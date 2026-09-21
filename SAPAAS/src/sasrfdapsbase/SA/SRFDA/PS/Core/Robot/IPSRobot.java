/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.Deploy.IPSDCResObject;
import SA.SRFDA.PS.Core.IPSObject;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Data.PSRobot;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;

public interface IPSRobot
extends IPSObject,
IPSDCResObject {
    public void init(ISRFDAGlobalHelper var1, PSRobot var2) throws Exception;

    public String getRobotType();

    public int getCurrentEnergy() throws Exception;

    public String getRunPSTaskServerId();

    public String getRunPSRobotWorkId();

    public boolean addPSRobotWorks(IPSRobotWork[] var1) throws Exception;

    public boolean closePSRobotWork(IPSRobotWork var1, boolean var2) throws Exception;

    public boolean isSupportPSRobotWork(IPSRobotWork var1) throws Exception;

    public int getPSRobotWorkEnergy(IPSRobotWork var1) throws Exception;

    public int getPSRobotWorkTotalEnergy(IPSRobotWork var1) throws Exception;

    public float getEnergyRate();

    public boolean startRun() throws Exception;

    public void stopRun() throws Exception;

    public void active() throws Exception;

    public int getOrderValue();

    public int getRobotLevel();
}

