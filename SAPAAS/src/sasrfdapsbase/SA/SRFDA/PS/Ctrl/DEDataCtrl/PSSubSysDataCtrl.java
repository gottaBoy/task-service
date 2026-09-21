/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFDA.Ctrl.IDEDataCtrl
 *  SA.SRFramework.DataEx.BaseDataEntity
 *  SA.SRFramework.DataEx.CallResult
 *  SA.SRFramework.Utility.StringHelper
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel
 *  net.ibizsys.pscore.srv.config.entity.PSSubSys
 *  net.ibizsys.pscore.srv.config.service.PSSubSysService
 *  net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask
 *  net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService
 *  net.ibizsys.pscore.srv.util.PSSysModelInstGlobal
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package SA.SRFDA.PS.Ctrl.DEDataCtrl;

import SA.SRFDA.Ctrl.IDEDataCtrl;
import SA.SRFDA.PS.Core.IPSDevSlnSys;
import SA.SRFDA.PS.Core.IPSSystem;
import SA.SRFDA.PS.Core.PF.IPSPF;
import SA.SRFDA.PS.Ctrl.DEDataCtrl.PSDEDataCtrl;
import SA.SRFDA.PS.Data.PSAppModule;
import SA.SRFDA.PS.Data.PSAppView;
import SA.SRFDA.PS.Data.PSDEAction;
import SA.SRFDA.PS.Data.PSDEViewBase;
import SA.SRFDA.PS.Data.PSDataEntity;
import SA.SRFDA.PS.Data.PSSubApp;
import SA.SRFDA.PS.Data.PSSubAppView;
import SA.SRFDA.PS.Data.PSSubDE;
import SA.SRFDA.PS.Data.PSSubDEAction;
import SA.SRFDA.PS.Data.PSSubDEView;
import SA.SRFDA.PS.Data.PSSubSys;
import SA.SRFDA.PS.Data.PSSubSysSF;
import SA.SRFDA.PS.Data.PSSysApp;
import SA.SRFDA.PS.Data.PSSysSFPub;
import SA.SRFramework.DataEx.BaseDataEntity;
import SA.SRFramework.DataEx.CallResult;
import SA.SRFramework.Utility.StringHelper;
import java.util.HashMap;
import java.util.Vector;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.pscore.srv.codelist.SysDevBKTaskStateCodeListModel;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.ibizsys.pscore.srv.util.PSSysModelInstGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public class PSSubSysDataCtrl
extends PSDEDataCtrl {
    private static final Log log = LogFactory.getLog(PSSubSysDataCtrl.class);
    public static final String CUSTOMCALL_UPDATEMODEL = "UPDATEMODEL";
    public static final String CUSTOMCALL_ADDUPDATEMODELTASK = "ADDUPDATEMODELTASK";

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
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_UPDATEMODEL, (boolean)true) == 0) {
            return this.updateModel(dataEntity);
        }
        if (StringHelper.Compare((String)strCallName, (String)CUSTOMCALL_ADDUPDATEMODELTASK, (boolean)true) == 0) {
            return this.addSyncSubSysModelTask(dataEntity);
        }
        return super.OnCustomCall(strCallName, dataEntity);
    }

    public CallResult updateModel(BaseDataEntity dataEntity) {
        CallResult callResult = this.Get(dataEntity);
        if (callResult.IsError()) {
            return callResult;
        }
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSubSys psSubSys = new PSSubSys();
            psSubSys.proxy(dataEntity);
            this.onUpdateSubSysModel(psSubSys);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u66f4\u65b0\u5b50\u7cfb\u7edf\u6a21\u578b\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onUpdateSubSysModel(PSSubSys psSubSys) throws Exception {
        if (StringHelper.IsNullOrEmpty((String)psSubSys.getPSDEVSLNSYSID())) {
            if (StringHelper.IsNullOrEmpty((String)psSubSys.getPSSYSTEMID())) {
                throw new Exception(StringHelper.Format((String)"\u6ca1\u6709\u6307\u5b9a\u7cfb\u7edf\u6807\u8bc6"));
            }
            HashMap<String, PSSubDE> psSubDEMap = new HashMap<String, PSSubDE>();
            IDEDataCtrl psDataEntityDataCtrl = this.GetRelatedDataCtrl("DE2050");
            BaseDataEntity cond = new BaseDataEntity();
            cond.setParamValue("PSSYSTEMID", (Object)psSubSys.getPSSYSTEMID());
            Vector dataEntityList = new Vector();
            CallResult callResult = psDataEntityDataCtrl.Select(cond, dataEntityList, PSDataEntity.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            IDEDataCtrl psSubDEActionDataCtrl = this.GetRelatedDataCtrl("DE1952");
            IDEDataCtrl psDEActionDataCtrl = this.GetRelatedDataCtrl("DE2076");
            IDEDataCtrl psSubDEDataCtrl = this.GetRelatedDataCtrl("DE1951");
            for (PSDataEntity psDataEntity : dataEntityList) {
                PSSubDE psSubDE = new PSSubDE();
                psSubDE.setPSSUBSYSID(psSubSys.getPSSUBSYSID());
                psSubDE.setPSSUBSYSNAME(psSubSys.getPSSUBSYSNAME());
                psSubDE.setCODENAME(psDataEntity.getCODENAME());
                psSubDE.setLOGICNAME(psDataEntity.getLOGICNAME());
                psSubDE.setMEMO(psDataEntity.getMEMO());
                psSubDE.setMODULENAME(psDataEntity.getPSMODULENAME());
                psSubDE.setPSDEID(psDataEntity.getPSDATAENTITYID());
                psSubDE.setPSSUBDENAME(psDataEntity.getPSDATAENTITYNAME());
                callResult = psSubDEDataCtrl.AutoSave((BaseDataEntity)psSubDE);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b50\u7cfb\u7edf\u5b9e\u4f53\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSubDEMap.put(psDataEntity.getPSDATAENTITYID(), psSubDE);
                Vector psDEActionList = new Vector();
                cond.Reset();
                cond.setParamValue("PSDEID", (Object)psDataEntity.getPSDATAENTITYID());
                callResult = psDEActionDataCtrl.Select(cond, psDEActionList, PSDEAction.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                for (PSDEAction psDEAction : psDEActionList) {
                    PSSubDEAction psSubDEAction = new PSSubDEAction();
                    psSubDEAction.setPSDEACTIONID(psDEAction.getPSDEACTIONID());
                    psSubDEAction.setPSSUBDEID(psSubDE.getPSSUBDEID());
                    psSubDEAction.setPSSUBDENAME(psSubDE.getPSSUBDENAME());
                    psSubDEAction.setCODENAME(psDEAction.getCODENAME());
                    psSubDEAction.setLOGICNAME(psDEAction.getLOGICNAME());
                    psSubDEAction.setMEMO(psSubDE.getMEMO());
                    psSubDEAction.setPSSUBDEACTIONNAME(psDEAction.getPSDEACTIONNAME());
                    callResult = psSubDEActionDataCtrl.AutoSave((BaseDataEntity)psSubDEAction);
                    if (!callResult.isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b50\u7cfb\u7edf\u5b9e\u4f53\u884c\u4e3a\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                if (this.getTransactionManager() == null) continue;
                this.getTransactionManager().CommitAndBegin();
            }
            IDEDataCtrl psSubDEViewDataCtrl = this.GetRelatedDataCtrl("DE1955");
            IDEDataCtrl psDEViewBaseDataCtrl = this.GetRelatedDataCtrl("DE2300");
            Vector psDEViewList = new Vector();
            cond.Reset();
            cond.setParamValue("PSSYSTEMID", (Object)psSubSys.getPSSYSTEMID());
            callResult = psDEViewBaseDataCtrl.Select(cond, psDEViewList, PSDEViewBase.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            HashMap<String, PSSubDEView> psSubDEViewMap = new HashMap<String, PSSubDEView>();
            for (PSDEViewBase psDEView : psDEViewList) {
                PSSubDEView psSubDEView = new PSSubDEView();
                psSubDEView.setPSSUBSYSID(psSubSys.getPSSUBSYSID());
                psSubDEView.setPSSUBSYSNAME(psSubSys.getPSSUBSYSNAME());
                psSubDEView.setPSDEVIEWBASEID(psDEView.getPSDEVIEWBASEID());
                if (!StringHelper.IsNullOrEmpty((String)psDEView.getPSDEID())) {
                    PSSubDE psSubDE = (PSSubDE)((Object)psSubDEMap.get(psDEView.getPSDEID()));
                    psSubDEView.setPSSUBDEID(psSubDE.getPSSUBDEID());
                    psSubDEView.setPSSUBDENAME(psSubDE.getPSSUBDENAME());
                }
                psSubDEView.setCODENAME(psDEView.getCODENAME());
                psSubDEView.setMEMO(psDEView.getMEMO());
                psSubDEView.setPSSUBDEVIEWNAME(psDEView.getPSDEVIEWBASENAME());
                psSubDEView.setVIEWTYPE(psDEView.getPSDEVIEWBASETYPE());
                callResult = psSubDEViewDataCtrl.AutoSave((BaseDataEntity)psSubDEView);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b50\u7cfb\u7edf\u5b9e\u4f53\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                psSubDEViewMap.put(psDEView.getPSDEVIEWBASEID(), psSubDEView);
            }
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().CommitAndBegin();
            }
            IDEDataCtrl psSubSysSFDataCtrl = this.GetRelatedDataCtrl("DE1953");
            IDEDataCtrl psSysSFPubDataCtrl = this.GetRelatedDataCtrl("DE2800");
            Vector psSysSFPubList = new Vector();
            cond.Reset();
            cond.setParamValue("PSSYSTEMID", (Object)psSubSys.getPSSYSTEMID());
            callResult = psSysSFPubDataCtrl.Select(cond, psSysSFPubList, PSSysSFPub.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u670d\u52a1\u5c42\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSSysSFPub psSysSFPub : psSysSFPubList) {
                PSSubSysSF psSubSysSF = new PSSubSysSF();
                psSysSFPub.CopyTo(psSubSysSF, true);
                psSubSysSF.setPSSFID(psSubSys.getPSSFID());
                psSubSysSF.setPSSFNAME(psSubSys.getPSSFNAME());
                psSubSysSF.setPSSUBSYSID(psSubSys.getPSSUBSYSID());
                psSubSysSF.setPSSUBSYSNAME(psSubSys.getPSSUBSYSNAME());
                psSubSysSF.setPSSUBSYSSFNAME(psSysSFPub.getPSSYSSFPUBNAME());
                callResult = psSubSysSFDataCtrl.AutoSave((BaseDataEntity)psSubSysSF);
                if (!callResult.isError()) continue;
                throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b50\u7cfb\u7edf\u670d\u52a1\u5c42\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            IDEDataCtrl psSubAppDataCtrl = this.GetRelatedDataCtrl("DE1960");
            IDEDataCtrl psSysAppDataCtrl = this.GetRelatedDataCtrl("DE2500");
            IDEDataCtrl psSubAppViewDataCtrl = this.GetRelatedDataCtrl("DE1963");
            IDEDataCtrl psAppViewDataCtrl = this.GetRelatedDataCtrl("DE2506");
            IDEDataCtrl psAppModuleDataCtrl = this.GetRelatedDataCtrl("DE2501");
            Vector psSysAppList = new Vector();
            cond.Reset();
            cond.setParamValue("PSSYSTEMID", (Object)psSubSys.getPSSYSTEMID());
            callResult = psSysAppDataCtrl.Select(cond, psSysAppList, PSSysApp.class.getName());
            if (callResult.isError()) {
                throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u7cfb\u7edf\u5e94\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
            }
            for (PSSysApp psSysApp : psSysAppList) {
                PSSubApp psSubApp = new PSSubApp();
                psSysApp.CopyTo(psSubApp, true);
                psSubApp.setPSSUBSYSID(psSubSys.getPSSUBSYSID());
                psSubApp.setPSSUBSYSNAME(psSubSys.getPSSUBSYSNAME());
                psSubApp.setPSSUBAPPNAME(psSysApp.getPSSYSAPPNAME());
                callResult = psSubAppDataCtrl.AutoSave((BaseDataEntity)psSubApp);
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b50\u7cfb\u7edf\u5e94\u7528\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                Vector psAppModuleList = new Vector();
                cond.Reset();
                cond.setParamValue("PSSYSAPPID", (Object)psSysApp.getPSSYSAPPID());
                callResult = psAppModuleDataCtrl.Select(cond, psAppModuleList, PSAppModule.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u6a21\u5757\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                HashMap<String, PSAppModule> psAppModuleMap = new HashMap<String, PSAppModule>();
                for (PSAppModule psAppModule : psAppModuleList) {
                    psAppModuleMap.put(psAppModule.getPSAPPMODULEID(), psAppModule);
                }
                Vector psAppViewList = new Vector();
                cond.Reset();
                cond.setParamValue("PSSYSAPPID", (Object)psSysApp.getPSSYSAPPID());
                callResult = psAppViewDataCtrl.Select(cond, psAppViewList, PSAppView.class.getName());
                if (callResult.isError()) {
                    throw new Exception(StringHelper.Format((String)"\u67e5\u8be2\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
                IPSPF iPSPF = this.getPSModelStorage().getPSPF(psSysApp.getPSPFID());
                for (PSAppView psAppView : psAppViewList) {
                    PSSubDEView psSubDEView;
                    PSSubAppView psSubAppView = new PSSubAppView();
                    psAppView.CopyTo(psSubAppView, true);
                    psSubAppView.setPSSUBAPPID(psSubApp.getPSSUBAPPID());
                    psSubAppView.setPSSUBAPPNAME(psSubApp.getPSSUBAPPNAME());
                    psSubAppView.setPSSUBAPPVIEWNAME(psAppView.getPSAPPVIEWNAME());
                    PSAppModule psAppModule = (PSAppModule)((Object)psAppModuleMap.get(psAppView.getPSAPPMODULEID()));
                    if (psAppModule != null) {
                        psSubAppView.setMODULENAME(psAppModule.getPSAPPMODULENAME());
                        psSubAppView.setMODULECODENAME(psAppModule.getCODENAME());
                    }
                    if (!StringHelper.IsNullOrEmpty((String)psAppView.getPSDEVIEWBASEID()) && (psSubDEView = (PSSubDEView)((Object)psSubDEViewMap.get(psAppView.getPSDEVIEWBASEID()))) != null) {
                        psSubAppView.setPSSUBDEVIEWID(psSubDEView.getPSSUBDEVIEWID());
                        psSubAppView.setPSSUBDEVIEWNAME(psSubDEView.getPSSUBDEVIEWNAME());
                    }
                    iPSPF.fillPSSubAppView(psSubAppView, psSysApp, psAppModule, psAppView);
                    callResult = psSubAppViewDataCtrl.AutoSave((BaseDataEntity)psSubAppView);
                    if (!callResult.isError()) continue;
                    throw new Exception(StringHelper.Format((String)"\u4fdd\u5b58\u5b50\u7cfb\u7edf\u5e94\u7528\u89c6\u56fe\u53d1\u751f\u9519\u8bef\uff0c%1$s", (Object)callResult.getErrorInfo()));
                }
            }
        }
    }

    public CallResult addSyncSubSysModelTask(BaseDataEntity dataEntity) {
        CallResult callResult = new CallResult();
        try {
            if (this.getTransactionManager() != null) {
                this.getTransactionManager().Commit();
            }
            PSSubSys psSubSys = new PSSubSys();
            psSubSys.proxy(dataEntity);
            this.onAddSyncSubSysModelTask(psSubSys);
            return callResult;
        }
        catch (Exception ex) {
            log.error((Object)StringHelper.Format((String)"\u5efa\u7acb\u5b50\u7cfb\u7edf\u6a21\u578b\u540c\u6b65\u4efb\u52a1\u53d1\u751f\u5f02\u5e38\uff0c%1$s", (Object)ex.getMessage()), (Throwable)ex);
            callResult.setRetCode(1);
            callResult.setErrorInfo(ex.getMessage());
            return callResult;
        }
    }

    protected void onAddSyncSubSysModelTask(PSSubSys psSubSys) throws Exception {
        IPSSystem iPSSystem = null;
        String strPSDevSlnSysId = psSubSys.getParamStringValue("PSDEVSLNSYSID", "");
        if (StringHelper.IsNullOrEmpty((String)strPSDevSlnSysId)) {
            return;
        }
        IPSDevSlnSys iPSDevSlnSys = this.getPSModelStorage().getPSDevSlnSys(strPSDevSlnSysId);
        PSSubSysService psSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        net.ibizsys.pscore.srv.config.entity.PSSubSys psSubSys2 = new net.ibizsys.pscore.srv.config.entity.PSSubSys();
        psSubSys2.setPSSubSysId(psSubSys.getPSSUBSYSID());
        psSubSysService.get((IEntity)psSubSys2);
        iPSSystem = iPSDevSlnSys.getPSSystem(false);
        PSSysDevBKTask psSysDevBKTask = new PSSysDevBKTask();
        psSysDevBKTask.setPSSysDevBKTaskName(StringHelper.Format((String)"\u540c\u6b65\u5b50\u7cfb\u7edf[%1$s]\u6a21\u578b", (Object)psSubSys2.getPSSubSysName()));
        psSysDevBKTask.setPSDevSlnSysId(strPSDevSlnSysId);
        psSysDevBKTask.setPSSysModelInstId(iPSDevSlnSys.getPSSysModelInstId());
        psSysDevBKTask.setTaskType("SYNCSUBSYSMODEL");
        psSysDevBKTask.setTaskState(SysDevBKTaskStateCodeListModel.CREATED);
        psSysDevBKTask.setPSSystemId(iPSSystem.getId());
        psSysDevBKTask.setPSSystemName(iPSSystem.getName());
        psSysDevBKTask.setTaskParam(psSubSys.getPSSUBSYSID());
        PSSysDevBKTaskService psSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)PSSysModelInstGlobal.getSessionFactory((String)iPSDevSlnSys.getPSSysModelInstId()));
        psSysDevBKTaskService.create((IEntity)psSysDevBKTask);
        SA.SRFDA.PS.Data.PSSysDevBKTask psSysDevBKTask2 = new SA.SRFDA.PS.Data.PSSysDevBKTask();
        PSSubSysDataCtrl.convertEntity((IEntity)psSysDevBKTask, psSysDevBKTask2);
        this.getPSModelStorage().getPSSysDevBKTaskGlobal().addPSSysDevBKTask(psSysDevBKTask2);
    }
}

