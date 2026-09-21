/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.NullNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  com.google.common.base.CaseFormat
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEField
 *  net.ibizsys.paas.core.IDER1N
 *  net.ibizsys.paas.core.IDERBase
 *  net.ibizsys.paas.core.IDataEntity
 *  net.ibizsys.paas.core.RemoteCallResult
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBCallResult
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDBDialect
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.ISelectContext
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.ISelectFilter
 *  net.ibizsys.paas.db.ProcParam
 *  net.ibizsys.paas.db.ProcParamList
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.db.SelectFieldFilter
 *  net.ibizsys.paas.db.SelectGroupFilter
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDEFieldModel
 *  net.ibizsys.paas.demodel.IDER1NModel
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.demodel.ISqlCommandModel
 *  net.ibizsys.paas.demodel.SqlCommandModel
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityException
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ActionSession
 *  net.ibizsys.paas.service.ActionSessionManager
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.CloneSessionManager
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ImportSessionManager
 *  net.ibizsys.paas.service.RemoteService
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.DefaultValueHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.paas.util.freemarker.DataContextMethod
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.springframework.http.HttpEntity
 *  org.springframework.http.HttpHeaders
 *  org.springframework.http.HttpMethod
 *  org.springframework.http.HttpStatus
 *  org.springframework.http.MediaType
 *  org.springframework.http.ResponseEntity
 *  org.springframework.http.converter.StringHttpMessageConverter
 *  org.springframework.util.MultiValueMap
 *  org.springframework.web.client.HttpServerErrorException
 *  org.springframework.web.client.RestTemplate
 */
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
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.core.IDEField;
import net.ibizsys.paas.core.IDER1N;
import net.ibizsys.paas.core.IDERBase;
import net.ibizsys.paas.core.IDataEntity;
import net.ibizsys.paas.core.RemoteCallResult;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBCallResult;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDBDialect;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.ISelectContext;
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.ISelectFilter;
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
import net.ibizsys.pscore.srv.IPSCoreSysDAO;
import net.ibizsys.pscore.srv.IPSCoreSysService;
import net.ibizsys.pscore.srv.IPSMOSFileService;
import net.ibizsys.pscore.srv.IPSModelV2Service;
import net.ibizsys.pscore.srv.IPSRawSelectWork;
import net.ibizsys.pscore.srv.PSCoreSysModel;
import net.ibizsys.pscore.srv.PSCoreSysServiceBaseBase;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTSBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserRecent;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserRecentBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserRecentService;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.service.IPSModelService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelChgLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelChgLogBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelLog;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelLogBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPubBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTask;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelChgLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelLogService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTaskService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFileBase;
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
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

public abstract class PSCoreSysServiceBase<ET extends IEntity>
extends PSCoreSysServiceBaseBase<ET>
implements IPSCoreSysService<ET>,
IPSModelV2Service<ET>,
IPSMOSFileService<ET> {
    private static final Log log = LogFactory.getLog(PSCoreSysServiceBase.class);
    private static RestTemplate restTemplate = new RestTemplate();
    private static HashMap<String, String> deLogMap;
    private static HashMap<String, String> deModelVerMap;
    private static HashMap<String, String> deModelVerMap2;
    private static HashMap<String, String> deDBVerMap;
    private static HashMap<String, String> sysModelVerMap;
    private static HashMap<String, String> sysModelVerSqlMap;
    private static HashMap<String, String> sysModelLogMap;
    private static HashMap<String, String> informStateMap;
    private static HashMap<String, String> informStateMap2;
    private static final String ACTION_X_INITMODEL = "INITMODEL";
    public static final String ACTION_INITMODEL = "INITMODEL";
    public static final String LOGGER_OPINFO = "\u64cd\u4f5c\u4fe1\u606f";
    private static String strDevCenterApi;
    private static RemoteCallResult defaultRemoteCallResult;
    private static ThreadLocal<String> curPSSystemId;
    private static ThreadLocal<String> curPSDCId;
    private static ThreadLocal<String> curPSDevSlnSysId;
    private static ThreadLocal<String> curPSDevSlnId;
    private static ThreadLocal<String> curPSDynaInstId;
    private static PSModelHotCodeHelper psModelHotCodeHelper;
    private static ThreadLocal<PSSystem> impSysModelSystem;
    private static ThreadLocal<SessionFactory> curMajorSessionFactory;
    private static ThreadLocal<Boolean> simpleImportExportMode;
    private static ThreadLocal<String> simpleImportExportOwner;
    private static ThreadLocal<Boolean> threadCurDCLimit;
    private static ThreadLocal<Boolean> threadCurDevSlnLimit;
    private static ThreadLocal<Boolean> threadCodeNameUpperCamel;
    private static HashMap<String, String> denyCopyMap;
    public static int PSMODEL_EXPORTMODE;
    public static final String MSG_ACEMPTY = "\u65e0\u6cd5\u81ea\u52a8\u8ba1\u7b97\u5408\u9002\u7684\u53ef\u9009\u503c\uff0c\u8bf7\u76f4\u63a5\u8f93\u5165";
    private static boolean bEnableMergeCount;
    private static boolean bEnableI18NDefault;
    private static boolean bEnableStateInformDefault;
    private static Boolean bEnableDevSlnSysRemoteCall;
    private static Boolean bEnableModelObjStorage;
    private static boolean bEnableOPInfoInformDefault;
    private static Boolean bEnableGitLabPlugin;
    private static IPSGitLabPlugin iPSGitLabPlugin;
    private static Boolean bEnableKafkaPlugin;
    private static IPSKafkaPlugin iPSKafkaPlugin;
    private static String strPSSvrDomainId;
    private static boolean bEnableCurDCLimit;
    private static boolean bEnableCurDevSlnLimit;
    private static boolean bEnablePaaSAdminLimit;
    private static String strRecyclePSDCId;
    private static boolean bPrivateCloudMode;
    private static boolean bMOSMode;
    private static int nMOSVersion;
    private static boolean bCloudMode;
    private static String strProxyTaskServerUrl;
    private static boolean bEnableCodeNameUpperCamel;
    private static Boolean bEnableGitBranch;
    private static String strModelFormat;
    protected static final Pattern codeNamePattern;
    private static PSSysSFPub invalidPSSysSFPub;
    private static Map<String, PSHelpSection[]> pastePSHelpSectionsMap;
    private static Map<String, Integer> ignoreExportModelV2Map;
    private static Map<String, Integer> ignoreImportModelV2Map;
    private static Map<String, Integer> ignoreImportModelFieldV2Map;
    private static Map<String, String> aliasModelV2Map;
    private static Map<String, String> ignoreCountDRDataFoldersMap;
    private static ObjectMapper MAPPER;
    private ISysConsole iSysConsole = new ISysConsole(){

        @Override
        public void log(String string, String string2) {
            PSCoreSysServiceBase.this.logSysConsole("INFO", string, string2);
        }

        @Override
        public void warn(String string, String string2) {
            PSCoreSysServiceBase.this.logSysConsole("WARN", string, string2);
        }

        @Override
        public void error(String string, String string2) {
            PSCoreSysServiceBase.this.logSysConsole("ERROR", string, string2);
        }
    };

    public PSCoreSysServiceBase() {
        try {
            PSCoreEntityKeeperGlobal.initAll();
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
    }

    protected void onBeforeCreateTemp(ET ET) throws Exception {
        if (ImportSessionManager.getCurrentSession() == null) {
            this.fillEntity(ET);
            this.fillDefaultValue(ET, true);
        }
        psModelHotCodeHelper.execute(this, "BEFORECREATE", (IEntity)ET, true);
        super.onBeforeCreateTemp(ET);
    }

    protected void onBeforeUpdateTemp(ET ET) throws Exception {
        this.fillEntity(ET);
        psModelHotCodeHelper.execute(this, "BEFOREUPDATE", (IEntity)ET, true);
        super.onBeforeUpdateTemp(ET);
    }

    protected void onAfterCreateTemp(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "AFTERCREATE", (IEntity)ET, true);
        this.informObjectChanged(ET, "CREATE");
        super.onAfterCreateTemp(ET);
    }

    protected void onAfterUpdateTemp(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "AFTERUPDATE", (IEntity)ET, true);
        this.informObjectChanged(ET, "UPDATE");
        super.onAfterUpdateTemp(ET);
    }

    protected void onBeforeGetDraft(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "BEFOREGETDRAFT", (IEntity)ET, true);
        super.onBeforeGetDraft(ET);
    }

    protected void onBeforeGetDraftTemp(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "BEFOREGETDRAFT", (IEntity)ET, true);
        super.onBeforeGetDraftTemp(ET);
    }

    protected void onAfterGetDraft(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "AFTERGETDRAFT", (IEntity)ET, true);
        super.onAfterGetDraft(ET);
    }

    protected void onAfterGetDraftTemp(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "AFTERGETDRAFT", (IEntity)ET, true);
        super.onAfterGetDraftTemp(ET);
    }

    protected void onBeforeCreate(ET ET) throws Exception {
        if (ImportSessionManager.getCurrentSession() == null) {
            ET.set("DYNAMODELFLAG", (Object)0);
        }
        if (ImportSessionManager.getCurrentSession() == null) {
            this.fillEntity(ET);
            this.fillDefaultValue(ET, false);
        }
        psModelHotCodeHelper.execute(this, "BEFORECREATE", (IEntity)ET, true);
        super.onBeforeCreate(ET);
    }

    protected void onAfterCreate(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "AFTERCREATE", (IEntity)ET, true);
        this.informObjectChanged(ET, "CREATE");
        this.logSysModelChanged(ET, "CREATE");
        this.logModelObjChanged(ET, "CREATE");
        this.logDEModelVerChanged(ET);
        this.logDEDBVerChanged(ET);
        if (ImportSessionManager.getCurrentSession() == null) {
            PSSystem pSSystem;
            this.syncSysTask(ET, false);
            boolean bl = true;
            if (StringHelper.compare((String)this.getDEModel().getName(), (String)"PSDATAENTITY", (boolean)true) == 0 && !DataObject.getBoolValue((Integer)(pSSystem = PSCoreSysServiceBase.getCurrentPSSystem(ET, this.getSessionFactory())).getInitDEDefault(), (boolean)true)) {
                bl = false;
            }
            if (bl) {
                this.onInitModel(ET);
            }
        }
        super.onAfterCreate(ET);
    }

    protected void onBeforeUpdate(ET ET) throws Exception {
        this.fillEntity(ET);
        psModelHotCodeHelper.execute(this, "BEFOREUPDATE", (IEntity)ET, true);
        super.onBeforeUpdate(ET);
    }

    protected void onAfterUpdate(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "AFTERUPDATE", (IEntity)ET, true);
        this.informObjectChanged(ET, "UPDATE");
        this.logSysModelChanged(ET, "UPDATE");
        this.logModelObjChanged(ET, "UPDATE");
        this.logDEModelVerChanged(ET);
        this.logDEDBVerChanged(ET);
        if (ImportSessionManager.getCurrentSession() == null) {
            this.syncSysTask(ET, false);
        }
        super.onAfterUpdate(ET);
    }

    protected void onBeforeRemove(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "BEFOREREMOVE", (IEntity)ET, true);
        this.informObjectChanged(ET, "DELETE");
        this.logSysModelChanged(ET, "DELETE");
        this.logModelObjChanged(ET, "DELETE");
        this.logDEModelVerChanged(ET);
        this.logDEDBVerChanged(ET);
        this.syncSysTask(ET, true);
        super.onBeforeRemove(ET);
    }

    protected void onAfterRemove(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "AFTERREMOVE", (IEntity)ET, true);
        this.informObjectChanged(ET, "DELETE");
        super.onAfterRemove(ET);
    }

    protected void onAfterRemoveTemp(ET ET) throws Exception {
        psModelHotCodeHelper.execute(this, "AFTERREMOVE", (IEntity)ET, true);
        this.informObjectChanged(ET, "DELETE");
        super.onAfterRemoveTemp(ET);
    }

    protected void logSysModelChanged(ET object, String string) throws Exception {
        Object object2;
        Object object3;
        Object object4;
        String string2;
        if (PSCoreSysServiceBase.isImpSysModelNowEx()) {
            return;
        }
        if (sysModelLogMap.containsKey(this.getDEModel().getName())) {
            string2 = sysModelLogMap.get(this.getDEModel().getName());
            if (StringHelper.isNullOrEmpty((String)string2)) {
                string2 = this.getDEModel().getName();
            }
            if ((object4 = object.get("pssystemid")) == null) {
                object4 = PSCoreSysServiceBase.getCurrentPSSystemId();
            }
            if (object4 != null) {
                if (ActionSessionManager.getCurrentSession().registerRecursion("LOGSYSMODELCHANGED", (String)object4, (Object)string2)) {
                    object3 = (PSSysModelLogService)ServiceGlobal.getService(PSSysModelLogService.class, (SessionFactory)this.getSessionFactory());
                    object2 = new PSSysModelLog();
                    ((PSSysModelLogBase)object2).setPSSystemId((String)object4);
                    ((PSSysModelLogBase)object2).setPSSystemName("(N/A)");
                    ((PSSysModelLogBase)object2).setPSSysModelLogName(string2);
                    object3.save((IEntity)object2, false);
                }
            } else {
                log.error((Object)StringHelper.format((String)"\u7cfb\u7edf\u6a21\u578b[%1$s]\u53d8\u5316\u6ca1\u6709\u88ab\u65e5\u5fd7\uff0c\u6ca1\u6709\u7cfb\u7edf\u6807\u8bc6", (Object)this.getDEModel().getName()));
            }
        }
        if (!StringHelper.isNullOrEmpty((String)(string2 = deLogMap.get(this.getDEModel().getName())))) {
            if (StringHelper.compare((String)string, (String)"DELETE", (boolean)true) == 0) {
                object = this.getLast((IEntity)object);
            }
            if (!StringHelper.isNullOrEmpty((String)(object4 = (String)object.get(string2)))) {
                Object object5;
                object3 = new PSSysModelChgLog();
                ((PSSysModelChgLogBase)object3).setCHGType(string);
                ((PSSysModelChgLogBase)object3).setPSSysModelChgLogName(this.getDEModel().getLogicName());
                ((PSSysModelChgLogBase)object3).setObjType(this.getDEModel().getName());
                ((PSSysModelChgLogBase)object3).setPSDEId((String)object4);
                ((PSSysModelChgLogBase)object3).setPSObjId((String)object.get(this.getDEModel().getKeyDEField().getName()));
                if (object.get("pssystemid") != null) {
                    ((PSSysModelChgLogBase)object3).set("pssystemid", object.get("pssystemid"));
                }
                if (object.get("pssystemname") != null) {
                    ((PSSysModelChgLogBase)object3).set("pssystemname", object.get("pssystemname"));
                }
                if (StringHelper.isNullOrEmpty((String)((PSSysModelChgLogBase)object3).getPSSystemName())) {
                    ((PSSysModelChgLogBase)object3).setPSSystemName("(N/A)");
                }
                if (StringHelper.compare((String)string, (String)"DELETE", (boolean)true) == 0 && StringHelper.compare((String)this.getDEModel().getName(), (String)"PSDATAENTITY", (boolean)true) == 0 && StringHelper.compare((String)object4, (String)((PSSysModelChgLogBase)object3).getPSObjId(), (boolean)true) == 0) {
                    ((PSSysModelChgLogBase)object3).setPSDEName("(N/A)");
                }
                if (StringHelper.isNullOrEmpty((String)(object2 = (String)object.get(this.getDEModel().getMajorDEField().getName()))) && StringHelper.compare((String)string, (String)"DELETE", (boolean)true) != 0) {
                    object5 = this.getDEModel().createEntity();
                    object5.set(this.getDEModel().getKeyDEField().getName(), (Object)((PSSysModelChgLogBase)object3).getPSObjId());
                    this.get((IEntity)object5);
                    object2 = (String)object5.get(this.getDEModel().getMajorDEField().getName());
                }
                if (StringHelper.isNullOrEmpty((String)object2)) {
                    object2 = "(N/A)";
                }
                ((PSSysModelChgLogBase)object3).setPSObjName((String)object2);
                if (this.getWebContext() != null) {
                    ((PSSysModelChgLogBase)object3).setRemoteAddr(this.getWebContext().getRemoteAddr());
                }
                object5 = (PSSysModelChgLogService)ServiceGlobal.getService(PSSysModelChgLogService.class, (SessionFactory)this.getSessionFactory());
                ((PSCoreSysServiceBase)object5).create(object3, false);
                return;
            }
        }
    }

    protected void logDEModelVerChanged(ET ET) throws Exception {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        if (PSCoreSysServiceBase.isImpSysModelNowEx()) {
            return;
        }
        boolean bl = false;
        String string = deModelVerMap.get(this.getDEModel().getName());
        String string2 = null;
        if (!StringHelper.isNullOrEmpty((String)string)) {
            string2 = (String)ET.get(string);
            if (StringHelper.isNullOrEmpty((String)string2) && this.getLast((IEntity)ET) != null) {
                string2 = (String)this.getLast((IEntity)ET).get(string);
            }
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                if (ActionSessionManager.getCurrentSession().registerRecursion("LOGDEMODELVERCHANGED", "PSDATAENTITY", (Object)string2)) {
                    object4 = StringHelper.format((String)"UPDATE T_SRFPSDATAENTITY SET MODELVER=MODELVER+1 WHERE PSDATAENTITYID=?");
                    object3 = new SqlParamList();
                    object3.add((Object)string2, 25);
                    this.getDAO().executeRawSql(null, (String)object4, (SqlParamList)object3);
                    object2 = StringHelper.format((String)"update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpsdataentity where t_srfpssystem.PSSYSTEMID = t_srfpsdataentity.PSSYSTEMID and t_srfpsdataentity.psdataentityid=?)");
                    this.getDAO().executeRawSql(null, (String)object2, (SqlParamList)object3);
                }
                bl = true;
            }
        }
        if (!StringHelper.isNullOrEmpty(string2) && this.getWebContext() != null && ActionSessionManager.getCurrentSession().registerRecursion("LOGDEVUSERRECENT_DE", "PSDATAENTITY", (Object)string2) && !StringHelper.isNullOrEmpty((String)this.getWebContext().getCurUserId()) && !StringHelper.isNullOrEmpty((String)this.getWebContext().getCurOrgId())) {
            object4 = new PSDataEntity();
            ((PSDataEntityBase)object4).setPSDataEntityId(string2);
            object3 = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
            object3.get((IEntity)object4);
            object2 = new PSDevUserRecent();
            ((PSDevUserRecentBase)object2).setObjType("PSDATAENTITY");
            ((PSDevUserRecentBase)object2).setObjId(((PSDataEntityBase)object4).getPSDataEntityId());
            object = ((PSCoreSysServiceBase)object3).getDataInfo(object4);
            ((PSDevUserRecentBase)object2).setObjName((String)object);
            if (!StringHelper.isNullOrEmpty((String)this.getWebContext().getCurOrgId())) {
                ((PSDevUserRecentBase)object2).setPSDevCenterId(this.getWebContext().getCurOrgId());
                if (StringHelper.isNullOrEmpty((String)this.getWebContext().getCurOrgName())) {
                    ((PSDevUserRecentBase)object2).setPSDevCenterName("\u5e94\u7528\u4e2d\u5fc3");
                } else {
                    ((PSDevUserRecentBase)object2).setPSDevCenterName(this.getWebContext().getCurOrgName());
                }
            }
            ((PSDevUserRecentBase)object2).setPSDevUserId(this.getWebContext().getCurUserId());
            ((PSDevUserRecentBase)object2).setPSDevUserName(this.getWebContext().getCurUserName());
            ((PSDevUserRecentBase)object2).setPSDevUserRecentName(((PSDevUserRecentBase)object2).getObjName());
            PSDevUserRecentService pSDevUserRecentService = (PSDevUserRecentService)ServiceGlobal.getService(PSDevUserRecentService.class, (SessionFactory)this.getSessionFactory());
            pSDevUserRecentService.save((IEntity)object2, false);
        }
        string2 = null;
        string = deModelVerMap2.get(this.getDEModel().getName());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            string2 = (String)ET.get(string);
            if (StringHelper.isNullOrEmpty((String)string2) && this.getLast((IEntity)ET) != null) {
                string2 = (String)this.getLast((IEntity)ET).get(string);
            }
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                if (ActionSessionManager.getCurrentSession().registerRecursion("LOGDEMODELVERCHANGED", "PSDATAENTITY", (Object)string2)) {
                    object4 = StringHelper.format((String)"UPDATE T_SRFPSDATAENTITY SET MODELVER=MODELVER+1 WHERE PSDATAENTITYID=?");
                    object3 = new SqlParamList();
                    object3.add((Object)string2, 25);
                    this.getDAO().executeRawSql(null, (String)object4, (SqlParamList)object3);
                    object2 = StringHelper.format((String)"update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpsdataentity where t_srfpssystem.PSSYSTEMID = t_srfpsdataentity.PSSYSTEMID and t_srfpsdataentity.psdataentityid=?)");
                    this.getDAO().executeRawSql(null, (String)object2, (SqlParamList)object3);
                }
                bl = true;
            }
        }
        if (!bl) {
            object4 = sysModelVerMap.get(this.getDEModel().getName());
            if (object4 != null) {
                object3 = PSCoreSysServiceBase.getCurrentPSSystemId();
                if (StringHelper.isNullOrEmpty((String)object3) && !StringHelper.isNullOrEmpty((String)object4) && StringHelper.isNullOrEmpty((String)(object3 = (String)ET.get((String)object4))) && this.getLast((IEntity)ET) != null) {
                    object3 = (String)this.getLast((IEntity)ET).get((String)object4);
                }
                if (!StringHelper.isNullOrEmpty((String)object3) && ActionSessionManager.getCurrentSession().registerRecursion("LOGDEMODELVERCHANGED", "PSSYSTEM", object3)) {
                    object2 = StringHelper.format((String)"UPDATE T_SRFPSSYSTEM SET MODELVER=MODELVER+1 WHERE PSSYSTEMID=?");
                    object = new SqlParamList();
                    object.add(object3, 25);
                    this.getDAO().executeRawSql(null, (String)object2, object);
                }
            } else {
                object3 = sysModelVerSqlMap.get(this.getDEModel().getName());
                if (!StringHelper.isNullOrEmpty((String)object3) && !StringHelper.isNullOrEmpty((String)(object2 = DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName())))) && ActionSessionManager.getCurrentSession().registerRecursion("LOGDEMODELVERCHANGED", "PSSYSTEM", object2)) {
                    object = new SqlParamList();
                    object.add(object2, 25);
                    this.getDAO().executeRawSql(null, (String)object3, object);
                }
            }
        }
    }

    protected void logDEDBVerChanged(ET ET) throws Exception {
        if (PSCoreSysServiceBase.isImpSysModelNowEx()) {
            return;
        }
        String string = deDBVerMap.get(this.getDEModel().getName());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            String string2 = (String)ET.get(string);
            if (StringHelper.isNullOrEmpty((String)string2) && this.getLast((IEntity)ET) != null) {
                string2 = (String)this.getLast((IEntity)ET).get(string);
            }
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                if (ActionSessionManager.getCurrentSession().registerRecursion("LOGDEDBVERCHANGED", "PSDATAENTITY", (Object)string2)) {
                    String string3 = StringHelper.format((String)"UPDATE T_SRFPSDATAENTITY SET DBVER=DBVER+1 WHERE PSDATAENTITYID=?");
                    SqlParamList sqlParamList = new SqlParamList();
                    sqlParamList.add((Object)string2, 25);
                    this.getDAO().executeRawSql(null, string3, sqlParamList);
                    string3 = StringHelper.format((String)"update T_SRFPSSYSTEM set DBVERSION=DBVERSION+1\twhere exists(select * from T_SRFPSDATAENTITY t1 where t1.PSDATAENTITYID=? and t1.PSSYSTEMID=T_SRFPSSYSTEM.PSSYSTEMID)");
                    this.getDAO().executeRawSql(null, string3, sqlParamList);
                }
                return;
            }
        }
    }

    public void initModel(ET ET) throws Exception {
        IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, "INITMODEL", 0, ET, null).getResult() == 1) {
            return;
        }
        final String string = DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName()));
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        this.doServiceWork(new IServiceWork((IEntity)ET){
            final /* synthetic */ IEntity val$et;
            {
                this.val$et = iEntity;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                if (KeyValueHelper.isTempKey((String)string)) {
                    PSCoreSysServiceBase.this.getTemp(this.val$et);
                    String string2 = (String)EntityBase.getOriginKey((IEntity)this.val$et);
                    if (!StringHelper.isNullOrEmpty((String)string2)) {
                        IEntity iEntity = PSCoreSysServiceBase.this.getDEModel().createEntity();
                        iEntity.set(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName(), (Object)string2);
                        PSCoreSysServiceBase.this.get(iEntity);
                        PSCoreSysServiceBase.this.onInitModel(iEntity);
                    }
                } else {
                    PSCoreSysServiceBase.this.get(this.val$et);
                    PSCoreSysServiceBase.this.onInitModel(this.val$et);
                }
            }
        }, true);
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, "INITMODEL", 99, ET, null);
        }
    }

    protected void onInitModel(ET ET) throws Exception {
        PSModelInitStruct pSModelInitStruct = PSModelInitGlobal.getPSModelInitStruct(this.getDEModel().getName());
        if (pSModelInitStruct == null) {
            return;
        }
        for (PSMIDetail pSMIDetail : pSModelInitStruct.getPSModelInitDetails()) {
            String string = KeyValueHelper.genUniqueId((String)this.getDEModel().getSystem().getId(), (String)pSMIDetail.getPSDEName());
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)string);
            IService iService = iDataEntityModel.getService(this.getSessionFactory());
            if (!(iService instanceof IPSModelService)) continue;
            ((IPSModelService)iService).initModel(this.getDEModel().getName(), (IEntity)ET, pSMIDetail.getInitMode());
        }
    }

    public void executeAction(String string, IEntity iEntity) throws Exception {
        if (string.indexOf("X_") == 0 || string.indexOf("XG_") == 0 || string.indexOf("X2_") == 0 || string.indexOf("X2G_") == 0 || string.indexOf("X3_") == 0 || string.indexOf("X3G_") == 0) {
            if (this.getWebContext() == null) {
                final String string2 = string;
                final IEntity iEntity2 = iEntity;
                ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                    public void execute(ITransaction iTransaction) throws Exception {
                        PSCoreSysServiceBase.this.executeRemoteCallX(string2, iEntity2);
                    }
                });
            } else {
                this.executeRemoteCallX(string, iEntity);
            }
            return;
        }
        super.executeAction(string, iEntity);
    }

    protected void executeRemoteCallX(String string, IEntity iEntity) throws Exception {
        if (string.indexOf("X_") == 0) {
            this.executeRemoteCall(string.substring(2), iEntity);
            return;
        }
        if (string.indexOf("XG_") == 0) {
            this.executeRemoteCall(string.substring(3), iEntity, true);
            return;
        }
        if (string.indexOf("X2_") == 0) {
            this.executeRemoteCall2(string.substring(3), iEntity, false);
            return;
        }
        if (string.indexOf("X2G_") == 0) {
            this.executeRemoteCall2(string.substring(4), iEntity, true);
            return;
        }
        if (string.indexOf("X3_") == 0) {
            this.executeRemoteCall3(string.substring(3), iEntity);
            return;
        }
        if (string.indexOf("X3G_") == 0) {
            this.executeRemoteCall3(string.substring(4), iEntity, true);
            return;
        }
    }

    protected RemoteCallResult executeRemoteCall(String string, IEntity iEntity) throws Exception {
        return this.executeRemoteCall(string, iEntity, false);
    }

    protected RemoteCallResult executeRemoteCall(String string, IEntity iEntity, boolean bl) throws Exception {
        Object object;
        Object object2;
        Object object3 = iEntity.get("pssystemid");
        if (object3 == null) {
            object3 = PSCoreSysServiceBase.getCurrentPSSystemId();
        }
        if (object3 == null) {
            object3 = this.getDataContextValue(iEntity, "pssystemid", null);
        }
        if (object3 == null) {
            object3 = DataContextMethod.getValue((String)"pssystemid", (SessionFactory)this.getSessionFactory());
        }
        PSTaskServer pSTaskServer = null;
        SessionFactory sessionFactory = this.getSessionFactory();
        if (PSCoreSysServiceBase.isEnableDevSlnSysRemoteCall() || sessionFactory == PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            object2 = this.getCurrentPSDevSlnSysId((IEntity)(sessionFactory == PSCoreSysServiceBase.getCurMajorSessionFactory() ? iEntity : null), true);
            if (StringHelper.isNullOrEmpty((Object)object2)) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf");
            }
            object = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
            pSDevSlnSys.setPSDevSlnSysId((String)object2);
            object.get((IEntity)pSDevSlnSys);
            if (pSDevSlnSys.getPSDevCenterTS() != null) {
                pSTaskServer = pSDevSlnSys.getPSDevCenterTS().getPSTaskServer();
                iEntity.set("pssystemid", (Object)pSDevSlnSys.getPSSystemId());
                iEntity.set("psdevslnsysid", (Object)pSDevSlnSys.getPSDevSlnSysId());
            } else {
                sessionFactory = PSSysModelInstGlobal.getSessionFactory(pSDevSlnSys.getPSSysModelInstId());
            }
        }
        if (pSTaskServer == null) {
            if (object3 == null) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7cfb\u7edf");
            }
            object2 = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
            object = new PSSystem();
            ((PSSystemBase)object).setPSSystemId((String)object3);
            object2.getCache((IEntity)object);
            if (((PSSystem)object).getPSDevCenterTS() == null) {
                throw new Exception("\u5f53\u524d\u7cfb\u7edf\u672a\u914d\u7f6e\u4efb\u52a1\u670d\u52a1\u5668");
            }
            if (!StringHelper.isNullOrEmpty((String)((PSSystemBase)object).getPSDevSlnSysId())) {
                iEntity.set("psdevslnsysid", (Object)((PSSystemBase)object).getPSDevSlnSysId());
            }
            iEntity.set("pssystemid", (Object)((PSSystemBase)object).getPSSystemId());
            pSTaskServer = ((PSSystem)object).getPSDevCenterTS().getPSTaskServer();
        }
        return this.executeRemoteCall(pSTaskServer, string, iEntity, bl);
    }

    protected RemoteCallResult executeRemoteCall(PSTaskServer pSTaskServer, String string, IEntity iEntity, boolean bl) throws Exception {
        String string2 = this.getRemoteCallUrl(pSTaskServer, string, iEntity);
        RemoteService remoteService = new RemoteService();
        remoteService.init(string2, this.getDEModel().getName(), WebContext.getCurrent().getCurUserId());
        log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u8fdc\u7a0b\u5730\u5740[%1$s]", (Object)string2));
        RemoteCallResult remoteCallResult = remoteService.executeAction(string, iEntity, "GBK");
        if (remoteCallResult.isError()) {
            throw new Exception(remoteCallResult.getErrorInfo());
        }
        if (bl && remoteCallResult.getItems() != null && remoteCallResult.getItems().length() > 0) {
            DataObject.fromJSONObject((IDataObject)iEntity, (JSONObject)remoteCallResult.getItems().getJSONObject(0));
        }
        return remoteCallResult;
    }

    protected RemoteCallResult executeRemoteCall2(String string, IEntity iEntity) throws Exception {
        return this.executeRemoteCall2(string, iEntity, false);
    }

    protected RemoteCallResult executeRemoteCall2(String string, IEntity iEntity, boolean bl) throws Exception {
        PSDevCenterTS pSDevCenterTS2;
        Object object;
        Object object2 = iEntity.get("psdevcenterid");
        if (object2 == null) {
            object2 = PSCoreSysServiceBase.getCurrentPSDCId();
        } else {
            object = PSCoreSysServiceBase.getCurrentPSDCId();
            if (!StringHelper.isNullOrEmpty((String)object) && !object2.equals(object)) {
                throw new Exception("\u4f20\u5165\u5e94\u7528\u4e2d\u5fc3\u4e0d\u4e00\u81f4");
            }
        }
        if (object2 == null) {
            object2 = this.getDataContextValue(iEntity, "psdevcenterid", null);
        }
        if (object2 == null) {
            object2 = DataContextMethod.getValue((String)"psdevcenterid", (SessionFactory)this.getSessionFactory());
        }
        if (object2 == null && WebContext.getCurrent() != null) {
            object2 = WebContext.getCurrent().getCurOrgId();
        }
        if (StringHelper.isNullOrEmpty((Object)object2)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3");
        }
        object = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId((String)object2);
        ArrayList<PSDevCenterTS> arrayList = ((PSDevCenterTSServiceBase)object).selectByPSDevCenter(pSDevCenter);
        if (arrayList.size() == 0) {
            throw new Exception("\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3\u672a\u914d\u7f6e\u4efb\u52a1\u670d\u52a1\u5668");
        }
        PSDevCenterTSBase pSDevCenterTSBase = null;
        for (PSDevCenterTS pSDevCenterTS2 : arrayList) {
            if (!DataObject.getBoolValue((Integer)pSDevCenterTS2.getValidFlag(), (boolean)true)) continue;
            if (StringHelper.compare((String)"SYSPUB", (String)pSDevCenterTS2.getServerUsage(), (boolean)false) == 0) {
                pSDevCenterTSBase = pSDevCenterTS2;
                break;
            }
            if (pSDevCenterTSBase != null) continue;
            pSDevCenterTSBase = pSDevCenterTS2;
        }
        if (pSDevCenterTSBase == null) {
            throw new Exception("\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3\u672a\u914d\u7f6e\u4efb\u52a1\u670d\u52a1\u5668");
        }
        iEntity.set("psdevcenterid", object2);
        String string2 = this.getRemoteCallUrl(pSDevCenterTSBase.getPSTaskServer(), string, iEntity);
        pSDevCenterTS2 = new RemoteService();
        pSDevCenterTS2.init(string2, this.getDEModel().getName(), WebContext.getCurrent().getCurUserId());
        log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u8fdc\u7a0b\u5730\u5740[%1$s]", (Object)string2));
        RemoteCallResult remoteCallResult = pSDevCenterTS2.executeAction(string, iEntity, "GBK");
        if (remoteCallResult.isError()) {
            throw new Exception(remoteCallResult.getErrorInfo());
        }
        if (bl && remoteCallResult.getItems() != null && remoteCallResult.getItems().length() > 0) {
            DataObject.fromJSONObject((IDataObject)iEntity, (JSONObject)remoteCallResult.getItems().getJSONObject(0));
        }
        return remoteCallResult;
    }

    protected RemoteCallResult executeRemoteCall2All(String string, IEntity iEntity) throws Exception {
        Object object = iEntity.get("psdevcenterid");
        if (object == null) {
            object = PSCoreSysServiceBase.getCurrentPSDCId();
        }
        if (object == null) {
            object = this.getDataContextValue(iEntity, "psdevcenterid", null);
        }
        if (object == null) {
            object = DataContextMethod.getValue((String)"psdevcenterid", (SessionFactory)this.getSessionFactory());
        }
        if (object == null && WebContext.getCurrent() != null) {
            object = WebContext.getCurrent().getCurOrgId();
        }
        if (StringHelper.isNullOrEmpty((Object)object)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3");
        }
        PSDevCenterTSService pSDevCenterTSService = (PSDevCenterTSService)ServiceGlobal.getService(PSDevCenterTSService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevCenter pSDevCenter = new PSDevCenter();
        pSDevCenter.setPSDevCenterId((String)object);
        ArrayList<PSDevCenterTS> arrayList = pSDevCenterTSService.selectByPSDevCenter(pSDevCenter);
        if (arrayList.size() == 0) {
            throw new Exception("\u5f53\u524d\u5e94\u7528\u4e2d\u5fc3\u672a\u914d\u7f6e\u4efb\u52a1\u670d\u52a1\u5668");
        }
        RemoteCallResult remoteCallResult = null;
        for (PSDevCenterTS pSDevCenterTS : arrayList) {
            if (!DataObject.getBoolValue((Integer)pSDevCenterTS.getValidFlag(), (boolean)true)) continue;
            IEntity iEntity2 = this.getDEModel().createEntity();
            iEntity.copyTo((IDataObject)iEntity2, false);
            iEntity2.set("psdevcenterid", object);
            String string2 = this.getRemoteCallUrl(pSDevCenterTS.getPSTaskServer(), string, iEntity);
            RemoteService remoteService = new RemoteService();
            remoteService.init(string2, this.getDEModel().getName(), WebContext.getCurrent().getCurUserId());
            log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u8fdc\u7a0b\u5730\u5740[%1$s]", (Object)string2));
            remoteCallResult = remoteService.executeAction(string, iEntity2, "GBK");
            if (!remoteCallResult.isError()) continue;
            throw new Exception(remoteCallResult.getErrorInfo());
        }
        return remoteCallResult;
    }

    protected RemoteCallResult executeRemoteCall3(String string, IEntity iEntity) throws Exception {
        return this.executeRemoteCall3(string, iEntity, false);
    }

    protected RemoteCallResult executeRemoteCall3(String string, IEntity iEntity, boolean bl) throws Exception {
        String string2 = DataObject.getStringValue((Object)iEntity.get("psdevslnsysid"));
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7cfb\u7edf");
        }
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        pSDevSlnSys.setPSDevSlnSysId(string2);
        pSDevSlnSysService.get((IEntity)pSDevSlnSys);
        PSTaskServer pSTaskServer = null;
        if (pSDevSlnSys.getPSDevCenterTS() != null) {
            pSTaskServer = pSDevSlnSys.getPSDevCenterTS().getPSTaskServer();
            iEntity.set("pssystemid", (Object)pSDevSlnSys.getPSSystemId());
            iEntity.set("psdevslnsysid", (Object)pSDevSlnSys.getPSDevSlnSysId());
        }
        if (pSTaskServer == null) {
            throw new Exception("\u5f53\u524d\u7cfb\u7edf\u672a\u914d\u7f6e\u4efb\u52a1\u670d\u52a1\u5668");
        }
        String string3 = this.getRemoteCallUrl(pSTaskServer, string, iEntity);
        RemoteService remoteService = new RemoteService();
        remoteService.init(string3, this.getDEModel().getName(), WebContext.getCurrent().getCurUserId());
        log.debug((Object)StringHelper.format((String)"\u8bf7\u6c42\u8fdc\u7a0b\u5730\u5740[%1$s]", (Object)string3));
        iEntity.set("SRF_LOGINNAME", (Object)WebContext.getCurrent().getCurLoginName());
        RemoteCallResult remoteCallResult = remoteService.executeAction(string, iEntity, "GBK");
        if (remoteCallResult.isError()) {
            throw new Exception(remoteCallResult.getErrorInfo());
        }
        if (bl && remoteCallResult.getItems() != null && remoteCallResult.getItems().length() > 0) {
            DataObject.fromJSONObject((IDataObject)iEntity, (JSONObject)remoteCallResult.getItems().getJSONObject(0));
        }
        return remoteCallResult;
    }

    protected String getRemoteCallUrl(PSTaskServer pSTaskServer, String string, IEntity iEntity) throws Exception {
        String string2;
        IWebContext iWebContext = net.ibizsys.paas.web.WebContext.getCurrent();
        if (iWebContext != null) {
            if (!iEntity.contains("SRF_LOGINNAME")) {
                iEntity.set("SRF_LOGINNAME", (Object)iWebContext.getCurLoginName());
            }
            if (!iEntity.contains("SRF_PERSONNAME")) {
                iEntity.set("SRF_PERSONNAME", (Object)iWebContext.getCurUserName());
            }
            if (!iEntity.contains("SRF_IPADDR")) {
                iEntity.set("SRF_IPADDR", (Object)iWebContext.getRealRemoteAddr());
            }
        }
        String string3 = pSTaskServer.getServerUrl();
        string3 = string3 + "saps/remoteapi.jsp";
        HashMap<String, String> hashMap = new HashMap<String, String>();
        this.getRemoteCallUrlParams(hashMap, string, iEntity);
        if (hashMap.size() > 0 && !StringHelper.isNullOrEmpty((String)(string2 = WebUtility.getQueryString(hashMap)))) {
            string3 = string3 + "?";
            string3 = string3 + string2;
        }
        return string3;
    }

    protected void getRemoteCallUrlParams(Map<String, String> map, String string, IEntity iEntity) throws Exception {
        map.put("action", "code");
        String string2 = null;
        String string3 = null;
        if (WebContext.getCurrent() != null && WebContext.getAppData() != null) {
            string2 = WebContext.getAppData().optString("psdevcenterid");
            string3 = WebContext.getAppData().optString("psdevslnsysid");
            if (StringHelper.isNullOrEmpty((String)string3)) {
                string3 = WebContext.getAppData().optString("psdevslntemplid");
            }
        }
        if (StringHelper.isNullOrEmpty(string2)) {
            string2 = "UNKNOWN";
        }
        if (StringHelper.isNullOrEmpty(string3)) {
            string3 = "UNKNOWN";
            map.put("action", "maintain");
        }
        map.put("actiontag", string2);
        map.put("actiontag2", string3);
    }

    public static RemoteCallResult executeDevCenterApi(String string, IEntity iEntity) throws Exception {
        if (strDevCenterApi == null) {
            strDevCenterApi = WebConfig.getCurrent().getAttribute("DEVCENTERAPI", "");
        }
        if (StringHelper.isNullOrEmpty((String)strDevCenterApi)) {
            return defaultRemoteCallResult;
        }
        RemoteService remoteService = new RemoteService();
        remoteService.init(strDevCenterApi, "PSDEVCENTER", WebContext.getCurrent().getCurUserId());
        RemoteCallResult remoteCallResult = remoteService.executeAction(string, iEntity, "UTF-8");
        if (remoteCallResult.isError()) {
            throw new Exception(remoteCallResult.getErrorInfo());
        }
        return remoteCallResult;
    }

    protected boolean isPrepareLastForRemove() {
        if (deModelVerMap.containsKey(this.getDEModel().getName())) {
            return true;
        }
        if (deDBVerMap.containsKey(this.getDEModel().getName())) {
            return true;
        }
        if (sysModelVerMap.containsKey(this.getDEModel().getName())) {
            return true;
        }
        if (deLogMap.containsKey(this.getDEModel().getName())) {
            return true;
        }
        return super.isPrepareLastForRemove();
    }

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
        }
        catch (Exception exception) {
            // empty catch block
        }
        return super.isPrepareLastForUpdate();
    }

    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)"INITMODEL", (boolean)true) == 0) {
            this.initModel(iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public XmlNode exportXmlModel(ET ET, XmlNode xmlNode) throws Exception {
        Object object;
        boolean bl;
        boolean bl2 = bl = xmlNode == null;
        if (!bl && !ET.isFullEntity()) {
            object = DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName()), (String)"");
            if (((String)object).indexOf("SRFTEMPKEY:") == 0) {
                this.getTemp((IEntity)ET);
            } else {
                this.get((IEntity)ET);
            }
        }
        object = new XmlNode();
        if (xmlNode != null) {
            xmlNode.addNode((XmlNode)object);
        }
        IEntity iEntity = this.getDEModel().createEntity();
        ET.copyTo((IDataObject)iEntity, false);
        this.exportCurXmlModel(iEntity, (XmlNode)object, bl);
        this.exportRelatedXmlModel(ET, (XmlNode)object);
        return object;
    }

    protected void exportCurXmlModel(ET ET, XmlNode xmlNode, boolean bl) throws Exception {
        ET.set(this.getDEModel().getKeyDEField().getName().toUpperCase(), null);
        ET.set("ENABLE", null);
        ET.set("CREATEMAN", null);
        ET.set("CREATEDATE", null);
        ET.set("UPDATEMAN", null);
        ET.set("UPDATEDATE", null);
        ET.set("SRFORIKEY", null);
        ET.set("SRFDRAFTFLAG", null);
        ET.set("DYNAMODELFLAG", null);
        ET.set("PSDYNAINSTID", null);
        ET.fillXmlNode(xmlNode, false);
    }

    protected void exportRelatedXmlModel(ET ET, XmlNode xmlNode) throws Exception {
        this.onExportRelatedXmlModel(ET, xmlNode);
    }

    protected void onExportRelatedXmlModel(ET ET, XmlNode xmlNode) throws Exception {
    }

    public ET importXmlModel(XmlNode xmlNode) throws Exception {
        return this.importXmlModel(null, xmlNode);
    }

    public ET importXmlModel(ET object, XmlNode xmlNode) throws Exception {
        if (object == null) {
            object = this.getDEModel().createEntity();
        }
        ET ET = object;
        XmlNode xmlNode2 = xmlNode;
        boolean bl = false;
        object.setSessionFactory(this.getSessionFactory());
        if (ActionSessionManager.getCurrentSession().getActionParam("IMPORTXMLMODEL_FIRST") == null) {
            ActionSessionManager.getCurrentSession().setActionParam("IMPORTXMLMODEL_FIRST", (Object)"FALSE");
            bl = true;
        }
        final boolean bl2 = bl;
        this.doServiceWork(new IServiceWork((IEntity)ET, xmlNode2){
            final /* synthetic */ IEntity val$et2;
            final /* synthetic */ XmlNode val$xmlNode2;
            {
                this.val$et2 = iEntity;
                this.val$xmlNode2 = xmlNode;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                CloneSession cloneSession = CloneSessionManager.getCurrentSession();
                if (bl2) {
                    String string = (String)this.val$et2.get(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName());
                    if (StringHelper.isNullOrEmpty((String)string)) {
                        string = this.val$xmlNode2.getAttribute("SRFKEY", "");
                        this.val$et2.set(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName(), (Object)string);
                    }
                    if (string.indexOf("SRFTEMPKEY:") != 0) {
                        PSCoreSysServiceBase.this.get(this.val$et2);
                    } else {
                        PSCoreSysServiceBase.this.getTemp(this.val$et2);
                    }
                    cloneSession.setEntity(PSCoreSysServiceBase.this.getDEModel(), (Object)string, this.val$et2);
                } else {
                    PSCoreSysServiceBase.this.importCurXmlModel(this.val$et2, this.val$xmlNode2);
                }
                PSCoreSysServiceBase.this.importRelatedXmlModel(this.val$et2, this.val$xmlNode2);
            }
        });
        return ET;
    }

    protected void importCurXmlModel(ET ET, XmlNode xmlNode) throws Exception {
        DataObject.fromXmlNode(ET, (XmlNode)xmlNode);
        this.onImportCurXmlModel(ET, xmlNode);
    }

    protected void onImportCurXmlModel(ET ET, XmlNode xmlNode) throws Exception {
        CloneSession cloneSession = CloneSessionManager.getCurrentSession();
        this.createTemp(ET);
        Object object = ET.get(this.getDEModel().getKeyDEField().getName());
        cloneSession.setEntity(this.getDEModel(), object, ET);
        xmlNode.setAttribute(this.getDEModel().getKeyDEField().getName(), DataObject.getStringValue((Object)object));
    }

    protected void importRelatedXmlModel(ET ET, XmlNode xmlNode) throws Exception {
        this.onImportRelatedXmlModel(ET, xmlNode);
    }

    protected void onImportRelatedXmlModel(ET ET, XmlNode xmlNode) throws Exception {
    }

    public IDAO getDAO() {
        return null;
    }

    public void getTempMajor(ET ET) throws Exception {
        String string;
        JSONObject jSONObject;
        if (WebContext.getCurrent() != null && (jSONObject = WebContext.getActiveData()) != null && !StringHelper.isNullOrEmpty((String)(string = jSONObject.optString("srfkey")))) {
            ET.set(this.getDEModel().getKeyDEField().getName(), (Object)string);
            this.getTemp((IEntity)ET);
            return;
        }
        super.getTempMajor(ET);
    }

    protected void syncSysTask(ET ET, boolean bl) throws Exception {
        if (StringHelper.compare((String)this.getDEModel().getName(), (String)"PSSYSTASK", (boolean)true) == 0) {
            return;
        }
        if (this.getDEModel().getDEField("TODOTASK", true) != null) {
            if (!bl && !ET.contains("TODOTASK")) {
                return;
            }
            Object object = this.getDataContextValue((IEntity)ET, "pssystemid", null);
            if (object == null) {
                object = DataContextMethod.getValue((String)"pssystemid", (SessionFactory)this.getSessionFactory());
            }
            if (object == null) {
                object = PSCoreSysServiceBase.getCurrentPSSystemId();
            }
            if (object == null) {
                throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7cfb\u7edf");
            }
            PSSysTaskService pSSysTaskService = (PSSysTaskService)ServiceGlobal.getService(PSSysTaskService.class, (SessionFactory)this.getSessionFactory());
            String string = KeyValueHelper.genUniqueId((String)this.getDEModel().getId(), (String)((String)object), (String)DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName())));
            PSSysTask pSSysTask = new PSSysTask();
            pSSysTask.setPSSysTaskId(string);
            boolean bl2 = false;
            if (pSSysTaskService.checkKey(pSSysTask) == 1) {
                bl2 = true;
            }
            String string2 = DataObject.getStringValue((Object)ET.get("TODOTASK"));
            if (bl || StringHelper.isNullOrEmpty((String)string2)) {
                if (bl2) {
                    pSSysTaskService.remove((IEntity)pSSysTask);
                }
            } else {
                pSSysTask.setModelTypeId(this.getDEModel().getName());
                pSSysTask.setModelTypeName(this.getDEModel().getLogicName());
                pSSysTask.setPSObjId(DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName())));
                pSSysTask.setPSObjName(this.getDEModel().getDataInfo(ET));
                pSSysTask.setPSSystemId((String)object);
                pSSysTask.setPSDEId(DataObject.getStringValue((Object)ET.get("PSDEID")));
                pSSysTask.setPSDEName(DataObject.getStringValue((Object)ET.get("PSDENAME")));
                pSSysTask.setPSSysAppId(DataObject.getStringValue((Object)ET.get("PSSYSAPPID")));
                pSSysTask.setPSSysAppName(DataObject.getStringValue((Object)ET.get("PSSYSAPPNAME")));
                if (this.getDEModel().getDEField("PSSYSREQITEMID", true) != null) {
                    pSSysTask.setPSSysReqItemId(DataObject.getStringValue((Object)ET.get("PSSYSREQITEMID")));
                    pSSysTask.setPSSysReqItemName(DataObject.getStringValue((Object)ET.get("PSSYSREQITEMNAME")));
                }
                pSSysTask.setToDoTaskInfo(string2);
                if (string2.length() > 100) {
                    pSSysTask.setPSSysTaskName(string2.substring(0, 90) + "...");
                } else {
                    pSSysTask.setPSSysTaskName(string2);
                }
                if (bl2) {
                    pSSysTaskService.update(pSSysTask, false);
                } else {
                    pSSysTaskService.create(pSSysTask, false);
                }
            }
        }
    }

    public static void setCurrentPSDevSlnId(String string) {
        if (StringHelper.isNullOrEmpty((String)string)) {
            curPSDevSlnId.set(null);
        } else {
            curPSDevSlnId.set(string);
        }
    }

    public static String getCurrentPSDevSlnId() {
        return curPSDevSlnId.get();
    }

    public static void setCurrentPSDevSlnSysId(String string) {
        if (StringHelper.isNullOrEmpty((String)string)) {
            curPSDevSlnSysId.set(null);
        } else {
            curPSDevSlnSysId.set(string);
        }
    }

    public static String getCurrentPSDevSlnSysId() {
        return curPSDevSlnSysId.get();
    }

    public static void setCurrentPSDynaInstId(String string) {
        if (StringHelper.isNullOrEmpty((String)string)) {
            curPSDynaInstId.set(null);
        } else {
            curPSDynaInstId.set(string);
        }
    }

    public static String getCurrentPSDynaInstId() {
        return curPSDynaInstId.get();
    }

    public static void setCurrentPSSystemId(String string) {
        if (StringHelper.isNullOrEmpty((String)string)) {
            curPSSystemId.set(null);
        } else {
            curPSSystemId.set(string);
        }
    }

    public static String getCurrentPSSystemId() {
        return curPSSystemId.get();
    }

    public static void setCurrentPSDCId(String string) {
        if (StringHelper.isNullOrEmpty((String)string)) {
            curPSDCId.set(null);
        } else {
            curPSDCId.set(string);
        }
    }

    public static String getCurrentPSDCId() {
        return curPSDCId.get();
    }

    public static void setCurrentPSSvrDomainId(String string) {
        strPSSvrDomainId = string;
    }

    public static String getCurrentPSSvrDomainId() {
        return strPSSvrDomainId;
    }

    public static void setDefaultPSSvrDomainId(String string) {
        strPSSvrDomainId = string;
    }

    public static String getDefaultPSSvrDomainId() {
        return strPSSvrDomainId;
    }

    public static void setRecyclePSDCId(String string) {
        strRecyclePSDCId = string;
    }

    public static String getRecyclePSDCId() {
        return strRecyclePSDCId;
    }

    public static boolean isPrivateCloudMode() {
        return bPrivateCloudMode;
    }

    public static void setPrivateCloudMode(boolean bl) {
        bPrivateCloudMode = bl;
    }

    public static boolean isCloudMode() {
        return bCloudMode;
    }

    public static void setCloudMode(boolean bl) {
        bCloudMode = bl;
    }

    public static String getProxyTaskServerUrl() {
        return strProxyTaskServerUrl;
    }

    public static void setProxyTaskServerUrl(String string) {
        strProxyTaskServerUrl = string;
    }

    public static boolean isMOSMode() {
        return bMOSMode;
    }

    public static void setMOSMode(boolean bl) {
        bMOSMode = bl;
    }

    public static int getMOSVer() {
        return nMOSVersion;
    }

    public static void setMOSVer(int n) {
        nMOSVersion = n;
    }

    public static void setCurMajorSessionFactory(SessionFactory sessionFactory) {
        curMajorSessionFactory.set(sessionFactory);
    }

    public static SessionFactory getCurMajorSessionFactory() {
        return curMajorSessionFactory.get();
    }

    public static boolean isMajorSessionFactory(SessionFactory sessionFactory) {
        return PSCoreSysServiceBase.getCurMajorSessionFactory() == sessionFactory;
    }

    public static void reloadHotCodes() throws Exception {
        psModelHotCodeHelper.reloadHotCodes();
    }

    public static void beginImpSysModel(PSSystem pSSystem) {
        impSysModelSystem.set(pSSystem);
    }

    public static void endImpSysModel() {
        PSCoreSysServiceBase.endImpSysModel(false);
    }

    public static void endImpSysModel(boolean bl) {
        PSCoreSysServiceBase pSCoreSysServiceBase;
        PSSystem pSSystem = impSysModelSystem.get();
        if (pSSystem == null) {
            return;
        }
        impSysModelSystem.set(null);
        if (bl) {
            return;
        }
        try {
            pSCoreSysServiceBase = (PSSysModelLogService)ServiceGlobal.getService(PSSysModelLogService.class, (SessionFactory)pSSystem.getSessionFactory());
            for (String string : sysModelLogMap.keySet()) {
                PSSysModelLog pSSysModelLog = new PSSysModelLog();
                pSSysModelLog.setPSSystemId(pSSystem.getPSSystemId());
                pSSysModelLog.setPSSystemName("(N/A)");
                pSSysModelLog.setPSSysModelLogName(string);
                pSCoreSysServiceBase.save((IEntity)pSSysModelLog, false);
            }
        }
        catch (Exception exception) {
            log.error((Object)exception.getMessage(), (Throwable)exception);
        }
        try {
            String string;
            pSCoreSysServiceBase = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)pSSystem.getSessionFactory());
            String string2 = StringHelper.format((String)"UPDATE T_SRFPSSYSTEM SET MODELVER=MODELVER+1 WHERE PSSYSTEMID=?");
            string = new SqlParamList();
            string.add((Object)pSSystem.getPSSystemId(), 25);
            ((PSSystemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, string2, (SqlParamList)string);
        }
        catch (Exception exception) {
            log.error((Object)exception.getMessage(), (Throwable)exception);
        }
    }

    public static boolean isImpSysModelNow() {
        IEntity iEntity = (IEntity)impSysModelSystem.get();
        return iEntity != null;
    }

    public static boolean isImpSysModelNowEx() {
        IEntity iEntity = (IEntity)impSysModelSystem.get();
        return iEntity != null || ImportSessionManager.getCurrentSession() != null;
    }

    protected String onImportCurModel(ET ET, JSONObject jSONObject) throws Exception {
        if (!PSCoreSysServiceBase.isImpSysModelNow()) {
            return super.onImportCurModel(ET, jSONObject);
        }
        IDataEntityModel iDataEntityModel = this.getDEModel();
        IEntity iEntity = iDataEntityModel.createEntity();
        iEntity.set(iDataEntityModel.getKeyDEField().getName(), ET.get(iDataEntityModel.getKeyDEField().getName()));
        if (this.get(iEntity, true)) {
            if (!PSCoreSysServiceBase.diffDEData(iDataEntityModel, ET, iEntity)) {
                this.setLast((IEntity)ET, iEntity, true);
                this.update(ET, false);
            }
        } else {
            this.create(ET, false);
        }
        return null;
    }

    public static boolean diffDEData(IDataEntityModel iDataEntityModel, IEntity iEntity, IEntity iEntity2) throws Exception {
        Iterator iterator = iDataEntityModel.getDEFields();
        while (iterator.hasNext()) {
            IDEField iDEField = (IDEField)iterator.next();
            if (!iDEField.isPhisicalDEField() || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"CREATEDATE", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"CREATEMAN", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"CREATEMANNAME", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"LOGICVALID", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"UPDATEDATE", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"UPDATEMAN", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getPreDefinedType(), (String)"UPDATEMANNAME", (boolean)true) == 0 || StringHelper.compare((String)iDEField.getDataType(), (String)"PICKUP", (boolean)true) == 0) continue;
            Object object = iEntity.get(iDEField.getName());
            Object object2 = iEntity2.get(iDEField.getName());
            if (object == null && object2 == null || object != null && object2 != null && DataTypeHelper.compare((int)iDEField.getStdDataType(), (Object)object, (Object)object2) == 0L) continue;
            return false;
        }
        return true;
    }

    public static PSSystem getCurrentPSSystem(SessionFactory sessionFactory) throws Exception {
        return PSCoreSysServiceBase.getCurrentPSSystem(null, sessionFactory);
    }

    public static PSSystem getCurrentPSSystem(IEntity iEntity, SessionFactory sessionFactory) throws Exception {
        return PSCoreSysServiceBase.getCurrentPSSystem(iEntity, sessionFactory, false);
    }

    public static PSSystem getCurrentPSSystem(IEntity iEntity, SessionFactory sessionFactory, boolean bl) throws Exception {
        Object object;
        Object object2;
        Object object3 = PSCoreSysServiceBase.getCurrentPSSystemId();
        if (object3 == null && iEntity != null) {
            object3 = iEntity.get("pssystemid");
        }
        if (object3 == null) {
            object3 = DataContextMethod.getValue((String)"pssystemid", (SessionFactory)sessionFactory);
        }
        if (object3 == null) {
            if (bl) {
                return null;
            }
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7cfb\u7edf\u6807\u8bc6");
        }
        String string = StringHelper.format((String)"SYS_%1$s_%2$s", (Object)object3, (Object)sessionFactory);
        IWebContext iWebContext = net.ibizsys.paas.web.WebContext.getCurrent();
        if (iWebContext != null) {
            object2 = iWebContext.getAttribute(string);
            if (object2 != null) {
                return (PSSystem)object2;
            }
        } else {
            object2 = ActionSessionManager.getCurrentSession((boolean)false);
            if (object2 != null && (object = object2.getActionParam(string)) != null) {
                return (PSSystem)object;
            }
        }
        object2 = new PSSystem();
        object = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)sessionFactory);
        ((PSSystemBase)object2).setPSSystemId((String)object3);
        object.get((IEntity)object2);
        if (iWebContext != null) {
            iWebContext.setAttribute(string, object2);
        } else {
            object = ActionSessionManager.getCurrentSession((boolean)false);
            if (object != null) {
                object.setActionParam(string, object2);
            }
        }
        return object2;
    }

    public static PSSysSFPub getCurrentDefaultPSSysSFPub(IEntity iEntity, SessionFactory sessionFactory) throws Exception {
        Object object;
        Object object2;
        PSSystem pSSystem = PSCoreSysServiceBase.getCurrentPSSystem(iEntity, sessionFactory, true);
        if (pSSystem == null) {
            return null;
        }
        String string = StringHelper.format((String)"SYSSFPUB_%1$s_%2$s", (Object)pSSystem.getPSSystemId(), (Object)sessionFactory);
        IWebContext iWebContext = net.ibizsys.paas.web.WebContext.getCurrent();
        if (iWebContext != null) {
            object2 = iWebContext.getAttribute(string);
            if (object2 != null) {
                if (invalidPSSysSFPub == object2) {
                    return null;
                }
                return (PSSysSFPub)object2;
            }
        } else {
            object2 = ActionSessionManager.getCurrentSession((boolean)false);
            if (object2 != null && (object = object2.getActionParam(string)) != null) {
                if (invalidPSSysSFPub == object) {
                    return null;
                }
                return (PSSysSFPub)object;
            }
        }
        object2 = new PSSysSFPub();
        object = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)sessionFactory);
        ((PSSysSFPubBase)object2).setPSSystemId(pSSystem.getPSSystemId());
        ((PSSysSFPubBase)object2).setDefaultPub(1);
        if (!object.selectOne((IEntity)object2, true)) {
            object2 = invalidPSSysSFPub;
        }
        if (iWebContext != null) {
            iWebContext.setAttribute(string, object2);
        } else {
            object = ActionSessionManager.getCurrentSession((boolean)false);
            if (object != null) {
                object.setActionParam(string, object2);
            }
        }
        if (invalidPSSysSFPub == object2) {
            return null;
        }
        return object2;
    }

    public static boolean isExtractDefault(SessionFactory sessionFactory) throws Exception {
        PSSystem pSSystem = PSCoreSysServiceBase.getCurrentPSSystem(null, sessionFactory);
        return DataObject.getBoolValue((Integer)pSSystem.getExtractDefault(), (boolean)false);
    }

    public void copyDetails(ET ET, Object object) throws Exception {
        String string = denyCopyMap.get(this.getDEModel().getName());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            IEntity iEntity;
            IPSDEFieldModel iPSDEFieldModel = this.getDEModel().getDEField(string, false);
            Object object2 = ET.get(string);
            if (StringHelper.isNullOrEmpty((Object)object2)) {
                iEntity = this.getDEModel().createEntity();
                iEntity.set(this.getDEModel().getKeyDEField().getName(), ET.get(this.getDEModel().getKeyDEField().getName()));
                this.get(iEntity);
                object2 = ET.get(string);
            }
            iEntity = this.getDEModel().createEntity();
            iEntity.set(this.getDEModel().getKeyDEField().getName(), object);
            this.get(iEntity);
            Object object3 = iEntity.get(string);
            if (DataTypeHelper.compare((int)iPSDEFieldModel.getStdDataType(), (Object)object3, (Object)object2) != 0L) {
                throw new Exception(StringHelper.format((String)"[%1$s]\u4e0d\u80fd\u8de8[%2$s]\u62f7\u8d1d", (Object)this.getDEModel().getLogicName(), (Object)iPSDEFieldModel.getLogicName()));
            }
        }
        super.copyDetails(ET, object);
    }

    protected void resetPSSysModelLogs(String string) {
        try {
            PSSysModelLogService pSSysModelLogService = (PSSysModelLogService)ServiceGlobal.getService(PSSysModelLogService.class, (SessionFactory)this.getSessionFactory());
            String string2 = StringHelper.format((String)"UPDATE T_SRFPSSYSMODELLOG SET UPDATEDATE = ? WHERE PSSYSTEMID=?");
            SqlParamList sqlParamList = new SqlParamList();
            sqlParamList.addDateTime((Object)new Timestamp(System.currentTimeMillis()));
            sqlParamList.add((Object)string, 25);
            pSSysModelLogService.getDAO().executeRawSql(null, string2, sqlParamList);
        }
        catch (Exception exception) {
            log.error((Object)exception.getMessage(), (Throwable)exception);
        }
    }

    protected void logSysConsole(String string, String string2, String string3) {
        try {
            PSSysConsole pSSysConsole = new PSSysConsole();
            if (StringHelper.isNullOrEmpty((String)string2)) {
                string2 = this.getDEModel().getLogicName();
            }
            if (StringHelper.length((String)string3) > 4000) {
                string3 = string3.substring(0, 3920) + "...";
            }
            if (StringHelper.compare((String)string, (String)"INFO", (boolean)false) == 0) {
                log.info((Object)StringHelper.format((String)"[CONSOLE][%1$s]%2$s", (Object)string2, (Object)string3));
            } else if (StringHelper.compare((String)string, (String)"WARN", (boolean)false) == 0) {
                log.warn((Object)StringHelper.format((String)"[CONSOLE][%1$s]%2$s", (Object)string2, (Object)string3));
            } else if (StringHelper.compare((String)string, (String)"ERROR", (boolean)false) == 0) {
                log.error((Object)StringHelper.format((String)"[CONSOLE][%1$s]%2$s", (Object)string2, (Object)string3));
            }
            pSSysConsole.setLogTime(new Timestamp(System.currentTimeMillis()));
            pSSysConsole.setPSSysConsoleName(string2);
            pSSysConsole.setLogLevel(string);
            pSSysConsole.setLogInfo(string3);
            String string4 = PSCoreSysServiceBase.getCurrentPSSystemId();
            if (StringHelper.isNullOrEmpty((String)string4)) {
                string4 = (String)DataContextMethod.getValue((String)"pssystemid", (SessionFactory)this.getSessionFactory());
            }
            if (StringHelper.isNullOrEmpty((String)string4)) {
                string4 = "2C40DFCD-0DF5-47BF-91A5-C45F810B0001";
            }
            pSSysConsole.setPSSystemId(string4);
            pSSysConsole.setPSSystemName("\u7cfb\u7edf\u540d\u79f0");
            PSSysConsoleService pSSysConsoleService = (PSSysConsoleService)ServiceGlobal.getService(PSSysConsoleService.class, (SessionFactory)this.getSessionFactory());
            pSSysConsoleService.create(pSSysConsole, false);
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
    }

    public ISysConsole getConsole() {
        return this.iSysConsole;
    }

    protected void onExportCurModel(ET ET, ArrayList<JSONObject> arrayList, int n) throws Exception {
        ET.remove("CREATEDATE");
        ET.remove("CREATEMAN");
        ET.remove("UPDATEMAN");
        ET.remove("UPDATEDATE");
        ET.remove("LOCKFLAG");
        super.onExportCurModel(ET, arrayList, n);
    }

    protected String getCurrentPSSystemId(IEntity iEntity) throws Exception {
        return this.getCurrentPSSystemId(iEntity, false);
    }

    protected String getCurrentPSSystemId(IEntity iEntity, boolean bl) throws Exception {
        Object object = null;
        if (object == null && iEntity != null) {
            object = iEntity.get("pssystemid");
        }
        if (object == null) {
            object = PSCoreSysServiceBase.getCurrentPSSystemId();
        }
        if (object == null && iEntity != null) {
            object = this.getDataContextValue(iEntity, "pssystemid", null);
        }
        if (object == null) {
            object = DataContextMethod.getValue((String)"pssystemid", (SessionFactory)this.getSessionFactory());
        }
        if (object == null) {
            if (bl) {
                return null;
            }
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7cfb\u7edf\u6807\u8bc6");
        }
        return (String)object;
    }

    protected String getCurrentPSDevSlnSysId(IEntity iEntity, boolean bl) throws Exception {
        Object object = null;
        if (object == null && iEntity != null) {
            object = iEntity.get("psdevslnsysid");
        }
        if (object == null) {
            object = PSCoreSysServiceBase.getCurrentPSDevSlnSysId();
        }
        if (object == null && WebContext.getAppData() != null) {
            object = WebContext.getAppData().opt("psdevslnsysid");
        }
        if (object == null) {
            if (bl) {
                return null;
            }
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf\u6807\u8bc6");
        }
        return (String)object;
    }

    protected String getCurrentPSDynaInstId(IEntity iEntity, boolean bl) throws Exception {
        Object object = null;
        if (object == null && iEntity != null) {
            object = iEntity.get("psdynainstid");
        }
        if (object == null) {
            object = PSCoreSysServiceBase.getCurrentPSDynaInstId();
        }
        if (object == null && WebContext.getAppData() != null) {
            object = WebContext.getAppData().opt("psdynainstid");
        }
        if (object == null) {
            if (bl) {
                return null;
            }
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u52a8\u6001\u5b9e\u4f8b\u6807\u8bc6");
        }
        return (String)object;
    }

    protected String getRemoveRejectMsg(String string, String string2, String string3, String string4, String string5, Object object) throws Exception {
        String string6 = string2;
        if (StringHelper.isNullOrEmpty((String)string6)) {
            String string7;
            IDataEntityModel iDataEntityModel = this.getSystemModel().getDataEntityModel(string4);
            string6 = iDataEntityModel.getLogicName();
            if (PSCoreSysServiceBase.isMOSMode() && PSModelV2Helper.containsModelV2(string4)) {
                if (object != null && object instanceof IEntity) {
                    IPSMOSFileService iPSMOSFileService = (IPSMOSFileService)iDataEntityModel.getService(this.getSessionFactory());
                    IEntity iEntity = iDataEntityModel.createEntity();
                    ((IEntity)object).copyTo((IDataObject)iEntity, false);
                    PSMOSFile pSMOSFile = iPSMOSFileService.getFile(iEntity);
                    string6 = StringHelper.format((String)"[%1$s]%2$s", (Object)string6, (Object)pSMOSFile.getPSMOSFileId());
                }
            } else if (object != null && object instanceof IEntity && !StringHelper.isNullOrEmpty((String)(string7 = this.getRemoveRejectMsgRefDataInfo(iDataEntityModel, object)))) {
                string6 = StringHelper.format((String)"%1$s-%2$s", (Object)string6, (Object)string7);
            }
        }
        return this.getLocalization("CTRL.SERVICE.GETREMOVEREJECTMSG_INFO", new Object[]{this.getSystemModel().getDataEntityModel(string3).getLogicName(), string5, string6}, StringHelper.format((String)"%1$s[%2$s]\u5b58\u5728\u5173\u7cfb\u6570\u636e[%3$s]\uff0c\u65e0\u6cd5\u5220\u9664\uff01", (Object)this.getSystemModel().getDataEntityModel(string3).getLogicName(), (Object)string5, (Object)string6));
    }

    protected String getRemoveRejectMsgRefDataInfo(IDataEntityModel iDataEntityModel, Object object) throws Exception {
        if (object != null && object instanceof IEntity) {
            StringBuilderEx stringBuilderEx = new StringBuilderEx();
            if (object instanceof PSDEDSDQ) {
                PSDEDSDQ pSDEDSDQ = (PSDEDSDQ)object;
                PSDEDataSet pSDEDataSet = pSDEDSDQ.getPSDEDataSet();
                PSDataEntity pSDataEntity = pSDEDataSet.getPSDE();
                if (pSDataEntity != null) {
                    stringBuilderEx.append("%1$s/", (Object)pSDataEntity.getPSDataEntityName());
                }
                if (pSDEDataSet != null) {
                    stringBuilderEx.append("%1$s/", (Object)pSDEDataSet.getPSDEDataSetName());
                }
            } else if (object instanceof PSDEFormDetail) {
                PSDEFormDetail pSDEFormDetail = (PSDEFormDetail)object;
                PSDEForm pSDEForm = pSDEFormDetail.getPSDEForm();
                PSDataEntity pSDataEntity = pSDEForm.getPSDE();
                if (pSDataEntity != null) {
                    stringBuilderEx.append("%1$s/", (Object)pSDataEntity.getPSDataEntityName());
                }
                if (pSDEForm != null) {
                    stringBuilderEx.append("%1$s/", (Object)pSDEForm.getPSDEFormName());
                }
            } else if (object instanceof PSDEGridCol) {
                PSDEGridCol pSDEGridCol = (PSDEGridCol)object;
                PSDEGrid pSDEGrid = pSDEGridCol.getPSDEGrid();
                PSDataEntity pSDataEntity = pSDEGrid.getPSDE();
                if (pSDataEntity != null) {
                    stringBuilderEx.append("%1$s/", (Object)pSDataEntity.getPSDataEntityName());
                }
                if (pSDEGrid != null) {
                    stringBuilderEx.append("%1$s/", (Object)pSDEGrid.getPSDEGridName());
                }
            } else if (object instanceof PSDEViewCtrl) {
                PSDEViewCtrl pSDEViewCtrl = (PSDEViewCtrl)object;
                PSDEViewBase pSDEViewBase = pSDEViewCtrl.getPSDEViewBase();
                PSDataEntity pSDataEntity = pSDEViewBase.getPSDE();
                if (pSDataEntity != null) {
                    stringBuilderEx.append("%1$s/", (Object)pSDataEntity.getPSDataEntityName());
                }
                if (pSDEViewBase != null) {
                    stringBuilderEx.append("%1$s/", (Object)pSDEViewBase.getPSDEViewBaseName());
                }
            }
            stringBuilderEx.append("%1$s", (Object)iDataEntityModel.getDataInfo((IEntity)object));
            return stringBuilderEx.toString();
        }
        return null;
    }

    public String getDataSummary(ET ET) throws Exception {
        String string = PSModelSummaryHelper.getPSModelSummary(this.getDEModel(), ET);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return string;
        }
        return super.getDataSummary(ET);
    }

    public void updateTempMajor(ET ET) throws Exception {
        if (this.isUseServiceAPI()) {
            this.getServiceAPIClientModel().execute(this.getDEModel().getServiceAPIActionTag("DEACTION", "UPDATETEMPMAJOR"), ET);
            return;
        }
        ET ET2 = ET;
        ET2.setSessionFactory(this.getSessionFactory());
        Object object = ET.get("SRFSOURCEKEY");
        Object object2 = ET.get("SRFENTITYKEY");
        this.doServiceWork(new IServiceWork((IEntity)ET2, object2, object){
            final /* synthetic */ IEntity val$et2;
            final /* synthetic */ Object val$objEntityKey;
            final /* synthetic */ Object val$strSourceKey;
            {
                this.val$et2 = iEntity;
                this.val$objEntityKey = object;
                this.val$strSourceKey = object2;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                CloneSession cloneSession = CloneSessionManager.getCurrentSession();
                Object object = this.val$et2.get("srfupdatedate");
                PSCoreSysServiceBase.this.updateTemp(this.val$et2);
                IEntity iEntity = PSCoreSysServiceBase.this.getDEModel().createEntity();
                this.val$et2.copyTo((IDataObject)iEntity, false);
                iEntity.remove(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName());
                PSCoreSysServiceBase.this.replaceParentInfo(iEntity, cloneSession);
                Object object2 = new JSONObject();
                iEntity.fillJSONObject(object2, false);
                Object object3 = object2.keys();
                while (object3.hasNext()) {
                    String string = (String)object3.next();
                    Object object4 = object2.get(string);
                    if (object4 == null || !(object4 instanceof String) || !KeyValueHelper.isTempKey((String)((String)object4))) continue;
                    log.warn((Object)StringHelper.format((String)"\u4e34\u65f6\u6570\u636e[%1$s]\u5c5e\u6027[%2$s]\u4e3a\u4e34\u65f6\u6570\u636e", (Object)PSCoreSysServiceBase.this.getDEModel().getName(), (Object)string));
                    return;
                }
                object2 = this.val$et2.get("SRFORIKEY");
                if (this.val$objEntityKey != null) {
                    iEntity.set("SRFENTITYKEY", this.val$objEntityKey);
                }
                if (StringHelper.isNullOrEmpty((Object)object2)) {
                    PSCoreSysServiceBase.this.create(iEntity);
                    this.val$et2.set("SRFORIKEY", iEntity.get(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName()));
                    object3 = new HashMap();
                    iEntity.fillMap((HashMap)object3, false);
                    for (Object object4 : ((HashMap)object3).keySet()) {
                        Object object5;
                        Object v = ((HashMap)object3).get(object4);
                        if (!this.val$et2.contains((String)object4) || (object5 = this.val$et2.get((String)object4)) != null || v == null) continue;
                        this.val$et2.set((String)object4, v);
                    }
                    PSCoreSysServiceBase.this.updateTemp(this.val$et2);
                } else {
                    iEntity.set(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName(), object2);
                    if (object != null) {
                        iEntity.set("srfupdatedate", object);
                    }
                    if (PSCoreSysServiceBase.this.checkKey(iEntity) == 0) {
                        PSCoreSysServiceBase.this.create(iEntity);
                    } else {
                        PSCoreSysServiceBase.this.update(iEntity);
                    }
                    if (object != null) {
                        iEntity.set("srfupdatedate", object);
                    }
                }
                cloneSession.setEntity(PSCoreSysServiceBase.this.getDEModel(), this.val$et2.get(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName()), iEntity);
                PSCoreSysServiceBase.this.beginMergeChild(iEntity);
                PSCoreSysServiceBase.this.updateRelatedDataTempMajor(this.val$et2, iEntity);
                if (StringHelper.isNullOrEmpty((Object)object2) && !StringHelper.isNullOrEmpty((Object)this.val$strSourceKey)) {
                    PSCoreSysServiceBase.this.copyDetails(iEntity, this.val$strSourceKey);
                }
                PSCoreSysServiceBase.this.endMergeChild(iEntity, true);
                PSCoreSysServiceBase.this.onAfterUpdateTempMajor(iEntity);
                this.val$et2.set(PSCoreSysServiceBase.this.getDEModel().getUpdateDateDEField().getName(), iEntity.get(PSCoreSysServiceBase.this.getDEModel().getUpdateDateDEField().getName()));
            }
        });
    }

    public boolean fillEntityKeyValue(ET ET, boolean bl) throws Exception {
        if (PSCoreSysModel.isEnableFolderKey() && !bl && this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            String string = this.getDEModel().getKeyDEField().getName();
            Object object = ET.get(string);
            if (object != null) {
                return true;
            }
            if (!this.isIgnoreFolderKey(ET)) {
                boolean bl2 = false;
                PSSystem pSSystem = PSCoreSysServiceBase.getCurrentPSSystem(ET, this.getSessionFactory(), true);
                if (pSSystem != null && DataObject.getBoolValue((Integer)pSSystem.getEnableFolderKey(), (boolean)false)) {
                    bl2 = true;
                }
                if (bl2 && (object = this.getEntityFolderKeyValue(ET, pSSystem)) != null) {
                    ET.set(string, object);
                    return true;
                }
            }
        }
        return super.fillEntityKeyValue(ET, bl);
    }

    protected String getEntityFolderKeyValue(ET ET, PSSystem pSSystem) throws Exception {
        return PSModelFolderKeyHelper.getModelKey(ET, pSSystem, this.getDEModel().getName(), "", this.getSessionFactory());
    }

    protected boolean isIgnoreFolderKey(ET ET) {
        return PSModelFolderKeyHelper.isIgnoreModel(this.getDEModel().getName());
    }

    protected boolean isEnableFolderKey(IEntity iEntity) throws Exception {
        return false;
    }

    protected boolean isEnableNoViewMode(IEntity iEntity) throws Exception {
        PSSystem pSSystem = PSCoreSysServiceBase.getCurrentPSSystem(iEntity, this.getSessionFactory());
        return DataObject.getBoolValue((Integer)pSSystem.getNoViewMode(), (boolean)false);
    }

    protected boolean isEnableHBaseModelInst() {
        return false;
    }

    protected CallResult internalGetTemp(ET ET, boolean bl) throws Exception {
        try {
            return super.internalGetTemp(ET, bl);
        }
        catch (Exception exception) {
            IPSDBServerSessionFactory iPSDBServerSessionFactory;
            if (this.getRealSessionFactory() instanceof IPSDBServerSessionFactory && StringHelper.compare((String)(iPSDBServerSessionFactory = (IPSDBServerSessionFactory)this.getRealSessionFactory()).getRealDBName(), (String)"SRFNODB", (boolean)false) != 0) {
                log.error((Object)StringHelper.format((String)"\u67e5\u8be2\u4e34\u65f6\u6570\u636e\u53d1\u751f\u5f02\u5e38\uff0c\u5f53\u524d\u6570\u636e\u6e90[%1$s]\uff0c%2$s", (Object)iPSDBServerSessionFactory.getRealDBName(), (Object)exception.getMessage()), (Throwable)exception);
            }
            throw exception;
        }
    }

    protected CallResult internalGet(ET ET, boolean bl, int n) throws Exception {
        return super.internalGet(ET, bl, n);
    }

    protected void internalCreate(ET ET) throws Exception {
        super.internalCreate(ET);
    }

    protected void internalUpdate(ET ET) throws Exception {
        super.internalUpdate(ET);
        this.updateModelKeeper(ET);
    }

    protected void internalSysUpdate(ET ET) throws Exception {
        super.internalSysUpdate(ET);
        this.logSysModelChanged(ET, "UPDATE");
        this.logModelObjChanged(ET, "UPDATE");
        this.updateModelKeeper(ET);
    }

    protected void internalRemove(ET ET) throws Exception {
        super.internalRemove(ET);
        this.removeModelKeeper(ET);
    }

    protected ArrayList<ET> internalSelect(ISelectCond iSelectCond) throws Exception {
        return super.internalSelect(iSelectCond);
    }

    public int checkKey(ET ET) throws Exception {
        return super.checkKey(ET);
    }

    public void save(ET ET, int n, boolean bl) throws Exception {
        super.save(ET, n, bl);
    }

    @Override
    public void create(ET ET, boolean bl) throws Exception {
        String string;
        if (PSCoreSysServiceBase.getCurrentPSSystemId() != null && !StringHelper.isNullOrEmpty((String)(string = PSCoreSysServiceBase.getCurrentPSSystemId())) && StringHelper.compare((String)this.getDEModel().getName(), (String)"PSSYSTEM", (boolean)false) != 0 && this.getDEModel().getDEField("PSSYSTEMID", true) != null) {
            ET.set("PSSYSTEMID", (Object)string);
        }
        boolean bl2 = EntityBase.isIgnoreCheck(ET);
        try {
            super.create(ET, bl);
        }
        catch (Exception exception) {
            Iterator iterator;
            EntityException entityException;
            if (exception instanceof EntityException && (entityException = (EntityException)exception).getErrorCode() == 6 && (iterator = this.getDEModel().getUnionKeyValueDEFields()) != null) {
                EntityFieldError entityFieldError;
                Object object;
                EntityError entityError = new EntityError();
                while (iterator.hasNext()) {
                    object = (IDEField)iterator.next();
                    entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName(object.getName());
                    if (this.getWebContext() != null) {
                        entityFieldError.setFieldLogicName(object.getLogicName(this.getWebContext().getLocalization()));
                    } else {
                        entityFieldError.setFieldLogicName(object.getLogicName());
                    }
                    entityFieldError.setErrorType(3);
                    if ("PSSYSTEMID".equalsIgnoreCase(object.getName())) continue;
                    Object object2 = ET.get(object.getName());
                    entityFieldError.setErrorInfo(this.getLocalization("CTRL.SERVICE.CHECKFIELDDUPRULE_INFO", new Object[]{object2}, String.format("\u503c[%1$s]\u91cd\u590d", object2)));
                    entityError.register(entityFieldError);
                }
                object = this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb"));
                entityFieldError = ActionSessionManager.getCurrentSession();
                if (entityFieldError != null && StringHelper.compare((String)entityFieldError.getName(), (String)this.getDEModel().getName(), (boolean)true) != 0 && !StringHelper.isNullOrEmpty((String)(object = this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb"))))) {
                    object = StringHelper.format((String)"[%1$s]%2$s\u3002", (Object)this.getDEModel().getLogicName(), (Object)object);
                    object = (String)object + entityError.toString();
                    throw new EntityException(entityError, 6, (String)object, (IDataEntity)this.getDEModel());
                }
                throw new EntityException(entityError, 6, this.getLocalization("CTRL.SERVICE.CHECKKEYSTATE_EXIST", StringHelper.format((String)"\u6570\u636e\u5df2\u7ecf\u5b58\u5728\uff0c\u65e0\u6cd5\u518d\u6b21\u5efa\u7acb")), (IDataEntity)this.getDEModel());
            }
            throw exception;
        }
    }

    public void createTemp(ET ET) throws Exception {
        String string;
        if (PSCoreSysServiceBase.getCurrentPSSystemId() != null && !StringHelper.isNullOrEmpty((String)(string = PSCoreSysServiceBase.getCurrentPSSystemId())) && StringHelper.compare((String)this.getDEModel().getName(), (String)"PSSYSTEM", (boolean)false) != 0 && this.getDEModel().getDEField("PSSYSTEMID", true) != null) {
            ET.set("PSSYSTEMID", (Object)string);
        }
        super.createTemp(ET);
    }

    @Override
    public void update(ET ET, boolean bl) throws Exception {
        boolean bl2 = EntityBase.isIgnoreCheck(ET);
        super.update(ET, bl);
    }

    public void mergeChild(String string, String string2, Object object) throws Exception {
        if (PSCoreSysServiceBase.isImpSysModelNowEx() || this.getDEModel().isNoViewMode()) {
            return;
        }
        if (!PSCoreSysServiceBase.isEnableMergeCount() && StringHelper.compare((String)this.getDEModel().getName(), (String)"PSCODEITEM", (boolean)true) != 0) {
            return;
        }
        super.mergeChild(string, string2, object);
    }

    protected DBFetchResult doServiceFetchWork(IDEDataSetFetchContext iDEDataSetFetchContext, String string, boolean bl) throws Exception {
        DBFetchResult dBFetchResult = super.doServiceFetchWork(iDEDataSetFetchContext, string, bl);
        if (dBFetchResult == null || dBFetchResult.getRetCode() != 0 || iDEDataSetFetchContext.isCacheDataSet()) {
            // empty if block
        }
        return dBFetchResult;
    }

    public void fillXmlNode(IEntity iEntity, XmlNode xmlNode, boolean bl) throws Exception {
        iEntity.set("ENABLE", null);
        iEntity.set("CREATEMAN", null);
        iEntity.set("CREATEDATE", null);
        iEntity.set("UPDATEMAN", null);
        iEntity.set("UPDATEDATE", null);
        iEntity.set("SRFORIKEY", null);
        iEntity.set("SRFDRAFTFLAG", null);
        iEntity.set("DYNAMODELFLAG", null);
        iEntity.set("PSDYNAINSTID", null);
        iEntity.fillXmlNode(xmlNode, bl);
    }

    public void updateParent(ET ET) throws Exception {
        if (ET == null) {
            return;
        }
        String string = (String)ET.get(this.getDEModel().getKeyDEField().getName());
        if (StringHelper.isNullOrEmpty((String)string)) {
            return;
        }
        if (KeyValueHelper.isTempKey((String)string) && StringHelper.compare((String)this.getDEModel().getName(), (String)"PSCODEITEM", (boolean)true) != 0) {
            return;
        }
        if (!PSCoreSysServiceBase.isEnableMergeCount() && StringHelper.compare((String)this.getDEModel().getName(), (String)"PSCODEITEM", (boolean)true) != 0) {
            return;
        }
        super.updateParent(ET);
    }

    public void getDraft(ET ET) throws Exception {
        Object object = ET.get(this.getDEModel().getKeyDEField().getName());
        if (!StringHelper.isNullOrEmpty((Object)object)) {
            this.getDraftFrom((IEntity)ET);
            return;
        }
        super.getDraft(ET);
        this.fillGetDraftDefaultValue(ET, false);
    }

    public void getDraftTemp(ET ET) throws Exception {
        Object object = ET.get(this.getDEModel().getKeyDEField().getName());
        if (!StringHelper.isNullOrEmpty((Object)object)) {
            this.getDraftTempFrom(ET);
            return;
        }
        super.getDraftTemp(ET);
        this.fillGetDraftDefaultValue(ET, true);
    }

    @Override
    public boolean existsData(ET ET) throws Exception {
        Map.Entry entry2;
        SelectContext selectContext = new SelectContext();
        HashMap hashMap = new HashMap();
        ET.fillMap(hashMap, true);
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (entry2.getValue() == null || entry2.getValue() == DataObject.EMPTY) {
                selectContext.setIsNull((String)entry2.getKey());
                continue;
            }
            selectContext.set((String)entry2.getKey(), entry2.getValue());
        }
        selectContext.setFetchFirst(true);
        String string = this.getDEModel().getKeyDEField().getName();
        selectContext.addSelectField(string);
        entry2 = this.select((ISelectCond)selectContext);
        if (((ArrayList)((Object)entry2)).size() == 0) {
            return false;
        }
        ET.set(string, ((IEntity)((ArrayList)((Object)entry2)).get(0)).get(string));
        return true;
    }

    public static void setEnableMergeCount(boolean bl) {
        bEnableMergeCount = bl;
    }

    public static boolean isEnableMergeCount() {
        return bEnableMergeCount;
    }

    public static void setEnableI18NDefault(boolean bl) {
        bEnableI18NDefault = bl;
    }

    public static boolean isEnableI18NDefault() {
        return bEnableI18NDefault;
    }

    public static void setEnableStateInformDefault(boolean bl) {
        bEnableStateInformDefault = bl;
    }

    public static boolean isEnableStateInformDefault() {
        return bEnableStateInformDefault;
    }

    public static void setEnableOPInfoInformDefault(boolean bl) {
        bEnableOPInfoInformDefault = bl;
    }

    public static boolean isEnableOPInfoInformDefault() {
        return bEnableOPInfoInformDefault;
    }

    public static void setEnableCurDCLimit(boolean bl) {
        bEnableCurDCLimit = bl;
    }

    public static void setThreadCurDCLimit(boolean bl) {
        threadCurDCLimit.set(bl);
    }

    public static boolean isEnableCurDCLimit() {
        return bEnableCurDCLimit || threadCurDCLimit.get() != null && threadCurDCLimit.get() != false;
    }

    public static void setEnableCurDevSlnLimit(boolean bl) {
        bEnableCurDevSlnLimit = bl;
    }

    public static void setThreadCurDevSlnLimit(boolean bl) {
        threadCurDevSlnLimit.set(bl);
    }

    public static boolean isEnableCurDevSlnLimit() {
        return bEnableCurDevSlnLimit || threadCurDevSlnLimit.get() != null && threadCurDevSlnLimit.get() != false;
    }

    public static void setEnablePaaSAdminLimit(boolean bl) {
        bEnablePaaSAdminLimit = bl;
    }

    public static boolean isEnablePaaSAdminLimit() {
        return bEnablePaaSAdminLimit;
    }

    public static void setThreadEnableCodeNameUpperCamel(Boolean bl) {
        threadCodeNameUpperCamel.set(bl);
    }

    public static boolean isEnableCodeNameUpperCamel() {
        Boolean bl = threadCodeNameUpperCamel.get();
        if (bl != null) {
            return bl;
        }
        return bEnableCodeNameUpperCamel;
    }

    public static void setEnableCodeNameUpperCamel(boolean bl) {
        bEnableCodeNameUpperCamel = bl;
    }

    public static String toUpperCamel(String string) {
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, string);
    }

    public static boolean isEnableGitBranch() {
        if (bEnableGitBranch == null) {
            bEnableGitBranch = false;
            if (WebConfig.getCurrent() != null) {
                String string = WebConfig.getCurrent().getAttribute("GITBRANCH", "FALSE");
                if (StringHelper.isNullOrEmpty((String)string)) {
                    string = "FALSE";
                }
                if (StringHelper.compare((String)string, (String)"TRUE", (boolean)true) == 0) {
                    bEnableGitBranch = true;
                }
            }
        }
        return bEnableGitBranch;
    }

    public static void setEnableGitBranch(boolean bl) {
        bEnableGitBranch = bl;
    }

    public static String getModelFormat() {
        if (strModelFormat == null) {
            strModelFormat = "JSON";
            if (WebConfig.getCurrent() != null) {
                String string = WebConfig.getCurrent().getAttribute("MODELFORMAT", "JSON");
                if (StringHelper.isNullOrEmpty((String)string)) {
                    string = "JSON";
                }
                strModelFormat = string;
            }
        }
        return strModelFormat;
    }

    public static void setModelFormat(String string) {
        strModelFormat = string;
    }

    public static void setEnableGitLabPlugin(boolean bl) {
        bEnableGitLabPlugin = bl;
    }

    public static boolean isEnableGitLabPlugin() {
        if (bEnableGitLabPlugin == null) {
            bEnableGitLabPlugin = false;
            if (WebConfig.getCurrent() != null) {
                String string = WebConfig.getCurrent().getAttribute("GITLABPLUGIN", "FALSE");
                if (StringHelper.isNullOrEmpty((String)string)) {
                    string = "FALSE";
                }
                if (StringHelper.compare((String)string, (String)"FALSE", (boolean)true) == 0) {
                    bEnableGitLabPlugin = false;
                } else if (StringHelper.compare((String)string, (String)"TRUE", (boolean)true) == 0) {
                    bEnableGitLabPlugin = true;
                    if (iPSGitLabPlugin == null) {
                        iPSGitLabPlugin = new PSGitLabPluginImpl();
                    }
                } else {
                    try {
                        Object object = ObjectHelper.create((String)string);
                        if (!(object instanceof IPSGitLabPlugin)) {
                            throw new Exception(StringHelper.format((String)"\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e"));
                        }
                        bEnableGitLabPlugin = true;
                        iPSGitLabPlugin = (IPSGitLabPlugin)object;
                    }
                    catch (Exception exception) {
                        log.error((Object)StringHelper.format((String)"\u5efa\u7acbGitLab\u63d2\u4ef6\u5bf9\u8c61[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), (Throwable)exception);
                    }
                }
            }
        }
        return bEnableGitLabPlugin != false && PSCoreSysServiceBase.getPSGitLabPlugin() != null;
    }

    public static void setPSGitLabPlugin(IPSGitLabPlugin iPSGitLabPlugin) {
        PSCoreSysServiceBase.iPSGitLabPlugin = iPSGitLabPlugin;
    }

    public static IPSGitLabPlugin getPSGitLabPlugin() {
        return iPSGitLabPlugin;
    }

    public static void setEnableKafkaPlugin(boolean bl) {
        bEnableKafkaPlugin = bl;
    }

    public static boolean isEnableKafkaPlugin() {
        if (bEnableKafkaPlugin == null) {
            bEnableKafkaPlugin = false;
            if (WebConfig.getCurrent() != null) {
                String string = WebConfig.getCurrent().getAttribute("KAFKAPLUGIN", "FALSE");
                if (StringHelper.isNullOrEmpty((String)string)) {
                    string = "FALSE";
                }
                if (StringHelper.compare((String)string, (String)"FALSE", (boolean)true) == 0) {
                    bEnableKafkaPlugin = false;
                } else if (StringHelper.compare((String)string, (String)"TRUE", (boolean)true) == 0) {
                    bEnableKafkaPlugin = true;
                    if (iPSKafkaPlugin == null) {
                        iPSKafkaPlugin = new PSKafkaPluginImpl();
                    }
                } else {
                    try {
                        Object object = ObjectHelper.create((String)string);
                        if (!(object instanceof IPSKafkaPlugin)) {
                            throw new Exception(StringHelper.format((String)"\u5bf9\u8c61\u7c7b\u578b\u4e0d\u6b63\u786e"));
                        }
                        bEnableKafkaPlugin = true;
                        iPSKafkaPlugin = (IPSKafkaPlugin)object;
                    }
                    catch (Exception exception) {
                        log.error((Object)StringHelper.format((String)"\u5efa\u7acbKafka\u63d2\u4ef6\u5bf9\u8c61[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), (Throwable)exception);
                    }
                }
            }
        }
        return bEnableKafkaPlugin != false && PSCoreSysServiceBase.getPSKafkaPlugin() != null;
    }

    public static void setPSKafkaPlugin(IPSKafkaPlugin iPSKafkaPlugin) {
        PSCoreSysServiceBase.iPSKafkaPlugin = iPSKafkaPlugin;
    }

    public static IPSKafkaPlugin getPSKafkaPlugin() {
        return iPSKafkaPlugin;
    }

    public static void setEnableDevSlnSysRemoteCall(boolean bl) {
        bEnableDevSlnSysRemoteCall = bl;
    }

    public static boolean isEnableDevSlnSysRemoteCall() {
        if (bEnableDevSlnSysRemoteCall == null) {
            bEnableDevSlnSysRemoteCall = WebConfig.getCurrent() != null ? Boolean.valueOf(WebConfig.getCurrent().getAttribute("DEVSLNSYSREMOTECALL", false)) : Boolean.valueOf(false);
        }
        return bEnableDevSlnSysRemoteCall;
    }

    public static void setEnableModelObjStorage(boolean bl) {
        bEnableModelObjStorage = bl;
    }

    public static boolean isEnableModelObjStorage() {
        if (bEnableModelObjStorage == null && WebConfig.getCurrent() != null) {
            bEnableModelObjStorage = WebConfig.getCurrent().getAttribute("MODELOBJSTORAGE", false);
        }
        return bEnableModelObjStorage;
    }

    protected boolean isEnableStateInform() {
        if (!PSCoreSysServiceBase.isEnableStateInformDefault()) {
            return false;
        }
        if (PSCoreSysServiceBase.isImpSysModelNowEx()) {
            return false;
        }
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        if (actionSession != null) {
            if (StringHelper.compare((String)actionSession.getName(), (String)this.getDEModel().getName(), (boolean)true) != 0) {
                return false;
            }
            if (ActionSessionManager.getCurrentSession().getActionParam("SRFIGNORESTATEINFORM") != null) {
                return false;
            }
        }
        return true;
    }

    protected void setEnableStateInform(boolean bl) {
        if (ActionSessionManager.getCurrentSession() != null) {
            if (bl) {
                ActionSessionManager.getCurrentSession().removeActionParam("SRFIGNORESTATEINFORM");
            } else {
                ActionSessionManager.getCurrentSession().setActionParam("SRFIGNORESTATEINFORM", (Object)"1");
            }
        }
    }

    protected void informObjectChanged(ET ET, String string) throws Exception {
        Object object;
        String string2;
        if (!this.isEnableStateInform()) {
            return;
        }
        this.informOPInfo(ET, string);
        String string3 = informStateMap.get(this.getDEModel().getName());
        if (string3 == null) {
            return;
        }
        ET ET2 = ET;
        String string4 = DataObject.getStringValue((Object)ET.get("psdsconsoleid"));
        if (KeyValueHelper.isTempKey((String)DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName()))) && net.ibizsys.paas.web.WebContext.getAppData() != null) {
            string4 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdsconsoleid");
        }
        if (StringHelper.isNullOrEmpty((String)string4)) {
            string4 = DataObject.getStringValue((Object)ET.get("psdynainstid"));
        }
        if (StringHelper.isNullOrEmpty((String)string4)) {
            string4 = DataObject.getStringValue((Object)ET.get("psdevslnsysid"));
        }
        if (StringHelper.isNullOrEmpty((String)string4) && net.ibizsys.paas.web.WebContext.getAppData() != null) {
            string4 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdevslnsysid");
        }
        if (StringHelper.isNullOrEmpty((String)string4) && (string2 = informStateMap2.get(this.getDEModel().getName())) != null) {
            string4 = DataObject.getStringValue((Object)ET.get("psdevslnid"));
            if (StringHelper.isNullOrEmpty((String)string4) && net.ibizsys.paas.web.WebContext.getAppData() != null) {
                string4 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdevslnid");
            }
            if (!StringHelper.isNullOrEmpty((String)string4)) {
                string4 = KeyValueHelper.genUniqueId((String)string4);
            }
        }
        if (StringHelper.isNullOrEmpty((String)string4)) {
            return;
        }
        string2 = string4;
        String string5 = "OBJECTUPDATED";
        if (StringHelper.compare((String)string, (String)"DELETE", (boolean)true) == 0) {
            string5 = "OBJECTREMOVED";
        } else if (StringHelper.compare((String)string, (String)"CREATE", (boolean)true) == 0) {
            string5 = "OBJECTCREATED";
        }
        final String string6 = string5;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("srfdename", (Object)this.getDEModel().getName());
        Object object2 = ET2.get(this.getDEModel().getMajorDEField().getName());
        Object object3 = ET2.get(this.getDEModel().getKeyDEField().getName());
        jSONObject.put("srfkey", object3);
        jSONObject.put(this.getDEModel().getKeyDEField().getName().toLowerCase(), object3);
        if (object2 != null) {
            jSONObject.put("srfmajortext", object2);
            jSONObject.put(this.getDEModel().getMajorDEField().getName().toLowerCase(), object2);
        }
        if (!StringHelper.isNullOrEmpty((String)string3)) {
            object = string3.split("[|]");
            for (int i = 0; i < ((String[])object).length; ++i) {
                jSONObject.put(object[i].toLowerCase(), ET2.get(object[i]));
            }
        }
        if ((object = this.getDEModel().getDEField("CODENAME", true)) != null && ET2.contains("CODENAME")) {
            jSONObject.put("codename", ET2.get("CODENAME"));
        }
        if ((object = this.getDEModel().getDEField("LOGICNAME", true)) != null && ET2.contains("LOGICNAME")) {
            jSONObject.put("logicname", ET2.get("LOGICNAME"));
        }
        if (StringHelper.compare((String)string5, (String)"OBJECTCREATED", (boolean)true) == 0 || StringHelper.compare((String)string5, (String)"OBJECTUPDATED", (boolean)true) == 0) {
            object = this.getDEModel().getDEField("LEFTPOS", true);
            if (object != null && ET2.contains("LEFTPOS") && ET2.get("LEFTPOS") != null) {
                jSONObject.put("leftpos", ET2.get("LEFTPOS"));
            }
            if ((object = this.getDEModel().getDEField("TOPPOS", true)) != null && ET2.contains("TOPPOS") && ET2.get("TOPPOS") != null) {
                jSONObject.put("toppos", ET2.get("TOPPOS"));
            }
        }
        this.fillInformObject(ET2, string, jSONObject);
        final String string7 = jSONObject.toString();
        SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                PSStudioConsoleHelper.getCurrent().sendCommand(string2, string6, string7);
            }

            public void rollback() {
            }
        });
    }

    protected void sendStudioConsole(boolean bl, String string, String string2, boolean bl2) {
        this.sendStudioConsole(bl, string, string2, null, null, bl2);
    }

    protected void sendStudioConsole(boolean bl, String string, String string2, String string3, String string4, boolean bl2) {
        if (!this.internalSendStudioConsole(bl, string, string2, string3, string4, bl2)) {
            if (StringHelper.compare((String)string, (String)"INFO", (boolean)true) == 0) {
                log.info((Object)string2);
            } else if (StringHelper.compare((String)string, (String)"WARN", (boolean)true) == 0) {
                log.warn((Object)string2);
            } else if (StringHelper.compare((String)string, (String)"ERROR", (boolean)true) == 0) {
                log.error((Object)string2);
            } else if (StringHelper.compare((String)string, (String)"DEBUG", (boolean)true) == 0) {
                log.debug((Object)string2);
            }
        }
    }

    protected boolean internalSendStudioConsole(boolean bl, String string, String string2, String string3, String string4, boolean bl2) {
        if (PSStudioConsoleHelper.getCurrent() != null && net.ibizsys.paas.web.WebContext.getAppData() != null) {
            String string5 = null;
            string5 = bl ? net.ibizsys.paas.web.WebContext.getAppData().optString("psdsconsoleid") : net.ibizsys.paas.web.WebContext.getAppData().optString("psdevslnsysid");
            if (StringHelper.isNullOrEmpty((String)string5)) {
                return false;
            }
            if (!StringHelper.isNullOrEmpty((String)string)) {
                string2 = StringHelper.compare((String)string, (String)"INFO", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent(string2, 34, -1, 1) : (StringHelper.compare((String)string, (String)"WARN", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent(string2, 33, -1, 1) : (StringHelper.compare((String)string, (String)"ERROR", (boolean)false) == 0 ? PSStudioConsoleHelper.getContent(string2, 31, -1, 1) : PSStudioConsoleHelper.getContent(string2, 32, -1, 1)));
            }
            try {
                if (bl2) {
                    final String string6 = string5;
                    final String string7 = string2;
                    final String string8 = string4;
                    final String string9 = string3;
                    SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

                        public void commit() {
                            PSStudioConsoleHelper.getCurrent().sendConsole(string6, string7, string9, string8, true);
                        }

                        public void rollback() {
                        }
                    });
                } else {
                    PSStudioConsoleHelper.getCurrent().sendConsole(string5, string2, string3, string4, true);
                }
                return true;
            }
            catch (Exception exception) {
                log.error((Object)exception);
            }
        }
        return false;
    }

    protected void fillInformObject(ET ET, String string, JSONObject jSONObject) throws Exception {
    }

    @Override
    protected void checkEntity(ET ET, boolean bl, boolean bl2, boolean bl3) throws Exception {
        try {
            super.checkEntity(ET, bl, bl2, bl3);
            EntityError entityError = new EntityError();
            psModelHotCodeHelper.execute(this, "CHECKENTITY", (IEntity)ET, entityError, true);
            if (entityError.hasError()) {
                this.convertEntityError(entityError);
                throw new EntityException(entityError, (IDataEntity)this.getDEModel());
            }
        }
        catch (Exception exception) {
            EntityException entityException;
            String string;
            ActionSession actionSession;
            if (exception instanceof EntityException && (actionSession = ActionSessionManager.getCurrentSession()) != null && !StringHelper.isNullOrEmpty((String)actionSession.getName()) && StringHelper.compare((String)actionSession.getName(), (String)this.getDEModel().getName(), (boolean)true) != 0 && !StringHelper.isNullOrEmpty((String)(string = (entityException = (EntityException)exception).getMessage()))) {
                string = StringHelper.format((String)"[%1$s]%2$s", (Object)this.getDEModel().getLogicName(), (Object)string);
                throw new EntityException(entityException.getEntityError(), entityException.getErrorCode(), string, (IDataEntity)this.getDEModel());
            }
            throw exception;
        }
    }

    @Override
    public String getModelV2Name(ET ET, boolean bl) throws Exception {
        return this.getModelV2Name(bl);
    }

    @Override
    public String getModelV2Name(boolean bl) {
        if (bl) {
            return this.getDEModel().getName();
        }
        String string = this.getDEModel().getName();
        return Inflector.getInstance().pluralize(string).toUpperCase();
    }

    @Override
    public String getModelV2LogicName() {
        return this.getDEModel().getLogicName();
    }

    @Override
    public String getModelV2LogicName(ET ET) throws Exception {
        return this.getModelV2LogicName();
    }

    @Override
    public String getModelV2ResPath(IEntity iEntity, boolean bl) throws Exception {
        String string = DataObject.getStringValue((Object)iEntity.get(this.getDEModel().getKeyDEField().getName()));
        if (StringHelper.isNullOrEmpty((String)string)) {
            return null;
        }
        String string2 = this.getModelV2ResScope(iEntity);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            log.warn((Object)StringHelper.format((String)"\u6a21\u578b[%1$s](%2$s)\u6ca1\u6709\u6307\u5b9a\u6a21\u578b\u8303\u56f4", (Object)this.getDEModel().getName(), (Object)string));
            return null;
        }
        if (bl) {
            return StringHelper.format((String)"%1$s%2$s%3$s#%4$s.txt", (Object)this.getDEModel().getName(), (Object)File.separator, (Object)string2, (Object)"ALL");
        }
        return StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s.json", (Object)this.getDEModel().getName(), (Object)File.separator, (Object)string2, (Object)string);
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (StringHelper.isNullOrEmpty((String)string)) {
            return null;
        }
        return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        return null;
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        return null;
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return null;
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        return false;
    }

    @Override
    public void importModelV2Ex(ET ET, String string, String string2) throws Exception {
        ObjectNode objectNode = null;
        objectNode = "YAML".equals(string2) ? PSModelYamlHelper.importModel(this.getDEModel(), ET, string) : (ObjectNode)JsonNodeHelper.fromString((String)string);
        this.importModelV2(ET, objectNode);
    }

    @Override
    public void importModelV2(ET ET, ObjectNode objectNode) throws Exception {
        String string;
        ET ET2 = ET;
        ObjectNode objectNode2 = objectNode;
        Iterator iterator = this.getDEModel().getDEFields();
        if (iterator != null) {
            while (iterator.hasNext()) {
                string = (IDEField)iterator.next();
                if (string.isKeyDEField() || ET.contains(string.getName())) continue;
                if (string.getName().equals("ENABLE")) {
                    ET.set(string.getName(), (Object)1);
                    continue;
                }
                JsonNode jsonNode = objectNode.get(string.getName().toLowerCase());
                if (jsonNode == null || jsonNode instanceof NullNode) {
                    if (string.getName().equals("ENABLE")) continue;
                    ET.set(string.getName(), null);
                    continue;
                }
                if (DataTypeHelper.isStringDataType((int)string.getStdDataType())) {
                    ET.set(string.getName(), (Object)jsonNode.asText());
                    continue;
                }
                if (DataTypeHelper.isIntType((int)string.getStdDataType())) {
                    ET.set(string.getName(), (Object)jsonNode.asInt());
                    continue;
                }
                if (DataTypeHelper.isDoubleType((int)string.getStdDataType())) {
                    ET.set(string.getName(), (Object)jsonNode.asDouble());
                    continue;
                }
                if (DataTypeHelper.isDateTimeType((int)string.getStdDataType())) {
                    if (jsonNode.isLong()) {
                        ET.set(string.getName(), (Object)new Timestamp(jsonNode.asLong()));
                        continue;
                    }
                    ET.set(string.getName(), (Object)jsonNode.asText());
                    continue;
                }
                ET.set(string.getName(), (Object)jsonNode.asText());
            }
        }
        boolean bl = PSCoreSysServiceBase.isSimpleImportExportMode();
        string = PSCoreSysServiceBase.getSimpleImportExportOwner();
        this.doServiceWork(new IServiceWork((IEntity)ET2, string, objectNode2, bl){
            final /* synthetic */ IEntity val$et2;
            final /* synthetic */ String val$strSimpleImportExportOwner;
            final /* synthetic */ ObjectNode val$objectNode2;
            final /* synthetic */ boolean val$bSimpleImportExportMode;
            {
                this.val$et2 = iEntity;
                this.val$strSimpleImportExportOwner = string;
                this.val$objectNode2 = objectNode;
                this.val$bSimpleImportExportMode = bl;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                try {
                    boolean bl = !StringHelper.isNullOrEmpty((Object)this.val$et2.get(PSCoreSysServiceBase.this.getDEModel().getKeyDEField().getName()));
                    PSCoreSysServiceBase.setSimpleImportExportMode(true);
                    if (StringHelper.isNullOrEmpty((String)this.val$strSimpleImportExportOwner)) {
                        PSCoreSysServiceBase.setSimpleImportExportOwner(PSCoreSysServiceBase.this.getModelV2Name(true));
                    }
                    ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
                    PSModelV2Helper.setKeyMap(concurrentHashMap);
                    ArrayList<ModelV2> arrayList = PSCoreSysServiceBase.this.getCompileModelV2List(true);
                    PSCoreSysServiceBase.this.prepareImportExportModelV2Env(this.val$et2, arrayList, true);
                    ArrayList<ModelV2> arrayList2 = PSCoreSysServiceBase.this.getImportModelV2List(true);
                    PSCoreSysServiceBase.this.compileModelV2(this.val$et2, this.val$objectNode2, null, null, 1);
                    PSCoreSysServiceBase.this.compileModelV2(this.val$et2, this.val$objectNode2, null, null, 2);
                    PSCoreSysServiceBase.this.onImportModelV2(bl, this.val$et2, arrayList2);
                    PSCoreSysServiceBase.this.resetImportModelV2List();
                    PSCoreSysServiceBase.this.resetCompileModelV2List();
                    PSModelV2Helper.setKeyMap(null);
                    if (StringHelper.isNullOrEmpty((String)this.val$strSimpleImportExportOwner)) {
                        PSCoreSysServiceBase.setSimpleImportExportOwner(this.val$strSimpleImportExportOwner);
                    }
                    PSCoreSysServiceBase.setSimpleImportExportMode(this.val$bSimpleImportExportMode);
                }
                catch (Exception exception) {
                    PSCoreSysServiceBase.this.resetImportModelV2List();
                    PSCoreSysServiceBase.this.resetCompileModelV2List();
                    PSModelV2Helper.setKeyMap(null);
                    if (StringHelper.isNullOrEmpty((String)this.val$strSimpleImportExportOwner)) {
                        PSCoreSysServiceBase.setSimpleImportExportOwner(this.val$strSimpleImportExportOwner);
                    }
                    PSCoreSysServiceBase.setSimpleImportExportMode(this.val$bSimpleImportExportMode);
                    throw exception;
                }
            }
        }, true);
    }

    /*
     * WARNING - void declaration
     */
    protected void onImportModelV2(boolean bl, ET ET, ArrayList<ModelV2> arrayList) throws Exception {
        void var5_9;
        String i;
        if (arrayList.size() == 0) {
            throw new Exception("\u6ca1\u6709\u4efb\u4f55\u5bfc\u5165\u6570\u636e");
        }
        for (ModelV2 object2 : arrayList) {
            log.debug((Object)StringHelper.format((String)"\u5bfc\u5165\u6570\u636e[%1$s][%2$s][%3$s]", (Object)object2.type, (Object)object2.text, (Object)object2.key));
        }
        String string = this.getModelV2Name(ET, true);
        if (StringHelper.compare((String)arrayList.get((int)0).type, (String)string, (boolean)false) != 0) {
            throw new Exception(StringHelper.format((String)"\u5bfc\u5165\u9996\u6570\u636e\u7c7b\u578b[%1$s]\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a[%2$s]", (Object)arrayList.get((int)0).type, (Object)string));
        }
        if (bl && StringHelper.compare((String)arrayList.get((int)0).key, (String)(i = DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName()))), (boolean)false) != 0) {
            throw new Exception(StringHelper.format((String)"\u5bfc\u5165\u9996\u6570\u636e\u952e\u503c[%1$s]\u4e0d\u6b63\u786e\uff0c\u5fc5\u987b\u4e3a[%2$s]", (Object)arrayList.get((int)0).key, (Object)i));
        }
        if (bl) {
            this.emptyModelV2(ET);
        }
        boolean bl2 = false;
        while (var5_9 < arrayList.size()) {
            IEntity iEntity = arrayList.get((int)var5_9).entity;
            if (var5_9 == false) {
                this.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
                if (bl) {
                    this.update(iEntity);
                } else {
                    this.create(iEntity);
                }
            } else {
                IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)arrayList.get((int)var5_9).type);
                IService iService = iDataEntityModel.getService(this.getSessionFactory());
                iService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
                iService.create(iEntity, false);
            }
            ++var5_9;
        }
        if (arrayList.get((int)0).entity != ET) {
            arrayList.get((int)0).entity.copyTo(ET, true);
        }
    }

    @Override
    public void emptyModelV2(ET ET) throws Exception {
        ET ET2 = ET;
        this.doServiceWork(new IServiceWork((IEntity)ET2){
            final /* synthetic */ IEntity val$et2;
            {
                this.val$et2 = iEntity;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase.this.onEmptyModelV2(this.val$et2);
            }
        }, true);
    }

    protected void onEmptyModelV2(ET ET) throws Exception {
    }

    @Override
    public void exportModelV2(ET ET, String string, String string2) throws Exception {
        ET ET2 = ET;
        String string3 = string;
        String string4 = string2;
        this.doServiceWork(new IServiceWork((IEntity)ET2, string3, string4){
            final /* synthetic */ IEntity val$et2;
            final /* synthetic */ String val$strFolder2;
            final /* synthetic */ String val$strResFolder2;
            {
                this.val$et2 = iEntity;
                this.val$strFolder2 = string;
                this.val$strResFolder2 = string2;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase.this.pushExportModelV2(this.val$et2);
                PSCoreSysServiceBase.this.exportCurModelV2(this.val$et2, this.val$strFolder2, this.val$strResFolder2);
                PSCoreSysServiceBase.this.exportRelatedModelV2(this.val$et2, this.val$strFolder2, this.val$strResFolder2);
                PSCoreSysServiceBase.this.popupExportModelV2(this.val$et2);
            }
        }, false);
    }

    protected void exportCurModelV2(ET ET, String string, String string2) throws Exception {
        ObjectNode objectNode = this.fillModelV2(null, ET, string2);
        if (objectNode != null) {
            this.onExportCurModelV2(ET, objectNode, string2, false);
            this.onWriteFileCurModelV2(ET, string, objectNode);
        }
    }

    protected void onWriteFileCurModelV2(ET ET, String string, ObjectNode objectNode) throws Exception {
        String string2 = null;
        string2 = "YAML".equals(PSCoreSysServiceBase.getModelFormat()) ? StringHelper.format((String)"%1$s%2$s%3$s.yaml", (Object)string, (Object)File.separator, (Object)this.getModelV2Name(ET, true)) : StringHelper.format((String)"%1$s%2$s%3$s.json", (Object)string, (Object)File.separator, (Object)this.getModelV2Name(ET, true));
        String string3 = null;
        string3 = "YAML".equals(PSCoreSysServiceBase.getModelFormat()) ? PSModelYamlHelper.exportModel(objectNode) : MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString((Object)objectNode);
        PSModelV2Helper.writeFile(string2, string3);
        Map<String, String> map = PSModelV2Helper.getUniqueFileMap();
        if (map != null) {
            Object object = ET.get(this.getDEModel().getKeyDEField().getName());
            Object object2 = null;
            if (this.getDEModel().getMajorDEField() != null) {
                object2 = ET.get(this.getDEModel().getMajorDEField().getName());
            }
            String string4 = String.format("[%1$s](%2$s|%3$s)", this.getModelV2Name(ET, true), object, object2);
            String string5 = string2.toUpperCase();
            String string6 = map.get(string5);
            if (!StringHelper.isNullOrEmpty((String)string6)) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b%1$s\u5bfc\u51fa\u8def\u5f84\u4e0e%2$s\u4e00\u81f4", (Object)string4, (Object)string6));
            }
            map.put(string5, string4);
        }
    }

    public ObjectNode fillModelV2(ObjectNode objectNode, ET ET, String string) throws Exception {
        if (objectNode == null) {
            objectNode = JsonNodeHelper.createObjectNode();
        }
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("PSDEVSLNID", "");
        hashMap.put("PSDEVSLNNAME", "");
        hashMap.put("PSDEVCENTERID", "");
        hashMap.put("PSDEVCENTERNAME", "");
        hashMap.put("PSDEVSLNSYSID", "");
        hashMap.put("PSDEVSLNSYSNAME", "");
        hashMap.put("ENABLE", "");
        if (StringHelper.isNullOrEmpty((String)string)) {
            hashMap.put("CREATEMAN", "");
            hashMap.put("UPDATEMAN", "");
            hashMap.put("CREATEDATE", "");
            hashMap.put("UPDATEDATE", "");
        } else {
            Timestamp timestamp;
            Timestamp timestamp2 = DataObject.getTimestampValue(ET, (String)"CREATEDATE", null);
            if (timestamp2 != null) {
                hashMap.put("CREATEDATE", DateHelper.toDateTimeString((Date)timestamp2));
            }
            if ((timestamp = DataObject.getTimestampValue(ET, (String)"UPDATEDATE", null)) != null) {
                hashMap.put("UPDATEDATE", DateHelper.toDateTimeString((Date)timestamp));
            }
        }
        if (ET.contains("DYNAMODELFLAG") && DataObject.getIntegerValue(ET, (String)"DYNAMODELFLAG", (int)0) == 0) {
            hashMap.put("DYNAMODELFLAG", "");
        }
        if (!this.getDEModel().getName().equals("PSSYSTEM")) {
            hashMap.put("PSSYSTEMID", "");
            hashMap.put("PSSYSTEMNAME", "");
        }
        return this.onFillModelV2(objectNode, ET, string, hashMap);
    }

    protected ObjectNode onFillModelV2(ObjectNode objectNode, ET ET, String string, Map<String, String> map) throws Exception {
        Object object;
        Object object2;
        for (int i = 0; i < 2; ++i) {
            object2 = null;
            if (i == 0) {
                object2 = this.getDEModel().getDERs(false);
            } else if (this.getDEModel().getInheritDEModel() != null) {
                object2 = this.getDEModel().getInheritDEModel().getDERs(false);
            }
            if (object2 == null) continue;
            block1: while (object2.hasNext()) {
                Object object3;
                IDERBase iDERBase = (IDERBase)object2.next();
                if (!(iDERBase instanceof IDER1N)) continue;
                IDER1NModel object4 = (IDER1NModel)iDERBase;
                object = this.getDEModel().getDEField(object4.getPickupDEFName(), true);
                if (object == null || map.containsKey(object.getName()) || StringHelper.isNullOrEmpty((Object)(object3 = ET.get(object.getName())))) continue;
                ModelV2 modelV2 = this.getLastExportModelV2(iDERBase.getMajorDEName(), 1);
                if (modelV2 != null && modelV2.key.equals(object3)) {
                    Object object5;
                    if (modelV2.pos == 1) {
                        object5 = this.getModelV2ResScopeDER((IEntity)ET);
                        if (StringHelper.isNullOrEmpty((String)object5) || StringHelper.compare((String)object4.getName(), (String)object5, (boolean)false) == 0) {
                            map.put(object.getName(), "");
                        } else {
                            map.put(object.getName(), StringHelper.format((String)"<%1$s>", (Object)iDERBase.getMajorDEName()));
                        }
                    } else {
                        map.put(object.getName(), StringHelper.format((String)"<%1$s>", (Object)iDERBase.getMajorDEName()));
                    }
                    object5 = null;
                    if (i == 0) {
                        object5 = this.getDEModel().getDEFields();
                    } else if (this.getDEModel().getInheritDEModel() != null) {
                        object5 = this.getDEModel().getInheritDEModel().getDEFields();
                    }
                    if (object5 == null) continue;
                    while (object5.hasNext()) {
                        IDEField iDEField = (IDEField)object5.next();
                        if (!iDEField.isLinkDEField() || !iDEField.isPhisicalDEField() || !"PICKUPTEXT".equals(iDEField.getDataType()) || StringHelper.compare((String)iDEField.getDERName(), (String)object4.getName(), (boolean)false) != 0) continue;
                        Object object6 = ET.get(iDEField.getName());
                        if (object6 == null || StringHelper.compare((String)modelV2.text, (String)((String)object6), (boolean)false) != 0) continue block1;
                        map.put(iDEField.getName(), "");
                        continue block1;
                    }
                    continue;
                }
                map.put(object.getName(), this.getModelV2UniqueTag(object4.getMajorDEName(), (String)object3, string));
            }
        }
        Iterator iterator = this.getDEModel().getDEFields();
        if (iterator != null) {
            while (iterator.hasNext()) {
                object2 = (IDEFieldModel)iterator.next();
                if (!StringHelper.isNullOrEmpty((String)object2.getUserTag()) && StringHelper.compare((String)"IGNOREMODELV2", (String)object2.getUserTag(), (boolean)true) == 0) {
                    map.put(object2.getName(), "");
                    continue;
                }
                if (object2.isPhisicalDEField() || object2.isInheritDEField()) continue;
                map.put(object2.getName(), "");
            }
        }
        map.put(this.getDEModel().getKeyDEField().getName(), "");
        if (this.getDEModel().getInheritDEModel() != null) {
            iterator = this.getDEModel().getInheritDEModel().getDEFields();
            if (iterator != null) {
                while (iterator.hasNext()) {
                    object2 = (IDEFieldModel)iterator.next();
                    if (!StringHelper.isNullOrEmpty((String)object2.getUserTag()) && StringHelper.compare((String)"IGNOREMODELV2", (String)object2.getUserTag(), (boolean)true) == 0) {
                        map.put(object2.getName(), "");
                        continue;
                    }
                    if (object2.isPhisicalDEField()) continue;
                    map.put(object2.getName(), "");
                }
            }
            map.put(this.getDEModel().getInheritDEModel().getKeyDEField().getName(), "");
        }
        if (!this.getDEModel().getName().equals("PSSYSTEM")) {
            map.put("PSSYSTEMID", "");
            map.put("PSSYSTEMNAME", "");
        }
        object2 = new HashMap();
        ET.fillMap((HashMap)object2, false);
        for (Map.Entry entry : ((HashMap)object2).entrySet()) {
            object = map.get(((String)entry.getKey()).toUpperCase());
            if (object == null) {
                if (entry.getValue() == null || entry.getValue() == DataObject.EMPTY || entry.getValue() instanceof Timestamp) continue;
                JsonNodeHelper.put((ObjectNode)objectNode, (String)((String)entry.getKey()).toLowerCase(), entry.getValue());
                continue;
            }
            if (StringHelper.isNullOrEmpty((String)object)) continue;
            JsonNodeHelper.put((ObjectNode)objectNode, (String)((String)entry.getKey()).toLowerCase(), (Object)object);
        }
        return objectNode;
    }

    protected String getModelV2UniqueTag(String string, String string2, String string3) throws Exception {
        Map<String, String> map = PSModelV2Helper.getUniqueTagMap();
        if (map != null) {
            String string4 = StringHelper.format((String)"%1$s/%2$s", (Object)string, (Object)string2).toLowerCase();
            String string5 = map.get(string4);
            if (StringHelper.isNullOrEmpty((String)string5)) {
                Integer n = ignoreExportModelV2Map.get(string);
                if (n == null) {
                    log.warn((Object)StringHelper.format((String)"\u6a21\u578b[%1$s](%2$s)\u6807\u8bc6\u6587\u4ef6\u4e0d\u5b58\u5728", (Object)string, (Object)string2));
                    return string2;
                }
                if (n == 1) {
                    return string2;
                }
                return null;
            }
            int n = string5.indexOf("/");
            if (n == -1) {
                return string5;
            }
            String string6 = string5.substring(0, n);
            String string7 = string5.substring(n + 1);
            String[] stringArray = string6.split("[#]");
            if (stringArray.length != 2) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s](%2$s)\u6807\u8bc6\u5185\u5bb9(%3$s)\u4e0d\u6b63\u786e", (Object)string, (Object)string2, (Object)string5));
            }
            ModelV2 modelV2 = this.getLastExportModelV2(stringArray[0], 1);
            if (modelV2 != null && StringHelper.compare((String)modelV2.key, (String)stringArray[1], (boolean)true) == 0) {
                return StringHelper.format((String)"<%1$s>/%2$s", (Object)stringArray[0], (Object)string7);
            }
            return this.getModelV2UniqueTag(stringArray[0], stringArray[1], string3) + "/" + string7;
        }
        if (StringHelper.isNullOrEmpty((String)string3)) {
            Integer n = ignoreExportModelV2Map.get(string);
            if (n != null) {
                if (n == 1) {
                    return string2;
                }
                return null;
            }
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)string);
            IService iService = iDataEntityModel.getService(this.getSessionFactory());
            IEntity iEntity = iDataEntityModel.createEntity();
            iEntity.set(iDataEntityModel.getKeyDEField().getName(), (Object)string2);
            if (!iService.get(iEntity, true)) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s](%2$s)\u6570\u636e\u4e0d\u6b63\u786e", (Object)string, (Object)string2));
            }
            String string8 = ((IPSModelV2Service)iService).getModelV2ResScope(iEntity);
            if (StringHelper.isNullOrEmpty((String)string8)) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s](%2$s)\u8d44\u6e90\u8303\u56f4\u4e0d\u6b63\u786e", (Object)string, (Object)string2));
            }
            String[] stringArray = string8.split("[#]");
            if (stringArray.length != 2) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s](%2$s)\u8d44\u6e90\u8303\u56f4(%3$s)\u4e0d\u6b63\u786e", (Object)string, (Object)string2, (Object)string8));
            }
            String string9 = ((IPSModelV2Service)iService).getModelV2Tag(iEntity);
            ModelV2 modelV2 = this.getLastExportModelV2(stringArray[0], 1);
            if (modelV2 != null && StringHelper.compare((String)modelV2.key, (String)stringArray[1], (boolean)true) == 0) {
                if (StringHelper.compare((String)stringArray[0], (String)"PSSYSTEM", (boolean)false) == 0) {
                    return string9;
                }
                return StringHelper.format((String)"<%1$s>/%2$s", (Object)stringArray[0], (Object)string9);
            }
            return this.getModelV2UniqueTag(stringArray[0], stringArray[1], string3) + "/" + string9;
        }
        String string10 = StringHelper.format((String)"%1$s%2$s%3$s%2$s%4$s.txt", (Object)string3, (Object)File.separator, (Object)string, (Object)string2);
        File file = new File(string10);
        if (!file.exists()) {
            Integer n = ignoreExportModelV2Map.get(string);
            if (n == null) {
                log.warn((Object)StringHelper.format((String)"\u6a21\u578b[%1$s](%2$s)\u6807\u8bc6\u6587\u4ef6\u4e0d\u5b58\u5728", (Object)string, (Object)string2));
                return string2;
            }
            if (n == 1) {
                return string2;
            }
            return null;
        }
        String string11 = PSModelV2Helper.readFile(string10);
        int n = string11.indexOf("/");
        if (n == -1) {
            return string11;
        }
        String string12 = string11.substring(0, n);
        String string13 = string11.substring(n + 1);
        String[] stringArray = string12.split("[#]");
        if (stringArray.length != 2) {
            throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s](%2$s)\u6807\u8bc6\u5185\u5bb9(%3$s)\u4e0d\u6b63\u786e", (Object)string, (Object)string2, (Object)string11));
        }
        ModelV2 modelV2 = this.getLastExportModelV2(stringArray[0], 1);
        if (modelV2 != null && StringHelper.compare((String)modelV2.key, (String)stringArray[1], (boolean)true) == 0) {
            return StringHelper.format((String)"<%1$s>/%2$s", (Object)stringArray[0], (Object)string13);
        }
        return this.getModelV2UniqueTag(stringArray[0], stringArray[1], string3) + "/" + string13;
    }

    protected void onExportCurModelV2(ET ET, ObjectNode objectNode, String string, boolean bl) throws Exception {
    }

    @Override
    public ObjectNode exportModelV2(ET ET) throws Exception {
        boolean bl = PSCoreSysServiceBase.isSimpleImportExportMode();
        String string = PSCoreSysServiceBase.getSimpleImportExportOwner();
        try {
            PSCoreSysServiceBase.setSimpleImportExportMode(true);
            if (StringHelper.isNullOrEmpty((String)string)) {
                PSCoreSysServiceBase.setSimpleImportExportOwner(this.getModelV2Name(true));
            }
            ObjectNode objectNode = this.exportModelV2(ET, null);
            if (StringHelper.isNullOrEmpty((String)string)) {
                PSCoreSysServiceBase.setSimpleImportExportOwner(string);
            }
            PSCoreSysServiceBase.setSimpleImportExportMode(bl);
            return objectNode;
        }
        catch (Exception exception) {
            if (StringHelper.isNullOrEmpty((String)string)) {
                PSCoreSysServiceBase.setSimpleImportExportOwner(string);
            }
            PSCoreSysServiceBase.setSimpleImportExportMode(bl);
            throw exception;
        }
    }

    public ObjectNode exportModelV2(ET ET, String string) throws Exception {
        ET ET2 = ET;
        String string2 = string;
        CallResult callResult = new CallResult();
        this.doServiceWork(new IServiceWork((IEntity)ET2, string2, callResult){
            final /* synthetic */ IEntity val$et2;
            final /* synthetic */ String val$strResFolder2;
            final /* synthetic */ CallResult val$callResult;
            {
                this.val$et2 = iEntity;
                this.val$strResFolder2 = string;
                this.val$callResult = callResult;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase.this.pushExportModelV2(this.val$et2, this.val$strResFolder2 == null);
                ObjectNode objectNode = PSCoreSysServiceBase.this.fillModelV2(null, this.val$et2, this.val$strResFolder2);
                if (objectNode != null) {
                    PSCoreSysServiceBase.this.onExportCurModelV2(this.val$et2, objectNode, this.val$strResFolder2, this.val$strResFolder2 != null);
                    this.val$callResult.setUserObject((Object)objectNode);
                }
                PSCoreSysServiceBase.this.popupExportModelV2(this.val$et2);
            }
        }, false);
        if (callResult.getUserObject() instanceof ObjectNode) {
            return (ObjectNode)callResult.getUserObject();
        }
        return null;
    }

    @Override
    public String exportModelV2Ex(ET ET, String string) throws Exception {
        ObjectNode objectNode = this.exportModelV2(ET);
        if ("YAML".equals(string)) {
            return PSModelYamlHelper.exportModel(this.getDEModel(), ET, objectNode);
        }
        return objectNode.toString();
    }

    protected void pushExportModelV2(ET ET) throws Exception {
        this.pushExportModelV2(ET, false);
    }

    protected void pushExportModelV2(ET ET, boolean bl) throws Exception {
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        Object object = actionSession.getActionParam("EXPORTMODELV2LIST");
        ArrayList<ModelV2> arrayList = null;
        if (object == null) {
            arrayList = new ArrayList<ModelV2>();
            actionSession.setActionParam("EXPORTMODELV2LIST", arrayList);
            if (bl) {
                this.prepareImportExportModelV2Env(ET, arrayList, false);
            }
        } else {
            arrayList = (ArrayList<ModelV2>)object;
        }
        ModelV2 modelV2 = new ModelV2();
        modelV2.key = (String)ET.get(this.getDEModel().getKeyDEField().getName());
        modelV2.type = this.getDEModel().getName();
        modelV2.text = (String)ET.get(this.getDEModel().getMajorDEField().getName());
        arrayList.add(0, modelV2);
    }

    protected void prepareImportExportModelV2Env(ET ET, ArrayList<ModelV2> arrayList, boolean bl) throws Exception {
        String[] stringArray;
        IDataEntityModel iDataEntityModel;
        Object object;
        String string;
        Object object2 = ET;
        IPSModelV2Service<ET> iPSModelV2Service = this;
        if (bl && StringHelper.isNullOrEmpty((String)(string = DataObject.getStringValue((Object)object2.get("SRFMODELV2SCOPE")))) && StringHelper.isNullOrEmpty((String)(string = iPSModelV2Service.getModelV2ResScope((IEntity)object2))) && !StringHelper.isNullOrEmpty((Object)(object = ET.get(this.getDEModel().getKeyDEField().getName())))) {
            iDataEntityModel = this.getDEModel().createEntity();
            iDataEntityModel.set(this.getDEModel().getKeyDEField().getName(), object);
            this.get((IEntity)iDataEntityModel);
            string = this.getModelV2ResScope((IEntity)iDataEntityModel);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                object2.set("SRFMODELV2SCOPE", (Object)string);
                stringArray = string.split("[#]");
                iPSModelV2Service.setModelV2ResScope((IEntity)object2, stringArray[0], stringArray[1]);
            }
        }
        while (true) {
            if (StringHelper.isNullOrEmpty((String)(string = DataObject.getStringValue((Object)object2.get("SRFMODELV2SCOPE"))))) {
                string = iPSModelV2Service.getModelV2ResScope((IEntity)object2);
            }
            if (StringHelper.isNullOrEmpty((String)string)) break;
            object = string.split("[#]");
            if (object == null || ((String[])object).length != 2) {
                log.error((Object)StringHelper.format((String)"\u65e0\u6548\u7684\u8d44\u6e90\u8303\u56f4[%1$s]", (Object)string));
                break;
            }
            try {
                iDataEntityModel = DEModelGlobal.getDEModel((String)object[0]);
                stringArray = iDataEntityModel.getService(this.getSessionFactory());
                IEntity iEntity = iDataEntityModel.createEntity();
                iEntity.set(iDataEntityModel.getKeyDEField().getName(), (Object)object[1]);
                stringArray.get(iEntity);
                ModelV2 modelV2 = new ModelV2();
                modelV2.key = object[1];
                modelV2.type = iDataEntityModel.getName();
                modelV2.text = (String)iEntity.get(iDataEntityModel.getMajorDEField().getName());
                modelV2.tag = PSModelV2Helper.getModelV2TagFolderName(((IPSModelV2Service)stringArray).getModelV2Tag(iEntity));
                arrayList.add(modelV2);
                if (StringHelper.compare((String)modelV2.type, (String)"PSSYSTEM", (boolean)false) == 0) break;
                object2 = iEntity;
                iPSModelV2Service = (IPSModelV2Service)stringArray;
            }
            catch (Exception exception) {
                if (bl) {
                    throw new Exception(StringHelper.format((String)"\u8ba1\u7b97\u5bfc\u5165\u8d44\u6e90\u8303\u56f4[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), exception);
                }
                throw new Exception(StringHelper.format((String)"\u8ba1\u7b97\u5bfc\u51fa\u8d44\u6e90\u8303\u56f4[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), exception);
            }
        }
    }

    protected void popupExportModelV2(ET ET) {
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        Object object = actionSession.getActionParam("EXPORTMODELV2LIST");
        ArrayList arrayList = null;
        if (object == null) {
            actionSession.setActionParam("EXPORTMODELV2LIST", (Object)arrayList);
        } else {
            arrayList = (ArrayList)object;
        }
        arrayList.remove(0);
    }

    protected ModelV2 getLastExportModelV2(String string, int n) {
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        Object object = actionSession.getActionParam("EXPORTMODELV2LIST");
        ArrayList arrayList = null;
        if (object == null) {
            arrayList = new ArrayList();
            actionSession.setActionParam("EXPORTMODELV2LIST", arrayList);
        } else {
            arrayList = (ArrayList)object;
        }
        if (n < 0) {
            n = 0;
        }
        for (int i = n; i < arrayList.size(); ++i) {
            ModelV2 modelV2 = (ModelV2)arrayList.get(i);
            if (StringHelper.compare((String)string, (String)modelV2.type, (boolean)false) != 0) continue;
            modelV2.pos = i;
            return modelV2;
        }
        return null;
    }

    protected void exportRelatedModelV2(ET ET, String string, String string2) throws Exception {
        this.onExportRelatedModelV2(ET, string, string2);
    }

    protected void onExportRelatedModelV2(ET ET, String string, String string2) throws Exception {
    }

    @Override
    public String getModelV2Tag(ET ET) {
        try {
            return DataObject.getStringValue(ET, (String)this.getDEModel().getKeyDEField().getName(), null);
        }
        catch (Exception exception) {
            return null;
        }
    }

    @Override
    public boolean setModelV2Tag(ET ET, String string) {
        return false;
    }

    protected int getExportCurModelV2Level() {
        if (PSCoreSysServiceBase.isSimpleImportExportMode()) {
            return 500;
        }
        return 50;
    }

    @Override
    public void compileModelV2(ET object, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (object == null) {
            object = this.getDEModel().createEntity();
        }
        ET ET = object;
        String string3 = string;
        String string4 = string2;
        ObjectNode objectNode2 = objectNode;
        int n2 = n;
        this.doServiceWork(new IServiceWork((IEntity)ET, objectNode2, string3, string4, n2){
            final /* synthetic */ IEntity val$et2;
            final /* synthetic */ ObjectNode val$objectNode2;
            final /* synthetic */ String val$strFolder2;
            final /* synthetic */ String val$strResFolder2;
            final /* synthetic */ int val$nMode2;
            {
                this.val$et2 = iEntity;
                this.val$objectNode2 = objectNode;
                this.val$strFolder2 = string;
                this.val$strResFolder2 = string2;
                this.val$nMode2 = n;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase.this.pushCompileModelV2(this.val$et2);
                PSCoreSysServiceBase.this.compileCurModelV2(this.val$et2, this.val$objectNode2, this.val$strFolder2, this.val$strResFolder2, this.val$nMode2);
                PSCoreSysServiceBase.this.popupCompileModelV2(this.val$et2);
            }
        }, false);
    }

    protected boolean testCompileCurModelV2(ET ET, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        return true;
    }

    protected void compileCurModelV2(ET ET, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        Object object;
        String string3 = null;
        String string4 = null;
        Map<String, String> map = PSModelV2Helper.getKeyMap();
        if (objectNode == null) {
            if ("YAML".equals(PSCoreSysServiceBase.getModelFormat())) {
                string3 = StringHelper.format((String)"%1$s%2$s%3$s.yaml", (Object)string2, (Object)File.separator, (Object)this.getModelV2Name(ET, true));
                if (StringHelper.compare((String)this.getModelV2Name(ET, true), (String)this.getDEModel().getServiceCodeName(), (boolean)true) != 0 && !((File)(object = new File(string3))).exists()) {
                    string3 = StringHelper.format((String)"%1$s%2$s%3$s.yaml", (Object)string2, (Object)File.separator, (Object)this.getDEModel().getServiceCodeName().toUpperCase());
                }
            } else {
                string3 = StringHelper.format((String)"%1$s%2$s%3$s.json", (Object)string2, (Object)File.separator, (Object)this.getModelV2Name(ET, true));
                if (StringHelper.compare((String)this.getModelV2Name(ET, true), (String)this.getDEModel().getServiceCodeName(), (boolean)true) != 0 && !((File)(object = new File(string3))).exists()) {
                    string3 = StringHelper.format((String)"%1$s%2$s%3$s.json", (Object)string2, (Object)File.separator, (Object)this.getDEModel().getServiceCodeName().toUpperCase());
                }
            }
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                string4 = map.get("SRFLASTFILE");
                map.put("SRFLASTFILE", string3);
            }
            if (!((File)(object = new File(string3))).exists()) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6a21\u578b\u6587\u4ef6"));
            }
            try {
                String string5 = PSModelV2Helper.readFile(string3);
                objectNode = "YAML".equals(PSCoreSysServiceBase.getModelFormat()) ? PSModelYamlHelper.importModel(string5) : (ObjectNode)JsonNodeHelper.fromString((String)string5);
            }
            catch (Exception exception) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b\u6587\u4ef6\u5185\u5bb9\u4e0d\u6b63\u786e"));
            }
        }
        if (!this.testCompileCurModelV2(ET, objectNode, string, string2, n)) {
            return;
        }
        object = this.getLastCompileModelV2(this.getDEModel().getName());
        if (object == null || ((ModelV2)object).pos != 0) {
            log.error((Object)StringHelper.format((String)"\u6700\u8fd1\u7f16\u8bd1\u6a21\u578b\u5bf9\u8c61\u6709\u8bef\uff0c\u5bf9\u8c61[%1$s]\uff0c\u8def\u5f84[%2$s]", (Object)this.getModelV2Name(ET, true), (Object)string3));
            throw new Exception(StringHelper.format((String)"\u6700\u8fd1\u7f16\u8bd1\u6a21\u578b\u5bf9\u8c61\u6709\u8bef\uff0c\u5bf9\u8c61[%1$s|%2$s]", (Object)this.getModelV2Name(ET, true), (Object)this.getModelV2LogicName(ET)));
        }
        try {
            boolean bl = this.fillModelV2Key(ET, objectNode, string, string2, n == 2);
            ((ModelV2)object).key = (String)ET.get(this.getDEModel().getKeyDEField().getName());
            ((ModelV2)object).text = (String)ET.get(this.getDEModel().getMajorDEField().getName());
            ((ModelV2)object).tag = PSModelV2Helper.getModelV2TagFolderName(this.getModelV2Tag(ET));
            if (!bl) {
                String string6 = "";
                ArrayList<ModelV2> arrayList = this.getCompileModelV2List();
                int n2 = arrayList.size();
                if (n2 >= 2) {
                    for (int i = n2 - 2; i >= 0; --i) {
                        if (!StringHelper.isNullOrEmpty((String)string6)) {
                            string6 = string6 + "/";
                        }
                        string6 = string6 + arrayList.get((int)i).tag;
                    }
                }
                ET.set(this.getDEModel().getKeyDEField().getName(), (Object)KeyValueHelper.genUniqueId((String)string6.toUpperCase()));
                ((ModelV2)object).key = (String)ET.get(this.getDEModel().getKeyDEField().getName());
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u7f16\u8bd1\u6a21\u578b\u5bf9\u8c61\u6709\u8bef\uff0c\u5bf9\u8c61[%1$s]\uff0c\u8def\u5f84[%2$s]", (Object)this.getModelV2Name(ET, true), (Object)string3));
            throw new Exception(StringHelper.format((String)"\u7f16\u8bd1\u6a21\u578b\u5bf9\u8c61[%1$s|%2$s]\u6709\u8bef\uff0c%3$s", (Object)this.getModelV2Name(ET, true), (Object)this.getModelV2LogicName(ET), (Object)exception.getMessage()));
        }
        if (n == 1) {
            this.onWriteFileCurModelV2Key(ET, string, objectNode);
        } else {
            this.onWriteFileCurModelV2Data(ET, string);
        }
        this.compileRelatedModelV2(ET, objectNode, string, string2, n);
        if (!StringHelper.isNullOrEmpty((String)string4)) {
            map.put("SRFLASTFILE", string4);
        }
    }

    protected void onWriteFileCurModelV2Key(ET ET, String string, ObjectNode objectNode) throws Exception {
        String string2 = "";
        ArrayList<ModelV2> arrayList = this.getCompileModelV2List();
        int n = arrayList.size();
        if (n >= 2) {
            for (int i = n - 2; i >= 0; --i) {
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    string2 = string2 + "/";
                }
                string2 = string2 + arrayList.get((int)i).tag;
            }
        } else {
            return;
        }
        Map<String, String> map = PSModelV2Helper.getKeyMap();
        if (map != null) {
            String string3;
            String string4 = this.getModelV2Name(ET, true);
            String string5 = StringHelper.format((String)"%1$s/%2$s", (Object)string4, (Object)KeyValueHelper.genUniqueId((String)(string2 = string2.toUpperCase()))).toLowerCase();
            if (map.containsKey(string5)) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s/%2$s]\u6807\u8bc6\u5df2\u5b58\u5728", (Object)string4, (Object)string2));
            }
            String string6 = DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName()));
            Map<String, String> map2 = PSModelV2Helper.getUniqueKeyMap();
            if (map2 != null) {
                string3 = StringHelper.format((String)"%1$s/%2$s", (Object)string4, (Object)string6);
                if (map2.containsKey(string3)) {
                    throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s/%2$s]\u952e\u503c\u5df2\u5b58\u5728\uff0c\u53ef\u5c1d\u8bd5\u4f7f\u7528\u6a21\u578b\u7ec4[PSSYSMODELGROUP]\u89e3\u51b3", (Object)string4, (Object)string2));
                }
                map2.put(string3, "");
            }
            map.put(string5, string6);
            if (this.getDEModel().getInheritDEModel() != null) {
                string4 = this.getDEModel().getInheritDEModel().getName();
                string5 = StringHelper.format((String)"%1$s/%2$s", (Object)string4, (Object)KeyValueHelper.genUniqueId((String)(string2 = string2.toUpperCase()))).toLowerCase();
                if (map.containsKey(string5)) {
                    throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s/%2$s]\u6807\u8bc6\u5df2\u5b58\u5728", (Object)string4, (Object)string2));
                }
                if (map2 != null) {
                    string3 = StringHelper.format((String)"%1$s/%2$s", (Object)string4, (Object)string6);
                    if (map2.containsKey(string3)) {
                        throw new Exception(StringHelper.format((String)"\u6a21\u578b[%1$s/%2$s]\u952e\u503c\u5df2\u5b58\u5728\uff0c\u53ef\u5c1d\u8bd5\u4f7f\u7528\u6a21\u578b\u7ec4[PSSYSMODELGROUP]\u89e3\u51b3", (Object)string4, (Object)string2));
                    }
                    map2.put(string3, "");
                }
                map.put(string5, string6);
            }
        } else {
            String string7 = StringHelper.format((String)"%1$s%2$sKEYS%2$s%3$s", (Object)string, (Object)File.separator, (Object)this.getModelV2Name(ET, true));
            File file = new File(string7);
            if (!file.exists()) {
                file.mkdirs();
            }
            string2 = string2.toUpperCase();
            String string8 = StringHelper.format((String)"%1$s%2$s%3$s.txt", (Object)string7, (Object)File.separator, (Object)KeyValueHelper.genUniqueId((String)string2));
            PSModelV2Helper.writeFile(string8, DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName())), true);
            if (this.getDEModel().getInheritDEModel() != null) {
                string7 = StringHelper.format((String)"%1$s%2$sKEYS%2$s%3$s", (Object)string, (Object)File.separator, (Object)this.getDEModel().getInheritDEModel().getName());
                file = new File(string7);
                if (!file.exists()) {
                    file.mkdirs();
                }
                string2 = string2.toUpperCase();
                string8 = StringHelper.format((String)"%1$s%2$s%3$s.txt", (Object)string7, (Object)File.separator, (Object)KeyValueHelper.genUniqueId((String)string2));
                PSModelV2Helper.writeFile(string8, DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName())), true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void onWriteFileCurModelV2Data(ET ET, String string) throws Exception {
        Object object;
        Integer n;
        Object object2;
        Object object3;
        Map<String, Integer> map;
        ObjectNode objectNode = JsonNodeHelper.createObjectNode();
        if (!StringHelper.isNullOrEmpty((String)string)) {
            map = new HashMap<String, Integer>();
            ET.fillMap(map, false);
            for (Map.Entry object42 : ((HashMap)map).entrySet()) {
                if (object42.getValue() == null || object42.getValue() == DataObject.EMPTY) continue;
                if (object42.getValue() instanceof Timestamp) {
                    JsonNodeHelper.put((ObjectNode)objectNode, (String)((String)object42.getKey()).toLowerCase(), (Object)DateHelper.toDateTimeString((Date)((Timestamp)object42.getValue())));
                    continue;
                }
                JsonNodeHelper.put((ObjectNode)objectNode, (String)((String)object42.getKey()).toLowerCase(), object42.getValue());
            }
        }
        if ((map = PSModelV2Helper.getCounterMap()) != null) {
            object3 = this.getModelV2Name(ET, true);
            Map<String, Integer> map2 = map;
            synchronized (map2) {
                Integer n2 = map.get(object3);
                if (n2 == null) {
                    n2 = 0;
                }
                Integer n3 = n2;
                Integer n4 = n2 = Integer.valueOf(n2 + 1);
                map.put((String)object3, n2);
            }
        }
        map = PSModelV2Helper.getCounterMap2();
        if (map != null) {
            object3 = this.getModelV2Name(ET, true);
            Map<String, Integer> map3 = map;
            synchronized (map3) {
                object2 = map.get(object3);
                if (object2 == null) {
                    object2 = 0;
                }
                n = object2;
                object = object2 = Integer.valueOf((Integer)object2 + 1);
                map.put((String)object3, (Integer)object2);
            }
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            object3 = this.getImportModelV2List();
            ModelV2 modelV2 = new ModelV2();
            modelV2.type = this.getModelV2Name(ET, true);
            modelV2.key = DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName()));
            modelV2.text = DataObject.getStringValue((Object)ET.get(this.getDEModel().getMajorDEField().getName()));
            modelV2.entity = ET;
            ((ArrayList)object3).add(modelV2);
        } else {
            object3 = StringHelper.format((String)"%1$s%2$sDATAS%2$s%3$s", (Object)string, (Object)File.separator, (Object)this.getModelV2Name(ET, true));
            File file = new File((String)object3);
            if (!file.exists()) {
                file.mkdirs();
            }
            object2 = StringHelper.format((String)"%1$s%2$sDATAS%2$s%3$s%2$sALL.txt", (Object)string, (Object)File.separator, (Object)this.getModelV2Name(ET, true));
            n = new ObjectMapper();
            object = n.writeValueAsString(objectNode);
            PSModelV2Helper.appendFile((String)object2, (String)object + "\n\n");
        }
    }

    public boolean fillModelV2Key(ET ET, ObjectNode objectNode, String string, String string2, boolean bl) throws Exception {
        Object object;
        Object object2;
        Object object3;
        String string3 = DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName()));
        if (!bl && !StringHelper.isNullOrEmpty((String)string3)) {
            return true;
        }
        if (!this.getDEModel().getName().equals("PSSYSTEM") && (object3 = this.getLastCompileModelV2("PSSYSTEM")) != null) {
            ET.set("PSSYSTEMID", (Object)((ModelV2)object3).key);
            if (bl && !StringHelper.isNullOrEmpty((String)((ModelV2)object3).text)) {
                ET.set("PSSYSTEMNAME", (Object)((ModelV2)object3).text);
            }
        }
        if ((object3 = this.getDEModel().getDEFields()) != null) {
            while (object3.hasNext()) {
                object2 = (IPSDEFieldModel)object3.next();
                if (object2.isKeyDEField() || ET.contains(object2.getName())) continue;
                if (object2.getName().equals("ENABLE")) {
                    ET.set(object2.getName(), (Object)1);
                    continue;
                }
                object = objectNode.get(object2.getName().toLowerCase());
                if (object == null && StringHelper.compare((String)object2.getName(), (String)object2.getServiceCodeName(), (boolean)true) != 0) {
                    object = objectNode.get(object2.getServiceCodeName().toLowerCase());
                }
                if (object == null || object instanceof NullNode) {
                    if (object2.getName().equals("ENABLE")) continue;
                    ET.set(object2.getName(), null);
                    continue;
                }
                if (DataTypeHelper.isStringDataType((int)object2.getStdDataType())) {
                    ET.set(object2.getName(), (Object)object.asText());
                    continue;
                }
                if (DataTypeHelper.isIntType((int)object2.getStdDataType())) {
                    ET.set(object2.getName(), (Object)object.asInt());
                    continue;
                }
                if (DataTypeHelper.isDoubleType((int)object2.getStdDataType())) {
                    ET.set(object2.getName(), (Object)object.asDouble());
                    continue;
                }
                if (DataTypeHelper.isDateTimeType((int)object2.getStdDataType())) {
                    if (object.isLong()) {
                        ET.set(object2.getName(), (Object)new Timestamp(object.asLong()));
                        continue;
                    }
                    ET.set(object2.getName(), (Object)object.asText());
                    continue;
                }
                ET.set(object2.getName(), (Object)object.asText());
            }
        }
        if (bl) {
            for (int i = 0; i < 2; ++i) {
                object2 = null;
                if (i == 0) {
                    object2 = this.getDEModel().getDERs(false);
                } else if (this.getDEModel().getInheritDEModel() != null) {
                    object2 = this.getDEModel().getInheritDEModel().getDERs(false);
                }
                if (object2 == null) continue;
                block6: while (object2.hasNext()) {
                    Object object4;
                    object = (IDERBase)object2.next();
                    if (!(object instanceof IDER1N)) continue;
                    IDER1NModel iDER1NModel = (IDER1NModel)object;
                    IPSDEFieldModel iPSDEFieldModel = this.getDEModel().getDEField(iDER1NModel.getPickupDEFName(), true);
                    if (iPSDEFieldModel == null || StringHelper.isNullOrEmpty((Object)(object4 = ET.get(iPSDEFieldModel.getName())))) continue;
                    try {
                        ET.set(iPSDEFieldModel.getName(), (Object)this.getModelV2Key(iDER1NModel.getMajorDEName(), (String)object4, string, iPSDEFieldModel.getName()));
                    }
                    catch (Exception exception) {
                        log.error((Object)StringHelper.format((String)"\u8ba1\u7b97\u5c5e\u6027[%1$s|%2$s]\u503c[%3$s]\u53d1\u751f\u5f02\u5e38\uff0c%4$s", (Object)iPSDEFieldModel.getName(), (Object)iPSDEFieldModel.getLogicName(), (Object)object4, (Object)exception.getMessage()), (Throwable)exception);
                        throw new Exception(StringHelper.format((String)"\u8ba1\u7b97\u5c5e\u6027[%1$s|%2$s]\u503c[%3$s]\u53d1\u751f\u5f02\u5e38\uff0c%4$s", (Object)iPSDEFieldModel.getName(), (Object)iPSDEFieldModel.getLogicName(), (Object)object4, (Object)exception.getMessage()), exception);
                    }
                    ModelV2 modelV2 = this.getLastCompileModelV2(iDER1NModel.getMajorDEName());
                    if (modelV2 == null || StringHelper.compare((String)modelV2.key, (String)((String)ET.get(iPSDEFieldModel.getName())), (boolean)false) != 0) continue;
                    Iterator iterator = null;
                    if (i == 0) {
                        iterator = this.getDEModel().getDEFields();
                    } else if (this.getDEModel().getInheritDEModel() != null) {
                        iterator = this.getDEModel().getInheritDEModel().getDEFields();
                    }
                    if (iterator == null) continue;
                    while (iterator.hasNext()) {
                        IDEField iDEField = (IDEField)iterator.next();
                        if (!iDEField.isLinkDEField() || !iDEField.isPhisicalDEField() || !"PICKUPTEXT".equals(iDEField.getDataType()) || StringHelper.compare((String)iDEField.getDERName(), (String)iDER1NModel.getName(), (boolean)false) != 0) continue;
                        Object object5 = ET.get(iDEField.getName());
                        if (!StringHelper.isNullOrEmpty((Object)object5)) continue block6;
                        ET.set(iDEField.getName(), (Object)modelV2.text);
                        continue block6;
                    }
                }
            }
        } else {
            object3 = this.getDEModel().getUnionKeyValueDEFields();
            if (object3 != null) {
                while (object3.hasNext()) {
                    object2 = (IDEField)object3.next();
                    if (!object2.isLinkDEField() || StringHelper.compare((String)object2.getName(), (String)"PSSYSTEMID", (boolean)true) == 0 || StringHelper.isNullOrEmpty((Object)(object = ET.get(object2.getName())))) continue;
                    block9: for (int i = 0; i < 2; ++i) {
                        Iterator iterator = null;
                        if (i == 0) {
                            iterator = this.getDEModel().getDERs(false);
                        } else if (this.getDEModel().getInheritDEModel() != null) {
                            iterator = this.getDEModel().getInheritDEModel().getDERs(false);
                        }
                        if (iterator == null) continue;
                        while (iterator.hasNext()) {
                            IDER1NModel iDER1NModel;
                            IDERBase iDERBase = (IDERBase)iterator.next();
                            if (!(iDERBase instanceof IDER1N) || StringHelper.compare((String)(iDER1NModel = (IDER1NModel)iDERBase).getPickupDEFName(), (String)object2.getName(), (boolean)true) != 0) continue;
                            try {
                                ET.set(object2.getName(), (Object)this.getModelV2Key(iDER1NModel.getMajorDEName(), (String)object, string, object2.getName()));
                            }
                            catch (Exception exception) {
                                log.error((Object)StringHelper.format((String)"\u8ba1\u7b97\u5c5e\u6027[%1$s|%2$s]\u503c[%3$s]\u53d1\u751f\u5f02\u5e38\uff0c%4$s", (Object)object2.getName(), (Object)object2.getLogicName(), (Object)object, (Object)exception.getMessage()), (Throwable)exception);
                                throw new Exception(StringHelper.format((String)"\u8ba1\u7b97\u5c5e\u6027[%1$s|%2$s]\u503c[%3$s]\u53d1\u751f\u5f02\u5e38\uff0c%4$s", (Object)object2.getName(), (Object)object2.getLogicName(), (Object)object, (Object)exception.getMessage()), exception);
                            }
                            i = 3;
                            continue block9;
                        }
                    }
                }
            }
        }
        if (!StringHelper.isNullOrEmpty((String)string3)) {
            return true;
        }
        return this.fillEntityKeyValue((IEntity)ET);
    }

    protected String getModelV2Key(String string, String string2, String string3, String string4) throws Exception {
        Object object;
        Object object2;
        String string5;
        String[] stringArray = string2.split("[/]");
        Map<String, String> map = PSModelV2Helper.getKeyMap();
        if (map != null) {
            Object object3;
            Object object4;
            String string6;
            if (stringArray.length == 1) {
                if (StringHelper.isNullOrEmpty((String)stringArray[0]) || stringArray[0].indexOf("<") == -1) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[0])) {
                        return null;
                    }
                    String string7 = stringArray[0].toUpperCase();
                    String string8 = KeyValueHelper.genUniqueId((String)string7);
                    String string9 = StringHelper.format((String)"%1$s/%2$s", (Object)string, (Object)string8).toLowerCase();
                    String string10 = map.get(string9);
                    if (StringHelper.isNullOrEmpty((String)string10)) {
                        Object object5;
                        Integer n = ignoreExportModelV2Map.get(string);
                        if (n != null) {
                            if (n == 1) {
                                return stringArray[0];
                            }
                            return null;
                        }
                        ModelV2 modelV2 = this.getLastCompileModelV2(string, stringArray[0]);
                        if (modelV2 != null) {
                            return stringArray[0];
                        }
                        if (StringHelper.isNullOrEmpty((String)string3) && (modelV2 = this.getLastCompileModelV2("PSSYSTEM")) != null) {
                            IDataEntityModel iDataEntityModel;
                            object5 = DEModelGlobal.getDEModel((String)"PSSYSTEM").getService(this.getSessionFactory());
                            PSSystem pSSystem = new PSSystem();
                            pSSystem.setPSSystemId(modelV2.key);
                            IEntity iEntity = ((IPSModelV2Service)object5).getModelV2Entity(pSSystem, string, string2);
                            if (iEntity != null && (iDataEntityModel = DEModelGlobal.getDEModel((String)string)) != null && !StringHelper.isNullOrEmpty((String)(string10 = DataObject.getStringValue((Object)iEntity.get(iDataEntityModel.getKeyDEField().getName()))))) {
                                map.put(string9, string10);
                                String string11 = KeyValueHelper.genUniqueId((String)string10.toUpperCase());
                                String string12 = StringHelper.format((String)"%1$s/%2$s", (Object)string, (Object)string11).toLowerCase();
                                map.put(string12, string10);
                                return string10;
                            }
                        }
                        if ((n = ignoreImportModelV2Map.get(string)) != null) {
                            if (n == 1) {
                                return stringArray[0];
                            }
                            return null;
                        }
                        object5 = StringHelper.format((String)"%1$s|%2$s", (Object)this.getDEModel().getName(), (Object)string4);
                        n = ignoreImportModelFieldV2Map.get(object5);
                        if (n != null) {
                            if (n == 1) {
                                return stringArray[0];
                            }
                            return null;
                        }
                        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s](%2$s)", (Object)string, (Object)string2));
                    }
                    return string10;
                }
                String string13 = stringArray[0].replace("<", "").replace(">", "");
                ModelV2 modelV2 = this.getLastCompileModelV2(string13);
                if (modelV2 != null) {
                    return modelV2.key;
                }
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7f16\u8bd1\u6a21\u578b\u5bf9\u8c61[%1$s]", (Object)stringArray[0]));
            }
            String string14 = "";
            for (int i = 0; i < stringArray.length; ++i) {
                if (StringHelper.isNullOrEmpty((String)stringArray[i]) || stringArray[i].indexOf("<") == -1) {
                    if (!StringHelper.isNullOrEmpty((String)string14)) {
                        string14 = string14 + "/";
                    }
                    string14 = string14 + stringArray[i];
                    continue;
                }
                string6 = stringArray[i].replace("<", "").replace(">", "");
                object4 = this.getLastCompileModelV2(string6);
                if (object4 != null) {
                    if (!StringHelper.isNullOrEmpty((String)string14)) {
                        string14 = string14 + "/";
                    }
                    string14 = string14 + ((ModelV2)object4).tag;
                    object3 = this.getCompileModelV2List();
                    int n = ((ArrayList)object3).size();
                    for (int j = ((ModelV2)object4).pos + 1; j < n - 1; ++j) {
                        string14 = ((ModelV2)((ArrayList)object3).get((int)j)).tag + "/" + string14;
                    }
                    continue;
                }
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7f16\u8bd1\u6a21\u578b\u5bf9\u8c61[%1$s]", (Object)stringArray[i]));
            }
            String string15 = KeyValueHelper.genUniqueId((String)string14.toUpperCase());
            string6 = StringHelper.format((String)"%1$s/%2$s", (Object)string, (Object)string15).toLowerCase();
            object4 = map.get(string6);
            if (StringHelper.isNullOrEmpty((String)object4) && StringHelper.isNullOrEmpty((String)string3) && (object3 = this.getLastCompileModelV2("PSSYSTEM")) != null) {
                IDataEntityModel iDataEntityModel;
                IService iService = DEModelGlobal.getDEModel((String)"PSSYSTEM").getService(this.getSessionFactory());
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(((ModelV2)object3).key);
                IEntity iEntity = ((IPSModelV2Service)iService).getModelV2Entity(pSSystem, string, string14);
                if (iEntity != null && (iDataEntityModel = DEModelGlobal.getDEModel((String)string)) != null) {
                    object4 = DataObject.getStringValue((Object)iEntity.get(iDataEntityModel.getKeyDEField().getName()));
                    map.put(string6, (String)object4);
                    String string16 = KeyValueHelper.genUniqueId((String)((String)object4).toUpperCase());
                    String string17 = StringHelper.format((String)"%1$s/%2$s", (Object)string, (Object)string16).toLowerCase();
                    map.put(string17, (String)object4);
                }
            }
            if (StringHelper.isNullOrEmpty((String)object4)) {
                log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s][%2$s]\u5b9e\u9645\u6807\u8bc6\uff0c\u8def\u5f84[%3$s]\u6807\u8bc6[%4$s]", (Object)string, (Object)string2, (Object)string14, (Object)string15));
                object3 = this.getSystemModel().getDataEntityModel(string, true);
                if (object3 != null) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s](%3$s)", (Object)string, (Object)object3.getLogicName(), (Object)string2));
                }
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s](%2$s)", (Object)string, (Object)string2));
            }
            return object4;
        }
        if (stringArray.length == 1) {
            if (StringHelper.isNullOrEmpty((String)stringArray[0]) || stringArray[0].indexOf("<") == -1) {
                if (StringHelper.isNullOrEmpty((String)stringArray[0])) {
                    return null;
                }
                String string18 = stringArray[0].toUpperCase();
                String string19 = KeyValueHelper.genUniqueId((String)string18);
                String string20 = StringHelper.format((String)"%1$s%2$sKEYS%2$s%3$s%2$s%4$s.txt", (Object)string3, (Object)File.separator, (Object)string, (Object)string19);
                File file = new File(string20);
                if (!file.exists()) {
                    Integer n = ignoreExportModelV2Map.get(string);
                    if (n != null) {
                        if (n == 1) {
                            return stringArray[0];
                        }
                        return null;
                    }
                    n = ignoreImportModelV2Map.get(string);
                    if (n != null) {
                        if (n == 1) {
                            return stringArray[0];
                        }
                        return null;
                    }
                    ModelV2 modelV2 = this.getLastCompileModelV2(string, stringArray[0]);
                    if (modelV2 != null) {
                        return stringArray[0];
                    }
                    String string21 = StringHelper.format((String)"%1$s|%2$s", (Object)this.getDEModel().getName(), (Object)string4);
                    n = ignoreImportModelFieldV2Map.get(string21);
                    if (n != null) {
                        if (n == 1) {
                            return stringArray[0];
                        }
                        return null;
                    }
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s](%2$s)", (Object)string, (Object)string2));
                }
                return PSModelV2Helper.readFile(string20);
            }
            String string22 = stringArray[0].replace("<", "").replace(">", "");
            ModelV2 modelV2 = this.getLastCompileModelV2(string22);
            if (modelV2 != null) {
                return modelV2.key;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7f16\u8bd1\u6a21\u578b\u5bf9\u8c61[%1$s]", (Object)stringArray[0]));
        }
        String string23 = "";
        for (int i = 0; i < stringArray.length; ++i) {
            if (StringHelper.isNullOrEmpty((String)stringArray[i]) || stringArray[i].indexOf("<") == -1) {
                if (!StringHelper.isNullOrEmpty((String)string23)) {
                    string23 = string23 + "/";
                }
                string23 = string23 + stringArray[i];
                continue;
            }
            string5 = stringArray[i].replace("<", "").replace(">", "");
            object2 = this.getLastCompileModelV2(string5);
            if (object2 != null) {
                if (!StringHelper.isNullOrEmpty((String)string23)) {
                    string23 = string23 + "/";
                }
                string23 = string23 + ((ModelV2)object2).tag;
                object = this.getCompileModelV2List();
                int n = ((ArrayList)object).size();
                for (int j = ((ModelV2)object2).pos + 1; j < n - 1; ++j) {
                    string23 = ((ModelV2)((ArrayList)object).get((int)j)).tag + "/" + string23;
                }
                continue;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u7f16\u8bd1\u6a21\u578b\u5bf9\u8c61[%1$s]", (Object)stringArray[i]));
        }
        String string24 = KeyValueHelper.genUniqueId((String)string23.toUpperCase());
        string5 = StringHelper.format((String)"%1$s%2$sKEYS%2$s%3$s%2$s%4$s.txt", (Object)string3, (Object)File.separator, (Object)string, (Object)string24);
        object2 = new File(string5);
        if (!((File)object2).exists()) {
            log.error((Object)StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s][%2$s]\u5b9e\u9645\u6807\u8bc6\uff0c\u8def\u5f84[%3$s]\u6807\u8bc6[%4$s]", (Object)string, (Object)string2, (Object)string23, (Object)string24));
            object = this.getSystemModel().getDataEntityModel(string, true);
            if (object != null) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s](%3$s)", (Object)string, (Object)object.getLogicName(), (Object)string2));
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s](%2$s)", (Object)string, (Object)string2));
        }
        return PSModelV2Helper.readFile(string5);
    }

    protected void compileRelatedModelV2(ET ET, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        this.onCompileRelatedModelV2(ET, objectNode, string, string2, n);
    }

    protected void onCompileRelatedModelV2(ET ET, ObjectNode objectNode, String string, String string2, int n) throws Exception {
    }

    protected void pushCompileModelV2(ET ET) throws Exception {
        ArrayList<ModelV2> arrayList = this.getCompileModelV2List();
        ModelV2 modelV2 = new ModelV2();
        modelV2.type = this.getDEModel().getName();
        arrayList.add(0, modelV2);
    }

    protected void popupCompileModelV2(ET ET) {
        ArrayList<ModelV2> arrayList = this.getCompileModelV2List();
        arrayList.remove(0);
    }

    protected ModelV2 getLastCompileModelV2(String string) {
        ArrayList<ModelV2> arrayList = this.getCompileModelV2List();
        for (int i = 0; i < arrayList.size(); ++i) {
            ModelV2 modelV2 = arrayList.get(i);
            if (StringHelper.compare((String)string, (String)modelV2.type, (boolean)false) != 0) continue;
            modelV2.pos = i;
            return modelV2;
        }
        return null;
    }

    protected ModelV2 getLastCompileModelV2(String string, String string2) {
        ArrayList<ModelV2> arrayList = this.getCompileModelV2List();
        for (int i = 0; i < arrayList.size(); ++i) {
            ModelV2 modelV2 = arrayList.get(i);
            if (StringHelper.compare((String)string2, (String)modelV2.key, (boolean)false) != 0) continue;
            if (StringHelper.compare((String)string, (String)modelV2.type, (boolean)false) == 0) {
                modelV2.pos = i;
                return modelV2;
            }
            String string3 = aliasModelV2Map.get(modelV2.type);
            if (StringHelper.isNullOrEmpty((String)string3) || StringHelper.compare((String)string, (String)string3, (boolean)false) != 0) continue;
            modelV2.pos = i;
            return modelV2;
        }
        return null;
    }

    protected ArrayList<ModelV2> getCompileModelV2List() {
        return this.getCompileModelV2List(false);
    }

    protected ArrayList<ModelV2> getCompileModelV2List(boolean bl) {
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        Object object = actionSession.getActionParam("COMPILEMODELV2LIST");
        ArrayList arrayList = null;
        if (object == null || bl) {
            arrayList = new ArrayList();
            actionSession.setActionParam("COMPILEMODELV2LIST", (Object)arrayList);
        } else {
            arrayList = (ArrayList)object;
        }
        return arrayList;
    }

    protected void resetCompileModelV2List() {
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        Object object = actionSession.getActionParam("COMPILEMODELV2LIST");
        if (object != null) {
            actionSession.removeActionParam("COMPILEMODELV2LIST");
        }
    }

    protected ArrayList<ModelV2> getImportModelV2List() {
        return this.getImportModelV2List(false);
    }

    protected ArrayList<ModelV2> getImportModelV2List(boolean bl) {
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        Object object = actionSession.getActionParam("IMPORTMODELV2LIST");
        ArrayList arrayList = null;
        if (object == null || bl) {
            arrayList = new ArrayList();
            actionSession.setActionParam("IMPORTMODELV2LIST", (Object)arrayList);
        } else {
            arrayList = (ArrayList)object;
        }
        return arrayList;
    }

    protected void resetImportModelV2List() {
        ActionSession actionSession = ActionSessionManager.getCurrentSession();
        Object object = actionSession.getActionParam("IMPORTMODELV2LIST");
        if (object != null) {
            actionSession.removeActionParam("IMPORTMODELV2LIST");
        }
    }

    @Override
    public void selectRaw(String string, SqlParamList sqlParamList, IPSRawSelectWork iPSRawSelectWork) throws Exception {
        final String string2 = string;
        final SqlParamList sqlParamList2 = sqlParamList;
        final IPSRawSelectWork iPSRawSelectWork2 = iPSRawSelectWork;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                ((IPSCoreSysDAO)PSCoreSysServiceBase.this.getDAO()).executeRawSelectSql(null, string2, sqlParamList2, iPSRawSelectWork2);
            }
        });
    }

    @Override
    public DBCallResult executeBatchCreate(ArrayList<IEntity> arrayList, int n) throws Exception {
        String string;
        SqlParamList[] sqlParamListArray;
        Object object;
        String[] stringArray;
        String string2;
        if (this.getDEModel().getInheritDEModel() != null) {
            string2 = this.getDEModel().getInheritDEModel().getKeyDEField().getName();
            stringArray = this.getDEModel().getInheritDEModel().getMajorDEField().getName();
            object = this.getDEModel().getInheritTypeValue();
            sqlParamListArray = this.getDEModel().getInheritDEModel().getIndexTypeDEField().getName();
            String string3 = this.getDEModel().getKeyDEField().getName();
            string = this.getDEModel().getMajorDEField().getName();
            for (IEntity iEntity : arrayList) {
                iEntity.set(string2, iEntity.get(string3));
                iEntity.set((String)stringArray, iEntity.get(string));
                if (StringHelper.isNullOrEmpty((String)object)) continue;
                iEntity.set((String)sqlParamListArray, object);
            }
            IPSCoreSysService iPSCoreSysService = (IPSCoreSysService)this.getDEModel().getInheritDEModel().getService(this.getSessionFactory());
            iPSCoreSysService.executeBatchCreate(arrayList, n);
        }
        string2 = PSCoreSysServiceBase.getCreateSqlCommandModel(this.getDAO().getRealDBDialect(), this.getDEModel());
        stringArray = new String[]{string2.getSql()};
        object = new ArrayList();
        for (IEntity iEntity : arrayList) {
            string = new SqlParamList();
            string2.fillSqlParams(iEntity, null, (SqlParamList)string);
            ((ArrayList)object).add(string);
        }
        sqlParamListArray = ((ArrayList)object).toArray(new SqlParamList[((ArrayList)object).size()]);
        int n2 = n;
        string = new CallResult();
        this.doServiceWork(new IServiceWork((CallResult)string, stringArray, sqlParamListArray, n2){
            final /* synthetic */ CallResult val$callResult;
            final /* synthetic */ String[] val$sqls2;
            final /* synthetic */ SqlParamList[] val$sqlParamLists2;
            final /* synthetic */ int val$nBatchSize2;
            {
                this.val$callResult = callResult;
                this.val$sqls2 = stringArray;
                this.val$sqlParamLists2 = sqlParamListArray;
                this.val$nBatchSize2 = n;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase.this.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
                this.val$callResult.setUserObject((Object)PSCoreSysServiceBase.this.getDAO().executeRawSqlBatch(null, this.val$sqls2, this.val$sqlParamLists2, this.val$nBatchSize2));
            }
        });
        return (DBCallResult)string.getUserObject();
    }

    public static ISqlCommandModel getCreateSqlCommandModel(IDBDialect iDBDialect, IDataEntityModel iDataEntityModel) throws Exception {
        Object object;
        StringBuilderEx stringBuilderEx;
        IDEField iDEField;
        SqlCommandModel sqlCommandModel = new SqlCommandModel();
        sqlCommandModel.setDataEntityModel(iDataEntityModel);
        sqlCommandModel.setDBDialect(iDBDialect);
        HashMap<String, StringBuilderEx> hashMap = new HashMap<String, StringBuilderEx>();
        Iterator iterator = iDataEntityModel.getDEFields();
        while (iterator.hasNext()) {
            iDEField = (IDEField)iterator.next();
            if (iDEField.isDynaStorageDEField() || !iDEField.isPhisicalDEField() || iDEField.isInheritDEField() || iDEField.isFormulaDEField()) continue;
            stringBuilderEx = new ProcParam();
            stringBuilderEx.setDataType(iDEField.getStdDataType());
            stringBuilderEx.setParamName(StringHelper.format((String)"VAR_%1$s", (Object)iDEField.getName().toUpperCase()));
            hashMap.put(iDEField.getName(), stringBuilderEx);
        }
        iDEField = new ProcParamList();
        stringBuilderEx = new StringBuilderEx();
        stringBuilderEx.append("INSERT INTO %1$s (", (Object)iDBDialect.getDBObjStandardName(iDataEntityModel.getDEDBConfig(iDBDialect.getDBType()).getTableName()));
        boolean bl = true;
        for (String string : hashMap.keySet()) {
            if (bl) {
                bl = false;
            } else {
                stringBuilderEx.append(",");
            }
            object = iDataEntityModel.getDEField(string, true);
            if (object == null) {
                stringBuilderEx.append(iDBDialect.getDBObjStandardName(string));
                continue;
            }
            stringBuilderEx.append(iDBDialect.getDBObjStandardName(object.getDEFDTColumn(iDBDialect.getDBType()).getColumnName()));
        }
        stringBuilderEx.append(")VALUES(");
        bl = true;
        for (String string : hashMap.keySet()) {
            if (bl) {
                bl = false;
            } else {
                stringBuilderEx.append(",");
            }
            object = hashMap.get(string);
            if (object instanceof ProcParam) {
                stringBuilderEx.append("?");
                iDEField.add((Object)((ProcParam)object));
                continue;
            }
            stringBuilderEx.append((String)object);
        }
        stringBuilderEx.append(")");
        sqlCommandModel.setSql(stringBuilderEx.toString());
        sqlCommandModel.setProcParamList((ProcParamList)iDEField);
        return sqlCommandModel;
    }

    public void updateModelKeeper(ET ET) throws Exception {
        if (!this.isUpdateModelKeeper(ET) || this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        this.doServiceWork(new IServiceWork((IEntity)ET){
            final /* synthetic */ IEntity val$et;
            {
                this.val$et = iEntity;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase.this.onUpdateModelKeeper(this.val$et);
            }
        }, false);
    }

    protected void onUpdateModelKeeper(ET ET) throws Exception {
    }

    protected boolean isUpdateModelKeeper(ET ET) throws Exception {
        return false;
    }

    public void removeModelKeeper(ET ET) throws Exception {
        if (!this.isRemoveModelKeeper(ET) || this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory()) {
            return;
        }
        this.doServiceWork(new IServiceWork((IEntity)ET){
            final /* synthetic */ IEntity val$et;
            {
                this.val$et = iEntity;
            }

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase.this.onRemoveModelKeeper(this.val$et);
            }
        }, false);
    }

    protected void onRemoveModelKeeper(ET ET) throws Exception {
    }

    protected boolean isRemoveModelKeeper(ET ET) throws Exception {
        return this.isUpdateModelKeeper(ET);
    }

    protected String checkFieldDupRule(IDataEntityModel iDataEntityModel, String string, String string2, ET ET, boolean bl, boolean bl2) throws Exception {
        SelectContext selectContext = new SelectContext();
        String[] stringArray = null;
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            stringArray = string2.split("[;]");
        }
        if (!this.fillCheckFieldDupRuleSelectCond(selectContext, iDataEntityModel, string, stringArray, ET, bl, bl2)) {
            return null;
        }
        Object object = ET.get(iDataEntityModel.getKeyDEField().getName());
        ArrayList arrayList = null;
        arrayList = bl2 ? (iDataEntityModel == this.getDEModel() ? this.selectTemp((ISelectCond)selectContext) : iDataEntityModel.getService(this.getSessionFactory()).selectTemp((ISelectCond)selectContext)) : (iDataEntityModel == this.getDEModel() ? this.select((ISelectCond)selectContext) : iDataEntityModel.getService(this.getSessionFactory()).select((ISelectCond)selectContext));
        if (arrayList.size() == 0) {
            return null;
        }
        for (IEntity iEntity : arrayList) {
            Object object2 = iEntity.get(iDataEntityModel.getKeyDEField().getName());
            if (DataTypeHelper.compare((int)iDataEntityModel.getKeyDEField().getStdDataType(), (Object)object, (Object)object2) == 0L) continue;
            Object object3 = ET.get(string);
            return this.getLocalization("CTRL.SERVICE.CHECKFIELDDUPRULE_INFO", new Object[]{object3}, String.format("\u503c[%1$s]\u91cd\u590d", object3));
        }
        return null;
    }

    protected boolean fillCheckFieldDupRuleSelectCond(SelectContext selectContext, IDataEntityModel iDataEntityModel, String string, String[] iEntity, ET ET, boolean bl, boolean bl2) throws Exception {
        Object object;
        boolean bl3 = true;
        boolean bl4 = true;
        Object object2 = ET.get(string);
        selectContext.setConditon(string, object2);
        selectContext.setFetchFirst(true);
        boolean bl5 = false;
        boolean bl6 = false;
        if (this.getSessionFactory() != PSCoreSysServiceBase.getCurMajorSessionFactory() && iEntity != null && ((String[])iEntity).length > 0) {
            boolean bl7 = false;
            boolean bl8 = false;
            object = iEntity;
            int n = ((IEntity)object).length;
            for (int i = 0; i < n; ++i) {
                IEntity iEntity2 = object[i];
                if (StringHelper.compare((String)iEntity2, (String)"PSSYSTEMID", (boolean)true) == 0) {
                    bl7 = true;
                }
                if (StringHelper.compare((String)iEntity2, (String)"PSMODULEID", (boolean)true) != 0) continue;
                bl8 = true;
            }
            if (!bl7 && !this.getDEModel().getName().equals("PSSYSTEM") && (object = this.getDEModel().getDEField("PSSYSTEMID", true)) != null && object.isPhisicalDEField()) {
                bl5 = true;
            }
            if (!bl8 && !this.getDEModel().getName().equals("PSMODULE") && (object = this.getDEModel().getDEField("PSMODULEID", true)) != null && object.isPhisicalDEField()) {
                bl6 = true;
            }
        }
        Object object3 = null;
        if (bl5 && ET.contains("PSSYSTEMID")) {
            object3 = DataObject.getStringValue((Object)ET.get("PSSYSTEMID"), (String)"");
        }
        Object object4 = null;
        if (bl6 && ET.contains("PSMODULEID")) {
            object4 = DataObject.getStringValue((Object)ET.get("PSMODULEID"), (String)"");
        }
        if ((object = this.getLast((IEntity)ET)) != null) {
            Object object5 = object.get(string);
            if (object5 != null) {
                IDEField iDEField = iDataEntityModel.getDEField(string, true);
                boolean bl9 = bl3 = DataTypeHelper.compare((int)iDEField.getStdDataType(), (Object)object2, (Object)object5) != 0L;
            }
            if (bl5 && object3 == null) {
                object3 = object.get("PSSYSTEMID");
            }
            if (bl6 && object4 == null) {
                object4 = object.get("PSMODULEID");
            }
        }
        if (iEntity != null && ((IEntity)iEntity).length > 0) {
            bl4 = false;
            for (IEntity iEntity3 : iEntity) {
                Object object6;
                Object object7 = ET.get((String)iEntity3);
                if (object7 == null && object != null) {
                    object7 = object.get((String)iEntity3);
                }
                if (bl2 && object7 != null && object7 instanceof String && ((String)(object6 = (String)object7)).indexOf("SRFTEMPKEY:") != 0) {
                    return false;
                }
                if (object7 == null) {
                    selectContext.setConditon((String)iEntity3, SelectCond.ISNULL);
                } else {
                    selectContext.setConditon((String)iEntity3, object7);
                }
                if (object != null) {
                    object6 = object.get((String)iEntity3);
                    if (object6 != null) {
                        IDEField iDEField;
                        if (object7 == null || DataTypeHelper.compare((int)(iDEField = iDataEntityModel.getDEField((String)iEntity3, true)).getStdDataType(), (Object)object7, (Object)object6) == 0L) continue;
                        bl4 = true;
                        continue;
                    }
                    if (object7 == null) continue;
                    bl4 = true;
                    continue;
                }
                bl4 = true;
            }
        } else {
            bl4 = false;
        }
        if (!bl3 && !bl4) {
            return false;
        }
        if (bl5 && !StringHelper.isNullOrEmpty((Object)object3)) {
            selectContext.set("PSSYSTEMID", object3);
        }
        if (bl6) {
            if (!StringHelper.isNullOrEmpty((Object)object4)) {
                selectContext.set("PSMODULEID", object4);
            } else {
                selectContext.setConditon("PSMODULEID", SelectCond.ISNULL);
            }
        }
        SelectField selectField = new SelectField();
        selectField.setName(iDataEntityModel.getKeyDEField().getName());
        selectContext.addSelectField((ISelectField)selectField);
        return true;
    }

    protected int getDefaultOrderValue() {
        return 1000;
    }

    protected boolean fillGetDraftDefaultValue(ET ET, boolean bl) throws Exception {
        Map<String, String> map = this.getGetDraftDefaultValueMap(ET, bl);
        if (map == null || map.size() == 0) {
            return false;
        }
        Map<String, Object> map2 = this.getGetDraftDefaultValueScope(ET, bl);
        if (map2 == null || map2.size() == 0) {
            return false;
        }
        return this.fillDefaultValue(ET, bl, map, map2);
    }

    protected Map<String, String> getGetDraftDefaultValueMap(ET ET, boolean bl) {
        return null;
    }

    protected Map<String, Object> getGetDraftDefaultValueScope(ET ET, boolean bl) {
        try {
            if (this.getModelV2ResScopeFields() == null || this.getModelV2ResScopeFields().length == 0) {
                return null;
            }
            String string = "P" + this.getDEModel().getKeyDEField().getName();
            for (String string2 : this.getModelV2ResScopeFields()) {
                Object object;
                if (StringHelper.compare((String)string2, (String)string, (boolean)true) == 0 || (object = ET.get(string2)) == null) continue;
                if (string2 instanceof String && StringHelper.isNullOrEmpty((String)((String)object))) {
                    return null;
                }
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put(string2, object);
                return hashMap;
            }
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
        return null;
    }

    protected Map<String, String> getGetDefaultValueMap(ET ET, boolean bl) {
        return this.getGetDraftDefaultValueMap(ET, bl);
    }

    protected Map<String, Object> getGetDefaultValueScope(ET ET, boolean bl) {
        return this.getGetDraftDefaultValueScope(ET, bl);
    }

    protected boolean fillDefaultValue(ET ET, boolean bl) throws Exception {
        Map<String, String> map = this.getGetDefaultValueMap(ET, bl);
        if (map == null || map.size() == 0) {
            return false;
        }
        Map<String, Object> map2 = this.getGetDefaultValueScope(ET, bl);
        if (map2 == null || map2.size() == 0) {
            return false;
        }
        return this.fillDefaultValue(ET, bl, map, map2);
    }

    /*
     * WARNING - void declaration
     */
    protected boolean fillDefaultValue(ET ET, boolean bl, Map<String, String> map, Map<String, Object> map2) throws Exception {
        int n;
        Object object;
        boolean bl2 = false;
        SelectContext selectContext = new SelectContext();
        for (String object42 : map.keySet()) {
            String string = DataTypeHelper.getStringValue((Object)ET.get(object42));
            if (!StringHelper.isNullOrEmpty((String)string) && string.indexOf("{0}") == -1) continue;
            SelectField selectField = new SelectField();
            selectField.setName(object42);
            selectContext.addSelectField((ISelectField)selectField);
            bl2 = true;
        }
        if (!bl2) {
            return false;
        }
        SelectGroupFilter selectGroupFilter = new SelectGroupFilter();
        selectGroupFilter.setCondOp("AND");
        selectContext.setSelectFilter((ISelectFilter)selectGroupFilter);
        for (Map.Entry<String, Object> entry : map2.entrySet()) {
            SelectFieldFilter selectFieldFilter = new SelectFieldFilter();
            selectFieldFilter.setDEFName(entry.getKey());
            if (entry.getValue() == null) {
                object = ET.get(entry.getKey());
                if (object == null) {
                    selectFieldFilter.setCondOp("ISNULL");
                } else {
                    selectFieldFilter.setCondOp("EQ");
                    selectFieldFilter.setCondObjectValue(object);
                }
            } else {
                selectFieldFilter.setCondOp("EQ");
                object = entry.getValue();
                if (object instanceof String && StringHelper.isNullOrEmpty((String)((String)object))) {
                    object = ET.get(entry.getKey());
                }
                if (object == null) {
                    return false;
                }
                if (bl && object instanceof String && !KeyValueHelper.isTempKey((String)((String)object))) {
                    bl = false;
                }
                selectFieldFilter.setCondObjectValue(object);
            }
            selectGroupFilter.getSelectFilterList(true).add(selectFieldFilter);
        }
        SelectGroupFilter selectGroupFilter2 = new SelectGroupFilter();
        selectGroupFilter2.setCondOp("OR");
        selectGroupFilter.getSelectFilterList(true).add(selectGroupFilter2);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            object = DataTypeHelper.getStringValue((Object)ET.get(entry.getKey()));
            if (!StringHelper.isNullOrEmpty((String)object)) {
                n = ((String)object).indexOf("{0}");
                if (n == -1) continue;
                object = ((String)object).substring(0, n);
            }
            SelectFieldFilter selectFieldFilter = new SelectFieldFilter();
            selectFieldFilter.setDEFName(entry.getKey());
            selectFieldFilter.setCondOp("LEFTLIKE");
            if (StringHelper.isNullOrEmpty((String)object)) {
                selectFieldFilter.setCondValue(entry.getValue());
            } else {
                selectFieldFilter.setCondValue((String)object);
            }
            selectGroupFilter2.getSelectFilterList(true).add(selectFieldFilter);
        }
        Object var9_15 = null;
        if (bl) {
            ArrayList arrayList = this.selectTempEx((ISelectContext)selectContext);
        } else {
            ArrayList arrayList = this.selectEx((ISelectContext)selectContext);
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        int n2 = 0;
        block3: do {
            if (n2 == 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    hashMap.put(entry.getKey(), ET.get(entry.getKey()));
                }
            } else {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    ET.set(entry.getKey(), (Object)entry.getValue());
                }
            }
            ++n2;
            n = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                void var9_18;
                String string = DataTypeHelper.getStringValue((Object)ET.get(entry.getKey()));
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    int n3 = string.indexOf("{0}");
                    if (n3 == -1) continue;
                    string = string.replace("{0}", "%1$s");
                }
                String string2 = null;
                string2 = StringHelper.isNullOrEmpty((String)string) ? StringHelper.format((String)"%1$s%2$s", (Object)entry.getValue(), (Object)(n2 == 1 ? "" : Integer.valueOf(n2))) : StringHelper.format((String)string, (Object)(n2 == 1 ? "" : Integer.valueOf(n2)));
                for (IEntity iEntity : var9_18) {
                    String string3 = DataObject.getStringValue((Object)iEntity.get(entry.getKey()), null);
                    if (StringHelper.compare((String)string2, (String)string3, (boolean)true) != 0) continue;
                    n = 1;
                    break;
                }
                if (n != 0) continue block3;
                ET.set(entry.getKey(), (Object)string2);
            }
        } while (n != 0);
        return true;
    }

    @Override
    public void createBatch(final List<ET> list) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.create(iEntity);
                }
            }
        }, true);
    }

    @Override
    public void createBatch(final List<ET> list, final boolean bl) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.create(iEntity, bl);
                }
            }
        }, true);
    }

    @Override
    public void updateBatch(final List<ET> list) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.update(iEntity);
                }
            }
        }, true);
    }

    @Override
    public void updateBatch(final List<ET> list, final boolean bl) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.update(iEntity, bl);
                }
            }
        }, true);
    }

    @Override
    public void removeBatch(final List<ET> list) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.remove(iEntity);
                }
            }
        }, true);
    }

    @Override
    public void createTempBatch(final List<ET> list) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.createTemp(iEntity);
                }
            }
        }, true);
    }

    @Override
    public void createTempBatch(final List<ET> list, boolean bl) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.createTemp(iEntity);
                }
            }
        }, true);
    }

    @Override
    public void updateTempBatch(final List<ET> list) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.updateTemp(iEntity);
                }
            }
        }, true);
    }

    @Override
    public void updateTempBatch(final List<ET> list, final boolean bl) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.updateTemp(iEntity, bl);
                }
            }
        }, true);
    }

    @Override
    public void removeTempBatch(final List<ET> list) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.removeTemp(iEntity);
                }
            }
        }, true);
    }

    @Override
    public void removeTempMajor(final List<ET> list) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.removeTempMajor(iEntity);
                }
            }
        }, true);
    }

    @Override
    public void saveBatch(final List<ET> list) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.save(iEntity);
                }
            }
        }, true);
    }

    @Override
    public void saveBatch(final List<ET> list, final boolean bl) throws Exception {
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                for (IEntity iEntity : list) {
                    PSCoreSysServiceBase.this.save(iEntity, bl);
                }
            }
        }, true);
    }

    @Override
    public void saveTempBatch(List<ET> list) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void saveTempBatch(List<ET> list, boolean bl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void moveOrder(int n, List<ET> list) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    public void exportModel(ET ET, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.exportModel(ET, arrayList, n);
    }

    protected void logModelObjChanged(ET ET, String string) throws Exception {
    }

    @Override
    public IEntity getModelV2Entity(ET ET, String string, String string2) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception("\u4f20\u5165\u6a21\u578b\u6807\u8bb0\u65e0\u6548");
        }
        String[] stringArray = string2.split("[/]");
        String string3 = DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName()), null);
        if (StringHelper.isNullOrEmpty((String)string3) ? !this.containsModelV2Entity(string, stringArray.length) : !this.containsModelV2Entity(string, stringArray.length + 1)) {
            return null;
        }
        String string4 = "";
        if (StringHelper.isNullOrEmpty((String)string3)) {
            if (!this.getModelV2Entity(ET, stringArray[0])) {
                return null;
            }
            if (stringArray.length == 1) {
                return ET;
            }
            string3 = DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName()), null);
            for (int i = 1; i < stringArray.length; ++i) {
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    string4 = string4 + "/";
                }
                string4 = string4 + stringArray[i];
            }
        } else {
            string4 = string2;
        }
        return this.onGetRelatedModelV2Entity(ET, string, string4);
    }

    protected IEntity onGetRelatedModelV2Entity(ET ET, String string, String string2) throws Exception {
        return null;
    }

    protected boolean getModelV2Entity(ET ET, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        ET.copyTo((IDataObject)selectCond, false);
        ArrayList arrayList = this.select((ISelectCond)selectCond);
        for (IEntity iEntity : arrayList) {
            String string2 = this.getModelV2Tag(iEntity);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            iEntity.copyTo(ET, true);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsModelV2Entity(String string, int n) throws Exception {
        if (n <= 0) {
            return false;
        }
        if (StringHelper.compare((String)string, (String)this.getModelV2Name(true), (boolean)false) == 0 && n == 1) {
            return true;
        }
        return this.onContainsRelatedModelV2Entity(string, n - 1);
    }

    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        return false;
    }

    public static void setSimpleImportExportMode(Boolean bl) {
        simpleImportExportMode.set(bl);
    }

    public static boolean isSimpleImportExportMode() {
        Boolean bl = simpleImportExportMode.get();
        if (bl == null) {
            return false;
        }
        return bl;
    }

    public static boolean isSimpleImportExportMode(String string) {
        return PSCoreSysServiceBase.isSimpleImportExportMode();
    }

    public static void setSimpleImportExportOwner(String string) {
        simpleImportExportOwner.set(string);
    }

    public static String getSimpleImportExportOwner() {
        return simpleImportExportOwner.get();
    }

    protected void doServiceWork(int n, IServiceWork iServiceWork, boolean bl) throws Exception {
        super.doServiceWork(n, iServiceWork, bl);
    }

    @Override
    public String getFullDataInfo(ET ET) throws Exception {
        String string = this.getDEModel().getDataInfo(ET);
        if (StringHelper.isNullOrEmpty((String)string)) {
            return string;
        }
        String string2 = this.getModelV2ResScope((IEntity)ET);
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return string;
        }
        String[] stringArray = string2.split("[#]");
        if (stringArray.length != 2) {
            return string;
        }
        if (StringHelper.compare((String)stringArray[0], (String)"PSSYSTEM", (boolean)true) == 0) {
            return string;
        }
        if (StringHelper.compare((String)stringArray[0], (String)"PSMODULE", (boolean)true) == 0) {
            return string;
        }
        if (StringHelper.isNullOrEmpty((String)stringArray[1])) {
            return string;
        }
        try {
            IDataEntityModel iDataEntityModel = DEModelGlobal.getDEModel((String)stringArray[0]);
            IPSCoreSysService iPSCoreSysService = (IPSCoreSysService)iDataEntityModel.getService(this.getSessionFactory());
            IEntity iEntity = iDataEntityModel.createEntity();
            iEntity.set(iDataEntityModel.getKeyDEField().getName(), (Object)stringArray[1]);
            iPSCoreSysService.get(iEntity);
            String string3 = iPSCoreSysService.getFullDataInfo(iEntity);
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                return string3 + "|" + string;
            }
            return string;
        }
        catch (Exception exception) {
            log.error((Object)exception);
            return string;
        }
    }

    protected void informOPInfo(ET ET, String string) throws Exception {
        try {
            if (!PSCoreSysServiceBase.isEnableOPInfoInformDefault() || PSStudioConsoleHelper.getCurrent() == null) {
                return;
            }
            ActionSession actionSession = ActionSessionManager.getCurrentSession();
            if (actionSession == null) {
                return;
            }
            if (!sysModelLogMap.containsKey(this.getDEModel().getName())) {
                return;
            }
            String string2 = DataObject.getStringValue(ET, (String)this.getDEModel().getKeyDEField().getName(), null);
            if (StringHelper.isNullOrEmpty((String)string2) || KeyValueHelper.isTempKey((String)string2)) {
                return;
            }
            String string3 = StringHelper.format((String)"INFORMOPINFO|%1$s|%2$s", (Object)this.getDEModel().getName(), (Object)string2);
            if (actionSession.getActionParam(string3) != null) {
                return;
            }
            actionSession.setActionParam(string3, (Object)"");
            IWebContext iWebContext = net.ibizsys.paas.web.WebContext.getCurrent();
            if (iWebContext == null) {
                return;
            }
            String string4 = "";
            if (net.ibizsys.paas.web.WebContext.getAppData() != null) {
                string4 = net.ibizsys.paas.web.WebContext.getAppData().optString("psdevslnsysid");
            }
            if (StringHelper.isNullOrEmpty((String)string4)) {
                return;
            }
            String string5 = iWebContext.getCurLoginName();
            if (StringHelper.isNullOrEmpty((String)string5)) {
                string5 = "!\u672a\u77e5\u7528\u6237";
            }
            Object object = ET;
            if (StringHelper.compare((String)string, (String)"DELETE", (boolean)true) == 0) {
                object = this.getLast((IEntity)ET, true);
            }
            if (object == null) {
                object = ET;
            }
            String string6 = PSObjChangeTypeCodeListModel.getInstance().getCodeListText(string, true);
            String string7 = null;
            try {
                string7 = this.getFullDataInfo(object);
            }
            catch (Exception exception) {
                string7 = "!\u65e0\u6cd5\u8ba1\u7b97";
            }
            String string8 = StringHelper.format((String)"%1$s [%2$s] %3$s(%4$s)[%5$s]", (Object)string5, (Object)string6, (Object)this.getDEModel().getLogicName(), (Object)this.getModelV2Name(true), (Object)string7);
            if (StringHelper.compare((String)string, (String)"DELETE", (boolean)true) == 0) {
                string8 = PSStudioConsoleHelper.getContent(string8, 33, -1, 1);
            } else if (StringHelper.compare((String)string, (String)"CREATE", (boolean)true) == 0) {
                string8 = PSStudioConsoleHelper.getContent(string8, 32, -1, 1);
            } else if (StringHelper.compare((String)string, (String)"UPDATE", (boolean)true) == 0) {
                string8 = PSStudioConsoleHelper.getContent(string8, 34, -1, 1);
            }
            final String string9 = string4;
            final String string10 = string8;
            SessionFactoryManager.getCurrentSFS().registerSFSAction(this.getRealSessionFactory(), new ISFSAction(){

                public void commit() {
                    PSStudioConsoleHelper.getCurrent().sendConsole(string9, string10, PSCoreSysServiceBase.LOGGER_OPINFO);
                }

                public void rollback() {
                }
            });
        }
        catch (Exception exception) {
            log.error((Object)exception);
        }
    }

    public void getDraftTempMajorFrom(ET ET) throws Exception {
        super.getDraftTempMajorFrom(ET);
        this.onRemoveEntityUncopyValues((IEntity)ET, true);
    }

    public void getDraftTempFrom(ET ET) throws Exception {
        super.getDraftTempFrom(ET);
        this.onRemoveEntityUncopyValues((IEntity)ET, true);
    }

    @Override
    public PSMOSFile[] listFiles(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        final CallResult callResult = new CallResult();
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        final String string2 = string;
        final IPSMOSFileFilter iPSMOSFileFilter2 = iPSMOSFileFilter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                callResult.setUserObject((Object)PSCoreSysServiceBase.this.internalListFiles(pSMOSFile2, string2, iPSMOSFileFilter2));
            }
        }, false);
        if (callResult.getUserObject() == null) {
            return null;
        }
        return (PSMOSFile[])callResult.getUserObject();
    }

    protected PSMOSFile[] internalListFiles(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        PSMOSFile[] pSMOSFileArray;
        int n;
        String[] stringArray = null;
        if (!StringHelper.isNullOrEmpty((String)string) && !StringHelper.isNullOrEmpty((String)(string = string.trim())) && StringHelper.compare((String)string, (String)"/", (boolean)false) != 0) {
            if (string.indexOf("/") == 0) {
                string = string.substring(1);
            }
            stringArray = string.split("[/]");
        }
        if (stringArray == null || stringArray.length == 0) {
            ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
            PSMOSFile[] pSMOSFileArray2 = this.listCurFiles(pSMOSFile, iPSMOSFileFilter);
            if (pSMOSFileArray2 != null) {
                PSMOSFileUtil.addAll(arrayList, pSMOSFileArray2);
            }
            if ((pSMOSFileArray2 = this.listDRFolders(pSMOSFile, null, iPSMOSFileFilter)) != null) {
                PSMOSFileUtil.addAll(arrayList, pSMOSFileArray2);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            return arrayList.toArray(new PSMOSFile[arrayList.size()]);
        }
        if (stringArray.length == 1) {
            void var5_6 = stringArray[0];
            if (var5_6.indexOf("[") == 0 && var5_6.indexOf("]") == var5_6.length() - 1) {
                return this.listDRFolders(pSMOSFile, (String)var5_6, iPSMOSFileFilter);
            }
            if (var5_6.indexOf("<") == 0 && var5_6.indexOf(">") == var5_6.length() - 1) {
                return this.listDRDataFolders(pSMOSFile, null, (String)var5_6, iPSMOSFileFilter);
            }
            if (PSCoreSysServiceBase.getMOSVer() == 2) {
                return this.listDRDataFolders(pSMOSFile, null, (String)var5_6, iPSMOSFileFilter);
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8def\u5f84\uff1a%1$s", (Object)var5_6));
        }
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = stringArray[0];
        String string7 = stringArray[1];
        if (string6.indexOf("[") == 0 && string6.indexOf("]") == string6.length() - 1) {
            string2 = string6;
            if (string7.indexOf("<") == 0 && string7.indexOf(">") == string7.length() - 1) {
                string3 = string7;
            }
        } else if (string6.indexOf("<") == 0 && string6.indexOf(">") == string6.length() - 1) {
            string3 = string6;
        }
        if (PSCoreSysServiceBase.getMOSVer() == 2) {
            string3 = string6;
        }
        if (StringHelper.isNullOrEmpty((String)string3)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8def\u5f84\uff1a%1$s/%2$s", (Object)string6, (Object)string7));
        }
        int n2 = 0;
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string4 = stringArray[1];
            n2 = 2;
        } else if (stringArray.length > 2) {
            string4 = stringArray[2];
            n2 = 3;
        }
        if (StringHelper.isNullOrEmpty((String)string4)) {
            return this.listDRDataFolders(pSMOSFile, string2, string3, iPSMOSFileFilter);
        }
        for (n = n2; n < stringArray.length; ++n) {
            if (StringHelper.isNullOrEmpty(string5)) {
                string5 = stringArray[n];
                continue;
            }
            string5 = string5 + "/";
            string5 = string5 + stringArray[n];
        }
        n = 0;
        if (!StringHelper.isNullOrEmpty(string5)) {
            n = 1;
        }
        if ((pSMOSFileArray = this.listDRDataFolders(pSMOSFile, string2, string3, null, n != 0)) != null) {
            for (PSMOSFile pSMOSFile2 : pSMOSFileArray) {
                if (!StringHelper.isNullOrEmpty((String)string5) && DataObject.getIntegerValue((Object)pSMOSFile2.getFolderFlag(), (Integer)0) == 0 || StringHelper.isNullOrEmpty((String)pSMOSFile2.getModelV2Tag()) || StringHelper.compare((String)pSMOSFile2.getModelV2Tag(), (String)string4, (boolean)true) != 0) continue;
                IDataEntityModel iDataEntityModel = this.getSystemModel().getDataEntityModel(pSMOSFile2.getPSModelType());
                IPSMOSFileService iPSMOSFileService = (IPSMOSFileService)iDataEntityModel.getService(this.getSessionFactory());
                return iPSMOSFileService.listFiles(pSMOSFile2, string5, iPSMOSFileFilter);
            }
            for (PSMOSFile pSMOSFile2 : pSMOSFileArray) {
                if (!StringHelper.isNullOrEmpty((String)string5) && DataObject.getIntegerValue((Object)pSMOSFile2.getFolderFlag(), (Integer)0) == 0 || StringHelper.compare((String)pSMOSFile2.getPSMOSFileName(), (String)string4, (boolean)true) != 0) continue;
                IDataEntityModel iDataEntityModel = this.getSystemModel().getDataEntityModel(pSMOSFile2.getPSModelType());
                IPSMOSFileService iPSMOSFileService = (IPSMOSFileService)iDataEntityModel.getService(this.getSessionFactory());
                return iPSMOSFileService.listFiles(pSMOSFile2, string5, iPSMOSFileFilter);
            }
        }
        return null;
    }

    @Override
    public PSMOSFile getFile(PSMOSFile pSMOSFile, String string) throws Exception {
        final CallResult callResult = new CallResult();
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        final String string2 = string;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                callResult.setUserObject((Object)PSCoreSysServiceBase.this.internalGetFile(pSMOSFile2, string2));
            }
        }, false);
        if (callResult.getUserObject() == null) {
            return null;
        }
        return (PSMOSFile)callResult.getUserObject();
    }

    protected PSMOSFile internalGetFile(PSMOSFile pSMOSFile, String string) throws Exception {
        PSMOSFile[] pSMOSFileArray;
        int n;
        String[] stringArray = null;
        if (!StringHelper.isNullOrEmpty((String)string) && !StringHelper.isNullOrEmpty((String)(string = string.trim())) && StringHelper.compare((String)string, (String)"/", (boolean)false) != 0) {
            if (string.indexOf("/") == 0) {
                string = string.substring(1);
            }
            stringArray = string.split("[/]");
        }
        if (stringArray == null || stringArray.length == 0) {
            if (PSCoreSysServiceBase.getMOSVer() == 2 && pSMOSFile.getRealEntity() != null) {
                this.fillPSMOSFile(pSMOSFile, pSMOSFile.getRealEntity(), null);
            }
            return pSMOSFile;
        }
        if (stringArray.length == 1) {
            void var4_4 = stringArray[0];
            PSMOSFile[] pSMOSFileArray2 = this.listDRFolders(pSMOSFile, null, null);
            if (pSMOSFileArray2 != null && pSMOSFileArray2.length > 0) {
                for (PSMOSFile pSMOSFile2 : pSMOSFileArray2) {
                    String string2 = pSMOSFile2.getModelV2Tag();
                    if (StringHelper.isNullOrEmpty((String)string2)) {
                        string2 = pSMOSFile2.getPSMOSFileName();
                    }
                    if (StringHelper.compare((String)string2, (String)var4_4, (boolean)false) != 0) continue;
                    return pSMOSFile2;
                }
            }
            return null;
        }
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        String string7 = stringArray[0];
        String string8 = stringArray[1];
        if (string7.indexOf("[") == 0 && string7.indexOf("]") == string7.length() - 1) {
            string3 = string7;
            if (string8.indexOf("<") == 0 && string8.indexOf(">") == string8.length() - 1) {
                string4 = string8;
            }
        } else if (string7.indexOf("<") == 0 && string7.indexOf(">") == string7.length() - 1) {
            string4 = string7;
        }
        if (PSCoreSysServiceBase.getMOSVer() == 2) {
            string4 = string7;
        }
        if (StringHelper.isNullOrEmpty((String)string4)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8bc6\u522b\u7684\u8def\u5f84\uff1a%1$s/%2$s", (Object)string7, (Object)string8));
        }
        int n2 = 0;
        if (StringHelper.isNullOrEmpty((String)string3)) {
            string5 = stringArray[1];
            n2 = 2;
        } else if (stringArray.length > 2) {
            string5 = stringArray[2];
            n2 = 3;
        }
        if (StringHelper.isNullOrEmpty((String)string5)) {
            PSMOSFile[] pSMOSFileArray3;
            if (!StringHelper.isNullOrEmpty((String)string3) && !StringHelper.isNullOrEmpty((String)string4) && (pSMOSFileArray3 = this.listDRFolders(pSMOSFile, string3, null)) != null && pSMOSFileArray3.length > 0) {
                for (PSMOSFile pSMOSFile3 : pSMOSFileArray3) {
                    String string9 = pSMOSFile3.getModelV2Tag();
                    if (StringHelper.isNullOrEmpty((String)string9)) {
                        string9 = pSMOSFile3.getPSMOSFileName();
                    }
                    if (StringHelper.compare((String)string9, (String)string4, (boolean)false) != 0) continue;
                    return pSMOSFile3;
                }
            }
            return null;
        }
        for (n = n2; n < stringArray.length; ++n) {
            if (StringHelper.isNullOrEmpty(string6)) {
                string6 = stringArray[n];
                continue;
            }
            string6 = string6 + "/";
            string6 = string6 + stringArray[n];
        }
        n = 0;
        if (!StringHelper.isNullOrEmpty(string6)) {
            n = 1;
        }
        if ((pSMOSFileArray = this.listDRDataFolders(pSMOSFile, string3, string4, null, n != 0)) != null) {
            for (PSMOSFile pSMOSFile4 : pSMOSFileArray) {
                if (!StringHelper.isNullOrEmpty((String)string6) && DataObject.getIntegerValue((Object)pSMOSFile4.getFolderFlag(), (Integer)0) == 0 || StringHelper.isNullOrEmpty((String)pSMOSFile4.getModelV2Tag()) || StringHelper.compare((String)pSMOSFile4.getModelV2Tag(), (String)string5, (boolean)true) != 0) continue;
                IDataEntityModel iDataEntityModel = this.getSystemModel().getDataEntityModel(pSMOSFile4.getPSModelType());
                IPSMOSFileService iPSMOSFileService = (IPSMOSFileService)iDataEntityModel.getService(this.getSessionFactory());
                return iPSMOSFileService.getFile(pSMOSFile4, string6);
            }
            for (PSMOSFile pSMOSFile4 : pSMOSFileArray) {
                if (!StringHelper.isNullOrEmpty((String)string6) && DataObject.getIntegerValue((Object)pSMOSFile4.getFolderFlag(), (Integer)0) == 0 || StringHelper.compare((String)pSMOSFile4.getPSMOSFileName(), (String)string5, (boolean)true) != 0) continue;
                IDataEntityModel iDataEntityModel = this.getSystemModel().getDataEntityModel(pSMOSFile4.getPSModelType());
                IPSMOSFileService iPSMOSFileService = (IPSMOSFileService)iDataEntityModel.getService(this.getSessionFactory());
                return iPSMOSFileService.getFile(pSMOSFile4, string6);
            }
        }
        return null;
    }

    @Override
    public PSMOSFile[] pasteFiles(IEntity iEntity, PSMOSFile[] pSMOSFileArray, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        final CallResult callResult = new CallResult();
        final PSMOSFile[] pSMOSFileArray2 = pSMOSFileArray;
        final IEntity iEntity2 = iEntity;
        final IPSMOSFileAction iPSMOSFileAction2 = iPSMOSFileAction;
        final String string2 = string;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                callResult.setUserObject((Object)PSCoreSysServiceBase.this.internalPasteFiles(iEntity2, pSMOSFileArray2, string2, iPSMOSFileAction2));
            }
        }, false);
        if (callResult.getUserObject() == null) {
            return null;
        }
        return (PSMOSFile[])callResult.getUserObject();
    }

    protected PSMOSFile[] internalPasteFiles(ET ET, PSMOSFile[] pSMOSFileArray, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        String string2 = this.getCurUserName();
        ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
        for (PSMOSFile pSMOSFile : pSMOSFileArray) {
            try {
                PSMOSFile pSMOSFile2 = this.onPasteFile(ET, pSMOSFile, string, iPSMOSFileAction);
                if (pSMOSFile2 == null) continue;
                arrayList.add(pSMOSFile2);
                JSONObject jSONObject = new JSONObject();
                JSONObjectHelper.put((JSONObject)jSONObject, (String)"type", (Object)"COMMAND");
                JSONObjectHelper.put((JSONObject)jSONObject, (String)"subtype", (Object)"OBJECTCREATED");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("srfdename", (Object)pSMOSFile2.getPSModelType());
                jSONObject2.put("srfkey", (Object)pSMOSFile2.getPSModelId());
                jSONObject2.put("srfmajortext", (Object)pSMOSFile2.getPSMOSFileName());
                jSONObject2.put("srfpath", (Object)pSMOSFile2.getPSMOSFileId());
                JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)jSONObject2);
                this.sendStudioConsole(true, "INFO", StringHelper.format((String)"%1$s \u5c06\u6a21\u578b[%2$s]\u7c98\u8d34\u5230[%3$s]", (Object)string2, (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile2.getPSMOSFileId()), LOGGER_OPINFO, jSONObject.toString(), false);
            }
            catch (Exception exception) {
                log.error((Object)exception);
                this.sendStudioConsole(true, "ERROR", StringHelper.format((String)"%1$s \u7c98\u8d34\u6a21\u578b[%2$s]\u53d1\u751f\u5f02\u5e38\uff0c%3$s", (Object)string2, (Object)pSMOSFile.getPSMOSFileId(), (Object)exception.getMessage()), LOGGER_OPINFO, null, false);
            }
        }
        return arrayList.toArray(new PSMOSFile[arrayList.size()]);
    }

    protected PSMOSFile onPasteFile(ET ET, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u9ecf\u8d34\u6587\u4ef6[%1$s]\u5230[%2%s]", (Object)pSMOSFile.getPSModelType(), (Object)this.getDEModel().getName()));
    }

    @Override
    public PSMOSFile getFile(IEntity iEntity) throws Exception {
        final CallResult callResult = new CallResult();
        final IEntity iEntity2 = iEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                callResult.setUserObject((Object)PSCoreSysServiceBase.this.internalGetFile(iEntity2));
            }
        }, false);
        return (PSMOSFile)callResult.getUserObject();
    }

    protected PSMOSFile internalGetFile(ET ET) throws Exception {
        IEntity iEntity;
        if (StringHelper.compare((String)this.getDEModel().getName(), (String)"PSSYSTEM", (boolean)true) == 0) {
            PSMOSFile pSMOSFile = new PSMOSFile();
            pSMOSFile.setPSMOSFileId("/");
            pSMOSFile.setPSModelType(this.getModelV2Name(true));
            pSMOSFile.setPSModelId(DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName())));
            pSMOSFile.setPSMOSFileName(this.getFileName((IEntity)ET));
            pSMOSFile.setFolderFlag(1);
            pSMOSFile.setFileTag("MODEL");
            return pSMOSFile;
        }
        String string = this.getModelV2ResScope((IEntity)ET);
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b\u57df"));
        }
        String[] stringArray = string.split("[#]");
        if (stringArray == null || stringArray.length != 2) {
            throw new Exception(StringHelper.format((String)"\u6a21\u578b\u57df[%1$s]\u4e0d\u6b63\u786e", (Object)string));
        }
        String string2 = this.getModelV2ResScopeDER((IEntity)ET);
        IDataEntityModel iDataEntityModel = this.getSystemModel().getDataEntityModel(stringArray[0]);
        IService iService = iDataEntityModel.getService(this.getSessionFactory());
        IPSMOSFileService iPSMOSFileService = (IPSMOSFileService)iService;
        PSMOSFile pSMOSFile = iPSMOSFileService.getFile(iEntity = PSCoreSysServiceBase.getActionCacheEntity(iService, stringArray[1]));
        String string3 = pSMOSFile.getPSMOSFileId();
        if (StringHelper.compare((String)string3, (String)"/", (boolean)false) == 0) {
            string3 = "";
        }
        String string4 = iPSMOSFileService.getDRFolderPath(string2, (IEntity)ET, null);
        if (PSCoreSysServiceBase.getMOSVer() == 2 && StringHelper.isNullOrEmpty((String)string4)) {
            string4 = Inflector.getInstance().pluralize(this.getDEModel().getName().toLowerCase());
        }
        if (!StringHelper.isNullOrEmpty((String)string4)) {
            if (!StringHelper.isNullOrEmpty((String)string3)) {
                string3 = string3 + "/";
            }
            string3 = string3 + string4;
        }
        if (!StringHelper.isNullOrEmpty((String)string3)) {
            string3 = string3 + "/";
        }
        String string5 = PSModelV2Helper.getModelV2TagFolderName(this.getModelV2Tag(ET));
        string3 = string3 + string5;
        PSMOSFile pSMOSFile2 = new PSMOSFile();
        if (!StringHelper.isNullOrEmpty((String)string3) && string3.charAt(0) != '/') {
            string3 = "/" + string3;
        }
        pSMOSFile2.setPSMOSFileId(string3);
        pSMOSFile2.setPSModelType(this.getModelV2Name(true));
        Object object = this.getDataType(ET);
        if (object != null) {
            if (object instanceof String) {
                pSMOSFile2.setPSModelSubType((String)object);
            } else {
                pSMOSFile2.setPSModelSubType(StringHelper.format((String)"%1$s", (Object)object));
            }
        }
        pSMOSFile2.setPSModelId(DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName())));
        pSMOSFile2.setModelV2Tag(string5);
        pSMOSFile2.setPSMOSFileName(this.getFileName((IEntity)ET));
        pSMOSFile2.setFolderFlag(this.isOutputDRFolders() ? 1 : 0);
        pSMOSFile2.setFileTag("MODEL");
        pSMOSFile2.setFileTag4(this.getFileLogicName((IEntity)ET));
        return pSMOSFile2;
    }

    @Override
    public PSMOSFile getFile(PSMOSFile pSMOSFile, IEntity iEntity) throws Exception {
        return this.getFile(pSMOSFile, iEntity, false);
    }

    @Override
    public PSMOSFile getFile(PSMOSFile pSMOSFile, IEntity iEntity, boolean bl) throws Exception {
        final CallResult callResult = new CallResult();
        final IEntity iEntity2 = iEntity;
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        final boolean bl2 = bl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                callResult.setUserObject((Object)PSCoreSysServiceBase.this.internalGetFile(pSMOSFile2, iEntity2, bl2));
            }
        }, false);
        return (PSMOSFile)callResult.getUserObject();
    }

    protected PSMOSFile internalGetFile(PSMOSFile pSMOSFile, ET ET, boolean bl) throws Exception {
        Object object;
        if (StringHelper.compare((String)this.getDEModel().getName(), (String)"PSSYSTEM", (boolean)true) == 0) {
            PSMOSFile pSMOSFile2 = new PSMOSFile();
            pSMOSFile2.setPSMOSFileId("/");
            pSMOSFile2.setPSModelType(this.getModelV2Name(true));
            pSMOSFile2.setPSModelId(DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName())));
            pSMOSFile2.setPSMOSFileName(this.getFileName((IEntity)ET));
            pSMOSFile2.setFolderFlag(1);
            pSMOSFile2.setFileTag("MODEL");
            pSMOSFile2.setFileTag4(this.getFileLogicName((IEntity)ET));
            if (PSCoreSysServiceBase.getMOSVer() != 1) {
                pSMOSFile2.setRealEntity((IEntity)ET);
            }
            return pSMOSFile2;
        }
        boolean bl2 = false;
        String string = this.getModelV2ResScope((IEntity)ET);
        if (StringHelper.isNullOrEmpty((String)string)) {
            if (PSCoreSysServiceBase.getMOSVer() == 2) {
                return null;
            }
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b\u57df"));
        }
        if (pSMOSFile != null) {
            object = string.split("[#]");
            if (object == null || ((String[])object).length != 2) {
                throw new Exception(StringHelper.format((String)"\u6a21\u578b\u57df[%1$s]\u4e0d\u6b63\u786e", (Object)string));
            }
            if (StringHelper.compare((String)object[0], (String)pSMOSFile.getPSModelType(), (boolean)false) != 0 || StringHelper.compare((String)object[0], (String)pSMOSFile.getPSModelType(), (boolean)false) != 0) {
                bl2 = true;
            }
            if (bl2 && bl) {
                return null;
            }
        }
        object = new PSMOSFile();
        ((PSMOSFileBase)object).setPSModelType(this.getModelV2Name(true));
        Object object2 = this.getDataType(ET);
        if (object2 != null) {
            if (object2 instanceof String) {
                ((PSMOSFileBase)object).setPSModelSubType((String)object2);
            } else {
                ((PSMOSFileBase)object).setPSModelSubType(StringHelper.format((String)"%1$s", (Object)object2));
            }
        }
        ((PSMOSFileBase)object).setPSModelId(DataObject.getStringValue((Object)ET.get(this.getDEModel().getKeyDEField().getName())));
        ((PSMOSFileBase)object).setModelV2Tag(PSModelV2Helper.getModelV2TagFolderName(this.getModelV2Tag(ET)));
        ((PSMOSFileBase)object).setPSMOSFileName(this.getFileName((IEntity)ET));
        if (bl2) {
            ((PSMOSFileBase)object).setFolderFlag(this.isOutputDRFolders() ? 1 : 0);
            ((PSMOSFileBase)object).setFileTag("LINK");
            PSMOSFile pSMOSFile3 = this.getFile((IEntity)ET);
            ((PSMOSFileBase)object).setFileTag2(pSMOSFile3.getPSMOSFileId());
            String string2 = this.getModelV2ResScopeText((IEntity)ET);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                ((PSMOSFileBase)object).setPSMOSFileName(((PSMOSFileBase)object).getPSMOSFileName() + "@" + string2);
            }
            ((PSMOSFileBase)object).setFileTag4(this.getFileLogicName((IEntity)ET));
        } else {
            ((PSMOSFileBase)object).setFolderFlag(this.isOutputDRFolders() ? 1 : 0);
            ((PSMOSFileBase)object).setFileTag("MODEL");
            ((PSMOSFileBase)object).setFileTag4(this.getFileLogicName((IEntity)ET));
            if (PSCoreSysServiceBase.getMOSVer() == 1) {
                this.fillPSMOSFile((PSMOSFile)object, ET, pSMOSFile);
            } else {
                ((PSMOSFile)object).setRealEntity((IEntity)ET);
            }
        }
        return object;
    }

    protected void fillPSMOSFile(PSMOSFile pSMOSFile, ET ET, PSMOSFile pSMOSFile2) throws Exception {
        if (DataObject.getStringValue((Object)ET.get("color")) != null) {
            pSMOSFile.setColor(DataObject.getStringValue((Object)ET.get("color")));
        }
        if (DataObject.getIntegerValue((Object)ET.get("ordervalue"), null) != null) {
            pSMOSFile.setOrderValue(DataObject.getIntegerValue((Object)ET.get("ordervalue"), null));
        }
        if (PSCoreSysServiceBase.getMOSVer() == 2) {
            return;
        }
        pSMOSFile.setData(this.getPSMOSFileData(pSMOSFile, ET, pSMOSFile2));
    }

    protected String getPSMOSFileData(PSMOSFile pSMOSFile, ET ET, PSMOSFile pSMOSFile2) throws Exception {
        if (PSCoreSysServiceBase.getMOSVer() == 2) {
            return null;
        }
        return PSModelV2Helper.toJSONString(ET, false);
    }

    @Override
    public PSMOSFile getFileSummary(PSMOSFile pSMOSFile, IEntity iEntity) throws Exception {
        final CallResult callResult = new CallResult();
        final IEntity iEntity2 = iEntity;
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMOSFile[] pSMOSFileArray;
                PSMOSFile pSMOSFile = PSCoreSysServiceBase.this.internalGetFile(pSMOSFile2, iEntity2, true);
                if (pSMOSFile != null && (pSMOSFileArray = PSCoreSysServiceBase.this.listFiles(pSMOSFile2, pSMOSFile.getPSMOSFileId(), null)) != null) {
                    ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
                    for (PSMOSFile pSMOSFile22 : pSMOSFileArray) {
                        PSMOSFile[] pSMOSFileArray2 = PSCoreSysServiceBase.this.listFiles(pSMOSFile2, pSMOSFile22.getPSMOSFileId(), null);
                        if (pSMOSFileArray2 == null) continue;
                        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
                        for (PSMOSFile pSMOSFile3 : pSMOSFileArray2) {
                            arrayList2.add(pSMOSFile3);
                        }
                        pSMOSFile22.setPSMOSFiles(arrayList2);
                        arrayList.add(pSMOSFile22);
                    }
                    if (arrayList.size() > 0) {
                        pSMOSFile.setPSMOSFiles(arrayList);
                    }
                }
                callResult.setUserObject((Object)pSMOSFile);
            }
        }, false);
        return (PSMOSFile)callResult.getUserObject();
    }

    @Override
    public PSMOSFile getFileSummary(PSMOSFile pSMOSFile, String string) throws Exception {
        final CallResult callResult = new CallResult();
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        final String string2 = string;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMOSFile[] pSMOSFileArray;
                PSMOSFile pSMOSFile = PSCoreSysServiceBase.this.internalGetFile(pSMOSFile2, string2);
                if (pSMOSFile != null && (pSMOSFileArray = PSCoreSysServiceBase.this.listFiles(pSMOSFile2, pSMOSFile.getPSMOSFileId(), null)) != null) {
                    ArrayList<PSMOSFile> arrayList = new ArrayList<PSMOSFile>();
                    for (PSMOSFile pSMOSFile22 : pSMOSFileArray) {
                        PSMOSFile[] pSMOSFileArray2 = PSCoreSysServiceBase.this.listFiles(pSMOSFile2, pSMOSFile22.getPSMOSFileId(), null);
                        if (pSMOSFileArray2 == null) continue;
                        ArrayList<PSMOSFile> arrayList2 = new ArrayList<PSMOSFile>();
                        for (PSMOSFile pSMOSFile3 : pSMOSFileArray2) {
                            arrayList2.add(pSMOSFile3);
                        }
                        pSMOSFile22.setPSMOSFiles(arrayList2);
                        arrayList.add(pSMOSFile22);
                    }
                    if (arrayList.size() > 0) {
                        pSMOSFile.setPSMOSFiles(arrayList);
                    }
                }
                callResult.setUserObject((Object)pSMOSFile);
            }
        }, false);
        if (callResult.getUserObject() == null) {
            return null;
        }
        return (PSMOSFile)callResult.getUserObject();
    }

    @Override
    public String getFileWiki(PSMOSFile pSMOSFile, String string) throws Exception {
        final CallResult callResult = new CallResult();
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        final String string2 = string;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                String string = PSCoreSysServiceBase.this.internalGetFileWiki(pSMOSFile2, string2);
                callResult.setUserObject((Object)string);
            }
        }, false);
        if (callResult.getUserObject() == null) {
            return null;
        }
        return (String)callResult.getUserObject();
    }

    protected String internalGetFileWiki(PSMOSFile pSMOSFile, String string) throws Exception {
        if (!PSCoreSysServiceBase.isEnableGitLabPlugin()) {
            throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
        }
        String string2 = PSCoreSysServiceBase.getCurrentPSDevSlnSysId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf");
        }
        PSMOSFile pSMOSFile2 = this.internalGetFile(pSMOSFile, string);
        if (pSMOSFile2 == null) {
            return null;
        }
        return this.internalGetFileWiki(pSMOSFile2);
    }

    protected String internalGetFileWiki(PSMOSFile pSMOSFile) throws Exception {
        if (!PSCoreSysServiceBase.isEnableGitLabPlugin()) {
            throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
        }
        String string = PSCoreSysServiceBase.getCurrentPSDevSlnSysId();
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf");
        }
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        pSDevSlnSys.setPSDevSlnSysId(string);
        if (!pSDevSlnSysService.get((IEntity)pSDevSlnSys, true)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf");
        }
        String string2 = String.format("mos%1$s", pSMOSFile.getPSMOSFileId());
        try {
            WikiPage wikiPage = PSCoreSysServiceBase.getPSGitLabPlugin().getWikiPage(pSDevSlnSys, string2, true);
            if (wikiPage != null) {
                return wikiPage.getContent();
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6Wiki\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u83b7\u53d6Wiki\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
        return null;
    }

    @Override
    public void updateFileWiki(PSMOSFile pSMOSFile, String string, String string2) throws Exception {
        CallResult callResult = new CallResult();
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        final String string3 = string;
        final String string4 = string2;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase.this.internalUpdateFileWiki(pSMOSFile2, string3, string4);
            }
        }, false);
    }

    protected void internalUpdateFileWiki(PSMOSFile pSMOSFile, String string, String string2) throws Exception {
        if (!PSCoreSysServiceBase.isEnableGitLabPlugin()) {
            throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
        }
        String string3 = PSCoreSysServiceBase.getCurrentPSDevSlnSysId();
        if (StringHelper.isNullOrEmpty((String)string3)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf");
        }
        PSMOSFile pSMOSFile2 = this.internalGetFile(pSMOSFile, string);
        if (pSMOSFile2 == null) {
            return;
        }
        this.internalUpdateFileWiki(pSMOSFile2, string2);
    }

    protected void internalUpdateFileWiki(PSMOSFile pSMOSFile, String string) throws Exception {
        if (!PSCoreSysServiceBase.isEnableGitLabPlugin()) {
            throw new Exception("\u5f53\u524d\u73af\u5883\u4e0d\u652f\u6301\u6b64\u64cd\u4f5c");
        }
        String string2 = PSCoreSysServiceBase.getCurrentPSDevSlnSysId();
        if (StringHelper.isNullOrEmpty((String)string2)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u5f53\u524d\u5f00\u53d1\u7cfb\u7edf");
        }
        PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
        PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        pSDevSlnSys.setPSDevSlnSysId(string2);
        if (!pSDevSlnSysService.get((IEntity)pSDevSlnSys, true)) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf");
        }
        String string3 = String.format("mos%1$s", pSMOSFile.getPSMOSFileId());
        try {
            PSCoreSysServiceBase.getPSGitLabPlugin().updateWikiPage(pSDevSlnSys, string3, null, string, true);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u66f4\u65b0Wiki\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
            throw new Exception(StringHelper.format((String)"\u66f4\u65b0Wiki\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    @Override
    public String getFileAutoWiki(PSMOSFile pSMOSFile, String string, String string2) throws Exception {
        return null;
    }

    @Override
    public String getFileAutoWiki(IEntity iEntity, String string) throws Exception {
        return null;
    }

    @Override
    public String getFileAutoIssue(PSMOSFile pSMOSFile, String string, String string2) throws Exception {
        return null;
    }

    @Override
    public String getFileAutoIssue(IEntity iEntity, String string) throws Exception {
        return null;
    }

    protected PSMOSFile[] listCurFiles(PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        return null;
    }

    protected PSMOSFile[] listDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        PSMOSFile[] pSMOSFileArray = this.onListDRFolders(pSMOSFile, string, iPSMOSFileFilter);
        if (pSMOSFileArray != null) {
            for (PSMOSFile pSMOSFile2 : pSMOSFileArray) {
                PSMOSFile pSMOSFile3;
                ArrayNode arrayNode;
                if (StringHelper.isNullOrEmpty((String)pSMOSFile2.getPSModelId())) {
                    pSMOSFile2.setPSModelType(pSMOSFile.getPSModelType());
                    pSMOSFile2.setPSModelId(pSMOSFile.getPSModelId());
                    pSMOSFile2.setPSModelSubType(pSMOSFile.getPSModelSubType());
                }
                if (!StringHelper.isNullOrEmpty((String)pSMOSFile2.getPSMOSFileId())) continue;
                String string2 = pSMOSFile.getPSMOSFileId();
                if (StringHelper.compare((String)string2, (String)"/", (boolean)true) == 0) {
                    string2 = "";
                }
                string2 = !StringHelper.isNullOrEmpty((String)string2) ? string2 + "/" : "";
                if (PSCoreSysServiceBase.getMOSVer() == 1 && !StringHelper.isNullOrEmpty((String)pSMOSFile2.getFileTag4())) {
                    string2 = string2 + pSMOSFile2.getFileTag4();
                    string2 = string2 + "/";
                }
                if (!StringHelper.isNullOrEmpty((String)(string2 = !StringHelper.isNullOrEmpty((String)pSMOSFile2.getModelV2Tag()) ? string2 + pSMOSFile2.getModelV2Tag() : string2 + pSMOSFile2.getPSMOSFileName())) && string2.charAt(0) != '/') {
                    string2 = "/" + string2;
                }
                pSMOSFile2.setPSMOSFileId(string2);
                if (iPSMOSFileFilter != null || StringHelper.compare((String)pSMOSFile2.getFileTag(), (String)"GROUP", (boolean)false) != 0 || (arrayNode = this.listDRFolders(pSMOSFile3 = new PSMOSFile(), pSMOSFile2.getPSMOSFileName(), null)) == null) continue;
                ArrayList<ObjectNode> arrayList = new ArrayList<ObjectNode>();
                for (PSMOSFile pSMOSFile4 : arrayNode) {
                    arrayList.add(PSModelV2Helper.toJSONObject((IEntity)pSMOSFile4, false));
                }
                ArrayNode arrayNode2 = new ObjectMapper().createArrayNode();
                arrayNode2.addAll(arrayList);
                pSMOSFile2.setData(arrayNode2.toString());
            }
        }
        return pSMOSFileArray;
    }

    protected PSMOSFile[] onListDRFolders(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        return null;
    }

    protected PSMOSFile[] listDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        return this.listDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, false);
    }

    protected PSMOSFile[] listDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        PSMOSFile[] pSMOSFileArray = this.onListDRDataFolders(pSMOSFile, string, string2, iPSMOSFileFilter, bl);
        if (pSMOSFileArray != null) {
            for (PSMOSFile pSMOSFile2 : pSMOSFileArray) {
                if (StringHelper.isNullOrEmpty((String)pSMOSFile2.getPSModelId())) {
                    pSMOSFile2.setPSModelType(pSMOSFile.getPSModelType());
                    pSMOSFile2.setPSModelSubType(pSMOSFile.getPSModelSubType());
                    pSMOSFile2.setPSModelId(pSMOSFile.getPSModelId());
                }
                if (!StringHelper.isNullOrEmpty((String)pSMOSFile2.getPSMOSFileId())) continue;
                String string3 = pSMOSFile.getPSMOSFileId();
                if (StringHelper.compare((String)string3, (String)"/", (boolean)false) == 0) {
                    string3 = "";
                }
                string3 = !StringHelper.isNullOrEmpty((String)string3) ? string3 + "/" : "";
                if (!StringHelper.isNullOrEmpty((String)string)) {
                    string3 = string3 + string;
                    string3 = string3 + "/";
                }
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    string3 = string3 + string2;
                    string3 = string3 + "/";
                }
                if (!StringHelper.isNullOrEmpty((String)(string3 = !StringHelper.isNullOrEmpty((String)pSMOSFile2.getModelV2Tag()) ? string3 + pSMOSFile2.getModelV2Tag() : string3 + pSMOSFile2.getPSMOSFileName())) && string3.charAt(0) != '/') {
                    string3 = "/" + string3;
                }
                pSMOSFile2.setPSMOSFileId(string3);
            }
        }
        return pSMOSFileArray;
    }

    protected PSMOSFile[] onListDRDataFolders(PSMOSFile pSMOSFile, String string, String string2, IPSMOSFileFilter iPSMOSFileFilter, boolean bl) throws Exception {
        return null;
    }

    /*
     * WARNING - void declaration
     */
    protected SelectContext getListDRDataFolderCond(PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter, IService iService, String string, String string2, String string3, String string4, String string5) throws Exception {
        Object object;
        SelectContext selectContext = new SelectContext();
        selectContext.set(string2, (Object)string3);
        Map<String, String> map = ((IPSMOSFileService)iService).getListDRDataFolderFields(null, pSMOSFile, iPSMOSFileFilter);
        if (map != null) {
            map.put(string2, "");
            map.put(iService.getDEModel().getKeyDEField().getName(), null);
            if (iService.getDEModel().getMajorDEField() != null) {
                map.put(iService.getDEModel().getMajorDEField().getName(), null);
            }
            if (iService.getDEModel().getDEField("MEMO", true) != null) {
                map.put("MEMO", null);
            }
            if (iService.getDEModel().getDEField("LOGICNAME", true) != null) {
                map.put("LOGICNAME", null);
            }
            if (iService.getDEModel().getDEField("CODENAME", true) != null) {
                map.put("CODENAME", null);
            }
            if (iService.getDEModel().getIndexTypeDEField() != null) {
                map.put(iService.getDEModel().getIndexTypeDEField().getName(), null);
            }
            if (iService.getDEModel().getMultiFormDEField() != null) {
                map.put(iService.getDEModel().getMultiFormDEField().getName(), null);
            }
            for (Map.Entry entry : map.entrySet()) {
                selectContext.addSelectField((String)entry.getKey());
            }
        }
        if (!StringHelper.isNullOrEmpty((String)string4)) {
            void var12_14;
            object = string4.split("[;]");
            boolean i = false;
            while (var12_14 < ((String[])object).length) {
                String[] stringArray = object[var12_14].split("[:]");
                if (stringArray.length == 2) {
                    if (StringHelper.compare((String)stringArray[1], (String)"ISNULL", (boolean)true) == 0) {
                        selectContext.setIsNull(stringArray[0]);
                    } else if (StringHelper.compare((String)stringArray[1], (String)"ISNOTNULL", (boolean)true) == 0) {
                        selectContext.setIsNotNull(stringArray[0]);
                    } else {
                        selectContext.set(stringArray[0], (Object)stringArray[1]);
                    }
                }
                ++var12_14;
            }
        }
        if (iPSMOSFileFilter != null && !StringHelper.isNullOrEmpty((String)iPSMOSFileFilter.getQuery()) && iService != null) {
            object = iService.getDEModel().getFetchQuickSearchCondition(iPSMOSFileFilter.getQuery());
            selectContext.setSelectFilter((ISelectFilter)object);
        }
        return selectContext;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        return map;
    }

    protected boolean isCountDRDataFolder(PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter, String string, String string2, String string3, String string4, String string5) throws Exception {
        if (PSCoreSysServiceBase.getMOSVer() == 2) {
            return false;
        }
        if (iPSMOSFileFilter != null) {
            return false;
        }
        if (StringHelper.isNullOrEmpty((String)string3)) {
            return false;
        }
        return !ignoreCountDRDataFoldersMap.containsKey(string);
    }

    protected boolean isOutputDRDataFolder(PSMOSFile pSMOSFile, String string, IPSMOSFileFilter iPSMOSFileFilter, String string2, String string3, String string4, String string5, String string6, String string7, String string8) throws Exception {
        String[] stringArray;
        if (iPSMOSFileFilter == null) {
            if (PSCoreSysServiceBase.getMOSVer() == 2) {
                return true;
            }
            if (StringHelper.isNullOrEmpty((String)string) ? !StringHelper.isNullOrEmpty((String)string2) : StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) {
                return false;
            }
        } else {
            if (PSCoreSysServiceBase.getMOSVer() == 2) {
                return true;
            }
            if (!iPSMOSFileFilter.isStarQuery() && string3.indexOf(iPSMOSFileFilter.getQuery()) == -1) {
                return false;
            }
        }
        if (StringHelper.isNullOrEmpty((String)string8) || StringHelper.isNullOrEmpty((String)pSMOSFile.getPSModelSubType())) {
            return true;
        }
        for (String string9 : stringArray = string8.split("[;]")) {
            if (StringHelper.compare((String)string9, (String)pSMOSFile.getPSModelSubType(), (boolean)true) != 0) continue;
            return true;
        }
        return false;
    }

    protected String getDRFolderModelV2Name(String string, boolean bl) {
        if (bl) {
            return StringHelper.format((String)"[%1$s]", (Object)PSModelV2Helper.getModelV2TagFolderName(string));
        }
        return StringHelper.format((String)"<%1$s>", (Object)PSModelV2Helper.getModelV2TagFolderName(string));
    }

    @Override
    public String getDRFolderPath(String string, IEntity iEntity, String string2) throws Exception {
        if (PSCoreSysServiceBase.getMOSVer() == 2) {
            return null;
        }
        log.warn((Object)StringHelper.format((String)"\u5b9e\u4f53[%1$s]\u65e0\u6cd5\u8ba1\u7b97[%2$s]\u7684\u6570\u636e\u5173\u7cfb\u8def\u5f84", (Object)this.getModelV2Name(true), (Object)string));
        return null;
    }

    @Override
    public String getFileName(IEntity iEntity) throws Exception {
        if (PSCoreSysServiceBase.getMOSVer() == 2) {
            return this.getModelV2Tag(iEntity);
        }
        return this.getDataInfo(iEntity);
    }

    public String getFileLogicName(IEntity iEntity) throws Exception {
        String string = DataObject.getStringValue((Object)iEntity.get("LOGICNAME"), null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return string;
        }
        string = DataObject.getStringValue((Object)iEntity.get(this.getDEModel().getMajorDEField().getName()), null);
        if (StringHelper.isNullOrEmpty((String)string)) {
            return null;
        }
        String string2 = this.getModelV2Tag(iEntity);
        if (StringHelper.compare((String)string, (String)string2, (boolean)true) != 0) {
            return string;
        }
        return null;
    }

    @Override
    public PSMOSFile createFile(PSMOSFile pSMOSFile, String string, Map<String, Object> map) throws Exception {
        final CallResult callResult = new CallResult();
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        final String string2 = string;
        final Map<String, Object> map2 = map;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSMOSFile pSMOSFile = PSCoreSysServiceBase.this.internalCreateFile(pSMOSFile2, string2, map2);
                callResult.setUserObject((Object)pSMOSFile);
            }
        }, false);
        if (callResult.getUserObject() == null) {
            return null;
        }
        return (PSMOSFile)callResult.getUserObject();
    }

    protected PSMOSFile internalCreateFile(PSMOSFile pSMOSFile, String string, Map<String, Object> map) throws Exception {
        PSMOSFile pSMOSFile2;
        String[] stringArray = string.split("[/]");
        if (stringArray.length < 2) {
            throw new Exception(String.format("\u6587\u4ef6\u8def\u5f84[%1$s]\u4e0d\u6b63\u786e", string));
        }
        String string2 = "";
        for (int i = 0; i < stringArray.length - 2; ++i) {
            if (i != 0) {
                string2 = string2 + "/";
            }
            string2 = string2 + stringArray[i];
        }
        if (StringHelper.isNullOrEmpty((String)string2)) {
            string2 = "/";
        }
        if ((pSMOSFile2 = this.getFile(pSMOSFile, string2)) == null) {
            throw new Exception(String.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u8def\u5f84[%1$s]", string2));
        }
        if (StringHelper.isNullOrEmpty((String)pSMOSFile2.getPSModelType())) {
            throw new Exception(String.format("\u6587\u4ef6\u8def\u5f84[%1$s]\u672a\u6307\u5411\u6a21\u578b\u5bf9\u8c61", string2));
        }
        IDataEntityModel iDataEntityModel = this.getSystemModel().getDataEntityModel(pSMOSFile2.getPSModelType());
        IService iService = iDataEntityModel.getService(this.getSessionFactory());
        IPSMOSFileService iPSMOSFileService = (IPSMOSFileService)iService;
        String string3 = stringArray[stringArray.length - 2];
        String string4 = stringArray[stringArray.length - 1];
        PSMOSFileFilter pSMOSFileFilter = new PSMOSFileFilter();
        pSMOSFileFilter.setQuery(string3);
        PSMOSFile[] pSMOSFileArray = iPSMOSFileService.listFiles(pSMOSFile2, "/", pSMOSFileFilter);
        if (pSMOSFileArray == null || pSMOSFileArray.length == 0) {
            throw new Exception(String.format("\u65e0\u6cd5\u8bc6\u522b\u7684\u6587\u4ef6\u8def\u5f84[%1$s]", string2 + "/" + string3));
        }
        IDataEntityModel iDataEntityModel2 = this.getSystemModel().getDataEntityModel(pSMOSFileArray[0].getFileTag3());
        String string5 = pSMOSFileArray[0].getFileTag2();
        if (StringHelper.isNullOrEmpty((String)string5)) {
            throw new Exception(String.format("\u6587\u4ef6\u8def\u5f84[%1$s]\u5173\u7cfb\u6807\u8bb0\u65e0\u6548", string2 + "/" + string3));
        }
        String[] stringArray2 = string5.split("[|]");
        if (stringArray2.length != 2) {
            throw new Exception(String.format("\u6587\u4ef6\u8def\u5f84[%1$s]\u5173\u7cfb\u6807\u8bb0\u65e0\u6548", string2 + "/" + string3));
        }
        IService iService2 = iDataEntityModel2.getService(this.getSessionFactory());
        IEntity iEntity = iDataEntityModel2.createEntity();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                iEntity.set(entry.getKey(), entry.getValue());
            }
        }
        iEntity.set(stringArray2[1], (Object)pSMOSFile2.getPSModelId());
        ((IPSModelV2Service)iService2).setModelV2Tag(iEntity, string4);
        if ("PSSYSTEM".equals(pSMOSFile.getPSModelType())) {
            iEntity.set("PSSYSTEMID", (Object)pSMOSFile.getPSModelId());
        }
        try {
            ((IPSMOSFileService)iService2).getDraftFile(iEntity, pSMOSFile2, string4);
            iService2.create(iEntity);
        }
        catch (Exception exception) {
            throw new Exception(String.format("\u65b0\u5efa\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", exception.getMessage()), exception);
        }
        return ((IPSMOSFileService)iService2).getFile(iEntity);
    }

    @Override
    public void getDraftFile(IEntity iEntity, PSMOSFile pSMOSFile, String string) throws Exception {
        Matcher matcher;
        boolean bl;
        Object object;
        if (this.getDEModel().getDEField("CODENAME", true) != null && StringHelper.isNullOrEmpty((Object)(object = iEntity.get("CODENAME"))) && (bl = (matcher = codeNamePattern.matcher(string)).matches())) {
            iEntity.set("CODENAME", (Object)string);
        }
        this.getDraft(iEntity);
    }

    @Override
    public void deleteFile(PSMOSFile pSMOSFile, String string) throws Exception {
        final PSMOSFile pSMOSFile2 = pSMOSFile;
        final String string2 = string;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSCoreSysServiceBase.this.internalDeleteFile(pSMOSFile2, string2);
            }
        }, false);
    }

    protected void internalDeleteFile(PSMOSFile pSMOSFile, String string) throws Exception {
    }

    public boolean isOutputDRFolders() {
        return false;
    }

    @Override
    public String getDataInfo(ET ET) throws Exception {
        String string = DataObject.getStringValue((Object)ET.get(this.getDEModel().getMajorDEField().getName()));
        String string2 = DataObject.getStringValue((Object)ET.get("LOGICNAME"));
        if (StringHelper.isNullOrEmpty((String)string2)) {
            return string;
        }
        if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) {
            return StringHelper.format((String)"%1$s (%2$s)", (Object)string2, (Object)string);
        }
        return string;
    }

    protected final boolean isMajorSessionFactory() {
        return PSCoreSysServiceBase.isMajorSessionFactory(this.getSessionFactory());
    }

    protected Object getDefaultValue(IWebContext iWebContext, String string, String string2, int n) throws Exception {
        if (!StringHelper.isNullOrEmpty((String)string) && string.indexOf("USER") == 0) {
            return null;
        }
        return DefaultValueHelper.getValue((IWebContext)iWebContext, (String)string, (String)string2, (int)n);
    }

    public Object getDataType(ET ET) throws Exception {
        return null;
    }

    protected void fillPasteEntity(IEntity iEntity, String string) throws Exception {
        if (string.length() <= 9) {
            return;
        }
        String string2 = string.substring(9);
        if (!StringHelper.isNullOrEmpty((String)string2)) {
            String[] stringArray = string2.split("[;]");
            for (int i = 0; i < stringArray.length; ++i) {
                String[] stringArray2 = stringArray[i].split("[:]");
                if (stringArray2.length != 2) continue;
                iEntity.set(stringArray2[0], (Object)stringArray2[1]);
            }
        }
    }

    @Override
    public PSHelpSection[] getPasteHelps(IEntity iEntity) throws Exception {
        PSHelpSection[] pSHelpSectionArray = pastePSHelpSectionsMap.get(this.getDEModel().getName());
        if (pSHelpSectionArray == null) {
            ArrayList<PSHelpSection> arrayList = new ArrayList<PSHelpSection>();
            this.onFillPasteHelps(iEntity, arrayList);
            pSHelpSectionArray = arrayList.toArray(new PSHelpSection[arrayList.size()]);
            pastePSHelpSectionsMap.put(this.getDEModel().getName(), pSHelpSectionArray);
        }
        return pSHelpSectionArray;
    }

    protected void onFillPasteHelps(ET ET, List<PSHelpSection> list) throws Exception {
    }

    @Override
    public void doServiceWork(IServiceWork iServiceWork, boolean bl) throws Exception {
        super.doServiceWork(iServiceWork, bl);
    }

    protected String executeCallback(String string, String string2) throws Exception {
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity((Object)string2, (MultiValueMap)httpHeaders);
        try {
            ResponseEntity responseEntity = restTemplate.exchange(new URI(string), HttpMethod.POST, httpEntity, String.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK) {
                String string3 = (String)responseEntity.getBody();
                return string3;
            }
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)responseEntity.getStatusCode().getReasonPhrase()));
        }
        catch (Exception exception) {
            if (exception instanceof HttpServerErrorException) {
                String string4;
                HttpServerErrorException httpServerErrorException = (HttpServerErrorException)exception;
                try {
                    string4 = new String(httpServerErrorException.getResponseBodyAsByteArray(), "UTF-8");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    log.error((Object)unsupportedEncodingException);
                    string4 = httpServerErrorException.getResponseBodyAsString();
                }
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    if (httpServerErrorException.getStatusCode().value() >= 400 && httpServerErrorException.getStatusCode().value() <= 500 && string4.indexOf("{") == 0) {
                        try {
                            ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string4);
                            JsonNode jsonNode = objectNode.get("message");
                            if (jsonNode != null && !jsonNode.isNull()) {
                                string4 = jsonNode.asText();
                            }
                        }
                        catch (Exception exception2) {
                            log.error((Object)exception2);
                        }
                    }
                    throw new Exception(string4, exception);
                }
            }
            throw new Exception(StringHelper.format((String)"\u8bf7\u6c42\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), exception);
        }
    }

    protected String getRealCallbackUrl(String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        return string.replace("{psdevslnsysid}", WebUtility.encodeURLParamValue((String)string2)).replace("{psdevslnid}", WebUtility.encodeURLParamValue((String)string3)).replace("{runmode}", WebUtility.encodeURLParamValue((String)string4)).replace("{system}", WebUtility.encodeURLParamValue((String)string5)).replace("{image}", WebUtility.encodeURLParamValue((String)string6)).replace("{token}", WebUtility.encodeURLParamValue((String)string7));
    }

    protected String getCurUserName() throws Exception {
        String string = null;
        if (WebContext.getCurrent() != null) {
            string = WebContext.getCurrent().getCurLoginName();
        }
        if (StringHelper.isNullOrEmpty(string)) {
            string = "!\u672a\u77e5\u7528\u6237";
        }
        return string;
    }

    @Override
    public void translate(Map<String, Object> map) throws Exception {
        this.onTranslate(map);
    }

    protected void onTranslate(Map<String, Object> map) throws Exception {
    }

    @Override
    public abstract IPSDataEntityModel<ET> getDEModel();

    protected void fillEntity(ET ET) throws Exception {
        if (this.getDEModel().isTranslateDEFieldServiceCodeName()) {
            Iterator iterator = this.getDEModel().getDEFields();
            while (iterator.hasNext()) {
                IPSDEFieldModel iPSDEFieldModel = (IPSDEFieldModel)iterator.next();
                if (StringHelper.compare((String)iPSDEFieldModel.getName(), (String)iPSDEFieldModel.getServiceCodeName(), (boolean)true) == 0 || ET.contains(iPSDEFieldModel.getName()) || !ET.contains(iPSDEFieldModel.getServiceCodeName())) continue;
                ET.set(iPSDEFieldModel.getName(), ET.get(iPSDEFieldModel.getServiceCodeName()));
            }
        }
    }

    static {
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        deLogMap = new HashMap();
        deModelVerMap = new HashMap();
        deModelVerMap2 = new HashMap();
        deDBVerMap = new HashMap();
        sysModelVerMap = new HashMap();
        sysModelVerSqlMap = new HashMap();
        sysModelLogMap = new HashMap();
        informStateMap = new HashMap();
        informStateMap2 = new HashMap();
        strDevCenterApi = null;
        defaultRemoteCallResult = new RemoteCallResult();
        curPSSystemId = new ThreadLocal();
        curPSDCId = new ThreadLocal();
        curPSDevSlnSysId = new ThreadLocal();
        curPSDevSlnId = new ThreadLocal();
        curPSDynaInstId = new ThreadLocal();
        psModelHotCodeHelper = new PSModelHotCodeHelper();
        impSysModelSystem = new ThreadLocal();
        curMajorSessionFactory = new ThreadLocal();
        simpleImportExportMode = new ThreadLocal();
        simpleImportExportOwner = new ThreadLocal();
        threadCurDCLimit = new ThreadLocal();
        threadCurDevSlnLimit = new ThreadLocal();
        threadCodeNameUpperCamel = new ThreadLocal();
        denyCopyMap = new HashMap();
        PSMODEL_EXPORTMODE = 7;
        bEnableMergeCount = true;
        bEnableI18NDefault = true;
        bEnableStateInformDefault = false;
        bEnableDevSlnSysRemoteCall = null;
        bEnableModelObjStorage = null;
        bEnableOPInfoInformDefault = false;
        bEnableGitLabPlugin = null;
        iPSGitLabPlugin = null;
        bEnableKafkaPlugin = null;
        iPSKafkaPlugin = null;
        strPSSvrDomainId = null;
        bEnableCurDCLimit = false;
        bEnableCurDevSlnLimit = false;
        bEnablePaaSAdminLimit = false;
        strRecyclePSDCId = null;
        bPrivateCloudMode = false;
        bMOSMode = true;
        nMOSVersion = 1;
        bCloudMode = false;
        strProxyTaskServerUrl = null;
        bEnableCodeNameUpperCamel = false;
        bEnableGitBranch = null;
        strModelFormat = null;
        codeNamePattern = Pattern.compile("[a-zA-Z_$][a-zA-Z0-9_$]*");
        invalidPSSysSFPub = new PSSysSFPub();
        pastePSHelpSectionsMap = new HashMap<String, PSHelpSection[]>();
        ignoreExportModelV2Map = new HashMap<String, Integer>();
        ignoreImportModelV2Map = new HashMap<String, Integer>();
        ignoreImportModelFieldV2Map = new HashMap<String, Integer>();
        aliasModelV2Map = new HashMap<String, String>();
        ignoreCountDRDataFoldersMap = new HashMap<String, String>();
        MAPPER = new ObjectMapper();
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
        sysModelVerSqlMap.put("PSSYSPFPITEMPL", "UPDATE T_SRFPSSYSTEM SET MODELVER=MODELVER+1 WHERE EXISTS(SELECT * FROM T_SRFPSSYSPFPITEMPL INNER JOIN T_SRFPSSYSPFPLUGIN ON T_SRFPSSYSPFPITEMPL.PSSYSPFPLUGINID = T_SRFPSSYSPFPLUGIN.PSSYSPFPLUGINID WHERE T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSPFPLUGIN.PSSYSTEMID AND T_SRFPSSYSPFPITEMPL.PSSYSPFPITEMPLID=?)");
        sysModelVerSqlMap.put("PSSYSSFPITEMPL", "UPDATE T_SRFPSSYSTEM SET MODELVER=MODELVER+1 WHERE EXISTS(SELECT * FROM T_SRFPSSYSSFPITEMPL INNER JOIN T_SRFPSSYSSFPLUGIN ON T_SRFPSSYSSFPITEMPL.PSSYSSFPLUGINID = T_SRFPSSYSSFPLUGIN.PSSYSSFPLUGINID WHERE T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSSFPLUGIN.PSSYSTEMID AND T_SRFPSSYSSFPITEMPL.PSSYSSFPITEMPLID=?)");
        sysModelVerSqlMap.put("PSWFVERSION", "update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpswfversion inner join t_srfpsworkflow on t_srfpswfversion.PSWFID = t_srfpsworkflow.PSWORKFLOWID   where t_srfpssystem.PSSYSTEMID = t_srfpsworkflow.PSSYSTEMID and t_srfpswfversion.pswfversionid=?)");
        sysModelVerSqlMap.put("PSAPPMENU", "update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpsappmenu inner join t_srfpssysapp on t_srfpsappmenu.PSSYSAPPID = t_srfpssysapp.PSSYSAPPID   where t_srfpssystem.PSSYSTEMID = t_srfpssysapp.PSSYSTEMID and t_srfpsappmenu.psappmenuid=?)");
        sysModelVerSqlMap.put("PSWXENTAPP", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSWXENTAPP inner join T_SRFPSWXACCOUNT on T_SRFPSWXENTAPP.PSWXACCOUNTID = T_SRFPSWXACCOUNT.PSWXACCOUNTID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSWXACCOUNT.PSSYSTEMID and T_SRFPSWXENTAPP.PSWXENTAPPID=?)");
        sysModelVerSqlMap.put("PSWXLOGIC", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSWXLOGIC inner join T_SRFPSWXACCOUNT on T_SRFPSWXLOGIC.PSWXACCOUNTID = T_SRFPSWXACCOUNT.PSWXACCOUNTID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSWXACCOUNT.PSSYSTEMID and T_SRFPSWXLOGIC.PSWXLOGICID=?)");
        sysModelVerSqlMap.put("PSWXMENU", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSWXMENU inner join T_SRFPSWXACCOUNT on T_SRFPSWXMENU.PSWXACCOUNTID = T_SRFPSWXACCOUNT.PSWXACCOUNTID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSWXACCOUNT.PSSYSTEMID and T_SRFPSWXMENU.PSWXMENUID=?)");
        sysModelVerSqlMap.put("PSWXMENUFUNC", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSWXMENUFUNC inner join T_SRFPSWXACCOUNT on T_SRFPSWXMENUFUNC.PSWXACCOUNTID = T_SRFPSWXACCOUNT.PSWXACCOUNTID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSWXACCOUNT.PSSYSTEMID and T_SRFPSWXMENUFUNC.PSWXMENUFUNCID=?)");
        sysModelVerSqlMap.put("PSSYSSFCODE", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSSYSSFCODE inner join T_SRFPSSYSSFPUB on T_SRFPSSYSSFCODE.PSSYSSFPUBID = T_SRFPSSYSSFPUB.PSSYSSFPUBID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSSFPUB.PSSYSTEMID and T_SRFPSSYSSFCODE.PSSYSSFCODEID=?)");
        sysModelVerSqlMap.put("PSAPPVIEWCODE", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPVIEWCODE inner join T_SRFPSSYSAPP on T_SRFPSAPPVIEWCODE.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPVIEWCODE.PSAPPVIEWCODEID=?)");
        sysModelVerSqlMap.put("PSAPPLAN", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPLAN inner join T_SRFPSSYSAPP on T_SRFPSAPPLAN.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPLAN.PSAPPLANID=?)");
        sysModelVerSqlMap.put("PSAPPPKG", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPPKG inner join T_SRFPSSYSAPP on T_SRFPSAPPPKG.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPPKG.PSAPPPKGID=?)");
        sysModelVerSqlMap.put("PSSYSSFPUBPKG", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSSYSSFPUBPKG inner join T_SRFPSSYSSFPUB on T_SRFPSSYSSFPUBPKG.PSSYSSFPUBID = T_SRFPSSYSSFPUB.PSSYSSFPUBID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSSFPUB.PSSYSTEMID and T_SRFPSSYSSFPUBPKG.PSSYSSFPUBPKGID=?)");
        sysModelVerSqlMap.put("PSAPPUSERMODE", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPUSERMODE inner join T_SRFPSSYSAPP on T_SRFPSAPPUSERMODE.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPUSERMODE.PSAPPUSERMODEID=?)");
        sysModelVerSqlMap.put("PSAPPLOCALDE", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPLOCALDE inner join T_SRFPSSYSAPP on T_SRFPSAPPLOCALDE.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPLOCALDE.PSAPPLOCALDEID=?)");
        sysModelVerSqlMap.put("PSMOBAPPSTARTPAGE", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSMOBAPPSTARTPAGE inner join T_SRFPSSYSAPP on T_SRFPSMOBAPPSTARTPAGE.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSMOBAPPSTARTPAGE.PSMOBAPPSTARTPAGEID=?)");
        sysModelVerSqlMap.put("PSMOBAPPPACK", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSMOBAPPPACK inner join T_SRFPSSYSAPP on T_SRFPSMOBAPPPACK.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSMOBAPPPACK.PSMOBAPPPACKID=?)");
        sysModelVerSqlMap.put("PSSUBSYSSADETAIL", "update t_srfpssystem set MODELVER=MODELVER+1 where exists(select * from t_srfpssubsyssadetail inner join t_srfpssubsysserviceapi on t_srfpssubsyssadetail.PSSUBSYSSERVICEAPIID = t_srfpssubsysserviceapi.PSSUBSYSSERVICEAPIID   where t_srfpssystem.PSSYSTEMID = t_srfpssubsysserviceapi.PSSYSTEMID and t_srfpssubsyssadetail.pssubsyssadetailid=?)");
        sysModelVerSqlMap.put("PSAPPTITLEBAR", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPTITLEBAR inner join T_SRFPSSYSAPP on T_SRFPSAPPTITLEBAR.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPTITLEBAR.PSAPPTITLEBARID=?)");
        sysModelVerSqlMap.put("PSSYSDYNAMODELATTR", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSSYSDYNAMODELATTR inner join T_SRFPSSYSDYNAMODEL on T_SRFPSSYSDYNAMODELATTR.PSSYSDYNAMODELID = T_SRFPSSYSDYNAMODEL.PSSYSDYNAMODELID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSDYNAMODEL.PSSYSTEMID and T_SRFPSSYSDYNAMODELATTR.PSSYSDYNAMODELATTRID=?)");
        sysModelVerSqlMap.put("PSAPPUITHEME", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSAPPUITHEME inner join T_SRFPSSYSAPP on T_SRFPSAPPUITHEME.PSSYSAPPID = T_SRFPSSYSAPP.PSSYSAPPID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSSYSAPP.PSSYSTEMID and T_SRFPSAPPUITHEME.PSAPPUITHEMEID=?)");
        sysModelVerSqlMap.put("PSDYNADEVIEWTEMPL", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSDYNADEVIEWTEMPL inner join T_SRFPSDYNADETEMPL on T_SRFPSDYNADEVIEWTEMPL.PSDYNADETEMPLID = T_SRFPSDYNADETEMPL.PSDYNADETEMPLID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSDYNADETEMPL.PSSYSTEMID and T_SRFPSDYNADEVIEWTEMPL.PSDYNADEVIEWTEMPLID=?)");
        sysModelVerSqlMap.put("PSDYNADEFORMTEMPL", "update T_SRFPSSYSTEM set MODELVER=MODELVER+1 where exists(select * from T_SRFPSDYNADEFORMTEMPL inner join T_SRFPSDYNADETEMPL on T_SRFPSDYNADEFORMTEMPL.PSDYNADETEMPLID = T_SRFPSDYNADETEMPL.PSDYNADETEMPLID   where T_SRFPSSYSTEM.PSSYSTEMID = T_SRFPSDYNADETEMPL.PSSYSTEMID and T_SRFPSDYNADEFORMTEMPL.PSDYNADEFORMTEMPLID=?)");
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

    protected class ModelV2 {
        public String type = null;
        public String key = null;
        public String text = null;
        public String tag = null;
        public int pos = -1;
        public IEntity entity = null;

        protected ModelV2() {
        }
    }

    protected static interface ISysConsole {
        public void log(String var1, String var2);

        public void warn(String var1, String var2);

        public void error(String var1, String var2);
    }
}

