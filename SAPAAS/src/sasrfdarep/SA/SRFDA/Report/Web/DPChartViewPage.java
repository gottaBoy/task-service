/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Web.SRFDAPageEx
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.ReportEx.Model.ChartConfig
 *  SA.SRFramework.ReportEx.SRFExChart
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExControl
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Report.Web;

import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Report.Web.ViewModel.DPChartViewModel;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFDA.Web.ViewModel.PageModel;
import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.ReportEx.Model.ChartConfig;
import SA.SRFramework.ReportEx.SRFExChart;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;
import net.sf.json.JSONObject;

public class DPChartViewPage
extends SRFDAPageEx {
    protected Chart chart = new Chart();
    protected SRFExChart chartCtrl = null;
    protected DPChartViewModel chartViewModel = null;

    protected boolean PreparePageEnv() {
        if (!super.PreparePageEnv()) {
            return false;
        }
        String strChartId = this.getWebContext().GetParamValue("CHARTID");
        if (StringHelper.IsNullOrEmpty((String)strChartId)) {
            this.PageLog((Object)this, 1, "\u6ca1\u6709\u6307\u5b9a\u56fe\u8868\u7f16\u53f7");
            return false;
        }
        CallResult callResult = this.getDAModelHelper().GetChart(strChartId, this.chart);
        if (callResult.getRetCode() != 0) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u56fe\u8868[%1$s]\uff0c%2$s", (Object)strChartId, (Object)callResult.getErrorInfo()));
            return false;
        }
        this.strPageDataEntityId = this.chart.getDEID();
        this.LoadPageDataEntity();
        return true;
    }

    public String OutputPageCaption() {
        return this.chart.getCHARTNAME();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadChart();
    }

    protected PageModel CreatePageModel() {
        return new DPChartViewModel();
    }

    protected void PreparePageModel() {
        super.PreparePageModel();
        this.chartViewModel = (DPChartViewModel)this.pageModel;
    }

    protected boolean OnFillPageModel(JSONObject jsonObject) {
        return super.OnFillPageModel(jsonObject);
    }

    protected void LoadChart() {
        this.chartCtrl = new SRFExChart();
        ChartConfig chartConfig = new ChartConfig();
        chartConfig.setChartStyle(this.chart.getCHARTTYPE());
        chartConfig.setWidth(this.chart.getWIDTH());
        chartConfig.setHeight(this.chart.getHEIGHT());
        chartConfig.setGridPos(this.chart.getGRIDPOS());
        chartConfig.setGridHeight(300);
        chartConfig.setGridWidth(this.chart.getGRIDWIDTH());
        chartConfig.setLoadDefault(false);
        String strDataURL = StringHelper.Format((String)"../srfpage/chartdatabackend.jsp?SRFCHARTID=%1$s&SRFCHARTTYPE=%2$s", (Object)this.chart.getCHARTID(), (Object)this.chart.getCHARTTYPE());
        chartConfig.setDataURL(strDataURL);
        this.chartCtrl.setConfig((XMLConfig)chartConfig);
        this.chartCtrl.setID("chart");
        this.AddControl((SRFExControl)this.chartCtrl);
        if (this.chartViewModel != null) {
            strDataURL = StringHelper.Format((String)"../srfpage/chartdatamodelbackend.jsp?SRFCHARTID=%1$s&SRFCHARTTYPE=%2$s", (Object)this.chart.getCHARTID(), (Object)this.chart.getCHARTTYPE());
            this.chartViewModel.setChart(this.chart);
            this.chartViewModel.setDataURL(strDataURL);
        }
    }
}

