package processing.check;

import java.io.File;

public class IsValidFile {
    public boolean isValidFile(File file) {
        return file.isFile() && file.getName().toLowerCase().endsWith(".txt");
    }
}
