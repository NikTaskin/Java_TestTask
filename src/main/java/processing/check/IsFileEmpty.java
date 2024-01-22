package processing.check;

import java.io.File;

public class IsFileEmpty {
    public boolean isFileEmpty(File file) {
        return file.isFile() && file.length() == 0;
    }
}
