/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Grid;

import SA.SRFDA.PS.Core.Control.Grid.IPSDEGridParam;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSMDAjaxControlParamImpl;
import SA.SRFDA.PS.Core.PSModelRTIgnoreMeta;
import SA.SRFramework.Utility.StringHelper;

@PSModelRTIgnoreMeta
public class PSDEGridParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDEGridParam {
    private String strPSDEGridId = "";
    private Boolean bSingleSelect = null;
    private Boolean bEnableRowEdit = null;
    private Boolean bEnableColFilter = null;
    private Boolean bEnableCustomized = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEGridId(this.psDEViewCtrl.getPSDEGRIDID());
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            int nEditMode = this.psDEViewCtrl.GetParamIntValue("CTRLPARAM6", 0);
            this.setEnableRowEdit((nEditMode & 1) == 1);
        }
        if (!this.psDEViewCtrl.isCTRLPARAM8Null()) {
            this.setEnableColFilter(this.psDEViewCtrl.getCTRLPARAM8() == 1);
        }
        if (!this.psDEViewCtrl.isMULTISELECTNull()) {
            this.bSingleSelect = !this.psDEViewCtrl.getMULTISELECT();
        }
        if (!this.psDEViewCtrl.isCTRLPARAM7Null()) {
            this.setEnableCustomized(this.psDEViewCtrl.getCTRLPARAM7() == 1);
        }
    }

    @Override
    public String getPSDEGridId() {
        return this.strPSDEGridId;
    }

    public void setPSDEGridId(String strPSDEGridId) {
        this.strPSDEGridId = strPSDEGridId;
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDEGridParam) {
            IPSDEGridParam iPSDEGridParam = (IPSDEGridParam)iPSControlParam;
            if (!StringHelper.IsNullOrEmpty((String)iPSDEGridParam.getPSDEGridId())) {
                this.setPSDEGridId(iPSDEGridParam.getPSDEGridId());
            }
            if (iPSDEGridParam.isSingleSelect() != null) {
                this.setSingleSelect(iPSDEGridParam.isSingleSelect());
            }
            if (iPSDEGridParam.isEnableRowEdit() != null) {
                this.setEnableRowEdit(iPSDEGridParam.isEnableRowEdit());
            }
            if (iPSDEGridParam.isEnableColFilter() != null) {
                this.setEnableColFilter(iPSDEGridParam.isEnableColFilter());
            }
            if (iPSDEGridParam.isEnableCustomized() != null) {
                this.setEnableCustomized(iPSDEGridParam.isEnableCustomized());
            }
        }
    }

    @Override
    public Boolean isSingleSelect() {
        if (this.bSingleSelect == null) {
            return null;
        }
        return this.bSingleSelect;
    }

    public void setSingleSelect(Boolean bSingleSelect) {
        this.bSingleSelect = bSingleSelect;
    }

    @Override
    public Boolean isEnableRowEdit() {
        if (this.bEnableRowEdit == null) {
            return null;
        }
        return this.bEnableRowEdit;
    }

    public void setEnableRowEdit(Boolean bEnableRowEdit) {
        this.bEnableRowEdit = bEnableRowEdit;
    }

    @Override
    public Boolean isEnableColFilter() {
        if (this.bEnableColFilter == null) {
            return null;
        }
        return this.bEnableColFilter;
    }

    public void setEnableColFilter(Boolean bEnableColFilter) {
        this.bEnableColFilter = bEnableColFilter;
    }

    @Override
    public Boolean isEnableCustomized() {
        if (this.bEnableCustomized == null) {
            return null;
        }
        return this.bEnableCustomized;
    }

    public void setEnableCustomized(Boolean bEnableCustomized) {
        this.bEnableCustomized = bEnableCustomized;
    }
}

