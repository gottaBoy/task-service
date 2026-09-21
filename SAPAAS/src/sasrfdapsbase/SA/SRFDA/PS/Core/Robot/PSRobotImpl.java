/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSRobot
 *  net.ibizsys.psop.zookeeper.PSRobotKeeper
 *  net.ibizsys.psop.zookeeper.PSZooKeeper
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package SA.SRFDA.PS.Core.Robot;

import SA.SRFDA.PS.Core.Deploy.PSDCResObjectImplBase;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSRobot;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import java.util.Iterator;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.psop.zookeeper.PSRobotKeeper;
import net.ibizsys.psop.zookeeper.PSZooKeeper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSRobotImpl
extends PSDCResObjectImplBase
implements IPSRobot {
    private static final Log log = LogFactory.getLog(PSRobotImpl.class);
    protected PSRobot psRobot = null;
    private PSRobotKeeper psRobotKeeper = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, PSRobot psRobot) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.psRobot = psRobot;
        this.setId(this.psRobot.getPSROBOTID());
        this.setName(this.psRobot.getPSROBOTNAME());
        this.setPSObjectData(this.psRobot);
        net.ibizsys.pscore.srv.paasmgr.entity.PSRobot psRobot2 = new net.ibizsys.pscore.srv.paasmgr.entity.PSRobot();
        PSDEDataCtrl.convertEntity2(psRobot, (IEntity)psRobot2);
        this.psRobotKeeper = new PSRobotKeeper(PSZooKeeper.getCurrent(), this.getId(), this.getPSModelStorage().getPSTaskServerId(), (IEntity)psRobot2);
        this.onInit();
    }

    @Override
    public String getModelType() {
        return "PSROBOT";
    }

    @Override
    public String getRobotType() {
        return this.psRobot.getROBOTTYPE();
    }

    @Override
    public String getPSSysModelInstId() {
        return null;
    }

    @Override
    public synchronized int getCurrentEnergy() throws Exception {
        return this.psRobotKeeper.getCurrentEnergy();
    }

    @Override
    public String getRunPSTaskServerId() {
        return this.psRobotKeeper.getRunPSTaskServerId();
    }

    @Override
    public String getRunPSRobotWorkId() {
        return null;
    }

    public synchronized void runPSRobotWork(IPSRobotWork iPSRobotWork) throws Exception {
        this.psRobotKeeper.setRunWork(iPSRobotWork.getName());
    }

    @Override
    public boolean isSupportPSRobotWork(IPSRobotWork iPSRobotWork) throws Exception {
        return true;
    }

    @Override
    public int getPSRobotWorkEnergy(IPSRobotWork iPSRobotWork) throws Exception {
        if (iPSRobotWork.getPSRobotWorkType() == null) {
            log.warn((Object)StringHelper.format((String)"\u673a\u5668\u4eba\u5de5\u4f5c[%1$s]\u6ca1\u6709\u6307\u5b9a\u5de5\u4f5c\u7c7b\u578b", (Object)iPSRobotWork.getName()));
            return 0;
        }
        return iPSRobotWork.getPSRobotWorkType().getEnergy();
    }

    @Override
    public float getEnergyRate() {
        return this.psRobotKeeper.getEnergyRate();
    }

    @Override
    public int getPSRobotWorkTotalEnergy(IPSRobotWork iPSRobotWork) throws Exception {
        int nTotal = this.getPSRobotWorkEnergy(iPSRobotWork);
        Iterator<IPSRobotWork> childPSRobotWorks = iPSRobotWork.getPSRobotWorks();
        if (childPSRobotWorks != null) {
            while (childPSRobotWorks.hasNext()) {
                nTotal += this.getPSRobotWorkTotalEnergy(childPSRobotWorks.next());
            }
        }
        return nTotal;
    }

    @Override
    public boolean addPSRobotWorks(IPSRobotWork[] psRobotWorks) throws Exception {
        return false;
    }

    @Override
    public boolean closePSRobotWork(IPSRobotWork iPSRobotWork, boolean bReturnEnergy) throws Exception {
        return false;
    }

    @Override
    public synchronized boolean startRun() throws Exception {
        return this.psRobotKeeper.start();
    }

    @Override
    public synchronized void stopRun() throws Exception {
        this.psRobotKeeper.stop();
    }

    @Override
    public void active() throws Exception {
        this.psRobotKeeper.active();
    }

    @Override
    public boolean isLocalRes() {
        return true;
    }

    @Override
    public int getOrderValue() {
        return this.psRobotKeeper.getOrderValue();
    }

    @Override
    public int getRobotLevel() {
        return this.psRobotKeeper.getRobotLevel();
    }
}

