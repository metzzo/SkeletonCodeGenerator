package SkeletonCodeGenerator;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

/**
 * Diese Klasse zeigt das Assoziations Diagramm an. Hierbei werden in einer übersichtlichen Darstellungen alle Attribute
 * falls nicht Primitiv als Assoziation dargestellt.
 * @author Coolo
 */
public class AssoInterface {

    public JFrame F;
    public GUIInterface inter;
    public AssoCanvas can;
    public static AssoInterface current;
    /**
     * Öffnet Dieses Fenter
     * @param inter
     */
    public void open(GUIInterface inter) {
        current = this;

        this.inter = inter;
        F = new JFrame();
        F.setLayout(new BorderLayout());
        F.setTitle("Associatation Viewer");
        F.setSize(300, 300);
        F.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        can = new AssoCanvas(this);
        can.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PointerInfo info = MouseInfo.getPointerInfo();
                Point location = evt.getPoint();
                FontMetrics metrics = can.getMetrics();
                //schauen ob kolli
                int mx, my;

                mx = location.x;
                my = location.y;
                //System.out.println("CLICK "+mx+", "+my);
                for (Assos ass : can.getAsso()) {
                    if (AssoCanvas.rectsoverlap(mx, my, 1, 1,ass.getX() - metrics.stringWidth("Class: " + ass.getAtt().getDatatype()) / 2 + can.getWidth() / 2 - 4, ass.getY() - metrics.getHeight() + can.getHeight() / 2, metrics.stringWidth("Class: " + ass.getAtt().getDatatype())+8, metrics.getHeight()+8)) {
                        //System.out.println("Clicked: "+current.inter.getDict() + "/" + ass.getAtt().getPureDatatype()+".uml");
                        UMLViewer v = new UMLViewer();
                        String s = ""; //schauen wo es ist
                        FileReader filereader;

                        try {
                            filereader = new FileReader(current.inter.getDict() + "/" + ass.getAtt().getDatatype()+".uml");
                            BufferedReader reader;
                            reader = new BufferedReader(filereader);
                            String output = reader.readLine();
                            while (output != null) {
                                s += output + "\n";
                                output = reader.readLine();

                            }
                            filereader.close();
                            v.setText(s);
                            v.setVisible(true);
                            v.toFront();
                        } catch (FileNotFoundException fr) {
                            //System.err.println("Error! file not found");
                        } catch (IOException fr) {
                            //System.err.println("Error!");
                        }
                    }
                }
            }
        });
        F.add(can);
        F.setVisible(true);
        JButton but = new JButton();
        but.setText("Close");
        but.setSize(128, 64);
        but.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                F.setVisible(false);
            }
        });
        F.add("South", but);
    }
}
/**
 * Eine Assoziation
 * @author Coolo
 */
class Assos {

    private int x, y;
    private int w, h;
    private UMLAttribute name;
    /**
     * Konstruktor initialisiert
     * @param asso Worin ist das drinnen
     * @param g das Graphics Objekt
     * @param name das zugehörige UML Attribut
     */
    public Assos(AssoCanvas asso, Graphics g, UMLAttribute name) {
        this.name = name;
        FontMetrics metrics = g.getFontMetrics();
        //X,Y Achse suchen
        w = metrics.stringWidth(getName() + name.getDatatype());
        h = metrics.getHeight();
        for (double dist = 150; true; dist += 20) {
            for (double angle = 0; angle < Math.PI * 2.0; angle += Math.PI / 10.0) {
                this.x = (int) (Math.cos((double) angle) * dist);
                this.y = (int) (Math.sin((double) angle) * dist);

                if (asso.colli(this)) {
                    return;
                }
            }
        }
    }
    /**
     * Gibt das zugehörige UMLAttribute zurück
     * @return
     */
    public UMLAttribute getAtt() {
        return name;
    }
    /**
     * Der angezeigte Text, des Assos
     * @return
     */
    public String getName() {
        if (name.getDim() > 0) {
            return "* Role: " + name.getName();
        } else {
            return "1 Role: " + name.getName();
        }
    }
    /**
     * zeichnet es
     * @param can Das Canvas, woring gezeichnet wird
     * @param g das Graphics Objekt
     */
    public void draw(AssoCanvas can, Graphics g) {
        Dimension d = can.getSize();
        int wi = d.width, he = d.height;
        g.setColor(Color.WHITE);
        can.drawRectString(g, getName(), wi / 2 + x, he / 2 + y + 20);
        g.setColor(Color.GREEN);
        can.drawRectString(g, "Class: " + name.getDatatype(), wi / 2 + x, he / 2 + y);
    }
    /**
     * Zeichnet die Linie zwischen sich selber und dem klassennamen
     * @param can das Canvas
     * @param g das Graphics Objekt
     */
    public void line(AssoCanvas can, Graphics g) {
        Dimension d = can.getSize();
        int wi = d.width, he = d.height;
        g.setColor(Color.CYAN);
        g.drawLine(wi / 2 + x, he / 2 + y, wi / 2, he / 2);

    }
    /**
     * X Koordinate
     * @return
     */
    public int getX() {
        return x;
    }
    /**
     * Y Koordinate
     * @return
     */
    public int getY() {
        return y;
    }
    /**
     * Breite
     * @return
     */
    public int getW() {
        return w;
    }
    /**
     * Höhe
     * @return
     */
    public int getH() {
        return h;
    }
}
/**
 * Das Canvas in dem alle Assos sind
 * @author Coolo
 */
class AssoCanvas extends Canvas {

    private ArrayList<Assos> ass = new ArrayList<Assos>();
    private UMLGenerator uml;
    private AssoInterface asso;
    private FontMetrics metrics;
    /**
     * Die Schriftart
     * @return
     */
    public FontMetrics getMetrics() {
        return metrics;
    }
    /**
     * Gibt die ArrayList zurück, welche alle Assos beinhaltet
     * @return
     */
    public ArrayList<Assos> getAsso() {
        return ass;
    }
    /**
     * Das Canvas
     * @param asso
     */
    public AssoCanvas(AssoInterface asso) {
        this.asso = asso;
    }
    /**
     * Zeichen Methode
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        metrics = g.getFontMetrics();
        if (uml != asso.inter.getUMLGen()) {
            uml = asso.inter.getUMLGen();
            ass = new ArrayList<Assos>();
            for (UMLAttribute data : uml.getDatatypes()) {
                ass.add(new Assos(this, g, data));
            }
        }
        Dimension d = getSize();
        int w = d.width, h = d.height;
        for (Assos a : ass) {
            a.line(this, g);
        }
        for (Assos a : ass) {
            a.draw(this, g);
        }
        //nun die Klasse in der Mitte zeichnen
        g.setColor(Color.orange);
        drawRectString(g, "1 " + uml.getClassName(), w / 2, h / 2);
    }
    /**
     * Kollision mit einem anderen Asso?
     * @param a2
     * @return
     */
    public boolean colli(Assos a2) {
        for (Assos a : ass) {
            if (a != a2 && rectsoverlap(a.getX() - metrics.stringWidth(a.getName()) / 2 - 4, a.getY() - metrics.getHeight(), a.getW(), a.getH() * 4, a2.getX() - metrics.stringWidth(a2.getName()) / 2, a2.getY() - metrics.getHeight(), a2.getW(), a2.getH() * 3)) {
                return false;
            }
        }

        return true;
    }
    /**
     * Zeichnet einen Text mit RoundBox
     * @param g 
     * @param txt
     * @param x
     * @param y
     */
    public void drawRectString(Graphics g, String txt, int x, int y) {
        metrics = g.getFontMetrics();
        g.fillRoundRect(x - metrics.stringWidth(txt) / 2 - 4, y - metrics.getHeight(), metrics.stringWidth(txt) + 8, metrics.getHeight() + metrics.getAscent() / 2, 10, 10);
        g.setColor(Color.BLACK);
        g.drawString(txt, x - metrics.stringWidth(txt) / 2, y);
    }
    /**
     * Distanz
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    private int distance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt((double) ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
    }
    /**
     * Rechteckskollision
     * @param x1
     * @param y1
     * @param breite1
     * @param hoehe1
     * @param x2
     * @param y2
     * @param breite2
     * @param hoehe2
     * @return
     */
    public static boolean rectsoverlap(int x1, int y1, int breite1, int hoehe1, int x2, int y2, int breite2, int hoehe2) {
        return x1 <= (x2 + breite2) && y1 <= y2 + hoehe2 && (x1 + breite1) >= x2 && (y1 + hoehe1) >= y2;
    }
}
