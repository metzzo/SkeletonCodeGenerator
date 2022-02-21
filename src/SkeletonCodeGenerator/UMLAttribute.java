package SkeletonCodeGenerator;


/**
 * Ein Attribut in der Klasse
 * @author Coolo
 */
public class UMLAttribute {
    public static String primitiveDatatypes[] = {"int","float","double","short","byte","long","char","boolean"};
    private String name="unknown", datatype="unknown";
    private boolean isstatic=false;
    private int dim=0;
    private boolean gensetter, gengetter;
    private boolean ex;
    /**
     * Die DImensionen
     * @return
     */
    public int getDim() {
        return dim;
    }
    /**
     * Konsttuktor
     * @param name Name
     * @param datatype Datentyp
     * @param dim Dimensionen
     * @param isstatic Ist es Statisch?
     */
    public UMLAttribute(String name, String datatype, int dim, boolean isstatic) {
        this.name=name;
        this.datatype=datatype;
        this.dim=dim;
        this.gensetter=true;
        this.gengetter=true;
        this.isstatic=isstatic;
    }
    /**
     * Fibt den Namen zurück
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * Der Datentyp
     * @return
     */
    public String getDatatype() {
        return datatype;
    }
    /**
     * toString() im autogenerierten Java Code
     * @return
     */
    @Override
    public String toString() {
        for (String data:primitiveDatatypes) {
           if (data.equals(datatype)) {
                return "txt += \""+name+": \"+ "+name+" + \" \";"; // txt += "dername: "+name
           }
        }
        return "txt += \""+name+": \"+ "+name+".toString()+\" \";";
    }
    /**
     * Der Pure Datentyp (ohne array und collection)
     * @return
     */
    public String getPureDatatype() {
        for (int i=0;i<getDatatype().length();i++) {
            if (getDatatype().charAt(i)=='<' || getDatatype().charAt(i)=='[') return getDatatype().substring(0,i);
        }
        return getDatatype();
    }
    /**
     * Generiert die equals in auto javacode
     * @return
     */
    public String genEquals() {
        if (isstatic) return "";
        for (String data:primitiveDatatypes) {
           if (data.equals(datatype)) {
                return "if (this."+name+" != object."+name+") return false;";
           }
        }
        return "if (!this."+name+".equals(object."+name+")) return false;";
    }
    /**
     * hat es einen setter?
     * @return
     */
    public boolean isGensetter() {
        return gensetter;
    }
    /**
     * hat es einen getter?
     * @return
     */
    public boolean isGengetter() {
        return gengetter;
    }
    /**
     * setze zum setter generieren
     * @param gensetter
     */
    public void setGensetter(boolean gensetter) {
        this.gensetter = gensetter;
    }
    /**
     * generiere einen getter
     * @param gengetter
     */
    public void setGengetter(boolean gengetter) {
        this.gengetter = gengetter;
    }
    /**
     * Setzt zum existieren
     * @param ex
     */
    public void setExist(boolean ex) {
        this.ex=ex;
    }
    /**
     * Existiert beiereits?
     * @return
     */
    public boolean isExist() {
        return ex;
    }
    /**
     * Ist es statisch?
     * @return
     */
    public boolean isStatic() {
        return this.isstatic;
    }
}
