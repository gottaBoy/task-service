/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Data.PSDCRobot;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSDCRobot
extends IPSRobot {
    public void init(ISRFDAGlobalHelper var1, PSDCRobot var2) throws Exception;
}

