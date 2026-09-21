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
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService
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
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBakLink;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysBakDataCtrl
extends PSDEDataCtrl {
    public static final String CUSTOMCALL_ADDRESTORESYSMODELTASK = "ADDRESTORESYSMODELTASK";
    private static final Log log = LogFactory.getLog(PSDevSlnSysBakDataCtrl.class);

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDRESTORESYSMODELTASK, (boolean)true) == 0) {
            return this.addRestoreSysModelTask(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult addRestoreSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysBakDataCtrl.this.onAddRestoreSysModelTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u6062\u590d\u5f00\u53d1\u7cfb\u7edf\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddRestoreSysModelTask(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSysBak);
        psDevSlnSysBakService.get((IEntity)psDevSlnSysBak);
        if (DataObject.getIntegerValue((Object)psDevSlnSysBak.getBackupState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u6062\u590d\u4efb\u52a1", (Object)psDevSlnSysBak.getPSDevSlnSysBakName(), (Object)DBInstBStateCodeListModel.getInstance().getCodeItem(psDevSlnSysBak.getBackupState().toString()).getText()));
        }
        if (DataObject.getBoolValue((Integer)psDevSlnSysBak.getLinkFlag(), (boolean)false)) {
            PSDevSlnSysBakLinkService psDevSlnSysBakLinkService = (PSDevSlnSysBakLinkService)ServiceGlobal.getService(PSDevSlnSysBakLinkService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevSlnSysBakLink psDevSlnSysBakLink = new PSDevSlnSysBakLink();
            psDevSlnSysBakLink.setPSDevSlnSysBakLinkId(psDevSlnSysBak.getPSDevSlnSysBakId());
            if (!psDevSlnSysBakLinkService.get((IEntity)psDevSlnSysBakLink, true)) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u65e0\u6cd5\u83b7\u53d6\u5907\u4efd\u94fe\u63a5\uff0c\u65e0\u6cd5\u5efa\u7acb\u6062\u590d\u4efb\u52a1", (Object)psDevSlnSysBak.getPSDevSlnSysBakName()));
            }
            if (DataObject.getIntegerValue((Object)psDevSlnSysBakLink.getLinkState(), (Integer)30) != 30) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u5f15\u7528\u7684\u5907\u4efd\u94fe\u63a5\u65e0\u6548\uff0c\u65e0\u6cd5\u5efa\u7acb\u6062\u590d\u4efb\u52a1", (Object)psDevSlnSysBak.getPSDevSlnSysBakName()));
            }
            if (DataObject.getIntegerValue((Object)psDevSlnSysBakLink.getPSDevSlnSysBak().getBackupState(), (Integer)30) != 30) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u5f15\u7528\u7684\u5907\u4efd\u94fe\u63a5\u65e0\u6548\uff0c\u5907\u4efd\u72b6\u6001\u4e0d\u6b63\u786e\uff0c\u65e0\u6cd5\u5efa\u7acb\u6062\u590d\u4efb\u52a1", (Object)psDevSlnSysBak.getPSDevSlnSysBakName()));
            }
            if (psDevSlnSysBakLink.getBeginTime() != null && System.currentTimeMillis() < psDevSlnSysBakLink.getBeginTime().getTime()) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u5f15\u7528\u7684\u5907\u4efd\u94fe\u63a5\u65e0\u6548\uff0c\u4e0d\u5728\u6388\u6743\u5f00\u59cb\u65f6\u95f4\u8303\u56f4\u5185\uff0c\u65e0\u6cd5\u5efa\u7acb\u6062\u590d\u4efb\u52a1", (Object)psDevSlnSysBak.getPSDevSlnSysBakName()));
            }
            if (psDevSlnSysBakLink.getEndTime() != null && System.currentTimeMillis() > psDevSlnSysBakLink.getEndTime().getTime()) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u5907\u4efd[%1$s]\u5f15\u7528\u7684\u5907\u4efd\u94fe\u63a5\u65e0\u6548\uff0c\u4e0d\u5728\u6388\u6743\u7ed3\u675f\u65f6\u95f4\u8303\u56f4\u5185\uff0c\u65e0\u6cd5\u5efa\u7acb\u6062\u590d\u4efb\u52a1", (Object)psDevSlnSysBak.getPSDevSlnSysBakName()));
            }
        }
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        psDevSlnSys.setPSDevSlnSysId(psDevSlnSysBak.getPSDevSlnSysId());
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e3a\u5171\u4eab\u6a21\u578b\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5efa\u7acb\u6062\u590d\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u6062\u590d\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u6062\u590d\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("RECOVER");
        psDevSlnSys2.setActionOwner(StringHelper.Format((String)"%1$s|%2$s", (Object)psDevSlnSysBakService.getDEModel().getName(), (Object)psDevSlnSysBak.getPSDevSlnSysBakId()));
        EntityBase.setLastUpdateDate((IEntity)psDevSlnSys2, (Timestamp)psDevSlnSys.getUpdateDate());
        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDevCenterId(psDevSlnSysBak.getPSDevCenterId());
        psDCBKTask.setPSDevCenterName(psDevSlnSysBak.getPSDevCenterName());
        psDCBKTask.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCBKTask.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDCBKTask.setPSDCBKTaskName(psDevSlnSysBak.getPSDevSlnSysBakName());
        psDCBKTask.setOrderValue(Integer.valueOf(100));
        psDCBKTask.setTaskType("RESTOREDEVSLNSYS");
        psDCBKTask.setTaskParam(psDevSlnSysBak.getPSDevSlnSysId());
        psDCBKTask.setTaskParam2(psDevSlnSysBak.getPSDevSlnSysBakId());
        psDCBKTaskService.create((IEntity)psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysBakDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
                }
                catch (Exception ex) {
                    log.error((Object)ex);
                    try {
                        psDevSlnSys2.reset();
                        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
                        psDevSlnSys2.setCurAction("NONE");
                        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, false);
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
}

