/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWSBooking
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWSBookingLog
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingLogService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.ResBooking.IPSResBookingDispatcherContext;
import SA.SRFDA.PS.Core.ResBooking.IPSWorkspaceBooking;
import SA.SRFDA.PS.Core.ResBooking.PSResBookingImplBase;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWSBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWSBookingLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSWorkspaceBookingImpl
extends PSResBookingImplBase
implements IPSWorkspaceBooking {
    private static final Log log = LogFactory.getLog(PSWorkspaceBookingImpl.class);
    private PSWSBooking psWSBooking = null;
    private PSWSBookingService psWSBookingService = null;
    private PSWSBookingLogService psWSBookingLogService = null;
    private PSWorkspaceService psWorkspaceService = null;
    private PSWorkspace psWorkspace = new PSWorkspace();
    private long nLastEndTime = 0L;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSResBookingDispatcherContext iPSResBookingDispatcherContext, IEntity iEntity) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSResBookingDispatcherContext(iPSResBookingDispatcherContext);
        this.psWSBookingService = (PSWSBookingService)ServiceGlobal.getService(PSWSBookingService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.psWSBookingLogService = (PSWSBookingLogService)ServiceGlobal.getService(PSWSBookingLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.syncEntity(iEntity);
        this.onInit();
    }

    @Override
    public void syncEntity(IEntity iEntity) throws Exception {
        boolean bFirst;
        boolean bl = bFirst = this.psWSBooking == null;
        if (iEntity instanceof PSWSBooking) {
            this.psWSBooking = (PSWSBooking)iEntity;
        } else {
            PSWSBooking psWSBooking = new PSWSBooking();
            iEntity.copyTo((IDataObject)psWSBooking, false);
            this.psWSBooking = psWSBooking;
        }
        this.setResBookingData((IEntity)this.psWSBooking);
        if (bFirst) {
            this.setId(this.psWSBooking.getPSWSBookingId());
            this.setName(this.psWSBooking.getPSWSBookingName());
            this.setBeginTime(this.psWSBooking.getBeginTime().getTime());
            this.setEndTime(this.psWSBooking.getEndTime().getTime());
            this.psWorkspace.setPSWorkspaceId(this.psWSBooking.getPSWorkspaceId());
            this.psWorkspaceService.get((IEntity)this.psWorkspace);
            this.setBookingResType("WORKSPACE");
            this.setPSBookingResType(this.getPSModelStorage().getPSBookingResType(this.getBookingResType(), false));
        }
        this.setState(this.psWSBooking.getBookingState());
        this.setLastUpdateTime(this.psWSBooking.getUpdateDate());
        if (this.nLastEndTime != this.psWSBooking.getEndTime().getTime()) {
            try {
                if (!StringHelper.IsNullOrEmpty((String)this.psWSBooking.getPSWorkspaceId())) {
                    PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    PSWorkspace psWorkspace = new PSWorkspace();
                    psWorkspace.setPSWorkspaceId(this.psWSBooking.getPSWorkspaceId());
                    psWorkspace.setExpiredTime(this.psWSBooking.getEndTime());
                    psWorkspaceService.update((IEntity)psWorkspace);
                }
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u751f\u4ea7\u7ebf\u8fc7\u671f\u65f6\u95f4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            }
            try {
                if (!StringHelper.IsNullOrEmpty((String)this.psWSBooking.getPSDCWorkspaceId())) {
                    PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                    PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
                    psDCWorkspace.setPSDCWorkspaceId(this.psWSBooking.getPSDCWorkspaceId());
                    psDCWorkspaceService.get((IEntity)psDCWorkspace);
                    if (!StringHelper.IsNullOrEmpty((String)psDCWorkspace.getPSDevSlnSysId())) {
                        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                        psDevSlnSys.setPSDevSlnSysId(psDCWorkspace.getPSDevSlnSysId());
                        psDevSlnSys.setOfflineTime(this.psWSBooking.getEndTime());
                        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys, true);
                        PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys);
                    }
                }
            }
            catch (Exception ex) {
                throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u79bb\u7ebf\u65f6\u95f4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), ex);
            }
            this.nLastEndTime = this.psWSBooking.getEndTime().getTime();
        }
    }

    @Override
    protected void onGotoState(int nNewState, int nOldState) {
        PSWSBookingLog psWSBookingLog;
        PSWSBooking psWSBooking = new PSWSBooking();
        try {
            psWSBooking.setPSWSBookingId(this.getId());
            EntityBase.setLastUpdateDate((IEntity)psWSBooking, (Timestamp)this.getLastUpdateTime());
            this.psWSBookingService.update((IEntity)psWSBooking);
            this.setLastUpdateTime(psWSBooking.getUpdateDate());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0[%1$s][%2$s]\u72b6\u6001\u5f02\u5e38\uff0c%3$s", (Object)this.getBookingResType(), (Object)this.getId(), (Object)ex.getMessage()), (Throwable)ex);
            return;
        }
        if (nNewState == 15 || nNewState == 25) {
            psWSBookingLog = new PSWSBookingLog();
            psWSBookingLog.setPSWSBookingLogId(this.getId());
            psWSBookingLog.setPSWSBookingLogName(this.getName());
            try {
                this.psWSBooking.copyTo((IDataObject)psWSBookingLog, false);
                psWSBookingLog.setPSTaskServerId(this.getPSModelStorage().getPSTaskServerEnv().getId());
                psWSBookingLog.setPSTaskServerName(this.getPSModelStorage().getPSTaskServerEnv().getName());
                psWSBooking.reset();
                psWSBooking.setPSWSBookingId(this.getId());
                psWSBooking.setBookingState(Integer.valueOf(nNewState));
                this.psWSBookingService.update((IEntity)psWSBooking);
                this.syncEntity((IEntity)psWSBooking);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
            try {
                this.psWSBookingLogService.save((IEntity)psWSBookingLog);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
            if (nNewState == 25) {
                try {
                    if (!StringHelper.IsNullOrEmpty((String)psWSBooking.getPSDCWorkspaceId())) {
                        PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                        PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
                        psDCWorkspace.setPSDCWorkspaceId(psWSBooking.getPSDCWorkspaceId());
                        psDCWorkspaceService.get((IEntity)psDCWorkspace);
                        if (!StringHelper.IsNullOrEmpty((String)psDCWorkspace.getPSDevSlnSysId())) {
                            this.sendStudioConsole(psDCWorkspace.getPSDevSlnSysId(), "WARN", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u4f7f\u7528\u7684\u751f\u4ea7\u7ebf\u5373\u5c06\u88ab\u5173\u95ed"));
                        }
                    }
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u53d1\u9001\u751f\u4ea7\u7ebf\u51c6\u5907\u5173\u95ed\u6d88\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                }
            }
            if (nNewState == 15) {
                try {
                    if (!StringHelper.IsNullOrEmpty((String)psWSBooking.getPSWorkspaceId())) {
                        PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                        PSWorkspace psWorkspace = new PSWorkspace();
                        psWorkspace.setPSWorkspaceId(psWSBooking.getPSWorkspaceId());
                        psWorkspace.setExpiredTime(psWSBooking.getEndTime());
                        psWorkspaceService.update((IEntity)psWorkspace);
                    }
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u751f\u4ea7\u7ebf\u8fc7\u671f\u65f6\u95f4\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                }
            }
        }
        if (nNewState == 20 || nNewState == 30) {
            block33: {
                psWSBookingLog = new PSWSBookingLog();
                psWSBookingLog.setPSWSBookingLogId(this.getId());
                psWSBookingLog.setPSWSBookingLogName(this.getName());
                try {
                    this.psWSBooking.copyTo((IDataObject)psWSBookingLog, false);
                    psWSBookingLog.setPSTaskServerId(this.getPSModelStorage().getPSTaskServerEnv().getId());
                    psWSBookingLog.setPSTaskServerName(this.getPSModelStorage().getPSTaskServerEnv().getName());
                    if (nNewState == 20) {
                        this.linkPSDCWorkspace(true, nNewState);
                        psWSBookingLog.setRestoreState(Integer.valueOf(1));
                        psWSBookingLog.setBookingState(Integer.valueOf(nNewState));
                    } else if (nNewState == 30) {
                        this.linkPSDCWorkspace(false, nNewState);
                        psWSBookingLog.setBackupState(Integer.valueOf(1));
                        psWSBookingLog.setBookingState(Integer.valueOf(nNewState));
                    }
                }
                catch (Exception ex) {
                    if (nNewState == 20) {
                        psWSBookingLog.setRestoreState(Integer.valueOf(2));
                        psWSBookingLog.setRestoreInfo(ex.getMessage());
                    }
                    if (nNewState != 30) break block33;
                    psWSBookingLog.setBackupState(Integer.valueOf(2));
                    psWSBookingLog.setBackupInfo(ex.getMessage());
                }
            }
            try {
                this.psWSBookingLogService.save((IEntity)psWSBookingLog);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
            if (nNewState == 30) {
                PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
                try {
                    if (!StringHelper.IsNullOrEmpty((String)psWSBooking.getPSDCWorkspaceId())) {
                        PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                        psDCWorkspace.setPSDCWorkspaceId(psWSBooking.getPSDCWorkspaceId());
                        psDCWorkspaceService.get((IEntity)psDCWorkspace);
                        if (!StringHelper.IsNullOrEmpty((String)psDCWorkspace.getPSDevSlnSysId())) {
                            this.sendStudioConsole(psDCWorkspace.getPSDevSlnSysId(), "ERROR", StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf\u4f7f\u7528\u7684\u751f\u4ea7\u7ebf\u5df2\u7ecf\u5173\u95ed"));
                        }
                    }
                }
                catch (Exception ex) {
                    log.error((Object)StringHelper.Format((String)"\u53d1\u9001\u751f\u4ea7\u7ebf\u5173\u95ed\u6d88\u606f\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                }
                if (!StringHelper.IsNullOrEmpty((String)psDCWorkspace.getPSDevSlnSysId())) {
                    try {
                        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                        psDevSlnSys.setPSDevSlnSysId(psDCWorkspace.getPSDevSlnSysId());
                        psDevSlnSysService.offline(psDevSlnSys);
                    }
                    catch (Exception ex) {
                        log.error((Object)StringHelper.Format((String)"\u751f\u4ea7\u7ebf\u7cfb\u7edf\u79bb\u7ebf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
                    }
                }
            }
        }
    }

    protected void linkPSDCWorkspace(boolean bBind, int nNewState) throws Exception {
        PSWorkspace psWorkspace = this.psWorkspace;
        SessionFactoryManager.addRef();
        try {
            PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
            psDCWorkspace.setPSDCWorkspaceId(this.psWSBooking.getPSDCWorkspaceId());
            if (bBind) {
                psDCWorkspace.setResState(Integer.valueOf(20));
                psDCWorkspaceService.update((IEntity)psDCWorkspace);
            } else {
                psDCWorkspace.setResState(Integer.valueOf(42));
                psDCWorkspaceService.update((IEntity)psDCWorkspace);
            }
            PSWSBooking psWSBooking = new PSWSBooking();
            psWSBooking.setPSWSBookingId(this.getId());
            psWSBooking.setBookingState(Integer.valueOf(nNewState));
            this.psWSBookingService.update((IEntity)psWSBooking);
            this.syncEntity((IEntity)psWSBooking);
            SessionFactoryManager.releaseRef((boolean)true);
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }
}

