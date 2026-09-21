/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel
 *  net.ibizsys.pscore.srv.codelist.SVNRepoState2CodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceAction
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceActionService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Workspace.IPSDCWorkspace;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.SVNRepoState2CodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceAction;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceActionService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDCWorkspaceActionDataCtrl
extends PSDEDataCtrl {
    public static final String CUSTOMCALL_ADDDCBKTASK = "ADDDCBKTASK";
    private static final Log log = LogFactory.getLog(PSDCWorkspaceActionDataCtrl.class);

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
                    PSDCWorkspaceActionDataCtrl.this.onAddDCBKTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u4f5c\u4e1a\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddDCBKTask(BaseDataEntity dataEntity) throws Exception {
        PSDCWorkspaceActionService psDCWorkspaceActionService = (PSDCWorkspaceActionService)ServiceGlobal.getService(PSDCWorkspaceActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspaceAction psDCWorkspaceAction = new PSDCWorkspaceAction();
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDCWorkspaceAction);
        psDCWorkspaceActionService.get((IEntity)psDCWorkspaceAction);
        if (DataObject.getIntegerValue((Object)psDCWorkspaceAction.getActionState(), (Integer)10) != 10) {
            throw new Exception(StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u4f5c\u4e1a[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1", (Object)psDCWorkspaceAction.getPSDCWorkspaceActionName(), (Object)BackendActionStateCodeListModel.getInstance().getCodeItem(psDCWorkspaceAction.getActionState().toString()).getText()));
        }
        String strOwnerId = StringHelper.Format((String)"%1$s|%2$s", (Object)psDCWorkspaceActionService.getDEModel().getName(), (Object)psDCWorkspaceAction.getPSDCWorkspaceActionId());
        try {
            psDCWorkspace.setPSDCWorkspaceId(psDCWorkspaceAction.getPSDCWorkspaceId());
            psDCWorkspaceService.get((IEntity)psDCWorkspace);
            if (DataObject.getIntegerValue((Object)psDCWorkspace.getWorkspaceState(), (Integer)30) != 30) {
                throw new Exception(StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1", (Object)psDCWorkspace.getPSDCWorkspaceName(), (Object)SVNRepoState2CodeListModel.getInstance().getCodeItem(psDCWorkspace.getWorkspaceState().toString()).getText()));
            }
            if (!StringHelper.IsNullOrEmpty((String)psDCWorkspace.getCurAction()) && StringHelper.Compare((String)psDCWorkspace.getCurAction(), (String)"NONE", (boolean)true) != 0) {
                throw new Exception(StringHelper.Format((String)"\u4e2d\u5fc3\u751f\u4ea7\u7ebf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u4efb\u52a1", (Object)psDCWorkspace.getPSDCWorkspaceName(), (Object)DCWorkspaceLogTypeCodeListModel.getInstance().getCodeItem(psDCWorkspace.getCurAction()).getText()));
            }
            if (StringHelper.Compare((String)psDCWorkspaceAction.getActionType(), (String)"INSTALLSYS", (boolean)true) == 0) {
                IPSDCWorkspace iPSDCWorkspace = this.getPSModelStorage().getPSDCWorkspace(psDCWorkspaceAction.getPSDCWorkspaceId());
                iPSDCWorkspace.testAction("DCBKTASK", "WORKSPACEACTION", 1, false);
            }
            PSWorkspace psWorkspace2 = new PSWorkspace();
            psWorkspace2.setPSWorkspaceId(psDCWorkspace.getPSWorkspaceId());
            psWorkspace2.setCurAction(psDCWorkspaceAction.getActionType());
            psWorkspace2.setActionOwner(strOwnerId);
            EntityBase.setLastUpdateDate((IEntity)psWorkspace2, (Timestamp)psDCWorkspace.getWorkspaceUpdateDate());
            psWorkspaceService.sysUpdate((IEntity)psWorkspace2, true);
            psDCBKTask.reset();
            psDCBKTask.setPSDevCenterId(psDCWorkspaceAction.getPSDevCenterId());
            psDCBKTask.setPSDevCenterName(psDCWorkspaceAction.getPSDevCenterName());
            psDCBKTask.setPSDevSlnId(psDCWorkspace.getPSDevSlnId());
            psDCBKTask.setPSDevSlnName(psDCWorkspace.getPSDevSlnName());
            psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
            psDCBKTask.setPSDCBKTaskName(psDCWorkspaceAction.getPSDCWorkspaceActionName());
            psDCBKTask.setOrderValue(Integer.valueOf(100));
            psDCBKTask.setTaskType("WORKSPACEACTION");
            psDCBKTask.setTaskParam(psDCWorkspaceAction.getPSDCWorkspaceId());
            psDCBKTask.setTaskParam2(psDCWorkspaceAction.getPSDCWorkspaceActionId());
            psDCBKTaskService.create((IEntity)psDCBKTask);
        }
        catch (Exception ex) {
            String strResult = ex.getMessage();
            if (StringHelper.Length((String)strResult) > 4000) {
                strResult = String.valueOf(strResult.substring(0, 3990)) + "...";
            }
            try {
                PSDCWorkspaceAction psDCWorkspaceAction2 = new PSDCWorkspaceAction();
                psDCWorkspaceAction2.setPSDCWorkspaceActionId(psDCWorkspaceAction.getPSDCWorkspaceActionId());
                psDCWorkspaceAction2.setActionState(Integer.valueOf(40));
                psDCWorkspaceAction2.setActionResult(strResult);
                psDCWorkspaceActionService.update((IEntity)psDCWorkspaceAction2);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            if (!StringHelper.IsNullOrEmpty((String)psDCWorkspace.getPSWorkspaceId())) {
                try {
                    PSWorkspace psWorkspace2 = new PSWorkspace();
                    psWorkspace2.setPSWorkspaceId(psDCWorkspace.getPSWorkspaceId());
                    psWorkspaceService.get((IEntity)psWorkspace2);
                    if (StringHelper.Compare((String)psWorkspace2.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                        psWorkspace2.reset();
                        psWorkspace2.setPSWorkspaceId(psDCWorkspace.getPSWorkspaceId());
                        psWorkspace2.setCurAction(null);
                        psWorkspace2.setActionOwner(null);
                        EntityBase.setLastUpdateDate((IEntity)psWorkspace2, (Timestamp)psDCWorkspace.getWorkspaceUpdateDate());
                        psWorkspaceService.sysUpdate((IEntity)psWorkspace2, true);
                    }
                }
                catch (Exception e) {
                    log.error((Object)e);
                }
            }
            try {
                psDCBKTask.reset();
                psDCBKTask.setPSDevCenterId(psDCWorkspaceAction.getPSDevCenterId());
                psDCBKTask.setPSDevCenterName(psDCWorkspaceAction.getPSDevCenterName());
                psDCBKTask.setPSDevSlnId(psDCWorkspace.getPSDevSlnId());
                psDCBKTask.setPSDevSlnName(psDCWorkspace.getPSDevSlnName());
                psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
                psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
                psDCBKTask.setPSDCBKTaskName(psDCWorkspaceAction.getPSDCWorkspaceActionName());
                psDCBKTask.setOrderValue(Integer.valueOf(100));
                psDCBKTask.setTaskType("WORKSPACEACTION");
                psDCBKTask.setTaskParam(psDCWorkspaceAction.getPSDCWorkspaceId());
                psDCBKTask.setTaskParam2(psDCWorkspaceAction.getPSDCWorkspaceActionId());
                psDCBKTask.setResultInfo(String.valueOf(ex.getMessage()) + "\uff0c\u65e0\u6cd5\u6267\u884c\u4efb\u52a1");
                psDCBKTask.setTaskState(Integer.valueOf(40));
                psDCBKTaskService.create((IEntity)psDCBKTask);
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
                    PSDCWorkspaceActionDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                    try {
                        PSWorkspace psWorkspace2 = new PSWorkspace();
                        psWorkspace2.setPSWorkspaceId(psDCWorkspace.getPSWorkspaceId());
                        psWorkspace2.setCurAction(null);
                        psWorkspace2.setActionOwner(null);
                        EntityBase.setLastUpdateDate((IEntity)psWorkspace2, (Timestamp)psDCWorkspace.getWorkspaceUpdateDate());
                        psWorkspaceService.sysUpdate((IEntity)psWorkspace2, true);
                    }
                    catch (Exception e) {
                        log.error((Object)e);
                    }
                }
            }

            public void rollback() {
            }
        });
    }
}

