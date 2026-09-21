/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.exception.ErrorException
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.codelist.DevSlnSysKeyStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.StudioVerCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevSlnSysKey;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevSlnSysKeyService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnUser;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.util.IPSDevUser;
import net.ibizsys.pscore.srv.util.IPSSysDevUser;
import net.ibizsys.pscore.srv.util.PSDevUserBase;
import net.ibizsys.pscore.srv.util.PSDevUserUserGlobal;
import net.ibizsys.pscore.srv.util.PSSysDevUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysDevUserUserGlobal
implements Serializable {
    public static final String SESSIONKEY = "SRF_PSSYSDEVUSERUSERGLOBAL";
    private static final Log log = LogFactory.getLog(PSSysDevUserUserGlobal.class);
    protected HashMap<String, IPSSysDevUser> psSysDevUserMap = new HashMap();
    private static ThreadLocal<IPSSysDevUser> currentUser = new ThreadLocal();

    public static IPSSysDevUser getCurrentUser() {
        return currentUser.get();
    }

    public static void setCurrentUser(IPSSysDevUser iPSSysDevUser) {
        currentUser.set(iPSSysDevUser);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public IPSSysDevUser getPSSysDevUser(String string) throws Exception {
        IPSSysDevUser iPSSysDevUser = null;
        HashMap<String, IPSSysDevUser> hashMap = this.psSysDevUserMap;
        synchronized (hashMap) {
            iPSSysDevUser = this.psSysDevUserMap.get(string);
            return iPSSysDevUser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerPSSysDevUser(String string, IPSSysDevUser iPSSysDevUser) throws Exception {
        HashMap<String, IPSSysDevUser> hashMap = this.psSysDevUserMap;
        synchronized (hashMap) {
            this.psSysDevUserMap.put(string, iPSSysDevUser);
        }
    }

    public static PSSysDevUserUserGlobal getCurrent() throws Exception {
        return PSSysDevUserUserGlobal.getCurrent(null);
    }

    public static PSSysDevUserUserGlobal getCurrent(IWebContext iWebContext) throws Exception {
        if (iWebContext == null) {
            iWebContext = WebContext.getCurrent();
        }
        if (iWebContext == null) {
            throw new Exception(StringHelper.format((String)"\u7528\u6237\u4e0a\u4e0b\u6587\u5bf9\u8c61\u65e0\u6548"));
        }
        Object object = iWebContext.getSessionValue(SESSIONKEY, false);
        if (object == null) {
            object = new PSSysDevUserUserGlobal();
            iWebContext.setSessionValue(SESSIONKEY, object, false);
        }
        return (PSSysDevUserUserGlobal)object;
    }

    public static void resetCurrent(IWebContext iWebContext) {
        if (iWebContext == null) {
            iWebContext = WebContext.getCurrent();
        }
        if (iWebContext == null) {
            return;
        }
        iWebContext.setSessionValue(SESSIONKEY, null);
    }

    public static IPSSysDevUser getPSSysDevUser(IWebContext iWebContext, String string, String string2) throws Exception {
        if (StringHelper.isNullOrEmpty((String)iWebContext.getCurUserId()) && !PSCoreSysModel.isShareSysMode()) {
            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u8fd8\u672a\u767b\u5f55"));
        }
        IPSSysDevUser iPSSysDevUser = null;
        PSSysDevUserUserGlobal pSSysDevUserUserGlobal = PSSysDevUserUserGlobal.getCurrent(iWebContext);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            Object object;
            Object object2;
            iPSSysDevUser = pSSysDevUserUserGlobal.getPSSysDevUser(string);
            if (iPSSysDevUser != null) {
                if (iPSSysDevUser == PSSysDevUser.ACCESSDENY) {
                    throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u7cfb\u7edf"));
                }
                if (iPSSysDevUser.isExpired()) {
                    throw new ErrorException(2, StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u5df2\u8fc7\u671f"));
                }
                if (StringHelper.compare((String)PSCoreSysModel.getStudioVer(), (String)"S0500", (boolean)false) == 0 && (StringHelper.isNullOrEmpty((String)iPSSysDevUser.getStudioVer()) || StringHelper.compare((String)iPSSysDevUser.getStudioVer(), (String)"S0500", (boolean)false) == 0 || StringHelper.compare((String)iPSSysDevUser.getStudioVer(), (String)"S0600M1", (boolean)false) == 0)) {
                    return iPSSysDevUser;
                }
                if (StringHelper.compare((String)PSCoreSysModel.getStudioVer(), (String)"S0600", (boolean)false) == 0 && (StringHelper.isNullOrEmpty((String)iPSSysDevUser.getStudioVer()) || StringHelper.compare((String)iPSSysDevUser.getStudioVer(), (String)"S0600", (boolean)false) == 0 || StringHelper.compare((String)iPSSysDevUser.getStudioVer(), (String)"S0600M1", (boolean)false) == 0)) {
                    return iPSSysDevUser;
                }
                String string3 = StudioVerCodeListModel.getInstance().getCodeListText(iPSSysDevUser.getStudioVer(), true);
                throw new ErrorException(2, StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u65e0\u6cd5\u6253\u5f00\uff0c\u9700\u8981Studio\u7248\u672c[%1$s]", (Object)string3));
            }
            PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            pSDevSlnSys.setPSDevSlnSysId(string);
            pSDevSlnSysService.get((IEntity)pSDevSlnSys);
            Timestamp timestamp = pSDevSlnSys.getExpriedTime();
            IPSDevUser iPSDevUser = null;
            int n = 5;
            if (!PSCoreSysModel.isShareSysMode()) {
                PSDevSlnUser pSDevSlnUser;
                try {
                    iPSDevUser = PSDevUserUserGlobal.getPSDevUser(iWebContext, pSDevSlnSys.getPSDevCenterId());
                }
                catch (Exception exception) {
                    // empty catch block
                }
                object2 = iWebContext.getCurUserId();
                if (iPSDevUser != null) {
                    object2 = iPSDevUser.getPSDevUserId();
                }
                if ((pSDevSlnUser = ((PSDevSlnUserService)(object = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class))).getPSDevSlnUser(pSDevSlnSys, (String)object2)) != null) {
                    n = pSDevSlnUser.getAccMode();
                } else {
                    PSDevSlnSysKeyService pSDevSlnSysKeyService = (PSDevSlnSysKeyService)ServiceGlobal.getService(PSDevSlnSysKeyService.class);
                    String string4 = iWebContext.getParamValue("DEVSLNSYSKEY");
                    PSDevSlnSysKey pSDevSlnSysKey = new PSDevSlnSysKey();
                    if (StringHelper.isNullOrEmpty((String)string4)) {
                        pSDevSlnSysKey.setPSDevCenterId(iWebContext.getCurOrgId());
                        pSDevSlnSysKey.setPSDevSlnSysId(string);
                        pSDevSlnSysKey.setKeyState(DevSlnSysKeyStateCodeListModel.OK);
                        if (!pSDevSlnSysKeyService.select(pSDevSlnSysKey, true)) {
                            pSSysDevUserUserGlobal.registerPSSysDevUser(pSDevSlnSys.getPSDevSlnSysId(), PSSysDevUser.ACCESSDENY);
                            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u7cfb\u7edf"));
                        }
                        if (System.currentTimeMillis() > pSDevSlnSysKey.getEndTime().getTime()) {
                            pSSysDevUserUserGlobal.registerPSSysDevUser(pSDevSlnSys.getPSDevSlnSysId(), PSSysDevUser.ACCESSDENY);
                            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u7cfb\u7edf\uff0c\u8bbf\u95ee\u6388\u6743\u5df2\u7ecf\u8d85\u671f"));
                        }
                        timestamp = pSDevSlnSysKey.getEndTime();
                    } else {
                        pSDevSlnSysKey.setPSDevSlnSysKeyId(string4);
                        if (!pSDevSlnSysKeyService.get((IEntity)pSDevSlnSysKey, true)) {
                            log.error((Object)StringHelper.format((String)"\u7528\u6237[%1$s][%2$s]\u4f7f\u7528\u7cfb\u7edf\u7ba1\u7406\u6807\u8bc6\u8bbf\u95ee\u5931\u8d25\uff0c\u6570\u636e\u4e0d\u5b58\u5728", (Object)iWebContext.getCurUserId(), (Object)iWebContext.getRealRemoteAddr()));
                            pSSysDevUserUserGlobal.registerPSSysDevUser(pSDevSlnSys.getPSDevSlnSysId(), PSSysDevUser.ACCESSDENY);
                            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u7cfb\u7edf"));
                        }
                        if (StringHelper.compare((String)string, (String)pSDevSlnSysKey.getPSDevSlnSysId(), (boolean)false) != 0) {
                            log.error((Object)StringHelper.format((String)"\u7528\u6237[%1$s][%2$s]\u4f7f\u7528\u7cfb\u7edf\u7ba1\u7406\u6807\u8bc6\u8bbf\u95ee\u5931\u8d25\uff0c\u7cfb\u7edf\u4e0d\u4e00\u81f4", (Object)iWebContext.getCurUserId(), (Object)iWebContext.getRealRemoteAddr()));
                            pSSysDevUserUserGlobal.registerPSSysDevUser(pSDevSlnSys.getPSDevSlnSysId(), PSSysDevUser.ACCESSDENY);
                            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u7cfb\u7edf"));
                        }
                        int n2 = DataObject.getIntegerValue((Object)pSDevSlnSysKey.getKeyCount(), (Integer)0);
                        if (n2 <= 0) {
                            log.error((Object)StringHelper.format((String)"\u7528\u6237[%1$s][%2$s]\u4f7f\u7528\u7cfb\u7edf\u7ba1\u7406\u6807\u8bc6\u8bbf\u95ee\u5931\u8d25\uff0c\u6570\u91cf\u4e0d\u8db3", (Object)iWebContext.getCurUserId(), (Object)iWebContext.getRealRemoteAddr()));
                            pSSysDevUserUserGlobal.registerPSSysDevUser(pSDevSlnSys.getPSDevSlnSysId(), PSSysDevUser.ACCESSDENY);
                            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u7cfb\u7edf"));
                        }
                        pSDevSlnSysKey.setKeyCount(--n2);
                        pSDevSlnSysKeyService.update(pSDevSlnSysKey);
                        log.info((Object)StringHelper.format((String)"\u7528\u6237[%1$s][%2$s]\u4f7f\u7528\u7cfb\u7edf\u7ba1\u7406\u6807\u8bc6[%3$s]", (Object)iWebContext.getCurUserId(), (Object)iWebContext.getRealRemoteAddr(), (Object)pSDevSlnSysKey.getPSDevSlnSysKeyId()));
                        n = 3;
                    }
                }
            }
            if (StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSysModelInstId())) {
                throw new ErrorException(2, StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u5df2\u79bb\u7ebf"));
            }
            object2 = new PSSysDevUser();
            ((PSSysDevUser)object2).setAccMode(n);
            if (DataObject.getBoolValue((Integer)pSDevSlnSys.getShareFlag(), (boolean)false)) {
                ((PSSysDevUser)object2).setAccMode(5);
            }
            ((PSSysDevUser)object2).setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            ((PSSysDevUser)object2).setPSSystemId(pSDevSlnSys.getPSSystemId());
            if (iPSDevUser != null) {
                ((PSDevUserBase)object2).setPSDevUserId(iPSDevUser.getPSDevUserId());
                ((PSDevUserBase)object2).setPSDevUserName(iPSDevUser.getPSDevUserName());
            } else {
                ((PSDevUserBase)object2).setPSDevUserId(iWebContext.getCurUserId());
                ((PSDevUserBase)object2).setPSDevUserName(iWebContext.getCurUserName());
            }
            ((PSSysDevUser)object2).setPSSysModelInstId(pSDevSlnSys.getPSSysModelInstId());
            if (pSDevSlnSys.getPSDevCenterTS() != null && pSDevSlnSys.getPSDevCenterTS().getPSTaskServer() != null) {
                ((PSDevUserBase)object2).setTaskServerUrl(pSDevSlnSys.getPSDevCenterTS().getPSTaskServer().getServerUrl());
            }
            if (pSDevSlnSys.getJITPSDevCenterTS() != null && pSDevSlnSys.getJITPSDevCenterTS().getPSTaskServer() != null) {
                ((PSSysDevUser)object2).setJITTaskServerUrl(pSDevSlnSys.getJITPSDevCenterTS().getPSTaskServer().getServerUrl());
            }
            ((PSDevUserBase)object2).setExpiredTime(timestamp);
            ((PSDevUserBase)object2).setStudioTag(pSDevSlnSys.getStudioTag());
            ((PSDevUserBase)object2).setStudioTag2(pSDevSlnSys.getStudioTag2());
            ((PSDevUserBase)object2).setStudioVer(pSDevSlnSys.getStudioVer());
            ((PSDevUserBase)object2).setPSDevCenterId(pSDevSlnSys.getPSDevCenterId());
            ((PSDevUserBase)object2).setPSDevCenterName(pSDevSlnSys.getPSDevCenterName());
            ((PSSysDevUser)object2).setPSDevSlnId(pSDevSlnSys.getPSDevSlnId());
            pSSysDevUserUserGlobal.registerPSSysDevUser(pSDevSlnSys.getPSDevSlnSysId(), (IPSSysDevUser)object2);
            if (((PSDevUserBase)object2).isExpired()) {
                throw new ErrorException(2, StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u5df2\u8fc7\u671f"));
            }
            if (StringHelper.compare((String)PSCoreSysModel.getStudioVer(), (String)"S0500", (boolean)false) == 0 && (StringHelper.isNullOrEmpty((String)((PSDevUserBase)object2).getStudioVer()) || StringHelper.compare((String)((PSDevUserBase)object2).getStudioVer(), (String)"S0500", (boolean)false) == 0 || StringHelper.compare((String)((PSDevUserBase)object2).getStudioVer(), (String)"S0600M1", (boolean)false) == 0)) {
                return object2;
            }
            if (StringHelper.compare((String)PSCoreSysModel.getStudioVer(), (String)"S0600", (boolean)false) == 0 && (StringHelper.isNullOrEmpty((String)((PSDevUserBase)object2).getStudioVer()) || StringHelper.compare((String)((PSDevUserBase)object2).getStudioVer(), (String)"S0600", (boolean)false) == 0 || StringHelper.compare((String)((PSDevUserBase)object2).getStudioVer(), (String)"S0600M1", (boolean)false) == 0)) {
                return object2;
            }
            object = StudioVerCodeListModel.getInstance().getCodeListText(((PSDevUserBase)object2).getStudioVer(), true);
            throw new ErrorException(2, StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf\u65e0\u6cd5\u6253\u5f00\uff0c\u9700\u8981Studio\u7248\u672c[%1$s]", (Object)object));
        }
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            if (iWebContext.getCurLoginName().indexOf("@softanywhere.com") == -1 && StringHelper.compare((String)iWebContext.getCurLoginName(), (String)"liuzhi", (boolean)true) != 0) {
                throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u7cfb\u7edf"));
            }
            iPSSysDevUser = pSSysDevUserUserGlobal.getPSSysDevUser(string2);
            if (iPSSysDevUser != null) {
                if (iPSSysDevUser == PSSysDevUser.ACCESSDENY) {
                    throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u7cfb\u7edf"));
                }
                return iPSSysDevUser;
            }
            PSSysDevUser pSSysDevUser = new PSSysDevUser();
            pSSysDevUser.setAccMode(3);
            pSSysDevUser.setPSSystemId(string2);
            pSSysDevUser.setPSDevUserId(iWebContext.getCurUserId());
            pSSysDevUserUserGlobal.registerPSSysDevUser(string2, pSSysDevUser);
            return pSSysDevUser;
        }
        return null;
    }

    public static IPSSysDevUser getPSSysDevUser(IWebContext iWebContext, String string) throws Exception {
        return PSSysDevUserUserGlobal.getPSSysDevUserBySln(iWebContext, string);
    }

    public static IPSSysDevUser getPSSysDevUserBySys(IWebContext iWebContext, String string) throws Exception {
        return PSSysDevUserUserGlobal.getPSSysDevUser(iWebContext, string, null);
    }

    public static IPSSysDevUser getPSSysDevUserBySln(IWebContext iWebContext, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)iWebContext.getCurUserId()) && !PSCoreSysModel.isShareSysMode()) {
            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u8fd8\u672a\u767b\u5f55"));
        }
        IPSSysDevUser iPSSysDevUser = null;
        PSSysDevUserUserGlobal pSSysDevUserUserGlobal = PSSysDevUserUserGlobal.getCurrent(iWebContext);
        String string2 = StringHelper.format((String)"DEVSLN:%1$s", (Object)string);
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            Serializable serializable;
            iPSSysDevUser = pSSysDevUserUserGlobal.getPSSysDevUser(string2);
            if (iPSSysDevUser != null) {
                if (iPSSysDevUser == PSSysDevUser.ACCESSDENY) {
                    throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u65b9\u6848"));
                }
                if (iPSSysDevUser.isExpired()) {
                    throw new ErrorException(2, StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848\u5df2\u8fc7\u671f"));
                }
                return iPSSysDevUser;
            }
            PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class);
            PSDevSln pSDevSln = new PSDevSln();
            pSDevSln.setPSDevSlnId(string);
            pSDevSlnService.get((IEntity)pSDevSln);
            Timestamp timestamp = null;
            int n = 5;
            if (!PSCoreSysModel.isShareSysMode()) {
                n = 0;
                if (StringHelper.compare((String)pSDevSln.getAdminPSDevUserId(), (String)iWebContext.getCurUserId(), (boolean)true) == 0) {
                    n = 19;
                } else {
                    serializable = PSSysDevUserUserGlobal.getPSDevUserAccMode(string, 1, null, (Object)pSDevSln, iWebContext);
                    if (serializable == null) {
                        pSSysDevUserUserGlobal.registerPSSysDevUser(string2, PSSysDevUser.ACCESSDENY);
                        throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u65b9\u6848"));
                    }
                    n = (Integer)serializable;
                }
            }
            serializable = new PSSysDevUser();
            ((PSSysDevUser)serializable).setAccMode(n);
            ((PSSysDevUser)serializable).setPSDevSlnSysId(string2);
            ((PSSysDevUser)serializable).setPSDevSlnId(string);
            ((PSDevUserBase)serializable).setPSDevUserId(iWebContext.getCurUserId());
            ((PSDevUserBase)serializable).setExpiredTime(timestamp);
            pSSysDevUserUserGlobal.registerPSSysDevUser(string2, (IPSSysDevUser)serializable);
            if (((PSDevUserBase)serializable).isExpired()) {
                throw new ErrorException(2, StringHelper.format((String)"\u5f00\u53d1\u65b9\u6848\u5df2\u8fc7\u671f"));
            }
            return serializable;
        }
        return null;
    }

    public static IPSSysDevUser getPSSysDevUserByTempl(IWebContext iWebContext, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)iWebContext.getCurUserId()) && !PSCoreSysModel.isShareSysMode()) {
            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u8fd8\u672a\u767b\u5f55"));
        }
        IPSSysDevUser iPSSysDevUser = null;
        PSSysDevUserUserGlobal pSSysDevUserUserGlobal = PSSysDevUserUserGlobal.getCurrent(iWebContext);
        String string2 = StringHelper.format((String)"DEVTEMPL:%1$s", (Object)string);
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            Serializable serializable;
            iPSSysDevUser = pSSysDevUserUserGlobal.getPSSysDevUser(string2);
            if (iPSSysDevUser != null) {
                if (iPSSysDevUser == PSSysDevUser.ACCESSDENY) {
                    throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u6a21\u677f"));
                }
                if (iPSSysDevUser.isExpired()) {
                    throw new ErrorException(2, StringHelper.format((String)"\u5f00\u53d1\u6a21\u677f\u5df2\u8fc7\u671f"));
                }
                return iPSSysDevUser;
            }
            PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class);
            PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
            pSDevSlnTempl.setPSDevSlnTemplId(string);
            pSDevSlnTemplService.get((IEntity)pSDevSlnTempl);
            Timestamp timestamp = null;
            int n = 5;
            if (!PSCoreSysModel.isShareSysMode()) {
                n = 0;
                serializable = pSDevSlnTempl.getPSDevSln();
                if (StringHelper.compare((String)((PSDevSlnBase)serializable).getAdminPSDevUserId(), (String)iWebContext.getCurUserId(), (boolean)true) == 0) {
                    n = 19;
                } else {
                    Integer n2 = PSSysDevUserUserGlobal.getPSDevUserAccMode(pSDevSlnTempl.getPSDevSlnId(), 2, pSDevSlnTempl.getPSDevSlnTemplId(), (Object)pSDevSlnTempl, iWebContext);
                    if (n2 == null) {
                        pSSysDevUserUserGlobal.registerPSSysDevUser(string2, PSSysDevUser.ACCESSDENY);
                        throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u6a21\u677f"));
                    }
                    n = n2;
                }
            }
            serializable = new PSSysDevUser();
            ((PSSysDevUser)serializable).setAccMode(n);
            ((PSSysDevUser)serializable).setPSDevSlnSysId(string2);
            ((PSSysDevUser)serializable).setPSDevSlnTemplId(pSDevSlnTempl.getPSDevSlnTemplId());
            ((PSDevUserBase)serializable).setPSDevUserId(iWebContext.getCurUserId());
            ((PSDevUserBase)serializable).setExpiredTime(timestamp);
            pSSysDevUserUserGlobal.registerPSSysDevUser(string2, (IPSSysDevUser)serializable);
            if (((PSDevUserBase)serializable).isExpired()) {
                throw new ErrorException(2, StringHelper.format((String)"\u5f00\u53d1\u6a21\u677f\u5df2\u8fc7\u671f"));
            }
            return serializable;
        }
        return null;
    }

    public static IPSSysDevUser getPSSysDevUserByDynaInst(IWebContext iWebContext, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)iWebContext.getCurUserId()) && !PSCoreSysModel.isShareSysMode()) {
            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u8fd8\u672a\u767b\u5f55"));
        }
        IPSSysDevUser iPSSysDevUser = null;
        PSSysDevUserUserGlobal pSSysDevUserUserGlobal = PSSysDevUserUserGlobal.getCurrent(iWebContext);
        String string2 = StringHelper.format((String)"DYNAINST:%1$s", (Object)string);
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            Object object;
            iPSSysDevUser = pSSysDevUserUserGlobal.getPSSysDevUser(string2);
            if (iPSSysDevUser != null) {
                if (iPSSysDevUser == PSSysDevUser.ACCESSDENY) {
                    throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b"));
                }
                if (iPSSysDevUser.isExpired()) {
                    throw new ErrorException(2, StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u5df2\u8fc7\u671f"));
                }
                return iPSSysDevUser;
            }
            PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class);
            PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
            pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(string);
            pSDevSlnSysDynaInstService.get((IEntity)pSDevSlnSysDynaInst);
            Timestamp timestamp = null;
            int n = 5;
            if (!PSCoreSysModel.isShareSysMode()) {
                object = pSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId();
                if (StringHelper.isNullOrEmpty((String)object)) {
                    object = pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId();
                }
                n = 0;
                PSDevSln pSDevSln = pSDevSlnSysDynaInst.getPSDevSln();
                if (pSDevSln != null) {
                    if (StringHelper.compare((String)pSDevSln.getAdminPSDevUserId(), (String)iWebContext.getCurUserId(), (boolean)true) == 0) {
                        n = 19;
                    } else {
                        Integer n2 = PSSysDevUserUserGlobal.getPSDevUserAccMode(pSDevSlnSysDynaInst.getPSDevSlnId(), 3, (String)object, (Object)pSDevSlnSysDynaInst, iWebContext);
                        if (n2 == null) {
                            pSSysDevUserUserGlobal.registerPSSysDevUser(string2, PSSysDevUser.ACCESSDENY);
                            throw new ErrorException(2, StringHelper.format((String)"\u5f53\u524d\u7528\u6237\u65e0\u6cd5\u8bbf\u95ee\u6307\u5b9a\u52a8\u6001\u5b9e\u4f8b"));
                        }
                        n = n2;
                    }
                }
            }
            object = new PSSysDevUser();
            ((PSSysDevUser)object).setAccMode(n);
            ((PSSysDevUser)object).setPSDevSlnSysId(string2);
            ((PSSysDevUser)object).setPSDevSlnTemplId(pSDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            ((PSDevUserBase)object).setPSDevUserId(iWebContext.getCurUserId());
            ((PSDevUserBase)object).setExpiredTime(timestamp);
            pSSysDevUserUserGlobal.registerPSSysDevUser(string2, (IPSSysDevUser)object);
            if (((PSDevUserBase)object).isExpired()) {
                throw new ErrorException(2, StringHelper.format((String)"\u52a8\u6001\u5b9e\u4f8b\u5df2\u8fc7\u671f"));
            }
            return object;
        }
        return null;
    }

    protected static Integer getPSDevUserAccMode(String string, int n, String string2, Object object, IWebContext iWebContext) throws Exception {
        Integer n2;
        PSDevSln pSDevSln = null;
        PSDevSlnSys pSDevSlnSys = null;
        PSDevSlnTempl pSDevSlnTempl = null;
        PSDevSlnSysDynaInst pSDevSlnSysDynaInst = null;
        String string3 = null;
        if (n == 1) {
            if (object instanceof PSDevSln) {
                pSDevSln = (PSDevSln)object;
                string3 = pSDevSln.getPSDevCenterId();
            }
        } else if (n == 0) {
            if (object instanceof PSDevSlnSys) {
                pSDevSlnSys = (PSDevSlnSys)object;
                string3 = pSDevSlnSys.getPSDevCenterId();
            }
        } else if (n == 2) {
            if (object instanceof PSDevSlnTempl) {
                pSDevSlnTempl = (PSDevSlnTempl)object;
                string3 = pSDevSlnTempl.getPSDevCenterId();
            }
        } else if (n == 3 && object instanceof PSDevSlnSysDynaInst) {
            pSDevSlnSysDynaInst = (PSDevSlnSysDynaInst)object;
            string3 = pSDevSlnSysDynaInst.getPSDevCenterId();
        }
        if ((n2 = PSSysDevUserUserGlobal.getPSDevUserAccMode(string, n, string2, object, iWebContext.getCurUserId())) != null) {
            return n2;
        }
        if (StringHelper.compare((String)string3, (String)iWebContext.getCurOrgId(), (boolean)false) != 0) {
            PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class);
            PSDevUser pSDevUser = new PSDevUser();
            pSDevUser.setPSDevCenterId(string3);
            pSDevUser.setFromPSDevUserId(iWebContext.getCurUserId());
            pSDevUser.setFromUserMode(1);
            pSDevUser.setValidFlag(1);
            if (pSDevUserService.select(pSDevUser, true)) {
                n2 = PSSysDevUserUserGlobal.getPSDevUserAccMode(string, n, string2, object, pSDevUser.getPSDevUserId());
            }
        }
        return n2;
    }

    protected static Integer getPSDevUserAccMode(String string, int n, String string2, Object object, String string3) throws Exception {
        Integer n2 = null;
        PSDevSlnUserService pSDevSlnUserService = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class);
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEVSLNID", (Object)string);
        selectCond.set("PSDEVUSEROBJID", (Object)string3);
        ArrayList arrayList = pSDevSlnUserService.select((ISelectCond)selectCond);
        if (arrayList.size() > 0) {
            for (PSDevSlnUser pSDevSlnUser : arrayList) {
                if (pSDevSlnUser.getExpiredTime() != null && pSDevSlnUser.getExpiredTime().getTime() < System.currentTimeMillis() || pSDevSlnUser.getAllSysFlag() == null || pSDevSlnUser.getAccMode() == null) continue;
                if (n == 1) {
                    if (pSDevSlnUser.getAllSysFlag() == 1) {
                        return pSDevSlnUser.getAccMode();
                    }
                    if (n2 != null && 1 <= n2) continue;
                    n2 = 1;
                    continue;
                }
                if (n == 0) {
                    if (pSDevSlnUser.getAllSysFlag() == 1) {
                        if (n2 != null && pSDevSlnUser.getAccMode() <= n2) continue;
                        n2 = pSDevSlnUser.getAccMode();
                        continue;
                    }
                    if (pSDevSlnUser.getAllSysFlag() != 0 || StringHelper.compare((String)pSDevSlnUser.getPSDevSlnSysId(), (String)string2, (boolean)false) != 0) continue;
                    return pSDevSlnUser.getAccMode();
                }
                if (n == 2) {
                    if (pSDevSlnUser.getAllSysFlag() == 1) {
                        if (n2 != null && pSDevSlnUser.getAccMode() <= n2) continue;
                        n2 = pSDevSlnUser.getAccMode();
                        continue;
                    }
                    if (pSDevSlnUser.getAllSysFlag() != 2 || StringHelper.compare((String)pSDevSlnUser.getPSDevSlnTemplId(), (String)string2, (boolean)false) != 0) continue;
                    return pSDevSlnUser.getAccMode();
                }
                if (n != 3) continue;
                if (pSDevSlnUser.getAllSysFlag() == 1) {
                    if (n2 != null && pSDevSlnUser.getAccMode() <= n2) continue;
                    n2 = pSDevSlnUser.getAccMode();
                    continue;
                }
                if (pSDevSlnUser.getAllSysFlag() != 3 || StringHelper.compare((String)pSDevSlnUser.getPSDevSlnSysDynaInstId(), (String)string2, (boolean)false) != 0) continue;
                return pSDevSlnUser.getAccMode();
            }
        }
        return n2;
    }
}

