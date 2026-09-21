/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterASBase
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSASBooking
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSASBookingLog
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServerBase
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst
 *  net.ibizsys.pscore.srv.paasmgr.service.PSASBookingLogService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.ResBooking;

import SA.SRFDA.PS.Core.Deploy.IPSAppServerType;
import SA.SRFDA.PS.Core.ResBooking.IPSASBooking;
import SA.SRFDA.PS.Core.ResBooking.IPSResBookingDispatcherContext;
import SA.SRFDA.PS.Core.ResBooking.PSResBookingImplBase;
import SA.SRFDA.PS.Core.Util.PasswordHelper;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterASBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSASBooking;
import net.ibizsys.pscore.srv.paasmgr.entity.PSASBookingLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServerBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSASBookingImpl
extends PSResBookingImplBase
implements IPSASBooking {
    private static final Log log = LogFactory.getLog(PSASBookingImpl.class);
    private PSASBooking psASBooking = null;
    private PSASBookingService psASBookingService = null;
    private PSASBookingLogService psASBookingLogService = null;
    private PSAppServerService psAppServerService = null;
    private PSDBDevInstService psDBDevInstService = null;
    private PSAppServer psAppServer = new PSAppServer();
    private static Random random = new Random();
    private String strNewASPassword = null;

    @Override
    public void init(ISRFDAGlobalHelper iDAGlobalHelper, IPSResBookingDispatcherContext iPSResBookingDispatcherContext, IEntity iEntity) throws Exception {
        this.setDAGlobalHelper(iDAGlobalHelper);
        this.setPSResBookingDispatcherContext(iPSResBookingDispatcherContext);
        this.psASBookingService = (PSASBookingService)ServiceGlobal.getService(PSASBookingService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.psASBookingLogService = (PSASBookingLogService)ServiceGlobal.getService(PSASBookingLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.psAppServerService = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.psDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        this.syncEntity(iEntity);
        this.onInit();
    }

    @Override
    public void syncEntity(IEntity iEntity) throws Exception {
        boolean bFirst;
        boolean bl = bFirst = this.psASBooking == null;
        if (iEntity instanceof PSASBooking) {
            this.psASBooking = (PSASBooking)iEntity;
        } else {
            PSASBooking psASBooking = new PSASBooking();
            iEntity.copyTo((IDataObject)psASBooking, false);
            this.psASBooking = psASBooking;
        }
        this.setResBookingData((IEntity)this.psASBooking);
        if (bFirst) {
            this.setId(this.psASBooking.getPSASBookingId());
            this.setName(this.psASBooking.getPSASBookingName());
            this.setBeginTime(this.psASBooking.getBeginTime().getTime());
            this.setEndTime(this.psASBooking.getEndTime().getTime());
            this.psAppServer.setPSAppServerId(this.psASBooking.getPSAppServerId());
            this.psAppServerService.get((IEntity)this.psAppServer);
            this.setBookingResType(this.psAppServer.getTimeShareResType());
            this.setPSBookingResType(this.getPSModelStorage().getPSBookingResType(this.getBookingResType(), false));
        }
        this.setState(this.psASBooking.getBookingState());
        this.setLastUpdateTime(this.psASBooking.getUpdateDate());
    }

    @Override
    protected void onGotoState(int nNewState, int nOldState) {
        PSASBookingLog psASBookingLog;
        PSASBooking psASBooking = new PSASBooking();
        try {
            psASBooking.setPSASBookingId(this.getId());
            EntityBase.setLastUpdateDate((IEntity)psASBooking, (Timestamp)this.getLastUpdateTime());
            this.psASBookingService.update((IEntity)psASBooking);
            this.setLastUpdateTime(psASBooking.getUpdateDate());
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0[%1$s][%2$s]\u72b6\u6001\u5f02\u5e38\uff0c%3$s", (Object)this.getBookingResType(), (Object)this.getId(), (Object)ex.getMessage()), (Throwable)ex);
            return;
        }
        if (nNewState == 15 || nNewState == 25) {
            psASBookingLog = new PSASBookingLog();
            psASBookingLog.setPSASBookingLogId(this.getId());
            psASBookingLog.setPSASBookingLogName(this.getName());
            try {
                this.psASBooking.copyTo((IDataObject)psASBookingLog, false);
                psASBookingLog.setPSTaskServerId(this.getPSModelStorage().getPSTaskServerEnv().getId());
                psASBookingLog.setPSTaskServerName(this.getPSModelStorage().getPSTaskServerEnv().getName());
                psASBooking.reset();
                psASBooking.setPSASBookingId(this.getId());
                psASBooking.setBookingState(Integer.valueOf(nNewState));
                this.psASBookingService.update((IEntity)psASBooking);
                this.syncEntity((IEntity)psASBooking);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
            try {
                this.psASBookingLogService.save((IEntity)psASBookingLog);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
        if (nNewState == 20 || nNewState == 30) {
            block17: {
                psASBookingLog = new PSASBookingLog();
                psASBookingLog.setPSASBookingLogId(this.getId());
                psASBookingLog.setPSASBookingLogName(this.getName());
                try {
                    this.psASBooking.copyTo((IDataObject)psASBookingLog, false);
                    psASBookingLog.setPSTaskServerId(this.getPSModelStorage().getPSTaskServerEnv().getId());
                    psASBookingLog.setPSTaskServerName(this.getPSModelStorage().getPSTaskServerEnv().getName());
                    PSAppServer psAppServer2 = new PSAppServer();
                    psAppServer2.setPSAppServerId(this.psAppServer.getPSAppServerId());
                    psAppServer2.setPasswd(PasswordHelper.generate());
                    int nStartPort = DataObject.getIntegerValue((Object)this.psAppServer.getBeginPort(), (Integer)8080);
                    int nEndPort = DataObject.getIntegerValue((Object)this.psAppServer.getEndPort(), (Integer)18080);
                    int nHttpPort = nStartPort + random.nextInt(nEndPort - nStartPort);
                    psAppServer2.setHttpPort(Integer.valueOf(nHttpPort));
                    this.psAppServerService.update((IEntity)psAppServer2);
                    ArrayList psDBDevInstList = this.psDBDevInstService.selectByPSAppServer((PSAppServerBase)psAppServer2);
                    for (PSDBDevInst psDBDevInst : psDBDevInstList) {
                        PSDBDevInst psDBDevInst2 = new PSDBDevInst();
                        psDBDevInst2.setPSDBDevInstId(psDBDevInst.getPSDBDevInstId());
                        psDBDevInst2.setPasswd(PasswordHelper.generate());
                        this.psDBDevInstService.update((IEntity)psDBDevInst2, false);
                    }
                    this.psAppServer = psAppServer2;
                    IPSAppServerType iPSAppServerType = this.getPSModelStorage().getPSAppServerType(this.psAppServer.getASType());
                    SA.SRFDA.PS.Data.PSAppServer psAppServerV3 = new SA.SRFDA.PS.Data.PSAppServer();
                    PSDEDataCtrl.convertEntity((IEntity)this.psAppServer, psAppServerV3);
                    if (nNewState == 20) {
                        iPSAppServerType.initBookingRes(psAppServerV3);
                        this.linkPSDevCenterAS(true, nNewState);
                        psASBookingLog.setRestoreState(Integer.valueOf(1));
                        psASBookingLog.setBookingState(Integer.valueOf(nNewState));
                    } else if (nNewState == 30) {
                        iPSAppServerType.uninitBookingRes(psAppServerV3);
                        this.linkPSDevCenterAS(false, nNewState);
                        psASBookingLog.setBackupState(Integer.valueOf(1));
                        psASBookingLog.setBookingState(Integer.valueOf(nNewState));
                    }
                }
                catch (Exception ex) {
                    if (nNewState == 20) {
                        psASBookingLog.setRestoreState(Integer.valueOf(2));
                        psASBookingLog.setRestoreInfo(ex.getMessage());
                    }
                    if (nNewState != 30) break block17;
                    psASBookingLog.setBackupState(Integer.valueOf(2));
                    psASBookingLog.setBackupInfo(ex.getMessage());
                }
            }
            try {
                this.psASBookingLogService.save((IEntity)psASBookingLog);
            }
            catch (Exception ex) {
                log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u8d44\u6e90\u9884\u7ea6\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            }
        }
    }

    protected void linkPSDevCenterAS(boolean bBind, int nNewState) throws Exception {
        PSAppServer psAppServer = this.psAppServer;
        SessionFactoryManager.addRef();
        try {
            PSDevCenterASService psDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevCenterDBInstService psDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDevCenterAS psDevCenterAS = new PSDevCenterAS();
            psDevCenterAS.setPSDevCenterASId(this.psASBooking.getPSDevCenterASId());
            ArrayList psDevCenterDBInstList = psDevCenterDBInstService.selectByPSDevCenterAS((PSDevCenterASBase)psDevCenterAS);
            if (bBind) {
                PSDBDevInstService psDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
                ArrayList psDBDevInstList = psDBDevInstService.selectByPSAppServer((PSAppServerBase)psAppServer);
                HashMap<String, PSDevCenterDBInst> psDevCenterDBInstMap = new HashMap<String, PSDevCenterDBInst>();
                for (PSDevCenterDBInst psDevCenterDBInst : psDevCenterDBInstList) {
                    psDevCenterDBInstMap.put(psDevCenterDBInst.getDBType(), psDevCenterDBInst);
                }
                for (PSDBDevInst psDBDevInst : psDBDevInstList) {
                    PSDevCenterDBInst psDevCenterDBInst = (PSDevCenterDBInst)psDevCenterDBInstMap.get(psDBDevInst.getDBType());
                    if (psDevCenterDBInst == null) {
                        throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u627e\u5230\u5206\u65f6\u8d44\u6e90[%1$s]\u5bf9\u5e94\u7684[%2$s]\u5e94\u7528\u4e2d\u5fc3\u6570\u636e\u5e93\u5b9e\u4f8b", (Object)this.psASBooking.getPSDevCenterASName(), (Object)psDBDevInst.getDBType()));
                    }
                    String psDevCenterDBInstId = psDevCenterDBInst.getPSDevCenterDBInstId();
                    psDevCenterDBInst.reset();
                    psDevCenterDBInst.setPSDevCenterDBInstId(psDevCenterDBInstId);
                    psDevCenterDBInst.setDBName(psDBDevInst.getDBName());
                    psDevCenterDBInst.setPSDBDevInstId(psDBDevInst.getPSDBDevInstId());
                    psDevCenterDBInst.setPSDBDevInstName(psDBDevInst.getPSDBDevInstName());
                    psDevCenterDBInst.setUserName(psDBDevInst.getUserName());
                    psDevCenterDBInst.setPasswd(psDBDevInst.getPasswd());
                    psDevCenterDBInst.setExpriedTime(new Timestamp(this.getEndTime()));
                    psDevCenterDBInst.setResReadyTime(null);
                    psDevCenterDBInst.setResState(Integer.valueOf(20));
                    if (!StringHelper.IsNullOrEmpty((String)psDBDevInst.getConnStrFmt())) {
                        psDevCenterDBInst.setConnStr(StringHelper.Format((String)psDBDevInst.getConnStrFmt(), (Object)psDevCenterDBInst.getUserName(), (Object)psDevCenterDBInst.getPasswd()));
                    } else {
                        psDevCenterDBInst.setConnStr(psDBDevInst.getConnStr());
                    }
                    psDevCenterDBInstService.update((IEntity)psDevCenterDBInst, false);
                }
                psDevCenterAS.setPSAppServerId(psAppServer.getPSAppServerId());
                psDevCenterAS.setPSAppServerName(psAppServer.getPSAppServerName());
                psDevCenterAS.setExpriedTime(new Timestamp(this.getEndTime()));
                if (StringHelper.IsNullOrEmpty((String)psAppServer.getSSHIPAddr())) {
                    psDevCenterAS.setHostAddress(psAppServer.getIpAddr());
                } else {
                    psDevCenterAS.setHostAddress(psAppServer.getSSHIPAddr());
                }
                psDevCenterAS.setHostUserName(psAppServer.getUserName());
                psDevCenterAS.setHostPasswd(psAppServer.getPasswd());
                psDevCenterAS.setHostPort(psAppServer.getSSHPort());
                if (psAppServer.getHttpPort() != null) {
                    psDevCenterAS.setHttpPort(psAppServer.getHttpPort());
                }
                if (psAppServer.getHttpsPort() != null) {
                    psDevCenterAS.setHttpsPort(psAppServer.getHttpsPort());
                }
                psDevCenterAS.setResReadyTime(null);
                psDevCenterAS.setResState(Integer.valueOf(20));
                psDevCenterASService.update((IEntity)psDevCenterAS);
            } else {
                for (PSDevCenterDBInst psDevCenterDBInst : psDevCenterDBInstList) {
                    String psDevCenterDBInstId = psDevCenterDBInst.getPSDevCenterDBInstId();
                    psDevCenterDBInst.reset();
                    psDevCenterDBInst.setPSDevCenterDBInstId(psDevCenterDBInstId);
                    psDevCenterDBInst.setDBName(null);
                    psDevCenterDBInst.setPSDBDevInstId(null);
                    psDevCenterDBInst.setPSDBDevInstName(null);
                    psDevCenterDBInst.setUserName(null);
                    psDevCenterDBInst.setPasswd(null);
                    psDevCenterDBInst.setExpriedTime(null);
                    psDevCenterDBInst.setConnStr(null);
                    psDevCenterDBInst.setResState(Integer.valueOf(42));
                    psDevCenterDBInstService.update((IEntity)psDevCenterDBInst, false);
                }
                psDevCenterAS.setPSAppServerId(null);
                psDevCenterAS.setPSAppServerName(null);
                psDevCenterAS.setExpriedTime(null);
                psDevCenterAS.setHostAddress(null);
                psDevCenterAS.setHostUserName(null);
                psDevCenterAS.setHostPasswd(null);
                psDevCenterAS.setHostPort(null);
                psDevCenterAS.setResState(Integer.valueOf(42));
                psDevCenterASService.update((IEntity)psDevCenterAS);
            }
            PSASBooking psASBooking = new PSASBooking();
            psASBooking.setPSASBookingId(this.getId());
            psASBooking.setBookingState(Integer.valueOf(nNewState));
            this.psASBookingService.update((IEntity)psASBooking);
            this.syncEntity((IEntity)psASBooking);
            SessionFactoryManager.releaseRef((boolean)true);
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
    }
}

