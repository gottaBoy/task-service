/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.grid.IPSDEGridParam
 *  net.ibizsys.paas.util.StringHelper
 */
package net.ibizsys.model.control.grid;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.PSMDAjaxControlParamImpl;
import net.ibizsys.model.control.grid.IPSDEGridParam;
import net.ibizsys.paas.util.StringHelper;

public class PSDEGridParamImpl
extends PSMDAjaxControlParamImpl
implements IPSDEGridParam {
    private String strPSDEGridId = "";
    private Boolean bSingleSelect = null;
    private Boolean bEnableRowEdit = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.setPSDEGridId(this.psDEViewCtrl.getPSDEGRIDID());
        if (!this.psDEViewCtrl.isCTRLPARAM6Null()) {
            this.setEnableRowEdit(this.psDEViewCtrl.getCTRLPARAM6());
        }
        if (!this.psDEViewCtrl.isMULTISELECTNull()) {
            this.bSingleSelect = !this.psDEViewCtrl.getMULTISELECT();
        }
    }

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
            if (!StringHelper.isNullOrEmpty((String)iPSDEGridParam.getPSDEGridId())) {
                this.setPSDEGridId(iPSDEGridParam.getPSDEGridId());
            }
            if (iPSDEGridParam.isSingleSelect() != null) {
                this.setSingleSelect(iPSDEGridParam.isSingleSelect());
            }
            if (iPSDEGridParam.isEnableRowEdit() != null) {
                this.setEnableRowEdit(iPSDEGridParam.isEnableRowEdit());
            }
        }
    }

    public Boolean isSingleSelect() {
        if (this.bSingleSelect == null) {
            return null;
        }
        return this.bSingleSelect;
    }

    public void setSingleSelect(Boolean bSingleSelect) {
        this.bSingleSelect = bSingleSelect;
    }

    public Boolean isEnableRowEdit() {
        if (this.bEnableRowEdit == null) {
            return null;
        }
        return this.bEnableRowEdit;
    }

    public void setEnableRowEdit(Boolean bEnableRowEdit) {
        this.bEnableRowEdit = bEnableRowEdit;
    }
}

