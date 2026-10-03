/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSStudioConsoleHelper
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSDevSlnSysDynaInst;
import SA.SRFDA.PS.Core.IPSDevSlnSysRuntime;
import SA.SRFDA.PS.Core.IPSModelHelper;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.IPSTaskServerEnv;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSSysRunSession;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRunSessionService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSStudioConsoleHelper;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSysRunSessionDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSysRunSessionDataCtrl.class);
    public static final String CUSTOMCALL_STARTEX = "STARTEX";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_STARTEX, (boolean)true) == 0) {
            return this.startEx(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult startEx(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        String strPSDevSlnSysId = dataEntity.getParamStringValue("PSDEVSLNSYSID", "");
        String strPSDynaInstId = dataEntity.getParamStringValue("PSDYNAINSTID", "");
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSSysRunSession psSysRunSession = new PSSysRunSession();
            psSysRunSession.proxy(dataEntity);
            if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId) && StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                callResult = this.Get(psSysRunSession);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u83b7\u53d6\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd[%1$s]\u53d1\u751f\u9519\u8bef\uff0c%2$s", (Object)psSysRunSession.getPSSYSRUNSESSIONID(), (Object)callResult.getErrorInfo()));
                }
                strPSDynaInstId = psSysRunSession.getPSDYNAINSTID();
                ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                    public void execute(ITransaction iTransaction) throws Exception {
                        PSCoreSysServiceBase.setCurrentPSDCId(null);
                        PSCoreSysServiceBase.setCurrentPSDevSlnSysId(null);
                        PSCoreSysServiceBase.setCurrentPSSystemId(null);
                        PSSysRunSessionDataCtrl.this.onAddSyncSysDBModelTask(psSysRunSession);
                    }
                });
            } else {
                this.onAddSyncSysDBModelTask(psSysRunSession);
            }
            return callResult;
        }
        catch (Exception ex) {
            if (!(StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId) && StringHelper.IsNullOrEmpty((String)strPSDynaInstId) || PSStudioConsoleHelper.getCurrent() == null)) {
                String strContent = PSStudioConsoleHelper.getContent((String)StringHelper.Format((String)"[\u5efa\u7acb\u540e\u53f0\u4efb\u52a1\u9519\u8bef]"), (int)31, (int)-1, (int)1);
                if (!StringHelper.IsNullOrEmpty((String)ex.getMessage())) {
                    strContent = String.valueOf(strContent) + " ";
                    strContent = String.valueOf(strContent) + PSStudioConsoleHelper.getContent((String)ex.getMessage(), (int)31);
                }
                if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                    PSStudioConsoleHelper.getCurrent().sendConsole(strPSDynaInstId, strContent);
                } else {
                    PSStudioConsoleHelper.getCurrent().sendConsole(strPSDevSlnSysId, strContent);
                }
            }
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u4e00\u952e\u542f\u52a8\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void onAddSyncSysDBModelTask(PSSysRunSession psSysRunSession) throws Exception {
        int nRebuildMode;
        int nTaskCount;
        String strPSDevSlnSysId = psSysRunSession.getParamStringValue("PSDEVSLNSYSID", "");
        String strPSDynaInstId = psSysRunSession.getPSDYNAINSTID();
        String strPSBKTaskSessionId = strPSDevSlnSysId;
        boolean bDynaInstMode = false;
        if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
            strPSBKTaskSessionId = "PSDYNAINST:" + strPSDynaInstId;
            bDynaInstMode = true;
        }
        if (psSysRunSession.getRUNPARAM5() == 1) {
            try {
                this.getPSModelStorage().getPSSysDevBKTaskGlobal().resetPSBKTaskSession(strPSBKTaskSessionId);
            }
            catch (Exception ex) {
                log.error((Object)ex.getMessage());
            }
        }
        if ((nTaskCount = this.getPSModelStorage().getPSSysDevBKTaskGlobal().getPSBKTaskSessionTaskCount(strPSBKTaskSessionId, true)) >= 1) {
            if (bDynaInstMode) {
                throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u52a8\u6001\u5b9e\u4f8b\u4f5c\u4e1a\u961f\u5217\u5df2\u6392\u961f[%1$s]\uff0c\u8bf7\u7b49\u5f85\u5f53\u524d\u4f5c\u4e1a\u5b8c\u6210\u6216\u8bbe\u7f6e\u53d6\u6d88\u5f53\u524d\u4f5c\u4e1a", (Object)nTaskCount));
            }
            try {
                PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
                psDevSlnSys.get();
                PSSysRunSessionService psSysRunSessionService = (PSSysRunSessionService)ServiceGlobal.getService(PSSysRunSessionService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
                net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession psSysRunSession2 = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession();
                psSysRunSession2.setPSSysRunSessionId(psSysRunSession.getPSSYSRUNSESSIONID());
                psSysRunSessionService.remove(psSysRunSession2);
                throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7cfb\u7edf\u4f5c\u4e1a\u961f\u5217\u5df2\u6392\u961f[%1$s]\uff0c\u8bf7\u7b49\u5f85\u5f53\u524d\u4f5c\u4e1a\u5b8c\u6210\u6216\u8bbe\u7f6e\u53d6\u6d88\u5f53\u524d\u4f5c\u4e1a", (Object)nTaskCount));
            }
            catch (Exception ex) {
                log.error((Object)ex);
            }
            throw new Exception(StringHelper.Format((String)"\u5f53\u524d\u7cfb\u7edf\u4f5c\u4e1a\u961f\u5217\u5df2\u6392\u961f[%1$s]\uff0c\u8bf7\u7b49\u5f85\u5f53\u524d\u4f5c\u4e1a\u5b8c\u6210\u6216\u8bbe\u7f6e\u53d6\u6d88\u5f53\u524d\u4f5c\u4e1a", (Object)nTaskCount));
        }
        IPSDevSlnSysDynaInst iPSDevSlnSysDynaInst = null;
        IPSSystem iPSSystem = null;
        IPSDevSlnSys iPSDevSlnSys = null;
        String strPSSysModelInstId = null;
        boolean bTemplEngineV2 = false;
        if (bDynaInstMode) {
            bTemplEngineV2 = true;
            iPSDevSlnSysDynaInst = this.getPSModelStorage().getCachePSDevSlnSysDynaInst(strPSDynaInstId);
            if (iPSDevSlnSysDynaInst != null) {
                IPSModelHelper iPSModelHelper;
                iPSDevSlnSys = iPSDevSlnSysDynaInst.getPSDevSlnSys();
                if (iPSDevSlnSys != null && (iPSModelHelper = this.getPSModelHelper(iPSDevSlnSys.getPSSysModelInstId())) != null) {
                    iPSModelHelper.resetCache();
                }
                try {
                    this.getPSModelStorage().getPSSysDevBKTaskGlobal().resetPSBKTaskSession(strPSBKTaskSessionId);
                }
                catch (Exception ex) {
                    log.error((Object)ex.getMessage());
                }
                this.getPSModelStorage().resetPSDevSlnSysDynaInst(strPSDynaInstId);
            }
            iPSDevSlnSysDynaInst = this.getPSModelStorage().getPSDevSlnSysDynaInst(strPSDynaInstId);
            iPSDevSlnSys = iPSDevSlnSysDynaInst.getPSDevSlnSys();
            strPSSysModelInstId = iPSDevSlnSysDynaInst.getPSSysModelInstId();
        } else {
            iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            bTemplEngineV2 = StringHelper.Compare((String)iPSDevSlnSys.getTemplEngineVer(), (String)"V2", (boolean)true) == 0;
            strPSSysModelInstId = iPSDevSlnSys.getPSSysModelInstId();
        }
        PSSysRunSessionService psSysRunSessionService = (PSSysRunSessionService)ServiceGlobal.getService(PSSysRunSessionService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)strPSSysModelInstId));
        net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession psSysRunSession2 = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession();
        psSysRunSession2.setPSSysRunSessionId(psSysRunSession.getPSSYSRUNSESSIONID());
        if (!psSysRunSessionService.get(psSysRunSession2, true)) {
            if (StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) throw new Exception(String.format("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u7cfb\u7edf\u8fd0\u884c\u4f1a\u8bdd", new Object[0]));
            PSDEDataCtrl.convertEntity2(psSysRunSession, (IEntity)psSysRunSession2);
            psSysRunSession2.setPSSystemId(iPSDevSlnSys.getPSSystemId());
            psSysRunSession2.setPSSystemName(iPSDevSlnSys.getPSSystemName());
            psSysRunSessionService.create(psSysRunSession2);
        }
        if (((nRebuildMode = DataObject.getIntegerValue((Object)psSysRunSession2.getRebuildMode(), (Integer)0).intValue()) & 4) == 4) {
            nRebuildMode = 0;
            if (!bDynaInstMode) {
                this.getPSModelHelper(iPSDevSlnSys.getPSSysModelInstId()).resetCache();
                try {
                    this.getPSModelStorage().getPSSysDevBKTaskGlobal().resetPSBKTaskSession(strPSBKTaskSessionId);
                }
                catch (Exception ex) {
                    log.error((Object)ex.getMessage());
                }
                this.getPSModelStorage().resetPSDevSlnSys(strPSDevSlnSysId);
                iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
            }
        }
        boolean bDebugMode = false;
        if (DataObject.getIntegerValue((Object)psSysRunSession2.getDebugMode(), (Integer)0) == 1) {
            bDebugMode = true;
        }
        if (iPSDevSlnSys instanceof IPSDevSlnSysRuntime) {
            ((IPSDevSlnSysRuntime)((Object)iPSDevSlnSys)).setDebugMode(bDebugMode);
        }
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask parentPSSysDevBKTask = null;
        IPSTaskServerEnv iPSTaskServerEnv = this.getPSModelStorage().getPSTaskServerEnv();
        if (!bTemplEngineV2 && iPSTaskServerEnv.isTemplEngineV2Only()) {
            throw new Exception(String.format("\u7cfb\u7edf\u6a21\u677f\u5f15\u64ce\u7248\u672c\u4e0d\u652f\u6301", new Object[0]));
        }
        SessionFactoryManager.addRef();
        try {
            PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)strPSSysModelInstId));
            int nTaskOrder = 1;
            boolean bPubPFCode = true;
            boolean bPubSFCode = true;
            boolean bPackPFCode = true;
            boolean bPackSFCode = true;
            boolean bDeploySys = true;
            boolean bPackVer = false;
            boolean bPackAndroidApp = false;
            boolean bPackIOSApp = false;
            boolean bDeployMSAPI = false;
            boolean bDeployMSApp = false;
            boolean bSyncDBModel = true;
            boolean bDeployPkg = false;
            boolean bRemotePack = ((IPSDevSlnSysRuntime)((Object)iPSDevSlnSys)).isUseDeployCenter();
            boolean bPubDynaInstModel = false;
            boolean bSFOnly = false;
            if (!StringHelper.IsNullOrEmpty((String)psSysRunSession.getPSSYSSFPUBID())) {
                IPSSysSFPub iPSSysSFPub = iPSSystem.getPSSysSFPub(psSysRunSession.getPSSYSSFPUBID());
                bRemotePack = iPSSysSFPub.isRemotePack();
                bSFOnly = iPSSysSFPub.isDocMode();
                if (iPSSysSFPub.isDocMode()) {
                    psSysRunSession.setRUNMODE("PUBDOC");
                    psSysRunSession2.setRunMode("PUBDOC");
                }
            }
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            psSysDevBKTask.setUserTag(psSysRunSession.getUSERTAG());
            psSysDevBKTask.setUserTag2(psSysRunSession.getUSERTAG2());
            psSysDevBKTask.setTaskType("STARTUPEX");
            if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"STARTX", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u542f\u52a8\u7cfb\u7edf", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBCODE", (boolean)true) == 0 || StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBCODE2", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u4ee3\u7801", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setTaskType("STARTUPEX2");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBDOC", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u6587\u6863", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setTaskType("STARTUPEX2");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
                bSFOnly = true;
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBMODEL", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u6a21\u578b", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setTaskType("STARTUPEX2");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
                bSFOnly = true;
                if (StringHelper.IsNullOrEmpty((String)psSysRunSession.getPSSYSSFPUBID())) {
                    IPSSysSFPub iPSSysSFPub = iPSSystem.getDefaultPSSysSFPub();
                    if (iPSSysSFPub == null) throw new Exception(String.format("\u7cfb\u7edf\u672a\u6307\u5b9a\u9ed8\u8ba4\u540e\u53f0\u53d1\u5e03\u5bf9\u8c61", new Object[0]));
                    psSysRunSession.setPSSYSSFPUBID(iPSSysSFPub.getId());
                    psSysRunSession.setPSSYSSFPUBNAME(iPSSysSFPub.getName());
                    psSysRunSession2.setPSSysSFPubId(iPSSysSFPub.getId());
                    psSysRunSession2.setPSSysSFPubName(iPSSysSFPub.getName());
                }
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PACKVER", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u7cfb\u7edf\u7248\u672c", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setTaskType("STARTUPEX3");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PACKMOBAPP", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u79fb\u52a8\u7aef\u5e94\u7528", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setTaskType("STARTUPEX4");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"STARTMSAPI", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u90e8\u7f72\u5fae\u670d\u52a1\u63a5\u53e3", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setTaskType("STARTUPEX5");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"STARTMSAPP", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u90e8\u7f72\u5fae\u670d\u52a1\u5e94\u7528", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setTaskType("STARTUPEX6");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"STARTMSFUNC", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u90e8\u7f72\u5fae\u670d\u52a1\u529f\u80fd", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setTaskType("STARTUPEX8");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"DEPLOYPKG", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u90e8\u7f72\u7ec4\u4ef6\u5305\u5230\u4ed3\u5e93", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setTaskType("STARTUPEX7");
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
            } else if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBDYNAINSTMODEL", (boolean)true) == 0) {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u52a8\u6001\u5b9e\u4f8b\u6a21\u578b", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_ALL);
                psSysDevBKTask.setTaskType("STARTUPEX9");
            } else {
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u542f\u52a8\u7cfb\u7edf", (Object)psSysRunSession2.getPSSysRunSessionName()));
                psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
            }
            psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
            psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
            psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysRunSessionId());
            psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
            psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
            psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
            if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
            }
            psSysDevBKTaskService.create(psSysDevBKTask);
            parentPSSysDevBKTask = psSysDevBKTask;
            if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBCODE", (boolean)true) == 0 || StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBCODE2", (boolean)true) == 0 || StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBDOC", (boolean)true) == 0 || StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBMODEL", (boolean)true) == 0 || StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PACKVER", (boolean)true) == 0 || StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PACKMOBAPP", (boolean)true) == 0) {
                bDeploySys = false;
                if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PACKVER", (boolean)true) == 0) {
                    bPackVer = true;
                }
                if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBCODE2", (boolean)true) == 0) {
                    if (StringHelper.IsNullOrEmpty((String)psSysRunSession.getPSSYSSFPUBID())) {
                        bPubSFCode = false;
                    }
                    if (StringHelper.IsNullOrEmpty((String)psSysRunSession.getPSSYSAPPID())) {
                        bPubPFCode = false;
                    } else if (iPSSystem != null) {
                        iPSSystem.resetPSApplication(psSysRunSession.getPSSYSAPPID());
                    }
                }
            }
            if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PACKMOBAPP", (boolean)true) == 0) {
                bPubSFCode = false;
                bPackSFCode = false;
                bDeploySys = false;
                bPackPFCode = false;
                bSyncDBModel = false;
                PSMobAppPack psMobAppPack = psSysRunSession2.getPSMobAppPack();
                if (psMobAppPack != null) {
                    bPackAndroidApp = DataObject.getBoolValue((Integer)psMobAppPack.getEnableAndroid(), (boolean)false);
                    bPackIOSApp = DataObject.getBoolValue((Integer)psMobAppPack.getEnableIOS(), (boolean)false);
                }
            }
            if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"STARTMSAPI", (boolean)true) == 0 || StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"STARTMSAPP", (boolean)true) == 0) {
                bDeploySys = true;
                if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"STARTMSAPI", (boolean)true) == 0) {
                    bDeployMSAPI = true;
                    bPubPFCode = false;
                    bPackPFCode = false;
                } else {
                    bDeployMSApp = true;
                }
            }
            if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"DEPLOYPKG", (boolean)true) == 0) {
                bDeploySys = false;
                bPubPFCode = false;
                bPackPFCode = false;
                bDeployPkg = true;
            }
            if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"STARTMSFUNC", (boolean)true) == 0) {
                bDeploySys = true;
            }
            if (StringHelper.Compare((String)psSysRunSession.getRUNMODE(), (String)"PUBDYNAINSTMODEL", (boolean)true) == 0) {
                bPubDynaInstModel = true;
                bPubSFCode = false;
                bPackSFCode = false;
                bDeploySys = false;
                bPubPFCode = false;
                bPackPFCode = false;
                bSyncDBModel = false;
            }
            if (bSFOnly) {
                bPubSFCode = true;
                bPubPFCode = false;
                bPackPFCode = false;
                bPackSFCode = false;
                bDeploySys = false;
                bPackVer = false;
                bPackAndroidApp = false;
                bPackIOSApp = false;
                bDeployMSAPI = false;
                bDeployMSApp = false;
                bSyncDBModel = false;
                bDeployPkg = false;
                bRemotePack = false;
                bPubDynaInstModel = false;
            }
            ++nTaskOrder;
            psSysDevBKTask = new PSSysDevBKTask();
            psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u68c0\u67e5[%1$s]\u7cfb\u7edf\u6a21\u578b", (Object)iPSSystem.getName()));
            psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
            psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
            psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
            psSysDevBKTask.setTaskType("CHECKSYSMODEL");
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSystemDBCfgId());
            psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
            psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
            psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
            psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
            psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
            if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
            }
            psSysDevBKTaskService.create(psSysDevBKTask, false);
            if (bSyncDBModel && (bDeployMSAPI || bDeployMSApp || !StringHelper.IsNullOrEmpty((String)psSysRunSession2.getPSSystemDBCfgId()))) {
                ++nTaskOrder;
                psSysDevBKTask = new PSSysDevBKTask();
                if (StringHelper.IsNullOrEmpty((String)psSysRunSession2.getPSSystemDBCfgName())) {
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65\u6570\u636e\u5e93\u6a21\u578b"));
                } else {
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSysRunSession2.getPSSystemDBCfgName()));
                }
                psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                psSysDevBKTask.setTaskType("SYNCDBMODEL");
                psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSystemDBCfgId());
                psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                    psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                    psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                    psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                }
                psSysDevBKTaskService.create(psSysDevBKTask, false);
            }
            if (bTemplEngineV2 && (bPubSFCode || bPubPFCode)) {
                ++nTaskOrder;
                psSysDevBKTask = new PSSysDevBKTask();
                if (bPubDynaInstModel) {
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u51c6\u5907\u53d1\u5e03\u52a8\u6001\u5b9e\u4f8b[%1$s]\u6a21\u578b", (Object)iPSDevSlnSysDynaInst.getName()));
                } else {
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u51c6\u5907\u53d1\u5e03[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysSFPubName()));
                }
                psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                psSysDevBKTask.setTaskType("BEGINPUBCODE");
                psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                    psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                    psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                    psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                }
                psSysDevBKTaskService.create(psSysDevBKTask, false);
            }
            if (bPubSFCode) {
                ++nTaskOrder;
                psSysDevBKTask = new PSSysDevBKTask();
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u670d\u52a1\u5c42[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysSFPubName()));
                psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                psSysDevBKTask.setTaskType("PUBSFCODE");
                psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                    psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                    psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                    psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                }
                psSysDevBKTaskService.create(psSysDevBKTask, false);
            }
            if (bPubPFCode && !StringHelper.IsNullOrEmpty((String)psSysRunSession2.getPSSysAppId())) {
                ++nTaskOrder;
                psSysDevBKTask = new PSSysDevBKTask();
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysAppName()));
                psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                psSysDevBKTask.setTaskType("PUBPFCODE");
                psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysAppId());
                psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                    psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                    psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                    psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                }
                psSysDevBKTaskService.create(psSysDevBKTask, false);
            }
            if (bPubDynaInstModel) {
                ++nTaskOrder;
                psSysDevBKTask = new PSSysDevBKTask();
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u52a8\u6001\u5b9e\u4f8b[%1$s]\u6a21\u578b", (Object)iPSDevSlnSysDynaInst.getName()));
                psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                psSysDevBKTask.setTaskType("PUBDYNAINSTMODEL");
                psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                    psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                    psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                    psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                }
                psSysDevBKTaskService.create(psSysDevBKTask, false);
            }
            if (nRebuildMode > 0) {
                ++nTaskOrder;
                psSysDevBKTask = new PSSysDevBKTask();
                psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u91cd\u7f6e\u670d\u52a1\u5c42(\u524d\uff09[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysSFPubName()));
                psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                psSysDevBKTask.setTaskType("RESETSFCODE");
                psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                    psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                    psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                    psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                }
                psSysDevBKTaskService.create(psSysDevBKTask, false);
                if (!StringHelper.IsNullOrEmpty((String)psSysRunSession2.getPSSysAppId())) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u91cd\u7f6e\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysAppName()));
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("RESETPFCODE");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysAppId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bPubSFCode) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u670d\u52a1\u5c42[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysSFPubName()));
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("PUBSFCODE");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bPubPFCode && !StringHelper.IsNullOrEmpty((String)psSysRunSession2.getPSSysAppId())) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u53d1\u5e03\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysAppName()));
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("PUBPFCODE");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysAppId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
            }
            if (nRebuildMode > 0) {
                // empty if block
            }
            if (bTemplEngineV2) {
                if (bPubSFCode || bPubPFCode) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    if (bPubDynaInstModel) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u7ed3\u675f\u53d1\u5e03\u52a8\u6001\u5b9e\u4f8b[%1$s]\u6a21\u578b", (Object)iPSDevSlnSysDynaInst.getName()));
                    } else {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u7ed3\u675f\u53d1\u5e03[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysSFPubName()));
                    }
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("ENDPUBCODE");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
            } else {
                if (bPackSFCode) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    if (bRemotePack) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u63d0\u4ea4\u670d\u52a1\u5c42[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysSFPubName()));
                    } else {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u670d\u52a1\u5c42[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysSFPubName()));
                    }
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("PACKSFCODE");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bPackPFCode && !StringHelper.IsNullOrEmpty((String)psSysRunSession2.getPSSysAppId())) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    if (bRemotePack) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u63d0\u4ea4\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysAppName()));
                    } else {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysAppName()));
                    }
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("PACKPFCODE");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysAppId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bPackPFCode && !StringHelper.IsNullOrEmpty((String)psSysRunSession2.getPSSysAppId2())) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    if (bRemotePack) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u63d0\u4ea4\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysAppName2()));
                    } else {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u5e94\u7528\u7a0b\u5e8f[%1$s]\u4ee3\u7801", (Object)psSysRunSession2.getPSSysAppName2()));
                    }
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("PACKPFCODE");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysAppId2());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bPackAndroidApp && !StringHelper.IsNullOrEmpty((String)psSysRunSession2.getPSSysAppId())) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305[%1$s]Android\u5e94\u7528", (Object)psSysRunSession2.getPSSysAppName()));
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setTaskType("PACKANDROIDAPP");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysAppId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bPackIOSApp && !StringHelper.IsNullOrEmpty((String)psSysRunSession2.getPSSysAppId())) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305[%1$s]iOS\u5e94\u7528", (Object)psSysRunSession2.getPSSysAppName()));
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("PACKIOSAPP");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysAppId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bDeploySys && bRemotePack) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u7cfb\u7edf[%1$s]", (Object)psSysRunSession2.getPSSysSFPubName()));
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("REMOTEPACKSYS");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bDeploySys) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    if (bDeployMSAPI) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u505c\u6b62\u5fae\u670d\u52a1\u63a5\u53e3[%1$s]", (Object)psSysRunSession2.getPSDevSlnMSDepAPIName()));
                    } else if (bDeployMSApp) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u505c\u6b62\u5fae\u670d\u52a1\u5e94\u7528[%1$s]", (Object)psSysRunSession2.getPSDevSlnMSDepAppName()));
                    } else {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u505c\u6b62\u5e94\u7528\u670d\u52a1\u5668[%1$s]", (Object)psSysRunSession2.getPSSystemASName()));
                    }
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("SHUTDOWNAS");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSystemASId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bDeploySys) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    if (bDeployMSAPI) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u90e8\u7f72\u5fae\u670d\u52a1\u63a5\u53e3[%1$s]", (Object)psSysRunSession2.getPSDevSlnMSDepAPIName()));
                    } else if (bDeployMSApp) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u90e8\u7f72\u5fae\u670d\u52a1\u5e94\u7528[%1$s]", (Object)psSysRunSession2.getPSDevSlnMSDepAppName()));
                    } else {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u90e8\u7f72\u7cfb\u7edf"));
                    }
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("DEPLOYSYS");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bDeployPkg) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u90e8\u7f72\u7ec4\u4ef6\u5305\u5230\u4ed3\u5e93"));
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("DEPLOYPKG");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bDeploySys) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    if (bDeployMSAPI) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u542f\u52a8\u5fae\u670d\u52a1\u63a5\u53e3[%1$s]", (Object)psSysRunSession2.getPSDevSlnMSDepAPIName()));
                    } else if (bDeployMSApp) {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u542f\u52a8\u5fae\u670d\u52a1\u5e94\u7528[%1$s]", (Object)psSysRunSession2.getPSDevSlnMSDepAppName()));
                    } else {
                        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u542f\u52a8\u5e94\u7528\u670d\u52a1\u5668[%1$s]", (Object)psSysRunSession2.getPSSystemASName()));
                    }
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("STARTUPAS");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSystemASId());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
                if (bPackVer) {
                    ++nTaskOrder;
                    psSysDevBKTask = new PSSysDevBKTask();
                    psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u6253\u5305\u7248\u672c[%1$s]", (Object)psSysRunSession2.getRunParam2()));
                    psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
                    psSysDevBKTask.setPSSysModelInstId(strPSSysModelInstId);
                    psSysDevBKTask.setPSDynaInstId(strPSDynaInstId);
                    psSysDevBKTask.setTaskType("PACKSYSVER");
                    psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
                    psSysDevBKTask.setPSSystemId(iPSSystem.getId());
                    psSysDevBKTask.setPSSystemName(iPSSystem.getName());
                    psSysDevBKTask.setTaskParam(psSysRunSession2.getPSSysSFPubId());
                    psSysDevBKTask.setTaskParam2(psSysRunSession2.getRunParam());
                    psSysDevBKTask.setPPSSysDevBKTaskId(parentPSSysDevBKTask.getPSSysDevBKTaskId());
                    psSysDevBKTask.setPPSSysDevBKTaskName(parentPSSysDevBKTask.getPSSysDevBKTaskName());
                    psSysDevBKTask.setOrderValue(Integer.valueOf(nTaskOrder));
                    psSysDevBKTask.setPSTaskServerId(iPSTaskServerEnv.getId());
                    psSysDevBKTask.setPSTaskServerName(iPSTaskServerEnv.getName());
                    if (!StringHelper.IsNullOrEmpty((String)strPSDynaInstId)) {
                        psSysDevBKTask.setPSSystemId(iPSDevSlnSys.getPSSystemId());
                        psSysDevBKTask.setPSSystemName(iPSDevSlnSys.getPSSystemName());
                        psSysDevBKTask.setPSDevSlnSysId(iPSDevSlnSys.getId());
                    }
                    psSysDevBKTaskService.create(psSysDevBKTask, false);
                }
            }
            if (bDeploySys) {
                ++nTaskOrder;
                SelectCond selectCond = new SelectCond();
                selectCond.set("PSSYSTEMID", (Object)psSysRunSession.getPSSYSTEMID());
                selectCond.set("RUNSTATE", (Object)20);
                ArrayList<net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession> psSysRunSessionList = psSysRunSessionService.select((ISelectCond)selectCond);
                for (net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession lastRunSession : psSysRunSessionList) {
                    net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession updateItem = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession();
                    updateItem.setPSSysRunSessionId(lastRunSession.getPSSysRunSessionId());
                    updateItem.setRunState(Integer.valueOf(30));
                    updateItem.setEndTime(new Timestamp(System.currentTimeMillis()));
                    psSysRunSessionService.update(updateItem);
                }
                net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession updateItem = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession();
                updateItem.setPSSysRunSessionId(psSysRunSession.getPSSYSRUNSESSIONID());
                updateItem.setRunState(Integer.valueOf(20));
                updateItem.setStartTime(new Timestamp(System.currentTimeMillis()));
                psSysRunSessionService.update(updateItem);
            } else {
                net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession updateItem = new net.ibizsys.pscore.srv.sysdesign.entity.PSSysRunSession();
                updateItem.setPSSysRunSessionId(psSysRunSession.getPSSYSRUNSESSIONID());
                updateItem.setRunState(Integer.valueOf(30));
                updateItem.setStartTime(new Timestamp(System.currentTimeMillis()));
                psSysRunSessionService.update(updateItem);
            }
            SessionFactoryManager.releaseRef((boolean)true);
        }
        catch (Exception ex) {
            SessionFactoryManager.releaseRef((boolean)false);
            throw ex;
        }
        try {
            SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
            PSSysRunSessionDataCtrl.convertEntity((IEntity)parentPSSysDevBKTask, psSysDevBKTask2);
            this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
            return;
        }
        catch (Exception ex) {
            try {
                PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)strPSSysModelInstId));
                psSysDevBKTaskService.remove(parentPSSysDevBKTask);
                throw ex;
            }
            catch (Exception e) {
                log.error((Object)StringHelper.Format((String)"\u79fb\u9664\u7cfb\u7edf\u5f00\u53d1\u540e\u53f0\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)e.getMessage()), (Throwable)e);
            }
            throw ex;
        }
    }
}

