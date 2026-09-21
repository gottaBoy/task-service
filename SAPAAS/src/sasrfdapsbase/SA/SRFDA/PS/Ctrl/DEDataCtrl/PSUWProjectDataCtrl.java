/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.UWProjectModeCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWProject
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSUWProjectService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.UWProjectModeCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSUWProject;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSUWProjectService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSUWProjectDataCtrl
extends PSDEDataCtrl {
    public static final String CUSTOMCALL_ADDDCBKTASK = "ADDDCBKTASK";
    private static final Log log = LogFactory.getLog(PSUWProjectDataCtrl.class);

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDDCBKTASK, (boolean)true) == 0) {
            return this.addDCBKTask(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult addDCBKTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSUWProjectDataCtrl.this.onAddDCBKTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u9879\u76ee\u5411\u5bfc\u4f5c\u4e1a\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddDCBKTask(BaseDataEntity dataEntity) throws Exception {
        PSUWProjectService psUWProjectService = (PSUWProjectService)ServiceGlobal.getService(PSUWProjectService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSUWProject psUWProject = new PSUWProject();
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psUWProject);
        psUWProjectService.get((IEntity)psUWProject);
        if (StringHelper.Compare((String)psUWProject.getWizardMode(), (String)"QUICKPF", (boolean)false) != 0 && StringHelper.Compare((String)psUWProject.getWizardMode(), (String)"QUICKSF", (boolean)false) != 0) {
            throw new Exception(StringHelper.Format((String)"\u65b0\u5efa\u9879\u76ee\u5411\u5bfc[%1$s]\u5411\u5bfc\u7c7b\u578b[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1", (Object)psUWProject.getPSUWProjectName(), (Object)UWProjectModeCodeListModel.getInstance().getCodeItem(psUWProject.getWizardMode()).getText()));
        }
        if (DataObject.getIntegerValue((Object)psUWProject.getWizardState(), (Integer)20) != 20) {
            throw new Exception(StringHelper.Format((String)"\u65b0\u5efa\u9879\u76ee\u5411\u5bfc[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1", (Object)psUWProject.getPSUWProjectName(), (Object)BackendActionStateCodeListModel.getInstance().getCodeItem(psUWProject.getWizardState().toString()).getText()));
        }
        try {
            psDCBKTask.reset();
            psDCBKTask.setPSDevCenterId(psUWProject.getPSDevCenterId());
            psDCBKTask.setPSDevCenterName(psUWProject.getPSDevCenterName());
            psDCBKTask.setPSDevSlnId(psUWProject.getPSDevSlnId());
            psDCBKTask.setPSDevSlnName(psUWProject.getPSDevSlnName());
            psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
            psDCBKTask.setPSDCBKTaskName(psUWProject.getPSUWProjectName());
            psDCBKTask.setOrderValue(Integer.valueOf(100));
            psDCBKTask.setTaskType("UWPROJECT");
            psDCBKTask.setTaskParam(psUWProject.getPSUWProjectId());
            psDCBKTaskService.create((IEntity)psDCBKTask);
        }
        catch (Exception ex) {
            String strResult = ex.getMessage();
            if (StringHelper.Length((String)strResult) > 4000) {
                strResult = String.valueOf(strResult.substring(0, 3990)) + "...";
            }
            try {
                PSUWProject psUWProject2 = new PSUWProject();
                psUWProject2.setPSUWProjectId(psUWProject.getPSUWProjectId());
                psUWProject2.setWizardState(Integer.valueOf(40));
                psUWProject2.setErrorInfo(strResult);
                psUWProjectService.update((IEntity)psUWProject2);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            SessionFactoryManager.releaseAndAddRef((boolean)true);
            throw ex;
        }
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSUWProjectDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                }
            }

            public void rollback() {
            }
        });
    }
}

