/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSGanttExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSGanttExpBarParamImpl
extends PSExpBarParamImpl
implements IPSGanttExpBarParam {
    private static final Log log = LogFactory.getLog(PSExpBarParamImpl.class);
    private String strPSDETreeId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSDETreeId = this.psDEViewCtrl.getPSDETREEVIEWID();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSGanttExpBarParam) {
            IPSGanttExpBarParam iPSExpBarParam = (IPSGanttExpBarParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSDETreeId())) {
                this.setPSDETreeId(iPSExpBarParam.getPSDETreeId());
            }
        }
    }

    @Override
    public String getPSDETreeId() {
        return this.strPSDETreeId;
    }

    protected void setPSDETreeId(String strPSDETreeId) {
        this.strPSDETreeId = strPSDETreeId;
    }
}

