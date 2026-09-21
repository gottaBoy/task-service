/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.IPSControlParam
 *  net.ibizsys.model.control.form.IPSDESearchFormParam
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.control.IPSControlParam;
import net.ibizsys.model.control.form.IPSDESearchFormParam;
import net.ibizsys.model.control.form.PSDEFormParamImpl;

public class PSDESearchFormParamImpl
extends PSDEFormParamImpl
implements IPSDESearchFormParam {
    private Boolean bEnableAdvanceSearch = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        if (!this.psDEViewCtrl.isCTRLPARAM5Null()) {
            this.setEnableAdvanceSearch(this.psDEViewCtrl.getCTRLPARAM5());
        }
    }

    @Override
    protected void onMerge(IPSControlParam iPSControlParam) {
        IPSDESearchFormParam iPSDESearchFormParam;
        super.onMerge(iPSControlParam);
        if (iPSControlParam instanceof IPSDESearchFormParam && (iPSDESearchFormParam = (IPSDESearchFormParam)iPSControlParam).isEnableAdvanceSearch() != null) {
            this.setEnableAdvanceSearch(iPSDESearchFormParam.isEnableAdvanceSearch());
        }
    }

    public Boolean isEnableAdvanceSearch() {
        if (this.bEnableAdvanceSearch == null) {
            return null;
        }
        return this.bEnableAdvanceSearch;
    }

    public void setEnableAdvanceSearch(Boolean bEnableAdvanceSearch) {
        this.bEnableAdvanceSearch = bEnableAdvanceSearch;
    }
}

