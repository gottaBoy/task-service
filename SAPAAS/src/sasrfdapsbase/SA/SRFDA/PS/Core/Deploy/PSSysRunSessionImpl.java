/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.CallResult
 *  net.ibizsys.paas.util.ObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPack;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDCAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.Deploy.IPSSystemAS;
import SA.SRFDA.PS.Core.Deploy.PSDCAppServerImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCDBDevInstImpl;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterFile;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterNetworkFlow;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterRuntime;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemRuntime;
import SA.SRFDA.PS.Core.PSModelRTMeta;
import SA.SRFDA.PS.Core.PSSystemObjectImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntimePlugin;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.PSCodePubSession;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSDevCenterAS;
import SA.SRFDA.PS.Data.PSDevCenterDBInst;
import SA.SRFDA.PS.Data.PSSysRunSession;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.CallResult;
import java.io.File;
import java.util.HashMap;
import net.ibizsys.paas.util.ObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSSysRunSessionImpl
extends PSSystemObjectImpl
implements IPSSysRunSession,
IPSSysPubRuntime {
    private static final Log log = LogFactory.getLog(PSSysRunSessionImpl.class);
    protected PSSysRunSession psSysRunSession = null;
    private IPSSystemDBConfig iPSSystemDBConfig = null;
    private IPSApplication iPSApplication = null;
    private IPSApplication iPSApplication2 = null;
    private IPSSystemAS iPSSystemAS = null;
    private IPSDBDevInst iPSDBDevInst = null;
    private IPSAppServer iPSAppServer = null;
    private String strLogBrokerUri = null;
    private String strLogQueueName = null;
    private boolean bRebuildMode = false;
    private boolean bEnableVC = true;
    private boolean bPubCodeOnly = false;
    private IPSSysSFPub iPSSysSFPub = null;
    private int nRebuildModeEx = 0;
    private String strRealRSId = "";
    private IPSDevCenterRuntime iPSDevCenter = null;
    private String strSysRootFolder = null;
    private String strPubRootFolder = null;
    private String strWorkshopFolder = null;
    private IPSMobAppPack iPSMobAppPack = null;
    protected HashMap<String, PSCodePubSession> psPFPubSessionMap = new HashMap();
    protected HashMap<String, PSCodePubSession> psSFPubSessionMap = new HashMap();
    protected HashMap<String, IPSSysPubRuntimePlugin> psSysPubRuntimePluginMap = new HashMap();
    private IPSSysServiceAPI iPSSysServiceAPI = null;
    private IPSDevSlnMSDepAPI iPSDevSlnMSDepAPI = null;
    private IPSDevSlnMSDepApp iPSDevSlnMSDepApp = null;
    private IPSDevSlnMSDepFunc iPSDevSlnMSDepFunc = null;
    public static final String LOGNAME_PSSYSRUNSESSION = "\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd";
    private boolean bTemplEngineV2 = false;
    private IPSSysDynaModel runPSSysDynaModel = null;
    private boolean bStopWhenTemplError = false;
    private boolean bDebugMode = false;
    private boolean bQuickMode = false;
    private int nQuickModeEx = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSSystem iPSSystem, PSSysRunSession psSysRunSession) throws Exception {
        int nRebuildMode;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSSystem(iPSSystem);
        if (StringHelper.compare((String)this.getPSSystemUtil().getTemplEngineVer(), (String)"V2", (boolean)true) == 0) {
            this.bTemplEngineV2 = true;
        }
        this.psSysRunSession = psSysRunSession;
        this.setId(this.psSysRunSession.getPSSYSRUNSESSIONID());
        this.setName(this.psSysRunSession.getPSSYSRUNSESSIONNAME());
        this.setPSObjectData(this.psSysRunSession);
        this.strRealRSId = this.psSysRunSession.getPSSYSRUNSESSIONID();
        this.iPSDevCenter = (IPSDevCenterRuntime)this.getPSModelStorage().getPSDevCenter(iPSSystem.getPSDevCenterId());
        if (!StringHelper.isNullOrEmpty((String)psSysRunSession.getPSSYSTEMASID())) {
            this.iPSSystemAS = iPSSystem.getPSSystemAS(psSysRunSession.getPSSYSTEMASID());
        }
        if (!StringHelper.isNullOrEmpty((String)psSysRunSession.getPSSYSTEMDBCFGNAME())) {
            this.iPSSystemDBConfig = iPSSystem.getPSSystemDBConfig(psSysRunSession.getPSSYSTEMDBCFGNAME());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysRunSession.getPSSYSAPPID())) {
            this.iPSApplication = this.iPSSystem.getPSApplication(this.psSysRunSession.getPSSYSAPPID());
            if (!StringHelper.isNullOrEmpty((String)this.psSysRunSession.getPSMOBAPPPACKID())) {
                this.iPSMobAppPack = this.iPSApplication.getPSMobAppPack(this.psSysRunSession.getPSMOBAPPPACKID());
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysRunSession.getPSSYSAPPID2())) {
            this.iPSApplication2 = this.iPSSystem.getPSApplication(this.psSysRunSession.getPSSYSAPPID2());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysRunSession.getPSSYSSERVICEAPIID())) {
            this.iPSSysServiceAPI = this.iPSSystem.getPSSysServiceAPI(this.psSysRunSession.getPSSYSSERVICEAPIID());
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysRunSession.getPSDEVSLNMSDEPAPIID())) {
            this.iPSDevSlnMSDepAPI = this.getPSModelStorage().getPSDevSlnMSDepAPI(this.psSysRunSession.getPSDEVSLNMSDEPAPIID());
            if (this.iPSDevSlnMSDepAPI.getPSDBDevInst() != null && (this.iPSSystemDBConfig == null || StringHelper.compare((String)this.iPSSystemDBConfig.getDBType(), (String)this.iPSDevSlnMSDepAPI.getPSDBDevInst().getDBType(), (boolean)false) != 0)) {
                if (this.iPSSystemDBConfig != null) {
                    this.getPSSystemUtil().getPSSysConsole().warn(LOGNAME_PSSYSRUNSESSION, StringHelper.format((String)"\u6307\u5b9a\u8fd0\u884c\u6570\u636e\u5e93[%1$s]\u4e0e\u5fae\u670d\u52a1\u63a5\u53e3\u90e8\u7f72\u6570\u636e\u5e93\u7c7b\u578b[%2$s]\u4e0d\u4e00\u81f4\uff0c\u4f7f\u7528\u5fae\u670d\u52a1\u63a5\u53e3\u90e8\u7f72\u6570\u636e\u5e93", (Object)this.iPSSystemDBConfig.getName(), (Object)this.iPSDevSlnMSDepAPI.getPSDBDevInst().getDBType()));
                }
                this.iPSSystemDBConfig = iPSSystem.getPSSystemDBConfig(this.iPSDevSlnMSDepAPI.getPSDBDevInst().getDBType(), true);
                if (this.iPSSystemDBConfig == null) {
                    throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e0d\u652f\u6301\u6570\u636e\u5e93\u7c7b\u578b[%1$s]", (Object)this.iPSDevSlnMSDepAPI.getPSDBDevInst().getDBType()));
                }
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysRunSession.getPSDEVSLNMSDEPAPPID())) {
            this.iPSDevSlnMSDepApp = this.getPSModelStorage().getPSDevSlnMSDepApp(this.psSysRunSession.getPSDEVSLNMSDEPAPPID());
            if (this.iPSDevSlnMSDepApp.getPSDBDevInst() != null && (this.iPSSystemDBConfig == null || StringHelper.compare((String)this.iPSSystemDBConfig.getDBType(), (String)this.iPSDevSlnMSDepApp.getPSDBDevInst().getDBType(), (boolean)false) != 0)) {
                if (this.iPSSystemDBConfig != null) {
                    this.getPSSystemUtil().getPSSysConsole().warn(LOGNAME_PSSYSRUNSESSION, StringHelper.format((String)"\u6307\u5b9a\u8fd0\u884c\u6570\u636e\u5e93[%1$s]\u4e0e\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72\u6570\u636e\u5e93\u7c7b\u578b[%2$s]\u4e0d\u4e00\u81f4\uff0c\u4f7f\u7528\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72\u6570\u636e\u5e93", (Object)this.iPSSystemDBConfig.getName(), (Object)this.iPSDevSlnMSDepAPI.getPSDBDevInst().getDBType()));
                }
                this.iPSSystemDBConfig = iPSSystem.getPSSystemDBConfig(this.iPSDevSlnMSDepApp.getPSDBDevInst().getDBType(), true);
                if (this.iPSSystemDBConfig == null) {
                    throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e0d\u652f\u6301\u6570\u636e\u5e93\u7c7b\u578b[%1$s]", (Object)this.iPSDevSlnMSDepApp.getPSDBDevInst().getDBType()));
                }
            }
        }
        if (!StringHelper.isNullOrEmpty((String)this.psSysRunSession.getPSDEVSLNMSDEPFUNCID())) {
            this.iPSDevSlnMSDepFunc = this.getPSModelStorage().getPSDevSlnMSDepFunc(this.psSysRunSession.getPSDEVSLNMSDEPFUNCID());
            if (this.iPSDevSlnMSDepFunc.getPSDBDevInst() != null && (this.iPSSystemDBConfig == null || StringHelper.compare((String)this.iPSSystemDBConfig.getDBType(), (String)this.iPSDevSlnMSDepFunc.getPSDBDevInst().getDBType(), (boolean)false) != 0)) {
                if (this.iPSSystemDBConfig != null) {
                    this.getPSSystemUtil().getPSSysConsole().warn(LOGNAME_PSSYSRUNSESSION, StringHelper.format((String)"\u6307\u5b9a\u8fd0\u884c\u6570\u636e\u5e93[%1$s]\u4e0e\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72\u6570\u636e\u5e93\u7c7b\u578b[%2$s]\u4e0d\u4e00\u81f4\uff0c\u4f7f\u7528\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72\u6570\u636e\u5e93", (Object)this.iPSSystemDBConfig.getName(), (Object)this.iPSDevSlnMSDepAPI.getPSDBDevInst().getDBType()));
                }
                this.iPSSystemDBConfig = iPSSystem.getPSSystemDBConfig(this.iPSDevSlnMSDepFunc.getPSDBDevInst().getDBType(), true);
                if (this.iPSSystemDBConfig == null) {
                    throw new Exception(StringHelper.format((String)"\u7cfb\u7edf\u4e0d\u652f\u6301\u6570\u636e\u5e93\u7c7b\u578b[%1$s]", (Object)this.iPSDevSlnMSDepFunc.getPSDBDevInst().getDBType()));
                }
            }
        }
        if (StringHelper.compare((String)this.psSysRunSession.getRUNMODE(), (String)"DEPLOYPKG", (boolean)true) == 0 && this.iPSSystemDBConfig == null) {
            this.iPSSystemDBConfig = iPSSystem.getDefaultPSSystemDBConfig();
        }
        if (!StringHelper.isNullOrEmpty((String)psSysRunSession.getPSSYSSFPUBID())) {
            this.iPSSysSFPub = this.iPSSystem.getPSSysSFPub(psSysRunSession.getPSSYSSFPUBID());
        } else if (StringHelper.compare((String)this.psSysRunSession.getRUNMODE(), (String)"PUBMODEL", (boolean)true) == 0) {
            this.iPSSysSFPub = this.iPSSystem.getDefaultPSSysSFPub();
        }
        this.strLogBrokerUri = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "SYSRUNLOGMQ", "");
        if (!StringHelper.isNullOrEmpty((String)this.strLogBrokerUri)) {
            this.strLogQueueName = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "SYSRUNLOGMQNAME", "");
        } else {
            this.strLogBrokerUri = null;
        }
        if (!this.psSysRunSession.isREBUILDMODENull() && ((nRebuildMode = this.psSysRunSession.GetParamIntValue("REBUILDMODE", 0)) & 4) == 0) {
            this.bRebuildMode = nRebuildMode > 0;
            this.nRebuildModeEx = nRebuildMode;
        }
        if (this.bRebuildMode) {
            this.bEnableVC = true;
        } else if (!this.psSysRunSession.isENABLEVCNull()) {
            this.bEnableVC = this.psSysRunSession.getENABLEVC();
        }
        if (iPSSystem.getPSSVNInstRepo() == null && this.bEnableVC) {
            this.bEnableVC = false;
        }
        if (StringHelper.compare((String)this.psSysRunSession.getRUNMODE(), (String)"PUBCODE", (boolean)true) == 0) {
            this.bPubCodeOnly = true;
        }
        if (!StringHelper.isNullOrEmpty((String)psSysRunSession.getRUNPSSYSDYNAMODELID())) {
            this.runPSSysDynaModel = this.getPSSystem().getPSSysDynaModel(psSysRunSession.getRUNPSSYSDYNAMODELID());
        }
        if (!this.psSysRunSession.isSTOPWHENTEMPLERRORNull()) {
            this.bStopWhenTemplError = this.psSysRunSession.getSTOPWHENTEMPLERROR();
        }
        if (!this.psSysRunSession.isDEBUGMODENull()) {
            this.bDebugMode = this.psSysRunSession.getDEBUGMODE();
        }
        if (!this.psSysRunSession.isQUICKMODENull()) {
            this.nQuickModeEx = this.psSysRunSession.getQUICKMODE();
        } else if (this.getPSModelStorage().isCloudMode()) {
            this.nQuickModeEx = 1;
        }
        this.bQuickMode = this.nQuickModeEx > 0;
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        CallResult callResult;
        this.preparePubFolders();
        PSDevCenterDBInst psDevCenterDBInst = null;
        if (this.iPSSystemAS != null && !StringHelper.isNullOrEmpty((String)this.iPSSystemAS.getPSDCAppServerId())) {
            PSDevCenterAS psDevCenterAS = new PSDevCenterAS();
            callResult = this.getPSModelHelper(null).getPSDevCenterAS(this.iPSSystemAS.getPSDCAppServerId(), psDevCenterAS);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u5e94\u7528\u5bb9\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            PSDCAppServerImpl psDCAppServerImpl = new PSDCAppServerImpl();
            psDCAppServerImpl.init(this.getDAGlobalHelper(), psDevCenterAS);
            this.iPSAppServer = psDCAppServerImpl;
            if (this.iPSSystemDBConfig != null) {
                String strDBType = this.iPSSystemDBConfig.getDBType();
                psDevCenterDBInst = new PSDevCenterDBInst();
                callResult = this.getPSModelHelper(null).getPSDCDBInst(psDCAppServerImpl.getId(), strDBType, psDevCenterDBInst);
                if (!callResult.isOk()) {
                    psDevCenterDBInst = null;
                }
            }
        }
        String strPSDevCenterDBInstId = null;
        if (this.iPSSystemDBConfig != null) {
            if (psDevCenterDBInst != null) {
                if (!StringHelper.isNullOrEmpty((String)this.iPSSystemDBConfig.getPSDCDBDevInstId()) && StringHelper.compare((String)psDevCenterDBInst.getPSDEVCENTERDBINSTID(), (String)this.iPSSystemDBConfig.getPSDCDBDevInstId(), (boolean)false) != 0) {
                    this.getPSSystemUtil().getPSSysConsole().warn(LOGNAME_PSSYSRUNSESSION, StringHelper.format((String)"\u7cfb\u7edf[%1$s]\u8fd0\u884c\u4f18\u5148\u4f7f\u7528\u5e94\u7528\u5bb9\u5668[%2$s]\u6570\u636e\u5e93\u5b9e\u4f8b[%3$s]", (Object)this.getPSSystem().getName(), (Object)this.iPSAppServer.getName(), (Object)psDevCenterDBInst.getPSDEVCENTERDBINSTNAME()));
                }
            } else if (psDevCenterDBInst == null && !StringHelper.isNullOrEmpty((String)this.iPSSystemDBConfig.getPSDCDBDevInstId())) {
                strPSDevCenterDBInstId = this.iPSSystemDBConfig.getPSDCDBDevInstId();
            }
        }
        if (this.getPSDevSlnMSDepAPI() != null && !StringHelper.isNullOrEmpty((String)this.getPSDevSlnMSDepAPI().getPSDevCenterDBInstId())) {
            psDevCenterDBInst = null;
            strPSDevCenterDBInstId = this.getPSDevSlnMSDepAPI().getPSDevCenterDBInstId();
        }
        if (this.getPSDevSlnMSDepApp() != null && !StringHelper.isNullOrEmpty((String)this.getPSDevSlnMSDepApp().getPSDevCenterDBInstId())) {
            psDevCenterDBInst = null;
            strPSDevCenterDBInstId = this.getPSDevSlnMSDepApp().getPSDevCenterDBInstId();
        }
        if (psDevCenterDBInst == null && !StringHelper.isNullOrEmpty(strPSDevCenterDBInstId)) {
            psDevCenterDBInst = new PSDevCenterDBInst();
            callResult = this.getPSModelHelper(null).getPSDCDBInst(strPSDevCenterDBInstId, psDevCenterDBInst);
            if (callResult.isError()) {
                throw new Exception(StringHelper.format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
        }
        if (psDevCenterDBInst != null) {
            PSDCDBDevInstImpl iPSDCDBDevInst = new PSDCDBDevInstImpl();
            if (StringHelper.isNullOrEmpty((String)psDevCenterDBInst.getPSDEVCENTERASID())) {
                iPSDCDBDevInst.init(this.getDAGlobalHelper(), psDevCenterDBInst);
            } else if (this.iPSAppServer == null) {
                if (StringHelper.compare((String)this.psSysRunSession.getRUNMODE(), (String)"STARTX", (boolean)true) == 0) {
                    throw new Exception(StringHelper.format((String)StringHelper.format((String)"\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u5fc5\u987b\u5728\u5e94\u7528\u5bb9\u5668[%2$s]\u4e0b\u8fd0\u884c", (Object)psDevCenterDBInst.getPSDEVCENTERDBINSTNAME(), (Object)psDevCenterDBInst.getPSDEVCENTERASNAME())));
                }
                iPSDCDBDevInst.init(this.getDAGlobalHelper(), psDevCenterDBInst);
            } else if (StringHelper.compare((String)psDevCenterDBInst.getPSDEVCENTERASID(), (String)this.iPSAppServer.getId(), (boolean)false) != 0) {
                if (StringHelper.compare((String)this.psSysRunSession.getRUNMODE(), (String)"STARTX", (boolean)true) == 0) {
                    throw new Exception(StringHelper.format((String)StringHelper.format((String)"\u6570\u636e\u5e93\u5b9e\u4f8b[%1$s]\u5fc5\u987b\u5728\u5e94\u7528\u5bb9\u5668[%2$s]\u4e0b\u8fd0\u884c\uff0c\u5f53\u524d\u4e3a[%3$s]", (Object)psDevCenterDBInst.getPSDEVCENTERDBINSTNAME(), (Object)psDevCenterDBInst.getPSDEVCENTERASNAME(), (Object)this.iPSAppServer.getName())));
                }
                iPSDCDBDevInst.init(this.getDAGlobalHelper(), psDevCenterDBInst);
            } else {
                iPSDCDBDevInst.init(this.getDAGlobalHelper(), (IPSDCAppServer)this.iPSAppServer, psDevCenterDBInst);
            }
            this.iPSDBDevInst = iPSDCDBDevInst;
        }
        if (StringHelper.compare((String)this.psSysRunSession.getRUNMODE(), (String)"STARTX", (boolean)true) == 0 && this.iPSDBDevInst == null) {
            throw new Exception(StringHelper.format((String)StringHelper.format((String)"\u542f\u52a8\u7cfb\u7edf\u5fc5\u987b\u6307\u5b9a\u8fd0\u884c\u6570\u636e\u5e93\u5b9e\u4f8b")));
        }
        if (StringHelper.compare((String)this.psSysRunSession.getRUNMODE(), (String)"DEPLOYPKG", (boolean)true) == 0) {
            if ((StringHelper.isNullOrEmpty((String)this.getRunParam()) || StringHelper.compare((String)this.getRunParam(), (String)"SLN", (boolean)true) == 0) && ((IPSSystemRuntime)((Object)this.iPSSystem)).getDeployPSMavenRepo() == null) {
                throw new Exception(StringHelper.format((String)StringHelper.format((String)"\u90e8\u7f72\u7ec4\u4ef6\u5305\u5fc5\u987b\u6307\u5b9a\u5f00\u53d1\u65b9\u6848\u90e8\u7f72\u4ed3\u5e93\u5730\u5740")));
            }
            if (StringHelper.compare((String)this.getRunParam(), (String)"DC", (boolean)true) == 0 && ((IPSSystemRuntime)((Object)this.iPSSystem)).getDCDeployPSMavenRepo() == null) {
                throw new Exception(StringHelper.format((String)StringHelper.format((String)"\u90e8\u7f72\u7ec4\u4ef6\u5305\u5fc5\u987b\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3\u90e8\u7f72\u4ed3\u5e93\u5730\u5740")));
            }
        }
        super.onInit();
    }

    protected void preparePubFolders() throws Exception {
        String strFolder = this.getPSDevCenterRuntime().getRootFolder();
        strFolder = String.valueOf(strFolder) + File.separator + this.getPSSystem().getPubSystemId();
        File folder = new File(strFolder);
        folder.mkdirs();
        this.strSysRootFolder = strFolder;
        this.strPubRootFolder = strFolder;
        this.strPubRootFolder = String.valueOf(this.strPubRootFolder) + File.separator + this.getPSSystem().getVCName();
        folder = new File(this.strPubRootFolder);
        folder.mkdirs();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u6570\u636e\u5e93", debugmode=true, hideempty=true)
    public IPSSystemDBConfig getPSSystemDBConfig() {
        return this.iPSSystemDBConfig;
    }

    @Override
    @PSModelRTMeta(description="\u524d\u7aef\u5e94\u7528", debugmode=true, hideempty=true)
    public IPSApplication getPSApplication() {
        return this.iPSApplication;
    }

    @Override
    public IPSApplication getPSApplication2() {
        return this.iPSApplication2;
    }

    @Override
    @PSModelRTMeta(description="\u6570\u636e\u5e93\u5b9e\u4f8b", debugmode=true, hideempty=true)
    public IPSDBDevInst getPSDBDevInst() {
        return this.iPSDBDevInst;
    }

    @Override
    @PSModelRTMeta(description="\u5e94\u7528\u5bb9\u5668", debugmode=true, hideempty=true)
    public IPSAppServer getPSAppServer() {
        return this.iPSAppServer;
    }

    @Override
    public String getLogBrokerUri() {
        return this.strLogBrokerUri;
    }

    @Override
    public String getLogTopicName() {
        return this.strLogQueueName;
    }

    public String getPSSysRunSessionId() {
        return this.psSysRunSession.getPSSYSRUNSESSIONID();
    }

    @Override
    public boolean isRebuildMode() {
        return this.bRebuildMode;
    }

    @Override
    public boolean isEnableVC() {
        return this.bEnableVC;
    }

    @Override
    public boolean isPubCodeOnly() {
        return this.bPubCodeOnly;
    }

    @Override
    public String getRunParam() {
        return this.psSysRunSession.getRUNPARAM();
    }

    @Override
    public String getRunParam2() {
        return this.psSysRunSession.getRUNPARAM2();
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u6a21\u5f0f", debugmode=true, hideempty=true, codelist="SysRunModes")
    public String getRunMode() {
        return this.psSysRunSession.getRUNMODE();
    }

    @Override
    public String getModelType() {
        return "PSSYSRUNSESSION";
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u670d\u52a1\u53d1\u5e03", debugmode=true, hideempty=true)
    public IPSSysSFPub getPSSysSFPub() {
        return this.iPSSysSFPub;
    }

    @Override
    public int getRebuildModeEx() {
        return this.nRebuildModeEx;
    }

    @Override
    public String getRealRSId() {
        return this.strRealRSId;
    }

    @Override
    public String getRunParam3() {
        return this.psSysRunSession.getRUNPARAM3();
    }

    @Override
    public String getRunParam4() {
        return this.psSysRunSession.getRUNPARAM4();
    }

    @Override
    public int getRunParam5() {
        return this.psSysRunSession.getRUNPARAM5();
    }

    @Override
    public int getRunParam6() {
        return this.psSysRunSession.getRUNPARAM6();
    }

    protected IPSDevCenterRuntime getPSDevCenterRuntime() {
        return this.iPSDevCenter;
    }

    @Override
    public String getPFPubRootFolder(IPSApplication iPSApplication) throws Exception {
        return StringHelper.format((String)"%1$s%2$sapp_%3$s", (Object)this.getPubRootFolder(), (Object)File.separator, (Object)iPSApplication.getWorkshopName());
    }

    @Override
    public String getSFPubRootFolder(IPSSysSFPub iPSSysSFPub) throws Exception {
        return StringHelper.format((String)"%1$s%2$ssrv_%3$s", (Object)this.getPubRootFolder(), (Object)File.separator, (Object)iPSSysSFPub.getCodeName());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerPFPubCode(IPSApplication iPSApplication, String strCodeFolder, String strCodeFilePath, boolean bSame) throws Exception {
        if (this.bTemplEngineV2) {
            return;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psPFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psPFPubSessionMap.get(iPSApplication.getId());
            if (codePubSession == null) {
                codePubSession = new PSCodePubSession(this.getPFPubRootFolder(iPSApplication));
                this.psPFPubSessionMap.put(iPSApplication.getId(), codePubSession);
            }
        }
        codePubSession.registerPubCode(strCodeFolder, strCodeFilePath, bSame);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerSFPubCode(IPSSysSFPub iPSSysSFPub, String strCodeFolder, String strCodeFilePath, boolean bSame) throws Exception {
        if (this.bTemplEngineV2) {
            return;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psSFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psSFPubSessionMap.get(iPSSysSFPub.getId());
            if (codePubSession == null) {
                codePubSession = new PSCodePubSession(this.getSFPubRootFolder(iPSSysSFPub));
                this.psSFPubSessionMap.put(iPSSysSFPub.getId(), codePubSession);
            }
        }
        codePubSession.registerPubCode(strCodeFolder, strCodeFilePath, bSame);
    }

    @Override
    public String getPubRootFolder() {
        return this.strPubRootFolder;
    }

    @Override
    public String getSysRootFolder() {
        return this.strSysRootFolder;
    }

    @Override
    public String getWorkshopFolder() {
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int syncPFPubCode(String strPSSysAppId, String strCodeFolders, String strDestFilePath, int nSyncMode) throws Exception {
        if (this.bTemplEngineV2) {
            return 0;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psPFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psPFPubSessionMap.get(strPSSysAppId);
        }
        if (codePubSession == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5e94\u7528\u4ee3\u7801\u53d1\u5e03\u4f1a\u8bdd"));
        }
        return codePubSession.syncPubCode(strCodeFolders, strDestFilePath, nSyncMode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int syncSFPubCode(String strPSSysSFPubId, String strCodeFolders, String strDestFilePath, int nSyncMode) throws Exception {
        if (this.bTemplEngineV2) {
            return 0;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psSFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psSFPubSessionMap.get(strPSSysSFPubId);
        }
        if (codePubSession == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u670d\u52a1\u4ee3\u7801\u53d1\u5e03\u4f1a\u8bdd"));
        }
        return codePubSession.syncPubCode(strCodeFolders, strDestFilePath, nSyncMode);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void endPFPubCode(IPSApplication iPSApplication) throws Exception {
        if (this.bTemplEngineV2) {
            return;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psPFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psPFPubSessionMap.get(iPSApplication.getId());
        }
        if (codePubSession == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5e94\u7528\u4ee3\u7801\u53d1\u5e03\u4f1a\u8bdd"));
        }
        codePubSession.endPubCode();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void endSFPubCode(IPSSysSFPub iPSSysSFPub) throws Exception {
        if (this.bTemplEngineV2) {
            return;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psSFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psSFPubSessionMap.get(iPSSysSFPub.getId());
        }
        if (codePubSession == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u670d\u52a1\u4ee3\u7801\u53d1\u5e03\u4f1a\u8bdd"));
        }
        codePubSession.endPubCode();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetPFPubCode(IPSApplication iPSApplication) throws Exception {
        if (this.bTemplEngineV2) {
            return;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psPFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psPFPubSessionMap.get(iPSApplication.getId());
        }
        if (codePubSession == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u5e94\u7528\u4ee3\u7801\u53d1\u5e03\u4f1a\u8bdd"));
        }
        codePubSession.resetPubCode();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void resetSFPubCode(IPSSysSFPub iPSSysSFPub) throws Exception {
        if (this.bTemplEngineV2) {
            return;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psSFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psSFPubSessionMap.get(iPSSysSFPub.getId());
        }
        if (codePubSession == null) {
            throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u670d\u52a1\u4ee3\u7801\u53d1\u5e03\u4f1a\u8bdd"));
        }
        codePubSession.resetPubCode();
    }

    @Override
    public IPSDevCenterFile createPSDCFile() {
        return null;
    }

    @Override
    public boolean logPSDCFile(IPSDevCenterFile iPSDevCenterFile) {
        return false;
    }

    @Override
    public IPSDevCenterNetworkFlow createPSDCNetworkFlow() {
        return null;
    }

    @Override
    public boolean logPSDCNetworkFlow(IPSDevCenterNetworkFlow iPSDevCenterNetworkFlow) {
        return false;
    }

    @Override
    public String executePlugin(String strObject, String strAction, String strArg) throws Exception {
        IPSSysPubRuntimePlugin iPSSysPubRuntimePlugin = this.psSysPubRuntimePluginMap.get(strObject);
        if (iPSSysPubRuntimePlugin == null) {
            Object objPlugin = ObjectHelper.create((String)strObject);
            if (!(objPlugin instanceof IPSSysPubRuntimePlugin)) {
                throw new Exception(StringHelper.format((String)"\u63d2\u4ef6\u5bf9\u8c61[%1$s]\u7c7b\u578b\u4e0d\u6b63\u786e", (Object)strObject));
            }
            iPSSysPubRuntimePlugin = (IPSSysPubRuntimePlugin)objPlugin;
            iPSSysPubRuntimePlugin.init(this.getDAGlobalHelper(), this);
            this.psSysPubRuntimePluginMap.put(strObject, iPSSysPubRuntimePlugin);
        }
        return iPSSysPubRuntimePlugin.execute(strAction, strArg);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerPFPubFolder(IPSApplication iPSApplication, String strCodeFolder) throws Exception {
        if (this.bTemplEngineV2) {
            return;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psPFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psPFPubSessionMap.get(iPSApplication.getId());
            if (codePubSession == null) {
                codePubSession = new PSCodePubSession(this.getPFPubRootFolder(iPSApplication));
                this.psPFPubSessionMap.put(iPSApplication.getId(), codePubSession);
            }
        }
        codePubSession.registerPubFolder(strCodeFolder);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void registerSFPubFolder(IPSSysSFPub iPSSysSFPub, String strCodeFolder) throws Exception {
        if (this.bTemplEngineV2) {
            return;
        }
        PSCodePubSession codePubSession = null;
        HashMap<String, PSCodePubSession> hashMap = this.psSFPubSessionMap;
        synchronized (hashMap) {
            codePubSession = this.psSFPubSessionMap.get(iPSSysSFPub.getId());
            if (codePubSession == null) {
                codePubSession = new PSCodePubSession(this.getSFPubRootFolder(iPSSysSFPub));
                this.psSFPubSessionMap.put(iPSSysSFPub.getId(), codePubSession);
            }
        }
        codePubSession.registerPubFolder(strCodeFolder);
    }

    @Override
    @PSModelRTMeta(description="\u79fb\u52a8\u5e94\u7528\u6253\u5305", debugmode=true, hideempty=true)
    public IPSMobAppPack getPSMobAppPack() {
        return this.iPSMobAppPack;
    }

    @Override
    @PSModelRTMeta(description="\u7cfb\u7edf\u670d\u52a1\u63a5\u53e3", debugmode=true, hideempty=true)
    public IPSSysServiceAPI getPSSysServiceAPI() {
        return this.iPSSysServiceAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u670d\u52a1\u63a5\u53e3\u90e8\u7f72", debugmode=true, hideempty=true)
    public IPSDevSlnMSDepAPI getPSDevSlnMSDepAPI() {
        return this.iPSDevSlnMSDepAPI;
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72", debugmode=true, hideempty=true)
    public IPSDevSlnMSDepApp getPSDevSlnMSDepApp() {
        return this.iPSDevSlnMSDepApp;
    }

    @Override
    @PSModelRTMeta(description="\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72", debugmode=true, hideempty=true)
    public IPSDevSlnMSDepFunc getPSDevSlnMSDepFunc() {
        return this.iPSDevSlnMSDepFunc;
    }

    @Override
    @PSModelRTMeta(description="\u52a8\u6001\u8fd0\u884c\u6a21\u578b")
    public IPSSysDynaModel getRunPSDynaModel() {
        return this.runPSSysDynaModel;
    }

    @Override
    @PSModelRTMeta(description="\u8fd0\u884c\u540d\u79f0")
    public String getRunName() {
        return this.psSysRunSession.getPSSYSRUNSESSIONNAME();
    }

    @Override
    @PSModelRTMeta(description="\u6a21\u677f\u53d1\u5e03\u9519\u8bef\u65f6\u505c\u6b62\u4f5c\u4e1a")
    public boolean isStopWhenTemplError() {
        return this.bStopWhenTemplError;
    }

    @Override
    public boolean isDebugMode() {
        return this.bDebugMode;
    }

    @Override
    @PSModelRTMeta(description="\u5feb\u901f\u6a21\u5f0f")
    public boolean isQuickMode() {
        return this.bQuickMode;
    }

    @Override
    public String getPSDSConsoleId() {
        return this.psSysRunSession.getPSDSCONSOLEID();
    }

    @Override
    public String getPSDCRegistryItemId() {
        return this.getRunParam2();
    }

    @Override
    public int getQuickModeEx() {
        return this.nQuickModeEx;
    }

    @Override
    public String getRunParam7() {
        return this.psSysRunSession.getRUNPARAM7();
    }

    @Override
    public String getRunParam8() {
        return this.psSysRunSession.getRUNPARAM8();
    }

    @Override
    public String getRunParam9() {
        return this.psSysRunSession.getRUNPARAM9();
    }

    @Override
    public String getRunParam10() {
        return this.psSysRunSession.getRUNPARAM10();
    }

    @Override
    public String getRunParam11() {
        return this.psSysRunSession.getRUNPARAM11();
    }

    @Override
    public String getRunParam12() {
        return this.psSysRunSession.getRUNPARAM12();
    }
}

