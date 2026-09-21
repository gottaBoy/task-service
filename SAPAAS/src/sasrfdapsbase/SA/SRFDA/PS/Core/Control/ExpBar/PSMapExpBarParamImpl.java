/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSMapExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSMapExpBarParamImpl
extends PSExpBarParamImpl
implements IPSMapExpBarParam {
    private static final Log log = LogFactory.getLog(PSExpBarParamImpl.class);
    private String strPSSysMapId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSSysMapId = this.psDEViewCtrl.getPSSYSMAPVIEWID();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSMapExpBarParam) {
            IPSMapExpBarParam iPSExpBarParam = (IPSMapExpBarParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSSysMapId())) {
                this.setPSSysMapId(iPSExpBarParam.getPSSysMapId());
            }
        }
    }

    @Override
    public String getPSSysMapId() {
        return this.strPSSysMapId;
    }

    protected void setPSSysMapId(String strPSSysMapId) {
        this.strPSSysMapId = strPSSysMapId;
    }
}

