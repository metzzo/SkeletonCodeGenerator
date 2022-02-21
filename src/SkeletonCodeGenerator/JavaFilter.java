package SkeletonCodeGenerator;


/**
 * Filtert alle Java Dateien
 * @author Coolo
 */
import java.io.File;
import javax.swing.filechooser.*;



public class JavaFilter extends FileFilter {
    /**
      * Akzeptiert
     * @param f
     * @return
     */
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = JUtils.getExtension(f);
        if (extension != null) {
            if (extension.equals(JUtils.java)) {
                    return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Java file";
    }
}
class JUtils {

    public final static String java = "java";

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}