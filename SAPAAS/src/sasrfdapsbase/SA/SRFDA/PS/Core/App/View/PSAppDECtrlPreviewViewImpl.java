/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.PSAppModuleImpl;
import SA.SRFDA.PS.Core.App.View.IPSAppDEEditView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEGridView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.PSAppViewImpl;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.Control.DataInfoBar.IPSDataInfoBar;
import SA.SRFDA.PS.Core.Control.Form.IPSDESearchForm;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysViewLayoutPanel;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelParamImpl;
import SA.SRFDA.PS.Core.Control.SearchBar.IPSSearchBar;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCondition;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;

@PSModelIgnoreMeta
public class PSAppDECtrlPreviewViewImpl
extends PSAppViewImpl
implements IPSAppDEView,
IPSAppDEGridView,
IPSAppDEEditView {
    private IPSDataEntity iPSDataEntity = null;
    private PSDEViewCtrl psDEViewCtrl = null;
    private PSAppModuleImpl psAppModuleImpl = null;
    private IPSSysViewLayoutPanel iPSViewLayoutPanel = null;
    private IPSPFStyle iPSPFStyle = null;
    private boolean bV2Preview = false;
    private boolean bDesignMode = true;

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView, IPSDataEntity iPSDataEntity, PSDEViewCtrl psDEViewCtrl) throws Exception {
        this.setPSDataEntity(iPSDataEntity);
        PSAppModule psAppModule = new PSAppModule();
        psAppModule.setPSAPPMODULEID("DEMO");
        psAppModule.setPSAPPMODULENAME("DEMO");
        psAppModule.setCODENAME("DEMO");
        this.psAppModuleImpl = new PSAppModuleImpl();
        this.psAppModuleImpl.init(iDAGlobalHelper, iPSApplication, psAppModule);
        super.init(iDAGlobalHelper, iPSApplication, psApplicationView);
        this.psDEViewCtrl = psDEViewCtrl;
        if (StringHelper.Compare((String)psDEViewCtrl.getPSDEVIEWCTRLTYPE(), (String)"VIEWLAYOUTPANEL", (boolean)true) == 0) {
            PSSysPanelParamImpl psSysPanelParamImpl = new PSSysPanelParamImpl();
            psSysPanelParamImpl.setPSSysPanelId(this.psDEViewCtrl.getPSSYSVIEWPANELID());
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType("VIEWLAYOUTPANEL");
            IPSControl iPSControl = iPSControlType.createPSControl(psSysPanelParamImpl);
            iPSControl.init(this.getDAGlobalHelper(), this, "layoutpanel", psSysPanelParamImpl);
            this.iPSViewLayoutPanel = (IPSSysViewLayoutPanel)iPSControl;
        } else {
            IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType(psDEViewCtrl.getPSDEVIEWCTRLTYPE());
            IPSControlParam iPSControlParam = iPSControlType.createPSControlParam(psDEViewCtrl);
            iPSControlParam.init(this.getDAGlobalHelper(), this, psDEViewCtrl);
            this.registerPSControl(psDEViewCtrl.getPSDEVIEWCTRLNAME().toLowerCase(), psDEViewCtrl.getPSDEVIEWCTRLTYPE(), iPSControlParam);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (this.isV2Preview()) {
            this.onPreparePSViewLayoutPanel();
        }
    }

    @Override
    public boolean isEnableDP() {
        return false;
    }

    @Override
    public String getPSDEViewId() {
        return "DEMO";
    }

    @Override
    public String getPSDEViewName() {
        return "DEMO";
    }

    @Override
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    @Override
    public IPSAppModule getPSAppModule() throws Exception {
        return this.psAppModuleImpl;
    }

    @Override
    public int getTempMode() {
        return 0;
    }

    @Override
    public boolean isEnableWF() {
        return true;
    }

    @Override
    public String getNewDataMode() {
        return null;
    }

    @Override
    public String getEditDataMode() {
        return null;
    }

    @Override
    public boolean isLoadDefault() {
        return false;
    }

    @Override
    public boolean isEnableBatchAdd() {
        return false;
    }

    @Override
    public boolean isBatchAddOnly() {
        return false;
    }

    @Override
    public boolean isPickupMode() {
        return false;
    }

    @Override
    public boolean isEnableViewData() {
        return true;
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }

    @Override
    public boolean isEnableNewData() {
        return true;
    }

    @Override
    public boolean isEnableEditData() {
        return true;
    }

    @Override
    public boolean isEnableRemoveData() {
        return true;
    }

    @Override
    public boolean isEnablePrint() {
        return true;
    }

    @Override
    public IPSDEWF getPSDEWF() {
        return null;
    }

    @Override
    public IPSWFVersion getPSWFVersion() {
        return null;
    }

    @Override
    public IPSWorkflow getPSWorkflow() {
        return null;
    }

    @Override
    public boolean isWFIAMode() {
        return false;
    }

    @Override
    public boolean isEnableRowEdit() {
        return true;
    }

    @Override
    public boolean isEnableImport() {
        return true;
    }

    @Override
    public boolean isEnableExport() {
        return true;
    }

    @Override
    public boolean isEnableFilter() {
        return true;
    }

    @Override
    public boolean isEnableCopy() {
        return true;
    }

    @Override
    public boolean isEnableHelp() {
        return true;
    }

    @Override
    public boolean isEnableQuickSearch() {
        return true;
    }

    @Override
    public boolean isEnableSearch() {
        return true;
    }

    @Override
    public boolean isEnableStartWF() {
        return true;
    }

    @Override
    public IPSDEPrint getPSDEPrint() {
        return null;
    }

    @Override
    public int getExtendMode() {
        return 0;
    }

    @Override
    public String getModelType() {
        return null;
    }

    @Override
    public boolean isDbClickEditData() {
        return false;
    }

    @Override
    public IPSDEActionWizardGroup getPSDEActionWizardGroup() {
        return null;
    }

    @Override
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return null;
    }

    @Override
    public int getGridRowActiveMode() {
        return 0;
    }

    @Override
    public boolean isEnableQuickCreate() {
        return false;
    }

    @Override
    public boolean isRowEditDefault() {
        return false;
    }

    @Override
    public IPSSysViewLayoutPanel getPSSysViewLayoutPanel() {
        if (this.iPSViewLayoutPanel != null) {
            return this.iPSViewLayoutPanel;
        }
        return super.getPSSysViewLayoutPanel();
    }

    @Override
    public String getActionAfterNewDataWizard() {
        return "DEFAULT";
    }

    @Override
    public Iterator<IPSDEDQCondition> getADPSDEDQConditions() throws Exception {
        return null;
    }

    @Override
    public IPSControl getXDataPSControl() throws Exception {
        return null;
    }

    @Override
    public String getXDataControlName() {
        return null;
    }

    @Override
    public String getPSDEViewCodeName() {
        return "DEMO";
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
    }

    @Override
    public IPSPFStyle getPSPFStyle() {
        if (this.iPSPFStyle != null) {
            return this.iPSPFStyle;
        }
        return super.getPSPFStyle();
    }

    @Override
    public void setPSPFStyle(IPSPFStyle iPSPFStyle) {
        this.iPSPFStyle = iPSPFStyle;
    }

    public void setV2Preview(boolean bV2Preview) {
        this.bV2Preview = bV2Preview;
    }

    public boolean isV2Preview() {
        return this.bV2Preview;
    }

    @Override
    public boolean isExpandSearchForm() {
        return false;
    }

    @Override
    public boolean isShowDataInfoBar() {
        return false;
    }

    @Override
    public boolean isHideEditForm() {
        return false;
    }

    @Override
    public boolean isDesignMode() {
        return this.bDesignMode;
    }

    public void setDesignMode(boolean bDesignMode) {
        this.bDesignMode = bDesignMode;
    }

    @Override
    public IPSAppDataEntity getPSAppDataEntity() {
        return null;
    }

    @Override
    public IPSDER1N getPSDER1N() {
        return null;
    }

    @Override
    public IPSAppWF getPSAppWF() {
        return null;
    }

    @Override
    public IPSAppWFVer getPSAppWFVer() {
        return null;
    }

    @Override
    public String getFuncViewMode() {
        return null;
    }

    @Override
    public String getFuncViewParam() {
        return null;
    }

    @Override
    public IPSSysCounter getPSSysCounter() {
        return null;
    }

    @Override
    public boolean isEnableQuickGroup() {
        return false;
    }

    @Override
    public IPSCodeList getQuickGroupPSCodeList() {
        return null;
    }

    @Override
    public IPSDESearchForm getPSDESearchForm() {
        return null;
    }

    @Override
    public IPSDESearchForm getQuickPSDESearchForm() {
        return null;
    }

    @Override
    public IPSSysCounterRef getPSSysCounterRef() {
        return null;
    }

    @Override
    public IPSSearchBar getPSSearchBar() {
        return null;
    }

    @Override
    public IPSAppDataEntity getParentPSAppDataEntity() throws Exception {
        return null;
    }

    @Override
    public int getMultiFormMode() {
        return 0;
    }

    @Override
    public IPSAppCounterRef getPSAppCounterRef() {
        return null;
    }

    @Override
    public IPSDataInfoBar getPSDataInfoBar() {
        return null;
    }

    @Override
    public boolean isEnableDirtyChecking() {
        return false;
    }

    @Override
    public String getMarkOpenDataMode() {
        return null;
    }

    @Override
    public boolean isManualAppendForms() {
        return false;
    }
}

