/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.ChartCoordinateSystemCodeListModel
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemControl;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartCoordinateSystemRuntime;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.IPSChartSeriesEncode;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartCoordinateSystem;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartObjectImplBase;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartTitleImpl;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDEChart;
import SA.SRFDA.PS.Data.PSDEChartCS;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.ChartCoordinateSystemCodeListModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartCoordinateSystemImplBase
extends PSDEChartObjectImplBase
implements IPSDEChartCoordinateSystem,
IPSChartCoordinateSystemRuntime {
    private static final Log log = LogFactory.getLog(PSDEChartTitleImpl.class);
    private PSDEChart psDEChart = null;
    private int nAutoIndex = -1;
    private int nIndex = -1;
    private ArrayList<IPSChartSeries> psChartSeriesList = new ArrayList();
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private PSDEChartCS psDEChartCS = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChart iPSDEChart, PSDEChart psDEChart, PSDEChartCS csData) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDEChart(iPSDEChart);
            this.psDEChart = psDEChart;
            this.psDEChartCS = csData;
            this.nIndex = csData.GetParamIntValue("INDEX", this.nIndex);
            this.nAutoIndex = csData.GetParamIntValue("AUTOINDEX", this.nAutoIndex);
            this.setId(StringHelper.format((String)"%1$s_%2$s", (Object)this.psDEChart.getPSDECHARTID(), (Object)this.nAutoIndex));
            String strTypeName = ChartCoordinateSystemCodeListModel.getInstance().getCodeListText(this.getType(), true);
            String strName = csData.getParamStringValue("PSDECHARTPARAMNAME", "");
            if (StringHelper.isNullOrEmpty((String)strName)) {
                this.setName(StringHelper.format((String)"%1$s[%2$s]", (Object)strTypeName, (Object)this.nAutoIndex));
            } else {
                this.setName(StringHelper.format((String)"[%3$s]%1$s[%2$s]", (Object)strTypeName, (Object)this.nAutoIndex, (Object)strName));
            }
            this.setPSObjectData(csData);
            String strPSSysPFPluginId = csData.getParamStringValue("PSSYSPFPLUGINID", null);
            if (!StringHelper.isNullOrEmpty((String)strPSSysPFPluginId)) {
                this.iPSSysPFPlugin = this.getPSApplication().getPSSystem().getPSSysPFPlugin(strPSSysPFPluginId);
                this.getPSDEChart().getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
            }
            this.onInit();
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    protected PSDEChart getPSDEChartData() {
        return this.psDEChart;
    }

    protected PSDEChartCS getPSDEChartCSData() {
        return this.psDEChartCS;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTCOORDINATESYSTEM";
    }

    @Override
    public String getModelId() {
        return StringHelper.format((String)"%1$s#%2$s", (Object)this.getPSDEChart().getModelId(), (Object)super.getModelId());
    }

    @Override
    public String getFullModelName() {
        return StringHelper.format((String)"%1$s#\u5750\u6807\u7cfb%2$s", (Object)this.getPSDEChart().getFullModelName(), (Object)this.getIndex());
    }

    @Override
    @PSModelRTMeta(description="\u5750\u6807\u7cfb\u7c7b\u578b", codelist="ChartCoordinateSystem")
    public String getType() {
        return this.onGetType();
    }

    protected String onGetType() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5750\u6807\u7cfb\u7d22\u5f15")
    public int getIndex() {
        return this.nAutoIndex;
    }

    @Override
    public int getOriginIndex() {
        return this.nIndex;
    }

    @Override
    @PSModelRTMeta(description="ECharts\u5750\u6807\u7cfb\u7c7b\u578b")
    public String getEChartsType() {
        return this.onGetEChartsType();
    }

    protected String onGetEChartsType() {
        return this.getType().toLowerCase();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u5e8f\u5217\u96c6\u5408")
    public Iterator<IPSChartSeries> getPSChartSerieses() {
        if (this.psChartSeriesList == null || this.psChartSeriesList.size() == 0) {
            return null;
        }
        return this.psChartSeriesList.iterator();
    }

    @Override
    public void registerPSChartSeries(IPSChartSeries iPSChartSeries) {
        this.psChartSeriesList.add(iPSChartSeries);
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u5e8f\u5217\u6570\u91cf", dump=false)
    public int getPSChartSeriesCount() {
        return this.psChartSeriesList.size();
    }

    @Override
    public boolean testPSChartSeries(IPSChartSeries iPSChartSeries) {
        if (this.getMaxPSChartSeriesCount() == -1) {
            return true;
        }
        return this.getPSChartSeriesCount() < this.getMaxPSChartSeriesCount();
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u652f\u6301\u5e8f\u5217\u6570\u91cf", dump=false)
    public int getMaxPSChartSeriesCount() {
        return -1;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public IPSChartCoordinateSystemControl getPSChartCoordinateSystemControl() {
        return this.onGetPSChartCoordinateSystemControl();
    }

    protected IPSChartCoordinateSystemControl onGetPSChartCoordinateSystemControl() {
        return null;
    }

    @Override
    public IPSChartSeriesEncode createPSChartSeriesEncode() {
        return null;
    }
}

