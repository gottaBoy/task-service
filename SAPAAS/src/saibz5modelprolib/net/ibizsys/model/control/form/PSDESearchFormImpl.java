/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.control.form.IPSDESearchForm
 */
package net.ibizsys.model.control.form;

import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.control.form.IPSDESearchForm;
import net.ibizsys.model.control.form.PSDEFormImpl;
import net.ibizsys.model.control.form.PSDEFormParamImpl;
import net.ibizsys.model.control.form.PSDESearchFormParamImpl;

public class PSDESearchFormImpl
extends PSDEFormImpl
implements IPSDESearchForm {
    public static final String PFSTYLEPARAM_SEARCHFORM_LABLEWIDTH = "SEARCHFORM.LABLEWIDTH";
    protected PSDESearchFormParamImpl psDESearchFormParamImpl = null;
    protected boolean bEnableAdvanceSearch = false;

    @Override
    protected void onPreparePSDEFormLayout() throws Exception {
        if (!this.psDEForm.isENABLEADVSEARCHNull()) {
            this.bEnableAdvanceSearch = this.psDEForm.getENABLEADVSEARCH();
        }
        if (this.psDESearchFormParamImpl.isEnableAdvanceSearch() != null) {
            this.bEnableAdvanceSearch = this.psDESearchFormParamImpl.isEnableAdvanceSearch();
        }
        super.onPreparePSDEFormLayout();
    }

    @Override
    protected PSDEFormParamImpl createPSDEFormParamImpl() {
        this.psDESearchFormParamImpl = new PSDESearchFormParamImpl();
        return this.psDESearchFormParamImpl;
    }

    public String getControlType() {
        return "SEARCHFORM";
    }

    @PSModelRTMeta(description="\u662f\u5426\u652f\u6301\u9ad8\u7ea7\u641c\u7d22")
    public boolean isEnableAdvanceSearch() {
        return this.bEnableAdvanceSearch;
    }
}

