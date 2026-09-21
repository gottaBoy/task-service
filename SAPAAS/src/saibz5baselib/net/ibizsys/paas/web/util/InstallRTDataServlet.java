/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.paas.web.util;

import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.SystemRTHelper;
import net.ibizsys.paas.web.AjaxActionResult;
import net.ibizsys.paas.web.HttpServletBase;
import net.ibizsys.paas.web.util.LoginServlet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class InstallRTDataServlet
extends HttpServletBase {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(LoginServlet.class);
    private String strInstallDataInfo = "";

    @Override
    protected AjaxActionResult onProcessAction() {
        AjaxActionResult ajaxActionResult = new AjaxActionResult();
        try {
            this.onInstallData();
            ajaxActionResult.setRetCode(0);
            ajaxActionResult.setErrorInfo(this.strInstallDataInfo);
        }
        catch (Exception e) {
            ajaxActionResult.setRetCode(1);
            ajaxActionResult.setErrorInfo(e.getMessage());
            log.error((Object)e);
        }
        return ajaxActionResult;
    }

    protected void onInstallData() throws Exception {
        if (!this.getWebContext().isSuperUser()) {
            throw new ErrorException(2, "\u53ea\u5141\u8bb8\u7cfb\u7edf\u8d85\u7ea7\u7ba1\u7406\u5458\u64cd\u4f5c");
        }
        ActionSessionManager.openSession("\u5b89\u88c5\u8fd0\u884c\u6570\u636e");
        try {
            SystemRTHelper.installAll();
            this.strInstallDataInfo = ActionSessionManager.getActionInfo();
            ActionSessionManager.closeSession();
            if (this.strInstallDataInfo != null) {
                this.strInstallDataInfo = this.strInstallDataInfo.replace("\r\n", "<BR>");
            }
        }
        catch (Exception ex) {
            ActionSessionManager.closeSession();
            throw ex;
        }
    }
}

