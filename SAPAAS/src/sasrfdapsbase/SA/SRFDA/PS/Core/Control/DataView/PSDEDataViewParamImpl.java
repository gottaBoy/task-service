/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.DataView;

import SA.SRFDA.PS.Core.Control.DataView.IPSDEDataViewParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEDataViewParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDEDataViewParam {
    private String strPSDEDataViewId = "";
    private Boolean bSingleSelect = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEDataViewId(this.psDEViewCtrl.getPSDEDATAVIEWID());
        if (!this.psDEViewCtrl.isMULTISELECTNull()) {
            this.bSingleSelect = !this.psDEViewCtrl.getMULTISELECT();
        }
    }

    @Override
    public String getPSDEDataViewId() {
        return this.strPSDEDataViewId;
    }

    public void setPSDEDataViewId(String strPSDEDataViewId) {
        this.strPSDEDataViewId = strPSDEDataViewId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEDataViewParam) {
            IPSDEDataViewParam iPSDEDataViewParam = (IPSDEDataViewParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty((String)iPSDEDataViewParam.getPSDEDataViewId())) {
                this.setPSDEDataViewId(iPSDEDataViewParam.getPSDEDataViewId());
            }
            if (iPSDEDataViewParam.isSingleSelect() != null) {
                this.setSingleSelect(iPSDEDataViewParam.isSingleSelect());
            }
        }
    }

    @Override
    public Boolean isSingleSelect() {
        return this.bSingleSelect;
    }

    public void setSingleSelect(Boolean bSingleSelect) {
        this.bSingleSelect = bSingleSelect;
    }
}

