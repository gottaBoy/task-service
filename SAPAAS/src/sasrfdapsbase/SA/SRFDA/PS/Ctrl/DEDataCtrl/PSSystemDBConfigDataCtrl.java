/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.service.ServiceWorkHelper
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg
 *  net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDQCodePublisher;
import SA.SRFDA.PS.Core.DataEntity.DS.IPSDEDataQuery;
import SA.SRFDA.PS.Core.DataEntity.IPSDataEntity;
import SA.SRFDA.PS.Core.Database.IPSDBType;
import SA.SRFDA.PS.Core.Database.IPSDEDBConfig;
import SA.SRFDA.PS.Core.Database.IPSSystemDBConfig;
import SA.SRFDA.PS.Core.Deploy.IPSDBDevInst;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PSTaskServerEnvImpl;
import SA.SRFDA.PS.Core.Pub.PSDBPublishContextImpl;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSSysDBDetail;
import SA.SRFDA.PS.Data.PSSystem;
import SA.SRFDA.PS.Data.PSSystemDBConfig;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.service.ServiceWorkHelper;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSystemDBConfigDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSystemDBConfigDataCtrl.class);
    public static final String CUSTOMCALL_SYNCSYSDBMODEL = "SYNCSYSDBMODEL";
    public static final String CUSTOMCALL_ADDSYNCSYSDBMODELTASK = "ADDSYNCSYSDBMODELTASK";
    public static final String CUSTOMCALL_ADDSYNCSUBSYSDBMODELTASK = "ADDSYNCSUBSYSDBMODELTASK";
    public static final String CUSTOMCALL_ADDPUBSYSDBMODELTASK = "ADDPUBSYSDBMODELTASK";

    @Override
    protected CallResult OnBeforeSave(boolean bInsert, String strActionMode, BaseDataEntity dataEntity, BaseDataEntity lastDataEntity) {
        CallResult callResult = super.OnBeforeSave(bInsert, strActionMode, dataEntity, lastDataEntity);
        if (callResult.isError()) {
            return callResult;
        }
        if (bInsert) {
            PSSystemDBConfig psSystemDBConfig = new PSSystemDBConfig();
            psSystemDBConfig.proxy(dataEntity);
            String strPSSYSTEMDBCFGNAME = psSystemDBConfig.getPSSYSTEMDBCFGNAME();
            psSystemDBConfig.setPSSYSTEMDBCFGID(Helper.GenUniqueId((String)psSystemDBConfig.getPSSYSTEMID(), (String)strPSSYSTEMDBCFGNAME));
        }
        return callResult;
    }

    @Override
    protected CallResult OnCustomCall(String strCallName, BaseDataEntity dataEntity) {
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_SYNCSYSDBMODEL, (boolean)true) == 0) {
            return this.syncSysDBModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDSYNCSYSDBMODELTASK, (boolean)true) == 0) {
            return this.addSyncSysDBModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDSYNCSUBSYSDBMODELTASK, (boolean)true) == 0) {
            return this.addSyncSubSysDBModelTask(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDPUBSYSDBMODELTASK, (boolean)true) == 0) {
            return this.addPubSysDBModelTask(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult syncSysDBModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            final PSSystemDBConfig psSystem = new PSSystemDBConfig();
            psSystem.proxy(dataEntity);
            ServiceWorkHelper.getInstance().execute(new IServiceWork(){

                public void execute(ITransaction iTransaction) throws Exception {
                    PSSystemDBConfigDataCtrl.this.onSyncSysDBModel(psSystem);
                }
            });
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u540c\u6b65\u7cfb\u7edf\u6570\u636e\u5e93\u7ed3\u6784\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onSyncSysDBModel(PSSystemDBConfig psSystemDBConfig) throws Exception {
        String strPSSystemId = psSystemDBConfig.getPSSYSTEMID();
        IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
        IDEDataCtrl psSysDBDetailDataCtrl = this.GetRelatedDataCtrl("DE2036");
        Vector psDataEntityList = new Vector();
        BaseDataEntity cond = new BaseDataEntity();
        cond.setParamValue("PSSYSTEMID", (Object)strPSSystemId);
        CallResult callResult = psDataEntityDataCtrl.Select(cond, psDataEntityList, PSDataEntity.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        Vector psSysDBDetailList = new Vector();
        cond.Reset();
        cond.setParamValue("PSSYSTEMDBCFGID", (Object)psSystemDBConfig.getPSSYSTEMDBCFGID());
        callResult = psSysDBDetailDataCtrl.Select(cond, psSysDBDetailList, PSSysDBDetail.class.getName());
        if (callResult.isError()) {
            throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u6570\u636e\u5e93\u5b9e\u4f53\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
        HashMap<String, PSDataEntity> psDataEntityMap = new HashMap<String, PSDataEntity>();
        for (PSDataEntity psDataEntity : psDataEntityList) {
            psDataEntityMap.put(psDataEntity.getPSDATAENTITYID(), psDataEntity);
        }
        for (PSSysDBDetail psSysDBDetail : psSysDBDetailList) {
            PSDataEntity psDataEntity;
            if (!psDataEntityMap.containsKey(psSysDBDetail.getPSDEID()) || (psDataEntity = (PSDataEntity)((Object)psDataEntityMap.get(psSysDBDetail.getPSDEID()))).getDBVER() != psSysDBDetail.getPUBDBVER()) continue;
            psDataEntityMap.remove(psSysDBDetail.getPSDEID());
        }
        if (psDataEntityMap.size() == 0) {
            return;
        }
        IPSSystem iPSSystem = this.getPSModelStorage().getPSSystem(psSystemDBConfig.getPSSYSTEMID());
        if (iPSSystem.getLoadedLevel() < IPSSystem.LOADLEVEL_CODE) {
            IDEDataCtrl psSystemDataCtrl = this.GetRelatedDataCtrl("DE2030");
            PSSystem psSystem = new PSSystem();
            psSystem.setParamValue("PSSYSTEMID", strPSSystemId);
            callResult = psSystemDataCtrl.CustomCall("RELOADMODEL", (BaseDataEntity)psSystem);
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u5237\u65b0\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            iPSSystem = this.getPSModelStorage().getPSSystem(psSystemDBConfig.getPSSYSTEMID());
        }
        IPSSystemDBConfig iPSSystemDBConfig = iPSSystem.getPSSystemDBConfig(psSystemDBConfig.getPSSYSTEMDBCFGNAME());
        int nTotalCount = psDataEntityMap.size();
        int nIndex = 0;
        for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
            log.info((Object)StringHelper.Format((String)"\u51c6\u5907\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b\uff0c%2$s/%3$s", (Object)psDataEntity.getPSDATAENTITYNAME(), (Object)(++nIndex), (Object)nTotalCount));
            this.onPublishDBModel(iPSSystemDBConfig, iPSSystem.getPSDataEntity2(psDataEntity.getPSDATAENTITYNAME()));
            log.info((Object)StringHelper.Format((String)"\u7ed3\u675f\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b\uff0c%2$s/%3$s", (Object)psDataEntity.getPSDATAENTITYNAME(), (Object)nIndex, (Object)nTotalCount));
        }
        nIndex = 0;
        for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
            log.info((Object)StringHelper.Format((String)"\u51c6\u5907\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b2\uff0c%2$s/%3$s", (Object)psDataEntity.getPSDATAENTITYNAME(), (Object)(++nIndex), (Object)nTotalCount));
            this.onPublishDBModel2(iPSSystemDBConfig, iPSSystem.getPSDataEntity2(psDataEntity.getPSDATAENTITYNAME()));
            log.info((Object)StringHelper.Format((String)"\u7ed3\u675f\u53d1\u5e03\u5b9e\u4f53[%1$s]\u6570\u636e\u5e93\u6a21\u578b2\uff0c%2$s/%3$s", (Object)psDataEntity.getPSDATAENTITYNAME(), (Object)nIndex, (Object)nTotalCount));
        }
        for (PSDataEntity psDataEntity : psDataEntityMap.values()) {
            PSSysDBDetail psSysDBDetail = new PSSysDBDetail();
            psSysDBDetail.setPSDEID(psDataEntity.getPSDATAENTITYID());
            psSysDBDetail.setPSSYSTEMDBCFGID(psSystemDBConfig.getPSSYSTEMDBCFGID());
            psSysDBDetail.setPUBDBVER(psDataEntity.getDBVER());
            callResult = psSysDBDetailDataCtrl.AutoSave((BaseDataEntity)psSysDBDetail);
            if (!callResult.isError()) continue;
            throw new Exception(StringHelper.Format((String)"\u66f4\u65b0\u7cfb\u7edf\u6570\u636e\u5b9e\u4f53\u7248\u672c\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
        }
    }

    protected void onPublishDBModel(IPSSystemDBConfig iPSSystemDBConfig, IPSDataEntity iPSDataEntity) throws Exception {
        IPSDEDBConfig iPSDEDBConfig;
        PSDBPublishContextImpl psPublishContextImpl = new PSDBPublishContextImpl((IDEDataCtrl)this);
        psPublishContextImpl.setPSSystemDBConfig(iPSSystemDBConfig);
        IPSDBDevInst iPSDBDevInst = null;
        if (!StringHelper.IsNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) {
            iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
        }
        if ((iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSSystemDBConfig.getName())).isValidFlag() && iPSDEDBConfig.isPubModel()) {
            iPSDEDBConfig.publishDBModel(psPublishContextImpl, iPSDBDevInst);
        }
    }

    protected void onPublishDBModel2(IPSSystemDBConfig iPSSystemDBConfig, IPSDataEntity iPSDataEntity) throws Exception {
        IPSDEDBConfig iPSDEDBConfig;
        PSDBPublishContextImpl psPublishContextImpl = new PSDBPublishContextImpl((IDEDataCtrl)this);
        psPublishContextImpl.setPSSystemDBConfig(iPSSystemDBConfig);
        IPSDBDevInst iPSDBDevInst = null;
        if (!StringHelper.IsNullOrEmpty((String)iPSSystemDBConfig.getPSDBDevInstId())) {
            iPSDBDevInst = this.getPSModelStorage().getPSDBDevInst(iPSSystemDBConfig.getPSDBDevInstId());
        }
        if ((iPSDEDBConfig = iPSDataEntity.getPSDEDBConfig(iPSSystemDBConfig.getName())).isValidFlag() && iPSDEDBConfig.isPubModel()) {
            iPSDEDBConfig.publishDBModel2(psPublishContextImpl, iPSDBDevInst);
        }
        if (iPSDEDBConfig.isValidFlag()) {
            Iterator<IPSDEDataQuery> psDEDataQueries = iPSDataEntity.getAllPSDEDataQueries();
            while (psDEDataQueries.hasNext()) {
                IPSDEDataQuery iPSDEDataQuery = psDEDataQueries.next();
                IPSDBType iDBType = this.getPSModelStorage().getPSDBType(iPSSystemDBConfig.getName());
                IPSDEDQCodePublisher iPSDEDQCodePublisher = iDBType.getPSDEDQCodePublisher();
                iPSDEDQCodePublisher.generateCode(psPublishContextImpl, iPSDEDataQuery);
                iPSDEDQCodePublisher.close();
            }
        }
    }

    public CallResult addSyncSysDBModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSystemDBConfig psSystemDBConfig = new PSSystemDBConfig();
            psSystemDBConfig.proxy(dataEntity);
            this.onAddSyncSysDBModelTask(psSystemDBConfig);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u7cfb\u7edf\u6570\u636e\u5e93\u7ed3\u6784\u540c\u6b65\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddSyncSysDBModelTask(PSSystemDBConfig psSystemDBConfig) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psSystemDBConfig.getParamStringValue("PSDEVSLNSYSID", "");
        if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            this.onSyncSysDBModel(psSystemDBConfig);
            return;
        }
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        PSSystemDBCfg psSystemDBConfig2 = new PSSystemDBCfg();
        psSystemDBConfig2.setPSSystemDBCfgId(psSystemDBConfig.getPSSYSTEMDBCFGID());
        psSystemDBCfgService.get((IEntity)psSystemDBConfig2);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSystemDBConfig2.getPSSystemDBCfgName()));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("SYNCDBMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psSystemDBConfig.getPSSYSTEMDBCFGID());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSSystemDBConfigDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }

    public CallResult addSyncSubSysDBModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSystemDBConfig psSystemDBConfig = new PSSystemDBConfig();
            psSystemDBConfig.proxy(dataEntity);
            this.onAddSyncSubSysDBModelTask(psSystemDBConfig);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5b50\u7cfb\u7edf\u6570\u636e\u5e93\u7ed3\u6784\u540c\u6b65\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddSyncSubSysDBModelTask(PSSystemDBConfig psSystemDBConfig) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psSystemDBConfig.getParamStringValue("PSDEVSLNSYSID", "");
        if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            return;
        }
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        PSSystemDBCfg psSystemDBConfig2 = new PSSystemDBCfg();
        psSystemDBConfig2.setPSSystemDBCfgId(psSystemDBConfig.getPSSYSTEMDBCFGID());
        psSystemDBCfgService.get((IEntity)psSystemDBConfig2);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65\u5b50\u7cfb\u7edf[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSystemDBConfig2.getPSSystemDBCfgName()));
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
        psSysDevBKTask.setTaskParam(psSystemDBConfig.getPSSYSTEMDBCFGID());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSSystemDBConfigDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }

    public CallResult addPubSysDBModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSystemDBConfig psSystemDBConfig = new PSSystemDBConfig();
            psSystemDBConfig.proxy(dataEntity);
            this.onAddPubSysDBModelTask(psSystemDBConfig);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u53d1\u5e03\u7cfb\u7edf\u6570\u636e\u5e93\u7ed3\u6784\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddPubSysDBModelTask(PSSystemDBConfig psSystemDBConfig) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psSystemDBConfig.getParamStringValue("PSDEVSLNSYSID", "");
        if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            return;
        }
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        PSSystemDBCfgService psSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        PSSystemDBCfg psSystemDBConfig2 = new PSSystemDBCfg();
        psSystemDBConfig2.setPSSystemDBCfgId(psSystemDBConfig.getPSSYSTEMDBCFGID());
        psSystemDBCfgService.get((IEntity)psSystemDBConfig2);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u91cd\u65b0\u53d1\u5e03\u7cfb\u7edf[%1$s]\u6570\u636e\u5e93\u6a21\u578b", (Object)psSystemDBConfig2.getPSSystemDBCfgName()));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        if (PSTaskServerEnvImpl.getCurrent() != null) {
            psSysDevBKTask.setPSTaskServerId(PSTaskServerEnvImpl.getCurrent().getId());
            psSysDevBKTask.setPSTaskServerName(PSTaskServerEnvImpl.getCurrent().getName());
        }
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("PUBSYSDBMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psSystemDBConfig.getPSSYSTEMDBCFGID());
        psSysDevBKTask.setModelLevel(IPSSystem.LOADLEVEL_CODE);
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSSystemDBConfigDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }
}

