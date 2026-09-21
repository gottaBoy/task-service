/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Data.PSDCBKTask;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDevCenterBKTask
extends IPSBKTask,
IPSRobotWork {
    public void init(ISRFDAGlobalHelper var1, IPSDevCenterBKTask var2, PSDCBKTask var3) throws Exception;

    public IPSDevCenterBKTask getParentPSDevCenterBKTask();

    public boolean isUseRobot();
}

