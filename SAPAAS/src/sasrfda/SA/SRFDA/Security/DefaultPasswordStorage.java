/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Base64
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Security;

import SA.SRFDA.Ctrl.BaseDEDataCtrl;
import SA.SRFDA.Ctrl.Data.PwdStorage;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Security.IPasswordStorage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Base64;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.io.ByteArrayOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DefaultPasswordStorage
implements IPasswordStorage {
    private static byte[] keyData = new byte[8];
    private ISRFDAGlobalHelper iDAGlobalHelper = null;

    static {
        DefaultPasswordStorage.keyData[0] = 2;
        DefaultPasswordStorage.keyData[1] = 0;
        DefaultPasswordStorage.keyData[2] = 1;
        DefaultPasswordStorage.keyData[3] = 2;
        DefaultPasswordStorage.keyData[4] = 0;
        DefaultPasswordStorage.keyData[5] = 8;
        DefaultPasswordStorage.keyData[6] = 0;
        DefaultPasswordStorage.keyData[7] = 1;
    }

    @Override
    public void Init(ISRFDAGlobalHelper iDAGlobalHelper) throws Exception {
        this.iDAGlobalHelper = iDAGlobalHelper;
    }

    protected ISRFDAGlobalHelper getGlobalHelper() {
        return this.iDAGlobalHelper;
    }

    @Override
    public void Storage(IDEDataCtrl iDEDataCtrl, String strDEId, Object objKey, String strUserTag, String strPassword, boolean bRevert) throws Exception {
        IDEDataCtrl pwdStorageDataCtrl = null;
        pwdStorageDataCtrl = iDEDataCtrl == null ? this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0124", "SA.SRFDA.Security.DefaultPasswordStorage") : iDEDataCtrl.GetRelatedDataCtrl("DE0124");
        String strPwdStorageKey = StringHelper.Format((String)"PWD:%1$s:%2$s:%3$s", (Object)strDEId, (Object)objKey, (Object)strUserTag);
        strPwdStorageKey = Helper.GenMD5((String)strPwdStorageKey);
        if (StringHelper.IsNullOrEmpty((String)strPassword)) {
            strPassword = "";
        }
        strPassword = String.valueOf(strPwdStorageKey) + strPassword;
        PwdStorage pwdStorage = new PwdStorage();
        pwdStorage.setPWDSTORAGEID(strPwdStorageKey);
        boolean bInsert = pwdStorageDataCtrl.CheckKeyState2(pwdStorage) == 0;
        pwdStorage.setPWDSTORAGEID(strPwdStorageKey);
        pwdStorage.setPWDSTORAGENAME(StringHelper.Format((String)"%1$s:%2$s:%3$s", (Object)strDEId, (Object)objKey, (Object)strUserTag));
        pwdStorage.setREVERTFLAG(bRevert);
        if (bRevert) {
            byte[] buff = DefaultPasswordStorage.Encrypto(strPassword.getBytes(), keyData);
            String strOutput = Base64.encodeBytes((byte[])buff, (int)2);
            pwdStorage.setDATA(strOutput);
        } else {
            String strOutput = Helper.GenMD5((String)strPassword);
            pwdStorage.setDATA(strOutput);
        }
        BaseDEDataCtrl.SetCallParamRetData(pwdStorage, false);
        BaseDEDataCtrl.SetCallParamDALog(pwdStorage, false);
        BaseDEDataCtrl.SetCallParamCheckKey(pwdStorage, false);
        CallResult callResult = pwdStorageDataCtrl.Save(bInsert, pwdStorage);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5bc6\u7801\u5b58\u50a8\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    @Override
    public String Revert(String strDEId, Object objKey, String strUserTag) throws Exception {
        IDEDataCtrl pwdStorageDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0124", "SA.SRFDA.Security.DefaultPasswordStorage");
        String strPwdStorageKey = StringHelper.Format((String)"PWD:%1$s:%2$s:%3$s", (Object)strDEId, (Object)objKey, (Object)strUserTag);
        strPwdStorageKey = Helper.GenMD5((String)strPwdStorageKey);
        PwdStorage pwdStorage = new PwdStorage();
        pwdStorage.setPWDSTORAGEID(strPwdStorageKey);
        CallResult callResult = pwdStorageDataCtrl.Get(pwdStorage);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5bc6\u7801\u5b58\u50a8\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (!pwdStorage.getREVERTFLAG()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5bc6\u7801\u4e0d\u652f\u6301\u6062\u590d"));
        }
        byte[] buff = Base64.decode((String)pwdStorage.getDATA());
        byte[] buff2 = DefaultPasswordStorage.Decrypto(buff, keyData);
        String strResult = new String(buff2);
        strResult = strResult.substring(strPwdStorageKey.length());
        return strResult;
    }

    @Override
    public boolean Check(String strDEId, Object objKey, String strUserTag, String strPassword) throws Exception {
        IDEDataCtrl pwdStorageDataCtrl = this.getGlobalHelper().getDAModelStorage().FindGlobalDEDataCtrl("DE0124", "SA.SRFDA.Security.DefaultPasswordStorage");
        String strPwdStorageKey = StringHelper.Format((String)"PWD:%1$s:%2$s:%3$s", (Object)strDEId, (Object)objKey, (Object)strUserTag);
        strPwdStorageKey = Helper.GenMD5((String)strPwdStorageKey);
        PwdStorage pwdStorage = new PwdStorage();
        pwdStorage.setPWDSTORAGEID(strPwdStorageKey);
        CallResult callResult = pwdStorageDataCtrl.Get(pwdStorage);
        if (callResult.IsError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5bc6\u7801\u5b58\u50a8\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        if (!pwdStorage.getREVERTFLAG()) {
            if (StringHelper.IsNullOrEmpty((String)strPassword)) {
                strPassword = "";
            }
            strPassword = String.valueOf(strPwdStorageKey) + strPassword;
            String strOutput = Helper.GenMD5((String)strPassword);
            return StringHelper.Compare((String)pwdStorage.getDATA(), (String)strOutput, (boolean)false) == 0;
        }
        byte[] buff = Base64.decode((String)pwdStorage.getDATA());
        byte[] buff2 = DefaultPasswordStorage.Decrypto(buff, keyData);
        String strResult = new String(buff2);
        return StringHelper.Compare((String)(strResult = strResult.substring(strPwdStorageKey.length())), (String)strPassword, (boolean)false) == 0;
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

    private static byte[] Decrypto(byte[] byteSource, byte[] keyData) throws Exception {
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
}

