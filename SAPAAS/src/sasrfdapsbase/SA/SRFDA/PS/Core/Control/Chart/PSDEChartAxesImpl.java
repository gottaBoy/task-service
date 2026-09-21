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

import SA.SRFDA.PS.Core.Control.Chart.IPSChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.PSChartAxesImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Data.PSDEChartAxes;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEChartAxesImpl
extends PSChartAxesImpl
implements IPSDEChartAxes {
    private static final Log log = LogFactory.getLog(PSDEChartAxesImpl.class);
    private IPSDEChart iPSDEChart;
    private PSDEChartAxes psDEChartAxes;
    private ArrayList<String> fieldList = new ArrayList();
    private String[] fields = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private int nDataShowMode = 0;
    private Double fMaxValue = null;
    private Double fMinValue = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private int nCoordinateSystemIndex = -1;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSDEChart iPSDEChart, PSDEChartAxes psDEChartAxes) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.iPSDEChart = iPSDEChart;
            this.psDEChartAxes = psDEChartAxes;
            this.setId(this.psDEChartAxes.getPSDECHARTAXESID());
            this.setName(this.psDEChartAxes.getPSDECHARTAXESNAME());
            this.setPSObjectData(this.psDEChartAxes);
            if (!this.psDEChartAxes.isDATASHOWMODENull()) {
                this.nDataShowMode = this.psDEChartAxes.getDATASHOWMODE();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartAxes.getFIELDS())) {
                String[] fields;
                String[] stringArray = fields = SA.SRFramework.Utility.StringHelper.SplitEx((String)this.psDEChartAxes.getFIELDS());
                int n = fields.length;
                int n2 = 0;
                while (n2 < n) {
                    String strField = stringArray[n2];
                    this.fieldList.add(strField.trim().toLowerCase());
                    ++n2;
                }
            }
            this.fields = new String[this.fieldList.size()];
            this.fields = this.fieldList.toArray(this.fields);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartAxes.getCAPPSLANRESID())) {
                this.capPSLanguageRes = this.iPSDEChart.getPSAppView().getPSApplication().getPSLanguageRes(this.psDEChartAxes.getCAPPSLANRESID());
            }
            if (!this.psDEChartAxes.isAXESMAXVALUENull()) {
                this.fMaxValue = this.psDEChartAxes.GetParamDoubleValue("AXESMAXVALUE", 0.0);
            }
            if (!this.psDEChartAxes.isAXESMINVALUENull()) {
                this.fMinValue = this.psDEChartAxes.GetParamDoubleValue("AXESMINVALUE", 0.0);
            }
            if (!this.psDEChartAxes.isCOORDINATESYSTEMIDNull()) {
                this.nCoordinateSystemIndex = this.psDEChartAxes.getCOORDINATESYSTEMID();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEChartAxes.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = iPSDEChart.getPSAppView().getPSSystem().getPSSysPFPlugin(this.psDEChartAxes.getPSSYSPFPLUGINID());
                this.iPSDEChart.getPSAppView().registerPSSysPFPlugin(this.iPSSysPFPlugin);
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

    @Override
    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        return this.psDEChartAxes.getCAPTION();
    }

    @Override
    @PSModelRTMeta(description="\u5750\u6807\u8f74\u7c7b\u578b", codelist="ChartAxesType", fields={"AXESTYPE"})
    public String getAxesType() {
        return this.psDEChartAxes.getAXESTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u5750\u6807\u8f74\u4f4d\u7f6e", codelist="ChartAxesPos", fields={"AXESPOS"})
    public String getAxesPos() {
        return this.psDEChartAxes.getAXESPOS();
    }

    @Override
    public IPSChart getPSChart() {
        return this.iPSDEChart;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u56fe\u8868\u5bf9\u8c61")
    public IPSDEChart getPSDEChart() {
        return this.iPSDEChart;
    }

    @Override
    public String[] getFields() {
        return this.fields;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.iPSDEChart.getPSSysModelInstId();
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u663e\u793a\u6a21\u5f0f", codelist="ChartAxesDataShowMode", ignoredumpvalues="0", fields={"DATASHOWMODE"})
    public int getDataShowMode() {
        return this.nDataShowMode;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5927\u503c", fields={"AXESMAXVALUE"})
    public Double getMaxValue() {
        return this.fMaxValue;
    }

    @Override
    @PSModelRTMeta(description="\u6700\u5c0f\u503c", fields={"AXESMINVALUE"})
    public Double getMinValue() {
        return this.fMinValue;
    }

    @Override
    public String getModelType() {
        return "PSDECHARTAXES";
    }

    @Override
    public String getModelId() {
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSDEChart().getModelId(), (Object)this.getName());
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSDEChart().getPSAppView().getPSSystem());
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    @PSModelRTMeta(description="\u5750\u6807\u7cfb\u7edf\u7d22\u5f15", fields={"COORDINATESYSTEMID"})
    public int getCoordinateSystemIndex() {
        return this.nCoordinateSystemIndex;
    }

    @Override
    protected IPSSysDynaModel internalGetPSSysDynaModel(String strPSSysDynaModelId) throws Exception {
        return this.getPSDEChart().getPSAppView().getPSSystem().getPSSysDynaModel(strPSSysDynaModelId);
    }

    @Override
    public IPSControl getOwnedPSControl() {
        return this.getPSDEChart();
    }
}

