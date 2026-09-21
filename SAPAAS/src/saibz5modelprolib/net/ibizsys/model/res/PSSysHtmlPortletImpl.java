/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.res;

import net.ibizsys.model.res.IPSSysHtmlPortlet;
import net.ibizsys.model.res.PSSysPortletImpl;
import net.ibizsys.paas.util.StringHelper;

public class PSSysHtmlPortletImpl
extends PSSysPortletImpl
implements IPSSysHtmlPortlet {
    private String strHtmlShowMode = "INNER";

    @Override
    protected void onInit() throws Exception {
        if (!StringHelper.isNullOrEmpty((String)this.psSysPortlet.getHTMLSHOWMODE())) {
            this.strHtmlShowMode = this.psSysPortlet.getHTMLSHOWMODE();
        }
        super.onInit();
    }

    @Override
    public String getPageUrl() {
        return this.psSysPortlet.getHTMLURL();
    }

    @Override
    public String getHtmlShowMode() {
        return this.strHtmlShowMode;
    }
}

