/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDevSysDiffRep;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSysDiffRepDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSDevSysDiffRepDataCtrl.class);
    public static final String CUSTOMCALL_STARTDIFF = "STARTDIFF";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_STARTDIFF, (boolean)true) == 0) {
            return this.startDiff(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult startDiff(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            PSDevSysDiffRep psDevSysDiffRep = new PSDevSysDiffRep();
            psDevSysDiffRep.proxy(dataEntity);
            this.onAddDiffSysModelTask(psDevSysDiffRep);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u6a21\u578b\u5dee\u5f02\u5206\u6790\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddDiffSysModelTask(PSDevSysDiffRep psDevSysDiffRep) throws Exception {
        String strPSDevSlnSysId = psDevSysDiffRep.getParamStringValue("PSDEVSLNSYSID", "");
        String strPSDevCenterId = psDevSysDiffRep.getParamStringValue("PSDEVCENTERID", "");
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem();
        PSSysDevBKTask parentPSSysDevBKTask = null;
        SessionFactoryManager.addRef();
        try {
            PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
            int nTaskOrder = 1;
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"%1$s", (Object)psDevSysDiffRep.getPSDEVSYSDIFFREPNAME()));
            psSysDevBKTask.setTaskType("DIFFSYSMODEL");
            psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
            psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask.setTaskParam(psDevSysDiffRep.getPSDEVSYSDIFFREPID());
            psSysDevBKTask.setTaskParam2(strPSDevCenterId);
            psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
            psSysDevBKTaskService.create(psSysDevBKTask);
            parentPSSysDevBKTask = psSysDevBKTask;
            SessionFactoryManager.releaseRef((boolean)true);
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSDevSysDiffRepDataCtrl.convertEntity((IEntity)parentPSSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }
}
