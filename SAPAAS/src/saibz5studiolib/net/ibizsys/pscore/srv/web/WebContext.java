/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.security.IUserPrivilegeMgr
 *  net.ibizsys.paas.security.IUserRoleMgr
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.common.entity.LoginAccount
 *  net.ibizsys.psrt.srv.common.service.LoginAccountService
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.security.IUserPrivilegeMgr;
import net.ibizsys.paas.security.IUserRoleMgr;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DCLevelCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterLog;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.ibizsys.pscore.srv.util.IPSDevUser;
import net.ibizsys.pscore.srv.util.IPSDevUserBase;
import net.ibizsys.pscore.srv.util.IPSSysDevUser;
import net.ibizsys.pscore.srv.util.PSDevCenterHelper;
import net.ibizsys.pscore.srv.util.PSDevCenterLogger;
import net.ibizsys.pscore.srv.util.PSDevUser;
import net.ibizsys.pscore.srv.util.PSDevUserUserGlobal;
import net.ibizsys.pscore.srv.util.PSStudioGlobal;
import net.ibizsys.pscore.srv.util.PSStudioUserLog;
import net.ibizsys.pscore.srv.util.PSSysDevUserUserGlobal;
import net.ibizsys.pscore.srv.web.UserPrivilegeMgr;
import net.ibizsys.pscore.srv.web.UserRoleMgr;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class WebContext
extends net.ibizsys.paas.web.WebContext {
    public static final String USERPRIVILEGEMGRS = "SRFUSERPRIVILEGEMGRS";
    private static final Log log = LogFactory.getLog(WebContext.class);
    public static final String PSDCINSTID = "PSDCINSTID";
    public static final String PSDCADMIN = "PSDCADMIN";
    public static final String PSDCTYPE = "PSDCTYPE";
    public static final String PSDCLEVEL = "PSDCLEVEL";
    public static final String PSSTUDIOVER = "PSSTUDIOVER";
    public static final String PSSTUDIOTAG = "PSSTUDIOTAG";
    public static final String PSSTUDIOTAG2 = "PSSTUDIOTAG2";
    private Map<String, Object> tempSessionValueMap = null;

    public void login(String string) throws Exception {
        this.logout(false);
        PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("FULLLOGINNAME", (Object)string);
        selectCond.set("VALIDFLAG", (Object)1);
        selectCond.setFetchFirst(true);
        ArrayList arrayList = pSDevUserService.select((ISelectCond)selectCond);
        if (arrayList == null || arrayList.size() == 0) {
            if (string.indexOf("@") == -1) {
                LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                LoginAccount loginAccount = new LoginAccount();
                loginAccount.setLoginAccountName(string);
                loginAccount.setIsEnable(Integer.valueOf(1));
                if (loginAccountService.select(loginAccount, true)) {
                    this.setSessionValue("SRFPERSONID", loginAccount.getLoginAccountId());
                    this.setSessionValue("SRFUSERID", loginAccount.getLoginAccountId());
                    this.setSessionValue("SRFUSERNAME", loginAccount.getLoginAccountName());
                    this.setSessionValue("SRFUESRNAME", loginAccount.getLoginAccountName());
                    this.setSessionValue("SRFLOGINNAME", string);
                    this.setSessionValue("SRFORGID", loginAccount.getLoginAccountId());
                    return;
                }
                boolean bl = WebConfig.getCurrent().getAttribute("PAASMGRLOGIN", false);
                if (bl) {
                    this.setSessionValue("SRFPERSONID", "SYSTEM");
                    this.setSessionValue("SRFUSERNAME", "\u7ba1\u7406\u5458");
                    this.setSessionValue("SRFORGADMIN", "1");
                    this.setSessionValue("SRFSUPERUSER", "1");
                    this.setSessionValue(PSDCTYPE, "DEVCENTER");
                    this.setSessionValue(PSDCLEVEL, DCLevelCodeListModel.ENTERPRISE);
                    return;
                }
            }
            throw new Exception("\u65e0\u6548\u7684\u7528\u6237\u8eab\u4efd");
        }
        net.ibizsys.pscore.srv.devcenter.entity.PSDevUser pSDevUser = (net.ibizsys.pscore.srv.devcenter.entity.PSDevUser)arrayList.get(0);
        super.login(string);
        this.setSessionValue("SRFPERSONID", pSDevUser.getPSDevUserId());
        this.setSessionValue("SRFUSERID", pSDevUser.getPSDevUserId());
        this.setSessionValue("SRFUSERNAME", pSDevUser.getPSDevUserName());
        this.setSessionValue("SRFORGID", pSDevUser.getPSDevCenterId());
        this.setSessionValue("SRFORGNAME", pSDevUser.getPSDevCenterName());
        this.setSessionValue("psdevcenterid", pSDevUser.getPSDevCenterId());
        this.setSessionValue("psdevcentername", pSDevUser.getPSDevCenterName());
        PSDevUser pSDevUser2 = new PSDevUser();
        pSDevUser2.setPSDevUserId(pSDevUser.getPSDevUserId());
        pSDevUser2.setPSDevUserName(pSDevUser.getPSDevUserName());
        pSDevUser2.setPSDevCenterId(pSDevUser.getPSDevCenterId());
        pSDevUser2.setPSDevCenterName(pSDevUser.getPSDevCenterName());
        pSDevUser2.setDefaultMode(true);
        PSDevCenter pSDevCenter = pSDevUser.getPSDevCenter();
        if (!StringHelper.isNullOrEmpty((String)pSDevCenter.getPSDCInstId())) {
            this.setSessionValue(PSDCINSTID, pSDevCenter.getPSDCInstId());
            pSDevUser2.setPSDCInstId(pSDevCenter.getPSDCInstId());
        }
        Integer n = DataObject.getIntegerValue((Object)pSDevCenter.getDCLevel(), (Integer)DCLevelCodeListModel.PROFESSIONAL);
        String string2 = DataObject.getStringValue((Object)pSDevCenter.getDCType(), (String)"DEVCENTER");
        this.setSessionValue(PSDCTYPE, string2);
        this.setSessionValue(PSDCLEVEL, n);
        this.setSessionValue(PSSTUDIOVER, pSDevCenter.getStudioVer());
        this.setSessionValue(PSSTUDIOTAG, pSDevCenter.getStudioTag());
        this.setSessionValue(PSSTUDIOTAG2, pSDevCenter.getStudioTag2());
        pSDevUser2.setPSDCType(string2);
        pSDevUser2.setPSDCLevel(n);
        pSDevUser2.setStudioVer(pSDevCenter.getStudioVer());
        pSDevUser2.setStudioTag(pSDevCenter.getStudioTag());
        pSDevUser2.setStudioTag2(pSDevCenter.getStudioTag2());
        if ((PSDevCenterHelper.isLabDC(pSDevCenter) || n >= DCLevelCodeListModel.PROFESSIONAL) && DataObject.getBoolValue((Integer)pSDevUser.getAdminMode(), (boolean)false)) {
            this.setSessionValue("SRFORGADMIN", "1");
            this.setSessionValue(PSDCADMIN, 1);
            pSDevUser2.setAdminMode(true);
        }
        PSDevUserUserGlobal.getCurrent((IWebContext)this).registerPSDevUser(pSDevUser.getPSDevCenterId(), pSDevUser2);
        PSStudioGlobal.getCurrent().logUserAction((IWebContext)this, PSStudioUserLog.USERACTION_LOGIN, null);
        PSDevCenterLog pSDevCenterLog = new PSDevCenterLog();
        pSDevCenterLog.setPSDevCenterId(pSDevUser.getPSDevCenterId());
        pSDevCenterLog.setLogType("USERLOGIN");
        pSDevCenterLog.setLogLevel2(20000);
        pSDevCenterLog.setLogLevel("INFO");
        pSDevCenterLog.setPSDevCenterLogName(pSDevUser.getPSDevUserName());
        pSDevCenterLog.setRemoteAddr(this.getRemoteAddr());
        PSDevCenterLogger.log(pSDevCenterLog, pSDevCenter.getPSDCInstId());
        try {
            CallResult callResult = PSStudioGlobal.getCurrent().loginUser((IWebContext)this);
            if (callResult.isError()) {
                throw new Exception(callResult.getErrorInfo());
            }
        }
        catch (Exception exception) {
            log.error((Object)exception.getMessage(), (Throwable)exception);
            this.logout(true);
            throw exception;
        }
    }

    public void logout(boolean bl) {
        if (!StringHelper.isNullOrEmpty((String)this.getCurOrgId()) && !StringHelper.isNullOrEmpty((String)this.getCurUserId())) {
            try {
                CallResult callResult = PSStudioGlobal.getCurrent().logoutUser((IWebContext)this);
                if (callResult.isError()) {
                    throw new Exception(callResult.getErrorInfo());
                }
            }
            catch (Exception exception) {
                log.error((Object)exception.getMessage(), (Throwable)exception);
            }
        }
        PSStudioGlobal.getCurrent().logUserAction((IWebContext)this, PSStudioUserLog.USERACTION_LOGOUT, null);
        PSSysDevUserUserGlobal.resetCurrent((IWebContext)this);
        PSDevUserUserGlobal.resetCurrent((IWebContext)this);
        this.setSessionValue(PSDCADMIN, null);
        this.setSessionValue("SRFPERSONID", null);
        this.setSessionValue("SRFUSERID", null);
        this.setSessionValue("SRFUSERNAME", null);
        this.setSessionValue("SRFORGID", null);
        this.setSessionValue("SRFORGNAME", null);
        this.setSessionValue(USERPRIVILEGEMGRS, null);
        this.setSessionValue(PSDCTYPE, null);
        this.setSessionValue(PSDCLEVEL, null);
        this.setSessionValue(PSSTUDIOVER, null);
        this.setSessionValue(PSSTUDIOTAG, null);
        this.setSessionValue(PSSTUDIOTAG2, null);
        super.logout(bl);
    }

    protected IUserPrivilegeMgr createUserPrivilegeMgr() throws Exception {
        return new UserPrivilegeMgr();
    }

    protected IUserRoleMgr createUserRoleMgr() throws Exception {
        UserRoleMgr userRoleMgr = new UserRoleMgr();
        userRoleMgr.init((IWebContext)this);
        return userRoleMgr;
    }

    public static boolean isDCAdmin(IWebContext iWebContext) throws Exception {
        return DataObject.getIntegerValue((Object)iWebContext.getSessionValue(PSDCADMIN), (Integer)0) == 1;
    }

    public boolean isEnableSessionShare() {
        return true;
    }

    public IUserPrivilegeMgr getUserPrivilegeMgr() throws Exception {
        Object object;
        JSONObject jSONObject = WebContext.getAppData();
        String string = null;
        if (jSONObject != null) {
            object = jSONObject.optString("psdevslnsysid");
            if (StringHelper.isNullOrEmpty((String)object)) {
                object = jSONObject.optString("pssystemid");
            }
            string = (String)object;
        }
        if (StringHelper.isNullOrEmpty(string)) {
            return super.getUserPrivilegeMgr();
        }
        object = null;
        HashMap<String, IUserPrivilegeMgr> hashMap = (HashMap<String, IUserPrivilegeMgr>)this.getSessionValue(USERPRIVILEGEMGRS, false);
        if (hashMap == null) {
            hashMap = new HashMap<String, IUserPrivilegeMgr>();
            object = hashMap;
            this.setSessionValue(USERPRIVILEGEMGRS, object, false);
        } else {
            object = hashMap;
        }
        IUserPrivilegeMgr iUserPrivilegeMgr = (IUserPrivilegeMgr)((HashMap)object).get(string);
        if (iUserPrivilegeMgr == null) {
            iUserPrivilegeMgr = this.createUserPrivilegeMgr();
            ((HashMap)object).put(string, iUserPrivilegeMgr);
        }
        return iUserPrivilegeMgr;
    }

    public static int getDCLevel(IWebContext iWebContext) throws Exception {
        return DataObject.getIntegerValue((Object)iWebContext.getSessionValue(PSDCLEVEL), (Integer)DCLevelCodeListModel.PROFESSIONAL);
    }

    public static String getDCType(IWebContext iWebContext) throws Exception {
        return DataObject.getStringValue((Object)iWebContext.getSessionValue(PSDCTYPE), (String)"DEVCENTER");
    }

    public Object getSessionValue(String string) {
        Object object = this.getTempSessionValue(string);
        if (object != null) {
            return object;
        }
        return super.getSessionValue(string);
    }

    public Object getSessionValue(String string, boolean bl) {
        Object object;
        if (!bl && (object = this.getTempSessionValue(string)) != null) {
            return object;
        }
        return super.getSessionValue(string, bl);
    }

    public void setTempSessionValue(String string, Object object) {
        if (this.tempSessionValueMap == null) {
            if (object == null) {
                return;
            }
            this.tempSessionValueMap = new HashMap<String, Object>();
        }
        if (object == null) {
            this.tempSessionValueMap.remove(string);
        } else {
            this.tempSessionValueMap.put(string, object);
        }
    }

    public Object getTempSessionValue(String string) {
        if (this.tempSessionValueMap == null) {
            return null;
        }
        return this.tempSessionValueMap.get(string);
    }

    public void resetTempSession() {
        this.tempSessionValueMap = null;
    }

    public void setTempSession(IPSDevUserBase iPSDevUserBase) {
        if (iPSDevUserBase instanceof IPSDevUser) {
            IPSDevUser iPSDevUser = (IPSDevUser)iPSDevUserBase;
            this.setTempSessionValue("SRFPERSONID", iPSDevUser.getPSDevUserId());
            this.setTempSessionValue("SRFUSERID", iPSDevUser.getPSDevUserId());
            if (!StringHelper.isNullOrEmpty((String)iPSDevUser.getPSDevUserName())) {
                this.setTempSessionValue("SRFUSERNAME", iPSDevUser.getPSDevUserName());
            }
            this.setTempSessionValue("SRFORGID", iPSDevUser.getPSDevCenterId());
            this.setTempSessionValue("SRFORGNAME", iPSDevUser.getPSDevCenterName());
            this.setTempSessionValue("psdevcenterid", iPSDevUser.getPSDevCenterId());
            this.setTempSessionValue("psdevcentername", iPSDevUser.getPSDevCenterName());
            this.setTempSessionValue(PSDCINSTID, iPSDevUser.getPSDCInstId());
            this.setTempSessionValue(PSDCTYPE, iPSDevUser.getPSDCType());
            this.setTempSessionValue(PSDCLEVEL, iPSDevUser.getPSDCLevel());
            if (iPSDevUser.isAdminMode()) {
                this.setTempSessionValue("SRFORGADMIN", "1");
                this.setTempSessionValue(PSDCADMIN, 1);
            } else {
                this.setTempSessionValue("SRFORGADMIN", "0");
                this.setTempSessionValue(PSDCADMIN, 0);
            }
            return;
        }
        if (iPSDevUserBase instanceof IPSSysDevUser) {
            IPSSysDevUser iPSSysDevUser = (IPSSysDevUser)iPSDevUserBase;
            if (iPSSysDevUser.isShareAccMode()) {
                return;
            }
            this.setTempSessionValue("SRFPERSONID", iPSSysDevUser.getPSDevUserId());
            this.setTempSessionValue("SRFUSERID", iPSSysDevUser.getPSDevUserId());
            if (!StringHelper.isNullOrEmpty((String)iPSSysDevUser.getPSDevUserName())) {
                this.setTempSessionValue("SRFUSERNAME", iPSSysDevUser.getPSDevUserName());
            }
            this.setTempSessionValue("SRFORGID", iPSSysDevUser.getPSDevCenterId());
            this.setTempSessionValue("SRFORGNAME", iPSSysDevUser.getPSDevCenterName());
            this.setTempSessionValue("psdevcenterid", iPSSysDevUser.getPSDevCenterId());
            this.setTempSessionValue("psdevcentername", iPSSysDevUser.getPSDevCenterName());
            this.setTempSessionValue("SRFORGADMIN", "0");
            this.setTempSessionValue(PSDCADMIN, 0);
            return;
        }
    }
}

