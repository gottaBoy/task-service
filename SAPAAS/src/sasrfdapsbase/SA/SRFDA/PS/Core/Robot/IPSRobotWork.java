/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWorkType;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import java.util.Iterator;

public interface IPSRobotWork
extends IPSObject {
    public void setPlanPSRobot(PSRobotResult var1) throws Exception;

    public void setPSRobot(IPSRobot var1, int var2) throws Exception;

    public IPSRobotWorkType getPSRobotWorkType();

    public Iterator<IPSRobotWork> getPSRobotWorks();

    public int getEnergy();

    public IPSRobot getPSRobot();
}

