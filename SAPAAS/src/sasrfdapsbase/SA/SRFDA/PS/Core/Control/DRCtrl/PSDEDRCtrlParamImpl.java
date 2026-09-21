/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.DRCtrl;

import SA.SRFDA.PS.Core.Control.DRCtrl.IPSDEDRCtrlParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEDRCtrlParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDEDRCtrlParam {
    private String strPSDEDRId = "";
    private String strPSSysCounterId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEDRId(this.psDEViewCtrl.getPSDEDRID());
        this.setPSSysCounterId(this.psDEViewCtrl.getPSSYSCOUNTERID());
    }

    @Override
    public String getPSDEDRId() {
        return this.strPSDEDRId;
    }

    public void setPSDEDRId(String strPSDEDRId) {
        this.strPSDEDRId = strPSDEDRId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEDRCtrlParam) {
            IPSDEDRCtrlParam iPSDEDRCtrlParam = (IPSDEDRCtrlParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSDEDRId())) {
                this.setPSDEDRId(iPSDEDRCtrlParam.getPSDEDRId());
            }
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysCounterId())) {
                this.setPSSysCounterId(iPSDEDRCtrlParam.getPSSysCounterId());
            }
        }
    }

    @Override
    public String getPSSysCounterId() {
        return this.strPSSysCounterId;
    }

    protected void setPSSysCounterId(String strPSSysCounterId) {
        this.strPSSysCounterId = strPSSysCounterId;
    }
}

