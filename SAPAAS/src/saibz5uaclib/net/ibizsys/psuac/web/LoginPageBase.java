/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.Page
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.psrt.srv.common.entity.LoginAccount
 *  net.ibizsys.psrt.srv.common.entity.OrgUser
 *  net.ibizsys.psrt.srv.common.service.LoginAccountService
 *  net.ibizsys.psrt.srv.common.service.OrgUserService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psuac.web;

import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.Page;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.OrgUser;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.OrgUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class LoginPageBase
extends Page {
    private static final Log log = LogFactory.getLog(LoginPageBase.class);

    protected CallResult loginUserName(String strUserName) throws Exception {
        CallResult callResult = new CallResult();
        try {
            LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class);
            LoginAccount loginAccount = new LoginAccount();
            loginAccount.setLoginAccountName(strUserName.toLowerCase());
            if (loginAccountService.select((IEntity)loginAccount, true)) {
                WebContext.fillByLoginAccount((IWebContext)this.getWebContext(), (LoginAccount)loginAccount);
            }
            OrgUserService orgUserService = (OrgUserService)ServiceGlobal.getService(OrgUserService.class);
            OrgUser orgUser = new OrgUser();
            orgUser.setOrgUserId(loginAccount.getUserId());
            if (orgUserService.get((IEntity)orgUser, true)) {
                WebContext.fillByOrgUser((IWebContext)this.getWebContext(), (OrgUser)orgUser);
            }
            this.getWebContext().login(strUserName);
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }
}

