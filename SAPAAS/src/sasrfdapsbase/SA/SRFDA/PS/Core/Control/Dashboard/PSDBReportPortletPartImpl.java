/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBReportPortletPart;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBSysPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.ReportPanel.IPSDEReportPanel;
import SA.SRFDA.PS.Core.Control.ReportPanel.PSDEReportPanelParamImpl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEReportPortlet;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"REPORT"})
public class PSDBReportPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBReportPortletPart {
    public static final String REPORTNAME = "_report";
    private IPSDEReportPanel iPSDEReportPanel = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDEReportPortlet iPSSysDEReportPortlet = (IPSSysDEReportPortlet)this.iPSSysPortlet;
        PSDEReportPanelParamImpl psDEReportParamImpl = new PSDEReportPanelParamImpl();
        psDEReportParamImpl.setPSDEReportId(iPSSysDEReportPortlet.getPSDEReportId());
        if (iPSSysDEReportPortlet.getHeight() > 0) {
            psDEReportParamImpl.setHeight(Double.valueOf(iPSSysDEReportPortlet.getHeight()));
        }
        this.iPSDEReportPanel = (IPSDEReportPanel)this.registerPSControl(String.valueOf(this.getName()) + REPORTNAME, "REPORTPANEL", psDEReportParamImpl);
        super.onInit();
    }

    @Override
    public IPSDEReportPanel getPSDEReportPanel() {
        return this.iPSDEReportPanel;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6", dumpref=true, modelreftype="LINK", from="__self__", from_method="getPSControl")
    public IPSControl getContentPSControl() {
        return this.getPSDEReportPanel();
    }
}

