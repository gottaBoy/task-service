/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSChartExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSChartExpBarParamImpl
extends PSExpBarParamImpl
implements IPSChartExpBarParam {
    private static final Log log = LogFactory.getLog(PSExpBarParamImpl.class);
    private String strPSDEChartId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSDEChartId = this.psDEViewCtrl.getPSDECHARTID();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSChartExpBarParam) {
            IPSChartExpBarParam iPSExpBarParam = (IPSChartExpBarParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSDEChartId())) {
                this.setPSDEChartId(iPSExpBarParam.getPSDEChartId());
            }
        }
    }

    @Override
    public String getPSDEChartId() {
        return this.strPSDEChartId;
    }

    protected void setPSDEChartId(String strPSDEChartId) {
        this.strPSDEChartId = strPSDEChartId;
    }
}

