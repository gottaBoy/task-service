/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.PSModelIgnoreMeta;
import SA.SRFDA.PS.Core.Robot.IPSDCRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import SA.SRFDA.PS.Data.PSDevCenter;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

@PSModelIgnoreMeta
public interface IPSDevCenter
extends IPSObject {
    public void init(ISRFDAGlobalHelper var1, PSDevCenter var2) throws Exception;

    public int getMaxActiveUserCount();

    public boolean isUseRobot();

    public IPSDCRobot getPSDCRobot(String var1) throws Exception;

    public void resetPSDCRobot(String var1);

    public PSRobotResult getValidPSDCRobot(IPSRobotWork var1) throws Exception;

    public boolean isValid();

    public int getDCLevel();

    public String getDCType();

    public String getDomainName();

    public long getLastActiveTime();

    public void active();

    public boolean isUseWorkspace();
}

