/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Map;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.Map.IPSSysMapParam;
import SA.SRFDA.PS.Core.Control.Map.PSMapParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSSysMapParamImpl
extends PSMapParamImpl
implements IPSSysMapParam {
    private String strPSSysMapViewId = "";

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSSysMapViewId(this.psDEViewCtrl.getPSSYSMAPVIEWID());
    }

    @Override
    public String getPSSysMapViewId() {
        return this.strPSSysMapViewId;
    }

    public void setPSSysMapViewId(String strPSSysMapViewId) {
        this.strPSSysMapViewId = strPSSysMapViewId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSSysMapParam) {
            IPSSysMapParam iPSSysCalendarBarParam = (IPSSysMapParam)iPSControlParam;
            if (StringHelper.IsNullOrEmpty((String)this.getPSSysMapViewId())) {
                this.setPSSysMapViewId(iPSSysCalendarBarParam.getPSSysMapViewId());
            }
        }
    }
}

