/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.chart.IPSDEChart
 *  net.ibizsys.model.pub.PSGenerateCodeResultImpl
 */
package net.ibizsys.model.pub.vuemob;

import java.util.HashMap;
import net.ibizsys.model.control.chart.IPSDEChart;
import net.ibizsys.model.pub.PSGenerateCodeResultImpl;
import net.ibizsys.model.pub.vuemob.PSVueMobCtrlCodePublisherImpl;

public class PSVueMobDEChartViewCodePublisherImpl
extends PSVueMobCtrlCodePublisherImpl {
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
        this.iPSDEChart = (IPSDEChart)this.iPSControl;
        super.onFillGenerateCodeParams(params);
    }

    protected void onClose() {
        throw new Error("Unresolved compilation problems: \n\tThe method onClose() of type PSVueMobDEChartViewCodePublisherImpl must override or implement a supertype method\n\tThe method onClose() is undefined for the type PSVueMobCtrlCodePublisherImpl\n");
    }
}

