package net.ibizsys.pscore.srv;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.CaseFormat;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEDataSetCond;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.RemoteCallResult;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ProcParam;
import net.ibizsys.paas.db.ProcParamList;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.db.SelectFieldFilter;
import net.ibizsys.paas.db.SelectGroupFilter;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDEFieldModel;
import net.ibizsys.paas.demodel.IDER1NModel;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.demodel.ISqlCommandModel;
import net.ibizsys.paas.demodel.SqlCommandModel;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityException;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ActionSession;
import net.ibizsys.paas.service.ActionSessionManager;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.CloneSessionManager;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ImportSessionManager;
import net.ibizsys.paas.service.RemoteService;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.DefaultValueHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.util.WebUtility;
import net.ibizsys.paas.util.freemarker.DataContextMethod;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.codelist.PSObjChangeTypeCodeListModel;
import net.ibizsys.pscore.srv.config.entity.PSMIDetail;
import net.ibizsys.pscore.srv.config.entity.PSModelInitStruct;
import net.ibizsys.pscore.srv.core.IPSDEFieldModel;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDSDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserRecent;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserRecentService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelChgLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelChgLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.Inflector;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSMOSFileUtil;
import net.ibizsys.pscore.srv.util.PSModelFolderKeyHelper;
import net.ibizsys.pscore.srv.util.PSModelHotCodeHelper;
import net.ibizsys.pscore.srv.util.PSModelInitGlobal;
import net.ibizsys.pscore.srv.util.PSModelSummaryHelper;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.pscore.srv.util.gitlab.IPSGitLabPlugin;
import net.ibizsys.pscore.srv.util.gitlab.PSGitLabPluginImpl;
import net.ibizsys.pscore.srv.util.gitlab.model.WikiPage;
import net.ibizsys.pscore.srv.util.kafka.IPSKafkaPlugin;
import net.ibizsys.pscore.srv.util.kafka.PSKafkaPluginImpl;
import net.ibizsys.pscore.srv.util.modelinst.IPSDBServerSessionFactory;
import net.ibizsys.pscore.srv.util.yaml.PSModelYamlHelper;
import net.ibizsys.pscore.srv.web.WebContext;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public abstract class PSCoreSysServiceBase<ET extends IEntity>
   extends PSCoreSysServiceBaseBase<ET>
   implements IPSCoreSysService<ET>,
   IPSModelV2Service<ET>,
   IPSMOSFileService<ET> {
   private static final Log log = LogFactory.getLog(PSCoreSysServiceBase.class);
   private static RestTemplate restTemplate = new RestTemplate();
   private static HashMap<String, String> deLogMap = new HashMap<>();
   private static HashMap<String, String> deModelVerMap = new HashMap<>();
   private static HashMap<String, String> deModelVerMap2 = new HashMap<>();
   private static HashMap<String, String> deDBVerMap = new HashMap<>();
   private static HashMap<String, String> sysModelVerMap = new HashMap<>();
   private static HashMap<String, String> sysModelVerSqlMap = new HashMap<>();
   private static HashMap<String, String> sysModelLogMap = new HashMap<>();
   private static HashMap<String, String> informStateMap = new HashMap<>();
   private static HashMap<String, String> informStateMap2 = new HashMap<>();
   private static final String ACTION_X_INITMODEL = "INITMODEL";
   public static final String ACTION_INITMODEL = "INITMODEL";
   public static final String LOGGER_OPINFO = "操作信息";
   private static String strDevCenterApi = null;
   private static RemoteCallResult defaultRemoteCallResult = new RemoteCallResult();
   private static ThreadLocal<String> curPSSystemId = new ThreadLocal<>();
   private static ThreadLocal<String> curPSDCId = new ThreadLocal<>();
   private static ThreadLocal<String> curPSDevSlnSysId = new ThreadLocal<>();
   private static ThreadLocal<String> curPSDevSlnId = new ThreadLocal<>();
   private static ThreadLocal<String> curPSDynaInstId = new ThreadLocal<>();
   private static PSModelHotCodeHelper psModelHotCodeHelper = new PSModelHotCodeHelper();
   private static ThreadLocal<PSSystem> impSysModelSystem = new ThreadLocal<>();
   private static ThreadLocal<SessionFactory> curMajorSessionFactory = new ThreadLocal<>();
   private static ThreadLocal<Boolean> simpleImportExportMode = new ThreadLocal<>();
   private static ThreadLocal<String> simpleImportExportOwner = new ThreadLocal<>();
   private static ThreadLocal<Boolean> threadCurDCLimit = new ThreadLocal<>();
   private static ThreadLocal<Boolean> threadCurDevSlnLimit = new ThreadLocal<>();
   private static ThreadLocal<Boolean> threadCodeNameUpperCamel = new ThreadLocal<>();
   private static HashMap<String, String> denyCopyMap = new HashMap<>();
   public static int PSMODEL_EXPORTMODE = 7;
   public static final String MSG_ACEMPTY = "无法自动计算合适的可选值，请直接输入";
   private static boolean bEnableMergeCount = true;
   private static boolean bEnableI18NDefault = true;
   private static boolean bEnableStateInformDefault = false;
   private static Boolean bEnableDevSlnSysRemoteCall = null;
   private static Boolean bEnableModelObjStorage = null;
   private static boolean bEnableOPInfoInformDefault = false;
   private static Boolean bEnableGitLabPlugin = null;
   private static IPSGitLabPlugin iPSGitLabPlugin = null;
   private static Boolean bEnableKafkaPlugin = null;
   private static IPSKafkaPlugin iPSKafkaPlugin = null;
   private static String strPSSvrDomainId = null;
   private static boolean bEnableCurDCLimit = false;
   private static boolean bEnableCurDevSlnLimit = false;
   private static boolean bEnablePaaSAdminLimit = false;
   private static String strRecyclePSDCId = null;
   private static boolean bPrivateCloudMode = false;
   private static boolean bMOSMode = true;
   private static int nMOSVersion = 1;
   private static boolean bCloudMode = false;
   private static String strProxyTaskServerUrl = null;
   private static boolean bEnableCodeNameUpperCamel = false;
   private static Boolean bEnableGitBranch = null;
   private static String strModelFormat = null;
   protected static final Pattern codeNamePattern = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");
   private static PSSysSFPub invalidPSSysSFPub = new PSSysSFPub();
   private static Map<String, PSHelpSection[]> pastePSHelpSectionsMap = new HashMap<>();
   private static Map<String, Integer> ignoreExportModelV2Map = new HashMap<>();
   private static Map<String, Integer> ignoreImportModelV2Map = new HashMap<>();
   private static Map<String, Integer> ignoreImportModelFieldV2Map = new HashMap<>();
   private static Map<String, String> aliasModelV2Map = new HashMap<>();
   private static Map<String, String> ignoreCountDRDataFoldersMap = new HashMap<>();
   private static ObjectMapper MAPPER = new ObjectMapper();
   private PSCoreSysServiceBase.ISysConsole iSysConsole = new PSCoreSysServiceBase.ISysConsole() {
      @Override
      public void log(String var1, String var2) {
         PSCoreSysServiceBase.this.logSysConsole("INFO", var1, var2);
      }

      @Override
      public void warn(String var1, String var2) {
         PSCoreSysServiceBase.this.logSysConsole("WARN", var1, var2);
      }

      @Override
      public void error(String var1, String var2) {
         PSCoreSysServiceBase.this.logSysConsole("ERROR", var1, var2);
      }
   };

   public PSCoreSysServiceBase() {
      try {
         PSCoreEntityKeeperGlobal.initAll();
      } catch (Exception var2) {
         log.error(var2);
      }
   }

   @Override
   protected void onBeforeCreateTemp(ET var1) throws Exception {
      if (ImportSessionManager.getCurrentSession() == null) {
         this.fillEntity((ET)var1);
         this.fillDefaultValue((ET)var1, true);
      }

      psModelHotCodeHelper.execute(this, "BEFORECREATE", var1, true);
      super.onBeforeCreateTemp((ET)var1);
   }

   @Override
   protected void onBeforeUpdateTemp(ET var1) throws Exception {
      this.fillEntity((ET)var1);
      psModelHotCodeHelper.execute(this, "BEFOREUPDATE", var1, true);
      super.onBeforeUpdateTemp((ET)var1);
   }

   @Override
   protected void onAfterCreateTemp(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "AFTERCREATE", var1, true);
      this.informObjectChanged((ET)var1, "CREATE");
      super.onAfterCreateTemp((ET)var1);
   }

   @Override
   protected void onAfterUpdateTemp(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "AFTERUPDATE", var1, true);
      this.informObjectChanged((ET)var1, "UPDATE");
      super.onAfterUpdateTemp((ET)var1);
   }

   @Override
   protected void onBeforeGetDraft(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "BEFOREGETDRAFT", var1, true);
      super.onBeforeGetDraft((ET)var1);
   }

   @Override
   protected void onBeforeGetDraftTemp(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "BEFOREGETDRAFT", var1, true);
      super.onBeforeGetDraftTemp((ET)var1);
   }

   @Override
   protected void onAfterGetDraft(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "AFTERGETDRAFT", var1, true);
      super.onAfterGetDraft((ET)var1);
   }

   @Override
   protected void onAfterGetDraftTemp(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "AFTERGETDRAFT", var1, true);
      super.onAfterGetDraftTemp((ET)var1);
   }

   @Override
   protected void onBeforeCreate(ET var1) throws Exception {
      if (ImportSessionManager.getCurrentSession() == null) {
         var1.set("DYNAMODELFLAG", 0);
      }

      if (ImportSessionManager.getCurrentSession() == null) {
         this.fillEntity((ET)var1);
         this.fillDefaultValue((ET)var1, false);
      }

      psModelHotCodeHelper.execute(this, "BEFORECREATE", var1, true);
      super.onBeforeCreate((ET)var1);
   }

   @Override
   protected void onAfterCreate(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "AFTERCREATE", var1, true);
      this.informObjectChanged((ET)var1, "CREATE");
      this.logSysModelChanged((ET)var1, "CREATE");
      this.logModelObjChanged((ET)var1, "CREATE");
      this.logDEModelVerChanged((ET)var1);
      this.logDEDBVerChanged((ET)var1);
      if (ImportSessionManager.getCurrentSession() == null) {
         this.syncSysTask((ET)var1, false);
         boolean var2 = true;
         if (StringHelper.compare(this.getDEModel().getName(), "PSDATAENTITY", true) == 0) {
            PSSystem var3 = getCurrentPSSystem(var1, this.getSessionFactory());
            if (!DataObject.getBoolValue(var3.getInitDEDefault(), true)) {
               var2 = false;
            }
         }

         if (var2) {
            this.onInitModel((ET)var1);
         }
      }

      super.onAfterCreate((ET)var1);
   }

   @Override
   protected void onBeforeUpdate(ET var1) throws Exception {
      this.fillEntity((ET)var1);
      psModelHotCodeHelper.execute(this, "BEFOREUPDATE", var1, true);
      super.onBeforeUpdate((ET)var1);
   }

   @Override
   protected void onAfterUpdate(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "AFTERUPDATE", var1, true);
      this.informObjectChanged((ET)var1, "UPDATE");
      this.logSysModelChanged((ET)var1, "UPDATE");
      this.logModelObjChanged((ET)var1, "UPDATE");
      this.logDEModelVerChanged((ET)var1);
      this.logDEDBVerChanged((ET)var1);
      if (ImportSessionManager.getCurrentSession() == null) {
         this.syncSysTask((ET)var1, false);
      }

      super.onAfterUpdate((ET)var1);
   }

   @Override
   protected void onBeforeRemove(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "BEFOREREMOVE", var1, true);
      this.informObjectChanged((ET)var1, "DELETE");
      this.logSysModelChanged((ET)var1, "DELETE");
      this.logModelObjChanged((ET)var1, "DELETE");
      this.logDEModelVerChanged((ET)var1);
      this.logDEDBVerChanged((ET)var1);
      this.syncSysTask((ET)var1, true);
      super.onBeforeRemove((ET)var1);
   }

   @Override
   protected void onAfterRemove(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "AFTERREMOVE", var1, true);
      this.informObjectChanged((ET)var1, "DELETE");
      super.onAfterRemove((ET)var1);
   }

   @Override
   protected void onAfterRemoveTemp(ET var1) throws Exception {
      psModelHotCodeHelper.execute(this, "AFTERREMOVE", var1, true);
      this.informObjectChanged((ET)var1, "DELETE");
      super.onAfterRemoveTemp((ET)var1);
   }

   protected void logSysModelChanged(ET var1, String var2) throws Exception {
      if (!isImpSysModelNowEx()) {
         if (sysModelLogMap.containsKey(this.getDEModel().getName())) {
            String var3 = sysModelLogMap.get(this.getDEModel().getName());
            if (StringHelper.isNullOrEmpty(var3)) {
               var3 = this.getDEModel().getName();
            }

            Object var4 = var1.get("pssystemid");
            if (var4 == null) {
               var4 = getCurrentPSSystemId();
            }

            if (var4 != null) {
               if (ActionSessionManager.getCurrentSession().registerRecursion("LOGSYSMODELCHANGED", (String)var4, var3)) {
                  PSSysModelLogService var5 = (PSSysModelLogService)ServiceGlobal.getService(PSSysModelLogService.class, this.getSessionFactory());
                  PSSysModelLog var6 = new PSSysModelLog();
                  var6.setPSSystemId((String)var4);
                  var6.setPSSystemName("(N/A)");
                  var6.setPSSysModelLogName(var3);
                  var5.save(var6, false);
               }
            } else {
               log.error(StringHelper.format("系统模型[%1$s]变化没有被日志，没有系统标识", this.getDEModel().getName()));
            }
         }

         String var8 = deLogMap.get(this.getDEModel().getName());
         if (!StringHelper.isNullOrEmpty(var8)) {
            if (StringHelper.compare(var2, "DELETE", true) == 0) {
               var1 = this.getLast(var1);
            }

            String var9 = (String)var1.get(var8);
            if (!StringHelper.isNullOrEmpty(var9)) {
               PSSysModelChgLog var10 = new PSSysModelChgLog();
               var10.setCHGType(var2);
               var10.setPSSysModelChgLogName(this.getDEModel().getLogicName());
               var10.setObjType(this.getDEModel().getName());
               var10.setPSDEId(var9);
               var10.setPSObjId((String)var1.get(this.getDEModel().getKeyDEField().getName()));
               if (var1.get("pssystemid") != null) {
                  var10.set("pssystemid", var1.get("pssystemid"));
               }

               if (var1.get("pssystemname") != null) {
                  var10.set("pssystemname", var1.get("pssystemname"));
               }

               if (StringHelper.isNullOrEmpty(var10.getPSSystemName())) {
                  var10.setPSSystemName("(N/A)");
               }

               if (StringHelper.compare(var2, "DELETE", true) == 0
                  && StringHelper.compare(this.getDEModel().getName(), "PSDATAENTITY", true) == 0
                  && StringHelper.compare(var9, var10.getPSObjId(), true) == 0) {
                  var10.setPSDEName("(N/A)");
               }

               String var11 = (String)var1.get(this.getDEModel().getMajorDEField().getName());
               if (StringHelper.isNullOrEmpty(var11) && StringHelper.compare(var2, "DELETE", true) != 0) {
                  IEntity var7 = this.getDEModel().createEntity();
                  var7.set(this.getDEModel().getKeyDEField().getName(), var10.getPSObjId());
                  this.get((ET)var7);
                  var11 = (String)var7.get(this.getDEModel().getMajorDEField().getName());
               }

               if (StringHelper.isNullOrEmpty(var11)) {
                  var11 = "(N/A)";
               }

               var10.setPSObjName(var11);
               if (this.getWebContext() != null) {
                  var10.setRemoteAddr(this.getWebContext().getRemoteAddr());
               }

               PSSysModelChgLogService var12 = (PSSysModelChgLogService)ServiceGlobal.getService(PSSysModelChgLogService.class, this.getSessionFactory());
               var12.create(var10, false);
               return;
            }
         }
      }
   }

   protected void logDEModelVerChanged(ET var1) throws Exception {
      if (!isImpSysModelNowEx()) {
         boolean var2 = false;
         String var3 = deModelVerMap.get(this.getDEModel().getName());
         String var4 = null;
         if (!StringHelper.isNullOrEmpty(var3)) {
            var4 = (String)var1.get(var3);
            if (StringHelper.isNullOrEmpty(var4) && this.getLast(var1) != null) {
               var4 = (String)this.getLast(var1).get(var3);
            }

            if (!StringHelper.isNullOrEmpty(var4)) {
               if (ActionSessionManager.getCurrentSession().registerRecursion("LOGDEMODELVERCHANGED", "PSDATAENTITY", var4)) {
                  String var5 = StringHelper.format("UPDATE T_SRFPSDATAENTITY SET MODELVER=MODELVER+1 WHERE PSDATAENTITYID=?");
                  SqlParamList var6 = new SqlParamList();
                  var6.add(var4, 25);
                  this.getDAO().executeRawSql(null, var5, var6);
                  String var7 = StringHelper.format(
                     "update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpsdataentity where t_srfpssystem.PSSYSTEMID = t_srfpsdataentity.PSSYSTEMID and t_srfpsdataentity.psdataentityid=?)"
                  );
                  this.getDAO().executeRawSql(null, var7, var6);
               }

               var2 = true;
            }
         }

         if (!StringHelper.isNullOrEmpty(var4)
            && this.getWebContext() != null
            && ActionSessionManager.getCurrentSession().registerRecursion("LOGDEVUSERRECENT_DE", "PSDATAENTITY", var4)
            && !StringHelper.isNullOrEmpty(this.getWebContext().getCurUserId())
            && !StringHelper.isNullOrEmpty(this.getWebContext().getCurOrgId())) {
            PSDataEntity var13 = new PSDataEntity();
            var13.setPSDataEntityId(var4);
            PSDataEntityService var16 = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, this.getSessionFactory());
            var16.get(var13);
            PSDevUserRecent var20 = new PSDevUserRecent();
            var20.setObjType("PSDATAENTITY");
            var20.setObjId(var13.getPSDataEntityId());
            String var8 = var16.getDataInfo(var13);
            var20.setObjName(var8);
            if (!StringHelper.isNullOrEmpty(this.getWebContext().getCurOrgId())) {
               var20.setPSDevCenterId(this.getWebContext().getCurOrgId());
               if (StringHelper.isNullOrEmpty(this.getWebContext().getCurOrgName())) {
                  var20.setPSDevCenterName("应用中心");
               } else {
                  var20.setPSDevCenterName(this.getWebContext().getCurOrgName());
               }
            }

            var20.setPSDevUserId(this.getWebContext().getCurUserId());
            var20.setPSDevUserName(this.getWebContext().getCurUserName());
            var20.setPSDevUserRecentName(var20.getObjName());
            PSDevUserRecentService var9 = (PSDevUserRecentService)ServiceGlobal.getService(PSDevUserRecentService.class, this.getSessionFactory());
            var9.save(var20, false);
         }

         String var11 = null;
         var3 = deModelVerMap2.get(this.getDEModel().getName());
         if (!StringHelper.isNullOrEmpty(var3)) {
            var11 = (String)var1.get(var3);
            if (StringHelper.isNullOrEmpty(var11) && this.getLast(var1) != null) {
               var11 = (String)this.getLast(var1).get(var3);
            }

            if (!StringHelper.isNullOrEmpty(var11)) {
               if (ActionSessionManager.getCurrentSession().registerRecursion("LOGDEMODELVERCHANGED", "PSDATAENTITY", var11)) {
                  String var14 = StringHelper.format("UPDATE T_SRFPSDATAENTITY SET MODELVER=MODELVER+1 WHERE PSDATAENTITYID=?");
                  SqlParamList var17 = new SqlParamList();
                  var17.add(var11, 25);
                  this.getDAO().executeRawSql(null, var14, var17);
                  String var21 = StringHelper.format(
                     "update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpsdataentity where t_srfpssystem.PSSYSTEMID = t_srfpsdataentity.PSSYSTEMID and t_srfpsdataentity.psdataentityid=?)"
                  );
                  this.getDAO().executeRawSql(null, var21, var17);
               }

               var2 = true;
            }
         }

         if (!var2) {
            String var15 = sysModelVerMap.get(this.getDEModel().getName());
            if (var15 != null) {
               String var18 = getCurrentPSSystemId();
               if (StringHelper.isNullOrEmpty(var18) && !StringHelper.isNullOrEmpty(var15)) {
                  var18 = (String)var1.get(var15);
                  if (StringHelper.isNullOrEmpty(var18) && this.getLast(var1) != null) {
                     var18 = (String)this.getLast(var1).get(var15);
                  }
               }

               if (!StringHelper.isNullOrEmpty(var18) && ActionSessionManager.getCurrentSession().registerRecursion("LOGDEMODELVERCHANGED", "PSSYSTEM", var18)) {
                  String var22 = StringHelper.format("UPDATE T_SRFPSSYSTEM SET MODELVER=MODELVER+1 WHERE PSSYSTEMID=?");
                  SqlParamList var24 = new SqlParamList();
                  var24.add(var18, 25);
                  this.getDAO().executeRawSql(null, var22, var24);
               }
            } else {
               String var19 = sysModelVerSqlMap.get(this.getDEModel().getName());
               if (!StringHelper.isNullOrEmpty(var19)) {
                  String var23 = DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()));
                  if (!StringHelper.isNullOrEmpty(var23)
                     && ActionSessionManager.getCurrentSession().registerRecursion("LOGDEMODELVERCHANGED", "PSSYSTEM", var23)) {
                     SqlParamList var25 = new SqlParamList();
                     var25.add(var23, 25);
                     this.getDAO().executeRawSql(null, var19, var25);
                  }
               }
            }
         }
      }
   }

   protected void logDEDBVerChanged(ET var1) throws Exception {
      if (!isImpSysModelNowEx()) {
         String var2 = deDBVerMap.get(this.getDEModel().getName());
         if (!StringHelper.isNullOrEmpty(var2)) {
            String var3 = (String)var1.get(var2);
            if (StringHelper.isNullOrEmpty(var3) && this.getLast(var1) != null) {
               var3 = (String)this.getLast(var1).get(var2);
            }

            if (!StringHelper.isNullOrEmpty(var3)) {
               if (ActionSessionManager.getCurrentSession().registerRecursion("LOGDEDBVERCHANGED", "PSDATAENTITY", var3)) {
                  String var4 = StringHelper.format("UPDATE T_SRFPSDATAENTITY SET DBVER=DBVER+1 WHERE PSDATAENTITYID=?");
                  SqlParamList var5 = new SqlParamList();
                  var5.add(var3, 25);
                  this.getDAO().executeRawSql(null, var4, var5);
                  var4 = StringHelper.format(
                     "update T_SRFPSSYSTEM set DBVERSION=DBVERSION+1\twhere exists(select * from T_SRFPSDATAENTITY t1 where t1.PSDATAENTITYID=? and t1.PSSYSTEMID=T_SRFPSSYSTEM.PSSYSTEMID)"
                  );
                  this.getDAO().executeRawSql(null, var4, var5);
               }

               return;
            }
         }
      }
   }

   public void initModel(final ET var1) throws Exception {
      IServicePlugin var2 = this.getPlugin();
      if (var2 == null || var2.doCustomAction(this, "INITMODEL", 0, var1, null).getResult() != 1) {
         final String var3 = DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()));
         if (!StringHelper.isNullOrEmpty(var3)) {
            this.doServiceWork(new IServiceWork() {
               @Override
               public void execute(ITransaction var1x) throws Exception {
                  if (KeyValueHelper.isTempKey(var3)) {
                     PSCoreSysServiceBase.this.getTemp(var1);
                     String var2x = (String)EntityBase.getOriginKey(var1);
                     if (!StringHelper.isNullOrEmpty(var2x)) {
                        ET var3x = PSCoreSysServiceBase.this.getDEModel().createEntity();
                        var3x.set(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName(), var2x);
                        PSCoreSysServiceBase.this.get(var3x);
                        PSCoreSysServiceBase.this.onInitModel(var3x);
                     }
                  } else {
                     PSCoreSysServiceBase.this.get(var1);
                     PSCoreSysServiceBase.this.onInitModel(var1);
                  }
               }
            }, true);
            if (var2 != null) {
               var2.doCustomAction(this, "INITMODEL", 99, var1, null);
            }
         }
      }
   }

   protected void onInitModel(ET var1) throws Exception {
      PSModelInitStruct var2 = PSModelInitGlobal.getPSModelInitStruct(this.getDEModel().getName());
      if (var2 != null) {
         for (PSMIDetail var4 : var2.getPSModelInitDetails()) {
            String var5 = KeyValueHelper.genUniqueId(this.getDEModel().getSystem().getId(), var4.getPSDEName());
            IDataEntityModel var6 = DEModelGlobal.getDEModel(var5);
            IService var7 = var6.getService(this.getSessionFactory());
            if (var7 instanceof IPSModelService) {
               ((IPSModelService)var7).initModel(this.getDEModel().getName(), var1, var4.getInitMode());
            }
         }
      }
   }

   @Override
   public void executeAction(String var1, IEntity var2) throws Exception {
      if (var1.indexOf("X_") != 0
         && var1.indexOf("XG_") != 0
         && var1.indexOf("X2_") != 0
         && var1.indexOf("X2G_") != 0
         && var1.indexOf("X3_") != 0
         && var1.indexOf("X3G_") != 0) {
         super.executeAction(var1, var2);
      } else {
         if (this.getWebContext() == null) {
            final String var3 = var1;
            final IEntity var4 = var2;
            ServiceWorkHelper.getInstance().execute(new IServiceWork() {
               @Override
               public void execute(ITransaction var1) throws Exception {
                  PSCoreSysServiceBase.this.executeRemoteCallX(var3, var4);
               }
            });
         } else {
            this.executeRemoteCallX(var1, var2);
         }
      }
   }

   protected void executeRemoteCallX(String var1, IEntity var2) throws Exception {
      if (var1.indexOf("X_") == 0) {
         this.executeRemoteCall(var1.substring(2), var2);
      } else if (var1.indexOf("XG_") == 0) {
         this.executeRemoteCall(var1.substring(3), var2, true);
      } else if (var1.indexOf("X2_") == 0) {
         this.executeRemoteCall2(var1.substring(3), var2, false);
      } else if (var1.indexOf("X2G_") == 0) {
         this.executeRemoteCall2(var1.substring(4), var2, true);
      } else if (var1.indexOf("X3_") == 0) {
         this.executeRemoteCall3(var1.substring(3), var2);
      } else if (var1.indexOf("X3G_") == 0) {
         this.executeRemoteCall3(var1.substring(4), var2, true);
      }
   }

   protected RemoteCallResult executeRemoteCall(String var1, IEntity var2) throws Exception {
      return this.executeRemoteCall(var1, var2, false);
   }

   protected RemoteCallResult executeRemoteCall(String var1, IEntity var2, boolean var3) throws Exception {
      Object var4 = var2.get("pssystemid");
      if (var4 == null) {
         var4 = getCurrentPSSystemId();
      }

      if (var4 == null) {
         var4 = this.getDataContextValue((ET)var2, "pssystemid", null);
      }

      if (var4 == null) {
         var4 = DataContextMethod.getValue("pssystemid", this.getSessionFactory());
      }

      PSTaskServer var5 = null;
      SessionFactory var6 = this.getSessionFactory();
      if (isEnableDevSlnSysRemoteCall() || var6 == getCurMajorSessionFactory()) {
         String var7 = this.getCurrentPSDevSlnSysId(var6 == getCurMajorSessionFactory() ? var2 : null, true);
         if (StringHelper.isNullOrEmpty((Object)var7)) {
            throw new Exception("无法获取当前开发系统");
         }

         PSDevSlnSysService var8 = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, getCurMajorSessionFactory());
         PSDevSlnSys var9 = new PSDevSlnSys();
         var9.setPSDevSlnSysId(var7);
         var8.get(var9);
         if (var9.getPSDevCenterTS() != null) {
            var5 = var9.getPSDevCenterTS().getPSTaskServer();
            var2.set("pssystemid", var9.getPSSystemId());
            var2.set("psdevslnsysid", var9.getPSDevSlnSysId());
         } else {
            var6 = PSSysModelInstGlobal.getSessionFactory(var9.getPSSysModelInstId());
         }
      }

      if (var5 == null) {
         if (var4 == null) {
            throw new Exception("无法获取当前系统");
         }

         PSSystemService var10 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, var6);
         PSSystem var11 = new PSSystem();
         var11.setPSSystemId((String)var4);
         var10.getCache(var11);
         if (var11.getPSDevCenterTS() == null) {
            throw new Exception("当前系统未配置任务服务器");
         }

         if (!StringHelper.isNullOrEmpty(var11.getPSDevSlnSysId())) {
            var2.set("psdevslnsysid", var11.getPSDevSlnSysId());
         }

         var2.set("pssystemid", var11.getPSSystemId());
         var5 = var11.getPSDevCenterTS().getPSTaskServer();
      }

      return this.executeRemoteCall(var5, var1, var2, var3);
   }

   protected RemoteCallResult executeRemoteCall(PSTaskServer var1, String var2, IEntity var3, boolean var4) throws Exception {
      String var5 = this.getRemoteCallUrl(var1, var2, var3);
      RemoteService var6 = new RemoteService();
      var6.init(var5, this.getDEModel().getName(), WebContext.getCurrent().getCurUserId());
      log.debug(StringHelper.format("请求远程地址[%1$s]", var5));
      RemoteCallResult var7 = var6.executeAction(var2, var3, "GBK");
      if (var7.isError()) {
         throw new Exception(var7.getErrorInfo());
      }

      if (var4 && var7.getItems() != null && var7.getItems().length() > 0) {
         DataObject.fromJSONObject(var3, var7.getItems().getJSONObject(0));
      }

      return var7;
   }

   protected RemoteCallResult executeRemoteCall2(String var1, IEntity var2) throws Exception {
      return this.executeRemoteCall2(var1, var2, false);
   }

   protected RemoteCallResult executeRemoteCall2(String var1, IEntity var2, boolean var3) throws Exception {
      Object var4 = var2.get("psdevcenterid");
      if (var4 == null) {
         var4 = getCurrentPSDCId();
      } else {
         String var5 = getCurrentPSDCId();
         if (!StringHelper.isNullOrEmpty(var5) && !var4.equals(var5)) {
            throw new Exception("传入应用中心不一致");
         }
      }

      if (var4 == null) {
         var4 = this.getDataContextValue((ET)var2, "psdevcenterid", null);
      }

      if (var4 == null) {
         var4 = DataContextMethod.getValue("psdevcenterid", this.getSessionFactory());
      }

      if (var4 == null && WebContext.getCurrent() != null) {
         var4 = WebContext.getCurrent().getCurOrgId();
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception("无法获取当前应用中心");
      }

      PSDevCenterTSService var12 = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, getCurMajorSessionFactory());
      PSDevCenter var6 = new PSDevCenter();
      var6.setPSDevCenterId((String)var4);
      ArrayList<PSDevCenterTS> var7 = var12.selectByPSDevCenter(var6);
      if (var7.size() == 0) {
         throw new Exception("当前应用中心未配置任务服务器");
      }

      PSDevCenterTS var8 = null;

      for (PSDevCenterTS var10 : var7) {
         if (DataObject.getBoolValue(var10.getValidFlag(), true)) {
            if (StringHelper.compare("SYSPUB", var10.getServerUsage(), false) == 0) {
               var8 = var10;
               break;
            }

            if (var8 == null) {
               var8 = var10;
            }
         }
      }

      if (var8 == null) {
         throw new Exception("当前应用中心未配置任务服务器");
      }

      var2.set("psdevcenterid", var4);
      String var13 = this.getRemoteCallUrl(var8.getPSTaskServer(), var1, var2);
      RemoteService var14 = new RemoteService();
      var14.init(var13, this.getDEModel().getName(), WebContext.getCurrent().getCurUserId());
      log.debug(StringHelper.format("请求远程地址[%1$s]", var13));
      RemoteCallResult var11 = var14.executeAction(var1, var2, "GBK");
      if (var11.isError()) {
         throw new Exception(var11.getErrorInfo());
      }

      if (var3 && var11.getItems() != null && var11.getItems().length() > 0) {
         DataObject.fromJSONObject(var2, var11.getItems().getJSONObject(0));
      }

      return var11;
   }

   protected RemoteCallResult executeRemoteCall2All(String var1, IEntity var2) throws Exception {
      Object var3 = var2.get("psdevcenterid");
      if (var3 == null) {
         var3 = getCurrentPSDCId();
      }

      if (var3 == null) {
         var3 = this.getDataContextValue((ET)var2, "psdevcenterid", null);
      }

      if (var3 == null) {
         var3 = DataContextMethod.getValue("psdevcenterid", this.getSessionFactory());
      }

      if (var3 == null && WebContext.getCurrent() != null) {
         var3 = WebContext.getCurrent().getCurOrgId();
      }

      if (StringHelper.isNullOrEmpty(var3)) {
         throw new Exception("无法获取当前应用中心");
      }

      PSDevCenterTSService var4 = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, getCurMajorSessionFactory());
      PSDevCenter var5 = new PSDevCenter();
      var5.setPSDevCenterId((String)var3);
      ArrayList<PSDevCenterTS> var6 = var4.selectByPSDevCenter(var5);
      if (var6.size() == 0) {
         throw new Exception("当前应用中心未配置任务服务器");
      }

      RemoteCallResult var7 = null;

      for (PSDevCenterTS var9 : var6) {
         if (DataObject.getBoolValue(var9.getValidFlag(), true)) {
            IEntity var10 = this.getDEModel().createEntity();
            var2.copyTo(var10, false);
            var10.set("psdevcenterid", var3);
            String var11 = this.getRemoteCallUrl(var9.getPSTaskServer(), var1, var2);
            RemoteService var12 = new RemoteService();
            var12.init(var11, this.getDEModel().getName(), WebContext.getCurrent().getCurUserId());
            log.debug(StringHelper.format("请求远程地址[%1$s]", var11));
            var7 = var12.executeAction(var1, var10, "GBK");
            if (var7.isError()) {
               throw new Exception(var7.getErrorInfo());
            }
         }
      }

      return var7;
   }

   protected RemoteCallResult executeRemoteCall3(String var1, IEntity var2) throws Exception {
      return this.executeRemoteCall3(var1, var2, false);
   }

   protected RemoteCallResult executeRemoteCall3(String var1, IEntity var2, boolean var3) throws Exception {
      String var4 = DataObject.getStringValue(var2.get("psdevslnsysid"));
      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception("无法获取当前系统");
      }

      PSDevSlnSysService var5 = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, getCurMajorSessionFactory());
      PSDevSlnSys var6 = new PSDevSlnSys();
      var6.setPSDevSlnSysId(var4);
      var5.get(var6);
      PSTaskServer var7 = null;
      if (var6.getPSDevCenterTS() != null) {
         var7 = var6.getPSDevCenterTS().getPSTaskServer();
         var2.set("pssystemid", var6.getPSSystemId());
         var2.set("psdevslnsysid", var6.getPSDevSlnSysId());
      }

      if (var7 == null) {
         throw new Exception("当前系统未配置任务服务器");
      }

      String var8 = this.getRemoteCallUrl(var7, var1, var2);
      RemoteService var9 = new RemoteService();
      var9.init(var8, this.getDEModel().getName(), WebContext.getCurrent().getCurUserId());
      log.debug(StringHelper.format("请求远程地址[%1$s]", var8));
      var2.set("SRF_LOGINNAME", WebContext.getCurrent().getCurLoginName());
      RemoteCallResult var10 = var9.executeAction(var1, var2, "GBK");
      if (var10.isError()) {
         throw new Exception(var10.getErrorInfo());
      }

      if (var3 && var10.getItems() != null && var10.getItems().length() > 0) {
         DataObject.fromJSONObject(var2, var10.getItems().getJSONObject(0));
      }

      return var10;
   }

   protected String getRemoteCallUrl(PSTaskServer var1, String var2, IEntity var3) throws Exception {
      IWebContext var4 = net.ibizsys.paas.web.WebContext.getCurrent();
      if (var4 != null) {
         if (!var3.contains("SRF_LOGINNAME")) {
            var3.set("SRF_LOGINNAME", var4.getCurLoginName());
         }

         if (!var3.contains("SRF_PERSONNAME")) {
            var3.set("SRF_PERSONNAME", var4.getCurUserName());
         }

         if (!var3.contains("SRF_IPADDR")) {
            var3.set("SRF_IPADDR", var4.getRealRemoteAddr());
         }
      }

      String var5 = var1.getServerUrl();
      var5 = var5 + "saps/remoteapi.jsp";
      HashMap var6 = new HashMap();
      this.getRemoteCallUrlParams(var6, var2, var3);
      if (var6.size() > 0) {
         String var7 = WebUtility.getQueryString(var6);
         if (!StringHelper.isNullOrEmpty(var7)) {
            var5 = var5 + "?";
            var5 = var5 + var7;
         }
      }

      return var5;
   }

   protected void getRemoteCallUrlParams(Map<String, String> var1, String var2, IEntity var3) throws Exception {
      var1.put("action", "code");
      String var4 = null;
      String var5 = null;
      if (WebContext.getCurrent() != null && WebContext.getAppData() != null) {
         var4 = WebContext.getAppData().optString("psdevcenterid");
         var5 = WebContext.getAppData().optString("psdevslnsysid");
         if (StringHelper.isNullOrEmpty(var5)) {
            var5 = WebContext.getAppData().optString("psdevslntemplid");
         }
      }

      if (StringHelper.isNullOrEmpty(var4)) {
         var4 = "UNKNOWN";
      }

      if (StringHelper.isNullOrEmpty(var5)) {
         var5 = "UNKNOWN";
         var1.put("action", "maintain");
      }

      var1.put("actiontag", var4);
      var1.put("actiontag2", var5);
   }

   public static RemoteCallResult executeDevCenterApi(String var0, IEntity var1) throws Exception {
      if (strDevCenterApi == null) {
         strDevCenterApi = WebConfig.getCurrent().getAttribute("DEVCENTERAPI", "");
      }

      if (StringHelper.isNullOrEmpty(strDevCenterApi)) {
         return defaultRemoteCallResult;
      } else {
         RemoteService var2 = new RemoteService();
         var2.init(strDevCenterApi, "PSDEVCENTER", WebContext.getCurrent().getCurUserId());
         RemoteCallResult var3 = var2.executeAction(var0, var1, "UTF-8");
         if (var3.isError()) {
            throw new Exception(var3.getErrorInfo());
         } else {
            return var3;
         }
      }
   }

   @Override
   protected boolean isPrepareLastForRemove() {
      if (deModelVerMap.containsKey(this.getDEModel().getName())) {
         return true;
      } else if (deDBVerMap.containsKey(this.getDEModel().getName())) {
         return true;
      } else if (sysModelVerMap.containsKey(this.getDEModel().getName())) {
         return true;
      } else {
         return deLogMap.containsKey(this.getDEModel().getName()) ? true : super.isPrepareLastForRemove();
      }
   }

   @Override
   protected boolean isPrepareLastForUpdate() {
      if (deModelVerMap.containsKey(this.getDEModel().getName())) {
         return true;
      }

      if (deDBVerMap.containsKey(this.getDEModel().getName())) {
         return true;
      }

      if (sysModelVerMap.containsKey(this.getDEModel().getName())) {
         return true;
      }

      try {
         if (this.getDEModel().getDEField("TODOTASK", true) != null) {
            return true;
         }
      } catch (Exception var2) {
      }

      return super.isPrepareLastForUpdate();
   }

   @Override
   protected void onExecuteAction(String var1, IEntity var2) throws Exception {
      if (StringHelper.compare(var1, "INITMODEL", true) == 0) {
         this.initModel((ET)var2);
      } else {
         super.onExecuteAction(var1, var2);
      }
   }

   public XmlNode exportXmlModel(ET var1, XmlNode var2) throws Exception {
      boolean var3 = var2 == null;
      if (!var3 && !var1.isFullEntity()) {
         String var4 = DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()), "");
         if (var4.indexOf("SRFTEMPKEY:") == 0) {
            this.getTemp((ET)var1);
         } else {
            this.get((ET)var1);
         }
      }

      XmlNode var6 = new XmlNode();
      if (var2 != null) {
         var2.addNode(var6);
      }

      IEntity var5 = this.getDEModel().createEntity();
      var1.copyTo(var5, false);
      this.exportCurXmlModel((ET)var5, var6, var3);
      this.exportRelatedXmlModel((ET)var1, var6);
      return var6;
   }

   protected void exportCurXmlModel(ET var1, XmlNode var2, boolean var3) throws Exception {
      var1.set(this.getDEModel().getKeyDEField().getName().toUpperCase(), null);
      var1.set("ENABLE", null);
      var1.set("CREATEMAN", null);
      var1.set("CREATEDATE", null);
      var1.set("UPDATEMAN", null);
      var1.set("UPDATEDATE", null);
      var1.set("SRFORIKEY", null);
      var1.set("SRFDRAFTFLAG", null);
      var1.set("DYNAMODELFLAG", null);
      var1.set("PSDYNAINSTID", null);
      var1.fillXmlNode(var2, false);
   }

   protected void exportRelatedXmlModel(ET var1, XmlNode var2) throws Exception {
      this.onExportRelatedXmlModel((ET)var1, var2);
   }

   protected void onExportRelatedXmlModel(ET var1, XmlNode var2) throws Exception {
   }

   public ET importXmlModel(XmlNode var1) throws Exception {
      return this.importXmlModel(null, var1);
   }

   public ET importXmlModel(ET var1, XmlNode var2) throws Exception {
      if (var1 == null) {
         var1 = this.getDEModel().createEntity();
      }

      final ET var3 = var1;
      final XmlNode var4 = var2;
      boolean var5 = false;
      var1.setSessionFactory(this.getSessionFactory());
      if (ActionSessionManager.getCurrentSession().getActionParam("IMPORTXMLMODEL_FIRST") == null) {
         ActionSessionManager.getCurrentSession().setActionParam("IMPORTXMLMODEL_FIRST", "FALSE");
         var5 = true;
      }

      final boolean var6 = var5;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            CloneSession var2x = CloneSessionManager.getCurrentSession();
            if (var6) {
               String var3x = (String)var3.get(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName());
               if (StringHelper.isNullOrEmpty(var3x)) {
                  var3x = var4.getAttribute("SRFKEY", "");
                  var3.set(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName(), var3x);
               }

               if (var3x.indexOf("SRFTEMPKEY:") != 0) {
                  PSCoreSysServiceBase.this.get(var3);
               } else {
                  PSCoreSysServiceBase.this.getTemp(var3);
               }

               var2x.setEntity(PSCoreSysServiceBase.this.getDEModel(), var3x, var3);
            } else {
               PSCoreSysServiceBase.this.importCurXmlModel(var3, var4);
            }

            PSCoreSysServiceBase.this.importRelatedXmlModel(var3, var4);
         }
      });
      return (ET)var3;
   }

   protected void importCurXmlModel(ET var1, XmlNode var2) throws Exception {
      DataObject.fromXmlNode(var1, var2);
      this.onImportCurXmlModel((ET)var1, var2);
   }

   protected void onImportCurXmlModel(ET var1, XmlNode var2) throws Exception {
      CloneSession var3 = CloneSessionManager.getCurrentSession();
      this.createTemp((ET)var1);
      Object var4 = var1.get(this.getDEModel().getKeyDEField().getName());
      var3.setEntity(this.getDEModel(), var4, var1);
      var2.setAttribute(this.getDEModel().getKeyDEField().getName(), DataObject.getStringValue(var4));
   }

   protected void importRelatedXmlModel(ET var1, XmlNode var2) throws Exception {
      this.onImportRelatedXmlModel((ET)var1, var2);
   }

   protected void onImportRelatedXmlModel(ET var1, XmlNode var2) throws Exception {
   }

   @Override
   public IDAO getDAO() {
      return null;
   }

   @Override
   public void getTempMajor(ET var1) throws Exception {
      if (WebContext.getCurrent() != null) {
         JSONObject var2 = WebContext.getActiveData();
         if (var2 != null) {
            String var3 = var2.optString("srfkey");
            if (!StringHelper.isNullOrEmpty(var3)) {
               var1.set(this.getDEModel().getKeyDEField().getName(), var3);
               this.getTemp((ET)var1);
               return;
            }
         }
      }

      super.getTempMajor((ET)var1);
   }

   protected void syncSysTask(ET var1, boolean var2) throws Exception {
      if (StringHelper.compare(this.getDEModel().getName(), "PSSYSTASK", true) != 0) {
         if (this.getDEModel().getDEField("TODOTASK", true) != null) {
            if (!var2 && !var1.contains("TODOTASK")) {
               return;
            }

            Object var3 = this.getDataContextValue((ET)var1, "pssystemid", null);
            if (var3 == null) {
               var3 = DataContextMethod.getValue("pssystemid", this.getSessionFactory());
            }

            if (var3 == null) {
               var3 = getCurrentPSSystemId();
            }

            if (var3 == null) {
               throw new Exception("无法获取当前系统");
            }

            PSSysTaskService var4 = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, this.getSessionFactory());
            String var5 = KeyValueHelper.genUniqueId(
               this.getDEModel().getId(), (String)var3, DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()))
            );
            PSSysTask var6 = new PSSysTask();
            var6.setPSSysTaskId(var5);
            boolean var7 = false;
            if (var4.checkKey(var6) == 1) {
               var7 = true;
            }

            String var8 = DataObject.getStringValue(var1.get("TODOTASK"));
            if (!var2 && !StringHelper.isNullOrEmpty(var8)) {
               var6.setModelTypeId(this.getDEModel().getName());
               var6.setModelTypeName(this.getDEModel().getLogicName());
               var6.setPSObjId(DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName())));
               var6.setPSObjName(this.getDEModel().getDataInfo((ET)var1));
               var6.setPSSystemId((String)var3);
               var6.setPSDEId(DataObject.getStringValue(var1.get("PSDEID")));
               var6.setPSDEName(DataObject.getStringValue(var1.get("PSDENAME")));
               var6.setPSSysAppId(DataObject.getStringValue(var1.get("PSSYSAPPID")));
               var6.setPSSysAppName(DataObject.getStringValue(var1.get("PSSYSAPPNAME")));
               if (this.getDEModel().getDEField("PSSYSREQITEMID", true) != null) {
                  var6.setPSSysReqItemId(DataObject.getStringValue(var1.get("PSSYSREQITEMID")));
                  var6.setPSSysReqItemName(DataObject.getStringValue(var1.get("PSSYSREQITEMNAME")));
               }

               var6.setToDoTaskInfo(var8);
               if (var8.length() > 100) {
                  var6.setPSSysTaskName(var8.substring(0, 90) + "...");
               } else {
                  var6.setPSSysTaskName(var8);
               }

               if (var7) {
                  var4.update(var6, false);
               } else {
                  var4.create(var6, false);
               }
            } else if (var7) {
               var4.remove(var6);
            }
         }
      }
   }

   public static void setCurrentPSDevSlnId(String var0) {
      if (StringHelper.isNullOrEmpty(var0)) {
         curPSDevSlnId.set(null);
      } else {
         curPSDevSlnId.set(var0);
      }
   }

   public static String getCurrentPSDevSlnId() {
      return curPSDevSlnId.get();
   }

   public static void setCurrentPSDevSlnSysId(String var0) {
      if (StringHelper.isNullOrEmpty(var0)) {
         curPSDevSlnSysId.set(null);
      } else {
         curPSDevSlnSysId.set(var0);
      }
   }

   public static String getCurrentPSDevSlnSysId() {
      return curPSDevSlnSysId.get();
   }

   public static void setCurrentPSDynaInstId(String var0) {
      if (StringHelper.isNullOrEmpty(var0)) {
         curPSDynaInstId.set(null);
      } else {
         curPSDynaInstId.set(var0);
      }
   }

   public static String getCurrentPSDynaInstId() {
      return curPSDynaInstId.get();
   }

   public static void setCurrentPSSystemId(String var0) {
      if (StringHelper.isNullOrEmpty(var0)) {
         curPSSystemId.set(null);
      } else {
         curPSSystemId.set(var0);
      }
   }

   public static String getCurrentPSSystemId() {
      return curPSSystemId.get();
   }

   public static void setCurrentPSDCId(String var0) {
      if (StringHelper.isNullOrEmpty(var0)) {
         curPSDCId.set(null);
      } else {
         curPSDCId.set(var0);
      }
   }

   public static String getCurrentPSDCId() {
      return curPSDCId.get();
   }

   public static void setCurrentPSSvrDomainId(String var0) {
      strPSSvrDomainId = var0;
   }

   public static String getCurrentPSSvrDomainId() {
      return strPSSvrDomainId;
   }

   public static void setDefaultPSSvrDomainId(String var0) {
      strPSSvrDomainId = var0;
   }

   public static String getDefaultPSSvrDomainId() {
      return strPSSvrDomainId;
   }

   public static void setRecyclePSDCId(String var0) {
      strRecyclePSDCId = var0;
   }

   public static String getRecyclePSDCId() {
      return strRecyclePSDCId;
   }

   public static boolean isPrivateCloudMode() {
      return bPrivateCloudMode;
   }

   public static void setPrivateCloudMode(boolean var0) {
      bPrivateCloudMode = var0;
   }

   public static boolean isCloudMode() {
      return bCloudMode;
   }

   public static void setCloudMode(boolean var0) {
      bCloudMode = var0;
   }

   public static String getProxyTaskServerUrl() {
      return strProxyTaskServerUrl;
   }

   public static void setProxyTaskServerUrl(String var0) {
      strProxyTaskServerUrl = var0;
   }

   public static boolean isMOSMode() {
      return bMOSMode;
   }

   public static void setMOSMode(boolean var0) {
      bMOSMode = var0;
   }

   public static int getMOSVer() {
      return nMOSVersion;
   }

   public static void setMOSVer(int var0) {
      nMOSVersion = var0;
   }

   public static void setCurMajorSessionFactory(SessionFactory var0) {
      curMajorSessionFactory.set(var0);
   }

   public static SessionFactory getCurMajorSessionFactory() {
      return curMajorSessionFactory.get();
   }

   public static boolean isMajorSessionFactory(SessionFactory var0) {
      return getCurMajorSessionFactory() == var0;
   }

   public static void reloadHotCodes() throws Exception {
      psModelHotCodeHelper.reloadHotCodes();
   }

   public static void beginImpSysModel(PSSystem var0) {
      impSysModelSystem.set(var0);
   }

   public static void endImpSysModel() {
      endImpSysModel(false);
   }

   public static void endImpSysModel(boolean var0) {
      PSSystem var1 = impSysModelSystem.get();
      if (var1 != null) {
         impSysModelSystem.set(null);
         if (!var0) {
            try {
               PSSysModelLogService var2 = (PSSysModelLogService)ServiceGlobal.getService(PSSysModelLogService.class, var1.getSessionFactory());

               for (String var4 : sysModelLogMap.keySet()) {
                  PSSysModelLog var5 = new PSSysModelLog();
                  var5.setPSSystemId(var1.getPSSystemId());
                  var5.setPSSystemName("(N/A)");
                  var5.setPSSysModelLogName(var4);
                  var2.save(var5, false);
               }
            } catch (Exception var7) {
               log.error(var7.getMessage(), var7);
            }

            try {
               PSSystemService var8 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, var1.getSessionFactory());
               String var9 = StringHelper.format("UPDATE T_SRFPSSYSTEM SET MODELVER=MODELVER+1 WHERE PSSYSTEMID=?");
               SqlParamList var10 = new SqlParamList();
               var10.add(var1.getPSSystemId(), 25);
               var8.getDAO().executeRawSql(null, var9, var10);
            } catch (Exception var6) {
               log.error(var6.getMessage(), var6);
            }
         }
      }
   }

   public static boolean isImpSysModelNow() {
      IEntity var0 = impSysModelSystem.get();
      return var0 != null;
   }

   public static boolean isImpSysModelNowEx() {
      IEntity var0 = impSysModelSystem.get();
      return var0 != null || ImportSessionManager.getCurrentSession() != null;
   }

   @Override
   protected String onImportCurModel(ET var1, JSONObject var2) throws Exception {
      if (!isImpSysModelNow()) {
         return super.onImportCurModel((ET)var1, var2);
      }

      IPSDataEntityModel var3 = this.getDEModel();
      IEntity var4 = var3.createEntity();
      var4.set(var3.getKeyDEField().getName(), var1.get(var3.getKeyDEField().getName()));
      if (this.get((ET)var4, true)) {
         if (!diffDEData(var3, var1, var4)) {
            this.setLast(var1, var4, true);
            this.update((ET)var1, false);
         }
      } else {
         this.create((ET)var1, false);
      }

      return null;
   }

   public static boolean diffDEData(IDataEntityModel var0, IEntity var1, IEntity var2) throws Exception {
      Iterator var3 = var0.getDEFields();

      while (var3.hasNext()) {
         IDEField var4 = (IDEField)var3.next();
         if (var4.isPhisicalDEField()
            && StringHelper.compare(var4.getPreDefinedType(), "CREATEDATE", true) != 0
            && StringHelper.compare(var4.getPreDefinedType(), "CREATEMAN", true) != 0
            && StringHelper.compare(var4.getPreDefinedType(), "CREATEMANNAME", true) != 0
            && StringHelper.compare(var4.getPreDefinedType(), "LOGICVALID", true) != 0
            && StringHelper.compare(var4.getPreDefinedType(), "UPDATEDATE", true) != 0
            && StringHelper.compare(var4.getPreDefinedType(), "UPDATEMAN", true) != 0
            && StringHelper.compare(var4.getPreDefinedType(), "UPDATEMANNAME", true) != 0
            && StringHelper.compare(var4.getDataType(), "PICKUP", true) != 0) {
            Object var5 = var1.get(var4.getName());
            Object var6 = var2.get(var4.getName());
            if ((var5 != null || var6 != null) && (var5 == null || var6 == null || DataTypeHelper.compare(var4.getStdDataType(), var5, var6) != 0L)) {
               return false;
            }
         }
      }

      return true;
   }

   public static PSSystem getCurrentPSSystem(SessionFactory var0) throws Exception {
      return getCurrentPSSystem(null, var0);
   }

   public static PSSystem getCurrentPSSystem(IEntity var0, SessionFactory var1) throws Exception {
      return getCurrentPSSystem(var0, var1, false);
   }

   public static PSSystem getCurrentPSSystem(IEntity var0, SessionFactory var1, boolean var2) throws Exception {
      Object var3 = getCurrentPSSystemId();
      if (var3 == null && var0 != null) {
         var3 = var0.get("pssystemid");
      }

      if (var3 == null) {
         var3 = DataContextMethod.getValue("pssystemid", var1);
      }

      if (var3 == null) {
         if (var2) {
            return null;
         } else {
            throw new Exception("无法获取当前系统标识");
         }
      } else {
         String var4 = StringHelper.format("SYS_%1$s_%2$s", var3, var1);
         IWebContext var5 = net.ibizsys.paas.web.WebContext.getCurrent();
         if (var5 != null) {
            Object var6 = var5.getAttribute(var4);
            if (var6 != null) {
               return (PSSystem)var6;
            }
         } else {
            ActionSession var8 = ActionSessionManager.getCurrentSession(false);
            if (var8 != null) {
               Object var7 = var8.getActionParam(var4);
               if (var7 != null) {
                  return (PSSystem)var7;
               }
            }
         }

         PSSystem var9 = new PSSystem();
         PSSystemService var10 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, var1);
         var9.setPSSystemId((String)var3);
         var10.get(var9);
         if (var5 != null) {
            var5.setAttribute(var4, var9);
         } else {
            ActionSession var11 = ActionSessionManager.getCurrentSession(false);
            if (var11 != null) {
               var11.setActionParam(var4, var9);
            }
         }

         return var9;
      }
   }

   public static PSSysSFPub getCurrentDefaultPSSysSFPub(IEntity var0, SessionFactory var1) throws Exception {
      PSSystem var2 = getCurrentPSSystem(var0, var1, true);
      if (var2 == null) {
         return null;
      }

      String var3 = StringHelper.format("SYSSFPUB_%1$s_%2$s", var2.getPSSystemId(), var1);
      IWebContext var4 = net.ibizsys.paas.web.WebContext.getCurrent();
      if (var4 != null) {
         Object var5 = var4.getAttribute(var3);
         if (var5 != null) {
            if (invalidPSSysSFPub == var5) {
               return null;
            }

            return (PSSysSFPub)var5;
         }
      } else {
         ActionSession var7 = ActionSessionManager.getCurrentSession(false);
         if (var7 != null) {
            Object var6 = var7.getActionParam(var3);
            if (var6 != null) {
               if (invalidPSSysSFPub == var6) {
                  return null;
               }

               return (PSSysSFPub)var6;
            }
         }
      }

      PSSysSFPub var8 = new PSSysSFPub();
      PSSysSFPubService var9 = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, var1);
      var8.setPSSystemId(var2.getPSSystemId());
      var8.setDefaultPub(1);
      if (!var9.selectOne(var8, true)) {
         var8 = invalidPSSysSFPub;
      }

      if (var4 != null) {
         var4.setAttribute(var3, var8);
      } else {
         ActionSession var10 = ActionSessionManager.getCurrentSession(false);
         if (var10 != null) {
            var10.setActionParam(var3, var8);
         }
      }

      return invalidPSSysSFPub == var8 ? null : var8;
   }

   public static boolean isExtractDefault(SessionFactory var0) throws Exception {
      PSSystem var1 = getCurrentPSSystem(null, var0);
      return DataObject.getBoolValue(var1.getExtractDefault(), false);
   }

   @Override
   public void copyDetails(ET var1, Object var2) throws Exception {
      String var3 = denyCopyMap.get(this.getDEModel().getName());
      if (!StringHelper.isNullOrEmpty(var3)) {
         IPSDEFieldModel var4 = this.getDEModel().getDEField(var3, false);
         Object var5 = var1.get(var3);
         if (StringHelper.isNullOrEmpty(var5)) {
            IEntity var6 = this.getDEModel().createEntity();
            var6.set(this.getDEModel().getKeyDEField().getName(), var1.get(this.getDEModel().getKeyDEField().getName()));
            this.get((ET)var6);
            var5 = var1.get(var3);
         }

         IEntity var8 = this.getDEModel().createEntity();
         var8.set(this.getDEModel().getKeyDEField().getName(), var2);
         this.get((ET)var8);
         Object var7 = var8.get(var3);
         if (DataTypeHelper.compare(var4.getStdDataType(), var7, var5) != 0L) {
            throw new Exception(StringHelper.format("[%1$s]不能跨[%2$s]拷贝", this.getDEModel().getLogicName(), var4.getLogicName()));
         }
      }

      super.copyDetails((ET)var1, var2);
   }

   protected void resetPSSysModelLogs(String var1) {
      try {
         PSSysModelLogService var2 = (PSSysModelLogService)ServiceGlobal.getService(PSSysModelLogService.class, this.getSessionFactory());
         String var3 = StringHelper.format("UPDATE T_SRFPSSYSMODELLOG SET UPDATEDATE = ? WHERE PSSYSTEMID=?");
         SqlParamList var4 = new SqlParamList();
         var4.addDateTime(new Timestamp(System.currentTimeMillis()));
         var4.add(var1, 25);
         var2.getDAO().executeRawSql(null, var3, var4);
      } catch (Exception var5) {
         log.error(var5.getMessage(), var5);
      }
   }

   protected void logSysConsole(String var1, String var2, String var3) {
      try {
         PSSysConsole var4 = new PSSysConsole();
         if (StringHelper.isNullOrEmpty(var2)) {
            var2 = this.getDEModel().getLogicName();
         }

         if (StringHelper.length(var3) > 4000) {
            var3 = var3.substring(0, 3920) + "...";
         }

         if (StringHelper.compare(var1, "INFO", false) == 0) {
            log.info(StringHelper.format("[CONSOLE][%1$s]%2$s", var2, var3));
         } else if (StringHelper.compare(var1, "WARN", false) == 0) {
            log.warn(StringHelper.format("[CONSOLE][%1$s]%2$s", var2, var3));
         } else if (StringHelper.compare(var1, "ERROR", false) == 0) {
            log.error(StringHelper.format("[CONSOLE][%1$s]%2$s", var2, var3));
         }

         var4.setLogTime(new Timestamp(System.currentTimeMillis()));
         var4.setPSSysConsoleName(var2);
         var4.setLogLevel(var1);
         var4.setLogInfo(var3);
         String var5 = getCurrentPSSystemId();
         if (StringHelper.isNullOrEmpty(var5)) {
            var5 = (String)DataContextMethod.getValue("pssystemid", this.getSessionFactory());
         }

         if (StringHelper.isNullOrEmpty(var5)) {
            var5 = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
         }

         var4.setPSSystemId(var5);
         var4.setPSSystemName("系统名称");
         PSSysConsoleService var6 = (PSSysConsoleService)ServiceGlobal.getService(PSSysConsoleService.class, this.getSessionFactory());
         var6.create(var4, false);
      } catch (Exception var7) {
         log.error(var7);
      }
   }

   public PSCoreSysServiceBase.ISysConsole getConsole() {
      return this.iSysConsole;
   }

   @Override
   protected void onExportCurModel(ET var1, ArrayList<JSONObject> var2, int var3) throws Exception {
      var1.remove("CREATEDATE");
      var1.remove("CREATEMAN");
      var1.remove("UPDATEMAN");
      var1.remove("UPDATEDATE");
      var1.remove("LOCKFLAG");
      super.onExportCurModel((ET)var1, var2, var3);
   }

   protected String getCurrentPSSystemId(IEntity var1) throws Exception {
      return this.getCurrentPSSystemId(var1, false);
   }

   protected String getCurrentPSSystemId(IEntity var1, boolean var2) throws Exception {
      Object var3 = null;
      if (var3 == null && var1 != null) {
         var3 = var1.get("pssystemid");
      }

      if (var3 == null) {
         var3 = getCurrentPSSystemId();
      }

      if (var3 == null && var1 != null) {
         var3 = this.getDataContextValue((ET)var1, "pssystemid", null);
      }

      if (var3 == null) {
         var3 = DataContextMethod.getValue("pssystemid", this.getSessionFactory());
      }

      if (var3 == null) {
         if (var2) {
            return null;
         } else {
            throw new Exception("无法获取当前系统标识");
         }
      } else {
         return (String)var3;
      }
   }

   protected String getCurrentPSDevSlnSysId(IEntity var1, boolean var2) throws Exception {
      Object var3 = null;
      if (var3 == null && var1 != null) {
         var3 = var1.get("psdevslnsysid");
      }

      if (var3 == null) {
         var3 = getCurrentPSDevSlnSysId();
      }

      if (var3 == null && WebContext.getAppData() != null) {
         var3 = WebContext.getAppData().opt("psdevslnsysid");
      }

      if (var3 == null) {
         if (var2) {
            return null;
         } else {
            throw new Exception("无法获取当前开发系统标识");
         }
      } else {
         return (String)var3;
      }
   }

   protected String getCurrentPSDynaInstId(IEntity var1, boolean var2) throws Exception {
      Object var3 = null;
      if (var3 == null && var1 != null) {
         var3 = var1.get("psdynainstid");
      }

      if (var3 == null) {
         var3 = getCurrentPSDynaInstId();
      }

      if (var3 == null && WebContext.getAppData() != null) {
         var3 = WebContext.getAppData().opt("psdynainstid");
      }

      if (var3 == null) {
         if (var2) {
            return null;
         } else {
            throw new Exception("无法获取当前动态实例标识");
         }
      } else {
         return (String)var3;
      }
   }

   @Override
   protected String getRemoveRejectMsg(String var1, String var2, String var3, String var4, String var5, Object var6) throws Exception {
      String var7 = var2;
      if (StringHelper.isNullOrEmpty(var7)) {
         IDataEntityModel var8 = this.getSystemModel().getDataEntityModel(var4);
         var7 = var8.getLogicName();
         if (isMOSMode() && PSModelV2Helper.containsModelV2(var4)) {
            if (var6 != null && var6 instanceof IEntity) {
               IPSMOSFileService var12 = (IPSMOSFileService)var8.getService(this.getSessionFactory());
               IEntity var10 = var8.createEntity();
               ((IEntity)var6).copyTo(var10, false);
               PSMOSFile var11 = var12.getFile(var10);
               var7 = StringHelper.format("[%1$s]%2$s", var7, var11.getPSMOSFileId());
            }
         } else if (var6 != null && var6 instanceof IEntity) {
            String var9 = this.getRemoveRejectMsgRefDataInfo(var8, var6);
            if (!StringHelper.isNullOrEmpty(var9)) {
               var7 = StringHelper.format("%1$s-%2$s", var7, var9);
            }
         }
      }

      return this.getLocalization(
         "CTRL.SERVICE.GETREMOVEREJECTMSG_INFO",
         new Object[]{this.getSystemModel().getDataEntityModel(var3).getLogicName(), var5, var7},
         StringHelper.format("%1$s[%2$s]存在关系数据[%3$s]，无法删除！", this.getSystemModel().getDataEntityModel(var3).getLogicName(), var5, var7)
      );
   }

   protected String getRemoveRejectMsgRefDataInfo(IDataEntityModel var1, Object var2) throws Exception {
      if (var2 != null && var2 instanceof IEntity) {
         StringBuilderEx var3 = new StringBuilderEx();
         if (var2 instanceof PSDEDSDQ) {
            PSDEDSDQ var4 = (PSDEDSDQ)var2;
            PSDEDataSet var5 = var4.getPSDEDataSet();
            PSDataEntity var6 = var5.getPSDE();
            if (var6 != null) {
               var3.append("%1$s/", var6.getPSDataEntityName());
            }

            if (var5 != null) {
               var3.append("%1$s/", var5.getPSDEDataSetName());
            }
         } else if (var2 instanceof PSDEFormDetail) {
            PSDEFormDetail var7 = (PSDEFormDetail)var2;
            PSDEForm var10 = var7.getPSDEForm();
            PSDataEntity var13 = var10.getPSDE();
            if (var13 != null) {
               var3.append("%1$s/", var13.getPSDataEntityName());
            }

            if (var10 != null) {
               var3.append("%1$s/", var10.getPSDEFormName());
            }
         } else if (var2 instanceof PSDEGridCol) {
            PSDEGridCol var8 = (PSDEGridCol)var2;
            PSDEGrid var11 = var8.getPSDEGrid();
            PSDataEntity var14 = var11.getPSDE();
            if (var14 != null) {
               var3.append("%1$s/", var14.getPSDataEntityName());
            }

            if (var11 != null) {
               var3.append("%1$s/", var11.getPSDEGridName());
            }
         } else if (var2 instanceof PSDEViewCtrl) {
            PSDEViewCtrl var9 = (PSDEViewCtrl)var2;
            PSDEViewBase var12 = var9.getPSDEViewBase();
            PSDataEntity var15 = var12.getPSDE();
            if (var15 != null) {
               var3.append("%1$s/", var15.getPSDataEntityName());
            }

            if (var12 != null) {
               var3.append("%1$s/", var12.getPSDEViewBaseName());
            }
         }

         var3.append("%1$s", var1.getDataInfo((ET)var2));
         return var3.toString();
      } else {
         return null;
      }
   }

   @Override
   public String getDataSummary(ET var1) throws Exception {
      String var2 = PSModelSummaryHelper.getPSModelSummary(this.getDEModel(), var1);
      return !StringHelper.isNullOrEmpty(var2) ? var2 : super.getDataSummary((ET)var1);
   }

   @Override
   public void updateTempMajor(ET var1) throws Exception {
      if (this.isUseServiceAPI()) {
         this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "UPDATETEMPMAJOR"), var1);
      } else {
         final ET var2 = var1;
         var2.setSessionFactory(this.getSessionFactory());
         final Object var3 = var1.get("SRFSOURCEKEY");
         final Object var4 = var1.get("SRFENTITYKEY");
         this.doServiceWork(
            new IServiceWork() {
               @Override
               public void execute(ITransaction var1) throws Exception {
                  CloneSession var2x = CloneSessionManager.getCurrentSession();
                  Object var3x = var2.get("srfupdatedate");
                  PSCoreSysServiceBase.this.updateTemp(var2);
                  ET var4x = PSCoreSysServiceBase.this.getDEModel().createEntity();
                  var2.copyTo(var4x, false);
                  var4x.remove(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName());
                  PSCoreSysServiceBase.this.replaceParentInfo(var4x, var2x);
                  JSONObject var5 = new JSONObject();
                  var4x.fillJSONObject(var5, false);
                  Iterator var6 = var5.keys();

                  while (var6.hasNext()) {
                     String var7 = (String)var6.next();
                     Object var8 = var5.get(var7);
                     if (var8 != null && var8 instanceof String && KeyValueHelper.isTempKey((String)var8)) {
                        PSCoreSysServiceBase.log.warn(StringHelper.format("临时数据[%1$s]属性[%2$s]为临时数据", PSCoreSysServiceBase.this.getDEModel().getName(), var7));
                        return;
                     }
                  }

                  Object var11 = var2.get("SRFORIKEY");
                  if (var4 != null) {
                     var4x.set("SRFENTITYKEY", var4);
                  }

                  if (StringHelper.isNullOrEmpty(var11)) {
                     PSCoreSysServiceBase.this.create(var4x);
                     var2.set("SRFORIKEY", var4x.get(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName()));
                     HashMap<String, Object> var12 = new HashMap<String, Object>();
                     var4x.fillMap(var12, false);

                     for (String var14 : var12.keySet()) {
                        Object var9 = var12.get(var14);
                        if (var2.contains(var14)) {
                           Object var10 = var2.get(var14);
                           if (var10 == null && var9 != null) {
                              var2.set(var14, var9);
                           }
                        }
                     }

                     PSCoreSysServiceBase.this.updateTemp(var2);
                  } else {
                     var4x.set(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName(), var11);
                     if (var3x != null) {
                        var4x.set("srfupdatedate", var3x);
                     }

                     if (PSCoreSysServiceBase.this.checkKey(var4x) == 0) {
                        PSCoreSysServiceBase.this.create(var4x);
                     } else {
                        PSCoreSysServiceBase.this.update(var4x);
                     }

                     if (var3x != null) {
                        var4x.set("srfupdatedate", var3x);
                     }
                  }

                  var2x.setEntity(PSCoreSysServiceBase.this.getDEModel(), var2.get(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName()), var4x);
                  PSCoreSysServiceBase.this.beginMergeChild(var4x);
                  PSCoreSysServiceBase.this.updateRelatedDataTempMajor(var2, var4x);
                  if (StringHelper.isNullOrEmpty(var11) && !StringHelper.isNullOrEmpty(var3)) {
                     PSCoreSysServiceBase.this.copyDetails(var4x, var3);
                  }

                  PSCoreSysServiceBase.this.endMergeChild(var4x, true);
                  PSCoreSysServiceBase.this.onAfterUpdateTempMajor(var4x);
                  var2.set(
                     PSCoreSysServiceBase.this.getDEModel().getUpdateDateDEField().getName(),
                     var4x.get(PSCoreSysServiceBase.this.getDEModel().getUpdateDateDEField().getName())
                  );
               }
            }
         );
      }
   }

   @Override
   public boolean fillEntityKeyValue(ET var1, boolean var2) throws Exception {
      if (PSCoreSysModel.isEnableFolderKey() && !var2 && this.getSessionFactory() != getCurMajorSessionFactory()) {
         String var3 = this.getDEModel().getKeyDEField().getName();
         Object var4 = var1.get(var3);
         if (var4 != null) {
            return true;
         }

         if (!this.isIgnoreFolderKey((ET)var1)) {
            boolean var5 = false;
            PSSystem var6 = getCurrentPSSystem(var1, this.getSessionFactory(), true);
            if (var6 != null && DataObject.getBoolValue(var6.getEnableFolderKey(), false)) {
               var5 = true;
            }

            if (var5) {
               var4 = this.getEntityFolderKeyValue((ET)var1, var6);
               if (var4 != null) {
                  var1.set(var3, var4);
                  return true;
               }
            }
         }
      }

      return super.fillEntityKeyValue((ET)var1, var2);
   }

   protected String getEntityFolderKeyValue(ET var1, PSSystem var2) throws Exception {
      return PSModelFolderKeyHelper.getModelKey(var1, var2, this.getDEModel().getName(), "", this.getSessionFactory());
   }

   protected boolean isIgnoreFolderKey(ET var1) {
      return PSModelFolderKeyHelper.isIgnoreModel(this.getDEModel().getName());
   }

   protected boolean isEnableFolderKey(IEntity var1) throws Exception {
      return false;
   }

   protected boolean isEnableNoViewMode(IEntity var1) throws Exception {
      PSSystem var2 = getCurrentPSSystem(var1, this.getSessionFactory());
      return DataObject.getBoolValue(var2.getNoViewMode(), false);
   }

   protected boolean isEnableHBaseModelInst() {
      return false;
   }

   @Override
   protected CallResult internalGetTemp(ET var1, boolean var2) throws Exception {
      try {
         return super.internalGetTemp((ET)var1, var2);
      } catch (Exception var5) {
         if (this.getRealSessionFactory() instanceof IPSDBServerSessionFactory) {
            IPSDBServerSessionFactory var4 = (IPSDBServerSessionFactory)this.getRealSessionFactory();
            if (StringHelper.compare(var4.getRealDBName(), "SRFNODB", false) != 0) {
               log.error(StringHelper.format("查询临时数据发生异常，当前数据源[%1$s]，%2$s", var4.getRealDBName(), var5.getMessage()), var5);
            }
         }

         throw var5;
      }
   }

   @Override
   protected CallResult internalGet(ET var1, boolean var2, int var3) throws Exception {
      return super.internalGet((ET)var1, var2, var3);
   }

   @Override
   protected void internalCreate(ET var1) throws Exception {
      super.internalCreate((ET)var1);
   }

   @Override
   protected void internalUpdate(ET var1) throws Exception {
      super.internalUpdate((ET)var1);
      this.updateModelKeeper((ET)var1);
   }

   @Override
   protected void internalSysUpdate(ET var1) throws Exception {
      super.internalSysUpdate((ET)var1);
      this.logSysModelChanged((ET)var1, "UPDATE");
      this.logModelObjChanged((ET)var1, "UPDATE");
      this.updateModelKeeper((ET)var1);
   }

   @Override
   protected void internalRemove(ET var1) throws Exception {
      super.internalRemove((ET)var1);
      this.removeModelKeeper((ET)var1);
   }

   @Override
   protected ArrayList<ET> internalSelect(ISelectCond var1) throws Exception {
      return super.internalSelect(var1);
   }

   @Override
   public int checkKey(ET var1) throws Exception {
      return super.checkKey((ET)var1);
   }

   @Override
   public void save(ET var1, int var2, boolean var3) throws Exception {
      super.save((ET)var1, var2, var3);
   }

   @Override
   public void create(ET var1, boolean var2) throws Exception {
      if (getCurrentPSSystemId() != null) {
         String var3 = getCurrentPSSystemId();
         if (!StringHelper.isNullOrEmpty(var3)
            && StringHelper.compare(this.getDEModel().getName(), "PSSYSTEM", false) != 0
            && this.getDEModel().getDEField("PSSYSTEMID", true) != null) {
            var1.set("PSSYSTEMID", var3);
         }
      }

      boolean var12 = EntityBase.isIgnoreCheck(var1);

      try {
         super.create((ET)var1, var2);
      } catch (Exception var11) {
         if (var11 instanceof EntityException) {
            EntityException var5 = (EntityException)var11;
            if (var5.getErrorCode() == 6) {
               Iterator var6 = this.getDEModel().getUnionKeyValueDEFields();
               if (var6 != null) {
                  EntityError var7 = new EntityError();

                  while (var6.hasNext()) {
                     IDEField var8 = (IDEField)var6.next();
                     EntityFieldError var9 = new EntityFieldError();
                     var9.setFieldName(var8.getName());
                     if (this.getWebContext() != null) {
                        var9.setFieldLogicName(var8.getLogicName(this.getWebContext().getLocalization()));
                     } else {
                        var9.setFieldLogicName(var8.getLogicName());
                     }

                     var9.setErrorType(3);
                     if (!"PSSYSTEMID".equalsIgnoreCase(var8.getName())) {
                        Object var10 = var1.get(var8.getName());
                        var9.setErrorInfo(this.getLocalization("CTRL.SERVICE.CHECKFIELDDUPRULE_INFO", new Object[]{var10}, String.format("值[%1$s]重复", var10)));
                        var7.register(var9);
                     }
                  }

                  String var13 = this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format("数据已经存在，无法再次建立"));
                  ActionSession var17 = ActionSessionManager.getCurrentSession();
                  if (var17 != null && StringHelper.compare(var17.getName(), this.getDEModel().getName(), true) != 0) {
                     var13 = this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format("数据已经存在，无法再次建立"));
                     if (!StringHelper.isNullOrEmpty(var13)) {
                        var13 = StringHelper.format("[%1$s]%2$s。", this.getDEModel().getLogicName(), var13);
                        var13 = var13 + var7.toString();
                        throw new EntityException(var7, 6, var13, this.getDEModel());
                     }
                  }

                  throw new EntityException(
                     var7, 6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format("数据已经存在，无法再次建立")), this.getDEModel()
                  );
               }
            }
         }

         throw var11;
      }
   }

   @Override
   public void createTemp(ET var1) throws Exception {
      if (getCurrentPSSystemId() != null) {
         String var2 = getCurrentPSSystemId();
         if (!StringHelper.isNullOrEmpty(var2)
            && StringHelper.compare(this.getDEModel().getName(), "PSSYSTEM", false) != 0
            && this.getDEModel().getDEField("PSSYSTEMID", true) != null) {
            var1.set("PSSYSTEMID", var2);
         }
      }

      super.createTemp((ET)var1);
   }

   @Override
   public void update(ET var1, boolean var2) throws Exception {
      boolean var3 = EntityBase.isIgnoreCheck(var1);
      super.update((ET)var1, var2);
   }

   @Override
   public void mergeChild(String var1, String var2, Object var3) throws Exception {
      if (!isImpSysModelNowEx() && !this.getDEModel().isNoViewMode()) {
         if (isEnableMergeCount() || StringHelper.compare(this.getDEModel().getName(), "PSCODEITEM", true) == 0) {
            super.mergeChild(var1, var2, var3);
         }
      }
   }

   @Override
   protected DBFetchResult doServiceFetchWork(IDEDataSetFetchContext var1, String var2, boolean var3) throws Exception {
      DBFetchResult var4 = super.doServiceFetchWork(var1, var2, var3);
      if (var4 != null && var4.getRetCode() == 0 && var1.isCacheDataSet()) {
      }

      return var4;
   }

   public void fillXmlNode(IEntity var1, XmlNode var2, boolean var3) throws Exception {
      var1.set("ENABLE", null);
      var1.set("CREATEMAN", null);
      var1.set("CREATEDATE", null);
      var1.set("UPDATEMAN", null);
      var1.set("UPDATEDATE", null);
      var1.set("SRFORIKEY", null);
      var1.set("SRFDRAFTFLAG", null);
      var1.set("DYNAMODELFLAG", null);
      var1.set("PSDYNAINSTID", null);
      var1.fillXmlNode(var2, var3);
   }

   @Override
   public void updateParent(ET var1) throws Exception {
      if (var1 != null) {
         String var2 = (String)var1.get(this.getDEModel().getKeyDEField().getName());
         if (!StringHelper.isNullOrEmpty(var2)) {
            if (!KeyValueHelper.isTempKey(var2) || StringHelper.compare(this.getDEModel().getName(), "PSCODEITEM", true) == 0) {
               if (isEnableMergeCount() || StringHelper.compare(this.getDEModel().getName(), "PSCODEITEM", true) == 0) {
                  super.updateParent((ET)var1);
               }
            }
         }
      }
   }

   @Override
   public void getDraft(ET var1) throws Exception {
      Object var2 = var1.get(this.getDEModel().getKeyDEField().getName());
      if (!StringHelper.isNullOrEmpty(var2)) {
         this.getDraftFrom((ET)var1);
      } else {
         super.getDraft((ET)var1);
         this.fillGetDraftDefaultValue((ET)var1, false);
      }
   }

   @Override
   public void getDraftTemp(ET var1) throws Exception {
      Object var2 = var1.get(this.getDEModel().getKeyDEField().getName());
      if (!StringHelper.isNullOrEmpty(var2)) {
         this.getDraftTempFrom((ET)var1);
      } else {
         super.getDraftTemp((ET)var1);
         this.fillGetDraftDefaultValue((ET)var1, true);
      }
   }

   @Override
   public boolean existsData(ET var1) throws Exception {
      SelectContext var2 = new SelectContext();
      HashMap<String, Object> var3 = new HashMap<String, Object>();
      var1.fillMap(var3, true);

      for (Entry<String, Object> var5 : var3.entrySet()) {
         if (var5.getValue() != null && var5.getValue() != DataObject.EMPTY) {
            var2.set((String)var5.getKey(), var5.getValue());
         } else {
            var2.setIsNull((String)var5.getKey());
         }
      }

      var2.setFetchFirst(true);
      String var6 = this.getDEModel().getKeyDEField().getName();
      var2.addSelectField(var6);
      ArrayList<ET> var7 = this.select(var2);
      if (var7.size() == 0) {
         return false;
      }

      var1.set(var6, (var7.get(0)).get(var6));
      return true;
   }

   public static void setEnableMergeCount(boolean var0) {
      bEnableMergeCount = var0;
   }

   public static boolean isEnableMergeCount() {
      return bEnableMergeCount;
   }

   public static void setEnableI18NDefault(boolean var0) {
      bEnableI18NDefault = var0;
   }

   public static boolean isEnableI18NDefault() {
      return bEnableI18NDefault;
   }

   public static void setEnableStateInformDefault(boolean var0) {
      bEnableStateInformDefault = var0;
   }

   public static boolean isEnableStateInformDefault() {
      return bEnableStateInformDefault;
   }

   public static void setEnableOPInfoInformDefault(boolean var0) {
      bEnableOPInfoInformDefault = var0;
   }

   public static boolean isEnableOPInfoInformDefault() {
      return bEnableOPInfoInformDefault;
   }

   public static void setEnableCurDCLimit(boolean var0) {
      bEnableCurDCLimit = var0;
   }

   public static void setThreadCurDCLimit(boolean var0) {
      threadCurDCLimit.set(var0);
   }

   public static boolean isEnableCurDCLimit() {
      return bEnableCurDCLimit || threadCurDCLimit.get() != null && threadCurDCLimit.get();
   }

   public static void setEnableCurDevSlnLimit(boolean var0) {
      bEnableCurDevSlnLimit = var0;
   }

   public static void setThreadCurDevSlnLimit(boolean var0) {
      threadCurDevSlnLimit.set(var0);
   }

   public static boolean isEnableCurDevSlnLimit() {
      return bEnableCurDevSlnLimit || threadCurDevSlnLimit.get() != null && threadCurDevSlnLimit.get();
   }

   public static void setEnablePaaSAdminLimit(boolean var0) {
      bEnablePaaSAdminLimit = var0;
   }

   public static boolean isEnablePaaSAdminLimit() {
      return bEnablePaaSAdminLimit;
   }

   public static void setThreadEnableCodeNameUpperCamel(Boolean var0) {
      threadCodeNameUpperCamel.set(var0);
   }

   public static boolean isEnableCodeNameUpperCamel() {
      Boolean var0 = threadCodeNameUpperCamel.get();
      return var0 != null ? var0 : bEnableCodeNameUpperCamel;
   }

   public static void setEnableCodeNameUpperCamel(boolean var0) {
      bEnableCodeNameUpperCamel = var0;
   }

   public static String toUpperCamel(String var0) {
      return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, var0);
   }

   public static boolean isEnableGitBranch() {
      if (bEnableGitBranch == null) {
         bEnableGitBranch = false;
         if (WebConfig.getCurrent() != null) {
            String var0 = WebConfig.getCurrent().getAttribute("GITBRANCH", "FALSE");
            if (StringHelper.isNullOrEmpty(var0)) {
               var0 = "FALSE";
            }

            if (StringHelper.compare(var0, "TRUE", true) == 0) {
               bEnableGitBranch = true;
            }
         }
      }

      return bEnableGitBranch;
   }

   public static void setEnableGitBranch(boolean var0) {
      bEnableGitBranch = var0;
   }

   public static String getModelFormat() {
      if (strModelFormat == null) {
         strModelFormat = "JSON";
         if (WebConfig.getCurrent() != null) {
            String var0 = WebConfig.getCurrent().getAttribute("MODELFORMAT", "JSON");
            if (StringHelper.isNullOrEmpty(var0)) {
               var0 = "JSON";
            }

            strModelFormat = var0;
         }
      }

      return strModelFormat;
   }

   public static void setModelFormat(String var0) {
      strModelFormat = var0;
   }

   public static void setEnableGitLabPlugin(boolean var0) {
      bEnableGitLabPlugin = var0;
   }

   public static boolean isEnableGitLabPlugin() {
      if (bEnableGitLabPlugin == null) {
         bEnableGitLabPlugin = false;
         if (WebConfig.getCurrent() != null) {
            String var0 = WebConfig.getCurrent().getAttribute("GITLABPLUGIN", "FALSE");
            if (StringHelper.isNullOrEmpty(var0)) {
               var0 = "FALSE";
            }

            if (StringHelper.compare(var0, "FALSE", true) == 0) {
               bEnableGitLabPlugin = false;
            } else if (StringHelper.compare(var0, "TRUE", true) == 0) {
               bEnableGitLabPlugin = true;
               if (iPSGitLabPlugin == null) {
                  iPSGitLabPlugin = new PSGitLabPluginImpl();
               }
            } else {
               try {
                  Object var1 = ObjectHelper.create(var0);
                  if (!(var1 instanceof IPSGitLabPlugin)) {
                     throw new Exception(StringHelper.format("对象类型不正确"));
                  }

                  bEnableGitLabPlugin = true;
                  iPSGitLabPlugin = (IPSGitLabPlugin)var1;
               } catch (Exception var2) {
                  log.error(StringHelper.format("建立GitLab插件对象[%1$s]发生异常，%2$s", var0, var2.getMessage()), var2);
               }
            }
         }
      }

      return bEnableGitLabPlugin && getPSGitLabPlugin() != null;
   }

   public static void setPSGitLabPlugin(IPSGitLabPlugin var0) {
      iPSGitLabPlugin = var0;
   }

   public static IPSGitLabPlugin getPSGitLabPlugin() {
      return iPSGitLabPlugin;
   }

   public static void setEnableKafkaPlugin(boolean var0) {
      bEnableKafkaPlugin = var0;
   }

   public static boolean isEnableKafkaPlugin() {
      if (bEnableKafkaPlugin == null) {
         bEnableKafkaPlugin = false;
         if (WebConfig.getCurrent() != null) {
            String var0 = WebConfig.getCurrent().getAttribute("KAFKAPLUGIN", "FALSE");
            if (StringHelper.isNullOrEmpty(var0)) {
               var0 = "FALSE";
            }

            if (StringHelper.compare(var0, "FALSE", true) == 0) {
               bEnableKafkaPlugin = false;
            } else if (StringHelper.compare(var0, "TRUE", true) == 0) {
               bEnableKafkaPlugin = true;
               if (iPSKafkaPlugin == null) {
                  iPSKafkaPlugin = new PSKafkaPluginImpl();
               }
            } else {
               try {
                  Object var1 = ObjectHelper.create(var0);
                  if (!(var1 instanceof IPSKafkaPlugin)) {
                     throw new Exception(StringHelper.format("对象类型不正确"));
                  }

                  bEnableKafkaPlugin = true;
                  iPSKafkaPlugin = (IPSKafkaPlugin)var1;
               } catch (Exception var2) {
                  log.error(StringHelper.format("建立Kafka插件对象[%1$s]发生异常，%2$s", var0, var2.getMessage()), var2);
               }
            }
         }
      }

      return bEnableKafkaPlugin && getPSKafkaPlugin() != null;
   }

   public static void setPSKafkaPlugin(IPSKafkaPlugin var0) {
      iPSKafkaPlugin = var0;
   }

   public static IPSKafkaPlugin getPSKafkaPlugin() {
      return iPSKafkaPlugin;
   }

   public static void setEnableDevSlnSysRemoteCall(boolean var0) {
      bEnableDevSlnSysRemoteCall = var0;
   }

   public static boolean isEnableDevSlnSysRemoteCall() {
      if (bEnableDevSlnSysRemoteCall == null) {
         if (WebConfig.getCurrent() != null) {
            bEnableDevSlnSysRemoteCall = WebConfig.getCurrent().getAttribute("DEVSLNSYSREMOTECALL", false);
         } else {
            bEnableDevSlnSysRemoteCall = false;
         }
      }

      return bEnableDevSlnSysRemoteCall;
   }

   public static void setEnableModelObjStorage(boolean var0) {
      bEnableModelObjStorage = var0;
   }

   public static boolean isEnableModelObjStorage() {
      if (bEnableModelObjStorage == null && WebConfig.getCurrent() != null) {
         bEnableModelObjStorage = WebConfig.getCurrent().getAttribute("MODELOBJSTORAGE", false);
      }

      return bEnableModelObjStorage;
   }

   protected boolean isEnableStateInform() {
      if (!isEnableStateInformDefault()) {
         return false;
      }

      if (isImpSysModelNowEx()) {
         return false;
      }

      ActionSession var1 = ActionSessionManager.getCurrentSession();
      if (var1 != null) {
         if (StringHelper.compare(var1.getName(), this.getDEModel().getName(), true) != 0) {
            return false;
         }

         if (ActionSessionManager.getCurrentSession().getActionParam("SRFIGNORESTATEINFORM") != null) {
            return false;
         }
      }

      return true;
   }

   protected void setEnableStateInform(boolean var1) {
      if (ActionSessionManager.getCurrentSession() != null) {
         if (var1) {
            ActionSessionManager.getCurrentSession().removeActionParam("SRFIGNORESTATEINFORM");
         } else {
            ActionSessionManager.getCurrentSession().setActionParam("SRFIGNORESTATEINFORM", "1");
         }
      }
   }

   protected void informObjectChanged(ET var1, String var2) throws Exception {
      if (this.isEnableStateInform()) {
         this.informOPInfo((ET)var1, var2);
         String var3 = informStateMap.get(this.getDEModel().getName());
         if (var3 != null) {
            IEntity var4 = var1;
            String var5 = DataObject.getStringValue(var1.get("psdsconsoleid"));
            if (KeyValueHelper.isTempKey(DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName())))
               && net.ibizsys.paas.web.WebContext.getAppData() != null) {
               var5 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdsconsoleid");
            }

            if (StringHelper.isNullOrEmpty(var5)) {
               var5 = DataObject.getStringValue(var1.get("psdynainstid"));
            }

            if (StringHelper.isNullOrEmpty(var5)) {
               var5 = DataObject.getStringValue(var1.get("psdevslnsysid"));
            }

            if (StringHelper.isNullOrEmpty(var5) && net.ibizsys.paas.web.WebContext.getAppData() != null) {
               var5 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdevslnsysid");
            }

            if (StringHelper.isNullOrEmpty(var5)) {
               String var6 = informStateMap2.get(this.getDEModel().getName());
               if (var6 != null) {
                  var5 = DataObject.getStringValue(var1.get("psdevslnid"));
                  if (StringHelper.isNullOrEmpty(var5) && net.ibizsys.paas.web.WebContext.getAppData() != null) {
                     var5 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdevslnid");
                  }

                  if (!StringHelper.isNullOrEmpty(var5)) {
                     var5 = KeyValueHelper.genUniqueId(var5);
                  }
               }
            }

            if (!StringHelper.isNullOrEmpty(var5)) {
               final String var14 = var5;
               String var7 = "OBJECTUPDATED";
               if (StringHelper.compare(var2, "DELETE", true) == 0) {
                  var7 = "OBJECTREMOVED";
               } else if (StringHelper.compare(var2, "CREATE", true) == 0) {
                  var7 = "OBJECTCREATED";
               }

               final String var8 = var7;
               JSONObject var9 = new JSONObject();
               var9.put("srfdename", this.getDEModel().getName());
               Object var10 = var4.get(this.getDEModel().getMajorDEField().getName());
               Object var11 = var4.get(this.getDEModel().getKeyDEField().getName());
               var9.put("srfkey", var11);
               var9.put(this.getDEModel().getKeyDEField().getName().toLowerCase(), var11);
               if (var10 != null) {
                  var9.put("srfmajortext", var10);
                  var9.put(this.getDEModel().getMajorDEField().getName().toLowerCase(), var10);
               }

               if (!StringHelper.isNullOrEmpty(var3)) {
                  String[] var12 = var3.split("[|]");

                  for (int var13 = 0; var13 < var12.length; var13++) {
                     var9.put(var12[var13].toLowerCase(), var4.get(var12[var13]));
                  }
               }

               IPSDEFieldModel var15 = this.getDEModel().getDEField("CODENAME", true);
               if (var15 != null && var4.contains("CODENAME")) {
                  var9.put("codename", var4.get("CODENAME"));
               }

               var15 = this.getDEModel().getDEField("LOGICNAME", true);
               if (var15 != null && var4.contains("LOGICNAME")) {
                  var9.put("logicname", var4.get("LOGICNAME"));
               }

               if (StringHelper.compare(var7, "OBJECTCREATED", true) == 0 || StringHelper.compare(var7, "OBJECTUPDATED", true) == 0) {
                  var15 = this.getDEModel().getDEField("LEFTPOS", true);
                  if (var15 != null && var4.contains("LEFTPOS") && var4.get("LEFTPOS") != null) {
                     var9.put("leftpos", var4.get("LEFTPOS"));
                  }

                  var15 = this.getDEModel().getDEField("TOPPOS", true);
                  if (var15 != null && var4.contains("TOPPOS") && var4.get("TOPPOS") != null) {
                     var9.put("toppos", var4.get("TOPPOS"));
                  }
               }

               this.fillInformObject((ET)var4, var2, var9);
               final String var19 = var9.toString();
               SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction() {
                  @Override
                  public void commit() {
                     PSStudioConsoleHelper.getCurrent().sendCommand(var14, var8, var19);
                  }

                  @Override
                  public void rollback() {
                  }
               });
            }
         }
      }
   }

   protected void sendStudioConsole(boolean var1, String var2, String var3, boolean var4) {
      this.sendStudioConsole(var1, var2, var3, null, null, var4);
   }

   protected void sendStudioConsole(boolean var1, String var2, String var3, String var4, String var5, boolean var6) {
      if (!this.internalSendStudioConsole(var1, var2, var3, var4, var5, var6)) {
         if (StringHelper.compare(var2, "INFO", true) == 0) {
            log.info(var3);
         } else if (StringHelper.compare(var2, "WARN", true) == 0) {
            log.warn(var3);
         } else if (StringHelper.compare(var2, "ERROR", true) == 0) {
            log.error(var3);
         } else if (StringHelper.compare(var2, "DEBUG", true) == 0) {
            log.debug(var3);
         }
      }
   }

   protected boolean internalSendStudioConsole(boolean var1, String var2, String var3, String var4, String var5, boolean var6) {
      if (PSStudioConsoleHelper.getCurrent() != null && net.ibizsys.paas.web.WebContext.getAppData() != null) {
         String var7 = null;
         if (var1) {
            var7 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdsconsoleid");
         } else {
            var7 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdevslnsysid");
         }

         if (StringHelper.isNullOrEmpty(var7)) {
            return false;
         }

         if (!StringHelper.isNullOrEmpty(var2)) {
            if (StringHelper.compare(var2, "INFO", false) == 0) {
               var3 = PSStudioConsoleHelper.getContent(var3, 34, -1, 1);
            } else if (StringHelper.compare(var2, "WARN", false) == 0) {
               var3 = PSStudioConsoleHelper.getContent(var3, 33, -1, 1);
            } else if (StringHelper.compare(var2, "ERROR", false) == 0) {
               var3 = PSStudioConsoleHelper.getContent(var3, 31, -1, 1);
            } else {
               var3 = PSStudioConsoleHelper.getContent(var3, 32, -1, 1);
            }
         }

         try {
            if (var6) {
               final String var8 = var7;
               final String var9 = var3;
               final String var10 = var5;
               final String var11 = var4;
               SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction() {
                  @Override
                  public void commit() {
                     PSStudioConsoleHelper.getCurrent().sendConsole(var8, var9, var11, var10, true);
                  }

                  @Override
                  public void rollback() {
                  }
               });
            } else {
               PSStudioConsoleHelper.getCurrent().sendConsole(var7, var3, var4, var5, true);
            }

            return true;
         } catch (Exception var13) {
            log.error(var13);
         }
      }

      return false;
   }

   protected void fillInformObject(ET var1, String var2, JSONObject var3) throws Exception {
   }

   @Override
   protected void checkEntity(ET var1, boolean var2, boolean var3, boolean var4) throws Exception {
      try {
         super.checkEntity((ET)var1, var2, var3, var4);
         EntityError var5 = new EntityError();
         psModelHotCodeHelper.execute(this, "CHECKENTITY", var1, var5, true);
         if (var5.hasError()) {
            this.convertEntityError(var5);
            throw new EntityException(var5, this.getDEModel());
         }
      } catch (Exception var9) {
         if (var9 instanceof EntityException) {
            ActionSession var6 = ActionSessionManager.getCurrentSession();
            if (var6 != null && !StringHelper.isNullOrEmpty(var6.getName()) && StringHelper.compare(var6.getName(), this.getDEModel().getName(), true) != 0) {
               EntityException var7 = (EntityException)var9;
               String var8 = var7.getMessage();
               if (!StringHelper.isNullOrEmpty(var8)) {
                  var8 = StringHelper.format("[%1$s]%2$s", this.getDEModel().getLogicName(), var8);
                  throw new EntityException(var7.getEntityError(), var7.getErrorCode(), var8, this.getDEModel());
               }
            }
         }

         throw var9;
      }
   }

   @Override
   public String getModelV2Name(ET var1, boolean var2) throws Exception {
      return this.getModelV2Name(var2);
   }

   @Override
   public String getModelV2Name(boolean var1) {
      if (var1) {
         return this.getDEModel().getName();
      }

      String var2 = this.getDEModel().getName();
      return Inflector.getInstance().pluralize(var2).toUpperCase();
   }

   @Override
   public String getModelV2LogicName() {
      return this.getDEModel().getLogicName();
   }

   @Override
   public String getModelV2LogicName(ET var1) throws Exception {
      return this.getModelV2LogicName();
   }

   @Override
   public String getModelV2ResPath(IEntity var1, boolean var2) throws Exception {
      String var3 = DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()));
      if (StringHelper.isNullOrEmpty(var3)) {
         return null;
      } else {
         String var4 = this.getModelV2ResScope(var1);
         if (StringHelper.isNullOrEmpty(var4)) {
            log.warn(StringHelper.format("模型[%1$s](%2$s)没有指定模型范围", this.getDEModel().getName(), var3));
            return null;
         } else {
            return var2
               ? StringHelper.format("%1$s%2$s%3$s#%4$s.txt", this.getDEModel().getName(), File.separator, var4, "ALL")
               : StringHelper.format("%1$s%2$s%3$s%2$s%4$s.json", this.getDEModel().getName(), File.separator, var4, var3);
         }
      }
   }

   @Override
   public String getModelV2ResScope(IEntity var1) throws Exception {
      String var2 = DataObject.getStringValue(var1, "PSSYSTEMID", null);
      return StringHelper.isNullOrEmpty(var2) ? null : StringHelper.format("PSSYSTEM#%1$s", var2);
   }

   @Override
   public String getModelV2ResScopeDER(IEntity var1) throws Exception {
      return null;
   }

   @Override
   public String getModelV2ResScopeText(IEntity var1) throws Exception {
      return null;
   }

   @Override
   public String[] getModelV2ResScopeFields() throws Exception {
      return null;
   }

   @Override
   public boolean setModelV2ResScope(IEntity var1, String var2, String var3) throws Exception {
      return false;
   }

   @Override
   public void importModelV2Ex(ET var1, String var2, String var3) throws Exception {
      ObjectNode var4 = null;
      if ("YAML".equals(var3)) {
         var4 = PSModelYamlHelper.importModel(this.getDEModel(), var1, var2);
      } else {
         var4 = (ObjectNode)JsonNodeHelper.fromString(var2);
      }

      this.importModelV2((ET)var1, var4);
   }

   @Override
   public void importModelV2(ET var1, ObjectNode var2) throws Exception {
      final ET var3 = var1;
      final ObjectNode var4 = var2;
      Iterator var5 = this.getDEModel().getDEFields();
      if (var5 != null) {
         while (var5.hasNext()) {
            IDEField var6 = (IDEField)var5.next();
            if (!var6.isKeyDEField() && !var1.contains(var6.getName())) {
               if (var6.getName().equals("ENABLE")) {
                  var1.set(var6.getName(), 1);
               } else {
                  JsonNode var7 = var2.get(var6.getName().toLowerCase());
                  if (var7 == null || var7 instanceof NullNode) {
                     if (!var6.getName().equals("ENABLE")) {
                        var1.set(var6.getName(), null);
                     }
                  } else if (DataTypeHelper.isStringDataType(var6.getStdDataType())) {
                     var1.set(var6.getName(), var7.asText());
                  } else if (DataTypeHelper.isIntType(var6.getStdDataType())) {
                     var1.set(var6.getName(), var7.asInt());
                  } else if (DataTypeHelper.isDoubleType(var6.getStdDataType())) {
                     var1.set(var6.getName(), var7.asDouble());
                  } else if (DataTypeHelper.isDateTimeType(var6.getStdDataType())) {
                     if (var7.isLong()) {
                        var1.set(var6.getName(), new Timestamp(var7.asLong()));
                     } else {
                        var1.set(var6.getName(), var7.asText());
                     }
                  } else {
                     var1.set(var6.getName(), var7.asText());
                  }
               }
            }
         }
      }

      final boolean var8 = isSimpleImportExportMode();
      final String var9 = getSimpleImportExportOwner();
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            try {
               boolean var2x = !StringHelper.isNullOrEmpty(var3.get(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName()));
               PSCoreSysServiceBase.setSimpleImportExportMode(true);
               if (StringHelper.isNullOrEmpty(var9)) {
                  PSCoreSysServiceBase.setSimpleImportExportOwner(PSCoreSysServiceBase.this.getModelV2Name(true));
               }

               ConcurrentHashMap var3x = new ConcurrentHashMap();
               PSModelV2Helper.setKeyMap(var3x);
               ArrayList var4x = PSCoreSysServiceBase.this.getCompileModelV2List(true);
               PSCoreSysServiceBase.this.prepareImportExportModelV2Env(var3, var4x, true);
               ArrayList var5x = PSCoreSysServiceBase.this.getImportModelV2List(true);
               PSCoreSysServiceBase.this.compileModelV2(var3, var4, null, null, 1);
               PSCoreSysServiceBase.this.compileModelV2(var3, var4, null, null, 2);
               PSCoreSysServiceBase.this.onImportModelV2(var2x, var3, var5x);
               PSCoreSysServiceBase.this.resetImportModelV2List();
               PSCoreSysServiceBase.this.resetCompileModelV2List();
               PSModelV2Helper.setKeyMap(null);
               if (StringHelper.isNullOrEmpty(var9)) {
                  PSCoreSysServiceBase.setSimpleImportExportOwner(var9);
               }

               PSCoreSysServiceBase.setSimpleImportExportMode(var8);
            } catch (Exception var6) {
               PSCoreSysServiceBase.this.resetImportModelV2List();
               PSCoreSysServiceBase.this.resetCompileModelV2List();
               PSModelV2Helper.setKeyMap(null);
               if (StringHelper.isNullOrEmpty(var9)) {
                  PSCoreSysServiceBase.setSimpleImportExportOwner(var9);
               }

               PSCoreSysServiceBase.setSimpleImportExportMode(var8);
               throw var6;
            }
         }
      }, true);
   }

   protected void onImportModelV2(boolean var1, ET var2, ArrayList<PSCoreSysServiceBase<ET>.ModelV2> var3) throws Exception {
      if (var3.size() == 0) {
         throw new Exception("没有任何导入数据");
      }

      for (PSCoreSysServiceBase.ModelV2 var5 : var3) {
         log.debug(StringHelper.format("导入数据[%1$s][%2$s][%3$s]", var5.type, var5.text, var5.key));
      }

      String var9 = this.getModelV2Name((ET)var2, true);
      if (StringHelper.compare(((PSCoreSysServiceBase.ModelV2)var3.get(0)).type, var9, false) != 0) {
         throw new Exception(StringHelper.format("导入首数据类型[%1$s]不正确，必须为[%2$s]", ((PSCoreSysServiceBase.ModelV2)var3.get(0)).type, var9));
      }

      if (var1) {
         String var10 = DataObject.getStringValue(var2.get(this.getDEModel().getKeyDEField().getName()));
         if (StringHelper.compare(((PSCoreSysServiceBase.ModelV2)var3.get(0)).key, var10, false) != 0) {
            throw new Exception(StringHelper.format("导入首数据键值[%1$s]不正确，必须为[%2$s]", ((PSCoreSysServiceBase.ModelV2)var3.get(0)).key, var10));
         }
      }

      if (var1) {
         this.emptyModelV2((ET)var2);
      }

      for (int var11 = 0; var11 < var3.size(); var11++) {
         IEntity var6 = ((PSCoreSysServiceBase.ModelV2)var3.get(var11)).entity;
         if (var11 == 0) {
            this.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
            if (var1) {
               this.update((ET)var6);
            } else {
               this.create((ET)var6);
            }
         } else {
            IDataEntityModel var7 = DEModelGlobal.getDEModel(((PSCoreSysServiceBase.ModelV2)var3.get(var11)).type);
            IService var8 = var7.getService(this.getSessionFactory());
            var8.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
            var8.create(var6, false);
         }
      }

      if (((PSCoreSysServiceBase.ModelV2)var3.get(0)).entity != var2) {
         ((PSCoreSysServiceBase.ModelV2)var3.get(0)).entity.copyTo(var2, true);
      }
   }

   @Override
   public void emptyModelV2(ET var1) throws Exception {
      final ET var2 = var1;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSCoreSysServiceBase.this.onEmptyModelV2(var2);
         }
      }, true);
   }

   protected void onEmptyModelV2(ET var1) throws Exception {
   }

   @Override
   public void exportModelV2(ET var1, String var2, String var3) throws Exception {
      final ET var4 = var1;
      final String var5 = var2;
      final String var6 = var3;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSCoreSysServiceBase.this.pushExportModelV2(var4);
            PSCoreSysServiceBase.this.exportCurModelV2(var4, var5, var6);
            PSCoreSysServiceBase.this.exportRelatedModelV2(var4, var5, var6);
            PSCoreSysServiceBase.this.popupExportModelV2(var4);
         }
      }, false);
   }

   protected void exportCurModelV2(ET var1, String var2, String var3) throws Exception {
      ObjectNode var4 = this.fillModelV2(null, (ET)var1, var3);
      if (var4 != null) {
         this.onExportCurModelV2((ET)var1, var4, var3, false);
         this.onWriteFileCurModelV2((ET)var1, var2, var4);
      }
   }

   protected void onWriteFileCurModelV2(ET var1, String var2, ObjectNode var3) throws Exception {
      String var4 = null;
      if ("YAML".equals(getModelFormat())) {
         var4 = StringHelper.format("%1$s%2$s%3$s.yaml", var2, File.separator, this.getModelV2Name((ET)var1, true));
      } else {
         var4 = StringHelper.format("%1$s%2$s%3$s.json", var2, File.separator, this.getModelV2Name((ET)var1, true));
      }

      String var5 = null;
      if ("YAML".equals(getModelFormat())) {
         var5 = PSModelYamlHelper.exportModel(var3);
      } else {
         var5 = MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(var3);
      }

      PSModelV2Helper.writeFile(var4, var5);
      Map var6 = PSModelV2Helper.getUniqueFileMap();
      if (var6 != null) {
         Object var7 = var1.get(this.getDEModel().getKeyDEField().getName());
         Object var8 = null;
         if (this.getDEModel().getMajorDEField() != null) {
            var8 = var1.get(this.getDEModel().getMajorDEField().getName());
         }

         String var9 = String.format("[%1$s](%2$s|%3$s)", this.getModelV2Name((ET)var1, true), var7, var8);
         String var10 = var4.toUpperCase();
         String var11 = (String)var6.get(var10);
         if (!StringHelper.isNullOrEmpty(var11)) {
            throw new Exception(StringHelper.format("模型%1$s导出路径与%2$s一致", var9, var11));
         }

         var6.put(var10, var9);
      }
   }

   public ObjectNode fillModelV2(ObjectNode var1, ET var2, String var3) throws Exception {
      if (var1 == null) {
         var1 = JsonNodeHelper.createObjectNode();
      }

      HashMap var4 = new HashMap();
      var4.put("PSDEVSLNID", "");
      var4.put("PSDEVSLNNAME", "");
      var4.put("PSDEVCENTERID", "");
      var4.put("PSDEVCENTERNAME", "");
      var4.put("PSDEVSLNSYSID", "");
      var4.put("PSDEVSLNSYSNAME", "");
      var4.put("ENABLE", "");
      if (StringHelper.isNullOrEmpty(var3)) {
         var4.put("CREATEMAN", "");
         var4.put("UPDATEMAN", "");
         var4.put("CREATEDATE", "");
         var4.put("UPDATEDATE", "");
      } else {
         Timestamp var5 = DataObject.getTimestampValue(var2, "CREATEDATE", null);
         if (var5 != null) {
            var4.put("CREATEDATE", DateHelper.toDateTimeString(var5));
         }

         Timestamp var6 = DataObject.getTimestampValue(var2, "UPDATEDATE", null);
         if (var6 != null) {
            var4.put("UPDATEDATE", DateHelper.toDateTimeString(var6));
         }
      }

      if (var2.contains("DYNAMODELFLAG") && DataObject.getIntegerValue(var2, "DYNAMODELFLAG", 0) == 0) {
         var4.put("DYNAMODELFLAG", "");
      }

      if (!this.getDEModel().getName().equals("PSSYSTEM")) {
         var4.put("PSSYSTEMID", "");
         var4.put("PSSYSTEMNAME", "");
      }

      return this.onFillModelV2(var1, (ET)var2, var3, var4);
   }

   protected ObjectNode onFillModelV2(ObjectNode var1, ET var2, String var3, Map<String, String> var4) throws Exception {
      for (int var5 = 0; var5 < 2; var5++) {
         Iterator var6 = null;
         if (var5 == 0) {
            var6 = this.getDEModel().getDERs(false);
         } else if (this.getDEModel().getInheritDEModel() != null) {
            var6 = this.getDEModel().getInheritDEModel().getDERs(false);
         }

         if (var6 != null) {
            while (var6.hasNext()) {
               IDERBase var7 = (IDERBase)var6.next();
               if (var7 instanceof IDER1N) {
                  IDER1NModel var8 = (IDER1NModel)var7;
                  IPSDEFieldModel var9 = this.getDEModel().getDEField(var8.getPickupDEFName(), true);
                  if (var9 != null && !var4.containsKey(var9.getName())) {
                     Object var10 = var2.get(var9.getName());
                     if (!StringHelper.isNullOrEmpty(var10)) {
                        PSCoreSysServiceBase.ModelV2 var11 = this.getLastExportModelV2(var7.getMajorDEName(), 1);
                        if (var11 != null && var11.key.equals(var10)) {
                           if (var11.pos == 1) {
                              String var12 = this.getModelV2ResScopeDER(var2);
                              if (!StringHelper.isNullOrEmpty(var12) && StringHelper.compare(var8.getName(), var12, false) != 0) {
                                 var4.put(var9.getName(), StringHelper.format("<%1$s>", var7.getMajorDEName()));
                              } else {
                                 var4.put(var9.getName(), "");
                              }
                           } else {
                              var4.put(var9.getName(), StringHelper.format("<%1$s>", var7.getMajorDEName()));
                           }

                           Iterator var23 = null;
                           if (var5 == 0) {
                              var23 = this.getDEModel().getDEFields();
                           } else if (this.getDEModel().getInheritDEModel() != null) {
                              var23 = this.getDEModel().getInheritDEModel().getDEFields();
                           }

                           if (var23 != null) {
                              while (var23.hasNext()) {
                                 IDEField var13 = (IDEField)var23.next();
                                 if (var13.isLinkDEField()
                                    && var13.isPhisicalDEField()
                                    && "PICKUPTEXT".equals(var13.getDataType())
                                    && StringHelper.compare(var13.getDERName(), var8.getName(), false) == 0) {
                                    Object var14 = var2.get(var13.getName());
                                    if (var14 != null && StringHelper.compare(var11.text, (String)var14, false) == 0) {
                                       var4.put(var13.getName(), "");
                                    }
                                    break;
                                 }
                              }
                           }
                        } else {
                           var4.put(var9.getName(), this.getModelV2UniqueTag(var8.getMajorDEName(), (String)var10, var3));
                        }
                     }
                  }
               }
            }
         }
      }

      Iterator var15 = this.getDEModel().getDEFields();
      if (var15 != null) {
         while (var15.hasNext()) {
            IDEFieldModel var17 = (IDEFieldModel)var15.next();
            if (!StringHelper.isNullOrEmpty(var17.getUserTag()) && StringHelper.compare("IGNOREMODELV2", var17.getUserTag(), true) == 0) {
               var4.put(var17.getName(), "");
            } else if (!var17.isPhisicalDEField() && !var17.isInheritDEField()) {
               var4.put(var17.getName(), "");
            }
         }
      }

      var4.put(this.getDEModel().getKeyDEField().getName(), "");
      if (this.getDEModel().getInheritDEModel() != null) {
         var15 = this.getDEModel().getInheritDEModel().getDEFields();
         if (var15 != null) {
            while (var15.hasNext()) {
               IDEFieldModel var18 = (IDEFieldModel)var15.next();
               if (!StringHelper.isNullOrEmpty(var18.getUserTag()) && StringHelper.compare("IGNOREMODELV2", var18.getUserTag(), true) == 0) {
                  var4.put(var18.getName(), "");
               } else if (!var18.isPhisicalDEField()) {
                  var4.put(var18.getName(), "");
               }
            }
         }

         var4.put(this.getDEModel().getInheritDEModel().getKeyDEField().getName(), "");
      }

      if (!this.getDEModel().getName().equals("PSSYSTEM")) {
         var4.put("PSSYSTEMID", "");
         var4.put("PSSYSTEMNAME", "");
      }

      HashMap<String, Object> var19 = new HashMap<String, Object>();
      var2.fillMap(var19, false);

      for (Entry<String, Object> var21 : var19.entrySet()) {
         String var22 = (String)var4.get(((String)var21.getKey()).toUpperCase());
         if (var22 == null) {
            if (var21.getValue() != null && var21.getValue() != DataObject.EMPTY && !(var21.getValue() instanceof Timestamp)) {
               JsonNodeHelper.put(var1, ((String)var21.getKey()).toLowerCase(), var21.getValue());
            }
         } else if (!StringHelper.isNullOrEmpty(var22)) {
            JsonNodeHelper.put(var1, ((String)var21.getKey()).toLowerCase(), var22);
         }
      }

      return var1;
   }

   protected String getModelV2UniqueTag(String var1, String var2, String var3) throws Exception {
      Map var4 = PSModelV2Helper.getUniqueTagMap();
      if (var4 != null) {
         String var14 = StringHelper.format("%1$s/%2$s", var1, var2).toLowerCase();
         String var16 = (String)var4.get(var14);
         if (StringHelper.isNullOrEmpty(var16)) {
            Integer var20 = ignoreExportModelV2Map.get(var1);
            if (var20 == null) {
               log.warn(StringHelper.format("模型[%1$s](%2$s)标识文件不存在", var1, var2));
               return var2;
            } else {
               return var20 == 1 ? var2 : null;
            }
         } else {
            int var19 = var16.indexOf("/");
            if (var19 == -1) {
               return var16;
            }

            String var22 = var16.substring(0, var19);
            String var24 = var16.substring(var19 + 1);
            String[] var26 = var22.split("[#]");
            if (var26.length != 2) {
               throw new Exception(StringHelper.format("模型[%1$s](%2$s)标识内容(%3$s)不正确", var1, var2, var16));
            }

            PSCoreSysServiceBase.ModelV2 var28 = this.getLastExportModelV2(var26[0], 1);
            return var28 != null && StringHelper.compare(var28.key, var26[1], true) == 0
               ? StringHelper.format("<%1$s>/%2$s", var26[0], var24)
               : this.getModelV2UniqueTag(var26[0], var26[1], var3) + "/" + var24;
         }
      } else if (StringHelper.isNullOrEmpty(var3)) {
         Integer var13 = ignoreExportModelV2Map.get(var1);
         if (var13 != null) {
            return var13 == 1 ? var2 : null;
         } else {
            IDataEntityModel var15 = DEModelGlobal.getDEModel(var1);
            IService var18 = var15.getService(this.getSessionFactory());
            IEntity var21 = var15.createEntity();
            var21.set(var15.getKeyDEField().getName(), var2);
            if (!var18.get(var21, true)) {
               throw new Exception(StringHelper.format("模型[%1$s](%2$s)数据不正确", var1, var2));
            } else {
               String var23 = ((IPSModelV2Service)var18).getModelV2ResScope(var21);
               if (StringHelper.isNullOrEmpty(var23)) {
                  throw new Exception(StringHelper.format("模型[%1$s](%2$s)资源范围不正确", var1, var2));
               } else {
                  String[] var25 = var23.split("[#]");
                  if (var25.length != 2) {
                     throw new Exception(StringHelper.format("模型[%1$s](%2$s)资源范围(%3$s)不正确", var1, var2, var23));
                  } else {
                     String var27 = ((IPSModelV2Service)var18).getModelV2Tag(var21);
                     PSCoreSysServiceBase.ModelV2 var29 = this.getLastExportModelV2(var25[0], 1);
                     if (var29 == null || StringHelper.compare(var29.key, var25[1], true) != 0) {
                        return this.getModelV2UniqueTag(var25[0], var25[1], var3) + "/" + var27;
                     } else {
                        return StringHelper.compare(var25[0], "PSSYSTEM", false) == 0 ? var27 : StringHelper.format("<%1$s>/%2$s", var25[0], var27);
                     }
                  }
               }
            }
         }
      } else {
         String var5 = StringHelper.format("%1$s%2$s%3$s%2$s%4$s.txt", var3, File.separator, var1, var2);
         File var6 = new File(var5);
         if (!var6.exists()) {
            Integer var17 = ignoreExportModelV2Map.get(var1);
            if (var17 == null) {
               log.warn(StringHelper.format("模型[%1$s](%2$s)标识文件不存在", var1, var2));
               return var2;
            } else {
               return var17 == 1 ? var2 : null;
            }
         } else {
            String var7 = PSModelV2Helper.readFile(var5);
            int var8 = var7.indexOf("/");
            if (var8 == -1) {
               return var7;
            }

            String var9 = var7.substring(0, var8);
            String var10 = var7.substring(var8 + 1);
            String[] var11 = var9.split("[#]");
            if (var11.length != 2) {
               throw new Exception(StringHelper.format("模型[%1$s](%2$s)标识内容(%3$s)不正确", var1, var2, var7));
            }

            PSCoreSysServiceBase.ModelV2 var12 = this.getLastExportModelV2(var11[0], 1);
            return var12 != null && StringHelper.compare(var12.key, var11[1], true) == 0
               ? StringHelper.format("<%1$s>/%2$s", var11[0], var10)
               : this.getModelV2UniqueTag(var11[0], var11[1], var3) + "/" + var10;
         }
      }
   }

   protected void onExportCurModelV2(ET var1, ObjectNode var2, String var3, boolean var4) throws Exception {
   }

   @Override
   public ObjectNode exportModelV2(ET var1) throws Exception {
      boolean var2 = isSimpleImportExportMode();
      String var3 = getSimpleImportExportOwner();

      try {
         setSimpleImportExportMode(true);
         if (StringHelper.isNullOrEmpty(var3)) {
            setSimpleImportExportOwner(this.getModelV2Name(true));
         }

         ObjectNode var4 = this.exportModelV2((ET)var1, null);
         if (StringHelper.isNullOrEmpty(var3)) {
            setSimpleImportExportOwner(var3);
         }

         setSimpleImportExportMode(var2);
         return var4;
      } catch (Exception var5) {
         if (StringHelper.isNullOrEmpty(var3)) {
            setSimpleImportExportOwner(var3);
         }

         setSimpleImportExportMode(var2);
         throw var5;
      }
   }

   public ObjectNode exportModelV2(ET var1, String var2) throws Exception {
      final ET var3 = var1;
      final String var4 = var2;
      final CallResult var5 = new CallResult();
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSCoreSysServiceBase.this.pushExportModelV2(var3, var4 == null);
            ObjectNode var2x = PSCoreSysServiceBase.this.fillModelV2(null, var3, var4);
            if (var2x != null) {
               PSCoreSysServiceBase.this.onExportCurModelV2(var3, var2x, var4, var4 != null);
               var5.setUserObject(var2x);
            }

            PSCoreSysServiceBase.this.popupExportModelV2(var3);
         }
      }, false);
      return var5.getUserObject() instanceof ObjectNode ? (ObjectNode)var5.getUserObject() : null;
   }

   @Override
   public String exportModelV2Ex(ET var1, String var2) throws Exception {
      ObjectNode var3 = this.exportModelV2((ET)var1);
      return "YAML".equals(var2) ? PSModelYamlHelper.exportModel(this.getDEModel(), var1, var3) : var3.toString();
   }

   protected void pushExportModelV2(ET var1) throws Exception {
      this.pushExportModelV2((ET)var1, false);
   }

   protected void pushExportModelV2(ET var1, boolean var2) throws Exception {
      ActionSession var3 = ActionSessionManager.getCurrentSession();
      Object var4 = var3.getActionParam("EXPORTMODELV2LIST");
      ArrayList var5 = null;
      if (var4 == null) {
         var5 = new ArrayList();
         var3.setActionParam("EXPORTMODELV2LIST", var5);
         if (var2) {
            this.prepareImportExportModelV2Env((ET)var1, var5, false);
         }
      } else {
         var5 = (ArrayList)var4;
      }

      PSCoreSysServiceBase.ModelV2 var6 = new PSCoreSysServiceBase.ModelV2();
      var6.key = (String)var1.get(this.getDEModel().getKeyDEField().getName());
      var6.type = this.getDEModel().getName();
      var6.text = (String)var1.get(this.getDEModel().getMajorDEField().getName());
      var5.add(0, var6);
   }

   protected void prepareImportExportModelV2Env(ET var1, ArrayList<PSCoreSysServiceBase<ET>.ModelV2> var2, boolean var3) throws Exception {
      IEntity var4 = var1;
      IPSModelV2Service var5 = this;
      if (var3) {
         String var6 = DataObject.getStringValue(var4.get("SRFMODELV2SCOPE"));
         if (StringHelper.isNullOrEmpty(var6)) {
            var6 = var5.getModelV2ResScope(var4);
            if (StringHelper.isNullOrEmpty(var6)) {
               Object var7 = var1.get(this.getDEModel().getKeyDEField().getName());
               if (!StringHelper.isNullOrEmpty(var7)) {
                  IEntity var8 = this.getDEModel().createEntity();
                  var8.set(this.getDEModel().getKeyDEField().getName(), var7);
                  this.get((ET)var8);
                  var6 = this.getModelV2ResScope(var8);
                  if (!StringHelper.isNullOrEmpty(var6)) {
                     var4.set("SRFMODELV2SCOPE", var6);
                     String[] var9 = var6.split("[#]");
                     var5.setModelV2ResScope(var4, var9[0], var9[1]);
                  }
               }
            }
         }
      }

      while (true) {
         String var15 = DataObject.getStringValue(var4.get("SRFMODELV2SCOPE"));
         if (StringHelper.isNullOrEmpty(var15)) {
            var15 = var5.getModelV2ResScope(var4);
         }

         if (StringHelper.isNullOrEmpty(var15)) {
            break;
         }

         String[] var16 = var15.split("[#]");
         if (var16 == null || var16.length != 2) {
            log.error(StringHelper.format("无效的资源范围[%1$s]", var15));
            break;
         }

         try {
            IDataEntityModel var17 = DEModelGlobal.getDEModel(var16[0]);
            IService var18 = var17.getService(this.getSessionFactory());
            IEntity var10 = var17.createEntity();
            var10.set(var17.getKeyDEField().getName(), var16[1]);
            var18.get(var10);
            PSCoreSysServiceBase.ModelV2 var11 = new PSCoreSysServiceBase.ModelV2();
            var11.key = var16[1];
            var11.type = var17.getName();
            var11.text = (String)var10.get(var17.getMajorDEField().getName());
            var11.tag = PSModelV2Helper.getModelV2TagFolderName(((IPSModelV2Service)var18).getModelV2Tag(var10));
            var2.add(var11);
            if (StringHelper.compare(var11.type, "PSSYSTEM", false) == 0) {
               break;
            }

            var4 = var10;
            var5 = (IPSModelV2Service)var18;
         } catch (Exception var12) {
            if (var3) {
               throw new Exception(StringHelper.format("计算导入资源范围[%1$s]发生异常，%2$s", var15, var12.getMessage()), var12);
            }

            throw new Exception(StringHelper.format("计算导出资源范围[%1$s]发生异常，%2$s", var15, var12.getMessage()), var12);
         }
      }
   }

   protected void popupExportModelV2(ET var1) {
      ActionSession var2 = ActionSessionManager.getCurrentSession();
      Object var3 = var2.getActionParam("EXPORTMODELV2LIST");
      ArrayList var4 = null;
      if (var3 == null) {
         var2.setActionParam("EXPORTMODELV2LIST", var4);
      } else {
         var4 = (ArrayList)var3;
      }

      var4.remove(0);
   }

   protected PSCoreSysServiceBase<ET>.ModelV2 getLastExportModelV2(String var1, int var2) {
      ActionSession var3 = ActionSessionManager.getCurrentSession();
      Object var4 = var3.getActionParam("EXPORTMODELV2LIST");
      ArrayList var5 = null;
      if (var4 == null) {
         var5 = new ArrayList();
         var3.setActionParam("EXPORTMODELV2LIST", var5);
      } else {
         var5 = (ArrayList)var4;
      }

      if (var2 < 0) {
         var2 = 0;
      }

      for (int var6 = var2; var6 < var5.size(); var6++) {
         PSCoreSysServiceBase.ModelV2 var7 = (PSCoreSysServiceBase.ModelV2)var5.get(var6);
         if (StringHelper.compare(var1, var7.type, false) == 0) {
            var7.pos = var6;
            return var7;
         }
      }

      return null;
   }

   protected void exportRelatedModelV2(ET var1, String var2, String var3) throws Exception {
      this.onExportRelatedModelV2((ET)var1, var2, var3);
   }

   protected void onExportRelatedModelV2(ET var1, String var2, String var3) throws Exception {
   }

   @Override
   public String getModelV2Tag(ET var1) {
      try {
         return DataObject.getStringValue(var1, this.getDEModel().getKeyDEField().getName(), null);
      } catch (Exception var3) {
         return null;
      }
   }

   @Override
   public boolean setModelV2Tag(ET var1, String var2) {
      return false;
   }

   protected int getExportCurModelV2Level() {
      return isSimpleImportExportMode() ? 500 : 50;
   }

   @Override
   public void compileModelV2(ET var1, ObjectNode var2, String var3, String var4, int var5) throws Exception {
      if (var1 == null) {
         var1 = this.getDEModel().createEntity();
      }

      final ET var6 = var1;
      final String var7 = var3;
      final String var8 = var4;
      final ObjectNode var9 = var2;
      final int var10 = var5;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSCoreSysServiceBase.this.pushCompileModelV2(var6);
            PSCoreSysServiceBase.this.compileCurModelV2(var6, var9, var7, var8, var10);
            PSCoreSysServiceBase.this.popupCompileModelV2(var6);
         }
      }, false);
   }

   protected boolean testCompileCurModelV2(ET var1, ObjectNode var2, String var3, String var4, int var5) throws Exception {
      return true;
   }

   protected void compileCurModelV2(ET var1, ObjectNode var2, String var3, String var4, int var5) throws Exception {
      String var6 = null;
      String var7 = null;
      Map var8 = PSModelV2Helper.getKeyMap();
      if (var2 == null) {
         if ("YAML".equals(getModelFormat())) {
            var6 = StringHelper.format("%1$s%2$s%3$s.yaml", var4, File.separator, this.getModelV2Name((ET)var1, true));
            if (StringHelper.compare(this.getModelV2Name((ET)var1, true), this.getDEModel().getServiceCodeName(), true) != 0) {
               File var9 = new File(var6);
               if (!var9.exists()) {
                  var6 = StringHelper.format("%1$s%2$s%3$s.yaml", var4, File.separator, this.getDEModel().getServiceCodeName().toUpperCase());
               }
            }
         } else {
            var6 = StringHelper.format("%1$s%2$s%3$s.json", var4, File.separator, this.getModelV2Name((ET)var1, true));
            if (StringHelper.compare(this.getModelV2Name((ET)var1, true), this.getDEModel().getServiceCodeName(), true) != 0) {
               File var17 = new File(var6);
               if (!var17.exists()) {
                  var6 = StringHelper.format("%1$s%2$s%3$s.json", var4, File.separator, this.getDEModel().getServiceCodeName().toUpperCase());
               }
            }
         }

         if (!StringHelper.isNullOrEmpty(var6)) {
            var7 = (String)var8.get("SRFLASTFILE");
            var8.put("SRFLASTFILE", var6);
         }

         File var18 = new File(var6);
         if (!var18.exists()) {
            throw new Exception(StringHelper.format("无法获取指定模型文件"));
         }

         try {
            String var10 = PSModelV2Helper.readFile(var6);
            if ("YAML".equals(getModelFormat())) {
               var2 = PSModelYamlHelper.importModel(var10);
            } else {
               var2 = (ObjectNode)JsonNodeHelper.fromString(var10);
            }
         } catch (Exception var15) {
            throw new Exception(StringHelper.format("模型文件内容不正确"));
         }
      }

      if (this.testCompileCurModelV2(var1, var2, var3, var4, var5)) {
         PSCoreSysServiceBase.ModelV2 var19 = this.getLastCompileModelV2(this.getDEModel().getName());
         if (var19 != null && var19.pos == 0) {
            try {
               boolean var20 = this.fillModelV2Key((ET)var1, var2, var3, var4, var5 == 2);
               var19.key = (String)var1.get(this.getDEModel().getKeyDEField().getName());
               var19.text = (String)var1.get(this.getDEModel().getMajorDEField().getName());
               var19.tag = PSModelV2Helper.getModelV2TagFolderName(this.getModelV2Tag((ET)var1));
               if (!var20) {
                  String var11 = "";
                  ArrayList var12 = this.getCompileModelV2List();
                  int var13 = var12.size();
                  if (var13 >= 2) {
                     for (int var14 = var13 - 2; var14 >= 0; var14--) {
                        if (!StringHelper.isNullOrEmpty(var11)) {
                           var11 = var11 + "/";
                        }

                        var11 = var11 + ((PSCoreSysServiceBase.ModelV2)var12.get(var14)).tag;
                     }
                  }

                  var1.set(this.getDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId(var11.toUpperCase()));
                  var19.key = (String)var1.get(this.getDEModel().getKeyDEField().getName());
               }
            } catch (Exception var16) {
               log.error(StringHelper.format("编译模型对象有误，对象[%1$s]，路径[%2$s]", this.getModelV2Name((ET)var1, true), var6));
               throw new Exception(
                  StringHelper.format("编译模型对象[%1$s|%2$s]有误，%3$s", this.getModelV2Name((ET)var1, true), this.getModelV2LogicName((ET)var1), var16.getMessage())
               );
            }

            if (var5 == 1) {
               this.onWriteFileCurModelV2Key((ET)var1, var3, var2);
            } else {
               this.onWriteFileCurModelV2Data((ET)var1, var3);
            }

            this.compileRelatedModelV2((ET)var1, var2, var3, var4, var5);
            if (!StringHelper.isNullOrEmpty(var7)) {
               var8.put("SRFLASTFILE", var7);
            }
         } else {
            log.error(StringHelper.format("最近编译模型对象有误，对象[%1$s]，路径[%2$s]", this.getModelV2Name((ET)var1, true), var6));
            throw new Exception(StringHelper.format("最近编译模型对象有误，对象[%1$s|%2$s]", this.getModelV2Name((ET)var1, true), this.getModelV2LogicName((ET)var1)));
         }
      }
   }

   protected void onWriteFileCurModelV2Key(ET var1, String var2, ObjectNode var3) throws Exception {
      String var4 = "";
      ArrayList var5 = this.getCompileModelV2List();
      int var6 = var5.size();
      if (var6 >= 2) {
         for (int var7 = var6 - 2; var7 >= 0; var7--) {
            if (!StringHelper.isNullOrEmpty(var4)) {
               var4 = var4 + "/";
            }

            var4 = var4 + ((PSCoreSysServiceBase.ModelV2)var5.get(var7)).tag;
         }

         Map var17 = PSModelV2Helper.getKeyMap();
         if (var17 != null) {
            String var8 = this.getModelV2Name((ET)var1, true);
            var4 = var4.toUpperCase();
            String var9 = StringHelper.format("%1$s/%2$s", var8, KeyValueHelper.genUniqueId(var4)).toLowerCase();
            if (var17.containsKey(var9)) {
               throw new Exception(StringHelper.format("模型[%1$s/%2$s]标识已存在", var8, var4));
            }

            String var10 = DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()));
            Map var11 = PSModelV2Helper.getUniqueKeyMap();
            if (var11 != null) {
               String var12 = StringHelper.format("%1$s/%2$s", var8, var10);
               if (var11.containsKey(var12)) {
                  throw new Exception(StringHelper.format("模型[%1$s/%2$s]键值已存在，可尝试使用模型组[PSSYSMODELGROUP]解决", var8, var4));
               }

               var11.put(var12, "");
            }

            var17.put(var9, var10);
            if (this.getDEModel().getInheritDEModel() != null) {
               var8 = this.getDEModel().getInheritDEModel().getName();
               var4 = var4.toUpperCase();
               var9 = StringHelper.format("%1$s/%2$s", var8, KeyValueHelper.genUniqueId(var4)).toLowerCase();
               if (var17.containsKey(var9)) {
                  throw new Exception(StringHelper.format("模型[%1$s/%2$s]标识已存在", var8, var4));
               }

               if (var11 != null) {
                  String var26 = StringHelper.format("%1$s/%2$s", var8, var10);
                  if (var11.containsKey(var26)) {
                     throw new Exception(StringHelper.format("模型[%1$s/%2$s]键值已存在，可尝试使用模型组[PSSYSMODELGROUP]解决", var8, var4));
                  }

                  var11.put(var26, "");
               }

               var17.put(var9, var10);
            }
         } else {
            String var19 = StringHelper.format("%1$s%2$sKEYS%2$s%3$s", var2, File.separator, this.getModelV2Name((ET)var1, true));
            File var22 = new File(var19);
            if (!var22.exists()) {
               var22.mkdirs();
            }

            var4 = var4.toUpperCase();
            String var24 = StringHelper.format("%1$s%2$s%3$s.txt", var19, File.separator, KeyValueHelper.genUniqueId(var4));
            PSModelV2Helper.writeFile(var24, DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName())), true);
            if (this.getDEModel().getInheritDEModel() != null) {
               var19 = StringHelper.format("%1$s%2$sKEYS%2$s%3$s", var2, File.separator, this.getDEModel().getInheritDEModel().getName());
               var22 = new File(var19);
               if (!var22.exists()) {
                  var22.mkdirs();
               }

               var4 = var4.toUpperCase();
               var24 = StringHelper.format("%1$s%2$s%3$s.txt", var19, File.separator, KeyValueHelper.genUniqueId(var4));
               PSModelV2Helper.writeFile(var24, DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName())), true);
            }
         }
      }
   }

   protected void onWriteFileCurModelV2Data(ET var1, String var2) throws Exception {
      ObjectNode var3 = JsonNodeHelper.createObjectNode();
      if (!StringHelper.isNullOrEmpty(var2)) {
      HashMap<String, Object> var4 = new HashMap<String, Object>();
         var1.fillMap(var4, false);

         for (Entry<String, Object> var6 : var4.entrySet()) {
            if (var6.getValue() != null && var6.getValue() != DataObject.EMPTY) {
               if (var6.getValue() instanceof Timestamp) {
                  JsonNodeHelper.put(var3, ((String)var6.getKey()).toLowerCase(), DateHelper.toDateTimeString((Timestamp)var6.getValue()));
               } else {
                  JsonNodeHelper.put(var3, ((String)var6.getKey()).toLowerCase(), var6.getValue());
               }
            }
         }
      }

      Map var14 = PSModelV2Helper.getCounterMap();
      if (var14 != null) {
         String var16 = this.getModelV2Name((ET)var1, true);
         synchronized (var14) {
            Integer var7 = (Integer)var14.get(var16);
            if (var7 == null) {
               var7 = 0;
            }

            var7 = var7 + 1;
            var14.put(var16, var7);
         }
      } else {
         var14 = PSModelV2Helper.getCounterMap2();
         if (var14 != null) {
            String var17 = this.getModelV2Name((ET)var1, true);
            synchronized (var14) {
               Integer var23 = (Integer)var14.get(var17);
               if (var23 == null) {
                  var23 = 0;
               }

               var23 = var23 + 1;
               var14.put(var17, var23);
            }
         }

         if (StringHelper.isNullOrEmpty(var2)) {
            ArrayList var18 = this.getImportModelV2List();
            PSCoreSysServiceBase.ModelV2 var20 = new PSCoreSysServiceBase.ModelV2();
            var20.type = this.getModelV2Name((ET)var1, true);
            var20.key = DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()));
            var20.text = DataObject.getStringValue(var1.get(this.getDEModel().getMajorDEField().getName()));
            var20.entity = var1;
            var18.add(var20);
         } else {
            String var19 = StringHelper.format("%1$s%2$sDATAS%2$s%3$s", var2, File.separator, this.getModelV2Name((ET)var1, true));
            File var21 = new File(var19);
            if (!var21.exists()) {
               var21.mkdirs();
            }

            String var25 = StringHelper.format("%1$s%2$sDATAS%2$s%3$s%2$sALL.txt", var2, File.separator, this.getModelV2Name((ET)var1, true));
            ObjectMapper var8 = new ObjectMapper();
            String var9 = var8.writeValueAsString(var3);
            PSModelV2Helper.appendFile(var25, var9 + "\n\n");
         }
      }
   }

   public boolean fillModelV2Key(ET var1, ObjectNode var2, String var3, String var4, boolean var5) throws Exception {
      String var6 = DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()));
      if (!var5 && !StringHelper.isNullOrEmpty(var6)) {
         return true;
      }

      if (!this.getDEModel().getName().equals("PSSYSTEM")) {
         PSCoreSysServiceBase.ModelV2 var7 = this.getLastCompileModelV2("PSSYSTEM");
         if (var7 != null) {
            var1.set("PSSYSTEMID", var7.key);
            if (var5 && !StringHelper.isNullOrEmpty(var7.text)) {
               var1.set("PSSYSTEMNAME", var7.text);
            }
         }
      }

      Iterator var19 = this.getDEModel().getDEFields();
      if (var19 != null) {
         while (var19.hasNext()) {
            IPSDEFieldModel var8 = (IPSDEFieldModel)var19.next();
            if (!var8.isKeyDEField() && !var1.contains(var8.getName())) {
               if (var8.getName().equals("ENABLE")) {
                  var1.set(var8.getName(), 1);
               } else {
                  JsonNode var9 = var2.get(var8.getName().toLowerCase());
                  if (var9 == null && StringHelper.compare(var8.getName(), var8.getServiceCodeName(), true) != 0) {
                     var9 = var2.get(var8.getServiceCodeName().toLowerCase());
                  }

                  if (var9 == null || var9 instanceof NullNode) {
                     if (!var8.getName().equals("ENABLE")) {
                        var1.set(var8.getName(), null);
                     }
                  } else if (DataTypeHelper.isStringDataType(var8.getStdDataType())) {
                     var1.set(var8.getName(), var9.asText());
                  } else if (DataTypeHelper.isIntType(var8.getStdDataType())) {
                     var1.set(var8.getName(), var9.asInt());
                  } else if (DataTypeHelper.isDoubleType(var8.getStdDataType())) {
                     var1.set(var8.getName(), var9.asDouble());
                  } else if (DataTypeHelper.isDateTimeType(var8.getStdDataType())) {
                     if (var9.isLong()) {
                        var1.set(var8.getName(), new Timestamp(var9.asLong()));
                     } else {
                        var1.set(var8.getName(), var9.asText());
                     }
                  } else {
                     var1.set(var8.getName(), var9.asText());
                  }
               }
            }
         }
      }

      if (var5) {
         for (int var20 = 0; var20 < 2; var20++) {
            Iterator var22 = null;
            if (var20 == 0) {
               var22 = this.getDEModel().getDERs(false);
            } else if (this.getDEModel().getInheritDEModel() != null) {
               var22 = this.getDEModel().getInheritDEModel().getDERs(false);
            }

            if (var22 != null) {
               while (var22.hasNext()) {
                  IDERBase var24 = (IDERBase)var22.next();
                  if (var24 instanceof IDER1N) {
                     IDER1NModel var10 = (IDER1NModel)var24;
                     IPSDEFieldModel var11 = this.getDEModel().getDEField(var10.getPickupDEFName(), true);
                     if (var11 != null) {
                        Object var12 = var1.get(var11.getName());
                        if (!StringHelper.isNullOrEmpty(var12)) {
                           try {
                              var1.set(var11.getName(), this.getModelV2Key(var10.getMajorDEName(), (String)var12, var3, var11.getName()));
                           } catch (Exception var18) {
                              log.error(
                                 StringHelper.format("计算属性[%1$s|%2$s]值[%3$s]发生异常，%4$s", var11.getName(), var11.getLogicName(), var12, var18.getMessage()),
                                 var18
                              );
                              throw new Exception(
                                 StringHelper.format("计算属性[%1$s|%2$s]值[%3$s]发生异常，%4$s", var11.getName(), var11.getLogicName(), var12, var18.getMessage()),
                                 var18
                              );
                           }

                           PSCoreSysServiceBase.ModelV2 var13 = this.getLastCompileModelV2(var10.getMajorDEName());
                           if (var13 != null && StringHelper.compare(var13.key, (String)var1.get(var11.getName()), false) == 0) {
                              Iterator var14 = null;
                              if (var20 == 0) {
                                 var14 = this.getDEModel().getDEFields();
                              } else if (this.getDEModel().getInheritDEModel() != null) {
                                 var14 = this.getDEModel().getInheritDEModel().getDEFields();
                              }

                              if (var14 != null) {
                                 while (var14.hasNext()) {
                                    IDEField var15 = (IDEField)var14.next();
                                    if (var15.isLinkDEField()
                                       && var15.isPhisicalDEField()
                                       && "PICKUPTEXT".equals(var15.getDataType())
                                       && StringHelper.compare(var15.getDERName(), var10.getName(), false) == 0) {
                                       Object var16 = var1.get(var15.getName());
                                       if (StringHelper.isNullOrEmpty(var16)) {
                                          var1.set(var15.getName(), var13.text);
                                       }
                                       break;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         var19 = this.getDEModel().getUnionKeyValueDEFields();
         if (var19 != null) {
            while (var19.hasNext()) {
               IDEField var23 = (IDEField)var19.next();
               if (var23.isLinkDEField() && StringHelper.compare(var23.getName(), "PSSYSTEMID", true) != 0) {
                  Object var25 = var1.get(var23.getName());
                  if (!StringHelper.isNullOrEmpty(var25)) {
                     for (int var26 = 0; var26 < 2; var26++) {
                        Iterator var27 = null;
                        if (var26 == 0) {
                           var27 = this.getDEModel().getDERs(false);
                        } else if (this.getDEModel().getInheritDEModel() != null) {
                           var27 = this.getDEModel().getInheritDEModel().getDERs(false);
                        }

                        if (var27 != null) {
                           while (var27.hasNext()) {
                              IDERBase var28 = (IDERBase)var27.next();
                              if (var28 instanceof IDER1N) {
                                 IDER1NModel var29 = (IDER1NModel)var28;
                                 if (StringHelper.compare(var29.getPickupDEFName(), var23.getName(), true) == 0) {
                                    try {
                                       var1.set(var23.getName(), this.getModelV2Key(var29.getMajorDEName(), (String)var25, var3, var23.getName()));
                                    } catch (Exception var17) {
                                       log.error(
                                          StringHelper.format(
                                             "计算属性[%1$s|%2$s]值[%3$s]发生异常，%4$s", var23.getName(), var23.getLogicName(), var25, var17.getMessage()
                                          ),
                                          var17
                                       );
                                       throw new Exception(
                                          StringHelper.format(
                                             "计算属性[%1$s|%2$s]值[%3$s]发生异常，%4$s", var23.getName(), var23.getLogicName(), var25, var17.getMessage()
                                          ),
                                          var17
                                       );
                                    }

                                    var26 = 3;
                                    break;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return !StringHelper.isNullOrEmpty(var6) ? true : this.fillEntityKeyValue((ET)var1);
   }

   protected String getModelV2Key(String var1, String var2, String var3, String var4) throws Exception {
      String[] var5 = var2.split("[/]");
      Map var6 = PSModelV2Helper.getKeyMap();
      if (var6 != null) {
         if (var5.length == 1) {
            if (!StringHelper.isNullOrEmpty(var5[0]) && var5[0].indexOf("<") != -1) {
               String var23 = var5[0].replace("<", "").replace(">", "");
               PSCoreSysServiceBase.ModelV2 var30 = this.getLastCompileModelV2(var23);
               if (var30 != null) {
                  return var30.key;
               } else {
                  throw new Exception(StringHelper.format("无法获取当前编译模型对象[%1$s]", var5[0]));
               }
            } else {
               if (StringHelper.isNullOrEmpty(var5[0])) {
                  return null;
               }

               String var22 = var5[0].toUpperCase();
               String var29 = KeyValueHelper.genUniqueId(var22);
               String var35 = StringHelper.format("%1$s/%2$s", var1, var29).toLowerCase();
               String var40 = (String)var6.get(var35);
               if (StringHelper.isNullOrEmpty(var40)) {
                  Integer var49 = ignoreExportModelV2Map.get(var1);
                  if (var49 != null) {
                     return var49 == 1 ? var5[0] : null;
                  }

                  PSCoreSysServiceBase.ModelV2 var55 = this.getLastCompileModelV2(var1, var5[0]);
                  if (var55 != null) {
                     return var5[0];
                  }

                  if (StringHelper.isNullOrEmpty(var3)) {
                     var55 = this.getLastCompileModelV2("PSSYSTEM");
                     if (var55 != null) {
                        IService var60 = DEModelGlobal.getDEModel("PSSYSTEM").getService(this.getSessionFactory());
                        PSSystem var62 = new PSSystem();
                        var62.setPSSystemId(var55.key);
                        IEntity var63 = ((IPSModelV2Service)var60).getModelV2Entity(var62, var1, var2);
                        if (var63 != null) {
                           IDataEntityModel var64 = DEModelGlobal.getDEModel(var1);
                           if (var64 != null) {
                              var40 = DataObject.getStringValue(var63.get(var64.getKeyDEField().getName()));
                              if (!StringHelper.isNullOrEmpty(var40)) {
                                 var6.put(var35, var40);
                                 String var65 = KeyValueHelper.genUniqueId(var40.toUpperCase());
                                 String var18 = StringHelper.format("%1$s/%2$s", var1, var65).toLowerCase();
                                 var6.put(var18, var40);
                                 return var40;
                              }
                           }
                        }
                     }
                  }

                  var49 = ignoreImportModelV2Map.get(var1);
                  if (var49 != null) {
                     return var49 == 1 ? var5[0] : null;
                  } else {
                     String var61 = StringHelper.format("%1$s|%2$s", this.getDEModel().getName(), var4);
                     var49 = ignoreImportModelFieldV2Map.get(var61);
                     if (var49 != null) {
                        return var49 == 1 ? var5[0] : null;
                     } else {
                        throw new Exception(StringHelper.format("无法获取模型[%1$s](%2$s)", var1, var2));
                     }
                  }
               } else {
                  return var40;
               }
            }
         } else {
            String var21 = "";

            for (int var27 = 0; var27 < var5.length; var27++) {
               if (!StringHelper.isNullOrEmpty(var5[var27]) && var5[var27].indexOf("<") != -1) {
                  String var33 = var5[var27].replace("<", "").replace(">", "");
                  PSCoreSysServiceBase.ModelV2 var38 = this.getLastCompileModelV2(var33);
                  if (var38 == null) {
                     throw new Exception(StringHelper.format("无法获取当前编译模型对象[%1$s]", var5[var27]));
                  }

                  if (!StringHelper.isNullOrEmpty(var21)) {
                     var21 = var21 + "/";
                  }

                  var21 = var21 + var38.tag;
                  ArrayList var46 = this.getCompileModelV2List();
                  int var53 = var46.size();

                  for (int var58 = var38.pos + 1; var58 < var53 - 1; var58++) {
                     var21 = ((PSCoreSysServiceBase.ModelV2)var46.get(var58)).tag + "/" + var21;
                  }
               } else {
                  if (!StringHelper.isNullOrEmpty(var21)) {
                     var21 = var21 + "/";
                  }

                  var21 = var21 + var5[var27];
               }
            }

            String var28 = KeyValueHelper.genUniqueId(var21.toUpperCase());
            String var34 = StringHelper.format("%1$s/%2$s", var1, var28).toLowerCase();
            String var39 = (String)var6.get(var34);
            if (StringHelper.isNullOrEmpty(var39) && StringHelper.isNullOrEmpty(var3)) {
               PSCoreSysServiceBase.ModelV2 var47 = this.getLastCompileModelV2("PSSYSTEM");
               if (var47 != null) {
                  IService var54 = DEModelGlobal.getDEModel("PSSYSTEM").getService(this.getSessionFactory());
                  PSSystem var59 = new PSSystem();
                  var59.setPSSystemId(var47.key);
                  IEntity var14 = ((IPSModelV2Service)var54).getModelV2Entity(var59, var1, var21);
                  if (var14 != null) {
                     IDataEntityModel var15 = DEModelGlobal.getDEModel(var1);
                     if (var15 != null) {
                        var39 = DataObject.getStringValue(var14.get(var15.getKeyDEField().getName()));
                        var6.put(var34, var39);
                        String var16 = KeyValueHelper.genUniqueId(var39.toUpperCase());
                        String var17 = StringHelper.format("%1$s/%2$s", var1, var16).toLowerCase();
                        var6.put(var17, var39);
                     }
                  }
               }
            }

            if (StringHelper.isNullOrEmpty(var39)) {
               log.error(StringHelper.format("无法获取模型[%1$s][%2$s]实际标识，路径[%3$s]标识[%4$s]", var1, var2, var21, var28));
               IDataEntityModel var48 = this.getSystemModel().getDataEntityModel(var1, true);
               if (var48 != null) {
                  throw new Exception(StringHelper.format("无法获取模型[%1$s|%2$s](%3$s)", var1, var48.getLogicName(), var2));
               } else {
                  throw new Exception(StringHelper.format("无法获取模型[%1$s](%2$s)", var1, var2));
               }
            } else {
               return var39;
            }
         }
      } else if (var5.length == 1) {
         if (!StringHelper.isNullOrEmpty(var5[0]) && var5[0].indexOf("<") != -1) {
            String var20 = var5[0].replace("<", "").replace(">", "");
            PSCoreSysServiceBase.ModelV2 var26 = this.getLastCompileModelV2(var20);
            if (var26 != null) {
               return var26.key;
            } else {
               throw new Exception(StringHelper.format("无法获取当前编译模型对象[%1$s]", var5[0]));
            }
         } else {
            if (StringHelper.isNullOrEmpty(var5[0])) {
               return null;
            }

            String var19 = var5[0].toUpperCase();
            String var25 = KeyValueHelper.genUniqueId(var19);
            String var32 = StringHelper.format("%1$s%2$sKEYS%2$s%3$s%2$s%4$s.txt", var3, File.separator, var1, var25);
            File var37 = new File(var32);
            if (!var37.exists()) {
               Integer var43 = ignoreExportModelV2Map.get(var1);
               if (var43 != null) {
                  return var43 == 1 ? var5[0] : null;
               } else {
                  var43 = ignoreImportModelV2Map.get(var1);
                  if (var43 != null) {
                     return var43 == 1 ? var5[0] : null;
                  } else {
                     PSCoreSysServiceBase.ModelV2 var52 = this.getLastCompileModelV2(var1, var5[0]);
                     if (var52 != null) {
                        return var5[0];
                     } else {
                        String var57 = StringHelper.format("%1$s|%2$s", this.getDEModel().getName(), var4);
                        var43 = ignoreImportModelFieldV2Map.get(var57);
                        if (var43 != null) {
                           return var43 == 1 ? var5[0] : null;
                        } else {
                           throw new Exception(StringHelper.format("无法获取模型[%1$s](%2$s)", var1, var2));
                        }
                     }
                  }
               }
            } else {
               return PSModelV2Helper.readFile(var32);
            }
         }
      } else {
         String var7 = "";

         for (int var8 = 0; var8 < var5.length; var8++) {
            if (!StringHelper.isNullOrEmpty(var5[var8]) && var5[var8].indexOf("<") != -1) {
               String var9 = var5[var8].replace("<", "").replace(">", "");
               PSCoreSysServiceBase.ModelV2 var10 = this.getLastCompileModelV2(var9);
               if (var10 == null) {
                  throw new Exception(StringHelper.format("无法获取当前编译模型对象[%1$s]", var5[var8]));
               }

               if (!StringHelper.isNullOrEmpty(var7)) {
                  var7 = var7 + "/";
               }

               var7 = var7 + var10.tag;
               ArrayList var11 = this.getCompileModelV2List();
               int var12 = var11.size();

               for (int var13 = var10.pos + 1; var13 < var12 - 1; var13++) {
                  var7 = ((PSCoreSysServiceBase.ModelV2)var11.get(var13)).tag + "/" + var7;
               }
            } else {
               if (!StringHelper.isNullOrEmpty(var7)) {
                  var7 = var7 + "/";
               }

               var7 = var7 + var5[var8];
            }
         }

         String var24 = KeyValueHelper.genUniqueId(var7.toUpperCase());
         String var31 = StringHelper.format("%1$s%2$sKEYS%2$s%3$s%2$s%4$s.txt", var3, File.separator, var1, var24);
         File var36 = new File(var31);
         if (!var36.exists()) {
            log.error(StringHelper.format("无法获取模型[%1$s][%2$s]实际标识，路径[%3$s]标识[%4$s]", var1, var2, var7, var24));
            IDataEntityModel var42 = this.getSystemModel().getDataEntityModel(var1, true);
            if (var42 != null) {
               throw new Exception(StringHelper.format("无法获取模型[%1$s|%2$s](%3$s)", var1, var42.getLogicName(), var2));
            } else {
               throw new Exception(StringHelper.format("无法获取模型[%1$s](%2$s)", var1, var2));
            }
         } else {
            return PSModelV2Helper.readFile(var31);
         }
      }
   }

   protected void compileRelatedModelV2(ET var1, ObjectNode var2, String var3, String var4, int var5) throws Exception {
      this.onCompileRelatedModelV2((ET)var1, var2, var3, var4, var5);
   }

   protected void onCompileRelatedModelV2(ET var1, ObjectNode var2, String var3, String var4, int var5) throws Exception {
   }

   protected void pushCompileModelV2(ET var1) throws Exception {
      ArrayList var2 = this.getCompileModelV2List();
      PSCoreSysServiceBase.ModelV2 var3 = new PSCoreSysServiceBase.ModelV2();
      var3.type = this.getDEModel().getName();
      var2.add(0, var3);
   }

   protected void popupCompileModelV2(ET var1) {
      ArrayList var2 = this.getCompileModelV2List();
      var2.remove(0);
   }

   protected PSCoreSysServiceBase<ET>.ModelV2 getLastCompileModelV2(String var1) {
      ArrayList var2 = this.getCompileModelV2List();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         PSCoreSysServiceBase.ModelV2 var4 = (PSCoreSysServiceBase.ModelV2)var2.get(var3);
         if (StringHelper.compare(var1, var4.type, false) == 0) {
            var4.pos = var3;
            return var4;
         }
      }

      return null;
   }

   protected PSCoreSysServiceBase<ET>.ModelV2 getLastCompileModelV2(String var1, String var2) {
      ArrayList var3 = this.getCompileModelV2List();

      for (int var4 = 0; var4 < var3.size(); var4++) {
         PSCoreSysServiceBase.ModelV2 var5 = (PSCoreSysServiceBase.ModelV2)var3.get(var4);
         if (StringHelper.compare(var2, var5.key, false) == 0) {
            if (StringHelper.compare(var1, var5.type, false) == 0) {
               var5.pos = var4;
               return var5;
            }

            String var6 = aliasModelV2Map.get(var5.type);
            if (!StringHelper.isNullOrEmpty(var6) && StringHelper.compare(var1, var6, false) == 0) {
               var5.pos = var4;
               return var5;
            }
         }
      }

      return null;
   }

   protected ArrayList<PSCoreSysServiceBase<ET>.ModelV2> getCompileModelV2List() {
      return this.getCompileModelV2List(false);
   }

   protected ArrayList<PSCoreSysServiceBase<ET>.ModelV2> getCompileModelV2List(boolean var1) {
      ActionSession var2 = ActionSessionManager.getCurrentSession();
      Object var3 = var2.getActionParam("COMPILEMODELV2LIST");
      ArrayList var4 = null;
      if (var3 != null && !var1) {
         var4 = (ArrayList)var3;
      } else {
         var4 = new ArrayList();
         var2.setActionParam("COMPILEMODELV2LIST", var4);
      }

      return var4;
   }

   protected void resetCompileModelV2List() {
      ActionSession var1 = ActionSessionManager.getCurrentSession();
      Object var2 = var1.getActionParam("COMPILEMODELV2LIST");
      if (var2 != null) {
         var1.removeActionParam("COMPILEMODELV2LIST");
      }
   }

   protected ArrayList<PSCoreSysServiceBase<ET>.ModelV2> getImportModelV2List() {
      return this.getImportModelV2List(false);
   }

   protected ArrayList<PSCoreSysServiceBase<ET>.ModelV2> getImportModelV2List(boolean var1) {
      ActionSession var2 = ActionSessionManager.getCurrentSession();
      Object var3 = var2.getActionParam("IMPORTMODELV2LIST");
      ArrayList var4 = null;
      if (var3 != null && !var1) {
         var4 = (ArrayList)var3;
      } else {
         var4 = new ArrayList();
         var2.setActionParam("IMPORTMODELV2LIST", var4);
      }

      return var4;
   }

   protected void resetImportModelV2List() {
      ActionSession var1 = ActionSessionManager.getCurrentSession();
      Object var2 = var1.getActionParam("IMPORTMODELV2LIST");
      if (var2 != null) {
         var1.removeActionParam("IMPORTMODELV2LIST");
      }
   }

   @Override
   public void selectRaw(String var1, SqlParamList var2, IPSRawSelectWork var3) throws Exception {
      final String var4 = var1;
      final SqlParamList var5 = var2;
      final IPSRawSelectWork var6 = var3;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            ((IPSCoreSysDAO)PSCoreSysServiceBase.this.getDAO()).executeRawSelectSql(null, var4, var5, var6);
         }
      });
   }

   @Override
   public DBCallResult executeBatchCreate(ArrayList<IEntity> var1, int var2) throws Exception {
      if (this.getDEModel().getInheritDEModel() != null) {
         String var3 = this.getDEModel().getInheritDEModel().getKeyDEField().getName();
         String var4 = this.getDEModel().getInheritDEModel().getMajorDEField().getName();
         String var5 = this.getDEModel().getInheritTypeValue();
         String var6 = this.getDEModel().getInheritDEModel().getIndexTypeDEField().getName();
         String var7 = this.getDEModel().getKeyDEField().getName();
         String var8 = this.getDEModel().getMajorDEField().getName();

         for (IEntity var10 : var1) {
            var10.set(var3, var10.get(var7));
            var10.set(var4, var10.get(var8));
            if (!StringHelper.isNullOrEmpty(var5)) {
               var10.set(var6, var5);
            }
         }

         IPSCoreSysService var20 = (IPSCoreSysService)this.getDEModel().getInheritDEModel().getService(this.getSessionFactory());
         var20.executeBatchCreate(var1, var2);
      }

      ISqlCommandModel var11 = getCreateSqlCommandModel(this.getDAO().getRealDBDialect(), this.getDEModel());
      final String[] var12 = new String[]{var11.getSql()};
      ArrayList<SqlParamList> var13 = new ArrayList<SqlParamList>();

      for (IEntity var16 : var1) {
         SqlParamList var18 = new SqlParamList();
         var11.fillSqlParams(var16, null, var18);
         var13.add(var18);
      }

      final SqlParamList[] var15 = var13.toArray(new SqlParamList[var13.size()]);
      final int var17 = var2;
      final CallResult var19 = new CallResult();
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSCoreSysServiceBase.this.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
            var19.setUserObject(PSCoreSysServiceBase.this.getDAO().executeRawSqlBatch(null, var12, var15, var17));
         }
      });
      return (DBCallResult)var19.getUserObject();
   }

   public static ISqlCommandModel getCreateSqlCommandModel(IDBDialect var0, IDataEntityModel var1) throws Exception {
      SqlCommandModel var2 = new SqlCommandModel();
      var2.setDataEntityModel(var1);
      var2.setDBDialect(var0);
      HashMap<String, Object> var3 = new HashMap<String, Object>();
      Iterator var4 = var1.getDEFields();

      while (var4.hasNext()) {
         IDEField var5 = (IDEField)var4.next();
         if (!var5.isDynaStorageDEField() && var5.isPhisicalDEField() && !var5.isInheritDEField() && !var5.isFormulaDEField()) {
            ProcParam var6 = new ProcParam();
            var6.setDataType(var5.getStdDataType());
            var6.setParamName(StringHelper.format("VAR_%1$s", var5.getName().toUpperCase()));
            var3.put(var5.getName(), var6);
         }
      }

      ProcParamList var11 = new ProcParamList();
      StringBuilderEx var12 = new StringBuilderEx();
      var12.append("INSERT INTO %1$s (", var0.getDBObjStandardName(var1.getDEDBConfig(var0.getDBType()).getTableName()));
      boolean var7 = true;

      for (String var9 : var3.keySet()) {
         if (var7) {
            var7 = false;
         } else {
            var12.append(",");
         }

         IDEField var10 = var1.getDEField(var9, true);
         if (var10 == null) {
            var12.append(var0.getDBObjStandardName(var9));
         } else {
            var12.append(var0.getDBObjStandardName(var10.getDEFDTColumn(var0.getDBType()).getColumnName()));
         }
      }

      var12.append(")VALUES(");
      var7 = true;

      for (String var15 : var3.keySet()) {
         if (var7) {
            var7 = false;
         } else {
            var12.append(",");
         }

         Object var16 = var3.get(var15);
         if (var16 instanceof ProcParam) {
            var12.append("?");
            var11.add((ProcParam)var16);
         } else {
            var12.append((String)var16);
         }
      }

      var12.append(")");
      var2.setSql(var12.toString());
      var2.setProcParamList(var11);
      return var2;
   }

   public void updateModelKeeper(final ET var1) throws Exception {
      if (this.isUpdateModelKeeper((ET)var1) && this.getSessionFactory() == getCurMajorSessionFactory()) {
         this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction var1x) throws Exception {
               PSCoreSysServiceBase.this.onUpdateModelKeeper(var1);
            }
         }, false);
      }
   }

   protected void onUpdateModelKeeper(ET var1) throws Exception {
   }

   protected boolean isUpdateModelKeeper(ET var1) throws Exception {
      return false;
   }

   public void removeModelKeeper(final ET var1) throws Exception {
      if (this.isRemoveModelKeeper((ET)var1) && this.getSessionFactory() == getCurMajorSessionFactory()) {
         this.doServiceWork(new IServiceWork() {
            @Override
            public void execute(ITransaction var1x) throws Exception {
               PSCoreSysServiceBase.this.onRemoveModelKeeper(var1);
            }
         }, false);
      }
   }

   protected void onRemoveModelKeeper(ET var1) throws Exception {
   }

   protected boolean isRemoveModelKeeper(ET var1) throws Exception {
      return this.isUpdateModelKeeper((ET)var1);
   }

   @Override
   protected String checkFieldDupRule(IDataEntityModel var1, String var2, String var3, ET var4, boolean var5, boolean var6) throws Exception {
      SelectContext var7 = new SelectContext();
      String[] var8 = null;
      if (!StringHelper.isNullOrEmpty(var3)) {
         var8 = var3.split("[;]");
      }

      if (!this.fillCheckFieldDupRuleSelectCond(var7, var1, var2, var8, (ET)var4, var5, var6)) {
         return null;
      }

      Object var9 = var4.get(var1.getKeyDEField().getName());
      ArrayList<? extends IEntity> var10 = null;
      if (var6) {
         if (var1 == this.getDEModel()) {
            var10 = this.selectTemp(var7);
         } else {
            var10 = var1.getService(this.getSessionFactory()).selectTemp(var7);
         }
      } else if (var1 == this.getDEModel()) {
         var10 = this.select(var7);
      } else {
         var10 = var1.getService(this.getSessionFactory()).select(var7);
      }

      if (var10.size() == 0) {
         return null;
      }

      for (IEntity var12 : var10) {
         Object var13 = var12.get(var1.getKeyDEField().getName());
         if (DataTypeHelper.compare(var1.getKeyDEField().getStdDataType(), var9, var13) != 0L) {
            Object var14 = var4.get(var2);
            return this.getLocalization("CTRL.SERVICE.CHECKFIELDDUPRULE_INFO", new Object[]{var14}, String.format("值[%1$s]重复", var14));
         }
      }

      return null;
   }

   protected boolean fillCheckFieldDupRuleSelectCond(SelectContext var1, IDataEntityModel var2, String var3, String[] var4, ET var5, boolean var6, boolean var7) throws Exception {
      boolean var8 = true;
      boolean var9 = true;
      Object var10 = var5.get(var3);
      var1.setConditon(var3, var10);
      var1.setFetchFirst(true);
      boolean var11 = false;
      boolean var12 = false;
      if (this.getSessionFactory() != getCurMajorSessionFactory() && var4 != null && var4.length > 0) {
         boolean var13 = false;
         boolean var14 = false;

         for (String var18 : var4) {
            if (StringHelper.compare(var18, "PSSYSTEMID", true) == 0) {
               var13 = true;
            }

            if (StringHelper.compare(var18, "PSMODULEID", true) == 0) {
               var14 = true;
            }
         }

         if (!var13 && !this.getDEModel().getName().equals("PSSYSTEM")) {
            IPSDEFieldModel var26 = this.getDEModel().getDEField("PSSYSTEMID", true);
            if (var26 != null && var26.isPhisicalDEField()) {
               var11 = true;
            }
         }

         if (!var14 && !this.getDEModel().getName().equals("PSMODULE")) {
            IPSDEFieldModel var27 = this.getDEModel().getDEField("PSMODULEID", true);
            if (var27 != null && var27.isPhisicalDEField()) {
               var12 = true;
            }
         }
      }

      Object var24 = null;
      if (var11 && var5.contains("PSSYSTEMID")) {
         var24 = DataObject.getStringValue(var5.get("PSSYSTEMID"), "");
      }

      Object var25 = null;
      if (var12 && var5.contains("PSMODULEID")) {
         var25 = DataObject.getStringValue(var5.get("PSMODULEID"), "");
      }

      IEntity var28 = this.getLast(var5);
      if (var28 != null) {
         Object var29 = var28.get(var3);
         if (var29 != null) {
            IDEField var32 = var2.getDEField(var3, true);
            var8 = DataTypeHelper.compare(var32.getStdDataType(), var10, var29) != 0L;
         }

         if (var11 && var24 == null) {
            var24 = var28.get("PSSYSTEMID");
         }

         if (var12 && var25 == null) {
            var25 = var28.get("PSMODULEID");
         }
      }

      if (var4 != null && var4.length > 0) {
         var9 = false;

         for (String var19 : var4) {
            Object var20 = var5.get(var19);
            if (var20 == null && var28 != null) {
               var20 = var28.get(var19);
            }

            if (var7 && var20 != null && var20 instanceof String) {
               String var21 = (String)var20;
               if (var21.indexOf("SRFTEMPKEY:") != 0) {
                  return false;
               }
            }

            if (var20 == null) {
               var1.setConditon(var19, SelectCond.ISNULL);
            } else {
               var1.setConditon(var19, var20);
            }

            if (var28 != null) {
               Object var35 = var28.get(var19);
               if (var35 != null) {
                  if (var20 != null) {
                     IDEField var22 = var2.getDEField(var19, true);
                     if (DataTypeHelper.compare(var22.getStdDataType(), var20, var35) != 0L) {
                        var9 = true;
                     }
                  }
               } else if (var20 != null) {
                  var9 = true;
               }
            } else {
               var9 = true;
            }
         }
      } else {
         var9 = false;
      }

      if (!var8 && !var9) {
         return false;
      }

      if (var11 && !StringHelper.isNullOrEmpty(var24)) {
         var1.set("PSSYSTEMID", var24);
      }

      if (var12) {
         if (!StringHelper.isNullOrEmpty(var25)) {
            var1.set("PSMODULEID", var25);
         } else {
            var1.setConditon("PSMODULEID", SelectCond.ISNULL);
         }
      }

      SelectField var31 = new SelectField();
      var31.setName(var2.getKeyDEField().getName());
      var1.addSelectField(var31);
      return true;
   }

   protected int getDefaultOrderValue() {
      return 1000;
   }

   protected boolean fillGetDraftDefaultValue(ET var1, boolean var2) throws Exception {
      Map var3 = this.getGetDraftDefaultValueMap((ET)var1, var2);
      if (var3 != null && var3.size() != 0) {
         Map var4 = this.getGetDraftDefaultValueScope((ET)var1, var2);
         return var4 != null && var4.size() != 0 ? this.fillDefaultValue((ET)var1, var2, var3, var4) : false;
      } else {
         return false;
      }
   }

   protected Map<String, String> getGetDraftDefaultValueMap(ET var1, boolean var2) {
      return null;
   }

   protected Map<String, Object> getGetDraftDefaultValueScope(ET var1, boolean var2) {
      try {
         if (this.getModelV2ResScopeFields() == null || this.getModelV2ResScopeFields().length == 0) {
            return null;
         }

         String var3 = "P" + this.getDEModel().getKeyDEField().getName();

         for (String var7 : this.getModelV2ResScopeFields()) {
            if (StringHelper.compare(var7, var3, true) != 0) {
               Object var8 = var1.get(var7);
               if (var8 != null) {
                  if (var7 instanceof String && StringHelper.isNullOrEmpty((String)var8)) {
                     return null;
                  }

                  HashMap var9 = new HashMap();
                  var9.put(var7, var8);
                  return var9;
               }
            }
         }
      } catch (Exception var10) {
         log.error(var10);
      }

      return null;
   }

   protected Map<String, String> getGetDefaultValueMap(ET var1, boolean var2) {
      return this.getGetDraftDefaultValueMap((ET)var1, var2);
   }

   protected Map<String, Object> getGetDefaultValueScope(ET var1, boolean var2) {
      return this.getGetDraftDefaultValueScope((ET)var1, var2);
   }

   protected boolean fillDefaultValue(ET var1, boolean var2) throws Exception {
      Map var3 = this.getGetDefaultValueMap((ET)var1, var2);
      if (var3 != null && var3.size() != 0) {
         Map var4 = this.getGetDefaultValueScope((ET)var1, var2);
         return var4 != null && var4.size() != 0 ? this.fillDefaultValue((ET)var1, var2, var3, var4) : false;
      } else {
         return false;
      }
   }

   protected boolean fillDefaultValue(ET var1, boolean var2, Map<String, String> var3, Map<String, Object> var4) throws Exception {
      boolean var5 = false;
      SelectContext var6 = new SelectContext();

      for (String var8 : var3.keySet()) {
         String var9 = DataTypeHelper.getStringValue(var1.get(var8));
         if (StringHelper.isNullOrEmpty(var9) || var9.indexOf("{0}") != -1) {
            SelectField var10 = new SelectField();
            var10.setName(var8);
            var6.addSelectField(var10);
            var5 = true;
         }
      }

      if (!var5) {
         return false;
      }

      SelectGroupFilter var20 = new SelectGroupFilter();
      var20.setCondOp("AND");
      var6.setSelectFilter(var20);

      for (Entry<String, Object> var23 : var4.entrySet()) {
         SelectFieldFilter var27 = new SelectFieldFilter();
         var27.setDEFName((String)var23.getKey());
         if (var23.getValue() == null) {
            Object var11 = var1.get((String)var23.getKey());
            if (var11 == null) {
               var27.setCondOp("ISNULL");
            } else {
               var27.setCondOp("EQ");
               var27.setCondObjectValue(var11);
            }
         } else {
            var27.setCondOp("EQ");
            Object var30 = var23.getValue();
            if (var30 instanceof String && StringHelper.isNullOrEmpty((String)var30)) {
               var30 = var1.get((String)var23.getKey());
            }

            if (var30 == null) {
               return false;
            }

            if (var2 && var30 instanceof String && !KeyValueHelper.isTempKey((String)var30)) {
               var2 = false;
            }

            var27.setCondObjectValue(var30);
         }

         var20.getSelectFilterList(true).add(var27);
      }

      SelectGroupFilter var22 = new SelectGroupFilter();
      var22.setCondOp("OR");
      var20.getSelectFilterList(true).add(var22);

      for (Entry<String, String> var28 : var3.entrySet()) {
         String var31 = DataTypeHelper.getStringValue(var1.get((String)var28.getKey()));
         if (!StringHelper.isNullOrEmpty(var31)) {
            int var12 = var31.indexOf("{0}");
            if (var12 == -1) {
               continue;
            }

            var31 = var31.substring(0, var12);
         }

         SelectFieldFilter var33 = new SelectFieldFilter();
         var33.setDEFName((String)var28.getKey());
         var33.setCondOp("LEFTLIKE");
         if (StringHelper.isNullOrEmpty(var31)) {
            var33.setCondValue((String)var28.getValue());
         } else {
            var33.setCondValue(var31);
         }

         var22.getSelectFilterList(true).add(var33);
      }

      ArrayList<ET> var25 = null;
      if (var2) {
         var25 = this.selectTempEx(var6);
      } else {
         var25 = this.selectEx(var6);
      }

      HashMap<String, Object> var29 = new HashMap<String, Object>();
      int var32 = 0;

      boolean var36;
      label136:
      do {
         if (var32 == 0) {
            for (Entry<String, String> var37 : var3.entrySet()) {
               var29.put(var37.getKey(), var1.get((String)var37.getKey()));
            }
         } else {
            for (Entry<String, Object> var13 : var29.entrySet()) {
               var1.set((String)var13.getKey(), var13.getValue());
            }
         }

         var32++;
         var36 = false;
         Iterator<Entry<String, String>> var38 = var3.entrySet().iterator();

         while (true) {
            Entry var14;
            String var15;
            while (true) {
               if (!var38.hasNext()) {
                  continue label136;
               }

               var14 = (Entry)var38.next();
               var15 = DataTypeHelper.getStringValue(var1.get((String)var14.getKey()));
               if (StringHelper.isNullOrEmpty(var15)) {
                  break;
               }

               int var16 = var15.indexOf("{0}");
               if (var16 != -1) {
                  var15 = var15.replace("{0}", "%1$s");
                  break;
               }
            }

            String var39 = null;
            if (StringHelper.isNullOrEmpty(var15)) {
               var39 = StringHelper.format("%1$s%2$s", var14.getValue(), var32 == 1 ? "" : var32);
            } else {
               var39 = StringHelper.format(var15, var32 == 1 ? "" : var32);
            }

            for (IEntity var18 : var25) {
               String var19 = DataObject.getStringValue(var18.get((String)var14.getKey()), null);
               if (StringHelper.compare(var39, var19, true) == 0) {
                  var36 = true;
                  break;
               }
            }

            if (var36) {
               break;
            }

            var1.set((String)var14.getKey(), var39);
         }
      } while (var36);

      return true;
   }

   @Override
   public void createBatch(final List<ET> var1) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.create(var3);
            }
         }
      }, true);
   }

   @Override
   public void createBatch(final List<ET> var1, final boolean var2) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.create(var3, var2);
            }
         }
      }, true);
   }

   @Override
   public void updateBatch(final List<ET> var1) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.update(var3);
            }
         }
      }, true);
   }

   @Override
   public void updateBatch(final List<ET> var1, final boolean var2) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.update(var3, var2);
            }
         }
      }, true);
   }

   @Override
   public void removeBatch(final List<ET> var1) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.remove(var3);
            }
         }
      }, true);
   }

   @Override
   public void createTempBatch(final List<ET> var1) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.createTemp(var3);
            }
         }
      }, true);
   }

   @Override
   public void createTempBatch(final List<ET> var1, boolean var2) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.createTemp(var3);
            }
         }
      }, true);
   }

   @Override
   public void updateTempBatch(final List<ET> var1) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.updateTemp(var3);
            }
         }
      }, true);
   }

   @Override
   public void updateTempBatch(final List<ET> var1, final boolean var2) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.updateTemp(var3, var2);
            }
         }
      }, true);
   }

   @Override
   public void removeTempBatch(final List<ET> var1) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.removeTemp(var3);
            }
         }
      }, true);
   }

   @Override
   public void removeTempMajor(final List<ET> var1) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.removeTempMajor(var3);
            }
         }
      }, true);
   }

   @Override
   public void saveBatch(final List<ET> var1) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.save(var3);
            }
         }
      }, true);
   }

   @Override
   public void saveBatch(final List<ET> var1, final boolean var2) throws Exception {
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1x) throws Exception {
            for (ET var3 : var1) {
               PSCoreSysServiceBase.this.save(var3, var2);
            }
         }
      }, true);
   }

   @Override
   public void saveTempBatch(List<ET> var1) throws Exception {
      throw new Exception("没有实现");
   }

   @Override
   public void saveTempBatch(List<ET> var1, boolean var2) throws Exception {
      throw new Exception("没有实现");
   }

   @Override
   public void moveOrder(int var1, List<ET> var2) throws Exception {
      throw new Exception("没有实现");
   }

   @Override
   public void exportModel(ET var1, ArrayList<JSONObject> var2, int var3) throws Exception {
      super.exportModel((ET)var1, var2, var3);
   }

   protected void logModelObjChanged(ET var1, String var2) throws Exception {
   }

   @Override
   public IEntity getModelV2Entity(ET var1, String var2, String var3) throws Exception {
      if (StringHelper.isNullOrEmpty(var3)) {
         throw new Exception("传入模型标记无效");
      }

      String[] var4 = var3.split("[/]");
      String var5 = DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()), null);
      if (StringHelper.isNullOrEmpty(var5)) {
         if (!this.containsModelV2Entity(var2, var4.length)) {
            return null;
         }
      } else if (!this.containsModelV2Entity(var2, var4.length + 1)) {
         return null;
      }

      String var6 = "";
      if (StringHelper.isNullOrEmpty(var5)) {
         if (!this.getModelV2Entity((ET)var1, var4[0])) {
            return null;
         }

         if (var4.length == 1) {
            return var1;
         }

         var5 = DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName()), null);

         for (int var7 = 1; var7 < var4.length; var7++) {
            if (!StringHelper.isNullOrEmpty(var6)) {
               var6 = var6 + "/";
            }

            var6 = var6 + var4[var7];
         }
      } else {
         var6 = var3;
      }

      return this.onGetRelatedModelV2Entity((ET)var1, var2, var6);
   }

   protected IEntity onGetRelatedModelV2Entity(ET var1, String var2, String var3) throws Exception {
      return null;
   }

   protected boolean getModelV2Entity(ET var1, String var2) throws Exception {
      SelectCond var3 = new SelectCond();
      var1.copyTo(var3, false);

      for (IEntity var6 : this.select(var3)) {
         String var7 = this.getModelV2Tag((ET)var6);
         if (StringHelper.compare(var7, var2, false) == 0) {
            var6.copyTo(var1, true);
            return true;
         }
      }

      return false;
   }

   @Override
   public boolean containsModelV2Entity(String var1, int var2) throws Exception {
      if (var2 <= 0) {
         return false;
      } else {
         return StringHelper.compare(var1, this.getModelV2Name(true), false) == 0 && var2 == 1 ? true : this.onContainsRelatedModelV2Entity(var1, var2 - 1);
      }
   }

   protected boolean onContainsRelatedModelV2Entity(String var1, int var2) throws Exception {
      return false;
   }

   public static void setSimpleImportExportMode(Boolean var0) {
      simpleImportExportMode.set(var0);
   }

   public static boolean isSimpleImportExportMode() {
      Boolean var0 = simpleImportExportMode.get();
      return var0 == null ? false : var0;
   }

   public static boolean isSimpleImportExportMode(String var0) {
      return isSimpleImportExportMode();
   }

   public static void setSimpleImportExportOwner(String var0) {
      simpleImportExportOwner.set(var0);
   }

   public static String getSimpleImportExportOwner() {
      return simpleImportExportOwner.get();
   }

   @Override
   protected void doServiceWork(int var1, IServiceWork var2, boolean var3) throws Exception {
      try {
         super.doServiceWork(var1, var2, var3);
      } catch (Exception var5) {
         throw var5;
      }
   }

   @Override
   public String getFullDataInfo(ET var1) throws Exception {
      String var2 = this.getDEModel().getDataInfo((ET)var1);
      if (StringHelper.isNullOrEmpty(var2)) {
         return var2;
      }

      String var3 = this.getModelV2ResScope(var1);
      if (StringHelper.isNullOrEmpty(var3)) {
         return var2;
      }

      String[] var4 = var3.split("[#]");
      if (var4.length != 2) {
         return var2;
      }

      if (StringHelper.compare(var4[0], "PSSYSTEM", true) == 0) {
         return var2;
      }

      if (StringHelper.compare(var4[0], "PSMODULE", true) == 0) {
         return var2;
      }

      if (StringHelper.isNullOrEmpty(var4[1])) {
         return var2;
      }

      try {
         IDataEntityModel var5 = DEModelGlobal.getDEModel(var4[0]);
         IPSCoreSysService var6 = (IPSCoreSysService)var5.getService(this.getSessionFactory());
         IEntity var7 = var5.createEntity();
         var7.set(var5.getKeyDEField().getName(), var4[1]);
         var6.get(var7);
         String var8 = var6.getFullDataInfo(var7);
         return !StringHelper.isNullOrEmpty(var8) ? var8 + "|" + var2 : var2;
      } catch (Exception var9) {
         log.error(var9);
         return var2;
      }
   }

   protected void informOPInfo(ET var1, String var2) throws Exception {
      try {
         if (!isEnableOPInfoInformDefault() || PSStudioConsoleHelper.getCurrent() == null) {
            return;
         }

         ActionSession var3 = ActionSessionManager.getCurrentSession();
         if (var3 == null) {
            return;
         }

         if (!sysModelLogMap.containsKey(this.getDEModel().getName())) {
            return;
         }

         String var4 = DataObject.getStringValue(var1, this.getDEModel().getKeyDEField().getName(), null);
         if (StringHelper.isNullOrEmpty(var4) || KeyValueHelper.isTempKey(var4)) {
            return;
         }

         String var5 = StringHelper.format("INFORMOPINFO|%1$s|%2$s", this.getDEModel().getName(), var4);
         if (var3.getActionParam(var5) != null) {
            return;
         }

         var3.setActionParam(var5, "");
         IWebContext var6 = net.ibizsys.paas.web.WebContext.getCurrent();
         if (var6 == null) {
            return;
         }

         String var7 = "";
         if (net.ibizsys.paas.web.WebContext.getAppData() != null) {
            var7 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdevslnsysid");
         }

         if (StringHelper.isNullOrEmpty(var7)) {
            return;
         }

         String var8 = var6.getCurLoginName();
         if (StringHelper.isNullOrEmpty(var8)) {
            var8 = "!未知用户";
         }

         IEntity var9 = var1;
         if (StringHelper.compare(var2, "DELETE", true) == 0) {
            var9 = this.getLast(var1, true);
         }

         if (var9 == null) {
            var9 = var1;
         }

         String var10 = PSObjChangeTypeCodeListModel.getInstance().getCodeListText(var2, true);
         Object var11 = null;

         try {
            var11 = this.getFullDataInfo((ET)var9);
         } catch (Exception var15) {
            var11 = "!无法计算";
         }

         String var12 = StringHelper.format("%1$s [%2$s] %3$s(%4$s)[%5$s]", var8, var10, this.getDEModel().getLogicName(), this.getModelV2Name(true), var11);
         if (StringHelper.compare(var2, "DELETE", true) == 0) {
            var12 = PSStudioConsoleHelper.getContent(var12, 33, -1, 1);
         } else if (StringHelper.compare(var2, "CREATE", true) == 0) {
            var12 = PSStudioConsoleHelper.getContent(var12, 32, -1, 1);
         } else if (StringHelper.compare(var2, "UPDATE", true) == 0) {
            var12 = PSStudioConsoleHelper.getContent(var12, 34, -1, 1);
         }

         final String var13 = var7;
         final String var14 = var12;
         SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction() {
            @Override
            public void commit() {
               PSStudioConsoleHelper.getCurrent().sendConsole(var13, var14, "操作信息");
            }

            @Override
            public void rollback() {
            }
         });
      } catch (Exception var16) {
         log.error(var16);
      }
   }

   @Override
   public void getDraftTempMajorFrom(ET var1) throws Exception {
      super.getDraftTempMajorFrom((ET)var1);
      this.onRemoveEntityUncopyValues((ET)var1, true);
   }

   @Override
   public void getDraftTempFrom(ET var1) throws Exception {
      super.getDraftTempFrom((ET)var1);
      this.onRemoveEntityUncopyValues((ET)var1, true);
   }

   @Override
   public PSMOSFile[] listFiles(PSMOSFile var1, String var2, IPSMOSFileFilter var3) throws Exception {
      final CallResult var4 = new CallResult();
      final PSMOSFile var5 = var1;
      final String var6 = var2;
      final IPSMOSFileFilter var7 = var3;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            var4.setUserObject(PSCoreSysServiceBase.this.internalListFiles(var5, var6, var7));
         }
      }, false);
      return var4.getUserObject() == null ? null : (PSMOSFile[])var4.getUserObject();
   }

   protected PSMOSFile[] internalListFiles(PSMOSFile var1, String var2, IPSMOSFileFilter var3) throws Exception {
      String[] var4 = null;
      if (!StringHelper.isNullOrEmpty(var2)) {
         var2 = var2.trim();
         if (!StringHelper.isNullOrEmpty(var2) && StringHelper.compare(var2, "/", false) != 0) {
            if (var2.indexOf("/") == 0) {
               var2 = var2.substring(1);
            }

            var4 = var2.split("[/]");
         }
      }

      if (var4 != null && var4.length != 0) {
         if (var4.length == 1) {
            String var22 = var4[0];
            if (var22.indexOf("[") == 0 && var22.indexOf("]") == var22.length() - 1) {
               return this.listDRFolders(var1, var22, var3);
            } else if (var22.indexOf("<") == 0 && var22.indexOf(">") == var22.length() - 1) {
               return this.listDRDataFolders(var1, null, var22, var3);
            } else if (getMOSVer() == 2) {
               return this.listDRDataFolders(var1, null, var22, var3);
            } else {
               throw new Exception(StringHelper.format("无法识别的路径：%1$s", var22));
            }
         } else {
            String var21 = null;
            String var24 = null;
            String var7 = null;
            String var8 = null;
            String var9 = var4[0];
            String var10 = var4[1];
            if (var9.indexOf("[") == 0 && var9.indexOf("]") == var9.length() - 1) {
               var21 = var9;
               if (var10.indexOf("<") == 0 && var10.indexOf(">") == var10.length() - 1) {
                  var24 = var10;
               }
            } else if (var9.indexOf("<") == 0 && var9.indexOf(">") == var9.length() - 1) {
               var24 = var9;
            }

            if (getMOSVer() == 2) {
               var24 = var9;
            }

            if (StringHelper.isNullOrEmpty(var24)) {
               throw new Exception(StringHelper.format("无法识别的路径：%1$s/%2$s", var9, var10));
            }

            byte var11 = 0;
            if (StringHelper.isNullOrEmpty(var21)) {
               var7 = var4[1];
               var11 = 2;
            } else if (var4.length > 2) {
               var7 = var4[2];
               var11 = 3;
            }

            if (StringHelper.isNullOrEmpty(var7)) {
               return this.listDRDataFolders(var1, var21, var24, var3);
            }

            for (int var12 = var11; var12 < var4.length; var12++) {
               if (StringHelper.isNullOrEmpty(var8)) {
                  var8 = var4[var12];
               } else {
                  var8 = var8 + "/";
                  var8 = var8 + var4[var12];
               }
            }

            boolean var26 = false;
            if (!StringHelper.isNullOrEmpty(var8)) {
               var26 = true;
            }

            PSMOSFile[] var13 = this.listDRDataFolders(var1, var21, var24, null, var26);
            if (var13 != null) {
               for (PSMOSFile var17 : var13) {
                  if ((StringHelper.isNullOrEmpty(var8) || DataObject.getIntegerValue(var17.getFolderFlag(), 0) != 0)
                     && !StringHelper.isNullOrEmpty(var17.getModelV2Tag())
                     && StringHelper.compare(var17.getModelV2Tag(), var7, true) == 0) {
                     IDataEntityModel var18 = this.getSystemModel().getDataEntityModel(var17.getPSModelType());
                     IPSMOSFileService var19 = (IPSMOSFileService)var18.getService(this.getSessionFactory());
                     return var19.listFiles(var17, var8, var3);
                  }
               }

               for (PSMOSFile var30 : var13) {
                  if ((StringHelper.isNullOrEmpty(var8) || DataObject.getIntegerValue(var30.getFolderFlag(), 0) != 0)
                     && StringHelper.compare(var30.getPSMOSFileName(), var7, true) == 0) {
                     IDataEntityModel var31 = this.getSystemModel().getDataEntityModel(var30.getPSModelType());
                     IPSMOSFileService var32 = (IPSMOSFileService)var31.getService(this.getSessionFactory());
                     return var32.listFiles(var30, var8, var3);
                  }
               }
            }

            return null;
         }
      } else {
         ArrayList<PSMOSFile> var5 = new ArrayList<PSMOSFile>();
         PSMOSFile[] var6 = this.listCurFiles(var1, var3);
         if (var6 != null) {
            PSMOSFileUtil.addAll(var5, var6);
         }

         var6 = this.listDRFolders(var1, null, var3);
         if (var6 != null) {
            PSMOSFileUtil.addAll(var5, var6);
         }

         return var5.size() == 0 ? null : var5.toArray(new PSMOSFile[var5.size()]);
      }
   }

   @Override
   public PSMOSFile getFile(PSMOSFile var1, String var2) throws Exception {
      final CallResult var3 = new CallResult();
      final PSMOSFile var4 = var1;
      final String var5 = var2;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            var3.setUserObject(PSCoreSysServiceBase.this.internalGetFile(var4, var5));
         }
      }, false);
      return var3.getUserObject() == null ? null : (PSMOSFile)var3.getUserObject();
   }

   protected PSMOSFile internalGetFile(PSMOSFile var1, String var2) throws Exception {
      String[] var3 = null;
      if (!StringHelper.isNullOrEmpty(var2)) {
         var2 = var2.trim();
         if (!StringHelper.isNullOrEmpty(var2) && StringHelper.compare(var2, "/", false) != 0) {
            if (var2.indexOf("/") == 0) {
               var2 = var2.substring(1);
            }

            var3 = var2.split("[/]");
         }
      }

      if (var3 != null && var3.length != 0) {
         if (var3.length == 1) {
            String var20 = var3[0];
            PSMOSFile[] var21 = this.listDRFolders(var1, null, null);
            if (var21 != null && var21.length > 0) {
               for (PSMOSFile var26 : var21) {
                  String var27 = var26.getModelV2Tag();
                  if (StringHelper.isNullOrEmpty(var27)) {
                     var27 = var26.getPSMOSFileName();
                  }

                  if (StringHelper.compare(var27, var20, false) == 0) {
                     return var26;
                  }
               }
            }

            return null;
         } else {
            String var4 = null;
            String var5 = null;
            String var6 = null;
            String var7 = null;
            String var8 = var3[0];
            String var9 = var3[1];
            if (var8.indexOf("[") == 0 && var8.indexOf("]") == var8.length() - 1) {
               var4 = var8;
               if (var9.indexOf("<") == 0 && var9.indexOf(">") == var9.length() - 1) {
                  var5 = var9;
               }
            } else if (var8.indexOf("<") == 0 && var8.indexOf(">") == var8.length() - 1) {
               var5 = var8;
            }

            if (getMOSVer() == 2) {
               var5 = var8;
            }

            if (StringHelper.isNullOrEmpty(var5)) {
               throw new Exception(StringHelper.format("无法识别的路径：%1$s/%2$s", var8, var9));
            }

            byte var10 = 0;
            if (StringHelper.isNullOrEmpty(var4)) {
               var6 = var3[1];
               var10 = 2;
            } else if (var3.length > 2) {
               var6 = var3[2];
               var10 = 3;
            }

            if (StringHelper.isNullOrEmpty(var6)) {
               if (!StringHelper.isNullOrEmpty(var4) && !StringHelper.isNullOrEmpty(var5)) {
                  PSMOSFile[] var29 = this.listDRFolders(var1, var4, null);
                  if (var29 != null && var29.length > 0) {
                     for (PSMOSFile var36 : var29) {
                        String var38 = var36.getModelV2Tag();
                        if (StringHelper.isNullOrEmpty(var38)) {
                           var38 = var36.getPSMOSFileName();
                        }

                        if (StringHelper.compare(var38, var5, false) == 0) {
                           return var36;
                        }
                     }
                  }
               }

               return null;
            } else {
               for (int var11 = var10; var11 < var3.length; var11++) {
                  if (StringHelper.isNullOrEmpty(var7)) {
                     var7 = var3[var11];
                  } else {
                     var7 = var7 + "/";
                     var7 = var7 + var3[var11];
                  }
               }

               boolean var28 = false;
               if (!StringHelper.isNullOrEmpty(var7)) {
                  var28 = true;
               }

               PSMOSFile[] var12 = this.listDRDataFolders(var1, var4, var5, null, var28);
               if (var12 != null) {
                  for (PSMOSFile var16 : var12) {
                     if ((StringHelper.isNullOrEmpty(var7) || DataObject.getIntegerValue(var16.getFolderFlag(), 0) != 0)
                        && !StringHelper.isNullOrEmpty(var16.getModelV2Tag())
                        && StringHelper.compare(var16.getModelV2Tag(), var6, true) == 0) {
                        IDataEntityModel var17 = this.getSystemModel().getDataEntityModel(var16.getPSModelType());
                        IPSMOSFileService var18 = (IPSMOSFileService)var17.getService(this.getSessionFactory());
                        return var18.getFile(var16, var7);
                     }
                  }

                  for (PSMOSFile var37 : var12) {
                     if ((StringHelper.isNullOrEmpty(var7) || DataObject.getIntegerValue(var37.getFolderFlag(), 0) != 0)
                        && StringHelper.compare(var37.getPSMOSFileName(), var6, true) == 0) {
                        IDataEntityModel var39 = this.getSystemModel().getDataEntityModel(var37.getPSModelType());
                        IPSMOSFileService var40 = (IPSMOSFileService)var39.getService(this.getSessionFactory());
                        return var40.getFile(var37, var7);
                     }
                  }
               }

               return null;
            }
         }
      } else {
         if (getMOSVer() == 2 && var1.getRealEntity() != null) {
            this.fillPSMOSFile(var1, (ET)var1.getRealEntity(), null);
         }

         return var1;
      }
   }

   @Override
   public PSMOSFile[] pasteFiles(IEntity var1, PSMOSFile[] var2, String var3, IPSMOSFileAction var4) throws Exception {
      final CallResult var5 = new CallResult();
      final PSMOSFile[] var6 = var2;
      final ET var7 = (ET)var1;
      final IPSMOSFileAction var8 = var4;
      final String var9 = var3;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            var5.setUserObject(PSCoreSysServiceBase.this.internalPasteFiles(var7, var6, var9, var8));
         }
      }, false);
      return var5.getUserObject() == null ? null : (PSMOSFile[])var5.getUserObject();
   }

   protected PSMOSFile[] internalPasteFiles(ET var1, PSMOSFile[] var2, String var3, IPSMOSFileAction var4) throws Exception {
      String var5 = this.getCurUserName();
      ArrayList<PSMOSFile> var6 = new ArrayList<PSMOSFile>();

      for (PSMOSFile var10 : var2) {
         try {
            PSMOSFile var11 = this.onPasteFile((ET)var1, var10, var3, var4);
            if (var11 != null) {
               var6.add(var11);
               JSONObject var12 = new JSONObject();
               JSONObjectHelper.put(var12, "type", "COMMAND");
               JSONObjectHelper.put(var12, "subtype", "OBJECTCREATED");
               JSONObject var13 = new JSONObject();
               var13.put("srfdename", var11.getPSModelType());
               var13.put("srfkey", var11.getPSModelId());
               var13.put("srfmajortext", var11.getPSMOSFileName());
               var13.put("srfpath", var11.getPSMOSFileId());
               JSONObjectHelper.put(var12, "content", var13);
               this.sendStudioConsole(
                  true,
                  "INFO",
                  StringHelper.format("%1$s 将模型[%2$s]粘贴到[%3$s]", var5, var10.getPSMOSFileId(), var11.getPSMOSFileId()),
                  "操作信息",
                  var12.toString(),
                  false
               );
            }
         } catch (Exception var14) {
            log.error(var14);
            this.sendStudioConsole(
               true, "ERROR", StringHelper.format("%1$s 粘贴模型[%2$s]发生异常，%3$s", var5, var10.getPSMOSFileId(), var14.getMessage()), "操作信息", null, false
            );
         }
      }

      return var6.toArray(new PSMOSFile[var6.size()]);
   }

   protected PSMOSFile onPasteFile(ET var1, PSMOSFile var2, String var3, IPSMOSFileAction var4) throws Exception {
      throw new Exception(StringHelper.format("无法黏贴文件[%1$s]到[%2%s]", var2.getPSModelType(), this.getDEModel().getName()));
   }

   @Override
   public PSMOSFile getFile(IEntity var1) throws Exception {
      final CallResult var2 = new CallResult();
      final ET var3 = (ET)var1;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            var2.setUserObject(PSCoreSysServiceBase.this.internalGetFile(var3));
         }
      }, false);
      return (PSMOSFile)var2.getUserObject();
   }

   protected PSMOSFile internalGetFile(ET var1) throws Exception {
      if (StringHelper.compare(this.getDEModel().getName(), "PSSYSTEM", true) == 0) {
         PSMOSFile var15 = new PSMOSFile();
         var15.setPSMOSFileId("/");
         var15.setPSModelType(this.getModelV2Name(true));
         var15.setPSModelId(DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName())));
         var15.setPSMOSFileName(this.getFileName(var1));
         var15.setFolderFlag(1);
         var15.setFileTag("MODEL");
         return var15;
      }

      String var2 = this.getModelV2ResScope(var1);
      if (StringHelper.isNullOrEmpty(var2)) {
         throw new Exception(StringHelper.format("无法计算模型域"));
      }

      String[] var3 = var2.split("[#]");
      if (var3 != null && var3.length == 2) {
         String var4 = this.getModelV2ResScopeDER(var1);
         IDataEntityModel var5 = this.getSystemModel().getDataEntityModel(var3[0]);
         IService var6 = var5.getService(this.getSessionFactory());
         IEntity var7 = getActionCacheEntity(var6, var3[1]);
         IPSMOSFileService var8 = (IPSMOSFileService)var6;
         PSMOSFile var9 = var8.getFile(var7);
         String var10 = var9.getPSMOSFileId();
         if (StringHelper.compare(var10, "/", false) == 0) {
            var10 = "";
         }

         String var11 = var8.getDRFolderPath(var4, var1, null);
         if (getMOSVer() == 2 && StringHelper.isNullOrEmpty(var11)) {
            var11 = Inflector.getInstance().pluralize(this.getDEModel().getName().toLowerCase());
         }

         if (!StringHelper.isNullOrEmpty(var11)) {
            if (!StringHelper.isNullOrEmpty(var10)) {
               var10 = var10 + "/";
            }

            var10 = var10 + var11;
         }

         if (!StringHelper.isNullOrEmpty(var10)) {
            var10 = var10 + "/";
         }

         String var12 = PSModelV2Helper.getModelV2TagFolderName(this.getModelV2Tag((ET)var1));
         var10 = var10 + var12;
         PSMOSFile var13 = new PSMOSFile();
         if (!StringHelper.isNullOrEmpty(var10) && var10.charAt(0) != '/') {
            var10 = "/" + var10;
         }

         var13.setPSMOSFileId(var10);
         var13.setPSModelType(this.getModelV2Name(true));
         Object var14 = this.getDataType((ET)var1);
         if (var14 != null) {
            if (var14 instanceof String) {
               var13.setPSModelSubType((String)var14);
            } else {
               var13.setPSModelSubType(StringHelper.format("%1$s", var14));
            }
         }

         var13.setPSModelId(DataObject.getStringValue(var1.get(this.getDEModel().getKeyDEField().getName())));
         var13.setModelV2Tag(var12);
         var13.setPSMOSFileName(this.getFileName(var1));
         var13.setFolderFlag(this.isOutputDRFolders() ? 1 : 0);
         var13.setFileTag("MODEL");
         var13.setFileTag4(this.getFileLogicName(var1));
         return var13;
      } else {
         throw new Exception(StringHelper.format("模型域[%1$s]不正确", var2));
      }
   }

   @Override
   public PSMOSFile getFile(PSMOSFile var1, IEntity var2) throws Exception {
      return this.getFile(var1, var2, false);
   }

   @Override
   public PSMOSFile getFile(PSMOSFile var1, IEntity var2, boolean var3) throws Exception {
      final CallResult var4 = new CallResult();
      final IEntity var5 = var2;
      final PSMOSFile var6 = var1;
      final boolean var7 = var3;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            var4.setUserObject(PSCoreSysServiceBase.this.internalGetFile(var6, (ET)var5, var7));
         }
      }, false);
      return (PSMOSFile)var4.getUserObject();
   }

   protected PSMOSFile internalGetFile(PSMOSFile var1, ET var2, boolean var3) throws Exception {
      if (StringHelper.compare(this.getDEModel().getName(), "PSSYSTEM", true) == 0) {
         PSMOSFile var10 = new PSMOSFile();
         var10.setPSMOSFileId("/");
         var10.setPSModelType(this.getModelV2Name(true));
         var10.setPSModelId(DataObject.getStringValue(var2.get(this.getDEModel().getKeyDEField().getName())));
         var10.setPSMOSFileName(this.getFileName(var2));
         var10.setFolderFlag(1);
         var10.setFileTag("MODEL");
         var10.setFileTag4(this.getFileLogicName(var2));
         if (getMOSVer() != 1) {
            var10.setRealEntity(var2);
         }

         return var10;
      } else {
         boolean var4 = false;
         String var5 = this.getModelV2ResScope(var2);
         if (StringHelper.isNullOrEmpty(var5)) {
            if (getMOSVer() == 2) {
               return null;
            } else {
               throw new Exception(StringHelper.format("无法计算模型域"));
            }
         } else {
            if (var1 != null) {
               String[] var6 = var5.split("[#]");
               if (var6 == null || var6.length != 2) {
                  throw new Exception(StringHelper.format("模型域[%1$s]不正确", var5));
               }

               if (StringHelper.compare(var6[0], var1.getPSModelType(), false) != 0 || StringHelper.compare(var6[0], var1.getPSModelType(), false) != 0) {
                  var4 = true;
               }

               if (var4 && var3) {
                  return null;
               }
            }

            PSMOSFile var11 = new PSMOSFile();
            var11.setPSModelType(this.getModelV2Name(true));
            Object var7 = this.getDataType((ET)var2);
            if (var7 != null) {
               if (var7 instanceof String) {
                  var11.setPSModelSubType((String)var7);
               } else {
                  var11.setPSModelSubType(StringHelper.format("%1$s", var7));
               }
            }

            var11.setPSModelId(DataObject.getStringValue(var2.get(this.getDEModel().getKeyDEField().getName())));
            var11.setModelV2Tag(PSModelV2Helper.getModelV2TagFolderName(this.getModelV2Tag((ET)var2)));
            var11.setPSMOSFileName(this.getFileName(var2));
            if (var4) {
               var11.setFolderFlag(this.isOutputDRFolders() ? 1 : 0);
               var11.setFileTag("LINK");
               PSMOSFile var8 = this.getFile(var2);
               var11.setFileTag2(var8.getPSMOSFileId());
               String var9 = this.getModelV2ResScopeText(var2);
               if (!StringHelper.isNullOrEmpty(var9)) {
                  var11.setPSMOSFileName(var11.getPSMOSFileName() + "@" + var9);
               }

               var11.setFileTag4(this.getFileLogicName(var2));
            } else {
               var11.setFolderFlag(this.isOutputDRFolders() ? 1 : 0);
               var11.setFileTag("MODEL");
               var11.setFileTag4(this.getFileLogicName(var2));
               if (getMOSVer() == 1) {
                  this.fillPSMOSFile(var11, (ET)var2, var1);
               } else {
                  var11.setRealEntity(var2);
               }
            }

            return var11;
         }
      }
   }

   protected void fillPSMOSFile(PSMOSFile var1, ET var2, PSMOSFile var3) throws Exception {
      if (DataObject.getStringValue(var2.get("color")) != null) {
         var1.setColor(DataObject.getStringValue(var2.get("color")));
      }

      if (DataObject.getIntegerValue(var2.get("ordervalue"), null) != null) {
         var1.setOrderValue(DataObject.getIntegerValue(var2.get("ordervalue"), null));
      }

      if (getMOSVer() != 2) {
         var1.setData(this.getPSMOSFileData(var1, (ET)var2, var3));
      }
   }

   protected String getPSMOSFileData(PSMOSFile var1, ET var2, PSMOSFile var3) throws Exception {
      return getMOSVer() == 2 ? null : PSModelV2Helper.toJSONString(var2, false);
   }

   @Override
   public PSMOSFile getFileSummary(PSMOSFile var1, IEntity var2) throws Exception {
      final CallResult var3 = new CallResult();
      final IEntity var4 = var2;
      final PSMOSFile var5 = var1;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSMOSFile var2x = PSCoreSysServiceBase.this.internalGetFile(var5, (ET)var4, true);
            if (var2x != null) {
               PSMOSFile[] var3x = PSCoreSysServiceBase.this.listFiles(var5, var2x.getPSMOSFileId(), null);
               if (var3x != null) {
                  ArrayList var4x = new ArrayList();

                  for (PSMOSFile var8 : var3x) {
                     PSMOSFile[] var9 = PSCoreSysServiceBase.this.listFiles(var5, var8.getPSMOSFileId(), null);
                     if (var9 != null) {
                        ArrayList var10 = new ArrayList();

                        for (PSMOSFile var14 : var9) {
                           var10.add(var14);
                        }

                        var8.setPSMOSFiles(var10);
                        var4x.add(var8);
                     }
                  }

                  if (var4x.size() > 0) {
                     var2x.setPSMOSFiles(var4x);
                  }
               }
            }

            var3.setUserObject(var2x);
         }
      }, false);
      return (PSMOSFile)var3.getUserObject();
   }

   @Override
   public PSMOSFile getFileSummary(PSMOSFile var1, String var2) throws Exception {
      final CallResult var3 = new CallResult();
      final PSMOSFile var4 = var1;
      final String var5 = var2;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSMOSFile var2x = PSCoreSysServiceBase.this.internalGetFile(var4, var5);
            if (var2x != null) {
               PSMOSFile[] var3x = PSCoreSysServiceBase.this.listFiles(var4, var2x.getPSMOSFileId(), null);
               if (var3x != null) {
                  ArrayList var4x = new ArrayList();

                  for (PSMOSFile var8 : var3x) {
                     PSMOSFile[] var9 = PSCoreSysServiceBase.this.listFiles(var4, var8.getPSMOSFileId(), null);
                     if (var9 != null) {
                        ArrayList var10 = new ArrayList();

                        for (PSMOSFile var14 : var9) {
                           var10.add(var14);
                        }

                        var8.setPSMOSFiles(var10);
                        var4x.add(var8);
                     }
                  }

                  if (var4x.size() > 0) {
                     var2x.setPSMOSFiles(var4x);
                  }
               }
            }

            var3.setUserObject(var2x);
         }
      }, false);
      return var3.getUserObject() == null ? null : (PSMOSFile)var3.getUserObject();
   }

   @Override
   public String getFileWiki(PSMOSFile var1, String var2) throws Exception {
      final CallResult var3 = new CallResult();
      final PSMOSFile var4 = var1;
      final String var5 = var2;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            String var2x = PSCoreSysServiceBase.this.internalGetFileWiki(var4, var5);
            var3.setUserObject(var2x);
         }
      }, false);
      return var3.getUserObject() == null ? null : (String)var3.getUserObject();
   }

   protected String internalGetFileWiki(PSMOSFile var1, String var2) throws Exception {
      if (!isEnableGitLabPlugin()) {
         throw new Exception("当前环境不支持此操作");
      }

      String var3 = getCurrentPSDevSlnSysId();
      if (StringHelper.isNullOrEmpty(var3)) {
         throw new Exception("无法获取当前开发系统");
      }

      PSMOSFile var4 = this.internalGetFile(var1, var2);
      return var4 == null ? null : this.internalGetFileWiki(var4);
   }

   protected String internalGetFileWiki(PSMOSFile var1) throws Exception {
      if (!isEnableGitLabPlugin()) {
         throw new Exception("当前环境不支持此操作");
      }

      String var2 = getCurrentPSDevSlnSysId();
      if (StringHelper.isNullOrEmpty(var2)) {
         throw new Exception("无法获取当前开发系统");
      }

      PSDevSlnSys var3 = new PSDevSlnSys();
      PSDevSlnSysService var4 = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, getCurMajorSessionFactory());
      var3.setPSDevSlnSysId(var2);
      if (!var4.get(var3, true)) {
         throw new Exception("无法获取指定开发系统");
      }

      String var5 = String.format("mos%1$s", var1.getPSMOSFileId());

      try {
         WikiPage var6 = getPSGitLabPlugin().getWikiPage(var3, var5, true);
         return var6 != null ? var6.getContent() : null;
      } catch (Exception var7) {
         log.error(StringHelper.format("获取Wiki发生异常，%1$s", var7.getMessage()), var7);
         throw new Exception(StringHelper.format("获取Wiki发生异常，%1$s", var7.getMessage()), var7);
      }
   }

   @Override
   public void updateFileWiki(PSMOSFile var1, String var2, String var3) throws Exception {
      new CallResult();
      final PSMOSFile var5 = var1;
      final String var6 = var2;
      final String var7 = var3;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSCoreSysServiceBase.this.internalUpdateFileWiki(var5, var6, var7);
         }
      }, false);
   }

   protected void internalUpdateFileWiki(PSMOSFile var1, String var2, String var3) throws Exception {
      if (!isEnableGitLabPlugin()) {
         throw new Exception("当前环境不支持此操作");
      }

      String var4 = getCurrentPSDevSlnSysId();
      if (StringHelper.isNullOrEmpty(var4)) {
         throw new Exception("无法获取当前开发系统");
      }

      PSMOSFile var5 = this.internalGetFile(var1, var2);
      if (var5 != null) {
         this.internalUpdateFileWiki(var5, var3);
      }
   }

   protected void internalUpdateFileWiki(PSMOSFile var1, String var2) throws Exception {
      if (!isEnableGitLabPlugin()) {
         throw new Exception("当前环境不支持此操作");
      }

      String var3 = getCurrentPSDevSlnSysId();
      if (StringHelper.isNullOrEmpty(var3)) {
         throw new Exception("无法获取当前开发系统");
      }

      PSDevSlnSys var4 = new PSDevSlnSys();
      PSDevSlnSysService var5 = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, getCurMajorSessionFactory());
      var4.setPSDevSlnSysId(var3);
      if (!var5.get(var4, true)) {
         throw new Exception("无法获取指定开发系统");
      }

      String var6 = String.format("mos%1$s", var1.getPSMOSFileId());

      try {
         getPSGitLabPlugin().updateWikiPage(var4, var6, null, var2, true);
      } catch (Exception var8) {
         log.error(StringHelper.format("更新Wiki发生异常，%1$s", var8.getMessage()), var8);
         throw new Exception(StringHelper.format("更新Wiki发生异常，%1$s", var8.getMessage()), var8);
      }
   }

   @Override
   public String getFileAutoWiki(PSMOSFile var1, String var2, String var3) throws Exception {
      return null;
   }

   @Override
   public String getFileAutoWiki(IEntity var1, String var2) throws Exception {
      return null;
   }

   @Override
   public String getFileAutoIssue(PSMOSFile var1, String var2, String var3) throws Exception {
      return null;
   }

   @Override
   public String getFileAutoIssue(IEntity var1, String var2) throws Exception {
      return null;
   }

   protected PSMOSFile[] listCurFiles(PSMOSFile var1, IPSMOSFileFilter var2) throws Exception {
      return null;
   }

   protected PSMOSFile[] listDRFolders(PSMOSFile var1, String var2, IPSMOSFileFilter var3) throws Exception {
      PSMOSFile[] var4 = this.onListDRFolders(var1, var2, var3);
      if (var4 != null) {
         for (PSMOSFile var8 : var4) {
            if (StringHelper.isNullOrEmpty(var8.getPSModelId())) {
               var8.setPSModelType(var1.getPSModelType());
               var8.setPSModelId(var1.getPSModelId());
               var8.setPSModelSubType(var1.getPSModelSubType());
            }

            if (StringHelper.isNullOrEmpty(var8.getPSMOSFileId())) {
               String var9 = var1.getPSMOSFileId();
               if (StringHelper.compare(var9, "/", true) == 0) {
                  var9 = "";
               }

               if (!StringHelper.isNullOrEmpty(var9)) {
                  var9 = var9 + "/";
               } else {
                  var9 = "";
               }

               if (getMOSVer() == 1 && !StringHelper.isNullOrEmpty(var8.getFileTag4())) {
                  var9 = var9 + var8.getFileTag4();
                  var9 = var9 + "/";
               }

               if (!StringHelper.isNullOrEmpty(var8.getModelV2Tag())) {
                  var9 = var9 + var8.getModelV2Tag();
               } else {
                  var9 = var9 + var8.getPSMOSFileName();
               }

               if (!StringHelper.isNullOrEmpty(var9) && var9.charAt(0) != '/') {
                  var9 = "/" + var9;
               }

               var8.setPSMOSFileId(var9);
               if (var3 == null && StringHelper.compare(var8.getFileTag(), "GROUP", false) == 0) {
                  PSMOSFile var10 = new PSMOSFile();
                  PSMOSFile[] var11 = this.listDRFolders(var10, var8.getPSMOSFileName(), null);
                  if (var11 != null) {
                     ArrayList var12 = new ArrayList();

                     for (PSMOSFile var16 : var11) {
                        var12.add(PSModelV2Helper.toJSONObject(var16, false));
                     }

                     ArrayNode var20 = new ObjectMapper().createArrayNode();
                     var20.addAll(var12);
                     var8.setData(var20.toString());
                  }
               }
            }
         }
      }

      return var4;
   }

   protected PSMOSFile[] onListDRFolders(PSMOSFile var1, String var2, IPSMOSFileFilter var3) throws Exception {
      return null;
   }

   protected PSMOSFile[] listDRDataFolders(PSMOSFile var1, String var2, String var3, IPSMOSFileFilter var4) throws Exception {
      return this.listDRDataFolders(var1, var2, var3, var4, false);
   }

   protected PSMOSFile[] listDRDataFolders(PSMOSFile var1, String var2, String var3, IPSMOSFileFilter var4, boolean var5) throws Exception {
      PSMOSFile[] var6 = this.onListDRDataFolders(var1, var2, var3, var4, var5);
      if (var6 != null) {
         for (PSMOSFile var10 : var6) {
            if (StringHelper.isNullOrEmpty(var10.getPSModelId())) {
               var10.setPSModelType(var1.getPSModelType());
               var10.setPSModelSubType(var1.getPSModelSubType());
               var10.setPSModelId(var1.getPSModelId());
            }

            if (StringHelper.isNullOrEmpty(var10.getPSMOSFileId())) {
               String var11 = var1.getPSMOSFileId();
               if (StringHelper.compare(var11, "/", false) == 0) {
                  var11 = "";
               }

               if (!StringHelper.isNullOrEmpty(var11)) {
                  var11 = var11 + "/";
               } else {
                  var11 = "";
               }

               if (!StringHelper.isNullOrEmpty(var2)) {
                  var11 = var11 + var2;
                  var11 = var11 + "/";
               }

               if (!StringHelper.isNullOrEmpty(var3)) {
                  var11 = var11 + var3;
                  var11 = var11 + "/";
               }

               if (!StringHelper.isNullOrEmpty(var10.getModelV2Tag())) {
                  var11 = var11 + var10.getModelV2Tag();
               } else {
                  var11 = var11 + var10.getPSMOSFileName();
               }

               if (!StringHelper.isNullOrEmpty(var11) && var11.charAt(0) != '/') {
                  var11 = "/" + var11;
               }

               var10.setPSMOSFileId(var11);
            }
         }
      }

      return var6;
   }

   protected PSMOSFile[] onListDRDataFolders(PSMOSFile var1, String var2, String var3, IPSMOSFileFilter var4, boolean var5) throws Exception {
      return null;
   }

   protected SelectContext getListDRDataFolderCond(
      PSMOSFile var1, IPSMOSFileFilter var2, IService var3, String var4, String var5, String var6, String var7, String var8
   ) throws Exception {
      SelectContext var9 = new SelectContext();
      var9.set(var5, var6);
      Map<String, String> var10 = ((IPSMOSFileService)var3).getListDRDataFolderFields(null, var1, var2);
      if (var10 != null) {
         var10.put(var5, "");
         var10.put(var3.getDEModel().getKeyDEField().getName(), null);
         if (var3.getDEModel().getMajorDEField() != null) {
            var10.put(var3.getDEModel().getMajorDEField().getName(), null);
         }

         if (var3.getDEModel().getDEField("MEMO", true) != null) {
            var10.put("MEMO", null);
         }

         if (var3.getDEModel().getDEField("LOGICNAME", true) != null) {
            var10.put("LOGICNAME", null);
         }

         if (var3.getDEModel().getDEField("CODENAME", true) != null) {
            var10.put("CODENAME", null);
         }

         if (var3.getDEModel().getIndexTypeDEField() != null) {
            var10.put(var3.getDEModel().getIndexTypeDEField().getName(), null);
         }

         if (var3.getDEModel().getMultiFormDEField() != null) {
            var10.put(var3.getDEModel().getMultiFormDEField().getName(), null);
         }

         for (Entry var12 : var10.entrySet()) {
            var9.addSelectField((String)var12.getKey());
         }
      }

      if (!StringHelper.isNullOrEmpty(var7)) {
         String[] var14 = var7.split("[;]");

         for (int var16 = 0; var16 < var14.length; var16++) {
            String[] var13 = var14[var16].split("[:]");
            if (var13.length == 2) {
               if (StringHelper.compare(var13[1], "ISNULL", true) == 0) {
                  var9.setIsNull(var13[0]);
               } else if (StringHelper.compare(var13[1], "ISNOTNULL", true) == 0) {
                  var9.setIsNotNull(var13[0]);
               } else {
                  var9.set(var13[0], var13[1]);
               }
            }
         }
      }

      if (var2 != null && !StringHelper.isNullOrEmpty(var2.getQuery()) && var3 != null) {
         IDEDataSetCond var15 = var3.getDEModel().getFetchQuickSearchCondition(var2.getQuery());
         var9.setSelectFilter(var15);
      }

      return var9;
   }

   @Override
   public Map<String, String> getListDRDataFolderFields(Map<String, String> var1, PSMOSFile var2, IPSMOSFileFilter var3) throws Exception {
      return var1;
   }

   protected boolean isCountDRDataFolder(PSMOSFile var1, IPSMOSFileFilter var2, String var3, String var4, String var5, String var6, String var7) throws Exception {
      if (getMOSVer() == 2) {
         return false;
      } else if (var2 != null) {
         return false;
      } else {
         return StringHelper.isNullOrEmpty(var5) ? false : !ignoreCountDRDataFoldersMap.containsKey(var3);
      }
   }

   protected boolean isOutputDRDataFolder(
      PSMOSFile var1, String var2, IPSMOSFileFilter var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10
   ) throws Exception {
      if (var3 == null) {
         if (getMOSVer() == 2) {
            return true;
         }

         if (StringHelper.isNullOrEmpty(var2)) {
            if (!StringHelper.isNullOrEmpty(var4)) {
               return false;
            }
         } else if (StringHelper.compare(var2, var4, false) != 0) {
            return false;
         }
      } else {
         if (getMOSVer() == 2) {
            return true;
         }

         if (!var3.isStarQuery() && var5.indexOf(var3.getQuery()) == -1) {
            return false;
         }
      }

      if (!StringHelper.isNullOrEmpty(var10) && !StringHelper.isNullOrEmpty(var1.getPSModelSubType())) {
         String[] var11 = var10.split("[;]");

         for (String var15 : var11) {
            if (StringHelper.compare(var15, var1.getPSModelSubType(), true) == 0) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   protected String getDRFolderModelV2Name(String var1, boolean var2) {
      return var2
         ? StringHelper.format("[%1$s]", PSModelV2Helper.getModelV2TagFolderName(var1))
         : StringHelper.format("<%1$s>", PSModelV2Helper.getModelV2TagFolderName(var1));
   }

   @Override
   public String getDRFolderPath(String var1, IEntity var2, String var3) throws Exception {
      if (getMOSVer() != 2) {
         log.warn(StringHelper.format("实体[%1$s]无法计算[%2$s]的数据关系路径", this.getModelV2Name(true), var1));
         return null;
      } else {
         return null;
      }
   }

   @Override
   public String getFileName(IEntity var1) throws Exception {
      return getMOSVer() == 2 ? this.getModelV2Tag((ET)var1) : this.getDataInfo((ET)var1);
   }

   public String getFileLogicName(IEntity var1) throws Exception {
      String var2 = DataObject.getStringValue(var1.get("LOGICNAME"), null);
      if (!StringHelper.isNullOrEmpty(var2)) {
         return var2;
      }

      var2 = DataObject.getStringValue(var1.get(this.getDEModel().getMajorDEField().getName()), null);
      if (StringHelper.isNullOrEmpty(var2)) {
         return null;
      }

      String var3 = this.getModelV2Tag((ET)var1);
      return StringHelper.compare(var2, var3, true) != 0 ? var2 : null;
   }

   @Override
   public PSMOSFile createFile(PSMOSFile var1, String var2, Map<String, Object> var3) throws Exception {
      final CallResult var4 = new CallResult();
      final PSMOSFile var5 = var1;
      final String var6 = var2;
      final Map var7 = var3;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSMOSFile var2x = PSCoreSysServiceBase.this.internalCreateFile(var5, var6, var7);
            var4.setUserObject(var2x);
         }
      }, false);
      return var4.getUserObject() == null ? null : (PSMOSFile)var4.getUserObject();
   }

   protected PSMOSFile internalCreateFile(PSMOSFile var1, String var2, Map<String, Object> var3) throws Exception {
      String[] var4 = var2.split("[/]");
      if (var4.length < 2) {
         throw new Exception(String.format("文件路径[%1$s]不正确", var2));
      }

      String var5 = "";

      for (int var6 = 0; var6 < var4.length - 2; var6++) {
         if (var6 != 0) {
            var5 = var5 + "/";
         }

         var5 = var5 + var4[var6];
      }

      if (StringHelper.isNullOrEmpty(var5)) {
         var5 = "/";
      }

      PSMOSFile var22 = this.getFile(var1, var5);
      if (var22 == null) {
         throw new Exception(String.format("无法识别的文件路径[%1$s]", var5));
      }

      if (StringHelper.isNullOrEmpty(var22.getPSModelType())) {
         throw new Exception(String.format("文件路径[%1$s]未指向模型对象", var5));
      }

      IDataEntityModel var7 = this.getSystemModel().getDataEntityModel(var22.getPSModelType());
      IService var8 = var7.getService(this.getSessionFactory());
      IPSMOSFileService var9 = (IPSMOSFileService)var8;
      String var10 = var4[var4.length - 2];
      String var11 = var4[var4.length - 1];
      PSMOSFileFilter var12 = new PSMOSFileFilter();
      var12.setQuery(var10);
      PSMOSFile[] var13 = var9.listFiles(var22, "/", var12);
      if (var13 != null && var13.length != 0) {
         IDataEntityModel var14 = this.getSystemModel().getDataEntityModel(var13[0].getFileTag3());
         String var15 = var13[0].getFileTag2();
         if (StringHelper.isNullOrEmpty(var15)) {
            throw new Exception(String.format("文件路径[%1$s]关系标记无效", var5 + "/" + var10));
         }

         String[] var16 = var15.split("[|]");
         if (var16.length != 2) {
            throw new Exception(String.format("文件路径[%1$s]关系标记无效", var5 + "/" + var10));
         }

         IService var17 = var14.getService(this.getSessionFactory());
         IEntity var18 = var14.createEntity();
         if (var3 != null) {
            for (Entry var20 : var3.entrySet()) {
               var18.set((String)var20.getKey(), var20.getValue());
            }
         }

         var18.set(var16[1], var22.getPSModelId());
         ((IPSModelV2Service)var17).setModelV2Tag(var18, var11);
         if ("PSSYSTEM".equals(var1.getPSModelType())) {
            var18.set("PSSYSTEMID", var1.getPSModelId());
         }

         try {
            ((IPSMOSFileService)var17).getDraftFile(var18, var22, var11);
            var17.create(var18);
         } catch (Exception var21) {
            throw new Exception(String.format("新建模型发生异常，%1$s", var21.getMessage()), var21);
         }

         return ((IPSMOSFileService)var17).getFile(var18);
      } else {
         throw new Exception(String.format("无法识别的文件路径[%1$s]", var5 + "/" + var10));
      }
   }

   @Override
   public void getDraftFile(IEntity var1, PSMOSFile var2, String var3) throws Exception {
      if (this.getDEModel().getDEField("CODENAME", true) != null) {
         Object var4 = var1.get("CODENAME");
         if (StringHelper.isNullOrEmpty(var4)) {
            Matcher var5 = codeNamePattern.matcher(var3);
            boolean var6 = var5.matches();
            if (var6) {
               var1.set("CODENAME", var3);
            }
         }
      }

      this.getDraft((ET)var1);
   }

   @Override
   public void deleteFile(PSMOSFile var1, String var2) throws Exception {
      final PSMOSFile var3 = var1;
      final String var4 = var2;
      this.doServiceWork(new IServiceWork() {
         @Override
         public void execute(ITransaction var1) throws Exception {
            PSCoreSysServiceBase.this.internalDeleteFile(var3, var4);
         }
      }, false);
   }

   protected void internalDeleteFile(PSMOSFile var1, String var2) throws Exception {
   }

   public boolean isOutputDRFolders() {
      return false;
   }

   @Override
   public String getDataInfo(ET var1) throws Exception {
      String var2 = DataObject.getStringValue(var1.get(this.getDEModel().getMajorDEField().getName()));
      String var3 = DataObject.getStringValue(var1.get("LOGICNAME"));
      if (StringHelper.isNullOrEmpty(var3)) {
         return var2;
      } else {
         return StringHelper.compare(var3, var2, false) != 0 ? StringHelper.format("%1$s (%2$s)", var3, var2) : var2;
      }
   }

   protected final boolean isMajorSessionFactory() {
      return isMajorSessionFactory(this.getSessionFactory());
   }

   protected Object getDefaultValue(IWebContext var1, String var2, String var3, int var4) throws Exception {
      return !StringHelper.isNullOrEmpty(var2) && var2.indexOf("USER") == 0 ? null : DefaultValueHelper.getValue(var1, var2, var3, var4);
   }

   public Object getDataType(ET var1) throws Exception {
      return null;
   }

   protected void fillPasteEntity(IEntity var1, String var2) throws Exception {
      if (var2.length() > 9) {
         String var3 = var2.substring(9);
         if (!StringHelper.isNullOrEmpty(var3)) {
            String[] var4 = var3.split("[;]");

            for (int var5 = 0; var5 < var4.length; var5++) {
               String[] var6 = var4[var5].split("[:]");
               if (var6.length == 2) {
                  var1.set(var6[0], var6[1]);
               }
            }
         }
      }
   }

   @Override
   public PSHelpSection[] getPasteHelps(IEntity var1) throws Exception {
      PSHelpSection[] var2 = pastePSHelpSectionsMap.get(this.getDEModel().getName());
      if (var2 == null) {
         ArrayList<PSHelpSection> var3 = new ArrayList<PSHelpSection>();
         this.onFillPasteHelps((ET)var1, var3);
         var2 = var3.toArray(new PSHelpSection[var3.size()]);
         pastePSHelpSectionsMap.put(this.getDEModel().getName(), var2);
      }

      return var2;
   }

   protected void onFillPasteHelps(ET var1, List<PSHelpSection> var2) throws Exception {
   }

   @Override
   public void doServiceWork(IServiceWork var1, boolean var2) throws Exception {
      super.doServiceWork(var1, var2);
   }

   protected String executeCallback(String var1, String var2) throws Exception {
      restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
      HttpHeaders var3 = new HttpHeaders();
      var3.setContentType(MediaType.APPLICATION_JSON);
      HttpEntity var4 = new HttpEntity<>(var2, var3);

      try {
         ResponseEntity var5 = restTemplate.exchange(new URI(var1), HttpMethod.POST, var4, String.class);
         if (var5.getStatusCode() == HttpStatus.OK) {
            return (String)var5.getBody();
         } else {
            throw new Exception(StringHelper.format("请求发生异常，%1$s", var5.getStatusCode().getReasonPhrase()));
         }
      } catch (Exception var12) {
         if (var12 instanceof HttpServerErrorException) {
            HttpServerErrorException var6 = (HttpServerErrorException)var12;

            String var7;
            try {
               var7 = new String(var6.getResponseBodyAsByteArray(), "UTF-8");
            } catch (UnsupportedEncodingException var11) {
               log.error(var11);
               var7 = var6.getResponseBodyAsString();
            }

            if (!StringHelper.isNullOrEmpty(var7)) {
               if (var6.getStatusCode().value() >= 400 && var6.getStatusCode().value() <= 500 && var7.indexOf("{") == 0) {
                  try {
                     ObjectNode var8 = (ObjectNode)JsonNodeHelper.fromString(var7);
                     JsonNode var9 = var8.get("message");
                     if (var9 != null && !var9.isNull()) {
                        var7 = var9.asText();
                     }
                  } catch (Exception var10) {
                     log.error(var10);
                  }
               }

               throw new Exception(var7, var12);
            }
         }

         throw new Exception(StringHelper.format("请求发生异常，%1$s", var12.getMessage()), var12);
      }
   }

   protected String getRealCallbackUrl(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      return var1.replace("{psdevslnsysid}", WebUtility.encodeURLParamValue(var2))
         .replace("{psdevslnid}", WebUtility.encodeURLParamValue(var3))
         .replace("{runmode}", WebUtility.encodeURLParamValue(var4))
         .replace("{system}", WebUtility.encodeURLParamValue(var5))
         .replace("{image}", WebUtility.encodeURLParamValue(var6))
         .replace("{token}", WebUtility.encodeURLParamValue(var7));
   }

   protected String getCurUserName() throws Exception {
      String var1 = null;
      if (WebContext.getCurrent() != null) {
         var1 = WebContext.getCurrent().getCurLoginName();
      }

      if (StringHelper.isNullOrEmpty(var1)) {
         var1 = "!未知用户";
      }

      return var1;
   }

   @Override
   public void translate(Map<String, Object> var1) throws Exception {
      this.onTranslate(var1);
   }

   protected void onTranslate(Map<String, Object> var1) throws Exception {
   }

   @Override
   public abstract IPSDataEntityModel<ET> getDEModel();

   protected void fillEntity(ET var1) throws Exception {
      if (this.getDEModel().isTranslateDEFieldServiceCodeName()) {
         Iterator var2 = this.getDEModel().getDEFields();

         while (var2.hasNext()) {
            IPSDEFieldModel var3 = (IPSDEFieldModel)var2.next();
            if (StringHelper.compare(var3.getName(), var3.getServiceCodeName(), true) != 0
               && !var1.contains(var3.getName())
               && var1.contains(var3.getServiceCodeName())) {
               var1.set(var3.getName(), var1.get(var3.getServiceCodeName()));
            }
         }
      }
   }

   static {
      restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
      ignoreCountDRDataFoldersMap.put("DER1N_PSSYSDBCHGLOG_PSDATAENTITY_PSDEID", "");
      ignoreCountDRDataFoldersMap.put("DER1N_PSSYSDBCHGLOG_PSSYSTEM_PSSYSTEMID", "");
      ignoreCountDRDataFoldersMap.put("DER1N_PSSYSDBCHGLOG_PSSYSAPP_PSSYSAPPID", "");
      aliasModelV2Map.put("PSAPPPORTALVIEW", "PSAPPVIEW");
      aliasModelV2Map.put("PSAPPPANELVIEW", "PSAPPVIEW");
      aliasModelV2Map.put("PSAPPINDEXVIEW", "PSAPPVIEW");
      aliasModelV2Map.put("PSAPPDEVIEW", "PSAPPVIEW");
      aliasModelV2Map.put("PSAPPDYNADEVIEW", "PSAPPVIEW");
      aliasModelV2Map.put("PSAPPUTILVIEW", "PSAPPVIEW");
      ignoreImportModelFieldV2Map.put("PSVIEWTYPELOGIC|PSVIEWLOGICTYPEID", 0);
      ignoreImportModelFieldV2Map.put("PSSYSDBCHGLOG|PSDEID", 0);
      ignoreImportModelFieldV2Map.put("PSSYSISSUE|PSSYSAPPID", 0);
      ignoreImportModelFieldV2Map.put("PSSYSDBCHGLOG|PSSYSAPPID", 0);
      ignoreImportModelFieldV2Map.put("PSSYSTEM|SRCPSSYSTEMID", 0);
      ignoreImportModelFieldV2Map.put("PSHELPSECTION|PSCODELISTID", 0);
      ignoreImportModelFieldV2Map.put("PSHELPSECTION|PSDEFIELDID", 0);
      ignoreImportModelFieldV2Map.put("PSHELPSECTION|PSHELPSECTIONTEMPLID", 0);
      ignoreImportModelFieldV2Map.put("PSLANGUAGERES|PSDEID", 0);
      ignoreImportModelFieldV2Map.put("PSLANGUAGERES|PSDEVIEWBASEID", 0);
      ignoreImportModelFieldV2Map.put("PSLANGUAGERES|PSWFID", 0);
      ignoreImportModelFieldV2Map.put("PSLANGUAGERES|PSWFVERSIONID", 0);
      ignoreImportModelFieldV2Map.put("PSLANGUAGERES|PSSYSAPPID", 0);
      ignoreImportModelFieldV2Map.put("PSLANGUAGERES|PSAPPVIEWID", 0);
      ignoreImportModelFieldV2Map.put("PSLANGUAGERES|PSDEFID", 0);
      ignoreImportModelFieldV2Map.put("PSHELPSECTION|PSDEUIACTIONID", 0);
      ignoreImportModelFieldV2Map.put("PSDEFIELD|PSDETABLEID", 0);
      ignoreImportModelFieldV2Map.put("PSDEFIELD|PSSYSDBCOLUMNID", 0);
      ignoreExportModelV2Map.put("PSPFPUBCODE", 1);
      ignoreExportModelV2Map.put("PSTASKSERVER", 1);
      ignoreExportModelV2Map.put("PSROBOT", 1);
      ignoreExportModelV2Map.put("PSSFCODETYPE", 1);
      ignoreExportModelV2Map.put("PSBACKSERVICE", 1);
      ignoreExportModelV2Map.put("PSNDFILE", 1);
      ignoreExportModelV2Map.put("PSSYSMODELINST", 1);
      ignoreExportModelV2Map.put("PSSVRDOMAIN", 1);
      ignoreExportModelV2Map.put("PSAPPSERVER", 1);
      ignoreExportModelV2Map.put("PSSFPKG", 1);
      ignoreExportModelV2Map.put("PSSFPKGVER", 1);
      ignoreExportModelV2Map.put("PSLANGUAGE", 1);
      ignoreExportModelV2Map.put("PSCONSOLESERVER", 1);
      ignoreExportModelV2Map.put("PSMSPLATFORMNODE", 1);
      ignoreExportModelV2Map.put("PSSAMPLEVALUE", 1);
      ignoreExportModelV2Map.put("PSCODELISTTEMPL", 1);
      ignoreExportModelV2Map.put("PSSFPLUGIN", 1);
      ignoreExportModelV2Map.put("PSDEPLOYCENTER", 1);
      ignoreExportModelV2Map.put("PSEDITORTYPE", 1);
      ignoreExportModelV2Map.put("PSSEARCHENGINEINST", 1);
      ignoreExportModelV2Map.put("PSSUBAPPVIEW", 1);
      ignoreExportModelV2Map.put("PSPDTAPPFUNC", 1);
      ignoreExportModelV2Map.put("PSSUBAPP", 1);
      ignoreExportModelV2Map.put("PSUIENGINETYPE", 1);
      ignoreExportModelV2Map.put("PSDBDEVINSTBK", 1);
      ignoreExportModelV2Map.put("PSUNIT", 1);
      ignoreExportModelV2Map.put("PSASGROUP", 1);
      ignoreExportModelV2Map.put("PSDBVALUEOP", 1);
      ignoreExportModelV2Map.put("PSAPPTYPE", 1);
      ignoreExportModelV2Map.put("PSPFPKG", 1);
      ignoreExportModelV2Map.put("PSPFPKGVER", 1);
      ignoreExportModelV2Map.put("PSSF", 1);
      ignoreExportModelV2Map.put("PSDBDEVINST", 1);
      ignoreExportModelV2Map.put("PSSYSPOLICY", 1);
      ignoreExportModelV2Map.put("PSPF", 1);
      ignoreExportModelV2Map.put("PSSUBSYS", 1);
      ignoreExportModelV2Map.put("PSSTUDIOTHEME", 1);
      ignoreExportModelV2Map.put("PSVALUERULE", 1);
      ignoreExportModelV2Map.put("PSCTRLTYPE", 1);
      ignoreExportModelV2Map.put("PSREGISTRYREPO", 1);
      ignoreExportModelV2Map.put("PSREGISTRYITEM", 1);
      ignoreExportModelV2Map.put("PSDEFDATATYPE", 1);
      ignoreExportModelV2Map.put("PSMQINST", 1);
      ignoreExportModelV2Map.put("PSSYSENGINECFG", 1);
      ignoreExportModelV2Map.put("PSMSPLATFORM", 1);
      ignoreExportModelV2Map.put("PSVARTYPE", 1);
      ignoreExportModelV2Map.put("PSDEDQPDCOND", 1);
      ignoreExportModelV2Map.put("PSWORKSHOPSERVER", 1);
      ignoreExportModelV2Map.put("PSPFSTYLE", 1);
      ignoreExportModelV2Map.put("PSSFCODEFOLDER", 1);
      ignoreExportModelV2Map.put("PSDEVSERVER", 1);
      ignoreExportModelV2Map.put("PSIMAGETEMPL", 1);
      ignoreExportModelV2Map.put("PSMODELAPIMETHOD", 1);
      ignoreExportModelV2Map.put("PSCSSCATTEMPL", 1);
      ignoreExportModelV2Map.put("PSHELPSECTIONTEMPL", 1);
      ignoreExportModelV2Map.put("PSEDITORSTYLE", 1);
      ignoreExportModelV2Map.put("PSSFSAHANDLER", 1);
      ignoreExportModelV2Map.put("PSVIEWENGINE", 1);
      ignoreExportModelV2Map.put("PSWFENGINEINST", 1);
      ignoreExportModelV2Map.put("PSCOREPRDFUNC", 1);
      ignoreExportModelV2Map.put("PSCOREPRDCAT", 1);
      ignoreExportModelV2Map.put("PSCOREPRDISSUE", 1);
      ignoreExportModelV2Map.put("PSCOREPRD", 1);
      ignoreExportModelV2Map.put("PSPFPLUGIN", 1);
      ignoreExportModelV2Map.put("PSDEJOINTYPE", 1);
      ignoreExportModelV2Map.put("PSPFCDN", 1);
      ignoreExportModelV2Map.put("PSDEPLOYSERVER", 1);
      ignoreExportModelV2Map.put("PSSFACHANDLER", 1);
      ignoreExportModelV2Map.put("PSSFSTYLEVER", 1);
      ignoreExportModelV2Map.put("PSSFSTYLE", 1);
      ignoreExportModelV2Map.put("PSWORKSPACE", 1);
      ignoreExportModelV2Map.put("PSMSPLATFORMFUNC", 1);
      ignoreExportModelV2Map.put("PSSYSUIACTION", 1);
      ignoreExportModelV2Map.put("PSSYSLANRES", 1);
      ignoreExportModelV2Map.put("PSBDDEVINST", 1);
      ignoreExportModelV2Map.put("PSSYSPRODUCT", 1);
      ignoreExportModelV2Map.put("PSPDTVIEW", 1);
      ignoreExportModelV2Map.put("PSCOUNTER", 1);
      ignoreExportModelV2Map.put("PSSVNINSTREPO", 1);
      ignoreExportModelV2Map.put("PSDCINST", 1);
      ignoreExportModelV2Map.put("PSSVRPROVIDER", 1);
      ignoreExportModelV2Map.put("PSRTWXACCOUNT", 1);
      ignoreExportModelV2Map.put("PSSTUDIOSERVERGRP", 1);
      ignoreExportModelV2Map.put("PSSYSTOOLBAR", 1);
      ignoreExportModelV2Map.put("PSDBTYPE", 1);
      ignoreExportModelV2Map.put("PSPORTLET", 1);
      ignoreExportModelV2Map.put("PSVTSTYLE", 1);
      ignoreExportModelV2Map.put("PSSFSTYLEPARAM", 1);
      ignoreExportModelV2Map.put("PSDEFTYPE", 1);
      ignoreExportModelV2Map.put("PSDBVALUEFUNC", 1);
      ignoreExportModelV2Map.put("PSGITUSER", 1);
      ignoreExportModelV2Map.put("PSCSSTEMPL", 1);
      ignoreExportModelV2Map.put("PSVIEWLOGICTYPE", 1);
      ignoreExportModelV2Map.put("PSROBOTABILITY", 1);
      ignoreExportModelV2Map.put("PSSYSUIACTION", 1);
      ignoreExportModelV2Map.put("PSDEFDATATYPE", 1);
      ignoreExportModelV2Map.put("PSDBTYPE", 1);
      ignoreExportModelV2Map.put("PSAPPTYPE", 1);
      ignoreExportModelV2Map.put("PSPF", 1);
      ignoreExportModelV2Map.put("PSPFSTYLE", 1);
      ignoreExportModelV2Map.put("PSSF", 1);
      ignoreExportModelV2Map.put("PSSFSTYLE", 1);
      ignoreExportModelV2Map.put("PSSFSTYLEVER", 1);
      ignoreExportModelV2Map.put("PSSFPLUGIN", 1);
      ignoreExportModelV2Map.put("PSIMAGETEMPL", 1);
      ignoreExportModelV2Map.put("PSSAMPLEVALUE", 1);
      ignoreExportModelV2Map.put("PSVIEWTYPE", 1);
      ignoreExportModelV2Map.put("PSSFPKG", 1);
      ignoreExportModelV2Map.put("PSSFPKGVER", 1);
      ignoreExportModelV2Map.put("PSSFPKGCAT", 1);
      ignoreExportModelV2Map.put("PSSFSTYLEPARAM", 1);
      ignoreExportModelV2Map.put("PSPFPKG", 1);
      ignoreExportModelV2Map.put("PSPFPKGVER", 1);
      ignoreExportModelV2Map.put("PSPFPKGVERCDN", 1);
      ignoreExportModelV2Map.put("PSPFPUBCODE", 1);
      ignoreExportModelV2Map.put("PSPFCDN", 1);
      ignoreExportModelV2Map.put("PSVALUERULE", 1);
      ignoreExportModelV2Map.put("PSPFPLUGIN", 1);
      ignoreExportModelV2Map.put("PSIMAGETEMPL", 1);
      ignoreExportModelV2Map.put("PSDBVALUEOP", 1);
      ignoreExportModelV2Map.put("PSDEJOINTYPE", 1);
      ignoreExportModelV2Map.put("PSSYSACHANDLER", 1);
      ignoreExportModelV2Map.put("PSSYSTOOLBAR", 1);
      ignoreExportModelV2Map.put("PSCODELISTTEMPL", 1);
      ignoreExportModelV2Map.put("PSVARTYPE", 1);
      ignoreExportModelV2Map.put("PSCOUNTER", 1);
      ignoreExportModelV2Map.put("PSSUBSYS", 1);
      ignoreExportModelV2Map.put("PSDBVALUEFUNC", 1);
      ignoreExportModelV2Map.put("PSSYSLANRES", 1);
      ignoreExportModelV2Map.put("PSUNIT", 1);
      ignoreExportModelV2Map.put("PSSYSENGINECFG", 1);
      ignoreExportModelV2Map.put("PSVIEWLOGICTYPE", 1);
      ignoreExportModelV2Map.put("PSDEFTYPE", 1);
      ignoreExportModelV2Map.put("PSVIEWENGINE", 1);
      ignoreExportModelV2Map.put("PSUIENGINETYPE", 1);
      ignoreExportModelV2Map.put("PSSFSAHANDLER", 1);
      ignoreExportModelV2Map.put("PSSAHANDLER", 1);
      ignoreExportModelV2Map.put("PSPFRESOURCE", 1);
      ignoreExportModelV2Map.put("PSCSSCATTEMPL", 1);
      ignoreExportModelV2Map.put("PSSFACHANDLER", 1);
      ignoreExportModelV2Map.put("PSDEVCENTERDBINST", 0);
      ignoreExportModelV2Map.put("PSDEVCENTERAS", 0);
      ignoreExportModelV2Map.put("PSDEVSLN", 0);
      ignoreExportModelV2Map.put("PSDEVCENTER", 0);
      ignoreExportModelV2Map.put("PSDEVCENTERTS", 0);
      ignoreExportModelV2Map.put("PSTASKSERVER", 0);
      ignoreExportModelV2Map.put("PSDBDEVINST", 0);
      ignoreExportModelV2Map.put("PSBDDEVINST", 0);
      ignoreExportModelV2Map.put("PSDEVSLNSYS", 0);
      ignoreExportModelV2Map.put("PSDEVSLNSYSAPI", 0);
      ignoreExportModelV2Map.put("PSDEVSLNSYSSRV", 0);
      ignoreExportModelV2Map.put("PSSYSMODELREPO", 1);
      ignoreExportModelV2Map.put("PSDCSYSMODELREPO", 1);
      ignoreImportModelV2Map.put("PSLANGUAGERES", 0);
      deLogMap.put("PSACHANDLER", "PSDEID");
      deLogMap.put("PSCODELIST", "PSDEID");
      deLogMap.put("PSDEACMODE", "PSDEID");
      deLogMap.put("PSDEACTION", "PSDEID");
      deLogMap.put("PSDECTRL", "PSDEID");
      deLogMap.put("PSDEDATAQUERY", "PSDEID");
      deLogMap.put("PSDEDBINDEX", "PSDEID");
      deLogMap.put("PSDEDATARELATION", "PSDEID");
      deLogMap.put("PSDEDATASET", "PSDEID");
      deLogMap.put("PSDEDBCFG", "PSDEID");
      deLogMap.put("PSDEDRGROUP", "PSDEID");
      deLogMap.put("PSDEDRITEM", "PSDEID");
      deLogMap.put("PSDEDUPRULE", "PSDEID");
      deLogMap.put("PSDEFIELD", "PSDEID");
      deLogMap.put("PSDEFORM", "PSDEID");
      deLogMap.put("PSDEGRID", "PSDEID");
      deLogMap.put("PSDELOGIC", "PSDEID");
      deLogMap.put("PSDEOPPRIV", "PSDEID");
      deLogMap.put("PSDESYSPROC", "PSDEID");
      deLogMap.put("PSDETOOLBAR", "PSDEID");
      deLogMap.put("PSDEUIACTION", "PSDEID");
      deLogMap.put("PSDEVIEWBASE", "PSDEID");
      deLogMap.put("PSDEVRGROUP", "PSDEID");
      deLogMap.put("PSDEMAINSTATE", "PSDEID");
      deLogMap.put("PSDEMAINSTATERS", "PSDEID");
      deLogMap.put("PSV3MIGRATEDE", "PSDEID");
      deLogMap.put("PSDEUAGROUP", "PSDEID");
      deLogMap.put("PSDEFGROUP", "PSDEID");
      deLogMap.put("PSDEGROUP", "PSDEID");
      deLogMap.put("PSDERGROUP", "PSDEID");
      deLogMap.put("PSDEACTIONGROUP", "PSDEID");
      deLogMap.put("PSDEDATAVIEW", "PSDEID");
      deLogMap.put("PSDEMAP", "PSDEID");
      deLogMap.put("PSDEFVALUERULE", "PSDEID");
      deLogMap.put("PSDATAENTITY", "PSDATAENTITYID");
      deLogMap.put("PSDEOPPRIV", "PSDEID");
      deLogMap.put("PSDEFFORMITEM", "PSDEID");
      deLogMap.put("PSDEDATAIMP", "PSDEID");
      deLogMap.put("PSDEDATAEXP", "PSDEID");
      deLogMap.put("PSDEFINPUTTIP", "PSDEID");
      deLogMap.put("PSDEWIZARD", "PSDEID");
      deLogMap.put("PSDEACTIONWIZARD", "PSDEID");
      deLogMap.put("PSDEAWGROUP", "PSDEID");
      deModelVerMap.put("PSACHANDLER", "PSDEID");
      deModelVerMap.put("PSCODELIST", "PSDEID");
      deModelVerMap.put("PSDEACMODE", "PSDEID");
      deModelVerMap.put("PSDEACTION", "PSDEID");
      deModelVerMap.put("PSDECHART", "PSDEID");
      deModelVerMap.put("PSDECTRL", "PSDEID");
      deModelVerMap.put("PSDEDATAQUERY", "PSDEID");
      deModelVerMap.put("PSDEDBINDEX", "PSDEID");
      deModelVerMap.put("PSDEDATARELATION", "PSDEID");
      deModelVerMap.put("PSDEDATASET", "PSDEID");
      deModelVerMap.put("PSDEDATAVIEW", "PSDEID");
      deModelVerMap.put("PSDEDBCFG", "PSDEID");
      deModelVerMap.put("PSDEDRGROUP", "PSDEID");
      deModelVerMap.put("PSDEDRITEM", "PSDEID");
      deModelVerMap.put("PSDEDUPRULE", "PSDEID");
      deModelVerMap.put("PSDEFIELD", "PSDEID");
      deModelVerMap.put("PSDEFORM", "PSDEID");
      deModelVerMap.put("PSDEFSFITEM", "PSDEID");
      deModelVerMap.put("PSDEGRID", "PSDEID");
      deModelVerMap.put("PSDELIST", "PSDEID");
      deModelVerMap.put("PSDELOGIC", "PSDEID");
      deModelVerMap.put("PSDEMAP", "PSDEID");
      deModelVerMap.put("PSDEOPPRIV", "PSDEID");
      deModelVerMap.put("PSDEPRINT", "PSDEID");
      deModelVerMap.put("PSDEREPORT", "PSDEID");
      deModelVerMap.put("PSDEUTILDE", "PSDEID");
      deModelVerMap.put("PSDESYSPROC", "PSDEID");
      deModelVerMap.put("PSDETOOLBAR", "PSDEID");
      deModelVerMap.put("PSDETREEVIEW", "PSDEID");
      deModelVerMap.put("PSDEUAGROUP", "PSDEID");
      deModelVerMap.put("PSDEGROUP", "PSDEID");
      deModelVerMap.put("PSDEFGROUP", "PSDEID");
      deModelVerMap.put("PSDEACTIONGROUP", "PSDEID");
      deModelVerMap.put("PSDERGROUP", "PSDEID");
      deModelVerMap.put("PSDEUIACTION", "PSDEID");
      deModelVerMap.put("PSDEVIEWBASE", "PSDEID");
      deModelVerMap.put("PSDEVRGROUP", "PSDEID");
      deModelVerMap.put("PSDEMAINSTATE", "PSDEID");
      deModelVerMap.put("PSDEFVALUERULE", "PSDEID");
      deModelVerMap.put("PSDER", "MINORPSDEID");
      deModelVerMap.put("PSDEVIEWBASE", "PSDEID");
      deModelVerMap.put("PSDATAENTITY", "PSDATAENTITYID");
      deModelVerMap.put("PSDEOPPRIV", "PSDEID");
      deModelVerMap.put("PSDEFFORMITEM", "PSDEID");
      deModelVerMap.put("PSDEWIZARD", "PSDEID");
      deModelVerMap.put("PSDEACTIONWIZARD", "PSDEID");
      deModelVerMap.put("PSDEAWGROUP", "PSDEID");
      deModelVerMap.put("PSDESERVICEAPI", "PSDEID");
      deModelVerMap.put("PSDEUSERROLE", "PSDEID");
      deModelVerMap.put("PSDEOPPRIVROLE", "PSDEID");
      deModelVerMap.put("PSDESAMPLEDATA", "PSDEID");
      deModelVerMap.put("PSDEMAINSTATERS", "PSDEID");
      deModelVerMap2.put("PSDER", "MAJORPSDEID");
      deModelVerMap.put("PSWFDE", "PSDEID");
      deModelVerMap.remove("PSV3MIGRATEDE");
      deModelVerMap.remove("PSDETREENODE");
      deModelVerMap.remove("PSSYSDBCHGLOG");
      deModelVerMap.remove("PSSYSPORTLET");
      deModelVerMap.remove("PSV3MIGRATEDE");
      deDBVerMap.put("PSDEDATAQUERY", "PSDEID");
      deDBVerMap.put("PSDEDBCFG", "PSDEID");
      deDBVerMap.put("PSDEFIELD", "PSDEID");
      deDBVerMap.put("PSDESYSPROC", "PSDEID");
      deDBVerMap.put("PSDER", "MINORPSDEID");
      deDBVerMap.put("PSDEDBINDEX", "PSDEID");
      sysModelVerMap.put("PSACHANDLER", "");
      sysModelVerMap.put("PSACHANDLERACTION", "");
      sysModelVerMap.put("PSAPPDERS", "");
      sysModelVerMap.put("PSAPPDERSVIEW", "");
      sysModelVerMap.put("PSAPPFUNC", "");
      sysModelVerMap.put("PSAPPLAN", "");
      sysModelVerMap.put("PSAPPLOCALDE", "");
      sysModelVerMap.put("PSAPPMENU", "");
      sysModelVerMap.put("PSAPPMENUITEM", "");
      sysModelVerMap.put("PSAPPMODULE", "");
      sysModelVerMap.put("PSAPPPDTVIEW", "");
      sysModelVerMap.put("PSAPPPKG", "");
      sysModelVerMap.put("PSAPPPORTALVIEW", "");
      sysModelVerMap.put("PSAPPPVPART", "");
      sysModelVerMap.put("PSAPPRESOURCE", "");
      sysModelVerMap.put("PSAPPSBITEM", "");
      sysModelVerMap.put("PSAPPSBITEMRS", "");
      sysModelVerMap.put("PSAPPSTORYBOARD", "");
      sysModelVerMap.put("PSAPPTITLEBAR", "");
      sysModelVerMap.put("PSAPPUISTYLE", "");
      sysModelVerMap.put("PSAPPUITHEME", "");
      sysModelVerMap.put("PSAPPUSERMODE", "");
      sysModelVerMap.put("PSAPPUTIL", "");
      sysModelVerMap.put("PSAPPUTILPAGE", "");
      sysModelVerMap.put("PSAPPVIEW", "");
      sysModelVerMap.put("PSAPPWF", "");
      sysModelVerMap.put("PSAPPWFVER", "");
      sysModelVerMap.put("PSCODEITEM", "");
      sysModelVerMap.put("PSCODELIST", "");
      sysModelVerMap.put("PSCTRLMSG", "");
      sysModelVerMap.put("PSCTRLMSGITEM", "");
      sysModelVerMap.put("PSDATAENTITY", "");
      sysModelVerMap.put("PSDEACMODE", "");
      sysModelVerMap.put("PSDEACMODEITEM", "");
      sysModelVerMap.put("PSDEACTION", "");
      sysModelVerMap.put("PSDEACTIONGROUP", "");
      sysModelVerMap.put("PSDEACTIONLOGIC", "");
      sysModelVerMap.put("PSDEACTIONPARAM", "");
      sysModelVerMap.put("PSDEACTIONTEMPL", "");
      sysModelVerMap.put("PSDEACTIONWIZARD", "");
      sysModelVerMap.put("PSDEAGDETAIL", "");
      sysModelVerMap.put("PSDEAWGROUP", "");
      sysModelVerMap.put("PSDEAWGRPDETAIL", "");
      sysModelVerMap.put("PSDEAWITEM", "");
      sysModelVerMap.put("PSDECHART", "");
      sysModelVerMap.put("PSDECHARTAXES", "");
      sysModelVerMap.put("PSDECHARTPARAM", "");
      sysModelVerMap.put("PSDEDATAEXP", "");
      sysModelVerMap.put("PSDEDATAIMP", "");
      sysModelVerMap.put("PSDEDATAIMPITEM", "");
      sysModelVerMap.put("PSDEDATAQUERY", "");
      sysModelVerMap.put("PSDEDATARELATION", "");
      sysModelVerMap.put("PSDEDATASET", "");
      sysModelVerMap.put("PSDEDATASYNC", "");
      sysModelVerMap.put("PSDEDATAVIEW", "");
      sysModelVerMap.put("PSDEDBCFG", "");
      sysModelVerMap.put("PSDEDBIDXFIELD", "");
      sysModelVerMap.put("PSDEDBINDEX", "");
      sysModelVerMap.put("PSDEDQCODE", "");
      sysModelVerMap.put("PSDEDQCODECOND", "");
      sysModelVerMap.put("PSDEDQCODEEXP", "");
      sysModelVerMap.put("PSDEDQCOND", "");
      sysModelVerMap.put("PSDEDQJOIN", "");
      sysModelVerMap.put("PSDEDRDETAIL", "");
      sysModelVerMap.put("PSDEDRGROUP", "");
      sysModelVerMap.put("PSDEDRITEM", "");
      sysModelVerMap.put("PSDEDSCODE", "");
      sysModelVerMap.put("PSDEDSDQ", "");
      sysModelVerMap.put("PSDEDSGRPPARAM", "");
      sysModelVerMap.put("PSDEDTSQUEUE", "");
      sysModelVerMap.put("PSDEFDLOGIC", "");
      sysModelVerMap.put("PSDEFDTCOL", "");
      sysModelVerMap.put("PSDEFFORMITEM", "");
      sysModelVerMap.put("PSDEFGROUP", "");
      sysModelVerMap.put("PSDEFGROUPDETAIL", "");
      sysModelVerMap.put("PSDEFIELD", "");
      sysModelVerMap.put("PSDEFINPUTTIP", "");
      sysModelVerMap.put("PSDEFINPUTTIPSET", "");
      sysModelVerMap.put("PSDEFIUDETAIL", "");
      sysModelVerMap.put("PSDEFIUPDATE", "");
      sysModelVerMap.put("PSDEFIVR", "");
      sysModelVerMap.put("PSDEFORM", "");
      sysModelVerMap.put("PSDEFORMDETAIL", "");
      sysModelVerMap.put("PSDEFORMRF", "");
      sysModelVerMap.put("PSDEFSFITEM", "");
      sysModelVerMap.put("PSDEFVALUERULE", "");
      sysModelVerMap.put("PSDEFVRCOND", "");
      sysModelVerMap.put("PSDEGEIUDETAIL", "");
      sysModelVerMap.put("PSDEGEIUPDATE", "");
      sysModelVerMap.put("PSDEGRID", "");
      sysModelVerMap.put("PSDEGRIDCOL", "");
      sysModelVerMap.put("PSDEGROUP", "");
      sysModelVerMap.put("PSDEGROUPDETAIL", "");
      sysModelVerMap.put("PSDELIST", "");
      sysModelVerMap.put("PSDELISTITEM", "");
      sysModelVerMap.put("PSDELLCOND", "");
      sysModelVerMap.put("PSDELNPARAM", "");
      sysModelVerMap.put("PSDELOGIC", "");
      sysModelVerMap.put("PSDELOGICLINK", "");
      sysModelVerMap.put("PSDELOGICNODE", "");
      sysModelVerMap.put("PSDELOGICPARAM", "");
      sysModelVerMap.put("PSDEMAINSTATE", "");
      sysModelVerMap.put("PSDEMAINSTATERS", "");
      sysModelVerMap.put("PSDEMAP", "");
      sysModelVerMap.put("PSDEMAPACTION", "");
      sysModelVerMap.put("PSDEMAPDETAIL", "");
      sysModelVerMap.put("PSDEMAPDQ", "");
      sysModelVerMap.put("PSDEMAPDS", "");
      sysModelVerMap.put("PSDEMSACTION", "");
      sysModelVerMap.put("PSDEMSFIELD", "");
      sysModelVerMap.put("PSDEMSOPPRIV", "");
      sysModelVerMap.put("PSDEOPPRIV", "");
      sysModelVerMap.put("PSDEOPPRIVROLE", "");
      sysModelVerMap.put("PSDEPRINT", "");
      sysModelVerMap.put("PSDEPSLNASGRP", "");
      sysModelVerMap.put("PSDEPSLNASITEM", "");
      sysModelVerMap.put("PSDER", "");
      sysModelVerMap.put("PSDERDEFMAP", "");
      sysModelVerMap.put("PSDEREPITEM", "");
      sysModelVerMap.put("PSDEREPORT", "");
      sysModelVerMap.put("PSDERGROUP", "");
      sysModelVerMap.put("PSDERGROUPDETAIL", "");
      sysModelVerMap.put("PSDERTAW", "");
      sysModelVerMap.put("PSDERTAWI", "");
      sysModelVerMap.put("PSDESADETAIL", "");
      sysModelVerMap.put("PSDESAMPLEDATA", "");
      sysModelVerMap.put("PSDESAMPLEDATAREF", "");
      sysModelVerMap.put("PSDESARS", "");
      sysModelVerMap.put("PSDESAVR", "");
      sysModelVerMap.put("PSDESERVICEAPI", "");
      sysModelVerMap.put("PSDETABLE", "");
      sysModelVerMap.put("PSDETBITEM", "");
      sysModelVerMap.put("PSDETOOLBAR", "");
      sysModelVerMap.put("PSDETREECOL", "");
      sysModelVerMap.put("PSDETREENODE", "");
      sysModelVerMap.put("PSDETREENODECOL", "");
      sysModelVerMap.put("PSDETREENODERS", "");
      sysModelVerMap.put("PSDETREENODERV", "");
      sysModelVerMap.put("PSDETREEVIEW", "");
      sysModelVerMap.put("PSDEUAGROUP", "");
      sysModelVerMap.put("PSDEUAGRPDETAIL", "");
      sysModelVerMap.put("PSDEUIACTION", "");
      sysModelVerMap.put("PSDEUSERROLE", "");
      sysModelVerMap.put("PSDEUTILDE", "");
      sysModelVerMap.put("PSDEVIEWBASE", "");
      sysModelVerMap.put("PSDEVIEWCTRL", "");
      sysModelVerMap.put("PSDEVIEWENGINE", "");
      sysModelVerMap.put("PSDEVIEWLOGIC", "");
      sysModelVerMap.put("PSDEVIEWRV", "");
      sysModelVerMap.put("PSDEVSLNMSDEPFUNC", "");
      sysModelVerMap.put("PSDEVSLNMSDEPFUNCITEM", "");
      sysModelVerMap.put("PSDEWIZARD", "");
      sysModelVerMap.put("PSDEWIZARDFORM", "");
      sysModelVerMap.put("PSDEWIZARDSTEP", "");
      sysModelVerMap.put("PSHELPARTICLE", "");
      sysModelVerMap.put("PSHELPMODULE", "");
      sysModelVerMap.put("PSHELPPRJ", "");
      sysModelVerMap.put("PSHELPRESOURCE", "");
      sysModelVerMap.put("PSHELPSECTION", "");
      sysModelVerMap.put("PSLANGUAGE", "");
      sysModelVerMap.put("PSLANGUAGEITEM", "");
      sysModelVerMap.put("PSLANGUAGERES", "");
      sysModelVerMap.put("PSMOBAPPPACK", "");
      sysModelVerMap.put("PSMOBAPPPACKTD", "");
      sysModelVerMap.put("PSMOBAPPSTARTPAGE", "");
      sysModelVerMap.put("PSMODULE", "");
      sysModelVerMap.put("PSPANELENGINE", "");
      sysModelVerMap.put("PSPANELITEMLOGIC", "");
      sysModelVerMap.put("PSPANELLLCOND", "");
      sysModelVerMap.put("PSPANELLNPARAM", "");
      sysModelVerMap.put("PSPANELLOGICLINK", "");
      sysModelVerMap.put("PSPANELLOGICNODE", "");
      sysModelVerMap.put("PSPANELLOGICPARAM", "");
      sysModelVerMap.put("PSSUBSYSSADE", "");
      sysModelVerMap.put("PSSUBSYSSADEFIELD", "");
      sysModelVerMap.put("PSSUBSYSSADERS", "");
      sysModelVerMap.put("PSSUBSYSSADETAIL", "");
      sysModelVerMap.put("PSSUBSYSSERVICEAPI", "");
      sysModelVerMap.put("PSSUBVIEWTYPE", "");
      sysModelVerMap.put("PSSYSACTOR", "");
      sysModelVerMap.put("PSSYSAPP", "");
      sysModelVerMap.put("PSSYSBACKSERVICE", "");
      sysModelVerMap.put("PSSYSBDCOLSET", "");
      sysModelVerMap.put("PSSYSBDCOLUMN", "");
      sysModelVerMap.put("PSSYSBDINSTCFG", "");
      sysModelVerMap.put("PSSYSBDMODULE", "");
      sysModelVerMap.put("PSSYSBDPART", "");
      sysModelVerMap.put("PSSYSBDSCHEME", "");
      sysModelVerMap.put("PSSYSBDTABLE", "");
      sysModelVerMap.put("PSSYSBDTABLEDE", "");
      sysModelVerMap.put("PSSYSBDTABLEDER", "");
      sysModelVerMap.put("PSSYSBDTABLERS", "");
      sysModelVerMap.put("PSSYSCALENDAR", "");
      sysModelVerMap.put("PSSYSCALENDARITEM", "");
      sysModelVerMap.put("PSSYSCALENDARITEMRV", "");
      sysModelVerMap.put("PSSYSCODESNIPPET", "");
      sysModelVerMap.put("PSSYSCONTENT", "");
      sysModelVerMap.put("PSSYSCONTENTCAT", "");
      sysModelVerMap.put("PSSYSCOUNTER", "");
      sysModelVerMap.put("PSSYSCOUNTERITEM", "");
      sysModelVerMap.put("PSSYSCSS", "");
      sysModelVerMap.put("PSSYSCSSCAT", "");
      sysModelVerMap.put("PSSYSDASHBOARD", "");
      sysModelVerMap.put("PSSYSDATASYNCAGENT", "");
      sysModelVerMap.put("PSSYSDBCOLUMN", "");
      sysModelVerMap.put("PSSYSDBPART", "");
      sysModelVerMap.put("PSSYSDBPROC", "");
      sysModelVerMap.put("PSSYSDBPROCPARAM", "");
      sysModelVerMap.put("PSSYSDBSCHEME", "");
      sysModelVerMap.put("PSSYSDBTABLE", "");
      sysModelVerMap.put("PSSYSDBVALUEOP", "");
      sysModelVerMap.put("PSSYSDBVF", "");
      sysModelVerMap.put("PSSYSDBVFCODE", "");
      sysModelVerMap.put("PSSYSDELOGICNODE", "");
      sysModelVerMap.put("PSSYSDICTCAT", "");
      sysModelVerMap.put("PSSYSDMITEM", "");
      sysModelVerMap.put("PSSYSDMVER", "");
      sysModelVerMap.put("PSSYSDYNAMODEL", "");
      sysModelVerMap.put("PSSYSDYNAMODELATTR", "");
      sysModelVerMap.put("PSSYSEDITORSTYLE", "");
      sysModelVerMap.put("PSSYSERMAP", "");
      sysModelVerMap.put("PSSYSERMAPNODE", "");
      sysModelVerMap.put("PSSYSFILE", "");
      sysModelVerMap.put("PSSYSIMAGE", "");
      sysModelVerMap.put("PSSYSMODELGROUP", "");
      sysModelVerMap.put("PSSYSMSGTEMPL", "");
      sysModelVerMap.put("PSSYSOPPRIV", "");
      sysModelVerMap.put("PSSYSPDTVIEW", "");
      sysModelVerMap.put("PSSYSPFPITEMPL", "");
      sysModelVerMap.put("PSSYSPFPLUGIN", "");
      sysModelVerMap.put("PSSYSPORTLET", "");
      sysModelVerMap.put("PSSYSREF", "");
      sysModelVerMap.put("PSSYSREQITEM", "");
      sysModelVerMap.put("PSSYSREQITEMDATA", "");
      sysModelVerMap.put("PSSYSREQITEMHIS", "");
      sysModelVerMap.put("PSSYSREQMODULE", "");
      sysModelVerMap.put("PSSYSRESOURCE", "");
      sysModelVerMap.put("PSSYSSAHANDLER", "");
      sysModelVerMap.put("PSSYSSAMPLEVALUE", "");
      sysModelVerMap.put("PSSYSSEARCHBAR", "");
      sysModelVerMap.put("PSSYSSEARCHBARITEM", "");
      sysModelVerMap.put("PSSYSSERVICEAPI", "");
      sysModelVerMap.put("PSSYSSFCODE", "");
      sysModelVerMap.put("PSSYSSFPITEMPL", "");
      sysModelVerMap.put("PSSYSSFPLUGIN", "");
      sysModelVerMap.put("PSSYSSFPUB", "");
      sysModelVerMap.put("PSSYSSFPUBPKG", "");
      sysModelVerMap.put("PSSYSSQLCMD", "");
      sysModelVerMap.put("PSSYSSQLCMDSQL", "");
      sysModelVerMap.put("PSSYSTCASSERT", "");
      sysModelVerMap.put("PSSYSTCINPUT", "");
      sysModelVerMap.put("PSSYSTDITEM", "");
      sysModelVerMap.put("PSSYSTEM", "");
      sysModelVerMap.put("PSSYSTEMAS", "");
      sysModelVerMap.put("PSSYSTEMDBCFG", "");
      sysModelVerMap.put("PSSYSTEMMQ", "");
      sysModelVerMap.put("PSSYSTEMRUN", "");
      sysModelVerMap.put("PSSYSTESTCASE", "");
      sysModelVerMap.put("PSSYSTESTDATA", "");
      sysModelVerMap.put("PSSYSTESTMODULE", "");
      sysModelVerMap.put("PSSYSTESTPRJ", "");
      sysModelVerMap.put("PSSYSTITLEBAR", "");
      sysModelVerMap.put("PSSYSUCMAP", "");
      sysModelVerMap.put("PSSYSUCMAPNODE", "");
      sysModelVerMap.put("PSSYSUNIRES", "");
      sysModelVerMap.put("PSSYSUNISTATE", "");
      sysModelVerMap.put("PSSYSUNIT", "");
      sysModelVerMap.put("PSSYSUSERCASE", "");
      sysModelVerMap.put("PSSYSUSERCASERS", "");
      sysModelVerMap.put("PSSYSUSERDR", "");
      sysModelVerMap.put("PSSYSUSERMODE", "");
      sysModelVerMap.put("PSSYSUSERROLERES", "");
      sysModelVerMap.put("PSSYSUSERROLEDATA", "");
      sysModelVerMap.put("PSSYSUTILDE", "");
      sysModelVerMap.put("PSSYSVALUERULE", "");
      sysModelVerMap.put("PSSYSVIEWLOGIC", "");
      sysModelVerMap.put("PSSYSVIEWLOGICPARAM", "");
      sysModelVerMap.put("PSSYSVIEWPANEL", "");
      sysModelVerMap.put("PSSYSVIEWPANELITEM", "");
      sysModelVerMap.put("PSSYSVIEWPANELLOGIC", "");
      sysModelVerMap.put("PSSYSVIEWPANELMODEL", "");
      sysModelVerMap.put("PSSYSWFMODE", "");
      sysModelVerMap.put("PSSYSWFSETTING", "");
      sysModelVerMap.put("PSVIEWMSG", "");
      sysModelVerMap.put("PSVIEWMSGGROUP", "");
      sysModelVerMap.put("PSVIEWMSGGRPDETAIL", "");
      sysModelVerMap.put("PSVIEWWIZARDGROUP", "");
      sysModelVerMap.put("PSWFDE", "");
      sysModelVerMap.put("PSWFLINK", "");
      sysModelVerMap.put("PSWFLINKCOND", "");
      sysModelVerMap.put("PSWFLINKROLE", "");
      sysModelVerMap.put("PSWFPROCESS", "");
      sysModelVerMap.put("PSWFPROCPARAM", "");
      sysModelVerMap.put("PSWFPROCROLE", "");
      sysModelVerMap.put("PSWFPROCSUBWF", "");
      sysModelVerMap.put("PSWFROLE", "");
      sysModelVerMap.put("PSWFSUBWF", "");
      sysModelVerMap.put("PSWFUTILUIACTION", "");
      sysModelVerMap.put("PSWFVERSION", "");
      sysModelVerMap.put("PSWFWORKTIME", "");
      sysModelVerMap.put("PSWORKFLOW", "");
      sysModelVerMap.put("PSWXACCOUNT", "");
      sysModelVerMap.put("PSWXENTAPP", "");
      sysModelVerMap.put("PSWXLOGIC", "");
      sysModelVerMap.put("PSWXMENU", "");
      sysModelVerMap.put("PSWXMENUFUNC", "");
      sysModelVerMap.put("PSWXMENUITEM", "");
      sysModelVerMap.put("PSACHANDLER", "PSSYSTEMID");
      sysModelVerMap.put("PSCODELIST", "PSSYSTEMID");
      sysModelVerMap.put("PSDER", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSDYNAMODEL", "PSSYSTEMID");
      sysModelVerMap.put("PSDYNADETEMPL", "PSSYSTEMID");
      sysModelVerMap.put("PSDETOOLBAR", "PSSYSTEMID");
      sysModelVerMap.put("PSDEUAGROUP", "PSSYSTEMID");
      sysModelVerMap.put("PSDEGROUP", "PSSYSTEMID");
      sysModelVerMap.put("PSDEFGROUP", "PSSYSTEMID");
      sysModelVerMap.put("PSDEACTIONGROUP", "PSSYSTEMID");
      sysModelVerMap.put("PSDERGROUP", "PSSYSTEMID");
      sysModelVerMap.put("PSDEUIACTION", "PSSYSTEMID");
      sysModelVerMap.put("PSDEVIEWBASE", "PSSYSTEMID");
      sysModelVerMap.put("PSMODULE", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSAPP", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSDBVF", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSDEPLOY", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSEDITORSTYLE", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSIMAGE", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSPORTLET", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSREF", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSSFPUB", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSTEMDBCFG", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSUSERMODE", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSVALUERULE", "PSSYSTEMID");
      sysModelVerMap.put("PSWFROLE", "PSSYSTEMID");
      sysModelVerMap.put("PSWFWORKTIME", "PSSYSTEMID");
      sysModelVerMap.put("PSWORKFLOW", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSCSS", "PSSYSTEMID");
      sysModelVerMap.put("PSCTRLMSG", "PSSYSTEMID");
      sysModelVerMap.put("PSDEACTIONTEMPL", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSUNIT", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSDELOGICNODE", "PSSYSTEMID");
      sysModelVerMap.put("PSLANGUAGERES", "PSSYSTEMID");
      sysModelVerMap.put("PSLANGUAGEITEM", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSDEFTYPE", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSOPPRIV", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSUSERROLERES", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSUSERROLEDATA", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSDMVER", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSPFPLUGIN", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSSFPLUGIN", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSCOUNTER", "PSSYSTEMID");
      sysModelVerMap.put("PSDEOPPRIV", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSDICTCAT", "PSSYSTEMID");
      sysModelVerMap.put("PSSUBVIEWTYPE", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSWFSETTING", "PSSYSWFSETTINGID");
      sysModelVerMap.put("PSDEFINPUTTIP", "PSSYSTEMID");
      sysModelVerMap.put("PSVIEWMSG", "PSSYSTEMID");
      sysModelVerMap.put("PSVIEWMSGGROUP", "PSSYSTEMID");
      sysModelVerMap.put("PSDEFINPUTTIPSET", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSUNISTATE", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSUTILDE", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSSEARCHBAR", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSDASHBOARD", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSCALENDAR", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSTITLEBAR", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSVIEWPANEL", "PSSYSTEMID");
      sysModelVerMap.put("PSDEDTSQUEUE", "PSSYSTEMID");
      sysModelVerMap.put("PSAPPDEVIEW", "PSSYSTEMID");
      sysModelVerMap.put("PSAPPINDEXVIEW", "PSSYSTEMID");
      sysModelVerMap.put("PSAPPPORTALVIEW", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSBDSCHEME", "PSSYSTEMID");
      sysModelVerMap.put("PSWXACCOUNT", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSTEM", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSSERVICEAPI", "PSSYSTEMID");
      sysModelVerMap.put("PSSUBSYSSERVICEAPI", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSSAHANDLER", "PSSYSTEMID");
      sysModelVerSqlMap.put(
         "PSSYSPFPITEMPL",
         "UPDATE T_SRFPSSYSTEM SET MODELVER=MODELVER+1 WHERE EXISTS(SELECT * FROM T_SRFPSSYSPFPITEMPL INNER JOIN T_SRFPSSYSPFPLUGIN ON T_SRFPSSYSPFPITEMPL.PSSYSPFPLUGINID = T_SRFPSSYSPFPLUGIN.PSSYSPFPLUGINID WHERE T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSPFPLUGIN.PSSYSTEMID AND T_SRFPSSYSPFPITEMPL.PSSYSPFPITEMPLID=?)"
      );
      sysModelVerSqlMap.put(
         "PSSYSSFPITEMPL",
         "UPDATE T_SRFPSSYSTEM SET MODELVER=MODELVER+1 WHERE EXISTS(SELECT * FROM T_SRFPSSYSSFPITEMPL INNER JOIN T_SRFPSSYSSFPLUGIN ON T_SRFPSSYSSFPITEMPL.PSSYSSFPLUGINID = T_SRFPSSYSSFPLUGIN.PSSYSSFPLUGINID WHERE T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSSFPLUGIN.PSSYSTEMID AND T_SRFPSSYSSFPITEMPL.PSSYSSFPITEMPLID=?)"
      );
      sysModelVerSqlMap.put(
         "PSWFVERSION",
         "update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpswfversion inner join t_srfpsworkflow on t_srfpswfversion.PSWFID = t_srfpsworkflow.PSWORKFLOWID   where t_srfpssystem.PSSYSTEMID = t_srfpsworkflow.PSSYSTEMID and t_srfpswfversion.pswfversionid=?)"
      );
      sysModelVerSqlMap.put(
         "PSAPPMENU",
         "update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpsappmenu inner join t_srfpssysapp on t_srfpsappmenu.PSSYSAPPID = t_srfpssysapp.PSSYSAPPID   where t_srfpssystem.PSSYSTEMID = t_srfpssysapp.PSSYSTEMID and t_srfpsappmenu.psappmenuid=?)"
      );
      sysModelVerSqlMap.put(
         "PSWXENTAPP",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSWXENTAPP inner join T_SRFPSWXACCOUNT on T_SRFPSWXENTAPP.PSWXACCOUNTID = T_SRFPSWXACCOUNT.PSWXACCOUNTID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSWXACCOUNT.PSSYSTEMID and T_SRFPSWXENTAPP.PSWXENTAPPID=?)"
      );
      sysModelVerSqlMap.put(
         "PSWXLOGIC",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSWXLOGIC inner join T_SRFPSWXACCOUNT on T_SRFPSWXLOGIC.PSWXACCOUNTID = T_SRFPSWXACCOUNT.PSWXACCOUNTID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSWXACCOUNT.PSSYSTEMID and T_SRFPSWXLOGIC.PSWXLOGICID=?)"
      );
      sysModelVerSqlMap.put(
         "PSWXMENU",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSWXMENU inner join T_SRFPSWXACCOUNT on T_SRFPSWXMENU.PSWXACCOUNTID = T_SRFPSWXACCOUNT.PSWXACCOUNTID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSWXACCOUNT.PSSYSTEMID and T_SRFPSWXMENU.PSWXMENUID=?)"
      );
      sysModelVerSqlMap.put(
         "PSWXMENUFUNC",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSWXMENUFUNC inner join T_SRFPSWXACCOUNT on T_SRFPSWXMENUFUNC.PSWXACCOUNTID = T_SRFPSWXACCOUNT.PSWXACCOUNTID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSWXACCOUNT.PSSYSTEMID and T_SRFPSWXMENUFUNC.PSWXMENUFUNCID=?)"
      );
      sysModelVerSqlMap.put(
         "PSSYSSFCODE",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSSYSSFCODE inner join T_SRFPSSYSSFPUB on T_SRFPSSYSSFCODE.PSSYSSFPUBID = T_SRFPSSYSSFPUB.PSSYSSFPUBID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSSFPUB.PSSYSTEMID and T_SRFPSSYSSFCODE.PSSYSSFCODEID=?)"
      );
      sysModelVerSqlMap.put(
         "PSAPPVIEWCODE",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPVIEWCODE inner join T_SRFPSSYSAPP on T_SRFPSAPPVIEWCODE.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPVIEWCODE.PSAPPVIEWCODEID=?)"
      );
      sysModelVerSqlMap.put(
         "PSAPPLAN",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPLAN inner join T_SRFPSSYSAPP on T_SRFPSAPPLAN.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPLAN.PSAPPLANID=?)"
      );
      sysModelVerSqlMap.put(
         "PSAPPPKG",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPPKG inner join T_SRFPSSYSAPP on T_SRFPSAPPPKG.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPPKG.PSAPPPKGID=?)"
      );
      sysModelVerSqlMap.put(
         "PSSYSSFPUBPKG",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSSYSSFPUBPKG inner join T_SRFPSSYSSFPUB on T_SRFPSSYSSFPUBPKG.PSSYSSFPUBID = T_SRFPSSYSSFPUB.PSSYSSFPUBID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSSFPUB.PSSYSTEMID and T_SRFPSSYSSFPUBPKG.PSSYSSFPUBPKGID=?)"
      );
      sysModelVerSqlMap.put(
         "PSAPPUSERMODE",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPUSERMODE inner join T_SRFPSSYSAPP on T_SRFPSAPPUSERMODE.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPUSERMODE.PSAPPUSERMODEID=?)"
      );
      sysModelVerSqlMap.put(
         "PSAPPLOCALDE",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPLOCALDE inner join T_SRFPSSYSAPP on T_SRFPSAPPLOCALDE.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPLOCALDE.PSAPPLOCALDEID=?)"
      );
      sysModelVerSqlMap.put(
         "PSMOBAPPSTARTPAGE",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSMOBAPPSTARTPAGE inner join T_SRFPSSYSAPP on T_SRFPSMOBAPPSTARTPAGE.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSMOBAPPSTARTPAGE.PSMOBAPPSTARTPAGEID=?)"
      );
      sysModelVerSqlMap.put(
         "PSMOBAPPPACK",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSMOBAPPPACK inner join T_SRFPSSYSAPP on T_SRFPSMOBAPPPACK.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSMOBAPPPACK.PSMOBAPPPACKID=?)"
      );
      sysModelVerSqlMap.put(
         "PSSUBSYSSADETAIL",
         "update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpssubsyssadetail inner join t_srfpssubsysserviceapi on t_srfpssubsyssadetail.PSSUBSYSSERVICEAPIID = t_srfpssubsysserviceapi.PSSUBSYSSERVICEAPIID   where t_srfpssystem.PSSYSTEMID = t_srfpssubsysserviceapi.PSSYSTEMID and t_srfpssubsyssadetail.pssubsyssadetailid=?)"
      );
      sysModelVerSqlMap.put(
         "PSAPPTITLEBAR",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPTITLEBAR inner join T_SRFPSSYSAPP on T_SRFPSAPPTITLEBAR.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPTITLEBAR.PSAPPTITLEBARID=?)"
      );
      sysModelVerSqlMap.put(
         "PSSYSDYNAMODELATTR",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSSYSDYNAMODELATTR inner join T_SRFPSSYSDYNAMODEL on T_SRFPSSYSDYNAMODELATTR.PSSYSDYNAMODELID = T_SRFPSSYSDYNAMODEL.PSSYSDYNAMODELID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSDYNAMODEL.PSSYSTEMID and T_SRFPSSYSDYNAMODELATTR.PSSYSDYNAMODELATTRID=?)"
      );
      sysModelVerSqlMap.put(
         "PSAPPUITHEME",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPUITHEME inner join T_SRFPSSYSAPP on T_SRFPSAPPUITHEME.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPUITHEME.PSAPPUITHEMEID=?)"
      );
      sysModelVerSqlMap.put(
         "PSDYNADEVIEWTEMPL",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSDYNADEVIEWTEMPL inner join T_SRFPSDYNADETEMPL on T_SRFPSDYNADEVIEWTEMPL.PSDYNADETEMPLID = T_SRFPSDYNADETEMPL.PSDYNADETEMPLID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSDYNADETEMPL.PSSYSTEMID and T_SRFPSDYNADEVIEWTEMPL.PSDYNADEVIEWTEMPLID=?)"
      );
      sysModelVerSqlMap.put(
         "PSDYNADEFORMTEMPL",
         "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSDYNADEFORMTEMPL inner join T_SRFPSDYNADETEMPL on T_SRFPSDYNADEFORMTEMPL.PSDYNADETEMPLID = T_SRFPSDYNADETEMPL.PSDYNADETEMPLID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSDYNADETEMPL.PSSYSTEMID and T_SRFPSDYNADEFORMTEMPL.PSDYNADEFORMTEMPLID=?)"
      );
      sysModelVerMap.put("PSDESARS", "");
      sysModelVerMap.put("PSAPPWF", "");
      sysModelVerMap.put("PSAPPWFVER", "");
      sysModelVerMap.put("PSAPPDERS", "");
      sysModelVerMap.put("PSAPPDERSVIEW", "");
      sysModelVerMap.put("PSSUBSYSSADE", "");
      sysModelVerMap.put("PSSUBSYSSADERS", "");
      sysModelVerMap.put("PSSUBSYSSADEFIELD", "");
      sysModelVerMap.put("PSSYSDBSCHEME", "PSSYSTEMID");
      sysModelVerMap.put("PSSYSDBTABLE", "");
      sysModelVerMap.put("PSSYSDBCOLUMN", "");
      sysModelVerMap.put("PSSYSDBPROC", "");
      sysModelVerMap.put("PSSYSDBPROCPARAM", "");
      sysModelVerMap.put("PSAPPRESOURCE", "");
      sysModelVerMap.put("PSSYSRESOURCE", "");
      sysModelVerMap.put("PSSYSCONTENT", "");
      sysModelVerMap.put("PSSYSCONTENTCAT", "");
      sysModelVerMap.put("PSAPPSBITEM", "");
      sysModelVerMap.put("PSAPPSBITEMRS", "");
      sysModelVerMap.put("PSAPPSTORYBOARD", "");
      sysModelVerMap.put("PSDESAVR", "");
      sysModelVerMap.put("PSHELPRESOURCE", "");
      sysModelVerMap.put("PSHELPARTICLE", "");
      sysModelVerMap.put("PSHELPPRJ", "");
      sysModelVerMap.put("PSHELPSECTION", "");
      sysModelVerMap.put("PSHELPMODULE", "");
      sysModelVerMap.put("PSSYSACTOR", "");
      sysModelVerMap.put("PSSYSUSERCASE", "");
      sysModelVerMap.put("PSSYSUSERCASERS", "");
      sysModelVerMap.put("PSSYSTESTCASE", "");
      sysModelVerMap.put("PSSYSTESTPRJ", "");
      sysModelVerMap.put("PSSYSTESTMODULE", "");
      sysModelVerMap.put("PSSYSREQMODULE", "");
      sysModelVerMap.put("PSSYSREQITEM", "");
      sysModelVerMap.put("PSDEUAGRPDETAIL", "");
      sysModelVerMap.put("PSCTRLLOGICGROUP", "");
      sysModelVerMap.put("PSCTRLLOGICGRPDETAIL", "");
      sysModelVerMap.put("PSSYSSEARCHSCHEME", "");
      sysModelVerMap.put("PSSYSSEARCHDOC", "");
      sysModelVerMap.put("PSSYSSEARCHFIELD", "");
      sysModelVerMap.put("PSSYSSEARCHDE", "");
      sysModelVerMap.put("PSSYSSEARCHDEFIELD", "");
      sysModelVerMap.put("PSSYSMAPVIEW", "");
      sysModelVerMap.put("PSSYSMAPITEM", "");
      sysModelVerMap.put("PSSYSPORTLETCAT", "");
      sysModelVerMap.put("PSAPPPORTLET", "");
      sysModelVerMap.put("PSDEGEIVR", "");
      sysModelVerMap.put("PSDEACTIONVR", "");
      sysModelVerMap.put("PSSYSSEQUENCE", "");
      sysModelVerMap.put("PSSYSTRANSLATOR", "");
      sysModelVerMap.put("PSSYSMSGQUEUE", "");
      sysModelVerMap.put("PSSYSMSGTARGET", "");
      sysModelVerMap.put("PSDENOTIFY", "");
      sysModelVerMap.put("PSDENOTIFYTARGET", "");
      sysModelVerMap.put("PSSYSEAIDATATYPEITEM", "");
      sysModelVerMap.put("PSSYSEAIDER", "");
      sysModelVerMap.put("PSSYSEAIDEFIELD", "");
      sysModelVerMap.put("PSSYSEAIDE", "");
      sysModelVerMap.put("PSSYSEAIELEMENTRE", "");
      sysModelVerMap.put("PSSYSEAIELEMENTATTR", "");
      sysModelVerMap.put("PSSYSEAIELEMENT", "");
      sysModelVerMap.put("PSSYSEAIDATATYPE", "");
      sysModelVerMap.put("PSSYSEAISCHEME", "");
      sysModelVerMap.put("PSSYSBIAGGCOLUMN", "");
      sysModelVerMap.put("PSSYSBIAGGTABLE", "");
      sysModelVerMap.put("PSSYSBICUBELEVEL", "");
      sysModelVerMap.put("PSSYSBICUBEMEASURE", "");
      sysModelVerMap.put("PSSYSBICUBEDIMENSION", "");
      sysModelVerMap.put("PSSYSBILEVEL", "");
      sysModelVerMap.put("PSSYSBIHIERARCHY", "");
      sysModelVerMap.put("PSSYSBIDIMENSION", "");
      sysModelVerMap.put("PSSYSBICUBE", "");
      sysModelVerMap.put("PSSYSBISCHEME", "");
      sysModelVerMap.put("PSTHRESHOLD", "");
      sysModelVerMap.put("PSTHRESHOLDGROUP", "");
      sysModelVerMap.put("PSSYSCHARTTHEME", "");
      sysModelVerMap.put("PSSYSCANVAS", "");
      sysModelVerMap.put("PSSYSCANVASMODEL", "");
      sysModelVerMap.put("PSSYSDASHBOARDLOGIC", "");
      sysModelVerMap.put("PSAPPMENULOGIC", "");
      sysModelVerMap.put("PSDEFORMLOGIC", "");
      sysModelVerMap.put("PSSYSSEARCHBARLOGIC", "");
      sysModelVerMap.put("PSAPPLOGIC", "");
      sysModelVerMap.put("PSDETOOLBARLOGIC", "");
      sysModelVerMap.put("PSDEWIZARDLOGIC", "");
      sysModelVerMap.put("PSDELISTLOGIC", "");
      sysModelVerMap.put("PSSYSMAPLOGIC", "");
      sysModelVerMap.put("PSDETREELOGIC", "");
      sysModelVerMap.put("PSDEDATAVIEWLOGIC", "");
      sysModelVerMap.put("PSSYSCALENDARLOGIC", "");
      sysModelVerMap.put("PSDEGRIDLOGIC", "");
      sysModelVerMap.put("PSDECHARTLOGIC", "");
      sysModelVerMap.put("PSDETEIUDETAIL", "");
      sysModelVerMap.put("PSDETEIUPDATE", "");
      sysModelVerMap.put("PSAPPPFPLUGIN", "");
      sysModelVerMap.put("PSSYSAIFACTORY", "");
      sysModelVerMap.put("PSSYSAICHATAGENT", "");
      sysModelVerMap.put("PSSYSAIWORKERAGENT", "");
      sysModelVerMap.put("PSSYSAIPIPELINEAGENT", "");
      sysModelVerMap.put("PSSYSAIPIPELINEJOB", "");
      sysModelVerMap.put("PSSYSAIPIPELINEWORKER", "");
      sysModelLogMap.put("PSACHANDLER", "");
      sysModelLogMap.put("PSACHANDLERACTION", "");
      sysModelLogMap.put("PSAPPDERS", "");
      sysModelLogMap.put("PSAPPDERSVIEW", "");
      sysModelLogMap.put("PSAPPFUNC", "");
      sysModelLogMap.put("PSAPPLAN", "");
      sysModelLogMap.put("PSAPPLOCALDE", "");
      sysModelLogMap.put("PSAPPMENU", "");
      sysModelLogMap.put("PSAPPMENUITEM", "");
      sysModelLogMap.put("PSAPPMODULE", "");
      sysModelLogMap.put("PSAPPPDTVIEW", "");
      sysModelLogMap.put("PSAPPPKG", "");
      sysModelLogMap.put("PSAPPPORTALVIEW", "");
      sysModelLogMap.put("PSAPPPVPART", "");
      sysModelLogMap.put("PSAPPRESOURCE", "");
      sysModelLogMap.put("PSAPPSBITEM", "");
      sysModelLogMap.put("PSAPPSBITEMRS", "");
      sysModelLogMap.put("PSAPPSTORYBOARD", "");
      sysModelLogMap.put("PSAPPTITLEBAR", "");
      sysModelLogMap.put("PSAPPUISTYLE", "");
      sysModelLogMap.put("PSAPPUITHEME", "");
      sysModelLogMap.put("PSAPPUSERMODE", "");
      sysModelLogMap.put("PSAPPUTIL", "");
      sysModelLogMap.put("PSAPPUTILPAGE", "");
      sysModelLogMap.put("PSAPPVIEW", "");
      sysModelLogMap.put("PSAPPWF", "");
      sysModelLogMap.put("PSAPPWFVER", "");
      sysModelLogMap.put("PSCODEITEM", "");
      sysModelLogMap.put("PSCODELIST", "");
      sysModelLogMap.put("PSCTRLMSG", "");
      sysModelLogMap.put("PSCTRLMSGITEM", "");
      sysModelLogMap.put("PSDATAENTITY", "");
      sysModelLogMap.put("PSDEACMODE", "");
      sysModelLogMap.put("PSDEACMODEITEM", "");
      sysModelLogMap.put("PSDEACTION", "");
      sysModelLogMap.put("PSDEACTIONGROUP", "");
      sysModelLogMap.put("PSDEACTIONLOGIC", "");
      sysModelLogMap.put("PSDEACTIONPARAM", "");
      sysModelLogMap.put("PSDEACTIONTEMPL", "");
      sysModelLogMap.put("PSDEACTIONWIZARD", "");
      sysModelLogMap.put("PSDEAGDETAIL", "");
      sysModelLogMap.put("PSDEAWGROUP", "");
      sysModelLogMap.put("PSDEAWGRPDETAIL", "");
      sysModelLogMap.put("PSDEAWITEM", "");
      sysModelLogMap.put("PSDECHART", "");
      sysModelLogMap.put("PSDECHARTAXES", "");
      sysModelLogMap.put("PSDECHARTPARAM", "");
      sysModelLogMap.put("PSDEDATAEXP", "");
      sysModelLogMap.put("PSDEDATAIMP", "");
      sysModelLogMap.put("PSDEDATAIMPITEM", "");
      sysModelLogMap.put("PSDEDATAQUERY", "");
      sysModelLogMap.put("PSDEDATARELATION", "");
      sysModelLogMap.put("PSDEDATASET", "");
      sysModelLogMap.put("PSDEDATASYNC", "");
      sysModelLogMap.put("PSDEDATAVIEW", "");
      sysModelLogMap.put("PSDEDBCFG", "");
      sysModelLogMap.put("PSDEDBIDXFIELD", "");
      sysModelLogMap.put("PSDEDBINDEX", "");
      sysModelLogMap.put("PSDEDQCODE", "");
      sysModelLogMap.put("PSDEDQCODECOND", "");
      sysModelLogMap.put("PSDEDQCODEEXP", "");
      sysModelLogMap.put("PSDEDQCOND", "");
      sysModelLogMap.put("PSDEDQJOIN", "");
      sysModelLogMap.put("PSDEDRDETAIL", "");
      sysModelLogMap.put("PSDEDRGROUP", "");
      sysModelLogMap.put("PSDEDRITEM", "");
      sysModelLogMap.put("PSDEDSCODE", "");
      sysModelLogMap.put("PSDEDSDQ", "");
      sysModelLogMap.put("PSDEDSGRPPARAM", "");
      sysModelLogMap.put("PSDEDTSQUEUE", "");
      sysModelLogMap.put("PSDEFDLOGIC", "");
      sysModelLogMap.put("PSDEFDTCOL", "");
      sysModelLogMap.put("PSDEFFORMITEM", "");
      sysModelLogMap.put("PSDEFGROUP", "");
      sysModelLogMap.put("PSDEFGROUPDETAIL", "");
      sysModelLogMap.put("PSDEFIELD", "");
      sysModelLogMap.put("PSDEFINPUTTIP", "");
      sysModelLogMap.put("PSDEFINPUTTIPSET", "");
      sysModelLogMap.put("PSDEFIUDETAIL", "");
      sysModelLogMap.put("PSDEFIUPDATE", "");
      sysModelLogMap.put("PSDEFIVR", "");
      sysModelLogMap.put("PSDEFORM", "");
      sysModelLogMap.put("PSDEFORMDETAIL", "");
      sysModelLogMap.put("PSDEFORMRF", "");
      sysModelLogMap.put("PSDEFSFITEM", "");
      sysModelLogMap.put("PSDEFVALUERULE", "");
      sysModelLogMap.put("PSDEFVRCOND", "");
      sysModelLogMap.put("PSDEGEIUDETAIL", "");
      sysModelLogMap.put("PSDEGEIUPDATE", "");
      sysModelLogMap.put("PSDEGRID", "");
      sysModelLogMap.put("PSDEGRIDCOL", "");
      sysModelLogMap.put("PSDEGROUP", "");
      sysModelLogMap.put("PSDEGROUPDETAIL", "");
      sysModelLogMap.put("PSDELIST", "");
      sysModelLogMap.put("PSDELISTITEM", "");
      sysModelLogMap.put("PSDELLCOND", "");
      sysModelLogMap.put("PSDELNPARAM", "");
      sysModelLogMap.put("PSDELOGIC", "");
      sysModelLogMap.put("PSDELOGICLINK", "");
      sysModelLogMap.put("PSDELOGICNODE", "");
      sysModelLogMap.put("PSDELOGICPARAM", "");
      sysModelLogMap.put("PSDEMAINSTATE", "");
      sysModelLogMap.put("PSDEMAINSTATERS", "");
      sysModelLogMap.put("PSDEMAP", "");
      sysModelLogMap.put("PSDEMAPACTION", "");
      sysModelLogMap.put("PSDEMAPDETAIL", "");
      sysModelLogMap.put("PSDEMAPDQ", "");
      sysModelLogMap.put("PSDEMAPDS", "");
      sysModelLogMap.put("PSDEMSACTION", "");
      sysModelLogMap.put("PSDEMSFIELD", "");
      sysModelLogMap.put("PSDEMSOPPRIV", "");
      sysModelLogMap.put("PSDEOPPRIV", "");
      sysModelLogMap.put("PSDEOPPRIVROLE", "");
      sysModelLogMap.put("PSDEPRINT", "");
      sysModelLogMap.put("PSDEPSLNASGRP", "");
      sysModelLogMap.put("PSDEPSLNASITEM", "");
      sysModelLogMap.put("PSDER", "");
      sysModelLogMap.put("PSDERDEFMAP", "");
      sysModelLogMap.put("PSDEREPITEM", "");
      sysModelLogMap.put("PSDEREPORT", "");
      sysModelLogMap.put("PSDERGROUP", "");
      sysModelLogMap.put("PSDERGROUPDETAIL", "");
      sysModelLogMap.put("PSDERTAW", "");
      sysModelLogMap.put("PSDERTAWI", "");
      sysModelLogMap.put("PSDESADETAIL", "");
      sysModelLogMap.put("PSDESAMPLEDATA", "");
      sysModelLogMap.put("PSDESAMPLEDATAREF", "");
      sysModelLogMap.put("PSDESARS", "");
      sysModelLogMap.put("PSDESAVR", "");
      sysModelLogMap.put("PSDESERVICEAPI", "");
      sysModelLogMap.put("PSDETABLE", "");
      sysModelLogMap.put("PSDETBITEM", "");
      sysModelLogMap.put("PSDETOOLBAR", "");
      sysModelLogMap.put("PSDETREECOL", "");
      sysModelLogMap.put("PSDETREENODE", "");
      sysModelLogMap.put("PSDETREENODECOL", "");
      sysModelLogMap.put("PSDETREENODERS", "");
      sysModelLogMap.put("PSDETREENODERV", "");
      sysModelLogMap.put("PSDETREEVIEW", "");
      sysModelLogMap.put("PSDEUAGROUP", "");
      sysModelLogMap.put("PSDEUAGRPDETAIL", "");
      sysModelLogMap.put("PSDEUIACTION", "");
      sysModelLogMap.put("PSDEUSERROLE", "");
      sysModelLogMap.put("PSDEUTILDE", "");
      sysModelLogMap.put("PSDEVIEWBASE", "");
      sysModelLogMap.put("PSDEVIEWCTRL", "");
      sysModelLogMap.put("PSDEVIEWENGINE", "");
      sysModelLogMap.put("PSDEVIEWLOGIC", "");
      sysModelLogMap.put("PSDEVIEWRV", "");
      sysModelLogMap.put("PSDEVSLNMSDEPFUNC", "");
      sysModelLogMap.put("PSDEVSLNMSDEPFUNCITEM", "");
      sysModelLogMap.put("PSDEWIZARD", "");
      sysModelLogMap.put("PSDEWIZARDFORM", "");
      sysModelLogMap.put("PSDEWIZARDSTEP", "");
      sysModelLogMap.put("PSHELPARTICLE", "");
      sysModelLogMap.put("PSHELPMODULE", "");
      sysModelLogMap.put("PSHELPPRJ", "");
      sysModelLogMap.put("PSHELPRESOURCE", "");
      sysModelLogMap.put("PSHELPSECTION", "");
      sysModelLogMap.put("PSLANGUAGE", "");
      sysModelLogMap.put("PSLANGUAGEITEM", "");
      sysModelLogMap.put("PSLANGUAGERES", "");
      sysModelLogMap.put("PSMOBAPPPACK", "");
      sysModelLogMap.put("PSMOBAPPPACKTD", "");
      sysModelLogMap.put("PSMOBAPPSTARTPAGE", "");
      sysModelLogMap.put("PSMODULE", "");
      sysModelLogMap.put("PSPANELENGINE", "");
      sysModelLogMap.put("PSPANELITEMLOGIC", "");
      sysModelLogMap.put("PSPANELLLCOND", "");
      sysModelLogMap.put("PSPANELLNPARAM", "");
      sysModelLogMap.put("PSPANELLOGICLINK", "");
      sysModelLogMap.put("PSPANELLOGICNODE", "");
      sysModelLogMap.put("PSPANELLOGICPARAM", "");
      sysModelLogMap.put("PSSUBSYSSADE", "");
      sysModelLogMap.put("PSSUBSYSSADEFIELD", "");
      sysModelLogMap.put("PSSUBSYSSADERS", "");
      sysModelLogMap.put("PSSUBSYSSADETAIL", "");
      sysModelLogMap.put("PSSUBSYSSERVICEAPI", "");
      sysModelLogMap.put("PSSUBVIEWTYPE", "");
      sysModelLogMap.put("PSSYSACTOR", "");
      sysModelLogMap.put("PSSYSAPP", "");
      sysModelLogMap.put("PSSYSBACKSERVICE", "");
      sysModelLogMap.put("PSSYSBDCOLSET", "");
      sysModelLogMap.put("PSSYSBDCOLUMN", "");
      sysModelLogMap.put("PSSYSBDINSTCFG", "");
      sysModelLogMap.put("PSSYSBDMODULE", "");
      sysModelLogMap.put("PSSYSBDPART", "");
      sysModelLogMap.put("PSSYSBDSCHEME", "");
      sysModelLogMap.put("PSSYSBDTABLE", "");
      sysModelLogMap.put("PSSYSBDTABLEDE", "");
      sysModelLogMap.put("PSSYSBDTABLEDER", "");
      sysModelLogMap.put("PSSYSBDTABLERS", "");
      sysModelLogMap.put("PSSYSCALENDAR", "");
      sysModelLogMap.put("PSSYSCALENDARITEM", "");
      sysModelLogMap.put("PSSYSCALENDARITEMRV", "");
      sysModelLogMap.put("PSSYSCODESNIPPET", "");
      sysModelLogMap.put("PSSYSCONTENT", "");
      sysModelLogMap.put("PSSYSCONTENTCAT", "");
      sysModelLogMap.put("PSSYSCOUNTER", "");
      sysModelLogMap.put("PSSYSCOUNTERITEM", "");
      sysModelLogMap.put("PSSYSCSS", "");
      sysModelLogMap.put("PSSYSCSSCAT", "");
      sysModelLogMap.put("PSSYSDASHBOARD", "");
      sysModelLogMap.put("PSSYSDATASYNCAGENT", "");
      sysModelLogMap.put("PSSYSDBCOLUMN", "");
      sysModelLogMap.put("PSSYSDBPART", "");
      sysModelLogMap.put("PSSYSDBPROC", "");
      sysModelLogMap.put("PSSYSDBPROCPARAM", "");
      sysModelLogMap.put("PSSYSDBSCHEME", "");
      sysModelLogMap.put("PSSYSDBTABLE", "");
      sysModelLogMap.put("PSSYSDBVALUEOP", "");
      sysModelLogMap.put("PSSYSDBVF", "");
      sysModelLogMap.put("PSSYSDBVFCODE", "");
      sysModelLogMap.put("PSSYSDELOGICNODE", "");
      sysModelLogMap.put("PSSYSDICTCAT", "");
      sysModelLogMap.put("PSSYSDMITEM", "");
      sysModelLogMap.put("PSSYSDMVER", "");
      sysModelLogMap.put("PSSYSDYNAMODEL", "");
      sysModelLogMap.put("PSSYSDYNAMODELATTR", "");
      sysModelLogMap.put("PSSYSEDITORSTYLE", "");
      sysModelLogMap.put("PSSYSERMAP", "");
      sysModelLogMap.put("PSSYSERMAPNODE", "");
      sysModelLogMap.put("PSSYSFILE", "");
      sysModelLogMap.put("PSSYSIMAGE", "");
      sysModelLogMap.put("PSSYSMODELGROUP", "");
      sysModelLogMap.put("PSSYSMSGTEMPL", "");
      sysModelLogMap.put("PSSYSOPPRIV", "");
      sysModelLogMap.put("PSSYSPDTVIEW", "");
      sysModelLogMap.put("PSSYSPFPITEMPL", "");
      sysModelLogMap.put("PSSYSPFPLUGIN", "");
      sysModelLogMap.put("PSSYSPORTLET", "");
      sysModelLogMap.put("PSSYSREF", "");
      sysModelLogMap.put("PSSYSREQITEM", "");
      sysModelLogMap.put("PSSYSREQITEMDATA", "");
      sysModelLogMap.put("PSSYSREQITEMHIS", "");
      sysModelLogMap.put("PSSYSREQMODULE", "");
      sysModelLogMap.put("PSSYSRESOURCE", "");
      sysModelLogMap.put("PSSYSSAHANDLER", "");
      sysModelLogMap.put("PSSYSSAMPLEVALUE", "");
      sysModelLogMap.put("PSSYSSEARCHBAR", "");
      sysModelLogMap.put("PSSYSSEARCHBARITEM", "");
      sysModelLogMap.put("PSSYSSERVICEAPI", "");
      sysModelLogMap.put("PSSYSSFCODE", "");
      sysModelLogMap.put("PSSYSSFPITEMPL", "");
      sysModelLogMap.put("PSSYSSFPLUGIN", "");
      sysModelLogMap.put("PSSYSSFPUB", "");
      sysModelLogMap.put("PSSYSSFPUBPKG", "");
      sysModelLogMap.put("PSSYSSQLCMD", "");
      sysModelLogMap.put("PSSYSSQLCMDSQL", "");
      sysModelLogMap.put("PSSYSTCASSERT", "");
      sysModelLogMap.put("PSSYSTCINPUT", "");
      sysModelLogMap.put("PSSYSTDITEM", "");
      sysModelLogMap.put("PSSYSTEM", "");
      sysModelLogMap.put("PSSYSTEMAS", "");
      sysModelLogMap.put("PSSYSTEMDBCFG", "");
      sysModelLogMap.put("PSSYSTEMMQ", "");
      sysModelLogMap.put("PSSYSTEMRUN", "");
      sysModelLogMap.put("PSSYSTESTCASE", "");
      sysModelLogMap.put("PSSYSTESTDATA", "");
      sysModelLogMap.put("PSSYSTESTMODULE", "");
      sysModelLogMap.put("PSSYSTESTPRJ", "");
      sysModelLogMap.put("PSSYSTITLEBAR", "");
      sysModelLogMap.put("PSSYSUCMAP", "");
      sysModelLogMap.put("PSSYSUCMAPNODE", "");
      sysModelLogMap.put("PSSYSUNIRES", "");
      sysModelLogMap.put("PSSYSUNISTATE", "");
      sysModelLogMap.put("PSSYSUNIT", "");
      sysModelLogMap.put("PSSYSUSERCASE", "");
      sysModelLogMap.put("PSSYSUSERCASERS", "");
      sysModelLogMap.put("PSSYSUSERDR", "");
      sysModelLogMap.put("PSSYSUSERMODE", "");
      sysModelLogMap.put("PSSYSUSERROLERES", "");
      sysModelLogMap.put("PSSYSUSERROLEDATA", "");
      sysModelLogMap.put("PSSYSUTILDE", "");
      sysModelLogMap.put("PSSYSVALUERULE", "");
      sysModelLogMap.put("PSSYSVIEWLOGIC", "");
      sysModelLogMap.put("PSSYSVIEWLOGICPARAM", "");
      sysModelLogMap.put("PSSYSVIEWPANEL", "");
      sysModelLogMap.put("PSSYSVIEWPANELITEM", "");
      sysModelLogMap.put("PSSYSVIEWPANELLOGIC", "");
      sysModelLogMap.put("PSSYSVIEWPANELMODEL", "");
      sysModelLogMap.put("PSSYSWFMODE", "");
      sysModelLogMap.put("PSSYSWFSETTING", "");
      sysModelLogMap.put("PSVIEWMSG", "");
      sysModelLogMap.put("PSVIEWMSGGROUP", "");
      sysModelLogMap.put("PSVIEWMSGGRPDETAIL", "");
      sysModelLogMap.put("PSVIEWWIZARDGROUP", "");
      sysModelLogMap.put("PSWFDE", "");
      sysModelLogMap.put("PSWFLINK", "");
      sysModelLogMap.put("PSWFLINKCOND", "");
      sysModelLogMap.put("PSWFLINKROLE", "");
      sysModelLogMap.put("PSWFPROCESS", "");
      sysModelLogMap.put("PSWFPROCPARAM", "");
      sysModelLogMap.put("PSWFPROCROLE", "");
      sysModelLogMap.put("PSWFPROCSUBWF", "");
      sysModelLogMap.put("PSWFROLE", "");
      sysModelLogMap.put("PSWFSUBWF", "");
      sysModelLogMap.put("PSWFUTILUIACTION", "");
      sysModelLogMap.put("PSWFVERSION", "");
      sysModelLogMap.put("PSWFWORKTIME", "");
      sysModelLogMap.put("PSWORKFLOW", "");
      sysModelLogMap.put("PSWXACCOUNT", "");
      sysModelLogMap.put("PSWXENTAPP", "");
      sysModelLogMap.put("PSWXLOGIC", "");
      sysModelLogMap.put("PSWXMENU", "");
      sysModelLogMap.put("PSWXMENUFUNC", "");
      sysModelLogMap.put("PSWXMENUITEM", "");
      sysModelLogMap.put("PSCODELIST", "");
      sysModelLogMap.put("PSSYSIMAGE", "");
      sysModelLogMap.put("PSSYSCSS", "");
      sysModelLogMap.put("PSCTRLMSG", "");
      sysModelLogMap.put("PSDEACTIONTEMPL", "");
      sysModelLogMap.put("PSSYSUNIT", "");
      sysModelLogMap.put("PSSYSDELOGICNODE", "");
      sysModelLogMap.put("PSSYSDEFTYPE", "");
      sysModelLogMap.put("PSSYSOPPRIV", "");
      sysModelLogMap.put("PSSYSUSERROLERES", "");
      sysModelLogMap.put("PSSYSUSERROLEDATA", "");
      sysModelLogMap.put("PSLANGUAGERES", "");
      sysModelLogMap.put("PSLANGUAGEITEM", "");
      sysModelLogMap.put("PSSUBVIEWTYPE", "");
      sysModelLogMap.put("PSSYSVALUERULE", "");
      sysModelLogMap.put("PSSYSPORTLET", "");
      sysModelLogMap.put("PSSYSDICTCAT", "");
      sysModelLogMap.put("PSSYSEDITORSTYLE", "");
      sysModelLogMap.put("PSSYSPFPLUGIN", "");
      sysModelLogMap.put("PSSYSPFPITEMPL", "");
      sysModelLogMap.put("PSSYSSFPLUGIN", "");
      sysModelLogMap.put("PSSYSSFPITEMPL", "");
      sysModelLogMap.put("PSSYSUNIRES", "");
      sysModelLogMap.put("PSSYSMSGTEMPL", "");
      sysModelLogMap.put("PSVIEWMSG", "");
      sysModelLogMap.put("PSDEFINPUTTIPSET", "");
      sysModelLogMap.put("PSSYSUNISTATE", "");
      sysModelLogMap.put("PSSYSUTILDE", "");
      sysModelLogMap.put("PSVIEWMSGGROUP", "");
      sysModelLogMap.put("PSSYSSFPUB", "");
      sysModelLogMap.put("PSSYSBACKSERVICE", "");
      sysModelLogMap.put("PSSYSPDTVIEW", "");
      sysModelLogMap.put("PSSYSVIEWLOGIC", "");
      sysModelLogMap.put("PSSYSDATASYNCAGENT", "");
      sysModelLogMap.put("PSDATAENTITY", "");
      sysModelLogMap.put("PSDEFIELD", "");
      sysModelLogMap.put("PSDEVIEWBASE", "");
      sysModelLogMap.put("PSDEFFORMITEM", "");
      sysModelLogMap.put("PSDEFSFITEM", "");
      sysModelLogMap.put("PSDEFDTCOL", "");
      sysModelLogMap.put("PSDEFVALUERULE", "");
      sysModelLogMap.put("PSDEFINPUTTIP", "");
      sysModelLogMap.put("PSDER", "");
      sysModelLogMap.put("PSSYSDYNAMODEL", "");
      sysModelLogMap.put("PSSYSDYNAMODELATTR", "");
      sysModelLogMap.put("PSDYNADETEMPL", "");
      sysModelLogMap.put("PSDYNADEVIEWTEMPL", "");
      sysModelLogMap.put("PSDYNADEFORMTEMPL", "");
      sysModelLogMap.put("PSDERDEFMAP", "");
      sysModelLogMap.put("PSDEDBCFG", "");
      sysModelLogMap.put("PSDEDBINDEX", "");
      sysModelLogMap.put("PSDEDATASET", "");
      sysModelLogMap.put("PSDEDATAQUERY", "");
      sysModelLogMap.put("PSDEDQCODE", "");
      sysModelLogMap.put("PSDEDQCODECOND", "");
      sysModelLogMap.put("PSDELOGIC", "");
      sysModelLogMap.put("PSDEACTION", "");
      sysModelLogMap.put("PSDEACTIONLOGIC", "");
      sysModelLogMap.put("PSACHANDLER", "");
      sysModelLogMap.put("PSDEDRITEM", "");
      sysModelLogMap.put("PSDEDRGROUP", "");
      sysModelLogMap.put("PSDEMAP", "");
      sysModelLogMap.put("PSDEDATARELATION", "");
      sysModelLogMap.put("PSDEDRDETAIL", "");
      sysModelLogMap.put("PSDEACMODE", "");
      sysModelLogMap.put("PSDEUIACTION", "");
      sysModelLogMap.put("PSDEUAGROUP", "");
      sysModelLogMap.put("PSDEGROUP", "");
      sysModelLogMap.put("PSDEFGROUP", "");
      sysModelLogMap.put("PSDEACTIONGROUP", "");
      sysModelLogMap.put("PSDERGROUP", "");
      sysModelLogMap.put("PSDEUAGRPDETAIL", "");
      sysModelLogMap.put("PSWFDE", "");
      sysModelLogMap.put("PSDEOPPRIV", "");
      sysModelLogMap.put("PSDEMAINSTATE", "");
      sysModelLogMap.put("PSDEMAINSTATERS", "");
      sysModelLogMap.put("PSDEDATAEXP", "");
      sysModelLogMap.put("PSDEDATAIMP", "");
      sysModelLogMap.put("PSDEREPORT", "");
      sysModelLogMap.put("PSDEPRINT", "");
      sysModelLogMap.put("PSDEUTILDE", "");
      sysModelLogMap.put("PSSYSUSERMODE", "");
      sysModelLogMap.put("PSSYSUSERDR", "");
      sysModelLogMap.put("PSSYSACTOR", "");
      sysModelLogMap.put("PSSYSUSERCASE", "");
      sysModelLogMap.put("PSSYSUSERCASERS", "");
      sysModelLogMap.put("PSSYSSAMPLEVALUE", "");
      sysModelLogMap.put("PSSYSTESTDATA", "");
      sysModelLogMap.put("PSSYSTESTCASE", "");
      sysModelLogMap.put("PSSYSTESTPRJ", "");
      sysModelLogMap.put("PSSYSTESTMODULE", "");
      sysModelLogMap.put("PSSYSERMAP", "");
      sysModelLogMap.put("PSSYSUCMAP", "");
      sysModelLogMap.put("PSDEWIZARD", "");
      sysModelLogMap.put("PSDEDATASYNC", "");
      sysModelLogMap.put("PSSYSBDTABLE", "");
      sysModelLogMap.put("PSSYSBDSCHEME", "");
      sysModelLogMap.put("PSSYSBDMODULE", "");
      sysModelLogMap.put("PSSYSBDPART", "");
      sysModelLogMap.put("PSSYSBDTABLERS", "");
      sysModelLogMap.put("PSSYSBDTABLE", "");
      sysModelLogMap.put("PSSYSBDCOLSET", "");
      sysModelLogMap.put("PSSYSBDTABLEDE", "");
      sysModelLogMap.put("PSSYSBDTABLEDER", "");
      sysModelLogMap.put("PSSYSBDCOLUMN", "");
      sysModelLogMap.put("PSDEACTIONWIZARD", "");
      sysModelLogMap.put("PSDEAWGROUP", "");
      sysModelLogMap.put("PSWORKFLOW", "");
      sysModelLogMap.put("PSWFVERSION", "");
      sysModelLogMap.put("PSWXACCOUNT", "");
      sysModelLogMap.put("PSWXENTAPP", "");
      sysModelLogMap.put("PSWXLOGIC", "");
      sysModelLogMap.put("PSWXMENU", "");
      sysModelLogMap.put("PSWXMENUFUNC", "");
      sysModelLogMap.put("PSSYSSFPUBPKG", "");
      sysModelLogMap.put("PSAPPPKG", "");
      sysModelLogMap.put("PSSYSSEARCHBAR", "");
      sysModelLogMap.put("PSSYSTITLEBAR", "");
      sysModelLogMap.put("PSAPPTITLEBAR", "");
      sysModelLogMap.put("PSSYSDASHBOARD", "");
      sysModelLogMap.put("PSSYSCALENDAR", "");
      sysModelLogMap.put("PSSYSVIEWPANEL", "");
      sysModelLogMap.put("PSDEUSERROLE", "");
      sysModelLogMap.put("PSDEOPPRIVROLE", "");
      sysModelLogMap.put("PSDATAENTITY", "");
      sysModelLogMap.put("PSAPPMODULE", "");
      sysModelLogMap.put("PSAPPVIEW", "");
      sysModelLogMap.put("PSAPPLAN", "");
      sysModelLogMap.put("PSAPPUTILPAGE", "");
      sysModelLogMap.put("PSAPPPDTVIEW", "");
      sysModelLogMap.put("PSAPPUISTYLE", "");
      sysModelLogMap.put("PSAPPFUNC", "");
      sysModelLogMap.put("PSAPPEDITORTEMPL", "");
      sysModelLogMap.put("PSAPPMENU", "");
      sysModelLogMap.put("PSAPPUSERMODE", "");
      sysModelLogMap.put("PSAPPUITHEME", "");
      sysModelLogMap.put("PSAPPLOCALDE", "");
      sysModelLogMap.put("PSMOBAPPSTARTPAGE", "");
      sysModelLogMap.put("PSMOBAPPPACK", "");
      sysModelLogMap.put("PSAPPVIEWCODE", "");
      sysModelLogMap.put("PSAPPVIEWREF", "");
      sysModelLogMap.put("PSAPPVIEWLOGIC", "");
      sysModelLogMap.put("PSDEVIEWBASE", "");
      sysModelLogMap.put("PSDETOOLBAR", "");
      sysModelLogMap.put("PSDEFORM", "");
      sysModelLogMap.put("PSDEGRID", "");
      sysModelLogMap.put("PSDETREEVIEW", "");
      sysModelLogMap.put("PSDECHART", "");
      sysModelLogMap.put("PSDELIST", "");
      sysModelLogMap.put("PSDEDATAVIEW", "");
      sysModelLogMap.put("PSSYSSAHANDLER", "");
      sysModelLogMap.put("PSSYSSERVICEAPI", "");
      sysModelLogMap.put("PSDESERVICEAPI", "");
      sysModelLogMap.put("PSDESADETAIL", "");
      sysModelLogMap.put("PSSUBSYSSERVICEAPI", "");
      sysModelLogMap.put("PSSUBSYSSADETAIL", "");
      sysModelLogMap.put("PSDEDTSQUEUE", "");
      sysModelLogMap.put("PSDEGRIDCOL", "");
      sysModelLogMap.put("PSDEVIEWCTRL", "");
      sysModelLogMap.put("PSDESAMPLEDATA", "");
      sysModelLogMap.put("PSDESARS", "");
      sysModelLogMap.put("PSAPPWF", "");
      sysModelLogMap.put("PSAPPWFVER", "");
      sysModelLogMap.put("PSAPPDERS", "");
      sysModelLogMap.put("PSAPPDERSVIEW", "");
      sysModelLogMap.put("PSSUBSYSSADE", "");
      sysModelLogMap.put("PSSUBSYSSADERS", "");
      sysModelLogMap.put("PSSUBSYSSADEFIELD", "");
      sysModelLogMap.put("PSSYSDBSCHEME", "");
      sysModelLogMap.put("PSSYSDBTABLE", "");
      sysModelLogMap.put("PSSYSDBCOLUMN", "");
      sysModelLogMap.put("PSSYSDBPROC", "");
      sysModelLogMap.put("PSSYSDBPROCPARAM", "");
      sysModelLogMap.put("PSAPPRESOURCE", "");
      sysModelLogMap.put("PSSYSRESOURCE", "");
      sysModelLogMap.put("PSSYSCONTENT", "");
      sysModelLogMap.put("PSSYSCONTENTCAT", "");
      sysModelLogMap.put("PSAPPSBITEM", "");
      sysModelLogMap.put("PSAPPSBITEMRS", "");
      sysModelLogMap.put("PSAPPSTORYBOARD", "");
      sysModelLogMap.put("PSDESAVR", "");
      sysModelLogMap.put("PSHELPRESOURCE", "");
      sysModelLogMap.put("PSHELPARTICLE", "");
      sysModelLogMap.put("PSHELPPRJ", "");
      sysModelLogMap.put("PSHELPSECTION", "");
      sysModelLogMap.put("PSHELPMODULE", "");
      sysModelLogMap.put("PSSYSERMAP", "");
      sysModelLogMap.put("PSSYSERMAPNODE", "");
      sysModelLogMap.put("PSSYSUCMAP", "");
      sysModelLogMap.put("PSSYSUCMAPNODE", "");
      sysModelLogMap.put("PSSYSREQMODULE", "");
      sysModelLogMap.put("PSSYSREQITEM", "");
      sysModelLogMap.put("PSAPPDEVIEW", "PSAPPVIEW");
      sysModelLogMap.put("PSAPPPORTALVIEW", "PSAPPVIEW");
      sysModelLogMap.put("PSAPPINDEXVIEW", "PSAPPVIEW");
      sysModelLogMap.put("PSCTRLLOGICGROUP", "");
      sysModelLogMap.put("PSCTRLLOGICGRPDETAIL", "");
      sysModelLogMap.put("PSSYSSEARCHSCHEME", "");
      sysModelLogMap.put("PSSYSSEARCHDOC", "");
      sysModelLogMap.put("PSSYSSEARCHFIELD", "");
      sysModelLogMap.put("PSSYSSEARCHDE", "");
      sysModelLogMap.put("PSSYSSEARCHDEFIELD", "");
      sysModelLogMap.put("PSSYSMAPVIEW", "");
      sysModelLogMap.put("PSSYSMAPITEM", "");
      sysModelLogMap.put("PSSYSPORTLETCAT", "");
      sysModelLogMap.put("PSAPPPORTLET", "");
      sysModelLogMap.put("PSDEGEIVR", "");
      sysModelLogMap.put("PSDEACTIONVR", "");
      sysModelLogMap.put("PSSYSSEQUENCE", "");
      sysModelLogMap.put("PSSYSTRANSLATOR", "");
      sysModelLogMap.put("PSSYSMSGQUEUE", "");
      sysModelLogMap.put("PSSYSMSGTARGET", "");
      sysModelLogMap.put("PSDENOTIFY", "");
      sysModelLogMap.put("PSDENOTIFYTARGET", "");
      sysModelLogMap.put("PSSYSEAIDATATYPEITEM", "");
      sysModelLogMap.put("PSSYSEAIDER", "");
      sysModelLogMap.put("PSSYSEAIDEFIELD", "");
      sysModelLogMap.put("PSSYSEAIDE", "");
      sysModelLogMap.put("PSSYSEAIELEMENTRE", "");
      sysModelLogMap.put("PSSYSEAIELEMENTATTR", "");
      sysModelLogMap.put("PSSYSEAIELEMENT", "");
      sysModelLogMap.put("PSSYSEAIDATATYPE", "");
      sysModelLogMap.put("PSSYSEAISCHEME", "");
      sysModelLogMap.put("PSSYSBIAGGCOLUMN", "");
      sysModelLogMap.put("PSSYSBIAGGTABLE", "");
      sysModelLogMap.put("PSSYSBICUBELEVEL", "");
      sysModelLogMap.put("PSSYSBICUBEMEASURE", "");
      sysModelLogMap.put("PSSYSBICUBEDIMENSION", "");
      sysModelLogMap.put("PSSYSBILEVEL", "");
      sysModelLogMap.put("PSSYSBIHIERARCHY", "");
      sysModelLogMap.put("PSSYSBIDIMENSION", "");
      sysModelLogMap.put("PSSYSBICUBE", "");
      sysModelLogMap.put("PSSYSBISCHEME", "");
      sysModelLogMap.put("PSTHRESHOLD", "");
      sysModelLogMap.put("PSTHRESHOLDGROUP", "");
      sysModelLogMap.put("PSSYSCHARTTHEME", "");
      sysModelLogMap.put("PSSYSCANVAS", "");
      sysModelLogMap.put("PSSYSCANVASMODEL", "");
      sysModelLogMap.put("PSSYSDASHBOARDLOGIC", "");
      sysModelLogMap.put("PSAPPMENULOGIC", "");
      sysModelLogMap.put("PSDEFORMLOGIC", "");
      sysModelLogMap.put("PSSYSSEARCHBARLOGIC", "");
      sysModelLogMap.put("PSAPPLOGIC", "");
      sysModelLogMap.put("PSDETOOLBARLOGIC", "");
      sysModelLogMap.put("PSDEWIZARDLOGIC", "");
      sysModelLogMap.put("PSDELISTLOGIC", "");
      sysModelLogMap.put("PSSYSMAPLOGIC", "");
      sysModelLogMap.put("PSDETREELOGIC", "");
      sysModelLogMap.put("PSDEDATAVIEWLOGIC", "");
      sysModelLogMap.put("PSSYSCALENDARLOGIC", "");
      sysModelLogMap.put("PSDEGRIDLOGIC", "");
      sysModelLogMap.put("PSDECHARTLOGIC", "");
      sysModelLogMap.put("PSDETEIUDETAIL", "");
      sysModelLogMap.put("PSDETEIUPDATE", "");
      sysModelLogMap.put("PSAPPPFPLUGIN", "");
      sysModelLogMap.put("PSSYSAIFACTORY", "");
      sysModelLogMap.put("PSSYSAICHATAGENT", "");
      sysModelLogMap.put("PSSYSAIWORKERAGENT", "");
      sysModelLogMap.put("PSSYSAIPIPELINEAGENT", "");
      sysModelLogMap.put("PSSYSAIPIPELINEJOB", "");
      sysModelLogMap.put("PSSYSAIPIPELINEWORKER", "");
      denyCopyMap.put("PSDEACMODE", "PSDEID");
      denyCopyMap.put("PSDEDATAQUERY", "PSDEID");
      denyCopyMap.put("PSDEDATARELATION", "PSDEID");
      denyCopyMap.put("PSDEDATASET", "PSDEID");
      denyCopyMap.put("PSDEDSDQ", "PSDEID");
      denyCopyMap.put("PSDEFORM", "PSDEID");
      denyCopyMap.put("PSDEFVALUERULE", "PSDEID");
      denyCopyMap.put("PSDEGRID", "PSDEID");
      denyCopyMap.put("PSDELOGIC", "PSDEID");
      denyCopyMap.put("PSDEVIEWBASE", "PSDEID");
      denyCopyMap.put("PSDEUAGROUP", "PSDEID");
      denyCopyMap.put("PSDEDATAVIEW", "PSDEID");
      denyCopyMap.put("PSDEMAP", "PSDEID");
      denyCopyMap.put("PSDECHART", "PSDEID");
      denyCopyMap.put("PSDELIST", "PSDEID");
      denyCopyMap.put("PSDEMAINSTATE", "PSDEID");
      denyCopyMap.put("PSDEDBINDEX", "PSDEID");
      denyCopyMap.put("PSDEREPORT", "PSDEID");
      denyCopyMap.put("PSSYSTESTCASE", "PSDEID");
      denyCopyMap.put("PSSYSTESTDATA", "PSDEID");
      denyCopyMap.put("PSDEWIZARD", "PSDEID");
      denyCopyMap.put("PSDEACTIONWIZARD", "PSDEID");
      denyCopyMap.put("PSDEAWGROUP", "PSDEID");
      denyCopyMap.put("PSDEFGROUP", "PSDEID");
      denyCopyMap.put("PSDEACTIONGROUP", "PSDEID");
      denyCopyMap.put("PSHELPARTICLE", "PSDEID");
      informStateMap.put("PSDATAENTITY", "");
      informStateMap.put("PSDER", "");
      informStateMap.put("PSDEFIELD", "");
      informStateMap.put("PSMODULE", "");
      informStateMap.put("PSSYSAPP", "");
      informStateMap.put("PSSYSSFPUB", "");
      informStateMap.put("PSSYSDEVBKTASK", "");
      informStateMap.put("PSDCBKTASK", "");
      informStateMap.put("PSSYSACTOR", "");
      informStateMap.put("PSSYSUSERCASE", "");
      informStateMap.put("PSSYSUSERCASERS", "");
      informStateMap.put("PSDELOGIC", "");
      informStateMap.put("PSDELOGICNODE", "PSDELOGICID");
      informStateMap.put("PSDELOGICLINK", "PSDELOGICID");
      informStateMap.put("PSWFVERSION", "");
      informStateMap.put("PSWFPROCESS", "PSWFVERSIONID");
      informStateMap.put("PSWFLINK", "PSWFVERSIONID");
      informStateMap.put("PSSYSERMAPNODE", "PSSYSERMAPID");
      informStateMap.put("PSSYSUCMAPNODE", "PSSYSUCMAPID");
      informStateMap.put("PSDEFORMDETAIL", "PSDEFORMID|PPSDEFORMDETAILID");
      informStateMap.put("PSDEGRIDCOL", "PSDEGRIDID|PPSDEGRIDCOLID");
      informStateMap.put("PSDETBITEM", "PSDETOOLBARID|PPSDETBITEMID");
      informStateMap.put("PSAPPMENUITEM", "PSAPPMENUID|PPSAPPMENUITEMID");
      informStateMap.put("PSDETREENODE", "PSDETREEVIEWID");
      informStateMap.put("PSDETREENODERS", "PSDETREEVIEWID");
      informStateMap.put("PSDETREENODECOL", "PSDETREEVIEWID");
      informStateMap.put("PSDELISTITEM", "PSDELISTID|PSDEDATAVIEWID");
      informStateMap.put("PSDEVIEWCTRL", "PSDEVIEWBASEID");
      informStateMap.put("PSDEVIEWRV", "MAJORPSDEVIEWID");
      informStateMap.put("PSDEVIEWLOGIC", "PSDEVIEWBASEID");
      informStateMap.put("PSDEVIEWENGINE", "PSDEVIEWBASEID");
      informStateMap.put("PSSYSVIEWPANELITEM", "PSSYSVIEWPANELID|PPSSYSVIEWPANELITEMID");
      informStateMap.put("PSSYSDBPART", "PSSYSDASHBOARDID|PPSSYSDBPARTID");
      informStateMap.put("PSAPPPVPART", "PSAPPPORTALVIEWID|PPSAPPPVPARTID");
      informStateMap.put("PSDECHARTAXES", "PSDECHARTID");
      informStateMap.put("PSDECHARTPARAM", "PSDECHARTID");
      informStateMap.put("PSDEFVALUERULE", "");
      informStateMap.put("PSDEFVRCOND", "PSDEFVRID|PPSDEFVRCONDID");
      informStateMap.put("PSDEDATAQUERY", "");
      informStateMap.put("PSDEDQJOIN", "PSDEDQID|PPSDEDQJOINID");
      informStateMap.put("PSPFPREVIEWACTION", "");
      informStateMap.put("PSSFPREVIEWACTION", "");
      informStateMap.put("PSCODEPREVIEWACTION", "");
      informStateMap.put("PSCODESERVERACTION", "");
      informStateMap.put("PSDESERVICEAPI", "");
      informStateMap.put("PSDESARS", "");
      informStateMap.put("PSDESADETAIL", "");
      informStateMap2.put("PSDCBKTASK", "");
   }

   protected interface ISysConsole {
      void log(String var1, String var2);

      void warn(String var1, String var2);

      void error(String var1, String var2);
   }

   protected class ModelV2 {
      public String type = null;
      public String key = null;
      public String text = null;
      public String tag = null;
      public int pos = -1;
      public IEntity entity = null;
   }
}
