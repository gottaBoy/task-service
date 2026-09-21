/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core;

import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepAPI;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepApp;
import SA.SRFDA.PS.Core.Deploy.IPSDevSlnMSDepFunc;
import SA.SRFDA.PS.Core.Deploy.IPSSVNInstRepo;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSSystemContainer;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Data.PSDevSlnSys;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.sql.Timestamp;
import java.util.Iterator;

@PSModelIgnoreMeta
public interface IPSDevSlnSys
extends IPSObject,
IPSSystemContainer {
    public void init(ISRFDAGlobalHelper var1, PSDevSlnSys var2) throws Exception;

    public String getPSDevSlnCodeName();

    public String getPSSystemId();

    public String getPSSystemName();

    public IPSSystem getPSSystem() throws Exception;

    public IPSSystem getPSSystem(boolean var1) throws Exception;

    @Override
    public String getPSSysModelInstId();

    public IPSSystem reloadPSSystem(int var1) throws Exception;

    public IPSSystem reloadPSSystem(int var1, int var2) throws Exception;

    public IPSSVNInstRepo getPSSVNInstRepo();

    public IPSSVNInstRepo getReadOnlyPSSVNInstRepo();

    public IPSSVNInstRepo getOpenPSSVNInstRepo();

    public String getVCType();

    public String getSysVersion();

    public String getMainPSDevSlnSysName();

    public void uploadPSSystem() throws Exception;

    public String getPSDevSlnId();

    public String getPSDevSlnName();

    public int getModelInstVer();

    public String getJITPSDBDevInstId();

    public String getLogicName();

    public long getLastActiveTime();

    public void active();

    public Timestamp getExpiredTime();

    public boolean isExpired();

    public IPSDevSlnSys getMainPSDevSlnSys() throws Exception;

    public IPSDevSlnSys getSourcePSDevSlnSys() throws Exception;

    public Iterator<IPSDevSlnMSDepAPI> getPSDevSlnMSDepAPIs() throws Exception;

    public Iterator<IPSDevSlnMSDepApp> getPSDevSlnMSDepApps() throws Exception;

    public Iterator<IPSDevSlnMSDepFunc> getPSDevSlnMSDepFuncs() throws Exception;

    public String getTemplEngineVer();

    public String getPSDevCenterDomain();

    public String getPSDevCenterId();

    public String getPSDevCenterName();

    public boolean isShareInstMode();

    public IPSSVNInstRepo getRTPSSVNInstRepo();

    public IPSSVNInstRepo getDocPSSVNInstRepo();

    public String getSysType();
}

