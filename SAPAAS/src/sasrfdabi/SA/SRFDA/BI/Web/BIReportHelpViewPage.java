/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Default.BaseMainPage
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.BI.Web;

import SA.SRFDA.BI.Ctrl.Data.BIReport;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.Web.Default.BaseMainPage;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;

public class BIReportHelpViewPage
extends BaseMainPage {
    protected BIReport biReport = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
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

    public String GetHelpContent() {
        if (this.biReport != null) {
            return this.biReport.getDESCRIPTION();
        }
        return "\u6ca1\u6709\u627e\u5230\u62a5\u8868\u8bf4\u660e\u4fe1\u606f";
    }
}

