/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.View.IPSAppDEGridView;
import SA.SRFDA.PS.Core.App.View.PSAppDEMultiDataViewImpl;
import SA.SRFDA.PS.Core.Control.Grid.IPSDEGrid;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import java.util.HashMap;

@PSModelImplementMeta(implement="IPSAppDEView", typevalues={"DEGRIDVIEW", "DEGRIDVIEW2", "DEGRIDVIEW4"})
public class PSAppDEGridViewImpl
extends PSAppDEMultiDataViewImpl
implements IPSAppDEGridView {
    private boolean bEnableDbClickActiveData = true;
    private IPSDEGrid iPSDEGrid = null;
    private int nGridRowActiveMode = 2;
    private boolean bRowEditDefault = false;

    @Override
    protected void onInit() throws Exception {
        if (!this.psViewBase.isVIEWPARAM6Null()) {
            this.bEnableDbClickActiveData = false;
            this.nGridRowActiveMode = this.psViewBase.GetParamIntValue("VIEWPARAM6", 0);
            if (this.nGridRowActiveMode == 1) {
                this.nGridRowActiveMode = 2;
                this.bEnableDbClickActiveData = true;
            } else if (this.nGridRowActiveMode == 2) {
                this.nGridRowActiveMode = 1;
            }
        } else {
            this.nGridRowActiveMode = this.getPSAppView().getPSApplication().getPSApplicationUI().getGridRowActiveMode();
            boolean bl = this.bEnableDbClickActiveData = this.nGridRowActiveMode == 2;
        }
        if (!this.psViewBase.isVIEWPARAM3Null()) {
            this.bRowEditDefault = this.psViewBase.GetParamIntValue("VIEWPARAM3", 0) == 1;
        }
        super.onInit();
    }

    @Override
    protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
        IPSControl iPSControl;
        PSDEViewCtrl psDEViewCtrl = psDEViewCtrlMap.remove("grid");
        if (psDEViewCtrl != null && (iPSControl = this.registerPSDEViewCtrl(psDEViewCtrl)) instanceof IPSDEGrid) {
            this.iPSDEGrid = (IPSDEGrid)iPSControl;
        }
        super.registerPSDEViewCtrls(psDEViewCtrlMap);
    }

    @Override
    public boolean isDbClickEditData() {
        return this.bEnableDbClickActiveData;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u884c\u7f16\u8f91")
    public boolean isEnableRowEdit() {
        if (this.isEnableViewActions()) {
            if (this.getPSDEGrid() != null) {
                return this.getPSDEGrid().isEnableRowEdit() && (this.getViewActions() & 0x20L) > 0L;
            }
            return (this.getViewActions() & 0x20L) > 0L;
        }
        if (this.getPSDEGrid() != null) {
            return this.getPSDEGrid().isEnableRowEdit();
        }
        return false;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5bfc\u5165")
    public boolean isEnableImport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x400L) > 0L;
        }
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u6570\u636e\u5bfc\u51fa")
    public boolean isEnableExport() {
        if (this.isEnableViewActions()) {
            return (this.getViewActions() & 0x40L) > 0L;
        }
        return true;
    }

    public IPSDEGrid getPSDEGrid() {
        return this.iPSDEGrid;
    }

    @Override
    @PSModelRTMeta(description="\u8868\u683c\u884c\u6fc0\u6d3b\u6a21\u5f0f", codelist="GridRowActiveMode")
    public int getGridRowActiveMode() {
        return this.nGridRowActiveMode;
    }

    @Override
    @PSModelRTMeta(description="\u89c6\u56fe\u9ed8\u8ba4\u8fdb\u5165\u884c\u7f16\u8f91")
    public boolean isRowEditDefault() {
        return this.bRowEditDefault;
    }

    @Override
    protected void onPreparePSDEViewLogics() throws Exception {
        super.onPreparePSDEViewLogics();
        this.isPrepareDefaultPSAppViewLogics();
    }

    @Override
    protected String onGetXDataControlName() {
        return "grid";
    }
}

