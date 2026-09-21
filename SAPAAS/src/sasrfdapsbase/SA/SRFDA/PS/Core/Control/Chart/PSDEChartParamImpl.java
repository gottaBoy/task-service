/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Chart;

import SA.SRFDA.PS.Core.Control.Chart.IPSDEChartParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEChartParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDEChartParam {
    private String strPSDEChartId = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEChartId(this.psDEViewCtrl.getPSDECHARTID());
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        IPSDEChartParam iPSDEChartParam;
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEChartParam && !StringHelper.IsNullOrEmpty((String)(iPSDEChartParam = (IPSDEChartParam)iPSControlParam).getPSDEChartId())) {
            this.setPSDEChartId(iPSDEChartParam.getPSDEChartId());
        }
    }

    @Override
    public String getPSDEChartId() {
        return this.strPSDEChartId;
    }

    public void setPSDEChartId(String strPSDEChartId) {
        this.strPSDEChartId = strPSDEChartId;
    }
}

