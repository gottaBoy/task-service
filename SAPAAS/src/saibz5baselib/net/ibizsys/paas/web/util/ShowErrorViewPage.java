/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.web.util;

import net.ibizsys.paas.web.Page;

public class ShowErrorViewPage
extends Page {
    @Override
    protected void onInit() throws Exception {
        super.onInit();
        String strErrorMsg = this.getWebContext().getParamValue("ERRORMSG");
        this.getPageContext().setAttribute("ERRORMSG", (Object)strErrorMsg);
    }

    public String getErrorMsg() {
        Object objErrorMsg = this.getPageContext().getAttribute("ERRORMSG");
        if (objErrorMsg == null) {
            return null;
        }
        return (String)objErrorMsg;
    }
}

