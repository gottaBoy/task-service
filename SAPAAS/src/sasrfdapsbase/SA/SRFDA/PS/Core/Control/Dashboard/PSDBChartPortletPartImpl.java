/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Dashboard;

import SA.SRFDA.PS.Core.Control.Chart.IPSChart;
import SA.SRFDA.PS.Core.Control.Chart.PSDEChartParamImpl;
import SA.SRFDA.PS.Core.Control.Dashboard.IPSDBChartPortlet;
import SA.SRFDA.PS.Core.Control.Dashboard.PSDBSysPortletPartImpl;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSSysDEChartPortlet;
import net.ibizsys.paas.util.StringHelper;

@PSModelImplementMeta(implement="IPSDBPortletPart", typevalues={"CHART"})
public class PSDBChartPortletPartImpl
extends PSDBSysPortletPartImpl
implements IPSDBChartPortlet {
    public static final String CHARTNAME = "_chart";
    private IPSChart iPSChart = null;

    @Override
    protected void onInit() throws Exception {
        IPSSysDEChartPortlet iPSSysDEChartPortlet = (IPSSysDEChartPortlet)this.iPSSysPortlet;
        PSDEChartParamImpl psDEChartParamImpl = new PSDEChartParamImpl();
        psDEChartParamImpl.setPSDEChartId(iPSSysDEChartPortlet.getPSDEChartId());
        psDEChartParamImpl.setPSDEDataSetId(iPSSysDEChartPortlet.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)psDEChartParamImpl.getPSDEDataSetId())) {
            psDEChartParamImpl.setCustomCond(iPSSysDEChartPortlet.getCustomCond());
        }
        psDEChartParamImpl.setActiveDataPSDELogicId(iPSSysDEChartPortlet.getActiveDataPSDELogicId());
        if (iPSSysDEChartPortlet.getHeight() > 0) {
            psDEChartParamImpl.setHeight(Double.valueOf(iPSSysDEChartPortlet.getHeight()));
        }
        this.iPSChart = (IPSChart)this.registerPSControl(String.valueOf(this.getName()) + CHARTNAME, "CHART", psDEChartParamImpl);
        super.onInit();
    }

    @Override
    public IPSChart getPSChart() {
        return this.iPSChart;
    }

    @Override
    @PSModelRTMeta(description="\u5185\u5bb9\u90e8\u4ef6", dumpref=true, modelreftype="LINK", from="__self__", from_method="getPSControl")
    public IPSControl getContentPSControl() {
        return this.getPSChart();
    }
}

