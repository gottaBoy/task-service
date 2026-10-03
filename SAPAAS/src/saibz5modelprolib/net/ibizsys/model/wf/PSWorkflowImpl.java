package net.ibizsys.model.wf;

import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.model.IPSModelStorageContext;
import net.ibizsys.model.IPSSystem;
import net.ibizsys.model.PSModelRTMeta;
import net.ibizsys.model.PSSystemObjectImpl;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.dataentity.wf.IPSDEWF;
import net.ibizsys.model.entity.PSWorkflow;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.sys.IPSSystemModule;
import net.ibizsys.paas.codelist.ICodeList;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.sysmodel.ISystemModel;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pswf.core.IWFService;
import net.ibizsys.pswf.core.IWFVersionModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSWorkflowImpl extends PSSystemObjectImpl implements IPSWorkflowRuntime {
   private static final Log log = LogFactory.getLog(PSWorkflowImpl.class);
   protected PSWorkflow psWorkflow;
   private String strCodeName = "";
   private PSWFVersionGlobalModel psWFVersionGlobalModel = null;
   private PSWFDEGlobalModel psWFDEGlobalModel = null;
   private IPSCodeList wfStepPSCodeList = null;
   private IPSCodeList entityStatePSCodeList = null;
   private HashMap<String, String> entityWFStateMap = new HashMap<>();
   private IPSWFVersion lastPSWFVersion = null;
   private String strEntityWFState = "";
   private String strRemindMsgTemplId = null;
   private boolean bValidFlag = true;
   private String strWFEngineCat = "EMBEDDED";
   private String strWFEngineType = "EMBEDDED";
   private boolean bDynamicWorkflow = false;
   private IPSLanguageRes namePSLanguageRes = null;
   private IPSSystemModule iPSSystemModule = null;
   private boolean bUseRemoteEngine = false;
   private int nWFProxyMode = 0;

   @Override
   public void init(IPSModelStorageContext iPSModelStorageContext, IPSSystem iPSSystem, PSWorkflow psWorkflow) throws Exception {
      this.setPSModelStorageContext(iPSModelStorageContext);
      this.setPSSystem(iPSSystem);
      this.psWorkflow = psWorkflow;
      this.setId(this.psWorkflow.getPSWORKFLOWID());
      this.setName(this.psWorkflow.getPSWORKFLOWNAME());
      this.setPSObjectData(this.psWorkflow);
      this.strCodeName = this.psWorkflow.getCODENAME();
      if (!this.psWorkflow.isWFPROXYMODENull()) {
         this.nWFProxyMode = this.psWorkflow.getWFPROXYMODE();
      }

      if (!StringHelper.isNullOrEmpty(this.psWorkflow.getWFSTEPCODELISTID())) {
         this.wfStepPSCodeList = iPSSystem.getPSCodeList(this.psWorkflow.getWFSTEPCODELISTID());
      }

      this.entityStatePSCodeList = iPSSystem.getPSCodeList(this.psWorkflow.getSTATECODELISTID());
      if (!StringHelper.isNullOrEmpty(this.psWorkflow.getREMINDPSSYSMSGTEMPLID())) {
         this.strRemindMsgTemplId = this.psWorkflow.getREMINDPSSYSMSGTEMPLID();
      }

      if (!this.psWorkflow.isVALIDFLAGNull()) {
         this.bValidFlag = this.psWorkflow.getVALIDFLAG();
      }

      if (!StringHelper.isNullOrEmpty(this.psWorkflow.getWFENGINETYPE())) {
         this.strWFEngineType = this.psWorkflow.getWFENGINETYPE();
      }

      this.strWFEngineCat = this.strWFEngineType;
      if (!this.psWorkflow.isENABLEDYNASYSNull()) {
         this.bDynamicWorkflow = this.psWorkflow.getENABLEDYNASYS();
      }

      if (!this.psWorkflow.isREMOTEENGINEFLAGNull()) {
         this.bUseRemoteEngine = this.psWorkflow.getREMOTEENGINEFLAG();
      }

      if (StringHelper.compare(this.getWFEngineCat(), "ACTIVITI", true) == 0 && this.isUseRemoteEngine()) {
         this.strWFEngineType = "ACTIVITI_REMOTE";
      }

      this.onInit();
   }

   @Override
   protected void onInit() throws Exception {
      super.onInit();
      if (!StringHelper.isNullOrEmpty(this.psWorkflow.getNAMEPSLANRESID())) {
         this.namePSLanguageRes = this.getPSSystem().getPSLanguageRes(this.psWorkflow.getNAMEPSLANRESID());
      }

      this.strEntityWFState = this.psWorkflow.getWFSTATEVALUE();
      if (!StringHelper.isNullOrEmpty(this.strEntityWFState)) {
         String[] items = this.strEntityWFState.split("[;]");
         String[] var5 = items;
         int var4 = items.length;

         for (int var3 = 0; var3 < var4; var3++) {
            String strItem = var5[var3];
            if (!StringHelper.isNullOrEmpty(strItem)) {
               this.entityWFStateMap.put(strItem, strItem);
            }
         }
      }

      this.psWFVersionGlobalModel = new PSWFVersionGlobalModel();
      this.psWFVersionGlobalModel.init(this.getPSModelStorageContext(), this);
      this.psWFDEGlobalModel = new PSWFDEGlobalModel();
      this.psWFDEGlobalModel.init(this.getPSModelStorageContext(), this);
   }

   @PSModelRTMeta(description = "逻辑名称")
   @Override
   public String getLogicName() {
      return this.getName();
   }

   @PSModelRTMeta(description = "代码名称")
   @Override
   public String getCodeName() {
      return this.strCodeName;
   }

   @Override
   public IPSWFVersion getPSWFVersion(String strWFVersionId) throws Exception {
      return this.psWFVersionGlobalModel.findModelHelper(strWFVersionId);
   }

   @PSModelRTMeta(description = "流程版本集合")
   @Override
   public Iterator<IPSWFVersion> getPSWFVersions() throws Exception {
      return this.psWFVersionGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "流程实体集合")
   @Override
   public Iterator<IPSDEWF> getPSWFDEs() throws Exception {
      return this.psWFDEGlobalModel.getAllModelHelpers();
   }

   @PSModelRTMeta(description = "流程步骤代码表")
   @Override
   public IPSCodeList getWFStepPSCodeList() {
      return this.wfStepPSCodeList;
   }

   @PSModelRTMeta(description = "业务状态代码表")
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

   @Override
   public String getEntityWFState() {
      return this.strEntityWFState;
   }

   @Override
   public IPSDEWF getPSDEWF(String strPSDEWFId) throws Exception {
      return this.psWFDEGlobalModel.findModelHelper(strPSDEWFId);
   }

   @Override
   public String getRemindMsgTemplId() {
      return this.strRemindMsgTemplId;
   }

   @PSModelRTMeta(description = "是否启用")
   @Override
   public boolean isValid() {
      return this.bValidFlag;
   }

   @PSModelRTMeta(description = "流程编号")
   @Override
   public String getWFSN() {
      return this.psWorkflow.getWFSN();
   }

   @Override
   public Object getRuntimeId() {
      return this.getId();
   }

   @Override
   public void setRuntimeId(Object objId) {
   }

   @PSModelRTMeta(description = "流程引擎类型")
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

   @PSModelRTMeta(description = "是否支持动态系统设计")
   @Override
   public boolean isDynamicWorkflow() {
      return this.bDynamicWorkflow;
   }

   @PSModelRTMeta(description = "名称语言资源", hideempty = true)
   @Override
   public IPSLanguageRes getNamePSLanguageRes() {
      return this.namePSLanguageRes;
   }

   @Override
   public String getNameLanResTag() {
      return this.getNamePSLanguageRes() != null ? this.getNamePSLanguageRes().getLanResTag() : null;
   }

   @PSModelRTMeta(description = "是否使用远程引擎")
   @Override
   public boolean isUseRemoteEngine() {
      return this.bUseRemoteEngine;
   }

   @Override
   public String getWXAccountId() {
      return null;
   }

   @Override
   public String getWXEntAppId() {
      return null;
   }

   @Override
   public String getDefaultDEName() {
      try {
         Iterator<IPSDEWF> psDEWFs = this.getPSWFDEs();
         return psDEWFs.hasNext() ? psDEWFs.next().getPSDataEntity().getName() : null;
      } catch (Exception ex) {
         log.error(StringHelper.format("获取工作流默认实体名称发生异常，%1$s", ex.getMessage()), ex);
         return null;
      }
   }

   @Override
   public int getWFProxyMode() {
      return this.nWFProxyMode;
   }
}
