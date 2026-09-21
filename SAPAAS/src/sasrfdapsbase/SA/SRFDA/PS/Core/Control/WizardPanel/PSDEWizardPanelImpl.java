/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Control.WizardPanel;

import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEField;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewRef;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxControlHandler;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerActionImpl;
import SA.SRFDA.PS.Core.Control.Ajax.PSAjaxControlHandlerImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.Form.PSDEEditFormParamImpl;
import SA.SRFDA.PS.Core.Control.IPSAjaxControlParam;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlAction;
import SA.SRFDA.PS.Core.Control.IPSControlContainer;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.PSAjaxControlContainerImpl;
import SA.SRFDA.PS.Core.Control.PSControlLogicImpl;
import SA.SRFDA.PS.Core.Control.WizardPanel.IPSDEWizardPanel;
import SA.SRFDA.PS.Core.Control.WizardPanel.IPSDEWizardPanelParam;
import SA.SRFDA.PS.Core.Control.WizardPanel.PSDEWizardPanelParamImpl;
import SA.SRFDA.PS.Core.DEField.IPSDEField;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizard;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardForm;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardLogic;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEWizardStep;
import SA.SRFDA.PS.Core.PSModelImplementMeta;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSACHandlerAction;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSDEWizard;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.util.ArrayList;
import java.util.Iterator;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@PSModelImplementMeta(implement="IPSControl", typevalues={"WIZARDPANEL"})
public class PSDEWizardPanelImpl
extends PSAjaxControlContainerImpl
implements IPSDEWizardPanel {
    private static final Log log = LogFactory.getLog(PSDEWizardPanelImpl.class);
    private PSDEWizardPanelParamImpl psDEWizardPanelParamImpl = null;
    private IPSDEWizard iPSDEWizard = null;
    private static final String FORMNAME = "_form_";
    private ArrayList<IPSDEEditForm> psDEEditFormList = new ArrayList();
    private boolean bShowStepBar = true;
    private boolean bShowActionBar = true;
    private PSDEWizard psDEWizard = null;
    private boolean bInvalidId = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSControlContainer iPSControlContainer, String strName, IPSControlParam iPSControlParam) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSControlContainer(iPSControlContainer);
            IPSDEWizardPanelParam iPSDEWizardPanelParam = (IPSDEWizardPanelParam)iPSControlParam;
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEWizardPanelParam.getPSDEWizardId())) {
                throw new Exception("\u5b9e\u4f53\u5411\u5bfc\u9762\u677f\u6ca1\u6709\u6307\u5b9a\u5b9e\u4f53\u5411\u5bfc\u914d\u7f6e");
            }
            this.psDEWizard = new PSDEWizard();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)iPSDEWizardPanelParam.getPSDEWizardId())) {
                CallResult callResult = this.getPSModelHelper().getPSDEWizard(iPSDEWizardPanelParam.getPSDEWizardId(), this.psDEWizard);
                if (callResult.isError()) {
                    throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5b9e\u4f53\u5411\u5bfc\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                this.setId(this.psDEWizard.getPSDEWIZARDID());
            } else {
                this.setId(SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppView().getId(), (Object)strName));
                this.bInvalidId = true;
            }
            this.setName(strName);
            this.setLogicName(this.psDEWizard.getPSDEWIZARDNAME());
            this.setPSObjectData(this.psDEWizard);
            if (this.getPSDataEntity() != null) {
                if (SA.SRFramework.Utility.StringHelper.Compare((String)this.psDEWizard.getPSDEID(), (String)this.getPSDataEntity().getId(), (boolean)true) != 0) {
                    this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEWizard.getPSDEID()));
                }
            } else {
                this.setPSDataEntity(this.getPSAppView().getPSSystem().getPSDataEntity2(this.psDEWizard.getPSDEID()));
            }
            this.iPSDEWizard = this.getPSDataEntity().getPSDEWizard(iPSDEWizardPanelParam.getPSDEWizardId());
            this.psDEWizardPanelParamImpl = this.createPSDEWizardPanelParam();
            this.psDEWizardPanelParamImpl.setPSCtrlMsgId(this.psDEWizard.getPSCTRLMSGID());
            this.psDEWizardPanelParamImpl.setPSSysPFPluginId(this.psDEWizard.getPSSYSPFPLUGINID());
            this.psDEWizardPanelParamImpl.setPSSysCssId(this.psDEWizard.getPSSYSCSSID());
            this.psDEWizardPanelParamImpl.setPSDEUILogicGroupId(this.psDEWizard.getPSCTRLLOGICGROUPID());
            this.psDEWizardPanelParamImpl.merge(iPSControlParam);
            if (this.psDEWizardPanelParamImpl.isShowStepBar() != null) {
                this.bShowStepBar = this.psDEWizardPanelParamImpl.isShowStepBar();
            }
            if (this.psDEWizardPanelParamImpl.isShowActionBar() != null) {
                this.bShowActionBar = this.psDEWizardPanelParamImpl.isShowActionBar();
            }
            super.init(iDAGlobalHelper, iPSControlContainer, strName, this.psDEWizardPanelParamImpl);
        }
        catch (Exception ex) {
            this.throwCriticalInitException(ex);
            String strLogName = StringHelper.format((String)"%1$s[%2$s]", (Object)PSModels.getModelName((String)this.getModelType()), (Object)this.getFullModelName());
            String strExInfo = StringHelper.format((String)"\u521d\u59cb\u5316\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage());
            log.error((Object)StringHelper.format((String)"%1$s%2$s", (Object)strLogName, (Object)strExInfo), (Throwable)ex);
            if (this.getPSSystemUtil() != null) {
                this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
            }
            this.throwInitException(ex);
        }
    }

    @Override
    protected void onInit() throws Exception {
        if (this.getPSDEWizard().getPrevCapPSLanguageRes() != null) {
            this.getPSAppView().getPSApplication().getPSLanguageRes(this.getPSDEWizard().getPrevCapPSLanguageRes().getId());
        }
        if (this.getPSDEWizard().getNextCapPSLanguageRes() != null) {
            this.getPSAppView().getPSApplication().getPSLanguageRes(this.getPSDEWizard().getNextCapPSLanguageRes().getId());
        }
        if (this.getPSDEWizard().getFinishCapPSLanguageRes() != null) {
            this.getPSAppView().getPSApplication().getPSLanguageRes(this.getPSDEWizard().getFinishCapPSLanguageRes().getId());
        }
        Iterator<IPSDEWizardForm> psDEWizardForms = this.getPSDEWizard().getPSDEWizardForms();
        while (psDEWizardForms.hasNext()) {
            IPSDEWizardForm iPSDEWizardForm = psDEWizardForms.next();
            if (iPSDEWizardForm.getCMPSLanguageRes() != null) {
                this.getPSAppView().getPSApplication().getPSLanguageRes(iPSDEWizardForm.getCMPSLanguageRes().getId());
            }
            if (iPSDEWizardForm.getCM2PSLanguageRes() != null) {
                this.getPSAppView().getPSApplication().getPSLanguageRes(iPSDEWizardForm.getCM2PSLanguageRes().getId());
            }
            PSDEEditFormParamImpl psDEEditFormParamImpl = new PSDEEditFormParamImpl();
            psDEEditFormParamImpl.setPSDEWizardForm(iPSDEWizardForm);
            PSDEViewCtrl formPSDEViewCtrl = new PSDEViewCtrl();
            formPSDEViewCtrl.setPSDEVIEWCTRLNAME(String.valueOf(this.getName()) + FORMNAME + iPSDEWizardForm.getFormTag());
            formPSDEViewCtrl.setPSDEFORMID(iPSDEWizardForm.getPSDEFormId());
            psDEEditFormParamImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), formPSDEViewCtrl);
            final IPSDEEditForm iPSDEEditForm = (IPSDEEditForm)this.registerPSControl(String.valueOf(this.getName()) + FORMNAME + iPSDEWizardForm.getFormTag(), "FORM", psDEEditFormParamImpl);
            this.psDEEditFormList.add(iPSDEEditForm);
            if (!this.isPrepareDefaultPSAppViewLogics()) continue;
            iPSDEEditForm.registerPSControlLogic(new PSControlLogicImpl(this){

                @Override
                public String getName() {
                    return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_formsave", (Object)super.getName());
                }

                @Override
                public String getLogicTag() {
                    return iPSDEEditForm.getName();
                }

                @Override
                public String getEventNames() {
                    return "SAVE";
                }
            });
            iPSDEEditForm.registerPSControlLogic(new PSControlLogicImpl(this){

                @Override
                public String getName() {
                    return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_formload", (Object)super.getName());
                }

                @Override
                public String getLogicTag() {
                    return iPSDEEditForm.getName();
                }

                @Override
                public String getEventNames() {
                    return "LOAD";
                }
            });
        }
        Iterator<IPSDEWizardStep> psDEWizardSteps = this.getPSDEWizard().getPSDEWizardSteps();
        if (psDEWizardSteps != null) {
            while (psDEWizardSteps.hasNext()) {
                IPSDEWizardStep iPSDEWizardStep = psDEWizardSteps.next();
                if (iPSDEWizardStep.getTitlePSLanguageRes() != null) {
                    this.getPSAppView().getPSApplication().getPSLanguageRes(iPSDEWizardStep.getTitlePSLanguageRes().getId());
                }
                if (iPSDEWizardStep.getSubTitlePSLanguageRes() == null) continue;
                this.getPSAppView().getPSApplication().getPSLanguageRes(iPSDEWizardStep.getSubTitlePSLanguageRes().getId());
            }
        }
        super.onInit();
    }

    protected PSDEWizardPanelParamImpl createPSDEWizardPanelParam() {
        return new PSDEWizardPanelParamImpl();
    }

    @Override
    public void fillRelatedPSAppViews(ArrayList<IPSAppView> relatedAppViewList) throws Exception {
        for (IPSDEEditForm iPSDEEditForm : this.psDEEditFormList) {
            iPSDEEditForm.fillRelatedPSAppViews(relatedAppViewList);
        }
        super.fillRelatedPSAppViews(relatedAppViewList);
    }

    @Override
    public String getModelScope() {
        return "DE";
    }

    @Override
    protected String onGetControlType() {
        return "WIZARDPANEL";
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5411\u5bfc\u5bf9\u8c61", child=true, model="PSDEViewCtrl", fields={"PSDEWIZARDID"})
    public IPSDEWizard getPSDEWizard() {
        return this.iPSDEWizard;
    }

    @Override
    public IPSAjaxControlParam getPSAjaxControlParam() {
        return this.psDEWizardPanelParamImpl;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u7f16\u8f91\u8868\u5355\u96c6\u5408", child=true)
    public Iterator<IPSDEEditForm> getPSDEEditForms() {
        return this.psDEEditFormList.iterator();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u6b65\u9aa4\u680f", model="PSDEViewCtrl", fields={"CTRLPARAM6"})
    public boolean isShowStepBar() {
        return this.bShowStepBar;
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u64cd\u4f5c\u680f", model="PSDEViewCtrl", fields={"CTRLPARAM5"})
    public boolean isShowActionBar() {
        return this.bShowActionBar;
    }

    @Override
    public void fillEmbeddedPSAppViewRefs(String strContainerId, ArrayList<IPSAppViewRef> embeddedPSAppViewRefList) throws Exception {
        for (IPSDEEditForm iPSDEEditForm : this.psDEEditFormList) {
            iPSDEEditForm.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
        }
        super.fillEmbeddedPSAppViewRefs(strContainerId, embeddedPSAppViewRefList);
    }

    @Override
    public String getModelType() {
        return "PSDEWIZARDPANEL";
    }

    @Override
    protected IPSAjaxControlHandler createDefaultPSAjaxControlHandler() throws Exception {
        if (this.getPSDEWizard() != null) {
            PSACHandlerAction psACHandlerAction;
            PSAjaxControlHandlerActionImpl psAjaxControlHandlerActionImpl;
            PSAjaxControlHandlerImpl psAjaxControlHandlerImpl = new PSAjaxControlHandlerImpl();
            PSACHandler psAjaxControlHandler = new PSACHandler();
            psAjaxControlHandlerImpl.init(this.getDAGlobalHelper(), this.getPSAppView(), this, psAjaxControlHandler);
            if (this.getPSDEWizard().getInitPSDEAction() != null) {
                psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
                psACHandlerAction = new PSACHandlerAction();
                psACHandlerAction.setPSACHANDLERACTIONID("init");
                psACHandlerAction.setPSACHANDLERACTIONNAME("init");
                psACHandlerAction.setACTIONTYPE("DEACTION");
                psACHandlerAction.setPSDEACTIONID(this.getPSDEWizard().getInitPSDEAction().getId());
                psACHandlerAction.setPSDEACTIONNAME(this.getPSDEWizard().getInitPSDEAction().getName());
                psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), psAjaxControlHandlerImpl, psACHandlerAction);
                psAjaxControlHandlerImpl.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
            }
            if (this.getPSDEWizard().getFinishPSDEAction() != null) {
                psAjaxControlHandlerActionImpl = new PSAjaxControlHandlerActionImpl();
                psACHandlerAction = new PSACHandlerAction();
                psACHandlerAction.setPSACHANDLERACTIONID("finish");
                psACHandlerAction.setPSACHANDLERACTIONNAME("finish");
                psACHandlerAction.setACTIONTYPE("DEACTION");
                psACHandlerAction.setPSDEACTIONID(this.getPSDEWizard().getFinishPSDEAction().getId());
                psACHandlerAction.setPSDEACTIONNAME(this.getPSDEWizard().getFinishPSDEAction().getName());
                psAjaxControlHandlerActionImpl.init(this.getDAGlobalHelper(), psAjaxControlHandlerImpl, psACHandlerAction);
                psAjaxControlHandlerImpl.registerPSAjaxHandlerAction(psAjaxControlHandlerActionImpl);
            }
            return psAjaxControlHandlerImpl;
        }
        return super.createDefaultPSAjaxControlHandler();
    }

    @Override
    public void fillRelatedPSCodeLists(ArrayList<IPSCodeList> relatedPSCodeListList) throws Exception {
        if (this.psDEEditFormList != null && this.psDEEditFormList.size() > 0) {
            for (IPSDEEditForm iPSDEEditForm : this.psDEEditFormList) {
                iPSDEEditForm.fillRelatedPSCodeLists(relatedPSCodeListList);
            }
        }
        super.fillRelatedPSCodeLists(relatedPSCodeListList);
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    @Override
    protected String onGetCodeName() {
        return this.getPSApplication().getViewCodeName(null, this.getPSDEWizard().getCodeName(), null);
    }

    @Override
    @PSModelRTMeta(description="\u521d\u59cb\u5316\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getInitPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("init", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u6210\u884c\u4e3a", hideempty=true, dumpref=true, from="__self__", from_method="getPSControlHandlerMust().getPSControlHandlerAction")
    public IPSControlAction getFinishPSControlAction() {
        try {
            if (this.getPSAjaxControlHandler() != null) {
                return this.getPSAjaxControlHandler().getPSAjaxHandlerAction("finish", true);
            }
            return null;
        }
        catch (Exception ex) {
            log.error((Object)ex);
            return null;
        }
    }

    @Override
    @PSModelRTMeta(description="\u5185\u7f6e\u5f0f\u6837", model="PSDEWizard", fields={"WIZARDSTYLE"})
    public String getWizardStyle() {
        return this.getPSDEWizard().getWizardStyle();
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u5c5e\u6027")
    public IPSDEField getStatePSDEField() {
        return this.getPSDEWizard().getStatePSDEField();
    }

    @Override
    @PSModelRTMeta(description="\u72b6\u6001\u5e94\u7528\u5b9e\u4f53\u5c5e\u6027", dumpref=true, model="PSDEWizard", fields={"STATEPSDEFID"})
    public IPSAppDEField getStatePSAppDEField() {
        if (this.getStatePSDEField() != null && this.getPSAppDataEntity() != null) {
            try {
                return this.getPSAppDataEntity().getPSAppDEField(this.getStatePSDEField(), true);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u90e8\u4ef6\u96c6\u5408", hideempty2=true)
    public Iterator<IPSControl> getPSControls() {
        return super.getPSControls();
    }

    @Override
    protected Iterator<? extends IPSAppDEUILogicGroupDetail> getPSAppDEUILogicGroupDetails() {
        Iterator<? extends IPSDEWizardLogic> psDEWizardLogics = this.getPSDEWizard().getPSDEWizardLogics();
        if (psDEWizardLogics == null) {
            return null;
        }
        ArrayList<IPSAppDEUILogicGroupDetail> list = new ArrayList<IPSAppDEUILogicGroupDetail>();
        while (psDEWizardLogics.hasNext()) {
            IPSDEWizardLogic iPSDEWizardLogic = psDEWizardLogics.next();
            if (!(iPSDEWizardLogic instanceof IPSAppDEUILogicGroupDetail)) continue;
            list.add((IPSAppDEUILogicGroupDetail)((Object)iPSDEWizardLogic));
        }
        if (list.size() == 0) {
            return null;
        }
        return list.iterator();
    }
}

