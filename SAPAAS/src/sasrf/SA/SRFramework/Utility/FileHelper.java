/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Utility;

import java.io.File;
import java.io.IOException;

public class FileHelper {
    public static final void RemoveFolder(String strFolderPath, boolean bContentOnly) throws IOException {
        File f = new File(strFolderPath);
        if (f.exists() && f.isDirectory()) {
            if (f.listFiles().length == 0) {
                if (!bContentOnly) {
                    f.delete();
                }
            } else {
                File[] delFile = f.listFiles();
                int i = f.listFiles().length;
                int j = 0;
                while (j < i) {
                    if (delFile[j].isDirectory()) {
                        FileHelper.RemoveFolder(delFile[j].getAbsolutePath(), false);
                    }
                    delFile[j].delete();
                    ++j;
                }
            }
        }
    }
}

