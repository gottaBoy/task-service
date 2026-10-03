/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.service.CloneSession
 *  net.ibizsys.paas.service.IDataContextParam
 *  net.ibizsys.paas.service.IService
 *  net.ibizsys.paas.service.IServicePlugin
 *  net.ibizsys.paas.service.IServiceWork
 *  net.ibizsys.paas.service.ITransaction
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.service.CloneSession;
import net.ibizsys.paas.service.IDataContextParam;
import net.ibizsys.paas.service.IService;
import net.ibizsys.paas.service.IServicePlugin;
import net.ibizsys.paas.service.IServiceWork;
import net.ibizsys.paas.service.ITransaction;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFBase;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.entity.PSSubSysBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPolicy;
import net.ibizsys.pscore.srv.config.entity.PSSysPolicyBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCBDInstBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDeployCenterBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTempl;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCModelTemplBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobotBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLic;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCSysLicBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterASBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInstBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVNBase;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTS;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterTSBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRegistryItemServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSyncDataService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCSyncDataServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCTaskLogService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCTaskLogServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSDevSlnSysKeyService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevSlnSysKeyServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysServiceBase;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerServiceBase;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstServiceBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInstBase;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServerBase;
import net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdServiceBase;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSysVerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysResBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevPrdSysServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCanvasService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCanvasServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnLinkServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepFuncServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnMSDepResServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnPipelineStepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAPIServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGDService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysGDServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysModelServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysRefServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrcService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrcServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrvServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysWSGitService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysWSGitServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserCSServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnUserServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffRepService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSysDiffRepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioTheme;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSStudioThemeBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakLinkServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysBakServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysLockLogService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysLockLogServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkService;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysRefLinkServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysServiceBase
extends PSCoreSysServiceBase<PSDevSlnSys> {
    private static final Log log = LogFactory.getLog(PSDevSlnSysServiceBase.class);
    public static final String DATASET_CURSLN = "CurSln";
    public static final String DATASET_CURSLNTRUNK = "CurSlnTrunk";
    public static final String DATASET_CURSYSBRANCH = "CurSysBranch";
    public static final String DATASET_CURUSER = "CurUser";
    public static final String DATASET_CURUSERTRUNK = "CurUserTrunk";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_TRUNK = "Trunk";
    public static final String ACTION_X_ADDBACKUPSYSMODELTASK = "X_ADDBACKUPSYSMODELTASK";
    public static final String ACTION_X_ADDBINDSYSMODELTASK = "X_ADDBINDSYSMODELTASK";
    public static final String ACTION_X_ADDEXPORTSYSMODELTASK = "X_ADDEXPORTSYSMODELTASK";
    public static final String ACTION_X_ADDIMPORTSYSMODELTASK = "X_ADDIMPORTSYSMODELTASK";
    public static final String ACTION_X_ADDOFFLINESYSMODELTASK = "X_ADDOFFLINESYSMODELTASK";
    public static final String ACTION_X_ADDONLINESYSMODELTASK = "X_ADDONLINESYSMODELTASK";
    public static final String ACTION_X_ADDRESTORESYSMODELTASK = "X_ADDRESTORESYSMODELTASK";
    public static final String ACTION_X_ADDUPGRATESYSMODELTASK = "X_ADDUPGRATESYSMODELTASK";
    public static final String ACTION_ADMINVISIT = "ADMINVISIT";
    public static final String ACTION_X_BACKUPSYSMODEL = "X_BACKUPSYSMODEL";
    public static final String ACTION_BINDSYSMODEL = "BindSysModel";
    public static final String ACTION_CALCDEVRESSTATE = "CALCDEVRESSTATE";
    public static final String ACTION_CREATEASYNC = "CreateAsync";
    public static final String ACTION_FIXPSDCSVNS = "FixPSDCSVNs";
    public static final String ACTION_GETCUR = "GetCur";
    public static final String ACTION_OFFLINE = "Offline";
    public static final String ACTION_RAWOFFLINE = "RawOffline";
    public static final String ACTION_REBINDSYSTEM = "RebindSystem";
    public static final String ACTION_SWITCHPSRES = "SwitchPSRes";
    public static final String ACTION_SWITCHUSERRES = "SwitchUserRes";
    private PSDevSlnSysDEModel pSDevSlnSysDEModel;
    private PSDevSlnSysDAO pSDevSlnSysDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService";
    }

    public PSDevSlnSysDEModel getPSDevSlnSysDEModel() {
        if (this.pSDevSlnSysDEModel == null) {
            try {
                this.pSDevSlnSysDEModel = (PSDevSlnSysDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSDevSlnSysDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDevSlnSysDEModel();
    }

    public PSDevSlnSysDAO getPSDevSlnSysDAO() {
        if (this.pSDevSlnSysDAO == null) {
            try {
                this.pSDevSlnSysDAO = (PSDevSlnSysDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSDevSlnSysDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDevSlnSysDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDevSlnSysDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSLN, (boolean)true) == 0) {
            return this.fetchCurSln(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSLNTRUNK, (boolean)true) == 0) {
            return this.fetchCurSlnTrunk(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSBRANCH, (boolean)true) == 0) {
            return this.fetchCurSysBranch(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSER, (boolean)true) == 0) {
            return this.fetchCurUser(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURUSERTRUNK, (boolean)true) == 0) {
            return this.fetchCurUserTrunk(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_TRUNK, (boolean)true) == 0) {
            return this.fetchTrunk(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDBACKUPSYSMODELTASK, (boolean)true) == 0) {
            this.addBackupSysModelTask((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDBINDSYSMODELTASK, (boolean)true) == 0) {
            this.addBindSysModelTask((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDEXPORTSYSMODELTASK, (boolean)true) == 0) {
            this.addExportSysModelTask((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDIMPORTSYSMODELTASK, (boolean)true) == 0) {
            this.addImportSysModelTask((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDOFFLINESYSMODELTASK, (boolean)true) == 0) {
            this.addOfflineSysModelTask((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDONLINESYSMODELTASK, (boolean)true) == 0) {
            this.addOnlineSysModelTask((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDRESTORESYSMODELTASK, (boolean)true) == 0) {
            this.addRestoreSysModelTask((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_ADDUPGRATESYSMODELTASK, (boolean)true) == 0) {
            this.addUpgrateSysModelTask((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_ADMINVISIT, (boolean)true) == 0) {
            this.adminVisit((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_BACKUPSYSMODEL, (boolean)true) == 0) {
            this.backupSysModel((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_BINDSYSMODEL, (boolean)true) == 0) {
            this.bindSysModel((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CALCDEVRESSTATE, (boolean)true) == 0) {
            this.calcDevResState((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEASYNC, (boolean)true) == 0) {
            this.createAsync((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_FIXPSDCSVNS, (boolean)true) == 0) {
            this.fixPSDCSVNs((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETCUR, (boolean)true) == 0) {
            this.getCur((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_OFFLINE, (boolean)true) == 0) {
            this.offline((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_RAWOFFLINE, (boolean)true) == 0) {
            this.rawOffline((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_REBINDSYSTEM, (boolean)true) == 0) {
            this.rebindSystem((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_SWITCHPSRES, (boolean)true) == 0) {
            this.switchPSRes((PSDevSlnSys)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_SWITCHUSERRES, (boolean)true) == 0) {
            this.switchUserRes((PSDevSlnSys)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurSln(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSlnTrunk(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSLNTRUNK, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysBranch(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSBRANCH, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUser(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSER, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurUserTrunk(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURUSERTRUNK, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTrunk(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_TRUNK, false);
        return dBFetchResult;
    }

    public void addBackupSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDBACKUPSYSMODELTASK, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_X_ADDBACKUPSYSMODELTASK);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_X_ADDBACKUPSYSMODELTASK, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onAddBackupSysModelTask(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDBACKUPSYSMODELTASK, 99, pSDevSlnSys, null);
        }
    }

    protected void onAddBackupSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDBACKUPSYSMODELTASK]");
    }

    public void addBindSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDBINDSYSMODELTASK, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_X_ADDBINDSYSMODELTASK);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_X_ADDBINDSYSMODELTASK, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onAddBindSysModelTask(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDBINDSYSMODELTASK, 99, pSDevSlnSys, null);
        }
    }

    protected void onAddBindSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDBINDSYSMODELTASK]");
    }

    public void addExportSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDEXPORTSYSMODELTASK, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_X_ADDEXPORTSYSMODELTASK);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_X_ADDEXPORTSYSMODELTASK, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onAddExportSysModelTask(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDEXPORTSYSMODELTASK, 99, pSDevSlnSys, null);
        }
    }

    protected void onAddExportSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDEXPORTSYSMODELTASK]");
    }

    public void addImportSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDIMPORTSYSMODELTASK, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_X_ADDIMPORTSYSMODELTASK);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_X_ADDIMPORTSYSMODELTASK, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onAddImportSysModelTask(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDIMPORTSYSMODELTASK, 99, pSDevSlnSys, null);
        }
    }

    protected void onAddImportSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDIMPORTSYSMODELTASK]");
    }

    public void addOfflineSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDOFFLINESYSMODELTASK, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_X_ADDOFFLINESYSMODELTASK);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_X_ADDOFFLINESYSMODELTASK, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onAddOfflineSysModelTask(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDOFFLINESYSMODELTASK, 99, pSDevSlnSys, null);
        }
    }

    protected void onAddOfflineSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDOFFLINESYSMODELTASK]");
    }

    public void addOnlineSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDONLINESYSMODELTASK, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_X_ADDONLINESYSMODELTASK);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_X_ADDONLINESYSMODELTASK, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onAddOnlineSysModelTask(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDONLINESYSMODELTASK, 99, pSDevSlnSys, null);
        }
    }

    protected void onAddOnlineSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDONLINESYSMODELTASK]");
    }

    public void addRestoreSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDRESTORESYSMODELTASK, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_X_ADDRESTORESYSMODELTASK);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_X_ADDRESTORESYSMODELTASK, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onAddRestoreSysModelTask(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDRESTORESYSMODELTASK, 99, pSDevSlnSys, null);
        }
    }

    protected void onAddRestoreSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDRESTORESYSMODELTASK]");
    }

    public void addUpgrateSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDUPGRATESYSMODELTASK, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_X_ADDUPGRATESYSMODELTASK);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_X_ADDUPGRATESYSMODELTASK, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onAddUpgrateSysModelTask(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_ADDUPGRATESYSMODELTASK, 99, pSDevSlnSys, null);
        }
    }

    protected void onAddUpgrateSysModelTask(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_ADDUPGRATESYSMODELTASK]");
    }

    public void adminVisit(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_ADMINVISIT, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_ADMINVISIT);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_ADMINVISIT, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onAdminVisit(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_ADMINVISIT, 99, pSDevSlnSys, null);
        }
    }

    protected void onAdminVisit(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ADMINVISIT]");
    }

    public void backupSysModel(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_BACKUPSYSMODEL, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_X_BACKUPSYSMODEL);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_X_BACKUPSYSMODEL, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onBackupSysModel(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_BACKUPSYSMODEL, 99, pSDevSlnSys, null);
        }
    }

    protected void onBackupSysModel(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_BACKUPSYSMODEL]");
    }

    public void bindSysModel(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_BINDSYSMODEL, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_BINDSYSMODEL);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_BINDSYSMODEL, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onBindSysModel(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_BINDSYSMODEL, 99, pSDevSlnSys, null);
        }
    }

    protected void onBindSysModel(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[BindSysModel]");
    }

    public void calcDevResState(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCDEVRESSTATE, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_CALCDEVRESSTATE);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_CALCDEVRESSTATE, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onCalcDevResState(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCDEVRESSTATE, 99, pSDevSlnSys, null);
        }
    }

    protected void onCalcDevResState(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CALCDEVRESSTATE]");
    }

    public void createAsync(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEASYNC, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_CREATEASYNC);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_CREATEASYNC, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onCreateAsync(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEASYNC, 99, pSDevSlnSys, null);
        }
    }

    protected void onCreateAsync(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateAsync]");
    }

    public void fixPSDCSVNs(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_FIXPSDCSVNS, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_FIXPSDCSVNS);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_FIXPSDCSVNS, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onFixPSDCSVNs(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_FIXPSDCSVNS, 99, pSDevSlnSys, null);
        }
    }

    protected void onFixPSDCSVNs(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[FixPSDCSVNs]");
    }

    public void getCur(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETCUR, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_GETCUR);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_GETCUR, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onGetCur(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETCUR, 99, pSDevSlnSys, null);
        }
    }

    protected void onGetCur(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetCur]");
    }

    public void offline(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_OFFLINE, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_OFFLINE);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_OFFLINE, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onOffline(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_OFFLINE, 99, pSDevSlnSys, null);
        }
    }

    protected void onOffline(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[Offline]");
    }

    public void rawOffline(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_RAWOFFLINE, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_RAWOFFLINE);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_RAWOFFLINE, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onRawOffline(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_RAWOFFLINE, 99, pSDevSlnSys, null);
        }
    }

    protected void onRawOffline(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RawOffline]");
    }

    public void rebindSystem(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_REBINDSYSTEM, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_REBINDSYSTEM);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_REBINDSYSTEM, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onRebindSystem(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_REBINDSYSTEM, 99, pSDevSlnSys, null);
        }
    }

    protected void onRebindSystem(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[RebindSystem]");
    }

    public void switchPSRes(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_SWITCHPSRES, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_SWITCHPSRES);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_SWITCHPSRES, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onSwitchPSRes(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_SWITCHPSRES, 99, pSDevSlnSys, null);
        }
    }

    protected void onSwitchPSRes(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[SwitchPSRes]");
    }

    public void switchUserRes(PSDevSlnSys pSDevSlnSys) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_SWITCHUSERRES, 0, pSDevSlnSys, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDevSlnSys, ACTION_SWITCHUSERRES);
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDevSlnSysServiceBase.this.getService(), PSDevSlnSysServiceBase.ACTION_SWITCHUSERRES, 40, pSDevSlnSys2, null).getResult() != 1) {
                    PSDevSlnSysServiceBase.this.onSwitchUserRes(pSDevSlnSys2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_SWITCHUSERRES, 99, pSDevSlnSys, null);
        }
    }

    protected void onSwitchUserRes(PSDevSlnSys pSDevSlnSys) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[SwitchUserRes]");
    }

    protected void onFillParentInfo(PSDevSlnSys pSDevSlnSys, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDBDEVINST_JITPSDBDEVINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService", (SessionFactory)this.getSessionFactory());
            PSDBDevInst pSDBDevInst = (PSDBDevInst)iService.getDEModel().createEntity();
            pSDBDevInst.set("PSDBDEVINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDBDevInst);
            } else {
                iService.get(pSDBDevInst);
            }
            this.onFillParentInfo_JitPSDBDevInst(pSDevSlnSys, pSDBDevInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDCBDINST_HBASEPSDCBDINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCBDInstService", (SessionFactory)this.getSessionFactory());
            PSDCBDInst pSDCBDInst = (PSDCBDInst)iService.getDEModel().createEntity();
            pSDCBDInst.set("PSDCBDINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCBDInst);
            } else {
                iService.get(pSDCBDInst);
            }
            this.onFillParentInfo_HBasePSDCDBInst(pSDevSlnSys, pSDCBDInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDeployCenterService", (SessionFactory)this.getSessionFactory());
            PSDCDeployCenter pSDCDeployCenter = (PSDCDeployCenter)iService.getDEModel().createEntity();
            pSDCDeployCenter.set("PSDCDEPLOYCENTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCDeployCenter);
            } else {
                iService.get(pSDCDeployCenter);
            }
            this.onFillParentInfo_PSDCDeployCenter(pSDevSlnSys, pSDCDeployCenter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDCMODELTEMPL_PSDCMODELTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCModelTemplService", (SessionFactory)this.getSessionFactory());
            PSDCModelTempl pSDCModelTempl = (PSDCModelTempl)iService.getDEModel().createEntity();
            pSDCModelTempl.set("PSDCMODELTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCModelTempl);
            } else {
                iService.get(pSDCModelTempl);
            }
            this.onFillParentInfo_PSDCModelTempl(pSDevSlnSys, pSDCModelTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDCROBOT_PSDCROBOTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService", (SessionFactory)this.getSessionFactory());
            PSDCRobot pSDCRobot = (PSDCRobot)iService.getDEModel().createEntity();
            pSDCRobot.set("PSDCROBOTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCRobot);
            } else {
                iService.get(pSDCRobot);
            }
            this.onFillParentInfo_PSDCRobot(pSDevSlnSys, pSDCRobot);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDCSYSLIC_PSDCSYSLICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService", (SessionFactory)this.getSessionFactory());
            PSDCSysLic pSDCSysLic = (PSDCSysLic)iService.getDEModel().createEntity();
            pSDCSysLic.set("PSDCSYSLICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDCSysLic);
            } else {
                iService.get(pSDCSysLic);
            }
            this.onFillParentInfo_PSDCSysLic(pSDevSlnSys, pSDCSysLic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERAS_PSDEVCENTERASID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_PSDevCenterAS(pSDevSlnSys, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERAS_PSDEVCENTERASID2", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_PSDevCenterAS2(pSDevSlnSys, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERAS_PSDEVCENTERASID3", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_PSDevCenterAS3(pSDevSlnSys, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERAS_PSDEVCENTERASID4", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService", (SessionFactory)this.getSessionFactory());
            PSDevCenterAS pSDevCenterAS = (PSDevCenterAS)iService.getDEModel().createEntity();
            pSDevCenterAS.set("PSDEVCENTERASID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterAS);
            } else {
                iService.get(pSDevCenterAS);
            }
            this.onFillParentInfo_PSDevCenterAS4(pSDevSlnSys, pSDevCenterAS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_DB2PSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_DB2PSDCDBInst(pSDevSlnSys, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_MSSQLPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_MSSQLPSDCDBInst(pSDevSlnSys, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_MYSQLPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_MySQLPSDCDBInst(pSDevSlnSys, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_ORAPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_OraPSDCDBInst(pSDevSlnSys, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_PGSQLPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PGSQLPSDCDBInst(pSDevSlnSys, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_PPASPSDCDBINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService", (SessionFactory)this.getSessionFactory());
            PSDevCenterDBInst pSDevCenterDBInst = (PSDevCenterDBInst)iService.getDEModel().createEntity();
            pSDevCenterDBInst.set("PSDEVCENTERDBINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterDBInst);
            } else {
                iService.get(pSDevCenterDBInst);
            }
            this.onFillParentInfo_PPASPSDCDBInst(pSDevSlnSys, pSDevCenterDBInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_DOCPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_DocPSDevCenterSVN(pSDevSlnSys, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_MODELPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_ModelPSDevCenterSVN(pSDevSlnSys, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_PSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnSys, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_ROPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_ROPSDevCenterSvn(pSDevSlnSys, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_RTMODELPSDEVCENTERSVNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService", (SessionFactory)this.getSessionFactory());
            PSDevCenterSVN pSDevCenterSVN = (PSDevCenterSVN)iService.getDEModel().createEntity();
            pSDevCenterSVN.set("PSDEVCENTERSVNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterSVN);
            } else {
                iService.get(pSDevCenterSVN);
            }
            this.onFillParentInfo_RTModelPSDevCenterSVN(pSDevSlnSys, pSDevCenterSVN);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERTS_JITPSDEVCENTERTSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService", (SessionFactory)this.getSessionFactory());
            PSDevCenterTS pSDevCenterTS = (PSDevCenterTS)iService.getDEModel().createEntity();
            pSDevCenterTS.set("PSDEVCENTERTSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterTS);
            } else {
                iService.get(pSDevCenterTS);
            }
            this.onFillParentInfo_JITPSDevCenterTS(pSDevSlnSys, pSDevCenterTS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVCENTERTS_PSDEVCENTERTSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterTSService", (SessionFactory)this.getSessionFactory());
            PSDevCenterTS pSDevCenterTS = (PSDevCenterTS)iService.getDEModel().createEntity();
            pSDevCenterTS.set("PSDEVCENTERTSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevCenterTS);
            } else {
                iService.get(pSDevCenterTS);
            }
            this.onFillParentInfo_PSDevCenterTS(pSDevSlnSys, pSDevCenterTS);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVSLNSYSRES_PSDEVSLNSYSRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysResService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSysRes pSDevSlnSysRes = (PSDevSlnSysRes)iService.getDEModel().createEntity();
            pSDevSlnSysRes.set("PSDEVSLNSYSRESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSysRes);
            } else {
                iService.get(pSDevSlnSysRes);
            }
            this.onFillParentInfo_PSDevSlnSysRes(pSDevSlnSys, pSDevSlnSysRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVSLNSYS_MAINPSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys2.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys2);
            } else {
                iService.get(pSDevSlnSys2);
            }
            this.onFillParentInfo_MainPSDevSlnSys(pSDevSlnSys, pSDevSlnSys2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVSLNSYS_PPSDEVSLNSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService", (SessionFactory)this.getSessionFactory());
            PSDevSlnSys pSDevSlnSys3 = (PSDevSlnSys)iService.getDEModel().createEntity();
            pSDevSlnSys3.set("PSDEVSLNSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSlnSys3);
            } else {
                iService.get(pSDevSlnSys3);
            }
            this.onFillParentInfo_PPSDevSlnSys(pSDevSlnSys, pSDevSlnSys3);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSDEVSLN_PSDEVSLNID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            PSDevSln pSDevSln = (PSDevSln)iService.getDEModel().createEntity();
            pSDevSln.set("PSDEVSLNID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDevSln);
            } else {
                iService.get(pSDevSln);
            }
            this.onFillParentInfo_PSDevSln(pSDevSlnSys, pSDevSln);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSPF);
            } else {
                iService.get(pSPF);
            }
            this.onFillParentInfo_PSPF(pSDevSlnSys, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSSF_PSSFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFService", (SessionFactory)this.getSessionFactory());
            PSSF pSSF = (PSSF)iService.getDEModel().createEntity();
            pSSF.set("PSSFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSF);
            } else {
                iService.get(pSSF);
            }
            this.onFillParentInfo_PSSF(pSDevSlnSys, pSSF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSSTUDIOTHEME_PSSTUDIOTHEMEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSStudioThemeService", (SessionFactory)this.getSessionFactory());
            PSStudioTheme pSStudioTheme = (PSStudioTheme)iService.getDEModel().createEntity();
            pSStudioTheme.set("PSSTUDIOTHEMEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSStudioTheme);
            } else {
                iService.get(pSStudioTheme);
            }
            this.onFillParentInfo_PSStudioTheme(pSDevSlnSys, pSStudioTheme);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSSUBSYS_SFPSSUBSYSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysService", (SessionFactory)this.getSessionFactory());
            PSSubSys pSSubSys = (PSSubSys)iService.getDEModel().createEntity();
            pSSubSys.set("PSSUBSYSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSubSys);
            } else {
                iService.get(pSSubSys);
            }
            this.onFillParentInfo_SFPSSubSys(pSDevSlnSys, pSSubSys);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSSYSMODELINST_PSSYSMODELINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService", (SessionFactory)this.getSessionFactory());
            PSSysModelInst pSSysModelInst = (PSSysModelInst)iService.getDEModel().createEntity();
            pSSysModelInst.set("PSSYSMODELINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysModelInst);
            } else {
                iService.get(pSSysModelInst);
            }
            this.onFillParentInfo_PSSysModelInst(pSDevSlnSys, pSSysModelInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSSYSPOLICY_PSSYSPOLICYID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPolicyService", (SessionFactory)this.getSessionFactory());
            PSSysPolicy pSSysPolicy = (PSSysPolicy)iService.getDEModel().createEntity();
            pSSysPolicy.set("PSSYSPOLICYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPolicy);
            } else {
                iService.get(pSSysPolicy);
            }
            this.onFillParentInfo_PSSysPolicy(pSDevSlnSys, pSSysPolicy);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVSLNSYS_PSTASKSERVER_PSTASKSERVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService", (SessionFactory)this.getSessionFactory());
            PSTaskServer pSTaskServer = (PSTaskServer)iService.getDEModel().createEntity();
            pSTaskServer.set("PSTASKSERVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSTaskServer);
            } else {
                iService.get(pSTaskServer);
            }
            this.onFillParentInfo_PSTaskServer(pSDevSlnSys, pSTaskServer);
            return;
        }
        super.onFillParentInfo(pSDevSlnSys, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_JitPSDBDevInst(PSDevSlnSys pSDevSlnSys, PSDBDevInst pSDBDevInst) throws Exception {
        pSDevSlnSys.setJITPSDBDevInstId(pSDBDevInst.getPSDBDevInstId());
        pSDevSlnSys.setJITPSDBDevInstName(pSDBDevInst.getPSDBDevInstName());
    }

    protected void onFillParentInfo_HBasePSDCDBInst(PSDevSlnSys pSDevSlnSys, PSDCBDInst pSDCBDInst) throws Exception {
        pSDevSlnSys.setHBasePSDCBDInstId(pSDCBDInst.getPSDCBDInstId());
        pSDevSlnSys.setHBasePSDCBDInstName(pSDCBDInst.getPSDCBDInstName());
    }

    protected void onFillParentInfo_PSDCDeployCenter(PSDevSlnSys pSDevSlnSys, PSDCDeployCenter pSDCDeployCenter) throws Exception {
        pSDevSlnSys.setPSDCDeployCenterId(pSDCDeployCenter.getPSDCDeployCenterId());
        pSDevSlnSys.setPSDCDeployCenterName(pSDCDeployCenter.getPSDCDeployCenterName());
    }

    protected void onFillParentInfo_PSDCModelTempl(PSDevSlnSys pSDevSlnSys, PSDCModelTempl pSDCModelTempl) throws Exception {
        pSDevSlnSys.setPSDCModelTemplId(pSDCModelTempl.getPSDCModelTemplId());
        pSDevSlnSys.setPSDCModelTemplName(pSDCModelTempl.getPSDCModelTemplName());
    }

    protected void onFillParentInfo_PSDCRobot(PSDevSlnSys pSDevSlnSys, PSDCRobot pSDCRobot) throws Exception {
        pSDevSlnSys.setPSDCRobotId(pSDCRobot.getPSDCRobotId());
        pSDevSlnSys.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
    }

    protected void onFillParentInfo_PSDCSysLic(PSDevSlnSys pSDevSlnSys, PSDCSysLic pSDCSysLic) throws Exception {
        pSDevSlnSys.setPSDCSysLicId(pSDCSysLic.getPSDCSysLicId());
        pSDevSlnSys.setPSDCSysLicName(pSDCSysLic.getPSDCSysLicName());
    }

    protected void onFillParentInfo_PSDevCenterAS(PSDevSlnSys pSDevSlnSys, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSDevSlnSys.setPSDevCenterASId(pSDevCenterAS.getPSDevCenterASId());
        pSDevSlnSys.setPSDevCenterASName(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_PSDevCenterAS2(PSDevSlnSys pSDevSlnSys, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSDevSlnSys.setPSDevCenterASId2(pSDevCenterAS.getPSDevCenterASId());
        pSDevSlnSys.setPSDevCenterASName2(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_PSDevCenterAS3(PSDevSlnSys pSDevSlnSys, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSDevSlnSys.setPSDevCenterAS3Id(pSDevCenterAS.getPSDevCenterASId());
        pSDevSlnSys.setPSDevCenterAS3Name(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_PSDevCenterAS4(PSDevSlnSys pSDevSlnSys, PSDevCenterAS pSDevCenterAS) throws Exception {
        pSDevSlnSys.setPSDevCenterAS4Id(pSDevCenterAS.getPSDevCenterASId());
        pSDevSlnSys.setPSDevCenterAS4Name(pSDevCenterAS.getPSDevCenterASName());
    }

    protected void onFillParentInfo_DB2PSDCDBInst(PSDevSlnSys pSDevSlnSys, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSys.setDB2PSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSys.setDB2PSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_MSSQLPSDCDBInst(PSDevSlnSys pSDevSlnSys, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSys.setMSSQLPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSys.setMSSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_MySQLPSDCDBInst(PSDevSlnSys pSDevSlnSys, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSys.setMySQLPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSys.setMySQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_OraPSDCDBInst(PSDevSlnSys pSDevSlnSys, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSys.setOraPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSys.setOraPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PGSQLPSDCDBInst(PSDevSlnSys pSDevSlnSys, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSys.setPGSQLPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSys.setPGSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_PPASPSDCDBInst(PSDevSlnSys pSDevSlnSys, PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        pSDevSlnSys.setPPASPSDCDBInstId(pSDevCenterDBInst.getPSDevCenterDBInstId());
        pSDevSlnSys.setPPASPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
    }

    protected void onFillParentInfo_DocPSDevCenterSVN(PSDevSlnSys pSDevSlnSys, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSys.setDocGitBranch(pSDevCenterSVN.getGitBranch());
        pSDevSlnSys.setDocGitPath(pSDevCenterSVN.getGitPath());
        pSDevSlnSys.setDocPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSys.setDocPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_ModelPSDevCenterSVN(PSDevSlnSys pSDevSlnSys, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSys.setModelGitBranch(pSDevCenterSVN.getGitBranch());
        pSDevSlnSys.setModelGitPath(pSDevCenterSVN.getGitPath());
        pSDevSlnSys.setModelPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSys.setModelPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_PSDevCenterSVN(PSDevSlnSys pSDevSlnSys, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSys.setGitBranch(pSDevCenterSVN.getGitBranch());
        pSDevSlnSys.setGitPath(pSDevCenterSVN.getGitPath());
        pSDevSlnSys.setPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSys.setPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_ROPSDevCenterSvn(PSDevSlnSys pSDevSlnSys, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSys.setROGitBranch(pSDevCenterSVN.getGitBranch());
        pSDevSlnSys.setROGitPath(pSDevCenterSVN.getGitPath());
        pSDevSlnSys.setROPSDevCenterSvnId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSys.setROPSDevCenterSvnName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_RTModelPSDevCenterSVN(PSDevSlnSys pSDevSlnSys, PSDevCenterSVN pSDevCenterSVN) throws Exception {
        pSDevSlnSys.setRTModelPSDevCenterSVNId(pSDevCenterSVN.getPSDevCenterSVNId());
        pSDevSlnSys.setRTModelPSDevCenterSVNName(pSDevCenterSVN.getPSDevCenterSVNName());
    }

    protected void onFillParentInfo_JITPSDevCenterTS(PSDevSlnSys pSDevSlnSys, PSDevCenterTS pSDevCenterTS) throws Exception {
        pSDevSlnSys.setJITPSDevCenterTSId(pSDevCenterTS.getPSDevCenterTSId());
        pSDevSlnSys.setJITPSDevCenterTSName(pSDevCenterTS.getPSDevCenterTSName());
    }

    protected void onFillParentInfo_PSDevCenterTS(PSDevSlnSys pSDevSlnSys, PSDevCenterTS pSDevCenterTS) throws Exception {
        pSDevSlnSys.setPSDevCenterTSId(pSDevCenterTS.getPSDevCenterTSId());
        pSDevSlnSys.setPSDevCenterTSName(pSDevCenterTS.getPSDevCenterTSName());
    }

    protected void onFillParentInfo_PSDevSlnSysRes(PSDevSlnSys pSDevSlnSys, PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        pSDevSlnSys.setPSDevSlnSysResId(pSDevSlnSysRes.getPSDevSlnSysResId());
        pSDevSlnSys.setPSDevSlnSysResName(pSDevSlnSysRes.getPSDevSlnSysResName());
    }

    protected void onFillParentInfo_MainPSDevSlnSys(PSDevSlnSys pSDevSlnSys, PSDevSlnSys pSDevSlnSys2) throws Exception {
        pSDevSlnSys.setMainPSDevSlnSysId(pSDevSlnSys2.getPSDevSlnSysId());
        pSDevSlnSys.setMainPSDevSlnSysName(pSDevSlnSys2.getPSDevSlnSysName());
        if (pSDevSlnSys2.getPSDevSln() != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnSys, pSDevSlnSys2.getPSDevSln());
        }
    }

    protected void onFillParentInfo_PPSDevSlnSys(PSDevSlnSys pSDevSlnSys, PSDevSlnSys pSDevSlnSys2) throws Exception {
        pSDevSlnSys.setPPSDevSlnSysId(pSDevSlnSys2.getPSDevSlnSysId());
        pSDevSlnSys.setPPSDevSlnSysName(pSDevSlnSys2.getPSDevSlnSysName());
    }

    protected void onFillParentInfo_PSDevSln(PSDevSlnSys pSDevSlnSys, PSDevSln pSDevSln) throws Exception {
        pSDevSlnSys.setPSDevCenterId(pSDevSln.getPSDevCenterId());
        pSDevSlnSys.setPSDevCenterName(pSDevSln.getPSDevCenterName());
        pSDevSlnSys.setPSDevSlnId(pSDevSln.getPSDevSlnId());
        pSDevSlnSys.setPSDevSlnName(pSDevSln.getPSDevSlnName());
    }

    protected void onFillParentInfo_PSPF(PSDevSlnSys pSDevSlnSys, PSPF pSPF) throws Exception {
        pSDevSlnSys.setPSPFId(pSPF.getPSPFId());
        pSDevSlnSys.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSSF(PSDevSlnSys pSDevSlnSys, PSSF pSSF) throws Exception {
        pSDevSlnSys.setPSSFId(pSSF.getPSSFId());
        pSDevSlnSys.setPSSFName(pSSF.getPSSFName());
    }

    protected void onFillParentInfo_PSStudioTheme(PSDevSlnSys pSDevSlnSys, PSStudioTheme pSStudioTheme) throws Exception {
        pSDevSlnSys.setPSStudioThemeId(pSStudioTheme.getPSStudioThemeId());
        pSDevSlnSys.setPSStudioThemeName(pSStudioTheme.getPSStudioThemeName());
        pSDevSlnSys.setThemeCssStyle(pSStudioTheme.getCardCssStyle());
    }

    protected void onFillParentInfo_SFPSSubSys(PSDevSlnSys pSDevSlnSys, PSSubSys pSSubSys) throws Exception {
        pSDevSlnSys.setSFPSSubSysId(pSSubSys.getPSSubSysId());
        pSDevSlnSys.setSFPSSubSysName(pSSubSys.getPSSubSysName());
    }

    protected void onFillParentInfo_PSSysModelInst(PSDevSlnSys pSDevSlnSys, PSSysModelInst pSSysModelInst) throws Exception {
        pSDevSlnSys.setModelInstVer(pSSysModelInst.getModelVer());
        pSDevSlnSys.setPSSysModelInstId(pSSysModelInst.getPSSysModelInstId());
        pSDevSlnSys.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
        pSDevSlnSys.setSysRowKey(pSSysModelInst.getSysRowKey());
    }

    protected void onFillParentInfo_PSSysPolicy(PSDevSlnSys pSDevSlnSys, PSSysPolicy pSSysPolicy) throws Exception {
        pSDevSlnSys.setPSSysPolicyId(pSSysPolicy.getPSSysPolicyId());
        pSDevSlnSys.setPSSysPolicyName(pSSysPolicy.getPSSysPolicyName());
    }

    protected void onFillParentInfo_PSTaskServer(PSDevSlnSys pSDevSlnSys, PSTaskServer pSTaskServer) throws Exception {
        pSDevSlnSys.setPSTaskServerId(pSTaskServer.getPSTaskServerId());
        pSDevSlnSys.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
    }

    protected void onFillEntityFullInfo(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (bl) {
            if (pSDevSlnSys.getDBVersion() == null) {
                pSDevSlnSys.setDBVersion((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDevSlnSys.getEnableDynaSys() == null) {
                pSDevSlnSys.setEnableDynaSys((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnSys.getEntityCnt() == null) {
                pSDevSlnSys.setEntityCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnSys.getSaaSMode() == null) {
                pSDevSlnSys.setSaaSMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnSys.getShareFlag() == null) {
                pSDevSlnSys.setShareFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDevSlnSys.getSysVer() == null) {
                pSDevSlnSys.setSysVer((String)this.getDefaultValue(this.getWebContext(), "", "1", 25));
            }
            if (pSDevSlnSys.getValidFlag() == null) {
                pSDevSlnSys.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDevSlnSys.getVCType() == null) {
                pSDevSlnSys.setVCType((String)this.getDefaultValue(this.getWebContext(), "", "TRUNK", 25));
            }
        }
        super.onFillEntityFullInfo(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_JitPSDBDevInst(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_HBasePSDCDBInst(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDCDeployCenter(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDCModelTempl(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDCRobot(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDCSysLic(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDevCenterAS(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDevCenterAS2(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDevCenterAS3(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDevCenterAS4(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_DB2PSDCDBInst(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_MSSQLPSDCDBInst(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_MySQLPSDCDBInst(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_OraPSDCDBInst(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PGSQLPSDCDBInst(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PPASPSDCDBInst(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_DocPSDevCenterSVN(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_ModelPSDevCenterSVN(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDevCenterSVN(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_ROPSDevCenterSvn(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_RTModelPSDevCenterSVN(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_JITPSDevCenterTS(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDevCenterTS(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDevSlnSysRes(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_MainPSDevSlnSys(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PPSDevSlnSys(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSDevSln(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSPF(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSSF(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSStudioTheme(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_SFPSSubSys(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSSysModelInst(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSSysPolicy(pSDevSlnSys, bl);
        this.onFillEntityFullInfo_PSTaskServer(pSDevSlnSys, bl);
    }

    protected void onFillEntityFullInfo_JitPSDBDevInst(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_HBasePSDCDBInst(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCDeployCenter(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCModelTempl(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDCRobot(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isPSDCRobotIdDirty()) {
            if (pSDevSlnSys.getPSDCRobotId() != null) {
                if (pSDevSlnSys.getPSDCRobotId() == null || pSDevSlnSys.getPSDCRobotName() == null) {
                    PSDCRobot pSDCRobot = pSDevSlnSys.getPSDCRobot();
                    pSDevSlnSys.setPSDCRobotName(pSDCRobot.getPSDCRobotName());
                }
            } else {
                pSDevSlnSys.setPSDCRobotName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDCSysLic(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterAS(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterAS2(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterAS3(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterAS4(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_DB2PSDCDBInst(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isDB2PSDCDBInstIdDirty()) {
            if (pSDevSlnSys.getDB2PSDCDBInstId() != null) {
                if (pSDevSlnSys.getDB2PSDCDBInstId() == null || pSDevSlnSys.getDB2PSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSys.getDB2PSDCDBInst();
                    pSDevSlnSys.setDB2PSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSys.setDB2PSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MSSQLPSDCDBInst(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isMSSQLPSDCDBInstIdDirty()) {
            if (pSDevSlnSys.getMSSQLPSDCDBInstId() != null) {
                if (pSDevSlnSys.getMSSQLPSDCDBInstId() == null || pSDevSlnSys.getMSSQLPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSys.getMSSQLPSDCDBInst();
                    pSDevSlnSys.setMSSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSys.setMSSQLPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MySQLPSDCDBInst(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isMySQLPSDCDBInstIdDirty()) {
            if (pSDevSlnSys.getMySQLPSDCDBInstId() != null) {
                if (pSDevSlnSys.getMySQLPSDCDBInstId() == null || pSDevSlnSys.getMySQLPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSys.getMySQLPSDCDBInst();
                    pSDevSlnSys.setMySQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSys.setMySQLPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OraPSDCDBInst(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isOraPSDCDBInstIdDirty()) {
            if (pSDevSlnSys.getOraPSDCDBInstId() != null) {
                if (pSDevSlnSys.getOraPSDCDBInstId() == null || pSDevSlnSys.getOraPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSys.getOraPSDCDBInst();
                    pSDevSlnSys.setOraPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSys.setOraPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PGSQLPSDCDBInst(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isPGSQLPSDCDBInstIdDirty()) {
            if (pSDevSlnSys.getPGSQLPSDCDBInstId() != null) {
                if (pSDevSlnSys.getPGSQLPSDCDBInstId() == null || pSDevSlnSys.getPGSQLPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSys.getPGSQLPSDCDBInst();
                    pSDevSlnSys.setPGSQLPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSys.setPGSQLPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPASPSDCDBInst(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isPPASPSDCDBInstIdDirty()) {
            if (pSDevSlnSys.getPPASPSDCDBInstId() != null) {
                if (pSDevSlnSys.getPPASPSDCDBInstId() == null || pSDevSlnSys.getPPASPSDCDBInstName() == null) {
                    PSDevCenterDBInst pSDevCenterDBInst = pSDevSlnSys.getPPASPSDCDBInst();
                    pSDevSlnSys.setPPASPSDCDBInstName(pSDevCenterDBInst.getPSDevCenterDBInstName());
                }
            } else {
                pSDevSlnSys.setPPASPSDCDBInstName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_DocPSDevCenterSVN(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ModelPSDevCenterSVN(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterSVN(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ROPSDevCenterSvn(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RTModelPSDevCenterSVN(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_JITPSDevCenterTS(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDevCenterTS(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isPSDevCenterTSIdDirty()) {
            if (pSDevSlnSys.getPSDevCenterTSId() != null) {
                if (pSDevSlnSys.getPSDevCenterTSId() == null || pSDevSlnSys.getPSDevCenterTSName() == null) {
                    PSDevCenterTS pSDevCenterTS = pSDevSlnSys.getPSDevCenterTS();
                    pSDevSlnSys.setPSDevCenterTSName(pSDevCenterTS.getPSDevCenterTSName());
                }
            } else {
                pSDevSlnSys.setPSDevCenterTSName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSlnSysRes(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MainPSDevSlnSys(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isMainPSDevSlnSysIdDirty()) {
            if (pSDevSlnSys.getMainPSDevSlnSysId() != null) {
                PSDevSlnSys pSDevSlnSys2;
                if (pSDevSlnSys.getMainPSDevSlnSysId() == null || pSDevSlnSys.getMainPSDevSlnSysName() == null) {
                    pSDevSlnSys2 = pSDevSlnSys.getMainPSDevSlnSys();
                    pSDevSlnSys.setMainPSDevSlnSysName(pSDevSlnSys2.getPSDevSlnSysName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDevSlnSys2 = pSDevSlnSys.getMainPSDevSlnSys()).getPSDevSlnId(), (Object)pSDevSlnSys.getPSDevSlnId()) != 0L) {
                    pSDevSlnSys.setPSDevSlnId(pSDevSlnSys2.getPSDevSlnId());
                    this.onFillEntityFullInfo_PSDevSln(pSDevSlnSys, bl);
                }
            } else {
                pSDevSlnSys.setMainPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PPSDevSlnSys(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isPPSDevSlnSysIdDirty()) {
            if (pSDevSlnSys.getPPSDevSlnSysId() != null) {
                if (pSDevSlnSys.getPPSDevSlnSysId() == null || pSDevSlnSys.getPPSDevSlnSysName() == null) {
                    PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys.getPPSDevSlnSys();
                    pSDevSlnSys.setPPSDevSlnSysName(pSDevSlnSys2.getPSDevSlnSysName());
                }
            } else {
                pSDevSlnSys.setPPSDevSlnSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDevSln(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isPSDevSlnIdDirty()) {
            if (pSDevSlnSys.getPSDevSlnId() != null) {
                if (pSDevSlnSys.getPSDevSlnId() == null || pSDevSlnSys.getPSDevSlnName() == null) {
                    PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
                    pSDevSlnSys.setPSDevCenterId(pSDevSln.getPSDevCenterId());
                    pSDevSlnSys.setPSDevCenterName(pSDevSln.getPSDevCenterName());
                    pSDevSlnSys.setPSDevSlnName(pSDevSln.getPSDevSlnName());
                }
            } else {
                pSDevSlnSys.setPSDevCenterId(null);
                pSDevSlnSys.setPSDevCenterName(null);
                pSDevSlnSys.setPSDevSlnName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPF(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSF(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isPSSFIdDirty()) {
            if (pSDevSlnSys.getPSSFId() != null) {
                if (pSDevSlnSys.getPSSFId() == null || pSDevSlnSys.getPSSFName() == null) {
                    PSSF pSSF = pSDevSlnSys.getPSSF();
                    pSDevSlnSys.setPSSFName(pSSF.getPSSFName());
                }
            } else {
                pSDevSlnSys.setPSSFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSStudioTheme(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SFPSSubSys(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isSFPSSubSysIdDirty()) {
            if (pSDevSlnSys.getSFPSSubSysId() != null) {
                if (pSDevSlnSys.getSFPSSubSysId() == null || pSDevSlnSys.getSFPSSubSysName() == null) {
                    PSSubSys pSSubSys = pSDevSlnSys.getSFPSSubSys();
                    pSDevSlnSys.setSFPSSubSysName(pSSubSys.getPSSubSysName());
                }
            } else {
                pSDevSlnSys.setSFPSSubSysName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysModelInst(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isPSSysModelInstIdDirty()) {
            if (pSDevSlnSys.getPSSysModelInstId() != null) {
                if (pSDevSlnSys.getPSSysModelInstId() == null || pSDevSlnSys.getPSSysModelInstName() == null) {
                    PSSysModelInst pSSysModelInst = pSDevSlnSys.getPSSysModelInst();
                    pSDevSlnSys.setModelInstVer(pSSysModelInst.getModelVer());
                    pSDevSlnSys.setPSSysModelInstName(pSSysModelInst.getPSSysModelInstName());
                    pSDevSlnSys.setSysRowKey(pSSysModelInst.getSysRowKey());
                }
            } else {
                pSDevSlnSys.setModelInstVer(null);
                pSDevSlnSys.setPSSysModelInstName(null);
                pSDevSlnSys.setSysRowKey(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysPolicy(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSTaskServer(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        if (pSDevSlnSys.isPSTaskServerIdDirty()) {
            if (pSDevSlnSys.getPSTaskServerId() != null) {
                if (pSDevSlnSys.getPSTaskServerId() == null || pSDevSlnSys.getPSTaskServerName() == null) {
                    PSTaskServer pSTaskServer = pSDevSlnSys.getPSTaskServer();
                    pSDevSlnSys.setPSTaskServerName(pSTaskServer.getPSTaskServerName());
                }
            } else {
                pSDevSlnSys.setPSTaskServerName(null);
            }
        }
    }

    protected void onWriteBackParent(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        super.onWriteBackParent(pSDevSlnSys, bl);
    }

    public ArrayList<PSDevSlnSys> selectByJitPSDBDevInst(PSDBDevInstBase pSDBDevInstBase) throws Exception {
        return this.selectByJitPSDBDevInst(pSDBDevInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByJitPSDBDevInst(PSDBDevInstBase pSDBDevInstBase, String string) throws Exception {
        return this.selectByJitPSDBDevInst(pSDBDevInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByJitPSDBDevInst(PSDBDevInstBase pSDBDevInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("JITPSDBDEVINSTID", (Object)pSDBDevInstBase.getPSDBDevInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByJitPSDBDevInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByJitPSDBDevInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByHBasePSDCDBInst(PSDCBDInstBase pSDCBDInstBase) throws Exception {
        return this.selectByHBasePSDCDBInst(pSDCBDInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByHBasePSDCDBInst(PSDCBDInstBase pSDCBDInstBase, String string) throws Exception {
        return this.selectByHBasePSDCDBInst(pSDCBDInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByHBasePSDCDBInst(PSDCBDInstBase pSDCBDInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("HBASEPSDCBDINSTID", (Object)pSDCBDInstBase.getPSDCBDInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByHBasePSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByHBasePSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string) throws Exception {
        return this.selectByPSDCDeployCenter(pSDCDeployCenterBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDCDeployCenter(PSDCDeployCenterBase pSDCDeployCenterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCDEPLOYCENTERID", (Object)pSDCDeployCenterBase.getPSDCDeployCenterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCDeployCenterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCDeployCenterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDCModelTempl(PSDCModelTemplBase pSDCModelTemplBase) throws Exception {
        return this.selectByPSDCModelTempl(pSDCModelTemplBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDCModelTempl(PSDCModelTemplBase pSDCModelTemplBase, String string) throws Exception {
        return this.selectByPSDCModelTempl(pSDCModelTemplBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDCModelTempl(PSDCModelTemplBase pSDCModelTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCMODELTEMPLID", (Object)pSDCModelTemplBase.getPSDCModelTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCModelTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCModelTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string) throws Exception {
        return this.selectByPSDCRobot(pSDCRobotBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDCRobot(PSDCRobotBase pSDCRobotBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCROBOTID", (Object)pSDCRobotBase.getPSDCRobotId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCRobotCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCRobotCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDCSysLic(PSDCSysLicBase pSDCSysLicBase) throws Exception {
        return this.selectByPSDCSysLic(pSDCSysLicBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDCSysLic(PSDCSysLicBase pSDCSysLicBase, String string) throws Exception {
        return this.selectByPSDCSysLic(pSDCSysLicBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDCSysLic(PSDCSysLicBase pSDCSysLicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDCSYSLICID", (Object)pSDCSysLicBase.getPSDCSysLicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDCSysLicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDCSysLicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByPSDevCenterAS(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByPSDevCenterAS(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERASID", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterASCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterASCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS2(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByPSDevCenterAS2(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS2(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByPSDevCenterAS2(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS2(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERASID2", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterAS2Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterAS2Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS3(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByPSDevCenterAS3(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS3(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByPSDevCenterAS3(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS3(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERASID3", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterAS3Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterAS3Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS4(PSDevCenterASBase pSDevCenterASBase) throws Exception {
        return this.selectByPSDevCenterAS4(pSDevCenterASBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS4(PSDevCenterASBase pSDevCenterASBase, String string) throws Exception {
        return this.selectByPSDevCenterAS4(pSDevCenterASBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterAS4(PSDevCenterASBase pSDevCenterASBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERASID4", (Object)pSDevCenterASBase.getPSDevCenterASId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterAS4Cond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterAS4Cond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByDB2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByDB2PSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByDB2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByDB2PSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByDB2PSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DB2PSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDB2PSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDB2PSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByMSSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByMSSQLPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByMSSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByMSSQLPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByMSSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MSSQLPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMSSQLPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMSSQLPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByMySQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByMySQLPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByMySQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByMySQLPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByMySQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MYSQLPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMySQLPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMySQLPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByOraPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByOraPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByOraPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByOraPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByOraPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ORAPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOraPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOraPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPGSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPGSQLPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPGSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPGSQLPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPGSQLPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PGSQLPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPGSQLPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPGSQLPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPPASPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase) throws Exception {
        return this.selectByPPASPSDCDBInst(pSDevCenterDBInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPPASPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string) throws Exception {
        return this.selectByPPASPSDCDBInst(pSDevCenterDBInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPPASPSDCDBInst(PSDevCenterDBInstBase pSDevCenterDBInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPASPSDCDBINSTID", (Object)pSDevCenterDBInstBase.getPSDevCenterDBInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPASPSDCDBInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPASPSDCDBInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByDocPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByDocPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByDocPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByDocPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByDocPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("DOCPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByDocPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByDocPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByModelPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByModelPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MODELPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByModelPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByModelPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByROPSDevCenterSvn(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByROPSDevCenterSvn(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByROPSDevCenterSvn(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByROPSDevCenterSvn(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByROPSDevCenterSvn(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ROPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByROPSDevCenterSvnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByROPSDevCenterSvnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByRTModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase) throws Exception {
        return this.selectByRTModelPSDevCenterSVN(pSDevCenterSVNBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByRTModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string) throws Exception {
        return this.selectByRTModelPSDevCenterSVN(pSDevCenterSVNBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByRTModelPSDevCenterSVN(PSDevCenterSVNBase pSDevCenterSVNBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("RTMODELPSDEVCENTERSVNID", (Object)pSDevCenterSVNBase.getPSDevCenterSVNId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRTModelPSDevCenterSVNCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRTModelPSDevCenterSVNCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByJITPSDevCenterTS(PSDevCenterTSBase pSDevCenterTSBase) throws Exception {
        return this.selectByJITPSDevCenterTS(pSDevCenterTSBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByJITPSDevCenterTS(PSDevCenterTSBase pSDevCenterTSBase, String string) throws Exception {
        return this.selectByJITPSDevCenterTS(pSDevCenterTSBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByJITPSDevCenterTS(PSDevCenterTSBase pSDevCenterTSBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("JITPSDEVCENTERTSID", (Object)pSDevCenterTSBase.getPSDevCenterTSId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByJITPSDevCenterTSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByJITPSDevCenterTSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterTS(PSDevCenterTSBase pSDevCenterTSBase) throws Exception {
        return this.selectByPSDevCenterTS(pSDevCenterTSBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterTS(PSDevCenterTSBase pSDevCenterTSBase, String string) throws Exception {
        return this.selectByPSDevCenterTS(pSDevCenterTSBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevCenterTS(PSDevCenterTSBase pSDevCenterTSBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVCENTERTSID", (Object)pSDevCenterTSBase.getPSDevCenterTSId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevCenterTSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevCenterTSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDevSlnSysRes(PSDevSlnSysResBase pSDevSlnSysResBase) throws Exception {
        return this.selectByPSDevSlnSysRes(pSDevSlnSysResBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevSlnSysRes(PSDevSlnSysResBase pSDevSlnSysResBase, String string) throws Exception {
        return this.selectByPSDevSlnSysRes(pSDevSlnSysResBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevSlnSysRes(PSDevSlnSysResBase pSDevSlnSysResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNSYSRESID", (Object)pSDevSlnSysResBase.getPSDevSlnSysResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnSysResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnSysResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByMainPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByMainPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByMainPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByMainPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByMainPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MAINPSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMainPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMainPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase) throws Exception {
        return this.selectByPPSDevSlnSys(pSDevSlnSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string) throws Exception {
        return this.selectByPPSDevSlnSys(pSDevSlnSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPPSDevSlnSys(PSDevSlnSysBase pSDevSlnSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSDEVSLNSYSID", (Object)pSDevSlnSysBase.getPSDevSlnSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSDevSlnSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSDevSlnSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSDevSln(PSDevSlnBase pSDevSlnBase) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string) throws Exception {
        return this.selectByPSDevSln(pSDevSlnBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSDevSln(PSDevSlnBase pSDevSlnBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVSLNID", (Object)pSDevSlnBase.getPSDevSlnId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDevSlnCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDevSlnCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSSF(PSSFBase pSSFBase) throws Exception {
        return this.selectByPSSF(pSSFBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSSF(PSSFBase pSSFBase, String string) throws Exception {
        return this.selectByPSSF(pSSFBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSSF(PSSFBase pSSFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSFID", (Object)pSSFBase.getPSSFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSStudioTheme(PSStudioThemeBase pSStudioThemeBase) throws Exception {
        return this.selectByPSStudioTheme(pSStudioThemeBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSStudioTheme(PSStudioThemeBase pSStudioThemeBase, String string) throws Exception {
        return this.selectByPSStudioTheme(pSStudioThemeBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSStudioTheme(PSStudioThemeBase pSStudioThemeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSTUDIOTHEMEID", (Object)pSStudioThemeBase.getPSStudioThemeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSStudioThemeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSStudioThemeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectBySFPSSubSys(PSSubSysBase pSSubSysBase) throws Exception {
        return this.selectBySFPSSubSys(pSSubSysBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectBySFPSSubSys(PSSubSysBase pSSubSysBase, String string) throws Exception {
        return this.selectBySFPSSubSys(pSSubSysBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectBySFPSSubSys(PSSubSysBase pSSubSysBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SFPSSUBSYSID", (Object)pSSubSysBase.getPSSubSysId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySFPSSubSysCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySFPSSubSysCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string) throws Exception {
        return this.selectByPSSysModelInst(pSSysModelInstBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSSysModelInst(PSSysModelInstBase pSSysModelInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMODELINSTID", (Object)pSSysModelInstBase.getPSSysModelInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysModelInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysModelInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSSysPolicy(PSSysPolicyBase pSSysPolicyBase) throws Exception {
        return this.selectByPSSysPolicy(pSSysPolicyBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSSysPolicy(PSSysPolicyBase pSSysPolicyBase, String string) throws Exception {
        return this.selectByPSSysPolicy(pSSysPolicyBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSSysPolicy(PSSysPolicyBase pSSysPolicyBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPOLICYID", (Object)pSSysPolicyBase.getPSSysPolicyId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPolicyCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPolicyCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDevSlnSys> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, "", -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string) throws Exception {
        return this.selectByPSTaskServer(pSTaskServerBase, string, -1);
    }

    public ArrayList<PSDevSlnSys> selectByPSTaskServer(PSTaskServerBase pSTaskServerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSTASKSERVERID", (Object)pSTaskServerBase.getPSTaskServerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSTaskServerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSTaskServerCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByJitPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByJitPSDBDevInst(pSDBDevInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDBDEVINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDBDevInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDBDEVINST_JITPSDBDEVINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDBDevInst), arrayList.get(0)));
        }
    }

    public void resetJitPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByJitPSDBDevInst(pSDBDevInst);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setJITPSDBDevInstId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByJitPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        final PSDBDevInst pSDBDevInst2 = pSDBDevInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByJitPSDBDevInst(pSDBDevInst2);
                PSDevSlnSysServiceBase.this.internalRemoveByJitPSDBDevInst(pSDBDevInst2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByJitPSDBDevInst(pSDBDevInst2);
            }
        });
    }

    protected void onBeforeRemoveByJitPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
    }

    protected void internalRemoveByJitPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByJitPSDBDevInst(pSDBDevInst);
        this.onBeforeRemoveByJitPSDBDevInst(pSDBDevInst, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByJitPSDBDevInst(pSDBDevInst, arrayList);
    }

    protected void onAfterRemoveByJitPSDBDevInst(PSDBDevInst pSDBDevInst) throws Exception {
    }

    protected void onBeforeRemoveByJitPSDBDevInst(PSDBDevInst pSDBDevInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByJitPSDBDevInst(PSDBDevInst pSDBDevInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByHBasePSDCDBInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByHBasePSDCDBInst(pSDCBDInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCBDINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCBDInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDCBDINST_HBASEPSDCBDINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDCBDInst), arrayList.get(0)));
        }
    }

    public void resetHBasePSDCDBInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByHBasePSDCDBInst(pSDCBDInst);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setHBasePSDCBDInstId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByHBasePSDCDBInst(PSDCBDInst pSDCBDInst) throws Exception {
        final PSDCBDInst pSDCBDInst2 = pSDCBDInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByHBasePSDCDBInst(pSDCBDInst2);
                PSDevSlnSysServiceBase.this.internalRemoveByHBasePSDCDBInst(pSDCBDInst2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByHBasePSDCDBInst(pSDCBDInst2);
            }
        });
    }

    protected void onBeforeRemoveByHBasePSDCDBInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void internalRemoveByHBasePSDCDBInst(PSDCBDInst pSDCBDInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByHBasePSDCDBInst(pSDCBDInst);
        this.onBeforeRemoveByHBasePSDCDBInst(pSDCBDInst, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByHBasePSDCDBInst(pSDCBDInst, arrayList);
    }

    protected void onAfterRemoveByHBasePSDCDBInst(PSDCBDInst pSDCBDInst) throws Exception {
    }

    protected void onBeforeRemoveByHBasePSDCDBInst(PSDCBDInst pSDCBDInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByHBasePSDCDBInst(PSDCBDInst pSDCBDInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCDEPLOYCENTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCDeployCenter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDCDEPLOYCENTER_PSDCDEPLOYCENTERID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDCDeployCenter), arrayList.get(0)));
        }
    }

    public void resetPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDCDeployCenterId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        final PSDCDeployCenter pSDCDeployCenter2 = pSDCDeployCenter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDCDeployCenter(pSDCDeployCenter2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void internalRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCDeployCenter(pSDCDeployCenter);
        this.onBeforeRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDCDeployCenter(pSDCDeployCenter, arrayList);
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter) throws Exception {
    }

    protected void onBeforeRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCDeployCenter(PSDCDeployCenter pSDCDeployCenter, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCModelTempl(pSDCModelTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCMODELTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCModelTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDCMODELTEMPL_PSDCMODELTEMPLID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDCModelTempl), arrayList.get(0)));
        }
    }

    public void resetPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCModelTempl(pSDCModelTempl);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDCModelTemplId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        final PSDCModelTempl pSDCModelTempl2 = pSDCModelTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDCModelTempl(pSDCModelTempl2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDCModelTempl(pSDCModelTempl2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDCModelTempl(pSDCModelTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
    }

    protected void internalRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCModelTempl(pSDCModelTempl);
        this.onBeforeRemoveByPSDCModelTempl(pSDCModelTempl, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDCModelTempl(pSDCModelTempl, arrayList);
    }

    protected void onAfterRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCModelTempl(PSDCModelTempl pSDCModelTempl, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCRobot(pSDCRobot, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCROBOT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCRobot);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDCROBOT_PSDCROBOTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDCRobot), arrayList.get(0)));
        }
    }

    public void resetPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCRobot(pSDCRobot);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDCRobotId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        final PSDCRobot pSDCRobot2 = pSDCRobot;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDCRobot(pSDCRobot2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDCRobot(pSDCRobot2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDCRobot(pSDCRobot2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void internalRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCRobot(pSDCRobot);
        this.onBeforeRemoveByPSDCRobot(pSDCRobot, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDCRobot(pSDCRobot, arrayList);
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot) throws Exception {
    }

    protected void onBeforeRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCRobot(PSDCRobot pSDCRobot, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDCSysLic(PSDCSysLic pSDCSysLic) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCSysLic(pSDCSysLic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDCSYSLIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDCSysLic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDCSYSLIC_PSDCSYSLICID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDCSysLic), arrayList.get(0)));
        }
    }

    public void resetPSDCSysLic(PSDCSysLic pSDCSysLic) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCSysLic(pSDCSysLic);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDCSysLicId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDCSysLic(PSDCSysLic pSDCSysLic) throws Exception {
        final PSDCSysLic pSDCSysLic2 = pSDCSysLic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDCSysLic(pSDCSysLic2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDCSysLic(pSDCSysLic2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDCSysLic(pSDCSysLic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDCSysLic(PSDCSysLic pSDCSysLic) throws Exception {
    }

    protected void internalRemoveByPSDCSysLic(PSDCSysLic pSDCSysLic) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDCSysLic(pSDCSysLic);
        this.onBeforeRemoveByPSDCSysLic(pSDCSysLic, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDCSysLic(pSDCSysLic, arrayList);
    }

    protected void onAfterRemoveByPSDCSysLic(PSDCSysLic pSDCSysLic) throws Exception {
    }

    protected void onBeforeRemoveByPSDCSysLic(PSDCSysLic pSDCSysLic, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDCSysLic(PSDCSysLic pSDCSysLic, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERAS_PSDEVCENTERASID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDevCenterASId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDevCenterAS(pSDevCenterAS2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDevCenterAS(pSDevCenterAS2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDevCenterAS(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS(pSDevCenterAS);
        this.onBeforeRemoveByPSDevCenterAS(pSDevCenterAS, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDevCenterAS(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterAS(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS2(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERAS_PSDEVCENTERASID2", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS2(pSDevCenterAS);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDevCenterASId2(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDevCenterAS2(pSDevCenterAS2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDevCenterAS2(pSDevCenterAS2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDevCenterAS2(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS2(pSDevCenterAS);
        this.onBeforeRemoveByPSDevCenterAS2(pSDevCenterAS, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDevCenterAS2(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterAS2(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterAS3(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS3(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERAS_PSDEVCENTERASID3", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterAS3(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS3(pSDevCenterAS);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDevCenterAS3Id(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDevCenterAS3(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDevCenterAS3(pSDevCenterAS2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDevCenterAS3(pSDevCenterAS2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDevCenterAS3(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterAS3(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByPSDevCenterAS3(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS3(pSDevCenterAS);
        this.onBeforeRemoveByPSDevCenterAS3(pSDevCenterAS, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDevCenterAS3(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterAS3(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterAS3(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterAS3(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterAS4(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS4(pSDevCenterAS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERAS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterAS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERAS_PSDEVCENTERASID4", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterAS), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterAS4(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS4(pSDevCenterAS);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDevCenterAS4Id(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDevCenterAS4(PSDevCenterAS pSDevCenterAS) throws Exception {
        final PSDevCenterAS pSDevCenterAS2 = pSDevCenterAS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDevCenterAS4(pSDevCenterAS2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDevCenterAS4(pSDevCenterAS2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDevCenterAS4(pSDevCenterAS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterAS4(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void internalRemoveByPSDevCenterAS4(PSDevCenterAS pSDevCenterAS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterAS4(pSDevCenterAS);
        this.onBeforeRemoveByPSDevCenterAS4(pSDevCenterAS, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDevCenterAS4(pSDevCenterAS, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterAS4(PSDevCenterAS pSDevCenterAS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterAS4(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterAS4(PSDevCenterAS pSDevCenterAS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByDB2PSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_DB2PSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByDB2PSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setDB2PSDCDBInstId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByDB2PSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.internalRemoveByDB2PSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByDB2PSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByDB2PSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByDB2PSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByDB2PSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDB2PSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByMSSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByMSSQLPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_MSSQLPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetMSSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByMSSQLPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setMSSQLPSDCDBInstId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByMSSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByMSSQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.internalRemoveByMSSQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByMSSQLPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByMSSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByMSSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByMSSQLPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByMSSQLPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByMSSQLPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByMSSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByMSSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMSSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByMySQLPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_MYSQLPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByMySQLPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setMySQLPSDCDBInstId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByMySQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.internalRemoveByMySQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByMySQLPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByMySQLPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByMySQLPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByMySQLPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMySQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByOraPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_ORAPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByOraPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setOraPSDCDBInstId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByOraPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.internalRemoveByOraPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByOraPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByOraPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByOraPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByOraPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOraPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPGSQLPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_PGSQLPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPGSQLPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPGSQLPSDCDBInstId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.internalRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPGSQLPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPGSQLPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPGSQLPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPPASPSDCDBInst(pSDevCenterDBInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERDBINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterDBInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERDBINST_PPASPSDCDBINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterDBInst), arrayList.get(0)));
        }
    }

    public void resetPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPPASPSDCDBInst(pSDevCenterDBInst);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPPASPSDCDBInstId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        final PSDevCenterDBInst pSDevCenterDBInst2 = pSDevCenterDBInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPPASPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.internalRemoveByPPASPSDCDBInst(pSDevCenterDBInst2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPPASPSDCDBInst(pSDevCenterDBInst2);
            }
        });
    }

    protected void onBeforeRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void internalRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPPASPSDCDBInst(pSDevCenterDBInst);
        this.onBeforeRemoveByPPASPSDCDBInst(pSDevCenterDBInst, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPPASPSDCDBInst(pSDevCenterDBInst, arrayList);
    }

    protected void onAfterRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst) throws Exception {
    }

    protected void onBeforeRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPASPSDCDBInst(PSDevCenterDBInst pSDevCenterDBInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByDocPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByDocPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_DOCPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetDocPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByDocPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setDocPSDevCenterSVNId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByDocPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByDocPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.internalRemoveByDocPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByDocPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByDocPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByDocPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByDocPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByDocPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByDocPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByDocPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByDocPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByDocPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_MODELPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setModelPSDevCenterSVNId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.internalRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByModelPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByModelPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_PSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDevCenterSVNId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByROPSDevCenterSvn(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByROPSDevCenterSvn(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_ROPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetROPSDevCenterSvn(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByROPSDevCenterSvn(pSDevCenterSVN);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setROPSDevCenterSvnId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByROPSDevCenterSvn(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByROPSDevCenterSvn(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.internalRemoveByROPSDevCenterSvn(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByROPSDevCenterSvn(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByROPSDevCenterSvn(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByROPSDevCenterSvn(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByROPSDevCenterSvn(pSDevCenterSVN);
        this.onBeforeRemoveByROPSDevCenterSvn(pSDevCenterSVN, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByROPSDevCenterSvn(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByROPSDevCenterSvn(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByROPSDevCenterSvn(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByROPSDevCenterSvn(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByRTModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByRTModelPSDevCenterSVN(pSDevCenterSVN, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERSVN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterSVN);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERSVN_RTMODELPSDEVCENTERSVNID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterSVN), arrayList.get(0)));
        }
    }

    public void resetRTModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByRTModelPSDevCenterSVN(pSDevCenterSVN);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setRTModelPSDevCenterSVNId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByRTModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        final PSDevCenterSVN pSDevCenterSVN2 = pSDevCenterSVN;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByRTModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.internalRemoveByRTModelPSDevCenterSVN(pSDevCenterSVN2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByRTModelPSDevCenterSVN(pSDevCenterSVN2);
            }
        });
    }

    protected void onBeforeRemoveByRTModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void internalRemoveByRTModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByRTModelPSDevCenterSVN(pSDevCenterSVN);
        this.onBeforeRemoveByRTModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByRTModelPSDevCenterSVN(pSDevCenterSVN, arrayList);
    }

    protected void onAfterRemoveByRTModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN) throws Exception {
    }

    protected void onBeforeRemoveByRTModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRTModelPSDevCenterSVN(PSDevCenterSVN pSDevCenterSVN, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByJITPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByJITPSDevCenterTS(pSDevCenterTS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERTS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterTS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERTS_JITPSDEVCENTERTSID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterTS), arrayList.get(0)));
        }
    }

    public void resetJITPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByJITPSDevCenterTS(pSDevCenterTS);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setJITPSDevCenterTSId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByJITPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
        final PSDevCenterTS pSDevCenterTS2 = pSDevCenterTS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByJITPSDevCenterTS(pSDevCenterTS2);
                PSDevSlnSysServiceBase.this.internalRemoveByJITPSDevCenterTS(pSDevCenterTS2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByJITPSDevCenterTS(pSDevCenterTS2);
            }
        });
    }

    protected void onBeforeRemoveByJITPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
    }

    protected void internalRemoveByJITPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByJITPSDevCenterTS(pSDevCenterTS);
        this.onBeforeRemoveByJITPSDevCenterTS(pSDevCenterTS, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByJITPSDevCenterTS(pSDevCenterTS, arrayList);
    }

    protected void onAfterRemoveByJITPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
    }

    protected void onBeforeRemoveByJITPSDevCenterTS(PSDevCenterTS pSDevCenterTS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByJITPSDevCenterTS(PSDevCenterTS pSDevCenterTS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterTS(pSDevCenterTS, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVCENTERTS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevCenterTS);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVCENTERTS_PSDEVCENTERTSID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevCenterTS), arrayList.get(0)));
        }
    }

    public void resetPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterTS(pSDevCenterTS);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDevCenterTSId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
        final PSDevCenterTS pSDevCenterTS2 = pSDevCenterTS;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDevCenterTS(pSDevCenterTS2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDevCenterTS(pSDevCenterTS2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDevCenterTS(pSDevCenterTS2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
    }

    protected void internalRemoveByPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevCenterTS(pSDevCenterTS);
        this.onBeforeRemoveByPSDevCenterTS(pSDevCenterTS, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDevCenterTS(pSDevCenterTS, arrayList);
    }

    protected void onAfterRemoveByPSDevCenterTS(PSDevCenterTS pSDevCenterTS) throws Exception {
    }

    protected void onBeforeRemoveByPSDevCenterTS(PSDevCenterTS pSDevCenterTS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevCenterTS(PSDevCenterTS pSDevCenterTS, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSlnSysRes(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevSlnSysRes(pSDevSlnSysRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYSRES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSysRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVSLNSYSRES_PSDEVSLNSYSRESID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevSlnSysRes), arrayList.get(0)));
        }
    }

    public void resetPSDevSlnSysRes(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevSlnSysRes(pSDevSlnSysRes);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDevSlnSysResId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDevSlnSysRes(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        final PSDevSlnSysRes pSDevSlnSysRes2 = pSDevSlnSysRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDevSlnSysRes(pSDevSlnSysRes2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDevSlnSysRes(pSDevSlnSysRes2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDevSlnSysRes(pSDevSlnSysRes2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSlnSysRes(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
    }

    protected void internalRemoveByPSDevSlnSysRes(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevSlnSysRes(pSDevSlnSysRes);
        this.onBeforeRemoveByPSDevSlnSysRes(pSDevSlnSysRes, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDevSlnSysRes(pSDevSlnSysRes, arrayList);
    }

    protected void onAfterRemoveByPSDevSlnSysRes(PSDevSlnSysRes pSDevSlnSysRes) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSlnSysRes(PSDevSlnSysRes pSDevSlnSysRes, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSlnSysRes(PSDevSlnSysRes pSDevSlnSysRes, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByMainPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByMainPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVSLNSYS_MAINPSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetMainPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByMainPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSys pSDevSlnSys2 : arrayList) {
            PSDevSlnSys pSDevSlnSys3 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys3.setPSDevSlnSysId(pSDevSlnSys2.getPSDevSlnSysId());
            pSDevSlnSys3.setMainPSDevSlnSysId(null);
            this.update(pSDevSlnSys3);
        }
    }

    public void removeByMainPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByMainPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysServiceBase.this.internalRemoveByMainPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByMainPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByMainPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByMainPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByMainPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByMainPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSys pSDevSlnSys2 : arrayList) {
            this.remove(pSDevSlnSys2);
        }
        this.onAfterRemoveByMainPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByMainPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByMainPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMainPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPPSDevSlnSys(pSDevSlnSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVSLNSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDevSlnSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSDEVSLNSYS_PPSDEVSLNSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSDevSlnSys), arrayList.get(0)));
        }
    }

    public void resetPPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPPSDevSlnSys(pSDevSlnSys);
        for (PSDevSlnSys pSDevSlnSys2 : arrayList) {
            PSDevSlnSys pSDevSlnSys3 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys3.setPSDevSlnSysId(pSDevSlnSys2.getPSDevSlnSysId());
            pSDevSlnSys3.setPPSDevSlnSysId(null);
            this.update(pSDevSlnSys3);
        }
    }

    public void removeByPPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        final PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysServiceBase.this.internalRemoveByPPSDevSlnSys(pSDevSlnSys2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPPSDevSlnSys(pSDevSlnSys2);
            }
        });
    }

    protected void onBeforeRemoveByPPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void internalRemoveByPPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPPSDevSlnSys(pSDevSlnSys);
        this.onBeforeRemoveByPPSDevSlnSys(pSDevSlnSys, arrayList);
        for (PSDevSlnSys pSDevSlnSys2 : arrayList) {
            this.remove(pSDevSlnSys2);
        }
        this.onAfterRemoveByPPSDevSlnSys(pSDevSlnSys, arrayList);
    }

    protected void onAfterRemoveByPPSDevSlnSys(PSDevSlnSys pSDevSlnSys) throws Exception {
    }

    protected void onBeforeRemoveByPPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSDevSlnSys(PSDevSlnSys pSDevSlnSys, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    public void resetPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevSln(pSDevSln);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSDevSlnId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSDevSln(PSDevSln pSDevSln) throws Exception {
        final PSDevSln pSDevSln2 = pSDevSln;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSDevSln(pSDevSln2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSDevSln(pSDevSln2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSDevSln(pSDevSln2);
            }
        });
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void internalRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSDevSln(pSDevSln);
        this.onBeforeRemoveByPSDevSln(pSDevSln, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSDevSln(pSDevSln, arrayList);
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln) throws Exception {
    }

    protected void onBeforeRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDevSln(PSDevSln pSDevSln, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSPF(pSPF);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSPFId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSSF(pSSF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSSF_PSSFID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSSF), arrayList.get(0)));
        }
    }

    public void resetPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSSF(pSSF);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSSFId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSSF(PSSF pSSF) throws Exception {
        final PSSF pSSF2 = pSSF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSSF(pSSF2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSSF(pSSF2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSSF(pSSF2);
            }
        });
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void internalRemoveByPSSF(PSSF pSSF) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSSF(pSSF);
        this.onBeforeRemoveByPSSF(pSSF, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSSF(pSSF, arrayList);
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF) throws Exception {
    }

    protected void onBeforeRemoveByPSSF(PSSF pSSF, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSF(PSSF pSSF, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
    }

    public void resetPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSStudioTheme(pSStudioTheme);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSStudioThemeId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
        final PSStudioTheme pSStudioTheme2 = pSStudioTheme;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSStudioTheme(pSStudioTheme2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSStudioTheme(pSStudioTheme2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSStudioTheme(pSStudioTheme2);
            }
        });
    }

    protected void onBeforeRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
    }

    protected void internalRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSStudioTheme(pSStudioTheme);
        this.onBeforeRemoveByPSStudioTheme(pSStudioTheme, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSStudioTheme(pSStudioTheme, arrayList);
    }

    protected void onAfterRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme) throws Exception {
    }

    protected void onBeforeRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSStudioTheme(PSStudioTheme pSStudioTheme, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveBySFPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectBySFPSSubSys(pSSubSys, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSUBSYS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSubSys);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSSUBSYS_SFPSSUBSYSID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSSubSys), arrayList.get(0)));
        }
    }

    public void resetSFPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectBySFPSSubSys(pSSubSys);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setSFPSSubSysId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeBySFPSSubSys(PSSubSys pSSubSys) throws Exception {
        final PSSubSys pSSubSys2 = pSSubSys;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveBySFPSSubSys(pSSubSys2);
                PSDevSlnSysServiceBase.this.internalRemoveBySFPSSubSys(pSSubSys2);
                PSDevSlnSysServiceBase.this.onAfterRemoveBySFPSSubSys(pSSubSys2);
            }
        });
    }

    protected void onBeforeRemoveBySFPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void internalRemoveBySFPSSubSys(PSSubSys pSSubSys) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectBySFPSSubSys(pSSubSys);
        this.onBeforeRemoveBySFPSSubSys(pSSubSys, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveBySFPSSubSys(pSSubSys, arrayList);
    }

    protected void onAfterRemoveBySFPSSubSys(PSSubSys pSSubSys) throws Exception {
    }

    protected void onBeforeRemoveBySFPSSubSys(PSSubSys pSSubSys, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySFPSSubSys(PSSubSys pSSubSys, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSSysModelInst(pSSysModelInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMODELINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysModelInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSSYSMODELINST_PSSYSMODELINSTID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSSysModelInst), arrayList.get(0)));
        }
    }

    public void resetPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSSysModelInstId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        final PSSysModelInst pSSysModelInst2 = pSSysModelInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSSysModelInst(pSSysModelInst2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSSysModelInst(pSSysModelInst2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSSysModelInst(pSSysModelInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void internalRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSSysModelInst(pSSysModelInst);
        this.onBeforeRemoveByPSSysModelInst(pSSysModelInst, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSSysModelInst(pSSysModelInst, arrayList);
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst) throws Exception {
    }

    protected void onBeforeRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysModelInst(PSSysModelInst pSSysModelInst, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSSysPolicy(pSSysPolicy, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPOLICY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPolicy);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVSLNSYS_PSSYSPOLICY_PSSYSPOLICYID", "", iDataEntityModel.getName(), "PSDEVSLNSYS", iDataEntityModel.getDataInfo(pSSysPolicy), arrayList.get(0)));
        }
    }

    public void resetPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSSysPolicy(pSSysPolicy);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSSysPolicyId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
        final PSSysPolicy pSSysPolicy2 = pSSysPolicy;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSSysPolicy(pSSysPolicy2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSSysPolicy(pSSysPolicy2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSSysPolicy(pSSysPolicy2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
    }

    protected void internalRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSSysPolicy(pSSysPolicy);
        this.onBeforeRemoveByPSSysPolicy(pSSysPolicy, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSSysPolicy(pSSysPolicy, arrayList);
    }

    protected void onAfterRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPolicy(PSSysPolicy pSSysPolicy, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    public void testRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    public void resetPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSTaskServer(pSTaskServer);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            PSDevSlnSys pSDevSlnSys2 = (PSDevSlnSys)this.getDEModel().createEntity();
            pSDevSlnSys2.setPSDevSlnSysId(pSDevSlnSys.getPSDevSlnSysId());
            pSDevSlnSys2.setPSTaskServerId(null);
            this.update(pSDevSlnSys2);
        }
    }

    public void removeByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        final PSTaskServer pSTaskServer2 = pSTaskServer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDevSlnSysServiceBase.this.onBeforeRemoveByPSTaskServer(pSTaskServer2);
                PSDevSlnSysServiceBase.this.internalRemoveByPSTaskServer(pSTaskServer2);
                PSDevSlnSysServiceBase.this.onAfterRemoveByPSTaskServer(pSTaskServer2);
            }
        });
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void internalRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
        ArrayList<PSDevSlnSys> arrayList = this.selectByPSTaskServer(pSTaskServer);
        this.onBeforeRemoveByPSTaskServer(pSTaskServer, arrayList);
        for (PSDevSlnSys pSDevSlnSys : arrayList) {
            this.remove(pSDevSlnSys);
        }
        this.onAfterRemoveByPSTaskServer(pSTaskServer, arrayList);
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer) throws Exception {
    }

    protected void onBeforeRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSTaskServer(PSTaskServer pSTaskServer, ArrayList<PSDevSlnSys> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDevSlnSys pSDevSlnSys) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDCRegistryItemService)ServiceGlobal.getService(PSDCRegistryItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCRegistryItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDCRegistryItemServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDCSyncDataService)ServiceGlobal.getService(PSDCSyncDataService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCSyncDataServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDCTaskLogService)ServiceGlobal.getService(PSDCTaskLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCTaskLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
        ((PSDCWorkspaceServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDepSysVerService)ServiceGlobal.getService(PSDepSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDepSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevPrdSysService)ServiceGlobal.getService(PSDevPrdSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevPrdSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnCanvasService)ServiceGlobal.getService(PSDevSlnCanvasService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnCanvasServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSlnCanvasServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnLinkService)ServiceGlobal.getService(PSDevSlnLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnMSDepAPIService)ServiceGlobal.getService(PSDevSlnMSDepAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnMSDepAppService)ServiceGlobal.getService(PSDevSlnMSDepAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnMSDepFuncService)ServiceGlobal.getService(PSDevSlnMSDepFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnMSDepResService)ServiceGlobal.getService(PSDevSlnMSDepResService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnMSDepResServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnPipelineStepService)ServiceGlobal.getService(PSDevSlnPipelineStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineStepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnPipelineService)ServiceGlobal.getService(PSDevSlnPipelineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnPipelineServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSlnPipelineServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysAPIServiceBase)pSCoreSysServiceBase).testRemoveByClient2PSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysAPIServiceBase)pSCoreSysServiceBase).testRemoveByClientPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysAPIService)ServiceGlobal.getService(PSDevSlnSysAPIService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysAPIServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysAppService)ServiceGlobal.getService(PSDevSlnSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysBakLinkService)ServiceGlobal.getService(PSDevSlnSysBakLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysBakLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysBakService)ServiceGlobal.getService(PSDevSlnSysBakService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysBakServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSlnSysBakServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDepInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysDynaInstServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysGDService)ServiceGlobal.getService(PSDevSlnSysGDService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysGDServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysKeyService)ServiceGlobal.getService(PSDevSlnSysKeyService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysKeyServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysLockLogService)ServiceGlobal.getService(PSDevSlnSysLockLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysLockLogServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSlnSysLockLogServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysModelService)ServiceGlobal.getService(PSDevSlnSysModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysModelServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSlnSysModelServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysRefLinkService)ServiceGlobal.getService(PSDevSlnSysRefLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysRefLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysRefServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSlnSysRefServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysRefService)ServiceGlobal.getService(PSDevSlnSysRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysRefServiceBase)pSCoreSysServiceBase).testRemoveByRefPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysSrcService)ServiceGlobal.getService(PSDevSlnSysSrcService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysSrcServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSlnSysSrcServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysSrcService)ServiceGlobal.getService(PSDevSlnSysSrcService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysSrcServiceBase)pSCoreSysServiceBase).testRemoveBySrcPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysSrvService)ServiceGlobal.getService(PSDevSlnSysSrvService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysSrvServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSlnSysVerServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysVerServiceBase)pSCoreSysServiceBase).testRemoveByVerPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysWSGitService)ServiceGlobal.getService(PSDevSlnSysWSGitService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysWSGitServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSlnSysWSGitServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByMainPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnSysServiceBase)pSCoreSysServiceBase).testRemoveByPPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnTemplServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnUserCSService)ServiceGlobal.getService(PSDevSlnUserCSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnUserCSServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSlnUserService)ServiceGlobal.getService(PSDevSlnUserService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSlnUserServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSysDiffRepService)ServiceGlobal.getService(PSDevSysDiffRepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSysDiffRepServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSDevSysDiffRepService)ServiceGlobal.getService(PSDevSysDiffRepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDevSysDiffRepServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSDevSysDiffRepServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSSaaSSysVerServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSSaaSSysService)ServiceGlobal.getService(PSSaaSSysService.class, (SessionFactory)this.getSessionFactory());
        ((PSSaaSSysServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysRefServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        pSCoreSysServiceBase = (PSTSCmdService)ServiceGlobal.getService(PSTSCmdService.class, (SessionFactory)this.getSessionFactory());
        ((PSTSCmdServiceBase)pSCoreSysServiceBase).testRemoveByPSDevSlnSys(pSDevSlnSys);
        ((PSTSCmdServiceBase)pSCoreSysServiceBase).removeByPSDevSlnSys(pSDevSlnSys);
        super.onBeforeRemove(pSDevSlnSys);
    }

    protected void replaceParentInfo(PSDevSlnSys pSDevSlnSys, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDevSlnSys, cloneSession);
        if (pSDevSlnSys.getJITPSDBDevInstId() != null && (iEntity = cloneSession.getEntity("PSDBDEVINST", (Object)pSDevSlnSys.getJITPSDBDevInstId())) != null) {
            this.onFillParentInfo_JitPSDBDevInst(pSDevSlnSys, (PSDBDevInst)iEntity);
        }
        if (pSDevSlnSys.getHBasePSDCBDInstId() != null && (iEntity = cloneSession.getEntity("PSDCBDINST", (Object)pSDevSlnSys.getHBasePSDCBDInstId())) != null) {
            this.onFillParentInfo_HBasePSDCDBInst(pSDevSlnSys, (PSDCBDInst)iEntity);
        }
        if (pSDevSlnSys.getPSDCDeployCenterId() != null && (iEntity = cloneSession.getEntity("PSDCDEPLOYCENTER", (Object)pSDevSlnSys.getPSDCDeployCenterId())) != null) {
            this.onFillParentInfo_PSDCDeployCenter(pSDevSlnSys, (PSDCDeployCenter)iEntity);
        }
        if (pSDevSlnSys.getPSDCModelTemplId() != null && (iEntity = cloneSession.getEntity("PSDCMODELTEMPL", (Object)pSDevSlnSys.getPSDCModelTemplId())) != null) {
            this.onFillParentInfo_PSDCModelTempl(pSDevSlnSys, (PSDCModelTempl)iEntity);
        }
        if (pSDevSlnSys.getPSDCRobotId() != null && (iEntity = cloneSession.getEntity("PSDCROBOT", (Object)pSDevSlnSys.getPSDCRobotId())) != null) {
            this.onFillParentInfo_PSDCRobot(pSDevSlnSys, (PSDCRobot)iEntity);
        }
        if (pSDevSlnSys.getPSDCSysLicId() != null && (iEntity = cloneSession.getEntity("PSDCSYSLIC", (Object)pSDevSlnSys.getPSDCSysLicId())) != null) {
            this.onFillParentInfo_PSDCSysLic(pSDevSlnSys, (PSDCSysLic)iEntity);
        }
        if (pSDevSlnSys.getPSDevCenterASId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSDevSlnSys.getPSDevCenterASId())) != null) {
            this.onFillParentInfo_PSDevCenterAS(pSDevSlnSys, (PSDevCenterAS)iEntity);
        }
        if (pSDevSlnSys.getPSDevCenterASId2() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSDevSlnSys.getPSDevCenterASId2())) != null) {
            this.onFillParentInfo_PSDevCenterAS2(pSDevSlnSys, (PSDevCenterAS)iEntity);
        }
        if (pSDevSlnSys.getPSDevCenterAS3Id() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSDevSlnSys.getPSDevCenterAS3Id())) != null) {
            this.onFillParentInfo_PSDevCenterAS3(pSDevSlnSys, (PSDevCenterAS)iEntity);
        }
        if (pSDevSlnSys.getPSDevCenterAS4Id() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERAS", (Object)pSDevSlnSys.getPSDevCenterAS4Id())) != null) {
            this.onFillParentInfo_PSDevCenterAS4(pSDevSlnSys, (PSDevCenterAS)iEntity);
        }
        if (pSDevSlnSys.getDB2PSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSys.getDB2PSDCDBInstId())) != null) {
            this.onFillParentInfo_DB2PSDCDBInst(pSDevSlnSys, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSys.getMSSQLPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSys.getMSSQLPSDCDBInstId())) != null) {
            this.onFillParentInfo_MSSQLPSDCDBInst(pSDevSlnSys, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSys.getMySQLPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSys.getMySQLPSDCDBInstId())) != null) {
            this.onFillParentInfo_MySQLPSDCDBInst(pSDevSlnSys, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSys.getOraPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSys.getOraPSDCDBInstId())) != null) {
            this.onFillParentInfo_OraPSDCDBInst(pSDevSlnSys, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSys.getPGSQLPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSys.getPGSQLPSDCDBInstId())) != null) {
            this.onFillParentInfo_PGSQLPSDCDBInst(pSDevSlnSys, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSys.getPPASPSDCDBInstId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERDBINST", (Object)pSDevSlnSys.getPPASPSDCDBInstId())) != null) {
            this.onFillParentInfo_PPASPSDCDBInst(pSDevSlnSys, (PSDevCenterDBInst)iEntity);
        }
        if (pSDevSlnSys.getDocPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSys.getDocPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_DocPSDevCenterSVN(pSDevSlnSys, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSys.getModelPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSys.getModelPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_ModelPSDevCenterSVN(pSDevSlnSys, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSys.getPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSys.getPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_PSDevCenterSVN(pSDevSlnSys, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSys.getROPSDevCenterSvnId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSys.getROPSDevCenterSvnId())) != null) {
            this.onFillParentInfo_ROPSDevCenterSvn(pSDevSlnSys, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSys.getRTModelPSDevCenterSVNId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERSVN", (Object)pSDevSlnSys.getRTModelPSDevCenterSVNId())) != null) {
            this.onFillParentInfo_RTModelPSDevCenterSVN(pSDevSlnSys, (PSDevCenterSVN)iEntity);
        }
        if (pSDevSlnSys.getJITPSDevCenterTSId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERTS", (Object)pSDevSlnSys.getJITPSDevCenterTSId())) != null) {
            this.onFillParentInfo_JITPSDevCenterTS(pSDevSlnSys, (PSDevCenterTS)iEntity);
        }
        if (pSDevSlnSys.getPSDevCenterTSId() != null && (iEntity = cloneSession.getEntity("PSDEVCENTERTS", (Object)pSDevSlnSys.getPSDevCenterTSId())) != null) {
            this.onFillParentInfo_PSDevCenterTS(pSDevSlnSys, (PSDevCenterTS)iEntity);
        }
        if (pSDevSlnSys.getPSDevSlnSysResId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYSRES", (Object)pSDevSlnSys.getPSDevSlnSysResId())) != null) {
            this.onFillParentInfo_PSDevSlnSysRes(pSDevSlnSys, (PSDevSlnSysRes)iEntity);
        }
        if (pSDevSlnSys.getMainPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSys.getMainPSDevSlnSysId())) != null) {
            this.onFillParentInfo_MainPSDevSlnSys(pSDevSlnSys, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSys.getPPSDevSlnSysId() != null && (iEntity = cloneSession.getEntity("PSDEVSLNSYS", (Object)pSDevSlnSys.getPPSDevSlnSysId())) != null) {
            this.onFillParentInfo_PPSDevSlnSys(pSDevSlnSys, (PSDevSlnSys)iEntity);
        }
        if (pSDevSlnSys.getPSDevSlnId() != null && (iEntity = cloneSession.getEntity("PSDEVSLN", (Object)pSDevSlnSys.getPSDevSlnId())) != null) {
            this.onFillParentInfo_PSDevSln(pSDevSlnSys, (PSDevSln)iEntity);
        }
        if (pSDevSlnSys.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSDevSlnSys.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSDevSlnSys, (PSPF)iEntity);
        }
        if (pSDevSlnSys.getPSSFId() != null && (iEntity = cloneSession.getEntity("PSSF", (Object)pSDevSlnSys.getPSSFId())) != null) {
            this.onFillParentInfo_PSSF(pSDevSlnSys, (PSSF)iEntity);
        }
        if (pSDevSlnSys.getPSStudioThemeId() != null && (iEntity = cloneSession.getEntity("PSSTUDIOTHEME", (Object)pSDevSlnSys.getPSStudioThemeId())) != null) {
            this.onFillParentInfo_PSStudioTheme(pSDevSlnSys, (PSStudioTheme)iEntity);
        }
        if (pSDevSlnSys.getSFPSSubSysId() != null && (iEntity = cloneSession.getEntity("PSSUBSYS", (Object)pSDevSlnSys.getSFPSSubSysId())) != null) {
            this.onFillParentInfo_SFPSSubSys(pSDevSlnSys, (PSSubSys)iEntity);
        }
        if (pSDevSlnSys.getPSSysModelInstId() != null && (iEntity = cloneSession.getEntity("PSSYSMODELINST", (Object)pSDevSlnSys.getPSSysModelInstId())) != null) {
            this.onFillParentInfo_PSSysModelInst(pSDevSlnSys, (PSSysModelInst)iEntity);
        }
        if (pSDevSlnSys.getPSSysPolicyId() != null && (iEntity = cloneSession.getEntity("PSSYSPOLICY", (Object)pSDevSlnSys.getPSSysPolicyId())) != null) {
            this.onFillParentInfo_PSSysPolicy(pSDevSlnSys, (PSSysPolicy)iEntity);
        }
        if (pSDevSlnSys.getPSTaskServerId() != null && (iEntity = cloneSession.getEntity("PSTASKSERVER", (Object)pSDevSlnSys.getPSTaskServerId())) != null) {
            this.onFillParentInfo_PSTaskServer(pSDevSlnSys, (PSTaskServer)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDevSlnSys, bl);
        pSDevSlnSys.resetDevResState();
        pSDevSlnSys.resetDevSysState();
        pSDevSlnSys.resetStudioTag();
        pSDevSlnSys.resetStudioTag2();
    }

    protected void onCheckEntity(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionOwner(bl, pSDevSlnSys, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_APIFlag(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CallbackTag(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CallbackUrl(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CurAction(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DB2PSDCDBInstId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DB2PSDCDBInstName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBTypes(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DBVersion(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeploySysId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeploySysOrgId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeploySysOrgSectorId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeploySysTag(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeploySysTag2(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DeploySysType(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DevResInfo(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DevResState(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DevSysState(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DocPSDevCenterSVNId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCallback(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDB2(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDeployCenter(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDM(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaSys(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableFolderKey(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableHANA(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableHBase(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableMySQL5(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableOracle(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePGSQL(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePPAS(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSQLite(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSqlServer(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableWSServer(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EntityCnt(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExpriedTime(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HBasePSDCBDInstId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InitParams(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JITPSDBDevInstId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_JITPSDevCenterTSId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastActiveTime(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LoadTime(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LowCodeMode(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainPSDevSlnSysId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MainPSDevSlnSysName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MaxEntityCnt(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelPrefix(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ModelPSDevCenterSVNId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSSQLPSDCDBInstId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MSSQLPSDCDBInstName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MySQLPSDCDBInstId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MySQLPSDCDBInstName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OfflineTime(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OraPSDCDBInstId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OraPSDCDBInstName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PGSQLPSDCDBInstId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PGSQLPSDCDBInstName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPASPSDCDBInstId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPASPSDCDBInstName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSlnSysId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSDevSlnSysName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCDeployCenterId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCModelTemplId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCRobotName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCSysLicId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDCWorkspaceId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterASId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterASId2(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterAS3Id(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterAS4Id(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterSVNId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterTSId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevCenterTSName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDevSlnSysResId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSFName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSStudioThemeId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysModelInstName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPolicyId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSTaskServerName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubCode(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResReadyTime(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ROPSDevCenterSvnId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RTModelPSDevCenterSVNId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SaaSMode(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SFPSSubSysId(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SFPSSubSysName(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShareFlag(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioTag(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioTag2(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_StudioVer(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysFolder(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysMDUrl(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTag(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTag2(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTag3(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysTag4(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysType(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysVer(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplEngine(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UnloadTime(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VCType(bl, pSDevSlnSys, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDevSlnSys, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionOwner(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isActionOwnerDirty() : !pSDevSlnSys.isActionOwnerDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getActionOwner();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionOwner_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONOWNER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_APIFlag(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isAPIFlagDirty() : !pSDevSlnSys.isAPIFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getAPIFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_APIFlag_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APIFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CallbackTag(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isCallbackTagDirty() : !pSDevSlnSys.isCallbackTagDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getCallbackTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CallbackTag_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALLBACKTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CallbackUrl(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isCallbackUrlDirty() : !pSDevSlnSys.isCallbackUrlDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getCallbackUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CallbackUrl_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CALLBACKURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isCodeNameDirty() && !bl2 : !pSDevSlnSys.isCodeNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CurAction(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isCurActionDirty() : !pSDevSlnSys.isCurActionDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getCurAction();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CurAction_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CURACTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DB2PSDCDBInstId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDB2PSDCDBInstIdDirty() : !pSDevSlnSys.isDB2PSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDB2PSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DB2PSDCDBInstId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DB2PSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DB2PSDCDBInstName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDB2PSDCDBInstNameDirty() : !pSDevSlnSys.isDB2PSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDB2PSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DB2PSDCDBInstName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DB2PSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBTypes(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDBTypesDirty() : !pSDevSlnSys.isDBTypesDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDBTypes();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DBTypes_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBTYPES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DBVersion(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDBVersionDirty() : !pSDevSlnSys.isDBVersionDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getDBVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DBVersion_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DBVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeploySysId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDeploySysIdDirty() : !pSDevSlnSys.isDeploySysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDeploySysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeploySysId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeploySysOrgId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDeploySysOrgIdDirty() : !pSDevSlnSys.isDeploySysOrgIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDeploySysOrgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeploySysOrgId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSYSORGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeploySysOrgSectorId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDeploySysOrgSectorIdDirty() : !pSDevSlnSys.isDeploySysOrgSectorIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDeploySysOrgSectorId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeploySysOrgSectorId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSYSORGSECTORID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeploySysTag(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDeploySysTagDirty() : !pSDevSlnSys.isDeploySysTagDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDeploySysTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeploySysTag_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSYSTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeploySysTag2(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDeploySysTag2Dirty() : !pSDevSlnSys.isDeploySysTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDeploySysTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeploySysTag2_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSYSTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DeploySysType(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDeploySysTypeDirty() : !pSDevSlnSys.isDeploySysTypeDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDeploySysType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DeploySysType_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEPLOYSYSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DevResInfo(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDevResInfoDirty() : !pSDevSlnSys.isDevResInfoDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDevResInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DevResInfo_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVRESINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DevResState(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDevResStateDirty() : !pSDevSlnSys.isDevResStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getDevResState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DevResState_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVRESSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DevSysState(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDevSysStateDirty() : !pSDevSlnSys.isDevSysStateDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getDevSysState();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DevSysState_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEVSYSSTATE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DocPSDevCenterSVNId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isDocPSDevCenterSVNIdDirty() : !pSDevSlnSys.isDocPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getDocPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DocPSDevCenterSVNId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DOCPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCallback(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableCallbackDirty() : !pSDevSlnSys.isEnableCallbackDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableCallback();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCallback_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECALLBACK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDB2(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableDB2Dirty() : !pSDevSlnSys.isEnableDB2Dirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableDB2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDB2_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDB2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDeployCenter(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableDeployCenterDirty() : !pSDevSlnSys.isEnableDeployCenterDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableDeployCenter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDeployCenter_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDEPLOYCENTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDM(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableDMDirty() : !pSDevSlnSys.isEnableDMDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableDM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDM_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaSys(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableDynaSysDirty() : !pSDevSlnSys.isEnableDynaSysDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableDynaSys();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaSys_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNASYS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableFolderKey(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableFolderKeyDirty() : !pSDevSlnSys.isEnableFolderKeyDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableFolderKey();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableFolderKey_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEFOLDERKEY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableHANA(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableHANADirty() : !pSDevSlnSys.isEnableHANADirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableHANA();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableHANA_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEHANA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableHBase(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableHBaseDirty() : !pSDevSlnSys.isEnableHBaseDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableHBase();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableHBase_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEHBASE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableMySQL5(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableMySQL5Dirty() : !pSDevSlnSys.isEnableMySQL5Dirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableMySQL5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableMySQL5_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEMYSQL5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableOracle(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableOracleDirty() : !pSDevSlnSys.isEnableOracleDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableOracle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableOracle_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEORACLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnablePGSQL(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnablePGSQLDirty() : !pSDevSlnSys.isEnablePGSQLDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnablePGSQL();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePGSQL_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPGSQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnablePPAS(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnablePPASDirty() : !pSDevSlnSys.isEnablePPASDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnablePPAS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePPAS_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPPAS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSQLite(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableSQLiteDirty() : !pSDevSlnSys.isEnableSQLiteDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableSQLite();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSQLite_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESQLITE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableSqlServer(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableSqlServerDirty() : !pSDevSlnSys.isEnableSqlServerDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableSqlServer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSqlServer_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESQLSERVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableWSServer(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEnableWSServerDirty() : !pSDevSlnSys.isEnableWSServerDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEnableWSServer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableWSServer_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEWSSERVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EntityCnt(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isEntityCntDirty() : !pSDevSlnSys.isEntityCntDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getEntityCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EntityCnt_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENTITYCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExpriedTime(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isExpriedTimeDirty() : !pSDevSlnSys.isExpriedTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSys.getExpriedTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExpriedTime_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXPRIEDTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HBasePSDCBDInstId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isHBasePSDCBDInstIdDirty() : !pSDevSlnSys.isHBasePSDCBDInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getHBasePSDCBDInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HBasePSDCBDInstId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HBASEPSDCBDINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_InitParams(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isInitParamsDirty() : !pSDevSlnSys.isInitParamsDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getInitParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_InitParams_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INITPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JITPSDBDevInstId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isJITPSDBDevInstIdDirty() : !pSDevSlnSys.isJITPSDBDevInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getJITPSDBDevInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JITPSDBDevInstId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JITPSDBDEVINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_JITPSDevCenterTSId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isJITPSDevCenterTSIdDirty() : !pSDevSlnSys.isJITPSDevCenterTSIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getJITPSDevCenterTSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_JITPSDevCenterTSId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("JITPSDEVCENTERTSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastActiveTime(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isLastActiveTimeDirty() : !pSDevSlnSys.isLastActiveTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSys.getLastActiveTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LastActiveTime_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTACTIVETIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LoadTime(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isLoadTimeDirty() : !pSDevSlnSys.isLoadTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSys.getLoadTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LoadTime_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOADTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isLogicNameDirty() : !pSDevSlnSys.isLogicNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LowCodeMode(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isLowCodeModeDirty() : !pSDevSlnSys.isLowCodeModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getLowCodeMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LowCodeMode_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOWCODEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MainPSDevSlnSysId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isMainPSDevSlnSysIdDirty() : !pSDevSlnSys.isMainPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getMainPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MainPSDevSlnSysId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINPSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MainPSDevSlnSysName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isMainPSDevSlnSysNameDirty() : !pSDevSlnSys.isMainPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getMainPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MainPSDevSlnSysName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAINPSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MaxEntityCnt(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isMaxEntityCntDirty() : !pSDevSlnSys.isMaxEntityCntDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getMaxEntityCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MaxEntityCnt_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MAXENTITYCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isMemoDirty() : !pSDevSlnSys.isMemoDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MEMO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelPrefix(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isModelPrefixDirty() : !pSDevSlnSys.isModelPrefixDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getModelPrefix();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelPrefix_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELPREFIX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ModelPSDevCenterSVNId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isModelPSDevCenterSVNIdDirty() : !pSDevSlnSys.isModelPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getModelPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ModelPSDevCenterSVNId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MODELPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSSQLPSDCDBInstId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isMSSQLPSDCDBInstIdDirty() : !pSDevSlnSys.isMSSQLPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getMSSQLPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSSQLPSDCDBInstId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSSQLPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MSSQLPSDCDBInstName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isMSSQLPSDCDBInstNameDirty() : !pSDevSlnSys.isMSSQLPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getMSSQLPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MSSQLPSDCDBInstName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MSSQLPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MySQLPSDCDBInstId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isMySQLPSDCDBInstIdDirty() : !pSDevSlnSys.isMySQLPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getMySQLPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MySQLPSDCDBInstId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYSQLPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MySQLPSDCDBInstName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isMySQLPSDCDBInstNameDirty() : !pSDevSlnSys.isMySQLPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getMySQLPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MySQLPSDCDBInstName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MYSQLPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OfflineTime(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isOfflineTimeDirty() : !pSDevSlnSys.isOfflineTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSys.getOfflineTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OfflineTime_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OFFLINETIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OraPSDCDBInstId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isOraPSDCDBInstIdDirty() : !pSDevSlnSys.isOraPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getOraPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OraPSDCDBInstId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORAPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OraPSDCDBInstName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isOraPSDCDBInstNameDirty() : !pSDevSlnSys.isOraPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getOraPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OraPSDCDBInstName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORAPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PGSQLPSDCDBInstId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPGSQLPSDCDBInstIdDirty() : !pSDevSlnSys.isPGSQLPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPGSQLPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PGSQLPSDCDBInstId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PGSQLPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PGSQLPSDCDBInstName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPGSQLPSDCDBInstNameDirty() : !pSDevSlnSys.isPGSQLPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPGSQLPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PGSQLPSDCDBInstName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PGSQLPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPASPSDCDBInstId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPPASPSDCDBInstIdDirty() : !pSDevSlnSys.isPPASPSDCDBInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPPASPSDCDBInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPASPSDCDBInstId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPASPSDCDBINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPASPSDCDBInstName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPPASPSDCDBInstNameDirty() : !pSDevSlnSys.isPPASPSDCDBInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPPASPSDCDBInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPASPSDCDBInstName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPASPSDCDBINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSlnSysId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPPSDevSlnSysIdDirty() : !pSDevSlnSys.isPPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPPSDevSlnSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSlnSysId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSDevSlnSysName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPPSDevSlnSysNameDirty() : !pSDevSlnSys.isPPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPPSDevSlnSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSDevSlnSysName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCDeployCenterId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDCDeployCenterIdDirty() : !pSDevSlnSys.isPSDCDeployCenterIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDCDeployCenterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCDeployCenterId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCDEPLOYCENTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCModelTemplId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDCModelTemplIdDirty() : !pSDevSlnSys.isPSDCModelTemplIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDCModelTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCModelTemplId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCMODELTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDCRobotIdDirty() : !pSDevSlnSys.isPSDCRobotIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDCRobotId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCRobotName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDCRobotNameDirty() : !pSDevSlnSys.isPSDCRobotNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDCRobotName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCRobotName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCROBOTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCSysLicId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDCSysLicIdDirty() : !pSDevSlnSys.isPSDCSysLicIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDCSysLicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCSysLicId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCSYSLICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDCWorkspaceId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDCWorkspaceIdDirty() : !pSDevSlnSys.isPSDCWorkspaceIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDCWorkspaceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDCWorkspaceId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDCWORKSPACEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterASId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevCenterASIdDirty() : !pSDevSlnSys.isPSDevCenterASIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevCenterASId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterASId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERASID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterASId2(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevCenterASId2Dirty() : !pSDevSlnSys.isPSDevCenterASId2Dirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevCenterASId2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterASId2_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERASID2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterAS3Id(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevCenterAS3IdDirty() : !pSDevSlnSys.isPSDevCenterAS3IdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevCenterAS3Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterAS3Id_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERASID3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterAS4Id(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevCenterAS4IdDirty() : !pSDevSlnSys.isPSDevCenterAS4IdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevCenterAS4Id();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterAS4Id_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERASID4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterSVNId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevCenterSVNIdDirty() : !pSDevSlnSys.isPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterSVNId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterTSId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevCenterTSIdDirty() : !pSDevSlnSys.isPSDevCenterTSIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevCenterTSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterTSId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERTSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevCenterTSName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevCenterTSNameDirty() : !pSDevSlnSys.isPSDevCenterTSNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevCenterTSName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevCenterTSName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVCENTERTSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevSlnIdDirty() && !bl2 : !pSDevSlnSys.isPSDevSlnIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevSlnId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevSlnNameDirty() && !bl2 : !pSDevSlnSys.isPSDevSlnNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevSlnName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevSlnSysIdDirty() && !bl2 : !pSDevSlnSys.isPSDevSlnSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevSlnSysId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevSlnSysNameDirty() && !bl2 : !pSDevSlnSys.isPSDevSlnSysNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevSlnSysName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEVSLNID";
                String string4 = this.checkFieldDupRule(this.getPSDevSlnSysDEModel(), "PSDEVSLNSYSNAME", string3, pSDevSlnSys, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVSLNSYSNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDevSlnSysResId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSDevSlnSysResIdDirty() : !pSDevSlnSys.isPSDevSlnSysResIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSDevSlnSysResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDevSlnSysResId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVSLNSYSRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSPFIdDirty() : !pSDevSlnSys.isPSPFIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSSFIdDirty() : !pSDevSlnSys.isPSSFIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSSFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSFName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSSFNameDirty() : !pSDevSlnSys.isPSSFNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSSFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSFName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSStudioThemeId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSStudioThemeIdDirty() : !pSDevSlnSys.isPSStudioThemeIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSStudioThemeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSStudioThemeId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSTUDIOTHEMEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSSysModelInstIdDirty() : !pSDevSlnSys.isPSSysModelInstIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSSysModelInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysModelInstName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSSysModelInstNameDirty() : !pSDevSlnSys.isPSSysModelInstNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSSysModelInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysModelInstName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMODELINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPolicyId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSSysPolicyIdDirty() : !pSDevSlnSys.isPSSysPolicyIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSSysPolicyId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPolicyId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPOLICYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSSystemIdDirty() : !pSDevSlnSys.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSSystemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSTaskServerIdDirty() : !pSDevSlnSys.isPSTaskServerIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSTaskServerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSTaskServerName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPSTaskServerNameDirty() : !pSDevSlnSys.isPSTaskServerNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getPSTaskServerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSTaskServerName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSTASKSERVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PubCode(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isPubCodeDirty() : !pSDevSlnSys.isPubCodeDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getPubCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubCode_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResReadyTime(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isResReadyTimeDirty() : !pSDevSlnSys.isResReadyTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSys.getResReadyTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ResReadyTime_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESREADYTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ROPSDevCenterSvnId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isROPSDevCenterSvnIdDirty() : !pSDevSlnSys.isROPSDevCenterSvnIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getROPSDevCenterSvnId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ROPSDevCenterSvnId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RTModelPSDevCenterSVNId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isRTModelPSDevCenterSVNIdDirty() : !pSDevSlnSys.isRTModelPSDevCenterSVNIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getRTModelPSDevCenterSVNId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RTModelPSDevCenterSVNId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RTMODELPSDEVCENTERSVNID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SaaSMode(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSaaSModeDirty() : !pSDevSlnSys.isSaaSModeDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getSaaSMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SaaSMode_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SAASMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SFPSSubSysId(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSFPSSubSysIdDirty() : !pSDevSlnSys.isSFPSSubSysIdDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSFPSSubSysId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SFPSSubSysId_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SFPSSUBSYSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SFPSSubSysName(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSFPSSubSysNameDirty() : !pSDevSlnSys.isSFPSSubSysNameDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSFPSSubSysName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SFPSSubSysName_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SFPSSUBSYSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShareFlag(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isShareFlagDirty() : !pSDevSlnSys.isShareFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getShareFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShareFlag_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHAREFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioTag(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isStudioTagDirty() : !pSDevSlnSys.isStudioTagDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getStudioTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioTag_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioTag2(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isStudioTag2Dirty() : !pSDevSlnSys.isStudioTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSys.getStudioTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioTag2_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_StudioVer(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isStudioVerDirty() : !pSDevSlnSys.isStudioVerDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getStudioVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_StudioVer_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("STUDIOVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysFolder(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSysFolderDirty() : !pSDevSlnSys.isSysFolderDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSysFolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysFolder_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSFOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysMDUrl(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSysMDUrlDirty() : !pSDevSlnSys.isSysMDUrlDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSysMDUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysMDUrl_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSMDURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTag(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSysTagDirty() : !pSDevSlnSys.isSysTagDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSysTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysTag_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTag2(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSysTag2Dirty() : !pSDevSlnSys.isSysTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSysTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysTag2_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTag3(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSysTag3Dirty() : !pSDevSlnSys.isSysTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSysTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysTag3_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysTag4(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSysTag4Dirty() : !pSDevSlnSys.isSysTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSysTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysTag4_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysType(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSysTypeDirty() : !pSDevSlnSys.isSysTypeDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSysType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysType_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysVer(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isSysVerDirty() && !bl2 : !pSDevSlnSys.isSysVerDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getSysVer();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSVER");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_SysVer_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplEngine(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isTemplEngineDirty() : !pSDevSlnSys.isTemplEngineDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getTemplEngine();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TemplEngine_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLENGINE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UnloadTime(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isUnloadTimeDirty() : !pSDevSlnSys.isUnloadTimeDirty()) {
            return null;
        }
        Timestamp timestamp = pSDevSlnSys.getUnloadTime();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UnloadTime_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UNLOADTIME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isUserCatDirty() : !pSDevSlnSys.isUserCatDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isUserTagDirty() : !pSDevSlnSys.isUserTagDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isUserTag2Dirty() : !pSDevSlnSys.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDevSlnSys.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isUserTag3Dirty() : !pSDevSlnSys.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDevSlnSys.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isUserTag4Dirty() : !pSDevSlnSys.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDevSlnSys.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isValidFlagDirty() : !pSDevSlnSys.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDevSlnSys.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VCType(boolean bl, PSDevSlnSys pSDevSlnSys, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDevSlnSys.isVCTypeDirty() && !bl2 : !pSDevSlnSys.isVCTypeDirty()) {
            return null;
        }
        String string = pSDevSlnSys.getVCType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VCTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_VCType_Default(pSDevSlnSys, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VCTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        super.onSyncEntity(pSDevSlnSys, bl);
    }

    protected void onSyncIndexEntities(PSDevSlnSys pSDevSlnSys, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDevSlnSys, bl);
    }

    public Object getDataContextValue(PSDevSlnSys pSDevSlnSys, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDevSlnSys, string, iDataContextParam)) != null) {
            return object;
        }
        PSDevSlnSys pSDevSlnSys2 = pSDevSlnSys.getMainPSDevSlnSys();
        if (pSDevSlnSys2 != null && pSDevSlnSys2.contains(string)) {
            return pSDevSlnSys2.get(string);
        }
        PSDevSlnSys pSDevSlnSys3 = pSDevSlnSys.getPPSDevSlnSys();
        if (pSDevSlnSys3 != null && pSDevSlnSys3.contains(string)) {
            return pSDevSlnSys3.get(string);
        }
        PSDevSln pSDevSln = pSDevSlnSys.getPSDevSln();
        if (pSDevSln != null && pSDevSln.contains(string)) {
            return pSDevSln.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDevSlnSys pSDevSlnSys, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDevSlnSys, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONOWNER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionOwner_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"APIFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_APIFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CALLBACKTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CallbackTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CALLBACKURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CallbackUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CURACTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CurAction_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DB2PSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DB2PSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DB2PSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DB2PSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBTYPES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBTypes_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DBVERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DBVersion_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeploySysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYSYSORGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeploySysOrgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYSYSORGSECTORID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeploySysOrgSectorId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYSYSTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeploySysTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYSYSTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeploySysTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEPLOYSYSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DeploySysType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVRESINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevResInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVRESSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevResState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEVSYSSTATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DevSysState_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCGITBRANCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocGitBranch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCGITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocGitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocPSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DOCPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DocPSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECALLBACK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCallback_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDB2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDB2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDEPLOYCENTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDeployCenter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNASYS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaSys_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEFOLDERKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableFolderKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEHANA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableHANA_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEHBASE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableHBase_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEMYSQL5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableMySQL5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEORACLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableOracle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPGSQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePGSQL_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPPAS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePPAS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESQLITE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSQLite_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESQLSERVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSqlServer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEWSSERVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableWSServer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENTITYCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EntityCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXPRIEDTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExpriedTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITBRANCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitBranch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HBASEPSDCBDINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HBasePSDCBDInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HBASEPSDCBDINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HBasePSDCBDInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INITPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InitParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JITPSDBDEVINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JITPSDBDevInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JITPSDBDEVINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JITPSDBDevInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JITPSDEVCENTERTSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JITPSDevCenterTSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"JITPSDEVCENTERTSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_JITPSDevCenterTSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTACTIVETIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastActiveTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOADTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LoadTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOWCODEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LowCodeMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINPSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainPSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAINPSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MainPSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MAXENTITYCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MaxEntityCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELGITBRANCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelGitBranch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELGITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelGitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELINSTVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelInstVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELPREFIX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelPrefix_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelPSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MODELPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ModelPSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSSQLPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSSQLPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MSSQLPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MSSQLPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYSQLPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MySQLPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MYSQLPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MySQLPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OFFLINETIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OfflineTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORAPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OraPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORAPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OraPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PGSQLPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PGSQLPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PGSQLPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PGSQLPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPASPSDCDBINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPASPSDCDBInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPASPSDCDBINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPASPSDCDBInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCDEPLOYCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCDeployCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMODELTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCModelTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCMODELTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCModelTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCROBOTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCRobotName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSLICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysLicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCSYSLICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCSysLicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDCWORKSPACEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDCWorkspaceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASID2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASId2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASID3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterAS3Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASID4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterAS4Id_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASNAME2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterASName2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASNAME3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterAS3Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERASNAME4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterAS4Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERTSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterTSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVCENTERTSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevCenterTSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVSLNSYSRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDevSlnSysResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOTHEMEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioThemeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSTUDIOTHEMENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSStudioThemeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMODELINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysModelInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPOLICYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPolicyId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPOLICYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPolicyName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSTASKSERVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSTaskServerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESREADYTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResReadyTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROGITBRANCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROGitBranch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROGITPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROGitPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSDevCenterSvnId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ROPSDevCenterSvnName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTMODELPSDEVCENTERSVNID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTModelPSDevCenterSVNId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RTMODELPSDEVCENTERSVNNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RTModelPSDevCenterSVNName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SAASMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SaaSMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SFPSSUBSYSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SFPSSubSysId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SFPSSUBSYSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SFPSSubSysName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHAREFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShareFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"STUDIOVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_StudioVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSFOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysFolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSMDURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysMDUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSROWKEY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysRowKey_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLENGINE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplEngine_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"THEMECSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ThemeCssStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UNLOADTIME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UnloadTime_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VCTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VCType_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionOwner_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONOWNER", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_APIFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CallbackTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALLBACKTAG", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CallbackUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CALLBACKURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CreateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CurAction_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CURACTION", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DB2PSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DB2PSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DB2PSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DB2PSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBTypes_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DBTYPES", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DBVersion_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DeploySysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYSYSID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeploySysOrgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYSYSORGID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeploySysOrgSectorId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYSYSORGSECTORID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeploySysTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYSYSTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeploySysTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYSYSTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DeploySysType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEPLOYSYSTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DevResInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DEVRESINFO", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DevResState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DevSysState_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DocGitBranch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCGITBRANCH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DocGitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCGITPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DocPSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DocPSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DOCPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableCallback_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDB2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDeployCenter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaSys_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableFolderKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableHANA_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableHBase_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableMySQL5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableOracle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnablePGSQL_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnablePPAS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSQLite_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSqlServer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableWSServer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EntityCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExpriedTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GitBranch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITBRANCH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GITPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HBasePSDCBDInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HBASEPSDCBDINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HBasePSDCBDInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HBASEPSDCBDINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InitParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("INITPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JITPSDBDevInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JITPSDBDEVINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JITPSDBDevInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JITPSDBDEVINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JITPSDevCenterTSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JITPSDEVCENTERTSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_JITPSDevCenterTSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("JITPSDEVCENTERTSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LastActiveTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LoadTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LowCodeMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_MainPSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINPSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MainPSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MAINPSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MaxEntityCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelGitBranch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELGITBRANCH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelGitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELGITPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelInstVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ModelPrefix_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELPREFIX", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelPSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ModelPSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MODELPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSSQLPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSSQLPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MSSQLPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MSSQLPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MySQLPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYSQLPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MySQLPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MYSQLPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OfflineTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OraPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORAPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OraPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORAPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PGSQLPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PGSQLPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PGSQLPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PGSQLPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPASPSDCDBInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPASPSDCDBINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPASPSDCDBInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPASPSDCDBINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false) && this.checkFieldRecursionRule("PPSDEVSLNSYSID", "PSDEVSLNSYS", iEntity, bl2, "")) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDeployCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCDeployCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCDEPLOYCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCModelTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMODELTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCModelTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCMODELTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCRobotName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCROBOTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysLicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSLICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCSysLicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCSYSLICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDCWorkspaceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDCWORKSPACEID", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASId2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASID2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterAS3Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASID3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterAS4Id_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASID4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterASName2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASNAME2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterAS3Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASNAME3", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterAS4Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERASNAME4", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterTSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERTSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevCenterTSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVCENTERTSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSDEVSLNSYSNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDevSlnSysResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVSLNSYSRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioThemeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOTHEMEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSStudioThemeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSTUDIOTHEMENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysModelInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMODELINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPolicyId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPOLICYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPolicyName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPOLICYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSystemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSTaskServerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSTASKSERVERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PubCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ResReadyTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ROGitBranch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROGITBRANCH", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROGitPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROGITPATH", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROPSDevCenterSvnId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ROPSDevCenterSvnName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ROPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RTModelPSDevCenterSVNId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RTMODELPSDEVCENTERSVNID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RTModelPSDevCenterSVNName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RTMODELPSDEVCENTERSVNNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SaaSMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SFPSSubSysId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SFPSSUBSYSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SFPSSubSysName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SFPSSUBSYSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShareFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_StudioTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOTAG", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StudioTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_StudioVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("STUDIOVER", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysFolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSFOLDER", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysMDUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSMDURL", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysRowKey_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSROWKEY", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSVER", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplEngine_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEMPLENGINE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ThemeCssStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("THEMECSSSTYLE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UnloadTime_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateDate_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UpdateMan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEMAN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERCAT", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG3", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG4", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_VCType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VCTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDevSlnSys pSDevSlnSys) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDevSlnSys)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDevSlnSys pSDevSlnSys) throws Exception {
        IService iService;
        Object object = pSDevSlnSys.get("PSDCSYSLICID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCSysLicService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEVSLNSYS_PSDCSYSLIC_PSDCSYSLICID", object);
        }
        if ((object = pSDevSlnSys.get("PSDEVSLNID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEVSLNSYS_PSDEVSLN_PSDEVSLNID", object);
        }
        super.onUpdateParent(pSDevSlnSys);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDevSlnSys pSDevSlnSys, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVSLNSYS");
        if (!bl) {
            pSDevSlnSys.setActionOwner(null);
            pSDevSlnSys.setCreateDate(null);
            pSDevSlnSys.setCreateMan(null);
            pSDevSlnSys.setCurAction(null);
            pSDevSlnSys.setDBVersion(null);
            pSDevSlnSys.setDevResInfo(null);
            pSDevSlnSys.setDevResState(null);
            pSDevSlnSys.setDevSysState(null);
            pSDevSlnSys.setJITPSDBDevInstId(null);
            pSDevSlnSys.setJITPSDBDevInstName(null);
            pSDevSlnSys.setModelPSDevCenterSVNName(null);
            pSDevSlnSys.setPSDCWorkspaceId(null);
            pSDevSlnSys.setPSDevCenterName(null);
            pSDevSlnSys.setPSDevSlnSysId(null);
            pSDevSlnSys.setPSDevSlnSysResId(null);
            pSDevSlnSys.setPSDevSlnSysResName(null);
            pSDevSlnSys.setPSStudioThemeName(null);
            pSDevSlnSys.setPSSysPolicyId(null);
            pSDevSlnSys.setPSSysPolicyName(null);
            pSDevSlnSys.setPSTaskServerId(null);
            pSDevSlnSys.setPSTaskServerName(null);
            pSDevSlnSys.setResReadyTime(null);
            pSDevSlnSys.setUnloadTime(null);
            pSDevSlnSys.setUpdateDate(null);
            pSDevSlnSys.setUpdateMan(null);
            super.exportCurXmlModel(pSDevSlnSys, xmlNode, bl);
        }
    }
}

