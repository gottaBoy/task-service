/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.Base64Helper
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.yaml.snakeyaml.DumperOptions
 *  org.yaml.snakeyaml.DumperOptions$FlowStyle
 *  org.yaml.snakeyaml.Yaml
 */
package net.ibizsys.pscore.srv.util;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;
import javax.crypto.Cipher;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.Base64Helper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel;
import net.ibizsys.pscore.srv.config.demodel.PSDevCenterTypeDEModel;
import net.ibizsys.pscore.srv.config.entity.PSDevCenterType;
import net.ibizsys.pscore.srv.config.service.PSDevCenterTypeService;
import net.ibizsys.pscore.srv.core.PSDCSysLicException;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCResRep;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDCResRepService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class PSDevCenterHelper {
    private static final String KEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAK6ioJMxbkWnZU8NGTcvCbNOd3NrrFKDbSocWQQr+R4/MRznOksADA4XtrmKer6Ro/8cYcHf17QUlyb3tJvh3cUCAwEAAQ==";
    public static final int GETUSERMODE_DEFAULT = 0;
    public static final int GETUSERMODE_TRY = 1;
    public static final int GETUSERMODE_CREATEIFNOTEXISTS = 2;
    private static final Log log = LogFactory.getLog(PSDevCenterHelper.class);

    public static boolean isLabDC(PSDevCenter pSDevCenter) {
        if (pSDevCenter.getDCLevel() != null && pSDevCenter.getDCLevel() >= 10 && pSDevCenter.getDCLevel() < 100) {
            return true;
        }
        return PSDevCenterHelper.isRecycleDC(pSDevCenter);
    }

    public static boolean isLabDCRepoReadonly(PSDevCenter pSDevCenter) {
        if (pSDevCenter.getDCLevel() != null) {
            return pSDevCenter.getDCLevel() == 10;
        }
        return false;
    }

    public static boolean isLabDC(PSDevCenter pSDevCenter, int n) {
        if (pSDevCenter.getDCLevel() != null && pSDevCenter.getDCLevel() >= 10 && pSDevCenter.getDCLevel() < 100) {
            return pSDevCenter.getDCLevel() == n;
        }
        return false;
    }

    public static PSDevUser getPSDevUser(PSDevCenter pSDevCenter, String string, int n) throws Exception {
        String string2 = "";
        String[] stringArray = string.split("[@]");
        string2 = stringArray[0];
        PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevUser pSDevUser = new PSDevUser();
        pSDevUser.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        if (stringArray.length > 1) {
            pSDevUser.setFullLoginName(string);
        } else {
            pSDevUser.setLoginName(string2);
        }
        if (pSDevUserService.select(pSDevUser, true)) {
            return pSDevUser;
        }
        pSDevUser.reset();
        pSDevUser.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
        pSDevUser.setFromUserMode(1);
        pSDevUser.setFromLoginName(string2);
        if (pSDevUserService.select(pSDevUser, true)) {
            return pSDevUser;
        }
        if (n == 0) {
            throw new Exception(StringHelper.format((String)"\u5f53\u524d\u4e2d\u5fc3\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7528\u6237[%1$s]", (Object)string));
        }
        if (n == 1) {
            return null;
        }
        if (n == 2) {
            PSDevUser pSDevUser2 = new PSDevUser();
            pSDevUser.reset();
            pSDevUser.setFromUserMode(0);
            if (stringArray.length > 1) {
                pSDevUser.setFullLoginName(string);
            } else {
                pSDevUser.setLoginName(string2);
            }
            if (!pSDevUserService.select(pSDevUser, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7528\u6237[%1$s]", (Object)string));
            }
            pSDevUser2.reset();
            pSDevUser2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevUser2.setFromUserMode(1);
            pSDevUser2.setFromPSDevUserId(pSDevUser.getPSDevUserId());
            if (pSDevUserService.select(pSDevUser2, true)) {
                String string3 = pSDevUser2.getPSDevUserId();
                pSDevUser2.reset();
                pSDevUser2.setPSDevUserId(string3);
                pSDevUser2.setFromLoginName(string2);
                pSDevUserService.sysUpdate(pSDevUser2, true);
                return pSDevUser2;
            }
            pSDevUser2.reset();
            pSDevUser2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevUser2.setFromUserMode(1);
            pSDevUser2.setFromPSDevUserId(pSDevUser.getPSDevUserId());
            pSDevUser2.setFromLoginName(string2);
            pSDevUser2.setFromPSDevUserName(pSDevUser.getPSDevUserName());
            pSDevUser2.setFromPSDCId(pSDevUser.getPSDevCenterId());
            pSDevUser2.setFromPSDCName(pSDevUser.getPSDevCenterName());
            pSDevUser2.setPSDevUserName(pSDevUser.getPSDevUserName());
            pSDevUser2.setValidFlag(1);
            pSDevUser2.setPSDevCenterId(pSDevCenter.getPSDevCenterId());
            pSDevUser2.setPSDevCenterName(pSDevCenter.getPSDevCenterName());
            pSDevUserService.create(pSDevUser2);
            return pSDevUser2;
        }
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u83b7\u53d6\u4e2d\u5fc3\u7528\u6237\u6a21\u5f0f[%1$s]", (Object)n));
    }

    public static boolean testCreate(PSDevCenter pSDevCenter, String string, boolean bl) throws Exception {
        if (pSDevCenter == null) {
            throw new Exception("\u4f20\u5165\u5e94\u7528\u4e2d\u5fc3\u65e0\u6548");
        }
        PSDevCenterType pSDevCenterType = PSDevCenterHelper.getPSDevCenterType(pSDevCenter);
        if (pSDevCenterType == null) {
            return true;
        }
        String string2 = "MAX" + string;
        int n = DataObject.getIntegerValue((IDataObject)pSDevCenterType, (String)string2, (int)-1);
        if (n == -1) {
            return true;
        }
        PSDCResRep pSDCResRep = PSDevCenterHelper.getPSDCResRep(pSDevCenter);
        int n2 = DataObject.getIntegerValue((IDataObject)pSDCResRep, (String)string, (int)0);
        if (n2 + 1 > n) {
            if (bl) {
                return false;
            }
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)"PSDEVCENTERTYPE");
            IDEField iDEField = iDataEntityModel.getDEField(string2, true);
            String string3 = string2;
            if (iDEField != null) {
                string3 = iDEField.getLogicName();
            }
            throw new PSDCSysLicException(StringHelper.format((String)"[%1$s]\u8d85\u8fc7\u9650\u5236\uff0c\u5141\u8bb8[%2$s]\uff0c\u5f53\u524d[%3$s]", (Object)string3, (Object)n, (Object)n2), iDEField.getLogicName(), n, n2);
        }
        return true;
    }

    public static boolean testCreatePSDevUser(PSDevUser pSDevUser, boolean bl) throws Exception {
        return PSDevCenterHelper.testCreate(pSDevUser.getPSDevCenter(), "USERCNT", bl);
    }

    public static PSDevCenterType getPSDevCenterType(PSDevCenter pSDevCenter) throws Exception {
        Object object;
        if (!StringHelper.isNullOrEmpty((String)pSDevCenter.getLicKey()) && (object = PSDevCenterHelper.fillPSDevCenter(pSDevCenter, null)) != null) {
            return object;
        }
        if (PSCoreSysServiceBase.isCloudMode()) {
            // empty if block
        }
        if (!pSDevCenter.isDCLevelDirty() || !pSDevCenter.isDCTypeDirty()) {
            throw new Exception(StringHelper.format((String)"\u4f20\u5165\u5e94\u7528\u4e2d\u5fc3\u65e0\u6548"));
        }
        object = StringHelper.format((String)"%1$s_%2$s", (Object)pSDevCenter.getDCType(), (Object)pSDevCenter.getDCLevel());
        PSDevCenterTypeService pSDevCenterTypeService = (PSDevCenterTypeService)ServiceGlobal.getService(PSDevCenterTypeService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        IEntity iEntity = PSCoreSysServiceBase.getActionCacheEntity(pSDevCenterTypeService, (String)object, true);
        if (iEntity != null) {
            return (PSDevCenterType)iEntity;
        }
        return null;
    }

    public static PSDCResRep getPSDCResRep(PSDevCenter pSDevCenter) throws Exception {
        PSDCResRepService pSDCResRepService = (PSDCResRepService)ServiceGlobal.getService(PSDCResRepService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        IEntity iEntity = PSCoreSysServiceBase.getActionCacheEntity(pSDCResRepService, pSDevCenter.getPSDevCenterId(), true);
        if (iEntity == null) {
            PSCoreSysServiceBase.resetActionCacheEntity("PSDCRESREP", pSDevCenter.getPSDevCenterId());
            PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            pSDevCenterService.genResRep(pSDevCenter);
            return (PSDCResRep)PSCoreSysServiceBase.getActionCacheEntity(pSDCResRepService, pSDevCenter.getPSDevCenterId(), false);
        }
        return (PSDCResRep)iEntity;
    }

    public static void updatetPSDCResRep(PSDevCenter pSDevCenter) throws Exception {
        PSDevCenterHelper.updatetPSDCResRep(pSDevCenter, null);
    }

    public static void updatetPSDCResRep(PSDevCenter pSDevCenter, String string) throws Exception {
        if (pSDevCenter == null) {
            return;
        }
        PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        pSDevCenterService.genResRep(pSDevCenter, string);
        PSCoreSysServiceBase.resetActionCacheEntity("PSDCRESREP", pSDevCenter.getPSDevCenterId());
    }

    public static PSDCWorkspace getPSDCWorkspace(PSDevCenter pSDevCenter, String string, boolean bl, boolean bl2) throws Exception {
        ArrayList arrayList;
        PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEVCENTERID", (Object)pSDevCenter.getPSDevCenterId());
        selectCond.set("RESSTATE", (Object)20);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.set("PSDCWORKSPACEID", (Object)string);
        }
        if ((arrayList = pSDCWorkspaceService.select((ISelectCond)selectCond)).size() == 0) {
            if (!StringHelper.isNullOrEmpty((String)string)) {
                log.error((Object)StringHelper.format((String)"\u6307\u5b9a\u751f\u4ea7\u7ebf[%1$s]\u65e0\u6548", (Object)string));
                throw new Exception(StringHelper.format((String)"\u6307\u5b9a\u751f\u4ea7\u7ebf\u65e0\u6548"));
            }
            if (bl2) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u65e0\u6709\u6548\u751f\u4ea7\u7ebf"));
        }
        if (!StringHelper.isNullOrEmpty((String)string)) {
            PSDCWorkspace pSDCWorkspace = (PSDCWorkspace)arrayList.get(0);
            if (bl) {
                if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace.getCurAction()) && StringHelper.compare((String)pSDCWorkspace.getCurAction(), (String)"NONE", (boolean)true) != 0) {
                    throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c", (Object)pSDCWorkspace.getPSDCWorkspaceName(), (Object)DCWorkspaceLogTypeCodeListModel.getInstance().getCodeItem(pSDCWorkspace.getCurAction()).getText()));
                }
                if (!StringHelper.isNullOrEmpty((String)pSDCWorkspace.getPSDevSlnSysId())) {
                    throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u5df2\u7ecf\u5b89\u88c5\u5f00\u53d1\u7cfb\u7edf[%2$s]", (Object)pSDCWorkspace.getPSDCWorkspaceName(), (Object)pSDCWorkspace.getPSDevSlnSysName()));
                }
            }
            return pSDCWorkspace;
        }
        for (PSDCWorkspace pSDCWorkspace : arrayList) {
            if (bl && (!StringHelper.isNullOrEmpty((String)pSDCWorkspace.getCurAction()) && StringHelper.compare((String)pSDCWorkspace.getCurAction(), (String)"NONE", (boolean)true) != 0 || !StringHelper.isNullOrEmpty((String)pSDCWorkspace.getPSDevSlnSysId()))) continue;
            return pSDCWorkspace;
        }
        if (bl2) {
            return null;
        }
        throw new Exception(StringHelper.format((String)"\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u65e0\u7a7a\u95f2\u751f\u4ea7\u7ebf"));
    }

    public static boolean isRecycleDC(PSDevCenter pSDevCenter) {
        return StringHelper.compare((String)pSDevCenter.getPSDevCenterId(), (String)PSCoreSysServiceBase.getRecyclePSDCId(), (boolean)false) == 0;
    }

    public static PSDevCenterType fillPSDevCenter(PSDevCenter pSDevCenter, PSDevCenter pSDevCenter2) throws Exception {
        String string = pSDevCenter.getLicKey();
        if (StringHelper.isNullOrEmpty((String)string) && pSDevCenter2 != null) {
            string = pSDevCenter2.getLicKey();
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            pSDevCenter.setLicInfo(null);
        } else {
            pSDevCenter.setLicInfo(null);
            try {
                DumperOptions dumperOptions = new DumperOptions();
                dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
                String string2 = PSDevCenterHelper.decrypt(string, KEY);
                Yaml yaml = new Yaml(dumperOptions);
                Map map = (Map)yaml.loadAs(string2, Map.class);
                if (map != null) {
                    Object v;
                    Object v2 = map.get("PSDEVCENTERNAME");
                    if (!StringHelper.isNullOrEmpty(v2)) {
                        pSDevCenter.setPSDevCenterName((String)v2);
                    }
                    if (!StringHelper.isNullOrEmpty(v = map.get("EXPIREDTIME"))) {
                        pSDevCenter.setExpiredTime(new Timestamp(DateHelper.parse((String)v.toString()).getTime()));
                    }
                    IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel(PSDevCenterTypeDEModel.class);
                    StringBuilderEx stringBuilderEx = new StringBuilderEx();
                    PSDevCenterType pSDevCenterType = new PSDevCenterType();
                    for (Map.Entry entry : map.entrySet()) {
                        pSDevCenterType.set((String)entry.getKey(), entry.getValue());
                        IDEField iDEField = iDataEntityModel.getDEField((String)entry.getKey(), true);
                        if (iDEField == null) continue;
                        stringBuilderEx.append("%1$s[%2$s]\r\n", (Object)iDEField.getLogicName(), entry.getValue());
                    }
                    pSDevCenter.setLicInfo(stringBuilderEx.toString());
                    return pSDevCenterType;
                }
            }
            catch (Exception exception) {
                pSDevCenter.setLicInfo("\u6388\u6743\u7801\u65e0\u6548");
                return null;
            }
        }
        return null;
    }

    private static String decrypt(String string, String string2) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64Helper.decode((String)string2));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        return PSDevCenterHelper.decrypt(string, publicKey);
    }

    private static String decrypt(String string, PublicKey publicKey) throws Exception {
        byte[] byArray;
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(2, publicKey);
        int n = 64;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray2 = Base64Helper.decode((String)string);
        int n2 = 0;
        while (true) {
            if (byArray2.length <= (n2 + 1) * n) break;
            byArray = cipher.doFinal(byArray2, n2 * n, n);
            byteArrayOutputStream.write(byArray);
            ++n2;
        }
        byArray = cipher.doFinal(byArray2, n2 * n, byArray2.length - n2 * n);
        byteArrayOutputStream.write(byArray);
        return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
    }
}

