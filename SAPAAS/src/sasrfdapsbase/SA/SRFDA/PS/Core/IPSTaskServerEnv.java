/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.PSModelIgnoreMeta;

@PSModelIgnoreMeta
public interface IPSTaskServerEnv {
    public static final String OSTYPE_WIN = "WIN";
    public static final String OSTYPE_LINUX = "LINUX";
    public static final String STUDIO_MOS = "MOS";
    public static final String STUDIO_MOSDYNAMIC = "MOSDYNAMIC";
    public static final String STUDIO_DYNAMIC = "DYNAMIC";

    public String getParam(String var1);

    public String getParam(String var1, String var2);

    public String getId();

    public String getName();

    public String getCodeFolder();

    public String getToolFolder();

    public String getBackupFolder();

    public String getPSSvrDomainId();

    public boolean isStartASBookingDisp();

    public int getDevSlnSysExpiredTime();

    public boolean isStartDSBookingDisp();

    public boolean isEnableThreadLockCheck();

    public String getRestartCmd();

    public int getThreadLockTime();

    public String getPSMobAppPackServerId();

    public String getFileFolder();

    public String getTaskServerTempFolder();

    public String getTempFolder();

    public boolean isThrowExceptionWhenFileNameTooLong();

    public int getMaxFileNameLength();

    public String getJITCodeFolder();

    public int getDevSysDeployMode();

    public String getOSType();

    public boolean isLinux();

    public boolean isWindows();

    public String getCorePSSysModelInstId();

    public String getPSDeployCenterId();

    public String getPSWorkshopServerId();

    public boolean isDebugMode();

    public String getPreviewPCPFId();

    public String getPreviewPCPFStyleId();

    public String getPreviewMobPFId();

    public String getPreviewMobPFStyleId();

    public String getRemoteAddr();

    public String createTempFolder() throws Exception;

    public String createTempFolder(String var1) throws Exception;

    public void restart(Throwable var1);

    public boolean isEnableModelInstProxyMode();

    public boolean isEnableConsoleServer();

    public String getConsoleServerUrl();

    public String getTempFileServerUrl();

    public String getTempFileServerAddr();

    public int getTempFileServerPort();

    public String getTempFileServerUserName();

    public String getTempFileServerPassword();

    public String getNetDiskCacheFolder();

    public String getModelBKMode();

    public boolean isThrowExceptionWhenTemplError();

    public boolean isDebugConsoleInfo();

    public int getGlobalConfigVer();

    public boolean isStartWSBookingDisp();

    public boolean isEnableOfflineDevSlnSys();

    public boolean isPFPreviewUseModel();

    public String getDynaInstFolder();

    public String getDepInstFolder();

    public boolean isTemplEngineV2Only();

    public boolean isBackupBeforeImportModel();

    public String getSysLogFolder();

    public boolean isAPIOnly();

    public boolean isEnableSystemTempl();

    public String getGitLabPlugin();

    public String getKafkaPlugin();

    public String getDevCallbackUrl();

    public boolean isEnableGitBranch();

    public String getModelFormat();

    public int getImportBatchSize();
}

