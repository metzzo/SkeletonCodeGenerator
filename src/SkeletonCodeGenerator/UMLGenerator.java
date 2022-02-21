package SkeletonCodeGenerator;


import java.io.*;
import java.util.*;

/**
 * Erstellt aus einem Klassendiagramm fertigen Javacode
 * @author Robert Fischer
 * @version 2.0
 */
public class UMLGenerator {
    private String className="";
    private String errorCode = "";
    private ArrayList<String> tokens;
    private String input;
    private ListIterator<String> iterator;
    private String currentToken;
    private String code;
    private int ident = 0;
    private boolean anyerror;
    private ArrayList<UMLAttribute> attributes = new ArrayList<UMLAttribute>(); //Alle Attribute
    private boolean generateSetter = false, generateAttributes = false, generateMethods = false, generateConstructors = false, generateToString = false, generateComments=false, generateGenerics=false,generateHashcode=false, generateEquals=false;
    private String lastDatatype;
    private int lastArrayCount;
    private static String operator[] = {":","<",">", "+", "-", "#", "(", ")", "[", "]", "\n", "\t",","};
    private LinkedList<String> alldatatype=new LinkedList<String>();
    private LinkedList<UMLAttribute> allArrayAtt=new LinkedList<UMLAttribute>();
    private LinkedList<String> functions=new LinkedList<String>();
    private String author, version, desc;
    private LinkedList<UMLAttribute> prevatt=new LinkedList<UMLAttribute>();
    private LinkedList<UMLAttribute> allattributes=new LinkedList<UMLAttribute>();
    private String autoumlcode="";
    private String attributesUML="", constructorsUML="", getterSetterUML="", methodsUML="", declarationUML="";
    private HashMap<String, Boolean> isAutomaticIdent = new HashMap<String,Boolean>();

    /**
     * Konstruktor
     * @param input der UML Code
     */
    public UMLGenerator(String input) {
        if (input != null) {
            this.input = input;
        }
    }
    /**
     * Sollen Setter generiert werden?
     */
    public void genSetter() {
        generateSetter = true;
    }
    /**
     * Sollen Attribute generiert werden?
     */
    public void genAttributes() {
        generateAttributes = true;
    }
    /**
     * Sollen Methoden generiert werden
     */
    public void genMethods() {
        generateMethods = true;
    }
    /**
     * Soll eine ToString generiert werden?
     */
    public void genToString() {
        generateToString = true;
    }
    /**
     * Sollen Auto Konstruktoren generiert werden?
     */
    public void genConstructors() {
        generateConstructors = true;
    }
    /**
     * Soll JavaDoc generiert werden
     */
    public void genComments() {
        generateComments = true;
    }
    /**
     * Sollen Generics generiert werden
     */
    public void genGenerics() {
        generateGenerics = true;
    }
    /**
     * Soll Hashcode generiert werden?
     */
    public void genHashCode() {
        generateHashcode=true;
    }
    /**
     * Soll Euqlas generiert werden?
     */
    public void genEquals() {
        generateEquals=true;
    }
    /**
     * Konstruktor
     * @param filereader der FileReader Stream
     */
    public UMLGenerator(FileReader filereader) {
        if (filereader != null) {
            try {
                input = "";
                BufferedReader reader;
                reader = new BufferedReader(filereader);
                String output = reader.readLine();
                while (output != null) {
                    input += output + "\n";
                    output = reader.readLine();

                }
            } catch (IOException e) {
                System.err.println("Fehler! kann datei nicht lesen");
            }
        }
    }
    /**
     * Parst einen Datatype
     * @param withname Mit dem Namen oder ohne?
     * @return
     */
    private String parseDatatype(boolean withname) {
        return parseDatatype(withname, false);
    }
    /**
     * Parst Datatype
     * @param withname mit Name
     * @param connect Soll der datentyp registriert werden?
     * @return
     */
    private String parseDatatype(boolean withname, boolean connect) {
        String name="";
        if (getCurrent().equals("_") && withname) {
            getNext();
            name=getCurrent();
        }
        if (withname) {
            name = getCurrent();
            getNext();
        }
        match(":");
        String datatype = getCurrent();
        if (connect) {
            boolean find=false;
            for (String data:alldatatype) {
                if(data.equals(datatype)) {
                    find=true;
                }
            }
            if (!find) alldatatype.add(datatype);
        }
        //schauen dass der datentyp kein operator ist
        if (datatype.equals("")) error("Empty datatype");
        for (String op:operator) {
            if (datatype.equals(op)) {
                error("Invalid datatype: '"+datatype+"'");
                break;
            }
        }
        getNext();
        if (getCurrent().equals("<") && !anyerror && generateGenerics) {
            datatype+="<";
            currentToken=",";
            do {
                match(",");
                datatype+=getCurrent();
                getNext();
                if (getCurrent().equals(",")) datatype+=", ";
            } while (getCurrent().equals(","));
            
            match(">");
            datatype+=">";
        }
        lastArrayCount=0;
        while (getCurrent().equals("[") && !anyerror) {
            datatype += "[]";
            getNext();
            lastArrayCount++;
            match("*");
            match("]");
        }
        
        lastDatatype=datatype;
        if (withname)
            return datatype+" "+name;
        else {
            getPrevious();
            return datatype;
        }
    }
    /**
     * Kompiliert
     * @return
     */
    public boolean compile() {
        tokenize();
        return parse();
    }
    /**
     * Zerteilt den Code in Tokens (tokenize)
     */
    private void tokenize() {
        input += " ";
        tokens = new ArrayList<String>();
        tokens.add(" ");
        int lastfound = 0;
        for (int i = 0; i < input.length(); i++) {
            boolean split = false;
            boolean dontadd = false;
            switch (input.charAt(i)) {
                case ' ':
                case '(':
                case ')':
                case '+':
                case '-':
                case '\n':
                case '[':
                case ']':
                case ':':
                case '#':
                case ',':
                case '<':
                case '>':
                case '_':
                    split = true;
            }
            switch (input.charAt(i)) {
                case ' ':
                case '\n':
                    dontadd = true;
            }
            if (split && i >= 0) {
                if (lastfound != i) {
                    tokens.add(input.substring(lastfound, i));
                }
                if (!dontadd) {
                    tokens.add("" + input.charAt(i));
                }
                lastfound = i + 1;
            }
        }
        tokens.add("");
        tokens.add("");
    }
    /**
     * Parst die Datei mit einem Rekursiven Top Down Parser
     * @return
     */
    private boolean parse() {
        ident = 0;
        iterator = tokens.listIterator();
        code = "";
        anyerror = false;
        if (generateComments) {
            add("/**");
            add(newLine());
            add("  * "+desc.replace("\n","\n  * "));
            add(newLine());
            add("  * ");
            add(newLine());
            add("  * @author "+author);
            add(newLine());
            add("  * @version "+version);
            add(newLine());
            add("  */");
            add(newLine());
        }
        getNext();
        getNext();
        //getNext();
        if (isToken("+")) {
            code += str2java("+");
            getNext();
        } else if (isToken("-")) {
            code += str2java("-");
            getNext();
        } else if (isToken("#")) {
            //
            code += str2java("#");
            getNext();
        } else {
            getPrevious();
            String name = getCurrent();
            currentToken = name;
        }
        className=getCurrent();
        add("class " + getCurrent() + " ");
        identUp();
        add(" {" + newLine());
        declarationUML=code;
        while (iterator.hasNext() && !anyerror) {
            getNext();
            if (isToken("+") || isToken("-") || isToken("#")) {
                String old = code;
                String hiding=str2java(getCurrent());
                getNext();
                boolean isstatic;
                if (getCurrent().equals("_")) {
                    isstatic=true;
                    getNext();
                } else {
                    isstatic=false;
                }
                String name = getCurrent();
                getNext();
                if (name.equals("new")) {
                    code=this.constructorsUML;
                    name = getCurrent();
                    if (!name.equals(className)) error("Constructorname and classname does not equal.");
                    getNext();
                    if (anyerror) break;
                    String parameter = "";
                    match("(");
                    LinkedList<String> params=new LinkedList<String>();
                    while (!isToken(")") && !anyerror) {
                        params.add(getCurrent());
                        parameter += parseDatatype(true);
                        if (!isToken(")")) {
                            parameter += ", ";
                            match(",");
                        }
                    }
                    match(")");
                    if (anyerror) break;
                    if (getCurrent().equals(":")) {
                        error("Constructor has no datatype");
                    }
                    if (generateComments) { //Kommentare hinzufügen
                        add("/**");
                        add(newLine());
                        add("  * Your description of constructor here");
                        add(newLine());
                        add("  * ");
                        add(newLine());
                        for (String par:params) {
                            add("  * @param "+par+" Your description of the parameter here.");
                            add(newLine());
                        }
                        add("  */");
                        add(newLine());
                    }
                    createidentifier("new "+name+" "+parameter,true);
                    add(hiding);
                    add(name);
                    add("(" + parameter + ") {");
                    identUp();
                    add(newLine());
                    identDown();
                    add(newLine());
                    add("}");
                    add(newLine());
                    getPrevious();
                    this.constructorsUML=code;
                } else if (isToken("(") && generateMethods) {
                    code=this.methodsUML;
                    String parameter = "";
                    String datatype = "void";
                    match("(");
                    if (anyerror) break;
                    LinkedList<String> params=new LinkedList<String>();
                    
                    while (!isToken(")") && !anyerror) {
                        params.add(getCurrent());
                        
                        parameter += parseDatatype(true);
                        if (!isToken(")")) {
                            parameter += ", ";
                            match(",");
                        }
                    }
                    match(")");
                    if (anyerror) break;
                    if (isToken(":")) {
                        datatype=parseDatatype(false);
                    } else {
                        getPrevious();
                    }
                    createidentifier(datatype+" "+name,false);
                    if (generateComments) { //Kommentare hinzufügen
                        add("/**");
                        add(newLine());
                        add("  * Your description of method here");
                        add(newLine());
                        add("  * ");
                        add(newLine());
                        for (String par:params) {
                            add("  * @param "+par+" Your description of the parameter here.");
                            add(newLine());
                        }
                        if (!datatype.equals("void")) {
                            add ("  * @return Your description of the return value ");
                            add(newLine());
                        }
                        add("  */");
                        add(newLine());
                    }
                    add(hiding);
                    if (isstatic) datatype=" static "+datatype;
                    add(datatype + " ");
                    add(name);
                    add("(" + parameter + ") {");
                    identUp();
                    add(newLine()+"// method implementation");
                    String txt = " null";
                    if (datatype.equals("int") || datatype.equals("byte") || datatype.equals("long") || datatype.equals("short")) {
                        txt=" 0";
                    } else if (datatype.equals("float")) {
                        txt=" 0.0f";
                    } else if (datatype.equals("char")) {
                        txt=" ''";
                    } else if (datatype.equals("String")) {
                        txt=" \"\"";
                    } else if (datatype.equals("double")) {
                        txt=" 0.0";
                    } else if (datatype.equals("boolean")) {
                        txt=" false";
                    }
                    if (!datatype.equals("void")) add(newLine()+"return"+txt+";");
                    identDown();
                    add(newLine());
                    add("}");
                    add(newLine());
                    this.methodsUML=code;
                } else if (generateAttributes) {
                    code=this.attributesUML;
                    add(hiding);
                    getPrevious();
                    currentToken=name;
                    createidentifier(name,false);
                    String statictxt="";
                    String mythis="this";
                    if (isstatic) {
                        mythis=className;
                        statictxt="static ";
                    }
                    add(statictxt);
                    add(parseDatatype(true,true)+";");
                    int arrayc=lastArrayCount;
                    add(newLine());
                    this.attributesUML=code;
                    code=this.getterSetterUML;
                    if (lastDatatype.indexOf("void")>=0) error("There is no void datatype for attributes.");
                    boolean genset=true, genget=true;
                    for (UMLAttribute prev:prevatt) {
                        if (prev.getName().equals(name)) {
                            genget=prev.isGengetter();
                            genset=prev.isGensetter();
                        }
                    }
                    String isstaticstr="";
                    if (isstatic) isstaticstr="_";
                    if (generateSetter && name.length()>0) {
                        if (genset) {
                            //schauen ob doppelt
                            for (String f:functions) {
                                if (f.equals(lastDatatype+" set"+firstUpper(name))) {
                                    //schon da => weg
                                    genset=false;
                                }
                            }
                            if (genset) {
                                autoumlcode += "+"+isstaticstr+"set" + firstUpper(name) + "(" + name +":"+java2umldatatype(lastDatatype) +")\n";
                                createidentifier(lastDatatype+" set"+firstUpper(name),true);
                                //Setter
                                if (generateComments) {
                                    add("/**");
                                    add(newLine());
                                    add("  * Sets the attribute this."+name+".");
                                    add(newLine());
                                    add("  * @param "+name+" The value, which the attribute "+name+" gets.");
                                    add(newLine());
                                    add("  */");
                                    add(newLine());
                                }
                                add("public "+statictxt+" void set" + firstUpper(name) + "(" + lastDatatype + " " + name + ") {");
                                identUp();
                                add(newLine());
                                add(mythis+"." + name + " = " + name + ";");
                                identDown();
                                add(newLine());
                                add("}");
                                add(newLine());
                            }
                        }
                        if (genget) {
                            for (String f:functions) {
                                if (f.equals(lastDatatype+" get"+firstUpper(name))) {
                                    //schon da => weg
                                    genget=false;
                                }
                            }
                            if (genget) {
                                createidentifier(lastDatatype+" get"+firstUpper(name),true);
                                autoumlcode += "+"+isstaticstr+"get" + firstUpper(name) + "():"+java2umldatatype(lastDatatype)+"\n" ;
                                if (generateComments) {
                                    add("/**");
                                    add(newLine());
                                    add("  * Gets the attribute this."+name+".");
                                    add(newLine());
                                    add("  * @return Returns the value of the attribute "+name);
                                    add(newLine());
                                    add("  */");
                                    add(newLine());
                                }
                                //getter
                                add("public "+ statictxt + lastDatatype + " get" + firstUpper(name) + "() {");
                                identUp();
                                add(newLine());
                                add("return "+mythis+"." + name + ";");
                                identDown();
                                add(newLine());
                                add("}");
                                add(newLine());
                            }
                        }
                    }
                    this.getterSetterUML=code;
                    UMLAttribute att = new UMLAttribute(name, lastDatatype,arrayc, isstatic);
                    att.setGengetter(genget);
                    att.setGensetter(genset);
                    if (arrayc>=0) {
                        boolean isprim=false;
                        for (String data:UMLAttribute.primitiveDatatypes) {
                            if ((data+"[]").equals(lastDatatype) || data.equals(lastDatatype)) {
                                isprim=true;
                                break;
                            }
                        }
                        if (!lastDatatype.equals("String") && !isprim) {
                            this.allArrayAtt.add(att);
                        }
                    }
                    for (UMLAttribute att2 : attributes) {
                        if (att2.toString().equals(att.toString())) {
                            att = null;
                            break;
                        }
                    }
                    if (att != null) {
                        attributes.add(att);
                    }
                    allattributes.add(att);
                    getPrevious();
                    
                } else {
                    code = old;
                }
            }
        }
        if (generateConstructors) {
            code="";
            if (generateComments) {
                add(newLine());
                add("/**");
                add(newLine());
                add("  * Default constructor");
                add(newLine());
                add("  */");
            }
            add(newLine());
            add("public "+this.className+"() {");
            identUp();
            add(newLine());
            identDown();
            add(newLine());
            add("}");
            add(newLine());
            if (this.attributes.size()>0) {
                if (generateComments) {
                    add(newLine());
                    add("/**");
                    add(newLine());
                    add("  * Full constructor");
                    add(newLine());
                    for(UMLAttribute att:this.attributes) {
                        add("  * @param "+att.getName()+" One attribute of this class");
                        add(newLine());
                    }
                    add("  */");
                }
                add(newLine());
                add("public "+this.className+"(");
                boolean is=false;
                for(UMLAttribute att:this.attributes) {
                    if (att.isGensetter() && !att.isStatic()) {
                        if (is) add(", ");
                        add(att.getDatatype()+" "+att.getName());
                        is=true;
                    }
                }
                add(") {");
                identUp();
                add(newLine());
                for (UMLAttribute att : attributes) {
                    if (att.getName().length()>0 && att.isGensetter() && !att.isStatic()) {
                        add("set"+firstUpper(att.getName())+"( "+att.getName()+" );");
                        add(newLine());
                    }
                }
                identDown();
                add(newLine());
                add("}");
                add(newLine());
            }
            this.constructorsUML=code+this.constructorsUML;
        }
        code=this.declarationUML+this.attributesUML+this.constructorsUML+this.getterSetterUML+this.methodsUML;
        if (generateToString && attributes.size()>0) {
            //ToString generieren
            autoumlcode+= "+toString():String\n";
            if (generateComments) {
                add("/**");
                add(newLine());
                add("  * generates a string, which contains every attribute of the class. So you can debug easier.");
                add(newLine());
                add("  * @return Returns the generated String, you can print it out with System.out.println for example.");
                add(newLine());
                add("  */");
                add(newLine());
            }
            add("@Override");
            add(newLine());
            add("public String toString() {");
            identUp();
            add(newLine());
            add("String txt = \"\";");
            add(newLine());
            //Nun alle Attribute tostringen
            for (UMLAttribute att : attributes) {
                add(att.toString());
                add(newLine());
            }
            add("return txt;");
            identDown();
            add(newLine());
            add("}");
        }
        
        if (generateEquals && attributes.size()>0) {
            add(newLine());
            autoumlcode+="+equals(object:Object):boolean\n";
            if (generateComments) {
               add("/**");
                add(newLine());
                add("  * Is this Object equals with the given object?");
                add(newLine());
                add("  * @param object The given object");
                add(newLine());
                add("  * @return Returns true if they are, false if they aren't");
                add(newLine());
                add("  */");
                add(newLine());
            }
            add("@Override");
            add(newLine());
            add("public boolean equals(Object object) {");
            identUp();
            add(newLine());
            add("if (object!=null && (object instanceof "+className+")) {");
            identUp();
            add(newLine());
            add("if (object==this) return true;");
            add(newLine());
            //Nun alle Attribute durchgehen und abfragen
            for (UMLAttribute att : attributes) {
                add(att.genEquals());
                add(newLine());
            }
            add("return true;");
            identDown();
            add(newLine());
           
            add("} else return false;");
            identDown();
            add(newLine());
            add("}");
        }
        if (this.generateHashcode && attributes.size()>0) {
            add(newLine());
            autoumlcode+="+hashCode():int\n";
            if (generateComments) {
               add("/**");
                add(newLine());
                add("  * The hashcode of this object");
                add(newLine());
                add("  * @return Returns the hashcode");
                add(newLine());
                add("  */");
                add(newLine());
            }
            add("@Override");
            add(newLine());
            add("public int hashCode() {");
            identUp();
            add(newLine());
            add("return this.toString().hashCode();");
            identDown();
            add(newLine());
            add("}");
        }
        identDown();
        add(newLine());
        //realUml = this.getUML() + code;
        add("}");
        //realUml += "}";
        if (className.trim().equals("")) code="";
        return !anyerror;
    }
    /**
     * Der reale UML Code (inkl autouml).
     * @return
     */
    public String getRealUML() {
        return this.getUML() + autoumlcode;
    }
    /**
     * das aktuelle token
     * @return
     */
    private String getCurrent() {
        if (currentToken.equals("")) {
            currentToken = "";
        }
        return currentToken;
    }
    /**
     * matcht das erwartete token mit dem aktuellen?
     * @param tmp
     * @return
     */
    private boolean match(String tmp) {
        if (getCurrent().equals(tmp)) {
            getNext();

            return true;
        } else {
            error("Unexpected token, expecting '" + tmp + "'");
        }
        return false;
    }
    /**
     * Das nächste Token
     * @return
     */
    private String getNext() {
        if (iterator.hasNext()) {
            currentToken = iterator.next();
            return currentToken;
        } else {

            currentToken = "endofline";
            error("Unexpected End of File");
            currentToken = "voidtoken";
            return "voidtoken";
        }
    }
    /**
     * Wandelt java datentyp in umldatentyp um
     * @param data
     * @return
     */
    private String java2umldatatype(String data) {
        return data.replace("[]","[*]");
    }
    /**
     * Vorige Token
     * @return
     */
    private String getPrevious() {
        if (iterator.hasPrevious()) {
            currentToken = iterator.previous();
            return currentToken;
        } else {
            currentToken = "endofline";
            error("Unexpected Begin of File");
            currentToken = "voidtoken";
            return "voidtoken";
        }
    }
    /**
     * Fügt neuen Code hinzu
     * @param txt
     */
    private void add(String txt) {
        code += txt;
    }
    /**
     * Ein String wird zu java komvertiert (+=public, -=private,...)
     * @param text
     * @return
     */
    private String str2java(String text) {
        if (text.equals("+")) {
            return "public ";
        } else if (text.equals("-")) {
            return "private ";
        } else if (text.equals("#")) {
            return "protected ";
        } else {
            error("Unknown identifier " + text);
            return "";
        }
    }
    /**
     * Scope hinauf
     */
    private void identUp() {
        ident++;
    }
    /**
     * Scope hinunter
     */
    private void identDown() {
        ident--;
    }
    /**
     * Neue Zeile (inkl Einrückung)
     * @return
     */
    private String newLine() {
        String txt = "\n";
        for (int i = 0; i < ident; i++) {
            txt += "\t";
        }
        return txt;
    }
    /**
     * Ist der aktuelle token gleich?
     * @param text
     * @return
     */
    private boolean isToken(String text) {
        return getCurrent().equals(text);
    }
    /**
     * Fehlermeldung
     * @param text
     */
    private void error(String text) {
        anyerror = true;
        if (text.equals("\n")) {
            text = "NEWLINE";
        }
        errorCode += "Error: " + text + " at token " + currentToken + "\n";
        if (!currentToken.equals("endofline")) {
            getNext();
        }
    }
    /**
     * Gibt die Information aller Tokens aus
     * @return
     */
    public String toString() {
        String txt = "";
        for (String tok : tokens) {
            if (tok.length() == 0) {
                txt += "    ";
            }
            txt += tok;
        }
        txt += "\n\n";
        txt += getCode();
        return txt;
    }
    /**
     * Ersten Buchstaben groß schreiben
     * @param upper
     * @return
     */
    private String firstUpper(String upper) {
        String firstLetter, restLetters;
        firstLetter = upper.substring(0, 1);
        restLetters = upper.substring(1);
        return firstLetter.toUpperCase() + restLetters;
    }
    /**
     * Der generierte Code
     * @return
     */
    public String getCode() {
        return code;
    }
    /**
     * Der input uml code
     * @return
     */
    public String getUML() {
        return input;
    }
    /**
     * Setzt input
     * @param uml
     */
    public void setUML(String uml) {
        input = uml;
    }
    /**
     * Die Fehlermeldung
     * @return
     */
    public String getError() {
        return errorCode;
    }
    /**
     * Der Input
     * @return
     */
    public String getInput() {
        return input;
    }
    /**
     * Klassenname
     * @return
     */
    public String getClassName() {
        return className;
    }
    /**
     * Alle UMLAttributes die ein array haben
     * @return
     */
    public LinkedList<UMLAttribute> getDatatypes() {
        return this.allArrayAtt;
    }
    /**
     * Alle UMLAttributes
     * @return
     */
    public LinkedList<UMLAttribute> getAllAttributes() {
        return this.allattributes;
    }
    /**
     * Erzeugt einen Identifier, der nicht doppelt vorkommen darf
     * @param f
     * @param isAuto
     */
    private void createidentifier(String f, boolean isAuto) {
        //zuerst suchen obs bereits da
        boolean remObj = false;
        for (String f2: functions) {
            if (f2.equals(f)) {
                //schauen obs automatisch ist
                Boolean b = this.isAutomaticIdent.get(f);
                if (b!= null && b.booleanValue()) {
                    remObj = true;
                    break;
                } else {
                    error("Duplicate identifier name: '"+f+"'");
                    return;
                }
            }
        }
        if (remObj) {
            functions.remove(f);
        }
        functions.add(f);
        this.isAutomaticIdent.put(f, isAuto);
    }
    /**
     * Setzt die Daten im javadoc header
     * @param author
     * @param version
     * @param desc
     */
    public void setProperty(String author, String version, String desc) {
        this.author = author;
        this.version = version;
        this.desc = desc;
    }
    /**
     * Die Attribute die davor gesetzt wurden
     * @param list
     */
    public void setBeforeAttributes(LinkedList<UMLAttribute> list) {
        if (list!=null) prevatt=list;
    }
    /**
     * Der autogenerierte uml code
     * @return
     */
    public String getAutoUML() {
        return autoumlcode;
    }
}


