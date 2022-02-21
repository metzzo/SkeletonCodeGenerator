/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Coolo
 */
import java.util.*;
import javax.swing.text.*;
import java.awt.*;

public class UMLHighlighter extends DefaultStyledDocument {

    private DefaultStyledDocument doc;
    private MutableAttributeSet normal;
    private MutableAttributeSet keyword;
    private MutableAttributeSet oper;
    private MutableAttributeSet identifier;
    private MutableAttributeSet parameter;
    private MutableAttributeSet classname;
    private MutableAttributeSet collection;
    private MutableAttributeSet underline;
    private MutableAttributeSet unknowndatatype;
    private Hashtable keywords;
    private static String operator[] = {":","<",">", "+", "-", "#", "(", ")", "[", "]", "\n", "\t",","};

    public UMLHighlighter() {

        doc = this;
        putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");

        normal = new SimpleAttributeSet();
        StyleConstants.setForeground(normal, Color.black);

        oper = new SimpleAttributeSet();
        Color opercol = new Color(128,128,128);
        StyleConstants.setForeground(oper, opercol);

        Color identifiercol = new Color(127,0,255);
        identifier = new SimpleAttributeSet();
        StyleConstants.setForeground(identifier, identifiercol);
        StyleConstants.setBold(identifier, true);

        Color paramcol = new Color(127,0,255);
        parameter = new SimpleAttributeSet();
        StyleConstants.setForeground(parameter, paramcol);

        underline=new SimpleAttributeSet();
        StyleConstants.setUnderline(underline, true);

        keyword = new SimpleAttributeSet();
        Color keywordcol = new Color(15,0,255);
        StyleConstants.setForeground(keyword, keywordcol);

        unknowndatatype = new SimpleAttributeSet();
        Color unknowncol = new Color(0,46,148);
        StyleConstants.setForeground(unknowndatatype, unknowncol);

        collection = new SimpleAttributeSet();
        Color collcol = new Color(127,0,255);
        StyleConstants.setForeground(collection, collcol);
        StyleConstants.setItalic(collection, true);

        classname = new SimpleAttributeSet();
        Color classnamecol = new Color(255,0,0);
        StyleConstants.setForeground(classname, classnamecol);
        StyleConstants.setBold(classname, true);

        Object dummyObject = new Object();

        keywords = new Hashtable();
        keywords.put("new", dummyObject);
        keywords.put("String", dummyObject);
        keywords.put("int", dummyObject);
        keywords.put("float", dummyObject);
        keywords.put("double", dummyObject);
        keywords.put("short", dummyObject);
        keywords.put("long", dummyObject);
        keywords.put("byte", dummyObject);
        keywords.put("void", dummyObject);
        keywords.put("char", dummyObject);
        keywords.put("*", dummyObject);
    }

    /*
     * Override to apply syntax highlighting after the document has been updated
     */
    @Override
    public void insertString(int offset, String str, AttributeSet a)
            throws BadLocationException {

        

        super.insertString(offset, str, normal);
        //Anfang suchen

        highlightline();

    }

    private String getTextsafe(int start, int count) {
        return getTextsafe(start, count, true);
    }

    private String getTextsafe(int start, int count, boolean withnewline) {
        try {
            String txt = "\n";
            if (!withnewline) {
                txt = "";
            }
            return doc.getText(start, count) + txt;
        } catch (BadLocationException ex) {
            System.out.println("" + ex);
        }
        return "";
    }

    private void highlightline() {
        //Nun den Identifier nach dem +/-/# highlighten
        boolean ishigh = false;
        int off = 0;
        //Alles zurücksetzen
        doc.setCharacterAttributes(0,doc.getLength(),normal,true);
        

        //nach new highlighten
        for (off = 0; off <= doc.getLength(); off++) {
            //Operator highlighten
            for (String op : operator) {
                if (getTextsafe(off, 1, false).equals(op)) {
                    doc.setCharacterAttributes(off,1,oper,true);

                    break;

                }
            }
            if (getTextsafe(off,1,false).equals(":")) {
                //Nun solange unterstreichen, bis es an ein leerzeichen kommt
                for (off=off+1;off<=doc.getLength();off++) {
                    doc.setCharacterAttributes(off, 1, unknowndatatype, true);
                    if (replaceOps(getTextsafe(off,1,false)).equals(" ")) {
                        break;
                    }
                }
            }
            //anderes
            String txt = getTextsafe(off, 1, false);
            if ((off+3)<=doc.getLength() && getTextsafe(off,3,false).equals("new")) {
                off+=3;
                for (int i=off;i<=doc.getLength();i++) {
                    if(!replaceOps(getTextsafe(i, 1, false)).equals(" ")) {
                        off=i;
                        break;
                    }
                }

                ishigh=true;
            }
            String firstchar="";
            if (!ishigh) {
                if (txt.equals("+") || txt.equals("-") || txt.equals("#")) {
                    //Nun Text danach highlighten, bis Operator kommt
                    ishigh = true;
                }
            } else {
                if (replaceOps(txt).equals(" ")) {
                    ishigh = false;
                } else {
                    doc.setCharacterAttributes(off, 1, identifier, true);
                }
            }
        }
        
        //Nun die tokens vor : highlighten
        
        for (off = 0; off <= doc.getLength(); off++) {
            String txt = getTextsafe(off, 1, false);
            if (txt.equals(":")) {
                //Nun Text davor highlighten
                for (int i = off-1; i >= 0; i--) {
                    if (replaceOps(getTextsafe(i, 1, false)).equals(" ")) {
                        break;
                    } else {
                        doc.setCharacterAttributes(i, 1, parameter, true);
                    }
                }
            }
        }

        //nun in token teilen
        String[] token = replaceOps(getTextsafe(0, doc.getLength() + 1)).split(" ");
        off = 0;
        //und nun die keywords färben
        for (String tok : token) {
            Object o = keywords.get(tok);
            if (o != null) {
                doc.setCharacterAttributes(off, tok.length(), keyword, true);
            }
            off += tok.length() + 1;
        }
        //Nun den Klassennamen extra highlighten
        int start=0;
        off=0;
        while (off<=doc.getLength() && replaceOps(getTextsafe(off,1,false)).equals(" ")) {
            off++;
            start++;
        }
        for (off = start; off <= doc.getLength(); off++) {
            if (replaceOps(getTextsafe(off,1,false)).equals(" ")) {
                break;
            } else {
                doc.setCharacterAttributes(off, 1, classname, true);
            }
        }
        //nun collections highlighten
        boolean incol=false;
        for (off = 0; off <= doc.getLength(); off++) {
            String txt = getTextsafe(off, 1, false);
            if (txt.equals("<")) {
                incol=true;
            }
            if (incol) {
                doc.setCharacterAttributes(off, 1, collection, true);
                if (txt.equals(">")) {
                    incol=false;
                }
            }
        }
        //statische sachen highlighten
        for (off=0;off<=doc.getLength();off++) {
            if (replaceOps(getTextsafe(off,1,false)).equals("_")) {
                //Nun solange unterstreichen, bis es an ein leerzeichen kommt
                for (;off<=doc.getLength();off++) {
                    doc.setCharacterAttributes(off, 1, underline, false);
                    if (replaceOps(getTextsafe(off,1,false)).equals(" ")) {
                        break;
                    }
                }
            }
        }
    }

    private String replaceOps(String str) {
        for (String op : operator) {
            str = str.replace(op, " ");
        }
        return str;
    }
    /*
     * Override to apply syntax highlighting after the document has been updated
     */

    @Override
    public void remove(int offset, int length) throws BadLocationException {
        super.remove(offset, length);
    }
}

