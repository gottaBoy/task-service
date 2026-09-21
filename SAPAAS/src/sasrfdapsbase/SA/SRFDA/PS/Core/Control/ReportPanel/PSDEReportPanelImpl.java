/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ReportPanel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEReport;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSControlImpl;
import SA.SRFDA.PS.Core.Control.ReportPanel.IPSDEReportPanel;
import SA.SRFDA.PS.Core.Control.ReportPanel.IPSDEReportPanelParam;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEReport;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"REPORTPANEL"})
public class PSDEReportPanelImpl
extends PSControlImpl
implements IPSDEReportPanel {
    private static final Log log = LogFactory.getLog(PSDEReportPanelImpl.class);
    protected IPSDEReportPanelParam iPSDEReportPanelParam = null;
    private IPSDEReport iPSDEReport = null;
    private IPSAppDEReport iPSAppDEReport = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSControlContainer(iPSControlContainer);
        this.setName(strName);
        if (iPSControlParam != null) {
            this.iPSDEReportPanelParam = (IPSDEReportPanelParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty((String)this.iPSDEReportPanelParam.getPSDEReportId())) {
                PSDEReport psDEReport = new PSDEReport();
                CallResult callResult = this.getPSModelHelper().getPSDEReport(this.iPSDEReportPanelParam.getPSDEReportId(), psDEReport);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u62a5\u8868\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(psDEReport.getPSDEREPORTID());
                this.setLogicName(psDEReport.getPSDEREPORTNAME());
                this.setPSObjectData(psDEReport);
                if (!(this.getPSDataEntity() != null && StringHelper.Compare((String)psDEReport.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) == 0 || StringHelper.IsNullOrEmpty((String)psDEReport.getPSDEID()))) {
                    this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(psDEReport.getPSDEID()));
                }
            }
        }
        super.init(iDAGlobalHelper, iPSControlContainer, strName, iPSControlParam);
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!StringHelper.IsNullOrEmpty((String)this.iPSDEReportPanelParam.getPSDEReportId())) {
            this.iPSDEReport = this.getPSDataEntity().getPSDEReport(this.iPSDEReportPanelParam.getPSDEReportId());
        }
        if (this.getPSAppDataEntity() != null && this.getPSDEReport() != null) {
            this.iPSAppDEReport = this.getPSAppDataEntity().getPSAppDEReport(this.getPSDEReport().getId(), true);
        }
    }

    @Override
    protected String onGetControlType() {
        return "REPORTPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u62a5\u8868\u5bf9\u8c61")
    public IPSDEReport getPSDEReport() {
        return this.iPSDEReport;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u62a5\u8868\u5bf9\u8c61", child=true)
    public IPSAppDEReport getPSAppDEReport() {
        return this.iPSAppDEReport;
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    public String getReportContentType() {
        return this.iPSDEReportPanelParam.getReportContentType();
    }

    @Override
    public String getModelType() {
        return "PSDEREPORTPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.calcCodeName(), null);
    }

    protected String calcCodeName() {
        if (this.getPSDEReport() != null) {
            return this.getPSDEReport().getCodeName();
        }
        return super.getCodeName();
    }
}

