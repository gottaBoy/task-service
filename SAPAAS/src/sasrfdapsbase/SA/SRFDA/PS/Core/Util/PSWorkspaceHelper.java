/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.SVNRepoState2CodeListModel
 *  net.ibizsys.pscore.srv.codelist.SVNRepoStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceAction
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceLog
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceActionService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceLogService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceLog
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceLogService
 *  net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Core.Util;

import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Util.PSDevSlnSysHelper;
import SA.SRFDA.PS.Core.Util.PSSysModelInstHelper;
import java.sql.Timestamp;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DCWorkspaceLogTypeCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.SVNRepoState2CodeListModel;
import net.ibizsys.pscore.srv.codelist.SVNRepoStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceAction;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspaceLog;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceActionService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceLogService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspaceLog;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSWorkspaceHelper {
    private static final Log log = LogFactory.getLog(PSWorkspaceHelper.class);

    public static void startup(String strPSWorkspaceId) throws Exception {
        PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSWorkspace psWorkspace = new PSWorkspace();
        PSWorkspaceLogService psWorkspaceLogService = (PSWorkspaceLogService)ServiceGlobal.getService(PSWorkspaceLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspaceLogService psDCWorkspaceLogService = (PSDCWorkspaceLogService)ServiceGlobal.getService(PSDCWorkspaceLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
        PSWorkspace psWorkspace2 = new PSWorkspace();
        psWorkspace.setPSWorkspaceId(strPSWorkspaceId);
        psWorkspaceService.get(psWorkspace);
        int nWorkspaceState = DataObject.getIntegerValue((Object)psWorkspace.getWorkspaceState(), (Integer)30);
        if (nWorkspaceState == 30) {
            throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u542f\u52a8", (Object)psWorkspace.getPSWorkspaceName(), (Object)SVNRepoState2CodeListModel.getInstance().getCodeItem(Integer.toString(nWorkspaceState)).getText()));
        }
        String strPSDevCenterId = psWorkspace.getPSDevCenterId();
        if (StringHelper.isNullOrEmpty((String)strPSDevCenterId)) {
            throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u672a\u5206\u914d\u5230\u4e2d\u5fc3\uff0c\u65e0\u6cd5\u542f\u52a8", (Object)psWorkspace.getPSWorkspaceName(), (Object)SVNRepoState2CodeListModel.getInstance().getCodeItem(Integer.toString(nWorkspaceState)).getText()));
        }
        String strPSDCWorkspaceId = psWorkspace.getPSDCWorkspaceId();
        if (StringHelper.isNullOrEmpty((String)strPSDCWorkspaceId)) {
            psDCWorkspace.setPSDevCenterId(psWorkspace.getPSDevCenterId());
            psDCWorkspace.setPSDevCenterName(psWorkspace.getPSDevCenterName());
            psDCWorkspace.setPSWorkspaceId(psWorkspace.getPSWorkspaceId());
            psDCWorkspace.setPSWorkspaceName(psWorkspace.getPSWorkspaceName());
            psDCWorkspace.setPSDCWorkspaceName(psWorkspace.getPSWorkspaceName());
            psDCWorkspace.setResState(Integer.valueOf(42));
            psDCWorkspaceService.create(psDCWorkspace);
            strPSDCWorkspaceId = psDCWorkspace.getPSDCWorkspaceId();
            psWorkspace.reset();
            psWorkspace.setPSWorkspaceId(strPSWorkspaceId);
            psWorkspace.setPSDCWorkspaceId(strPSDCWorkspaceId);
            psWorkspaceService.update(psWorkspace);
        }
        PSWorkspaceLog psWorkspaceLog = new PSWorkspaceLog();
        psWorkspaceLog.setPSWorkspaceLogName("\u542f\u52a8\u751f\u4ea7\u7ebf");
        psWorkspaceLog.setPSWorkspaceId(psWorkspace.getPSWorkspaceId());
        psWorkspaceLog.setPSWorkspaceName(psWorkspace.getPSWorkspaceName());
        psWorkspaceLog.setLogType("STARTUP");
        psWorkspaceLog.setLogLevel("INFO");
        psWorkspaceLog.setLogLevel2(Integer.valueOf(20000));
        psWorkspaceLog.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psWorkspaceLog.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psWorkspaceLog.setPSSvrDomainId(psWorkspace.getPSSvrDomainId());
        psWorkspaceLog.setPSSvrDomainName(psWorkspace.getPSSvrDomainName());
        psWorkspaceLogService.create(psWorkspaceLog);
        psWorkspace.reset();
        psWorkspace.setPSWorkspaceId(strPSWorkspaceId);
        psWorkspace.setWorkspaceState(Integer.valueOf(30));
        psWorkspaceService.update(psWorkspace);
        PSDCWorkspaceLog psDCWorkspaceLog = new PSDCWorkspaceLog();
        psDCWorkspaceLog.setPSDCWorkspaceLogName("\u542f\u52a8\u751f\u4ea7\u7ebf");
        psDCWorkspaceLog.setPSDCWorkspaceId(psDCWorkspace.getPSDCWorkspaceId());
        psDCWorkspaceLog.setPSDCWorkspaceName(psDCWorkspace.getPSDCWorkspaceName());
        psDCWorkspaceLog.setPSDevCenterId(psDCWorkspace.getPSDevCenterId());
        psDCWorkspaceLog.setPSDevCenterName(psDCWorkspace.getPSDevCenterName());
        psDCWorkspaceLog.setLogType("STARTUP");
        psDCWorkspaceLog.setLogLevel("INFO");
        psDCWorkspaceLog.setLogLevel2(Integer.valueOf(20000));
        psDCWorkspaceLogService.create(psDCWorkspaceLog);
        PSDCWorkspace psDCWorkspace2 = new PSDCWorkspace();
        psDCWorkspace2.setPSDCWorkspaceId(strPSDCWorkspaceId);
        psDCWorkspace2.setResState(Integer.valueOf(20));
        psDCWorkspaceService.sysUpdate(psDCWorkspace2, false);
    }

    public static void shutdown(String strPSWorkspaceId) throws Exception {
        PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSWorkspace psWorkspace = new PSWorkspace();
        PSWorkspaceLogService psWorkspaceLogService = (PSWorkspaceLogService)ServiceGlobal.getService(PSWorkspaceLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspaceLogService psDCWorkspaceLogService = (PSDCWorkspaceLogService)ServiceGlobal.getService(PSDCWorkspaceLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        psWorkspace.setPSWorkspaceId(strPSWorkspaceId);
        psWorkspaceService.get(psWorkspace);
        int nWorkspaceState = DataObject.getIntegerValue((Object)psWorkspace.getWorkspaceState(), (Integer)30);
        if (nWorkspaceState != 30) {
            throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u8fdb\u884c\u5173\u95ed", (Object)psWorkspace.getPSWorkspaceName(), (Object)SVNRepoState2CodeListModel.getInstance().getCodeItem(Integer.toString(nWorkspaceState)).getText()));
        }
        String strPSDCWorkspaceId = psWorkspace.getPSDCWorkspaceId();
        if (!StringHelper.isNullOrEmpty((String)strPSDCWorkspaceId)) {
            PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
            psDCWorkspace.setPSDCWorkspaceId(strPSDCWorkspaceId);
            psDCWorkspaceService.get(psDCWorkspace);
            String strPSDevSlnSysId = psDCWorkspace.getPSDevSlnSysId();
            if (!StringHelper.isNullOrEmpty((String)strPSDevSlnSysId)) {
                PSWorkspaceHelper.unintallSys(psDCWorkspace);
            }
            PSWorkspaceLog psWorkspaceLog = new PSWorkspaceLog();
            psWorkspaceLog.setPSWorkspaceLogName("\u5173\u95ed\u751f\u4ea7\u7ebf");
            psWorkspaceLog.setPSWorkspaceId(psWorkspace.getPSWorkspaceId());
            psWorkspaceLog.setPSWorkspaceName(psWorkspace.getPSWorkspaceName());
            psWorkspaceLog.setLogType("SHUTDOWN");
            psWorkspaceLog.setLogLevel("INFO");
            psWorkspaceLog.setLogLevel2(Integer.valueOf(20000));
            psWorkspaceLog.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psWorkspaceLog.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
            psWorkspaceLog.setPSSvrDomainId(psWorkspace.getPSSvrDomainId());
            psWorkspaceLog.setPSSvrDomainName(psWorkspace.getPSSvrDomainName());
            psWorkspaceLogService.create(psWorkspaceLog);
            PSWorkspace psWorkspace2 = new PSWorkspace();
            psWorkspace2.setPSWorkspaceId(strPSWorkspaceId);
            psWorkspace2.setWorkspaceState(Integer.valueOf(40));
            psWorkspaceService.update(psWorkspace2);
            PSDCWorkspaceLog psDCWorkspaceLog = new PSDCWorkspaceLog();
            psDCWorkspaceLog.setPSDCWorkspaceLogName("\u5173\u95ed\u751f\u4ea7\u7ebf");
            psDCWorkspaceLog.setPSDCWorkspaceId(psDCWorkspace.getPSDCWorkspaceId());
            psDCWorkspaceLog.setPSDCWorkspaceName(psDCWorkspace.getPSDCWorkspaceName());
            psDCWorkspaceLog.setPSDevCenterId(psDCWorkspace.getPSDevCenterId());
            psDCWorkspaceLog.setPSDevCenterName(psDCWorkspace.getPSDevCenterName());
            psDCWorkspaceLog.setLogType("SHUTDOWN");
            psDCWorkspaceLog.setLogLevel("INFO");
            psDCWorkspaceLog.setLogLevel2(Integer.valueOf(20000));
            psDCWorkspaceLogService.create(psDCWorkspaceLog);
            PSDCWorkspace psDCWorkspace2 = new PSDCWorkspace();
            psDCWorkspace2.setPSDCWorkspaceId(strPSDCWorkspaceId);
            psDCWorkspace2.setResState(Integer.valueOf(40));
            psDCWorkspaceService.sysUpdate(psDCWorkspace2, false);
        } else {
            PSWorkspaceLog psWorkspaceLog = new PSWorkspaceLog();
            psWorkspaceLog.setPSWorkspaceLogName("\u5173\u95ed\u751f\u4ea7\u7ebf");
            psWorkspaceLog.setPSWorkspaceId(psWorkspace.getPSWorkspaceId());
            psWorkspaceLog.setPSWorkspaceName(psWorkspace.getPSWorkspaceName());
            psWorkspaceLog.setLogType("SHUTDOWN");
            psWorkspaceLog.setLogLevel("INFO");
            psWorkspaceLog.setLogLevel2(Integer.valueOf(20000));
            psWorkspaceLog.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psWorkspaceLog.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
            psWorkspaceLog.setPSSvrDomainId(psWorkspace.getPSSvrDomainId());
            psWorkspaceLog.setPSSvrDomainName(psWorkspace.getPSSvrDomainName());
            psWorkspaceLogService.create(psWorkspaceLog);
            PSWorkspace psWorkspace2 = new PSWorkspace();
            psWorkspace2.setPSWorkspaceId(strPSWorkspaceId);
            psWorkspace2.setWorkspaceState(Integer.valueOf(40));
            psWorkspaceService.update(psWorkspace2);
        }
    }

    protected static PSDCWorkspaceAction unintallSys(PSDCWorkspace psDCWorkspace) throws Exception {
        PSDCWorkspaceActionService psDCWorkspaceActionService = (PSDCWorkspaceActionService)ServiceGlobal.getService(PSDCWorkspaceActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspaceAction psDCWorkspaceAction = new PSDCWorkspaceAction();
        psDCWorkspaceAction.setPSDCWorkspaceActionName(StringHelper.format((String)"\u5378\u8f7d\u7cfb\u7edf[%1$s]", (Object)DateHelper.getCurTimeString()));
        psDCWorkspaceAction.setPSDCWorkspaceId(psDCWorkspace.getPSDCWorkspaceId());
        psDCWorkspaceAction.setPSDCWorkspaceName(psDCWorkspace.getPSDCWorkspaceName());
        psDCWorkspaceAction.setPSDevCenterId(psDCWorkspace.getPSDevCenterId());
        psDCWorkspaceAction.setPSDevCenterName(psDCWorkspace.getPSDevCenterName());
        psDCWorkspaceAction.setActionType("UNINSTALLSYS");
        psDCWorkspaceAction.setActionState(BackendActionStateCodeListModel.CREATED);
        psDCWorkspaceAction.setPSDCWorkspaceActionId(psDCWorkspaceAction.getPSDCWorkspaceActionId());
        psDCWorkspaceAction.setPSDCWorkspaceActionName(psDCWorkspaceAction.getPSDCWorkspaceActionName());
        psDCWorkspaceAction.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDCWorkspaceAction.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDCWorkspaceActionService.create(psDCWorkspaceAction, true);
        return PSWorkspaceHelper.executeDCAction(psDCWorkspaceAction);
    }

    public static PSDCWorkspaceAction executeDCAction(PSDCWorkspaceAction psDCWorkspaceAction) throws Exception {
        PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSWorkspaceService psWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspaceActionService psDCWorkspaceActionService = (PSDCWorkspaceActionService)ServiceGlobal.getService(PSDCWorkspaceActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        String strPSDCWorkspaceActionId = psDCWorkspaceAction.getPSDCWorkspaceActionId();
        String strOwnerId = StringHelper.format((String)"%1$s|%2$s", (Object)psDCWorkspaceActionService.getDEModel().getName(), (Object)strPSDCWorkspaceActionId);
        PSWorkspace psWorkspace2 = new PSWorkspace();
        PSDCWorkspace psDCWorkspace = psDCWorkspaceAction.getPSDCWorkspace();
        PSDCWorkspaceAction psDCWorkspaceAction2 = new PSDCWorkspaceAction();
        try {
            PSDCWorkspace psDCWorkspace3 = PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).verifyPSDCWorkspace(psDCWorkspaceAction.getPSDCWorkspaceId());
            if (DataObject.getIntegerValue((Object)psDCWorkspace.getWorkspaceState(), (Integer)30) != 30) {
                throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u8fdb\u884c\u4f5c\u4e1a", (Object)psDCWorkspace.getPSDCWorkspaceName(), (Object)SVNRepoStateCodeListModel.getInstance().getCodeItem(psDCWorkspace.getWorkspaceState().toString()).getText()));
            }
            if (!StringHelper.isNullOrEmpty((String)psDCWorkspace.getCurAction()) && StringHelper.compare((String)psDCWorkspace.getCurAction(), (String)"NONE", (boolean)true) != 0) {
                if (StringHelper.compare((String)psDCWorkspace.getActionOwner(), (String)strOwnerId, (boolean)false) != 0) {
                    throw new Exception(StringHelper.format((String)"\u751f\u4ea7\u7ebf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u4f5c\u4e1a\uff0c\u65e0\u6cd5\u518d\u6b21\u4f5c\u4e1a", (Object)psDCWorkspace.getPSDCWorkspaceName(), (Object)DCWorkspaceLogTypeCodeListModel.getInstance().getCodeItem(psDCWorkspace.getCurAction()).getText()));
                }
            } else {
                psWorkspace2.reset();
                psWorkspace2.setPSWorkspaceId(psDCWorkspace.getPSWorkspaceId());
                psWorkspace2.setCurAction(psDCWorkspaceAction.getActionType());
                psWorkspace2.setActionOwner(strOwnerId);
                psWorkspaceService.sysUpdate(psWorkspace2, false);
            }
            PSWorkspaceHelper.executeDCAction(psDCWorkspace, psDCWorkspaceAction);
            psDCWorkspaceAction2.reset();
            psDCWorkspaceAction2.setPSDCWorkspaceActionId(strPSDCWorkspaceActionId);
            psDCWorkspaceAction2.setEndTime(DateHelper.getCurTime());
            psDCWorkspaceAction2.setActionState(DBInstBStateCodeListModel.CREATED);
            psDCWorkspaceActionService.sysUpdate(psDCWorkspaceAction2, true);
            psDCWorkspace.reset();
            psDCWorkspace.setPSDCWorkspaceId(psDCWorkspaceAction.getPSDCWorkspaceId());
            psDCWorkspaceService.get(psDCWorkspace);
            if (StringHelper.compare((String)psDCWorkspace.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                psWorkspace2.reset();
                psWorkspace2.setPSWorkspaceId(psDCWorkspace.getPSWorkspaceId());
                psWorkspace2.setCurAction(null);
                psWorkspace2.setActionOwner(null);
                psWorkspaceService.sysUpdate(psWorkspace2, true);
            }
            return psDCWorkspaceAction2;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u751f\u4ea7\u7ebf\u4f5c\u4e1a[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)strPSDCWorkspaceActionId, (Object)ex.getMessage()), (Throwable)ex);
            try {
                if (!StringHelper.isNullOrEmpty((String)psDCWorkspaceAction.getPSDCWorkspaceId())) {
                    psDCWorkspace.reset();
                    psDCWorkspace.setPSDCWorkspaceId(psDCWorkspaceAction.getPSDCWorkspaceId());
                    psDCWorkspaceService.get(psDCWorkspace);
                    if (StringHelper.compare((String)psDCWorkspace.getActionOwner(), (String)strOwnerId, (boolean)false) == 0) {
                        psWorkspace2.reset();
                        psWorkspace2.setPSWorkspaceId(psDCWorkspace.getPSWorkspaceId());
                        psWorkspace2.setCurAction(null);
                        psWorkspace2.setActionOwner(null);
                        psWorkspaceService.sysUpdate(psWorkspace2, false);
                    }
                }
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            try {
                psDCWorkspaceAction2.setPSDCWorkspaceActionId(strPSDCWorkspaceActionId);
                psDCWorkspaceAction2.setEndTime(DateHelper.getCurTime());
                psDCWorkspaceAction2.setActionState(DBInstBStateCodeListModel.FAILED);
                psDCWorkspaceActionService.sysUpdate(psDCWorkspaceAction2, false);
            }
            catch (Exception e) {
                log.error((Object)e);
            }
            throw ex;
        }
    }

    public static void executeDCAction(PSDCWorkspace psDCWorkspace, PSDCWorkspaceAction psDCWorkspaceAction) throws Exception {
        int nDevSysState;
        String strPSDevSlnSysId;
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspaceActionService psDCWorkspaceActionService = (PSDCWorkspaceActionService)ServiceGlobal.getService(PSDCWorkspaceActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCWorkspace psDCWorkspace2 = new PSDCWorkspace();
        PSDevSlnSys installPSDevSlnSys = new PSDevSlnSys();
        if ("INSTALLSYS".equals(psDCWorkspaceAction.getActionType())) {
            strPSDevSlnSysId = psDCWorkspaceAction.getPSDevSlnSysId();
            if (StringHelper.isNullOrEmpty((String)strPSDevSlnSysId)) {
                throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5b89\u88c5\u7cfb\u7edf");
            }
            installPSDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
            psDevSlnSysService.get(installPSDevSlnSys);
            nDevSysState = DataObject.getIntegerValue((Object)installPSDevSlnSys.getDevSysState(), (Integer)30);
            if (nDevSysState == 30) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u518d\u6b21\u8fde\u7ebf", (Object)installPSDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(Integer.toString(nDevSysState)).getText()));
            }
        } else if ("UNINSTALLSYS".equals(psDCWorkspaceAction.getActionType())) {
            strPSDevSlnSysId = psDCWorkspace.getPSDevSlnSysId();
            if (StringHelper.isNullOrEmpty((String)strPSDevSlnSysId)) {
                throw new Exception("\u751f\u4ea7\u7ebf\u672a\u5b89\u88c5\u7cfb\u7edf");
            }
            installPSDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
            psDevSlnSysService.get(installPSDevSlnSys);
            nDevSysState = DataObject.getIntegerValue((Object)installPSDevSlnSys.getDevSysState(), (Integer)30);
            if (nDevSysState == 35) {
                throw new Exception(StringHelper.format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u79bb\u7ebf", (Object)installPSDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(Integer.toString(nDevSysState)).getText()));
            }
        }
        PSDCWorkspaceLog psDCWorkspaceLog = new PSDCWorkspaceLog();
        String strLogName = DCWorkspaceLogTypeCodeListModel.getInstance().getCodeListText(psDCWorkspaceAction.getActionType(), true);
        psDCWorkspaceLog.setPSDCWorkspaceLogName(strLogName);
        psDCWorkspaceLog.setPSDCWorkspaceId(psDCWorkspace.getPSDCWorkspaceId());
        psDCWorkspaceLog.setPSDCWorkspaceName(psDCWorkspace.getPSDCWorkspaceName());
        psDCWorkspaceLog.setPSDevCenterId(psDCWorkspace.getPSDevCenterId());
        psDCWorkspaceLog.setPSDevCenterName(psDCWorkspace.getPSDevCenterName());
        psDCWorkspaceLog.setLogType(psDCWorkspaceAction.getActionType());
        psDCWorkspaceLog.setLogLevel("INFO");
        psDCWorkspaceLog.setLogLevel2(Integer.valueOf(20000));
        psDCWorkspaceLog.setBeginTime(new Timestamp(System.currentTimeMillis()));
        if (!StringHelper.isNullOrEmpty((String)psDCWorkspace.getPSDevSlnSysId())) {
            PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
            psDevSlnSys.setPSDevSlnSysId(psDCWorkspace.getPSDevSlnSysId());
            psDevSlnSysService.get(psDevSlnSys);
            PSSysModelInstHelper.updateVersion(psDevSlnSys.getPSSysModelInstId(), -1, -1);
            PSDevSlnSysHelper.offline(psDCWorkspace.getPSDevSlnSysId(), psDCWorkspaceAction.getPSDCWorkspaceId());
            psDCWorkspace2.reset();
            psDCWorkspace2.setPSDCWorkspaceId(psDCWorkspaceAction.getPSDCWorkspaceId());
            psDCWorkspace2.setPSDevSlnSysId(null);
            psDCWorkspace2.setPSDevSlnSysName(null);
            psDCWorkspaceService.sysUpdate(psDCWorkspace2, false);
            psDCWorkspaceLog.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
            psDCWorkspaceLog.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
            psDCWorkspaceLog.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
            psDCWorkspaceLog.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        }
        if ("INSTALLSYS".equals(psDCWorkspaceAction.getActionType())) {
            String strPSDevSlnSysId2 = psDCWorkspaceAction.getPSDevSlnSysId();
            PSDevSlnSysHelper.online(strPSDevSlnSysId2, psDCWorkspaceAction.getPSDCWorkspaceId());
            psDCWorkspace2.reset();
            psDCWorkspace2.setPSDCWorkspaceId(psDCWorkspaceAction.getPSDCWorkspaceId());
            psDCWorkspace2.setPSDevSlnSysId(installPSDevSlnSys.getPSDevSlnSysId());
            psDCWorkspace2.setPSDevSlnSysName(installPSDevSlnSys.getPSDevSlnSysName());
            psDCWorkspaceService.sysUpdate(psDCWorkspace2, false);
            psDCWorkspaceLog.setPSDevSlnId(installPSDevSlnSys.getPSDevSlnId());
            psDCWorkspaceLog.setPSDevSlnName(installPSDevSlnSys.getPSDevSlnName());
            psDCWorkspaceLog.setPSDevSlnSysId(installPSDevSlnSys.getPSDevSlnSysId());
            psDCWorkspaceLog.setPSDevSlnSysName(installPSDevSlnSys.getPSDevSlnSysName());
        }
        try {
            psDCWorkspaceLog.setEndTime(new Timestamp(System.currentTimeMillis()));
            PSDCWorkspaceLogService psDCWorkspaceLogService = (PSDCWorkspaceLogService)ServiceGlobal.getService(PSDCWorkspaceLogService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            psDCWorkspaceLogService.create(psDCWorkspaceLog, false);
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.format((String)"\u8bb0\u5f55\u4e2d\u5fc3\u751f\u4ea7\u7ebf\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
        }
    }
}
