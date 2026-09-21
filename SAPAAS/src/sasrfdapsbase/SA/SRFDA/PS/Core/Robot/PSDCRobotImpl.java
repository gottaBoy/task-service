/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotLog
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.Robot.IPSDCRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Data.PSRobot;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotLog;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSDCRobotImpl
extends PSDCResObjectImplBase
implements IPSDCRobot {
    private static final Log log = LogFactory.getLog(PSDCRobotImpl.class);
    protected SA.SRFDA.PS.Data.PSDCRobot psDCRobot = null;
    private IPSRobot iPSRobot = null;
    private HashMap<String, IPSRobotWork> psRobotWorkMap = new HashMap();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, SA.SRFDA.PS.Data.PSDCRobot psDCRobot) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psDCRobot = psDCRobot;
        this.setId(this.psDCRobot.getPSDCROBOTID());
        this.setName(this.psDCRobot.getPSDCROBOTNAME());
        this.setPSObjectData(this.psDCRobot);
        this.iPSRobot = this.getPSModelStorage().getPSRobot(this.psDCRobot.getPSROBOTID());
        this.onInit();
    }

    protected IPSRobot getPSRobot() {
        return this.iPSRobot;
    }

    @Override
    public String getModelType() {
        return "PSDCROBOT";
    }

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSRobot psRobot) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0");
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public String getRobotType() {
        return this.iPSRobot.getRobotType();
    }

    @Override
    public int getCurrentEnergy() throws Exception {
        return this.iPSRobot.getCurrentEnergy();
    }

    @Override
    public String getRunPSTaskServerId() {
        return this.iPSRobot.getRunPSTaskServerId();
    }

    @Override
    public String getRunPSRobotWorkId() {
        return this.iPSRobot.getRunPSRobotWorkId();
    }

    @Override
    public boolean isSupportPSRobotWork(IPSRobotWork iPSRobotWork) throws Exception {
        return this.iPSRobot.isSupportPSRobotWork(iPSRobotWork);
    }

    @Override
    public int getPSRobotWorkEnergy(IPSRobotWork iPSRobotWork) throws Exception {
        return this.iPSRobot.getPSRobotWorkEnergy(iPSRobotWork);
    }

    @Override
    public float getEnergyRate() {
        return this.iPSRobot.getEnergyRate();
    }

    @Override
    public int getPSRobotWorkTotalEnergy(IPSRobotWork iPSRobotWork) throws Exception {
        return this.iPSRobot.getPSRobotWorkTotalEnergy(iPSRobotWork);
    }

    protected void fillPSRobotWorkMap(IPSRobotWork iPSRobotWork) {
        Iterator<IPSRobotWork> psRobotWorks = iPSRobotWork.getPSRobotWorks();
        if (psRobotWorks != null) {
            while (psRobotWorks.hasNext()) {
                this.fillPSRobotWorkMap(psRobotWorks.next());
            }
        }
        this.psRobotWorkMap.put(iPSRobotWork.getId(), iPSRobotWork);
    }

    @Override
    public synchronized boolean addPSRobotWorks(IPSRobotWork[] psRobotWorks) throws Exception {
        boolean bIgnoreException;
        block9: {
            if (this.psRobotWorkMap.size() > 0) {
                return false;
            }
            bIgnoreException = false;
            if (this.startRun()) break block9;
            return false;
        }
        try {
            IPSRobotWork[] iPSRobotWorkArray = psRobotWorks;
            int n = psRobotWorks.length;
            int n2 = 0;
            while (n2 < n) {
                IPSRobotWork iPSRobotWork = iPSRobotWorkArray[n2];
                this.fillPSRobotWorkMap(iPSRobotWork);
                ++n2;
            }
            ArrayList<PSDCRobotLog> psDCRobotLogList = new ArrayList<PSDCRobotLog>();
            for (IPSRobotWork iPSRobotWork : this.psRobotWorkMap.values()) {
                int nEnergy = this.getPSRobotWorkEnergy(iPSRobotWork);
                PSDCRobotLog psDCRobotLog = new PSDCRobotLog();
                psDCRobotLog.setPSDCRobotLogName(iPSRobotWork.getName());
                psDCRobotLog.setPSDCRobotLogId(iPSRobotWork.getId());
                psDCRobotLog.setLogType("SYSBKTASK");
                psDCRobotLog.setEnergy(Integer.valueOf(-nEnergy));
                psDCRobotLog.setPSDCRobotId(this.getId());
                psDCRobotLog.setPSDCRobotName(this.getName());
                psDCRobotLogList.add(psDCRobotLog);
            }
            PSDCRobot psDCRobot = new PSDCRobot();
            psDCRobot.setPSDCRobotId(this.getId());
            PSDCRobotService psDCRobotService = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class);
            if (!psDCRobotService.logPSDCRobotActions(psDCRobot, psDCRobotLogList)) {
                bIgnoreException = true;
                throw new Exception("\u673a\u5668\u4eba\u80fd\u91cf\u4e0d\u8db3");
            }
            for (IPSRobotWork iPSRobotWork : this.psRobotWorkMap.values()) {
                int nEnergy = this.getPSRobotWorkEnergy(iPSRobotWork);
                iPSRobotWork.setPSRobot(this, nEnergy);
            }
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u673a\u5668\u4eba[%1$s]\u589e\u52a0\u5de5\u4f5c\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getName(), (Object)ex.getMessage()), (Throwable)ex);
            this.psRobotWorkMap.clear();
            this.stopRun();
            if (bIgnoreException) {
                return false;
            }
            throw ex;
        }
        return true;
    }

    @Override
    public synchronized boolean closePSRobotWork(IPSRobotWork iPSRobotWork, boolean bReturnEnergy) throws Exception {
        if ((iPSRobotWork = this.psRobotWorkMap.remove(iPSRobotWork.getId())) != null) {
            if (bReturnEnergy) {
                try {
                    ArrayList<PSDCRobotLog> psDCRobotLogList = new ArrayList<PSDCRobotLog>();
                    PSDCRobotLog psDCRobotLog = new PSDCRobotLog();
                    psDCRobotLog.setPSDCRobotLogName(iPSRobotWork.getName());
                    psDCRobotLog.setPSDCRobotLogId(iPSRobotWork.getId());
                    psDCRobotLog.setLogType("SYSBKTASK");
                    psDCRobotLog.setEnergy(Integer.valueOf(iPSRobotWork.getEnergy()));
                    psDCRobotLog.setPSDCRobotId(this.getId());
                    psDCRobotLog.setPSDCRobotName(this.getName());
                    psDCRobotLogList.add(psDCRobotLog);
                    PSDCRobot psDCRobot = new PSDCRobot();
                    psDCRobot.setPSDCRobotId(this.getId());
                    PSDCRobotService psDCRobotService = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class);
                    psDCRobotService.cancelPSDCRobotActions(psDCRobot, psDCRobotLogList);
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.format((String)"\u673a\u5668\u4eba[%1$s]\u8fd4\u56de\u80fd\u91cf\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)this.getName(), (Object)ex.getMessage()), (Throwable)ex);
                }
            }
            if (this.psRobotWorkMap.size() == 0) {
                this.stopRun();
            }
        }
        return iPSRobotWork != null;
    }

    @Override
    public synchronized boolean startRun() throws Exception {
        return this.iPSRobot.startRun();
    }

    @Override
    public synchronized void stopRun() throws Exception {
        this.psRobotWorkMap.clear();
        this.iPSRobot.stopRun();
    }

    @Override
    public void active() throws Exception {
        this.iPSRobot.active();
    }

    @Override
    public boolean isLocalRes() {
        return this.iPSRobot.isLocalRes();
    }

    @Override
    public int getOrderValue() {
        return this.iPSRobot.getOrderValue();
    }

    @Override
    public int getRobotLevel() {
        return this.iPSRobot.getRobotLevel();
    }
}

