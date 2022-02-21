/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Coolo
 */
public class UMLAttribute {
    public static String primitiveDatatypes[] = {"int","float","double","short","byte","long","char","boolean"};
    private String name="unknown", datatype="unknown";
    private boolean isstatic=false;
    private int dim=0;
    private boolean gensetter, gengetter;
    private boolean ex;
    public int getDim() {
        return dim;
    }
    public UMLAttribute(String name, String datatype, int dim, boolean isstatic) {
        this.name=name;
        this.datatype=datatype;
        this.dim=dim;
        this.gensetter=true;
        this.gengetter=true;
        this.isstatic=isstatic;
    }
    public String getName() {
        return name;
    }
    public String getDatatype() {
        return datatype;
    }
    @Override
    public String toString() {
        for (String data:primitiveDatatypes) {
           if (data.equals(datatype)) {
                return "txt += \""+name+": \"+ "+name+" + \" \";"; // txt += "dername: "+name
           }
        }
        return "txt += \""+name+": \"+ "+name+".toString()+\" \";";
    }
    public String getPureDatatype() {
        for (int i=0;i<getDatatype().length();i++) {
            if (getDatatype().charAt(i)=='<' || getDatatype().charAt(i)=='[') return getDatatype().substring(0,i);
        }
        return getDatatype();
    }
    public String genEquals() {
        if (isstatic) return "";
        for (String data:primitiveDatatypes) {
           if (data.equals(datatype)) {
                return "if (this."+name+" != object."+name+") return false;";
           }
        }
        return "if (!this."+name+".equals(object."+name+")) return false;";
    }
    public boolean isGensetter() {
        return gensetter;
    }
    public boolean isGengetter() {
        return gengetter;
    }
    public void setGensetter(boolean gensetter) {
        this.gensetter = gensetter;
    }
    public void setGengetter(boolean gengetter) {
        this.gengetter = gengetter;
    }
    public void setExist(boolean ex) {
        this.ex=ex;
    }
    public boolean isExist() {
        return ex;
    }
    public boolean isStatic() {
        return this.isstatic;
    }
}
