/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.ReportEx.SRFExChart
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExControl
 */
package SA.SRFDA.Web.Default;

import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.ReportEx.SRFExChart;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;

public class ChartFunnelPage
extends SRFDAPageEx {
    protected SRFExChart funnelChart = null;

    @Override
    protected boolean PreparePageEnv() {
        return super.PreparePageEnv();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadChart();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
    }

    protected void LoadChart() {
        this.funnelChart = new SRFExChart();
        this.funnelChart.InitConfig();
        this.funnelChart.setID("funnelChart");
        this.funnelChart.getChartConfig().setChartStyle("FUNNEL");
        this.funnelChart.getChartConfig().setWidth(245);
        this.funnelChart.getChartConfig().setHeight(600);
        String strChartId = this.getPageParam("PAGE.CHART", "");
        String strDataURL = StringHelper.Format((String)"../srfpage/chartdatabackend.jsp?SRFCHARTID=%1$s&SRFCHARTTYPE=%2$s", (Object)strChartId, (Object)"FUNNEL");
        this.funnelChart.getChartConfig().setDataURL(strDataURL);
        this.AddControl((SRFExControl)this.funnelChart);
    }

    public String OutputPageCaption() {
        return this.OnGetPageCaption();
    }

    protected String OnGetPageCaption() {
        return this.getPageParam("PAGE.CAPTION", "\u6f0f\u6597\u56fe");
    }

    public String GetFunnelClickCode() {
        return this.getPageParam("PAGE.FUNNELCLICK", "");
    }
}

