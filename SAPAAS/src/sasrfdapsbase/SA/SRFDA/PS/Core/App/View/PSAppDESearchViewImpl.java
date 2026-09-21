/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.util.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView;
import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView2;
import SA.SRFDA.PS.Core.App.View.IPSAppDESearchView3;
import SA.SRFDA.PS.Core.App.View.PSAppDEViewImpl;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBar;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.HashMap;
import net.ibizsys.paas.util.StringHelper;

public class PSAppDESearchViewImpl
extends PSAppDEViewImpl
implements IPSAppDESearchView,
IPSAppDESearchView2,
IPSAppDESearchView3 {
    private boolean bLoadDefault = true;
    private boolean bEnableQuickSearch = true;
    private boolean bEnableQuickSearchDefault = false;
    private IPSDESearchForm iPSDESearchForm = null;
    private boolean bExpandSearchFormDefault = false;
    private boolean bExpandSearchForm = false;
    private IPSCodeList quickGroupPSCodeList = null;
    private IPSDESearchForm quickPSDESearchForm = null;
    private IPSSearchBar iPSSearchBar = null;

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isLOADDEFAULTNull()) {
            this.bLoadDefault = this.psViewBase.getLOADDEFAULT();
        }
        this.bEnableQuickSearch = this.isEnableQuickSearchDefault();
        if (!this.psViewBase.isVIEWPARAM5Null()) {
            this.bEnableQuickSearch = this.psViewBase.getVIEWPARAM5();
        }
        this.bExpandSearchForm = this.isExpandSearchFormDefault();
        if (!this.psViewBase.isVIEWPARAM10Null()) {
            boolean bl = this.bExpandSearchForm = this.psViewBase.getVIEWPARAM10() == 1;
        }
        if (!StringHelper.isNullOrEmpty((String)this.psViewBase.getGROUPPSCODELISTID())) {
            this.quickGroupPSCodeList = this.getPSApplication().getPSAppCodeList(this.psViewBase.getGROUPPSCODELISTID());
        }
        super.onInit();
        if ((this.isEnableUIModelEx() || this.getPSSysViewLayoutPanel() != null && this.getPSSysViewLayoutPanel().isViewProxyMode()) && this.getPSSearchBar() == null) {
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLID("searchbar");
            psDEViewCtrl.setPSDEVIEWCTRLNAME("searchbar");
            psDEViewCtrl.setPSSYSSEARCHBARID("SRFCURRENTVIEW");
            psDEViewCtrl.setPSDEVIEWCTRLTYPE("SEARCHBAR");
            IPSControl iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl);
            if (iPSControl instanceof IPSSearchBar) {
                this.iPSSearchBar = (IPSSearchBar)iPSControl;
            }
        }
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
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("searchbar");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSSearchBar) {
            this.iPSSearchBar = (IPSSearchBar)iPSControl;
        }
        if ((psDEViewCtrl = psDEViewCtrlMap.remove("quicksearchform")) != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDESearchForm) {
            this.quickPSDESearchForm = (IPSDESearchForm)iPSControl;
        }
        if ((psDEViewCtrl = psDEViewCtrlMap.remove("searchform")) != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDESearchForm) {
            this.iPSDESearchForm = (IPSDESearchForm)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u8868\u5355\u90e8\u4ef6", hideempty=true)
    public IPSDESearchForm getPSDESearchForm() {
        return this.iPSDESearchForm;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u641c\u7d22\u8868\u5355\u90e8\u4ef6", hideempty=true)
    public IPSDESearchForm getQuickPSDESearchForm() {
        return this.quickPSDESearchForm;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u52a0\u8f7d\u6570\u636e", fields={"LOADDEFAULT"})
    public boolean isLoadDefault() {
        return this.bLoadDefault;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u641c\u7d22", fields={"VIEWPARAM5"})
    public boolean isEnableQuickSearch() {
        return this.bEnableQuickSearch;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u641c\u7d22", doc="\u5224\u65ad\u89c6\u56fe\u662f\u5426\u5b58\u5728\u641c\u7d22\u8868\u5355\u6216\u641c\u7d22\u680f")
    public boolean isEnableSearch() {
        return this.getPSDESearchForm() != null || this.getPSSearchBar() != null;
    }

    protected boolean isExpandSearchFormDefault() {
        return this.bExpandSearchFormDefault;
    }

    protected void setExpandSearchFormDefault(boolean bExpandSearchFormDefault) {
        this.bExpandSearchFormDefault = bExpandSearchFormDefault;
    }

    @Override
    @PSModelRTMeta(description="\u9ed8\u8ba4\u5c55\u5f00\u641c\u7d22\u8868\u5355", fields={"VIEWPARAM5"})
    public boolean isExpandSearchForm() {
        return this.bExpandSearchForm;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u5feb\u901f\u5206\u7ec4\u641c\u7d22", doc="\u5224\u65ad\u89c6\u56fe\u662f\u5426\u5b58\u5728\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868{@link #getQuickGroupPSCodeList}")
    public boolean isEnableQuickGroup() {
        return this.getQuickGroupPSCodeList() != null;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u5206\u7ec4\u4ee3\u7801\u8868", dumpref=true, fields={"GROUPPSCODELISTID"})
    public IPSCodeList getQuickGroupPSCodeList() {
        return this.quickGroupPSCodeList;
    }

    @Override
    @PSModelRTMeta(description="\u641c\u7d22\u680f\u90e8\u4ef6", hideempty=true)
    public IPSSearchBar getPSSearchBar() {
        return this.iPSSearchBar;
    }
}

