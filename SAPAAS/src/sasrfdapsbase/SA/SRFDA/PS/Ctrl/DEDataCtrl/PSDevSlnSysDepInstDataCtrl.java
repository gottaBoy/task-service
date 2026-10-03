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
 *  net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService
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
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysDepInstDataCtrl
extends PSDEDataCtrl {
    public static final String CUSTOMCALL_ADDSYNCSYSMODELTASK = "ADDSYNCSYSMODELTASK";
    public static final String CUSTOMCALL_CHECKOUTMODEL = "CHECKOUTMODEL";
    private static final Log log = LogFactory.getLog(PSDevSlnSysDepInstDataCtrl.class);

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDSYNCSYSMODELTASK, (boolean)true) == 0) {
            return this.addSyncSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CHECKOUTMODEL, (boolean)true) == 0) {
            return this.checkOutModel(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult addSyncSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDepInstDataCtrl.this.onAddSyncSysModelTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u540c\u6b65\u7cfb\u7edf\u90e8\u7f72\u6a21\u578b\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddSyncSysModelTask(BaseDataEntity dataEntity) throws Exception {
        final PSDevSlnSysDepInst psDevSlnSysDepInst = new PSDevSlnSysDepInst();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDepInst);
        final PSDevSlnSysDepInstService psDevSlnSysDepInstService = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysDepInstService.get(psDevSlnSysDepInst);
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(psDevSlnSysDepInst.getPSDevSlnSysId());
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysService.get(psDevSlnSys);
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u521b\u5efa\u90e8\u7f72\u5b9e\u4f8b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u521b\u5efa\u90e8\u7f72\u5b9e\u4f8b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("CREATEDEPINST");
        psDevSlnSys2.setActionOwner(StringHelper.Format((String)"%1$s|%2$s", (Object)psDevSlnSysDepInstService.getDEModel().getName(), (Object)psDevSlnSysDepInst.getPSDevSlnSysDepInstId()));
        EntityBase.setLastUpdateDate((IEntity)psDevSlnSys2, (Timestamp)psDevSlnSys.getUpdateDate());
        psDevSlnSysService.sysUpdate(psDevSlnSys2, true);
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDevCenterId(psDevSlnSysDepInst.getPSDevCenterId());
        psDCBKTask.setPSDevCenterName(psDevSlnSysDepInst.getPSDevCenterName());
        psDCBKTask.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCBKTask.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDCBKTask.setPSDCBKTaskName(psDevSlnSysDepInst.getPSDevSlnSysDepInstName());
        psDCBKTask.setOrderValue(Integer.valueOf(100));
        psDCBKTask.setTaskType("CREATEDEVSLNSYSDEPINST");
        psDCBKTask.setTaskParam(psDevSlnSysDepInst.getPSDevSlnSysId());
        psDCBKTask.setTaskParam2(psDevSlnSysDepInst.getPSDevSlnSysDepInstId());
        psDCBKTaskService.create(psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDepInstDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                    try {
                        psDevSlnSys2.reset();
                        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
                        psDevSlnSys2.setCurAction("NONE");
                        psDevSlnSysService.sysUpdate(psDevSlnSys2, false);
                    }
                    catch (Exception ex2) {
                        log.error((Object)ex2);
                    }
                    try {
                        String strPSDevSlnSysDepInstId = psDevSlnSysDepInst.getPSDevSlnSysDepInstId();
                        psDevSlnSysDepInst.reset();
                        psDevSlnSysDepInst.setPSDevSlnSysDepInstId(strPSDevSlnSysDepInstId);
                        psDevSlnSysDepInst.setBackupState(DBInstBStateCodeListModel.FAILED);
                        psDevSlnSysDepInstService.sysUpdate(psDevSlnSysDepInst, true);
                    }
                    catch (Exception ex2) {
                        log.error((Object)ex2);
                    }
                }
            }

            public void rollback() {
            }
        });
    }

    public CallResult checkOutModel(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDepInstDataCtrl.this.onCheckOutModel(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u7b7e\u51fa\u90e8\u7f72\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCheckOutModel(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSysDepInst psDevSlnSysDepInst = new PSDevSlnSysDepInst();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysDepInst);
        PSDevSlnSysDepInstService psDevSlnSysDepInstService = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psDevSlnSysDepInstService.checkOutModel(psDevSlnSysDepInst);
    }
}
