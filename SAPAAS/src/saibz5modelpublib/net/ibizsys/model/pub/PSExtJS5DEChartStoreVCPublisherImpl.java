/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.chart.IPSChartDataItem
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.pub.IPSGenerateCodeResult
 *  net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher
 */
package net.ibizsys.model.pub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.chart.IPSChartDataItem;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.pub.IPSGenerateCodeResult;
import net.ibizsys.model.pub.IPSPFCtrlPartCodePublisher;
import net.ibizsys.model.pub.PSExtJS5CtrlPartCodePublisherImpl;

public class PSExtJS5DEChartStoreVCPublisherImpl
extends PSExtJS5CtrlPartCodePublisherImpl {
    public static final String CTRLPART_RECORD = "RECORD";
    protected IPSDEChart iPSDEChart = null;

    public IPSGenerateCodeResult generateCode(IPSControl iPSControl, Object object) throws Exception {
        this.iPSDEChart = (IPSDEChart)iPSControl;
        return super.generateCode(iPSControl, object);
    }

    @Override
    protected void onFillGenerateCodeParams(HashMap<String, Object> params) throws Exception {
        super.onFillGenerateCodeParams(params);
        IPSPFCtrlPartCodePublisher iPSPFCtrlPartCodePublisher = this.getPSPFCtrlTempl().getPSPFCtrlTemplDetail(CTRLPART_RECORD).getPSPFCtrlPartCodePublisher();
        ArrayList<IPSGenerateCodeResult> gridRecordList = new ArrayList<IPSGenerateCodeResult>();
        Iterator psChartDataItems = this.iPSDEChart.getPSChartDataItems();
        if (psChartDataItems != null) {
            while (psChartDataItems.hasNext()) {
                IPSChartDataItem iPSChartDataItem = (IPSChartDataItem)psChartDataItems.next();
                IPSGenerateCodeResult iPSGenerateCodeResult = iPSPFCtrlPartCodePublisher.generateCode((IPSControl)this.iPSDEChart, (Object)iPSChartDataItem);
                gridRecordList.add(iPSGenerateCodeResult);
            }
        }
        params.put("records", gridRecordList);
    }
}

