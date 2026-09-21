/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.controller;

import net.ibizsys.paas.controller.AppUtilViewControllerBase;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.IWebContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class AppLogoutViewControllerBase
extends AppUtilViewControllerBase {
    private static final Log log = LogFactory.getLog(AppLogoutViewControllerBase.class);
    public static final String VIEWACTION_LOGOUT = "logout";

    @Override
    protected AjaxActionResult onViewAjaxAction(String strAction) throws Exception {
        if (StringHelper.compare(strAction, VIEWACTION_LOGOUT, true) == 0) {
            return this.onLogout();
        }
        return super.onViewAjaxAction(strAction);
    }

    protected void logoutUser(IWebContext iWebContext) throws Exception {
        iWebContext.logout(true);
    }

    protected AjaxActionResult onLogout() throws Exception {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        this.logoutUser(this.getWebContext());
        return ajaxActionResult;
    }
}

