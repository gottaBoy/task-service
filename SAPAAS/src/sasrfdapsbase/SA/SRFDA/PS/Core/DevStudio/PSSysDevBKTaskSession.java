/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.DevStudio;

import SA.SRFDA.PS.Core.DevCenter.IPSDevCenter;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTask;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTaskGlobalContext;
import SA.SRFDA.PS.Core.DevStudio.IPSSysDevBKTaskSessionContext;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskSessionBase;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.Robot.IPSRobot;
import SA.SRFDA.PS.Core.Robot.IPSRobotWork;
import SA.SRFDA.PS.Core.Robot.PSRobotResult;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysDevBKTaskSession
extends PSBKTaskSessionBase
implements IPSSysDevBKTaskSessionContext {
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskSession.class);
    private String strPSDevSlnSysId = null;
    private String psSysModelInstId = null;
    private String strPSDynaInstId = null;
    private IPSSysDevBKTaskGlobalContext iPSSysDevBKTaskGlobalContext = null;
    private IPSDevCenter iPSDevCenter = null;
    private IPSRobot lastPSRobot = null;
    private Object objLastPSRobotLock = new Object();
    private long nLastActiveTime = 0L;
    private boolean bDynaInstMode = false;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, String strPSDevSlnSysId, IPSBKTaskGlobalContext iPSBKTaskGlobalContext) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.iPSSysDevBKTaskGlobalContext = (IPSSysDevBKTaskGlobalContext)iPSBKTaskGlobalContext;
        if (strPSDevSlnSysId.indexOf("PSDYNAINST:") == 0) {
            this.bDynaInstMode = true;
            this.strPSDynaInstId = strPSDevSlnSysId.replace("PSDYNAINST:", "");
            IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = this.getPSModelStorage().getPSDevSlnSysDynaInst(this.strPSDynaInstId);
            IPSDevSlnSys iPSDevSlnSys = iPSDevSlnSysDynaInst.getPSDevSlnSys();
            this.strPSDevSlnSysId = iPSDevSlnSys.getId();
            this.psSysModelInstId = iPSDevSlnSysDynaInst.getPSSysModelInstId();
            this.iPSDevCenter = this.getPSModelStorage().getPSDevCenter(iPSDevSlnSysDynaInst.getPSDevCenterId());
            this.setName(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s][%2$s]\u52a8\u6001\u5b9e\u4f8b[%3$s]\u540e\u53f0\u4f5c\u4e1a", (Object)iPSDevSlnSys.getId(), (Object)iPSDevSlnSys.getName(), (Object)this.strPSDynaInstId));
        } else {
            this.strPSDevSlnSysId = strPSDevSlnSysId;
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(this.strPSDevSlnSysId);
            this.psSysModelInstId = iPSDevSlnSys.getPSSysModelInstId();
            this.iPSDevCenter = this.getPSModelStorage().getPSDevCenter(iPSDevSlnSys.getPSDevCenterId());
            this.setName(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s][%2$s]\u540e\u53f0\u4f5c\u4e1a", (Object)iPSDevSlnSys.getId(), (Object)iPSDevSlnSys.getName()));
        }
        super.init(iDAGlobalHelper, strPSDevSlnSysId, this.iPSSysDevBKTaskGlobalContext);
    }

    @Override
    protected int onCalcTaskThreadCount() throws Exception {
        int nTaskThreadCount = this.getDAGlobalHelper().getWebExConfig().GetValue("SRFPS", "TASKTHREADCOUNT", 3);
        if (nTaskThreadCount <= 0) {
            nTaskThreadCount = 3;
        }
        return nTaskThreadCount;
    }

    @Override
    public String getPSSysModelInstId() {
        return this.psSysModelInstId;
    }

    public String getPSDevSlnSysId() {
        return this.strPSDevSlnSysId;
    }

    @Override
    public String getPSDynaInstId() {
        return this.strPSDynaInstId;
    }

    public boolean isDynaInstMode() {
        return this.bDynaInstMode;
    }

    @Override
    protected boolean onBeforeCancelPSBKTask(String strPSBKTaskId) throws Exception {
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskId(strPSBKTaskId);
        if (!psSysDevBKTaskService.get(psSysDevBKTask, true)) {
            return false;
        }
        if (!StringHelper.isNullOrEmpty((String)psSysDevBKTask.getPPSSysDevBKTaskId())) {
            PSSysDevBKTask parentPSSysDevBKTask = new PSSysDevBKTask();
            parentPSSysDevBKTask.setPSSysDevBKTaskId(psSysDevBKTask.getPPSSysDevBKTaskId());
            if (psSysDevBKTaskService.get(parentPSSysDevBKTask, true) && (parentPSSysDevBKTask.getTaskState() == 10 || parentPSSysDevBKTask.getTaskState() == 20)) {
                this.cancelPSBKTask(psSysDevBKTask.getPPSSysDevBKTaskId());
                return false;
            }
        }
        return super.onBeforeCancelPSBKTask(strPSBKTaskId);
    }

    @Override
    protected void onAfterCancelPSBKTask(String strPSBKTaskId, IPSBKTask cancelPSBKTask) throws Exception {
        if (cancelPSBKTask == null) {
            try {
                PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)this.getPSSysModelInstId()));
                PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
                psSysDevBKTask.setPSSysDevBKTaskId(strPSBKTaskId);
                psSysDevBKTaskService.get(psSysDevBKTask);
                if (psSysDevBKTask.getTaskState() == 10 || psSysDevBKTask.getTaskState() == 20) {
                    psSysDevBKTask.reset();
                    psSysDevBKTask.setPSSysDevBKTaskId(strPSBKTaskId);
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CANCELLED);
                    psSysDevBKTask.setResultInfo(null);
                    psSysDevBKTaskService.update(psSysDevBKTask, false);
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
                this.activePSDevSlnSys();
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

    @Override
    protected void onRunPSBKTask(IPSBKTask iPSBKTask, boolean bCancel) {
        super.onRunPSBKTask(iPSBKTask, bCancel);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected boolean onTestRunPSBKTask(IPSBKTask iPSBKTask) throws Exception {
        IPSSysDevBKTask iPSSysDevBKTask = (IPSSysDevBKTask)iPSBKTask;
        if (this.iPSDevCenter.isUseRobot() && iPSSysDevBKTask.isUseRobot()) {
            PSRobotResult psRobotResult;
            block9: {
                block8: {
                    try {
                        psRobotResult = this.iPSDevCenter.getValidPSDCRobot(iPSSysDevBKTask);
                        if (psRobotResult != null && psRobotResult.getEnerge() >= 0) break block8;
                        iPSSysDevBKTask.setPlanPSRobot(psRobotResult);
                        return false;
                    }
                    catch (Exception ex) {
                        log.error((Object)"\u83b7\u53d6\u5f53\u524d\u53ef\u7528\u673a\u5668\u4eba\u53d1\u751f\u9519\u8bef", (Throwable)ex);
                        throw new Exception("\u5206\u914d\u4efb\u52a1\u673a\u5668\u4eba\u53d1\u751f\u9519\u8bef");
                    }
                }
                if (psRobotResult.getPSRobot().addPSRobotWorks(new IPSRobotWork[]{iPSSysDevBKTask})) break block9;
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
        if (iPSBKTask != null) {
            try {
                this.activePSDevSlnSys();
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.format((String)"\u6fc0\u6d3b\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        super.onSetQueuePos(nPos, nTotal, iPSBKTask);
    }

    protected boolean activePSDevSlnSys() throws Exception {
        long nCurTime = System.currentTimeMillis();
        if (this.nLastActiveTime + 10000L < nCurTime) {
            if (this.isDynaInstMode()) {
                IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = this.getPSModelStorage().getCachePSDevSlnSysDynaInst(this.getPSDynaInstId());
                if (iPSDevSlnSysDynaInst != null && iPSDevSlnSysDynaInst.getPSDevSlnSys() != null) {
                    iPSDevSlnSysDynaInst.getPSDevSlnSys().active();
                }
                this.nLastActiveTime = System.currentTimeMillis();
                return iPSDevSlnSysDynaInst != null;
            }
            IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getCachePSDevSlnSys(this.strPSDevSlnSysId);
            if (iPSDevSlnSys != null) {
                iPSDevSlnSys.active();
            }
            this.nLastActiveTime = System.currentTimeMillis();
            return iPSDevSlnSys != null;
        }
        return true;
    }

    @Override
    public IPSDevCenter getPSDevCenter() {
        return this.iPSDevCenter;
    }
}
