/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeriesEncode;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeriesEncodeRuntime;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartObjectImplBase;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartSeriesEncodeImplBase
extends PSDEChartObjectImplBase
implements IPSDEChartSeriesEncode,
IPSDEChartSeriesEncodeRuntime {
    private static final Log log = LogFactory.getLog(PSDEChartSeriesEncodeImplBase.class);
    private IPSDEChartSeries iPSDEChartSeries = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChartSeries iPSDEChartSeries) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEChartSeries = iPSDEChartSeries;
            this.setPSDEChart(iPSDEChartSeries.getPSDEChart());
            this.setId(this.getPSDEChartSeries().getId());
            this.setName("\u5750\u6807\u7cfb\u7f16\u7801");
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = net.ibizsys.paas.util.StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = net.ibizsys.paas.util.StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)net.ibizsys.paas.util.StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    public IPSChartSeries getPSChartSeries() {
        return this.getPSDEChartSeries();
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u8868\u5e8f\u5217")
    public IPSDEChartSeries getPSDEChartSeries() {
        return this.iPSDEChartSeries;
    }

    @Override
    @PSModelRTMeta(description="\u63d0\u793a\u7ef4\u5ea6\u96c6\u5408")
    public String[] getTooltip() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e8f\u5217\u7ef4\u5ea6\u96c6\u5408")
    public String[] getSeriesName() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e8f\u5217\u6807\u8bc6\u7ef4\u5ea6")
    public String getItemId() {
        if (StringHelper.IsNullOrEmpty((String)this.getPSDEChartSeries().getIdField())) {
            return this.getPSDEChartSeries().getSeriesField();
        }
        return this.getPSDEChartSeries().getIdField();
    }

    @Override
    @PSModelRTMeta(description="\u5e8f\u5217\u540d\u79f0\u7ef4\u5ea6")
    public String getItemName() {
        return this.getPSDEChartSeries().getSeriesField();
    }

    @Override
    public String getModelType() {
        return "PSDECHARTSERIESENCODE";
    }

    @Override
    public String getModelId() {
        return StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEChartSeries().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return net.ibizsys.paas.util.StringHelper.format((String)"%1$s\u7f16\u7801", (Object)this.getPSDEChart().getFullModelName());
    }

    @Override
    @PSModelRTMeta(description="\u5750\u6807\u7cfb\u7c7b\u578b", codelist="ChartCoordinateSystem")
    public String getType() {
        return this.onGetType();
    }

    protected String onGetType() {
        return null;
    }
}

