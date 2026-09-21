/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevCenter;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTask;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevCenter.IPSDevCenterBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskSessionBase;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevCenterBKTaskSession
extends PSBKTaskSessionBase
implements IPSDevCenterBKTaskSessionContext {
    private static final Log log = LogFactory.getLog(PSDevCenterBKTaskSession.class);
    private String strPSDevCenterId = null;
    private IPSDevCenterBKTask activePSDevCenterBKTask = null;
    private String psSysModelInstId = null;
    private IPSDevCenterBKTaskGlobalContext iPSDevCenterBKTaskGlobalContext = null;
    private IPSRobot lastPSRobot = null;
    private Object objLastPSRobotLock = new Object();
    private long nLastActiveTime = 0L;
    IPSDevCenter iPSDevCenter = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, String strPSDevCenterId, IPSBKTaskGlobalContext iPSBKTaskGlobalContext) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.strPSDevCenterId = strPSDevCenterId;
        this.iPSDevCenterBKTaskGlobalContext = (IPSDevCenterBKTaskGlobalContext)iPSBKTaskGlobalContext;
        this.iPSDevCenter = this.getPSModelStorage().getPSDevCenter(this.strPSDevCenterId);
        this.iPSDevCenter.active();
        this.psSysModelInstId = this.iPSDevCenter.getPSSysModelInstId();
        this.setName(StringHelper.format((String)"\u5e94\u7528\u4e2d\u5fc3[%1$s][%2$s]\u540e\u53f0\u4f5c\u4e1a", (Object)this.iPSDevCenter.getId(), (Object)this.iPSDevCenter.getName()));
        super.init(iDAGlobalHelper, strPSDevCenterId, iPSBKTaskGlobalContext);
    }

    @Override
    protected int onCalcTaskThreadCount() throws Exception {
        int nTaskThreadCount = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "DCTASKTHREADCOUNT", 3);
        if (nTaskThreadCount <= 0) {
            nTaskThreadCount = 3;
        }
        return nTaskThreadCount;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.psSysModelInstId;
    }

    public String getPSDevCenterId() {
        return this.strPSDevCenterId;
    }

    @Override
    protected boolean onBeforeCancelPSBKTask(String strPSBKTaskId) throws Exception {
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
        psDevCenterBKTask.setPSDCBKTaskId(strPSBKTaskId);
        if (!psDCBKTaskService.get((IEntity)psDevCenterBKTask, true)) {
            return false;
        }
        return super.onBeforeCancelPSBKTask(strPSBKTaskId);
    }

    @Override
    protected void onAfterCancelPSBKTask(String strPSBKTaskId, IPSBKTask cancelPSBKTask) throws Exception {
        if (cancelPSBKTask == null) {
            try {
                PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                PSDCBKTask psDevCenterBKTask = new PSDCBKTask();
                psDevCenterBKTask.setPSDCBKTaskId(strPSBKTaskId);
                psDCBKTaskService.get((IEntity)psDevCenterBKTask);
                if (psDevCenterBKTask.getTaskState() == 10 || psDevCenterBKTask.getTaskState() == 20) {
                    psDevCenterBKTask.reset();
                    psDevCenterBKTask.setPSDCBKTaskId(strPSBKTaskId);
                    psDevCenterBKTask.setTaskState(Integer.valueOf(40));
                    psDevCenterBKTask.setResultInfo(null);
                    psDCBKTaskService.update((IEntity)psDevCenterBKTask, false);
                }
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u66f4\u65b0\u4efb\u52a1\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        super.onAfterCancelPSBKTask(strPSBKTaskId, cancelPSBKTask);
    }

    @Override
    protected void onTestRunning(boolean bRunning) {
        if (bRunning) {
            IPSRobot runPSRobot = this.lastPSRobot;
            try {
                if (runPSRobot != null) {
                    runPSRobot.active();
                }
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            try {
                this.iPSDevCenter.active();
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
        }
        super.onTestRunning(bRunning);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected boolean onBeforeRun() {
        Object object = this.objLastPSRobotLock;
        synchronized (object) {
            this.lastPSRobot = null;
        }
        return super.onBeforeRun();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected boolean onTestRunPSBKTask(IPSBKTask iPSBKTask) throws Exception {
        IPSDevCenterBKTask iPSDevCenterBKTask = (IPSDevCenterBKTask)iPSBKTask;
        if (this.iPSDevCenter.isUseRobot() && iPSDevCenterBKTask.isUseRobot()) {
            PSRobotResult psRobotResult;
            block9: {
                block8: {
                    try {
                        psRobotResult = this.iPSDevCenter.getValidPSDCRobot(iPSDevCenterBKTask);
                        if (psRobotResult != null && psRobotResult.getEnerge() >= 0) break block8;
                        iPSDevCenterBKTask.setPlanPSRobot(psRobotResult);
                        return false;
                    }
                    catch (Exception ex) {
                        log.error((Object)"\u83b7\u53d6\u5f53\u524d\u53ef\u7528\u673a\u5668\u4eba\u53d1\u751f\u9519\u8bef", (Throwable)ex);
                        throw new Exception("\u5206\u914d\u4efb\u52a1\u673a\u5668\u4eba\u53d1\u751f\u9519\u8bef");
                    }
                }
                if (psRobotResult.getPSRobot().addPSRobotWorks(new IPSRobotWork[]{iPSDevCenterBKTask})) break block9;
                return false;
            }
            Object object = this.objLastPSRobotLock;
            synchronized (object) {
                this.lastPSRobot = psRobotResult.getPSRobot();
            }
        }
        return super.onTestRunPSBKTask(iPSBKTask);
    }

    public IPSRobot getLastTaskPSRobot() {
        return this.lastPSRobot;
    }

    @Override
    protected void onSetQueuePos(int nPos, int nTotal, IPSBKTask iPSBKTask) {
        this.iPSDevCenter.active();
        super.onSetQueuePos(nPos, nTotal, iPSBKTask);
    }
}

