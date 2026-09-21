/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  com.fasterxml.jackson.databind.ObjectMapper
 *  com.fasterxml.jackson.databind.SerializationFeature
 *  com.fasterxml.jackson.databind.node.ArrayNode
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.util.WebUtility
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItem
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppSBItemRS
 *  net.ibizsys.pscore.srv.appdesign.entity.PSAppStoryBoard
 *  net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst
 *  net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService
 *  net.ibizsys.pscore.srv.util.PSStudioEnvHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 *  org.yaml.snakeyaml.DumperOptions
 *  org.yaml.snakeyaml.DumperOptions$FlowStyle
 *  org.yaml.snakeyaml.Yaml
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.AI.IPSSysAIFactory;
import SA.SRFDA.PS.Core.App.AppMenu.IPSAppMenuModel;
import SA.SRFDA.PS.Core.App.BI.IPSAppBIScheme;
import SA.SRFDA.PS.Core.App.CodeList.IPSAppCodeList;
import SA.SRFDA.PS.Core.App.Control.IPSAppCounter;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDELogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDEUILogic;
import SA.SRFDA.PS.Core.App.DataEntity.IPSAppDataEntity;
import SA.SRFDA.PS.Core.App.IPSAppLan;
import SA.SRFDA.PS.Core.App.IPSAppModule;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.View.IPSAppView;
import SA.SRFDA.PS.Core.BA.IPSSysBDScheme;
import SA.SRFDA.PS.Core.BI.IPSSysBIScheme;
import SA.SRFDA.PS.Core.BackService.IPSSysBackService;
import SA.SRFDA.PS.Core.CodeList.IPSCodeList;
import SA.SRFDA.PS.Core.Control.IPSControl;
import SA.SRFDA.PS.Core.DEField.IPSDEFGroup;
import SA.SRFDA.PS.Core.DTS.IPSSysDTSQueue;
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
import SA.SRFDA.PS.Core.DataEntity.IPSDEGroup;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDELogic;
import SA.SRFDA.PS.Core.DataEntity.Logic.IPSDEMSLogic;
import SA.SRFDA.PS.Core.DataEntity.Print.IPSDEPrint;
import SA.SRFDA.PS.Core.DataEntity.Priv.IPSDEUserRole;
import SA.SRFDA.PS.Core.DataEntity.Report.IPSDEReport;
import SA.SRFDA.PS.Core.Database.IPSSysDBScheme;
import SA.SRFDA.PS.Core.Database.IPSSysDBValueFunc;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.DevStudio.PSSysDevBKTaskImplBase;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.ER.IPSSysERMap;
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
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSCodePublisherContextImpl;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqItem;
import SA.SRFDA.PS.Core.Requirement.IPSSysReqModule;
import SA.SRFDA.PS.Core.Res.IPSSysContentCat;
import SA.SRFDA.PS.Core.Res.IPSSysI18N;
import SA.SRFDA.PS.Core.Res.IPSSysLan;
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
import org.hibernate.SessionFactory;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

public class PubDynaInstModelPSSysDevBKTaskImpl
extends PSSysDevBKTaskImplBase {
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
    private List<DumpFile> dumpFileList = null;
    private List<Runnable> dumpRunnableList = new ArrayList<Runnable>();
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
        String strCallbackUrl;
        this.preparePSSFLogicTempls();
        if (StringHelper.isNullOrEmpty((String)this.psSysDevBKTask.getPSDYNAINSTID())) {
            throw new Exception(StringHelper.format((String)"\u6ca1\u6709\u6307\u5b9a\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b"));
        }
        this.iPSDevSlnSysDynaInst = this.getPSModelStorage().getPSDevSlnSysDynaInst(this.psSysDevBKTask.getPSDYNAINSTID());
        IPSDevSlnSys iPSDevSlnSys = this.iPSDevSlnSysDynaInst.getPSDevSlnSys();
        PSDevSlnSysDynaInst psDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
        psDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(this.psSysDevBKTask.getPSDYNAINSTID());
        PSDevSlnSysDynaInstService psDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysDynaInstService.checkOutCfg(psDevSlnSysDynaInst);
        this.strCfgPath = String.format("%1$s%2$sCFG%2$s%3$s", PSStudioEnvHelper.getCurrent().getDynaInstFolder(), File.separator, psDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
        if (StringHelper.compare((String)this.iPSDevSlnSysDynaInst.getInstType(), (String)"MODULE", (boolean)false) == 0) {
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
        psDevSlnSysDynaInstService.checkInCfg(psDevSlnSysDynaInst);
        boolean bUploadCfg = false;
        if (bUploadCfg) {
            String strServerRoot = PSTaskServerEnvImpl.getCurrent().getTempFileServerUrl();
            String strServerHost = PSTaskServerEnvImpl.getCurrent().getTempFileServerAddr();
            int nServerPort = PSTaskServerEnvImpl.getCurrent().getTempFileServerPort();
            String strDynaInstFolder = String.format("dynamic/%1$s", psDevSlnSysDynaInst.getPSDevSlnSysDynaInstId());
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.strCfgPath, (Object)strServerHost, (Object)nServerPort, (Object)strDynaInstFolder) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$stempfilehelp.py %3$s %4$s %5$s %6$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)this.strCfgPath, (Object)strServerHost, (Object)nServerPort, (Object)strDynaInstFolder);
            String strResult = this.runBat(strCmd, true);
            Thread.sleep(2000L);
        }
        if (!StringHelper.isNullOrEmpty((String)(strCallbackUrl = this.getCallbackUrl()))) {
            String strCmd = "";
            strCmd = PSTaskServerEnvImpl.getCurrent().isLinux() ? StringHelper.format((String)"python %1$s%2$spyutils%2$scurl.py %3$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strCallbackUrl) : StringHelper.format((String)"cmd.exe /c python %1$s%2$spyutils%2$scurl.py %3$s", (Object)PSTaskServerEnvImpl.getCurrent().getToolFolder(), (Object)File.separator, (Object)strCallbackUrl);
            String string = this.runBat(strCmd, true);
        }
        return strRet;
    }

    protected void preparePSSFLogicTempls() throws Exception {
        IPSSFStyle2 iPSSFStyle2;
        Iterator<? extends IPSSFLogicTempl> psSFLogicTempls;
        IPSSFStyle iPSSFStyle;
        IPSSF iPSSF;
        if (this.psSFLogicTemplListMap == null && (iPSSF = this.getPSModelStorage().getPSSF(PSSF_DYNASYS, true)) != null && (iPSSFStyle = iPSSF.getPSSFStyle(PSSF_DYNASYS_DEFAULT, true)) != null && iPSSFStyle instanceof IPSSFStyle2 && (psSFLogicTempls = (iPSSFStyle2 = (IPSSFStyle2)iPSSFStyle).getPSSFLogicTempls()) != null) {
            this.psSFLogicTemplListMap = new HashMap<String, List<IPSSFLogicTempl>>();
            while (psSFLogicTempls.hasNext()) {
                IPSSFLogicTempl iPSSFLogicTempl = psSFLogicTempls.next();
                List<IPSSFLogicTempl> list = this.psSFLogicTemplListMap.get(iPSSFLogicTempl.getName());
                if (list == null) {
                    list = new ArrayList<IPSSFLogicTempl>();
                    this.psSFLogicTemplListMap.put(iPSSFLogicTempl.getName(), list);
                }
                list.add(iPSSFLogicTempl);
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
            iPSSystemRuntime = (IPSSystemRuntime)((Object)this.iPSSystem);
            lastPSModelObjectLogger = iPSSystemRuntime.getPSModelObjectLogger();
            String strLoggerName = StringHelper.format((String)"\u52a8\u6001\u6a21\u578b");
            PSModelObjectLoggerImpl psModelObjectLoggerImpl = new PSModelObjectLoggerImpl(this.getRootPSSysDevBKTask(), this.iPSSystem.getPSDevCenterDomain(), strLoggerName, -1);
            iPSSystemRuntime.setPSModelObjectLogger(psModelObjectLoggerImpl);
            String strRet = this.pubDynaInstModel(this.iPSSystem);
            iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
            return strRet;
        }
        catch (Exception ex) {
            if (iPSSystemRuntime != null) {
                iPSSystemRuntime.setPSModelObjectLogger(lastPSModelObjectLogger);
            }
            throw ex;
        }
    }

    protected String pubDynaInstModel(IPSSystem iPSSystem) throws Exception {
        ArrayList<String> reloadAppIds = new ArrayList<String>();
        Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
        while (psApplications.hasNext()) {
            IPSApplication iPSApplication = psApplications.next();
            if (!iPSApplication.isEnableDynaModel() || iPSApplication.getLoadedLevel() >= this.getModelLoadLevel()) continue;
            reloadAppIds.add(iPSApplication.getId());
        }
        for (String strPSSysAppId : reloadAppIds) {
            PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, this.getModelLoadLevel());
        }
        this.pubPSSystemModel(iPSSystem);
        return null;
    }

    protected void pubIBizModelFile(File file, IPSSystem iPSSystem, IPSSysSFPub iPSSysSFPub) throws Exception {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("modelfolder", iPSSysSFPub.getModelFolder());
        DumperOptions dumperOptions = new DumperOptions();
        dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Yaml yaml = new Yaml(dumperOptions);
        String strContent = yaml.dump(map);
        FileWriterHelper.write3(file, strContent);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
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
        int i = 0;
        while (i < this.getTaskThreadCount()) {
            this.executeTask(new Runnable(){

                @Override
                public void run() {
                    PubDynaInstModelPSSysDevBKTaskImpl.this.dumpRun();
                }
            });
            ++i;
        }
        long nStartTime = System.currentTimeMillis();
        try {
            Object psSysUserRoles;
            Iterator<IPSSystemModule> psSystemModules;
            PSObjectImpl.setDynaModelPubIgnorePF(false);
            if (!this.isCodeGenModelMode()) {
                PSObjectImpl.setDynaModelPubIgnorePF(true);
            }
            PSObjectImpl.setDynaModelPubIgnorePFReal(true);
            Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
            if (psApplications != null) {
                while (psApplications.hasNext()) {
                    IPSApplication iPSApplication = psApplications.next();
                    if (!this.isCodeGenModelMode() && !iPSApplication.isEnableDynaModel()) continue;
                    this.pubPSApplicationDynaInstModel(iPSApplication);
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
            if ((psSystemModules = iPSSystem.getAllPSSystemModules()) != null) {
                while (psSystemModules.hasNext()) {
                    IPSSystemModule iPSSystemModule = psSystemModules.next();
                    this.pubPSSystemModuleModel(iPSSystemModule);
                }
            }
            if (this.isCodeGenModelMode()) {
                Iterator<IPSSysERMap> psSysERMaps;
                Iterator<IPSSysUCMap> psSysUCMaps;
                Iterator<IPSSysUseCase> psSysUseCases;
                Iterator<IPSSysActor> psSysActors;
                Iterator<IPSSysReqItem> psSysReqItems;
                Iterator<IPSSysReqModule> psSysReqModules;
                Iterator<IPSSysUnit> psSysUnits;
                Iterator<IPSSysSampleValue> psSysSampleValues;
                Iterator<IPSSysSFPub> psSysSFPubs;
                Iterator<IPSSystemDBConfig> psSystemDBConfigs = iPSSystem.getAllPSSystemDBConfigs();
                if (psSystemDBConfigs != null) {
                    while (psSystemDBConfigs.hasNext()) {
                        IPSSystemDBConfig iPSSystemDBConfig = psSystemDBConfigs.next();
                        this.pubPSModelObjectModel(iPSSystemDBConfig);
                    }
                }
                if ((psSysSFPubs = iPSSystem.getAllPSSysSFPubs()) != null) {
                    while (psSysSFPubs.hasNext()) {
                        IPSSysSFPub iPSSysSFPub = psSysSFPubs.next();
                        this.pubPSModelObjectModel(iPSSysSFPub);
                    }
                }
                if ((psSysSampleValues = iPSSystem.getAllPSSysSampleValues()) != null) {
                    while (psSysSampleValues.hasNext()) {
                        IPSSysSampleValue iPSSysSampleValue = psSysSampleValues.next();
                        this.pubPSModelObjectModel(iPSSysSampleValue);
                    }
                }
                if ((psSysUnits = iPSSystem.getAllPSSysUnits()) != null) {
                    while (psSysUnits.hasNext()) {
                        IPSSysUnit iPSSysUnit = psSysUnits.next();
                        this.pubPSModelObjectModel(iPSSysUnit);
                    }
                }
                if ((psSysReqModules = iPSSystem.getAllPSSysReqModules()) != null) {
                    while (psSysReqModules.hasNext()) {
                        IPSSysReqModule iPSSysReqModule = psSysReqModules.next();
                        this.pubPSModelObjectModel(iPSSysReqModule);
                    }
                }
                if ((psSysReqItems = iPSSystem.getAllPSSysReqItems()) != null) {
                    while (psSysReqItems.hasNext()) {
                        IPSSysReqItem iPSSysReqItem = psSysReqItems.next();
                        this.pubPSModelObjectModel(iPSSysReqItem);
                    }
                }
                if ((psSysActors = iPSSystem.getAllPSSysActors()) != null) {
                    while (psSysActors.hasNext()) {
                        IPSSysActor iPSSysActor = psSysActors.next();
                        this.pubPSModelObjectModel(iPSSysActor);
                    }
                }
                if ((psSysUseCases = iPSSystem.getAllPSSysUseCases()) != null) {
                    while (psSysUseCases.hasNext()) {
                        IPSSysUseCase iPSSysUseCase = psSysUseCases.next();
                        this.pubPSModelObjectModel(iPSSysUseCase);
                    }
                }
                if ((psSysUCMaps = iPSSystem.getAllPSSysUCMaps()) != null) {
                    while (psSysUCMaps.hasNext()) {
                        IPSSysUCMap iPSSysUCMap = psSysUCMaps.next();
                        this.pubPSModelObjectModel(iPSSysUCMap);
                    }
                }
                if ((psSysERMaps = iPSSystem.getAllPSSysERMaps()) != null) {
                    while (psSysERMaps.hasNext()) {
                        IPSSysERMap iPSSysERMap = psSysERMaps.next();
                        this.pubPSModelObjectModel(iPSSysERMap);
                    }
                }
            }
            if (this.nDynaInstMode == 1) {
                Iterator<IPSSysDERGroup> psDERGroups;
                Iterator<IPSSysI18N> psSysI18Ns;
                Iterator<IPSSysLan> psSysLans;
                Iterator<IPSSysTranslator> psSysTranslators;
                Iterator<IPSSysSequence> psSysSequences;
                Iterator<IPSSysValueRule> psSysValueRules;
                Iterator<IPSWFWorkTime> psWFWorkTimes;
                Iterator<IPSWFRole> psWFRoles;
                if (this.isCoreModelMode()) {
                    Iterator<IPSSysDynaModel> psSysDynaModels;
                    Iterator<IPSWXAccount> psWXAccounts;
                    Iterator<IPSSysContentCat> psSysContentCats;
                    Iterator<IPSSysTestData> psSysTestDatas;
                    Iterator<IPSSysTestCase> psSysTestCases;
                    Iterator<IPSSysTestPrj> psSysTestPrjs;
                    Iterator<IPSWorkflow> psWorkflows;
                    Iterator<IPSCodeList> psCodeLists;
                    Iterator<IPSSysSearchScheme> psSysSearchSchemes;
                    Iterator<IPSSysAIFactory> psSysAIFactorys;
                    Iterator<IPSSysBIScheme> psSysBISchemes;
                    Iterator<IPSSysBDScheme> psSysBDSchemes;
                    Iterator<IPSSysDBScheme> psSysDBSchemes;
                    Iterator<IPSSubSysServiceAPI> psSubSysServiceAPIs;
                    Iterator<IPSSysServiceAPI> psSysServiceAPIs;
                    Iterator<IPSSysDBValueFunc> psSysDBValueFuncs;
                    Iterator<IPSSysDTSQueue> psSysDTSQueues;
                    Iterator<IPSSysBackService> psSysBackServices = iPSSystem.getAllPSSysBackServices();
                    if (psSysBackServices != null) {
                        while (psSysBackServices.hasNext()) {
                            IPSSysBackService iPSSysBackService = psSysBackServices.next();
                            if (!this.isCodeGenModelMode() && !iPSSysBackService.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSysBackService);
                        }
                    }
                    if ((psSysDTSQueues = iPSSystem.getAllPSSysDTSQueues()) != null) {
                        while (psSysDTSQueues.hasNext()) {
                            IPSSysDTSQueue iPSSysDTSQueue = psSysDTSQueues.next();
                            if (!this.isCodeGenModelMode() && !iPSSysDTSQueue.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSysDTSQueue);
                        }
                    }
                    if ((psSysDBValueFuncs = iPSSystem.getAllPSSysDBValueFuncs()) != null) {
                        while (psSysDBValueFuncs.hasNext()) {
                            IPSSysDBValueFunc iPSSysDBValueFunc = psSysDBValueFuncs.next();
                            if (!this.isCodeGenModelMode() && !iPSSysDBValueFunc.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSysDBValueFunc);
                        }
                    }
                    if ((psSysServiceAPIs = iPSSystem.getAllPSSysServiceAPIs()) != null) {
                        while (psSysServiceAPIs.hasNext()) {
                            IPSSysServiceAPI iPSSysServiceAPI = psSysServiceAPIs.next();
                            if (!this.isCodeGenModelMode() && !iPSSysServiceAPI.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSysServiceAPI);
                        }
                    }
                    if ((psSubSysServiceAPIs = iPSSystem.getAllPSSubSysServiceAPIs()) != null) {
                        while (psSubSysServiceAPIs.hasNext()) {
                            IPSSubSysServiceAPI iPSSubSysServiceAPI = psSubSysServiceAPIs.next();
                            if (!this.isCodeGenModelMode() && !iPSSubSysServiceAPI.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSubSysServiceAPI);
                        }
                    }
                    if ((psSysDBSchemes = iPSSystem.getAllPSSysDBSchemes()) != null) {
                        while (psSysDBSchemes.hasNext()) {
                            IPSSysDBScheme iPSSysDBScheme = psSysDBSchemes.next();
                            if (!this.isCodeGenModelMode() && !iPSSysDBScheme.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSysDBScheme);
                        }
                    }
                    if ((psSysBDSchemes = iPSSystem.getAllPSSysBDSchemes()) != null) {
                        while (psSysBDSchemes.hasNext()) {
                            IPSSysBDScheme iPSSysBDScheme = psSysBDSchemes.next();
                            if (!this.isCodeGenModelMode() && !iPSSysBDScheme.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSysBDScheme);
                        }
                    }
                    if ((psSysBISchemes = iPSSystem.getAllPSSysBISchemes()) != null) {
                        while (psSysBISchemes.hasNext()) {
                            IPSSysBIScheme iPSSysBIScheme = psSysBISchemes.next();
                            if (!this.isCodeGenModelMode() && !iPSSysBIScheme.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSysBIScheme);
                        }
                    }
                    if ((psSysAIFactorys = iPSSystem.getAllPSSysAIFactories()) != null) {
                        while (psSysAIFactorys.hasNext()) {
                            IPSSysAIFactory iPSSysAIFactory = psSysAIFactorys.next();
                            if (!this.isCodeGenModelMode() && !iPSSysAIFactory.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSysAIFactory);
                        }
                    }
                    if ((psSysSearchSchemes = iPSSystem.getAllPSSysSearchSchemes()) != null) {
                        while (psSysSearchSchemes.hasNext()) {
                            IPSSysSearchScheme iPSSysSearchScheme = psSysSearchSchemes.next();
                            if (!this.isCodeGenModelMode() && !iPSSysSearchScheme.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSSysSearchScheme);
                        }
                    }
                    if ((psCodeLists = iPSSystem.getAllPSCodeLists()) != null) {
                        while (psCodeLists.hasNext()) {
                            IPSCodeList iPSCodeList = psCodeLists.next();
                            if (iPSCodeList.getPSSystemModule() != null || !this.isCodeGenModelMode() && !iPSCodeList.isEnableDynaModel()) continue;
                            this.pubPSModelObjectModel(iPSCodeList);
                        }
                    }
                    if ((psWorkflows = iPSSystem.getAllPSWorkflows()) != null) {
                        while (psWorkflows.hasNext()) {
                            IPSWorkflow iPSWorkflow = psWorkflows.next();
                            if (iPSWorkflow.getPSSystemModule() != null || !this.isCodeGenModelMode() && !iPSWorkflow.isEnableDynaModel()) continue;
                            this.pubPSWorkflowModel(iPSWorkflow);
                        }
                    }
                    if ((psSysTestPrjs = iPSSystem.getAllPSSysTestPrjs()) != null) {
                        while (psSysTestPrjs.hasNext()) {
                            IPSSysTestPrj iPSSysTestPrj = psSysTestPrjs.next();
                            this.pubPSSysTestPrjModel(iPSSysTestPrj);
                        }
                    }
                    if ((psSysTestCases = iPSSystem.getAllPSSysTestCases()) != null) {
                        while (psSysTestCases.hasNext()) {
                            IPSSysTestCase iPSSysTestCase = psSysTestCases.next();
                            this.pubPSModelObjectModel(iPSSysTestCase);
                        }
                    }
                    if ((psSysTestDatas = iPSSystem.getAllPSSysTestDatas()) != null) {
                        while (psSysTestDatas.hasNext()) {
                            IPSSysTestData iPSSysTestData = psSysTestDatas.next();
                            this.pubPSModelObjectModel(iPSSysTestData);
                        }
                    }
                    if ((psSysContentCats = iPSSystem.getAllPSSysContentCats()) != null) {
                        while (psSysContentCats.hasNext()) {
                            IPSSysContentCat iPSSysContentCat = psSysContentCats.next();
                            this.pubPSModelObjectModel(iPSSysContentCat);
                        }
                    }
                    if ((psWXAccounts = iPSSystem.getAllPSWXAccounts()) != null) {
                        while (psWXAccounts.hasNext()) {
                            IPSWXAccount iPSWXAccount = psWXAccounts.next();
                            this.pubPSModelObjectModel(iPSWXAccount);
                        }
                    }
                    if ((psSysDynaModels = iPSSystem.getAllPSSysDynaModels()) != null) {
                        while (psSysDynaModels.hasNext()) {
                            IPSSysDynaModel iPSSysDynaModel = psSysDynaModels.next();
                            this.pubPSModelObjectModel(iPSSysDynaModel);
                        }
                    }
                }
                if ((psWFRoles = iPSSystem.getAllPSWFRoles()) != null) {
                    while (psWFRoles.hasNext()) {
                        IPSWFRole iPSWFRole = psWFRoles.next();
                        if (!this.isCodeGenModelMode() && !iPSWFRole.isEnableDynaModel()) continue;
                        this.pubPSModelObjectModel(iPSWFRole);
                    }
                }
                if ((psWFWorkTimes = iPSSystem.getAllPSWFWorkTimes()) != null) {
                    while (psWFWorkTimes.hasNext()) {
                        IPSWFWorkTime iPSWFWorkTime = psWFWorkTimes.next();
                        if (!this.isCodeGenModelMode() && !iPSWFWorkTime.isEnableDynaModel()) continue;
                        this.pubPSModelObjectModel(iPSWFWorkTime);
                    }
                }
                if ((psSysUserRoles = iPSSystem.getAllPSSysUserRoles()) != null) {
                    while (psSysUserRoles.hasNext()) {
                        IPSSysUserRole iPSSysUserRole = (IPSSysUserRole)psSysUserRoles.next();
                        if (!this.isCodeGenModelMode() && !iPSSysUserRole.isEnableDynaModel()) continue;
                        this.pubPSModelObjectModel(iPSSysUserRole);
                    }
                }
                if ((psSysValueRules = iPSSystem.getAllPSSysValueRules()) != null) {
                    while (psSysValueRules.hasNext()) {
                        IPSSysValueRule iPSSysValueRule = psSysValueRules.next();
                        if (!this.isCodeGenModelMode() && !iPSSysValueRule.isEnableDynaModel()) continue;
                        this.pubPSModelObjectModel(iPSSysValueRule);
                    }
                }
                if ((psSysSequences = iPSSystem.getAllPSSysSequences()) != null) {
                    while (psSysSequences.hasNext()) {
                        IPSSysSequence iPSSysSequence = psSysSequences.next();
                        if (!this.isCodeGenModelMode() && !iPSSysSequence.isEnableDynaModel()) continue;
                        this.pubPSModelObjectModel(iPSSysSequence);
                    }
                }
                if ((psSysTranslators = iPSSystem.getAllPSSysTranslators()) != null) {
                    while (psSysTranslators.hasNext()) {
                        IPSSysTranslator iPSSysTranslator = psSysTranslators.next();
                        if (!this.isCodeGenModelMode() && !iPSSysTranslator.isEnableDynaModel()) continue;
                        this.pubPSModelObjectModel(iPSSysTranslator);
                    }
                }
                if ((psSysLans = iPSSystem.getAllPSSysLans()) != null) {
                    while (psSysLans.hasNext()) {
                        IPSSysLan iPSSysLan = psSysLans.next();
                        if (!this.isCodeGenModelMode() && !iPSSysLan.isEnableDynaModel()) continue;
                        this.pubPSModelObjectModel(iPSSysLan);
                    }
                }
                if ((psSysI18Ns = iPSSystem.getAllPSSysI18Ns()) != null) {
                    while (psSysI18Ns.hasNext()) {
                        IPSSysI18N iPSSysI18N = psSysI18Ns.next();
                        if (!this.isCodeGenModelMode() && !iPSSysI18N.isEnableDynaModel()) continue;
                        this.pubPSModelObjectModel(iPSSysI18N);
                    }
                }
                if ((psDERGroups = iPSSystem.getAllPSDERGroups()) != null) {
                    while (psDERGroups.hasNext()) {
                        IPSDERGroup iPSDERGroup = psDERGroups.next();
                        if (!iPSDERGroup.isEnableDynaModel()) continue;
                        this.pubPSModelObjectModel(iPSDERGroup);
                    }
                }
            }
            long nTime2 = System.currentTimeMillis() - nStartTime;
            if (this.dumpRunnableList != null) {
                while (true) {
                    psSysUserRoles = this.dumpRunnableList;
                    synchronized (psSysUserRoles) {
                        if (this.dumpRunnableList.size() == 0) {
                            break;
                        }
                    }
                    Thread.sleep(10L);
                }
            }
            long nTime3 = System.currentTimeMillis() - nStartTime;
            log.debug((Object)String.format("\u53d1\u5e03\u52a8\u6001\u6a21\u578b\u8017\u65f6[%1$s + %2$s = %3$s]ms", nTime2, nTime3 - nTime2, nTime3));
            this.bRunDumpThread = false;
        }
        catch (Exception ex) {
            this.bRunDumpThread = false;
            throw ex;
        }
    }

    protected void pubPSSystemModuleModel(IPSSystemModule iPSSystemModule) throws Exception {
        Iterator<IPSWorkflow> psWorkflows;
        Iterator<IPSDataEntity> psDataEntities;
        Iterator<IPSCodeList> psCodeLists;
        if (this.nDynaInstMode == 2) {
            if (StringHelper.compare((String)iPSSystemModule.getDynaInstTag(), (String)this.strDynaInstTag, (boolean)false) == 0) {
                this.pubPSModelObjectModel(iPSSystemModule);
            }
        } else if (this.nDynaInstMode == 1) {
            this.pubPSModelObjectModel(iPSSystemModule);
        }
        if ((psCodeLists = iPSSystemModule.getAllPSCodeLists()) != null) {
            while (psCodeLists.hasNext()) {
                IPSCodeList iPSCodeList = psCodeLists.next();
                if (!this.isCodeGenModelMode() && (!iPSCodeList.isEnableDynaModel() || this.nDynaInstMode == 2 && StringHelper.compare((String)iPSCodeList.getDynaInstTag(), (String)this.strDynaInstTag, (boolean)false) != 0)) continue;
                this.pubPSModelObjectModel(iPSCodeList);
            }
        }
        if ((psDataEntities = iPSSystemModule.getAllPSDataEntities()) != null) {
            while (psDataEntities.hasNext()) {
                IPSDataEntity iPSDataEntity = psDataEntities.next();
                if (!this.isCodeGenModelMode() && (!iPSDataEntity.isEnableDynaModel() || this.nDynaInstMode == 2 && StringHelper.compare((String)iPSDataEntity.getDynaInstTag(), (String)this.strDynaInstTag, (boolean)false) != 0)) continue;
                this.pubPSDataEntityModel(iPSDataEntity);
            }
        }
        if ((psWorkflows = iPSSystemModule.getAllPSWorkflows()) != null) {
            while (psWorkflows.hasNext()) {
                IPSWorkflow iPSWorkflow = psWorkflows.next();
                if (!this.isCodeGenModelMode() && (!iPSWorkflow.isEnableDynaModel() || this.nDynaInstMode == 2 && StringHelper.compare((String)iPSWorkflow.getDynaInstTag(), (String)this.strDynaInstTag, (boolean)false) != 0)) continue;
                this.pubPSWorkflowModel(iPSWorkflow);
            }
        }
    }

    protected void pubPSApplicationDynaInstModel(IPSApplication iPSApplication) throws Exception {
        Iterator<IPSAppLan> psAppLans;
        Iterator<IPSAppMenuModel> psAppMenuModels;
        Iterator<IPSAppBIScheme> psAppBISchemes;
        Iterator<IPSAppCodeList> psAppCodeLists;
        Iterator<IPSAppDataEntity> psAppDataEntities;
        if (this.nDynaInstMode == 1 || this.nDynaInstMode == 2) {
            this.pubPSModelObjectModel(iPSApplication);
            this.pubPSModelObjectModel2(iPSApplication, "SIMPLEAPP", false, "simple");
            this.pubPSModelObjectModel2(iPSApplication, "HUBSUBAPP", false, "hubsubapp");
        }
        HashMap<String, String> controlModelMap = new HashMap<String, String>();
        Iterator<IPSAppView> psAppViews = iPSApplication.getAllPSAppViews();
        if (psAppViews != null) {
            while (psAppViews.hasNext()) {
                IPSAppView iPSAppView = psAppViews.next();
                if (!this.isCodeGenModelMode() && (!iPSAppView.isEnableDynaModel() || this.nDynaInstMode == 2 && StringHelper.compare((String)iPSAppView.getDynaInstTag(), (String)this.strDynaInstTag, (boolean)false) != 0)) continue;
                this.pubPSAppViewModel(iPSAppView, controlModelMap);
            }
        }
        if ((psAppDataEntities = iPSApplication.getAllPSAppDataEntities()) != null) {
            while (psAppDataEntities.hasNext()) {
                IPSAppDataEntity iPSAppDataEntity = psAppDataEntities.next();
                if (!this.isCodeGenModelMode() && (!iPSAppDataEntity.isEnableDynaModel() || this.nDynaInstMode == 2 && StringHelper.compare((String)iPSAppDataEntity.getDynaInstTag(), (String)this.strDynaInstTag, (boolean)false) != 0)) continue;
                this.pubPSAppDataEntityModel(iPSAppDataEntity, controlModelMap);
            }
        }
        if ((psAppCodeLists = iPSApplication.getAllPSAppCodeLists()) != null) {
            while (psAppCodeLists.hasNext()) {
                IPSAppCodeList iPSAppCodeList = psAppCodeLists.next();
                if (!this.isCodeGenModelMode() && (!iPSAppCodeList.isEnableDynaModel() || this.nDynaInstMode == 2 && StringHelper.compare((String)iPSAppCodeList.getDynaInstTag(), (String)this.strDynaInstTag, (boolean)false) != 0)) continue;
                this.pubPSModelObjectModel(iPSAppCodeList);
            }
        }
        if ((psAppBISchemes = iPSApplication.getAllPSAppBISchemes()) != null) {
            while (psAppBISchemes.hasNext()) {
                IPSAppBIScheme iPSAppBIScheme = psAppBISchemes.next();
                if (!this.isCodeGenModelMode() && !iPSAppBIScheme.isEnableDynaModel()) continue;
                this.pubPSAppBISchemeModel(iPSAppBIScheme);
            }
        }
        if (this.nDynaInstMode == 1 && (psAppMenuModels = iPSApplication.getAllPSAppMenuModels()) != null) {
            while (psAppMenuModels.hasNext()) {
                IPSAppMenuModel iPSAppMenuModel = psAppMenuModels.next();
                if (!this.isCodeGenModelMode() && !iPSAppMenuModel.isEnableDynaModel()) continue;
                this.pubPSModelObjectModel(iPSAppMenuModel);
            }
        }
        if ((this.nDynaInstMode == 1 || this.nDynaInstMode == 2) && (psAppLans = iPSApplication.getAllPSAppLans()) != null) {
            while (psAppLans.hasNext()) {
                IPSAppLan iPSAppLan = psAppLans.next();
                if (!this.isCodeGenModelMode() && !iPSAppLan.isEnableDynaModel()) continue;
                this.pubPSModelObjectModel(iPSAppLan);
            }
        }
        if (this.isCodeGenModelMode()) {
            Iterator<IPSAppCounter> psAppCounters;
            Iterator<IPSAppModule> psAppModules = iPSApplication.getAllPSAppModules();
            if (psAppModules != null) {
                while (psAppModules.hasNext()) {
                    IPSAppModule iPSAppModule = psAppModules.next();
                    this.pubPSModelObjectModel(iPSAppModule);
                }
            }
            if ((psAppCounters = iPSApplication.getAllPSAppCounters()) != null) {
                while (psAppCounters.hasNext()) {
                    IPSAppCounter iPSAppCounter = psAppCounters.next();
                    this.pubPSModelObjectModel(iPSAppCounter);
                }
            }
        }
    }

    protected void pubPSAppDataEntityModel(IPSAppDataEntity iPSAppDataEntity, Map<String, String> controlModelMap) throws Exception {
        Iterator<IPSControl> psControls;
        Iterator<IPSAppDEUILogic> psAppDEUILogics;
        this.pubPSModelObjectModel(iPSAppDataEntity);
        Iterator<IPSAppDELogic> psAppDELogics = iPSAppDataEntity.getAllPSAppDELogics();
        if (psAppDELogics != null) {
            while (psAppDELogics.hasNext()) {
                IPSAppDELogic iPSAppDELogic = psAppDELogics.next();
                this.pubPSModelObjectModel(iPSAppDELogic);
            }
        }
        if ((psAppDEUILogics = iPSAppDataEntity.getAllPSAppDEUILogics()) != null) {
            while (psAppDEUILogics.hasNext()) {
                IPSAppDEUILogic iPSAppDEUILogic = psAppDEUILogics.next();
                this.pubPSModelObjectModel(iPSAppDEUILogic);
            }
        }
        if ((psControls = iPSAppDataEntity.getPSControls()) != null) {
            while (psControls.hasNext()) {
                IPSControl iPSControl = psControls.next();
                String strFilePath = iPSControl.getDynaModelFilePath();
                if (StringHelper.isNullOrEmpty((String)strFilePath) || controlModelMap.containsKey(strFilePath)) continue;
                this.pubPSModelObjectModel(iPSControl, "SINGLE", false);
                controlModelMap.put(strFilePath, "");
            }
        }
    }

    protected void pubPSAppViewModel(IPSAppView iPSAppView, Map<String, String> controlModelMap) throws Exception {
        ArrayList<IPSControl> psControls;
        if (iPSAppView.isEnableDynaModel()) {
            this.pubPSModelObjectModel(iPSAppView);
        }
        if ((psControls = iPSAppView.getAllPSControls()) != null) {
            for (IPSControl iPSControl : psControls) {
                String strFilePath = iPSControl.getDynaModelFilePath();
                if (StringHelper.isNullOrEmpty((String)strFilePath) || controlModelMap.containsKey(strFilePath)) continue;
                this.pubPSModelObjectModel(iPSControl, "SINGLE", false);
                controlModelMap.put(strFilePath, "");
            }
        }
    }

    protected void pubPSAppBISchemeModel(IPSAppBIScheme iPSAppBIScheme) throws Exception {
        if (iPSAppBIScheme.isEnableDynaModel()) {
            this.pubPSModelObjectModel(iPSAppBIScheme);
        }
    }

    protected void pubPSDataEntityModel(IPSDataEntity iPSDataEntity) throws Exception {
        Iterator<IPSDEReport> psDEReports;
        Iterator<IPSDEPrint> psDEPrints;
        Iterator<IPSDERBase> minorPSDERs;
        Iterator<IPSDERBase> majorPSDERs;
        Iterator<IPSDEDataSync> psDEDataSyncs;
        Iterator<IPSDELogic> psDELogics;
        this.pubPSModelObjectModel(iPSDataEntity);
        Iterator<IPSDEAction> psDEActions = iPSDataEntity.getAllPSDEActions();
        if (psDEActions != null) {
            while (psDEActions.hasNext()) {
                IPSDEAction iPSDEAction = psDEActions.next();
                this.pubPSModelObjectModel(iPSDEAction);
            }
        }
        if ((psDELogics = iPSDataEntity.getAllPSDELogics()) != null) {
            while (psDELogics.hasNext()) {
                IPSDELogic iPSDELogic = psDELogics.next();
                this.pubPSModelObjectModel(iPSDELogic);
            }
        }
        if ((psDEDataSyncs = iPSDataEntity.getAllPSDEDataSyncs()) != null) {
            while (psDEDataSyncs.hasNext()) {
                IPSDEDataSync iPSDEDataSync = psDEDataSyncs.next();
                this.pubPSModelObjectModel(iPSDEDataSync);
            }
        }
        if ((majorPSDERs = iPSDataEntity.getMajorPSDERs()) != null) {
            while (majorPSDERs.hasNext()) {
                IPSDERBase iPSDERBase = majorPSDERs.next();
                this.pubPSModelObjectModel(iPSDERBase);
            }
        }
        if ((minorPSDERs = iPSDataEntity.getMinorPSDERs()) != null) {
            while (minorPSDERs.hasNext()) {
                IPSDERBase iPSDERBase = minorPSDERs.next();
                this.pubPSModelObjectModel(iPSDERBase);
            }
        }
        if ((psDEPrints = iPSDataEntity.getAllPSDEPrints()) != null) {
            while (psDEPrints.hasNext()) {
                IPSDEPrint iPSDEPrint = psDEPrints.next();
                this.pubPSModelObjectModel(iPSDEPrint);
            }
        }
        if ((psDEReports = iPSDataEntity.getAllPSDEReports()) != null) {
            while (psDEReports.hasNext()) {
                IPSDEReport iPSDEReport = psDEReports.next();
                this.pubPSModelObjectModel(iPSDEReport);
            }
        }
        if ((PSObjectImpl.getDynaModelPubMode() & 4) != 0) {
            Iterator<IPSDEDataRelation> psDEDataRelations;
            Iterator<IPSDEDRGroup> psDEDRGroups;
            Iterator<IPSDEDRItem> psDEDRItems;
            Iterator<IPSDEFGroup> psDEFGroups;
            Iterator<IPSDEDataQuery> psDEDataQueries;
            Iterator<IPSDEMSLogic> psDEMSLogics;
            Iterator<IPSDEDataFlow> psDEDataFlows;
            Iterator<IPSDEUserRole> psDEUserRoles = iPSDataEntity.getAllPSDEUserRoles();
            if (psDEUserRoles != null) {
                while (psDEUserRoles.hasNext()) {
                    IPSDEUserRole iPSDEUserRole = psDEUserRoles.next();
                    this.pubPSModelObjectModel(iPSDEUserRole);
                }
            }
            if ((psDEDataFlows = iPSDataEntity.getAllPSDEDataFlows()) != null) {
                while (psDEDataFlows.hasNext()) {
                    IPSDEDataFlow iPSDEDataFlow = psDEDataFlows.next();
                    this.pubPSModelObjectModel(iPSDEDataFlow);
                }
            }
            if ((psDEMSLogics = iPSDataEntity.getAllPSDEMSLogics()) != null) {
                while (psDEMSLogics.hasNext()) {
                    IPSDEMSLogic iPSDEMSLogic = psDEMSLogics.next();
                    this.pubPSModelObjectModel(iPSDEMSLogic);
                }
            }
            if ((psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries()) != null) {
                while (psDEDataQueries.hasNext()) {
                    IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                    Iterator<IPSDEDataQueryCode> psDEDataQueryCodes = iPSDEDataQuery.getAllPSDEDataQueryCodes();
                    if (psDEDataQueryCodes == null) continue;
                    while (psDEDataQueryCodes.hasNext()) {
                        IPSDEDataQueryCode iPSDEDataQueryCode = psDEDataQueryCodes.next();
                        this.pubPSModelObjectModel(iPSDEDataQueryCode);
                    }
                }
            }
            if ((psDEFGroups = iPSDataEntity.getAllPSDEFGroups()) != null) {
                while (psDEFGroups.hasNext()) {
                    IPSDEFGroup iPSDEFGroup = psDEFGroups.next();
                    this.pubPSModelObjectModel(iPSDEFGroup);
                }
            }
            if ((psDEDRItems = iPSDataEntity.getAllPSDEDRItems()) != null) {
                while (psDEDRItems.hasNext()) {
                    IPSDEDRItem iPSDEDRItem = psDEDRItems.next();
                    this.pubPSModelObjectModel(iPSDEDRItem);
                }
            }
            if ((psDEDRGroups = iPSDataEntity.getAllPSDEDRGroups()) != null) {
                while (psDEDRGroups.hasNext()) {
                    IPSDEDRGroup iPSDEDRGroup = psDEDRGroups.next();
                    this.pubPSModelObjectModel(iPSDEDRGroup);
                }
            }
            if ((psDEDataRelations = iPSDataEntity.getAllPSDEDataRelations()) != null) {
                while (psDEDataRelations.hasNext()) {
                    IPSDEDataRelation iPSDEDataRelation = psDEDataRelations.next();
                    this.pubPSModelObjectModel(iPSDEDataRelation);
                }
            }
        }
        if (this.isCodeGenModelMode()) {
            Iterator<IPSDEActionGroup> psDEActionGroups;
            Iterator<IPSDERGroup> psDERGroups;
            Iterator<IPSDEGroup> psDEGroups = iPSDataEntity.getAllPSDEGroups();
            if (psDEGroups != null) {
                while (psDEGroups.hasNext()) {
                    IPSDEGroup iPSDEGroup = psDEGroups.next();
                    this.pubPSModelObjectModel(iPSDEGroup);
                }
            }
            if ((psDERGroups = iPSDataEntity.getAllPSDERGroups()) != null) {
                while (psDERGroups.hasNext()) {
                    IPSDERGroup iPSDERGroup = psDERGroups.next();
                    this.pubPSModelObjectModel(iPSDERGroup);
                }
            }
            if ((psDEActionGroups = iPSDataEntity.getAllPSDEActionGroups()) != null) {
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
                if (!this.isCodeGenModelMode() && !iPSWFVersion.isEnableDynaModel()) continue;
                this.pubPSModelObjectModel(iPSWFVersion);
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
                if (psSysTestCases == null) continue;
                while (psSysTestCases.hasNext()) {
                    IPSSysTestCase iPSSysTestCase = psSysTestCases.next();
                    this.pubPSModelObjectModel(iPSSysTestCase);
                }
            }
        }
    }

    protected void pubPSAppStoreBoardModel(IPSApplication iPSApplication) throws Exception {
        String strFilePath;
        HashMap<String, PSAppSBItem> psAppSBItemMap = new HashMap<String, PSAppSBItem>();
        ArrayList<PSAppSBItemRS> psAppSBItemRSList = new ArrayList<PSAppSBItemRS>();
        ObjectNode objectNode = JsonNodeHelper.createObjectNode();
        ArrayNode psAppSBItems = objectNode.putArray("psappsbitems");
        ArrayNode psAppSBItemRSs = objectNode.putArray("psappsbitemrses");
        PSAppStoryBoard psAppStoryBoard = new PSAppStoryBoard();
        IPSAppView defaultPSAppView = iPSApplication.getDefaultPSAppView();
        if (defaultPSAppView != null) {
            HashMap params;
            PSAppStoryBoardHelper2 psAppStoryBoardHelper = new PSAppStoryBoardHelper2();
            psAppStoryBoardHelper.getPSAppSBItem(defaultPSAppView, false, psAppStoryBoard, psAppSBItemMap, psAppSBItemRSList);
            for (PSAppSBItem psAppSBItem : psAppSBItemMap.values()) {
                if (DataObject.getBoolValue((Integer)psAppSBItem.getUserFlag(), (boolean)false)) continue;
                if (StringHelper.compare((String)psAppSBItem.getItemType(), (String)"APPVIEW", (boolean)false) == 0 && defaultPSAppView.getId().equals(psAppSBItem.getPSAppViewId())) {
                    psAppSBItem.setRootItem(Integer.valueOf(1));
                    JsonNodeHelper.put((ObjectNode)objectNode, (String)"rootitem", (Object)psAppSBItem.getPSAppSBItemId());
                }
                params = new HashMap();
                psAppSBItem.fillMap(params, false);
                ObjectNode itemNode = psAppSBItems.addObject();
                for (Map.Entry entry : params.entrySet()) {
                    if (entry.getValue() == null) continue;
                    JsonNodeHelper.put((ObjectNode)itemNode, (String)((String)entry.getKey()).toLowerCase(), entry.getValue());
                }
            }
            for (PSAppSBItemRS psAppSBItemRS : psAppSBItemRSList) {
                params = new HashMap();
                psAppSBItemRS.fillMap(params, false);
                ObjectNode itemRSNode = psAppSBItemRSs.addObject();
                for (Map.Entry entry : params.entrySet()) {
                    if (entry.getValue() == null) continue;
                    JsonNodeHelper.put((ObjectNode)itemRSNode, (String)((String)entry.getKey()).toLowerCase(), entry.getValue());
                }
            }
        }
        if (StringHelper.isNullOrEmpty((String)(strFilePath = iPSApplication.getDynaModelFilePath()))) {
            log.error((Object)String.format("\u65e0\u6cd5\u8f93\u51fa\u6a21\u578b\u5bf9\u8c61[%1$s][%2$s|%3$s]\u52a8\u6001\u6a21\u578b\uff0c\u6ca1\u6709\u5b9a\u4e49\u6a21\u578b\u8def\u5f84", iPSApplication.getModelType(), iPSApplication.getName(), iPSApplication.getId()));
            return;
        }
        strFilePath = strFilePath.substring(0, strFilePath.length() - 5);
        strFilePath = String.valueOf(strFilePath) + ".storyboard.json";
        File file = new File(String.valueOf(this.strCfgPath) + File.separator + strFilePath);
        File parentFolder = file.getParentFile();
        if (parentFolder != null && !parentFolder.exists()) {
            parentFolder.mkdirs();
        }
        String strCode = DTOMAPPER.writerWithDefaultPrettyPrinter().writeValueAsString((Object)objectNode);
        FileWriterHelper.write(file.getCanonicalPath(), strCode);
    }

    protected void pubPSModelObjectModel(IPSModelObject iPSModelObject) throws Exception {
        this.pubPSModelObjectModel(iPSModelObject, null, false);
    }

    protected void pubPSModelObjectModel(IPSModelObject iPSModelObject, boolean bUserModelOnly) throws Exception {
        this.pubPSModelObjectModel(iPSModelObject, null, bUserModelOnly);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void pubPSModelObjectModel(IPSModelObject iPSModelObject, String strType, boolean bUserModelOnly) throws Exception {
        final IPSModelObject iPSModelObject2 = iPSModelObject;
        final String strType2 = strType;
        final boolean bUserModelOnly2 = bUserModelOnly;
        final int nDynaModelPubMode2 = PSObjectImpl.getDynaModelPubMode();
        final boolean bDynaModelPubIgnorePF2 = PSObjectImpl.getDynaModelPubIgnorePF();
        final boolean bDynaModelPubIgnorePFReal2 = PSObjectImpl.getDynaModelPubIgnorePFReal();
        List<Runnable> list = this.dumpRunnableList;
        synchronized (list) {
            this.dumpRunnableList.add(new Runnable(){

                @Override
                public void run() {
                    int nDynaModelPubMode = PSObjectImpl.getDynaModelPubMode();
                    boolean bDynaModelPubIgnorePF = PSObjectImpl.getDynaModelPubIgnorePF();
                    boolean bDynaModelPubIgnorePFReal = PSObjectImpl.getDynaModelPubIgnorePFReal();
                    PSObjectImpl.setDynaModelPubMode(nDynaModelPubMode2);
                    PSObjectImpl.setDynaModelPubIgnorePF(bDynaModelPubIgnorePF2);
                    PSObjectImpl.setDynaModelPubIgnorePFReal(bDynaModelPubIgnorePFReal2);
                    try {
                        try {
                            PubDynaInstModelPSSysDevBKTaskImpl.this.pubPSModelObjectModel2(iPSModelObject2, strType2, bUserModelOnly2, null);
                        }
                        catch (Exception ex) {
                            log.debug((Object)ex);
                            PSObjectImpl.setDynaModelPubMode(nDynaModelPubMode);
                            PSObjectImpl.setDynaModelPubIgnorePF(bDynaModelPubIgnorePF);
                            PSObjectImpl.setDynaModelPubIgnorePFReal(bDynaModelPubIgnorePFReal);
                        }
                    }
                    finally {
                        PSObjectImpl.setDynaModelPubMode(nDynaModelPubMode);
                        PSObjectImpl.setDynaModelPubIgnorePF(bDynaModelPubIgnorePF);
                        PSObjectImpl.setDynaModelPubIgnorePFReal(bDynaModelPubIgnorePFReal);
                    }
                }
            });
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     */
    protected void pubPSModelObjectModel2(IPSModelObject iPSModelObject, String strType, boolean bUserModelOnly, String strAppend) throws Exception {
        iPSDynaInstSupportable = null;
        if (!(iPSModelObject instanceof IPSDynaInstSupportable)) {
            PubDynaInstModelPSSysDevBKTaskImpl.log.error((Object)String.format("\u65e0\u6cd5\u8f93\u51fa\u6a21\u578b\u5bf9\u8c61[%1$s][%2$s|%3$s]\u52a8\u6001\u6a21\u578b\uff0c\u6ca1\u6709\u5b9e\u73b0\u63a5\u53e3", new Object[]{iPSModelObject.getModelType(), iPSModelObject.getName(), iPSModelObject.getId()}));
            return;
        }
        iPSDynaInstSupportable = (IPSDynaInstSupportable)iPSModelObject;
        strFilePath = iPSDynaInstSupportable.getDynaModelFilePath();
        if (StringHelper.isNullOrEmpty((String)strFilePath)) {
            PubDynaInstModelPSSysDevBKTaskImpl.log.error((Object)String.format("\u65e0\u6cd5\u8f93\u51fa\u6a21\u578b\u5bf9\u8c61[%1$s][%2$s|%3$s]\u52a8\u6001\u6a21\u578b\uff0c\u6ca1\u6709\u5b9a\u4e49\u6a21\u578b\u8def\u5f84", new Object[]{iPSModelObject.getModelType(), iPSModelObject.getName(), iPSModelObject.getId()}));
            return;
        }
        if (!StringHelper.isNullOrEmpty((String)strAppend)) {
            strFilePath = strFilePath.substring(0, strFilePath.length() - 4);
            strFilePath = String.valueOf(strFilePath) + strAppend.toLowerCase();
            strFilePath = String.valueOf(strFilePath) + ".json";
        }
        PSObjectImpl.resetModelExportMap();
        objNode = iPSModelObject.toModel(strType);
        if (objNode == null) {
            PubDynaInstModelPSSysDevBKTaskImpl.log.error((Object)String.format("\u65e0\u6cd5\u8f93\u51fa\u6a21\u578b\u5bf9\u8c61[%1$s][%2$s|%3$s]\u52a8\u6001\u6a21\u578b\uff0c\u6ca1\u6709\u8fd4\u56de\u5185\u5bb9", new Object[]{iPSModelObject.getModelType(), iPSModelObject.getName(), iPSModelObject.getId()}));
            return;
        }
        file = new File(String.valueOf(this.strCfgPath) + File.separator + strFilePath);
        if (!bUserModelOnly) {
            if (iPSModelObject instanceof IPSSysContentCat) {
                jsonNode = objNode.get("getPSSysContents");
                if (jsonNode instanceof ArrayNode) {
                    arrayNode = (ArrayNode)jsonNode;
                    nSize = arrayNode.size();
                    i = 0;
                    while (i < nSize) {
                        contentNode = (ObjectNode)arrayNode.get(i);
                        if (contentNode.has("content")) {
                            contentNode.remove("content");
                            contentNode.put("_file", true);
                        }
                        ++i;
                    }
                }
                if ((psSysContents = (iPSSysContentCat = (IPSSysContentCat)iPSModelObject).getPSSysContents()) != null) {
                    while (psSysContents.hasNext()) {
                        iPSSysContent = psSysContents.next();
                        if (StringHelper.isNullOrEmpty((String)iPSSysContent.getCodeName())) continue;
                        strCode = iPSSysContent.getContent();
                        strContentFilePath = String.format("%1$s.%2$s.txt", new Object[]{file.getCanonicalPath(), iPSSysContent.getCodeName().toLowerCase()});
                        file2 = new File(strContentFilePath);
                        if (!StringHelper.isNullOrEmpty((String)strCode)) {
                            FileWriterHelper.write3(file2, strCode);
                            continue;
                        }
                        if (!file2.exists()) continue;
                        file2.delete();
                    }
                }
            }
            if (!StringHelper.isNullOrEmpty((String)this.getGroovySourcePath()) && this.nDynaInstMode == 1 && iPSModelObject instanceof IPSSystem) {
                iPSSystem = (IPSSystem)iPSModelObject;
                bPubSFPluginCodeFile = false;
                if (iPSSystem.getDefaultPSSysSFPub() != null) {
                    bPubSFPluginCodeFile = iPSSystem.getDefaultPSSysSFPub().isPubSFPluginCodeFile();
                }
                psSysSFPluginNodeMap = new HashMap<String, ObjectNode>();
                if (bPubSFPluginCodeFile && (jsonNode = objNode.get("getAllPSSysSFPlugins")) instanceof ArrayNode) {
                    arrayNode = (ArrayNode)jsonNode;
                    nSize = arrayNode.size();
                    i = 0;
                    while (i < nSize) {
                        contentNode = (ObjectNode)arrayNode.get(i);
                        if (contentNode.has("dynaModelFilePath") && !StringHelper.isNullOrEmpty((String)(strFilePath2 = contentNode.get("dynaModelFilePath").asText()))) {
                            psSysSFPluginNodeMap.put(strFilePath2, contentNode);
                        }
                        ++i;
                    }
                }
                ** if ((psSysSFPlugins = iPSSystem.getAllPSSysSFPlugins()) == null) goto lbl111
                while (psSysSFPlugins.hasNext()) {
                    iPSSysSFPlugin = psSysSFPlugins.next();
                    if (!iPSSysSFPlugin.isRuntimeObject()) continue;
                    if (bPubSFPluginCodeFile) {
                        strFilePath2 = iPSSysSFPlugin.getDynaModelFilePath();
                        if (!StringHelper.isNullOrEmpty((String)strFilePath2)) {
                            file2 = new File(String.valueOf(this.strCfgPath) + File.separator + strFilePath2);
                            contentNode = (ObjectNode)psSysSFPluginNodeMap.get(strFilePath2);
                            strCode = null;
                            if (contentNode != null) {
                                v0 = strCode = iPSSysSFPlugin.isTemplateMode() != false ? iPSSysSFPlugin.getRealCode() : iPSSysSFPlugin.getTemplCode();
                                if (contentNode.has("templCode")) {
                                    contentNode.remove("templCode");
                                    contentNode.put("_file", true);
                                }
                            }
                            strContentFilePath = String.format("%1$s.txt", new Object[]{file2.getCanonicalPath()});
                            file3 = new File(strContentFilePath);
                            if (!StringHelper.isNullOrEmpty((String)strCode)) {
                                FileWriterHelper.write3(file3, strCode);
                            } else if (file3.exists()) {
                                file3.delete();
                            }
                        } else {
                            PubDynaInstModelPSSysDevBKTaskImpl.log.error((Object)String.format("\u65e0\u6cd5\u8f93\u51fa\u540e\u53f0\u63d2\u4ef6[%1$s|%2$s]\u4ee3\u7801\u6587\u4ef6\uff0c\u6ca1\u6709\u5b9a\u4e49\u6a21\u578b\u8def\u5f84", new Object[]{iPSSysSFPlugin.getName(), iPSSysSFPlugin.getId()}));
                        }
                    }
                    if (StringHelper.isNullOrEmpty((String)(strRTObjectName = iPSSysSFPlugin.getRTObjectName()))) continue;
                    if (strRTObjectName.indexOf("GROOVY") == 0) {
                        strRTObjectName = strRTObjectName.length() > "GROOVY".length() + 1 ? strRTObjectName.substring("GROOVY".length() + 1) : null;
                    }
                    if (StringHelper.isNullOrEmpty((String)strRTObjectName) || strRTObjectName.indexOf(".") == -1) continue;
                    strGroovyFilePath = String.valueOf(this.getGroovySourcePath()) + File.separator + strRTObjectName.replace(".", File.separator) + ".groovy";
                    strCode = iPSSysSFPlugin.isTemplateMode() != false ? iPSSysSFPlugin.getRealCode() : iPSSysSFPlugin.getTemplCode();
                    file2 = new File(strGroovyFilePath);
                    if (!StringHelper.isNullOrEmpty((String)strCode)) {
                        FileWriterHelper.write3(file2, strCode);
                        continue;
                    }
                    if (!file2.exists()) continue;
                    file2.delete();
lbl-1000:
                    // 2 sources

                    {
                    }
                }
            }
lbl111:
            // 4 sources

            if (this.dumpFileList == null) {
                strCode = PubDynaInstModelPSSysDevBKTaskImpl.DTOMAPPER.writerWithDefaultPrettyPrinter().writeValueAsString((Object)objNode);
                bRet = FileWriterHelper.write3(file, (String)strCode);
                if (strCode.length() >= 0x100000) {
                    if (bRet) {
                        PubDynaInstModelPSSysDevBKTaskImpl.log.debug((Object)String.format("\u6587\u4ef6[%1$s][%2$s]\u5185\u5bb9\u6ca1\u6709\u53d8\u5316", new Object[]{file.getCanonicalPath(), strCode.length()}));
                    } else {
                        PubDynaInstModelPSSysDevBKTaskImpl.log.debug((Object)String.format("\u6587\u4ef6[%1$s][%2$s]\u5185\u5bb9\u6709\u53d8\u5316", new Object[]{file.getCanonicalPath(), strCode.length()}));
                    }
                }
            } else {
                strCode = this.dumpFileList;
                synchronized (strCode) {
                    this.dumpFileList.add(new DumpFile(file, objNode));
                }
            }
        }
        if (this.psSFLogicTemplListMap != null && (list = this.psSFLogicTemplListMap.get(strName = String.format("@LOGIC/@MODEL/%1$s", new Object[]{iPSModelObject.getDumpModelType()}))) != null) {
            for (IPSSFLogicTempl iPSSFLogicTempl : list) {
                if (iPSSFLogicTempl.getPSSFPubCode() == null) continue;
                params = new HashMap<String, Object>();
                params.put("item", iPSModelObject);
                params.put("P", new PSCodePublisherContextImpl());
                if (this.iPSSystem != null) {
                    params.put("sys", this.iPSSystem);
                    if (this.iPSSystem.getDefaultPSSysSFPub() != null) {
                        params.put("pub", this.iPSSystem.getDefaultPSSysSFPub());
                    }
                }
                strCode = PSTemplHelper.generateCode(iPSSFLogicTempl.getModelData(), "TEMPLCODE", params);
                if (iPSSFLogicTempl instanceof IPSSFLogicTempl2 && (iPSSFLogicTempl2 = (IPSSFLogicTempl2)iPSSFLogicTempl).isCheckModelOnly()) continue;
                strPath = String.format("%1$s.%2$s", new Object[]{file.getCanonicalPath(), iPSSFLogicTempl.getPSSFPubCode().getName()});
                if (!StringHelper.isNullOrEmpty((String)strCode)) {
                    strCode = strCode.trim();
                }
                file2 = new File(strPath);
                if (!StringHelper.isNullOrEmpty((String)strCode)) {
                    FileWriterHelper.write3(file2, strCode);
                    continue;
                }
                if (!file2.exists()) continue;
                file2.delete();
            }
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
        block8: {
            String strCallbackUrl;
            PSDevSln psDevSln;
            String strRunMode;
            block10: {
                block9: {
                    if (this.iPSDevSlnSysDynaInst == null) {
                        return "";
                    }
                    try {
                        strRunMode = "";
                        if (this.getPSSysRunSession() != null) {
                            strRunMode = this.getPSSysRunSession().getRunMode();
                        }
                        if (StringHelper.isNullOrEmpty((String)strRunMode)) {
                            strRunMode = "PUBDYNAINSTMODEL";
                        }
                        if (StringHelper.isNullOrEmpty((String)this.iPSDevSlnSysDynaInst.getPSDevSlnId())) break block8;
                        psDevSln = new PSDevSln();
                        CallResult callResult = this.getPSModelHelper(null).getPSDevSln(this.iPSDevSlnSysDynaInst.getPSDevSlnId(), psDevSln);
                        if (callResult.isError()) {
                            throw new Exception(StringHelper.format((String)"\u67e5\u8be2\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                        }
                        if (psDevSln.isENABLECALLBACKNull()) break block8;
                        if (psDevSln.getENABLECALLBACK()) break block9;
                        return "";
                    }
                    catch (Exception ex) {
                        log.error((Object)StringHelper.format((String)"\u8ba1\u7b97\u56de\u8c03\u4fe1\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                        return "";
                    }
                }
                strCallbackUrl = psDevSln.getCALLBACKURL();
                if (!StringHelper.isNullOrEmpty((String)strCallbackUrl)) break block10;
                return "";
            }
            return this.getRealCallbackUrl(strCallbackUrl, this.iPSDevSlnSysDynaInst.getId(), this.iPSDevSlnSysDynaInst.getPPSDevSlnSysDynaInstId(), psDevSln.getPSDEVSLNID(), strRunMode, psDevSln.getCALLBACKTAG());
        }
        return "";
    }

    protected String getRealCallbackUrl(String strUrl, String strPSDynaInstId, String strPPSDynaInstId, String strDevSlnId, String strRunMode, String strToken) {
        return strUrl.replace("{psdynainstid}", WebUtility.encodeURLParamValue((String)strPSDynaInstId)).replace("{ppsdynainstid}", WebUtility.encodeURLParamValue((String)strPPSDynaInstId)).replace("{psdevslnid}", WebUtility.encodeURLParamValue((String)strDevSlnId)).replace("{runmode}", WebUtility.encodeURLParamValue((String)strRunMode)).replace("{token}", WebUtility.encodeURLParamValue((String)strToken));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpRun() {
        while (this.bRunDumpThread) {
            Runnable runnable = null;
            List<Runnable> list = this.dumpRunnableList;
            synchronized (list) {
                if (this.dumpRunnableList.size() > 0) {
                    runnable = this.dumpRunnableList.remove(0);
                }
            }
            try {
                if (runnable != null) {
                    runnable.run();
                    continue;
                }
                Thread.sleep(10L);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void dumpFile() {
        while (this.bRunDumpThread) {
            DumpFile dumpFile = null;
            List<DumpFile> list = this.dumpFileList;
            synchronized (list) {
                if (this.dumpFileList.size() > 0) {
                    dumpFile = this.dumpFileList.remove(0);
                }
            }
            try {
                if (dumpFile != null) {
                    String strCode = DTOMAPPER.writerWithDefaultPrettyPrinter().writeValueAsString((Object)dumpFile.node);
                    FileWriterHelper.write3(dumpFile.file, strCode);
                    continue;
                }
                Thread.sleep(10L);
            }
            catch (Exception ex) {
                log.error((Object)ex);
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

