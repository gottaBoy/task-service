/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Base.XMLConfig
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFramework.ReportEx;

import SA.SRFramework.Base.XMLConfig;
import SA.SRFramework.ReportEx.Model.ChartConfig;
import SA.SRFramework.ReportEx.Model.ChartStyleItemConfig;
import SA.SRFramework.ReportEx.SRFExChartSearchAction;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.StringBuilderEx;
import SA.SRFramework.WebEx.SP.SRFExSPEx;
import SA.SRFramework.WebEx.SP.UI.SPExConfig;
import SA.SRFramework.WebEx.SRFExControl;
import SA.SRFramework.WebEx.SRFExDataGrid;
import java.io.Writer;
import java.net.URLEncoder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SRFExChart
extends SRFExControl {
    protected ChartConfig chartConfig = null;
    private static final Log log = LogFactory.getLog(SRFExChart.class);
    public static String BUILDER_CHART = "CHART";
    protected boolean bEnableUserDGTheme = true;
    protected SRFExDataGrid dataGrid = null;
    public static final String TAG_EMPTYXML = "<graph SUBCAPTION='empty data'></graph>";
    protected SRFExSPEx spEx = null;

    @Override
    protected XMLConfig CreateConfig() {
        return new ChartConfig();
    }

    @Override
    protected void OnInit() {
        super.OnInit();
    }

    public ChartConfig getChartConfig() {
        return this.chartConfig;
    }

    @Override
    protected void OnSetConfig() {
        super.OnSetConfig();
        this.chartConfig = null;
        if (this.config != null && this.config instanceof ChartConfig) {
            this.chartConfig = (ChartConfig)this.config;
        }
    }

    @Override
    protected void OnReloadConfig() {
        String strSPExConfigId;
        super.OnReloadConfig();
        if (this.spEx != null) {
            this.RemoveControl(this.spEx);
            this.spEx = null;
        }
        if (this.chartConfig != null && !StringHelper.IsNullOrEmpty((String)(strSPExConfigId = this.chartConfig.getSPExConfigId()))) {
            SPExConfig spExConfig = this.getWebContext().getSearchPanelMgr().GetSPExConfig(strSPExConfigId);
            if (spExConfig == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u641c\u7d22\u9762\u677f\u914d\u7f6e[%1$s]", (Object)strSPExConfigId));
            } else {
                this.spEx = new SRFExSPEx();
                this.spEx.setConfig(spExConfig);
                this.spEx.setID("SPEX");
                this.AddControl(this.spEx);
                this.spEx.getSearchForm().setTotalRealId(true);
                this.spEx.getSearchForm().setOutputUIDParam(true);
                this.spEx.getSearchForm().getSearchAction().setEnabled(false);
                SRFExChartSearchAction chartSearchAction = new SRFExChartSearchAction();
                StringBuilderEx script = new StringBuilderEx();
                script.Append(" $P.object['%1$s'].setDataURL(escape('%2$s'+'&'+_PARAMS));", this.getUniqueID(), this.getChartConfig().getDataURL());
                ChartStyleItemConfig ssGridItemConfig = this.getWebContext().getGlobalConfigMgr().GetChartStyleConfig().FindChartStyleItemConfig("SSGRID");
                if (ssGridItemConfig != null && StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"NONE", (boolean)true) != 0 && !StringHelper.IsNullOrEmpty((String)this.chartConfig.getGridPos())) {
                    script.Append("$P.object['g_%1$s'].setDataURL(escape('%2$s'+'&'+_PARAMS));", this.getUniqueID(), this.getChartConfig().getDataURL());
                }
                chartSearchAction.setSearchCode(script.toString());
                this.spEx.getSearchForm().AddFormAction(chartSearchAction);
            }
        }
    }

    @Override
    protected void OnRender(Writer writer) {
        try {
            int nGridHeight;
            int nGridWidth;
            int nHeight;
            ChartStyleItemConfig chartStyleItemConfig = this.getWebContext().getGlobalConfigMgr().GetChartStyleConfig().FindChartStyleItemConfig(this.chartConfig.getChartStyle());
            if (chartStyleItemConfig == null) {
                log.error((Object)StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6837\u5f0f[%1$s]\u6240\u5bf9\u5e94\u7684\u914d\u7f6e", (Object)this.chartConfig.getChartStyle()));
                return;
            }
            ChartStyleItemConfig ssGridItemConfig = this.getWebContext().getGlobalConfigMgr().GetChartStyleConfig().FindChartStyleItemConfig("SSGRID");
            int nWidth = this.getChartConfig().getWidth();
            if (nWidth == 0) {
                nWidth = 320;
            }
            if ((nHeight = this.getChartConfig().getHeight()) == 0) {
                nHeight = 240;
            }
            if ((nGridWidth = this.getChartConfig().getGridWidth()) == 0) {
                nGridWidth = nWidth;
            }
            if ((nGridHeight = this.getChartConfig().getGridHeight()) == 0) {
                nGridHeight = 100;
            }
            String strDataURL = URLEncoder.encode(this.getChartConfig().getDataURL(), "UTF-8");
            if (this.spEx != null) {
                this.spEx.Render(writer);
            }
            if (ssGridItemConfig == null || StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"NONE", (boolean)true) == 0 || StringHelper.IsNullOrEmpty((String)this.chartConfig.getGridPos())) {
                writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='100%%'>", (Object)nWidth));
                writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                writer.write(StringHelper.Format((String)"</td></tr>"));
                writer.write(StringHelper.Format((String)"</table>"));
            } else {
                writer.write(StringHelper.Format((String)"<DIV align='center'>"));
                int nTotalWidth = 0;
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"TOP", (boolean)true) == 0) {
                    nTotalWidth = nWidth > nGridWidth ? nWidth : nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr height='%1$s'><td align='center' >", (Object)nGridHeight));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"TOPLEFT", (boolean)true) == 0) {
                    nTotalWidth = nWidth > nGridWidth ? nWidth : nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td align='left'>"));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"TOPRIGHT", (boolean)true) == 0) {
                    nTotalWidth = nWidth > nGridWidth ? nWidth : nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td align='right'>"));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"BOTTOM", (boolean)true) == 0) {
                    nTotalWidth = nWidth > nGridWidth ? nWidth : nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"BOTTOMLEFT", (boolean)true) == 0) {
                    nTotalWidth = nWidth > nGridWidth ? nWidth : nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"<tr><td align='left'>"));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"BOTTOMRIGHT", (boolean)true) == 0) {
                    nTotalWidth = nWidth > nGridWidth ? nWidth : nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"<tr><td align='right'>"));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"LEFT", (boolean)true) == 0) {
                    nTotalWidth = nWidth + nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td valign='middle' width='%1$s'>", (Object)nGridWidth));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td>"));
                    writer.write(StringHelper.Format((String)"<td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"LEFTTOP", (boolean)true) == 0) {
                    nTotalWidth = nWidth + nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td valign='top' width='%1$s'>", (Object)nGridWidth));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td><"));
                    writer.write(StringHelper.Format((String)"<td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"LEFTBOTTOM", (boolean)true) == 0) {
                    nTotalWidth = nWidth + nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td valign='bottom' width='%1$s'>", (Object)nGridWidth));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td>"));
                    writer.write(StringHelper.Format((String)"<td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"RIGHT", (boolean)true) == 0) {
                    nTotalWidth = nWidth + nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td width='%1$s'>", (Object)nWidth));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td>"));
                    writer.write(StringHelper.Format((String)"<td valign='middle' width='%1$s'>", (Object)nGridWidth));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"RIGHTTOP", (boolean)true) == 0) {
                    nTotalWidth = nWidth + nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td>"));
                    writer.write(StringHelper.Format((String)"<td valign='top' width='%1$s'>", (Object)nGridWidth));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                if (StringHelper.Compare((String)this.chartConfig.getGridPos(), (String)"RIGHTBOTTOM", (boolean)true) == 0) {
                    nTotalWidth = nWidth + nGridWidth;
                    writer.write(StringHelper.Format((String)"<table border='0' cellspacing='2' cellpadding='2' width='%1$s'>", (Object)nTotalWidth));
                    writer.write(StringHelper.Format((String)"<tr><td align='center'>"));
                    this.RenderChart(writer, chartStyleItemConfig, nWidth, nHeight);
                    writer.write(StringHelper.Format((String)"</td>"));
                    writer.write(StringHelper.Format((String)"<td valign='bottom' width='%1$s'>", (Object)nGridWidth));
                    this.RenderDataGrid(writer, ssGridItemConfig, nGridWidth, nGridHeight);
                    writer.write(StringHelper.Format((String)"</td></tr>"));
                    writer.write(StringHelper.Format((String)"</table>"));
                }
                writer.write(StringHelper.Format((String)"</DIV>"));
            }
        }
        catch (Exception ex) {
            log.error((Object)this, (Throwable)ex);
        }
    }

    protected void RenderChart(Writer writer, ChartStyleItemConfig chartStyleItemConfig, int nWidth, int nHeight) throws Exception {
        String strContainer = "";
        if (StringHelper.IsNullOrEmpty((String)strContainer)) {
            strContainer = StringHelper.Format((String)"CC_%1$s", (Object)this.getUniqueID());
            writer.write(StringHelper.Format((String)"<DIV id='%1$s' align='center' style='width:%2$spx;height:%3$spx;' ></DIV>", (Object)strContainer, (Object)nWidth, (Object)nHeight));
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _%5$s = new FusionCharts(\"%1$s\", \"%2$s\", \"%3$s\", \"%4$s\",0,1);", chartStyleItemConfig.getChartPath(), this.getUniqueID(), nWidth, nHeight, this.getUniqueID());
        script.Append("_%1$s.addParam('wmode','transparent');", this.getUniqueID());
        script.Append("$P.object['%1$s']=_%1$s;", this.getUniqueID());
        if (this.getChartConfig().getLoadDefault()) {
            script.Append("_%2$s.setDataURL(escape('%1$s'));", this.getChartConfig().getDataURL(), this.getUniqueID());
        } else {
            script.Append("_%2$s.setDataXML(\"%1$s\");", TAG_EMPTYXML, this.getUniqueID());
        }
        script.Append("_%2$s.render('%1$s');", strContainer, this.getUniqueID());
        this.getPage().RegisterScript(2, script.toString());
    }

    protected void RenderDataGrid(Writer writer, ChartStyleItemConfig ssGridItemConfig, int nGridWidth, int nGridHeight) throws Exception {
        String strContainer = "";
        if (StringHelper.IsNullOrEmpty((String)strContainer)) {
            strContainer = StringHelper.Format((String)"CG_%1$s", (Object)this.getUniqueID());
            writer.write(StringHelper.Format((String)"<DIV id='%1$s' align='center' style='width:%2$spx;height:%3$spx;' ></DIV>", (Object)strContainer, (Object)nGridWidth, (Object)nGridHeight));
        }
        StringBuilderEx script = new StringBuilderEx();
        script.Append("var _g%5$s = new FusionCharts(\"%1$s\", \"%2$s\", \"%3$s\", \"%4$s\",0,1);", ssGridItemConfig.getChartPath(), "g" + this.getUniqueID(), nGridWidth, nGridHeight, this.getUniqueID());
        script.Append("_g%1$s.addParam('wmode','transparent');", this.getUniqueID());
        script.Append("$P.object['g_%1$s']=_g%1$s;", this.getUniqueID());
        if (this.getChartConfig().getLoadDefault()) {
            script.Append("_g%2$s.setDataURL(escape('%1$s'));", this.getChartConfig().getDataURL(), this.getUniqueID());
        } else {
            script.Append("_g%2$s.setDataXML(\"%1$s\");", TAG_EMPTYXML, this.getUniqueID());
        }
        script.Append("_g%2$s.render('%1$s');", strContainer, this.getUniqueID());
        this.getPage().RegisterScript(2, script.toString());
    }

    public SRFExDataGrid getDataGrid() {
        return this.dataGrid;
    }

    public void setDataGrid(SRFExDataGrid dataGrid) {
        this.dataGrid = dataGrid;
    }
}

