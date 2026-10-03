/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
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
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysRef;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysRefDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysRefDataCtrl.class);
    public static final String CUSTOMCALL_ADDIMPSUBSYSMODELTASK = "ADDIMPSUBSYSMODELTASK";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDIMPSUBSYSMODELTASK, (boolean)true) == 0) {
            return this.addImpSubSysModelTask(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult addImpSubSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSysRef psSysRef = new PSSysRef();
            psSysRef.proxy(dataEntity);
            this.onAddImpSubSysModelTask(psSysRef);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5bfc\u5165\u5b50\u7cfb\u7edf\u6a21\u578b\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddImpSubSysModelTask(PSSysRef psSysRef) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psSysRef.getParamStringValue("PSDEVSLNSYSID", "");
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u5bfc\u5165\u5b50\u7cfb\u7edf\u6a21\u578b[%1$s]", (Object)psSysRef.getPSSYSREFNAME()));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("IMPSUBSYSMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(iPSSystem.getId());
        psSysDevBKTask.setTaskParam2(psSysRef.getPSSYSREFID());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create(psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSSysRefDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }
}
