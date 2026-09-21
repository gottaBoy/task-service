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
import SA.SRFDA.PS.Core.Robot.IPSRobotWorkType;
import SA.SRFDA.PS.Data.PSRobotWorkType;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSRobotWorkTypeImpl
extends PSObjectImpl
implements IPSRobotWorkType {
    protected PSRobotWorkType psRobotWorkType = null;
    private static final Log log = LogFactory.getLog(PSRobotWorkTypeImpl.class);
    private int nEnergy = 0;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSRobotWorkType psRobotWorkType) throws Exception {
        this.psRobotWorkType = psRobotWorkType;
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setId(psRobotWorkType.getPSROBOTWORKTYPEID());
        this.setName(psRobotWorkType.getPSROBOTWORKTYPENAME());
        this.setPSObjectData(this.psRobotWorkType);
        this.nEnergy = this.psRobotWorkType.getENERGY();
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
    public int getEnergy() {
        return this.nEnergy;
    }
}

