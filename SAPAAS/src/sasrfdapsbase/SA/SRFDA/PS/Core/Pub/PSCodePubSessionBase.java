/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Pub;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class PSCodePubSessionBase {
    private static final Log log = LogFactory.getLog(PSCodePubSessionBase.class);
    protected Map<String, HashMap<String, Boolean>> codeTypeMap = new ConcurrentHashMap<String, HashMap<String, Boolean>>();
    protected Map<String, HashMap<String, Integer>> syncCodeMap = new ConcurrentHashMap<String, HashMap<String, Integer>>();
    protected Map<String, HashMap<String, String>> lastCodeMap = new ConcurrentHashMap<String, HashMap<String, String>>();
    private Boolean bEndPub = false;
    private Object objEndPubLock = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerPubFolder(String strCodeFolder) throws Exception {
        strCodeFolder = strCodeFolder.toUpperCase();
        HashMap<String, Boolean> map = null;
        Map<String, HashMap<String, Boolean>> map2 = this.codeTypeMap;
        synchronized (map2) {
            map = this.codeTypeMap.get(strCodeFolder);
            if (map == null) {
                map = new HashMap();
                this.codeTypeMap.put(strCodeFolder, map);
                this.buildLastFileList(strCodeFolder);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerPubCode(String strCodeFolder, String strCodeFilePath, boolean bSame) throws Exception {
        strCodeFolder = strCodeFolder.toUpperCase();
        strCodeFilePath = StringHelper.compare((String)File.separator, (String)"/", (boolean)true) == 0 ? strCodeFilePath.replace("\\", File.separator) : strCodeFilePath.replace("/", File.separator);
        String strCodeFilePath2 = strCodeFilePath.toUpperCase();
        if (strCodeFilePath2.indexOf(this.getPubRootFolderUpper()) != 0) {
            throw new Exception(StringHelper.format((String)"\u53d1\u5e03\u6587\u4ef6[%1$s]\u4e0d\u5728\u6839\u76ee\u5f55[%2$s]\u4e2d", (Object)strCodeFilePath, (Object)this.getPubRootFolder()));
        }
        strCodeFilePath = strCodeFilePath.substring(this.getPubRootFolder().length());
        strCodeFilePath = strCodeFilePath.substring(1);
        strCodeFilePath = strCodeFilePath.substring(strCodeFolder.length());
        HashMap<String, Boolean> map = null;
        Map<String, HashMap<String, Boolean>> map2 = this.codeTypeMap;
        synchronized (map2) {
            map = this.codeTypeMap.get(strCodeFolder);
            if (map == null) {
                map = new HashMap();
                this.codeTypeMap.put(strCodeFolder, map);
                this.buildLastFileList(strCodeFolder);
            }
        }
        map.put(strCodeFilePath, bSame);
    }

    protected abstract String getPubRootFolder();

    protected abstract String getPubRootFolderUpper();

    protected void buildLastFileList(String strCodeFolder) throws Exception {
        HashMap<String, String> lastFileMap = new HashMap<String, String>();
        String strFileList = StringHelper.format((String)"%1$s%2$s%3$s.list", (Object)this.getPubRootFolder(), (Object)File.separator, (Object)strCodeFolder);
        File listFile = new File(strFileList);
        if (listFile.exists()) {
            String strContent = PSCodePubSessionBase.readFile(listFile.getPath());
            Properties properties = PropertiesHelper.load((String)strContent);
            if (properties != null) {
                for (Object objKey : properties.keySet()) {
                    if (StringHelper.isNullOrEmpty((Object)objKey)) continue;
                    String strFilePath = (String)objKey;
                    lastFileMap.put(strFilePath.replace("/", File.separator), "");
                }
            }
        } else {
            String strFolder = StringHelper.format((String)"%1$s%2$s%3$s", (Object)this.getPubRootFolder(), (Object)File.separator, (Object)strCodeFolder);
            listFile = new File(strFolder);
            if (listFile.exists()) {
                this.buildFileList(listFile, lastFileMap, strFolder);
            }
        }
        this.lastCodeMap.put(strCodeFolder, lastFileMap);
    }

    protected void buildFileList(File file, Map<String, String> map, String strRootFolder) throws Exception {
        if (file.isFile()) {
            map.put(file.getPath().substring(strRootFolder.length()), "");
            return;
        }
        File[] children = file.listFiles();
        if (children != null) {
            File[] fileArray = children;
            int n = children.length;
            int n2 = 0;
            while (n2 < n) {
                File child = fileArray[n2];
                this.buildFileList(child, map, strRootFolder);
                ++n2;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void endPubCode() throws Exception {
        Object object = this.objEndPubLock;
        synchronized (object) {
            if (this.bEndPub.booleanValue()) {
                return;
            }
            for (String strCodeType : this.codeTypeMap.keySet()) {
                HashMap<String, Boolean> pubCodeLMap = this.codeTypeMap.get(strCodeType);
                HashMap<String, String> lastCodeMap = this.lastCodeMap.get(strCodeType);
                HashMap<String, Integer> syncCodeActionMap = new HashMap<String, Integer>();
                HashMap<String, String> lastCodeMap2 = new HashMap<String, String>();
                lastCodeMap2.putAll(lastCodeMap);
                log.debug((Object)String.format("\u5f00\u59cb\u6267\u884c[syncCode][%1$s]", strCodeType));
                this.syncCode(strCodeType, pubCodeLMap, lastCodeMap2, syncCodeActionMap);
                log.debug((Object)String.format("\u7ed3\u675f\u6267\u884c[syncCode][%1$s]", strCodeType));
                this.syncCodeMap.put(strCodeType, syncCodeActionMap);
                log.debug((Object)String.format("\u5f00\u59cb\u6267\u884c[writeListFile][%1$s]", strCodeType));
                this.writeListFile(strCodeType, pubCodeLMap);
                log.debug((Object)String.format("\u7ed3\u675f\u6267\u884c[writeListFile][%1$s]", strCodeType));
            }
            this.bEndPub = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resetPubCode() throws Exception {
        Object object = this.objEndPubLock;
        synchronized (object) {
            for (String strCodeType : this.codeTypeMap.keySet()) {
                HashMap<String, Integer> syncCodeActionMap;
                HashMap<String, String> lastCodeMap;
                HashMap<String, Boolean> pubCodeLMap = this.codeTypeMap.get(strCodeType);
                if (pubCodeLMap != null) {
                    pubCodeLMap.clear();
                }
                if ((lastCodeMap = this.lastCodeMap.get(strCodeType)) != null) {
                    lastCodeMap.clear();
                }
                if ((syncCodeActionMap = this.syncCodeMap.get(strCodeType)) == null) continue;
                syncCodeActionMap.clear();
            }
            this.bEndPub = false;
        }
    }

    protected void syncCode(String strCodeType, HashMap<String, Boolean> pubCodeMap, HashMap<String, String> lastCodeMap, HashMap<String, Integer> syncCodeMap) throws Exception {
        for (String strPubCode : pubCodeMap.keySet()) {
            Boolean bSame = pubCodeMap.get(strPubCode);
            if (lastCodeMap.containsKey(strPubCode)) {
                if (!bSame.booleanValue()) {
                    syncCodeMap.put(strPubCode, 1);
                }
                lastCodeMap.remove(strPubCode);
                continue;
            }
            syncCodeMap.put(strPubCode, 1);
        }
    }

    protected void writeListFile(String strCodeType, HashMap<String, Boolean> pubCodeMap) throws Exception {
        String strFileList = StringHelper.format((String)"%1$s%2$s%3$s.list", (Object)this.getPubRootFolder(), (Object)File.separator, (Object)strCodeType);
        File listFile = new File(strFileList);
        if (listFile.exists()) {
            listFile.delete();
        }
        try {
            FileWriter fileWriter = new FileWriter(strFileList, true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWriter);
            for (String strCodeName : pubCodeMap.keySet()) {
                bufferWritter.write(StringHelper.format((String)"%1$s=%2$s\r\n", (Object)strCodeName.replace("\\", "/"), (Object)""));
            }
            bufferWritter.flush();
            bufferWritter.close();
        }
        catch (IOException e) {
            log.error((Object)e);
        }
    }

    public int syncPubCode(String strCodeType, String strDstFolder) throws Exception {
        return this.syncPubCode(strCodeType, strDstFolder, 3);
    }

    public int syncPubCode(String strFolders, String strDstFolder, int nActionMode) throws Exception {
        File dstFile;
        String strDstFileName;
        String strCodeType2;
        int nAction;
        File pubCodeFolder;
        String strPubCodeFolder;
        String strSubFolder;
        String strCodeType;
        this.endPubCode();
        long nStartTime = System.currentTimeMillis();
        String[] folders = strFolders.split("[;]");
        String[] codeTypes = new String[folders.length];
        String[] codeSubFolders = new String[folders.length];
        int i = 0;
        while (i < folders.length) {
            String strFolder = folders[i];
            String[] codetypes = strFolder.split("[/]");
            strCodeType = codetypes[0];
            strSubFolder = null;
            if (codetypes.length > 1) {
                strSubFolder = "";
                int j = 1;
                while (j < codetypes.length) {
                    if (StringHelper.isNullOrEmpty((String)codetypes[j])) break;
                    strSubFolder = String.valueOf(strSubFolder) + File.separator + codetypes[j];
                    ++j;
                }
            }
            codeTypes[i] = strCodeType;
            codeSubFolders[i] = strSubFolder;
            ++i;
        }
        HashMap<String, String> dstFileMap = new HashMap<String, String>();
        int i2 = 0;
        while (i2 < folders.length) {
            String strCodeType3 = codeTypes[i2];
            String strSubFolder2 = codeSubFolders[i2];
            HashMap<String, Boolean> pubCodeMap = this.codeTypeMap.get(strCodeType3);
            if (pubCodeMap == null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u4ee3\u7801\u76ee\u5f55[%1$s]", (Object)strCodeType3));
            }
            for (String strPubCode : pubCodeMap.keySet()) {
                if (!StringHelper.isNullOrEmpty((String)strSubFolder2)) {
                    if (strPubCode.indexOf(strSubFolder2) != 0) continue;
                    strPubCode = strPubCode.substring(strSubFolder2.length());
                }
                String strDstFileName2 = String.valueOf(strDstFolder) + strPubCode;
                dstFileMap.put(strDstFileName2, strCodeType3);
            }
            ++i2;
        }
        int nCount = 0;
        if ((nActionMode & 2) > 0) {
            int i3 = codeTypes.length - 1;
            while (i3 >= 0) {
                strCodeType = codeTypes[i3];
                strSubFolder = codeSubFolders[i3];
                HashMap<String, Integer> syncCodeActionMap = this.syncCodeMap.get(strCodeType);
                if (syncCodeActionMap == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u4ee3\u7801\u76ee\u5f55[%1$s]", (Object)strCodeType));
                }
                strPubCodeFolder = String.valueOf(this.getPubRootFolder()) + File.separator + strCodeType;
                pubCodeFolder = new File(strPubCodeFolder);
                strPubCodeFolder = pubCodeFolder.getPath();
                for (String strPubCode : syncCodeActionMap.keySet()) {
                    File dstFile2;
                    if (!StringHelper.isNullOrEmpty((String)strSubFolder) && strPubCode.indexOf(strSubFolder) != 0 || (nAction = syncCodeActionMap.get(strPubCode).intValue()) != 2) continue;
                    if (!StringHelper.isNullOrEmpty((String)strSubFolder)) {
                        strPubCode = strPubCode.substring(strSubFolder.length());
                    }
                    if (StringHelper.isNullOrEmpty((String)(strCodeType2 = (String)dstFileMap.get(strDstFileName = String.valueOf(strDstFolder) + strPubCode))) || StringHelper.compare((String)strCodeType2, (String)strCodeType, (boolean)false) == 0) {
                        dstFile = new File(strDstFileName);
                        if (!dstFile.delete()) {
                            log.warn((Object)StringHelper.format((String)"\u5220\u9664\u6587\u4ef6\u5931\u8d25[%1$s]", (Object)dstFile.getPath()));
                            continue;
                        }
                        ++nCount;
                        continue;
                    }
                    String strSubFolder2 = null;
                    int j = codeTypes.length - 1;
                    while (j >= 0) {
                        if (StringHelper.compare((String)codeTypes[j], (String)strCodeType2, (boolean)false) == 0) {
                            strSubFolder2 = codeSubFolders[j];
                            break;
                        }
                        --j;
                    }
                    String strPubFileName2 = "";
                    if (!StringHelper.isNullOrEmpty(strSubFolder2)) {
                        strPubFileName2 = String.valueOf(strPubFileName2) + strSubFolder2;
                    }
                    strPubFileName2 = String.valueOf(strPubFileName2) + strPubCode;
                    File pubCodeFile2 = new File(String.valueOf(this.getPubRootFolder()) + File.separator + strCodeType2 + strPubFileName2);
                    if (!PSCodePubSessionBase.copyFile(pubCodeFile2, dstFile2 = new File(strDstFileName))) {
                        log.error((Object)StringHelper.format((String)"\u62f7\u8d1d\u6587\u4ef6\u5931\u8d25[%1$s]==>[%2$s]", (Object)pubCodeFile2.getPath(), (Object)dstFile2.getPath()));
                        throw new Exception(StringHelper.format((String)"\u62f7\u8d1d\u6587\u4ef6\u5931\u8d25[%1$s]", (Object)strPubCode));
                    }
                    ++nCount;
                    log.debug((Object)StringHelper.format((String)"\u6062\u590d\u53d1\u5e03\u6e90[%2$s]\u6587\u4ef6[%1$s]", (Object)strDstFileName, (Object)strCodeType2));
                }
                --i3;
            }
        }
        if ((nActionMode & 1) > 0) {
            int i4 = 0;
            while (i4 < codeTypes.length) {
                strCodeType = codeTypes[i4];
                strSubFolder = codeSubFolders[i4];
                HashMap<String, Integer> syncCodeActionMap = this.syncCodeMap.get(strCodeType);
                if (syncCodeActionMap == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u4ee3\u7801\u76ee\u5f55[%1$s]", (Object)strCodeType));
                }
                strPubCodeFolder = String.valueOf(this.getPubRootFolder()) + File.separator + strCodeType;
                pubCodeFolder = new File(strPubCodeFolder);
                strPubCodeFolder = pubCodeFolder.getPath();
                for (String strPubCode : syncCodeActionMap.keySet()) {
                    String strDstFileName3;
                    String strCodeType22;
                    if (!StringHelper.isNullOrEmpty((String)strSubFolder) && strPubCode.indexOf(strSubFolder) != 0) continue;
                    nAction = syncCodeActionMap.get(strPubCode);
                    File pubCodeFile = new File(String.valueOf(this.getPubRootFolder()) + File.separator + strCodeType + strPubCode);
                    if (nAction != 1) continue;
                    if (!StringHelper.isNullOrEmpty((String)strSubFolder)) {
                        strPubCode = strPubCode.substring(strSubFolder.length());
                    }
                    if (StringHelper.isNullOrEmpty((String)(strCodeType22 = (String)dstFileMap.get(strDstFileName3 = String.valueOf(strDstFolder) + strPubCode)))) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6587\u4ef6[%1$s]\u53d1\u5e03\u6e90", (Object)strDstFileName3));
                    }
                    if (StringHelper.compare((String)strCodeType22, (String)strCodeType, (boolean)false) == 0) {
                        File dstFile3 = new File(strDstFileName3);
                        if (!PSCodePubSessionBase.copyFile(pubCodeFile, dstFile3)) {
                            log.error((Object)StringHelper.format((String)"\u62f7\u8d1d\u6587\u4ef6\u5931\u8d25[%1$s]==>[%2$s]", (Object)pubCodeFile.getPath(), (Object)dstFile3.getPath()));
                            throw new Exception(StringHelper.format((String)"\u62f7\u8d1d\u6587\u4ef6\u5931\u8d25[%1$s]", (Object)strPubCode));
                        }
                        ++nCount;
                        continue;
                    }
                    log.debug((Object)StringHelper.format((String)"\u5ffd\u7565\u53d1\u5e03\u6e90[%2$s]\u6587\u4ef6[%1$s]\uff0c\u5b9e\u9645\u53d1\u5e03\u6e90\u4e3a[%3$s]", (Object)strDstFileName3, (Object)strCodeType, (Object)strCodeType22));
                }
                ++i4;
            }
        } else if ((nActionMode & 4) > 0) {
            int i5 = 0;
            while (i5 < codeTypes.length) {
                strCodeType = codeTypes[i5];
                strSubFolder = codeSubFolders[i5];
                HashMap<String, Boolean> pubCodeMap = this.codeTypeMap.get(strCodeType);
                if (pubCodeMap == null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u4ee3\u7801\u76ee\u5f55[%1$s]", (Object)strCodeType));
                }
                strPubCodeFolder = String.valueOf(this.getPubRootFolder()) + File.separator + strCodeType;
                pubCodeFolder = new File(strPubCodeFolder);
                strPubCodeFolder = pubCodeFolder.getPath();
                for (String strPubCode : pubCodeMap.keySet()) {
                    if (!StringHelper.isNullOrEmpty((String)strSubFolder) && strPubCode.indexOf(strSubFolder) != 0) continue;
                    File pubCodeFile = new File(String.valueOf(this.getPubRootFolder()) + File.separator + strCodeType + strPubCode);
                    if (!StringHelper.isNullOrEmpty((String)strSubFolder)) {
                        strPubCode = strPubCode.substring(strSubFolder.length());
                    }
                    if (StringHelper.isNullOrEmpty((String)(strCodeType2 = (String)dstFileMap.get(strDstFileName = String.valueOf(strDstFolder) + strPubCode)))) {
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6587\u4ef6[%1$s]\u53d1\u5e03\u6e90", (Object)strDstFileName));
                    }
                    if (StringHelper.compare((String)strCodeType2, (String)strCodeType, (boolean)false) == 0) {
                        dstFile = new File(strDstFileName);
                        if (!PSCodePubSessionBase.copyFile(pubCodeFile, dstFile)) {
                            log.error((Object)StringHelper.format((String)"\u62f7\u8d1d\u6587\u4ef6\u5931\u8d25[%1$s]==>[%2$s]", (Object)pubCodeFile.getPath(), (Object)dstFile.getPath()));
                            throw new Exception(StringHelper.format((String)"\u62f7\u8d1d\u6587\u4ef6\u5931\u8d25[%1$s]", (Object)strPubCode));
                        }
                        ++nCount;
                        continue;
                    }
                    log.debug((Object)StringHelper.format((String)"\u5ffd\u7565\u53d1\u5e03\u6e90[%2$s]\u6587\u4ef6[%1$s]\uff0c\u5b9e\u9645\u53d1\u5e03\u6e90\u4e3a[%3$s]", (Object)strDstFileName, (Object)strCodeType, (Object)strCodeType2));
                }
                ++i5;
            }
        }
        if ((nActionMode & 8) > 0) {
            this.removeEmptyFolder(new File(strDstFolder));
        }
        long nTime = System.currentTimeMillis() - nStartTime;
        log.debug((Object)StringHelper.format((String)"\u540c\u6b65\u76ee\u5f55[%1$s]==(%3$s)==>[%2$s]\u5b8c\u6210\uff0c\u540c\u6b65\u6587\u4ef6\u6570\u91cf[%4$s]\uff0c\u8017\u65f6[%5$s]ms", (Object)strFolders, (Object)strDstFolder, (Object)nActionMode, (Object)nCount, (Object)nTime));
        return nCount;
    }

    protected static String readFile(String strFilePath) throws Exception {
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
                    e.printStackTrace();
                    if (reader != null) {
                        try {
                            reader.close();
                        }
                        catch (IOException iOException) {}
                    }
                    break block15;
                }
            }
            catch (Throwable throwable) {
                if (reader != null) {
                    try {
                        reader.close();
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                throw throwable;
            }
            if (reader != null) {
                try {
                    reader.close();
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
        return sb.toString();
    }

    public static boolean copyFile(File f1, File f2) throws Exception {
        if (f2.exists()) {
            f2.delete();
        } else {
            f2.getParentFile().mkdirs();
        }
        f2.createNewFile();
        int length = 0x200000;
        FileInputStream in = null;
        FileOutputStream out = null;
        boolean bRet = false;
        try {
            try {
                in = new FileInputStream(f1);
                out = new FileOutputStream(f2);
                FileChannel inC = in.getChannel();
                FileChannel outC = out.getChannel();
                while (true) {
                    if (inC.position() == inC.size()) break;
                    length = inC.size() - inC.position() < 0x1400000L ? (int)(inC.size() - inC.position()) : 0x1400000;
                    inC.transferTo(inC.position(), length, outC);
                    inC.position(inC.position() + (long)length);
                }
                inC.close();
                outC.close();
                bRet = true;
            }
            catch (Exception ex) {
                log.error((Object)ex);
                bRet = false;
                in.close();
                out.close();
            }
        }
        finally {
            in.close();
            out.close();
        }
        return bRet;
    }

    protected boolean removeEmptyFolder(File folder) throws Exception {
        if (folder.isFile()) {
            return false;
        }
        File[] children = folder.listFiles();
        if (children != null) {
            File[] fileArray = children;
            int n = children.length;
            int n2 = 0;
            while (n2 < n) {
                File child = fileArray[n2];
                if (!this.removeEmptyFolder(child)) {
                    return false;
                }
                child.delete();
                ++n2;
            }
        }
        return true;
    }
}

