/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Res;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysHtmlPortlet;
import SA.SRFDA.PS.Core.Res.PSSysPortletImpl;
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
    @PSModelRTMeta(description="\u9875\u9762\u8def\u5f84")
    public String getPageUrl() {
        return this.psSysPortlet.getHTMLURL();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u663e\u793a\u6a21\u5f0f", codelist="PortletHtmlShowMode")
    public String getHtmlShowMode() {
        return this.strHtmlShowMode;
    }
}

