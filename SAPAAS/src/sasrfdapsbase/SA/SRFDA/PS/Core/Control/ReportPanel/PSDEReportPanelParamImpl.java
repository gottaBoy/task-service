/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.ReportPanel;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlParamImpl;
import SA.SRFDA.PS.Core.Control.ReportPanel.IPSDEReportPanelParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEReportPanelParamImpl
extends PSControlParamImpl
implements IPSDEReportPanelParam {
    private String strPSDEReportId = "";
    private String strReportContentType = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEReportId(this.psDEViewCtrl.getPSDEREPORTID());
        this.setReportContentType(this.psDEViewCtrl.getCTRLPARAM2());
    }

    @Override
    public String getPSDEReportId() {
        return this.strPSDEReportId;
    }

    public void setPSDEReportId(String strPSDEReportId) {
        this.strPSDEReportId = strPSDEReportId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEReportPanelParam) {
            IPSDEReportPanelParam iPSDEReportBarParam = (IPSDEReportPanelParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEReportId())) {
                this.setPSDEReportId(iPSDEReportBarParam.getPSDEReportId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getReportContentType())) {
                this.setReportContentType(iPSDEReportBarParam.getReportContentType());
            }
        }
    }

    @Override
    public String getReportContentType() {
        return this.strReportContentType;
    }

    public void setReportContentType(String strReportContentType) {
        this.strReportContentType = strReportContentType;
    }
}

