/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import java.util.ArrayList;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.util.LoginServlet;
import net.ibizsys.psrt.srv.common.entity.LoginAccount;
import net.ibizsys.psrt.srv.common.entity.User;
import net.ibizsys.psrt.srv.common.service.LoginAccountService;
import net.ibizsys.psrt.srv.common.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InitSystemEnvServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(LoginServlet.class);

    @Override
    protected AjaxActionResult onProcessAction() {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        try {
            UserService userService = (UserService)ServiceGlobal.getService(UserService.class);
            SelectCond selectCond = new SelectCond();
            selectCond.setFetchFirst(true);
            ArrayList userList = userService.select(selectCond);
            if (userList.size() > 0) {
                ajaxActionResult.setErrorInfo("\u7cfb\u7edf\u5df2\u521d\u59cb\u5316\uff01");
            } else {
                this.onInitSystemEnv();
                ajaxActionResult.setErrorInfo("\u7ba1\u7406\u5458\u8d26\u53f7\u5df2\u521b\u5efa\uff0c\u7cfb\u7edf\u521d\u59cb\u5316\u6210\u529f\uff01");
            }
            ajaxActionResult.setRetCode(0);
        }
        catch (Exception ex) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(ex.getMessage());
            log.error((Object)ex);
        }
        return ajaxActionResult;
    }

    protected void onInitSystemEnv() throws Exception {
        UserService userService = (UserService)ServiceGlobal.getService(UserService.class);
        LoginAccountService loginAccountService = (LoginAccountService)ServiceGlobal.getService(LoginAccountService.class);
        User user = new User();
        user.setUserName("\u7cfb\u7edf\u7ba1\u7406\u5458");
        user.setIsSystem(1);
        user.setValidFlag(1);
        user.setEnable(1);
        user.setMemo("\u7cfb\u7edf\u8d85\u7ea7\u7ba1\u7406\u5458");
        userService.create(user);
        String strPassword = KeyValueHelper.genUniqueId("ibzadmin", "123456");
        LoginAccount loginAccount = new LoginAccount();
        loginAccount.setUserId(user.getUserId());
        loginAccount.setUserName(user.getUserName());
        loginAccount.setLoginAccountName("ibzadmin");
        loginAccount.setSuperUser(1);
        loginAccount.setIsEnable(1);
        loginAccount.setPwd(strPassword);
        loginAccountService.create(loginAccount);
    }
}

