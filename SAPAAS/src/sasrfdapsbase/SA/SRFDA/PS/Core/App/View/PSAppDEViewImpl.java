package SA.SRFDA.PS.Core.App.View;

import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounterRef;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDERS;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroup;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogicGroupDetail;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.App.WF.IPSAppWFVer;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.Control.IPSControlParam;
import SA.SRFDA.PS.Core.Control.IPSControlType;
import SA.SRFDA.PS.Core.Control.Ajax.IPSAjaxHandler;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounter;
import SA.SRFDA.PS.Core.Control.Counter.IPSSysCounterRef;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDER1N;
import SA.SRFDA.PS.Core.DataEntity.MainState.IPSDEMainState;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.DataEntity.Wizard.IPSDEActionWizardGroup;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.Res.IPSSubViewType;
import SA.SRFDA.PS.Core.Security.IPSSysUniRes;
import SA.SRFDA.PS.Core.View.IPSUIEngineType;
import SA.SRFDA.PS.Core.View.IPSViewEngine;
import SA.SRFDA.PS.Core.View.IPSViewMsgGroup;
import SA.SRFDA.PS.Core.View.IPSViewType;
import SA.SRFDA.PS.Core.WF.IPSWFInteractiveProcess;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Data.PSACHandler;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSAppViewRef;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDEViewCtrl;
import SA.SRFDA.PS.Data.PSDEViewEngine;
import SA.SRFDA.PS.Data.PSDEViewLogic;
import SA.SRFDA.PS.Data.PSDEViewView;
import SA.SRFDA.PS.Data.PSSysIssue;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.UtilityEx.ObjectHelper;
import SA.SRFramework.UtilityEx.PropertiesHelper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.security.AccessUserModes;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.view.IViewWizardGroup;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSAppDEViewImpl extends PSAppViewImpl implements IPSAppDEView, IPSAppDEWFView, IPSAppDEWFActionView {
   private static final Log log = LogFactory.getLog(PSAppDEViewImpl.class);
   protected static final String PSDEVIEWCTRL_ORIGINNAME = "ORIGINNAME";
   protected String strPSDEViewId = "";
   protected String strPSDEViewName = "";
   protected IPSViewType iPSViewType = null;
   protected PSDEViewBase psViewBase = new PSDEViewBase();
   protected PSDEViewBase psViewBaseTempl = null;
   private IPSDataEntity iPSDataEntity = null;
   private boolean bEnableDP = true;
   protected String strPSAjaxControlId = "";
   private int nTempMode = 0;
   private boolean bWFIAMode = false;
   private String strWFStepValue = "";
   private String strWFUtilType = "";
   private IPSDEWF iPSWFDE = null;
   private IPSWFVersion iPSWFVersion = null;
   private IPSAppWF iPSAppWF = null;
   private IPSAppWFVer iPSAppWFVer = null;
   private boolean bEnableViewActions = false;
   private long nViewActions = 0L;
   private String strSubCaption = "";
   private Properties viewParamProperties = null;
   private IPSDEMainState iPSDEMainState = null;
   private int nAccUserMode = AccessUserModes.LOGINUSER;
   private IPSSysUniRes iPSSysUniRes = null;
   private IPSViewMsgGroup iPSViewMsgGroup = null;
   private IPSDEActionWizardGroup iPSDEActionWizardGroup = null;
   private IPSLanguageRes titlePSLanguageRes = null;
   private IPSLanguageRes capPSLanguageRes = null;
   private IPSLanguageRes subCapPSLanguageRes = null;
   private String strPSHelpModuleId = null;
   private Boolean bShowCaptionBar = null;
   private Boolean bDynamicView = null;
   private Integer nPriority = null;
   private IPSAjaxHandler iPSAjaxHandler = null;
   private IPSDER1N iPSDER1N = null;
   private Map<Integer, ArrayList<IPSAppDERS>> psAppDERSPathMap = null;
   private String[] SYNCFIELDS = new String[]{"MEMO", "USERCAT", "USERTAG", "USERTAG2", "USERTAG3", "USERTAG4"};
   private IPSAppCounter iPSAppCounter = null;
   private IPSSysCounterRef iPSSysCounterRef = null;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSApplication iPSApplication, PSAppView psApplicationView) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.setPSApplication(iPSApplication);
         this.setPSDEViewId(psApplicationView.getPSDEVIEWBASEID());
         this.setPSDEViewName(psApplicationView.getPSDEVIEWBASENAME());
         CallResult callResult = this.getPSModelHelper().getPSDEViewBase(this.getPSDEViewId(), this.psViewBase);
         if (callResult.isError()) {
            throw new Exception(StringHelper.Format("获取实体视图发生错误，%1$s", callResult.getErrorInfo()));
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getTEMPLPSDEVIEWID())) {
            this.psViewBaseTempl = new PSDEViewBase();
            callResult = this.getPSModelHelper().getPSDEViewBase(this.psViewBase.getTEMPLPSDEVIEWID(), this.psViewBaseTempl);
            if (callResult.isError()) {
               throw new Exception(StringHelper.Format("获取实体视图模版发生错误，%1$s", callResult.getErrorInfo()));
            }
         }

         this.strPSHelpModuleId = this.psViewBase.getPSHELPMODULEID();
         if (StringHelper.IsNullOrEmpty(psApplicationView.getPSSYSDYNAMODELID())) {
            psApplicationView.setPSSYSDYNAMODELID(this.psViewBase.getPSSYSDYNAMODELID());
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSDEID())) {
            this.setPSDataEntity(iPSApplication.getPSSystem().getPSDataEntity2(this.psViewBase.getPSDEID()));
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSDERID())) {
            this.iPSDER1N = this.getPSApplication().getPSSystem().getPSDER1N(this.psViewBase.getPSDERID());
         }

         if (this.getPSDataEntity() != null) {
            if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSDEMAINSTATEID())) {
               this.iPSDEMainState = this.getPSDataEntity().getPSDEMainState(this.psViewBase.getPSDEMAINSTATEID());
            }

            if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSDEAWGROUPID())) {
               this.iPSDEActionWizardGroup = this.getPSDataEntity().getPSDEActionWizardGroup(this.psViewBase.getPSDEAWGROUPID());
            }

            if (StringHelper.IsNullOrEmpty(this.strPSHelpModuleId)) {
               this.strPSHelpModuleId = this.getPSDataEntity().getPSHelpModuleId();
            }
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSVIEWMSGGROUPID())) {
            this.iPSViewMsgGroup = this.getPSApplication().getPSAppViewMsgGroup(this.psViewBase.getPSVIEWMSGGROUPID());
         }

         if (!this.psViewBase.isTEMPMODENull()) {
            this.nTempMode = this.psViewBase.getTEMPMODE();
         }

         if (!this.psViewBase.isENABLEVIEWACTIONSNull()) {
            this.bEnableViewActions = this.psViewBase.getENABLEVIEWACTIONS();
            if (this.bEnableViewActions) {
               this.nViewActions = this.psViewBase.getVIEWACTIONS();
            }
         } else if (this.iPSDEMainState != null && this.iPSDEMainState.isEnableViewActions()) {
            this.bEnableViewActions = true;
            this.nViewActions = this.iPSDEMainState.getViewActions();
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getSUBCAPTION())) {
            this.strSubCaption = this.psViewBase.getSUBCAPTION();
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getACCUSERMODE())) {
            this.nAccUserMode = Integer.parseInt(this.psViewBase.getACCUSERMODE());
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSSYSUNIRESID())) {
            this.iPSSysUniRes = this.getPSApplication().getPSSystem().getPSSysUniRes(this.psViewBase.getPSSYSUNIRESID());
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getTITLEPSLANRESID())) {
            this.titlePSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psViewBase.getTITLEPSLANRESID());
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getCAPPSLANRESID())) {
            this.capPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psViewBase.getCAPPSLANRESID());
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getSUBCAPPSLANRESID())) {
            this.subCapPSLanguageRes = this.getPSApplication().getPSLanguageRes(this.psViewBase.getSUBCAPPSLANRESID());
         }

         if (!this.psViewBase.isSHOWCAPTIONBARNull()) {
            this.bShowCaptionBar = this.psViewBase.getSHOWCAPTIONBAR();
         }

         if (StringHelper.IsNullOrEmpty(psApplicationView.getPSSYSIMAGEID()) && !StringHelper.IsNullOrEmpty(this.psViewBase.getPSSYSIMAGEID())) {
            psApplicationView.setPSSYSIMAGEID(this.psViewBase.getPSSYSIMAGEID());
         }

         if (StringHelper.IsNullOrEmpty(psApplicationView.getPSSYSCSSID()) && !StringHelper.IsNullOrEmpty(this.psViewBase.getPSSYSCSSID())) {
            psApplicationView.setPSSYSCSSID(this.psViewBase.getPSSYSCSSID());
         }

         String[] var8 = this.SYNCFIELDS;
         int var7 = this.SYNCFIELDS.length;

         for (int var14 = 0; var14 < var7; var14++) {
            String strSyncField = var8[var14];
            String strValue = psApplicationView.getParamStringValue(strSyncField, null);
            if (StringHelper.IsNullOrEmpty(strValue)) {
               strValue = this.psViewBase.getParamStringValue(strSyncField, null);
               if (!StringHelper.IsNullOrEmpty(strValue)) {
                  psApplicationView.set(strSyncField, strValue);
               }
            }
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSSYSCOUNTERID())) {
            this.iPSAppCounter = this.getPSApplication().getPSAppCounter(this.psViewBase.getPSSYSCOUNTERID(), false);
            JSONObject refModeObj = new JSONObject();
            this.iPSSysCounterRef = this.registerPSAppCounter(this.iPSAppCounter, refModeObj);
         }

         if (!this.psViewBase.isDYNCMODENull() && this.psViewBase.getDYNCMODE() >= 10) {
            this.nPriority = this.psViewBase.getDYNCMODE();
         }

         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSACHANDLERID())) {
            this.iPSAjaxHandler = this.createPSAjaxHandler(this.psViewBase.getPSACHANDLERID());
         }

         this.viewParamProperties = PropertiesHelper.Load(null, this.psViewBase.getVIEWPARAMS());
         this.onPrepareWFInfo();
         super.init(iDAGlobalHelper, iPSApplication, psApplicationView);
      } catch (Exception ex) {
         this.throwCriticalInitException(ex);
         String strLogName = net.ibizsys.paas.util.StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = net.ibizsys.paas.util.StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(net.ibizsys.paas.util.StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
         if (this.getPSSystemUtil() != null) {
            this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
         }

         this.throwInitException(ex, true);
      }
   }

   @Override
   protected void onInit() throws Exception {
      if (!this.psViewBase.isUPDATEDATENull()
         && (this.psApplicationView.isUPDATEDATENull() || this.psApplicationView.getUPDATEDATE().getTime() < this.psViewBase.getUPDATEDATE().getTime())) {
         String strLastModifyTime = DateHelper.toDateTimeString(this.psViewBase.getUPDATEDATE());
         this.setLastModifyTimeStr(strLastModifyTime);
      }

      if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSSYSPFPLUGINID())) {
         this.setPSSysPFPlugin(this.getPSApplication().getPSSysPFPlugin(this.psViewBase.getPSSYSPFPLUGINID(), "APPVIEW", this.getViewType(), null));
      }

      if (this.getPSSubViewType() == null && !StringHelper.IsNullOrEmpty(this.psViewBase.getPSSUBVIEWTYPEID())) {
         IPSSubViewType iPSSubViewType = this.getPSApplication().getPSSubViewType(this.psViewBase.getPSSUBVIEWTYPEID(), this.getViewType());
         this.setPSSubViewType(iPSSubViewType);
         if (StringHelper.IsNullOrEmpty(this.psViewBase.getPSSYSPFPLUGINID()) && iPSSubViewType.getPSSysPFPlugin() != null) {
            this.setPSSysPFPlugin(this.getPSApplication().getPSSysPFPlugin(iPSSubViewType.getPSSysPFPlugin().getId(), "APPVIEW", this.getViewType(), null));
         }
      }

      if (this.getPSAppDataEntity() == null && this.getPSDataEntity() != null) {
         this.setPSAppDataEntity(this.getPSApplication().getPSAppDataEntityByDEId(this.getPSDataEntity().getId(), true));
      }

      IPSAppDEViewPlugin iPSAppDEViewPlugin = this.getPSAppDEViewPlugin();
      if (iPSAppDEViewPlugin == null || !iPSAppDEViewPlugin.preparePSDEViewCtrls(this)) {
         this.onPreparePSDEViewCtrls();
      }

      super.onInit();
      if (this.getPSDER1N() != null && this.getPSAppDataEntity() != null) {
         int nRSCount = this.getPSAppDataEntity().getPSAppDERSPathCount();
         if (nRSCount > 0) {
            Map<Integer, ArrayList<IPSAppDERS>> psAppDERSPathMap = new LinkedHashMap<>();

            for (int i = 0; i < nRSCount; i++) {
               IPSAppDERS iPSAppDERS = this.getPSAppDataEntity().getPSAppDERSPathLast(i);
               if (iPSAppDERS != null
                  && iPSAppDERS.getPSDER1N() != null
                  && StringHelper.Compare(iPSAppDERS.getPSDER1N().getId(), this.getPSDER1N().getId(), false) == 0) {
                  Iterator<? extends IPSAppDERS> psAppDERSs = this.getPSAppDataEntity().getPSAppDERSPath(i);
                  if (psAppDERSs != null) {
                     ArrayList<IPSAppDERS> list = new ArrayList<>();

                     while (psAppDERSs.hasNext()) {
                        list.add(psAppDERSs.next());
                     }

                     psAppDERSPathMap.put(psAppDERSPathMap.size(), list);
                  }
               }
            }

            if (nRSCount != psAppDERSPathMap.size()) {
               this.psAppDERSPathMap = psAppDERSPathMap;
            }
         }
      }

      if (iPSAppDEViewPlugin == null || !iPSAppDEViewPlugin.preparePSDEViewLogics(this)) {
         this.onPreparePSDEViewLogics();
      }

      this.onPreparePSDEViewEngines();
   }

   @Override
   protected IPSAjaxHandler createPSAjaxHandler(String strPSAjaxHandlerId) throws Exception {
      PSACHandler psACHandler = null;
      if (this.getPSDataEntity() == null) {
         psACHandler = this.getPSSystem().getPSAjaxControlHandlerData(strPSAjaxHandlerId, false);
      } else {
         psACHandler = this.getPSDataEntity().getPSAjaxControlHandlerData(strPSAjaxHandlerId);
      }

      IPSAjaxHandler iPSAjaxHandler = new PSViewAjaxHandlerImpl();
      iPSAjaxHandler.init(this.getDAGlobalHelper(), this, psACHandler);
      return iPSAjaxHandler;
   }

   protected BaseDataEntity createRealViewDataEntity() {
      return new PSDEViewBase();
   }

   protected BaseDataEntity createRealViewTemplDataEntity() {
      return new PSDEViewBase();
   }

   protected void onPreparePSDEViewCtrls() throws Exception {
      Vector<PSDEViewCtrl> psDEViewCtrlList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDEViewCtrls(this.getPSDEViewId(), psDEViewCtrlList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询视图关联部件集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      HashMap<String, PSDEViewCtrl> psDEViewCtrlMap = new HashMap<>();

      for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlList) {
         if (psDEViewCtrl.isVALIDFLAGNull() || psDEViewCtrl.getVALIDFLAG()) {
            String strName = psDEViewCtrl.getPSDEVIEWCTRLNAME();
            String strOriginName = strName;
            String[] names = strName.split("[.]");
            strName = names[0];
            psDEViewCtrl.setPSDEVIEWCTRLNAME(strName);
            psDEViewCtrl.set("ORIGINNAME", strOriginName);
            strName = strName.toLowerCase();
            PSDEViewCtrl lastPSDEViewCtrl = psDEViewCtrlMap.get(strName);
            if (lastPSDEViewCtrl != null) {
               if (!this.isPrepareDefaultPSAppViewLogics()) {
                  if (StringHelper.Compare(psDEViewCtrl.getPSPFID(), this.getPSApplication().getPSPF().getId(), true) == 0) {
                     psDEViewCtrlMap.put(strName, psDEViewCtrl);
                  }
               } else if ((
                     StringHelper.IsNullOrEmpty(psDEViewCtrl.getPSPFID())
                        || StringHelper.Compare(psDEViewCtrl.getPSPFID(), this.getPSApplication().getPSPF().getId(), true) == 0
                  )
                  && this.replacePSDEViewCtrl(psDEViewCtrl, lastPSDEViewCtrl)) {
                  psDEViewCtrlMap.put(strName, psDEViewCtrl);
               }
            } else if ((
                  StringHelper.IsNullOrEmpty(psDEViewCtrl.getPSPFID())
                     || StringHelper.Compare(psDEViewCtrl.getPSPFID(), this.getPSApplication().getPSPF().getId(), true) == 0
               )
               && (names.length == 1 || names.length == 2 && StringHelper.Compare(names[1], this.getPSApplication().getPKGCodeName(), true) == 0)) {
               psDEViewCtrlMap.put(strName, psDEViewCtrl);
            }
         }
      }

      this.registerPSDEViewCtrls(psDEViewCtrlMap);
   }

   protected boolean replacePSDEViewCtrl(PSDEViewCtrl curPSDEViewCtrl, PSDEViewCtrl lastPSDEViewCtrl) throws Exception {
      String strCurName = curPSDEViewCtrl.getParamStringValue("ORIGINNAME", "");
      String strLastName = lastPSDEViewCtrl.getParamStringValue("ORIGINNAME", "");
      if (StringHelper.IsNullOrEmpty(strCurName)) {
         throw new Exception("当前部件名称不能为空");
      }

      if (StringHelper.IsNullOrEmpty(strLastName)) {
         throw new Exception("源部件名称不能为空");
      }

      String[] curnames = strCurName.split("[.]");
      String[] lastnames = strLastName.split("[.]");
      if (StringHelper.Compare(curPSDEViewCtrl.getPSPFID(), lastPSDEViewCtrl.getPSPFID(), false) == 0) {
         if (lastnames.length >= 2 && StringHelper.Compare(lastnames[1], this.getPSApplication().getPKGCodeName(), true) == 0) {
            return false;
         } else {
            return curnames.length >= 2 && StringHelper.Compare(curnames[1], this.getPSApplication().getPKGCodeName(), true) == 0
               ? true
               : curnames.length < lastnames.length;
         }
      } else {
         return !StringHelper.IsNullOrEmpty(curPSDEViewCtrl.getPSPFID());
      }
   }

   protected void registerPSDEViewCtrls(HashMap<String, PSDEViewCtrl> psDEViewCtrlMap) throws Exception {
      for (PSDEViewCtrl psDEViewCtrl : psDEViewCtrlMap.values()) {
         this.registerPSDEViewCtrl(psDEViewCtrl);
      }
   }

   protected IPSControl registerPSDEViewCtrl(PSDEViewCtrl psDEViewCtrl) throws Exception {
      try {
         IPSControlType iPSControlType = this.getPSModelStorage().getPSControlType(psDEViewCtrl.getPSDEVIEWCTRLTYPE());
         IPSControlParam iPSControlParam = iPSControlType.createPSControlParam(psDEViewCtrl);
         iPSControlParam.init(this.getDAGlobalHelper(), this, psDEViewCtrl);
         return this.registerPSControl(psDEViewCtrl.getPSDEVIEWCTRLNAME().toLowerCase(), psDEViewCtrl.getPSDEVIEWCTRLTYPE(), iPSControlParam);
      } catch (Exception ex) {
         throw new Exception(StringHelper.Format("注册实体视图控件[%1$s]发生异常，%2$s", psDEViewCtrl.getPSDEVIEWCTRLNAME(), ex.getMessage()), ex);
      }
   }

   @Override
   protected void onPreparePSAppViewRefs() throws Exception {
      super.onPreparePSAppViewRefs();
      Vector<PSDEViewView> psDEViewViewList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDEViewViews(this.getPSDEViewId(), psDEViewViewList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询视图关联视图集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      for (PSDEViewView psDEViewView : psDEViewViewList) {
         String strRefMode = psDEViewView.getPSDEVIEWRVNAME().toUpperCase();
         if (this.getPSAppViewRef(strRefMode, true) == null) {
            String strMinorPSDEViewId = psDEViewView.getMINORPSDEVIEWID();
            if (StringHelper.IsNullOrEmpty(strMinorPSDEViewId) && !StringHelper.IsNullOrEmpty(psDEViewView.getDEFVIEWTYPE())) {
               PSDEViewBase pdtViewBase = this.getPSDataEntity().getPSDEViewDataByPDT(psDEViewView.getDEFVIEWTYPE(), true);
               if (pdtViewBase != null) {
                  strMinorPSDEViewId = pdtViewBase.getPSDEVIEWBASEID();
               }
            }

            if (!StringHelper.IsNullOrEmpty(strMinorPSDEViewId)) {
               String strPSAppDEViewId = Helper.GenUniqueId(this.getPSApplication().getId(), strMinorPSDEViewId);
               PSAppViewRef psAppViewRef = new PSAppViewRef();
               psAppViewRef.setPSAPPVIEWREFNAME(psDEViewView.getPSDEVIEWRVNAME().toUpperCase());
               psAppViewRef.setMINORPSAPPVIEWID(strPSAppDEViewId);
               psAppViewRef.setOPENMODE(psDEViewView.getOPENMODE());
               psAppViewRef.setUSERTAG(psDEViewView.getUSERTAG());
               psAppViewRef.setUSERTAG2(psDEViewView.getUSERTAG2());
               psAppViewRef.setVIEWPARAMS(psDEViewView.getVIEWPARAMS());
               psAppViewRef.set("MINORPSDEVIEWBASEID", strMinorPSDEViewId);
               this.registerPSAppViewRef(psAppViewRef);
            }
         }
      }
   }

   protected String getPSDEUILogicGroupId() {
      return this.psViewBase.getPSCTRLLOGICGROUPID();
   }

   protected void onPreparePSDEViewLogics() throws Exception {
      Vector<PSDEViewLogic> psDEViewLogicList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDEViewLogics(this.getPSDEViewId(), psDEViewLogicList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询视图逻辑集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      Map<String, Object> map = new LinkedHashMap<>();

      for (PSDEViewLogic psDEViewLogic : psDEViewLogicList) {
         if (psDEViewLogic.isVALIDFLAGNull() || psDEViewLogic.getVALIDFLAG()) {
            try {
               PSAppDEViewLogicImpl psAppDEViewLogicImpl = new PSAppDEViewLogicImpl();
               psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), this, psDEViewLogic);
               this.registerPSAppViewLogic(psDEViewLogic.getPSDEVIEWLOGICNAME().toLowerCase(), psAppDEViewLogicImpl);
               map.put(psDEViewLogic.getPSDEVIEWLOGICNAME().toLowerCase(), psAppDEViewLogicImpl);
            } catch (Exception ex) {
               throw new Exception(
                  StringHelper.Format("注册视图[%1$s]逻辑[%2$s]发生异常，%3$s", this.getPSAppView().getName(), psDEViewLogic.getPSDEVIEWLOGICNAME(), ex.getMessage()), ex
               );
            }
         }
      }

      Iterator<? extends IPSAppDEUILogicGroupDetail> psAppDEUILogicGroupDetails = null;
      String strPPSDEUILogicGroupId = this.getPSDEUILogicGroupId();
      if (!StringHelper.IsNullOrEmpty(strPPSDEUILogicGroupId)) {
         if (this.getPSAppDataEntity() == null) {
            log.warn(String.format("视图[%1$s]应用实体无效，无法加载部件逻辑组", this.getName()));
            return;
         }

         List<IPSAppDEUILogicGroup> list = new ArrayList<>();

         while (!StringHelper.IsNullOrEmpty(strPPSDEUILogicGroupId)) {
            IPSAppDEUILogicGroup parent = this.getPSAppDataEntity().getPSAppDEUILogicGroup(strPPSDEUILogicGroupId);
            if (list.contains(parent)) {
               throw new Exception(String.format("界面逻辑组[%1$s]出现递归引用", parent.getFullName()));
            }

            list.add(parent);
            strPPSDEUILogicGroupId = parent.getParentPSDEUILogicGroupId();
         }

         for (IPSAppDEUILogicGroup item : list) {
            psAppDEUILogicGroupDetails = item.getPSAppDEUILogicGroupDetails();
            if (psAppDEUILogicGroupDetails != null) {
               while (psAppDEUILogicGroupDetails.hasNext()) {
                  IPSAppDEUILogicGroupDetail iPSAppDEUILogicGroupDetail = psAppDEUILogicGroupDetails.next();
                  String strName = iPSAppDEUILogicGroupDetail.getName();
                  if (!StringHelper.IsNullOrEmpty(strName)) {
                     strName = strName.toLowerCase();
                     if (!map.containsKey(strName)) {
                        map.put(strName, iPSAppDEUILogicGroupDetail);
                        PSDEViewLogic psDEViewLogic = new PSDEViewLogic();
                        psDEViewLogic.setPSDEVIEWBASEID(this.getPSDEViewId());
                        psDEViewLogic.setPSDEVIEWBASENAME(this.getPSDEViewName());
                        psDEViewLogic.setVALIDFLAG(true);
                        psDEViewLogic.setPSDEVIEWLOGICID(iPSAppDEUILogicGroupDetail.getId());
                        psDEViewLogic.setPSDEVIEWLOGICNAME(strName);
                        psDEViewLogic.setDSTLOGICTYPE(iPSAppDEUILogicGroupDetail.getLogicType());
                        psDEViewLogic.setPSDEVIEWLOGICTYPE(iPSAppDEUILogicGroupDetail.getTriggerType());
                        psDEViewLogic.setPSDEVIEWCTRLNAME(iPSAppDEUILogicGroupDetail.getCtrlName());
                        psDEViewLogic.setITEMNAME(iPSAppDEUILogicGroupDetail.getItemName());
                        psDEViewLogic.setATTRNAME(iPSAppDEUILogicGroupDetail.getAttrName());
                        psDEViewLogic.setLOGICPARAM(iPSAppDEUILogicGroupDetail.getLogicTag());
                        psDEViewLogic.setLOGICPARAM2(iPSAppDEUILogicGroupDetail.getLogicTag2());
                        psDEViewLogic.setCUSTOMCODE(iPSAppDEUILogicGroupDetail.getScriptCode());
                        psDEViewLogic.setTIMER(iPSAppDEUILogicGroupDetail.getTimer());
                        psDEViewLogic.setEVENTNAMES(iPSAppDEUILogicGroupDetail.getEventNames());
                        psDEViewLogic.setEVENTARG(iPSAppDEUILogicGroupDetail.getEventArg());
                        psDEViewLogic.setEVENTARG2(iPSAppDEUILogicGroupDetail.getEventArg2());
                        if (iPSAppDEUILogicGroupDetail.getPSDataEntity() != null) {
                           psDEViewLogic.setPSDEID(iPSAppDEUILogicGroupDetail.getPSDataEntity().getId());
                        }

                        psDEViewLogic.setPSSYSVIEWLOGICID(iPSAppDEUILogicGroupDetail.getPSSysViewLogicId());
                        psDEViewLogic.setPSDEUIACTIONID(iPSAppDEUILogicGroupDetail.getPSDEUIActionId());
                        psDEViewLogic.setPSDELOGICID(iPSAppDEUILogicGroupDetail.getPSDEUILogicId());
                        psDEViewLogic.setPSSYSVIEWPANELID(iPSAppDEUILogicGroupDetail.getPSSysViewPanelId());

                        try {
                           PSAppDEViewLogicImpl psAppDEViewLogicImpl = new PSAppDEViewLogicImpl();
                           psAppDEViewLogicImpl.init(this.getDAGlobalHelper(), this, psDEViewLogic);
                           this.registerPSAppViewLogic(psDEViewLogic.getPSDEVIEWLOGICNAME().toLowerCase(), psAppDEViewLogicImpl);
                           map.put(psDEViewLogic.getPSDEVIEWLOGICNAME().toLowerCase(), psAppDEViewLogicImpl);
                        } catch (Exception ex) {
                           throw new Exception(
                              StringHelper.Format(
                                 "注册视图[%1$s]逻辑[%2$s]发生异常，%3$s", this.getPSAppView().getName(), psDEViewLogic.getPSDEVIEWLOGICNAME(), ex.getMessage()
                              ),
                              ex
                           );
                        }
                     }
                  }
               }
            }
         }
      }
   }

   protected void onPreparePSDEViewEngines() throws Exception {
      Vector<PSDEViewEngine> psDEViewEngineList = new Vector<>();
      CallResult callResult = this.getPSModelHelper().getPSDEViewEngines(this.getPSDEViewId(), psDEViewEngineList);
      if (callResult.isError()) {
         throw new Exception(StringHelper.Format("查询视图界面引擎集合发生错误, %1$s", callResult.getErrorInfo()));
      }

      for (PSDEViewEngine psDEViewEngine : psDEViewEngineList) {
         if (psDEViewEngine.isVALIDFLAGNull() || psDEViewEngine.getVALIDFLAG()) {
            try {
               PSAppDEViewEngineImpl psAppDEViewEngineImpl = new PSAppDEViewEngineImpl();
               psAppDEViewEngineImpl.init(this.getDAGlobalHelper(), this, psDEViewEngine);
               this.registerPSAppViewEngine(psDEViewEngine.getPSDEVIEWENGINENAME().toLowerCase(), psAppDEViewEngineImpl);
            } catch (Exception ex) {
               throw new Exception(
                  StringHelper.Format("注册视图[%1$s]界面引擎[%2$s]发生异常，%3$s", this.getPSAppView().getName(), psDEViewEngine.getPSDEVIEWLOGICNAME(), ex.getMessage()),
                  ex
               );
            }
         }
      }

      if (this.isPrepareDefaultPSAppViewEngines()) {
         Iterator<IPSControl> psControls = this.getPSControls();
         if (psControls != null) {
            while (psControls.hasNext()) {
               IPSControl iPSControl = psControls.next();

               try {
                  if (!StringHelper.IsNullOrEmpty(iPSControl.getInstallUIEngine())) {
                     String strUIEngineType = String.format("CTRL_%1$s", iPSControl.getInstallUIEngine());
                     IPSUIEngineType iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(strUIEngineType, true);
                     if (iPSUIEngineType != null) {
                        IPSControl refPSControl = iPSControl.getRefPSControl();
                        this.installPSControlUIEngine(iPSControl, refPSControl, iPSControl.getInstallUIEngine(), iPSUIEngineType, "default", 100);
                     }
                  }

                  if (!StringHelper.IsNullOrEmpty(iPSControl.getInstallUIEngine2())) {
                     String strUIEngineType = String.format("CTRL_%1$s", iPSControl.getInstallUIEngine2());
                     IPSUIEngineType iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(strUIEngineType, true);
                     if (iPSUIEngineType != null) {
                        IPSControl refPSControl = iPSControl.getRefPSControl2();
                        this.installPSControlUIEngine(iPSControl, refPSControl, iPSControl.getInstallUIEngine2(), iPSUIEngineType, "default2", 200);
                     }
                  }
               } catch (Exception ex) {
                  throw new Exception(
                     StringHelper.Format("注册视图[%1$s]部件[%2$s]默认界面引擎发生异常，%3$s", this.getPSAppView().getName(), iPSControl.getName(), ex.getMessage()), ex
                  );
               }
            }
         }
      }
   }

   protected void installPSControlUIEngine(
      IPSControl iPSControl, IPSControl refPSControl, String strRefUsage, IPSUIEngineType iPSUIEngineType, String strTag, int nOrder
   ) throws Exception {
      PSDEViewEngine psDEViewEngine = new PSDEViewEngine();
      String strEngineName = String.format("engine_%1$s_%2$s", iPSControl.getName(), strTag).toLowerCase();
      psDEViewEngine.setPSDEVIEWENGINEID(strEngineName);
      psDEViewEngine.setPSDEVIEWENGINENAME(strEngineName);
      psDEViewEngine.setPSUIENGINETYPEID(iPSUIEngineType.getId());
      psDEViewEngine.setORDERVALUE(nOrder + iPSControl.getOrderValue());
      psDEViewEngine.setPSDEVIEWCTRLNAME(iPSControl.getName());
      if (refPSControl != null) {
         psDEViewEngine.setNO2PSDEVIEWCTRLNAME(refPSControl.getName());
      }

      PSAppDEViewEngineImpl psAppDEViewEngineImpl = new PSAppDEViewEngineImpl();
      psAppDEViewEngineImpl.init(this.getDAGlobalHelper(), this, psDEViewEngine);
      this.registerPSAppViewEngine(psDEViewEngine.getPSDEVIEWENGINENAME().toLowerCase(), psAppDEViewEngineImpl);
   }

   @Override
   protected String onGetViewType() {
      return this.iPSViewType.getId();
   }

   @Override
   protected String onGetCodeName() {
      if (this.isEnableUIModelEx() && !StringHelper.IsNullOrEmpty(this.psViewBase.getDEVIEWTAG2())) {
         return this.psViewBase.getDEVIEWTAG2();
      } else {
         return this.isEnableUIModelEx()
               && !StringHelper.IsNullOrEmpty(this.getPSApplication().getViewCodeNameMode())
               && StringHelper.Compare(this.getPSApplication().getViewCodeNameMode(), "NONE", false) != 0
               && (this.psApplicationView.isSYNCCODENAMENull() || this.psApplicationView.getSYNCCODENAME())
               && this.getPSAppDataEntity() != null
               && !StringHelper.IsNullOrEmpty(this.psViewBase.getCODENAME())
            ? this.getPSApplication().getViewCodeName(null, this.getPSAppDataEntity().getCodeName(), this.psViewBase.getCODENAME())
            : super.onGetCodeName();
      }
   }

   @PSModelRTMeta(description = "视图实体对象")
   @Override
   public IPSDataEntity getPSDataEntity() {
      return this.iPSDataEntity;
   }

   protected void setPSDataEntity(IPSDataEntity iPSDataEntity) throws Exception {
      this.iPSDataEntity = iPSDataEntity;
   }

   @PSModelRTMeta(description = "实体视图标识", fields = "PSDEVIEWBASEID")
   @Override
   public String getPSDEViewId() {
      return this.strPSDEViewId;
   }

   @Override
   public String getPSDEViewName() {
      return this.strPSDEViewName;
   }

   protected void setPSDEViewId(String strPSDEViewId) {
      this.strPSDEViewId = strPSDEViewId;
   }

   protected void setPSDEViewName(String strPSDEViewName) {
      this.strPSDEViewName = strPSDEViewName;
   }

   @Override
   public void setPSViewType(IPSViewType iPSViewType) {
      this.iPSViewType = iPSViewType;
   }

   @Override
   public IPSViewType getPSViewType() {
      return this.iPSViewType;
   }

   @PSModelRTMeta(description = "启用数据权限")
   @Override
   public boolean isEnableDP() {
      return this.bEnableDP;
   }

   @Override
   public IDataEntity getDataEntity() {
      return this.getPSDataEntity();
   }

   public String getPSAjaxControlHandlerId() {
      return this.strPSAjaxControlId;
   }

   protected void setPSAjaxControlHandlerId(String strPSAjaxControlId) {
      this.strPSAjaxControlId = strPSAjaxControlId;
   }

   @PSModelRTMeta(description = "视图抬头", fields = "TITLE", doc = "优先使用应用实体视图标题{@link net.ibizsys.centralstudio.dto.PSAppDEViewDTO#TAG_TITLE}")
   @Override
   public String getTitle() {
      String strTitle = super.getTitle();
      if (StringHelper.IsNullOrEmpty(strTitle)) {
         strTitle = this.psViewBase.getTITLE();
         if (StringHelper.IsNullOrEmpty(strTitle)) {
            return this.psViewBase.getPSDEVIEWBASENAME();
         }
      }

      return strTitle;
   }

   @PSModelRTMeta(
      description = "视图标题",
      group = "基本",
      order = 120,
      fields = "CAPTION",
      doc = "优先使用应用实体视图标题{@link net.ibizsys.centralstudio.dto.PSAppDEViewDTO#TAG_CAPTION}"
   )
   @Override
   public String getCaption() {
      String strCaption = super.getCaption();
      if (StringHelper.IsNullOrEmpty(strCaption)) {
         strCaption = this.psViewBase.getCAPTION();
         if (StringHelper.IsNullOrEmpty(strCaption)) {
            return this.getPSDataEntity().getLogicName(this.getLanguage());
         }
      }

      return strCaption;
   }

   @PSModelRTMeta(description = "视图子标题", fields = "SUBCAPTION")
   @Override
   public String getSubCaption() {
      String strSubCaption = super.getSubCaption();
      return StringHelper.IsNullOrEmpty(strSubCaption) ? this.strSubCaption : strSubCaption;
   }

   @PSModelRTMeta(description = "视图宽度", ignoredumpvalues = "0", outputdoc = "(%1$s.getWidth() gt 0)", fields = "WIDTH")
   @Override
   public int getWidth() {
      return this.psViewBase.getWIDTH() > 0 ? this.psViewBase.getWIDTH() : super.getWidth();
   }

   @PSModelRTMeta(description = "视图高度", ignoredumpvalues = "0", outputdoc = "(%1$s.getHeight() gt 0)", fields = "HEIGHT")
   @Override
   public int getHeight() {
      return this.psViewBase.getHEIGHT() > 0 ? this.psViewBase.getHEIGHT() : super.getHeight();
   }

   @PSModelRTMeta(description = "临时数据模式", codelist = "TempDataMode", ignoredumpvalues = "0", fields = "TEMPMODE")
   @Override
   public int getTempMode() {
      return this.nTempMode;
   }

   @PSModelRTMeta(description = "默认打开模式", codelist = "DEViewOpenMode", fields = "OPENMODE")
   @Override
   public String getOpenMode() {
      return this.psViewBase.getOPENMODE();
   }

   @PSModelRTMeta(description = "支持工作流", ignoredumpvalues = "false")
   @Override
   public boolean isEnableWF() {
      return false;
   }

   protected void onPrepareWFInfo() throws Exception {
      if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSWFDEID())) {
         this.iPSWFDE = this.getPSDataEntity().getPSDEWF(this.psViewBase.getPSWFDEID());
      } else {
         this.iPSWFDE = this.getPSDataEntity().getDefaultPSDEWF();
      }

      if (this.getPSDEWF() != null) {
         if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSWFVERSIONID())) {
            this.iPSWFVersion = this.getPSDEWF().getPSWorkflow().getPSWFVersion(this.psViewBase.getPSWFVERSIONID());
         } else {
            this.iPSWFVersion = this.getPSDEWF().getPSWorkflow().getLastPSWFVersion();
         }
      }

      if (this.getPSWorkflow() != null) {
         this.iPSAppWF = this.getPSApplication().getPSAppWF(this.getPSWorkflow().getId(), true);
      }

      if (this.getPSWFVersion() != null) {
         this.iPSAppWFVer = this.getPSApplication().getPSAppWFVer(this.getPSWFVersion().getId(), true);
      }
   }

   @PSModelRTMeta(description = "实体工作流对象", hideempty = true, ignorepf = true)
   @Override
   public IPSDEWF getPSDEWF() {
      return this.iPSWFDE;
   }

   @PSModelRTMeta(description = "工作流版本对象", hideempty = true, dumpref = true, ignorepf = true)
   @Override
   public IPSWFVersion getPSWFVersion() {
      return this.iPSWFVersion;
   }

   @PSModelRTMeta(description = "工作流对象", hideempty = true, dumpref = true, ignorepf = true)
   @Override
   public IPSWorkflow getPSWorkflow() {
      return this.getPSDEWF() == null ? null : this.getPSDEWF().getPSWorkflow();
   }

   @Override
   public boolean isWFIAMode() {
      return this.bWFIAMode;
   }

   protected void setWFIAMode(boolean bWFIAMode) {
      this.bWFIAMode = bWFIAMode;
   }

   @Override
   public String getWFStepValue() {
      return this.strWFStepValue;
   }

   protected void setWFStepValue(String strWFStepValue) {
      this.strWFStepValue = strWFStepValue;
   }

   @Override
   public String getWFUtilType() {
      return this.strWFUtilType;
   }

   protected void setWFUtilType(String strWFUtilType) {
      this.strWFUtilType = strWFUtilType;
   }

   protected boolean isEnableViewActions() {
      return this.bEnableViewActions;
   }

   protected long getViewActions() {
      return this.nViewActions;
   }

   @PSModelRTMeta(description = "支持帮助", dump = false)
   @Override
   public boolean isEnableHelp() {
      return this.isEnableViewActions() ? (this.getViewActions() & 512L) > 0L : super.isEnableHelp();
   }

   @Override
   protected void onPreparePSAppViewParams() throws Exception {
      if (this.getPSDER1N() != null) {
         IPSAppDataEntity majorPSAppDataEntity = this.getPSApplication().getPSAppDataEntity(this.getPSDER1N().getMajorPSDataEntity(), true);
         if (majorPSAppDataEntity != null) {
            this.registerPSAppViewParam(StringHelper.Format("%1$s%2$s", "SRFNAVCTX.", majorPSAppDataEntity.getName()), "%SRFPARENTKEY%", "父键值转化为导航上下文关系主实体键值");
         }
      }

      if (this.viewParamProperties != null) {
         for (Object objKey : this.viewParamProperties.keySet()) {
            this.registerPSAppViewParam(objKey.toString(), PropertiesHelper.GetProperty(this.viewParamProperties, objKey.toString()), "");
         }
      }

      super.onPreparePSAppViewParams();
   }

   @PSModelRTMeta(description = "访问用户模式", codelist = "ViewAccessUsers", fields = "ACCUSERMODE")
   @Override
   public int getAccUserMode() {
      return super.getAccUserMode() != AccessUserModes.UNKNOWN ? super.getAccUserMode() : this.nAccUserMode;
   }

   @Override
   protected IPSSysUniRes getPSSysUniRes() {
      return super.getPSSysUniRes() != null ? super.getPSSysUniRes() : this.iPSSysUniRes;
   }

   @Override
   protected String getDefaultAccessKey() {
      return (this.getAccUserMode() & AccessUserModes.LOGINUSERWITHKEY) > 0
         ? StringHelper.Format("DEDATA:%1$s:READ", this.getDataEntity().getName().toUpperCase())
         : super.getDefaultAccessKey();
   }

   @PSModelRTMeta(description = "应用实体视图", dump = false)
   @Override
   public boolean isPSDEView() {
      return true;
   }

   @Override
   public int getExtendMode() {
      return 0;
   }

   @Override
   public String getModelType() {
      return "PSAPPDEVIEW";
   }

   protected String getPDTParamPre() {
      return this.psViewBase.getPDTPARAMPRE();
   }

   @Override
   public IPSDEActionWizardGroup getPSDEActionWizardGroup() {
      return this.iPSDEActionWizardGroup;
   }

   @PSModelRTMeta(description = "视图消息组", hideempty = true)
   @Override
   public IPSViewMsgGroup getPSViewMsgGroup() {
      return super.getPSViewMsgGroup() != null ? super.getPSViewMsgGroup() : this.iPSViewMsgGroup;
   }

   @Override
   public IViewWizardGroup getViewWizardGroup() {
      return super.getViewWizardGroup() != null ? super.getViewWizardGroup() : this.getPSDEActionWizardGroup();
   }

   @PSModelRTMeta(description = "抬头语言资源", fields = "TITLEPSLANRESID")
   @Override
   public IPSLanguageRes getTitlePSLanguageRes() {
      return super.getTitlePSLanguageRes() != null ? super.getTitlePSLanguageRes() : this.titlePSLanguageRes;
   }

   @PSModelRTMeta(description = "标题语言资源", fields = "CAPPSLANRESID")
   @Override
   public IPSLanguageRes getCapPSLanguageRes() {
      if (super.getCapPSLanguageRes() != null) {
         return super.getCapPSLanguageRes();
      } else {
         return this.capPSLanguageRes == null ? this.getPSDataEntity().getLNPSLanguageRes() : this.capPSLanguageRes;
      }
   }

   @PSModelRTMeta(description = "子标题语言资源", fields = "SUBCAPPSLANRESID")
   @Override
   public IPSLanguageRes getSubCapPSLanguageRes() {
      return super.getSubCapPSLanguageRes() != null ? super.getSubCapPSLanguageRes() : this.subCapPSLanguageRes;
   }

   @Override
   public String getPSHelpModuleId() {
      return !StringHelper.IsNullOrEmpty(super.getPSHelpModuleId()) ? super.getPSHelpModuleId() : this.strPSHelpModuleId;
   }

   @PSModelRTMeta(description = "显示标题栏", ignoredumpvalues = "true", fields = "SHOWCAPTIONBAR")
   @Override
   public boolean isShowCaptionBar() {
      return this.bShowCaptionBar == null ? super.isShowCaptionBar() : this.bShowCaptionBar;
   }

   @Override
   protected void logPSModelIssue(PSSysIssue psSysIssueV3) throws Exception {
      psSysIssueV3.setPSOBJ2ID(this.getPSDEViewId());
      psSysIssueV3.setPSOBJ2NAME(this.getPSDEViewName());
      super.logPSModelIssue(psSysIssueV3);
   }

   @Override
   protected IPSAppViewPlugin createPSAppViewPlugin() throws Exception {
      IPSAppViewPlugin iPSAppViewPlugin = super.createPSAppViewPlugin();
      if (iPSAppViewPlugin != null) {
         return iPSAppViewPlugin;
      }

      if (!StringHelper.IsNullOrEmpty(this.psViewBase.getPSVIEWENGINEID())) {
         IPSViewEngine iPSViewEngine = this.getPSModelStorage().getPSViewEngine(this.psViewBase.getPSVIEWENGINEID());
         if (StringHelper.Compare(iPSViewEngine.getEngineType(), "PLUGIN", false) == 0) {
            return (IPSAppViewPlugin)ObjectHelper.Create(iPSViewEngine.getEngineObj());
         }
      }

      return null;
   }

   protected IPSAppDEViewPlugin getPSAppDEViewPlugin() {
      return this.getPSAppViewPlugin() != null && this.getPSAppViewPlugin() instanceof IPSAppDEViewPlugin
         ? (IPSAppDEViewPlugin)this.getPSAppViewPlugin()
         : null;
   }

   @Override
   protected Boolean getDynamicView() {
      Boolean bRet = super.getDynamicView();
      return bRet != null ? bRet : this.bDynamicView;
   }

   @Override
   protected void onPreparePSTitleBar() throws Exception {
      super.onPreparePSTitleBar();
      if (super.getPSTitleBar() == null) {
         ;
      }
   }

   @Override
   public IPSWFInteractiveProcess getPSWFInteractiveProcess() {
      return null;
   }

   @Override
   public IPSAjaxHandler getPSAjaxHandler() {
      IPSAjaxHandler iPSAjaxHandler = super.getPSAjaxHandler();
      return iPSAjaxHandler != null ? iPSAjaxHandler : this.iPSAjaxHandler;
   }

   @Override
   protected String getPSSysViewLayoutPanelId() {
      String strPSSysViewLayoutPanelId = super.getPSSysViewLayoutPanelId();
      if (StringHelper.IsNullOrEmpty(strPSSysViewLayoutPanelId)) {
         strPSSysViewLayoutPanelId = this.psViewBase.getPSSYSVIEWPANELID();
      }

      return strPSSysViewLayoutPanelId;
   }

   @Override
   protected IPSAppViewEngine createDefaultPSAppViewEngine() throws Exception {
      IPSUIEngineType iPSUIEngineType = null;
      if (this.getPSSubViewType() != null && this.getPSSubViewType().isExtendCtrl()) {
         iPSUIEngineType = this.getPSSubViewType().getPSUIEngineType();
      }

      if (iPSUIEngineType == null) {
         iPSUIEngineType = this.getPSModelStorage().getPSUIEngineType(this.getViewType(), true);
      }

      if (iPSUIEngineType == null) {
         return null;
      }

      PSDEViewEngine psDEViewEngine = new PSDEViewEngine();
      psDEViewEngine.setPSDEVIEWENGINEID("engine");
      psDEViewEngine.setPSDEVIEWENGINENAME("engine");
      psDEViewEngine.setPSUIENGINETYPEID(this.getViewType());
      psDEViewEngine.setORDERVALUE(0);
      Iterator<String> engineParams = iPSUIEngineType.getEngineParamNames();
      if (engineParams != null) {
         while (engineParams.hasNext()) {
            String strKey = engineParams.next();
            String strValue = iPSUIEngineType.getEngineParamKey(strKey);
            if (!StringHelper.IsNullOrEmpty(strValue)) {
               if (strValue.indexOf("PSDEVIEWCTRLNAME") != -1) {
                  if (this.hasPSControl(strKey)) {
                     IPSControl iPSControl = this.getPSControl(strKey);
                     psDEViewEngine.set(strValue, iPSControl.getName());
                  }
               } else if (strValue.indexOf("PSDEVIEWLOGICNAME") != -1) {
                  IPSAppViewLogic iPSAppViewLogic = this.getPSAppViewLogic(strKey.toLowerCase(), true);
                  if (iPSAppViewLogic != null) {
                     psDEViewEngine.set(strValue, iPSAppViewLogic.getName());
                  }
               } else if (strValue.indexOf("CTRLNAME") != -1) {
                  if (this.hasPSControl(strKey)) {
                     IPSControl iPSControl = this.getPSControl(strKey);
                     psDEViewEngine.set(strValue.replace("CTRLNAME", "PSDEVIEWCTRLNAME"), iPSControl.getName());
                  }
               } else if (strValue.indexOf("LOGICNAME") != -1) {
                  IPSAppViewLogic iPSAppViewLogic = this.getPSAppViewLogic(strKey.toLowerCase(), true);
                  if (iPSAppViewLogic != null) {
                     psDEViewEngine.set(strValue.replace("LOGICNAME", "PSDEVIEWLOGICNAME"), iPSAppViewLogic.getName());
                  }
               }
            }
         }
      }

      psDEViewEngine.setVIEWPARAM(this.psViewBase.getVIEWPARAM());
      psDEViewEngine.setVIEWPARAM2(this.psViewBase.getVIEWPARAM2());
      psDEViewEngine.setVIEWPARAM3(this.psViewBase.getVIEWPARAM3());
      psDEViewEngine.setVIEWPARAM4(this.psViewBase.getVIEWPARAM4());
      psDEViewEngine.setVIEWPARAM5(this.psViewBase.getVIEWPARAM5());
      psDEViewEngine.setVIEWPARAM6(this.psViewBase.getVIEWPARAM6());
      psDEViewEngine.setVIEWPARAM7(this.psViewBase.getVIEWPARAM7());
      psDEViewEngine.setVIEWPARAM8(this.psViewBase.getVIEWPARAM8());
      psDEViewEngine.setVIEWPARAM9(this.psViewBase.getVIEWPARAM9());
      psDEViewEngine.setVIEWPARAM10(this.psViewBase.getVIEWPARAM10());
      psDEViewEngine.setWFVIEWPARAM(this.psViewBase.getWFVIEWPARAM());
      psDEViewEngine.setWFVIEWPARAM2(this.psViewBase.getWFVIEWPARAM2());
      psDEViewEngine.setWFVIEWPARAM3(this.psViewBase.getWFVIEWPARAM3());
      psDEViewEngine.setWFVIEWPARAM4(this.psViewBase.getWFVIEWPARAM4());
      PSAppDEViewEngineImpl psAppDEViewEngineImpl = new PSAppDEViewEngineImpl();
      psAppDEViewEngineImpl.init(this.getDAGlobalHelper(), this, iPSUIEngineType, psDEViewEngine);
      return psAppDEViewEngineImpl;
   }

   @PSModelRTMeta(description = "实体视图代码名称")
   @Override
   public String getPSDEViewCodeName() {
      return this.psViewBase.getCODENAME();
   }

   @PSModelRTMeta(description = "实体视图控制关系")
   @Override
   public IPSDER1N getPSDER1N() {
      return this.iPSDER1N;
   }

   @PSModelRTMeta(description = "父应用实体", dumpref = true, ignorert = 3)
   @Override
   public IPSAppDataEntity getParentPSAppDataEntity() throws Exception {
      return this.getPSDER1N() != null ? this.getPSApplication().getPSAppDataEntity(this.getPSDER1N().getMajorPSDataEntity(), true) : null;
   }

   @PSModelRTMeta(description = "应用实体关系路径数量", dump = false)
   @Override
   public int getPSAppDERSPathCount() throws Exception {
      return this.psAppDERSPathMap != null ? this.psAppDERSPathMap.size() : super.getPSAppDERSPathCount();
   }

   @Override
   public Iterator<? extends IPSAppDERS> getPSAppDERSPath(int nPathIndex) throws Exception {
      if (this.psAppDERSPathMap != null) {
         ArrayList<IPSAppDERS> list = this.psAppDERSPathMap.get(nPathIndex);
         return list != null ? list.iterator() : null;
      } else {
         return super.getPSAppDERSPath(nPathIndex);
      }
   }

   @PSModelRTMeta(description = "应用工作流", hideempty = true, dumpref = true, from = "IPSApplication")
   @Override
   public IPSAppWF getPSAppWF() {
      return this.iPSAppWF;
   }

   @PSModelRTMeta(description = "应用工作流版本", hideempty = true, dumpref = true, from = "__self__", from_method = "getPSAppWFMust().getPSAppWFVer")
   @Override
   public IPSAppWFVer getPSAppWFVer() {
      return this.iPSAppWFVer;
   }

   @PSModelRTMeta(description = "功能视图模式", codelist = "PredefinedViewType", hideempty2 = true)
   @Override
   public String getFuncViewMode() {
      return this.psViewBase.getPREDEFINEVIEWTYPE();
   }

   @PSModelRTMeta(description = "功能视图参数", hideempty2 = true)
   @Override
   public String getFuncViewParam() {
      return this.psViewBase.getPDVTPARAM();
   }

   @PSModelRTMeta(description = "系统计数器", hideempty = true)
   @Override
   public IPSSysCounter getPSSysCounter() {
      return this.iPSAppCounter;
   }

   @PSModelRTMeta(description = "系统计数器引用", hideempty = true)
   @Override
   public IPSSysCounterRef getPSSysCounterRef() {
      return this.iPSSysCounterRef;
   }

   @PSModelRTMeta(description = "应用计数器引用", hideempty = true, dumpref = true, from = "__self__")
   @Override
   public IPSAppCounterRef getPSAppCounterRef() {
      return this.getPSSysCounterRef() != null && this.getPSSysCounterRef() instanceof IPSAppCounterRef ? (IPSAppCounterRef)this.getPSSysCounterRef() : null;
   }

   @Override
   protected Integer onGetPriority() {
      if (super.onGetPriority() != null) {
         return super.onGetPriority();
      } else {
         return this.nPriority == null && "DESUBAPPREFVIEW".equalsIgnoreCase(this.getViewType()) ? 100 : this.nPriority;
      }
   }

   @Override
   protected void onPreparePSAppViewEngines() throws Exception {
   }

   @Override
   protected void onPreparePSAppViewLogics() throws Exception {
   }

   @Override
   public void registerPSAppViewLogic(String strKey, IPSAppViewLogic iPSAppViewLogic) throws Exception {
      super.registerPSAppViewLogic(strKey, iPSAppViewLogic);
   }

   @Override
   protected Integer onGetDynaSysMode() {
      return super.onGetDynaSysMode();
   }

   @Override
   protected void onFillModelNode(ObjectNode objectNode, String strModelType) throws Exception {
      super.onFillModelNode(objectNode, strModelType);
      int nCount = this.getPSAppDERSPathCount();
      if (nCount > 0) {
         ArrayNode arrayNode = objectNode.putArray("getPSAppDERSPaths");

         for (int i = 0; i < nCount; i++) {
            Iterator<? extends IPSAppDERS> psAppDERSs = this.getPSAppDERSPath(i);
            if (psAppDERSs != null) {
               ArrayNode subArray = arrayNode.addArray();

               while (psAppDERSs.hasNext()) {
                  IPSAppDERS iPSAppDERS = psAppDERSs.next();
                  ObjectNode childNode = iPSAppDERS.getModel();
                  subArray.add(childNode);
               }
            }
         }
      }
   }

   @Override
   protected void onFillModelRefNode(ObjectNode objectNode, String strModelRefType) throws Exception {
      super.onFillModelRefNode(objectNode, strModelRefType);
      if (!StringHelper.IsNullOrEmpty(strModelRefType)) {
         if ("APPLICATION".equals(strModelRefType)) {
            if (this.getPSAppDataEntity() != null) {
               objectNode.put("resource", this.getPSAppDataEntity().getCodeName());
            }

            objectNode.put("view", this.getPSDEViewCodeName());
            if (!this.getCodeName().equals(this.getName())) {
               objectNode.put("name", this.getName());
            }
         }

         if ("DATAENTITY".equals(strModelRefType)) {
            objectNode.put("app", this.getPSApplication().getCodeName());
            objectNode.put("view", this.getPSDEViewCodeName());
         }
      }
   }
}
