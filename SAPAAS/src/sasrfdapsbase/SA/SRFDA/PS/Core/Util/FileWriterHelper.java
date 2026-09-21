/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFramework.Utility.StringHelper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileWriterHelper {
    private static final Log log = LogFactory.getLog(FileWriterHelper.class);

    public static void write(String strFullPath, String strCode) throws Exception {
        String strContent;
        File dstFile = new File(strFullPath);
        if (dstFile.exists() && StringHelper.Compare((String)(strContent = FileWriterHelper.readFile(strFullPath)), (String)strCode, (boolean)false) == 0) {
            return;
        }
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(strFullPath)), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(strCode);
        writer.flush();
        writer.close();
    }

    public static boolean write3(File dstFile, String strCode) throws Exception {
        if (dstFile.exists()) {
            String strContent = FileWriterHelper.readFile(dstFile.getCanonicalPath());
            if (StringHelper.Compare((String)strContent, (String)strCode, (boolean)false) == 0) {
                return true;
            }
        } else {
            File parentFolder = dstFile.getParentFile();
            if (parentFolder != null && !parentFolder.exists()) {
                parentFolder.mkdirs();
            }
        }
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(dstFile), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(strCode);
        writer.flush();
        writer.close();
        return false;
    }

    public static boolean write2(String strFullPath, String strCode) throws Exception {
        String strContent;
        File dstFile = new File(strFullPath);
        if (dstFile.exists() && StringHelper.Compare((String)(strContent = FileWriterHelper.readFile(strFullPath)), (String)strCode, (boolean)false) == 0) {
            return true;
        }
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(strFullPath)), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(strCode);
        writer.flush();
        writer.close();
        return false;
    }

    public static String readFile(String strFilePath) throws Exception {
        StringBuffer sb;
        block15: {
            sb = new StringBuffer();
            InputStreamReader reader = null;
            try {
                try {
                    int nLength;
                    FileInputStream fis = new FileInputStream(strFilePath);
                    reader = new InputStreamReader((InputStream)fis, "UTF-8");
                    char[] buf = new char[4096];
                    while ((nLength = reader.read(buf)) != -1) {
                        sb.append(new String(buf, 0, nLength));
                    }
                }
                catch (Exception e) {
                    log.error((Object)e);
                    if (reader != null) {
                        try {
                            reader.close();
                        }
                        catch (IOException e1) {
                            log.error((Object)e1);
                        }
                    }
                    break block15;
                }
            }
            catch (Throwable throwable) {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException e1) {
                        log.error((Object)e1);
                    }
                }
                throw throwable;
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException e1) {
                    log.error((Object)e1);
                }
            }
        }
        return sb.toString();
    }
}

