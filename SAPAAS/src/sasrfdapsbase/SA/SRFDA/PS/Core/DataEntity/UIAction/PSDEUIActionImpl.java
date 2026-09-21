/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.util.PropertiesHelper
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.DataEntity.UIAction;

import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEACMode;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataExport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEDataImport;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEMethod;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEPrint;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUIAction;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Logic.IPSAppUILogic;
import SA.SRFDA.PS.Core.App.View.IPSAppDEGridView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEMultiDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppDETreeGridView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEWFActionView;
import SA.SRFDA.PS.Core.App.View.IPSAppDEXDataView;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.App.View.IPSAppViewPreview;
import SA.SRFDA.PS.Core.App.View.PSAppDEFormPreviewViewImpl;
import SA.SRFDA.PS.Core.Control.Form.IPSDEEditForm;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlXDataContainer;
import SA.SRFDA.PS.Core.Control.IPSNavigateContext;
import SA.SRFDA.PS.Core.Control.IPSNavigateParam;
import SA.SRFDA.PS.Core.Control.PSNavigateContextImpl;
import SA.SRFDA.PS.Core.Control.PSNavigateParamImpl;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDECMUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDETBUIActionItem;
import SA.SRFDA.PS.Core.Control.Toolbar.IPSDEToolbarItem;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEOPPriv;
import SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIAction;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.PF.IPSPFPlugin;
import SA.SRFDA.PS.Core.PF.IPSPFXCodeObject;
import SA.SRFDA.PS.Core.PF.PSPFXCodeObjectProxy;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSysImage;
import SA.SRFDA.PS.Core.Res.IPSSysPDTView;
import SA.SRFDA.PS.Core.Res.IPSSysPFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysPFPluginTempl;
import SA.SRFDA.PS.Core.View.IPSUIAction;
import SA.SRFDA.PS.Core.View.IPSUIActionGroup;
import SA.SRFDA.PS.Core.View.IPSUIActionRuntime;
import SA.SRFDA.PS.Core.View.IPSViewLogic;
import SA.SRFDA.PS.Core.View.PSUIActionImpl;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEUIAction;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.Helper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.util.PropertiesHelper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDEUIActionImpl
extends PSUIActionImpl
implements IPSDEUIAction,
IPSUIActionRuntime,
IPSAppDEUIAction {
    private static final Log log = LogFactory.getLog(PSDEUIActionImpl.class);
    protected PSDEUIAction psDEUIAction = null;
    private boolean bUIActionGroup = false;
    private boolean bEnableUIActionGroupExMode = false;
    private String strUIActionTag = "";
    private String strUIActionFullTag = null;
    private String strCodeName = "";
    private String strFullCodeName = "";
    private IPSDEAction iPSDEAction = null;
    private boolean bValid = true;
    private IPSDataEntity iPSDataEntity = null;
    private IPSSysImage iPSSysImage = null;
    private IPSSystem iPSSystem = null;
    private long nTimeout = 60000L;
    private String strConfirmMsg = null;
    private boolean bReloadData = false;
    private String strSuccessMsg = null;
    private IPSDEOPPriv iPSDEOPPriv = null;
    private boolean bCloseEditView = false;
    private String strViewLogicAttachMode = null;
    private String strViewLogicType = null;
    private String strPSDEViewLogicId = null;
    private String strPSSysViewLogicId = null;
    private IPSLanguageRes capPSLanguageRes = null;
    private IPSLanguageRes tooltipPSLanguageRes = null;
    private IPSLanguageRes cmPSLanguageRes = null;
    private IPSLanguageRes smPSLanguageRes = null;
    private int nNoPrivDisplayMode = 2;
    private boolean bHasNoPrivDisplayMode = false;
    private JSONObject uiActionParamJO = null;
    private String strUIActionParam = null;
    private String strValueItem = null;
    private String strTextItem = null;
    private String strParamItem = null;
    private boolean bEnableRuntimeModel = false;
    private boolean bGlobalUIAction = false;
    private IPSUIAction nextPSUIAction = null;
    private IPSSysPFPlugin iPSSysPFPlugin = null;
    private int nExtendMode = 0;
    private boolean bPDTFrontView = false;
    private IPSSysPDTView iPSSysPDTView = null;
    private boolean bShowBusyIndicator = true;
    private int nRefreshMode = 0;
    private IPSAppDataEntity iPSAppDataEntity = null;
    private IPSAppView frontPSAppView = null;
    private IPSAppDEMethod iPSAppDEMethod = null;
    private IPSApplication iPSApplication = null;
    private boolean bSaveTargetFirst = false;
    private String strCounterId = null;
    private IPSAppCounter iPSAppCounter = null;
    private IPSPFXCodeObject iPSPFXCodeObject = null;
    private boolean bEnableViewActions = false;
    private long nViewActions = 0L;
    private String strReplacePSSysUIActionId = null;
    private Map<String, IPSNavigateContext> psNavigateContextMap = null;
    private Map<String, IPSNavigateParam> psNavigateParamMap = null;
    private boolean bEnableConfirm = true;
    private int nActionLevel = 100;
    private String strButtonStyle = null;
    private int nCloseWindowMode = 0;
    private IPSAppDEPrint iPSAppDEPrint = null;
    private IPSAppDEDataImport iPSAppDEDataImport = null;
    private IPSAppDEDataExport iPSAppDEDataExport = null;
    private IPSAppDEACMode iPSAppDEACMode = null;
    private String strScriptCode = null;
    private IPSDEEditForm iPSDEEditForm = null;
    private String strPSDEEditFormId = null;
    private String strMobPSDEEditFormId = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, IPSAppDataEntity iPSAppDataEntity, PSDEUIAction psDEUIAction) throws Exception {
        this.iPSAppDataEntity = iPSAppDataEntity;
        this.iPSApplication = iPSApplication;
        if (this.iPSAppDataEntity != null) {
            this.init(iDAGlobalHelper, iPSApplication.getPSSystem(), this.iPSAppDataEntity.getPSDataEntity(), psDEUIAction);
        } else {
            this.init(iDAGlobalHelper, iPSApplication.getPSSystem(), null, psDEUIAction);
        }
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, IPSDataEntity iPSDataEntity, PSDEUIAction psDEUIAction) throws Exception {
        try {
            this.setDAGlobalHelper(iDAGlobalHelper);
            this.setPSDataEntity(iPSDataEntity);
            this.iPSSystem = iPSSystem;
            this.psDEUIAction = psDEUIAction;
            this.setId(this.psDEUIAction.getPSDEUIACTIONID());
            this.setName(this.psDEUIAction.getPSDEUIACTIONNAME());
            this.setPSObjectData(this.psDEUIAction);
            if (!this.psDEUIAction.isEXTENDMODENull()) {
                this.nExtendMode = this.psDEUIAction.getEXTENDMODE();
            }
            this.strUIActionTag = this.psDEUIAction.getCODENAME();
            this.strCodeName = this.psDEUIAction.getCODENAME();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strCodeName)) {
                this.strCodeName = this.psDEUIAction.getPSDEUIACTIONNAME();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"SYS", (boolean)true) != 0) {
                if (this.getPSAppDataEntity() != null) {
                    this.strUIActionFullTag = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s", (Object)this.getUIActionTag(), (Object)this.getPSAppDataEntity().getCodeName());
                    this.strFullCodeName = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)this.getPSAppDataEntity().getCodeName(), (Object)this.getCodeName());
                } else if (iPSDataEntity != null) {
                    this.strUIActionFullTag = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s@%2$s", (Object)this.getUIActionTag(), (Object)iPSDataEntity.getCodeName());
                    this.strFullCodeName = SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_%2$s", (Object)iPSDataEntity.getCodeName(), (Object)this.getCodeName());
                }
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"FRONT", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"BACKEND", (boolean)true) == 0) {
                if (!this.psDEUIAction.isENABLEVIEWACTIONSNull()) {
                    this.bEnableViewActions = this.psDEUIAction.getENABLEVIEWACTIONS();
                    if (this.bEnableViewActions) {
                        this.nViewActions = this.psDEUIAction.getVIEWACTIONS();
                    }
                }
                this.strReplacePSSysUIActionId = this.psDEUIAction.getREPPSSYSUIACTIONID();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"CUSTOM", (boolean)true) == 0) {
                this.strScriptCode = this.psDEUIAction.getCUSTOMCODE();
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"FRONT", (boolean)true) == 0 && SA.SRFramework.Utility.StringHelper.Compare((String)this.getFrontProcessType(), (String)"OTHER", (boolean)true) == 0) {
                this.strScriptCode = this.psDEUIAction.getCUSTOMCODE();
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"FRONT", (boolean)true) == 0 && (SA.SRFramework.Utility.StringHelper.Compare((String)this.getFrontProcessType(), (String)"EDITFORM", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getFrontProcessType(), (String)"QUICKEDIT", (boolean)true) == 0)) {
                this.strPSDEEditFormId = this.psDEUIAction.getPSDEFORMID();
                this.strMobPSDEEditFormId = this.psDEUIAction.getMOBPSDEFORMID();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSDEACTIONID())) {
                this.iPSDEAction = this.getPSDataEntity().getPSDEAction(this.psDEUIAction.getPSDEACTIONID());
            }
            if (this.getPSDEAction() != null && this.getPSAppDataEntity() != null) {
                this.iPSAppDEMethod = this.getPSAppDataEntity().getPSAppDEMethod(this.getPSDEAction(), true);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSSYSIMAGEID())) {
                this.iPSSysImage = this.iPSSystem.getPSSysImage(this.psDEUIAction.getPSSYSIMAGEID());
            }
            if (this.psDEUIAction.getTIMEOUT() > 0) {
                this.nTimeout = this.psDEUIAction.getTIMEOUT();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCONFIRMINFO())) {
                this.strConfirmMsg = this.psDEUIAction.getCONFIRMINFO();
            }
            if (!this.psDEUIAction.isRELOADDATANull()) {
                this.nRefreshMode = this.psDEUIAction.GetParamIntValue("RELOADDATA", this.nRefreshMode);
                this.setReloadData(this.nRefreshMode > 0);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getSUCCESSINFO())) {
                this.strSuccessMsg = this.psDEUIAction.getSUCCESSINFO();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDEUIAction.getPSDEOPPRIVID())) {
                this.iPSDEOPPriv = this.iPSSystem.getPSDEOPPriv(psDEUIAction.getPSDEOPPRIVID());
            }
            if (!this.psDEUIAction.isCLOSEEDITVIEWNull()) {
                this.nCloseWindowMode = this.psDEUIAction.getCLOSEEDITVIEW();
                this.setCloseEditView(this.nCloseWindowMode != 0);
            }
            if (!this.psDEUIAction.isGLOBALFLAGNull()) {
                this.setGlobalUIAction(psDEUIAction.getGLOBALFLAG());
            }
            if (!this.psDEUIAction.isENABLERTMODELNull()) {
                this.setEnableRuntimeModel(psDEUIAction.getENABLERTMODEL());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCOUNTERID())) {
                this.strCounterId = this.psDEUIAction.getCOUNTERID();
            }
            if (!this.psDEUIAction.isPDTVIEWFLAGNull()) {
                this.bPDTFrontView = psDEUIAction.getPDTVIEWFLAG();
            }
            if (this.isFrontPDTView() && SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getFrontPSSysPDTViewId())) {
                this.iPSSysPDTView = this.getPSSystem().getPSSysPDTView(this.getFrontPSSysPDTViewId());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSSYSPFPLUGINID())) {
                this.iPSSysPFPlugin = this.getPSApplication() != null ? this.getPSApplication().getPSSysPFPlugin(this.psDEUIAction.getPSSYSPFPLUGINID(), "UIACTION", this.getUIActionMode(), null) : this.getPSSystem().getPSSysPFPlugin(this.psDEUIAction.getPSSYSPFPLUGINID());
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getVLEXECMODE())) {
                this.strViewLogicAttachMode = this.psDEUIAction.getVLEXECMODE();
                this.strViewLogicType = this.psDEUIAction.getVIEWLOGICTYPE();
                this.strPSDEViewLogicId = this.psDEUIAction.getPSDEVIEWLOGICID();
                this.strPSSysViewLogicId = this.psDEUIAction.getPSSYSVIEWLOGICID();
            }
            if (this.getPSApplication() != null) {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCAPPSLANRESID())) {
                    this.capPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psDEUIAction.getCAPPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getTIPPSLANRESID())) {
                    this.tooltipPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psDEUIAction.getTIPPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCMPSLANRESID())) {
                    this.cmPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psDEUIAction.getCMPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getSMPSLANRESID())) {
                    this.smPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psDEUIAction.getSMPSLANRESID());
                }
            } else {
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCAPPSLANRESID())) {
                    this.capPSLanguageRes = this.iPSSystem.getPSLanguageRes(this.psDEUIAction.getCAPPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getTIPPSLANRESID())) {
                    this.tooltipPSLanguageRes = this.iPSSystem.getPSLanguageRes(this.psDEUIAction.getTIPPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getCMPSLANRESID())) {
                    this.cmPSLanguageRes = this.iPSSystem.getPSLanguageRes(this.psDEUIAction.getCMPSLANRESID());
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getSMPSLANRESID())) {
                    this.smPSLanguageRes = this.iPSSystem.getPSLanguageRes(this.psDEUIAction.getSMPSLANRESID());
                }
            }
            if (!this.psDEUIAction.isNOPRIVDMNull()) {
                this.bHasNoPrivDisplayMode = true;
                this.nNoPrivDisplayMode = this.psDEUIAction.getNOPRIVDM();
            }
            if (!this.psDEUIAction.isBUSYINDICATORNull()) {
                this.bShowBusyIndicator = this.psDEUIAction.getBUSYINDICATOR();
            }
            this.bEnableConfirm = !this.psDEUIAction.isUSERCONFIRMNull() ? this.psDEUIAction.getUSERCONFIRM() : SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"BACKEND", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"WFBACKEND", (boolean)true) == 0;
            this.strUIActionParam = psDEUIAction.getUIACTIONPARAMS().trim();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUIActionParam)) {
                if (this.strUIActionParam.charAt(0) == '{') {
                    this.uiActionParamJO = JSONObject.fromString((String)this.strUIActionParam);
                } else {
                    this.uiActionParamJO = new JSONObject();
                    Properties properties = PropertiesHelper.load((String)this.strUIActionParam);
                    this.onPreparePSUIActionParams(properties);
                }
            }
            this.strValueItem = this.psDEUIAction.getDATAITEM().trim();
            this.strTextItem = this.psDEUIAction.getTEXTITEM().trim();
            this.strParamItem = this.psDEUIAction.getPARAMITEM().trim();
            if (!this.psDEUIAction.isACTIONLEVELNull()) {
                this.nActionLevel = this.psDEUIAction.getACTIONLEVEL();
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getBUTTONSTYLE())) {
                this.strButtonStyle = this.psDEUIAction.getBUTTONSTYLE();
            }
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDEUIActionImpl.this.getModelType()) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSDEUIActionImpl.this.getId())) {
                        if (!ActionSessionManager.getCurrentSession().registerRecursion(PSDEUIActionImpl.this.getModelType(), (Object)PSDEUIActionImpl.this.getId())) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5b58\u5728\u9012\u5f52\u5f15\u7528"));
                        }
                        try {
                            PSDEUIActionImpl.this.onInit();
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEUIActionImpl.this.getModelType(), (Object)PSDEUIActionImpl.this.getId());
                        }
                        catch (Exception ex) {
                            ActionSessionManager.getCurrentSession().unregisterRecursion(PSDEUIActionImpl.this.getModelType(), (Object)PSDEUIActionImpl.this.getId());
                            throw ex;
                        }
                    }
                }
            });
        }
        catch (Exception ex) {
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
        String strSysUIActionId = this.psDEUIAction.getPSSYSUIACTIONID();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strSysUIActionId)) {
            this.bUIActionGroup = strSysUIActionId.indexOf("VIEW_DEBHGROUP") == 0;
            boolean bl = this.bEnableUIActionGroupExMode = strSysUIActionId.indexOf("VIEW_DEBHGROUPEX") == 0;
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getNEXTPSDEUIACTIONID()) && SA.SRFramework.Utility.StringHelper.Compare((String)this.getId(), (String)this.psDEUIAction.getNEXTPSDEUIACTIONID(), (boolean)false) == 0) {
            throw new Exception("\u4e0b\u4e00\u6b65\u754c\u9762\u884c\u4e3a\u4e0d\u80fd\u6307\u5411\u81ea\u5df1");
        }
        if (this.getPSSysPFPlugin() != null && this.getPSApplication() != null) {
            String strPSSysPFPluginTemplId = KeyValueHelper.genUniqueId((String)this.getPSSysPFPlugin().getId(), (String)this.getPSApplication().getPSPF().getId());
            IPSSysPFPluginTempl iPSSysPFPluginTempl = this.getPSApplication().getPSSystem().getPSSysPFPluginTempl(strPSSysPFPluginTemplId, true);
            if (iPSSysPFPluginTempl != null) {
                this.iPSPFXCodeObject = new PSPFXCodeObjectProxy(iPSSysPFPluginTempl, null, null, (Object)this);
            }
        }
        super.onInit();
    }

    @Override
    protected int onCheck() throws Exception {
        this.getFrontPSAppView();
        if (this.getPSAppDEUILogic() != null) {
            this.getPSAppDEUILogic().check();
        }
        this.getPSAppDEACMode();
        return super.onCheck();
    }

    protected void onPreparePSUIActionParams(Properties uiactionParams) throws Exception {
        if (uiactionParams != null) {
            for (Object objKey : uiactionParams.keySet()) {
                PSNavigateParamImpl PSNavigateParamImpl2;
                boolean bRawValue;
                String strKey = objKey.toString();
                String strValue = PropertiesHelper.getProperty((Properties)uiactionParams, (String)strKey);
                String strTag = strKey.toUpperCase();
                if (strTag.indexOf("SRFNAVCTX.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVCTX.".length()).toUpperCase();
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateContextImpl PSNavigateContextImpl2 = new PSNavigateContextImpl();
                    PSNavigateContextImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateContextMap == null) {
                        this.psNavigateContextMap = new LinkedHashMap<String, IPSNavigateContext>();
                    }
                    this.psNavigateContextMap.put(strTag, PSNavigateContextImpl2);
                    continue;
                }
                if (strTag.indexOf("SRFNAVPARAM.") == 0) {
                    bRawValue = true;
                    strTag = strKey.substring("SRFNAVPARAM.".length()).toLowerCase();
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                        strValue = strValue.replace("%", "");
                        bRawValue = false;
                    }
                    PSNavigateParamImpl2 = new PSNavigateParamImpl();
                    PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag, strValue, null, bRawValue);
                    if (this.psNavigateParamMap == null) {
                        this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                    }
                    this.psNavigateParamMap.put(strTag, PSNavigateParamImpl2);
                    continue;
                }
                bRawValue = true;
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strValue) && strValue.charAt(0) == '%' && strValue.charAt(strValue.length() - 1) == '%') {
                    strValue = strValue.replace("%", "");
                    bRawValue = false;
                }
                PSNavigateParamImpl2 = new PSNavigateParamImpl();
                PSNavigateParamImpl2.init(this.getDAGlobalHelper(), this, strTag.toLowerCase(), strValue, null, bRawValue);
                if (this.psNavigateParamMap == null) {
                    this.psNavigateParamMap = new LinkedHashMap<String, IPSNavigateParam>();
                }
                this.psNavigateParamMap.put(strTag.toLowerCase(), PSNavigateParamImpl2);
                this.uiActionParamJO.put(strKey, (Object)PropertiesHelper.getProperty((Properties)uiactionParams, (String)strKey));
            }
        }
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53", hideempty=true, dumpref=true, fields={"PSDEID"})
    public IPSAppDataEntity getPSAppDataEntity() {
        return this.iPSAppDataEntity;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u6a21\u5f0f", codelist="DEUIActionType", group="\u57fa\u672c", order=128, fields={"UIACTIONTYPE"})
    public String getUIActionMode() {
        return this.psDEUIAction.getUIACTIONTYPE();
    }

    @Override
    public String getCaption(String strLanguage) {
        return this.psDEUIAction.getCAPTION();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u7c7b\u578b", displayvalue="\u5b9e\u4f53\u754c\u9762\u884c\u4e3a(DEUIACTION)")
    public String getUIActionType() {
        return "DEUIACTION";
    }

    @Override
    public String getPSSysDEUIActionId(Object obj) throws Exception {
        return this.psDEUIAction.getPSSYSUIACTIONID();
    }

    @Override
    public boolean isUIActionGroup(Object obj) throws Exception {
        return this.bUIActionGroup;
    }

    @Override
    public boolean isEnableUIActionGroupExMode(Object obj) throws Exception {
        return this.bEnableUIActionGroupExMode;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u6807\u8bb0", fields={"CODENAME"})
    public String getUIActionTag() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUIActionTag)) {
            return this.getId();
        }
        return this.strUIActionTag;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u64cd\u4f5c\u76ee\u6807", codelist="DEUIActionDataRange", fields={"ACTIONTARGET"})
    public String getActionTarget() {
        return this.psDEUIAction.getACTIONTARGET();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u53f0\u5904\u7406\u7c7b\u578b", codelist="DEUIActionFrontType", hideempty2=true, fields={"FRONTPROTYPE"})
    public String getFrontProcessType() {
        return this.psDEUIAction.getFRONTPROTYPE();
    }

    @Override
    @PSModelRTMeta(description="\u4ee3\u7801\u6807\u8bc6")
    public String getCodeName() {
        return this.onGetCodeName();
    }

    protected String onGetCodeName() {
        return this.strCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u540e\u53f0\u8c03\u7528\u5b9e\u4f53\u884c\u4e3a", hideempty=true)
    public IPSDEAction getPSDEAction() {
        return this.iPSDEAction;
    }

    @Override
    public boolean isValid(Object obj) throws Exception {
        if (!this.isValid()) {
            return false;
        }
        if (this.isEnableViewActions()) {
            long nCurViewActions = 0L;
            if ((this.getViewActions() & 1L) == 1L) {
                if (this.testNewData(obj, false)) {
                    nCurViewActions |= 1L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 2L) == 2L) {
                if (this.testEditData(obj, false)) {
                    nCurViewActions |= 2L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 4L) == 4L) {
                if (this.testViewData(obj, false)) {
                    nCurViewActions |= 4L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 8L) == 8L) {
                if (this.testRemoveData(obj, false)) {
                    nCurViewActions |= 8L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 0x10L) == 16L) {
                if (this.testCopyData(obj, false)) {
                    nCurViewActions |= 0x10L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 0x20L) == 32L) {
                if (this.testRowEdit(obj, false)) {
                    nCurViewActions |= 0x20L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 0x40L) == 64L) {
                if (this.testExportData(obj, false)) {
                    nCurViewActions |= 0x40L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 0x80L) == 128L) {
                if (this.testPrintData(obj, false)) {
                    nCurViewActions |= 0x80L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 0x100L) == 256L) {
                if (this.testFilter(obj, false)) {
                    nCurViewActions |= 0x100L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 0x200L) == 512L) {
                if (this.testHelp(obj, false)) {
                    nCurViewActions |= 0x200L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 0x400L) == 1024L) {
                if (this.testImportData(obj, false)) {
                    nCurViewActions |= 0x400L;
                } else {
                    return false;
                }
            }
            if ((this.getViewActions() & 0x800L) == 2048L) {
                if (this.testStartWF(obj, false)) {
                    nCurViewActions |= 0x800L;
                } else {
                    return false;
                }
            }
            return this.getViewActions() == nCurViewActions;
        }
        return true;
    }

    protected boolean isValid() {
        return this.bValid;
    }

    protected void setValid(boolean bValid) {
        this.bValid = bValid;
    }

    @Override
    @PSModelRTMeta(description="\u5b9e\u4f53\u5bf9\u8c61", hideempty2=true)
    public IPSDataEntity getPSDataEntity() {
        return this.iPSDataEntity;
    }

    protected void setPSDataEntity(IPSDataEntity iPSDataEntity) {
        this.iPSDataEntity = iPSDataEntity;
    }

    public IDataEntity getDataEntity() {
        return this.getPSDataEntity();
    }

    @Override
    public IPSUIActionGroup getPSUIActionGroup(Object obj) throws Exception {
        if (!this.isUIActionGroup(obj)) {
            return null;
        }
        if (obj instanceof IPSDEToolbarItem) {
            IPSDEToolbarItem iPSDEToolbarItem = (IPSDEToolbarItem)obj;
            return iPSDEToolbarItem.getPSDEToolbar().getPSDEUIActionGroup(this.getPSSysDEUIActionId(obj));
        }
        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u5bf9\u8c61\uff0c\u7c7b\u578b\u4e3a[%1$s]", (Object)obj.getClass().getCanonicalName()));
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u56fe\u6807\u5bf9\u8c61", hideempty=true, fields={"PSSYSIMAGEID"})
    public IPSSysImage getPSSysImage() {
        return this.iPSSysImage;
    }

    @Override
    public String getTooltip(String strLanguage) {
        return this.getTooltip();
    }

    @Override
    @PSModelRTMeta(description="Html\u9875\u9762\u8def\u5f84", fields={"HTMLPAGEURL"})
    public String getHtmlPageUrl() {
        return this.psDEUIAction.getHTMLPAGEURL();
    }

    @Override
    public String getPSSysModelInstId() {
        if (this.iPSSystem != null) {
            return this.iPSSystem.getPSSysModelInstId();
        }
        if (this.iPSDataEntity != null) {
            return this.iPSDataEntity.getPSSysModelInstId();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u8d85\u65f6\u65f6\u957f\uff08\u6beb\u79d2\uff09", fields={"TIMEOUT"})
    public long getTimeout() {
        return this.nTimeout;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u786e\u8ba4\u4fe1\u606f", hideempty2=true, fields={"CONFIRMINFO"})
    public String getConfirmMsg() {
        return this.strConfirmMsg;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u540e\u5237\u65b0\u5f53\u524d\u754c\u9762", ignoredumpvalues="false", fields={"RELOADDATA"})
    public boolean isReloadData() {
        return this.bReloadData;
    }

    public void setReloadData(boolean bReloadData) {
        this.bReloadData = bReloadData;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u6210\u529f\u63d0\u793a\u4fe1\u606f", hideempty2=true, fields={"SUCCESSINFO"})
    public String getSuccessMsg() {
        return this.strSuccessMsg;
    }

    public void setSuccessMsg(String strSuccessMsg) {
        this.strSuccessMsg = strSuccessMsg;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u8bbf\u95ee\u6743\u9650", hideempty2=true, fields={"PSDEOPPRIVID"})
    public String getDataAccessAction() {
        if (this.iPSDEOPPriv != null) {
            return this.iPSDEOPPriv.getName();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u540e\u5173\u95ed\u7f16\u8f91\u89c6\u56fe", ignoredumpvalues="false", fields={"CLOSEEDITVIEW"})
    public boolean isCloseEditView() {
        return this.bCloseEditView;
    }

    public void setCloseEditView(boolean bCloseEditView) {
        this.bCloseEditView = bCloseEditView;
    }

    @Override
    public boolean isEnableToggleMode() {
        return false;
    }

    @Override
    public int getExtendMode() {
        return this.nExtendMode;
    }

    @Override
    public String getModelType() {
        if (this.getPSAppDataEntity() != null) {
            return "PSAPPDEUIACTION";
        }
        if (this.getPSApplication() != null) {
            return "PSSYSAPPDEUIACTION";
        }
        return "PSDEUIACTION";
    }

    @Override
    public String getModelId() {
        if (this.getPSAppDataEntity() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSAppDataEntity().getModelId(), (Object)super.getModelId());
        }
        if (this.getPSApplication() != null) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getPSApplication().getModelId(), (Object)super.getModelId());
        }
        return super.getModelId();
    }

    @Override
    public String getFullModelName() {
        if (this.getPSAppDataEntity() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSAppDataEntity().getFullModelName(), (Object)this.getModelName());
        }
        if (this.getPSApplication() != null) {
            return StringHelper.format((String)"%1$s|%2$s", (Object)this.getPSApplication().getFullModelName(), (Object)this.getModelName());
        }
        return super.getFullModelName();
    }

    public void init(IDataEntity iDataEntity) throws Exception {
    }

    @Override
    public String getViewLogicAttachMode() {
        return this.strViewLogicAttachMode;
    }

    @Override
    public String getViewLogicType() {
        return this.strViewLogicType;
    }

    @Override
    public String getPSDEUILogicId() {
        return this.strPSDEViewLogicId;
    }

    @Override
    public String getPSSysViewLogicId() {
        return this.strPSSysViewLogicId;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u903b\u8f91\u9644\u52a0\u7c7b\u578b", codelist="DEUIActionVLExecMode", fields={"VLEXECMODE"})
    public String getUILogicAttachMode() {
        return this.getViewLogicAttachMode();
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u903b\u8f91\u7c7b\u578b", fields={"VIEWLOGICTYPE"})
    public String getUILogicType() {
        return this.getViewLogicType();
    }

    protected IPSControlXDataContainer getPSControlXDataContainer(Object obj) {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSDECMUIActionItem iPSDECMUIActionItem;
        if (obj == null) {
            return null;
        }
        if (obj instanceof IPSDECMUIActionItem && (iPSDECMUIActionItem = (IPSDECMUIActionItem)obj).getPSDEContextMenu() != null) {
            return iPSDECMUIActionItem.getPSDEContextMenu().getPSControlXDataContainer();
        }
        if (obj instanceof IPSDETBUIActionItem && (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSDEToolbar() != null) {
            return iPSDETBUIActionItem.getPSDEToolbar().getPSControlXDataContainer();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u6807\u9898\u8bed\u8a00\u8d44\u6e90", fields={"CAPPSLANRESID"})
    public IPSLanguageRes getCapPSLanguageRes() {
        return this.capPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u8bed\u8a00\u8d44\u6e90", fields={"TIPPSLANRESID"})
    public IPSLanguageRes getTooltipPSLanguageRes() {
        return this.tooltipPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u786e\u8ba4\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", hideempty=true, fields={"CMPSLANRESID"})
    public IPSLanguageRes getCMPSLanguageRes() {
        return this.cmPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u6210\u529f\u4fe1\u606f\u8bed\u8a00\u8d44\u6e90", hideempty=true, fields={"SMPSLANRESID"})
    public IPSLanguageRes getSMPSLanguageRes() {
        return this.smPSLanguageRes;
    }

    @Override
    @PSModelRTMeta(description="\u65e0\u6743\u9650\u663e\u793a\u6a21\u5f0f", modelattr="getNoPrivDisplayMode", ignoredumpvalues="2", codelist="BtnNoPrivDisplayMode", fields={"NOPRIVDM"})
    public int getAppNoPrivDisplayMode() {
        if (this.bHasNoPrivDisplayMode || this.getPSApplication() == null) {
            return this.nNoPrivDisplayMode;
        }
        if (this.getPSApplication().getPSAppUIStyle() != null) {
            return this.getPSApplication().getPSAppUIStyle().getButtonNoPrivDisplayMode();
        }
        return this.getPSApplication().getPSApplicationUI().getButtonNoPrivDisplayMode();
    }

    @Override
    public int getNoPrivDisplayMode(IPSAppView iPSAppView) {
        if (this.bHasNoPrivDisplayMode || iPSAppView == null) {
            return this.nNoPrivDisplayMode;
        }
        return iPSAppView.getButtonNoPrivDisplayMode();
    }

    @PSModelRTMeta(description="\u6807\u9898", fields={"CAPTION"})
    public String getCaption() {
        return this.psDEUIAction.getCAPTION();
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u63d0\u793a\u4fe1\u606f", fields={"TOOLTIPINFO"})
    public String getTooltip() {
        return this.psDEUIAction.getTOOLTIPINFO();
    }

    public String getCapLanResTag() {
        if (this.getCapPSLanguageRes() != null) {
            return this.getCapPSLanguageRes().getLanResTag();
        }
        return null;
    }

    public String getTooltipLanResTag() {
        if (this.getTooltipPSLanguageRes() != null) {
            return this.getTooltipPSLanguageRes().getLanResTag();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f", hideempty2=true, dump=false)
    public String getIconCls() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClass();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84", hideempty2=true, dump=false)
    public String getIconPath() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePath();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u6837\u5f0f\uff08X\uff09", hideempty2=true, dump=false)
    public String getIconClsX() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getCssClassX();
        }
        return null;
    }

    @PSModelRTMeta(description="\u56fe\u6807\u8def\u5f84\uff08X\uff09", hideempty2=true, dump=false)
    public String getIconPathX() {
        if (this.getPSSysImage() != null) {
            return this.getPSSysImage().getImagePathX();
        }
        return null;
    }

    public IPSSystem getPSSystem() {
        return this.iPSSystem;
    }

    protected IPSSystemUtil getPSSystemUtil() {
        return (IPSSystemUtil)((Object)this.getPSSystem());
    }

    @Override
    public String getUIActionParam() {
        return this.strUIActionParam;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u53c2\u6570\u5bf9\u8c61", hideempty2=true, fields={"UIACTIONPARAMS"})
    public JSONObject getUIActionParamJO() {
        return this.uiActionParamJO;
    }

    @Override
    @PSModelRTMeta(description="\u503c\u9879\u540d\u79f0", hideempty2=true, fields={"DATAITEM"})
    public String getValueItem() {
        return this.strValueItem;
    }

    @Override
    @PSModelRTMeta(description="\u6587\u672c\u9879\u540d\u79f0", hideempty2=true, fields={"TEXTITEM"})
    public String getTextItem() {
        return this.strTextItem;
    }

    @Override
    @PSModelRTMeta(description="\u53c2\u6570\u9879\u540d\u79f0", hideempty2=true, fields={"PARAMITEM"})
    public String getParamItem() {
        return this.strParamItem;
    }

    @PSModelRTMeta(description="\u652f\u6301\u8fd0\u884c\u65f6\u6a21\u578b", ignoredumpvalues="false", ignorert=3, fields={"ENABLERTMODEL"})
    public boolean isEnableRuntimeModel() {
        return this.bEnableRuntimeModel;
    }

    @PSModelRTMeta(description="\u5168\u5c40\u754c\u9762\u884c\u4e3a", ignoredumpvalues="false", fields={"GLOBALFLAG"})
    public boolean isGlobalUIAction() {
        return this.bGlobalUIAction;
    }

    public void setGlobalUIAction(boolean bGlobalUIAction) {
        this.bGlobalUIAction = bGlobalUIAction;
    }

    public void setEnableRuntimeModel(boolean bEnableRuntimeModel) {
        this.bEnableRuntimeModel = bEnableRuntimeModel;
    }

    @PSModelRTMeta(description="\u64cd\u4f5c\u540e\u5173\u95ed\u5f39\u51fa\u89c6\u56fe", ignoredumpvalues="false", fields={"CLOSEEDITVIEW"})
    public boolean isClosePopupView() {
        return this.bCloseEditView;
    }

    @Override
    @PSModelRTMeta(description="\u4e0b\u4e00\u6b65\u754c\u9762\u884c\u4e3a", hideempty=true, dumpref=true, rtname="getNext", fields={"NEXTPSDEUIACTIONID"})
    public IPSUIAction getNextPSUIAction() {
        if (this.nextPSUIAction != null) {
            return this.nextPSUIAction;
        }
        if (this.getPSAppDataEntity() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getNEXTPSDEUIACTIONID())) {
            try {
                this.nextPSUIAction = this.getPSAppDataEntity().getPSAppDEUIAction(this.psDEUIAction.getNEXTPSDEUIACTIONID(), false, this);
                return this.nextPSUIAction;
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        if (this.getPSDataEntity() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getNEXTPSDEUIACTIONID())) {
            try {
                this.nextPSUIAction = this.getPSDataEntity().getPSDEUIAction(this.psDEUIAction.getNEXTPSDEUIACTIONID());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        return this.nextPSUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u754c\u9762\u884c\u4e3a\u5b8c\u5168\u6807\u8bb0", dump=false)
    public String getUIActionFullTag() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strUIActionFullTag)) {
            return this.getUIActionTag();
        }
        return this.strUIActionFullTag;
    }

    @Override
    public boolean isFrontPDTView() {
        return this.bPDTFrontView;
    }

    @Override
    public String getFrontPSSysPDTViewId() {
        return this.psDEUIAction.getPSSYSPDTVIEWID();
    }

    public IPSSysPDTView getPSSysPDTView() {
        return this.iPSSysPDTView;
    }

    @Override
    public IPSAppView getFrontPSAppView(Object obj) throws Exception {
        boolean bTryMode = false;
        if (obj instanceof IPSAppViewPreview) {
            bTryMode = ((IPSAppViewPreview)obj).isDesignMode();
        } else if (obj instanceof IPSControl) {
            bTryMode = ((IPSControl)obj).isDesignMode();
        }
        if (this.isFrontPDTView()) {
            String strFrontPSSysPDTViewId = this.getFrontPSSysPDTViewId();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strFrontPSSysPDTViewId)) {
                IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(obj, false);
                IPSSysPDTView iPSSysPDTView = this.getPSSystem().getPSSysPDTView(strFrontPSSysPDTViewId);
                return PSSystemUtil.getPSAppView(iPSApplication, iPSSysPDTView, bTryMode);
            }
        } else {
            String strFrontPSAppViewId = this.psDEUIAction.getPSAPPVIEWID();
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strFrontPSAppViewId)) {
                IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(obj, false);
                return iPSApplication.getPSAppView(strFrontPSAppViewId, false);
            }
            String strFrontPSDEViewId = this.getFrontPSDEViewId(obj);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strFrontPSDEViewId)) {
                String strViewType;
                PSDEViewBase psDEViewBase;
                IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(obj, false);
                if (iPSApplication.isMobileApp() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getFrontMobPSDEViewId())) {
                    strFrontPSDEViewId = this.getFrontMobPSDEViewId();
                }
                if (this.getPSDataEntity() != null && (psDEViewBase = this.getPSDataEntity().getPSDEViewData(strFrontPSDEViewId, true)) != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)(strViewType = psDEViewBase.getPSDEVIEWBASETYPE())) && strViewType.indexOf("DE") == 0) {
                    if (strViewType.indexOf("DEMOB") == 0) {
                        if (!iPSApplication.isMobileApp()) {
                            bTryMode = true;
                        }
                    } else if (iPSApplication.isMobileApp()) {
                        bTryMode = true;
                    }
                }
                String strPSAppViewId = Helper.GenUniqueId((String)iPSApplication.getId(), (String)strFrontPSDEViewId);
                return iPSApplication.getPSAppView(strPSAppViewId, strFrontPSDEViewId, bTryMode);
            }
        }
        return null;
    }

    @Override
    public String getFrontPSDEViewId(Object obj) {
        return this.getFrontPSDEViewId();
    }

    @Override
    public String getFrontPSDEViewId() {
        if (this.isFrontPDTView() && this.getPSSysPDTView() != null) {
            return this.getPSSysPDTView().getPSDEViewBaseId();
        }
        return this.psDEUIAction.getPSDEVIEWBASEID();
    }

    @Override
    public String getFrontMobPSDEViewId() {
        if (this.isFrontPDTView() && this.getPSSysPDTView() != null) {
            return this.getPSSysPDTView().getMobPSDEViewBaseId();
        }
        return this.psDEUIAction.getMOBPSDEVIEWID();
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6a21\u677f\u903b\u8f91\u7c7b\u578b", dump=false)
    public String getPFLogicCodeType() {
        String strPluginCode = null;
        if (this.getPSSysPFPlugin() != null) {
            strPluginCode = this.getPSSysPFPlugin().getPluginCode();
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"SYS", (boolean)true) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPluginCode)) {
                return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getUIActionMode(), (Object)this.getCodeName()).toUpperCase();
            }
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s#%3$s", (Object)this.getUIActionMode(), (Object)this.getCodeName(), (Object)strPluginCode).toUpperCase();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPluginCode)) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s", (Object)this.getUIActionMode()).toUpperCase();
        }
        return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s#%2$s", (Object)this.getUIActionMode(), (Object)strPluginCode).toUpperCase();
    }

    @Override
    @PSModelRTMeta(description="\u5b8c\u5168\u4ee3\u7801\u6807\u8bc6", doc="\u5b8c\u5168\u4ee3\u7801\u6807\u8bc6\u683c\u5f0f\uff1a{\u5b9e\u4f53\u4ee3\u7801\u6807\u8bc6}_{\u754c\u9762\u884c\u4e3a\u4ee3\u7801\u6807\u8bc6}\uff0c\u89e3\u51b3\u4e0d\u540c\u5b9e\u4f53\u7684\u754c\u9762\u884c\u4e3a\u5728\u540c\u4e00\u4e2a\u5e94\u7528\u573a\u5408\u533a\u5206\u7684\u95ee\u9898")
    public String getFullCodeName() {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strFullCodeName)) {
            return this.getCodeName();
        }
        return this.strFullCodeName;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u6269\u5c55\u63d2\u4ef6")
    public IPSSysPFPlugin getPSSysPFPlugin() {
        return this.iPSSysPFPlugin;
    }

    @Override
    public IPSViewLogic getPSViewLogic(Object obj) throws Exception {
        String strPSSysViewLogicId = this.getPSSysViewLogicId();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysViewLogicId)) {
            IPSApplication iPSApplication = PSSystemUtil.getRefPSApplication(obj, false);
            return iPSApplication.getPSAppUILogic(strPSSysViewLogicId);
        }
        return null;
    }

    @Override
    public boolean hasViewLogic() {
        return !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSSysViewLogicId());
    }

    @Override
    public String getViewLogicCodeName() {
        if (this.hasViewLogic()) {
            return SA.SRFramework.Utility.StringHelper.Format((String)"%1$s_VL", (Object)this.getFullCodeName());
        }
        return null;
    }

    @Override
    public IPSPFPlugin getPSPFPlugin() {
        return this.getPSSysPFPlugin();
    }

    @Override
    @PSModelRTMeta(description="\u663e\u793a\u5904\u7406\u63d0\u793a", ignoredumpvalues="true", fields={"BUSYINDICATOR"})
    public boolean isShowBusyIndicator() {
        return this.bShowBusyIndicator;
    }

    @Override
    @PSModelRTMeta(description="\u5237\u65b0\u5f15\u7528\u89c6\u56fe\u6a21\u5f0f", codelist="UIActionReloadDataMode", ignoredumpvalues="0", fields={"RELOADDATA"})
    public int getRefreshMode() {
        return this.nRefreshMode;
    }

    @Override
    public void setNextPSUIAction(IPSUIAction iPSUIAction) {
        this.nextPSUIAction = iPSUIAction;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528\u89c6\u56fe", hideempty=true, dumpref=true, from="IPSApplication", doc="\u6839\u636e{@link #isFrontPDTView}\u4f18\u5148\u5904\u7406\u9884\u7f6e\u89c6\u56fe\uff0c\u5426\u5219\u6309\u5e94\u7528\u7c7b\u578b\u8ba1\u7b97\u5bf9\u5e94\u7684\u5b9e\u4f53\u89c6\u56fe", fields={"PSDEVIEWBASEID", "MOBPSDEVIEWID", "PSSYSPDTVIEWID"})
    public IPSAppView getFrontPSAppView() throws Exception {
        if (this.frontPSAppView == null && this.getPSApplication() != null) {
            this.frontPSAppView = this.getFrontPSAppView(this.getPSApplication());
        }
        return this.frontPSAppView;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u65b9\u6cd5", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEACTIONID"})
    public IPSAppDEMethod getPSAppDEMethod() {
        return this.iPSAppDEMethod;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528", hideempty=true, outputdoc="false")
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u9884\u7f6e\u754c\u9762\u903b\u8f91", hideempty=true, dumpref=true, from="IPSApplication", fields={"PSSYSVIEWLOGICID"})
    public IPSAppUILogic getPSAppUILogic() throws Exception {
        if (this.getPSApplication() == null) {
            return null;
        }
        String strPSSysViewLogicId = this.getPSSysViewLogicId();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSSysViewLogicId)) {
            return this.getPSApplication().getPSAppUILogic(strPSSysViewLogicId);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u754c\u9762\u903b\u8f91", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEVIEWLOGICID"})
    public IPSAppDEUILogic getPSAppDEUILogic() throws Exception {
        if (this.getPSApplication() == null || this.getPSAppDataEntity() == null) {
            return null;
        }
        String strPSDEUILogicId = this.getPSDEUILogicId();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDEUILogicId)) {
            return this.getPSAppDataEntity().getPSAppDEUILogic(strPSDEUILogicId);
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7ec4", hideempty=true, ignoredumpvalues="false")
    public boolean isGroup() throws Exception {
        return this.isUIActionGroup(null);
    }

    @Override
    @PSModelRTMeta(description="\u5148\u4fdd\u5b58\u76ee\u6807\u6570\u636e", ignoredumpvalues="false")
    public boolean isSaveTargetFirst() {
        return this.bSaveTargetFirst;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u9644\u52a0\u53c2\u6570Json\u5b57\u7b26\u4e32", dump=false)
    public String getParamJOString() {
        if (this.getUIActionParamJO() != null) {
            return this.getUIActionParamJO().toString();
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u9644\u52a0\u4e0a\u4e0b\u6587Json\u5b57\u7b26\u4e32")
    public String getContextJOString() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u8ba1\u6570\u9879\u6807\u8bc6", hideempty2=true, fields={"COUNTERID"})
    public String getCounterId() {
        return this.strCounterId;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u8ba1\u6570\u5668", hideempty=true, dumpref=true, from="IPSApplication", ignorepf=true, fields={"PSSYSCOUNTERID"})
    public IPSAppCounter getPSAppCounter() throws Exception {
        if (this.iPSAppCounter == null && this.getPSApplication() != null && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSSYSCOUNTERID())) {
            this.iPSAppCounter = this.getPSApplication().getPSAppCounter(this.psDEUIAction.getPSSYSCOUNTERID());
        }
        return this.iPSAppCounter;
    }

    @Override
    public String getCounterParamJOString() {
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u7ed8\u5236\u63d2\u4ef6")
    public IPSPFXCodeObject getRender() {
        return this.iPSPFXCodeObject;
    }

    protected boolean isEnableViewActions() {
        return this.bEnableViewActions;
    }

    protected long getViewActions() {
        return this.nViewActions;
    }

    @Override
    public String getReplacePSSysUIActionId() {
        return this.strReplacePSSysUIActionId;
    }

    protected boolean testNewData(Object obj, boolean bDefault) throws Exception {
        if (obj != null) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSAppView iPSAppView;
            IPSControlXDataContainer iPSControlXDataContainer = this.getPSControlXDataContainer(obj);
            if (iPSControlXDataContainer != null) {
                return iPSControlXDataContainer.isEnableNewData();
            }
            if (obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEXDataView) {
                IPSAppDEXDataView iPSAppDEXDataView = (IPSAppDEXDataView)iPSAppView;
                return iPSAppDEXDataView.isEnableNewData();
            }
        }
        return bDefault;
    }

    protected boolean testCopyData(Object obj, boolean bDefault) throws Exception {
        if (obj != null) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSAppView iPSAppView;
            IPSControlXDataContainer iPSControlXDataContainer = this.getPSControlXDataContainer(obj);
            if (iPSControlXDataContainer != null) {
                return iPSControlXDataContainer.isEnableCopy();
            }
            if (obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEXDataView) {
                IPSAppDEXDataView iPSAppDEXDataView = (IPSAppDEXDataView)iPSAppView;
                return iPSAppDEXDataView.isEnableCopy();
            }
        }
        return bDefault;
    }

    protected boolean testEditData(Object obj, boolean bDefault) throws Exception {
        if (obj != null) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSAppView iPSAppView;
            IPSControlXDataContainer iPSControlXDataContainer = this.getPSControlXDataContainer(obj);
            if (iPSControlXDataContainer != null) {
                return iPSControlXDataContainer.isEnableEditData();
            }
            if (obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEXDataView) {
                IPSAppDEXDataView iPSAppDEXDataView = (IPSAppDEXDataView)iPSAppView;
                return iPSAppDEXDataView.isEnableEditData();
            }
        }
        return bDefault;
    }

    protected boolean testExportData(Object obj, boolean bDefault) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEMultiDataView) {
            IPSAppDEMultiDataView iPSAppDEMultiDataView = (IPSAppDEMultiDataView)iPSAppView;
            return iPSAppDEMultiDataView.isEnableExport();
        }
        return bDefault;
    }

    protected boolean testFilter(Object obj, boolean bDefault) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEMultiDataView) {
            IPSAppDEMultiDataView iPSAppDEMultiDataView = (IPSAppDEMultiDataView)iPSAppView;
            return iPSAppDEMultiDataView.isEnableFilter();
        }
        return bDefault;
    }

    protected boolean testHelp(Object obj, boolean bDefault) throws Exception {
        if (obj != null && obj instanceof IPSDETBUIActionItem) {
            IPSDETBUIActionItem iPSDETBUIActionItem = (IPSDETBUIActionItem)obj;
            IPSAppView iPSAppView = iPSDETBUIActionItem.getPSAppView();
            return iPSAppView.isEnableHelp();
        }
        return bDefault;
    }

    protected boolean testImportData(Object obj, boolean bDefault) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEMultiDataView) {
            IPSAppDEMultiDataView iPSAppDEMultiDataView = (IPSAppDEMultiDataView)iPSAppView;
            return iPSAppDEMultiDataView.isEnableImport();
        }
        return bDefault;
    }

    protected boolean testNewRow(Object obj, boolean bDefault) throws Exception {
        if (obj != null && obj instanceof IPSDETBUIActionItem) {
            IPSDETBUIActionItem iPSDETBUIActionItem = (IPSDETBUIActionItem)obj;
            IPSAppView iPSAppView = iPSDETBUIActionItem.getPSAppView();
            if (iPSAppView instanceof IPSAppDEGridView) {
                IPSAppDEGridView iPSAppDEXDataView = (IPSAppDEGridView)iPSAppView;
                return iPSAppDEXDataView.isEnableRowEdit();
            }
            if (iPSAppView instanceof IPSAppDETreeGridView) {
                IPSAppDETreeGridView iPSAppDEXDataView = (IPSAppDETreeGridView)iPSAppView;
                return iPSAppDEXDataView.isEnableRowEdit();
            }
        }
        return bDefault;
    }

    protected boolean testPrintData(Object obj, boolean bDefault) throws Exception {
        if (obj != null) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSAppView iPSAppView;
            IPSControlXDataContainer iPSControlXDataContainer = this.getPSControlXDataContainer(obj);
            if (iPSControlXDataContainer != null) {
                return iPSControlXDataContainer.isEnablePrint();
            }
            if (obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEXDataView) {
                IPSAppDEXDataView iPSAppDEXDataView = (IPSAppDEXDataView)iPSAppView;
                return iPSAppDEXDataView.isEnablePrint();
            }
        }
        return bDefault;
    }

    protected boolean testRemoveData(Object obj, boolean bDefault) throws Exception {
        if (obj != null) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSAppView iPSAppView;
            IPSControlXDataContainer iPSControlXDataContainer = this.getPSControlXDataContainer(obj);
            if (iPSControlXDataContainer != null) {
                return iPSControlXDataContainer.isEnableRemoveData();
            }
            if (obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEXDataView) {
                IPSAppDEXDataView iPSAppDEXDataView = (IPSAppDEXDataView)iPSAppView;
                return iPSAppDEXDataView.isEnableRemoveData();
            }
        }
        return bDefault;
    }

    protected boolean testRowEdit(Object obj, boolean bDefault) throws Exception {
        if (obj != null && obj instanceof IPSDETBUIActionItem) {
            IPSDETBUIActionItem iPSDETBUIActionItem = (IPSDETBUIActionItem)obj;
            IPSAppView iPSAppView = iPSDETBUIActionItem.getPSAppView();
            if (iPSAppView instanceof IPSAppDEGridView) {
                IPSAppDEGridView iPSAppDEXDataView = (IPSAppDEGridView)iPSAppView;
                return iPSAppDEXDataView.isEnableRowEdit();
            }
            if (iPSAppView instanceof IPSAppDETreeGridView) {
                IPSAppDETreeGridView iPSAppDEXDataView = (IPSAppDETreeGridView)iPSAppView;
                return iPSAppDEXDataView.isEnableRowEdit();
            }
        }
        return bDefault;
    }

    protected boolean testSaveAndNewData(Object obj, boolean bDefault) throws Exception {
        if (obj != null) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSAppView iPSAppView;
            IPSControlXDataContainer iPSControlXDataContainer = this.getPSControlXDataContainer(obj);
            if (iPSControlXDataContainer != null) {
                return iPSControlXDataContainer.isEnableNewData() && iPSControlXDataContainer.isEnableEditData();
            }
            if (obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEXDataView) {
                IPSAppDEXDataView iPSAppDEXDataView = (IPSAppDEXDataView)iPSAppView;
                return iPSAppDEXDataView.isEnableNewData() && iPSAppDEXDataView.isEnableEditData();
            }
        }
        return bDefault;
    }

    protected boolean testSaveData(Object obj, boolean bDefault) throws Exception {
        if (obj != null) {
            IPSDETBUIActionItem iPSDETBUIActionItem;
            IPSAppView iPSAppView;
            IPSControlXDataContainer iPSControlXDataContainer = this.getPSControlXDataContainer(obj);
            if (iPSControlXDataContainer != null) {
                return iPSControlXDataContainer.isEnableEditData();
            }
            if (obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEXDataView) {
                IPSAppDEXDataView iPSAppDEXDataView = (IPSAppDEXDataView)iPSAppView;
                return iPSAppDEXDataView.isEnableEditData();
            }
        }
        return bDefault;
    }

    protected boolean testSaveRow(Object obj, boolean bDefault) throws Exception {
        if (obj != null && obj instanceof IPSDETBUIActionItem) {
            IPSDETBUIActionItem iPSDETBUIActionItem = (IPSDETBUIActionItem)obj;
            IPSAppView iPSAppView = iPSDETBUIActionItem.getPSAppView();
            if (iPSAppView instanceof IPSAppDEGridView) {
                IPSAppDEGridView iPSAppDEXDataView = (IPSAppDEGridView)iPSAppView;
                return iPSAppDEXDataView.isEnableRowEdit();
            }
            if (iPSAppView instanceof IPSAppDETreeGridView) {
                IPSAppDETreeGridView iPSAppDEXDataView = (IPSAppDETreeGridView)iPSAppView;
                return iPSAppDEXDataView.isEnableRowEdit();
            }
        }
        return bDefault;
    }

    protected boolean testStartWF(Object obj, boolean bDefault) throws Exception {
        if (obj != null && obj instanceof IPSDETBUIActionItem) {
            IPSDETBUIActionItem iPSDETBUIActionItem = (IPSDETBUIActionItem)obj;
            IPSAppView iPSAppView = iPSDETBUIActionItem.getPSAppView();
            if (iPSAppView instanceof IPSAppDEXDataView) {
                return ((IPSAppDEXDataView)iPSAppView).isEnableStartWF();
            }
            if (iPSAppView instanceof IPSAppDEView && ((IPSAppDEView)iPSAppView).isEnableWF() && iPSAppView instanceof IPSAppDEWFActionView) {
                return !((IPSAppDEWFActionView)iPSAppView).isWFIAMode();
            }
        }
        return bDefault;
    }

    protected boolean testViewData(Object obj, boolean bDefault) throws Exception {
        IPSDETBUIActionItem iPSDETBUIActionItem;
        IPSAppView iPSAppView;
        if (obj != null && obj instanceof IPSDETBUIActionItem && (iPSAppView = (iPSDETBUIActionItem = (IPSDETBUIActionItem)obj).getPSAppView()) instanceof IPSAppDEMultiDataView) {
            IPSAppDEMultiDataView iPSAppDEMultiDataView = (IPSAppDEMultiDataView)iPSAppView;
            return !iPSAppDEMultiDataView.isEnableEditData() && iPSAppDEMultiDataView.isEnableViewData();
        }
        return bDefault;
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u53c2\u6570\u96c6\u5408", child=true, group="\u903b\u8f91", order=216)
    public Iterator<? extends IPSNavigateParam> getPSNavigateParams() throws Exception {
        if (this.psNavigateParamMap == null || this.psNavigateParamMap.size() == 0) {
            return null;
        }
        return this.psNavigateParamMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u5bfc\u822a\u4e0a\u4e0b\u6587\u96c6\u5408", child=true, group="\u903b\u8f91", order=215)
    public Iterator<? extends IPSNavigateContext> getPSNavigateContexts() throws Exception {
        if (this.psNavigateContextMap == null || this.psNavigateContextMap.size() == 0) {
            return null;
        }
        return this.psNavigateContextMap.values().iterator();
    }

    @Override
    @PSModelRTMeta(description="\u542f\u7528\u7528\u6237\u64cd\u4f5c\u786e\u8ba4", ignoredumpvalues="false", fields={"USERCONFIRM"})
    public boolean isEnableConfirm() {
        return this.bEnableConfirm;
    }

    @Override
    public String getModelRefId() {
        return this.getUIActionFullTag();
    }

    @Override
    @PSModelRTMeta(description="\u884c\u4e3a\u7ea7\u522b", codelist="UIActionLevel", ignoredumpvalues="100", fields={"ACTIONLEVEL"})
    public int getActionLevel() {
        return this.nActionLevel;
    }

    @Override
    @PSModelRTMeta(description="\u6309\u94ae\u6837\u5f0f", codelist="ButtonStyle", ignoredumpvalues="100", fields={"BUTTONSTYLE"})
    public String getButtonStyle() {
        return this.strButtonStyle;
    }

    @Override
    protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
        if (this.getPSAppDataEntity() != null) {
            objectNode.put("getPSAppDataEntity", (JsonNode)this.getPSAppDataEntity().getModelRef());
        }
        super.onFillModelRefNode(objectNode, strModelRefType);
        objectNode.remove("getPSDEOPPriv");
    }

    @Override
    @PSModelRTMeta(description="\u5f39\u7a97\u5173\u95ed\u7ed3\u679c", codelist="UIActionDialogResult", fields={"CLOSEEDITVIEW"})
    public String getDialogResult() {
        if (this.isClosePopupView()) {
            switch (this.nCloseWindowMode) {
                case 1: {
                    return "OK";
                }
                case 2: {
                    return "CANCEL";
                }
            }
            return "OK";
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u76f8\u5173\u5b9e\u4f53\u64cd\u4f5c\u6807\u8bc6", hideempty=true, fields={"PSDEOPPRIVID"})
    public IPSDEOPPriv getPSDEOPPriv() {
        return this.iPSDEOPPriv;
    }

    @Override
    protected IPSModelObject onGetParentModel() {
        if (this.getPSAppDataEntity() != null) {
            return this.getPSAppDataEntity();
        }
        if (this.getPSApplication() != null) {
            return this.getPSApplication();
        }
        if (this.getPSDataEntity() != null) {
            return this.getPSDataEntity();
        }
        return super.onGetParentModel();
    }

    @Override
    @PSModelRTMeta(description="\u9884\u7f6e\u884c\u4e3a\u7c7b\u578b", hideempty2=true, fields={"PSSYSUIACTIONID"})
    public String getPredefinedType() {
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"SYS", (boolean)false) != 0) {
            return null;
        }
        try {
            String strPredefinedType = this.getPSSysDEUIActionId(null);
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPredefinedType)) {
                return strPredefinedType;
            }
        }
        catch (Exception e) {
            log.error((Object)e);
            return null;
        }
        return null;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6253\u5370", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEPRINTID"})
    public IPSAppDEPrint getPSAppDEPrint() throws Exception {
        if (this.getPSAppDataEntity() == null) {
            return null;
        }
        if (this.iPSAppDEPrint != null) {
            return this.iPSAppDEPrint;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getFrontProcessType(), (String)"PRINT", (boolean)false) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSDEPRINTID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u6253\u5370\u5bf9\u8c61");
            }
            this.iPSAppDEPrint = this.getPSAppDataEntity().getPSAppDEPrint(this.psDEUIAction.getPSDEPRINTID());
        }
        return this.iPSAppDEPrint;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u5165", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEDATAIMPID"})
    public IPSAppDEDataImport getPSAppDEDataImport() throws Exception {
        if (this.getPSAppDataEntity() == null) {
            return null;
        }
        if (this.iPSAppDEDataImport != null) {
            return this.iPSAppDEDataImport;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getFrontProcessType(), (String)"DATAIMP", (boolean)false) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSDEDATAIMPID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u5165\u5bf9\u8c61");
            }
            this.iPSAppDEDataImport = this.getPSAppDataEntity().getPSAppDEDataImport(this.psDEUIAction.getPSDEDATAIMPID());
        }
        return this.iPSAppDEDataImport;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"NO2PSDEDATAEXPID"})
    public IPSAppDEDataExport getPSAppDEDataExport() throws Exception {
        if (this.getPSAppDataEntity() == null) {
            return null;
        }
        if (this.iPSAppDEDataExport != null) {
            return this.iPSAppDEDataExport;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getFrontProcessType(), (String)"DATAEXP", (boolean)false) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getNO2PSDEDATAEXPID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u5bf9\u8c61");
            }
            this.iPSAppDEDataExport = this.getPSAppDataEntity().getPSAppDEDataExport(this.psDEUIAction.getNO2PSDEDATAEXPID());
        }
        return this.iPSAppDEDataExport;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5b9e\u4f53\u81ea\u586b\u6a21\u5f0f", hideempty=true, dumpref=true, from="IPSAppDataEntity", fields={"PSDEACMODEID"})
    public IPSAppDEACMode getPSAppDEACMode() throws Exception {
        if (this.getPSAppDataEntity() == null) {
            return null;
        }
        if (this.iPSAppDEACMode != null) {
            return this.iPSAppDEACMode;
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getFrontProcessType(), (String)"CHAT", (boolean)false) == 0) {
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDEUIAction.getPSDEACMODEID())) {
                throw new Exception("\u672a\u6307\u5b9a\u5b9e\u4f53\u81ea\u586b\u5bf9\u8c61");
            }
            this.iPSAppDEACMode = this.getPSAppDataEntity().getPSAppDEACMode(this.psDEUIAction.getPSDEACMODEID());
        }
        return this.iPSAppDEACMode;
    }

    @Override
    @PSModelRTMeta(description="\u811a\u672c\u4ee3\u7801", hideempty2=true, fields={"CUSTOMCODE"})
    public String getScriptCode() {
        return this.strScriptCode;
    }

    @Override
    public String getPSDEEditFormId() {
        return this.strPSDEEditFormId;
    }

    @Override
    public String getMobPSDEEditFormId() {
        return this.strMobPSDEEditFormId;
    }

    @Override
    @PSModelRTMeta(description="\u7f16\u8f91\u8868\u5355", child=true, fields={"PSDEFORMID"})
    public IPSDEEditForm getPSDEEditForm() throws Exception {
        if (this.getPSApplication() == null) {
            return null;
        }
        if (this.iPSDEEditForm != null) {
            return this.iPSDEEditForm;
        }
        if (!this.getPSApplication().isMobileApp() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDEEditFormId()) || this.getPSApplication().isMobileApp() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getMobPSDEEditFormId())) {
            PSAppView psAppView = new PSAppView();
            psAppView.setPSAPPVIEWID(String.valueOf(this.getPSApplication().getId()) + "__APPDEUIACTION__" + this.getFullCodeName());
            psAppView.setPSAPPVIEWNAME(this.getCodeName());
            PSDEViewCtrl psDEViewCtrl = new PSDEViewCtrl();
            psDEViewCtrl.setPSDEVIEWCTRLNAME("form");
            psDEViewCtrl.setPSDEVIEWCTRLTYPE("FORM");
            psDEViewCtrl.setPSDEFORMID(this.getPSApplication().isMobileApp() ? this.getMobPSDEEditFormId() : this.getPSDEEditFormId());
            psDEViewCtrl.setPSDEFORMNAME(this.getPSApplication().isMobileApp() ? this.psDEUIAction.getMOBPSDEFORMNAME() : this.psDEUIAction.getPSDEFORMNAME());
            PSAppDEFormPreviewViewImpl psAppDEFormPreviewViewImpl = new PSAppDEFormPreviewViewImpl();
            psAppDEFormPreviewViewImpl.setPSViewType(this.getPSModelStorage().getPSViewType(this.getPSApplication().isMobileApp() ? "DEMOBEDITVIEW" : "DEEDITVIEW"));
            psAppDEFormPreviewViewImpl.setV2Preview(true);
            psAppDEFormPreviewViewImpl.setDesignMode(false);
            psAppDEFormPreviewViewImpl.init(this.getDAGlobalHelper(), this.getPSApplication(), psAppView, this.getPSDataEntity(), psDEViewCtrl);
            this.iPSDEEditForm = (IPSDEEditForm)psAppDEFormPreviewViewImpl.getPSControl("form");
        }
        return this.iPSDEEditForm;
    }

    @Override
    public int getOrderValue() {
        return 99999;
    }

    @Override
    @PSModelRTMeta(description="\u5f02\u6b65\u64cd\u4f5c\u884c\u4e3a", ignoredumpvalues="false")
    public boolean isAsyncAction() {
        if (this.getPSDEAction() != null) {
            return this.getPSDEAction().isAsyncAction();
        }
        return false;
    }

    @Override
    protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
        super.onFillModelNode(objectNode, strModelType);
        if (this.isGroup()) {
            objectNode.remove("timeout");
        } else if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"FRONT", (boolean)true) == 0 || SA.SRFramework.Utility.StringHelper.Compare((String)this.getUIActionMode(), (String)"WFFRONT", (boolean)true) == 0) {
            objectNode.remove("timeout");
        }
    }
}

