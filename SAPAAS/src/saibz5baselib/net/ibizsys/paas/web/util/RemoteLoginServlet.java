/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import java.sql.Timestamp;
import java.util.HashMap;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.security.RemoteLoginGlobal;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.SDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.LoginLog;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.LoginLogService;
import net.ibizsys.psrt.srv.common.service.OrgUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RemoteLoginServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(RemoteLoginServlet.class);
    private HashMap<String, Integer> loginFaildMap = new HashMap();
    private HashMap<String, Long> loginFaildTimeMap = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected int getLoginFailedCount(String strLoginName, String strRemoteAddr) {
        HashMap<String, Integer> hashMap = this.loginFaildMap;
        synchronized (hashMap) {
            Integer nCount;
            block6: {
                block5: {
                    nCount = this.loginFaildMap.get(strRemoteAddr);
                    if (nCount != null) break block5;
                    return 0;
                }
                if (nCount < 3) break block6;
                long nLastTime = this.loginFaildTimeMap.get(strRemoteAddr);
                if (System.currentTimeMillis() - nLastTime < 60000L) break block6;
                this.loginFaildTimeMap.remove(strRemoteAddr);
                this.loginFaildMap.remove(strRemoteAddr);
                return 0;
            }
            return nCount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected int addLoginFailedCount(String strLoginName, String strRemoteAddr) {
        HashMap<String, Integer> hashMap = this.loginFaildMap;
        synchronized (hashMap) {
            Integer nCount = this.loginFaildMap.get(strRemoteAddr);
            if (nCount == null) {
                nCount = 0;
            }
            nCount = nCount + 1;
            this.loginFaildMap.put(strRemoteAddr, nCount);
            this.loginFaildTimeMap.put(strRemoteAddr, System.currentTimeMillis());
            return nCount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void resetLoginFailedCount(String strLoginName, String strRemoteAddr) {
        HashMap<String, Integer> hashMap = this.loginFaildMap;
        synchronized (hashMap) {
            this.loginFaildMap.remove(strRemoteAddr);
            this.loginFaildTimeMap.remove(strRemoteAddr);
        }
    }

    @Override
    protected AjaxActionResult onProcessAction() throws Exception {
        SDAjaxActionResult ajaxActionResult = new SDAjaxActionResult();
        String strLoginName = this.getWebContext().getPostOrParamValue("username");
        String strPassword = this.getWebContext().getPostOrParamValue("password");
        String strRemoteAddr = this.getWebContext().getRemoteAddr();
        try {
            int nFailedCount = this.getLoginFailedCount(strLoginName, strRemoteAddr);
            if (nFailedCount >= 3) {
                ajaxActionResult.setRetCode(2);
                ajaxActionResult.setErrorInfo("\u767b\u5f55\u5931\u8d25\u6b21\u6570\u8d85\u8fc73\u6b21\uff0c\u4e34\u65f6\u9650\u5236\u767b\u5f5560\u79d2");
                return ajaxActionResult;
            }
            if (StringHelper.isNullOrEmpty(strLoginName)) {
                ajaxActionResult.setRetCode(5);
                ajaxActionResult.setErrorInfo("\u767b\u5f55\u5e10\u6237\u6216\u5bc6\u7801\u4e0d\u6b63\u786e\uff0c\u6e05\u91cd\u65b0\u8f93\u5165");
                return ajaxActionResult;
            }
            LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class);
            LoginAccount loginAccount = new LoginAccount();
            loginAccount.setLoginAccountName(strLoginName.toLowerCase());
            if (!loginAccountService.select(loginAccount, true)) {
                ajaxActionResult.setRetCode(5);
                ajaxActionResult.setErrorInfo("\u767b\u5f55\u5e10\u6237\u6216\u5bc6\u7801\u4e0d\u6b63\u786e\uff0c\u6e05\u91cd\u65b0\u8f93\u5165");
                this.addLoginFailedCount(strLoginName, strRemoteAddr);
                return ajaxActionResult;
            }
            String strPassword2 = KeyValueHelper.genUniqueId(strLoginName.toLowerCase(), strPassword);
            if (StringHelper.compare(strPassword2, loginAccount.getPwd(), false) != 0) {
                ajaxActionResult.setRetCode(5);
                ajaxActionResult.setErrorInfo("\u767b\u5f55\u5e10\u6237\u6216\u5bc6\u7801\u4e0d\u6b63\u786e\uff0c\u6e05\u91cd\u65b0\u8f93\u5165");
                this.addLoginFailedCount(strLoginName, strRemoteAddr);
                return ajaxActionResult;
            }
            this.resetLoginFailedCount(strLoginName, strRemoteAddr);
            LoginLog loginLog = new LoginLog();
            loginLog.setIpAddress(strRemoteAddr);
            loginLog.setLoginAccountId(loginAccount.getLoginAccountId());
            loginLog.setLoginAccountName(loginAccount.getLoginAccountName());
            loginLog.setLoginLogName(loginAccount.getLoginAccountName());
            loginLog.setLoginTime(new Timestamp(System.currentTimeMillis()));
            loginLog.setIpAddress(strRemoteAddr);
            loginLog.setUserAgent(this.getWebContext().getUserAgent());
            LoginLogService loginLogService = (LoginLogService)ServiceGlobal.getService(LoginLogService.class);
            loginLogService.create(loginLog);
            loginLog.set("userid", loginAccount.getUserId());
            loginLog.set("username", loginAccount.getUserName());
            JSONObject data = ajaxActionResult.getData(true);
            data.put("loginkey", JSONObjectHelper.stripQuotes(loginLog.getLoginLogId(), true));
            data.put("userid", JSONObjectHelper.stripQuotes(loginAccount.getUserId(), true));
            data.put("username", JSONObjectHelper.stripQuotes(loginAccount.getUserName(), true));
            data.put("usermode", (Object)"");
            data.put("loginname", JSONObjectHelper.stripQuotes(strLoginName, true));
            data.put("language", JSONObjectHelper.stripQuotes(loginAccount.getLanguage(), true));
            if (DataObject.getBoolValue(loginAccount.getSuperUser(), false)) {
                loginLog.set("SRFSUPERUSER", "1");
            } else {
                loginLog.set("SRFSUPERUSER", "0");
            }
            if (DataObject.getBoolValue(loginAccount.getOrgAdmin(), false)) {
                loginLog.set("SRFORGADMIN", "1");
            } else {
                loginLog.set("SRFORGADMIN", "0");
            }
            RemoteLoginGlobal.setUserLoginLog(loginAccount.getUserId(), loginLog);
            WebContext.fillByLoginAccount(this.getWebContext(), loginAccount);
            OrgUserService orgUserService = (OrgUserService)ServiceGlobal.getService(OrgUserService.class);
            OrgUser orgUser = new OrgUser();
            orgUser.setOrgUserId(loginAccount.getUserId());
            if (orgUserService.get(orgUser, true)) {
                WebContext.fillByOrgUser(this.getWebContext(), orgUser);
            }
            this.getWebContext().login(strLoginName);
            return ajaxActionResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format("\u5904\u7406\u8fdc\u7a0b\u767b\u5f55\u53d1\u751f\u5f02\u5e38\uff0c%1$s", ex.getMessage()), (Throwable)ex);
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo("\u7cfb\u7edf\u5185\u90e8\u53d1\u751f\u9519\u8bef");
            return ajaxActionResult;
        }
    }
}

