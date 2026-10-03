package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSDynaInstSupportable;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSModelObjectLogger;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSModelObjectLoggerImpl;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BackService.IPSSysBackService;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DTS.IPSSysDTSQueue;
import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction;
import SA.SRFDA.PS.Core.DataEntity.Action.IPSDEActionGroup;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERBase;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DER.IPSSysDERGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRGroup;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem;
import SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDataRelation;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQueryCode;
import SA.SRFDA.PS.Core.DataEntity.DataFlow.IPSDEDataFlow;
import SA.SRFDA.PS.Core.DataEntity.DataSync.IPSDEDataSync;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.ER.IPSSysERMap;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSCodePublisherContextImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Core.Res.IPSSysContent;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.Res.IPSSysI18N;
import SA.SRFDA.PS.Core.Res.IPSSysLan;
import SA.SRFDA.PS.Core.Res.IPSSysSFPlugin;
import SA.SRFDA.PS.Core.Res.IPSSysSampleValue;
import SA.SRFDA.PS.Core.Res.IPSSysSequence;
import SA.SRFDA.PS.Core.Res.IPSSysTranslator;
import SA.SRFDA.PS.Core.Res.IPSSysUnit;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl;
import SA.SRFDA.PS.Core.SF.IPSSFLogicTempl2;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.IPSSFStyle2;
import SA.SRFDA.PS.Core.Search.IPSSysSearchScheme;
import SA.SRFDA.PS.Core.Security.IPSSysUserRole;
import SA.SRFDA.PS.Core.Service.IPSSubSysServiceAPI;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Core.System.IPSSystemModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestCase;
import SA.SRFDA.PS.Core.Testing.IPSSysTestData;
import SA.SRFDA.PS.Core.Testing.IPSSysTestModule;
import SA.SRFDA.PS.Core.Testing.IPSSysTestPrj;
import SA.SRFDA.PS.Core.UML.IPSSysActor;
import SA.SRFDA.PS.Core.UML.IPSSysUCMap;
import SA.SRFDA.PS.Core.UML.IPSSysUseCase;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.PS.Core.Util.PSAppStoryBoardHelper2;
import SA.SRFDA.PS.Core.ValueRule.IPSSysValueRule;
import SA.SRFDA.PS.Core.WF.IPSWFRole;
import SA.SRFDA.PS.Core.WF.IPSWFVersion;
import SA.SRFDA.PS.Core.WF.IPSWFWorkTime;
import SA.SRFDA.PS.Core.WF.IPSWorkflow;
import SA.SRFDA.PS.Core.WX.IPSWXAccount;
import SA.SRFDA.PS.Data.PSDevSln;
import SA.SRFramework.DataEx.CallResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.util.PSStudioEnvHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.DumperOptions.FlowStyle;

public class PubDynaInstModelPSSysDevBKTaskImpl extends PSSysDevBKTaskImplBase {
   private static final Log log = LogFactory.getLog(PubDynaInstModelPSSysDevBKTaskImpl.class);
   private String strCfgPath = null;
   private String strGroovySourcePath = null;
   private IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = null;
   private int nDynaInstMode = 1;
   private String strDynaInstTag = null;
   protected static String PSSF_DYNASYS = "DYNASYS";
   protected static String PSSF_DYNASYS_DEFAULT = "DYNASYS_DEFAULT";
   private Map<String, List<IPSSFLogicTempl>> psSFLogicTemplListMap = null;
   private IPSSystem iPSSystem = null;
   public static final String RTOBJECTNAME_GROOVY = "GROOVY";
   private List<PubDynaInstModelPSSysDevBKTaskImpl.DumpFile> dumpFileList = null;
   private List<Runnable> dumpRunnableList = new ArrayList<>();
   private boolean bRunDumpThread = false;
   protected static ObjectMapper DTOMAPPER = new ObjectMapper();

   static {
      DTOMAPPER.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
   }

   @Override
   protected String onRun() throws Exception {
      return this.generateModel();
   }

   protected String generateModel() throws Exception {
      this.preparePSSFLogicTempls();
      if (!StringHelper.isNullOrEmpty(this.psSysDevBKTask.getPSDYNAINSTID())) {
         this.iPSDevSlnSysDynaInst = this.getPSModelStorage().getPSDevSlnSysDynaInst(this.psSysDevBKTask.getPSDYNAINSTID());
         IPSDevSlnSys psDevSlnSysDynaInst = this.iPSDevSlnSysDynaInst.getPSDevSlnSys();
         PSDevSlnSysDynaInst psDevSlnSysDynaInstx = new PSDevSlnSysDynaInst();
         psDevSlnSysDynaInstx.setPSDevSlnSysDynaInstId(this.psSysDevBKTask.getPSDYNAINSTID());
         PSDevSlnSysDynaInstService psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(
            PSDevSlnSysDynaInstService.class, PSCoreSysServiceBase.getCurMajorSessionFactory()
         );
         psDevSlnSysDynaInstService.checkOutCfg(psDevSlnSysDynaInstx);
         this.strCfgPath = String.format(
            "%1$s%2$sCFG%2$s%3$s", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, psDevSlnSysDynaInstx.getPSDevSlnSysDynaInstId()
         );
         if (StringHelper.compare(this.iPSDevSlnSysDynaInst.getInstType(), "MODULE", false) == 0) {
            this.nDynaInstMode = 2;
            this.strDynaInstTag = this.iPSDevSlnSysDynaInst.getInstTag();
         }

         int nLastDynaModelPubMode = PSObjectImpl.getDynaModelPubMode();
         if (this.nDynaInstMode == 2) {
            PSObjectImpl.setDynaModelPubMode(2);
         } else {
            PSObjectImpl.setDynaModelPubMode(1);
         }

         String strRet = this.pubDynaInstModel();
         PSObjectImpl.setDynaModelPubMode(nLastDynaModelPubMode);
         psDevSlnSysDynaInstService.checkInCfg(psDevSlnSysDynaInstx);
         boolean bUploadCfg = false;
         if (bUploadCfg) {
            String strServerRoot = PSTaskServerEnvImpl.getCurrent().getTempFileServerUrl();
            String strServerHost = PSTaskServerEnvImpl.getCurrent().getTempFileServerAddr();
            int nServerPort = PSTaskServerEnvImpl.getCurrent().getTempFileServerPort();
            String strDynaInstFolder = String.format("dynamic/%1$s", psDevSlnSysDynaInstx.getPSDevSlnSysDynaInstId());
            String strCmd = "";
            if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
               strCmd = StringHelper.format(
                  "python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s %6$s",
                  PSTaskServerEnvImpl.getCurrent().getToolFolder(),
                  File.separator,
                  this.strCfgPath,
                  strServerHost,
                  nServerPort,
                  strDynaInstFolder
               );
            } else {
               strCmd = StringHelper.format(
                  "cmd.exe /c python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s %6$s",
                  PSTaskServerEnvImpl.getCurrent().getToolFolder(),
                  File.separator,
                  this.strCfgPath,
                  strServerHost,
                  nServerPort,
                  strDynaInstFolder
               );
            }

            String strResult = this.runBat(strCmd, true);
            Thread.sleep(2000L);
         }

         String strCallbackUrl = this.getCallbackUrl();
         if (!StringHelper.isNullOrEmpty(strCallbackUrl)) {
            String strCmd = "";
            if (PSTaskServerEnvImpl.getCurrent().isLinux()) {
               strCmd = StringHelper.format(
                  "python %1$s%2$spyutils%2$scurl.py %3$s", PSTaskServerEnvImpl.getCurrent().getToolFolder(), File.separator, strCallbackUrl
               );
            } else {
               strCmd = StringHelper.format(
                  "cmd.exe /c python %1$s%2$spyutils%2$scurl.py %3$s", PSTaskServerEnvImpl.getCurrent().getToolFolder(), File.separator, strCallbackUrl
               );
            }

            String var16 = this.runBat(strCmd, true);
         }

         return strRet;
      } else {
         throw new Exception(StringHelper.format("没有指定开发系统动态实例"));
      }
   }

   protected void preparePSSFLogicTempls() throws Exception {
      if (this.psSFLogicTemplListMap == null) {
         IPSSF iPSSF = this.getPSModelStorage().getPSSF(PSSF_DYNASYS, true);
         if (iPSSF != null) {
            IPSSFStyle iPSSFStyle = iPSSF.getPSSFStyle(PSSF_DYNASYS_DEFAULT, true);
            if (iPSSFStyle != null && iPSSFStyle instanceof IPSSFStyle2) {
               IPSSFStyle2 iPSSFStyle2 = (IPSSFStyle2)iPSSFStyle;
               Iterator<? extends IPSSFLogicTempl> psSFLogicTempls = iPSSFStyle2.getPSSFLogicTempls();
               if (psSFLogicTempls != null) {
                  this.psSFLogicTemplListMap = new HashMap<>();

                  while (psSFLogicTempls.hasNext()) {
                     IPSSFLogicTempl iPSSFLogicTempl = psSFLogicTempls.next();
                     List<IPSSFLogicTempl> list = this.psSFLogicTemplListMap.get(iPSSFLogicTempl.getName());
                     if (list == null) {
                        list = new ArrayList<>();
                        this.psSFLogicTemplListMap.put(iPSSFLogicTempl.getName(), list);
                     }

                     list.add(iPSSFLogicTempl);
                  }
               }
            }
         }
      }
   }

   protected String pubDynaInstModel() throws Exception {
      IPSDevSlnSys iPSDevSlnSys = this.iPSDevSlnSysDynaInst.getPSDevSlnSys();
      this.iPSSystem = iPSDevSlnSys.getPSSystem(false);
      if (this.iPSSystem.getLoadedLevel() < this.getModelLoadLevel()) {
         this.iPSSystem = iPSDevSlnSys.reloadPSSystem(this.getModelLoadLevel());
      }

      IPSModelObjectLogger lastPSModelObjectLogger = null;
      IPSSystemRuntime iPSSystemRuntime = null;

      try {
         iPSSystemRuntime = (IPSSystemRuntime)this.iPSSystem;
         lastPSModelObjectLogger = iPSSystemRuntime.getPSModelObjectLogger();
         String strLoggerName = StringHelper.format("动态模型");
         PSModelObjectLoggerImpl psModelObjectLoggerImpl = new PSModelObjectLoggerImpl(
            this.getRootPSSysDevBKTask(), this.iPSSystem.getPSDevCenterDomain(), strLoggerName, -1
         );
         iPSSystemRuntime.setPSModelObjectLogger(psModelObjectLoggerImpl);
         String strRet = this.pubDynaInstModel(this.iPSSystem);
         iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
         return strRet;
      } catch (Exception ex) {
         if (iPSSystemRuntime != null) {
            iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
         }

         throw ex;
      }
   }

   protected String pubDynaInstModel(IPSSystem iPSSystem) throws Exception {
      ArrayList<String> reloadAppIds = new ArrayList<>();
      Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();

      while (psApplications.hasNext()) {
         IPSApplication iPSApplication = psApplications.next();
         if (iPSApplication.isEnableDynaModel() && iPSApplication.getLoadedLevel() < this.getModelLoadLevel()) {
            reloadAppIds.add(iPSApplication.getId());
         }
      }

      for (String strPSSysAppId : reloadAppIds) {
         PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, this.getModelLoadLevel());
      }

      this.pubPSSystemModel(iPSSystem);
      return null;
   }

   protected void pubIBizModelFile(File file, IPSSystem iPSSystem, IPSSysSFPub iPSSysSFPub) throws Exception {
      Map<String, Object> map = new LinkedHashMap<>();
      map.put("modelfolder", iPSSysSFPub.getModelFolder());
      DumperOptions dumperOptions = new DumperOptions();
      dumperOptions.setDefaultFlowStyle(FlowStyle.BLOCK);
      Yaml yaml = new Yaml(dumperOptions);
      String strContent = yaml.dump(map);
      FileWriterHelper.write3(file, strContent);
   }

   protected void pubPSSystemModel(IPSSystem iPSSystem) throws Exception {
      if (this.iPSSystem == null) {
         this.iPSSystem = iPSSystem;
      }

      if (this.dumpFileList != null) {
         this.dumpFileList.clear();
      }

      if (this.dumpRunnableList != null) {
         this.dumpRunnableList.clear();
      }

      this.bRunDumpThread = true;

      for (int i = 0; i < this.getTaskThreadCount(); i++) {
         this.executeTask(new Runnable() {
            @Override
            public void run() {
               PubDynaInstModelPSSysDevBKTaskImpl.this.dumpRun();
            }
         });
      }

      long nStartTime = System.currentTimeMillis();

      try {
         PSObjectImpl.setDynaModelPubIgnorePF(false);
         if (!this.isCodeGenModelMode()) {
            PSObjectImpl.setDynaModelPubIgnorePF(true);
         }

         PSObjectImpl.setDynaModelPubIgnorePFReal(true);
         Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
         if (psApplications != null) {
            while (psApplications.hasNext()) {
               IPSApplication iPSApplication = psApplications.next();
               if (this.isCodeGenModelMode() || iPSApplication.isEnableDynaModel()) {
                  this.pubPSApplicationDynaInstModel(iPSApplication);
               }
            }
         }

         if (!this.isCodeGenModelMode()) {
            PSObjectImpl.setDynaModelPubIgnorePF(false);
         }

         PSObjectImpl.setDynaModelPubIgnorePFReal(false);
         PSObjectImpl.setDynaModelPubIgnorePF(false);
         if (this.nDynaInstMode == 1 || this.nDynaInstMode == 2) {
            this.pubPSModelObjectModel(iPSSystem);
         }

         Iterator<IPSSystemModule> psSystemModules = iPSSystem.getAllPSSystemModules();
         if (psSystemModules != null) {
            while (psSystemModules.hasNext()) {
               IPSSystemModule iPSSystemModule = psSystemModules.next();
               this.pubPSSystemModuleModel(iPSSystemModule);
            }
         }

         if (this.isCodeGenModelMode()) {
            Iterator<IPSSystemDBConfig> psSystemDBConfigs = iPSSystem.getAllPSSystemDBConfigs();
            if (psSystemDBConfigs != null) {
               while (psSystemDBConfigs.hasNext()) {
                  IPSSystemDBConfig iPSSystemDBConfig = psSystemDBConfigs.next();
                  this.pubPSModelObjectModel(iPSSystemDBConfig);
               }
            }

            Iterator<IPSSysSFPub> psSysSFPubs = iPSSystem.getAllPSSysSFPubs();
            if (psSysSFPubs != null) {
               while (psSysSFPubs.hasNext()) {
                  IPSSysSFPub iPSSysSFPub = psSysSFPubs.next();
                  this.pubPSModelObjectModel(iPSSysSFPub);
               }
            }

            Iterator<IPSSysSampleValue> psSysSampleValues = iPSSystem.getAllPSSysSampleValues();
            if (psSysSampleValues != null) {
               while (psSysSampleValues.hasNext()) {
                  IPSSysSampleValue iPSSysSampleValue = psSysSampleValues.next();
                  this.pubPSModelObjectModel(iPSSysSampleValue);
               }
            }

            Iterator<IPSSysUnit> psSysUnits = iPSSystem.getAllPSSysUnits();
            if (psSysUnits != null) {
               while (psSysUnits.hasNext()) {
                  IPSSysUnit iPSSysUnit = psSysUnits.next();
                  this.pubPSModelObjectModel(iPSSysUnit);
               }
            }

            Iterator<IPSSysReqModule> psSysReqModules = iPSSystem.getAllPSSysReqModules();
            if (psSysReqModules != null) {
               while (psSysReqModules.hasNext()) {
                  IPSSysReqModule iPSSysReqModule = psSysReqModules.next();
                  this.pubPSModelObjectModel(iPSSysReqModule);
               }
            }

            Iterator<IPSSysReqItem> psSysReqItems = iPSSystem.getAllPSSysReqItems();
            if (psSysReqItems != null) {
               while (psSysReqItems.hasNext()) {
                  IPSSysReqItem iPSSysReqItem = psSysReqItems.next();
                  this.pubPSModelObjectModel(iPSSysReqItem);
               }
            }

            Iterator<IPSSysActor> psSysActors = iPSSystem.getAllPSSysActors();
            if (psSysActors != null) {
               while (psSysActors.hasNext()) {
                  IPSSysActor iPSSysActor = psSysActors.next();
                  this.pubPSModelObjectModel(iPSSysActor);
               }
            }

            Iterator<IPSSysUseCase> psSysUseCases = iPSSystem.getAllPSSysUseCases();
            if (psSysUseCases != null) {
               while (psSysUseCases.hasNext()) {
                  IPSSysUseCase iPSSysUseCase = psSysUseCases.next();
                  this.pubPSModelObjectModel(iPSSysUseCase);
               }
            }

            Iterator<IPSSysUCMap> psSysUCMaps = iPSSystem.getAllPSSysUCMaps();
            if (psSysUCMaps != null) {
               while (psSysUCMaps.hasNext()) {
                  IPSSysUCMap iPSSysUCMap = psSysUCMaps.next();
                  this.pubPSModelObjectModel(iPSSysUCMap);
               }
            }

            Iterator<IPSSysERMap> psSysERMaps = iPSSystem.getAllPSSysERMaps();
            if (psSysERMaps != null) {
               while (psSysERMaps.hasNext()) {
                  IPSSysERMap iPSSysERMap = psSysERMaps.next();
                  this.pubPSModelObjectModel(iPSSysERMap);
               }
            }
         }

         if (this.nDynaInstMode == 1) {
            if (this.isCoreModelMode()) {
               Iterator<IPSSysBackService> psSysBackServices = iPSSystem.getAllPSSysBackServices();
               if (psSysBackServices != null) {
                  while (psSysBackServices.hasNext()) {
                     IPSSysBackService iPSSysBackService = psSysBackServices.next();
                     if (this.isCodeGenModelMode() || iPSSysBackService.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSysBackService);
                     }
                  }
               }

               Iterator<IPSSysDTSQueue> psSysDTSQueues = iPSSystem.getAllPSSysDTSQueues();
               if (psSysDTSQueues != null) {
                  while (psSysDTSQueues.hasNext()) {
                     IPSSysDTSQueue iPSSysDTSQueue = psSysDTSQueues.next();
                     if (this.isCodeGenModelMode() || iPSSysDTSQueue.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSysDTSQueue);
                     }
                  }
               }

               Iterator<IPSSysDBValueFunc> psSysDBValueFuncs = iPSSystem.getAllPSSysDBValueFuncs();
               if (psSysDBValueFuncs != null) {
                  while (psSysDBValueFuncs.hasNext()) {
                     IPSSysDBValueFunc iPSSysDBValueFunc = psSysDBValueFuncs.next();
                     if (this.isCodeGenModelMode() || iPSSysDBValueFunc.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSysDBValueFunc);
                     }
                  }
               }

               Iterator<IPSSysServiceAPI> psSysServiceAPIs = iPSSystem.getAllPSSysServiceAPIs();
               if (psSysServiceAPIs != null) {
                  while (psSysServiceAPIs.hasNext()) {
                     IPSSysServiceAPI iPSSysServiceAPI = psSysServiceAPIs.next();
                     if (this.isCodeGenModelMode() || iPSSysServiceAPI.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSysServiceAPI);
                     }
                  }
               }

               Iterator<IPSSubSysServiceAPI> psSubSysServiceAPIs = iPSSystem.getAllPSSubSysServiceAPIs();
               if (psSubSysServiceAPIs != null) {
                  while (psSubSysServiceAPIs.hasNext()) {
                     IPSSubSysServiceAPI iPSSubSysServiceAPI = psSubSysServiceAPIs.next();
                     if (this.isCodeGenModelMode() || iPSSubSysServiceAPI.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSubSysServiceAPI);
                     }
                  }
               }

               Iterator<IPSSysDBScheme> psSysDBSchemes = iPSSystem.getAllPSSysDBSchemes();
               if (psSysDBSchemes != null) {
                  while (psSysDBSchemes.hasNext()) {
                     IPSSysDBScheme iPSSysDBScheme = psSysDBSchemes.next();
                     if (this.isCodeGenModelMode() || iPSSysDBScheme.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSysDBScheme);
                     }
                  }
               }

               Iterator<IPSSysBDScheme> psSysBDSchemes = iPSSystem.getAllPSSysBDSchemes();
               if (psSysBDSchemes != null) {
                  while (psSysBDSchemes.hasNext()) {
                     IPSSysBDScheme iPSSysBDScheme = psSysBDSchemes.next();
                     if (this.isCodeGenModelMode() || iPSSysBDScheme.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSysBDScheme);
                     }
                  }
               }

               Iterator<IPSSysBIScheme> psSysBISchemes = iPSSystem.getAllPSSysBISchemes();
               if (psSysBISchemes != null) {
                  while (psSysBISchemes.hasNext()) {
                     IPSSysBIScheme iPSSysBIScheme = psSysBISchemes.next();
                     if (this.isCodeGenModelMode() || iPSSysBIScheme.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSysBIScheme);
                     }
                  }
               }

               Iterator<IPSSysAIFactory> psSysAIFactorys = iPSSystem.getAllPSSysAIFactories();
               if (psSysAIFactorys != null) {
                  while (psSysAIFactorys.hasNext()) {
                     IPSSysAIFactory iPSSysAIFactory = psSysAIFactorys.next();
                     if (this.isCodeGenModelMode() || iPSSysAIFactory.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSysAIFactory);
                     }
                  }
               }

               Iterator<IPSSysSearchScheme> psSysSearchSchemes = iPSSystem.getAllPSSysSearchSchemes();
               if (psSysSearchSchemes != null) {
                  while (psSysSearchSchemes.hasNext()) {
                     IPSSysSearchScheme iPSSysSearchScheme = psSysSearchSchemes.next();
                     if (this.isCodeGenModelMode() || iPSSysSearchScheme.isEnableDynaModel()) {
                        this.pubPSModelObjectModel(iPSSysSearchScheme);
                     }
                  }
               }

               Iterator<IPSCodeList> psCodeLists = iPSSystem.getAllPSCodeLists();
               if (psCodeLists != null) {
                  while (psCodeLists.hasNext()) {
                     IPSCodeList iPSCodeList = psCodeLists.next();
                     if (iPSCodeList.getPSSystemModule() == null && (this.isCodeGenModelMode() || iPSCodeList.isEnableDynaModel())) {
                        this.pubPSModelObjectModel(iPSCodeList);
                     }
                  }
               }

               Iterator<IPSWorkflow> psWorkflows = iPSSystem.getAllPSWorkflows();
               if (psWorkflows != null) {
                  while (psWorkflows.hasNext()) {
                     IPSWorkflow iPSWorkflow = psWorkflows.next();
                     if (iPSWorkflow.getPSSystemModule() == null && (this.isCodeGenModelMode() || iPSWorkflow.isEnableDynaModel())) {
                        this.pubPSWorkflowModel(iPSWorkflow);
                     }
                  }
               }

               Iterator<IPSSysTestPrj> psSysTestPrjs = iPSSystem.getAllPSSysTestPrjs();
               if (psSysTestPrjs != null) {
                  while (psSysTestPrjs.hasNext()) {
                     IPSSysTestPrj iPSSysTestPrj = psSysTestPrjs.next();
                     this.pubPSSysTestPrjModel(iPSSysTestPrj);
                  }
               }

               Iterator<IPSSysTestCase> psSysTestCases = iPSSystem.getAllPSSysTestCases();
               if (psSysTestCases != null) {
                  while (psSysTestCases.hasNext()) {
                     IPSSysTestCase iPSSysTestCase = psSysTestCases.next();
                     this.pubPSModelObjectModel(iPSSysTestCase);
                  }
               }

               Iterator<IPSSysTestData> psSysTestDatas = iPSSystem.getAllPSSysTestDatas();
               if (psSysTestDatas != null) {
                  while (psSysTestDatas.hasNext()) {
                     IPSSysTestData iPSSysTestData = psSysTestDatas.next();
                     this.pubPSModelObjectModel(iPSSysTestData);
                  }
               }

               Iterator<IPSSysContentCat> psSysContentCats = iPSSystem.getAllPSSysContentCats();
               if (psSysContentCats != null) {
                  while (psSysContentCats.hasNext()) {
                     IPSSysContentCat iPSSysContentCat = psSysContentCats.next();
                     this.pubPSModelObjectModel(iPSSysContentCat);
                  }
               }

               Iterator<IPSWXAccount> psWXAccounts = iPSSystem.getAllPSWXAccounts();
               if (psWXAccounts != null) {
                  while (psWXAccounts.hasNext()) {
                     IPSWXAccount iPSWXAccount = psWXAccounts.next();
                     this.pubPSModelObjectModel(iPSWXAccount);
                  }
               }

               Iterator<IPSSysDynaModel> psSysDynaModels = iPSSystem.getAllPSSysDynaModels();
               if (psSysDynaModels != null) {
                  while (psSysDynaModels.hasNext()) {
                     IPSSysDynaModel iPSSysDynaModel = psSysDynaModels.next();
                     this.pubPSModelObjectModel(iPSSysDynaModel);
                  }
               }
            }

            Iterator<IPSWFRole> psWFRoles = iPSSystem.getAllPSWFRoles();
            if (psWFRoles != null) {
               while (psWFRoles.hasNext()) {
                  IPSWFRole iPSWFRole = psWFRoles.next();
                  if (this.isCodeGenModelMode() || iPSWFRole.isEnableDynaModel()) {
                     this.pubPSModelObjectModel(iPSWFRole);
                  }
               }
            }

            Iterator<IPSWFWorkTime> psWFWorkTimes = iPSSystem.getAllPSWFWorkTimes();
            if (psWFWorkTimes != null) {
               while (psWFWorkTimes.hasNext()) {
                  IPSWFWorkTime iPSWFWorkTime = psWFWorkTimes.next();
                  if (this.isCodeGenModelMode() || iPSWFWorkTime.isEnableDynaModel()) {
                     this.pubPSModelObjectModel(iPSWFWorkTime);
                  }
               }
            }

            Iterator<IPSSysUserRole> psSysUserRoles = iPSSystem.getAllPSSysUserRoles();
            if (psSysUserRoles != null) {
               while (psSysUserRoles.hasNext()) {
                  IPSSysUserRole iPSSysUserRole = psSysUserRoles.next();
                  if (this.isCodeGenModelMode() || iPSSysUserRole.isEnableDynaModel()) {
                     this.pubPSModelObjectModel(iPSSysUserRole);
                  }
               }
            }

            Iterator<IPSSysValueRule> psSysValueRules = iPSSystem.getAllPSSysValueRules();
            if (psSysValueRules != null) {
               while (psSysValueRules.hasNext()) {
                  IPSSysValueRule iPSSysValueRule = psSysValueRules.next();
                  if (this.isCodeGenModelMode() || iPSSysValueRule.isEnableDynaModel()) {
                     this.pubPSModelObjectModel(iPSSysValueRule);
                  }
               }
            }

            Iterator<IPSSysSequence> psSysSequences = iPSSystem.getAllPSSysSequences();
            if (psSysSequences != null) {
               while (psSysSequences.hasNext()) {
                  IPSSysSequence iPSSysSequence = psSysSequences.next();
                  if (this.isCodeGenModelMode() || iPSSysSequence.isEnableDynaModel()) {
                     this.pubPSModelObjectModel(iPSSysSequence);
                  }
               }
            }

            Iterator<IPSSysTranslator> psSysTranslators = iPSSystem.getAllPSSysTranslators();
            if (psSysTranslators != null) {
               while (psSysTranslators.hasNext()) {
                  IPSSysTranslator iPSSysTranslator = psSysTranslators.next();
                  if (this.isCodeGenModelMode() || iPSSysTranslator.isEnableDynaModel()) {
                     this.pubPSModelObjectModel(iPSSysTranslator);
                  }
               }
            }

            Iterator<IPSSysLan> psSysLans = iPSSystem.getAllPSSysLans();
            if (psSysLans != null) {
               while (psSysLans.hasNext()) {
                  IPSSysLan iPSSysLan = psSysLans.next();
                  if (this.isCodeGenModelMode() || iPSSysLan.isEnableDynaModel()) {
                     this.pubPSModelObjectModel(iPSSysLan);
                  }
               }
            }

            Iterator<IPSSysI18N> psSysI18Ns = iPSSystem.getAllPSSysI18Ns();
            if (psSysI18Ns != null) {
               while (psSysI18Ns.hasNext()) {
                  IPSSysI18N iPSSysI18N = psSysI18Ns.next();
                  if (this.isCodeGenModelMode() || iPSSysI18N.isEnableDynaModel()) {
                     this.pubPSModelObjectModel(iPSSysI18N);
                  }
               }
            }

            Iterator<IPSSysDERGroup> psDERGroups = iPSSystem.getAllPSDERGroups();
            if (psDERGroups != null) {
               while (psDERGroups.hasNext()) {
                  IPSDERGroup iPSDERGroup = psDERGroups.next();
                  if (iPSDERGroup.isEnableDynaModel()) {
                     this.pubPSModelObjectModel(iPSDERGroup);
                  }
               }
            }
         }

         long nTime2 = System.currentTimeMillis() - nStartTime;
         if (this.dumpRunnableList != null) {
            while (true) {
               synchronized (this.dumpRunnableList) {
                  if (this.dumpRunnableList.size() == 0) {
                     break;
                  }
               }

               Thread.sleep(10L);
            }
         }

         long nTime3 = System.currentTimeMillis() - nStartTime;
         log.debug(String.format("发布动态模型耗时[%1$s + %2$s = %3$s]ms", nTime2, nTime3 - nTime2, nTime3));
         this.bRunDumpThread = false;
      } catch (Exception ex) {
         this.bRunDumpThread = false;
         throw ex;
      }
   }

   protected void pubPSSystemModuleModel(IPSSystemModule iPSSystemModule) throws Exception {
      if (this.nDynaInstMode == 2) {
         if (StringHelper.compare(iPSSystemModule.getDynaInstTag(), this.strDynaInstTag, false) == 0) {
            this.pubPSModelObjectModel(iPSSystemModule);
         }
      } else if (this.nDynaInstMode == 1) {
         this.pubPSModelObjectModel(iPSSystemModule);
      }

      Iterator<IPSCodeList> psCodeLists = iPSSystemModule.getAllPSCodeLists();
      if (psCodeLists != null) {
         while (psCodeLists.hasNext()) {
            IPSCodeList iPSCodeList = psCodeLists.next();
            if (this.isCodeGenModelMode()
               || iPSCodeList.isEnableDynaModel()
                  && (this.nDynaInstMode != 2 || StringHelper.compare(iPSCodeList.getDynaInstTag(), this.strDynaInstTag, false) == 0)) {
               this.pubPSModelObjectModel(iPSCodeList);
            }
         }
      }

      Iterator<IPSDataEntity> psDataEntities = iPSSystemModule.getAllPSDataEntities();
      if (psDataEntities != null) {
         while (psDataEntities.hasNext()) {
            IPSDataEntity iPSDataEntity = psDataEntities.next();
            if (this.isCodeGenModelMode()
               || iPSDataEntity.isEnableDynaModel()
                  && (this.nDynaInstMode != 2 || StringHelper.compare(iPSDataEntity.getDynaInstTag(), this.strDynaInstTag, false) == 0)) {
               this.pubPSDataEntityModel(iPSDataEntity);
            }
         }
      }

      Iterator<IPSWorkflow> psWorkflows = iPSSystemModule.getAllPSWorkflows();
      if (psWorkflows != null) {
         while (psWorkflows.hasNext()) {
            IPSWorkflow iPSWorkflow = psWorkflows.next();
            if (this.isCodeGenModelMode()
               || iPSWorkflow.isEnableDynaModel()
                  && (this.nDynaInstMode != 2 || StringHelper.compare(iPSWorkflow.getDynaInstTag(), this.strDynaInstTag, false) == 0)) {
               this.pubPSWorkflowModel(iPSWorkflow);
            }
         }
      }
   }

   protected void pubPSApplicationDynaInstModel(IPSApplication iPSApplication) throws Exception {
      if (this.nDynaInstMode == 1 || this.nDynaInstMode == 2) {
         this.pubPSModelObjectModel(iPSApplication);
         this.pubPSModelObjectModel2(iPSApplication, "SIMPLEAPP", false, "simple");
         this.pubPSModelObjectModel2(iPSApplication, "HUBSUBAPP", false, "hubsubapp");
      }

      Map<String, String> controlModelMap = new HashMap<>();
      Iterator<IPSAppView> psAppViews = iPSApplication.getAllPSAppViews();
      if (psAppViews != null) {
         while (psAppViews.hasNext()) {
            IPSAppView iPSAppView = psAppViews.next();
            if (this.isCodeGenModelMode()
               || iPSAppView.isEnableDynaModel()
                  && (this.nDynaInstMode != 2 || StringHelper.compare(iPSAppView.getDynaInstTag(), this.strDynaInstTag, false) == 0)) {
               this.pubPSAppViewModel(iPSAppView, controlModelMap);
            }
         }
      }

      Iterator<IPSAppDataEntity> psAppDataEntities = iPSApplication.getAllPSAppDataEntities();
      if (psAppDataEntities != null) {
         while (psAppDataEntities.hasNext()) {
            IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
            if (this.isCodeGenModelMode()
               || iPSAppDataEntity.isEnableDynaModel()
                  && (this.nDynaInstMode != 2 || StringHelper.compare(iPSAppDataEntity.getDynaInstTag(), this.strDynaInstTag, false) == 0)) {
               this.pubPSAppDataEntityModel(iPSAppDataEntity, controlModelMap);
            }
         }
      }

      Iterator<IPSAppCodeList> psAppCodeLists = iPSApplication.getAllPSAppCodeLists();
      if (psAppCodeLists != null) {
         while (psAppCodeLists.hasNext()) {
            IPSAppCodeList iPSAppCodeList = psAppCodeLists.next();
            if (this.isCodeGenModelMode()
               || iPSAppCodeList.isEnableDynaModel()
                  && (this.nDynaInstMode != 2 || StringHelper.compare(iPSAppCodeList.getDynaInstTag(), this.strDynaInstTag, false) == 0)) {
               this.pubPSModelObjectModel(iPSAppCodeList);
            }
         }
      }

      Iterator<IPSAppBIScheme> psAppBISchemes = iPSApplication.getAllPSAppBISchemes();
      if (psAppBISchemes != null) {
         while (psAppBISchemes.hasNext()) {
            IPSAppBIScheme iPSAppBIScheme = psAppBISchemes.next();
            if (this.isCodeGenModelMode() || iPSAppBIScheme.isEnableDynaModel()) {
               this.pubPSAppBISchemeModel(iPSAppBIScheme);
            }
         }
      }

      if (this.nDynaInstMode == 1) {
         Iterator<IPSAppMenuModel> psAppMenuModels = iPSApplication.getAllPSAppMenuModels();
         if (psAppMenuModels != null) {
            while (psAppMenuModels.hasNext()) {
               IPSAppMenuModel iPSAppMenuModel = psAppMenuModels.next();
               if (this.isCodeGenModelMode() || iPSAppMenuModel.isEnableDynaModel()) {
                  this.pubPSModelObjectModel(iPSAppMenuModel);
               }
            }
         }
      }

      if (this.nDynaInstMode == 1 || this.nDynaInstMode == 2) {
         Iterator<IPSAppLan> psAppLans = iPSApplication.getAllPSAppLans();
         if (psAppLans != null) {
            while (psAppLans.hasNext()) {
               IPSAppLan iPSAppLan = psAppLans.next();
               if (this.isCodeGenModelMode() || iPSAppLan.isEnableDynaModel()) {
                  this.pubPSModelObjectModel(iPSAppLan);
               }
            }
         }
      }

      if (this.isCodeGenModelMode()) {
         Iterator<IPSAppModule> psAppModules = iPSApplication.getAllPSAppModules();
         if (psAppModules != null) {
            while (psAppModules.hasNext()) {
               IPSAppModule iPSAppModule = psAppModules.next();
               this.pubPSModelObjectModel(iPSAppModule);
            }
         }

         Iterator<IPSAppCounter> psAppCounters = iPSApplication.getAllPSAppCounters();
         if (psAppCounters != null) {
            while (psAppCounters.hasNext()) {
               IPSAppCounter iPSAppCounter = psAppCounters.next();
               this.pubPSModelObjectModel(iPSAppCounter);
            }
         }
      }
   }

   protected void pubPSAppDataEntityModel(IPSAppDataEntity iPSAppDataEntity, Map<String, String> controlModelMap) throws Exception {
      this.pubPSModelObjectModel(iPSAppDataEntity);
      Iterator<IPSAppDELogic> psAppDELogics = iPSAppDataEntity.getAllPSAppDELogics();
      if (psAppDELogics != null) {
         while (psAppDELogics.hasNext()) {
            IPSAppDELogic iPSAppDELogic = psAppDELogics.next();
            this.pubPSModelObjectModel(iPSAppDELogic);
         }
      }

      Iterator<IPSAppDEUILogic> psAppDEUILogics = iPSAppDataEntity.getAllPSAppDEUILogics();
      if (psAppDEUILogics != null) {
         while (psAppDEUILogics.hasNext()) {
            IPSAppDEUILogic iPSAppDEUILogic = psAppDEUILogics.next();
            this.pubPSModelObjectModel(iPSAppDEUILogic);
         }
      }

      Iterator<IPSControl> psControls = iPSAppDataEntity.getPSControls();
      if (psControls != null) {
         while (psControls.hasNext()) {
            IPSControl iPSControl = psControls.next();
            String strFilePath = iPSControl.getDynaModelFilePath();
            if (!StringHelper.isNullOrEmpty(strFilePath) && !controlModelMap.containsKey(strFilePath)) {
               this.pubPSModelObjectModel(iPSControl, "SINGLE", false);
               controlModelMap.put(strFilePath, "");
            }
         }
      }
   }

   protected void pubPSAppViewModel(IPSAppView iPSAppView, Map<String, String> controlModelMap) throws Exception {
      if (iPSAppView.isEnableDynaModel()) {
         this.pubPSModelObjectModel(iPSAppView);
      }

      ArrayList<IPSControl> psControls = iPSAppView.getAllPSControls();
      if (psControls != null) {
         for (IPSControl iPSControl : psControls) {
            String strFilePath = iPSControl.getDynaModelFilePath();
            if (!StringHelper.isNullOrEmpty(strFilePath) && !controlModelMap.containsKey(strFilePath)) {
               this.pubPSModelObjectModel(iPSControl, "SINGLE", false);
               controlModelMap.put(strFilePath, "");
            }
         }
      }
   }

   protected void pubPSAppBISchemeModel(IPSAppBIScheme iPSAppBIScheme) throws Exception {
      if (iPSAppBIScheme.isEnableDynaModel()) {
         this.pubPSModelObjectModel(iPSAppBIScheme);
      }
   }

   protected void pubPSDataEntityModel(IPSDataEntity iPSDataEntity) throws Exception {
      this.pubPSModelObjectModel(iPSDataEntity);
      Iterator<IPSDEAction> psDEActions = iPSDataEntity.getAllPSDEActions();
      if (psDEActions != null) {
         while (psDEActions.hasNext()) {
            IPSDEAction iPSDEAction = psDEActions.next();
            this.pubPSModelObjectModel(iPSDEAction);
         }
      }

      Iterator<IPSDELogic> psDELogics = iPSDataEntity.getAllPSDELogics();
      if (psDELogics != null) {
         while (psDELogics.hasNext()) {
            IPSDELogic iPSDELogic = psDELogics.next();
            this.pubPSModelObjectModel(iPSDELogic);
         }
      }

      Iterator<IPSDEDataSync> psDEDataSyncs = iPSDataEntity.getAllPSDEDataSyncs();
      if (psDEDataSyncs != null) {
         while (psDEDataSyncs.hasNext()) {
            IPSDEDataSync iPSDEDataSync = psDEDataSyncs.next();
            this.pubPSModelObjectModel(iPSDEDataSync);
         }
      }

      Iterator<IPSDERBase> majorPSDERs = iPSDataEntity.getMajorPSDERs();
      if (majorPSDERs != null) {
         while (majorPSDERs.hasNext()) {
            IPSDERBase iPSDERBase = majorPSDERs.next();
            this.pubPSModelObjectModel(iPSDERBase);
         }
      }

      Iterator<IPSDERBase> minorPSDERs = iPSDataEntity.getMinorPSDERs();
      if (minorPSDERs != null) {
         while (minorPSDERs.hasNext()) {
            IPSDERBase iPSDERBase = minorPSDERs.next();
            this.pubPSModelObjectModel(iPSDERBase);
         }
      }

      Iterator<IPSDEPrint> psDEPrints = iPSDataEntity.getAllPSDEPrints();
      if (psDEPrints != null) {
         while (psDEPrints.hasNext()) {
            IPSDEPrint iPSDEPrint = psDEPrints.next();
            this.pubPSModelObjectModel(iPSDEPrint);
         }
      }

      Iterator<IPSDEReport> psDEReports = iPSDataEntity.getAllPSDEReports();
      if (psDEReports != null) {
         while (psDEReports.hasNext()) {
            IPSDEReport iPSDEReport = psDEReports.next();
            this.pubPSModelObjectModel(iPSDEReport);
         }
      }

      if ((PSObjectImpl.getDynaModelPubMode() & 4) != 0) {
         Iterator<IPSDEUserRole> psDEUserRoles = iPSDataEntity.getAllPSDEUserRoles();
         if (psDEUserRoles != null) {
            while (psDEUserRoles.hasNext()) {
               IPSDEUserRole iPSDEUserRole = psDEUserRoles.next();
               this.pubPSModelObjectModel(iPSDEUserRole);
            }
         }

         Iterator<IPSDEDataFlow> psDEDataFlows = iPSDataEntity.getAllPSDEDataFlows();
         if (psDEDataFlows != null) {
            while (psDEDataFlows.hasNext()) {
               IPSDEDataFlow iPSDEDataFlow = psDEDataFlows.next();
               this.pubPSModelObjectModel(iPSDEDataFlow);
            }
         }

         Iterator<IPSDEMSLogic> psDEMSLogics = iPSDataEntity.getAllPSDEMSLogics();
         if (psDEMSLogics != null) {
            while (psDEMSLogics.hasNext()) {
               IPSDEMSLogic iPSDEMSLogic = psDEMSLogics.next();
               this.pubPSModelObjectModel(iPSDEMSLogic);
            }
         }

         Iterator<IPSDEDataQuery> psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
         if (psDEDataQueries != null) {
            while (psDEDataQueries.hasNext()) {
               IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
               Iterator<IPSDEDataQueryCode> psDEDataQueryCodes = iPSDEDataQuery.getAllPSDEDataQueryCodes();
               if (psDEDataQueryCodes != null) {
                  while (psDEDataQueryCodes.hasNext()) {
                     IPSDEDataQueryCode iPSDEDataQueryCode = psDEDataQueryCodes.next();
                     this.pubPSModelObjectModel(iPSDEDataQueryCode);
                  }
               }
            }
         }

         Iterator<IPSDEFGroup> psDEFGroups = iPSDataEntity.getAllPSDEFGroups();
         if (psDEFGroups != null) {
            while (psDEFGroups.hasNext()) {
               IPSDEFGroup iPSDEFGroup = psDEFGroups.next();
               this.pubPSModelObjectModel(iPSDEFGroup);
            }
         }

         Iterator<IPSDEDRItem> psDEDRItems = iPSDataEntity.getAllPSDEDRItems();
         if (psDEDRItems != null) {
            while (psDEDRItems.hasNext()) {
               IPSDEDRItem iPSDEDRItem = psDEDRItems.next();
               this.pubPSModelObjectModel(iPSDEDRItem);
            }
         }

         Iterator<IPSDEDRGroup> psDEDRGroups = iPSDataEntity.getAllPSDEDRGroups();
         if (psDEDRGroups != null) {
            while (psDEDRGroups.hasNext()) {
               IPSDEDRGroup iPSDEDRGroup = psDEDRGroups.next();
               this.pubPSModelObjectModel(iPSDEDRGroup);
            }
         }

         Iterator<IPSDEDataRelation> psDEDataRelations = iPSDataEntity.getAllPSDEDataRelations();
         if (psDEDataRelations != null) {
            while (psDEDataRelations.hasNext()) {
               IPSDEDataRelation iPSDEDataRelation = psDEDataRelations.next();
               this.pubPSModelObjectModel(iPSDEDataRelation);
            }
         }
      }

      if (this.isCodeGenModelMode()) {
         Iterator<IPSDEGroup> psDEGroups = iPSDataEntity.getAllPSDEGroups();
         if (psDEGroups != null) {
            while (psDEGroups.hasNext()) {
               IPSDEGroup iPSDEGroup = psDEGroups.next();
               this.pubPSModelObjectModel(iPSDEGroup);
            }
         }

         Iterator<IPSDERGroup> psDERGroups = iPSDataEntity.getAllPSDERGroups();
         if (psDERGroups != null) {
            while (psDERGroups.hasNext()) {
               IPSDERGroup iPSDERGroup = psDERGroups.next();
               this.pubPSModelObjectModel(iPSDERGroup);
            }
         }

         Iterator<IPSDEActionGroup> psDEActionGroups = iPSDataEntity.getAllPSDEActionGroups();
         if (psDEActionGroups != null) {
            while (psDEActionGroups.hasNext()) {
               IPSDEActionGroup iPSDEActionGroup = psDEActionGroups.next();
               this.pubPSModelObjectModel(iPSDEActionGroup);
            }
         }
      }
   }

   protected void pubPSWorkflowModel(IPSWorkflow iPSWorkflow) throws Exception {
      this.pubPSModelObjectModel(iPSWorkflow);
      Iterator<IPSWFVersion> psWFVersions = iPSWorkflow.getPSWFVersions();
      if (psWFVersions != null) {
         while (psWFVersions.hasNext()) {
            IPSWFVersion iPSWFVersion = psWFVersions.next();
            if (this.isCodeGenModelMode() || iPSWFVersion.isEnableDynaModel()) {
               this.pubPSModelObjectModel(iPSWFVersion);
            }
         }
      }
   }

   protected void pubPSSysTestPrjModel(IPSSysTestPrj iPSSysTestPrj) throws Exception {
      this.pubPSModelObjectModel(iPSSysTestPrj);
      Iterator<IPSSysTestModule> psSysTestModules = iPSSysTestPrj.getPSSysTestModules();
      if (psSysTestModules != null) {
         while (psSysTestModules.hasNext()) {
            IPSSysTestModule iPSSysTestModule = psSysTestModules.next();
            Iterator<IPSSysTestCase> psSysTestCases = iPSSysTestModule.getPSSysTestCases();
            if (psSysTestCases != null) {
               while (psSysTestCases.hasNext()) {
                  IPSSysTestCase iPSSysTestCase = psSysTestCases.next();
                  this.pubPSModelObjectModel(iPSSysTestCase);
               }
            }
         }
      }
   }

   protected void pubPSAppStoreBoardModel(IPSApplication iPSApplication) throws Exception {
      Map<String, PSAppSBItem> psAppSBItemMap = new HashMap<>();
      List<PSAppSBItemRS> psAppSBItemRSList = new ArrayList<>();
      ObjectNode objectNode = JsonNodeHelper.createObjectNode();
      ArrayNode psAppSBItems = objectNode.putArray("psappsbitems");
      ArrayNode psAppSBItemRSs = objectNode.putArray("psappsbitemrses");
      PSAppStoryBoard psAppStoryBoard = new PSAppStoryBoard();
      IPSAppView defaultPSAppView = iPSApplication.getDefaultPSAppView();
      if (defaultPSAppView != null) {
         PSAppStoryBoardHelper2 psAppStoryBoardHelper = new PSAppStoryBoardHelper2();
         psAppStoryBoardHelper.getPSAppSBItem(defaultPSAppView, false, psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);

         for (PSAppSBItem psAppSBItem : psAppSBItemMap.values()) {
            if (!DataObject.getBoolValue(psAppSBItem.getUserFlag(), false)) {
               if (StringHelper.compare(psAppSBItem.getItemType(), "APPVIEW", false) == 0 && defaultPSAppView.getId().equals(psAppSBItem.getPSAppViewId())) {
                  psAppSBItem.setRootItem(1);
                  JsonNodeHelper.put(objectNode, "rootitem", psAppSBItem.getPSAppSBItemId());
               }

               HashMap<String, Object> params = new HashMap<>();
               psAppSBItem.fillMap(params, false);
               ObjectNode itemNode = psAppSBItems.addObject();

               for (Entry<String, Object> entry : params.entrySet()) {
                  if (entry.getValue() != null) {
                     JsonNodeHelper.put(itemNode, entry.getKey().toLowerCase(), entry.getValue());
                  }
               }
            }
         }

         for (PSAppSBItemRS psAppSBItemRS : psAppSBItemRSList) {
            HashMap<String, Object> params = new HashMap<>();
            psAppSBItemRS.fillMap(params, false);
            ObjectNode itemRSNode = psAppSBItemRSs.addObject();

            for (Entry<String, Object> entry : params.entrySet()) {
               if (entry.getValue() != null) {
                  JsonNodeHelper.put(itemRSNode, entry.getKey().toLowerCase(), entry.getValue());
               }
            }
         }
      }

      String strFilePath = iPSApplication.getDynaModelFilePath();
      if (StringHelper.isNullOrEmpty(strFilePath)) {
         log.error(String.format("无法输出模型对象[%1$s][%2$s|%3$s]动态模型，没有定义模型路径", iPSApplication.getModelType(), iPSApplication.getName(), iPSApplication.getId()));
      } else {
         strFilePath = strFilePath.substring(0, strFilePath.length() - 5);
         strFilePath = strFilePath + ".storyboard.json";
         File file = new File(this.strCfgPath + File.separator + strFilePath);
         File parentFolder = file.getParentFile();
         if (parentFolder != null && !parentFolder.exists()) {
            parentFolder.mkdirs();
         }

         String strCode = DTOMAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);
         FileWriterHelper.write(file.getCanonicalPath(), strCode);
      }
   }

   protected void pubPSModelObjectModel(IPSModelObject iPSModelObject) throws Exception {
      this.pubPSModelObjectModel(iPSModelObject, null, false);
   }

   protected void pubPSModelObjectModel(IPSModelObject iPSModelObject, boolean bUserModelOnly) throws Exception {
      this.pubPSModelObjectModel(iPSModelObject, null, bUserModelOnly);
   }

   protected void pubPSModelObjectModel(IPSModelObject iPSModelObject, String strType, boolean bUserModelOnly) throws Exception {
      final IPSModelObject iPSModelObject2 = iPSModelObject;
      final String strType2 = strType;
      final boolean bUserModelOnly2 = bUserModelOnly;
      final int nDynaModelPubMode2 = PSObjectImpl.getDynaModelPubMode();
      final boolean bDynaModelPubIgnorePF2 = PSObjectImpl.getDynaModelPubIgnorePF();
      final boolean bDynaModelPubIgnorePFReal2 = PSObjectImpl.getDynaModelPubIgnorePFReal();
      synchronized (this.dumpRunnableList) {
         this.dumpRunnableList.add(new Runnable() {
            @Override
            public void run() {
               int nDynaModelPubMode = PSObjectImpl.getDynaModelPubMode();
               boolean bDynaModelPubIgnorePF = PSObjectImpl.getDynaModelPubIgnorePF();
               boolean bDynaModelPubIgnorePFReal = PSObjectImpl.getDynaModelPubIgnorePFReal();
               PSObjectImpl.setDynaModelPubMode(nDynaModelPubMode2);
               PSObjectImpl.setDynaModelPubIgnorePF(bDynaModelPubIgnorePF2);
               PSObjectImpl.setDynaModelPubIgnorePFReal(bDynaModelPubIgnorePFReal2);

               try {
                  PubDynaInstModelPSSysDevBKTaskImpl.this.pubPSModelObjectModel2(iPSModelObject2, strType2, bUserModelOnly2, null);
               } catch (Exception ex) {
                  PubDynaInstModelPSSysDevBKTaskImpl.log.debug(ex);
               } finally {
                  PSObjectImpl.setDynaModelPubMode(nDynaModelPubMode);
                  PSObjectImpl.setDynaModelPubIgnorePF(bDynaModelPubIgnorePF);
                  PSObjectImpl.setDynaModelPubIgnorePFReal(bDynaModelPubIgnorePFReal);
               }
            }
         });
      }
   }

   protected void pubPSModelObjectModel2(IPSModelObject iPSModelObject, String strType, boolean bUserModelOnly, String strAppend) throws Exception {
      IPSDynaInstSupportable iPSDynaInstSupportable = null;
      if (iPSModelObject instanceof IPSDynaInstSupportable) {
         iPSDynaInstSupportable = (IPSDynaInstSupportable)iPSModelObject;
         String strFilePath = iPSDynaInstSupportable.getDynaModelFilePath();
         if (StringHelper.isNullOrEmpty(strFilePath)) {
            log.error(String.format("无法输出模型对象[%1$s][%2$s|%3$s]动态模型，没有定义模型路径", iPSModelObject.getModelType(), iPSModelObject.getName(), iPSModelObject.getId()));
         } else {
            if (!StringHelper.isNullOrEmpty(strAppend)) {
               strFilePath = strFilePath.substring(0, strFilePath.length() - 4);
               strFilePath = strFilePath + strAppend.toLowerCase();
               strFilePath = strFilePath + ".json";
            }

            PSObjectImpl.resetModelExportMap();
            ObjectNode objNode = iPSModelObject.toModel(strType);
            if (objNode == null) {
               log.error(String.format("无法输出模型对象[%1$s][%2$s|%3$s]动态模型，没有返回内容", iPSModelObject.getModelType(), iPSModelObject.getName(), iPSModelObject.getId()));
            } else {
               File file = new File(this.strCfgPath + File.separator + strFilePath);
               if (!bUserModelOnly) {
                  if (iPSModelObject instanceof IPSSysContentCat) {
                     JsonNode jsonNode = objNode.get("getPSSysContents");
                     if (jsonNode instanceof ArrayNode) {
                        ArrayNode arrayNode = (ArrayNode)jsonNode;
                        int nSize = arrayNode.size();

                        for (int i = 0; i < nSize; i++) {
                           ObjectNode contentNode = (ObjectNode)arrayNode.get(i);
                           if (contentNode.has("content")) {
                              contentNode.remove("content");
                              contentNode.put("_file", true);
                           }
                        }
                     }

                     IPSSysContentCat iPSSysContentCat = (IPSSysContentCat)iPSModelObject;
                     Iterator<IPSSysContent> psSysContents = iPSSysContentCat.getPSSysContents();
                     if (psSysContents != null) {
                        while (psSysContents.hasNext()) {
                           IPSSysContent iPSSysContent = psSysContents.next();
                           if (!StringHelper.isNullOrEmpty(iPSSysContent.getCodeName())) {
                              String strCode = iPSSysContent.getContent();
                              String strContentFilePath = String.format("%1$s.%2$s.txt", file.getCanonicalPath(), iPSSysContent.getCodeName().toLowerCase());
                              File file2 = new File(strContentFilePath);
                              if (!StringHelper.isNullOrEmpty(strCode)) {
                                 FileWriterHelper.write3(file2, strCode);
                              } else if (file2.exists()) {
                                 file2.delete();
                              }
                           }
                        }
                     }
                  }

                  if (!StringHelper.isNullOrEmpty(this.getGroovySourcePath()) && this.nDynaInstMode == 1 && iPSModelObject instanceof IPSSystem) {
                     IPSSystem iPSSystem = (IPSSystem)iPSModelObject;
                     boolean bPubSFPluginCodeFile = false;
                     if (iPSSystem.getDefaultPSSysSFPub() != null) {
                        bPubSFPluginCodeFile = iPSSystem.getDefaultPSSysSFPub().isPubSFPluginCodeFile();
                     }

                     Map<String, ObjectNode> psSysSFPluginNodeMap = new HashMap<>();
                     if (bPubSFPluginCodeFile) {
                        JsonNode jsonNode = objNode.get("getAllPSSysSFPlugins");
                        if (jsonNode instanceof ArrayNode) {
                           ArrayNode arrayNode = (ArrayNode)jsonNode;
                           int nSize = arrayNode.size();

                           for (int i = 0; i < nSize; i++) {
                              ObjectNode contentNode = (ObjectNode)arrayNode.get(i);
                              if (contentNode.has("dynaModelFilePath")) {
                                 String strFilePath2 = contentNode.get("dynaModelFilePath").asText();
                                 if (!StringHelper.isNullOrEmpty(strFilePath2)) {
                                    psSysSFPluginNodeMap.put(strFilePath2, contentNode);
                                 }
                              }
                           }
                        }
                     }

                     Iterator<IPSSysSFPlugin> psSysSFPlugins = iPSSystem.getAllPSSysSFPlugins();
                     if (psSysSFPlugins != null) {
                        while (psSysSFPlugins.hasNext()) {
                           IPSSysSFPlugin iPSSysSFPlugin = psSysSFPlugins.next();
                           if (iPSSysSFPlugin.isRuntimeObject()) {
                              if (bPubSFPluginCodeFile) {
                                 String strFilePath2 = iPSSysSFPlugin.getDynaModelFilePath();
                                 if (!StringHelper.isNullOrEmpty(strFilePath2)) {
                                    File file2 = new File(this.strCfgPath + File.separator + strFilePath2);
                                    ObjectNode contentNode = psSysSFPluginNodeMap.get(strFilePath2);
                                    String strCode = null;
                                    if (contentNode != null) {
                                       strCode = iPSSysSFPlugin.isTemplateMode() ? iPSSysSFPlugin.getRealCode() : iPSSysSFPlugin.getTemplCode();
                                       if (contentNode.has("templCode")) {
                                          contentNode.remove("templCode");
                                          contentNode.put("_file", true);
                                       }
                                    }

                                    String strContentFilePath = String.format("%1$s.txt", file2.getCanonicalPath());
                                    File file3 = new File(strContentFilePath);
                                    if (!StringHelper.isNullOrEmpty(strCode)) {
                                       FileWriterHelper.write3(file3, strCode);
                                    } else if (file3.exists()) {
                                       file3.delete();
                                    }
                                 } else {
                                    log.error(String.format("无法输出后台插件[%1$s|%2$s]代码文件，没有定义模型路径", iPSSysSFPlugin.getName(), iPSSysSFPlugin.getId()));
                                 }
                              }

                              String strRTObjectName = iPSSysSFPlugin.getRTObjectName();
                              if (!StringHelper.isNullOrEmpty(strRTObjectName)) {
                                 if (strRTObjectName.indexOf("GROOVY") == 0) {
                                    if (strRTObjectName.length() > "GROOVY".length() + 1) {
                                       strRTObjectName = strRTObjectName.substring("GROOVY".length() + 1);
                                    } else {
                                       strRTObjectName = null;
                                    }
                                 }

                                 if (!StringHelper.isNullOrEmpty(strRTObjectName) && strRTObjectName.indexOf(".") != -1) {
                                    String strGroovyFilePath = this.getGroovySourcePath()
                                       + File.separator
                                       + strRTObjectName.replace(".", File.separator)
                                       + ".groovy";
                                    String strCode = iPSSysSFPlugin.isTemplateMode() ? iPSSysSFPlugin.getRealCode() : iPSSysSFPlugin.getTemplCode();
                                    File file2 = new File(strGroovyFilePath);
                                    if (!StringHelper.isNullOrEmpty(strCode)) {
                                       FileWriterHelper.write3(file2, strCode);
                                    } else if (file2.exists()) {
                                       file2.delete();
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (this.dumpFileList == null) {
                     String strCode = DTOMAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(objNode);
                     boolean bRet = FileWriterHelper.write3(file, strCode);
                     if (strCode.length() >= 1048576) {
                        if (bRet) {
                           log.debug(String.format("文件[%1$s][%2$s]内容没有变化", file.getCanonicalPath(), strCode.length()));
                        } else {
                           log.debug(String.format("文件[%1$s][%2$s]内容有变化", file.getCanonicalPath(), strCode.length()));
                        }
                     }
                  } else {
                     synchronized (this.dumpFileList) {
                        this.dumpFileList.add(new PubDynaInstModelPSSysDevBKTaskImpl.DumpFile(file, objNode));
                     }
                  }
               }

               if (this.psSFLogicTemplListMap != null) {
                  String strName = String.format("@LOGIC/@MODEL/%1$s", iPSModelObject.getDumpModelType());
                  List<IPSSFLogicTempl> list = this.psSFLogicTemplListMap.get(strName);
                  if (list != null) {
                     for (IPSSFLogicTempl iPSSFLogicTempl : list) {
                        if (iPSSFLogicTempl.getPSSFPubCode() != null) {
                           Map<String, Object> params = new HashMap<>();
                           params.put("item", iPSModelObject);
                           params.put("P", new PSCodePublisherContextImpl());
                           if (this.iPSSystem != null) {
                              params.put("sys", this.iPSSystem);
                              if (this.iPSSystem.getDefaultPSSysSFPub() != null) {
                                 params.put("pub", this.iPSSystem.getDefaultPSSysSFPub());
                              }
                           }

                           String strCode = PSTemplHelper.generateCode(iPSSFLogicTempl.getModelData(), "TEMPLCODE", params);
                           if (iPSSFLogicTempl instanceof IPSSFLogicTempl2) {
                              IPSSFLogicTempl2 iPSSFLogicTempl2 = (IPSSFLogicTempl2)iPSSFLogicTempl;
                              if (iPSSFLogicTempl2.isCheckModelOnly()) {
                                 continue;
                              }
                           }

                           String strPath = String.format("%1$s.%2$s", file.getCanonicalPath(), iPSSFLogicTempl.getPSSFPubCode().getName());
                           if (!StringHelper.isNullOrEmpty(strCode)) {
                              strCode = strCode.trim();
                           }

                           File file2 = new File(strPath);
                           if (!StringHelper.isNullOrEmpty(strCode)) {
                              FileWriterHelper.write3(file2, strCode);
                           } else if (file2.exists()) {
                              file2.delete();
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         log.error(String.format("无法输出模型对象[%1$s][%2$s|%3$s]动态模型，没有实现接口", iPSModelObject.getModelType(), iPSModelObject.getName(), iPSModelObject.getId()));
      }
   }

   protected void setCfgPath(String strCfgPath) {
      this.strCfgPath = strCfgPath;
   }

   protected String getCfgPath() {
      return this.strCfgPath;
   }

   protected void setGroovySourcePath(String strGroovySourcePath) {
      this.strGroovySourcePath = strGroovySourcePath;
   }

   protected String getGroovySourcePath() {
      return this.strGroovySourcePath;
   }

   protected boolean isCoreModelMode() {
      return false;
   }

   protected boolean isCodeGenModelMode() {
      return false;
   }

   protected String getCallbackUrl() {
      if (this.iPSDevSlnSysDynaInst == null) {
         return "";
      }

      try {
         String strRunMode = "";
         if (this.getPSSysRunSession() != null) {
            strRunMode = this.getPSSysRunSession().getRunMode();
         }

         if (StringHelper.isNullOrEmpty(strRunMode)) {
            strRunMode = "PUBDYNAINSTMODEL";
         }

         if (!StringHelper.isNullOrEmpty(this.iPSDevSlnSysDynaInst.getPSDevSlnId())) {
            PSDevSln psDevSln = new PSDevSln();
            CallResult callResult = this.getPSModelHelper(null).getPSDevSln(this.iPSDevSlnSysDynaInst.getPSDevSlnId(), psDevSln);
            if (callResult.isError()) {
               throw new Exception(StringHelper.format("查询开发方案发生错误，%1$s", callResult.getErrorInfo()));
            }

            if (!psDevSln.isENABLECALLBACKNull()) {
               if (!psDevSln.getENABLECALLBACK()) {
                  return "";
               }

               String strCallbackUrl = psDevSln.getCALLBACKURL();
               if (StringHelper.isNullOrEmpty(strCallbackUrl)) {
                  return "";
               }

               return this.getRealCallbackUrl(
                  strCallbackUrl,
                  this.iPSDevSlnSysDynaInst.getId(),
                  this.iPSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId(),
                  psDevSln.getPSDEVSLNID(),
                  strRunMode,
                  psDevSln.getCALLBACKTAG()
               );
            }
         }

         return "";
      } catch (Exception ex) {
         log.error(StringHelper.format("计算回调信息发生异常，%1$s", ex.getMessage()), ex);
         return "";
      }
   }

   protected String getRealCallbackUrl(String strUrl, String strPSDynaInstId, String strPPSDynaInstId, String strDevSlnId, String strRunMode, String strToken) {
      return strUrl.replace("{psdynainstid}", WebUtility.encodeURLParamValue(strPSDynaInstId))
         .replace("{ppsdynainstid}", WebUtility.encodeURLParamValue(strPPSDynaInstId))
         .replace("{psdevslnid}", WebUtility.encodeURLParamValue(strDevSlnId))
         .replace("{runmode}", WebUtility.encodeURLParamValue(strRunMode))
         .replace("{token}", WebUtility.encodeURLParamValue(strToken));
   }

   private void dumpRun() {
      while (this.bRunDumpThread) {
         Runnable runnable = null;
         synchronized (this.dumpRunnableList) {
            if (this.dumpRunnableList.size() > 0) {
               runnable = this.dumpRunnableList.remove(0);
            }
         }

         try {
            if (runnable != null) {
               runnable.run();
            } else {
               Thread.sleep(10L);
            }
         } catch (Exception ex) {
            log.error(ex);
         }
      }
   }

   private void dumpFile() {
      while (this.bRunDumpThread) {
         PubDynaInstModelPSSysDevBKTaskImpl.DumpFile dumpFile = null;
         synchronized (this.dumpFileList) {
            if (this.dumpFileList.size() > 0) {
               dumpFile = this.dumpFileList.remove(0);
            }
         }

         try {
            if (dumpFile != null) {
               String strCode = DTOMAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(dumpFile.node);
               FileWriterHelper.write3(dumpFile.file, strCode);
            } else {
               Thread.sleep(10L);
            }
         } catch (Exception ex) {
            log.error(ex);
         }
      }
   }

   class DumpFile {
      public File file;
      public ObjectNode node;

      public DumpFile(File file, ObjectNode node) {
         this.file = file;
         this.node = node;
      }
   }
}
