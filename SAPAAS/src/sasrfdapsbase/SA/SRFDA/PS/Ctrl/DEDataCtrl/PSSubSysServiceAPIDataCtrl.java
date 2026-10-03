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
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService
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
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSubSysServiceAPI;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubSysServiceAPIService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSubSysServiceAPIDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSubSysServiceAPIDataCtrl.class);
    public static final String CUSTOMCALL_ADDSYNCSADEMODELTASK = "ADDSYNCSADEMODELTASK";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDSYNCSADEMODELTASK, (boolean)true) == 0) {
            return this.addSyncSADEModelTask(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult addSyncSADEModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSSubSysServiceAPI psSubSysServiceAPI = new SA.SRFDA.PS.Data.PSSubSysServiceAPI();
            psSubSysServiceAPI.proxy(dataEntity);
            this.onAddSyncSADEModelTask(psSubSysServiceAPI);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5916\u90e8\u7cfb\u7edf\u63a5\u53e3\u5b9e\u4f53\u540c\u6b65\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddSyncSADEModelTask(SA.SRFDA.PS.Data.PSSubSysServiceAPI psSubSysServiceAPI) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psSubSysServiceAPI.getParamStringValue("PSDEVSLNSYSID", "");
        if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            return;
        }
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        PSSubSysServiceAPIService psSubSysServiceAPIService = (PSSubSysServiceAPIService)ServiceGlobal.getService(PSSubSysServiceAPIService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        PSSubSysServiceAPI psSubSysServiceAPI2 = new PSSubSysServiceAPI();
        psSubSysServiceAPI2.setPSSubSysServiceAPIId(psSubSysServiceAPI.getPSSUBSYSSERVICEAPIID());
        psSubSysServiceAPIService.get(psSubSysServiceAPI2);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65[%1$s]\u63a5\u53e3\u5b9e\u4f53\u6a21\u578b", (Object)psSubSysServiceAPI2.getPSSubSysServiceAPIName()));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("SYNCSUBSYSSADEMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psSubSysServiceAPI.getPSSUBSYSSERVICEAPIID());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create(psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSSubSysServiceAPIDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }
}
