/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.ibizsys.paas.core.CallResult
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebConfig
 *  net.ibizsys.psop.zookeeper.PSEntityKeeperGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.pscore.srv.util;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import net.ibizsys.paas.core.CallResult;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebConfig;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSStudioServerLog;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSStudioServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.util.IPSStudioBKTaskWork2;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSStudioBKTaskWorkHelper;
import net.ibizsys.pscore.srv.util.PSStudioUserLog;
import net.ibizsys.pscore.srv.util.PSStudioUserLogSession;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.ibizsys.psop.zookeeper.PSEntityKeeperGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PSStudioGlobal {
    private HashMap<String, PSStudioUserLogSession> psStudioUserLogSessionMap = new HashMap();
    private ArrayList<PSStudioUserLogSession> psStudioUserLogSessionList = new ArrayList();
    private static final Log log = LogFactory.getLog(PSStudioGlobal.class);
    private static PSStudioGlobal psStudioGlobal = new PSStudioGlobal();
    private static CallResult loginAnotherResult = new CallResult();
    private static CallResult activeOkResult = new CallResult();
    private static CallResult devslnsysOfflineResult = new CallResult();
    private static CallResult devslnsysExpiredResult = new CallResult();
    private static CallResult devslnsysInvalidResult = new CallResult();
    public static final String WEBCONFIG_PSSTUDIOSERVERID = "PSSTUDIOSERVERID";
    private Boolean bFirstLog = true;
    private PSStudioServer psStudioServer = null;
    private PSStudioServerLogService psStudioServerLogService = null;
    private Object objFirstLogLock = new Object();
    private Boolean bSingleUser = null;
    private Boolean bEnableModelInstProxyMode = null;
    private String strRecyclePSDCId = null;

    public static void setCurrent(PSStudioGlobal pSStudioGlobal) {
        psStudioGlobal = pSStudioGlobal;
    }

    public static PSStudioGlobal getCurrent() {
        return psStudioGlobal;
    }

    public void logUserAction(IWebContext iWebContext, int n, String string) {
        PSStudioUserLogSession pSStudioUserLogSession = this.getPSStudioUserLogSession(iWebContext);
        if (pSStudioUserLogSession == null) {
            return;
        }
        pSStudioUserLogSession.logAction(iWebContext, n, string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected PSStudioUserLogSession getPSStudioUserLogSession(IWebContext iWebContext) {
        String string = iWebContext.getCurUserId();
        if (StringHelper.isNullOrEmpty((String)string)) {
            return null;
        }
        Object object = null;
        Object object2 = this.psStudioUserLogSessionMap;
        synchronized (object2) {
            object = this.psStudioUserLogSessionMap.get(string);
        }
        if (object != null) {
            return (PSStudioUserLogSession)object;
        }
        object2 = new PSStudioUserLogSession();
        ((PSStudioUserLogSession)object2).init(iWebContext);
        HashMap<String, PSStudioUserLogSession> hashMap = this.psStudioUserLogSessionMap;
        synchronized (hashMap) {
            object = this.psStudioUserLogSessionMap.get(string);
            if (object == null) {
                this.psStudioUserLogSessionMap.put(string, (PSStudioUserLogSession)object2);
                object = object2;
                ArrayList<PSStudioUserLogSession> arrayList = this.psStudioUserLogSessionList;
                synchronized (arrayList) {
                    this.psStudioUserLogSessionList.add((PSStudioUserLogSession)object);
                }
            }
        }
        return (PSStudioUserLogSession)object;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSStudioUserLog> getLastPSStudioUserLogList(int n) throws Exception {
        ArrayList<PSStudioUserLog> arrayList = new ArrayList<PSStudioUserLog>();
        long l = System.currentTimeMillis() - (long)(n * 1000);
        ArrayList<PSStudioUserLogSession> arrayList2 = this.psStudioUserLogSessionList;
        synchronized (arrayList2) {
            for (PSStudioUserLogSession pSStudioUserLogSession : this.psStudioUserLogSessionList) {
                pSStudioUserLogSession.fillPSStudioUserLogList(arrayList, l);
            }
        }
        return arrayList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset(int n) throws Exception {
        ArrayList<String> arrayList = new ArrayList<String>();
        long l = System.currentTimeMillis() - (long)(n * 1000);
        ArrayList<PSStudioUserLogSession> arrayList2 = this.psStudioUserLogSessionList;
        synchronized (arrayList2) {
            for (PSStudioUserLogSession pSStudioUserLogSession : this.psStudioUserLogSessionList) {
                if (pSStudioUserLogSession.getLastActionTime() >= l) continue;
                arrayList.add(pSStudioUserLogSession.getUserId());
            }
        }
        for (String string : arrayList) {
            HashMap<String, PSStudioUserLogSession> hashMap = this.psStudioUserLogSessionMap;
            synchronized (hashMap) {
                PSStudioUserLogSession pSStudioUserLogSession = this.psStudioUserLogSessionMap.get(string);
                if (pSStudioUserLogSession != null && pSStudioUserLogSession.getLastActionTime() < l) {
                    this.psStudioUserLogSessionMap.remove(string);
                    ArrayList<PSStudioUserLogSession> arrayList3 = this.psStudioUserLogSessionList;
                    synchronized (arrayList3) {
                        this.psStudioUserLogSessionList.remove(pSStudioUserLogSession);
                    }
                }
            }
        }
    }

    public boolean isSingleUser() {
        if (this.bSingleUser == null) {
            this.bSingleUser = WebConfig.getCurrent().getAttribute("SINGLEUSER", false);
        }
        return this.bSingleUser;
    }

    public CallResult loginUser(IWebContext iWebContext) throws Exception {
        if (this.isSingleUser() && PSEntityKeeperGlobal.getCurrent().isPSEntityEnabled("PSDEVUSER")) {
            SimpleEntity simpleEntity = new SimpleEntity();
            simpleEntity.set("PSDEVCENTERID", (Object)iWebContext.getCurOrgId());
            simpleEntity.set("PSDEVUSERID", (Object)iWebContext.getCurUserId());
            simpleEntity.set("SESSIONID", (Object)iWebContext.getSessionId());
            simpleEntity.set("REMOTEADDR", (Object)iWebContext.getRemoteAddr());
            PSEntityKeeperGlobal.getCurrent().updatePSEntity("PSDEVUSER", simpleEntity, true);
        }
        return activeOkResult;
    }

    public CallResult activeUser(IWebContext iWebContext) throws Exception {
        if (this.isSingleUser() && PSEntityKeeperGlobal.getCurrent().isPSEntityEnabled("PSDEVUSER")) {
            String string;
            SimpleEntity simpleEntity = new SimpleEntity();
            simpleEntity.set("PSDEVUSERID", (Object)iWebContext.getCurUserId());
            if (PSEntityKeeperGlobal.getCurrent().getPSEntity("PSDEVUSER", simpleEntity, false) && StringHelper.compare((String)(string = DataObject.getStringValue((Object)simpleEntity.get("SESSIONID"))), (String)iWebContext.getSessionId(), (boolean)true) == 0) {
                return activeOkResult;
            }
            return loginAnotherResult;
        }
        return activeOkResult;
    }

    public CallResult logoutUser(IWebContext iWebContext) throws Exception {
        if (this.isSingleUser() && PSEntityKeeperGlobal.getCurrent().isPSEntityEnabled("PSDEVUSER")) {
            String string;
            SimpleEntity simpleEntity = new SimpleEntity();
            simpleEntity.set("PSDEVUSERID", (Object)iWebContext.getCurUserId());
            if (PSEntityKeeperGlobal.getCurrent().getPSEntity("PSDEVUSER", simpleEntity, false) && StringHelper.compare((String)(string = DataObject.getStringValue((Object)simpleEntity.get("SESSIONID"))), (String)iWebContext.getSessionId(), (boolean)true) == 0) {
                simpleEntity.set("PSDEVUSERID", (Object)iWebContext.getCurUserId());
                simpleEntity.set("PSDEVCENTERID", (Object)"");
                simpleEntity.set("SESSIONID", (Object)"");
                simpleEntity.set("REMOTEADDR", (Object)"");
                PSEntityKeeperGlobal.getCurrent().updatePSEntity("PSDEVUSER", simpleEntity, false);
            }
        }
        return activeOkResult;
    }

    public CallResult activePSDevSlnSys(String string) throws Exception {
        if (PSCoreEntityKeeperGlobal.getCurrent(PSCoreSysServiceBase.getCurMajorSessionFactory()).isPSDevSlnSysEnabled()) {
            PSDevSlnSys pSDevSlnSys = PSCoreEntityKeeperGlobal.getCurrent(PSCoreSysServiceBase.getCurMajorSessionFactory()).getPSDevSlnSys(string);
            if (pSDevSlnSys.getValidFlag() != null && pSDevSlnSys.getValidFlag() != 1) {
                return devslnsysInvalidResult;
            }
            long l = System.currentTimeMillis();
            if (pSDevSlnSys.getExpriedTime() != null && pSDevSlnSys.getExpriedTime().getTime() < l) {
                return devslnsysExpiredResult;
            }
            if (pSDevSlnSys.getDevSysState() != null && pSDevSlnSys.getDevSysState() != 30) {
                return devslnsysOfflineResult;
            }
            pSDevSlnSys.setRTLastActiveTime(l);
        }
        return activeOkResult;
    }

    public void resetPSDevSlnSys() {
        try {
            PSCoreEntityKeeperGlobal pSCoreEntityKeeperGlobal = PSCoreEntityKeeperGlobal.getCurrent(PSCoreSysServiceBase.getCurMajorSessionFactory());
            if (!pSCoreEntityKeeperGlobal.isPSDevSlnSysEnabled()) {
                return;
            }
            ArrayList<String> arrayList = new ArrayList<String>();
            pSCoreEntityKeeperGlobal.fillPSDevSlnSysIdList(arrayList);
            long l = System.currentTimeMillis();
            for (String string : arrayList) {
                try {
                    PSDevSlnSys pSDevSlnSys = pSCoreEntityKeeperGlobal.getPSDevSlnSys(string);
                    if (pSDevSlnSys == null) continue;
                    boolean bl = false;
                    if (pSDevSlnSys.getValidFlag() != null && pSDevSlnSys.getValidFlag() != 1) {
                        bl = true;
                    } else if (pSDevSlnSys.getExpriedTime() != null && pSDevSlnSys.getExpriedTime().getTime() < l) {
                        bl = true;
                    }
                    if (!bl && pSDevSlnSys.getRTLastActiveTime() + 150000L >= l) continue;
                    if (!StringHelper.isNullOrEmpty((String)pSDevSlnSys.getPSSysModelInstId())) {
                        PSSysModelInstGlobal.resetSessionFactory(pSDevSlnSys.getPSSysModelInstId());
                        log.info((Object)StringHelper.format((String)"\u79fb\u9664\u5f00\u53d1\u7cfb\u7edf\u6570\u636e\u8fde\u63a5[%1$s][%2$s]", (Object)string, (Object)pSDevSlnSys.getPSDevSlnSysName()));
                    }
                    pSCoreEntityKeeperGlobal.resetPSDevSlnSys(string);
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u79fb\u9664\u5f00\u53d1\u7cfb\u7edf[%1$s]\u53d1\u751f\u5f02\u5e38\uff0c%2$s", (Object)string, (Object)exception.getMessage()), (Throwable)exception);
                }
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u91cd\u7f6e\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void logPSStudioServerInfo() {
        Object object = this.objFirstLogLock;
        synchronized (object) {
            if (this.bFirstLog.booleanValue()) {
                this.bFirstLog = false;
                String string = WebConfig.getCurrent().getAttribute(WEBCONFIG_PSSTUDIOSERVERID, "");
                if (StringHelper.isNullOrEmpty((String)string)) {
                    log.warn((Object)"\u6ca1\u6709\u6307\u5b9a\u5de5\u5177\u670d\u52a1\u5668\u6807\u8bc6\uff0c\u65e0\u6cd5\u8fdb\u884c\u65e5\u5fd7");
                    return;
                }
                try {
                    PSStudioServerService pSStudioServerService = (PSStudioServerService)ServiceGlobal.getService(PSStudioServerService.class);
                    PSStudioServer pSStudioServer = new PSStudioServer();
                    pSStudioServer.setPSStudioServerId(string);
                    pSStudioServerService.get(pSStudioServer);
                    this.psStudioServer = pSStudioServer;
                    PSStudioBKTaskWorkHelper.execute(new IPSStudioBKTaskWork2(){

                        @Override
                        public void execute(Object object) {
                            PSStudioGlobal.this.createDefaultPSStudioServerLog();
                        }
                    });
                }
                catch (Exception exception) {
                    log.error((Object)StringHelper.format((String)"\u521d\u59cb\u5316Studio\u670d\u52a1\u5668\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
                }
            } else {
                if (this.psStudioServer == null) {
                    return;
                }
                PSStudioBKTaskWorkHelper.execute(new IPSStudioBKTaskWork2(){

                    @Override
                    public void execute(Object object) {
                        PSStudioGlobal.this.createPSStudioServerLog();
                    }
                });
            }
        }
    }

    protected void createDefaultPSStudioServerLog() {
        try {
            this.psStudioServerLogService = (PSStudioServerLogService)ServiceGlobal.getService(PSStudioServerLogService.class);
            PSStudioServerLog pSStudioServerLog = new PSStudioServerLog();
            pSStudioServerLog.setPSStudioServerLogId(this.psStudioServer.getPSStudioServerId());
            if (this.psStudioServerLogService.checkKey(pSStudioServerLog) == 0) {
                pSStudioServerLog.setDefaultFlag(1);
                pSStudioServerLog.setPSStudioServerLogName(StringHelper.format((String)"[%1$s]\u9ed8\u8ba4\u65e5\u5fd7", (Object)this.psStudioServer.getPSStudioServerName()));
                pSStudioServerLog.setPSStudioServerId(this.psStudioServer.getPSStudioServerId());
                pSStudioServerLog.setPSStudioServerName(this.psStudioServer.getPSStudioServerName());
                this.psStudioServerLogService.create(pSStudioServerLog);
            }
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acbStudio\u670d\u52a1\u5668\u9ed8\u8ba4\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
        }
    }

    protected void createPSStudioServerLog() {
        try {
            PSCoreEntityKeeperGlobal pSCoreEntityKeeperGlobal = PSCoreEntityKeeperGlobal.getCurrent(PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSStudioServerLog pSStudioServerLog = new PSStudioServerLog();
            pSStudioServerLog.setDefaultFlag(0);
            pSStudioServerLog.setPSStudioServerLogName(StringHelper.format((String)"[%1$s]\u65e5\u5fd7", (Object)this.psStudioServer.getPSStudioServerName()));
            pSStudioServerLog.setPSStudioServerId(this.psStudioServer.getPSStudioServerId());
            pSStudioServerLog.setPSStudioServerName(this.psStudioServer.getPSStudioServerName());
            Runtime runtime = Runtime.getRuntime();
            pSStudioServerLog.setTotalMemory((int)(runtime.totalMemory() / 0x100000L));
            pSStudioServerLog.setFreeMemory((int)(runtime.freeMemory() / 0x100000L));
            pSStudioServerLog.setMaxMemory((int)(runtime.maxMemory() / 0x100000L));
            pSStudioServerLog.setSysModelInstCnt(PSSysModelInstGlobal.getSessionFactoryCount());
            pSStudioServerLog.setDCCnt(pSCoreEntityKeeperGlobal.getPSDevCenterCount());
            pSStudioServerLog.setSysModelCnt(pSCoreEntityKeeperGlobal.getPSDevSlnSysCount());
            ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
            int n = threadMXBean.getThreadCount();
            pSStudioServerLog.setThreadCnt(n);
            pSStudioServerLog.setLogTime(new Timestamp(System.currentTimeMillis()));
            this.psStudioServerLogService.create(pSStudioServerLog, false);
        }
        catch (Exception exception) {
            log.error((Object)StringHelper.format((String)"\u5efa\u7acbStudio\u670d\u52a1\u5668\u65e5\u5fd7\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)exception.getMessage()), (Throwable)exception);
        }
    }

    public boolean isEnableModelInstProxyMode() {
        if (this.bEnableModelInstProxyMode == null) {
            this.bEnableModelInstProxyMode = WebConfig.getCurrent().getAttribute("MODELINSTPROXYMODE", false);
        }
        return this.bEnableModelInstProxyMode;
    }

    public String getRecyclePSDCId() {
        if (this.strRecyclePSDCId == null) {
            this.strRecyclePSDCId = WebConfig.getCurrent().getAttribute("RECYCLEPSDCID", "");
        }
        return this.strRecyclePSDCId;
    }

    static {
        loginAnotherResult.setRetCode(2);
        loginAnotherResult.setErrorInfo("\u7528\u6237\u5df2\u5728\u5176\u5b83\u5730\u5740\u767b\u5f55");
        activeOkResult.setRetCode(0);
        devslnsysOfflineResult.setRetCode(2);
        devslnsysOfflineResult.setErrorInfo("\u5f00\u53d1\u7cfb\u7edf\u672a\u5904\u4e8e\u8fde\u7ebf\u72b6\u6001");
        devslnsysExpiredResult.setRetCode(2);
        devslnsysExpiredResult.setErrorInfo("\u5f00\u53d1\u7cfb\u7edf\u5df2\u8fc7\u671f");
        devslnsysInvalidResult.setRetCode(2);
        devslnsysInvalidResult.setErrorInfo("\u5f00\u53d1\u7cfb\u7edf\u672a\u88ab\u542f\u7528");
    }
}
