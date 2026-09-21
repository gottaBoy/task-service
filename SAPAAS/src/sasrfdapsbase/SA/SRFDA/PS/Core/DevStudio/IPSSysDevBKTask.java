/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.Deploy.IPSSysRunSession;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Data.PSSysDevBKTask;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSSysDevBKTask
extends IPSBKTask,
IPSRobotWork {
    public void init(ISRFDAGlobalHelper var1, IPSSysDevBKTask var2, PSSysDevBKTask var3) throws Exception;

    public IPSSysDevBKTask getParentPSSysDevBKTask();

    public IPSSysDevBKTask getRootPSSysDevBKTask();

    public IPSSysRunSession getPSSysRunSession();

    public int getModelLoadLevel();

    public boolean isUseRobot();

    public String getPSDevSlnSysId();

    public String getPSDynaInstId();

    public String getPSDSConsoleId();

    public String getPSSystemId();
}

