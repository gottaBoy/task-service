/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.PS.Core.Control.Chart.IPSDEChart
 *  SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes
 *  SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries
 *  SA.SRFDA.PS.Core.Control.IPSControl
 *  SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult
 *  SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher
 *  SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.Control.Chart.IPSDEChart;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartAxes;
import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartSeries;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSPFCtrlPartCodePublisher;
import SA.SRFDA.PS.Core.Pub.PSExtJS5CtrlCodePublisherImpl;
import SA.SRFDA.PS.Core.Pub.PSGenerateCodeResultImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class PSExtJS5DEChartViewCodePublisherImpl
extends PSExtJS5CtrlCodePublisherImpl {
    protected IPSDEChart iPSDEChart = null;
    public static final String CTRLPART_STORE = "STORE";
    public static final String CTRLPART_AXES = "AXES";
    public static final String CTRLPART_SERIES = "SERIES";

    protected PSGenerateCodeResultImpl onGenerateCode() throws Exception {
        this.iPSDEChart = (IPSDEChart)this.iPSControl;
        return super.onGenerateCode();
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        IPSGenerateCodeResult iPSGenerateCodeResult;
        super.onFillGenerateCodeParams(params);
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.iPSPFCtrlTempl.getPSPFCtrlTemplDetail(CTRLPART_STORE).getPSPFCtrlPartCodePublisher();
        IPSGenerateCodeResult iPSGenerateCodeResult2 = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEChart, null);
        iPSPFCtrlPartCodePublisher.close();
        params.put("store", iPSGenerateCodeResult2);
        iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_AXES).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEChartAxeses = this.iPSDEChart.getPSDEChartAxeses();
        while (psDEChartAxeses.hasNext()) {
            IPSDEChartAxes iPSDEChartAxes = (IPSDEChartAxes)psDEChartAxeses.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEChart, (Object)iPSDEChartAxes);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("axeses", gridRecordList);
        iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_SERIES).getPSPFCtrlPartCodePublisher();
        gridRecordList = new ArrayList();
        Iterator psDEChartSerieses = this.iPSDEChart.getPSDEChartSerieses();
        while (psDEChartSerieses.hasNext()) {
            IPSDEChartSeries iPSDEChartSeries = (IPSDEChartSeries)psDEChartSerieses.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode(this.iPSPublisherContext, (IPSControl)this.iPSDEChart, (Object)iPSDEChartSeries);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        iPSPFCtrlPartCodePublisher.close();
        params.put("serieses", gridRecordList);
    }

    protected void onClose() {
        this.iPSDEChart = null;
        super.onClose();
    }
}

