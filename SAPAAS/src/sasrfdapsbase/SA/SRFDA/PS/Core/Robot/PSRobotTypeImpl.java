/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.PSObjectImpl;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotType;
import SA.SRFDA.PS.Data.PSRobot;
import SA.SRFDA.PS.Data.PSRobotType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSRobotTypeImpl
extends PSObjectImpl
implements IPSRobotType {
    protected PSRobotType psRobotType = null;
    private static final Log log = LogFactory.getLog(PSRobotTypeImpl.class);

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSRobotType psRobotType) throws Exception {
        this.psRobotType = psRobotType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psRobotType.getPSROBOTTYPEID());
        this.setName(psRobotType.getPSROBOTTYPENAME());
        this.setPSObjectData(this.psRobotType);
        this.onInit();
    }

    @Override
    protected void onInit() throws Exception {
        super.onInit();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public IPSRobot createPSRobot(PSRobot psRobot) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }
}

