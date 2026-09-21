/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.List;

import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.List.IPSDEListParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEListParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDEListParam {
    private String strPSDEListId = null;
    private Boolean bSingleSelect = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEListId(this.psDEViewCtrl.getPSDELISTID());
        if (!this.psDEViewCtrl.isMULTISELECTNull()) {
            this.bSingleSelect = !this.psDEViewCtrl.getMULTISELECT();
        }
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEListParam) {
            IPSDEListParam iPSDEListParam = (IPSDEListParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty((String)iPSDEListParam.getPSDEListId())) {
                this.setPSDEListId(iPSDEListParam.getPSDEListId());
            }
            if (iPSDEListParam.isSingleSelect() != null) {
                this.setSingleSelect(iPSDEListParam.isSingleSelect());
            }
        }
    }

    @Override
    public String getPSDEListId() {
        return this.strPSDEListId;
    }

    public void setPSDEListId(String strPSDEListId) {
        this.strPSDEListId = strPSDEListId;
    }

    @Override
    public Boolean isSingleSelect() {
        return this.bSingleSelect;
    }

    public void setSingleSelect(Boolean bSingleSelect) {
        this.bSingleSelect = bSingleSelect;
    }
}

