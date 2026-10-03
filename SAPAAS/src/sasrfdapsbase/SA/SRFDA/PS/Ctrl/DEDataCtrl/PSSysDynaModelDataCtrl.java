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
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysDynaModelDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysDynaModelDataCtrl.class);
    public static final String CUSTOMCALL_ADDIMPORTMODELTASK = "ADDIMPORTMODELTASK";
    public static final String DYNAMODELUSAGE_IMPORTMODEL_PREFIX = "IM_";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDIMPORTMODELTASK, (boolean)true) == 0) {
            return this.addImportModelTask(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult addImportModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSSysDynaModel psSysDynaModel = new SA.SRFDA.PS.Data.PSSysDynaModel();
            psSysDynaModel.proxy(dataEntity);
            this.onAddImportModelTask(psSysDynaModel);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5bfc\u5165\u6a21\u578b\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddImportModelTask(SA.SRFDA.PS.Data.PSSysDynaModel psSysDynaModel) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psSysDynaModel.getParamStringValue("PSDEVSLNSYSID", "");
        if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            return;
        }
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        PSSysDynaModelService psSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        PSSysDynaModel psSysDynaModel2 = new PSSysDynaModel();
        psSysDynaModel2.setPSSysDynaModelId(psSysDynaModel.getPSSYSDYNAMODELID());
        psSysDynaModelService.get(psSysDynaModel2);
        String strUsage = psSysDynaModel2.getDynaModelUsage();
        if (StringHelper.IsNullOrEmpty((String)strUsage) || strUsage.indexOf(DYNAMODELUSAGE_IMPORTMODEL_PREFIX) != 0) {
            throw new Exception(String.format("\u672a\u652f\u6301\u7684\u6a21\u578b\u7528\u9014[%1$s]", strUsage));
        }
        String strTaskType = String.format("IMPORT%1$sMODEL", strUsage.substring(DYNAMODELUSAGE_IMPORTMODEL_PREFIX.length()));
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u5bfc\u5165\u6a21\u578b[%1$s]", (Object)psSysDynaModel2.getPSSysDynaModelName()));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType(strTaskType);
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psSysDynaModel.getPSSYSDYNAMODELID());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create(psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSSysDynaModelDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }
}
