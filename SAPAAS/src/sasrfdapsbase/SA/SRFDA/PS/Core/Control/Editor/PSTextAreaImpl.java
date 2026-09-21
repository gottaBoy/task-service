/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Control.Editor;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataSet;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Editor.IPSTextArea;
import SA.SRFDA.PS.Core.Control.Editor.PSTextEditorImpl;
import SA.SRFDA.PS.Core.DataEntity.AC.IPSDEACMode;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataSet;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;

@PSModelImplementMeta(implement="IPSEditor", typevalues={"TEXTAREA", "MOBTEXTAREA", "TEXTAREA_10"})
public class PSTextAreaImpl
extends PSTextEditorImpl
implements IPSTextArea {
    private IPSAppDataEntity iPSAppDataEntity = null;

    @Override
    protected void onInit() throws Exception {
        super.onInit();
        this.getPSAppDEACMode();
    }

    @Override
    protected boolean getDefaultShowMaxLength() {
        return true;
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u9009\u62e9\u89c6\u56fe[PICKUPVIEW]", ignoredumpvalues="false")
    public boolean isEnablePickupView() {
        return this.getEditorParam("PICKUPVIEW", false);
    }

    @Override
    @PSModelRTMeta(description="\u652f\u6301\u81ea\u52a8\u586b\u5145[AC]", ignoredumpvalues="false")
    public boolean isEnableAC() {
        return this.getEditorParam("AC", false);
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u5b9e\u4f53")
    public IPSDataEntity getPSDataEntity() throws Exception {
        if (!this.isEnableAC()) {
            return null;
        }
        return this.getPSEditorContainer().getRefPSDataEntity();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u7ed3\u679c\u96c6\u5408")
    public IPSDEDataSet getPSDEDataSet() throws Exception {
        if (!this.isEnableAC()) {
            return null;
        }
        return this.getPSEditorContainer().getRefPSDEDataSet();
    }

    @Override
    @PSModelRTMeta(description="\u5f15\u7528\u81ea\u586b\u6a21\u5f0f")
    public IPSDEACMode getPSDEACMode() throws Exception {
        if (!this.isEnableAC()) {
            return null;
        }
        return this.getPSEditorContainer().getRefPSDEACMode();
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61", dumpref=true)
    public IPSAppDataEntity getPSAppDataEntity() throws Exception {
        if (this.iPSAppDataEntity == null && this.getPSDataEntity() != null) {
            this.iPSAppDataEntity = this.getPSEditorContainer().getPSControlContainer().getPSAppView().getPSApplication().getPSAppDataEntity(this.getPSDataEntity(), !this.isEnableUIModelEx());
        }
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u7ed3\u679c\u96c6\u5bf9\u8c61", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEDataSet getPSAppDEDataSet() throws Exception {
        IPSAppDEMethod iPSAppDEMethod;
        if (this.getPSDEDataSet() == null) {
            return null;
        }
        IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity();
        if (iPSAppDataEntity != null && (iPSAppDEMethod = iPSAppDataEntity.getPSAppDEMethod(this.getPSDEDataSet(), !this.isEnableUIModelEx())) instanceof IPSAppDEDataSet) {
            return (IPSAppDEDataSet)iPSAppDEMethod;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f\u5bf9\u8c61", dumpref=true, from="IPSAppDataEntity")
    public IPSAppDEACMode getPSAppDEACMode() throws Exception {
        if (this.getPSDEACMode() == null) {
            return null;
        }
        IPSAppDataEntity iPSAppDataEntity = this.getPSAppDataEntity();
        if (iPSAppDataEntity != null) {
            return iPSAppDataEntity.getPSAppDEACMode(this.getPSDEACMode().getId(), !this.isEnableUIModelEx());
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u9009\u62e9\u89c6\u56fe", hideempty=true, dumpref=true)
    public IPSAppView getPickupPSAppView() throws Exception {
        if (!this.isEnablePickupView()) {
            return null;
        }
        return this.getPSEditorContainer().getRefPickupPSAppView();
    }
}

