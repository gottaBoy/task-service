/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.Page
 *  SA.SRFramework.ReportEx.SRFExChart
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.WebEx.SRFExControl
 *  SA.SRFramework.WebEx.SRFExIFrame
 */
package SA.SRFDA.Web.CRM;

import SA.SRFDA.Ctrl.Data.Page;
import SA.SRFDA.Web.SRFDAPageEx;
import SA.SRFramework.ReportEx.SRFExChart;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExIFrame;

public class FunnelGridViewPage
extends SRFDAPageEx {
    protected SRFExChart funnelChart = null;
    protected SRFExIFrame iFrame = null;

    @Override
    protected boolean PreparePageEnv() {
        return super.PreparePageEnv();
    }

    protected void OnInitComponents() {
        super.OnInitComponents();
        this.LoadChart();
        this.LoadIFrame();
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
        this.funnelChart.getChartConfig().setWidth(this.getPageParam("PAGE.CHART.WIDTH", 245));
        this.funnelChart.getChartConfig().setHeight(this.getPageParam("PAGE.CHART.HEIGHT", 450));
        String strChartId = this.getPageParam("PAGE.CHART", "");
        String strDataURL = StringHelper.Format((String)"../srfpage/chartdatabackend.jsp?SRFCHARTID=%1$s&SRFCHARTTYPE=%2$s", (Object)strChartId, (Object)"FUNNEL");
        this.funnelChart.getChartConfig().setDataURL(strDataURL);
        this.AddControl((SRFExControl)this.funnelChart);
    }

    protected void LoadIFrame() {
        if (this.iFrame != null) {
            return;
        }
        this.iFrame = new SRFExIFrame();
        this.iFrame.InitConfig();
        this.iFrame.setID("iframe");
        this.iFrame.getIFrameConfig().setWidth(0);
        this.iFrame.getIFrameConfig().setHeight(0);
        this.iFrame.getIFrameConfig().setScroll("no");
        this.iFrame.getIFrameConfig().setURL(this.GetIframeUrl());
        this.AddControl((SRFExControl)this.iFrame);
    }

    public String GetIframeUrl() {
        String strPageId;
        String strURL = this.getPageParam("PAGE.IFRAME.URL", "");
        if (StringHelper.IsNullOrEmpty((String)strURL) && !StringHelper.IsNullOrEmpty((String)(strPageId = this.getPageParam("PAGE.IFRAME.PAGE", "")))) {
            Page ifpage = this.getWebContext().getGlobalHelper().getDAModelStorage().FindPage(strPageId);
            if (this.page == null) {
                this.PageLog((Object)this, 1, StringHelper.Format((String)"\u83b7\u53d6\u9875\u9762\u914d\u7f6e[%1$s]\u5931\u8d25", (Object)strPageId));
                return "";
            }
            strURL = ifpage.GetTotalPagePath();
        }
        if (StringHelper.IsNullOrEmpty((String)strURL)) {
            this.PageLog((Object)this, 1, StringHelper.Format((String)"\u6ca1\u6709\u5b9a\u4e49\u6709\u6548\u7684IFrame\u8def\u5f84"));
        }
        return strURL;
    }

    public String OutputPageCaption() {
        return this.OnGetPageCaption();
    }

    protected String OnGetPageCaption() {
        return this.getPageParam("PAGE.CAPTION", "\u6f0f\u6597\u56fe");
    }

    public String OutputPageUnGroupLable() {
        return this.OnGetPageUnGroupLable();
    }

    protected String OnGetPageUnGroupLable() {
        return this.getPageParam("PAGE.UNGROUPLABLE", "\u4e0d\u5206\u7ec4");
    }

    public String GetFunnelClickCode() {
        return this.getPageParam("PAGE.FUNNELCLICK", "");
    }
}

