/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Base;

import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.xml.sax.InputSource;

public class ConfigMgr {
    protected String strConfigPath = "";
    protected String strFolderSeperator = "\\";
    protected Hashtable fileList = new Hashtable();
    protected Hashtable modifydateList = new Hashtable();
    protected boolean bEncrypt = false;
    protected ArrayList arrConfigPaths = null;

    public ConfigMgr() {
        this.strFolderSeperator = File.separator;
    }

    public void setEncrypt(boolean value) {
        this.bEncrypt = value;
    }

    public void setFolderSeperator(String value) {
    }

    public void OnFileChanged(String strFilePath) {
        String strKey = strFilePath.toUpperCase();
        if (this.fileList.containsKey(strKey)) {
            this.fileList.remove(strKey);
        }
    }

    public void setConfigPath(String strValue) {
        this.strConfigPath = strValue;
    }

    public String GetRealPath(String strPath) {
        int nPos;
        if (StringHelper.StringLength(strPath) == 0) {
            return "";
        }
        ArrayList<String> arrList = new ArrayList<String>();
        String strRealPath = "";
        while ((nPos = strPath.indexOf(".")) != -1) {
            String strPartA = strPath.substring(0, nPos);
            arrList.add(strPartA);
            strPath = strPath.substring(nPos + 1);
        }
        arrList.add(strPath);
        int i = 0;
        while (i < arrList.size()) {
            if (strRealPath.length() != 0) {
                strRealPath = String.valueOf(strRealPath) + this.strFolderSeperator;
            }
            strRealPath = String.valueOf(strRealPath) + (String)arrList.get(i);
            ++i;
        }
        return strRealPath;
    }

    private static byte[] symmetricDecrypto(byte[] byteSource, byte[] keyData) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int mode = 2;
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            DESKeySpec keySpec = new DESKeySpec(keyData);
            SecretKey key = keyFactory.generateSecret(keySpec);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(mode, key);
            int blockSize = cipher.getBlockSize();
            int position = 0;
            int length = byteSource.length;
            boolean more = true;
            while (more) {
                if (position + blockSize <= length) {
                    baos.write(cipher.update(byteSource, position, blockSize));
                    position += blockSize;
                    continue;
                }
                more = false;
            }
            if (position < length) {
                baos.write(cipher.doFinal(byteSource, position, length - position));
            } else {
                baos.write(cipher.doFinal());
            }
            byte[] byArray = baos.toByteArray();
            return byArray;
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            baos.close();
        }
    }

    protected static InputSource getContent(String strFilePath, byte[] key) {
        String strXML = ConfigMgr.getRowXMLContent(strFilePath, key);
        if (StringHelper.Length(strXML) == 0) {
            return null;
        }
        int nXPos = strXML.indexOf("<");
        if (nXPos != 0) {
            strXML = strXML.substring(nXPos);
        }
        return new InputSource(new StringReader(strXML));
    }

    private static String getRowXMLContent(String strFilePath, byte[] key) {
        ByteBuffer inBuf = null;
        FileInputStream inFile = null;
        try {
            int nRet;
            inFile = new FileInputStream(strFilePath);
            inBuf = ByteBuffer.allocate((int)inFile.getChannel().size());
            ByteBuffer readBuf = ByteBuffer.allocate(8);
            FileChannel srcChannel = inFile.getChannel();
            while ((nRet = ConfigMgr.replenish(srcChannel, readBuf)) != -1) {
                inBuf.put(readBuf.array(), 0, nRet);
                readBuf.clear();
            }
            inFile.close();
        }
        catch (IOException ex) {
            ex.printStackTrace(System.err);
            return "";
        }
        if (inBuf == null) {
            return "";
        }
        Object outBuf = null;
        try {
            byte[] desBuffer = ConfigMgr.symmetricDecrypto(inBuf.array(), key);
            String strRet = new String(desBuffer, "UTF-8");
            return strRet;
        }
        catch (Exception ex) {
            ex.printStackTrace(System.err);
            return "";
        }
    }

    private static int replenish(FileChannel channel, ByteBuffer buf) throws IOException {
        long byteLeft = channel.size() - channel.position();
        if (byteLeft == 0L) {
            return -1;
        }
        buf.position(0);
        buf.limit(buf.position() + (byteLeft < 8L ? (int)byteLeft : 8));
        return channel.read(buf);
    }

    public void setConfigPaths(ArrayList arrConfigPaths) {
        this.arrConfigPaths = arrConfigPaths;
    }

    public String GetConfigFilePath(String strPartFilePath) {
        String strFilePath;
        File file;
        if (this.arrConfigPaths == null) {
            return String.valueOf(this.strConfigPath) + strPartFilePath;
        }
        if (StringHelper.Length(this.strConfigPath) != 0 && (file = new File(strFilePath = String.valueOf(this.strConfigPath) + strPartFilePath)).exists()) {
            return strFilePath;
        }
        int nCount = this.arrConfigPaths.size();
        int i = 0;
        while (i < nCount) {
            String strFilePath2 = String.valueOf(this.arrConfigPaths.get(i).toString()) + strPartFilePath;
            File file2 = new File(strFilePath2);
            if (file2.exists()) {
                return strFilePath2;
            }
            ++i;
        }
        return "";
    }

    protected String GetConfigRootFolder() {
        return "";
    }

    public String GetRealConfigFilePath(String strToolbarId) {
        return this.GetConfigFilePath(String.valueOf(this.GetConfigRootFolder()) + this.strFolderSeperator + this.GetRealPath(strToolbarId) + this.GetFileExt());
    }

    protected String GetFileExt() {
        return ".xml";
    }
}

