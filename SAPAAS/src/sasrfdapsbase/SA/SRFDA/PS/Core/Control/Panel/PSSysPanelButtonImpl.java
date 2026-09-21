/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.sf.json.JSONObject
 */
package SA.SRFDA.PS.Core.Control.Panel;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntityRuntime;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewUIAction;
import SA.SRFDA.PS.Core.App.View.PSAppViewLogicImpl;
import SA.SRFDA.PS.Core.App.View.PSAppViewUIActionProxy;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.Panel.IPSPanelField;
import SA.SRFDA.PS.Core.Control.Panel.IPSSysPanelButton;
import SA.SRFDA.PS.Core.Control.Panel.PSSysPanelItemImpl;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Data.PSAppViewLogic;
import SA.SRFDA.PS.Data.PSDELogic;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import net.sf.json.JSONObject;

@PSModelImplementMeta(implement="IPSPanelItem", typevalues={"BUTTON"})
public class PSSysPanelButtonImpl
extends PSSysPanelItemImpl
implements IPSSysPanelButton {
    private String strButtonActionType = "CUSTOM";
    private String strPSDEUIActonId = "";
    private IPSDEUIAction iPSDEUIAction = null;
    private IPSWFUIAction iPSWFUIAction = null;
    private String strTooltip = null;
    private PSAppViewUIActionProxy psAppViewUIActionProxy = null;
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
            this.strButtonActionType = !StringHelper.IsNullOrEmpty((String)this.psSysPanelItem.getPSDEUIACTIONID()) ? "UIACTION" : "CUSTOM";
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
            this.strPSDEUIActonId = this.psSysPanelItem.getPSDEUIACTIONID();
            if (this.iPSDEUIAction == null && this.getPSAppDataEntity() != null) {
                this.iPSDEUIAction = this.getPSAppDataEntity().getPSAppDEUIAction(this.strPSDEUIActonId, true, this.getOwnedPSControl());
            }
            if (this.iPSDEUIAction == null) {
                this.iPSDEUIAction = iPSDataEntity.getPSDEUIAction(this.strPSDEUIActonId);
            }
            if (this.iPSDEUIAction instanceof IPSWFUIAction) {
                this.iPSWFUIAction = (IPSWFUIAction)((Object)this.iPSDEUIAction);
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
            this.iPSDEUIAction = this.getPSSysPanel().getPSAppView().getPSApplication().getPSAppDEUIActionByPredefinedType(this.strButtonActionType, true);
            if (this.iPSDEUIAction == null) {
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
            if (this.isPrepareTemplV2logic()) {
                this.psAppViewUIActionProxy = new PSAppViewUIActionProxy(this.getId(), this.getName(), this, this);
                this.psAppViewUIActionProxy.setPSAppCounterRef(this.getPSAppCounterRef());
                this.getPSSysPanel().registerPSAppViewUIAction(this.psAppViewUIActionProxy);
                this.registerPSAppViewLogic();
            } else {
                this.getPSSysPanel().getPSAppView().registerPSUIAction(this.iPSDEUIAction);
            }
        }
        super.onInit();
    }

    @Override
    protected void onCheckModel() throws Exception {
        if (StringHelper.Compare((String)this.getActionType(), (String)"UIACTION", (boolean)true) == 0 && this.getPSUIAction() == null) {
            throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u6309\u94ae\u8c03\u7528\u7684\u754c\u9762\u884c\u4e3a"));
        }
        super.onCheckModel();
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u884c\u4e3a\u7c7b\u578b", codelist="PanelButtonActionType", fields={"BTNACTIONTYPE"})
    public String getActionType() {
        return this.strButtonActionType;
    }

    @Override
    @PSModelRTMeta(description="\u8c03\u7528\u754c\u9762\u884c\u4e3a", hideempty=true, child=true, fields={"PSDEUIACTIONID"}, doc="\u9664\u4e86\u663e\u5f0f\u6307\u5b9a\u754c\u9762\u884c\u4e3a\uff0c\u5176\u5b83\u7c7b\u578b{@link #getActionType}\u4e5f\u4f1a\u88ab\u4eff\u771f\u4e3a\u754c\u9762\u884c\u4e3a")
    public IPSUIAction getPSUIAction() {
        return this.iPSDEUIAction;
    }

    @Override
    public String getPSUIActionId() {
        return this.strPSDEUIActonId;
    }

    @Override
    public IPSDEUIAction getPSDEUIAction() {
        return this.iPSDEUIAction;
    }

    @Override
    public IPSWFUIAction getPSWFUIAction() {
        return this.iPSWFUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f")
    public String getTooltip() {
        if (StringHelper.IsNullOrEmpty((String)this.strTooltip)) {
            return this.getCaption();
        }
        return this.strTooltip;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u8bed\u8a00\u8d44\u6e90")
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return super.getTooltipPSLanguageRes();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    protected String onGetCaption() {
        if (this.getPSUIAction() != null) {
            return this.getPSUIAction().getCaption();
        }
        return super.onGetCaption();
    }

    @Override
    protected IPSLanguageRes onGetCapPSLanguageRes() {
        if (this.getPSUIAction() != null) {
            return this.getPSUIAction().getCapPSLanguageRes();
        }
        return super.onGetCapPSLanguageRes();
    }

    @Override
    public IPSAppView getPSAppView() {
        return this.getPSControlContainer().getPSAppView();
    }

    @Override
    public JSONObject getUIActionParamJO() {
        return null;
    }

    @Override
    public String getXDataControlName() {
        return this.getPSSysPanel().getName();
    }

    @Override
    public IPSControl getXDataPSControl() throws Exception {
        return this.getPSSysPanel();
    }

    @Override
    public IPSControlContainer getPSControlContainer() {
        return this.getPSSysPanel();
    }

    protected void registerPSAppViewLogic() throws Exception {
        if (this.psAppViewUIActionProxy != null) {
            String strCtrlName = this.getPSSysPanel().getName();
            String strLogicTag = StringHelper.Format((String)"%1$s_%2$s_click", (Object)strCtrlName, (Object)this.getName()).toLowerCase();
            PSAppViewLogic psAppViewLogic = new PSAppViewLogic();
            psAppViewLogic.setPSAPPVIEWLOGICID(strLogicTag);
            psAppViewLogic.setPSAPPVIEWLOGICNAME(strLogicTag);
            psAppViewLogic.setDSTLOGICTYPE("APPVIEWUIACTION");
            psAppViewLogic.setPSAPPVIEWLOGICTYPE("CUSTOM");
            PSAppViewLogicImpl psAppDEViewLogicImpl = new PSAppViewLogicImpl();
            psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), (Object)this.getPSSysPanel(), psAppViewLogic, this.psAppViewUIActionProxy);
            this.getPSSysPanel().registerPSAppViewLogic(psAppDEViewLogicImpl);
        }
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u6807\u9898\u7ed1\u5b9a\u503c\u9879", fields={"FIELDNAME"})
    public String getCaptionItemName() {
        return this.psSysPanelItem.getFIELDNAME();
    }

    @Override
    public void fillPSPanelFields(ArrayList<IPSPanelField> psSysViewPanelFieldList) {
    }

    @Override
    public String getModelType() {
        return "PSSYSVIEWPANELITEM_BUTTON";
    }

    @Override
    public boolean isSaveTargetFirst() {
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().isSaveTargetFirst();
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().isSaveTargetFirst();
        }
        return false;
    }

    @Override
    public IPSAppCounterRef getPSAppCounterRef() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u64cd\u4f5c\u76ee\u6807", codelist="DEUIActionDataRange")
    public String getUIActionTarget() {
        if (this.getPSDEUIAction() != null) {
            return this.getPSDEUIAction().getActionTarget();
        }
        if (this.getPSWFUIAction() != null) {
            return this.getPSWFUIAction().getActionTarget();
        }
        return "NONE";
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u89c6\u56fe\u754c\u9762\u884c\u4e3a", dumpref=true)
    public IPSAppViewUIAction getPSAppViewUIAction() {
        return this.psAppViewUIActionProxy;
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u7c7b\u578b", ignoredumpvalues="PANELBUTTON")
    public String getButtonType() {
        return "PANELBUTTON";
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u6837\u5f0f", codelist="ButtonStyle", fields={"DETAILSTYLE"})
    public String getButtonStyle() {
        String strItemStyle = this.psSysPanelItem.getDETAILSTYLE();
        if (StringHelper.IsNullOrEmpty((String)strItemStyle)) {
            if (this.getPSDEUIAction() != null) {
                strItemStyle = this.getPSDEUIAction().getButtonStyle();
            } else if (this.getPSWFUIAction() != null) {
                strItemStyle = this.getPSWFUIAction().getButtonStyle();
            }
        }
        if (!StringHelper.IsNullOrEmpty((String)strItemStyle)) {
            return strItemStyle;
        }
        return this.getItemStyle();
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u5bbd\u5ea6", ignoredumpvalues="0.0")
    public double getButtonWidth() {
        return this.getContentWidth();
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u9ad8\u5ea6", ignoredumpvalues="0.0")
    public double getButtonHeight() {
        return this.getContentHeight();
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u76f4\u63a5\u6837\u5f0f", fields={"RAWCSSSTYLE"})
    public String getButtonCssStyle() {
        return this.psSysPanelItem.getRAWCSSSTYLE();
    }

    @Override
    public String getCssStyle() {
        return super.getCssStyle();
    }

    @Override
    @PSModelRTMeta(description="\u56fe\u6807\u5bf9\u9f50", codelist="ButtonIconAlign", fields={"ICONALIGN"})
    public String getIconAlign() {
        return this.psSysPanelItem.getICONALIGN();
    }

    @Override
    @PSModelRTMeta(description="\u8fb9\u6846\u6837\u5f0f", codelist="BorderStyle", fields={"BORDERSTYLE"})
    public String getBorderStyle() {
        return this.psSysPanelItem.getBORDERSTYLE();
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u7ed8\u5236\u6a21\u5f0f", codelist="ButtonRenderMode", ignoredumpvalues="BUTTON")
    public String getRenderMode() {
        return super.getRenderMode();
    }

    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    protected void setPSAppDataEntity(IPSAppDataEntity iPSAppDataEntity) {
        this.iPSAppDataEntity = iPSAppDataEntity;
    }

    @Override
    protected IPSSysImage onGetPSSysImage() {
        if (super.onGetPSSysImage() == null && this.getPSUIAction() != null) {
            return this.getPSUIAction().getPSSysImage();
        }
        return super.onGetPSSysImage();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\uff08\u8fd0\u884c\u65f6\u5185\u8054\uff09", rtdump=2, hideempty=true, child=true)
    public IPSUIAction getInlinePSUIAction() {
        return null;
    }
}

