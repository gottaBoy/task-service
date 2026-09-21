/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub;

import java.util.HashMap;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.PSJQCtrlCodePublisherImpl;

public class PSJQDEChartViewCodePublisherImpl
extends PSJQCtrlCodePublisherImpl {
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
        super.onFillGenerateCodeParams(params);
    }
}

