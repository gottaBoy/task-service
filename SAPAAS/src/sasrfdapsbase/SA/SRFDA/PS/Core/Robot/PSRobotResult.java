/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.Robot.IPSRobot;
import java.util.Date;

public class PSRobotResult {
    private IPSRobot iPSRobot = null;
    private int nEnerge = 0;
    private Date planTime = null;

    public IPSRobot getPSRobot() {
        return this.iPSRobot;
    }

    public void setPSRobot(IPSRobot iPSRobot) {
        this.iPSRobot = iPSRobot;
    }

    public int getEnerge() {
        return this.nEnerge;
    }

    public void setEnerge(int nEnerge) {
        this.nEnerge = nEnerge;
    }

    public Date getPlanTime() {
        return this.planTime;
    }

    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }
}

