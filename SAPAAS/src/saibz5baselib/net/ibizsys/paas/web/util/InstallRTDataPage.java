/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.web.util;

import net.ibizsys.paas.exception.ErrorException;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.util.SystemRTHelper;
import net.ibizsys.paas.web.Page;

public class InstallRTDataPage
extends Page {
    private String strInstallDataInfo = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.getWebContext().isSuperUser()) {
            throw new ErrorException(2, "\u9875\u9762\u53ea\u5141\u8bb8\u7cfb\u7edf\u8d85\u7ea7\u7ba1\u7406\u5458\u8bbf\u95ee");
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

    public String outputInstallInfo() {
        return this.strInstallDataInfo;
    }
}

