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
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDSBooking
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDSBookingLog
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingLogService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.Deploy.IPSDevServerType;
import SA.SRFDA.PS.Core.ResBooking.IPSDSBooking;
import SA.SRFDA.PS.Core.ResBooking.IPSResBookingDispatcherContext;
import SA.SRFDA.PS.Core.ResBooking.PSResBookingImplBase;
import SA.SRFDA.PS.Core.Util.PasswordHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.Random;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDSBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDSBookingLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDSBookingImpl
extends PSResBookingImplBase
implements IPSDSBooking {
    private static final Log log = LogFactory.getLog(PSDSBookingImpl.class);
    private PSDSBooking psDSBooking = null;
    private PSDSBookingService psDSBookingService = null;
    private PSDSBookingLogService psDSBookingLogService = null;
    private PSDevServerService psDevServerService = null;
    private PSDevServer psDevServer = new PSDevServer();
    private static Random random = new Random();

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSResBookingDispatcherContext iPSResBookingDispatcherContext, IEntity iEntity) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSResBookingDispatcherContext(iPSResBookingDispatcherContext);
        this.psDSBookingService = (PSDSBookingService)ServiceGlobal.getService(PSDSBookingService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.psDSBookingLogService = (PSDSBookingLogService)ServiceGlobal.getService(PSDSBookingLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.psDevServerService = (PSDevServerService)ServiceGlobal.getService(PSDevServerService.class, (SessionFactory)PSDevServerService.getCurMajorSessionFactory());
        this.syncEntity(iEntity);
        this.onInit();
    }

    @Override
    public void syncEntity(IEntity iEntity) throws Exception {
        boolean bFirst;
        boolean bl = bFirst = this.psDSBooking == null;
        if (iEntity instanceof PSDSBooking) {
            this.psDSBooking = (PSDSBooking)iEntity;
        } else {
            PSDSBooking psDSBooking = new PSDSBooking();
            iEntity.copyTo((IDataObject)psDSBooking, false);
            this.psDSBooking = psDSBooking;
        }
        this.setResBookingData((IEntity)this.psDSBooking);
        if (bFirst) {
            this.setId(this.psDSBooking.getPSDSBookingId());
            this.setName(this.psDSBooking.getPSDSBookingName());
            this.setBeginTime(this.psDSBooking.getBeginTime().getTime());
            this.setEndTime(this.psDSBooking.getEndTime().getTime());
            this.psDevServer.setPSDevServerId(this.psDSBooking.getPSDevServerId());
            this.psDevServerService.get(this.psDevServer);
            this.setBookingResType(this.psDevServer.getTimeShareResType());
            this.setPSBookingResType(this.getPSModelStorage().getPSBookingResType(this.getBookingResType(), false));
        }
        this.setState(this.psDSBooking.getBookingState());
        this.setLastUpdateTime(this.psDSBooking.getUpdateDate());
    }

    @Override
    protected void onGotoState(int nNewState, int nOldState) {
        PSDSBookingLog psDSBookingLog;
        PSDSBooking psDSBooking = new PSDSBooking();
        try {
            psDSBooking.setPSDSBookingId(this.getId());
            EntityBase.setLastUpdateDate((IEntity)psDSBooking, (Timestamp)this.getLastUpdateTime());
            this.psDSBookingService.update(psDSBooking);
            this.setLastUpdateTime(psDSBooking.getUpdateDate());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0[%1$s][%2$s]\u72b6\u6001\u5f02\u5e38\uff0c%3$s", (Object)this.getBookingResType(), (Object)this.getId(), (Object)ex.getMessage()), (Throwable)ex);
            return;
        }
        if (nNewState == 15 || nNewState == 25) {
            psDSBookingLog = new PSDSBookingLog();
            psDSBookingLog.setPSDSBookingLogId(this.getId());
            psDSBookingLog.setPSDSBookingLogName(this.getName());
            try {
                this.psDSBooking.copyTo((IDataObject)psDSBookingLog, false);
                psDSBookingLog.setPSTaskServerId(this.getPSModelStorage().getPSTaskServerEnv().getId());
                psDSBookingLog.setPSTaskServerName(this.getPSModelStorage().getPSTaskServerEnv().getName());
                psDSBooking.reset();
                psDSBooking.setPSDSBookingId(this.getId());
                psDSBooking.setBookingState(Integer.valueOf(nNewState));
                this.psDSBookingService.update(psDSBooking);
                this.syncEntity((IEntity)psDSBooking);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
            try {
                this.psDSBookingLogService.save(psDSBookingLog);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        if (nNewState == 20 || nNewState == 30) {
            block16: {
                psDSBookingLog = new PSDSBookingLog();
                psDSBookingLog.setPSDSBookingLogId(this.getId());
                psDSBookingLog.setPSDSBookingLogName(this.getName());
                try {
                    this.psDSBooking.copyTo((IDataObject)psDSBookingLog, false);
                    psDSBookingLog.setPSTaskServerId(this.getPSModelStorage().getPSTaskServerEnv().getId());
                    psDSBookingLog.setPSTaskServerName(this.getPSModelStorage().getPSTaskServerEnv().getName());
                    PSDevServer psDevServer2 = new PSDevServer();
                    psDevServer2.setPSDevServerId(this.psDevServer.getPSDevServerId());
                    psDevServer2.setPasswd(PasswordHelper.generate());
                    this.psDevServerService.update(psDevServer2);
                    this.psDevServer = psDevServer2;
                    IPSDevServerType iPSDevServerType = this.getPSModelStorage().getPSDevServerType(this.psDevServer.getDSType());
                    SA.SRFDA.PS.Data.PSDevServer psDevServerV3 = new SA.SRFDA.PS.Data.PSDevServer();
                    PSDEDataCtrl.convertEntity((IEntity)this.psDevServer, psDevServerV3);
                    if (nNewState == 20) {
                        iPSDevServerType.initBookingRes(psDevServerV3);
                        this.linkPSDevCenterServer(true, nNewState);
                        psDSBookingLog.setRestoreState(Integer.valueOf(1));
                        psDSBookingLog.setBookingState(Integer.valueOf(nNewState));
                    } else if (nNewState == 30) {
                        iPSDevServerType.uninitBookingRes(psDevServerV3);
                        this.linkPSDevCenterServer(false, nNewState);
                        psDSBookingLog.setBackupState(Integer.valueOf(1));
                        psDSBookingLog.setBookingState(Integer.valueOf(nNewState));
                    }
                }
                catch (Exception ex) {
                    if (nNewState == 20) {
                        psDSBookingLog.setRestoreState(Integer.valueOf(2));
                        psDSBookingLog.setRestoreInfo(ex.getMessage());
                    }
                    if (nNewState != 30) break block16;
                    psDSBookingLog.setBackupState(Integer.valueOf(2));
                    psDSBookingLog.setBackupInfo(ex.getMessage());
                }
            }
            try {
                this.psDSBookingLogService.save(psDSBookingLog);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    protected void linkPSDevCenterServer(boolean bBind, int nNewState) throws Exception {
        PSDevServer psDevServer = this.psDevServer;
        SessionFactoryManager.addRef();
        try {
            PSDevCenterServerService psDevCenterServerService = (PSDevCenterServerService)ServiceGlobal.getService(PSDevCenterServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevCenterServer psDevCenterServer = new PSDevCenterServer();
            psDevCenterServer.setPSDevCenterServerId(this.psDSBooking.getPSDevCenterServerId());
            if (bBind) {
                psDevCenterServer.setPSDevServerId(psDevServer.getPSDevServerId());
                psDevCenterServer.setPSDevServerName(psDevServer.getPSDevServerName());
                psDevCenterServer.setExpriedTime(new Timestamp(this.getEndTime()));
                psDevCenterServer.setHostAddress(psDevServer.getIpAddr());
                psDevCenterServer.setHostUserName(psDevServer.getUserName());
                psDevCenterServer.setHostPasswd(psDevServer.getPasswd());
                psDevCenterServer.setResReadyTime(null);
                psDevCenterServer.setResState(Integer.valueOf(20));
                psDevCenterServerService.update(psDevCenterServer);
            } else {
                psDevCenterServer.setPSDevServerId(null);
                psDevCenterServer.setPSDevServerName(null);
                psDevCenterServer.setExpriedTime(null);
                psDevCenterServer.setHostAddress(null);
                psDevCenterServer.setHostUserName(null);
                psDevCenterServer.setHostPasswd(null);
                psDevCenterServer.setResState(Integer.valueOf(42));
                psDevCenterServerService.update(psDevCenterServer);
            }
            PSDSBooking psDSBooking = new PSDSBooking();
            psDSBooking.setPSDSBookingId(this.getId());
            psDSBooking.setBookingState(Integer.valueOf(nNewState));
            this.psDSBookingService.update(psDSBooking);
            this.syncEntity((IEntity)psDSBooking);
            SessionFactoryManager.releaseRef((boolean)true);
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }
}
