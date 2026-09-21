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
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ISFSAction
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DateHelper
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.pscore.srv.PSCoreSysServiceBase
 *  net.ibizsys.pscore.srv.Version
 *  net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel
 *  net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCSysInstAction
 *  net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService
 *  net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.App.IPSApplicationRuntime;
import SA.SRFDA.PS.Core.DevStudio.IPSBKTaskWork;
import SA.SRFDA.PS.Core.DevStudio.PSBKTaskWorkHelper;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSSystemUtil;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ISFSAction;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DateHelper;
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.Version;
import net.ibizsys.pscore.srv.codelist.BackendActionStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DBInstBStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevCenterResStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysActionCodeListModel;
import net.ibizsys.pscore.srv.codelist.DevSysStateCodeListModel;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBKTask;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysInstAction;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSysInstActionService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysBak;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSCoreEntityKeeperGlobal;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSDevSlnSysDataCtrl
extends PSDEDataCtrl {
    public static final String CUSTOMCALL_UNLOAD = "UNLOAD";
    public static final String CUSTOMCALL_INITSYSMODEL = "INITSYSMODEL";
    public static final String CUSTOMCALL_PUBSYSDBMODEL = "PUBSYSDBMODEL";
    public static final String CUSTOMCALL_INITSUBSYSMODEL = "INITSUBSYSMODEL";
    public static final String CUSTOMCALL_CHECKSYSMODEL = "CHECKSYSMODEL";
    public static final String CUSTOMCALL_REBIND = "REBIND";
    public static final String CUSTOMCALL_ADDBACKUPSYSMODELTASK = "ADDBACKUPSYSMODELTASK";
    public static final String CUSTOMCALL_ADDONLINESYSMODELTASK = "ADDONLINESYSMODELTASK";
    public static final String CUSTOMCALL_ADDOFFLINESYSMODELTASK = "ADDOFFLINESYSMODELTASK";
    public static final String CUSTOMCALL_ADDBINDSYSMODELTASK = "ADDBINDSYSMODELTASK";
    public static final String CUSTOMCALL_ADDEXPORTSYSMODELTASK = "ADDEXPORTSYSMODELTASK";
    public static final String CUSTOMCALL_ADDIMPORTSYSMODELTASK = "ADDIMPORTSYSMODELTASK";
    public static final String CUSTOMCALL_ADDUPGRATESYSMODELTASK = "ADDUPGRATESYSMODELTASK";
    public static final String CUSTOMCALL_RAWOFFLINE = "RAWOFFLINE";
    public static final String FIELD_TASKNAME = "TASKNAME";
    public static final String FIELD_TASKTAG = "TASKTAG";
    public static final String FIELD_TASKTAG2 = "TASKTAG2";
    private static final Log log = LogFactory.getLog(PSDevSlnSysDataCtrl.class);

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_UNLOAD, (boolean)true) == 0) {
            return this.unloadSystem(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITSYSMODEL, (boolean)true) == 0) {
            return this.initSysModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_INITSUBSYSMODEL, (boolean)true) == 0) {
            return this.initSubSysModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_PUBSYSDBMODEL, (boolean)true) == 0) {
            return this.pubSysDBModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CHECKSYSMODEL, (boolean)true) == 0) {
            return this.checkSysModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_REBIND, (boolean)true) == 0) {
            return this.rebind(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDBACKUPSYSMODELTASK, (boolean)true) == 0) {
            return this.addBackupSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDONLINESYSMODELTASK, (boolean)true) == 0) {
            return this.addOnlineSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDOFFLINESYSMODELTASK, (boolean)true) == 0) {
            return this.addOfflineSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDBINDSYSMODELTASK, (boolean)true) == 0) {
            return this.addBindSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDEXPORTSYSMODELTASK, (boolean)true) == 0) {
            return this.addExportSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDIMPORTSYSMODELTASK, (boolean)true) == 0) {
            return this.addImportSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDUPGRATESYSMODELTASK, (boolean)true) == 0) {
            return this.addUpgrateSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_RAWOFFLINE, (boolean)true) == 0) {
            return this.rawOffline(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult unloadSystem(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys = new SA.SRFDA.PS.Data.PSDevSlnSys();
            psDevSlnSys.proxy(dataEntity);
            this.onUnloadSystem(psDevSlnSys);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5378\u8f7d\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onUnloadSystem(SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys) throws Exception {
        String strPSDevSlnSysId = psDevSlnSys.getPSDEVSLNSYSID();
        try {
            this.getPSModelStorage().getPSSysDevBKTaskGlobal().resetPSBKTaskSession(strPSDevSlnSysId);
        }
        catch (Exception ex) {
            log.error((Object)ex.getMessage());
        }
        this.getPSModelStorage().resetPSDevSlnSys(strPSDevSlnSysId);
    }

    public CallResult initSysModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys = new SA.SRFDA.PS.Data.PSDevSlnSys();
            psDevSlnSys.proxy(dataEntity);
            this.onInitSysModel(psDevSlnSys);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitSysModel(SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys) throws Exception {
        String strPSDevSlnSysId = psDevSlnSys.getPSDEVSLNSYSID();
        IPSSystem iPSSystem = null;
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b"));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType(CUSTOMCALL_INITSYSMODEL);
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psDevSlnSys.getPSSYSTEMID());
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSDevSlnSysDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }

    public CallResult initSubSysModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys = new SA.SRFDA.PS.Data.PSDevSlnSys();
            psDevSlnSys.proxy(dataEntity);
            this.onInitSubSysModel(psDevSlnSys);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b50\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onInitSubSysModel(SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys) throws Exception {
        String strPSDevSlnSysId = psDevSlnSys.getPSDEVSLNSYSID();
        IPSSystem iPSSystem = null;
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u5bfc\u5165\u5b50\u7cfb\u7edf\u6a21\u578b"));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("IMPSUBSYSMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psDevSlnSys.getPSSYSTEMID());
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSDevSlnSysDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
        iPSSystem = null;
        iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(iPSSystem.getId());
        ArrayList psSystemDBCfgList = psSystemDBCfgService.selectByPSSystem((PSSystemBase)psSystem);
        for (PSSystemDBCfg psSystemDBCfg : psSystemDBCfgList) {
            PSSysDevBKTask psSysDevBKTask3 = new PSSysDevBKTask();
            psSysDevBKTask3.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65\u5b50\u7cfb\u7edf[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSystemDBCfg.getPSSystemDBCfgName()));
            psSysDevBKTask3.setPSDevSlnSysId(strPSDevSlnSysId);
            psSysDevBKTask3.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
            psSysDevBKTask3.setTaskType("SYNCSUBSYSDBMODEL");
            psSysDevBKTask3.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask3.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask3.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask3.setTaskParam(psSystemDBCfg.getPSSystemDBCfgId());
            PSSysDevBKTaskService psSysDevBKTaskService2 = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
            psSysDevBKTaskService2.create((IEntity)psSysDevBKTask3);
            SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask22 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
            PSDevSlnSysDataCtrl.convertEntity((IEntity)psSysDevBKTask3, psSysDevBKTask22);
            this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask22);
        }
    }

    public CallResult pubSysDBModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys = new SA.SRFDA.PS.Data.PSDevSlnSys();
            psDevSlnSys.proxy(dataEntity);
            this.onPubSysDBModel(psDevSlnSys);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521d\u59cb\u5316\u5b50\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onPubSysDBModel(SA.SRFDA.PS.Data.PSDevSlnSys psDevSlnSys) throws Exception {
        String strPSDevSlnSysId = psDevSlnSys.getPSDEVSLNSYSID();
        IPSSystem iPSSystem = null;
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(iPSSystem.getId());
        ArrayList psSystemDBCfgList = psSystemDBCfgService.selectByPSSystem((PSSystemBase)psSystem);
        for (PSSystemDBCfg psSystemDBCfg : psSystemDBCfgList) {
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u91cd\u65b0\u53d1\u5e03\u7cfb\u7edf[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSystemDBCfg.getPSSystemDBCfgName()));
            psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
            psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
            psSysDevBKTask.setTaskType(CUSTOMCALL_PUBSYSDBMODEL);
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask.setTaskParam(psSystemDBCfg.getPSSystemDBCfgId());
            PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
            psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
            SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
            PSDevSlnSysDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
            this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
        }
    }

    protected CallResult OnAfterSaveOK(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnAfterSaveOK(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (!bInsert) {
            return this.updatePSDevSlnSysState(dataEntity);
        }
        return callResult;
    }

    public CallResult updatePSDevSlnSysState(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevSlnSysDataCtrl.this.onUpdatePSDevSlnSysState(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5f00\u53d1\u7cfb\u7edf\u72b6\u6001\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onUpdatePSDevSlnSysState(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSys.setSessionFactory(PSCoreSysServiceBase.getCurMajorSessionFactory());
        String strPSSvrDomainId = null;
        strPSSvrDomainId = psDevSlnSys.getPSDevSln().getPSDevCenter().getPSSvrDomainId();
        if (StringHelper.IsNullOrEmpty((String)strPSSvrDomainId)) {
            strPSSvrDomainId = "DEFAULT";
        }
        psDevSlnSys.set("PSSVRDOMAINID", (Object)strPSSvrDomainId);
        PSCoreEntityKeeperGlobal.getCurrent((SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory()).updatePSDevSlnSys(psDevSlnSys);
    }

    public CallResult checkSysModel(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevSlnSysDataCtrl.this.onCheckSysModel(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u68c0\u67e5\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCheckSysModel(BaseDataEntity dataEntity) throws Exception {
        IPSApplication iPSApplication;
        int nCount;
        String strPSDevSlnSysId = dataEntity.getParamStringValue("PSDEVSLNSYSID", "");
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        StringBuilderEx sBuilderEx = new StringBuilderEx();
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
        if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_ALL) {
            iPSSystem = iPSDevSlnSys.reloadPSSystem(IPSSystem.LOADLEVEL_ALL);
        }
        if ((nCount = iPSSystem.check(0)) > 0) {
            throw new Exception(StringHelper.Format((String)"\u7cfb\u7edf\u6a21\u578b\u5b58\u5728\u9519\u8bef[%1$s]", (Object)nCount));
        }
        ArrayList<String> reloadAppIds = new ArrayList<String>();
        Iterator<IPSApplication> psApplications = iPSSystem.getAllPSApps();
        while (psApplications.hasNext()) {
            iPSApplication = psApplications.next();
            if (iPSApplication.getLoadedLevel() >= IPSSystem.LOADLEVEL_ALL) continue;
            reloadAppIds.add(iPSApplication.getId());
        }
        for (String strPSSysAppId : reloadAppIds) {
            PSSystemUtil.loadPSApplication(iPSSystem, strPSSysAppId, IPSSystem.LOADLEVEL_ALL);
        }
        psApplications = iPSSystem.getAllPSApps();
        while (psApplications.hasNext()) {
            iPSApplication = psApplications.next();
            ((IPSApplicationRuntime)((Object)iPSApplication)).calcPSAppViewSysRefFlag();
        }
        nCount = iPSSystem.check(1);
        if (nCount > 0) {
            throw new Exception(StringHelper.Format((String)"\u7cfb\u7edf\u6a21\u578b\u5b58\u5728\u9519\u8bef[%1$s]", (Object)nCount));
        }
    }

    public CallResult rebind(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            PSBKTaskWorkHelper.execute(new IPSBKTaskWork(){

                @Override
                public void execute(Object obj) throws Exception {
                    PSDevSlnSysDataCtrl.this.onRebind(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u91cd\u65b0\u7ed1\u5b9a\u5f00\u53d1\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onRebind(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.rebindSystem(psDevSlnSys);
    }

    public CallResult addBackupSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDataCtrl.this.onAddBackupSysModelTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u5907\u4efd\u5f00\u53d1\u7cfb\u7edf\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddBackupSysModelTask(BaseDataEntity dataEntity) throws Exception {
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e3a\u5171\u4eab\u6a21\u578b\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5efa\u7acb\u5907\u4efd\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u5907\u4efd\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u5907\u4efd\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        final PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        psDevSlnSysBak.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSysBak.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDevSlnSysBak.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDevSlnSysBak.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
        psDevSlnSysBak.setPSSysModelInstId(psDevSlnSys.getPSSysModelInstId());
        psDevSlnSysBak.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDevSlnSysBak.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDevSlnSysBak.setBackupTime(DateHelper.getCurTime());
        psDevSlnSysBak.setModelVer(psDevSlnSys.getModelInstVer());
        psDevSlnSysBak.setBackupMode(PSTaskServerEnvImpl.getCurrent().getModelBKMode());
        psDevSlnSysBak.setPSDevSlnSysBakName(StringHelper.Format((String)"%1$s[%2$s]\u5907\u4efd", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DateHelper.toDateTimeString((Date)psDevSlnSysBak.getBackupTime())));
        psDevSlnSysBakService.create((IEntity)psDevSlnSysBak);
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("BACKUP");
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
        psDCBKTask.setTaskType("BACKUPDEVSLNSYS");
        psDCBKTask.setTaskParam(psDevSlnSysBak.getPSDevSlnSysId());
        psDCBKTask.setTaskParam2(psDevSlnSysBak.getPSDevSlnSysBakId());
        psDCBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCBKTask.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        String strTaskName = dataEntity.getParamStringValue(FIELD_TASKNAME, null);
        String strTaskTag = dataEntity.getParamStringValue(FIELD_TASKTAG, null);
        String strTaskTag2 = dataEntity.getParamStringValue(FIELD_TASKTAG2, null);
        if (!StringHelper.IsNullOrEmpty((String)strTaskName)) {
            psDCBKTask.setPSDCBKTaskName(strTaskName);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag)) {
            psDCBKTask.setUserTag(strTaskTag);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag2)) {
            psDCBKTask.setUserTag2(strTaskTag2);
        }
        psDCBKTaskService.create((IEntity)psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
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
                    try {
                        String strPSDevSlnSysBakId = psDevSlnSysBak.getPSDevSlnSysBakId();
                        psDevSlnSysBak.reset();
                        psDevSlnSysBak.setPSDevSlnSysBakId(strPSDevSlnSysBakId);
                        psDevSlnSysBak.setBackupState(DBInstBStateCodeListModel.FAILED);
                        psDevSlnSysBakService.sysUpdate((IEntity)psDevSlnSysBak, true);
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

    public CallResult addOnlineSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDataCtrl.this.onAddOnlineSysModelTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u8fde\u7ebf\u5f00\u53d1\u7cfb\u7edf\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddOnlineSysModelTask(BaseDataEntity dataEntity) throws Exception {
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 35) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u8fde\u7ebf\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u8fde\u7ebf\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        final PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        SelectCond selectCond = new SelectCond();
        selectCond.set("PSDEVSLNSYSID", (Object)psDevSlnSys.getPSDevSlnSysId());
        selectCond.set("OFFLINEFLAG", (Object)1);
        selectCond.set("BACKUPSTATE", (Object)30);
        selectCond.set("BACKUPTIME", SelectCond.ISNOTNULL);
        selectCond.setOrderInfo("ORDER BY BACKUPTIME DESC");
        selectCond.setMaxRowCount(1);
        ArrayList psDevSlnSysBakList = psDevSlnSysBakService.select((ISelectCond)selectCond);
        if (psDevSlnSysBakList.size() == 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u65e0\u6cd5\u83b7\u53d6\u6700\u65b0\u5907\u4efd\u6570\u636e\uff0c\u65e0\u6cd5\u5efa\u7acb\u8fde\u7ebf\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        final PSDevSlnSysBak psDevSlnSysBak = (PSDevSlnSysBak)psDevSlnSysBakList.get(0);
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("ONLINE");
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
        psDCBKTask.setTaskType("ONLINEDEVSLNSYS");
        psDCBKTask.setTaskParam(psDevSlnSysBak.getPSDevSlnSysId());
        psDCBKTask.setTaskParam2(psDevSlnSysBak.getPSDevSlnSysBakId());
        psDCBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCBKTask.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        String strTaskName = dataEntity.getParamStringValue(FIELD_TASKNAME, null);
        String strTaskTag = dataEntity.getParamStringValue(FIELD_TASKTAG, null);
        String strTaskTag2 = dataEntity.getParamStringValue(FIELD_TASKTAG2, null);
        if (!StringHelper.IsNullOrEmpty((String)strTaskName)) {
            psDCBKTask.setPSDCBKTaskName(strTaskName);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag)) {
            psDCBKTask.setUserTag(strTaskTag);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag2)) {
            psDCBKTask.setUserTag2(strTaskTag2);
        }
        psDCBKTaskService.create((IEntity)psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
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
                    try {
                        String strPSDevSlnSysBakId = psDevSlnSysBak.getPSDevSlnSysBakId();
                        psDevSlnSysBak.reset();
                        psDevSlnSysBak.setPSDevSlnSysBakId(strPSDevSlnSysBakId);
                        psDevSlnSysBak.setBackupState(DBInstBStateCodeListModel.FAILED);
                        psDevSlnSysBakService.sysUpdate((IEntity)psDevSlnSysBak, true);
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

    public CallResult addOfflineSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDataCtrl.this.onAddOfflineSysModelTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u79bb\u7ebf\u5f00\u53d1\u7cfb\u7edf\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddOfflineSysModelTaskOld(BaseDataEntity dataEntity) throws Exception {
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u79bb\u7ebf\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u79bb\u7ebf\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        final PSDevSlnSysBakService psDevSlnSysBakService = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSysBak psDevSlnSysBak = new PSDevSlnSysBak();
        psDevSlnSysBak.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSysBak.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDevSlnSysBak.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDevSlnSysBak.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
        psDevSlnSysBak.setPSSysModelInstId(psDevSlnSys.getPSSysModelInstId());
        psDevSlnSysBak.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDevSlnSysBak.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDevSlnSysBak.setModelVer(psDevSlnSys.getModelInstVer());
        psDevSlnSysBak.setBackupTime(DateHelper.getCurTime());
        psDevSlnSysBak.setPSDevSlnSysBakName(StringHelper.Format((String)"%1$s[%2$s]\u79bb\u7ebf\u5907\u4efd", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DateHelper.toDateTimeString((Date)psDevSlnSysBak.getBackupTime())));
        psDevSlnSysBak.setOfflineFlag(Integer.valueOf(1));
        psDevSlnSysBakService.create((IEntity)psDevSlnSysBak);
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("OFFLINE");
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
        psDCBKTask.setTaskType("OFFLINEDEVSLNSYS");
        psDCBKTask.setTaskParam(psDevSlnSysBak.getPSDevSlnSysId());
        psDCBKTask.setTaskParam2(psDevSlnSysBak.getPSDevSlnSysBakId());
        psDCBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCBKTask.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        String strTaskName = dataEntity.getParamStringValue(FIELD_TASKNAME, null);
        String strTaskTag = dataEntity.getParamStringValue(FIELD_TASKTAG, null);
        String strTaskTag2 = dataEntity.getParamStringValue(FIELD_TASKTAG2, null);
        if (!StringHelper.IsNullOrEmpty((String)strTaskName)) {
            psDCBKTask.setPSDCBKTaskName(strTaskName);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag)) {
            psDCBKTask.setUserTag(strTaskTag);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag2)) {
            psDCBKTask.setUserTag2(strTaskTag2);
        }
        psDCBKTaskService.create((IEntity)psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
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
                    try {
                        String strPSDevSlnSysBakId = psDevSlnSysBak.getPSDevSlnSysBakId();
                        psDevSlnSysBak.reset();
                        psDevSlnSysBak.setPSDevSlnSysBakId(strPSDevSlnSysBakId);
                        psDevSlnSysBak.setBackupState(DBInstBStateCodeListModel.FAILED);
                        psDevSlnSysBakService.sysUpdate((IEntity)psDevSlnSysBak, true);
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

    public CallResult addBindSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDataCtrl.this.onAddBindSysModelTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u7ed1\u5b9a\u5f00\u53d1\u7cfb\u7edf\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddBindSysModelTask(BaseDataEntity dataEntity) throws Exception {
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 20) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u7ed1\u5b9a\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u7ed1\u5b9a\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("CREATE");
        psDevSlnSys2.setActionOwner(StringHelper.Format((String)"%1$s|%2$s", (Object)psDevSlnSysService.getDEModel().getName(), (Object)psDevSlnSys.getPSDevSlnSysId()));
        EntityBase.setLastUpdateDate((IEntity)psDevSlnSys2, (Timestamp)psDevSlnSys.getUpdateDate());
        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDCBKTask.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
        psDCBKTask.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCBKTask.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDCBKTask.setPSDCBKTaskName(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u7ed1\u5b9a\u6a21\u578b", (Object)psDevSlnSys.getPSDevSlnSysName()));
        psDCBKTask.setOrderValue(Integer.valueOf(100));
        psDCBKTask.setTaskType("CREATEDEVSLNSYS2");
        psDCBKTask.setTaskParam(psDevSlnSys.getPSDevSlnSysId());
        psDCBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCBKTask.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        String strTaskName = dataEntity.getParamStringValue(FIELD_TASKNAME, null);
        String strTaskTag = dataEntity.getParamStringValue(FIELD_TASKTAG, null);
        String strTaskTag2 = dataEntity.getParamStringValue(FIELD_TASKTAG2, null);
        if (!StringHelper.IsNullOrEmpty((String)strTaskName)) {
            psDCBKTask.setPSDCBKTaskName(strTaskName);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag)) {
            psDCBKTask.setUserTag(strTaskTag);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag2)) {
            psDCBKTask.setUserTag2(strTaskTag2);
        }
        psDCBKTaskService.create((IEntity)psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
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
                    try {
                        String strPSDevSlnSysId = psDevSlnSys.getPSDevSlnSysId();
                        psDevSlnSys.reset();
                        psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
                        psDevSlnSys.setDevSysState(Integer.valueOf(42));
                        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys, true);
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

    public CallResult addExportSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDataCtrl.this.onAddExportSysModelTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u5bfc\u51fa\u5f00\u53d1\u7cfb\u7edf\u6a21\u578b\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddExportSysModelTask(BaseDataEntity dataEntity) throws Exception {
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e3a\u5171\u4eab\u6a21\u578b\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bfc\u51fa\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bfc\u51fa\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bfc\u51fa\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        if (StringHelper.IsNullOrEmpty((String)psDevSlnSys.getModelPSDevCenterSVNId())) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6ca1\u6709\u6307\u5b9a\u6a21\u578b\u5bfc\u51fa\u4ed3\u5e93\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bfc\u51fa\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        final PSDCSysInstActionService psDCSysInstActionService = (PSDCSysInstActionService)ServiceGlobal.getService(PSDCSysInstActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDCSysInstAction psDCSysInstAction = new PSDCSysInstAction();
        psDCSysInstAction.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCSysInstAction.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDCSysInstAction.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCSysInstAction.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCSysInstAction.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDCSysInstAction.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
        psDCSysInstAction.setActionParam(psDevSlnSys.getPSSysModelInstId());
        psDCSysInstAction.setActionType("EXPORTMODEL");
        psDCSysInstAction.setActionState(BackendActionStateCodeListModel.NOTCREATED);
        psDCSysInstAction.setPSDCSysInstActionName(StringHelper.Format((String)"%1$s[%2$s]\u6a21\u578b\u5bfc\u51fa", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DateHelper.toDateTimeString((Date)new Date())));
        psDCSysInstActionService.create((IEntity)psDCSysInstAction);
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("EXPORT");
        psDevSlnSys2.setActionOwner(StringHelper.Format((String)"%1$s|%2$s", (Object)psDCSysInstActionService.getDEModel().getName(), (Object)psDCSysInstAction.getPSDCSysInstActionId()));
        EntityBase.setLastUpdateDate((IEntity)psDevSlnSys2, (Timestamp)psDevSlnSys.getUpdateDate());
        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDevCenterId(psDCSysInstAction.getPSDevCenterId());
        psDCBKTask.setPSDevCenterName(psDCSysInstAction.getPSDevCenterName());
        psDCBKTask.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCBKTask.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDCBKTask.setPSDCBKTaskName(psDCSysInstAction.getPSDCSysInstActionName());
        psDCBKTask.setOrderValue(Integer.valueOf(100));
        psDCBKTask.setTaskType("EXPORTDEVSYSMODEL");
        psDCBKTask.setTaskParam(psDCSysInstAction.getPSDevSlnSysId());
        psDCBKTask.setTaskParam2(psDCSysInstAction.getPSDCSysInstActionId());
        psDCBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCBKTask.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        String strTaskName = dataEntity.getParamStringValue(FIELD_TASKNAME, null);
        String strTaskTag = dataEntity.getParamStringValue(FIELD_TASKTAG, null);
        String strTaskTag2 = dataEntity.getParamStringValue(FIELD_TASKTAG2, null);
        if (!StringHelper.IsNullOrEmpty((String)strTaskName)) {
            psDCBKTask.setPSDCBKTaskName(strTaskName);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag)) {
            psDCBKTask.setUserTag(strTaskTag);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag2)) {
            psDCBKTask.setUserTag2(strTaskTag2);
        }
        psDCBKTaskService.create((IEntity)psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
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
                    try {
                        String strPSDCSysInstActionId = psDCSysInstAction.getPSDCSysInstActionId();
                        psDCSysInstAction.reset();
                        psDCSysInstAction.setPSDCSysInstActionId(strPSDCSysInstActionId);
                        psDCSysInstAction.setActionState(BackendActionStateCodeListModel.FAILED);
                        psDCSysInstActionService.sysUpdate((IEntity)psDCSysInstAction, true);
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

    public CallResult addImportSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDataCtrl.this.onAddImportSysModelTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u5bfc\u5165\u5f00\u53d1\u7cfb\u7edf\u6a21\u578b\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddImportSysModelTask(BaseDataEntity dataEntity) throws Exception {
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e3a\u5171\u4eab\u6a21\u578b\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bfc\u5165\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bfc\u5165\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bfc\u5165\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        if (StringHelper.IsNullOrEmpty((String)psDevSlnSys.getModelPSDevCenterSVNId())) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6ca1\u6709\u6307\u5b9a\u6a21\u578b\u5bfc\u5165\u4ed3\u5e93\uff0c\u65e0\u6cd5\u5efa\u7acb\u5bfc\u5165\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        final PSDCSysInstActionService psDCSysInstActionService = (PSDCSysInstActionService)ServiceGlobal.getService(PSDCSysInstActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDCSysInstAction psDCSysInstAction = new PSDCSysInstAction();
        psDCSysInstAction.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCSysInstAction.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDCSysInstAction.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCSysInstAction.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCSysInstAction.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDCSysInstAction.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
        psDCSysInstAction.setActionParam(psDevSlnSys.getPSSysModelInstId());
        psDCSysInstAction.setActionType("IMPORTMODEL");
        psDCSysInstAction.setActionState(BackendActionStateCodeListModel.NOTCREATED);
        psDCSysInstAction.setPSDCSysInstActionName(StringHelper.Format((String)"%1$s[%2$s]\u6a21\u578b\u5bfc\u5165", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DateHelper.toDateTimeString((Date)new Date())));
        psDCSysInstActionService.create((IEntity)psDCSysInstAction);
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("IMPORT");
        psDevSlnSys2.setActionOwner(StringHelper.Format((String)"%1$s|%2$s", (Object)psDCSysInstActionService.getDEModel().getName(), (Object)psDCSysInstAction.getPSDCSysInstActionId()));
        EntityBase.setLastUpdateDate((IEntity)psDevSlnSys2, (Timestamp)psDevSlnSys.getUpdateDate());
        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDevCenterId(psDCSysInstAction.getPSDevCenterId());
        psDCBKTask.setPSDevCenterName(psDCSysInstAction.getPSDevCenterName());
        psDCBKTask.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCBKTask.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDCBKTask.setPSDCBKTaskName(psDCSysInstAction.getPSDCSysInstActionName());
        psDCBKTask.setOrderValue(Integer.valueOf(100));
        psDCBKTask.setTaskType("IMPORTDEVSYSMODEL");
        psDCBKTask.setTaskParam(psDCSysInstAction.getPSDevSlnSysId());
        psDCBKTask.setTaskParam2(psDCSysInstAction.getPSDCSysInstActionId());
        psDCBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCBKTask.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        String strTaskName = dataEntity.getParamStringValue(FIELD_TASKNAME, null);
        String strTaskTag = dataEntity.getParamStringValue(FIELD_TASKTAG, null);
        String strTaskTag2 = dataEntity.getParamStringValue(FIELD_TASKTAG2, null);
        if (!StringHelper.IsNullOrEmpty((String)strTaskName)) {
            psDCBKTask.setPSDCBKTaskName(strTaskName);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag)) {
            psDCBKTask.setUserTag(strTaskTag);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag2)) {
            psDCBKTask.setUserTag2(strTaskTag2);
        }
        psDCBKTaskService.create((IEntity)psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
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
                    try {
                        String strPSDCSysInstActionId = psDCSysInstAction.getPSDCSysInstActionId();
                        psDCSysInstAction.reset();
                        psDCSysInstAction.setPSDCSysInstActionId(strPSDCSysInstActionId);
                        psDCSysInstAction.setActionState(BackendActionStateCodeListModel.FAILED);
                        psDCSysInstActionService.sysUpdate((IEntity)psDCSysInstAction, true);
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

    public CallResult addUpgrateSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDataCtrl.this.onAddUpgrateSysModelTask(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u521b\u5efa\u5347\u7ea7\u5f00\u53d1\u7cfb\u7edf\u6a21\u578b\u4ed3\u5e93\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddUpgrateSysModelTask(BaseDataEntity dataEntity) throws Exception {
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e3a\u5171\u4eab\u6a21\u578b\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5efa\u7acb\u5347\u7ea7\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u5347\u7ea7\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u5347\u7ea7\u6a21\u578b\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        final PSDCSysInstActionService psDCSysInstActionService = (PSDCSysInstActionService)ServiceGlobal.getService(PSDCSysInstActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDCSysInstAction psDCSysInstAction = new PSDCSysInstAction();
        psDCSysInstAction.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCSysInstAction.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDCSysInstAction.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCSysInstAction.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCSysInstAction.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDCSysInstAction.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
        psDCSysInstAction.setActionParam(psDevSlnSys.getPSSysModelInstId());
        psDCSysInstAction.setActionType("UPGRATE");
        psDCSysInstAction.setActionState(BackendActionStateCodeListModel.NOTCREATED);
        psDCSysInstAction.setPSDCSysInstActionName(StringHelper.Format((String)"%1$s[%2$s]\u6a21\u578b\u5347\u7ea7", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DateHelper.toDateTimeString((Date)new Date())));
        psDCSysInstActionService.create((IEntity)psDCSysInstAction);
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("UPGRATE");
        psDevSlnSys2.setActionOwner(StringHelper.Format((String)"%1$s|%2$s", (Object)psDCSysInstActionService.getDEModel().getName(), (Object)psDCSysInstAction.getPSDCSysInstActionId()));
        EntityBase.setLastUpdateDate((IEntity)psDevSlnSys2, (Timestamp)psDevSlnSys.getUpdateDate());
        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        int i = 0;
        while (i < 5) {
            String strKey = KeyValueHelper.genUniqueId((String)"UPGRATEDEVSYSMODEL", (String)psDCSysInstAction.getPSDevSlnSysId(), (String)Integer.toString(Version.MODEL), (String)Integer.toString(i));
            PSDCBKTask psDCBKTask2 = new PSDCBKTask();
            psDCBKTask2.setPSDCBKTaskId(strKey);
            if (!psDCBKTaskService.get((IEntity)psDCBKTask2, true)) {
                psDCBKTask.setPSDCBKTaskId(strKey);
                break;
            }
            ++i;
        }
        psDCBKTask.setPSDevCenterId(psDCSysInstAction.getPSDevCenterId());
        psDCBKTask.setPSDevCenterName(psDCSysInstAction.getPSDevCenterName());
        psDCBKTask.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCBKTask.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDCBKTask.setPSDCBKTaskName(psDCSysInstAction.getPSDCSysInstActionName());
        psDCBKTask.setOrderValue(Integer.valueOf(100));
        psDCBKTask.setTaskType("UPGRATEDEVSYSMODEL");
        psDCBKTask.setTaskParam(psDCSysInstAction.getPSDevSlnSysId());
        psDCBKTask.setTaskParam2(psDCSysInstAction.getPSDCSysInstActionId());
        psDCBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCBKTask.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        String strTaskName = dataEntity.getParamStringValue(FIELD_TASKNAME, null);
        String strTaskTag = dataEntity.getParamStringValue(FIELD_TASKTAG, null);
        String strTaskTag2 = dataEntity.getParamStringValue(FIELD_TASKTAG2, null);
        if (!StringHelper.IsNullOrEmpty((String)strTaskName)) {
            psDCBKTask.setPSDCBKTaskName(strTaskName);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag)) {
            psDCBKTask.setUserTag(strTaskTag);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag2)) {
            psDCBKTask.setUserTag2(strTaskTag2);
        }
        psDCBKTaskService.create((IEntity)psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
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
                    try {
                        String strPSDCSysInstActionId = psDCSysInstAction.getPSDCSysInstActionId();
                        psDCSysInstAction.reset();
                        psDCSysInstAction.setPSDCSysInstActionId(strPSDCSysInstActionId);
                        psDCSysInstAction.setActionState(BackendActionStateCodeListModel.FAILED);
                        psDCSysInstActionService.sysUpdate((IEntity)psDCSysInstAction, true);
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

    protected void onAddOfflineSysModelTask(BaseDataEntity dataEntity) throws Exception {
        final PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.get((IEntity)psDevSlnSys);
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false)) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e3a\u5171\u4eab\u6a21\u578b\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5efa\u7acb\u7cfb\u7edf\u79bb\u7ebf\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName()));
        }
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != 30) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb\u7cfb\u7edf\u79bb\u7ebf\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText()));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb\u7cfb\u7edf\u79bb\u7ebf\u4efb\u52a1", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText()));
        }
        final PSDCSysInstActionService psDCSysInstActionService = (PSDCSysInstActionService)ServiceGlobal.getService(PSDCSysInstActionService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        final PSDCSysInstAction psDCSysInstAction = new PSDCSysInstAction();
        psDCSysInstAction.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCSysInstAction.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        psDCSysInstAction.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCSysInstAction.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCSysInstAction.setPSDevCenterId(psDevSlnSys.getPSDevCenterId());
        psDCSysInstAction.setPSDevCenterName(psDevSlnSys.getPSDevCenterName());
        psDCSysInstAction.setActionParam(psDevSlnSys.getPSSysModelInstId());
        psDCSysInstAction.setActionType("OFFLINESYS");
        psDCSysInstAction.setActionState(BackendActionStateCodeListModel.NOTCREATED);
        psDCSysInstAction.setPSDCSysInstActionName(StringHelper.Format((String)"%1$s[%2$s]\u7cfb\u7edf\u79bb\u7ebf", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DateHelper.toDateTimeString((Date)new Date())));
        psDCSysInstActionService.create((IEntity)psDCSysInstAction);
        final PSDevSlnSys psDevSlnSys2 = new PSDevSlnSys();
        psDevSlnSys2.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDevSlnSys2.setCurAction("OFFLINE");
        psDevSlnSys2.setActionOwner(StringHelper.Format((String)"%1$s|%2$s", (Object)psDCSysInstActionService.getDEModel().getName(), (Object)psDCSysInstAction.getPSDCSysInstActionId()));
        EntityBase.setLastUpdateDate((IEntity)psDevSlnSys2, (Timestamp)psDevSlnSys.getUpdateDate());
        psDevSlnSysService.sysUpdate((IEntity)psDevSlnSys2, true);
        PSDCBKTaskService psDCBKTaskService = (PSDCBKTaskService)ServiceGlobal.getService(PSDCBKTaskService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDCBKTask psDCBKTask = new PSDCBKTask();
        psDCBKTask.setPSDevCenterId(psDCSysInstAction.getPSDevCenterId());
        psDCBKTask.setPSDevCenterName(psDCSysInstAction.getPSDevCenterName());
        psDCBKTask.setPSDevSlnId(psDevSlnSys.getPSDevSlnId());
        psDCBKTask.setPSDevSlnName(psDevSlnSys.getPSDevSlnName());
        psDCBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
        psDCBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        psDCBKTask.setPSDCBKTaskName(psDCSysInstAction.getPSDCSysInstActionName());
        psDCBKTask.setOrderValue(Integer.valueOf(100));
        psDCBKTask.setTaskType("OFFLINEDEVSLNSYS");
        psDCBKTask.setTaskParam(psDCSysInstAction.getPSDevSlnSysId());
        psDCBKTask.setTaskParam2(psDCSysInstAction.getPSDCSysInstActionId());
        psDCBKTask.setPSDevSlnSysId(psDevSlnSys.getPSDevSlnSysId());
        psDCBKTask.setPSDevSlnSysName(psDevSlnSys.getPSDevSlnSysName());
        String strTaskName = dataEntity.getParamStringValue(FIELD_TASKNAME, null);
        String strTaskTag = dataEntity.getParamStringValue(FIELD_TASKTAG, null);
        String strTaskTag2 = dataEntity.getParamStringValue(FIELD_TASKTAG2, null);
        if (!StringHelper.IsNullOrEmpty((String)strTaskName)) {
            psDCBKTask.setPSDCBKTaskName(strTaskName);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag)) {
            psDCBKTask.setUserTag(strTaskTag);
        }
        if (!StringHelper.IsNullOrEmpty((String)strTaskTag2)) {
            psDCBKTask.setUserTag2(strTaskTag2);
        }
        psDCBKTaskService.create((IEntity)psDCBKTask);
        final SA.SRFDA.PS.Data.PSDCBKTask psDCBKTask2 = new SA.SRFDA.PS.Data.PSDCBKTask();
        PSDEDataCtrl.convertEntity((IEntity)psDCBKTask, psDCBKTask2);
        SessionFactoryManager.getCurrentSFS().registerSFSAction(psDCBKTaskService.getRealSessionFactory(), new ISFSAction(){

            public void commit() {
                try {
                    PSDevSlnSysDataCtrl.this.getPSModelStorage().getPSDevCenterBKTaskGlobal().addPSDCBKTask(psDCBKTask2);
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
                    try {
                        String strPSDCSysInstActionId = psDCSysInstAction.getPSDCSysInstActionId();
                        psDCSysInstAction.reset();
                        psDCSysInstAction.setPSDCSysInstActionId(strPSDCSysInstActionId);
                        psDCSysInstAction.setActionState(BackendActionStateCodeListModel.FAILED);
                        psDCSysInstActionService.sysUpdate((IEntity)psDCSysInstAction, true);
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

    protected void checkPSDevSlnSys(PSDevSlnSys psDevSlnSys, boolean bAllowShareMode, int nMustState, String strTask) throws Exception {
        this.checkPSDevSlnSysSimple(psDevSlnSys, bAllowShareMode, nMustState, strTask);
        if (psDevSlnSys.getExpriedTime() != null && psDevSlnSys.getExpriedTime().getTime() < System.currentTimeMillis()) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5df2\u7ecf\u8fc7\u671f\uff0c\u65e0\u6cd5\u5efa\u7acb[%2$s]", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)strTask));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getPSDCWorkspaceId())) {
            PSDCWorkspaceService psDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
            PSDCWorkspace psDCWorkspace = new PSDCWorkspace();
            psDCWorkspace.setPSDCWorkspaceId(psDevSlnSys.getPSDCWorkspaceId());
            if (!psDCWorkspaceService.get((IEntity)psDCWorkspace, true)) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u7ed1\u5b9a\u751f\u4ea7\u7ebf\u4e0d\u5b58\u5728\uff0c\u65e0\u6cd5\u5efa\u7acb[%2$s]", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)strTask));
            }
            int nResState = DataObject.getIntegerValue((Object)psDCWorkspace.getResState(), (Integer)20);
            if (nResState != 20) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u7ed1\u5b9a\u751f\u4ea7\u7ebf\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb[%3$s]", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevCenterResStateCodeListModel.getInstance().getCodeListText(Integer.toString(nResState), true), (Object)strTask));
            }
            if (psDCWorkspace.getExpiredTime() != null && psDCWorkspace.getExpiredTime().getTime() < System.currentTimeMillis()) {
                throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u7ed1\u5b9a\u751f\u4ea7\u7ebf\u5df2\u7ecf\u8fc7\u671f\uff0c\u65e0\u6cd5\u5efa\u7acb[%2$s]", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)strTask));
            }
        }
    }

    protected void checkPSDevSlnSysSimple(PSDevSlnSys psDevSlnSys, boolean bAllowShareMode, int nMustState, String strTask) throws Exception {
        if (DataObject.getBoolValue((Integer)psDevSlnSys.getShareFlag(), (boolean)false) && !bAllowShareMode) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u4e3a\u5171\u4eab\u6a21\u578b\u7cfb\u7edf\uff0c\u65e0\u6cd5\u5efa\u7acb[%2$s]", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)strTask));
        }
        if (DataObject.getIntegerValue((Object)psDevSlnSys.getDevSysState(), (Integer)30) != nMustState) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u5f53\u524d\u72b6\u6001[%2$s]\uff0c\u65e0\u6cd5\u5efa\u7acb[%3$s]", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysStateCodeListModel.getInstance().getCodeItem(psDevSlnSys.getDevSysState().toString()).getText(), (Object)strTask));
        }
        if (!StringHelper.IsNullOrEmpty((String)psDevSlnSys.getCurAction()) && StringHelper.Compare((String)psDevSlnSys.getCurAction(), (String)"NONE", (boolean)true) != 0) {
            throw new Exception(StringHelper.Format((String)"\u5f00\u53d1\u7cfb\u7edf[%1$s]\u6b63\u5728\u8fdb\u884c[%2$s]\u64cd\u4f5c\uff0c\u65e0\u6cd5\u5efa\u7acb[%3$s]", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)DevSysActionCodeListModel.getInstance().getCodeItem(psDevSlnSys.getCurAction()).getText(), (Object)strTask));
        }
    }

    public CallResult rawOffline(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final BaseDataEntity dataEntity2 = dataEntity;
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSDevSlnSysDataCtrl.this.onRawOffline(dataEntity2);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u76f4\u63a5\u79bb\u7ebf\u7cfb\u7edf\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onRawOffline(BaseDataEntity dataEntity) throws Exception {
        PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)PSCoreSysServiceBase.getCurMajorSessionFactory());
        PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
        PSDEDataCtrl.convertEntity2(dataEntity, (IEntity)psDevSlnSys);
        psDevSlnSysService.rawOffline(psDevSlnSys);
    }
}

