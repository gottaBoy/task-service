/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.model.app.view.IPSAppDESearchView
 *  net.ibizsys.model.control.IPSControl
 *  net.ibizsys.model.control.form.IPSDESearchForm
 */
package net.ibizsys.model.app.view;

import java.util.HashMap;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.app.view.IPSAppDESearchView;
import net.ibizsys.model.app.view.PSAppDEViewImpl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.form.IPSDESearchForm;
import net.ibizsys.model.entity.PSDEViewCtrl;

public class PSAppDESearchViewImpl
extends PSAppDEViewImpl
implements IPSAppDESearchView {
    private boolean bLoadDefault = true;
    private boolean bEnableQuickSearch = true;
    private boolean bEnableQuickSearchDefault = false;
    private IPSDESearchForm iPSDESearchForm = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isLOADDEFAULTNull()) {
            this.bLoadDefault = this.psViewBase.getLOADDEFAULT();
        }
        this.bEnableQuickSearch = this.isEnableQuickSearchDefault();
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bEnableQuickSearch = this.psViewBase.getVIEWPARAM5();
        }
        super.onInit();
    }

    protected boolean isEnableQuickSearchDefault() {
        return this.bEnableQuickSearchDefault;
    }

    protected void setEnableQuickSearchDefault(boolean bEnableQuickSearchDefault) {
        this.bEnableQuickSearchDefault = bEnableQuickSearchDefault;
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("searchform");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDESearchForm) {
            this.iPSDESearchForm = (IPSDESearchForm)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    public IPSDESearchForm getPSDESearchForm() {
        return this.iPSDESearchForm;
    }

    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d\u6570\u636e")
    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    @PSModelRTMeta(description="\u652f\u6301\u5feb\ufffd?\ufffd\u641c\ufffd?")
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    @PSModelRTMeta(description="\u652f\u6301\u641c\u7d22")
    public boolean isEnableSearch() {
        return this.getPSDESearchForm() != null;
    }
}

