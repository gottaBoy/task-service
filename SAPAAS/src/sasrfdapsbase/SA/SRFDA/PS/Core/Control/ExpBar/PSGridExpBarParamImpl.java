/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSGridExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSGridExpBarParamImpl
extends PSExpBarParamImpl
implements IPSGridExpBarParam {
    private static final Log log = LogFactory.getLog(PSExpBarParamImpl.class);
    private String strPSDEGridId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSDEGridId = this.psDEViewCtrl.getPSDEGRIDID();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSGridExpBarParam) {
            IPSGridExpBarParam iPSExpBarParam = (IPSGridExpBarParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSDEGridId())) {
                this.setPSDEGridId(iPSExpBarParam.getPSDEGridId());
            }
        }
    }

    @Override
    public String getPSDEGridId() {
        return this.strPSDEGridId;
    }

    protected void setPSDEGridId(String strPSDEGridId) {
        this.strPSDEGridId = strPSDEGridId;
    }
}

