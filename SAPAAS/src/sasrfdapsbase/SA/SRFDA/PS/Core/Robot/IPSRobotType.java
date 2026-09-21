/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Data.PSRobot;
import SA.SRFDA.PS.Data.PSRobotType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSRobotType
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSRobotType var2) throws Exception;

    public IPSRobot createPSRobot(PSRobot var1) throws Exception;
}

