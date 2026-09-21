/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Pub;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPack;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterFile;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterNetworkFlow;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;

public interface IPSSysPubRuntime {
    public String getPFPubRootFolder(IPSApplication var1) throws Exception;

    public String getSFPubRootFolder(IPSSysSFPub var1) throws Exception;

    public void registerPFPubFolder(IPSApplication var1, String var2) throws Exception;

    public void registerPFPubCode(IPSApplication var1, String var2, String var3, boolean var4) throws Exception;

    public void registerSFPubFolder(IPSSysSFPub var1, String var2) throws Exception;

    public void registerSFPubCode(IPSSysSFPub var1, String var2, String var3, boolean var4) throws Exception;

    public String getSysRootFolder();

    public String getPubRootFolder();

    public String getWorkshopFolder();

    public int syncPFPubCode(String var1, String var2, String var3, int var4) throws Exception;

    public int syncSFPubCode(String var1, String var2, String var3, int var4) throws Exception;

    public void endPFPubCode(IPSApplication var1) throws Exception;

    public void endSFPubCode(IPSSysSFPub var1) throws Exception;

    public void resetPFPubCode(IPSApplication var1) throws Exception;

    public void resetSFPubCode(IPSSysSFPub var1) throws Exception;

    public IPSDevCenterFile createPSDCFile();

    public boolean logPSDCFile(IPSDevCenterFile var1);

    public IPSDevCenterNetworkFlow createPSDCNetworkFlow();

    public boolean logPSDCNetworkFlow(IPSDevCenterNetworkFlow var1);

    public String executePlugin(String var1, String var2, String var3) throws Exception;

    public IPSSystemDBConfig getPSSystemDBConfig();

    public IPSApplication getPSApplication();

    public IPSApplication getPSApplication2();

    public boolean isRebuildMode();

    public int getRebuildModeEx();

    public boolean isEnableVC();

    public boolean isPubCodeOnly();

    public String getRunMode();

    public IPSSysSFPub getPSSysSFPub();

    public IPSMobAppPack getPSMobAppPack();

    public String getRunParam();

    public String getRunParam2();
}

