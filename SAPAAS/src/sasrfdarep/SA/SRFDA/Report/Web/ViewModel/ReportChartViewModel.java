/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Web.Default.ViewModel.MainViewModel
 *  SA.SRFDA.Web.ViewModel.ControlModel
 *  SA.SRFDA.Web.ViewModel.SPExModel
 *  SA.SRFDA.Web.ViewModel.SearchFormModel
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Report.Web.ViewModel;

import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Web.Default.ViewModel.MainViewModel;
import SA.SRFDA.Web.ViewModel.ControlModel;
import SA.SRFDA.Web.ViewModel.SPExModel;
import SA.SRFDA.Web.ViewModel.SearchFormModel;
import net.sf.json.JSONObject;

public class ReportChartViewModel
extends MainViewModel {
    protected SearchFormModel searchFormModel = null;
    protected SPExModel spExModel = null;
    protected Chart chart = new Chart();
    protected String strDataURL = "";

    public ReportChartViewModel() {
        this.searchFormModel = new SearchFormModel();
        this.spExModel = new SPExModel();
        this.RegisterCtrlModel("spex", (ControlModel)this.spExModel);
        this.RegisterCtrlModel("searchform", (ControlModel)this.searchFormModel);
    }

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        jo.put("chart", (Object)this.chart.ToJSONString());
        jo.put("dataurl", (Object)this.strDataURL);
    }

    public SPExModel getSPExModel() {
        return this.spExModel;
    }

    public SearchFormModel getSearchFormModel() {
        return this.searchFormModel;
    }

    public String getDataURL() {
        return this.strDataURL;
    }

    public void setDataURL(String strDataURL) {
        this.strDataURL = strDataURL;
    }

    public Chart getChart() {
        return this.chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }
}

