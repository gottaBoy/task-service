/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityRuntime;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;

public class PSSysPanelButtonImplBase
extends PSSysPanelItemImpl {
    private String strButtonActionType = "NONE";
    private IPSDEUIAction iPSDEUIAction = null;
    private IPSAppDataEntity iPSAppDataEntity = null;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    protected void onInit() throws Exception {
        PSDEUIAction psDEUIAction;
        this.strButtonActionType = this.psSysPanelItem.getBTNACTIONTYPE();
        if (StringHelper.IsNullOrEmpty((String)this.strButtonActionType)) {
            this.strButtonActionType = !StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEUIACTIONID()) ? "UIACTION" : this.getDefaultButtonActionType();
        }
        IPSDataEntity iPSDataEntity = null;
        if ((StringHelper.Compare((String)this.strButtonActionType, (String)"UIACTION", (boolean)false) == 0 || StringHelper.Compare((String)this.strButtonActionType, (String)"UILOGIC", (boolean)false) == 0) && this.getPSAppDataEntity() == null) {
            iPSDataEntity = !StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEID()) ? this.getPSSystem().getPSDataEntity2(this.psSysPanelItem.getPSDEID(), false) : this.getPSSysPanel().getPSDataEntity();
            if (iPSDataEntity == null) {
                throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u5bf9\u8c61");
            }
            this.setPSAppDataEntity(this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppDataEntity(iPSDataEntity, true));
        }
        IPSAppView openPSAppView = null;
        if (StringHelper.Compare((String)this.strButtonActionType, (String)"UIACTION", (boolean)false) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEUIACTIONID())) throw new Exception("\u672a\u6307\u5b9a\u754c\u9762\u884c\u4e3a\u5bf9\u8c61");
            String strPSDEUIActonId = this.psSysPanelItem.getPSDEUIACTIONID();
            if (this.iPSDEUIAction == null && this.getPSAppDataEntity() != null) {
                this.iPSDEUIAction = this.getPSAppDataEntity().getPSAppDEUIAction(strPSDEUIActonId, true, this.getOwnedPSControl());
            }
            if (this.iPSDEUIAction == null) {
                this.iPSDEUIAction = iPSDataEntity.getPSDEUIAction(strPSDEUIActonId);
            }
        } else if (StringHelper.Compare((String)this.strButtonActionType, (String)"UILOGIC", (boolean)false) == 0) {
            String strPSDEId;
            if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDELOGICID())) throw new Exception("\u672a\u6307\u5b9a\u754c\u9762\u903b\u8f91\u5bf9\u8c61");
            PSDELogic psDELogic = ((IPSSystem)((Object)this.getPSSystemUtil())).getPSDELogicData(this.psSysPanelItem.getPSDELOGICID(), true);
            if (psDELogic != null && !StringHelper.IsNullOrEmpty((String)(strPSDEId = psDELogic.getPSDEID()))) {
                iPSDataEntity = this.getPSSystem().getPSDataEntity2(strPSDEId, false);
                this.setPSAppDataEntity(this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppDataEntity(iPSDataEntity, true));
            }
            if (this.getPSAppDataEntity() == null) {
                throw new Exception("\u672a\u6307\u5b9a\u5e94\u7528\u5b9e\u4f53\u5bf9\u8c61");
            }
            IPSAppDEUILogic iPSAppDEUILogic = this.getPSAppDataEntity().getPSAppDEUILogic(this.psSysPanelItem.getPSDELOGICID());
            PSDEUIAction psDEUIAction2 = new PSDEUIAction();
            psDEUIAction2.setPSDEUIACTIONID(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()).toUpperCase());
            psDEUIAction2.setCODENAME(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()));
            psDEUIAction2.setPSDEUIACTIONNAME(this.getCaption());
            psDEUIAction2.setCAPTION(this.getCaption());
            psDEUIAction2.setUIACTIONTYPE("FRONT");
            psDEUIAction2.setFRONTPROTYPE("OTHER");
            psDEUIAction2.setVLEXECMODE("REPLACE");
            psDEUIAction2.setVIEWLOGICTYPE("DELOGIC");
            psDEUIAction2.setPSDEVIEWLOGICID(this.psSysPanelItem.getPSDELOGICID());
            psDEUIAction2.setACTIONTARGET("SINGLEDATA");
            psDEUIAction2.setPSDEID(this.getPSAppDataEntity().getPSDataEntity().getId());
            psDEUIAction2.setPSDENAME(this.getPSAppDataEntity().getPSDataEntity().getName());
            psDEUIAction2.setUIACTIONPARAMS(this.psSysPanelItem.getITEMPARAMS());
            psDEUIAction2.set("AUTOMODEL", 1);
            this.iPSDEUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction2);
        } else if (StringHelper.Compare((String)this.strButtonActionType, (String)"OPENDEVIEW", (boolean)false) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getOPENPSDEVIEWID())) throw new Exception("\u672a\u6307\u5b9a\u6253\u5f00\u7684\u5b9e\u4f53\u89c6\u56fe\u5bf9\u8c61");
            openPSAppView = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppViewByDEViewId(this.psSysPanelItem.getOPENPSDEVIEWID(), false);
        } else if (StringHelper.Compare((String)this.strButtonActionType, (String)"OPENVIEW", (boolean)false) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getOPENPSAPPVIEWID())) throw new Exception("\u672a\u6307\u5b9a\u6253\u5f00\u7684\u5e94\u7528\u89c6\u56fe\u5bf9\u8c61");
            try {
                openPSAppView = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppView(this.psSysPanelItem.getOPENPSAPPVIEWID(), false);
            }
            catch (Exception ex) {
                throw new Exception(String.format("\u6307\u5b9a\u6253\u5f00\u7684\u5e94\u7528\u89c6\u56fe[%1$s]\u4e0d\u5728\u5f53\u524d\u5e94\u7528\u4e2d", this.psSysPanelItem.getOPENPSAPPVIEWNAME()));
            }
        } else if (StringHelper.Compare((String)this.strButtonActionType, (String)"OPENSYSPDTVIEW", (boolean)false) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getOPENPSSYSPDTVIEWID())) throw new Exception("\u672a\u6307\u5b9a\u6253\u5f00\u7684\u7cfb\u7edf\u9884\u7f6e\u89c6\u56fe\u5bf9\u8c61");
            String strPSAppPDTViewId = Helper.GenUniqueId((String)this.getPSSysPanel().getPSAppView().getPSApplication().getId(), (String)this.psSysPanelItem.getOPENPSSYSPDTVIEWID());
            openPSAppView = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppPDTView(strPSAppPDTViewId, false).getPSAppView();
        } else if (StringHelper.Compare((String)this.strButtonActionType, (String)"OPENHTMLPAGE", (boolean)false) == 0) {
            if (StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getHTMLPAGEURL())) throw new Exception("\u672a\u6307\u5b9a\u6253\u5f00\u7684\u9875\u9762\u8def\u5f84");
            psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIACTIONID(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()).toUpperCase());
            psDEUIAction.setCODENAME(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()));
            psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
            psDEUIAction.setCAPTION(this.getCaption());
            psDEUIAction.setUIACTIONTYPE("FRONT");
            psDEUIAction.setFRONTPROTYPE("OPENHTMLPAGE");
            psDEUIAction.setHTMLPAGEURL(this.psSysPanelItem.getHTMLPAGEURL());
            psDEUIAction.setACTIONTARGET("SINGLEDATA");
            psDEUIAction.setUIACTIONPARAMS(this.psSysPanelItem.getITEMPARAMS());
            psDEUIAction.set("AUTOMODEL", 1);
            if (this.getPSSysPanel().getPSAppDataEntity() != null) {
                psDEUIAction.setPSDEID(this.getPSSysPanel().getPSAppDataEntity().getPSDataEntity().getId());
                psDEUIAction.setPSDENAME(this.getPSSysPanel().getPSAppDataEntity().getPSDataEntity().getName());
                this.iPSDEUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSSysPanel().getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction);
            } else {
                this.iPSDEUIAction = ((IPSApplicationRuntime)((Object)this.getPSSysPanel().getPSAppView().getPSApplication())).registerPSAppDEUIAction(psDEUIAction);
            }
        } else if (StringHelper.Compare((String)this.strButtonActionType, (String)"CUSTOM", (boolean)false) == 0) {
            psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIACTIONID(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()).toUpperCase());
            psDEUIAction.setCODENAME(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()));
            psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
            psDEUIAction.setCAPTION(this.getCaption());
            psDEUIAction.setUIACTIONTYPE("CUSTOM");
            psDEUIAction.setCUSTOMCODE(this.psSysPanelItem.getCUSTOMCODE());
            psDEUIAction.setACTIONTARGET("NONE");
            psDEUIAction.setUIACTIONPARAMS(this.psSysPanelItem.getITEMPARAMS());
            psDEUIAction.set("AUTOMODEL", 1);
            if (this.getPSSysPanel().getPSAppDataEntity() != null) {
                psDEUIAction.setPSDEID(this.getPSSysPanel().getPSAppDataEntity().getPSDataEntity().getId());
                psDEUIAction.setPSDENAME(this.getPSSysPanel().getPSAppDataEntity().getPSDataEntity().getName());
                this.iPSDEUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSSysPanel().getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction);
            } else {
                this.iPSDEUIAction = ((IPSApplicationRuntime)((Object)this.getPSSysPanel().getPSAppView().getPSApplication())).registerPSAppDEUIAction(psDEUIAction);
            }
        } else if (StringHelper.Compare((String)this.strButtonActionType, (String)"NONE", (boolean)false) != 0) {
            psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIACTIONID(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()).toUpperCase());
            psDEUIAction.setCODENAME(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()));
            psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
            psDEUIAction.setCAPTION(this.getCaption());
            psDEUIAction.setUIACTIONTYPE("SYS");
            psDEUIAction.setPSSYSUIACTIONID(this.strButtonActionType);
            psDEUIAction.setUIACTIONPARAMS(this.psSysPanelItem.getITEMPARAMS());
            psDEUIAction.set("AUTOMODEL", 1);
            if (this.getPSSysPanel().getPSAppDataEntity() != null) {
                psDEUIAction.setPSDEID(this.getPSSysPanel().getPSAppDataEntity().getPSDataEntity().getId());
                psDEUIAction.setPSDENAME(this.getPSSysPanel().getPSAppDataEntity().getPSDataEntity().getName());
                this.iPSDEUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSSysPanel().getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction);
            } else {
                this.iPSDEUIAction = ((IPSApplicationRuntime)((Object)this.getPSSysPanel().getPSAppView().getPSApplication())).registerPSAppDEUIAction(psDEUIAction);
            }
        }
        if (openPSAppView != null) {
            psDEUIAction = new PSDEUIAction();
            psDEUIAction.setPSDEUIACTIONID(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()).toUpperCase());
            psDEUIAction.setCODENAME(String.format("panel_%1$s_%2$s_click", this.getPSSysPanel().getCodeName(), this.getName()));
            psDEUIAction.setPSDEUIACTIONNAME(this.getCaption());
            psDEUIAction.setCAPTION(openPSAppView.getCaption());
            psDEUIAction.setUIACTIONTYPE("FRONT");
            psDEUIAction.setFRONTPROTYPE("WIZARD");
            psDEUIAction.setPSAPPVIEWID(openPSAppView.getId());
            psDEUIAction.setPSAPPVIEWNAME(openPSAppView.getName());
            psDEUIAction.setACTIONTARGET("SINGLEDATA");
            psDEUIAction.setUIACTIONPARAMS(this.psSysPanelItem.getITEMPARAMS());
            psDEUIAction.set("AUTOMODEL", 1);
            if (this.getPSSysPanel().getPSAppDataEntity() != null) {
                psDEUIAction.setPSDEID(this.getPSSysPanel().getPSAppDataEntity().getPSDataEntity().getId());
                psDEUIAction.setPSDENAME(this.getPSSysPanel().getPSAppDataEntity().getPSDataEntity().getName());
                this.iPSDEUIAction = ((IPSAppDataEntityRuntime)((Object)this.getPSSysPanel().getPSAppDataEntity())).registerPSAppDEUIAction(psDEUIAction);
            } else {
                this.iPSDEUIAction = ((IPSApplicationRuntime)((Object)this.getPSSysPanel().getPSAppView().getPSApplication())).registerPSAppDEUIAction(psDEUIAction);
            }
        }
        if (this.iPSDEUIAction != null) {
            this.strButtonActionType = "UIACTION";
            this.registerPSUIAction(this.iPSDEUIAction);
        }
        super.onInit();
    }

    @Override
    protected void onCheckModel() throws Exception {
        super.onCheckModel();
    }

    public String getActionType() {
        return this.strButtonActionType;
    }

    public IPSUIAction getPSUIAction() {
        return this.iPSDEUIAction;
    }

    protected String getDefaultButtonActionType() {
        return "NONE";
    }

    protected void registerPSUIAction(IPSUIAction iPSUIAction) {
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psSysViewPanelFieldList) {
    }

    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    protected void setPSAppDataEntity(IPSAppDataEntity iPSAppDataEntity) {
        this.iPSAppDataEntity = iPSAppDataEntity;
    }
}

