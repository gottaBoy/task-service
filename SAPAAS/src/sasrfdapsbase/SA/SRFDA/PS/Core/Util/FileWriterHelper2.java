/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.util.Hashtable;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileWriterHelper2 {
    private static final Log log = LogFactory.getLog(FileWriterHelper2.class);
    private Hashtable<String, byte[]> fileHashMap = new Hashtable();

    public void write(String strFullPath, String strCode) throws Exception {
        this.write2(strFullPath, strCode, true);
    }

    public boolean write2(String strFullPath, String strCode) throws Exception {
        return this.write2(strFullPath, strCode, true);
    }

    public boolean write2(String strFullPath, String strCode, boolean bRenameMode) throws Exception {
        byte[] contentmd5 = FileWriterHelper2.genMD5Ex(String.valueOf(strFullPath) + strCode);
        String strPath = this.genMD5Base64(strFullPath.toUpperCase());
        byte[] md52 = this.fileHashMap.get(strPath);
        if (md52 != null) {
            if (FileWriterHelper2.equalsBytes(md52, contentmd5)) {
                return true;
            }
        } else {
            File file = new File(strFullPath);
            if (file.exists() && StringHelper.compare((String)file.getCanonicalPath(), (String)strFullPath, (boolean)false) == 0) {
                String strContent2 = FileWriterHelper2.readFile(strFullPath);
                md52 = FileWriterHelper2.genMD5Ex(String.valueOf(strFullPath) + strContent2);
                if (FileWriterHelper2.equalsBytes(md52, contentmd5)) {
                    this.fileHashMap.put(strPath, contentmd5);
                    return true;
                }
            }
        }
        boolean bRename = false;
        File file = new File(strFullPath);
        if (file.exists() && StringHelper.compare((String)file.getCanonicalPath(), (String)strFullPath, (boolean)false) != 0) {
            file.delete();
            bRename = true;
        }
        OutputStreamWriter write = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(strFullPath)), "UTF-8");
        BufferedWriter writer = new BufferedWriter(write);
        writer.write(strCode);
        writer.flush();
        writer.close();
        this.fileHashMap.put(strPath, contentmd5);
        if (bRename && bRenameMode) {
            write = new OutputStreamWriter((OutputStream)new FileOutputStream(new File(String.valueOf(strFullPath) + ".rename")), "UTF-8");
            writer = new BufferedWriter(write);
            writer.write(strCode);
            writer.flush();
            writer.close();
        }
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

    public void reset() {
        this.fileHashMap.clear();
    }

    public static final byte[] genMD5Ex(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5hash = new byte[32];
            md.update(text.getBytes("utf-8"));
            md5hash = md.digest();
            return md5hash;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    public final String genMD5Base64(String text) {
        byte[] md5 = FileWriterHelper2.genMD5Ex(text);
        text = Base64Helper.encodeBytes((byte[])md5, (int)8);
        return text;
    }

    private static boolean equalsBytes(byte[] src, byte[] dest) {
        int i = 0;
        while (i < 16) {
            if (src[i] != dest[i]) {
                return false;
            }
            ++i;
        }
        return true;
    }
}

