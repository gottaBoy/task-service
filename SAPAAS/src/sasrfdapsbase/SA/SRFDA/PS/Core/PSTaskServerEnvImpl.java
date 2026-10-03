/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.PropertiesHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.ibizsys.pscore.srv.util.PSStudioEnvHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Data.PSTaskServer;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.io.File;
import java.util.Date;
import java.util.Properties;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.PropertiesHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSStudioEnvHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSTaskServerEnvImpl
extends PSObjectImpl
implements IPSTaskServerEnv {
    private static final Log log = LogFactory.getLog(PSTaskServerEnvImpl.class);
    private static IPSTaskServerEnv iPSTaskServerEnv = null;
    private Properties properties = null;
    private PSTaskServer psTaskServer = null;
    private String strCodeFolder = null;
    private String strToolFolder = null;
    private String strBackupFolder = null;
    private String strPSSvrDomainId = null;
    private boolean bStartASBookingDisp = false;
    private boolean bStartDSBookingDisp = false;
    private boolean bStartWSBookingDisp = false;
    private int nDevSlnSysExpiredTime = 600000;
    private boolean bEnableThreadLockCheck = true;
    private String strRestartCmd = null;
    private int nThreadLockTime = 40000;
    private String strPSMobAppPackServerId = null;
    private String strFileFolder = null;
    private String strTempFolder = null;
    private int nMaxFileNameLength = 250;
    private boolean bThrowExceptionWhenFileNameTooLong = false;
    private String strJITCodeFolder = null;
    private int nPackAndDeployMode = 1;
    private String strOSType = "WIN";
    private String strCoreSysModelInstId = null;
    private String strPSDeployCenterId = null;
    private String strPSWorkshopServerId = null;
    private boolean bDebugMode = false;
    private String strRemoteAddr = null;
    private boolean bLinux = false;
    private boolean bWindows = true;
    private String strPreviewPCPFId = "";
    private String strPreviewPCPFStyleId = "";
    private String strPreviewMobPFId = "";
    private String strPreviewMobPFStyleId = "";
    private boolean bEnableModelInstProxyMode = false;
    private String strConsoleServerUrl = "";
    private boolean bEnableConsoleServer = false;
    private String strTempFileServerUrl = "http://183.235.240.88:58088/";
    private String strTempFileServerAddr = "183.235.240.88:22";
    private String strTempFileServerUserName = "";
    private String strTempFileServerPassword = "";
    private int nTempFileServerPort = 22;
    private String strNetDiskCacheFolder = "";
    private boolean bThrowExceptionWhenTemplError = false;
    private boolean bDebugConsoleInfo = false;
    private boolean bEnableOfflineDevSlnSys = true;
    private boolean bPFPreviewUseModel = false;
    private String strDynaInstFolder = null;
    private String strDepInstFolder = null;
    private boolean bTemplEngineV2Only = false;
    private boolean bBackupBeforeImportModel = false;
    private String strSysLogFolder = null;
    private boolean bAPIOnly = false;
    private boolean bEnableSystemTempl = false;
    private String strGitLabPlugin = null;
    private String strKafkaPlugin = null;
    private String strDevCallbackUrl = null;
    private boolean bEnableGitBranch = false;
    private String strModelFormat = null;
    private int nImportBatchSize = 2000;

    public static void setCurrent(IPSTaskServerEnv iPSTaskServerEnv) {
        PSTaskServerEnvImpl.iPSTaskServerEnv = iPSTaskServerEnv;
    }

    public static IPSTaskServerEnv getCurrent() {
        return iPSTaskServerEnv;
    }

    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSTaskServer psTaskServer) throws Exception {
        String[] items;
        String strPFPreviewUseModel;
        String strDebugMode;
        String strEnableOfflineDevSlnSys;
        String strWSBookingDisp;
        String strDSBookingDisp;
        this.psTaskServer = psTaskServer;
        this.setId(psTaskServer.getPSTASKSERVERID());
        this.setName(psTaskServer.getPSTASKSERVERNAME());
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.strPSSvrDomainId = this.psTaskServer.getPSSVRDOMAINID();
        this.strPSMobAppPackServerId = this.psTaskServer.getPSMOBAPPPACKSERVERID();
        if (StringHelper.compare((String)File.separator, (String)"/", (boolean)false) == 0) {
            this.strOSType = "LINUX";
            this.bLinux = true;
        }
        this.strFileFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFDA", "FILEFOLDER", "");
        this.strTempFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFEXWEB", "TEMPFOLDER", "");
        this.strCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CODEFOLDER", "");
        this.strJITCodeFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "JITCODEFOLDER", this.strCodeFolder);
        this.strToolFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TOOLFOLDER", "");
        this.strBackupFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "BACKUPFOLDER", "");
        this.strNetDiskCacheFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "NDCACHEFOLDER", "");
        String strASBookingDisp = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "ASBOOKINGDISP", "FALSE");
        if (StringHelper.compare((String)strASBookingDisp, (String)"true", (boolean)true) == 0) {
            this.bStartASBookingDisp = true;
        }
        if (StringHelper.compare((String)(strDSBookingDisp = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DSBOOKINGDISP", "FALSE")), (String)"true", (boolean)true) == 0) {
            this.bStartDSBookingDisp = true;
        }
        if (StringHelper.compare((String)(strWSBookingDisp = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "WSBOOKINGDISP", "FALSE")), (String)"true", (boolean)true) == 0) {
            this.bStartWSBookingDisp = true;
        }
        if (StringHelper.compare((String)(strEnableOfflineDevSlnSys = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "OFFLINEDEVSLNSYS", "TRUE")), (String)"true", (boolean)true) == 0) {
            this.bEnableOfflineDevSlnSys = true;
        }
        if (StringHelper.compare((String)(strDebugMode = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DEBUGMODE", "FALSE")), (String)"true", (boolean)true) == 0) {
            this.bDebugMode = true;
        }
        if (StringHelper.compare((String)(strPFPreviewUseModel = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "PFPREVIEWUSEMODEL", "FALSE")), (String)"true", (boolean)true) == 0) {
            this.bPFPreviewUseModel = true;
        }
        this.nDevSlnSysExpiredTime = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DEVSLNSYSEXPIREDTIME", this.nDevSlnSysExpiredTime);
        String strThreadLockCheck = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "THREADLOCKCHECK", "TRUE");
        if (StringHelper.compare((String)strThreadLockCheck, (String)"true", (boolean)true) == 0) {
            this.bEnableThreadLockCheck = true;
        }
        this.nThreadLockTime = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "THREADLOCKTIME", 40000);
        this.strRestartCmd = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "RESTARTCMD", "");
        if (this.bLinux) {
            this.nMaxFileNameLength = 1024;
        }
        this.nMaxFileNameLength = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "MAXFILENAMELENGTH", this.nMaxFileNameLength);
        this.bThrowExceptionWhenFileNameTooLong = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "EXCEPTIONFILENAMETOOLONG", this.bThrowExceptionWhenFileNameTooLong);
        this.strCoreSysModelInstId = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CORESYSMODELINSTID", "UID_2015821546416900314232818");
        this.bThrowExceptionWhenTemplError = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "EXCEPTIONTEMPLERROR", this.bThrowExceptionWhenTemplError);
        this.strPreviewPCPFId = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "PREVIEWPCPF", "PREVIEW_PC");
        this.strPreviewPCPFStyleId = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "PREVIEWPCPFSTYLE", "F226FC2C-4011-4747-B237-745BA046F7B0");
        this.strPreviewMobPFId = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "PREVIEWMOBPF", "PREVIEW_MOB");
        this.strPreviewMobPFStyleId = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "PREVIEWMOBPFSTYLE", "430FDC4E-0A69-425A-B403-2C00A059BB65");
        this.bEnableModelInstProxyMode = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "MODELINSTPROXYMODE", this.bEnableModelInstProxyMode);
        this.strConsoleServerUrl = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "CONSOLESERVERURL", this.strConsoleServerUrl);
        this.bEnableConsoleServer = !StringHelper.isNullOrEmpty((String)this.strConsoleServerUrl);
        this.bDebugConsoleInfo = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DEBUGCONSOLEINFO", this.bDebugConsoleInfo);
        this.bAPIOnly = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "APIONLY", this.bAPIOnly);
        this.bEnableSystemTempl = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "SYSTEMTEMPL", this.bEnableSystemTempl);
        this.strTempFileServerUrl = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TEMPFILESERVERURL", this.strTempFileServerUrl);
        this.strTempFileServerAddr = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TEMPFILESERVERHOST", this.strTempFileServerAddr);
        this.strTempFileServerUserName = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TEMPFILESERVERUSERNAME", this.strTempFileServerUserName);
        this.strTempFileServerPassword = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TEMPFILESERVERPASSWORD", this.strTempFileServerPassword);
        this.bTemplEngineV2Only = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TEMPLENGINEV2ONLY", this.bTemplEngineV2Only);
        this.bBackupBeforeImportModel = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "BACKUPBEFOREIMPORTMODEL", this.bBackupBeforeImportModel);
        this.strGitLabPlugin = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "GITLABPLUGIN", "FALSE");
        this.strKafkaPlugin = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "KAFKAPLUGIN", "FALSE");
        this.strDevCallbackUrl = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DEVCALLBACKURL", "");
        this.bEnableGitBranch = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "GITBRANCH", this.bEnableGitBranch);
        this.strModelFormat = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "MODELFORMAT", "");
        this.nImportBatchSize = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "IMPORTBATCHSIZE", 2000);
        if (!StringHelper.isNullOrEmpty((String)this.strTempFileServerAddr) && (items = this.strTempFileServerAddr.split("[:]")).length == 2) {
            this.strTempFileServerAddr = items[0];
            this.nTempFileServerPort = Integer.parseInt(items[1]);
        }
        if (StringHelper.isNullOrEmpty((String)this.strCodeFolder)) {
            log.warn((Object)StringHelper.format((String)"\u4efb\u52a1\u7cfb\u7edf\u6ca1\u6709\u6307\u5b9a[\u4ee3\u7801\u76ee\u5f55]"));
        }
        if (StringHelper.isNullOrEmpty((String)this.strToolFolder)) {
            log.warn((Object)StringHelper.format((String)"\u4efb\u52a1\u7cfb\u7edf\u6ca1\u6709\u6307\u5b9a[\u5de5\u5177\u76ee\u5f55]"));
        }
        if (StringHelper.isNullOrEmpty((String)this.strBackupFolder)) {
            this.strBackupFolder = StringHelper.format((String)"%1$s%2$sbackup", (Object)this.getCodeFolder(), (Object)File.separator);
        }
        String strParams = "";
        if (!StringHelper.isNullOrEmpty((String)psTaskServer.getDOMAINPARAMS())) {
            strParams = psTaskServer.getDOMAINPARAMS();
            strParams = String.valueOf(strParams) + "\r\n";
        }
        if (!StringHelper.isNullOrEmpty((String)psTaskServer.getTSPARAMS())) {
            strParams = String.valueOf(strParams) + psTaskServer.getTSPARAMS();
        }
        this.setParams(strParams);
        if (!this.psTaskServer.isDEVSYSDEPLOYMODENull()) {
            this.nPackAndDeployMode = this.psTaskServer.getDEVSYSDEPLOYMODE();
        }
        this.strDynaInstFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DYNAINSTFOLDER", "");
        if (StringHelper.isNullOrEmpty((String)this.strDynaInstFolder)) {
            this.strDynaInstFolder = StringHelper.format((String)"%1$s%2$sDYNAINST", (Object)this.getCodeFolder(), (Object)File.separator);
        }
        this.strDepInstFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DEPINSTFOLDER", "");
        if (StringHelper.isNullOrEmpty((String)this.strDepInstFolder)) {
            this.strDepInstFolder = StringHelper.format((String)"%1$s%2$sDEPINST", (Object)this.getCodeFolder(), (Object)File.separator);
        }
        this.strSysLogFolder = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "SYSLOGFOLDER", "");
        if (StringHelper.isNullOrEmpty((String)this.strSysLogFolder)) {
            this.strSysLogFolder = StringHelper.format((String)"%1$s%2$sSYSLOG", (Object)this.getTempFolder(), (Object)File.separator);
        }
        this.strPSDeployCenterId = this.psTaskServer.getPSDEPLOYCENTERID();
        this.strPSWorkshopServerId = this.psTaskServer.getPSWORKSHOPSERVERID();
        this.strRemoteAddr = this.psTaskServer.getIPADDR();
        PSStudioEnvHelper.getCurrent().setToolFolder(this.getToolFolder());
        PSStudioEnvHelper.getCurrent().setNDCacheFolder(this.getNetDiskCacheFolder());
        PSStudioEnvHelper.getCurrent().setDynaInstFolder(this.getDynaInstFolder());
        PSStudioEnvHelper.getCurrent().setDepInstFolder(this.getDepInstFolder());
        this.onInit();
    }

    @Override
    public String getParam(String strKey) {
        return PropertiesHelper.getProperty((Properties)this.properties, (String)strKey);
    }

    @Override
    public String getParam(String strKey, String strDefault) {
        return PropertiesHelper.getProperty((Properties)this.properties, (String)strKey, (String)strDefault);
    }

    public void setParams(String strParams) throws Exception {
        this.properties = PropertiesHelper.load((String)strParams);
    }

    @Override
    public String getCodeFolder() {
        return this.strCodeFolder;
    }

    @Override
    public String getToolFolder() {
        return this.strToolFolder;
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getBackupFolder() {
        return this.strBackupFolder;
    }

    @Override
    public String getPSSvrDomainId() {
        return this.strPSSvrDomainId;
    }

    @Override
    public int getDevSlnSysExpiredTime() {
        return this.nDevSlnSysExpiredTime;
    }

    @Override
    public boolean isStartASBookingDisp() {
        return this.bStartASBookingDisp;
    }

    @Override
    public boolean isStartDSBookingDisp() {
        return this.bStartDSBookingDisp;
    }

    @Override
    public boolean isStartWSBookingDisp() {
        return this.bStartWSBookingDisp;
    }

    @Override
    public boolean isEnableThreadLockCheck() {
        return this.bEnableThreadLockCheck;
    }

    @Override
    public String getRestartCmd() {
        return this.strRestartCmd;
    }

    @Override
    public int getThreadLockTime() {
        return this.nThreadLockTime;
    }

    @Override
    public String getPSMobAppPackServerId() {
        return this.strPSMobAppPackServerId;
    }

    @Override
    public String getFileFolder() {
        return this.strFileFolder;
    }

    @Override
    public String getTempFolder() {
        return this.strTempFolder;
    }

    @Override
    public boolean isThrowExceptionWhenFileNameTooLong() {
        return this.bThrowExceptionWhenFileNameTooLong;
    }

    @Override
    public int getMaxFileNameLength() {
        return this.nMaxFileNameLength;
    }

    @Override
    public String getJITCodeFolder() {
        return this.strJITCodeFolder;
    }

    @Override
    public int getDevSysDeployMode() {
        return this.nPackAndDeployMode;
    }

    @Override
    public String getOSType() {
        return this.strOSType;
    }

    @Override
    public String getCorePSSysModelInstId() {
        return this.strCoreSysModelInstId;
    }

    @Override
    public String getPSDeployCenterId() {
        return this.strPSDeployCenterId;
    }

    @Override
    public String getPSWorkshopServerId() {
        return this.strPSWorkshopServerId;
    }

    @Override
    public boolean isDebugMode() {
        return this.bDebugMode;
    }

    @Override
    public String getPreviewPCPFId() {
        return this.strPreviewPCPFId;
    }

    @Override
    public String getPreviewPCPFStyleId() {
        return this.strPreviewPCPFStyleId;
    }

    @Override
    public String getPreviewMobPFId() {
        return this.strPreviewMobPFId;
    }

    @Override
    public String getPreviewMobPFStyleId() {
        return this.strPreviewMobPFStyleId;
    }

    @Override
    public String getRemoteAddr() {
        return this.strRemoteAddr;
    }

    @Override
    public boolean isLinux() {
        return this.bLinux;
    }

    @Override
    public boolean isWindows() {
        return this.bWindows;
    }

    @Override
    public String createTempFolder() throws Exception {
        String strPath = StringHelper.format((String)"%1$s%3$s%2$sts%4$s%2$s", (Object)this.getTempFolder(), (Object)File.separator, (Object)DateHelper.toDateString((Date)new Date()), (Object)KeyValueHelper.genGuidEx());
        File folder = new File(strPath);
        folder.mkdirs();
        return strPath;
    }

    @Override
    public String getTaskServerTempFolder() {
        String strPath = StringHelper.format((String)"%1$s%3$s%2$sts%4$s%2$s", (Object)this.getTempFolder(), (Object)File.separator, (Object)DateHelper.toDateString((Date)new Date()), (Object)this.getId());
        File folder = new File(strPath);
        folder.mkdirs();
        return strPath;
    }

    @Override
    public void restart(Throwable throwable) {
        if (throwable != null) {
            log.error((Object)StringHelper.format((String)"****************** \u670d\u52a1\u5668\u53d1\u751f\u6838\u5fc3\u5f02\u5e38[%1$s]\uff0c\u6267\u884c\u670d\u52a1\u5668\u91cd\u542f *********************", (Object)throwable.getMessage()), throwable);
        } else {
            log.error((Object)StringHelper.format((String)"****************** \u670d\u52a1\u5668\u53d1\u751f\u6838\u5fc3\u5f02\u5e38[%1$s]\uff0c\u6267\u884c\u670d\u52a1\u5668\u91cd\u542f *********************", (Object)"\u672a\u77e5"));
        }
        String strRestartCmd = this.getRestartCmd();
        if (!StringHelper.isNullOrEmpty((String)strRestartCmd)) {
            try {
                Runtime.getRuntime().exec(strRestartCmd);
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
    }

    @Override
    public boolean isEnableModelInstProxyMode() {
        return this.bEnableModelInstProxyMode;
    }

    @Override
    public boolean isEnableConsoleServer() {
        return this.bEnableConsoleServer;
    }

    @Override
    public String getConsoleServerUrl() {
        return this.strConsoleServerUrl;
    }

    @Override
    public String getTempFileServerUrl() {
        return this.strTempFileServerUrl;
    }

    @Override
    public String getTempFileServerAddr() {
        return this.strTempFileServerAddr;
    }

    @Override
    public int getTempFileServerPort() {
        return this.nTempFileServerPort;
    }

    @Override
    public String getNetDiskCacheFolder() {
        return this.strNetDiskCacheFolder;
    }

    @Override
    public String createTempFolder(String strType) throws Exception {
        if (StringHelper.isNullOrEmpty((String)strType)) {
            return this.createTempFolder();
        }
        String strPath = StringHelper.format((String)"%1$s%3$s%2$sts%4$s%2$s%5$s%2$s", (Object)this.getTempFolder(), (Object)File.separator, (Object)strType, (Object)DateHelper.toDateString((Date)new Date()), (Object)KeyValueHelper.genGuidEx());
        File folder = new File(strPath);
        folder.mkdirs();
        return strPath;
    }

    @Override
    public String getModelBKMode() {
        return "V2";
    }

    @Override
    public boolean isThrowExceptionWhenTemplError() {
        return this.bThrowExceptionWhenTemplError;
    }

    @Override
    public String getTempFileServerUserName() {
        return this.strTempFileServerUserName;
    }

    @Override
    public String getTempFileServerPassword() {
        return this.strTempFileServerPassword;
    }

    @Override
    public boolean isDebugConsoleInfo() {
        return this.bDebugConsoleInfo;
    }

    @Override
    public int getGlobalConfigVer() {
        try {
            if (!StringHelper.isNullOrEmpty((String)this.getPSSvrDomainId())) {
                PSSvrDomain psSvrDomain = PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).getPSSvrDomain(this.getPSSvrDomainId());
                return DataObject.getIntegerValue((Object)psSvrDomain.getSyncData3(), (Integer)(-1));
            }
            return -1;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u83b7\u53d6\u5168\u5c40\u914d\u7f6e\u7248\u672c\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            return -1;
        }
    }

    @Override
    public boolean isEnableOfflineDevSlnSys() {
        return this.bEnableOfflineDevSlnSys;
    }

    @Override
    public boolean isPFPreviewUseModel() {
        return this.bPFPreviewUseModel;
    }

    @Override
    public String getDynaInstFolder() {
        return this.strDynaInstFolder;
    }

    @Override
    public String getDepInstFolder() {
        return this.strDepInstFolder;
    }

    @Override
    public boolean isTemplEngineV2Only() {
        return this.bTemplEngineV2Only;
    }

    @Override
    public boolean isBackupBeforeImportModel() {
        return this.bBackupBeforeImportModel;
    }

    @Override
    public String getSysLogFolder() {
        return this.strSysLogFolder;
    }

    @Override
    public boolean isAPIOnly() {
        return this.bAPIOnly;
    }

    @Override
    public boolean isEnableSystemTempl() {
        return this.bEnableSystemTempl;
    }

    @Override
    public String getGitLabPlugin() {
        return this.strGitLabPlugin;
    }

    @Override
    public String getKafkaPlugin() {
        return this.strKafkaPlugin;
    }

    @Override
    public String getDevCallbackUrl() {
        return this.strDevCallbackUrl;
    }

    @Override
    public boolean isEnableGitBranch() {
        return this.bEnableGitBranch;
    }

    @Override
    public String getModelFormat() {
        return this.strModelFormat;
    }

    @Override
    public int getImportBatchSize() {
        return this.nImportBatchSize;
    }
}

