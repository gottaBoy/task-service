/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.SDAjaxActionResult;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.OrgUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoginServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(LoginServlet.class);
    private static final String ACTION_GETCURUSERINFO = "getcuruserinfo";

    @Override
    protected AjaxActionResult onProcessAction() throws Exception {
        String strAction = WebContext.getAction(this.getWebContext());
        if (StringHelper.compare(strAction, ACTION_GETCURUSERINFO, true) == 0) {
            return this.getCurUserInfo(this.getWebContext());
        }
        return this.doLogin(this.getWebContext());
    }

    protected AjaxActionResult doLogin(IWebContext webContext) {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        String strLoginName = this.getWebContext().getPostValue("loginname");
        String strPassword = this.getWebContext().getPostValue("pwd");
        if (!StringHelper.isNullOrEmpty(strLoginName)) {
            strLoginName = strLoginName.trim();
        }
        if (!StringHelper.isNullOrEmpty(strPassword)) {
            strPassword = strPassword.trim();
        }
        if (StringHelper.isNullOrEmpty(strLoginName)) {
            ajaxActionResult.setRetCode(5);
            ajaxActionResult.setErrorInfo("\u767b\u5f55\u5e10\u6237\u4e0d\u80fd\u4e3a\u7a7a");
            return ajaxActionResult;
        }
        if (StringHelper.isNullOrEmpty(strPassword)) {
            ajaxActionResult.setRetCode(5);
            ajaxActionResult.setErrorInfo("\u767b\u5f55\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a");
            return ajaxActionResult;
        }
        try {
            LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class);
            LoginAccount loginAccount = new LoginAccount();
            loginAccount.setLoginAccountName(strLoginName.toLowerCase());
            if (!loginAccountService.select(loginAccount, true)) {
                ajaxActionResult.setRetCode(3);
                ajaxActionResult.setErrorInfo("\u767b\u5f55\u5e10\u6237\u6216\u5bc6\u7801\u4e0d\u6b63\u786e");
                return ajaxActionResult;
            }
            String strPassword2 = KeyValueHelper.genUniqueId(strLoginName.toLowerCase(), strPassword);
            if (StringHelper.compare(strPassword2, loginAccount.getPwd(), false) != 0) {
                ajaxActionResult.setRetCode(3);
                ajaxActionResult.setErrorInfo("\u767b\u5f55\u5e10\u6237\u6216\u5bc6\u7801\u4e0d\u6b63\u786e");
                return ajaxActionResult;
            }
            this.getWebContext().logout(true);
            WebContext.fillByLoginAccount(this.getWebContext(), loginAccount);
            OrgUser orgUser = new OrgUser();
            orgUser.setOrgUserId(loginAccount.getUserId());
            OrgUserService orgUserService = (OrgUserService)ServiceGlobal.getService(OrgUserService.class);
            if (orgUserService.get(orgUser, true)) {
                WebContext.fillByOrgUser(this.getWebContext(), orgUser);
            }
            this.getWebContext().login(strLoginName);
            return ajaxActionResult;
        }
        catch (Exception ex) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            log.error((Object)ex);
            return ajaxActionResult;
        }
    }

    protected AjaxActionResult getCurUserInfo(IWebContext webContext) {
        SDAjaxActionResult sdAjaxActionResult = new SDAjaxActionResult();
        if (!StringHelper.isNullOrEmpty(webContext.getCurUserId())) {
            JSONObject data = sdAjaxActionResult.getData(true);
            data.put("userid", JSONObjectHelper.stripQuotes(webContext.getCurUserId(), true));
            data.put("username", JSONObjectHelper.stripQuotes(webContext.getCurUserName(), true));
            data.put("loginname", JSONObjectHelper.stripQuotes(webContext.getCurLoginName(), true));
            data.put("localization", JSONObjectHelper.stripQuotes(webContext.getLocalization(), true));
            data.put("curusericonpath", JSONObjectHelper.stripQuotes(webContext.getCurUserIconPath(), true));
            data.put("orgid", JSONObjectHelper.stripQuotes(webContext.getCurOrgId(), true));
            data.put("orgname", JSONObjectHelper.stripQuotes(webContext.getCurOrgName(), true));
            data.put("orgsectorid", JSONObjectHelper.stripQuotes(webContext.getCurOrgSectorId(), true));
            data.put("orgsectorname", JSONObjectHelper.stripQuotes(webContext.getCurOrgSectorName(), true));
            data.put("orgsectorbc", JSONObjectHelper.stripQuotes(webContext.getCurOrgSectorBC(), true));
        } else {
            sdAjaxActionResult.setRetCode(3);
            sdAjaxActionResult.setErrorInfo("\u65e0\u7528\u6237\u8eab\u4efd\u4fe1\u606f\uff01");
        }
        return sdAjaxActionResult;
    }
}

