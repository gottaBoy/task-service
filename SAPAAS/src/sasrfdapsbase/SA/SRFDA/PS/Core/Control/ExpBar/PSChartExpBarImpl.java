/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartParamImpl;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSChartExpBar;
import SA.SRFDA.PS.Core.Control.ExpBar.IPSChartExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSMDControlExpBarImplBase2;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.Iterator;

@PSModelImplementMeta(implement="IPSControl", typevalues={"CHARTEXPBAR"})
public class PSChartExpBarImpl
extends PSMDControlExpBarImplBase2
implements IPSChartExpBar {
    public static final String CHARTNAME = "_chart";
    private IPSDEChart iPSDEChart = null;
    private IPSChartExpBarParam iPSChartExpBarParam = null;

    @Override
    protected void onInit() throws Exception {
        this.iPSChartExpBarParam = (IPSChartExpBarParam)this.getPSControlParam();
        PSDEChartParamImpl psDEChartParamImpl = new PSDEChartParamImpl();
        PSDEViewCtrl gridPSDEViewCtrl = new PSDEViewCtrl();
        gridPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + CHARTNAME);
        gridPSDEViewCtrl.setPSDECHARTID(this.iPSChartExpBarParam.getPSDEChartId());
        gridPSDEViewCtrl.setPSACHANDLERID(this.iPSChartExpBarParam.getPSDEViewCtrlData().getSUBPSACHANDLERID());
        psDEChartParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), gridPSDEViewCtrl);
        if (this.iPSChartExpBarParam.getCtrlParamNames() != null) {
            Iterator<String> ctrlParamNames = this.iPSChartExpBarParam.getCtrlParamNames();
            while (ctrlParamNames.hasNext()) {
                String strKey = ctrlParamNames.next();
                psDEChartParamImpl.setCtrlParam(strKey, this.iPSChartExpBarParam.getCtrlParam(strKey));
            }
        }
        this.iPSDEChart = (IPSDEChart)this.registerPSControl(String.valueOf(this.getName()) + CHARTNAME, "CHART", psDEChartParamImpl);
        super.onInit();
        Iterator<IPSDEChartSeries> psDEChartSeriess = this.getPSDEChart().getPSDEChartSerieses();
        if (psDEChartSeriess != null) {
            while (psDEChartSeriess.hasNext()) {
                IPSDEChartSeries iPSDEChartSeries = psDEChartSeriess.next();
                this.registerPSControlObjectNavigatable(iPSDEChartSeries);
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u8868\u90e8\u4ef6")
    public IPSDEChart getPSDEChart() {
        return this.iPSDEChart;
    }

    @Override
    protected String onGetControlType() {
        return "CHARTEXPBAR";
    }

    @Override
    protected IPSControl onGetXDataPSControl() {
        return this.getPSDEChart();
    }
}

