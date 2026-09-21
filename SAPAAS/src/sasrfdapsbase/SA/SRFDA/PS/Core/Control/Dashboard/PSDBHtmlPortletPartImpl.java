/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBHtmlPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBSysPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysHtmlPortlet;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"HTML"})
public class PSDBHtmlPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBHtmlPortletPart {
    private IPSSysHtmlPortlet iPSSysHtmlPortlet = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSControlContainer(iPSControlContainer);
        this.setName(strName);
        super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onInit() throws Exception {
        this.iPSSysHtmlPortlet = (IPSSysHtmlPortlet)this.iPSSysPortlet;
        super.onInit();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6")
    public IPSControl getContentPSControl() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7f51\u9875\u5730\u5740")
    public String getPageUrl() {
        return this.iPSSysHtmlPortlet.getPageUrl();
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u663e\u793a\u6a21\u5f0f", codelist="PortletHtmlShowMode")
    public String getHtmlShowMode() {
        return this.iPSSysHtmlPortlet.getHtmlShowMode();
    }
}

