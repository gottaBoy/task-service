/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.SessionData
 *  SA.SRFDA.Ctrl.Data.Threshold
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.SRFDAWebCTXHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.StringBuilderEx
 *  SA.SRFramework.WebEx.ToolBar.SRFExToolbar
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.DEDataCtrl.IBICubeDataCtrl;
import SA.SRFDA.BI.Ctrl.Data.BIReport;
import SA.SRFDA.Ctrl.Data.SessionData;
import SA.SRFDA.Ctrl.Data.Threshold;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.SRFDAWebCTXHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.ToolBar.SRFExToolbar;
import java.util.Vector;

public class SLPivotTableViewPage
extends BaseMainPage {
    protected BIReport biReport = null;
    protected SRFExToolbar toolbar = null;
    protected String strToolbarConfigId = "";
    protected boolean bEmbedMode = false;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        this.bEmbedMode = this.OnGetEmbedMode();
        String strBIReportId = this.getWebContext().GetParamValue("BIREPORTID");
        if (!StringHelper.IsNullOrEmpty((String)strBIReportId)) {
            IDEDataCtrl reportDEDataCtrl = this.GetDEDataCtrl("BI0020");
            if (reportDEDataCtrl == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u5b9e\u4f53[%1$s]\u6570\u636e\u8bbf\u95ee\u5bf9\u8c61", (Object)"BI0020"));
                return false;
            }
            this.biReport = new BIReport();
            this.biReport.setBIREPORTID(strBIReportId);
            CallResult callResult = reportDEDataCtrl.Get((BaseDataEntity)this.biReport);
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6BI\u62a5\u8868[%1$s]\u5931\u8d25\uff0c%2$s", (Object)strBIReportId, (Object)callResult.getErrorInfo()));
                return false;
            }
        }
        return true;
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadToolbar();
    }

    protected String OnGetPageCaption() {
        if (this.biReport != null) {
            return this.biReport.getBIREPORTNAME();
        }
        return "BI\u62a5\u8868";
    }

    public String GetDataSourceName() {
        return "SABIDataSource";
    }

    public String GetXmlaPath() {
        return this.getWebContext().getWebExConfig().GetValue("SRFBI", "XMLAPATH", "");
    }

    public String GetBICubeThCode() {
        String strBICubeId;
        if (this.biReport != null && !StringHelper.IsNullOrEmpty((String)(strBICubeId = this.biReport.getBICUBEID()))) {
            Vector<Threshold> thresholds;
            IBICubeDataCtrl biCubeDataCtrl = (IBICubeDataCtrl)this.GetDEDataCtrl("BI0001");
            CallResult callResult = biCubeDataCtrl.ListBICubeThresholds(strBICubeId, thresholds = new Vector<Threshold>());
            if (callResult.IsError()) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u5206\u6790\u7acb\u65b9\u4f53[%1$s]\u6307\u6807\u9600\u503c\u5931\u8d25\uff0c%2$s", (Object)strBICubeId, (Object)callResult.getErrorInfo()));
                return "";
            }
            StringBuilderEx script = new StringBuilderEx();
            for (Threshold threshold : thresholds) {
                script.Append("biv.SetThreshold(\"[Measures].[%1$s]\", %2$s, %3$s, '%4$s');\r\n", threshold.GetParamValue("BICUBEMEASURENAME"), (Object)Float.valueOf(threshold.getSTARTVALUE()), (Object)Float.valueOf(threshold.getENDVALUE()), (Object)threshold.getSLSTYLE());
            }
            return script.toString();
        }
        return "";
    }

    public String GetCatalogName() {
        if (this.biReport == null) {
            return this.getWebContext().getWebExConfig().GetValue("SRFBI", "DEFAULTCATALOG", "");
        }
        return this.biReport.getBICATALOGNAME();
    }

    public String GetReportModel() {
        if (this.biReport == null) {
            return "";
        }
        String strSessionDataId = this.getWebContext().GetParamValue("SESSIONDATAID");
        if (StringHelper.IsNullOrEmpty((String)strSessionDataId)) {
            return this.biReport.getREPORTMODEL();
        }
        SessionData sessionData = new SessionData();
        sessionData.setSESSIONDATAID(String.valueOf(this.getWebContext().getSessionId()) + "_" + strSessionDataId);
        CallResult callResult = this.getDAModelStorage().GetSessionDataDataCtrl().Get((BaseDataEntity)sessionData);
        if (callResult.IsError()) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6Session\u6570\u636e[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strSessionDataId, (Object)callResult.getErrorInfo()));
            return this.biReport.getREPORTMODEL();
        }
        return sessionData.getDATA();
    }

    protected void LoadToolbar() {
        if (!this.IsBackEndMode()) {
            this.strToolbarConfigId = this.OnGetToolbarConfigId();
            if (StringHelper.IsNullOrEmpty((String)this.strToolbarConfigId)) {
                return;
            }
        }
        this.toolbar = SLPivotTableViewPage.CreateToolbar((SRFDAPage)this, (String)"toolBar", (double)0.0, (double)0.0, (String)this.strToolbarConfigId);
        if (this.toolbar != null && !this.IsBackEndMode()) {
            this.toolbar.getToolbarConfig().setCssClass("sx-toolbarnobg");
        }
    }

    protected String OnGetToolbarConfigId() {
        return "SRFBI.TB_PIVOTTABLE_DEFAULT";
    }

    protected boolean OnGetEmbedMode() {
        return SRFDAWebCTXHelper.IsEmbedMode((ISRFDAWebContext)this.getWebContext(), (boolean)this.bEmbedMode);
    }

    public boolean IsEmbedMode() {
        return this.bEmbedMode;
    }
}

