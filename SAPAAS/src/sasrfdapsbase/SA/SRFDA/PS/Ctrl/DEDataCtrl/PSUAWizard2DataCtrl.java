/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.Data.DEField
 *  SA.SRFDA.Ctrl.Data.LoginAccount
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFDA.Web.Utility.ISRFDAGlobalHelper
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.core.DEDataSetCond
 *  net.ibizsys.paas.core.DEDataSetFetchContext
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.data.ISimpleDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.IDataRow
 *  net.ibizsys.paas.db.IDataTable
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.StringBuilderEx
 *  net.ibizsys.paas.web.IWebContext
 *  net.ibizsys.paas.web.WebContext
 *  net.ibizsys.paas.web.util.SimpleWebContext
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst
 *  net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystem
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.Data.DEField;
import SA.SRFDA.Ctrl.Data.LoginAccount;
import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.App.IPSApplication;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPFStylePrj;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.IPSSysSFPub;
import SA.SRFDA.PS.Core.SF.IPSSFStylePrj;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSUAWizard2;
import SA.SRFDA.Web.Utility.ISRFDAGlobalHelper;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.core.DEDataSetCond;
import net.ibizsys.paas.core.DEDataSetFetchContext;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.ISimpleDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.IDataRow;
import net.ibizsys.paas.db.IDataTable;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.web.IWebContext;
import net.ibizsys.paas.web.WebContext;
import net.ibizsys.paas.web.util.SimpleWebContext;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSVNInstRepo;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPub;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPubService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSUAWizard2DataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSUAWizard2DataCtrl.class);
    public static final String CUSTOMCALL_ADDINITSYSMODELTASK = "ADDINITSYSMODELTASK";
    public static final String CUSTOMCALL_ADDINITSYSDEDBMODELTASK = "ADDINITSYSDEDBMODELTASK";
    public static final String CUSTOMCALL_ADDIMPSUBSYSMODELTASK = "ADDIMPSUBSYSMODELTASK";
    public static final String CUSTOMCALL_CHANGEPWD = "CHANGEPWD";
    public static final String CUSTOMCALL_ADDSYNCSUBSYSDBMODELTASK = "ADDSYNCSUBSYSDBMODELTASK";
    public static final String CUSTOMCALL_ADDINITAPPMODELTASK = "ADDINITAPPMODELTASK";
    public static final String CUSTOMCALL_CREATEUSER = "CREATEUSER";
    public static final String CUSTOMCALL_USERACTION2 = "USERACTION2";
    public static final String CUSTOMCALL_UPDATESVNAUTHZ = "UPDATESVNAUTHZ";
    public static final String CUSTOMCALL_GETSYSDEVENVINFO = "GETSYSDEVENVINFO";
    public static final String CUSTOMCALL_LISTDEVSLNSYS = "LISTDEVSLNSYS";

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDINITSYSMODELTASK, (boolean)true) == 0) {
            return this.addInitSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDINITSYSDEDBMODELTASK, (boolean)true) == 0) {
            return this.addInitSysDEDBModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CHANGEPWD, (boolean)true) == 0) {
            return this.changePwd(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDIMPSUBSYSMODELTASK, (boolean)true) == 0) {
            return this.addImpSubSysModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDSYNCSUBSYSDBMODELTASK, (boolean)true) == 0) {
            return this.addSyncSubSysDBModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDINITAPPMODELTASK, (boolean)true) == 0) {
            return this.addInitAppModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_CREATEUSER, (boolean)true) == 0) {
            return this.createUser(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_USERACTION2, (boolean)true) == 0) {
            return this.userAction2();
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_UPDATESVNAUTHZ, (boolean)true) == 0) {
            return this.updateSVNAuthZ(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_GETSYSDEVENVINFO, (boolean)true) == 0) {
            return this.getSysDevEnvInfo(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_LISTDEVSLNSYS, (boolean)true) == 0) {
            return this.listDevSlnSys(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult addInitSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSUAWizard2 psUAWizard2 = new PSUAWizard2();
            psUAWizard2.proxy(dataEntity);
            this.onAddInitSysModelTask(psUAWizard2);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddInitSysModelTask(PSUAWizard2 psUAWizard2) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psUAWizard2.getParamStringValue("PSDEVSLNSYSID", "");
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u6a21\u578b"));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("INITSYSMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psUAWizard2.getACTIONDATA());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSUAWizard2DataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }

    public CallResult addInitSysDEDBModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSUAWizard2 psUAWizard2 = new PSUAWizard2();
            psUAWizard2.proxy(dataEntity);
            this.onAddInitSysDEDBModelTask(psUAWizard2);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u521d\u59cb\u5316\u7cfb\u7edf\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddInitSysDEDBModelTask(PSUAWizard2 psUAWizard2) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psUAWizard2.getParamStringValue("PSDEVSLNSYSID", "");
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u521d\u59cb\u5316\u7cfb\u7edf\u5b9e\u4f53\u6570\u636e\u5e93\u914d\u7f6e"));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("INITSYSDEDBCFG");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psUAWizard2.getACTIONDATA());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSUAWizard2DataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }

    public CallResult changePwd(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSUAWizard2 psUAWizard2 = new PSUAWizard2();
            psUAWizard2.proxy(dataEntity);
            this.onChangePwd(psUAWizard2);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u4fee\u590d\u5bc6\u7801\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onChangePwd(PSUAWizard2 psUAWizard2) throws Exception {
        String strLoginName = psUAWizard2.getParamStringValue("LOGINNAME", "");
        String strOldPassword = psUAWizard2.getParamStringValue("ORIPASSWORD", "");
        String strNewPassword = psUAWizard2.getParamStringValue("NEWPASSWORD", "");
        boolean bUpdateLoginAccount = psUAWizard2.GetParamBoolValue("UPDATELOGINACCOUNT", true);
        if (bUpdateLoginAccount) {
            IDEDataCtrl loginAccountDataCtrl = this.GetRelatedDataCtrl("DE0142");
            LoginAccount loginAccount = new LoginAccount();
            loginAccount.setLOGINACCOUNTNAME(strLoginName);
            CallResult callResult = loginAccountDataCtrl.Select((BaseDataEntity)loginAccount);
            if (callResult.isError()) {
                throw new Exception("\u767b\u5f55\u8d26\u6237\u65e0\u6548");
            }
            if (StringHelper.Compare((String)loginAccount.getPWD(), (String)strOldPassword, (boolean)false) != 0) {
                throw new Exception("\u539f\u767b\u5f55\u5bc6\u7801\u4e0d\u4e00\u81f4");
            }
            LoginAccount loginAccount2 = new LoginAccount();
            loginAccount2.setLOGINACCOUNTID(loginAccount.getLOGINACCOUNTID());
            loginAccount2.setPWD(strNewPassword);
            callResult = loginAccountDataCtrl.Save(false, (BaseDataEntity)loginAccount2);
            if (callResult.isError()) {
                throw new Exception(callResult.getErrorInfo());
            }
        }
        if (this.getPSModelStorage().getPSUserMgrAPI() != null) {
            this.getPSModelStorage().getPSUserMgrAPI().changeUserPwd(strLoginName, strNewPassword, strOldPassword);
        }
    }

    public CallResult updateSVNAuthZ(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            this.onUpdateSVNAuthZ(dataEntity);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0SVN\u670d\u52a1\u5668\u8ba4\u8bc1\u6587\u4ef6\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onUpdateSVNAuthZ(BaseDataEntity dataEntity) throws Exception {
        UpdateSVNAuthZThread updateSVNAuthZThread = new UpdateSVNAuthZThread(this.getGlobalHelper(), dataEntity);
        updateSVNAuthZThread.start();
    }

    public CallResult addImpSubSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSUAWizard2 psUAWizard2 = new PSUAWizard2();
            psUAWizard2.proxy(dataEntity);
            this.onAddImpSubSysModelTask(psUAWizard2);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5bfc\u5165\u5b50\u7cfb\u7edf\u6a21\u578b\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddImpSubSysModelTask(PSUAWizard2 psUAWizard2) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psUAWizard2.getParamStringValue("PSDEVSLNSYSID", "");
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u5bfc\u5165\u5b50\u7cfb\u7edf\u6a21\u578b"));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("IMPSUBSYSMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psUAWizard2.getACTIONDATA());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSUAWizard2DataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }

    public CallResult addSyncSubSysDBModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSUAWizard2 psUAWizard2 = new PSUAWizard2();
            psUAWizard2.proxy(dataEntity);
            this.onAddSyncSubSysDBModelTask(psUAWizard2);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u540c\u6b65\u5b50\u7cfb\u7edf\u6570\u636e\u7ed3\u6784\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddSyncSubSysDBModelTask(PSUAWizard2 psUAWizard2) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psUAWizard2.getParamStringValue("PSDEVSLNSYSID", "");
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(iPSSystem.getId());
        ArrayList psSystemDBCfgList = psSystemDBCfgService.selectByPSSystem((PSSystemBase)psSystem);
        for (PSSystemDBCfg psSystemDBCfg : psSystemDBCfgList) {
            PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
            psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65\u5b50\u7cfb\u7edf[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSystemDBCfg.getPSSystemDBCfgName()));
            psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
            if (PSTaskServerEnvImpl.getCurrent() != null) {
                psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
                psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
            }
            psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
            psSysDevBKTask.setTaskType("SYNCSUBSYSDBMODEL");
            psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
            psSysDevBKTask.setPSSystemId(iPSSystem.getId());
            psSysDevBKTask.setPSSystemName(iPSSystem.getName());
            psSysDevBKTask.setTaskParam(psSystemDBCfg.getPSSystemDBCfgId());
            psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
            PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
            psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
            SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
            PSUAWizard2DataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
            this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
        }
    }

    public CallResult addInitAppModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSUAWizard2 psUAWizard2 = new PSUAWizard2();
            psUAWizard2.proxy(dataEntity);
            this.onAddInitAppModelTask(psUAWizard2);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u521d\u59cb\u5316\u5e94\u7528\u6a21\u578b\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddInitAppModelTask(PSUAWizard2 psUAWizard2) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psUAWizard2.getParamStringValue("PSDEVSLNSYSID", "");
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u521d\u59cb\u5316\u5e94\u7528\u6a21\u578b"));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("INITAPPMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psUAWizard2.getACTIONDATA());
        psSysDevBKTask.setTaskParam2(psUAWizard2.getPARAM5());
        psSysDevBKTask.setTaskParam3(psUAWizard2.getPARAM6());
        psSysDevBKTask.setTaskParam4(psUAWizard2.getPARAM7());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSUAWizard2DataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }

    public CallResult createUser(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSUAWizard2 psUAWizard2 = new PSUAWizard2();
            psUAWizard2.proxy(dataEntity);
            this.onCreateUser(psUAWizard2);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u7528\u6237\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onCreateUser(PSUAWizard2 psUAWizard2) throws Exception {
        String strLoginName = psUAWizard2.getParamStringValue("LOGINNAME", "");
        String strOldPassword = psUAWizard2.getParamStringValue("ORIPASSWORD", "");
        String strNewPassword = psUAWizard2.getParamStringValue("NEWPASSWORD", "");
        if (this.getPSModelStorage().getPSUserMgrAPI() != null) {
            this.getPSModelStorage().getPSUserMgrAPI().createUser(strLoginName, "");
            this.getPSModelStorage().getPSUserMgrAPI().changeUserPwd(strLoginName, strNewPassword, strOldPassword);
        } else {
            log.warn((Object)String.format("\u6ca1\u6709\u6307\u5b9a\u7528\u6237\u7ba1\u7406\u63a5\u53e3\uff0c\u65e0\u6cd5\u5efa\u7acb\u8fdc\u7a0b\u7528\u6237", new Object[0]));
        }
    }

    public CallResult userAction2() {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("DE2030", "PSSYSTEM");
            map.put("DE2031", "PSMODULE");
            map.put("DE2032", "PSSYSTEMDBCFG");
            map.put("DE2033", "PSSYSEDITORSTYLE");
            map.put("DE2034", "PSSYSVALUERULE");
            map.put("DE2035", "PSSYSUSERMODE");
            map.put("DE2036", "PSSYSDBDETAIL");
            map.put("DE2037", "PSSYSOPPRIV");
            map.put("DE2038", "PSSYSPFPLUGIN");
            map.put("DE2039", "PSSYSTEMAS");
            map.put("DE2040", "PSCODELIST");
            map.put("DE2041", "PSCODEITEM");
            map.put("DE2042", "PSSUBVIEWTYPE");
            map.put("DE2043", "PSSYSUNIRES");
            map.put("DE2044", "PSSYSDBVF");
            map.put("DE2045", "PSSYSDBVFCODE");
            map.put("DE2046", "PSSYSCTRLSTYLE");
            map.put("DE2047", "PSSYSACTOR");
            map.put("DE2048", "PSSYSUSERCASE");
            map.put("DE2049", "PSSYSTEMMQ");
            map.put("DE2050", "PSDATAENTITY");
            map.put("DE2051", "PSDEFIELD");
            map.put("DE2052", "PSDER");
            map.put("DE2055", "PSDEDBCFG");
            map.put("DE2056", "PSDEDATASET");
            map.put("DE2057", "PSDEDATAQUERY");
            map.put("DE2058", "PSDEDQJOIN");
            map.put("DE2059", "PSDEDQCOND");
            map.put("DE2060", "PSDEFDTCOL");
            map.put("DE2061", "PSDEDSDQ");
            map.put("DE2062", "PSDEDSCODE");
            map.put("DE2063", "PSDEDQCODE");
            map.put("DE2064", "PSDEOPPRIV");
            map.put("DE2065", "PSDEDUPRULE");
            map.put("DE2066", "PSDEDUPRULEITEM");
            map.put("DE2067", "PSDEFVALUERULE");
            map.put("DE2068", "PSDEDSPARAM");
            map.put("DE2069", "PSDEFVRDSPARAM");
            map.put("DE2070", "PSDESYSPROC");
            map.put("DE2071", "PSDEFVRCOND");
            map.put("DE2072", "PSDESPCODE");
            map.put("DE2073", "PSDESPCODEPART");
            map.put("DE2074", "PSDESPFIELD");
            map.put("DE2075", "PSDEDQCODEEXP");
            map.put("DE2076", "PSDEACTION");
            map.put("DE2077", "PSDEDQCODECOND");
            map.put("DE2078", "PSDEDSGRPPARAM");
            map.put("DE2079", "PSDEDBINDEX");
            map.put("DE2080", "PSDEUIACTION");
            map.put("DE2081", "PSDEDATARELATION");
            map.put("DE2082", "PSDEDRITEM");
            map.put("DE2083", "PSDELOGIC");
            map.put("DE2084", "PSDELOGICNODE");
            map.put("DE2085", "PSDELOGICLINK");
            map.put("DE2086", "PSDELOGICPARAM");
            map.put("DE2087", "PSDELLCOND");
            map.put("DE2088", "PSDEACTIONLOGIC");
            map.put("DE2089", "PSDBPROCPARAM");
            map.put("DE2091", "PSDEDRGROUP");
            map.put("DE2092", "PSDEDRDETAIL");
            map.put("DE2093", "PSDEVRGROUP");
            map.put("DE2094", "PSDEVRGRPDETAIL");
            map.put("DE2095", "PSDEUAGROUP");
            map.put("DE2096", "PSDEUAGRPDETAIL");
            map.put("DE2097", "PSDELNPARAM");
            map.put("DE2098", "PSDEDATAEXP");
            map.put("DE2099", "PSDEDATAIMP");
            map.put("DE2100", "PSSYSDEPLOY");
            map.put("DE2101", "PSSYSDEPLOYDB");
            map.put("DE2102", "PSSYSDEPLOYAS");
            map.put("DE2103", "PSSYSDEPLOYAPP");
            map.put("DE2104", "PSSYSORGTYPE");
            map.put("DE2105", "PSSYSOUTYPE");
            map.put("DE2106", "PSSYSOUTYPERS");
            map.put("DE2107", "PSDEDBIDXFIELD");
            map.put("DE2119", "PSSYSCSSCAT");
            map.put("DE2120", "PSSYSIMAGE");
            map.put("DE2121", "PSSYSCSS");
            map.put("DE2130", "PSSYSREF");
            map.put("DE2131", "PSSYSREFDE");
            map.put("DE2140", "PSDETEMPMODE");
            map.put("DE2141", "PSDETMDETAIL");
            map.put("DE2142", "PSDETMDRS");
            map.put("DE2143", "PSDEMAP");
            map.put("DE2144", "PSDEMAPDETAIL");
            map.put("DE2145", "PSDEMAINSTATE");
            map.put("DE2146", "PSDEMSACTION");
            map.put("DE2190", "PSDEDBOBJSQL");
            map.put("DE2197", "PSSYSCOUNTER");
            map.put("DE2198", "PSSYSDICTCAT");
            map.put("DE2200", "PSDECTRL");
            map.put("DE2201", "PSDEFORM");
            map.put("DE2203", "PSDEFFORMITEM");
            map.put("DE2204", "PSDEFSFITEM");
            map.put("DE2205", "PSDEFIVR");
            map.put("DE2206", "PSDETOOLBAR");
            map.put("DE2207", "PSDETBITEM");
            map.put("DE2208", "PSDEFDLOGIC");
            map.put("DE2210", "PSDEGRID");
            map.put("DE2211", "PSDEGRIDCOL");
            map.put("DE2212", "PSDEFGRIDCOL");
            map.put("DE2215", "PSDEACMODE");
            map.put("DE2216", "PSDEFIUPDATE");
            map.put("DE2217", "PSDEDATAVIEW");
            map.put("DE2218", "PSDEFIUDETAIL");
            map.put("DE2219", "PSDEFORMRF");
            map.put("DE2220", "PSDETREEVIEW");
            map.put("DE2221", "PSDETREENODE");
            map.put("DE2222", "PSDETREENODERS");
            map.put("DE2223", "PSDECHART");
            map.put("DE2224", "PSDECHARTPARAM");
            map.put("DE2225", "PSDEPRINT");
            map.put("DE2226", "PSDECHARTAXES");
            map.put("DE2227", "PSDELIST");
            map.put("DE2228", "PSDELISTITEM");
            map.put("DE2229", "PSDEACMODEITEM");
            map.put("DE2230", "PSDEREPORT");
            map.put("DE2231", "PSDEREPITEM");
            map.put("DE2240", "PSSYSPORTLET");
            map.put("DE2241", "PSSYSREPORT");
            map.put("DE2290", "PSACHANDLER");
            map.put("DE2291", "PSSYSVIEWLOGIC");
            map.put("DE2300", "PSDEVIEWBASE");
            map.put("DE2301", "PSDEVIEWRV");
            map.put("DE2302", "PSDEVIEWCTRL");
            map.put("DE2303", "PSDEVIEWLOGIC");
            map.put("DE2304", "PSSYSPFPITEMPL");
            map.put("DE2310", "PSSYSMSGTEMPL");
            map.put("DE2311", "PSSYSBACKSERVICE");
            map.put("DE2380", "PSSYSISSUE");
            map.put("DE2381", "PSSYSPDTVIEW");
            map.put("DE2400", "PSSYSWFMODE");
            map.put("DE2401", "PSWORKFLOW");
            map.put("DE2402", "PSWFVERSION");
            map.put("DE2403", "PSWFROLE");
            map.put("DE2404", "PSWFDE");
            map.put("DE2410", "PSWFPROCESS");
            map.put("DE2411", "PSWFLINK");
            map.put("DE2412", "PSWFWORKTIME");
            map.put("DE2413", "PSWFSUBWF");
            map.put("DE2414", "PSWFPROCROLE");
            map.put("DE2415", "PSWFLINKCOND");
            map.put("DE2416", "PSWFPROCSUBWF");
            map.put("DE2417", "PSWFLINKROLE");
            map.put("DE2418", "PSWFPROCPARAM");
            map.put("DE2419", "PSSYSWFSETTING");
            map.put("DE2500", "PSSYSAPP");
            map.put("DE2501", "PSAPPMODULE");
            map.put("DE2502", "PSAPPUSERMODE");
            map.put("DE2503", "PSAPPCTRLSTYLE");
            map.put("DE2504", "PSAPPVIEWSTYLE");
            map.put("DE2506", "PSAPPVIEW");
            map.put("DE2507", "PSAPPDEVIEW");
            map.put("DE2508", "PSAPPINDEXVIEW");
            map.put("DE2509", "PSAPPPORTALVIEW");
            map.put("DE2510", "PSAPPFUNC");
            map.put("DE2511", "PSAPPVIEWREF");
            map.put("DE2512", "PSAPPSUBAPP");
            map.put("DE2519", "PSAPPUTILPAGE");
            map.put("DE2520", "PSAPPMENU");
            map.put("DE2521", "PSAPPMENUITEM");
            map.put("DE2522", "PSAPPPVPART");
            map.put("DE2523", "PSAPPUISTYLE");
            map.put("DE2524", "PSAPPUITHEME");
            map.put("DE2530", "PSMOBAPPPACK");
            map.put("DE2580", "PSAPPVIEWTEMPL");
            map.put("DE2581", "PSAPPEDITORTEMPL");
            map.put("DE2585", "PSAPPVIEWLOGIC");
            map.put("DE2590", "PSAPPVIEWCODE");
            map.put("DE2700", "PSDEVSYSDIFFREP");
            map.put("DE2701", "PSDEVSYSDIFFITEM");
            map.put("DE2720", "PSDEPSLN");
            map.put("DE2721", "PSDEPSLNPRD");
            map.put("DE2722", "PSDEPSLNDBINST");
            map.put("DE2723", "PSDEPSLNAS");
            map.put("DE2724", "PSDEPSLNASGRP");
            map.put("DE2725", "PSDEPSLNASITEM");
            map.put("DE2740", "PSDEPSLNMODE");
            map.put("DE2741", "PSDEPSLNMODEPRD");
            map.put("DE2800", "PSSYSSFPUB");
            map.put("DE2801", "PSSYSSFCODE");
            map.put("DE2803", "PSSYSDMITEM");
            map.put("DE2834", "PSSYSUSERCASERS");
            map.put("DE2835", "PSSYSTESTCASE");
            map.put("DE2836", "PSSYSTCINPUT");
            map.put("DE2837", "PSSYSTCASSERT");
            IDEDataCtrl dataEntityDataCtrl = this.GetRelatedDataCtrl("DE0001");
            IDEDataCtrl deFieldDataCtrl = this.GetRelatedDataCtrl("DE0002");
            Vector list = new Vector();
            dataEntityDataCtrl.Select(new BaseDataEntity(), list);
            for (BaseDataEntity baseDataEntity : list) {
                String strDEId = baseDataEntity.getParamStringValue("DEID", "");
                if (!map.containsKey(strDEId)) continue;
                DEField indextype = new DEField();
                indextype.setDEFNAME("USERPARAMS");
                indextype.setDEID(strDEId);
                indextype.setDEFLOGICNAME("\u81ea\u5b9a\u4e49\u53c2\u6570");
                indextype.setTABLENAME("T_SRF" + (String)map.get(strDEId));
                indextype.setDEFTYPE(1);
                indextype.setISNULLABLE(true);
                indextype.setDATATYPE("TEXT");
                indextype.setLENGTH(2000);
                indextype.setISINDEXTYPE(false);
                indextype.setISMAJOR(false);
                indextype.setISPKEY(false);
                indextype.setISFKEY(false);
                indextype.setISSEARCHABLE(true);
                indextype.setISENABLECREATE(true);
                indextype.setISENABLEMODIFY(true);
                indextype.setISSYSTEM(true);
                callResult = deFieldDataCtrl.Save(true, (BaseDataEntity)indextype);
                if (callResult.getRetCode() == 0) continue;
                return callResult;
            }
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u81ea\u5b9a\u4e49\u7528\u6237\u64cd\u4f5c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    public CallResult getSysDevEnvInfo(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            StringBuilderEx sb = new StringBuilderEx();
            IPSSystem iPSSystem = null;
            String strPSDevSlnSysId = dataEntity.getParamStringValue("PSDEVSLNSYSID", "");
            if (!StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
                PSAppServer psAppServer;
                PSDBDevInst psDBDevInst;
                IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
                iPSSystem = iPSDevSlnSys.getPSSystem(false);
                if (iPSSystem.getReadOnlyPSSVNInstRepo() != null) {
                    Iterator<IPSApplication> psSysApps;
                    String strPubSvnUrl = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s/", (Object)iPSSystem.getReadOnlyPSSVNInstRepo().getConnStr(), (Object)iPSSystem.getPSDevSlnCodeName(), (Object)iPSSystem.getTrunkSysName(), (Object)iPSSystem.getVCName());
                    String strUsrSvnUrl = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s/", (Object)iPSSystem.getPSSVNInstRepo().getConnStr(), (Object)iPSSystem.getPSDevSlnCodeName(), (Object)iPSSystem.getTrunkSysName(), (Object)iPSSystem.getVCName());
                    sb.append("[\u7cfb\u7edf\u7248\u672c\u5e93\u4fe1\u606f]");
                    Iterator<IPSSysSFPub> psSysSFPubs = iPSSystem.getAllPSSysSFPubs();
                    if (psSysSFPubs != null) {
                        while (psSysSFPubs.hasNext()) {
                            IPSSysSFPub iPSSysSFPub = psSysSFPubs.next();
                            sb.append("\r\n\r\n\u540e\u53f0\u670d\u52a1[%1$s]", (Object)iPSSysSFPub.getName());
                            Iterator<IPSSFStylePrj> psSFStylePrjs = iPSSysSFPub.getPSSFStyle().getPSSFStylePrjs();
                            if (psSFStylePrjs == null) continue;
                            while (psSFStylePrjs.hasNext()) {
                                IPSSFStylePrj iPSSFStylePrj = psSFStylePrjs.next();
                                sb.append("\r\n<%1$s>[%2$s%3$s]", (Object)iPSSFStylePrj.getName(), (Object)(iPSSFStylePrj.isReadOnlyMode() ? strPubSvnUrl : strUsrSvnUrl), (Object)iPSSFStylePrj.getProjectName(iPSSysSFPub));
                            }
                        }
                    }
                    if ((psSysApps = iPSSystem.getAllPSApps()) != null) {
                        while (psSysApps.hasNext()) {
                            IPSApplication iPSSysApp = psSysApps.next();
                            sb.append("\r\n\r\n\u524d\u7aef\u5e94\u7528[%1$s]", (Object)iPSSysApp.getName());
                            Iterator<IPSPFStylePrj> psPFStylePrjs = iPSSysApp.getPSPFStyle().getPSPFStylePrjs();
                            if (psPFStylePrjs == null) continue;
                            while (psPFStylePrjs.hasNext()) {
                                IPSPFStylePrj iPSPFStylePrj = psPFStylePrjs.next();
                                sb.append("\r\n<%1$s>[%2$s%3$s]", (Object)iPSPFStylePrj.getName(), (Object)(iPSPFStylePrj.isReadOnlyMode() ? strPubSvnUrl : strUsrSvnUrl), (Object)iPSPFStylePrj.getProjectName(iPSSysApp));
                            }
                        }
                    }
                }
                PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
                PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                psDevSlnSys.setPSDevSlnSysId(strPSDevSlnSysId);
                psDevSlnSysService.get((IEntity)psDevSlnSys);
                sb.append("\r\n\r\n");
                sb.append("[\u5f00\u53d1\u6570\u636e\u5e93\u5b9e\u4f8b]");
                if (DataObject.getBoolValue((Integer)psDevSlnSys.getEnableMySQL5(), (boolean)false) && psDevSlnSys.getMySQLPSDCDBInst() != null && (psDBDevInst = psDevSlnSys.getMySQLPSDCDBInst().getPSDBDevInst()) != null) {
                    sb.append("\r\n\r\nMySQL\r\n<\u8def\u5f84>[%1$s]\r\n<\u8d26\u6237>[%2$s]\r\n<\u5bc6\u7801>[%3$s])", (Object)psDBDevInst.getConnStr(), (Object)psDBDevInst.getUserName(), (Object)psDBDevInst.getPasswd());
                }
                if (DataObject.getBoolValue((Integer)psDevSlnSys.getEnableDB2(), (boolean)false) && psDevSlnSys.getDB2PSDCDBInst() != null && (psDBDevInst = psDevSlnSys.getDB2PSDCDBInst().getPSDBDevInst()) != null) {
                    sb.append("\r\n\r\nDB2\r\n<\u8def\u5f84>[%1$s]\r\n<\u8d26\u6237>[%2$s]\r\n<\u5bc6\u7801>[%3$s])", (Object)psDBDevInst.getConnStr(), (Object)psDBDevInst.getUserName(), (Object)psDBDevInst.getPasswd());
                }
                if (DataObject.getBoolValue((Integer)psDevSlnSys.getEnableOracle(), (boolean)false) && psDevSlnSys.getOraPSDCDBInst() != null && (psDBDevInst = psDevSlnSys.getOraPSDCDBInst().getPSDBDevInst()) != null) {
                    sb.append("\r\n\r\nOracle\r\n<\u8def\u5f84>[%1$s]\r\n<\u8d26\u6237>[%2$s]\r\n<\u5bc6\u7801>[%3$s])", (Object)psDBDevInst.getConnStr(), (Object)psDBDevInst.getUserName(), (Object)psDBDevInst.getPasswd());
                }
                if (DataObject.getBoolValue((Integer)psDevSlnSys.getEnableSqlServer(), (boolean)false) && psDevSlnSys.getMSSQLPSDCDBInst() != null && (psDBDevInst = psDevSlnSys.getMSSQLPSDCDBInst().getPSDBDevInst()) != null) {
                    sb.append("\r\n\r\nMSSql\r\n<\u8def\u5f84>[%1$s]\r\n<\u8d26\u6237>[%2$s]\r\n<\u5bc6\u7801>[%3$s])", (Object)psDBDevInst.getConnStr(), (Object)psDBDevInst.getUserName(), (Object)psDBDevInst.getPasswd());
                }
                sb.append("\r\n\r\n");
                sb.append("[\u5e94\u7528\u670d\u52a1\u5668\u5730\u5740]");
                if (psDevSlnSys.getPSDevCenterAS() != null) {
                    psAppServer = psDevSlnSys.getPSDevCenterAS().getPSAppServer();
                    if (psAppServer != null) {
                        if (StringHelper.IsNullOrEmpty((String)psAppServer.getHttpAddress())) {
                            sb.append("\r\n\r\n\u670d\u52a1\u566801\r\n<\u8def\u5f84>[http://%1$s:%2$s])", (Object)psAppServer.getIpAddr(), (Object)psAppServer.getHttpPort());
                        } else {
                            sb.append("\r\n\r\n\u670d\u52a1\u566801\r\n<\u8def\u5f84>[http://%1$s:%2$s])", (Object)psAppServer.getHttpAddress(), (Object)psAppServer.getHttpPort());
                        }
                    } else if (StringHelper.IsNullOrEmpty((String)psDevSlnSys.getPSDevCenterAS().getHttpAddress())) {
                        sb.append("\r\n\r\n\u670d\u52a1\u566801\r\n<\u8def\u5f84>[http://%1$s:%2$s])", (Object)psDevSlnSys.getPSDevCenterAS().getHostAddress(), (Object)psDevSlnSys.getPSDevCenterAS().getHttpPort());
                    } else {
                        sb.append("\r\n\r\n\u670d\u52a1\u566801\r\n<\u8def\u5f84>[http://%1$s:%2$s])", (Object)psDevSlnSys.getPSDevCenterAS().getHttpAddress(), (Object)psDevSlnSys.getPSDevCenterAS().getHttpPort());
                    }
                }
                if (psDevSlnSys.getPSDevCenterAS2() != null) {
                    psAppServer = psDevSlnSys.getPSDevCenterAS2().getPSAppServer();
                    if (psAppServer != null) {
                        if (StringHelper.IsNullOrEmpty((String)psAppServer.getHttpAddress())) {
                            sb.append("\r\n\r\n\u670d\u52a1\u566802\r\n<\u8def\u5f84>[http://%1$s:%2$s])", (Object)psAppServer.getIpAddr(), (Object)psAppServer.getHttpPort());
                        } else {
                            sb.append("\r\n\r\n\u670d\u52a1\u566802\r\n<\u8def\u5f84>[http://%1$s:%2$s])", (Object)psAppServer.getHttpAddress(), (Object)psAppServer.getHttpPort());
                        }
                    } else if (StringHelper.IsNullOrEmpty((String)psDevSlnSys.getPSDevCenterAS2().getHttpAddress())) {
                        sb.append("\r\n\r\n\u670d\u52a1\u566802\r\n<\u8def\u5f84>[http://%1$s:%2$s])", (Object)psDevSlnSys.getPSDevCenterAS2().getHostAddress(), (Object)psDevSlnSys.getPSDevCenterAS2().getHttpPort());
                    } else {
                        sb.append("\r\n\r\n\u670d\u52a1\u566802\r\n<\u8def\u5f84>[http://%1$s:%2$s])", (Object)psDevSlnSys.getPSDevCenterAS2().getHttpAddress(), (Object)psDevSlnSys.getPSDevCenterAS2().getHttpPort());
                    }
                }
                sb.append("\r\n\r\n");
                sb.append("[\u5e94\u7528\u5730\u5740]");
                Iterator<IPSApplication> psSysApps = iPSSystem.getAllPSApps();
                if (psSysApps != null) {
                    while (psSysApps.hasNext()) {
                        IPSApplication iPSSysApp = psSysApps.next();
                        sb.append("\r\n\r\n\u524d\u7aef\u5e94\u7528[%1$s]", (Object)iPSSysApp.getName());
                        sb.append("\r\n<\u8def\u5f84>[\u670d\u52a1\u5668\u5730\u5740/%1$s/%2$s]", (Object)"\u670d\u52a1\u8def\u5f84", (Object)iPSSysApp.getPKGCodeName().toLowerCase());
                    }
                }
                callResult.setUserObject((Object)sb.toString());
            }
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    public CallResult listDevSlnSys(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            DEDataSetFetchContext deDataSetFetchContext = new DEDataSetFetchContext();
            deDataSetFetchContext.setPageSize(1000);
            String strPSDevSlnId = dataEntity.getParamStringValue("psdevslnid", "");
            String strPSDevUserId = dataEntity.getParamStringValue("psdevuserid", "");
            String strPSDevCenterId = dataEntity.getParamStringValue("psdevcenterid", "");
            SimpleWebContext simpleWebContext = new SimpleWebContext();
            simpleWebContext.setSessionValue("SRFPERSONID", (Object)strPSDevUserId);
            WebContext.setCurrent((IWebContext)simpleWebContext);
            PSDevSlnSysService psDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class);
            SimpleEntity simpleEntity = new SimpleEntity();
            simpleEntity.set("psdevcenterid", (Object)strPSDevCenterId);
            deDataSetFetchContext.setActiveDataObject((ISimpleDataObject)simpleEntity);
            DEDataSetCond deDataSetCondImpl = new DEDataSetCond();
            deDataSetCondImpl.setCondType("DEFIELD");
            deDataSetCondImpl.setCondOp("EQ");
            deDataSetCondImpl.setDEFName("PSDEVSLNID");
            deDataSetCondImpl.setCondValue(strPSDevSlnId);
            deDataSetFetchContext.getConditionList().add(deDataSetCondImpl);
            ArrayList<JSONObject> psDevSlnSysJOList = new ArrayList<JSONObject>();
            ArrayList<PSDevSlnSys> psDevSlnSysList = new ArrayList<PSDevSlnSys>();
            DBFetchResult dbFetchResult = psDevSlnSysService.fetchCurUser((IDEDataSetFetchContext)deDataSetFetchContext);
            IDataTable iDataTable = dbFetchResult.getDataSet().getDataTable(0);
            int i = 0;
            while (i < iDataTable.getCachedRowCount()) {
                IDataRow iDataRow = iDataTable.getCachedRow(i);
                PSDevSlnSys psDevSlnSys = new PSDevSlnSys();
                DataObject.fromDataRow((IDataObject)psDevSlnSys, (IDataRow)iDataRow);
                if (StringHelper.Compare((String)psDevSlnSys.getVCType(), (String)"BRANCH", (boolean)true) == 0 || StringHelper.Compare((String)psDevSlnSys.getVCType(), (String)"TAG", (boolean)true) == 0) {
                    psDevSlnSys.setPSDevSlnSysName(StringHelper.Format((String)"%1$s(v%2$s)", (Object)psDevSlnSys.getPSDevSlnSysName(), (Object)psDevSlnSys.getSysVer()));
                }
                psDevSlnSysList.add(psDevSlnSys);
                ++i;
            }
            Collections.sort(psDevSlnSysList, new Comparator<PSDevSlnSys>(){

                @Override
                public int compare(PSDevSlnSys o1, PSDevSlnSys o2) {
                    return o1.getPSDevSlnSysName().compareTo(o2.getPSDevSlnSysName());
                }
            });
            for (PSDevSlnSys psDevSlnSys : psDevSlnSysList) {
                JSONObject jo = this.getPSDevSlnSysJO(psDevSlnSys);
                psDevSlnSysJOList.add(jo);
            }
            callResult.setUserObject((Object)psDevSlnSysJOList.toString());
        }
        catch (Exception ex) {
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
        }
        return callResult;
    }

    protected JSONObject getPSDevSlnSysJO(PSDevSlnSys psDevSlnSys) throws Exception {
        JSONObject jo = DataObject.toJSONObject((IDataObject)psDevSlnSys, (boolean)true);
        String strSVNType = "SVN";
        String strGitUrl = "";
        if (psDevSlnSys.getPSDevCenterSVN() != null && psDevSlnSys.getPSDevCenterSVN().getPSSVNInstRepo() != null) {
            PSSVNInstRepo psSVNInstRepo = psDevSlnSys.getPSDevCenterSVN().getPSSVNInstRepo();
            strSVNType = psSVNInstRepo.getSVNType();
            strGitUrl = psSVNInstRepo.getGitPath();
            if (StringHelper.IsNullOrEmpty((String)strGitUrl)) {
                strGitUrl = psSVNInstRepo.getConnStr();
            }
        }
        jo.put("svntype", (Object)strSVNType);
        jo.put("dbTypes", (Object)psDevSlnSys.getDBTypes());
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(psDevSlnSys.getPSDevSlnSysId());
        IPSSystem iPSSystem = iPSDevSlnSys.getPSSystem(false);
        String strPubSvnUrl = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s/", (Object)iPSSystem.getReadOnlyPSSVNInstRepo().getConnStr(), (Object)iPSSystem.getPSDevSlnCodeName(), (Object)iPSSystem.getTrunkSysName(), (Object)iPSSystem.getVCName());
        String strUsrSvnUrl = StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s/", (Object)iPSSystem.getPSSVNInstRepo().getConnStr(), (Object)iPSSystem.getPSDevSlnCodeName(), (Object)iPSSystem.getTrunkSysName(), (Object)iPSSystem.getVCName());
        if (StringHelper.Compare((String)strSVNType, (String)"GIT", (boolean)true) == 0) {
            jo.put("svnroot", (Object)strGitUrl);
            ArrayList<JSONObject> sysSFPubJOList = new ArrayList<JSONObject>();
            ArrayList<JSONObject> prjJOList = new ArrayList<JSONObject>();
            JSONObject prjJO = new JSONObject();
            prjJO.put("name", (Object)psDevSlnSys.getLogicName());
            prjJO.put("svnurl", (Object)strGitUrl);
            prjJO.put("type", (Object)"");
            prjJO.put("readonly", false);
            prjJO.put("typename", (Object)"");
            prjJOList.add(prjJO);
            JSONObject joPSSysSFPub = new JSONObject();
            joPSSysSFPub.put("codename", (Object)psDevSlnSys.getCodeName());
            joPSSysSFPub.put("prjs", (Object)prjJOList.toArray());
            sysSFPubJOList.add(joPSSysSFPub);
            jo.put("pssyssfpubs", (Object)sysSFPubJOList.toArray());
            return jo;
        }
        jo.put("svnroot", (Object)StringHelper.Format((String)"%1$s/%2$s/%3$s/%4$s", (Object)iPSSystem.getReadOnlyPSSVNInstRepo().getConnStr(), (Object)iPSSystem.getPSDevSlnCodeName(), (Object)iPSSystem.getTrunkSysName(), (Object)iPSSystem.getVCName()));
        PSSysAppService psSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
        PSSysSFPubService psSysSFPubService = (PSSysSFPubService)ServiceGlobal.getService(PSSysSFPubService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)psDevSlnSys.getPSSysModelInstId()));
        PSSystem psSystem = new PSSystem();
        psSystem.setPSSystemId(psDevSlnSys.getPSSystemId());
        ArrayList psSysAppList = psSysAppService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList psSysSFPubList = psSysSFPubService.selectByPSSystem((PSSystemBase)psSystem);
        ArrayList<JSONObject> sysSFPubJOList = new ArrayList<JSONObject>();
        if (psSysSFPubList.size() > 0) {
            for (PSSysSFPub psSysSFPub : psSysSFPubList) {
                JSONObject joPSSysSFPub = DataObject.toJSONObject((IDataObject)psSysSFPub, (boolean)true);
                ArrayList<JSONObject> prjJOList = new ArrayList<JSONObject>();
                IPSSysSFPub iPSSysSFPub = iPSSystem.getPSSysSFPub(psSysSFPub.getPSSysSFPubId());
                Iterator<IPSSFStylePrj> psSFStylePrjs = iPSSysSFPub.getPSSFStyle().getPSSFStylePrjs();
                if (psSFStylePrjs != null) {
                    while (psSFStylePrjs.hasNext()) {
                        IPSSFStylePrj iPSSFStylePrj = psSFStylePrjs.next();
                        JSONObject prjJO = new JSONObject();
                        prjJO.put("name", (Object)iPSSFStylePrj.getProjectName(iPSSysSFPub));
                        prjJO.put("svnurl", (Object)StringHelper.Format((String)"%1$s%2$s", (Object)(iPSSFStylePrj.isReadOnlyMode() ? strPubSvnUrl : strUsrSvnUrl), (Object)iPSSFStylePrj.getProjectName(iPSSysSFPub)));
                        prjJO.put("type", (Object)iPSSFStylePrj.getPrjType());
                        prjJO.put("readonly", iPSSFStylePrj.isReadOnlyMode());
                        prjJO.put("typename", (Object)iPSSFStylePrj.getName());
                        prjJOList.add(prjJO);
                    }
                }
                joPSSysSFPub.put("prjs", (Object)prjJOList.toArray());
                sysSFPubJOList.add(joPSSysSFPub);
            }
        }
        ArrayList<JSONObject> sysAppJOList = new ArrayList<JSONObject>();
        if (psSysAppList.size() > 0) {
            for (PSSysApp psSysApp : psSysAppList) {
                JSONObject psSysAppjo = DataObject.toJSONObject((IDataObject)psSysApp, (boolean)true);
                ArrayList<JSONObject> prjJOList = new ArrayList<JSONObject>();
                IPSApplication iPSSysApp = iPSSystem.getPSApplication(psSysApp.getPSSysAppId());
                Iterator<IPSPFStylePrj> psPFStylePrjs = iPSSysApp.getPSPFStyle().getPSPFStylePrjs();
                if (psPFStylePrjs != null) {
                    while (psPFStylePrjs.hasNext()) {
                        IPSPFStylePrj iPSPFStylePrj = psPFStylePrjs.next();
                        JSONObject prjJO = new JSONObject();
                        prjJO.put("name", (Object)iPSPFStylePrj.getProjectName(iPSSysApp));
                        prjJO.put("svnurl", (Object)StringHelper.Format((String)"%1$s%2$s", (Object)(iPSPFStylePrj.isReadOnlyMode() ? strPubSvnUrl : strUsrSvnUrl), (Object)iPSPFStylePrj.getProjectName(iPSSysApp)));
                        prjJO.put("type", (Object)iPSPFStylePrj.getPrjType());
                        prjJO.put("readonly", iPSPFStylePrj.isReadOnlyMode());
                        prjJO.put("typename", (Object)iPSPFStylePrj.getName());
                        prjJOList.add(prjJO);
                    }
                }
                psSysAppjo.put("prjs", (Object)prjJOList.toArray());
                sysAppJOList.add(psSysAppjo);
            }
        }
        jo.put("pssysapps", (Object)sysAppJOList.toArray());
        jo.put("pssyssfpubs", (Object)sysSFPubJOList.toArray());
        return jo;
    }

    class UpdateSVNAuthZThread
    extends Thread {
        private ISRFDAGlobalHelper iSRFDAGlobalHelper = null;
        private BaseDataEntity dataEntity = null;

        public UpdateSVNAuthZThread(ISRFDAGlobalHelper iSRFDAGlobalHelper, BaseDataEntity dataEntity) {
            this.dataEntity = dataEntity;
            this.iSRFDAGlobalHelper = iSRFDAGlobalHelper;
        }

        @Override
        public void run() {
            IDEDataCtrl psSVNServerDataCtrl = this.iSRFDAGlobalHelper.getDAModelStorage().FindDEDataCtrl("DE1903", "SYSTEM", null);
            psSVNServerDataCtrl.CustomCall("UPDATEAUTHZ", this.dataEntity);
        }
    }
}

