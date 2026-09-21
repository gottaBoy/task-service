/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.control.chart.IPSDEChartAxes
 *  net.ibizsys.model.control.chart.IPSDEChartSeries
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.control.chart.IPSDEChartAxes;
import net.ibizsys.model.control.chart.IPSDEChartSeries;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSExtJS5CtrlCodePublisherImpl;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;

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
        IPSGenerateCodeResult iPSGenerateCodeResult2 = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEChart, null);
        params.put("store", iPSGenerateCodeResult2);
        iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_AXES).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psDEChartAxeses = this.iPSDEChart.getPSDEChartAxeses();
        while (psDEChartAxeses.hasNext()) {
            IPSDEChartAxes iPSDEChartAxes = (IPSDEChartAxes)psDEChartAxeses.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEChart, (Object)iPSDEChartAxes);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        params.put("axeses", gridRecordList);
        iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_SERIES).getPSPFCtrlPartCodePublisher();
        gridRecordList = new ArrayList();
        Iterator psDEChartSerieses = this.iPSDEChart.getPSDEChartSerieses();
        while (psDEChartSerieses.hasNext()) {
            IPSDEChartSeries iPSDEChartSeries = (IPSDEChartSeries)psDEChartSerieses.next();
            iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEChart, (Object)iPSDEChartSeries);
            gridRecordList.add(iPSGenerateCodeResult);
        }
        params.put("serieses", gridRecordList);
    }
}

