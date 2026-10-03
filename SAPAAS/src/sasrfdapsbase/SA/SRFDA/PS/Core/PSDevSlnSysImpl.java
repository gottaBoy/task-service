/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.CommonEx.LogLevels
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.DevCenterFileTypeCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.SysConsoleFixStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer
 *  net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysWSGit
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysWSGitService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.Deploy.IPSDCDeployServer;
import SA.SRFDA.PS.Core.Deploy.IPSDeployCenter;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnSysWSGit;
import SA.SRFDA.PS.Core.Deploy.IPSMavenRepo;
import SA.SRFDA.PS.Core.Deploy.IPSSVNInstRepo;
import SA.SRFDA.PS.Core.Deploy.IPSWorkshopServer;
import SA.SRFDA.PS.Core.Deploy.PSDCDeployCenterImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCDeployServerImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCMavenRepoImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCSVNInstRepoImpl;
import SA.SRFDA.PS.Core.Deploy.PSDCWorkshopServerImpl;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepAPIImpl;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepAppImpl;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnMSDepFuncImpl;
import SA.SRFDA.PS.Core.Deploy.PSDevSlnSysWSGitImpl;
import SA.SRFDA.PS.Core.Deploy.PSMavenRepoImpl;
import SA.SRFDA.PS.Core.Deploy.PSSVNInstRepoImpl;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterRuntime;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysRuntime;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSModelObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemUtil;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.JIT.SysModel.IPSJITSystemModel;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Core.PF.IPSPFStyle;
import SA.SRFDA.PS.Core.PF.PSPFStyle2Impl;
import SA.SRFDA.PS.Core.PSModelHelperImpl;
import SA.SRFDA.PS.Core.PSModelHelperImpl3;
import SA.SRFDA.PS.Core.PSModelLimitException;
import SA.SRFDA.PS.Core.PSModels;
import SA.SRFDA.PS.Core.PSObjectFactory;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.PSSystemImpl;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSGenerateCodeResult;
import SA.SRFDA.PS.Core.Pub.IPSSysPubRuntime;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Pub.Util.PSTemplHelper;
import SA.SRFDA.PS.Core.SF.IPSSF;
import SA.SRFDA.PS.Core.SF.IPSSFStyle;
import SA.SRFDA.PS.Core.SF.PSSFStyle2Impl;
import SA.SRFDA.PS.Core.Util.FileWriterHelper;
import SA.SRFDA.PS.Core.Util.FileWriterHelper2;
import SA.SRFDA.PS.Core.Workspace.IPSDCWorkspace;
import SA.SRFDA.PS.Core.Workspace.IPSWorkspace;
import SA.SRFDA.PS.Data.PSAppViewCode;
import SA.SRFDA.PS.Data.PSDCDeployCenter;
import SA.SRFDA.PS.Data.PSDCDeployServer;
import SA.SRFDA.PS.Data.PSDCMavenRepo;
import SA.SRFDA.PS.Data.PSDCWorkshopServer;
import SA.SRFDA.PS.Data.PSDevCenter;
import SA.SRFDA.PS.Data.PSDevCenterSVN;
import SA.SRFDA.PS.Data.PSDevSln;
import SA.SRFDA.PS.Data.PSDevSlnMSDepAPI;
import SA.SRFDA.PS.Data.PSDevSlnMSDepApp;
import SA.SRFDA.PS.Data.PSDevSlnMSDepFunc;
import SA.SRFDA.PS.Data.PSDevSlnSysDepInst;
import SA.SRFDA.PS.Data.PSDevSlnSysDynaInst;
import SA.SRFDA.PS.Data.PSDevSlnSysRes;
import SA.SRFDA.PS.Data.PSDevSlnTempl;
import SA.SRFDA.PS.Data.PSMavenRepo;
import SA.SRFDA.PS.Data.PSPFStyle;
import SA.SRFDA.PS.Data.PSSFStyle;
import SA.SRFDA.PS.Data.PSSVNInstRepo;
import SA.SRFDA.PS.Data.PSSysIssue;
import SA.SRFDA.PS.Data.PSSysSFCode;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.CommonEx.LogLevels;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.DevCenterFileTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.SysConsoleFixStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSSVNServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysWSGit;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysConsole;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysWSGitService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysConsoleService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysImpl
extends PSObjectImpl
implements IPSDevSlnSys,
IPSSystemUtil,
IPSDevSlnSysRuntime {
    private static final Log log = LogFactory.getLog(PSDevSlnSysImpl.class);
    protected SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys = null;
    protected IPSSystem iPSSystem = null;
    protected IPSSVNInstRepo iPSSVNInstRepo = null;
    protected IPSSVNInstRepo readOnlyPSSVNInstRepo = null;
    protected IPSSVNInstRepo docPSSVNInstRepo = null;
    protected IPSSVNInstRepo rtPSSVNInstRepo = null;
    protected String strVCType = "";
    protected String strSysVersion = "";
    protected String strMainPSDevSlnSysName = "";
    protected String strPSDevSlnCodeName = "";
    private long nLastActiveTime = 0L;
    private long nLastDBActiveTime = 0L;
    private String strCodeName = "";
    private String strPSDevSlnId = "";
    private String strPSDevSlnName = "";
    private String strJITPSDBDevInstId = "";
    private String strTemplEngineVer = "";
    private int nModelInstVer = PSModelHelperImpl.MAXMODELINSTVER;
    private String strSystemLogFilePath = "";
    private File sysLogFile = null;
    private FileWriterHelper2 fileWriterHelper2 = new FileWriterHelper2();
    private boolean bUseFileWriterHelper2 = true;
    private String strRootFolder = null;
    private String strSystemTemplFolder = null;
    private IPSDevCenterRuntime iPSDevCenter = null;
    private String strPSDevCenterId = null;
    private String strLogicName = null;
    private String strPSSysModelInstId = null;
    private Object objPSSystemLock = new Object();
    private IPSDCDeployServer iPSDCDeployServer = null;
    private IPSDeployCenter iPSDeployCenter = null;
    private IPSWorkshopServer iPSWorkshopServer = null;
    private IPSDevSlnSysWSGit iPSDevSlnSysWSGit = null;
    private String strMainPSDevSlnSysId = null;
    private String strSourcePSDevSlnSysId = null;
    private IPSMavenRepo slnDeployPSMavenRepo = null;
    private IPSMavenRepo dcDeployPSMavenRepo = null;
    private ArrayList<IPSDevSlnMSDepAPI> psDevSlnMSDepAPIList = null;
    private ArrayList<IPSDevSlnMSDepApp> psDevSlnMSDepAppList = null;
    private ArrayList<IPSDevSlnMSDepFunc> psDevSlnMSDepFuncList = null;
    private ArrayList<PSDevSlnTempl> psDevSlnTemplList = new ArrayList();
    private ArrayList<PSDevSlnSysDynaInst> psDevSlnSysDynaInstList = new ArrayList();
    private PSDevSln psDevSln = new PSDevSln();
    private boolean bShareInstMode = false;
    private boolean bDebugMode = false;
    private String strSysType = null;
    private String strDeploySysId = null;
    private String strDeploySysTag = null;
    private String strDeploySysTag2 = null;
    private String strDeploySysType = null;
    private String strDeploySysOrgId = null;
    private String strDeploySysOrgSectorId = null;
    private String strSysTag = null;
    private String strSysTag2 = null;
    private String strSysTag3 = null;
    private String strSysTag4 = null;
    private int nDynaInstMode = 0;
    private IPSDCWorkspace iPSDCWorkspace = null;
    private IPSSystemUtil.IPSSysConsole iPSSysConsole = new IPSSystemUtil.IPSSysConsole(){

        @Override
        public void log(String strName, String strLogInfo) {
            PSDevSlnSysImpl.this.logSysConsole("INFO", strName, strLogInfo);
        }

        @Override
        public void warn(String strName, String strLogInfo) {
            PSDevSlnSysImpl.this.logSysConsole("WARN", strName, strLogInfo);
        }

        @Override
        public void error(String strName, String strLogInfo) {
            PSDevSlnSysImpl.this.logSysConsole("ERROR", strName, strLogInfo);
        }

        @Override
        public void warn(String strName, String strLogInfo, String strFixDEName, String strFixDEAction, String strFixDataKey) {
            PSDevSlnSysImpl.this.logSysConsole("WARN", strName, strLogInfo, strFixDEName, strFixDEAction, strFixDataKey);
        }

        @Override
        public void error(String strName, String strLogInfo, String strFixDEName, String strFixDEAction, String strFixDataKey) {
            PSDevSlnSysImpl.this.logSysConsole("ERROR", strName, strLogInfo, strFixDEName, strFixDEAction, strFixDataKey);
        }
    };
    private PSDevSlnSysDynaInst psDevSlnSysDynaInst = null;
    private PSDevSlnSysDepInst psDevSlnSysDepInst = null;
    private String strPSDynaInstId = null;
    private String strPSDynaInstName = null;
    private String strPSDynaInstLogicName = null;
    private boolean bDynaInstMode = false;
    private String strRuntimePSSysModelInstId = null;
    private String strPPSDynaInstId = null;
    private Map<String, IPSSFStyle> psSFStyleMap = new HashMap<String, IPSSFStyle>();
    private Map<String, IPSPFStyle> psPFStyleMap = new HashMap<String, IPSPFStyle>();

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys, PSDevSlnSysDynaInst psDevSlnSysDynaInst, PSDevSlnSysDepInst psDevSlnSysDepInst) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDevSlnSysDepInst = psDevSlnSysDepInst;
        this.psDevSlnSysDynaInst = psDevSlnSysDynaInst;
        this.bDynaInstMode = true;
        this.strPSDynaInstId = this.psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTID();
        this.strPSDynaInstName = this.psDevSlnSysDynaInst.getPSDEVSLNSYSDYNAINSTNAME();
        this.strPSDynaInstLogicName = this.psDevSlnSysDynaInst.getLOGICNAME();
        this.strPPSDynaInstId = this.psDevSlnSysDynaInst.getPPSDEVSLNSYSDYNAINSTID();
        this.nDynaInstMode = SA.SRFramework.Utility.StringHelper.Compare((String)psDevSlnSysDynaInst.getINSTTYPE(), (String)"MODULE", (boolean)false) == 0 ? 2 : 1;
        this.strRuntimePSSysModelInstId = psDevSlnSysDepInst.getPSSYSMODELINSTID();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strRuntimePSSysModelInstId)) {
            this.strRuntimePSSysModelInstId = psDevSlnSys.getPSSYSMODELINSTID();
        }
        this.init(iDAGlobalHelper, psDevSlnSys);
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys) throws Exception {
        this.psDevSlnSys = psDevSlnSys;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psDevSlnSys.getPSDEVSLNSYSID());
        this.setName(psDevSlnSys.getPSDEVSLNSYSNAME());
        this.setPSObjectData(this.psDevSlnSys);
        this.strCodeName = this.psDevSlnSys.getCODENAME();
        this.strPSDevSlnId = this.psDevSlnSys.getPSDEVSLNID();
        this.strPSDevSlnName = this.psDevSlnSys.getPSDEVSLNNAME();
        this.strLogicName = this.psDevSlnSys.getLOGICNAME();
        if (this.isDynaInstMode()) {
            this.strPSSysModelInstId = "PSDYNAINST:" + this.getPSDynaInstId();
            this.strPSDevCenterId = this.psDevSlnSysDynaInst.getPSDEVCENTERID();
        } else {
            this.strPSSysModelInstId = psDevSlnSys.getPSSYSMODELINSTID();
            this.strMainPSDevSlnSysId = this.psDevSlnSys.getMAINPSDEVSLNSYSID();
            this.strSourcePSDevSlnSysId = this.psDevSlnSys.getPPSDEVSLNSYSID();
            this.strPSDevCenterId = this.psDevSlnSys.getPSDEVCENTERID();
        }
        this.iPSDevCenter = (IPSDevCenterRuntime)this.getPSModelStorage().getPSDevCenter(this.getPSDevCenterId());
        this.strRootFolder = this.isDynaInstMode() ? SA.SRFramework.Utility.StringHelper.Format((String)"%1$s%2$s%3$s", (Object)this.iPSDevCenter.getRootFolder(), (Object)File.separator, (Object)this.getPSDynaInstId()) : SA.SRFramework.Utility.StringHelper.Format((String)"%1$s%2$s%3$s", (Object)this.iPSDevCenter.getRootFolder(), (Object)File.separator, (Object)this.getId());
        File footFolder = new File(this.strRootFolder);
        footFolder.mkdirs();
        this.preparePSDevSlnSysFiles();
        this.reloadPSDevSlnSys(this.psDevSlnSys);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getCodeName() {
        return this.strCodeName;
    }

    protected void preparePSDevSlnSysFiles() throws Exception {
        if (this.isDynaInstMode()) {
            return;
        }
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSDevSlnSysImpl.this.onPreparePSDevSlnSysFiles();
            }
        });
    }

    protected void onPreparePSDevSlnSysFiles() throws Exception {
        IPSTaskServerEnv iPSTaskServerEnv = this.getPSModelStorage().getPSTaskServerEnv();
        PSDevCenterFileService psDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class);
        PSDevCenterFile psDevCenterFile = new PSDevCenterFile();
        psDevCenterFile.setFileType(DevCenterFileTypeCodeListModel.FOLDER);
        psDevCenterFile.setFilePath(this.getRootFolder());
        psDevCenterFile.setPSDevCenterId(this.iPSDevCenter.getId());
        psDevCenterFile.setPSDevCenterName(this.iPSDevCenter.getName());
        psDevCenterFile.setPSTaskServerId(iPSTaskServerEnv.getId());
        psDevCenterFile.setPSTaskServerName(iPSTaskServerEnv.getName());
        psDevCenterFile.setPSDevCenterFileName(SA.SRFramework.Utility.StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s\\%2$s][%3$s]\u6587\u4ef6\u76ee\u5f55", (Object)this.getPSDevSlnName(), (Object)this.getName(), (Object)this.getLogicName()));
        psDevCenterFile.setBizTag("DEVSLNSYS_ROOT");
        psDevCenterFile.setOwnerId(this.getId());
        psDevCenterFile.setOwnerName(this.getName());
        psDevCenterFile.setOwnerType("PSDEVSLNSYS");
        psDevCenterFile.setOwnerTypeName("\u5f00\u53d1\u7cfb\u7edf");
        String strKey = KeyValueHelper.genUniqueId((String)psDevCenterFile.getPSDevCenterId(), (String)"PSDEVSLNSYS", (String)this.getId(), (String)"DEVSLNSYS_ROOT");
        psDevCenterFile.setPSDevCenterFileId(strKey);
        psDevCenterFile.setMemo(SA.SRFramework.Utility.StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s\\%2$s][%3$s]\u6587\u4ef6\u76ee\u5f55", (Object)this.getPSDevSlnName(), (Object)this.getName(), (Object)this.getLogicName()));
        psDevCenterFileService.save(psDevCenterFile, false);
    }

    protected void reloadPSDevSlnSys(SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys) throws Exception {
        IPSModelHelper iPSModelHelper;
        this.setId(psDevSlnSys.getPSDEVSLNSYSID());
        this.setName(psDevSlnSys.getPSDEVSLNSYSNAME());
        this.strVCType = psDevSlnSys.getVCTYPE();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strVCType)) {
            this.strVCType = "TRUNK";
        }
        this.strSysVersion = psDevSlnSys.getSYSVER();
        if (!this.isDynaInstMode()) {
            this.strMainPSDevSlnSysName = this.psDevSlnSys.getMAINPSDEVSLNSYSNAME();
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strMainPSDevSlnSysName)) {
            this.strMainPSDevSlnSysName = psDevSlnSys.getPSDEVSLNSYSNAME();
        }
        if (!this.psDevSlnSys.isMODELINSTVERNull()) {
            this.nModelInstVer = this.psDevSlnSys.getMODELINSTVER();
            PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), this.getPSSysModelInstId()).setModelInstVer(this.nModelInstVer);
        }
        if (this.isDynaInstMode() && (iPSModelHelper = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), this.getPSSysModelInstId())) instanceof PSModelHelperImpl3) {
            PSModelHelperImpl3 psModelHelperImpl3 = (PSModelHelperImpl3)iPSModelHelper;
            psModelHelperImpl3.setPSModelFolderPath(this.psDevSlnSysDynaInst.getSYSMODELPATH());
            psModelHelperImpl3.setConfPSModelFolderPath(this.psDevSlnSysDynaInst.getROOTINSTMODELPATH());
            psModelHelperImpl3.setPSDynaInstId(this.getPSDynaInstId());
            psModelHelperImpl3.setPSDynaInstFolderPath(this.psDevSlnSysDynaInst.getINSTMODELPATH());
            psModelHelperImpl3.setPSDevSlnSysDynaInstRefList(this.psDevSlnSysDynaInst.getPSDevSlnSysDynaInstRefList(false));
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSysDynaInst.getPPSDEVSLNSYSDYNAINSTID())) {
                psModelHelperImpl3.setPPSDynaInstId(this.psDevSlnSysDynaInst.getPPSDEVSLNSYSDYNAINSTID());
                psModelHelperImpl3.setPPSDynaInstFolderPath(this.psDevSlnSysDynaInst.getPINSTMODELPATH());
                psModelHelperImpl3.setPPSDevSlnSysDynaInstRefList(this.psDevSlnSysDynaInst.getPPSDevSlnSysDynaInstRefList(false));
            }
            psModelHelperImpl3.resetPSDynaInstModelFolders();
            log.info((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u521d\u59cb\u5316\u52a8\u6001\u5b9e\u4f8b[%1$s]\u6a21\u578b\u8f85\u52a9\u5bf9\u8c61\uff0c\u6807\u51c6\u6a21\u578b[%2$s],\u5b9e\u4f8b\u6a21\u578b[%3$s]", (Object)this.getPSDynaInstId(), (Object)this.psDevSlnSysDynaInst.getSYSMODELPATH(), (Object)this.psDevSlnSysDynaInst.getINSTMODELPATH()));
        }
        this.bShareInstMode = !this.psDevSlnSys.isSHAREFLAGNull() ? this.psDevSlnSys.getSHAREFLAG() : false;
        this.strSystemTemplFolder = null;
        this.strTemplEngineVer = this.psDevSlnSys.getTEMPLENGINE();
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.strTemplEngineVer, (String)"V2", (boolean)true) == 0) {
            this.bUseFileWriterHelper2 = false;
            if (PSTaskServerEnvImpl.getCurrent().isEnableSystemTempl()) {
                this.strSystemTemplFolder = String.format("%1$s%2$s%3$s%2$s%4$s%2$stemplate", this.getRootFolder(), File.separator, this.getVCType().toLowerCase(), this.getCodeName());
            }
        }
        if (this.isDynaInstMode()) {
            this.strPSSysModelInstId = "PSDYNAINST:" + this.getPSDynaInstId();
        } else {
            this.strJITPSDBDevInstId = psDevSlnSys.getJITPSDBDEVINSTID();
            this.strPSSysModelInstId = psDevSlnSys.getPSSYSMODELINSTID();
        }
        this.strSysType = psDevSlnSys.getSYSTYPE();
        this.strDeploySysId = psDevSlnSys.getDEPLOYSYSID();
        this.strDeploySysTag = psDevSlnSys.getDEPLOYSYSTAG();
        this.strDeploySysTag2 = psDevSlnSys.getDEPLOYSYSTAG2();
        this.strDeploySysType = psDevSlnSys.getDEPLOYSYSTYPE();
        this.strDeploySysOrgId = psDevSlnSys.getDEPLOYSYSORGID();
        this.strDeploySysOrgSectorId = psDevSlnSys.getDEPLOYSYSORGSECTORID();
        this.strSysTag = psDevSlnSys.getSYSTAG();
        this.strSysTag2 = psDevSlnSys.getSYSTAG2();
        this.strSysTag3 = psDevSlnSys.getSYSTAG3();
        this.strSysTag4 = psDevSlnSys.getSYSTAG4();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strDeploySysId)) {
            this.strDeploySysId = this.getId();
            if (PSCoreSysServiceBase.isCloudMode()) {
                this.strDeploySysId = this.getName().toLowerCase();
            }
        }
        this.strPSDevSlnCodeName = "";
        this.active();
    }

    @Override
    public String getPSSystemId() {
        return this.psDevSlnSys.getPSSYSTEMID();
    }

    @Override
    public String getPSSystemName() {
        return this.psDevSlnSys.getPSDEVSLNSYSNAME();
    }

    @Override
    public synchronized IPSSystem getPSSystem() throws Exception {
        return this.getPSSystem(true);
    }

    @Override
    public synchronized IPSSystem getPSSystem(boolean bCache) throws Exception {
        if (!this.checkDevSysState()) {
            this.iPSSystem = null;
            CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnSys(this.getId(), this.psDevSlnSys);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            this.reloadPSDevSlnSys(this.psDevSlnSys);
        }
        if (this.isExpired()) {
            throw new Exception("\u5f00\u53d1\u7cfb\u7edf\u6216\u751f\u4ea7\u7ebf\u5df2\u8fc7\u671f");
        }
        this.active();
        if (bCache && this.iPSSystem != null) {
            return this.iPSSystem;
        }
        PSSystem psSystem = new PSSystem();
        CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), this.getPSSysModelInstId()).getPSSystem(this.psDevSlnSys.getPSSYSTEMID(), psSystem);
        if (callResult.isError()) {
            String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
            this.log(1, this, strInfo);
            throw new Exception(strInfo);
        }
        if (this.iPSSystem != null && this.iPSSystem.getVersion() == psSystem.getMODELVER()) {
            return this.iPSSystem;
        }
        if (this.iPSSystem != null) {
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnSys(this.getId(), this.psDevSlnSys);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            this.reloadPSDevSlnSys(this.psDevSlnSys);
        }
        this.psDevSln.Reset();
        callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSln(this.psDevSlnSys.getPSDEVSLNID(), this.psDevSln);
        if (callResult.isError()) {
            String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
            this.log(1, this, strInfo);
            throw new Exception(strInfo);
        }
        this.strPSDevSlnCodeName = this.psDevSln.getCODENAME();
        this.preparePSWorkspace();
        if (this.isDynaInstMode()) {
            this.preparePSDevSlnSysDynaInsts();
            this.iPSSVNInstRepo = null;
            this.readOnlyPSSVNInstRepo = null;
            this.rtPSSVNInstRepo = null;
            this.docPSSVNInstRepo = null;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSysDynaInst.getCFGPSDEVCENTERSVNID())) {
                PSDevCenterSVN psSVNInstRepo = new PSDevCenterSVN();
                callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSysDynaInst.getCFGPSDEVCENTERSVNID(), psSVNInstRepo);
                if (callResult.isError()) {
                    String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                    this.log(1, this, strInfo);
                    throw new Exception(strInfo);
                }
                PSDCSVNInstRepoImpl psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                psSVNInstRepoImpl.init(this.getDAGlobalHelper(), psSVNInstRepo);
                this.iPSSVNInstRepo = psSVNInstRepoImpl;
            }
        } else {
            PSDevCenter psDevCenter = new PSDevCenter();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenter(this.psDevSln.getPSDEVCENTERID(), psDevCenter);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u65b9\u6848\u5e94\u7528\u4e2d\u5fc3\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            if (!this.psDevSlnSys.isENABLEWSSERVERNull()) {
                if (this.psDevSlnSys.getENABLEWSSERVER()) {
                    this.preparePSWorkshopServer();
                }
            } else if (psDevCenter.isENABLEWSSERVERNull() || psDevCenter.getENABLEWSSERVER()) {
                this.preparePSWorkshopServer();
            }
            if (!this.psDevSlnSys.isENABLEWSSERVERNull()) {
                if (this.psDevSlnSys.getENABLEWSSERVER()) {
                    if (this.getPSWorkshopServer() == null) {
                        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u7cfb\u7edf\u6307\u5b9a\u5de5\u7a0b\u670d\u52a1\u5668"));
                    }
                } else {
                    this.iPSWorkshopServer = null;
                }
            }
            if (!this.psDevSlnSys.isENABLEDEPLOYCENTERNull()) {
                if (this.psDevSlnSys.getENABLEDEPLOYCENTER()) {
                    this.preparePSDeployCenter();
                }
            } else if (psDevCenter.isENABLEDEPLOYCENTERNull() || psDevCenter.getENABLEDEPLOYCENTER()) {
                this.preparePSDeployCenter();
            }
            if (!this.psDevSlnSys.isENABLEDEPLOYCENTERNull()) {
                if (this.psDevSlnSys.getENABLEDEPLOYCENTER()) {
                    if (this.getPSDeployCenter() == null) {
                        throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u7cfb\u7edf\u6307\u5b9a\u90e8\u7f72\u4e2d\u5fc3"));
                    }
                } else {
                    this.iPSDeployCenter = null;
                }
            }
            this.prepareDeployPSMavenRepo();
            this.preparePSDevSlnSysMSDeploy();
            this.preparePSDevSlnSysWSGit();
            this.preparePSDevSlnTempls();
            this.iPSSVNInstRepo = null;
            this.readOnlyPSSVNInstRepo = null;
            this.rtPSSVNInstRepo = null;
            this.docPSSVNInstRepo = null;
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getPSDEVCENTERSVNID())) {
                String strInfo;
                PSDevCenterSVN psSVNInstRepo = new PSDevCenterSVN();
                callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getPSDEVCENTERSVNID(), psSVNInstRepo);
                if (callResult.isError()) {
                    String strInfo2 = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                    this.log(1, this, strInfo2);
                    throw new Exception(strInfo2);
                }
                psSVNInstRepo.set("VCUSER", this.psDevSln.getVCUSER());
                psSVNInstRepo.set("VCPASSWORD", this.psDevSln.getVCPASSWORD());
                PSDCSVNInstRepoImpl psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                psSVNInstRepoImpl.init(this.getDAGlobalHelper(), psSVNInstRepo);
                this.iPSSVNInstRepo = psSVNInstRepoImpl;
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getROPSDEVCENTERSVNID())) {
                    psSVNInstRepo = new PSDevCenterSVN();
                    callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getROPSDEVCENTERSVNID(), psSVNInstRepo);
                    if (callResult.isError()) {
                        strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u53ea\u8bfb\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        this.log(1, this, strInfo);
                        throw new Exception(strInfo);
                    }
                    psSVNInstRepo.set("VCUSER", this.psDevSln.getVCUSER());
                    psSVNInstRepo.set("VCPASSWORD", this.psDevSln.getVCPASSWORD());
                    psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                    psSVNInstRepoImpl.init(this.getDAGlobalHelper(), psSVNInstRepo);
                    this.readOnlyPSSVNInstRepo = psSVNInstRepoImpl;
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getRTMODELPSDEVCENTERSVNID())) {
                    psSVNInstRepo = new PSDevCenterSVN();
                    callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getRTMODELPSDEVCENTERSVNID(), psSVNInstRepo);
                    if (callResult.isError()) {
                        strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u8fd0\u884c\u65f6\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        this.log(1, this, strInfo);
                        throw new Exception(strInfo);
                    }
                    psSVNInstRepo.set("VCUSER", this.psDevSln.getVCUSER());
                    psSVNInstRepo.set("VCPASSWORD", this.psDevSln.getVCPASSWORD());
                    psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                    psSVNInstRepoImpl.init(this.getDAGlobalHelper(), psSVNInstRepo);
                    this.rtPSSVNInstRepo = psSVNInstRepoImpl;
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getDOCPSDEVCENTERSVNID())) {
                    psSVNInstRepo = new PSDevCenterSVN();
                    callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getDOCPSDEVCENTERSVNID(), psSVNInstRepo);
                    if (callResult.isError()) {
                        strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u6587\u6863\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        this.log(1, this, strInfo);
                        throw new Exception(strInfo);
                    }
                    psSVNInstRepo.set("VCUSER", this.psDevSln.getVCUSER());
                    psSVNInstRepo.set("VCPASSWORD", this.psDevSln.getVCPASSWORD());
                    psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                    psSVNInstRepoImpl.init(this.getDAGlobalHelper(), psSVNInstRepo);
                    this.docPSSVNInstRepo = psSVNInstRepoImpl;
                }
            } else {
                String strInfo;
                PSSVNInstRepoImpl psSVNInstRepoImpl;
                BaseDataEntity psSVNInstRepo;
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDevCenter.getPSSVNINSTREPOID())) {
                    psSVNInstRepo = new PSSVNInstRepo();
                    callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSSVNInstRepo(psDevCenter.getPSSVNINSTREPOID(), (PSSVNInstRepo)psSVNInstRepo);
                    if (callResult.isError()) {
                        String strInfo3 = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        this.log(1, this, strInfo3);
                        throw new Exception(strInfo3);
                    }
                    psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                    psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                    psSVNInstRepoImpl = new PSSVNInstRepoImpl();
                    psSVNInstRepoImpl.init(this.getDAGlobalHelper(), (PSSVNInstRepo)psSVNInstRepo);
                    this.iPSSVNInstRepo = psSVNInstRepoImpl;
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDevCenter.getROPSSVNINSTREPOID())) {
                    psSVNInstRepo = new PSSVNInstRepo();
                    callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSSVNInstRepo(psDevCenter.getROPSSVNINSTREPOID(), (PSSVNInstRepo)psSVNInstRepo);
                    if (callResult.isError()) {
                        strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u53ea\u8bfb\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        this.log(1, this, strInfo);
                        throw new Exception(strInfo);
                    }
                    psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                    psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                    psSVNInstRepoImpl = new PSSVNInstRepoImpl();
                    psSVNInstRepoImpl.init(this.getDAGlobalHelper(), (PSSVNInstRepo)psSVNInstRepo);
                    this.readOnlyPSSVNInstRepo = psSVNInstRepoImpl;
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getRTMODELPSDEVCENTERSVNID())) {
                    psSVNInstRepo = new PSDevCenterSVN();
                    callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getRTMODELPSDEVCENTERSVNID(), (PSDevCenterSVN)psSVNInstRepo);
                    if (callResult.isError()) {
                        strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u8fd0\u884c\u65f6\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        this.log(1, this, strInfo);
                        throw new Exception(strInfo);
                    }
                    psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                    psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                    psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                    ((PSDCSVNInstRepoImpl)psSVNInstRepoImpl).init(this.getDAGlobalHelper(), (PSDevCenterSVN)psSVNInstRepo);
                    this.rtPSSVNInstRepo = psSVNInstRepoImpl;
                }
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getDOCPSDEVCENTERSVNID())) {
                    psSVNInstRepo = new PSDevCenterSVN();
                    callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getDOCPSDEVCENTERSVNID(), (PSDevCenterSVN)psSVNInstRepo);
                    if (callResult.isError()) {
                        strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u6587\u6863\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        this.log(1, this, strInfo);
                        throw new Exception(strInfo);
                    }
                    psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                    psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                    psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                    ((PSDCSVNInstRepoImpl)psSVNInstRepoImpl).init(this.getDAGlobalHelper(), (PSDevCenterSVN)psSVNInstRepo);
                    this.docPSSVNInstRepo = psSVNInstRepoImpl;
                }
            }
        }
        PSSystemImpl psSystemImpl = new PSSystemImpl();
        psSystemImpl.init(this.getDAGlobalHelper(), this, psSystem);
        this.iPSSystem = psSystemImpl;
        return this.iPSSystem;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.strPSSysModelInstId;
    }

    @Override
    public synchronized IPSSystem reloadPSSystem(int nLoadLevel) throws Exception {
        return this.reloadPSSystem(nLoadLevel, IPSSystem.LOADLEVEL_NONE);
    }

    @Override
    public synchronized IPSSystem reloadPSSystem(int nLoadLevel, int nAppLoadLevel) throws Exception {
        Iterator<IPSApplication> psSysApps;
        this.iPSSystem = null;
        this.checkDevSysState();
        this.active();
        if (nLoadLevel > IPSSystem.LOADLEVEL_NONE) {
            this.getPSModelHelper().startLoadPSSystem(this.getPSSystemId(), nLoadLevel);
        }
        try {
            CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnSys(this.getId(), this.psDevSlnSys);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            this.reloadPSDevSlnSys(this.psDevSlnSys);
            this.psDevSln.Reset();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSln(this.psDevSlnSys.getPSDEVSLNID(), this.psDevSln);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u65b9\u6848\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            this.strPSDevSlnCodeName = this.psDevSln.getCODENAME();
            this.preparePSWorkspace();
            if (this.isDynaInstMode()) {
                this.preparePSDevSlnSysDynaInsts();
                this.iPSSVNInstRepo = null;
                this.readOnlyPSSVNInstRepo = null;
                this.rtPSSVNInstRepo = null;
                this.docPSSVNInstRepo = null;
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSysDynaInst.getCFGPSDEVCENTERSVNID())) {
                    PSDevCenterSVN psSVNInstRepo = new PSDevCenterSVN();
                    callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSysDynaInst.getCFGPSDEVCENTERSVNID(), psSVNInstRepo);
                    if (callResult.isError()) {
                        String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        this.log(1, this, strInfo);
                        throw new Exception(strInfo);
                    }
                    PSDCSVNInstRepoImpl psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                    psSVNInstRepoImpl.init(this.getDAGlobalHelper(), psSVNInstRepo);
                    this.iPSSVNInstRepo = psSVNInstRepoImpl;
                }
            } else {
                String strInfo;
                PSSVNInstRepoImpl psSVNInstRepoImpl;
                BaseDataEntity psSVNInstRepo;
                PSDevCenter psDevCenter = new PSDevCenter();
                callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenter(this.psDevSln.getPSDEVCENTERID(), psDevCenter);
                if (callResult.isError()) {
                    String strInfo2 = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u65b9\u6848\u5e94\u7528\u4e2d\u5fc3\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                    this.log(1, this, strInfo2);
                    throw new Exception(strInfo2);
                }
                if (!this.psDevSlnSys.isENABLEWSSERVERNull()) {
                    if (this.psDevSlnSys.getENABLEWSSERVER()) {
                        this.preparePSWorkshopServer();
                    }
                } else if (psDevCenter.isENABLEWSSERVERNull() || psDevCenter.getENABLEWSSERVER()) {
                    this.preparePSWorkshopServer();
                }
                if (!this.psDevSlnSys.isENABLEWSSERVERNull()) {
                    if (this.psDevSlnSys.getENABLEWSSERVER()) {
                        if (this.getPSWorkshopServer() == null) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u7cfb\u7edf\u6307\u5b9a\u5de5\u7a0b\u670d\u52a1\u5668"));
                        }
                    } else {
                        this.iPSWorkshopServer = null;
                    }
                }
                if (!this.psDevSlnSys.isENABLEDEPLOYCENTERNull()) {
                    if (this.psDevSlnSys.getENABLEDEPLOYCENTER()) {
                        this.preparePSDeployCenter();
                    }
                } else if (psDevCenter.isENABLEDEPLOYCENTERNull() || psDevCenter.getENABLEDEPLOYCENTER()) {
                    this.preparePSDeployCenter();
                }
                if (!this.psDevSlnSys.isENABLEDEPLOYCENTERNull()) {
                    if (this.psDevSlnSys.getENABLEDEPLOYCENTER()) {
                        if (this.getPSDeployCenter() == null) {
                            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u6ca1\u6709\u4e3a\u7cfb\u7edf\u6307\u5b9a\u90e8\u7f72\u4e2d\u5fc3"));
                        }
                    } else {
                        this.iPSDeployCenter = null;
                    }
                }
                this.prepareDeployPSMavenRepo();
                this.preparePSDevSlnSysMSDeploy();
                this.preparePSDevSlnSysWSGit();
                this.preparePSDevSlnTempls();
                this.iPSSVNInstRepo = null;
                this.readOnlyPSSVNInstRepo = null;
                this.rtPSSVNInstRepo = null;
                this.docPSSVNInstRepo = null;
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getPSDEVCENTERSVNID())) {
                    psSVNInstRepo = new PSDevCenterSVN();
                    callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getPSDEVCENTERSVNID(), (PSDevCenterSVN)psSVNInstRepo);
                    if (callResult.isError()) {
                        String strInfo3 = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                        this.log(1, this, strInfo3);
                        throw new Exception(strInfo3);
                    }
                    psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                    psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                    psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                    ((PSDCSVNInstRepoImpl)psSVNInstRepoImpl).init(this.getDAGlobalHelper(), (PSDevCenterSVN)psSVNInstRepo);
                    this.iPSSVNInstRepo = psSVNInstRepoImpl;
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getROPSDEVCENTERSVNID())) {
                        psSVNInstRepo = new PSDevCenterSVN();
                        callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getROPSDEVCENTERSVNID(), (PSDevCenterSVN)psSVNInstRepo);
                        if (callResult.isError()) {
                            strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u53ea\u8bfb\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                            this.log(1, this, strInfo);
                            throw new Exception(strInfo);
                        }
                        psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                        psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                        psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                        ((PSDCSVNInstRepoImpl)psSVNInstRepoImpl).init(this.getDAGlobalHelper(), (PSDevCenterSVN)psSVNInstRepo);
                        this.readOnlyPSSVNInstRepo = psSVNInstRepoImpl;
                    }
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getRTMODELPSDEVCENTERSVNID())) {
                        psSVNInstRepo = new PSDevCenterSVN();
                        callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getRTMODELPSDEVCENTERSVNID(), (PSDevCenterSVN)psSVNInstRepo);
                        if (callResult.isError()) {
                            strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u8fd0\u884c\u65f6\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                            this.log(1, this, strInfo);
                            throw new Exception(strInfo);
                        }
                        psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                        psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                        psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                        ((PSDCSVNInstRepoImpl)psSVNInstRepoImpl).init(this.getDAGlobalHelper(), (PSDevCenterSVN)psSVNInstRepo);
                        this.rtPSSVNInstRepo = psSVNInstRepoImpl;
                    }
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getDOCPSDEVCENTERSVNID())) {
                        psSVNInstRepo = new PSDevCenterSVN();
                        callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevCenterSVN(this.psDevSlnSys.getDOCPSDEVCENTERSVNID(), (PSDevCenterSVN)psSVNInstRepo);
                        if (callResult.isError()) {
                            strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u6587\u6863\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                            this.log(1, this, strInfo);
                            throw new Exception(strInfo);
                        }
                        psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                        psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                        psSVNInstRepoImpl = new PSDCSVNInstRepoImpl();
                        ((PSDCSVNInstRepoImpl)psSVNInstRepoImpl).init(this.getDAGlobalHelper(), (PSDevCenterSVN)psSVNInstRepo);
                        this.docPSSVNInstRepo = psSVNInstRepoImpl;
                    }
                } else {
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDevCenter.getPSSVNINSTREPOID())) {
                        psSVNInstRepo = new PSSVNInstRepo();
                        callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSSVNInstRepo(psDevCenter.getPSSVNINSTREPOID(), (PSSVNInstRepo)psSVNInstRepo);
                        if (callResult.isError()) {
                            String strInfo4 = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                            this.log(1, this, strInfo4);
                            throw new Exception(strInfo4);
                        }
                        psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                        psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                        psSVNInstRepoImpl = new PSSVNInstRepoImpl();
                        psSVNInstRepoImpl.init(this.getDAGlobalHelper(), (PSSVNInstRepo)psSVNInstRepo);
                        this.iPSSVNInstRepo = psSVNInstRepoImpl;
                    }
                    if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDevCenter.getROPSSVNINSTREPOID())) {
                        psSVNInstRepo = new PSSVNInstRepo();
                        callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSSVNInstRepo(psDevCenter.getROPSSVNINSTREPOID(), (PSSVNInstRepo)psSVNInstRepo);
                        if (callResult.isError()) {
                            strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u7248\u672c\u5e93\uff08\u53ea\u8bfb\uff09\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                            this.log(1, this, strInfo);
                            throw new Exception(strInfo);
                        }
                        psSVNInstRepo.set("VCUSER", (Object)this.psDevSln.getVCUSER());
                        psSVNInstRepo.set("VCPASSWORD", (Object)this.psDevSln.getVCPASSWORD());
                        psSVNInstRepoImpl = new PSSVNInstRepoImpl();
                        psSVNInstRepoImpl.init(this.getDAGlobalHelper(), (PSSVNInstRepo)psSVNInstRepo);
                        this.readOnlyPSSVNInstRepo = psSVNInstRepoImpl;
                    }
                }
            }
            PSSystem psSystem = new PSSystem();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), this.getPSSysModelInstId()).getPSSystem(this.psDevSlnSys.getPSSYSTEMID(), psSystem);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            PSSystemImpl psSystemImpl = new PSSystemImpl();
            psSystemImpl.init(this.getDAGlobalHelper(), this, psSystem);
            if (nLoadLevel > IPSSystem.LOADLEVEL_NONE) {
                psSystemImpl.load(nLoadLevel);
                this.getPSModelHelper().stopLoadPSSystem();
            }
            this.iPSSystem = psSystemImpl;
        }
        catch (Exception ex) {
            this.log(1, this, SA.SRFramework.Utility.StringHelper.Format((String)"\u7cfb\u7edf\u52a0\u8f7d\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()));
            this.iPSSystem = null;
            if (nLoadLevel > IPSSystem.LOADLEVEL_NONE) {
                this.getPSModelHelper().stopLoadPSSystem();
            }
            throw ex;
        }
        if (nLoadLevel > IPSSystem.LOADLEVEL_NONE && nAppLoadLevel > IPSSystem.LOADLEVEL_NONE && (psSysApps = this.iPSSystem.getAllPSApps()) != null) {
            ArrayList<String> sysAppIdList = new ArrayList<String>();
            while (psSysApps.hasNext()) {
                IPSApplication iPSApplication = psSysApps.next();
                if (iPSApplication.getLoadedLevel() >= nAppLoadLevel) continue;
                sysAppIdList.add(iPSApplication.getId());
            }
            for (String strPSSysAppId : sysAppIdList) {
                PSSystemUtil.loadPSApplication(this.iPSSystem, strPSSysAppId, nAppLoadLevel);
            }
        }
        return this.iPSSystem;
    }

    @Override
    public IPSSVNInstRepo getPSSVNInstRepo() {
        return this.iPSSVNInstRepo;
    }

    @Override
    public IPSSVNInstRepo getReadOnlyPSSVNInstRepo() {
        if (PSCoreSysServiceBase.isCloudMode()) {
            return this.getPSSVNInstRepo();
        }
        if (this.readOnlyPSSVNInstRepo == null) {
            return this.getPSSVNInstRepo();
        }
        return this.readOnlyPSSVNInstRepo;
    }

    @Override
    public IPSSVNInstRepo getOpenPSSVNInstRepo() {
        return this.readOnlyPSSVNInstRepo;
    }

    @Override
    public IPSSVNInstRepo getDocPSSVNInstRepo() {
        return this.docPSSVNInstRepo;
    }

    @Override
    public IPSSVNInstRepo getRTPSSVNInstRepo() {
        return this.rtPSSVNInstRepo;
    }

    @Override
    public String getVCType() {
        return this.strVCType;
    }

    @Override
    public String getSysVersion() {
        return this.strSysVersion;
    }

    @Override
    public String getMainPSDevSlnSysName() {
        return this.strMainPSDevSlnSysName;
    }

    @Override
    public String getPSDevSlnCodeName() {
        return this.strPSDevSlnCodeName;
    }

    @Override
    public long getLastActiveTime() {
        return this.nLastActiveTime;
    }

    @Override
    public void uploadPSSystem() throws Exception {
    }

    @Override
    public void writeFile(String strFullPath, String strCode, Object strTag) throws Exception {
        if (this.bUseFileWriterHelper2) {
            this.fileWriterHelper2.write(strFullPath, strCode);
        } else {
            FileWriterHelper.write(strFullPath, strCode);
        }
    }

    @Override
    public boolean writeFile2(String strFullPath, String strCode, Object strTag) throws Exception {
        if (this.bUseFileWriterHelper2) {
            return this.fileWriterHelper2.write2(strFullPath, strCode);
        }
        return FileWriterHelper.write2(strFullPath, strCode);
    }

    @Override
    public void resetFileCache() {
        this.fileWriterHelper2.reset();
    }

    @Override
    public String getModelType() {
        return "PSDEVSLNSYS";
    }

    @Override
    public String getPSDevSlnId() {
        return this.strPSDevSlnId;
    }

    @Override
    public String getPSDevSlnName() {
        return this.strPSDevSlnName;
    }

    @Override
    public int getModelInstVer() {
        return this.nModelInstVer;
    }

    @Override
    public IPSJITSystemModel getPSJITSystemModel(boolean bPreviewMode) throws Exception {
        return ((IPSSystemUtil)((Object)this.getPSSystem())).getPSJITSystemModel(bPreviewMode);
    }

    @Override
    public boolean hasPSJITSystemModel() throws Exception {
        IPSSystem iPSSystem = this.iPSSystem;
        if (iPSSystem == null) {
            return false;
        }
        return ((IPSSystemUtil)((Object)iPSSystem)).hasPSJITSystemModel();
    }

    @Override
    public ArrayList<IPSObject> getPSModels(String strModelType, String strModelId) throws Exception {
        return ((IPSSystemUtil)((Object)this.getPSSystem())).getPSModels(strModelType, strModelId);
    }

    @Override
    public Iterator<PSSysSFCode> getPSModelSFCodes(String strModelType, String strModelId) throws Exception {
        return ((IPSSystemUtil)((Object)this.getPSSystem())).getPSModelSFCodes(strModelType, strModelId);
    }

    @Override
    public Iterator<PSAppViewCode> getPSModelPFCodes(String strModelType, String strModelId) throws Exception {
        return ((IPSSystemUtil)((Object)this.getPSSystem())).getPSModelPFCodes(strModelType, strModelId);
    }

    @Override
    public IPSGenerateCodeResult getPSModelCodeSnippet(String strModelType, String strModelId, String strPSDCCodeSnippetId) throws Exception {
        return ((IPSSystemUtil)((Object)this.getPSSystem())).getPSModelCodeSnippet(strModelType, strModelId, strPSDCCodeSnippetId);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData) {
        this.log(nLogLevel, iPSModelObject, strInfo, strUserData, null);
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo, String strUserData, String strUserData2) {
        if (this.sysLogFile != null) {
            String strFullInfo = SA.SRFramework.Utility.StringHelper.Format((String)"[%1$s][%2$s]%3$s", (Object)(iPSModelObject == this ? "PSSYSTEM" : iPSModelObject.getModelType()), (Object)iPSModelObject.getName(), (Object)strInfo);
            try {
                if (!this.sysLogFile.exists()) {
                    this.sysLogFile.createNewFile();
                }
                FileWriter fileWriter = new FileWriter(this.sysLogFile, true);
                BufferedWriter bufferWritter = new BufferedWriter(fileWriter);
                bufferWritter.write(SA.SRFramework.Utility.StringHelper.Format((String)"%1$tm-%1$td %1$tH:%1$tM:%1$tS [%2$s] %3$s\r\n", (Object)new Date(), (Object)LogLevels.ToString((int)nLogLevel), (Object)strFullInfo));
                bufferWritter.flush();
                bufferWritter.close();
            }
            catch (IOException e) {
                log.error((Object)e);
            }
        }
    }

    @Override
    public void log(int nLogLevel, IPSModelObject iPSModelObject, String strInfo) {
        this.log(nLogLevel, iPSModelObject, strInfo, null, null);
    }

    @Override
    public String getPSDevCenterId() {
        return this.strPSDevCenterId;
    }

    @Override
    public String getPSDevCenterDomain() {
        return this.iPSDevCenter.getDomainName();
    }

    @Override
    public String getPSDevCenterName() {
        return this.iPSDevCenter.getName();
    }

    @Override
    public String getJITPSDBDevInstId() {
        return this.strJITPSDBDevInstId;
    }

    @Override
    public String getRootFolder() {
        return this.strRootFolder;
    }

    public String getSystemTemplFolder() {
        return this.strSystemTemplFolder;
    }

    @Override
    public String getLogicName() {
        return this.strLogicName;
    }

    @Override
    public void pubPFCode(IPSSysPubRuntime iPSSysPubRuntime, IPSApplication ipsApplication, String strCodeType, String strFullPath, String strCode, Object strTag) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public void pubSFCode(IPSSysPubRuntime iPSSysPubRuntime, IPSSysSFPub iPSSysSFPub, String strCodeType, String strFullPath, String strCode, Object strTag) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public Timestamp getExpiredTime() {
        try {
            PSDCWorkspace psDCWorkspace;
            PSDevSlnSys psDevSlnSys = PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).getPSDevSlnSys(this.getId());
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDevSlnSys.getPSDCWorkspaceId()) && (psDCWorkspace = PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).getPSDCWorkspace(psDevSlnSys.getPSDCWorkspaceId())).getExpiredTime() != null) {
                if (psDevSlnSys.getExpriedTime() != null && psDevSlnSys.getExpriedTime().getTime() < psDCWorkspace.getExpiredTime().getTime()) {
                    return psDevSlnSys.getExpriedTime();
                }
                return psDCWorkspace.getExpiredTime();
            }
            if (psDevSlnSys.getOfflineTime() != null) {
                if (psDevSlnSys.getExpriedTime() != null && psDevSlnSys.getExpriedTime().getTime() < psDevSlnSys.getOfflineTime().getTime()) {
                    return psDevSlnSys.getExpriedTime();
                }
                return psDevSlnSys.getOfflineTime();
            }
            return psDevSlnSys.getExpriedTime();
        }
        catch (Exception ex) {
            log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"\u8ba1\u7b97\u5f00\u53d1\u7cfb\u7edf\u8fc7\u671f\u65f6\u95f4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return null;
        }
    }

    @Override
    public void active() {
        this.nLastActiveTime = System.currentTimeMillis();
        if (this.nLastDBActiveTime + 20000L < this.nLastActiveTime) {
            this.nLastDBActiveTime = this.nLastActiveTime;
            PSSysModelInstGlobal.active((String)this.getPSSysModelInstId());
            if (this.isDynaInstMode()) {
                PSSysModelInstGlobal.active((String)this.getRuntimePSSysModelInstId());
            }
            try {
                this.getPSModelHelper(this.getPSSysModelInstId());
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            IPSSystem iPSSystem = this.iPSSystem;
            if (iPSSystem != null) {
                iPSSystem.active(true);
            }
        }
    }

    @Override
    public int getCheckModelVer() {
        IPSSystem iPSSystem = this.iPSSystem;
        if (iPSSystem != null) {
            return ((IPSSystemUtil)((Object)iPSSystem)).getCheckModelVer();
        }
        return -1;
    }

    @Override
    public void logPSSysIssue(IPSModelObject iPSModelObject, PSSysIssue psSysIssue) throws Exception {
        IPSSystem iPSSystem = this.iPSSystem;
        if (iPSSystem != null) {
            ((IPSSystemUtil)((Object)iPSSystem)).logPSSysIssue(iPSModelObject, psSysIssue);
            return;
        }
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public boolean isExpired() {
        if (this.getExpiredTime() == null) {
            return false;
        }
        return this.getExpiredTime().getTime() < System.currentTimeMillis();
    }

    @Override
    @Deprecated
    public IPSDCDeployServer getPSDCDeployServer() {
        return this.iPSDCDeployServer;
    }

    @Override
    public IPSDevSlnSys getMainPSDevSlnSys() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strMainPSDevSlnSysId)) {
            return null;
        }
        return this.getPSModelStorage().getPSDevSlnSys(this.strMainPSDevSlnSysId);
    }

    @Override
    public IPSDevSlnSys getSourcePSDevSlnSys() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strSourcePSDevSlnSysId)) {
            return null;
        }
        return this.getPSModelStorage().getPSDevSlnSys(this.strSourcePSDevSlnSysId);
    }

    @Override
    public IPSDeployCenter getPSDeployCenter() {
        return this.iPSDeployCenter;
    }

    @Override
    public IPSWorkshopServer getPSWorkshopServer() {
        return this.iPSWorkshopServer;
    }

    @Override
    public IPSDevSlnSysWSGit getPSDevSlnSysWSGit() {
        return this.iPSDevSlnSysWSGit;
    }

    @Override
    public IPSMavenRepo getDeployPSMavenRepo() {
        return this.slnDeployPSMavenRepo;
    }

    @Override
    public boolean isUseWorkshopServer() {
        return this.getPSWorkshopServer() != null;
    }

    @Override
    public boolean isUseDeployCenter() {
        return this.getPSDeployCenter() != null;
    }

    @Override
    public Iterator<IPSDevSlnMSDepAPI> getPSDevSlnMSDepAPIs() throws Exception {
        if (this.isDynaInstMode()) {
            return null;
        }
        if (this.psDevSlnMSDepAPIList == null) {
            Vector<PSDevSlnMSDepAPI> psDevSlnMSDepAPIList = new Vector<PSDevSlnMSDepAPI>();
            CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnMSDepAPIs(this.getId(), psDevSlnMSDepAPIList);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u5fae\u670d\u52a1\u63a5\u53e3\u90e8\u7f72\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            ArrayList<IPSDevSlnMSDepAPI> psDevSlnMSDepAPIList2 = new ArrayList<IPSDevSlnMSDepAPI>();
            for (PSDevSlnMSDepAPI psDevSlnMSDepAPI : psDevSlnMSDepAPIList) {
                PSDevSlnMSDepAPIImpl iPSDevSlnMSDepAPI = new PSDevSlnMSDepAPIImpl();
                iPSDevSlnMSDepAPI.init(this.getDAGlobalHelper(), this, psDevSlnMSDepAPI);
                psDevSlnMSDepAPIList2.add(iPSDevSlnMSDepAPI);
            }
            this.psDevSlnMSDepAPIList = psDevSlnMSDepAPIList2;
        }
        if (this.psDevSlnMSDepAPIList.size() == 0) {
            return null;
        }
        return this.psDevSlnMSDepAPIList.iterator();
    }

    @Override
    public Iterator<IPSDevSlnMSDepApp> getPSDevSlnMSDepApps() throws Exception {
        if (this.isDynaInstMode()) {
            return null;
        }
        if (this.psDevSlnMSDepAppList == null) {
            Vector<PSDevSlnMSDepApp> psDevSlnMSDepAppList = new Vector<PSDevSlnMSDepApp>();
            CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnMSDepApps(this.getId(), psDevSlnMSDepAppList);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u5fae\u670d\u52a1\u5e94\u7528\u90e8\u7f72\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            ArrayList<IPSDevSlnMSDepApp> psDevSlnMSDepAppList2 = new ArrayList<IPSDevSlnMSDepApp>();
            for (PSDevSlnMSDepApp psDevSlnMSDepApp : psDevSlnMSDepAppList) {
                PSDevSlnMSDepAppImpl iPSDevSlnMSDepApp = new PSDevSlnMSDepAppImpl();
                iPSDevSlnMSDepApp.init(this.getDAGlobalHelper(), this, psDevSlnMSDepApp);
                psDevSlnMSDepAppList2.add(iPSDevSlnMSDepApp);
            }
            this.psDevSlnMSDepAppList = psDevSlnMSDepAppList2;
        }
        if (this.psDevSlnMSDepAppList.size() == 0) {
            return null;
        }
        return this.psDevSlnMSDepAppList.iterator();
    }

    @Override
    public Iterator<IPSDevSlnMSDepFunc> getPSDevSlnMSDepFuncs() throws Exception {
        if (this.isDynaInstMode()) {
            return null;
        }
        if (this.psDevSlnMSDepFuncList == null) {
            Vector<PSDevSlnMSDepFunc> psDevSlnMSDepFuncList = new Vector<PSDevSlnMSDepFunc>();
            CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnMSDepFuncs(this.getId(), psDevSlnMSDepFuncList);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u5fae\u670d\u52a1\u529f\u80fd\u90e8\u7f72\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            ArrayList<IPSDevSlnMSDepFunc> psDevSlnMSDepFuncList2 = new ArrayList<IPSDevSlnMSDepFunc>();
            for (PSDevSlnMSDepFunc psDevSlnMSDepFunc : psDevSlnMSDepFuncList) {
                PSDevSlnMSDepFuncImpl iPSDevSlnMSDepFunc = new PSDevSlnMSDepFuncImpl();
                iPSDevSlnMSDepFunc.init(this.getDAGlobalHelper(), this, psDevSlnMSDepFunc);
                psDevSlnMSDepFuncList2.add(iPSDevSlnMSDepFunc);
            }
            this.psDevSlnMSDepFuncList = psDevSlnMSDepFuncList2;
        }
        if (this.psDevSlnMSDepFuncList.size() == 0) {
            return null;
        }
        return this.psDevSlnMSDepFuncList.iterator();
    }

    protected void preparePSWorkshopServer() throws Exception {
        if (this.isDynaInstMode()) {
            return;
        }
        CallResult callResult = new CallResult();
        this.iPSWorkshopServer = null;
        PSDCWorkshopServer psDCWorkshopServer = null;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSln.getPSDCWORKSHOPSERVERID())) {
            psDCWorkshopServer = new PSDCWorkshopServer();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDCWorkshopServer(this.psDevSln.getPSDCWORKSHOPSERVERID(), psDCWorkshopServer);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u5de5\u7a0b\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
        }
        if (psDCWorkshopServer == null && (PSTaskServerEnvImpl.getCurrent().getDevSysDeployMode() & 2) > 0) {
            psDCWorkshopServer = new PSDCWorkshopServer();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getDefaultPSDCWorkshopServer(this.getPSDevCenterId(), psDCWorkshopServer);
            if (callResult.isError()) {
                psDCWorkshopServer = null;
            }
        }
        if (psDCWorkshopServer != null) {
            PSDCWorkshopServerImpl psDCWorkshopServerImpl = new PSDCWorkshopServerImpl();
            psDCWorkshopServerImpl.init(this.getDAGlobalHelper(), psDCWorkshopServer);
            this.iPSWorkshopServer = psDCWorkshopServerImpl;
        } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSTaskServerEnvImpl.getCurrent().getPSWorkshopServerId())) {
            this.iPSWorkshopServer = this.getPSModelStorage().getPSWorkshopServer(PSTaskServerEnvImpl.getCurrent().getPSWorkshopServerId());
        }
    }

    protected void preparePSDeployCenter() throws Exception {
        if (this.isDynaInstMode()) {
            return;
        }
        CallResult callResult = new CallResult();
        this.iPSDeployCenter = null;
        PSDCDeployCenter psDCDeployCenter = null;
        String strPSDCDeployCenterId = this.psDevSlnSys.getPSDCDEPLOYCENTERID();
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDCDeployCenterId)) {
            strPSDCDeployCenterId = this.psDevSln.getPSDCDEPLOYCENTERID();
        }
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strPSDCDeployCenterId)) {
            psDCDeployCenter = new PSDCDeployCenter();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDCDeployCenter(strPSDCDeployCenterId, psDCDeployCenter);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u90e8\u7f72\u4e2d\u5fc3\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
        }
        if (psDCDeployCenter == null && (PSTaskServerEnvImpl.getCurrent().getDevSysDeployMode() & 2) > 0) {
            psDCDeployCenter = new PSDCDeployCenter();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getDefaultPSDCDeployCenter(this.getPSDevCenterId(), psDCDeployCenter);
            if (callResult.isError()) {
                psDCDeployCenter = null;
            }
        }
        if (psDCDeployCenter != null) {
            PSDCDeployCenterImpl psDCDeployCenterImpl = new PSDCDeployCenterImpl();
            psDCDeployCenterImpl.init(this.getDAGlobalHelper(), psDCDeployCenter);
            this.iPSDeployCenter = psDCDeployCenterImpl;
        } else if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)PSTaskServerEnvImpl.getCurrent().getPSDeployCenterId())) {
            this.iPSDeployCenter = this.getPSModelStorage().getPSDeployCenter(PSTaskServerEnvImpl.getCurrent().getPSDeployCenterId());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void prepareDeployPSMavenRepo() throws Exception {
        PSDCMavenRepoImpl psDCMavenRepoImpl;
        PSDCMavenRepo psDCMavenRepo;
        if (this.isDynaInstMode()) {
            return;
        }
        CallResult callResult = new CallResult();
        this.slnDeployPSMavenRepo = null;
        this.dcDeployPSMavenRepo = null;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSln.getPSDCMAVENREPOID())) {
            psDCMavenRepo = new PSDCMavenRepo();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDCMavenRepo(this.psDevSln.getPSDCMAVENREPOID(), psDCMavenRepo);
            if (!callResult.isOk()) throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u5e94\u7528\u4e2d\u5fc3Maven\u4ed3\u5e93"));
            psDCMavenRepoImpl = new PSDCMavenRepoImpl();
            psDCMavenRepoImpl.init(this.getDAGlobalHelper(), psDCMavenRepo);
            this.slnDeployPSMavenRepo = psDCMavenRepoImpl;
        } else if (this.slnDeployPSMavenRepo == null) {
            PSMavenRepo psMavenRepo = new PSMavenRepo();
            String strPSMavenRepoId = KeyValueHelper.genUniqueId((String)"PSDEVSLN", (String)this.psDevSln.getPSDEVSLNID());
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSMavenRepo(strPSMavenRepoId, psMavenRepo);
            if (callResult.isOk()) {
                PSMavenRepoImpl psMavenRepoImpl = new PSMavenRepoImpl();
                psMavenRepoImpl.init(this.getDAGlobalHelper(), psMavenRepo);
                this.slnDeployPSMavenRepo = psMavenRepoImpl;
            }
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDevCenterId())) return;
        psDCMavenRepo = new PSDCMavenRepo();
        callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDCMavenRepo(this.getPSDevCenterId(), psDCMavenRepo);
        if (callResult.isOk()) {
            psDCMavenRepoImpl = new PSDCMavenRepoImpl();
            psDCMavenRepoImpl.init(this.getDAGlobalHelper(), psDCMavenRepo);
            this.dcDeployPSMavenRepo = psDCMavenRepoImpl;
        }
        if (this.dcDeployPSMavenRepo != null) return;
        PSMavenRepo psMavenRepo = new PSMavenRepo();
        String strPSMavenRepoId = KeyValueHelper.genUniqueId((String)"PSDEVCENTER", (String)this.getPSDevCenterId());
        callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSMavenRepo(strPSMavenRepoId, psMavenRepo);
        if (!callResult.isOk()) return;
        PSMavenRepoImpl psMavenRepoImpl = new PSMavenRepoImpl();
        psMavenRepoImpl.init(this.getDAGlobalHelper(), psMavenRepo);
        this.dcDeployPSMavenRepo = psMavenRepoImpl;
    }

    protected void preparePSDevSlnSysMSDeploy() throws Exception {
        this.psDevSlnMSDepAPIList = null;
        this.psDevSlnMSDepAppList = null;
        this.psDevSlnMSDepFuncList = null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void preparePSDevSlnTempls() throws Exception {
        if (this.isDynaInstMode()) {
            return;
        }
        Vector<PSDevSlnTempl> psDevSlnTemplList = new Vector<PSDevSlnTempl>();
        CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnTempls(this.getId(), psDevSlnTemplList);
        if (callResult.isError()) {
            String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u8c03\u8bd5\u6a21\u677f\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
            this.log(1, this, strInfo);
            throw new Exception(strInfo);
        }
        ArrayList<PSDevSlnTempl> arrayList = this.psDevSlnTemplList;
        synchronized (arrayList) {
            this.psDevSlnTemplList.clear();
            this.psDevSlnTemplList.addAll(psDevSlnTemplList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void preparePSDevSlnSysDynaInsts() throws Exception {
        if (!this.isDynaInstMode()) {
            return;
        }
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getPSDynaInstId())) {
            return;
        }
        Vector<PSDevSlnSysDynaInst> psDevSlnSysDynaInstList = new Vector<PSDevSlnSysDynaInst>();
        CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnSysDynaInsts(this.getPSDynaInstId(), psDevSlnSysDynaInstList);
        if (callResult.isError()) {
            String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u52a8\u6001\u5b9e\u4f8b\u5b50\u5b9e\u4f8b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
            this.log(1, this, strInfo);
            throw new Exception(strInfo);
        }
        ArrayList<PSDevSlnSysDynaInst> arrayList = this.psDevSlnSysDynaInstList;
        synchronized (arrayList) {
            this.psDevSlnSysDynaInstList.clear();
            this.psDevSlnSysDynaInstList.addAll(psDevSlnSysDynaInstList);
        }
    }

    protected void preparePSDevSlnSysWSGit() throws Exception {
        if (this.isDynaInstMode()) {
            return;
        }
        this.iPSDevSlnSysWSGit = null;
        if (this.getPSWorkshopServer() == null) {
            return;
        }
        PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

            @Override
            public void execute(Object obj) throws Exception {
                PSDevSlnSysImpl.this.onPreparePSDevSlnSysWSGit();
            }
        });
        String strPSDevSlnSysWSGitId = KeyValueHelper.genUniqueId((String)this.getId(), (String)this.getPSWorkshopServer().getId());
        CallResult callResult = new CallResult();
        SA.SRFDA.PS.Data.PSDevSlnSysWSGit psDevSlnSysWSGit = new SA.SRFDA.PS.Data.PSDevSlnSysWSGit();
        psDevSlnSysWSGit.setPSDEVSLNSYSWSGITID(strPSDevSlnSysWSGitId);
        callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnSysWSGit(strPSDevSlnSysWSGitId, psDevSlnSysWSGit);
        if (callResult.isError()) {
            String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u5de5\u4f5cGIT\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
            this.log(1, this, strInfo);
            throw new Exception(strInfo);
        }
        PSDevSlnSysWSGitImpl psDevSlnSysWSGitImpl = new PSDevSlnSysWSGitImpl();
        psDevSlnSysWSGitImpl.init(this.getDAGlobalHelper(), this, psDevSlnSysWSGit);
        this.iPSDevSlnSysWSGit = psDevSlnSysWSGitImpl;
    }

    protected void onPreparePSDevSlnSysWSGit() throws Exception {
        if (this.isDynaInstMode()) {
            return;
        }
        PSDevSlnSysWSGitService psDevSlnSysWSGitService = (PSDevSlnSysWSGitService)ServiceGlobal.getService(PSDevSlnSysWSGitService.class);
        String strPSDevSlnSysWSGitId = KeyValueHelper.genUniqueId((String)this.getId(), (String)this.getPSWorkshopServer().getId());
        PSDevSlnSysWSGit psDevSlnSysWSGit = new PSDevSlnSysWSGit();
        psDevSlnSysWSGit.setPSDevSlnSysWSGitId(strPSDevSlnSysWSGitId);
        String strGitServerId = this.getPSWorkshopServer().getGitServerId();
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strGitServerId)) {
            PSSVNServerService psSVNServerService = (PSSVNServerService)ServiceGlobal.getService(PSSVNServerService.class);
            PSSVNServer psSVNServer = new PSSVNServer();
            psSVNServer.setPSSVNServerId(strGitServerId);
            psSVNServerService.get(psSVNServer);
            psDevSlnSysWSGit.setGITUserName(psSVNServer.getGITUserName());
            psDevSlnSysWSGit.setGITPassword(psSVNServer.getGITPassword());
        }
        if (psDevSlnSysWSGitService.checkKey(psDevSlnSysWSGit) == 0) {
            psDevSlnSysWSGit.setPSDevSlnSysId(this.getId());
            psDevSlnSysWSGit.setPSDCWorkshopServerId(this.getPSWorkshopServer().getId());
            String strPSDevSlnSysWSGitName = "ws" + Helper.GenMD5Ex((String)Helper.GenGuid()).substring(0, 10);
            psDevSlnSysWSGit.setPSDevSlnSysWSGitName(strPSDevSlnSysWSGitName);
            psDevSlnSysWSGitService.create(psDevSlnSysWSGit);
        } else {
            psDevSlnSysWSGitService.update(psDevSlnSysWSGit);
        }
    }

    protected void preparePSWorkspace() throws Exception {
        this.iPSDCWorkspace = null;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getPSDCWORKSPACEID())) {
            IPSDCWorkspace iPSDCWorkspace;
            this.iPSDCWorkspace = iPSDCWorkspace = this.getPSModelStorage().getPSDCWorkspace(this.psDevSlnSys.getPSDCWORKSPACEID());
        }
    }

    @Override
    protected boolean hasPSSysDynaModel() {
        return false;
    }

    @Override
    public IPSSystemUtil.IPSSysConsole getPSSysConsole() {
        return this.iPSSysConsole;
    }

    protected final void logSysConsole(String strLogType, String strLogName, String strLogInfo) {
        this.logSysConsole(strLogType, strLogName, strLogInfo, null, null, null);
    }

    protected final void logSysConsole(String strLogType, String strLogName, String strLogInfo, String strFixDEName, String strFixDEAction, String strFixDataKey) {
        try {
            if (PSTemplHelper.isBusy()) {
                return;
            }
            final PSSysConsole psSysConsole = new PSSysConsole();
            if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strLogName)) {
                strLogName = this.getLogicName();
            }
            if (SA.SRFramework.Utility.StringHelper.Length((String)strLogInfo) > 4000) {
                strLogInfo = String.valueOf(strLogInfo.substring(0, 3920)) + "...";
            }
            if (SA.SRFramework.Utility.StringHelper.Compare((String)strLogType, (String)"INFO", (boolean)false) == 0) {
                log.info((Object)SA.SRFramework.Utility.StringHelper.Format((String)"[CONSOLE][%1$s]%2$s", (Object)strLogName, (Object)strLogInfo));
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strLogType, (String)"WARN", (boolean)false) == 0) {
                log.warn((Object)SA.SRFramework.Utility.StringHelper.Format((String)"[CONSOLE][%1$s]%2$s", (Object)strLogName, (Object)strLogInfo));
            } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strLogType, (String)"ERROR", (boolean)false) == 0) {
                log.error((Object)SA.SRFramework.Utility.StringHelper.Format((String)"[CONSOLE][%1$s]%2$s", (Object)strLogName, (Object)strLogInfo));
            }
            if (PSStudioConsoleHelper.getCurrent() != null) {
                String strContent;
                if (SA.SRFramework.Utility.StringHelper.Compare((String)strLogType, (String)"ERROR", (boolean)false) == 0) {
                    strContent = PSStudioConsoleHelper.getContent((String)SA.SRFramework.Utility.StringHelper.Format((String)"%1$s: %2$s", (Object)strLogName, (Object)strLogInfo), (int)31, (int)-1, (int)0);
                    PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), strContent, null);
                } else if (SA.SRFramework.Utility.StringHelper.Compare((String)strLogType, (String)"WARN", (boolean)false) == 0) {
                    strContent = PSStudioConsoleHelper.getContent((String)SA.SRFramework.Utility.StringHelper.Format((String)"%1$s: %2$s", (Object)strLogName, (Object)strLogInfo), (int)33, (int)-1, (int)0);
                    PSStudioConsoleHelper.getCurrent().sendConsole(this.getPSDSConsoleId(), strContent, null);
                }
            }
            if (!this.isDynaInstMode()) {
                psSysConsole.setLogTime(new Timestamp(System.currentTimeMillis()));
                psSysConsole.setPSSysConsoleName(strLogName);
                psSysConsole.setLogLevel(strLogType);
                psSysConsole.setLogInfo(strLogInfo);
                psSysConsole.setPSSystemId(this.getPSSystemId());
                psSysConsole.setPSSystemName(this.getName());
                if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strFixDEName) && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strFixDataKey)) {
                    psSysConsole.setFixState(SysConsoleFixStateCodeListModel.SUPPORT);
                    psSysConsole.setFixDEName(strFixDEName);
                    psSysConsole.setFixDEAction(strFixDEAction);
                    psSysConsole.setFixDataKey(strFixDataKey);
                }
                final PSSysConsoleService psSysConsoleService = (PSSysConsoleService)ServiceGlobal.getService(PSSysConsoleService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                    public void execute(ITransaction iTransaction) throws Exception {
                        psSysConsoleService.create(psSysConsole, false);
                    }
                });
            }
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Deprecated
    protected void preparePSDeployServer() throws Exception {
        if (this.isDynaInstMode()) {
            return;
        }
        this.iPSDCDeployServer = null;
        CallResult callResult = new CallResult();
        PSDCDeployServer psDCDeployServer = null;
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.psDevSlnSys.getPSDEVSLNSYSRESID())) {
            PSDevSlnSysRes psDevSlnSysRes = new PSDevSlnSysRes();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDevSlnSysRes(this.psDevSlnSys.getPSDEVSLNSYSRESID(), psDevSlnSysRes);
            if (callResult.isError()) {
                String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5f00\u53d1\u7cfb\u7edf\u8d44\u6e90\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                this.log(1, this, strInfo);
                throw new Exception(strInfo);
            }
            if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)psDevSlnSysRes.getPSDCDEPLOYSERVERID())) {
                psDCDeployServer = new PSDCDeployServer();
                callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getPSDCDeployServer(psDevSlnSysRes.getPSDCDEPLOYSERVERID(), psDCDeployServer);
                if (callResult.isError()) {
                    String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u5e94\u7528\u4e2d\u5fc3\u90e8\u7f72\u670d\u52a1\u5668\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
                    this.log(1, this, strInfo);
                    throw new Exception(strInfo);
                }
            }
        }
        if (psDCDeployServer == null && (PSTaskServerEnvImpl.getCurrent().getDevSysDeployMode() & 2) > 0) {
            psDCDeployServer = new PSDCDeployServer();
            callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), null).getDefaultPSDCDeployServer(this.getPSDevCenterId(), psDCDeployServer);
            if (callResult.isError()) {
                psDCDeployServer = null;
            }
        }
        if (psDCDeployServer != null) {
            PSDCDeployServerImpl psDCDeployServerImpl = new PSDCDeployServerImpl();
            psDCDeployServerImpl.init(this.getDAGlobalHelper(), psDCDeployServer);
            this.iPSDCDeployServer = psDCDeployServerImpl;
        }
    }

    @Override
    public IPSMavenRepo getDCDeployPSMavenRepo() {
        return this.dcDeployPSMavenRepo;
    }

    @Override
    public String getTemplEngineVer() {
        return this.strTemplEngineVer;
    }

    @Override
    public ArrayList<PSDevSlnTempl> getPSDevSlnTemplList() {
        return this.psDevSlnTemplList;
    }

    @Override
    public boolean isShareInstMode() {
        return this.bShareInstMode;
    }

    protected boolean checkDevSysState() throws Exception {
        if (this.isDynaInstMode()) {
            return true;
        }
        PSDevSlnSys psDevSlnSys = PSCoreEntityKeeperGlobal.getCurrent(null).getPSDevSlnSys(this.getId());
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            this.iPSSystem = null;
            throw new Exception(SA.SRFramework.Utility.StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u7ee7\u7eed\u4f5c\u4e1a", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (SA.SRFramework.Utility.StringHelper.Compare((String)this.getPSSysModelInstId(), (String)psDevSlnSys.getPSSysModelInstId(), (boolean)false) == 0) {
            return true;
        }
        this.iPSSystem = null;
        return false;
    }

    @Override
    public int getSampleDataId() {
        IPSSystem iPSSystem = this.iPSSystem;
        if (iPSSystem != null) {
            return ((IPSSystemUtil)((Object)iPSSystem)).getSampleDataId();
        }
        return 0;
    }

    @Override
    public boolean isDebugMode() {
        return this.bDebugMode;
    }

    @Override
    public void setDebugMode(boolean bDebugMode) {
        this.bDebugMode = bDebugMode;
    }

    @Override
    public String getDeploySysId() {
        return this.strDeploySysId;
    }

    @Override
    public String getDeploySysTag() {
        return this.strDeploySysTag;
    }

    @Override
    public String getDeploySysTag2() {
        return this.strDeploySysTag2;
    }

    @Override
    public String getDeploySysType() {
        return this.strDeploySysType;
    }

    @Override
    public String getDeploySysOrgId() {
        return this.strDeploySysOrgId;
    }

    @Override
    public String getDeploySysOrgSectorId() {
        return this.strDeploySysOrgSectorId;
    }

    @Override
    public String getSysTag() {
        return this.strSysTag;
    }

    @Override
    public String getSysTag2() {
        return this.strSysTag2;
    }

    @Override
    public String getSysTag3() {
        return this.strSysTag3;
    }

    @Override
    public String getSysTag4() {
        return this.strSysTag4;
    }

    @Override
    public IPSWorkspace getPSWorkspace() {
        return this.iPSDCWorkspace;
    }

    @Override
    public void testPSModelLimit(IPSModelObject ownerPSModelObject, String strPSModelType, int nCount) throws Exception {
        if (this.getPSWorkspace() == null) {
            return;
        }
        int nLimit = this.getPSWorkspace().getPSModelLimit(strPSModelType);
        if (nLimit >= 0 && nLimit < nCount) {
            String strOwnerName = "";
            strOwnerName = ownerPSModelObject instanceof IPSSystem ? "\u7cfb\u7edf(PSSYSTEM)" : StringHelper.format((String)"%1$s(%2$s)[%3$s]", (Object)PSModels.getModelName((String)ownerPSModelObject.getModelType()), (Object)ownerPSModelObject.getModelType(), (Object)ownerPSModelObject.getFullModelName());
            String strErrorInfo = SA.SRFramework.Utility.StringHelper.Format((String)"%5$s$%1$s(%2$s)\u6570\u91cf[%3$s]\u8d85\u51fa\u751f\u4ea7\u7ebf\u9650\u5236[%4$s]", (Object)PSModels.getModelName((String)strPSModelType), (Object)strPSModelType, (Object)nCount, (Object)nLimit, (Object)strOwnerName);
            if (PSStudioConsoleHelper.getCurrent() != null) {
                String strContent = PSStudioConsoleHelper.getContent((String)SA.SRFramework.Utility.StringHelper.Format((String)"%1$s: %2$s", (Object)"[\u751f\u4ea7\u7ebf\u68c0\u67e5]", (Object)strErrorInfo), (int)31, (int)-1, (int)0);
                PSStudioConsoleHelper.getCurrent().sendConsole(this.getId(), strContent, null);
            }
            throw new PSModelLimitException(strPSModelType, nLimit, strErrorInfo);
        }
    }

    @Override
    public boolean isDynaInstMode() {
        return this.bDynaInstMode;
    }

    @Override
    public String getPSDynaInstId() {
        return this.strPSDynaInstId;
    }

    @Override
    public String getPSDynaInstName() {
        return this.strPSDynaInstName;
    }

    @Override
    public String getPSDynaInstLogicName() {
        return this.strPSDynaInstLogicName;
    }

    @Override
    public String getPPSDynaInstId() {
        return this.strPPSDynaInstId;
    }

    protected String getPSDSConsoleId() {
        if (this.isDynaInstMode()) {
            return this.getPSDynaInstId();
        }
        return this.getId();
    }

    @Override
    public String getRuntimePSSysModelInstId() {
        if (!SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.strRuntimePSSysModelInstId)) {
            return this.strRuntimePSSysModelInstId;
        }
        return this.getPSSysModelInstId();
    }

    @Override
    public ArrayList<PSDevSlnSysDynaInst> getPSDevSlnSysDynaInstList() {
        return this.psDevSlnSysDynaInstList;
    }

    @Override
    public int getDynaInstMode() {
        return this.nDynaInstMode;
    }

    @Override
    public String getDynaInstTag() {
        if (this.psDevSlnSysDynaInst != null) {
            return this.psDevSlnSysDynaInst.getINSTTAG();
        }
        return super.getDynaInstTag();
    }

    @Override
    public String getDynaInstTag2() {
        if (this.psDevSlnSysDynaInst != null) {
            return this.psDevSlnSysDynaInst.getINSTTAG2();
        }
        return super.getDynaInstTag2();
    }

    @Override
    public IPSSFStyle getPSSFStyle(String strPSSFId, String strPSSFStyleId, String strTag) throws Exception {
        String strFolder;
        File templFolder;
        if (PSTaskServerEnvImpl.getCurrent().isEnableSystemTempl() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strTag) && (templFolder = new File(strFolder = String.format("%1$s%2$ssf%2$s%3$s", this.getSystemTemplFolder(), File.separator, strTag.toLowerCase()))).exists()) {
            String strFullTag = String.format("%1$s|%2$s|%3$s", strPSSFId, strPSSFStyleId, strTag).toLowerCase();
            IPSSFStyle iPSSFStyle = this.psSFStyleMap.get(strFullTag);
            if (iPSSFStyle == null) {
                IPSSF iPSSF = this.getPSModelStorage().getPSSF(strPSSFId);
                PSSFStyle psSFStyle = new PSSFStyle();
                psSFStyle.setPSSFSTYLEID(strPSSFStyleId);
                psSFStyle.setPSSFID(strPSSFId);
                psSFStyle.setV2FOLDER(strFolder);
                psSFStyle.setV2FOLDER2(strFolder);
                PSSFStyle2Impl psSFStyle2Impl = new PSSFStyle2Impl();
                psSFStyle2Impl.init(this.getDAGlobalHelper(), iPSSF, psSFStyle);
                iPSSFStyle = psSFStyle2Impl;
                this.psSFStyleMap.put(strFullTag, iPSSFStyle);
            }
            return iPSSFStyle;
        }
        return this.getPSModelStorage().getPSSF(strPSSFId).getPSSFStyle(strPSSFStyleId);
    }

    @Override
    public IPSPFStyle getPSPFStyle(String strPSPFId, String strPSPFStyleId, String strTag) throws Exception {
        String strFolder;
        File templFolder;
        if (PSTaskServerEnvImpl.getCurrent().isEnableSystemTempl() && !SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)strTag) && (templFolder = new File(strFolder = String.format("%1$s%2$spf%2$s%3$s", this.getSystemTemplFolder(), File.separator, strTag.toLowerCase()))).exists()) {
            String strFullTag = String.format("%1$s|%2$s|%3$s", strPSPFId, strPSPFStyleId, strTag).toLowerCase();
            IPSPFStyle iPSPFStyle = this.psPFStyleMap.get(strFullTag);
            if (iPSPFStyle == null) {
                IPSPF iPSPF = this.getPSModelStorage().getPSPF(strPSPFId);
                PSPFStyle psPFStyle = new PSPFStyle();
                psPFStyle.setPSPFSTYLEID(strPSPFStyleId);
                psPFStyle.setPSPFID(strPSPFId);
                psPFStyle.setV2FOLDER(strFolder);
                psPFStyle.setV2FOLDER2(strFolder);
                PSPFStyle2Impl psPFStyle2Impl = new PSPFStyle2Impl();
                psPFStyle2Impl.init(this.getDAGlobalHelper(), iPSPF, psPFStyle);
                iPSPFStyle = psPFStyle2Impl;
                this.psPFStyleMap.put(strFullTag, iPSPFStyle);
            }
            return iPSPFStyle;
        }
        return this.getPSModelStorage().getPSPF(strPSPFId).getPSPFStyle(strPSPFStyleId);
    }

    @Override
    public void reloadSystemTempls() throws Exception {
        if (SA.SRFramework.Utility.StringHelper.IsNullOrEmpty((String)this.getSystemTemplFolder())) {
            return;
        }
        File file = new File(this.getSystemTemplFolder());
        if (!file.exists()) {
            return;
        }
        this.psSFStyleMap.clear();
        this.psPFStyleMap.clear();
        PSSystem psSystem = new PSSystem();
        CallResult callResult = PSObjectFactory.getPSModelHelper(this.getDAGlobalHelper(), this.getPSSysModelInstId()).getPSSystem(this.psDevSlnSys.getPSSYSTEMID(), psSystem);
        if (callResult.isError()) {
            String strInfo = SA.SRFramework.Utility.StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo());
            this.log(1, this, strInfo);
            throw new Exception(strInfo);
        }
        PSSystemImpl psSystemImpl = new PSSystemImpl();
        psSystemImpl.init(this.getDAGlobalHelper(), this, psSystem);
        this.iPSSystem = psSystemImpl;
    }

    @Override
    public String getSysType() {
        return this.strSysType;
    }
}
