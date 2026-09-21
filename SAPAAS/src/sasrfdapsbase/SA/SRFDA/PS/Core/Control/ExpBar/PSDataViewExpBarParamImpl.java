/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.ExpBar;

import SA.SRFDA.PS.Core.Control.ExpBar.IPSDataViewExpBarParam;
import SA.SRFDA.PS.Core.Control.ExpBar.PSExpBarParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelRTIgnoreMeta
public class PSDataViewExpBarParamImpl
extends PSExpBarParamImpl
implements IPSDataViewExpBarParam {
    private static final Log log = LogFactory.getLog(PSExpBarParamImpl.class);
    private String strPSDEDataViewId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.strPSDEDataViewId = this.psDEViewCtrl.getPSDEDATAVIEWID();
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDataViewExpBarParam) {
            IPSDataViewExpBarParam iPSExpBarParam = (IPSDataViewExpBarParam)iPSControlParam;
            if (StringHelper.isNullOrEmpty((String)this.getPSDEDataViewId())) {
                this.setPSDEDataViewId(iPSExpBarParam.getPSDEDataViewId());
            }
        }
    }

    @Override
    public String getPSDEDataViewId() {
        return this.strPSDEDataViewId;
    }

    protected void setPSDEDataViewId(String strPSDEDataViewId) {
        this.strPSDEDataViewId = strPSDEDataViewId;
    }
}

