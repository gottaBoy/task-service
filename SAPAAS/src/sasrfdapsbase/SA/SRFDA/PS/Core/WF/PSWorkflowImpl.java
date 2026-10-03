package SA.SRFDA.PS.Core.WF;

import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.WF.IPSAppWF;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.DataEntity.WF.IPSDEWF;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Res.IPSLanguageRes;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIAction;
import SA.SRFDA.PS.Core.WF.UIAction.IPSWFUIActionGroup;
import SA.SRFDA.PS.Core.WF.UIAction.PSWFUIActionGlobalModel;
import SA.SRFDA.PS.Core.WF.UIAction.PSWFUIActionGroupGlobalModel;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Core.WX.IPSWXEntApp;
import SA.SRFDA.PS.Data.PSWorkflow;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkflowImpl extends PSSystemObjectImpl implements IPSWorkflow {
   private static final Log log = LogFactory.getLog(PSWorkflowImpl.class);
   protected PSWorkflow psWorkflow;
   private String strCodeName = "";
   private PSWFVersionGlobalModel psWFVersionGlobalModel = null;
   private PSWFDEGlobalModel psWFDEGlobalModel = null;
   private IPSCodeList wfStepPSCodeList = null;
   private IPSCodeList entityStatePSCodeList = null;
   private Map<String, String> entityWFStateMap = new LinkedHashMap<>();
   private IPSWFVersion lastPSWFVersion = null;
   private String strEntityWFState = "";
   private String strEntityWFFinishState = "";
   private String strEntityWFErrorState = "";
   private String strEntityWFCancelState = "";
   private String strRemindMsgTemplId = null;
   private boolean bValidFlag = true;
   private IPSWXAccount iPSWXAccount = null;
   private IPSWXEntApp iPSWXEntApp = null;
   private String strWFEngineCat = "EMBEDDED";
   private String strWFEngineType = "EMBEDDED";
   private boolean bDynamicWorkflow = false;
   private IPSLanguageRes namePSLanguageRes = null;
   private IPSSystemModule iPSSystemModule = null;
   private boolean bUseRemoteEngine = false;
   private boolean bUseWFProxyApp = false;
   private int nWFProxyMode = 0;
   protected PSWFUIActionGlobalModel psWFUIActionGlobalModel = new PSWFUIActionGlobalModel();
   protected PSWFUIActionGroupGlobalModel psWFUIActionGroupGlobalModel = new PSWFUIActionGroupGlobalModel();
   private ArrayList<IPSAppWF> psAppWFList = null;
   private String strWFType = "DEFAULT";
   private int nDynaInstMode = 0;
   private int nDynaSysMode = 0;

   @Override
   public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSWorkflow psWorkflow) throws Exception {
      try {
         this.setDAGlobalHelper(iDAGlobalHelper);
         this.setPSSystem(iPSSystem);
         this.psWorkflow = psWorkflow;
         this.setId(this.psWorkflow.getPSWORKFLOWID());
         this.setName(this.psWorkflow.getPSWORKFLOWNAME());
         this.setPSObjectData(this.psWorkflow);
         this.strCodeName = this.psWorkflow.getCODENAME();
         if (!this.psWorkflow.isWFPROXYMODENull()) {
            this.nWFProxyMode = this.psWorkflow.getWFPROXYMODE();
            this.bUseWFProxyApp = (this.getWFProxyMode() & 1) == 1;
         }

         if (!this.isUseWFProxyApp() && !StringHelper.IsNullOrEmpty(this.psWorkflow.getWFSTEPCODELISTID())) {
            this.wfStepPSCodeList = iPSSystem.getPSCodeList(this.psWorkflow.getWFSTEPCODELISTID());
         }

         if (!StringHelper.IsNullOrEmpty(this.psWorkflow.getSTATECODELISTID())) {
            this.entityStatePSCodeList = iPSSystem.getPSCodeList(this.psWorkflow.getSTATECODELISTID());
         }

         if (!StringHelper.IsNullOrEmpty(this.psWorkflow.getPSMODULEID())) {
            this.iPSSystemModule = this.getPSSystem().getPSSystemModule(this.psWorkflow.getPSMODULEID());
         }

         if (!StringHelper.IsNullOrEmpty(this.psWorkflow.getREMINDPSSYSMSGTEMPLID())) {
            this.strRemindMsgTemplId = this.psWorkflow.getREMINDPSSYSMSGTEMPLID();
         }

         if (!this.psWorkflow.isVALIDFLAGNull()) {
            this.bValidFlag = this.psWorkflow.getVALIDFLAG();
         }

         if (!StringHelper.IsNullOrEmpty(this.psWorkflow.getWFENGINETYPE())) {
            this.strWFEngineType = this.psWorkflow.getWFENGINETYPE();
         }

         if (!StringHelper.IsNullOrEmpty(this.psWorkflow.getWFTYPE())) {
            this.strWFType = this.psWorkflow.getWFTYPE();
         }

         this.strWFEngineCat = this.strWFEngineType;
         if (!this.psWorkflow.isENABLEDYNASYSNull()) {
            this.bDynamicWorkflow = this.psWorkflow.getENABLEDYNASYS();
            if (this.psWorkflow.getENABLEDYNASYS()) {
               this.nDynaSysMode = 1;
            }
         }

         if (!this.psWorkflow.isREMOTEENGINEFLAGNull()) {
            this.bUseRemoteEngine = this.psWorkflow.getREMOTEENGINEFLAG();
         }

         if (StringHelper.Compare(this.getWFEngineCat(), "ACTIVITI", true) == 0 && this.isUseRemoteEngine()) {
            this.strWFEngineType = "ACTIVITI_REMOTE";
         }

         if (this.getPSSystemModule() != null && this.getPSSystemModule().getDynaInstMode() != 0) {
            this.nDynaInstMode = this.getPSSystemModule().getDynaInstMode();
            if (!this.psWorkflow.isENABLEDYNASYSNull() && !this.psWorkflow.getENABLEDYNASYS()) {
               this.nDynaInstMode = 0;
            }
         }

         this.psWFUIActionGlobalModel.Init(this.getDAGlobalHelper(), this);
         this.psWFUIActionGroupGlobalModel.Init(this.getDAGlobalHelper(), this);
         this.onInit();
      } catch (Exception ex) {
         String strLogName = net.ibizsys.paas.util.StringHelper.format("%1$s[%2$s]", PSModels.getModelName(this.getModelType()), this.getFullModelName());
         String strExInfo = net.ibizsys.paas.util.StringHelper.format("初始化发生异常，%1$s", ex.getMessage());
         log.error(net.ibizsys.paas.util.StringHelper.format("%1$s%2$s", strLogName, strExInfo), ex);
         if (this.getPSSystemUtil() != null) {
            this.getPSSystemUtil().getPSSysConsole().error(strLogName, strExInfo);
         }

         this.throwInitException(ex);
      }
   }

   @Override
   protected void onInit() throws Exception {
      super.onInit();
      if (!StringHelper.IsNullOrEmpty(this.psWorkflow.getNAMEPSLANRESID())) {
         this.namePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psWorkflow.getNAMEPSLANRESID());
      }

      this.strEntityWFState = this.psWorkflow.getWFSTATEVALUE();
      if (!StringHelper.IsNullOrEmpty(this.strEntityWFState)) {
         String[] items = this.strEntityWFState.split("[;]");
         String[] var5 = items;
         int var4 = items.length;

         for (int var3 = 0; var3 < var4; var3++) {
            String strItem = var5[var3];
            if (!StringHelper.IsNullOrEmpty(strItem)) {
               this.entityWFStateMap.put(strItem, strItem);
            }
         }
      }

      this.strEntityWFErrorState = this.psWorkflow.getWFERRORVALUE();
      this.strEntityWFFinishState = this.psWorkflow.getWFFINISHEVALUE();
      this.strEntityWFCancelState = this.psWorkflow.getWFCANCELVALUE();
      this.psWFVersionGlobalModel = new PSWFVersionGlobalModel();
      this.psWFVersionGlobalModel.Init(this.getDAGlobalHelper(), this);
      this.psWFDEGlobalModel = new PSWFDEGlobalModel();
      this.psWFDEGlobalModel.Init(this.getDAGlobalHelper(), this);
      if (!StringHelper.IsNullOrEmpty(this.psWorkflow.getPSWXACCOUNTID())) {
         this.iPSWXAccount = this.getPSSystem().getPSWXAccount(this.psWorkflow.getPSWXACCOUNTID());
      }

      if (this.getPSWXAccount() != null && !StringHelper.IsNullOrEmpty(this.psWorkflow.getPSWXENTAPPID())) {
         this.iPSWXEntApp = this.getPSWXAccount().getPSWXEntApp(this.psWorkflow.getPSWXENTAPPID());
      }
   }

   @PSModelRTMeta(description = "逻辑名称", fields = "PSWORKFLOWNAME")
   @Override
   public String getLogicName() {
      return this.getName();
   }

   @PSModelRTMeta(description = "代码标识")
   @Override
   public String getCodeName() {
      return this.onGetCodeName();
   }

   protected String onGetCodeName() {
      return this.calcCodeName();
   }

   protected String calcCodeName() {
      return this.strCodeName;
   }

   @Override
   public IPSWFVersion getPSWFVersion(String strWFVersionId) throws Exception {
      return this.psWFVersionGlobalModel.FindModelHelper(strWFVersionId);
   }

   @PSModelRTMeta(description = "流程版本集合", child = true, dumpref = true, rtdump = 2, group = "基本", order = 135)
   @Override
   public Iterator<IPSWFVersion> getPSWFVersions() throws Exception {
      return this.psWFVersionGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "流程实体集合", child = true, dynamodelmode = 5, group = "基本", order = 130)
   @Override
   public Iterator<IPSWFDE> getPSWFDEs() throws Exception {
      return this.psWFDEGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "流程步骤代码表", fields = "WFSTEPCODELISTID")
   @Override
   public IPSCodeList getWFStepPSCodeList() {
      return this.wfStepPSCodeList;
   }

   @PSModelRTMeta(description = "业务状态代码表", fields = "STATECODELISTID")
   @Override
   public IPSCodeList getEntityStatePSCodeList() {
      return this.entityStatePSCodeList;
   }

   @PSModelRTMeta(description = "流程中业务状态集合")
   @Override
   public Iterator<String> getEntityWFStates() {
      return this.entityWFStateMap.keySet().iterator();
   }

   @PSModelRTMeta(description = "最新流程版本")
   @Override
   public IPSWFVersion getLastPSWFVersion() throws Exception {
      if (this.lastPSWFVersion != null) {
         return this.lastPSWFVersion;
      }

      Iterator<IPSWFVersion> psWFVersions = this.getPSWFVersions();
      if (psWFVersions == null) {
         return null;
      }

      while (psWFVersions.hasNext()) {
         IPSWFVersion iPSWFVersion = psWFVersions.next();
         if (this.lastPSWFVersion == null || iPSWFVersion.getWFVersion() > this.lastPSWFVersion.getWFVersion()) {
            this.lastPSWFVersion = iPSWFVersion;
         }
      }

      return this.lastPSWFVersion;
   }

   @Override
   public ISystemModel getSystemModel() {
      return null;
   }

   @Override
   public IEntity createEntity(String strDEName) throws Exception {
      return null;
   }

   @Override
   public ICodeList getWFStepCodeList() {
      return this.getWFStepPSCodeList();
   }

   @Override
   public ICodeList getEntityStateCodeList() {
      return this.getEntityStatePSCodeList();
   }

   @Override
   public IWFVersionModel getLastWFVersionModel() {
      return null;
   }

   @Override
   public IWFVersionModel getLastWFVersionModel(String strWFMode) throws Exception {
      return null;
   }

   @Override
   public IWFVersionModel getWFVersionModelByWFVersion(int nVersion) throws Exception {
      return null;
   }

   @Override
   public boolean isEntityWFState(String strWFState) {
      return this.entityWFStateMap.containsKey(strWFState);
   }

   @Override
   public IWFService getWFService() {
      return null;
   }

   @PSModelRTMeta(description = "实体流程中状态值", fields = "WFSTATEVALUE")
   @Override
   public String getEntityWFState() {
      return this.strEntityWFState;
   }

   @Override
   public IPSDEWF getPSDEWF(String strPSDEWFId) throws Exception {
      return this.psWFDEGlobalModel.FindModelHelper(strPSDEWFId);
   }

   @Override
   public IPSDEWF getPSDEWF(String strPSDEWFId, boolean bTryMode) throws Exception {
      return this.psWFDEGlobalModel.FindModelHelper(strPSDEWFId, bTryMode);
   }

   @Override
   public String getRemindMsgTemplId() {
      return this.strRemindMsgTemplId;
   }

   @PSModelRTMeta(description = "启用")
   @Override
   public boolean isValid() {
      return this.bValidFlag;
   }

   @PSModelRTMeta(description = "工作流编号", group = "基本", order = 105, fields = "WFSN")
   @Override
   public String getWFSN() {
      return this.psWorkflow.getWFSN();
   }

   @Override
   public String getModelType() {
      return "PSWORKFLOW";
   }

   @Override
   public void loadAll() throws Exception {
      this.getPSWFVersions();
      this.getPSSystemUtil().testPSModelLimit(this, "PSWFVERSION", this.psWFVersionGlobalModel.getAllModelHelperCount());
      this.psWFDEGlobalModel.getAllModelHelpers();
      this.psWFUIActionGlobalModel.getAllModelHelpers();
      this.psWFUIActionGroupGlobalModel.getAllModelHelpers();
   }

   @Override
   public String getWXAccountId() {
      return this.getPSWXAccount() == null ? null : this.getPSWXAccount().getId();
   }

   @Override
   public String getWXEntAppId() {
      return this.getPSWXEntApp() == null ? null : this.getPSWXEntApp().getId();
   }

   @PSModelRTMeta(description = "通知微信企业账号")
   @Override
   public IPSWXAccount getPSWXAccount() {
      return this.iPSWXAccount;
   }

   @PSModelRTMeta(description = "通知微信企业应用")
   @Override
   public IPSWXEntApp getPSWXEntApp() {
      return this.iPSWXEntApp;
   }

   @Override
   public Object getRuntimeId() {
      return this.getId();
   }

   @Override
   public void setRuntimeId(Object objId) {
   }

   @Override
   public boolean isEnableDynamicView() {
      return this.isDynamicWorkflow();
   }

   @PSModelRTMeta(description = "流程引擎类型", fields = "WFENGINETYPE")
   @Override
   public String getWFEngineType() {
      return this.strWFEngineType;
   }

   @PSModelRTMeta(description = "流程引擎类别")
   @Override
   public String getWFEngineCat() {
      return this.strWFEngineCat;
   }

   @Override
   public IWFVersionModel getWFVersionModel(String strWFVesionId) throws Exception {
      return null;
   }

   @Override
   public boolean isDynamicWorkflow() {
      return this.bDynamicWorkflow;
   }

   @PSModelRTMeta(description = "名称语言资源", hideempty = true, fields = "NAMEPSLANRESID")
   @Override
   public IPSLanguageRes getNamePSLanguageRes() {
      return this.namePSLanguageRes;
   }

   @Override
   public String getNameLanResTag() {
      return this.getNamePSLanguageRes() != null ? this.getNamePSLanguageRes().getLanResTag() : null;
   }

   @PSModelRTMeta(description = "系统模块", dumpref = true, hideempty = true, dynamodelmode = 4, fields = "PSMODULEID")
   @Override
   public IPSSystemModule getPSSystemModule() {
      return this.iPSSystemModule;
   }

   @PSModelRTMeta(description = "后台服务发布对象", hideempty = true)
   @Override
   public IPSSysSFPub getPSSysSFPub() {
      return this.getPSSystemModule() != null ? this.getPSSystemModule().getPSSysSFPub() : this.getPSSystem().getDefaultPSSysSFPub();
   }

   @PSModelRTMeta(description = "使用远程引擎", fields = "REMOTEENGINEFLAG")
   @Override
   public boolean isUseRemoteEngine() {
      return this.bUseRemoteEngine;
   }

   @PSModelRTMeta(description = "使用工作流代理应用")
   @Override
   public boolean isUseWFProxyApp() {
      return this.bUseWFProxyApp;
   }

   @Override
   public IPSWFUIAction getPSWFUIAction(String strDEUIActionId) throws Exception {
      return this.psWFUIActionGlobalModel.FindModelHelper(strDEUIActionId);
   }

   @Override
   public IPSWFUIAction getPSWFUIAction(String strDEUIActionId, boolean bTryMode) throws Exception {
      return this.psWFUIActionGlobalModel.FindModelHelper(strDEUIActionId, bTryMode);
   }

   @Override
   public void resetPSWFUIAction(String strDEUIActionId) throws Exception {
      this.psWFUIActionGlobalModel.ResetModel(strDEUIActionId);
   }

   @Override
   public Iterator<IPSWFUIAction> getAllPSWFUIActions() throws Exception {
      return this.psWFUIActionGlobalModel.getAllModelHelpers();
   }

   @Override
   public IPSWFUIActionGroup getPSWFUIActionGroup(String strDEUIActionGroupId) throws Exception {
      return this.psWFUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId);
   }

   @Override
   public IPSWFUIActionGroup getPSWFUIActionGroup(String strDEUIActionGroupId, boolean bTryMode) throws Exception {
      return this.psWFUIActionGroupGlobalModel.FindModelHelper(strDEUIActionGroupId, bTryMode);
   }

   @Override
   public void resetPSWFUIActionGroup(String strDEUIActionGroupId) throws Exception {
      this.psWFUIActionGroupGlobalModel.ResetModel(strDEUIActionGroupId);
   }

   @Override
   public String getDefaultDEName() {
      try {
         Iterator<IPSWFDE> psDEWFs = this.getPSWFDEs();
         return psDEWFs.hasNext() ? psDEWFs.next().getPSDataEntity().getName() : null;
      } catch (Exception ex) {
         log.error(StringHelper.Format("获取工作流默认实体名称发生异常，%1$s", ex.getMessage()), ex);
         return null;
      }
   }

   @PSModelRTMeta(description = "工作流代理模式", codelist = "WFProxyMode", fields = "WFPROXYMODE")
   @Override
   public int getWFProxyMode() {
      return this.nWFProxyMode;
   }

   @PSModelRTMeta(description = "应用工作流集合")
   @Override
   public Iterator<IPSAppWF> getPSAppWFs() throws Exception {
      if (this.psAppWFList == null) {
         ArrayList<IPSAppWF> psAppWFList = new ArrayList<>();
         Iterator<IPSApplication> psApplications = this.getPSSystem().getAllPSApps();
         if (psApplications != null) {
            while (psApplications.hasNext()) {
               IPSApplication iPSApplication = psApplications.next();
               Iterator<IPSAppWF> psAppWFs = iPSApplication.getAllPSAppWFs();
               if (psAppWFs != null) {
                  while (psAppWFs.hasNext()) {
                     IPSAppWF iPSAppWF = psAppWFs.next();
                     if (StringHelper.Compare(iPSAppWF.getPSWorkflow().getId(), this.getId(), false) == 0) {
                        psAppWFList.add(iPSAppWF);
                     }
                  }
               }
            }
         }

         if (this.psAppWFList == null) {
            this.psAppWFList = psAppWFList;
         }
      }

      return this.psAppWFList.iterator();
   }

   @PSModelRTMeta(description = "部署数据标识", dump = false)
   @Override
   public String getDeployId() {
      return this.getPSSystemModule() != null
         ? KeyValueHelper.genUniqueId(this.getPSSystemModule().getDeployId(), this.getCodeName())
         : KeyValueHelper.genUniqueId(this.getPSSystem().getDeployId(), this.getCodeName());
   }

   @PSModelRTMeta(description = "工作流类型", codelist = "WFType", fields = "WFTYPE")
   @Override
   public String getWFType() {
      return this.strWFType;
   }

   @Override
   protected int onGetDynaInstMode() {
      return this.nDynaInstMode;
   }

   @PSModelRTMeta(description = "实体流程结束状态值", fields = "WFFINISHEVALUE")
   @Override
   public String getEntityWFFinishState() {
      return this.strEntityWFFinishState;
   }

   @PSModelRTMeta(description = "实体流程错误状态值", fields = "WFERRORVALUE")
   @Override
   public String getEntityWFErrorState() {
      return this.strEntityWFErrorState;
   }

   @PSModelRTMeta(description = "实体流程取消状态值", fields = "WFCANCELVALUE")
   @Override
   public String getEntityWFCancelState() {
      return this.strEntityWFCancelState;
   }

   @PSModelRTMeta(description = "动态系统模式", codelist = "DynaSysMode", ignoredumpvalues = "0", fields = "ENABLEDYNASYS")
   @Override
   public int getDynaSysMode() {
      return this.nDynaSysMode;
   }

   @PSModelRTMeta(description = "流程分类代码", fields = "WFCATCODE")
   @Override
   public String getWFCatCode() {
      return this.psWorkflow.getWFCATCODE();
   }

   @PSModelRTMeta(description = "工作流唯一标记")
   @Override
   public String getUniqueTag() {
      if (this.getPSSystemModule() != null) {
         if (this.getPSSystemModule().getPSSysModelGroup() != null) {
            return String.format(
               "%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysModelGroup().getCodeName(), this.getPSSystemModule().getCodeName(), this.getCodeName()
            );
         } else {
            return this.getPSSystemModule().getPSSysRef() != null
               ? String.format(
                  "%1$s__%2$s__%3$s", this.getPSSystemModule().getPSSysRef().getSysRefTag(), this.getPSSystemModule().getCodeName(), this.getCodeName()
               )
               : String.format("%1$s__%2$s", this.getPSSystemModule().getCodeName(), this.getCodeName());
         }
      } else {
         return this.getCodeName();
      }
   }
}
