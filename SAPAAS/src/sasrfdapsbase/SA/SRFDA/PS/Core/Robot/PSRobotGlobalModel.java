/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.DevCenter.PSDCGlobalModelBase;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.PSRobotImpl;
import SA.SRFDA.PS.Data.PSRobot;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSRobotGlobalModel
extends PSDCGlobalModelBase<String, PSRobot, IPSRobot> {
    private static final Log log = LogFactory.getLog(PSRobotGlobalModel.class);

    @Override
    protected PSRobot GetObject(String strPSRobotId) {
        PSRobot psRobot = new PSRobot();
        CallResult callResult = this.iPSModelHelper.getPSRobot(strPSRobotId, psRobot);
        if (callResult.isError()) {
            log.error((Object)StringHelper.Format((String)"\u83b7\u53d6\u6307\u5b9a\u4e91\u5e73\u53f0\u673a\u5668\u4eba[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)strPSRobotId, (Object)callResult.getErrorInfo()));
            return null;
        }
        return psRobot;
    }

    @Override
    protected IPSRobot OnCreateModelHelper(PSRobot vt) throws Exception {
        PSRobotImpl iPSRobot = new PSRobotImpl();
        iPSRobot.init(this.iDAGlobalHelper, vt);
        return iPSRobot;
    }

    @Override
    protected Boolean TestObjectRenew(PSRobot obj) {
        return false;
    }

    @Override
    protected IPSRobot registerModel(PSRobot vt) throws Exception {
        IPSRobot iPSRobot = (IPSRobot)this.InternalGetModelHelper(vt.getPSROBOTID());
        if (iPSRobot != null) {
            return iPSRobot;
        }
        this.setModel(vt.getPSROBOTID(), vt, null);
        return (IPSRobot)this.FindModelHelper(vt.getPSROBOTID());
    }

    @Override
    protected String getObjectId(PSRobot vt) {
        return vt.getPSROBOTID();
    }
}

