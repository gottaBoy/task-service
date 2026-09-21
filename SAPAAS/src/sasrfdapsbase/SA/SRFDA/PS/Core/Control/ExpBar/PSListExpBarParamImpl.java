/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSListExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSListExpBarParamImpl
extends PSExpBarParamImpl
implements IPSListExpBarParam {
    private static final Log log = LogFactory.getLog(PSExpBarParamImpl.class);
    private String strPSDEListId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSDEListId = this.psDEViewCtrl.getPSDELISTID();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSListExpBarParam) {
            IPSListExpBarParam iPSExpBarParam = (IPSListExpBarParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSDEListId())) {
                this.setPSDEListId(iPSExpBarParam.getPSDEListId());
            }
        }
    }

    @Override
    public String getPSDEListId() {
        return this.strPSDEListId;
    }

    protected void setPSDEListId(String strPSDEListId) {
        this.strPSDEListId = strPSDEListId;
    }
}

