/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Web.ISRFDAWebContext
 *  SA.SRFDA.Web.SRFDAPage
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.UtilityEx.ObjectHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Report.Chart.ChartActionHelper;
import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAPage;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ChartDataPage
extends SRFDAPage {
    protected Chart chart = new Chart();
    private static final Log log = LogFactory.getLog(ChartDataPage.class);

    public ChartDataPage() {
        this.setMainPage(true);
        this.setOutputDebug(false);
    }

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strChartId = this.getWebContext().getSRFChartId();
        if (StringHelper.IsNullOrEmpty((String)strChartId)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u56fe\u8868\u5bf9\u8c61\u7f16\u53f7"));
            return false;
        }
        CallResult callResult = this.getDAModelHelper().GetChart(strChartId, this.chart);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u56fe\u8868\u5bf9\u8c61[%1$s]", (Object)strChartId));
            return false;
        }
        this.chart.BuildProperties();
        if (!this.chart.CheckUserMode(this.getWebContext().getCurUserMode())) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u5f53\u7136\u7528\u6237\u6a21\u5f0f\u4e0e\u56fe\u50cf\u9700\u8981\u7528\u6237\u6a21\u5f0f\u4e0d\u4e00\u81f4"));
            return false;
        }
        if (StringHelper.Compare((String)this.getWebContext().getSRFPageModel(), (String)"SL", (boolean)true) == 0) {
            this.getResponse().setContentType("text/html; charset=UTF-8");
        }
        return true;
    }

    protected void OnLoadBackEnd() {
        ChartActionHelper chartActionHelper = null;
        String strChartObject = this.chart.getCHARTOBJECT();
        if (StringHelper.IsNullOrEmpty((String)strChartObject)) {
            chartActionHelper = new ChartActionHelper();
        } else {
            Object objActionHelper = ObjectHelper.Create((String)this.chart.getCHARTOBJECT());
            if (objActionHelper == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u5efa\u7acb\u56fe\u50cf\u5904\u7406\u5bf9\u8c61[%1$s]", (Object)this.chart.getCHARTOBJECT()));
                return;
            }
            if (!(objActionHelper instanceof ChartActionHelper)) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u56fe\u50cf\u5904\u7406\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)this.chart.getCHARTOBJECT()));
                return;
            }
            chartActionHelper = (ChartActionHelper)objActionHelper;
        }
        this.Output(chartActionHelper.GetChartXML((ISRFDAWebContext)this.getWebContext(), (ISRFDAGlobalHelper)this.getWebContext().getGlobalHelper(), this.chart));
    }
}

