/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Chart
 *  SA.SRFDA.Web.ViewModel.PageModel
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.Report.Web.ViewModel;

import SA.SRFDA.Ctrl.Data.Chart;
import SA.SRFDA.Web.ViewModel.PageModel;
import net.sf.json.JSONObject;

public class DPChartViewModel
extends PageModel {
    protected Chart chart = new Chart();
    protected String strDataURL = "";

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

    protected void OnFillJSONObject(JSONObject jo) {
        super.OnFillJSONObject(jo);
        jo.put("chart", (Object)this.chart.ToJSONString());
        jo.put("dataurl", (Object)this.strDataURL);
    }
}

