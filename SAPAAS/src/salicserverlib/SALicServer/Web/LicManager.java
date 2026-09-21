/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.Base64
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.XML.SimpleXMLWriter
 *  SA.SRFramework.XML.XMLNode
 *  org.bouncycastle.jce.provider.BouncyCastleProvider
 */
package SALicServer.Web;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.XML.SimpleXMLWriter;
import SA.SRFramework.XML.XMLNode;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public final class LicManager
extends TimerTask {
    private static final String strRSAPubKey1 = "H4sIAAAAAAAAAAGBAH7/AKovW9ViNR6tr3ZyQlvhJ1YL7HDjvLNVzTW/nZZqveKOAB+Mn+TO2eRcHXhVnhFILQaKfJaYLePjCfFTvVryJwzHEwmea8bFoFyz3bc6nOeJ+G2/SF/wH4TQMjS7k0fkEh4C85ldJvfb3TsNGbqAtxeYtul5vytteKNeOS6+85K/L4JjjoEAAAA=";
    private static final String strRSAPubKey2 = "H4sIAAAAAAAAAGNkYAQAs4OEiQMAAAA=";
    private TreeMap<String, XMLNode> gaAppMap = new TreeMap();
    private TreeMap<String, TreeMap<String, String>> gaAppSessionMap = new TreeMap();
    private static final String TAG_SERVICEURL = "SERVICEURL";
    private XMLNode licNode = new XMLNode();
    private Timer refreshTimer = null;
    private long nLastFileTime = 0L;
    private String strLastLicenseFile = "";

    public final void LoadLicenseFile(String strLicenseFile) {
        String strContent = this.RSADecrypt(strLicenseFile);
        if (StringHelper.IsNullOrEmpty((String)strContent)) {
            return;
        }
        File file = new File(strLicenseFile);
        this.nLastFileTime = file.lastModified();
        this.strLastLicenseFile = strLicenseFile;
        this.LoadLicenseContent(strContent);
    }

    public final synchronized void LoadLicenseContent(String strContent) {
        this.licNode = null;
        this.licNode = new XMLNode();
        XMLConfig.LoadFromXML((String)strContent, (XMLConfig)this.licNode);
        ArrayList appList = new ArrayList();
        this.licNode.GetChildNodeByNodeName("SAGAAPPLICATION", appList);
        this.gaAppMap.clear();
        for (XMLNode appNode : appList) {
            this.gaAppMap.put(appNode.getID(), appNode);
        }
        if (this.refreshTimer == null) {
            this.refreshTimer = new Timer(Helper.GenGuidEx());
            this.refreshTimer.schedule((TimerTask)this, 60000L, 60000L);
        }
    }

    public final synchronized void OutputLicense(String strSign, Writer writer) throws IOException {
        String strTotalSign3;
        String strTotalSign2;
        String strTotalSign = StringHelper.Format((String)"%1$s|%2$s", (Object)LicManager.GetServerAddressInfo(), (Object)strSign);
        if (StringHelper.Compare((String)strTotalSign, (String)StringHelper.Format((String)"%1$s/licaction", (Object)this.licNode.GetExtValue(TAG_SERVICEURL, "")), (boolean)false) != 0 && StringHelper.Compare((String)(strTotalSign2 = StringHelper.Format((String)"%1$s|%2$s", (Object)LicManager.GetServerAddressInfo2(), (Object)strSign)), (String)StringHelper.Format((String)"%1$s/licaction", (Object)this.licNode.GetExtValue(TAG_SERVICEURL, "")), (boolean)false) != 0 && StringHelper.Compare((String)(strTotalSign3 = StringHelper.Format((String)"%1$s|%2$s", (Object)LicManager.GetServerAddressInfo3(), (Object)strSign)), (String)StringHelper.Format((String)"%1$s/licaction", (Object)this.licNode.GetExtValue(TAG_SERVICEURL, "")), (boolean)false) != 0) {
            String strTotalSignShow = Base64.encodeBytes((byte[])strTotalSign.getBytes(), (int)2);
            strTotalSignShow = strTotalSignShow.replace("\r", "");
            strTotalSignShow = strTotalSignShow.replace("\n", "");
            writer.write(StringHelper.Format((String)"<span>\u6388\u6743\u6587\u4ef6\u65e0\u6548\uff0c\u8bf7\u786e\u8ba4\u672c\u673a\u7279\u5f81\u7801[<BR><BR>SASIGN:%1$s<BR><BR>]\u662f\u5426\u4e0e\u6388\u6743\u6587\u4ef6\u4e00\u81f4</span>", (Object)strTotalSignShow));
            return;
        }
        StringBuilderEx sb = new StringBuilderEx();
        sb.Append("<span><B>\u6388\u6743\u534f\u8bae\u57fa\u672c\u4fe1\u606f</B></span><BR><BR>");
        sb.Append("&nbsp;<span><B>\u6388\u6743\u670d\u52a1\u5668:</B></span>&nbsp;<span>%1$s</span><BR><BR>", (Object)this.licNode.GetExtValue("GALICSERVERNAME", ""));
        sb.Append("<span><B>\u6388\u6743\u5e94\u7528\u96c6\u5408</B></span><BR><BR>");
        for (String strKey : this.gaAppMap.keySet()) {
            String strEXPIREDDATE;
            long nExpiredDate;
            XMLNode appNode = this.gaAppMap.get(strKey);
            sb.Append("&nbsp;<span><B>\u6388\u6743\u5e94\u7528[%1$s]</B></span><BR>", (Object)appNode.GetExtValue("APPNAME", ""));
            sb.Append("&nbsp;<span><B>\u5e94\u7528\u7f16\u53f7:</B></span>&nbsp;<span>%1$s</span><BR>", (Object)appNode.getID());
            sb.Append("&nbsp;<span><B>\u5e94\u7528\u6570\u91cf:</B></span>&nbsp;<span>%1$s</span><BR>", (Object)appNode.GetExtValue("APPCOUNT", 1));
            sb.Append("&nbsp;<span><B>\u6388\u6743\u4ea7\u54c1:</B></span>&nbsp;<span>%1$s</span><BR>", (Object)appNode.GetExtValue("PRODUCTID", ""));
            sb.Append("&nbsp;<span><B>\u7528\u6237\u5b9e\u4f53:</B></span>&nbsp;<span>%1$s</span><BR>", (Object)appNode.GetExtValue("USERBOCOUNT", 0));
            int nCPUCount = appNode.GetExtValue("CPUCOUNT", 0);
            if (nCPUCount > 0) {
                sb.Append("&nbsp;<span><B>CPU\u6570\u91cf:</B></span>&nbsp;<span>%1$s</span><BR>", (Object)nCPUCount);
            }
            if ((nExpiredDate = Long.parseLong(strEXPIREDDATE = appNode.GetExtValue("EXPIREDDATE", "0"))) == 0L) {
                sb.Append("&nbsp;<span><B>\u6388\u6743\u622a\u81f3:</B></span>&nbsp;<span>%1$s</span><BR>", (Object)"\u65e0");
            } else {
                Date dt = new Date(nExpiredDate);
                sb.Append("&nbsp;<span><B>\u6388\u6743\u622a\u81f3:</B></span>&nbsp;<span>%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS</span><BR>", (Object)dt);
            }
            sb.Append("<BR>");
        }
        writer.write(sb.toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final synchronized String RegApp(String strSign, String strAppId, String strClientIp) {
        String strTotalSign3;
        String strTotalSign = StringHelper.Format((String)"%1$s|%2$s", (Object)LicManager.GetServerAddressInfo(), (Object)strSign);
        if (StringHelper.Compare((String)strTotalSign, (String)StringHelper.Format((String)"%1$s/licaction", (Object)this.licNode.GetExtValue(TAG_SERVICEURL, "")), (boolean)false) != 0 && StringHelper.Compare((String)(strTotalSign = StringHelper.Format((String)"%1$s|%2$s", (Object)LicManager.GetServerAddressInfo2(), (Object)strSign)), (String)StringHelper.Format((String)"%1$s/licaction", (Object)this.licNode.GetExtValue(TAG_SERVICEURL, "")), (boolean)false) != 0 && StringHelper.Compare((String)(strTotalSign3 = StringHelper.Format((String)"%1$s|%2$s", (Object)LicManager.GetServerAddressInfo3(), (Object)strSign)), (String)StringHelper.Format((String)"%1$s/licaction", (Object)this.licNode.GetExtValue(TAG_SERVICEURL, "")), (boolean)false) != 0) {
            return "";
        }
        XMLNode ret = new XMLNode();
        ret.setNodeName("RESULT");
        if (this.gaAppMap.containsKey(strAppId)) {
            XMLNode appNode = this.gaAppMap.get(strAppId);
            String strSessionId = Helper.GenGuidEx();
            int nAppCount = appNode.GetExtValue("APPCOUNT", 1);
            String strProductId = appNode.GetExtValue("PRODUCTID", "");
            int nUserBOCount = appNode.GetExtValue("USERBOCOUNT", 0);
            String strEXPIREDDATE = appNode.GetExtValue("EXPIREDDATE", "0");
            long nExpiredDate = Long.parseLong(strEXPIREDDATE);
            int nCpuCount = appNode.GetExtValue("CPUCOUNT", 0);
            ret.SetValue("VERSION", "2");
            long nCurTime = new Date().getTime();
            if (nExpiredDate != 0L && nExpiredDate <= nCurTime) {
                ret.SetValue("RETCODE", "1");
                ret.SetValue("RETINFO", "\u5e94\u7528\u6388\u6743\u8d85\u65f6");
                return this.EncryptResult(ret);
            }
            TreeMap<Object, Object> appSessionMap = null;
            TreeMap<String, Object> treeMap = this.gaAppSessionMap;
            synchronized (treeMap) {
                if (this.gaAppSessionMap.containsKey(strAppId)) {
                    appSessionMap = this.gaAppSessionMap.get(strAppId);
                } else {
                    appSessionMap = new TreeMap();
                    this.gaAppSessionMap.put(strAppId, appSessionMap);
                }
            }
            treeMap = appSessionMap;
            synchronized (treeMap) {
                while (appSessionMap.size() >= nAppCount) {
                    String strLastSessionId = "";
                    String strRemoveSessionId = "";
                    Iterator<Object> iterator = appSessionMap.keySet().iterator();
                    while (iterator.hasNext()) {
                        String strTempSessionId;
                        strLastSessionId = strTempSessionId = (String)iterator.next();
                        String strLastClientIp = (String)appSessionMap.get(strTempSessionId);
                        if (StringHelper.Compare((String)strLastClientIp, (String)strClientIp, (boolean)false) != 0) continue;
                        strRemoveSessionId = strTempSessionId;
                        break;
                    }
                    if (!StringHelper.IsNullOrEmpty((String)strRemoveSessionId)) {
                        appSessionMap.remove(strRemoveSessionId);
                        continue;
                    }
                    if (StringHelper.IsNullOrEmpty((String)strLastSessionId)) continue;
                    appSessionMap.remove(strLastSessionId);
                }
                appSessionMap.put(strSessionId, strClientIp);
            }
            ret.SetValue("RETCODE", "0");
            ret.SetValue("PRODUCTID", strProductId);
            ret.SetValue("USERBOCOUNT", StringHelper.Format((String)"%1$s", (Object)nUserBOCount));
            ret.SetValue("SESSIONID", strSessionId);
            ret.SetValue("CPUCOUNT", StringHelper.Format((String)"%1$s", (Object)nCpuCount));
        } else {
            ret.SetValue("RETCODE", "1");
            ret.SetValue("RETINFO", "\u5e94\u7528\u4e0d\u5728\u6388\u6743\u8303\u56f4");
        }
        return this.EncryptResult(ret);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final synchronized String UpdateApp(String strSign, String strAppId, String strSessionId) {
        String strTotalSign3;
        String strTotalSign = StringHelper.Format((String)"%1$s|%2$s", (Object)LicManager.GetServerAddressInfo(), (Object)strSign);
        if (StringHelper.Compare((String)strTotalSign, (String)StringHelper.Format((String)"%1$s/licaction", (Object)this.licNode.GetExtValue(TAG_SERVICEURL, "")), (boolean)false) != 0 && StringHelper.Compare((String)(strTotalSign = StringHelper.Format((String)"%1$s|%2$s", (Object)LicManager.GetServerAddressInfo2(), (Object)strSign)), (String)StringHelper.Format((String)"%1$s/licaction", (Object)this.licNode.GetExtValue(TAG_SERVICEURL, "")), (boolean)false) != 0 && StringHelper.Compare((String)(strTotalSign3 = StringHelper.Format((String)"%1$s|%2$s", (Object)LicManager.GetServerAddressInfo3(), (Object)strSign)), (String)StringHelper.Format((String)"%1$s/licaction", (Object)this.licNode.GetExtValue(TAG_SERVICEURL, "")), (boolean)false) != 0) {
            return "";
        }
        XMLNode ret = new XMLNode();
        ret.setNodeName("RESULT");
        if (this.gaAppMap.containsKey(strAppId)) {
            XMLNode appNode = this.gaAppMap.get(strAppId);
            String strEXPIREDDATE = appNode.GetExtValue("EXPIREDDATE", "0");
            long nExpiredDate = Long.parseLong(strEXPIREDDATE);
            long nCurTime = new Date().getTime();
            if (nExpiredDate != 0L && nExpiredDate <= nCurTime) {
                ret.SetValue("RETCODE", "1");
                ret.SetValue("RETINFO", "\u5e94\u7528\u6388\u6743\u8d85\u65f6");
                return this.EncryptResult(ret);
            }
            TreeMap<Object, Object> appSessionMap = null;
            TreeMap<String, Object> treeMap = this.gaAppSessionMap;
            synchronized (treeMap) {
                if (this.gaAppSessionMap.containsKey(strAppId)) {
                    appSessionMap = this.gaAppSessionMap.get(strAppId);
                } else {
                    appSessionMap = new TreeMap();
                    this.gaAppSessionMap.put(strAppId, appSessionMap);
                }
            }
            treeMap = appSessionMap;
            synchronized (treeMap) {
                if (appSessionMap.containsKey(strSessionId)) {
                    ret.SetValue("RETCODE", "0");
                } else {
                    ret.SetValue("RETCODE", "1");
                }
            }
        }
        ret.SetValue("RETCODE", "1");
        ret.SetValue("RETINFO", "\u5e94\u7528\u4e0d\u5728\u6388\u6743\u8303\u56f4");
        return this.EncryptResult(ret);
    }

    private String EncryptResult(XMLNode node) {
        StringBuilder sb = new StringBuilder();
        SimpleXMLWriter writer = new SimpleXMLWriter(sb);
        writer.WriteRaw("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\r\n");
        node.Save(writer);
        String strContent = sb.toString();
        byte[] keyData = new byte[8];
        Calendar calendar = Calendar.getInstance();
        int nYear = calendar.get(1);
        int nMonth = calendar.get(2);
        int nDay = calendar.get(5);
        keyData[0] = (byte)(nYear / 1000);
        keyData[1] = (byte)(nYear % 1000 / 100);
        keyData[2] = (byte)(nYear % 100 / 10);
        keyData[3] = (byte)(nYear % 10);
        keyData[4] = (byte)(nMonth / 10);
        keyData[5] = (byte)(nMonth % 10);
        keyData[6] = (byte)(nDay / 10);
        keyData[7] = (byte)(nDay % 10);
        try {
            byte[] buff = LicManager.Encrypto(strContent.getBytes(), keyData);
            String strOutput = Base64.encodeBytes((byte[])buff, (int)2);
            return strOutput;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private final String RSADecrypt(String strSourceFile) {
        try {
            byte[] pubModBytes = Base64.decode((String)strRSAPubKey1);
            byte[] pubPubExpBytes = Base64.decode((String)strRSAPubKey2);
            RSAPublicKey recoveryPubKey = LicManager.GenerateRSAPublicKey(pubModBytes, pubPubExpBytes);
            File file = new File(strSourceFile);
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte[] tmpbuf = new byte[1024];
            int count = 0;
            while ((count = in.read(tmpbuf)) != -1) {
                bout.write(tmpbuf, 0, count);
                tmpbuf = new byte[1024];
            }
            in.close();
            String strTemp = new String(bout.toByteArray());
            byte[] buf = Base64.decode((String)strTemp);
            byte[] raw = LicManager.Decrypt(recoveryPubKey, buf);
            String strOutput = new String(raw, "UTF-8");
            return strOutput;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    private static String GetServerAddressInfo() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            String strTotalSign = StringHelper.Format((String)"%1$s|%2$s", (Object)localhost.getHostName().toUpperCase(), (Object)localhost.getHostAddress().toUpperCase());
            return strTotalSign;
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String GetServerAddressInfo2() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            String strTotalSign = StringHelper.Format((String)"%1$s|*", (Object)localhost.getHostName().toUpperCase());
            return strTotalSign;
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String GetServerAddressInfo3() {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            String strTotalSign = StringHelper.Format((String)"*|%1$s", (Object)localhost.getHostAddress().toUpperCase());
            return strTotalSign;
        }
        catch (UnknownHostException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static final RSAPublicKey GenerateRSAPublicKey(byte[] modulus, byte[] publicExponent) throws Exception {
        KeyFactory keyFac = null;
        try {
            keyFac = KeyFactory.getInstance("RSA", (Provider)new BouncyCastleProvider());
        }
        catch (NoSuchAlgorithmException ex) {
            throw new Exception(ex.getMessage());
        }
        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent));
        try {
            return (RSAPublicKey)keyFac.generatePublic(pubKeySpec);
        }
        catch (InvalidKeySpecException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private static byte[] Decrypt(Key key, byte[] raw) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("RSA", (Provider)new BouncyCastleProvider());
            cipher.init(2, key);
            int blockSize = cipher.getBlockSize();
            ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
            int j = 0;
            while (raw.length - j * blockSize > 0) {
                bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
                ++j;
            }
            return bout.toByteArray();
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private static byte[] Encrypto(byte[] byteSource, byte[] keyData) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int mode = 1;
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

    public void run() {
        File file = new File(this.strLastLicenseFile);
        if (!file.exists()) {
            return;
        }
        if (file.lastModified() == this.nLastFileTime) {
            return;
        }
        this.LoadLicenseFile(this.strLastLicenseFile);
    }
}

