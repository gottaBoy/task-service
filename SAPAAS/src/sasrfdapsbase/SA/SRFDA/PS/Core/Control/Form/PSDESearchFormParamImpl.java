/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Form;

import SA.SRFDA.PS.Core.Control.Form.IPSDESearchFormParam;
import SA.SRFDA.PS.Core.Control.Form.PSDEFormParamImpl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;

@PSModelRTIgnoreMeta
public class PSDESearchFormParamImpl
extends PSDEFormParamImpl
implements IPSDESearchFormParam {
    private Boolean bEnableAdvanceSearch = null;
    private Boolean bEnableAutoSearch = null;
    private Boolean bEnableFilterSave = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psDEViewCtrl.isCTRLPARAM5Null()) {
            this.setEnableAdvanceSearch(this.psDEViewCtrl.getCTRLPARAM5());
        }
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            this.setEnableAutoSearch(this.psDEViewCtrl.getCTRLPARAM6());
        }
        if (!this.psDEViewCtrl.isCTRLPARAM7Null()) {
            this.setEnableFilterSave(this.psDEViewCtrl.getCTRLPARAM7() == 1);
        }
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDESearchFormParam) {
            IPSDESearchFormParam iPSDESearchFormParam = (IPSDESearchFormParam)iPSControlParam;
            if (iPSDESearchFormParam.isEnableAdvanceSearch() != null) {
                this.setEnableAdvanceSearch(iPSDESearchFormParam.isEnableAdvanceSearch());
            }
            if (iPSDESearchFormParam.isEnableAutoSearch() != null) {
                this.setEnableAutoSearch(iPSDESearchFormParam.isEnableAutoSearch());
            }
            if (iPSDESearchFormParam.isEnableFilterSave() != null) {
                this.setEnableFilterSave(iPSDESearchFormParam.isEnableFilterSave());
            }
        }
    }

    @Override
    public Boolean isEnableAdvanceSearch() {
        if (this.bEnableAdvanceSearch == null) {
            return null;
        }
        return this.bEnableAdvanceSearch;
    }

    public void setEnableAdvanceSearch(Boolean bEnableAdvanceSearch) {
        this.bEnableAdvanceSearch = bEnableAdvanceSearch;
    }

    @Override
    public Boolean isEnableAutoSearch() {
        if (this.bEnableAutoSearch == null) {
            return null;
        }
        return this.bEnableAutoSearch;
    }

    public void setEnableAutoSearch(Boolean bEnableAutoSearch) {
        this.bEnableAutoSearch = bEnableAutoSearch;
    }

    @Override
    public Boolean isEnableFilterSave() {
        if (this.bEnableFilterSave == null) {
            return null;
        }
        return this.bEnableFilterSave;
    }

    public void setEnableFilterSave(Boolean bEnableFilterSave) {
        this.bEnableFilterSave = bEnableFilterSave;
    }
}

