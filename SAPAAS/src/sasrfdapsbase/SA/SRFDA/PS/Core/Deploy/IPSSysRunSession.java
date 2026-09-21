/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Deploy;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.Mob.IPSMobAppPack;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSAppServer;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.DynaModel.IPSSysDynaModel;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemObject;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.Service.IPSSysServiceAPI;
import SA.SRFDA.PS.Data.PSSysRunSession;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSysRunSession
extends IPSSystemObject {
    public static final Integer REBUILD_QUICK = 1;
    public static final Integer REBUILD_FULL = 2;
    public static final String RUNMODE_STARTX = "STARTX";
    public static final String RUNMODE_PUBCODE = "PUBCODE";
    public static final String RUNMODE_PUBDOC = "PUBDOC";
    public static final String RUNMODE_PUBMODEL = "PUBMODEL";
    public static final String RUNMODE_PACKVER = "PACKVER";
    public static final String RUNMODE_PACKVER2 = "PACKVER2";
    public static final String RUNMODE_PACKMOBAPP = "PACKMOBAPP";
    public static final String RUNMODE_STARTMSAPI = "STARTMSAPI";
    public static final String RUNMODE_STARTMSAPP = "STARTMSAPP";
    public static final int QUICKMODE_NEWRUNNER = 0;
    public static final int QUICKMODE_LASTRUNNER = 1;
    public static final int QUICKMODE_SELECTRUNNER = 2;

    public void init(ISRFDAGlobalHelper var1, IPSSystem var2, PSSysRunSession var3) throws Exception;

    public String getRealRSId();

    public IPSSystemDBConfig getPSSystemDBConfig();

    public IPSApplication getPSApplication();

    public IPSApplication getPSApplication2();

    public IPSDBDevInst getPSDBDevInst();

    public IPSAppServer getPSAppServer();

    public String getLogBrokerUri();

    public String getLogTopicName();

    public boolean isRebuildMode();

    public int getRebuildModeEx();

    public boolean isEnableVC();

    public boolean isPubCodeOnly();

    public String getRunParam();

    public String getRunParam2();

    public String getRunParam3();

    public String getRunParam4();

    public int getRunParam5();

    public int getRunParam6();

    public String getRunMode();

    public IPSSysSFPub getPSSysSFPub();

    public IPSMobAppPack getPSMobAppPack();

    public IPSSysServiceAPI getPSSysServiceAPI();

    public IPSDevSlnMSDepAPI getPSDevSlnMSDepAPI();

    public IPSDevSlnMSDepApp getPSDevSlnMSDepApp();

    public IPSDevSlnMSDepFunc getPSDevSlnMSDepFunc();

    public IPSSysDynaModel getRunPSDynaModel();

    public String getRunName();

    public boolean isStopWhenTemplError();

    public boolean isDebugMode();

    public String getPSDSConsoleId();

    public boolean isQuickMode();

    public String getPSDCRegistryItemId();

    public int getQuickModeEx();

    public String getRunParam7();

    public String getRunParam8();

    public String getRunParam9();

    public String getRunParam10();

    public String getRunParam11();

    public String getRunParam12();
}

