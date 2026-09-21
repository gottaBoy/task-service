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
import SA.SRFDA.PS.Core.Robot.IPSDCRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Core.Robot.PSDCRobotImpl;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import SA.SRFDA.PS.Data.PSDCRobot;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCRobotGlobalModel
extends PSDCGlobalModelBase<String, PSDCRobot, IPSDCRobot> {
    private static final Log log = LogFactory.getLog(PSDCRobotGlobalModel.class);

    @Override
    protected PSDCRobot GetObject(String strPSDCRobotId) {
        return null;
    }

    @Override
    protected IPSDCRobot OnCreateModelHelper(PSDCRobot vt) throws Exception {
        PSDCRobotImpl iPSDCRobot = new PSDCRobotImpl();
        iPSDCRobot.init(this.iDAGlobalHelper, vt);
        return iPSDCRobot;
    }

    @Override
    protected Boolean TestObjectRenew(PSDCRobot obj) {
        return false;
    }

    @Override
    protected void onPreloadModels() {
        super.onPreloadModels();
        try {
            this.getAllModelHelpers();
        }
        catch (Exception ex) {
            log.error((Object)ex);
        }
    }

    @Override
    protected IPSDCRobot registerModel(PSDCRobot vt) throws Exception {
        IPSDCRobot iPSDCRobot = (IPSDCRobot)this.InternalGetModelHelper(vt.getPSDCROBOTID());
        if (iPSDCRobot != null) {
            return iPSDCRobot;
        }
        this.setModel(vt.getPSDCROBOTID(), vt, null);
        return (IPSDCRobot)this.FindModelHelper(vt.getPSDCROBOTID());
    }

    @Override
    protected Vector<PSDCRobot> getAllModels() throws Exception {
        Vector<PSDCRobot> list = new Vector<PSDCRobot>();
        CallResult callResult = this.iPSModelHelper.getPSDCRobots(this.iPSDevCenter.getId(), list);
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u4e2d\u5fc3\u5168\u90e8\u673a\u5668\u4eba\u53d1\u751f\u9519\u8bef, %1$s", (Object)callResult.getErrorInfo()));
        }
        return list;
    }

    @Override
    protected String getObjectId(PSDCRobot vt) {
        return vt.getPSDCROBOTID();
    }

    public PSRobotResult getValidPSDCRobot(IPSRobotWork iPSRobotWork) throws Exception {
        PSRobotResult psRobotResult = new PSRobotResult();
        int nLastEnergy = -1;
        long nLastPlanTime = 0L;
        IPSDCRobot lastPSDCRobot = null;
        Iterator psDCRobots = this.getAllModelHelpers();
        while (psDCRobots.hasNext()) {
            IPSDCRobot iPSDCRobot = (IPSDCRobot)psDCRobots.next();
            if (!StringHelper.IsNullOrEmpty((String)iPSDCRobot.getRunPSTaskServerId()) || !iPSDCRobot.isSupportPSRobotWork(iPSRobotWork)) continue;
            int nEnergy = iPSDCRobot.getCurrentEnergy() - iPSDCRobot.getPSRobotWorkTotalEnergy(iPSRobotWork);
            if (lastPSDCRobot != null) {
                if (nLastEnergy < 0) {
                    if (nEnergy > 0) {
                        nLastEnergy = nEnergy;
                        lastPSDCRobot = iPSDCRobot;
                        nLastPlanTime = 0L;
                        continue;
                    }
                    long nPlanTime = (long)((float)(-nEnergy) / iPSDCRobot.getEnergyRate());
                    if (nPlanTime >= nLastPlanTime) continue;
                    nLastEnergy = nEnergy;
                    lastPSDCRobot = iPSDCRobot;
                    nLastPlanTime = nPlanTime;
                    continue;
                }
                if (nEnergy <= 0 || nEnergy >= nLastEnergy) continue;
                nLastEnergy = nEnergy;
                lastPSDCRobot = iPSDCRobot;
                nLastPlanTime = 0L;
                continue;
            }
            nLastEnergy = nEnergy;
            lastPSDCRobot = iPSDCRobot;
            if (nLastEnergy >= 0) continue;
            nLastPlanTime = (long)((float)(-nLastEnergy) / iPSDCRobot.getEnergyRate());
        }
        if (lastPSDCRobot == null) {
            return null;
        }
        psRobotResult.setEnerge(nLastEnergy);
        psRobotResult.setPSRobot(lastPSDCRobot);
        if (nLastPlanTime > 0L) {
            psRobotResult.setPlanTime(new Date(System.currentTimeMillis() + nLastPlanTime * 1000L));
        }
        return psRobotResult;
    }
}

