/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.web.Page
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psuac.web;

import net.ibizsys.paas.web.Page;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogoutPage
extends Page {
    private static final Log log = LogFactory.getLog(LogoutPage.class);
    protected String strServerPath = "";

    protected void onInit() throws Exception {
        super.onInit();
        try {
            this.getWebContext().logout(true);
            this.getResponse().sendRedirect(this.getWebContext().getParamValue("RU"));
            return;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}

