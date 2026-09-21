/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.node.ObjectNode
 *  javax.annotation.PostConstruct
 *  net.ibizsys.paas.core.IDEDataSetFetchContext
 *  net.ibizsys.paas.dao.DAOGlobal
 *  net.ibizsys.paas.dao.IDAO
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.db.DBFetchResult
 *  net.ibizsys.paas.db.ISelectCond
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityError
 *  net.ibizsys.paas.entity.EntityFieldError
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.SimpleEntity
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
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import net.ibizsys.paas.core.IDEDataSetFetchContext;
import net.ibizsys.paas.dao.DAOGlobal;
import net.ibizsys.paas.dao.IDAO;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.db.DBFetchResult;
import net.ibizsys.paas.db.ISelectCond;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityError;
import net.ibizsys.paas.entity.EntityFieldError;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.SimpleEntity;
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
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppFuncServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysUIAction;
import net.ibizsys.pscore.srv.config.entity.PSSysUIActionBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEUIActionDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEUIActionDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExpBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImpBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrint;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEPrintBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicServiceBase;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionService;
import net.ibizsys.pscore.srv.helpdesign.service.PSHelpSectionServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcessBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUIActionServiceBase
extends PSCoreSysServiceBase<PSDEUIAction> {
    private static final Log log = LogFactory.getLog(PSDEUIActionServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSDE = "CurSysDE";
    public static final String DATASET_CURSYSNOWF = "CurSysNoWF";
    public static final String DATASET_CURSYSWF = "CurSysWF";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_SYSANDDERANGE = "SysAndDERange";
    public static final String ACTION_CREATEDEUAGROUP = "CreateDEUAGroup";
    private PSDEUIActionDEModel pSDEUIActionDEModel;
    private PSDEUIActionDAO pSDEUIActionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService";
    }

    public PSDEUIActionDEModel getPSDEUIActionDEModel() {
        if (this.pSDEUIActionDEModel == null) {
            try {
                this.pSDEUIActionDEModel = (PSDEUIActionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEUIActionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUIActionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEUIActionDEModel();
    }

    public PSDEUIActionDAO getPSDEUIActionDAO() {
        if (this.pSDEUIActionDAO == null) {
            try {
                this.pSDEUIActionDAO = (PSDEUIActionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEUIActionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEUIActionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEUIActionDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSDE, (boolean)true) == 0) {
            return this.fetchCurSysDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSNOWF, (boolean)true) == 0) {
            return this.fetchCurSysNoWF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSWF, (boolean)true) == 0) {
            return this.fetchCurSysWF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_SYSANDDERANGE, (boolean)true) == 0) {
            return this.fetchSysAndDERange(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEDEUAGROUP, (boolean)true) == 0) {
            this.createDEUAGroup((PSDEUIAction)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysNoWF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSNOWF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysWF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSWF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchSysAndDERange(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_SYSANDDERANGE, false);
        return dBFetchResult;
    }

    public void createDEUAGroup(PSDEUIAction pSDEUIAction) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEUAGROUP, 0, (IEntity)pSDEUIAction, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEUIAction, ACTION_CREATEDEUAGROUP);
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEUIActionServiceBase.this.getService(), PSDEUIActionServiceBase.ACTION_CREATEDEUAGROUP, 40, (IEntity)pSDEUIAction2, null).getResult() != 1) {
                    PSDEUIActionServiceBase.this.onCreateDEUAGroup(pSDEUIAction2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEUAGROUP, 99, (IEntity)pSDEUIAction, null);
        }
    }

    protected void onCreateDEUAGroup(PSDEUIAction pSDEUIAction) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateDEUAGroup]");
    }

    protected void onFillParentInfo(PSDEUIAction pSDEUIAction, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEUIAction, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEACMODE_PSDEACMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory());
            PSDEACMode pSDEACMode = (PSDEACMode)iService.getDEModel().createEntity();
            pSDEACMode.set("PSDEACMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEACMode);
            } else {
                iService.get((IEntity)pSDEACMode);
            }
            this.onFillParentInfo_PSDEACMode(pSDEUIAction, pSDEACMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDEUIAction, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEDATAEXP_NO2PSDEDATAEXPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService", (SessionFactory)this.getSessionFactory());
            PSDEDataExp pSDEDataExp = (PSDEDataExp)iService.getDEModel().createEntity();
            pSDEDataExp.set("PSDEDATAEXPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataExp);
            } else {
                iService.get((IEntity)pSDEDataExp);
            }
            this.onFillParentInfo_No2PSDEDataExp(pSDEUIAction, pSDEDataExp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEDATAIMP_PSDEDATAIMPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService", (SessionFactory)this.getSessionFactory());
            PSDEDataImp pSDEDataImp = (PSDEDataImp)iService.getDEModel().createEntity();
            pSDEDataImp.set("PSDEDATAIMPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataImp);
            } else {
                iService.get((IEntity)pSDEDataImp);
            }
            this.onFillParentInfo_PSDEDataImp(pSDEUIAction, pSDEDataImp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEFGROUP_PSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFGroup);
            } else {
                iService.get((IEntity)pSDEFGroup);
            }
            this.onFillParentInfo_PSDEFGroup(pSDEUIAction, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEUIAction, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDELOGIC_PSDEVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDEViewLogic(pSDEUIAction, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEOPPriv);
            } else {
                iService.get((IEntity)pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOpPriv(pSDEUIAction, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEPRINT_PSDEPRINTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService", (SessionFactory)this.getSessionFactory());
            PSDEPrint pSDEPrint = (PSDEPrint)iService.getDEModel().createEntity();
            pSDEPrint.set("PSDEPRINTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEPrint);
            } else {
                iService.get((IEntity)pSDEPrint);
            }
            this.onFillParentInfo_PSDEPrint(pSDEUIAction, pSDEPrint);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEUIACTION_NEXTPSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction2.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUIAction2);
            } else {
                iService.get((IEntity)pSDEUIAction2);
            }
            this.onFillParentInfo_NextPSDEUIAction(pSDEUIAction, pSDEUIAction2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEVIEWBASE_MOBPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_MobPSDEView(pSDEUIAction, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDEUIAction, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEUIAction, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSLANGUAGERES_CMPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_CMPSLanRes(pSDEUIAction, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSLANGUAGERES_SMPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_SMPSLanRes(pSDEUIAction, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSDEUIAction, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSDEUIAction, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCounter);
            } else {
                iService.get((IEntity)pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSDEUIAction, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEUIAction, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEUIAction, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSPDTVIEW_PSSYSPDTVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService", (SessionFactory)this.getSessionFactory());
            PSSysPDTView pSSysPDTView = (PSSysPDTView)iService.getDEModel().createEntity();
            pSSysPDTView.set("PSSYSPDTVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPDTView);
            } else {
                iService.get((IEntity)pSSysPDTView);
            }
            this.onFillParentInfo_PSSysPDTView(pSDEUIAction, pSSysPDTView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEUIAction, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEUIAction, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDEUIAction, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSUIACTION_PSSYSUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysUIActionService", (SessionFactory)this.getSessionFactory());
            PSSysUIAction pSSysUIAction = (PSSysUIAction)iService.getDEModel().createEntity();
            pSSysUIAction.set("PSSYSUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUIAction);
            } else {
                iService.get((IEntity)pSSysUIAction);
            }
            this.onFillParentInfo_PSSysUIAction(pSDEUIAction, pSSysUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSUIACTION_REPPSSYSUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysUIActionService", (SessionFactory)this.getSessionFactory());
            PSSysUIAction pSSysUIAction = (PSSysUIAction)iService.getDEModel().createEntity();
            pSSysUIAction.set("PSSYSUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysUIAction);
            } else {
                iService.get((IEntity)pSSysUIAction);
            }
            this.onFillParentInfo_RepPSSysUIAction(pSDEUIAction, pSSysUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService", (SessionFactory)this.getSessionFactory());
            PSSysViewLogic pSSysViewLogic = (PSSysViewLogic)iService.getDEModel().createEntity();
            pSSysViewLogic.set("PSSYSVIEWLOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewLogic);
            } else {
                iService.get((IEntity)pSSysViewLogic);
            }
            this.onFillParentInfo_PSSysViewLogic(pSDEUIAction, pSSysViewLogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSWFLINK_PSWFPLINKID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService", (SessionFactory)this.getSessionFactory());
            PSWFLink pSWFLink = (PSWFLink)iService.getDEModel().createEntity();
            pSWFLink.set("PSWFLINKID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFLink);
            } else {
                iService.get((IEntity)pSWFLink);
            }
            this.onFillParentInfo_PSWFLink(pSDEUIAction, pSWFLink);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSWFPROCESS_PSWFPROCESSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService", (SessionFactory)this.getSessionFactory());
            PSWFProcess pSWFProcess = (PSWFProcess)iService.getDEModel().createEntity();
            pSWFProcess.set("PSWFPROCESSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFProcess);
            } else {
                iService.get((IEntity)pSWFProcess);
            }
            this.onFillParentInfo_PSWFProcess(pSDEUIAction, pSWFProcess);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            PSWFVersion pSWFVersion = (PSWFVersion)iService.getDEModel().createEntity();
            pSWFVersion.set("PSWFVERSIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWFVersion);
            } else {
                iService.get((IEntity)pSWFVersion);
            }
            this.onFillParentInfo_PSWFVersion(pSDEUIAction, pSWFVersion);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSWORKFLOW_PSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWorkflow);
            } else {
                iService.get((IEntity)pSWorkflow);
            }
            this.onFillParentInfo_PSWF(pSDEUIAction, pSWorkflow);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEUIAction, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEUIAction pSDEUIAction, PSDataEntity pSDataEntity) throws Exception {
        pSDEUIAction.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEUIAction.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSDEUIAction, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_PSDEACMode(PSDEUIAction pSDEUIAction, PSDEACMode pSDEACMode) throws Exception {
        pSDEUIAction.setPSDEACModeId(pSDEACMode.getPSDEACModeId());
        pSDEUIAction.setPSDEACModeName(pSDEACMode.getPSDEACModeName());
    }

    protected void onFillParentInfo_PSDEAction(PSDEUIAction pSDEUIAction, PSDEAction pSDEAction) throws Exception {
        pSDEUIAction.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEUIAction.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_No2PSDEDataExp(PSDEUIAction pSDEUIAction, PSDEDataExp pSDEDataExp) throws Exception {
        pSDEUIAction.setNo2PSDEDataExpId(pSDEDataExp.getPSDEDataExpId());
        pSDEUIAction.setNo2PSDEDataExpName(pSDEDataExp.getPSDEDataExpName());
    }

    protected void onFillParentInfo_PSDEDataImp(PSDEUIAction pSDEUIAction, PSDEDataImp pSDEDataImp) throws Exception {
        pSDEUIAction.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
        pSDEUIAction.setPSDEDataImpName(pSDEDataImp.getPSDEDataImpName());
    }

    protected void onFillParentInfo_PSDEFGroup(PSDEUIAction pSDEUIAction, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEUIAction.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEUIAction.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEUIAction pSDEUIAction, PSDEForm pSDEForm) throws Exception {
        pSDEUIAction.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEUIAction.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEViewLogic(PSDEUIAction pSDEUIAction, PSDELogic pSDELogic) throws Exception {
        pSDEUIAction.setPSDEViewLogicId(pSDELogic.getPSDELogicId());
        pSDEUIAction.setPSDEViewLogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEOpPriv(PSDEUIAction pSDEUIAction, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEUIAction.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEUIAction.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDEPrint(PSDEUIAction pSDEUIAction, PSDEPrint pSDEPrint) throws Exception {
        pSDEUIAction.setPSDEPrintId(pSDEPrint.getPSDEPrintId());
        pSDEUIAction.setPSDEPrintName(pSDEPrint.getPSDEPrintName());
    }

    protected void onFillParentInfo_NextPSDEUIAction(PSDEUIAction pSDEUIAction, PSDEUIAction pSDEUIAction2) throws Exception {
        pSDEUIAction.setNextPSDEUIActionId(pSDEUIAction2.getPSDEUIActionId());
        pSDEUIAction.setNextPSDEUIActionName(pSDEUIAction2.getPSDEUIActionName());
    }

    protected void onFillParentInfo_MobPSDEView(PSDEUIAction pSDEUIAction, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEUIAction.setMobPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEUIAction.setMobPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSDEUIAction pSDEUIAction, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEUIAction.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEUIAction.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEUIAction pSDEUIAction, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEUIAction.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEUIAction.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_CMPSLanRes(PSDEUIAction pSDEUIAction, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEUIAction.setCMPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEUIAction.setCMPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_SMPSLanRes(PSDEUIAction pSDEUIAction, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEUIAction.setSMPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEUIAction.setSMPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSDEUIAction pSDEUIAction, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEUIAction.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEUIAction.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSModule(PSDEUIAction pSDEUIAction, PSModule pSModule) throws Exception {
        pSDEUIAction.setPSModuleId(pSModule.getPSModuleId());
        pSDEUIAction.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysCounter(PSDEUIAction pSDEUIAction, PSSysCounter pSSysCounter) throws Exception {
        pSDEUIAction.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSDEUIAction.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEUIAction pSDEUIAction, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEUIAction.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEUIAction.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEUIAction pSDEUIAction, PSSysImage pSSysImage) throws Exception {
        pSDEUIAction.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEUIAction.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysPDTView(PSDEUIAction pSDEUIAction, PSSysPDTView pSSysPDTView) throws Exception {
        pSDEUIAction.setPSSysPDTViewId(pSSysPDTView.getPSSysPDTViewId());
        pSDEUIAction.setPSSysPDTViewName(pSSysPDTView.getPSSysPDTViewName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEUIAction pSDEUIAction, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEUIAction.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEUIAction.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEUIAction pSDEUIAction, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEUIAction.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEUIAction.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSystem(PSDEUIAction pSDEUIAction, PSSystem pSSystem) throws Exception {
        pSDEUIAction.setPSSystemId(pSSystem.getPSSystemId());
        pSDEUIAction.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysUIAction(PSDEUIAction pSDEUIAction, PSSysUIAction pSSysUIAction) throws Exception {
        pSDEUIAction.setPSSysUIActionId(pSSysUIAction.getPSSysUIActionId());
        pSDEUIAction.setPSSysUIActionName(pSSysUIAction.getPSSysUIActionName());
        pSDEUIAction.setSysItemObj(pSSysUIAction.getItemObj());
    }

    protected void onFillParentInfo_RepPSSysUIAction(PSDEUIAction pSDEUIAction, PSSysUIAction pSSysUIAction) throws Exception {
        pSDEUIAction.setRepPSSysUIActionId(pSSysUIAction.getPSSysUIActionId());
        pSDEUIAction.setRepPSSysUIActionName(pSSysUIAction.getPSSysUIActionName());
    }

    protected void onFillParentInfo_PSSysViewLogic(PSDEUIAction pSDEUIAction, PSSysViewLogic pSSysViewLogic) throws Exception {
        pSDEUIAction.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
        pSDEUIAction.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
    }

    protected void onFillParentInfo_PSWFLink(PSDEUIAction pSDEUIAction, PSWFLink pSWFLink) throws Exception {
        pSDEUIAction.setPSWFLinkId(pSWFLink.getPSWFLinkId());
    }

    protected void onFillParentInfo_PSWFProcess(PSDEUIAction pSDEUIAction, PSWFProcess pSWFProcess) throws Exception {
        pSDEUIAction.setPSWFProcessId(pSWFProcess.getPSWFProcessId());
    }

    protected void onFillParentInfo_PSWFVersion(PSDEUIAction pSDEUIAction, PSWFVersion pSWFVersion) throws Exception {
        pSDEUIAction.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
        pSDEUIAction.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
        if (pSWFVersion.getPSWF() != null) {
            this.onFillParentInfo_PSWF(pSDEUIAction, pSWFVersion.getPSWF());
        }
    }

    protected void onFillParentInfo_PSWF(PSDEUIAction pSDEUIAction, PSWorkflow pSWorkflow) throws Exception {
        pSDEUIAction.setPSWFId(pSWorkflow.getPSWorkflowId());
        pSDEUIAction.setPSWFName(pSWorkflow.getPSWorkflowName());
    }

    protected void onFillEntityFullInfo(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        if (bl && pSDEUIAction.getTemplMode() == null) {
            pSDEUIAction.setTemplMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDE(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDEACMode(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDEUIAction, bl);
        this.onFillEntityFullInfo_No2PSDEDataExp(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDEDataImp(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDEFGroup(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDEViewLogic(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDEOpPriv(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDEPrint(pSDEUIAction, bl);
        this.onFillEntityFullInfo_NextPSDEUIAction(pSDEUIAction, bl);
        this.onFillEntityFullInfo_MobPSDEView(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDEUIAction, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEUIAction, bl);
        this.onFillEntityFullInfo_CMPSLanRes(pSDEUIAction, bl);
        this.onFillEntityFullInfo_SMPSLanRes(pSDEUIAction, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSModule(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSSysPDTView(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSSystem(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSSysUIAction(pSDEUIAction, bl);
        this.onFillEntityFullInfo_RepPSSysUIAction(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSSysViewLogic(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSWFLink(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSWFProcess(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSWFVersion(pSDEUIAction, bl);
        this.onFillEntityFullInfo_PSWF(pSDEUIAction, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        if (pSDEUIAction.isPSDEIdDirty()) {
            if (pSDEUIAction.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSDEUIAction.getPSDEId() == null || pSDEUIAction.getPSDEName() == null) {
                    pSDataEntity = pSDEUIAction.getPSDE();
                    pSDEUIAction.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSDEUIAction.getPSDE()).getPSSystemId(), (Object)pSDEUIAction.getPSSystemId()) != 0L) {
                    pSDEUIAction.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSDEUIAction, bl);
                }
            } else {
                pSDEUIAction.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEACMode(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSDEDataExp(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataImp(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEFGroup(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewLogic(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEOpPriv(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEPrint(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NextPSDEUIAction(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MobPSDEView(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        if (pSDEUIAction.isCapPSLanResIdDirty()) {
            if (pSDEUIAction.getCapPSLanResId() != null) {
                if (pSDEUIAction.getCapPSLanResId() == null || pSDEUIAction.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEUIAction.getCapPSLanRes();
                    pSDEUIAction.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEUIAction.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CMPSLanRes(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        if (pSDEUIAction.isCMPSLanResIdDirty()) {
            if (pSDEUIAction.getCMPSLanResId() != null) {
                if (pSDEUIAction.getCMPSLanResId() == null || pSDEUIAction.getCMPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEUIAction.getCMPSLanRes();
                    pSDEUIAction.setCMPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEUIAction.setCMPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SMPSLanRes(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        if (pSDEUIAction.isSMPSLanResIdDirty()) {
            if (pSDEUIAction.getSMPSLanResId() != null) {
                if (pSDEUIAction.getSMPSLanResId() == null || pSDEUIAction.getSMPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEUIAction.getSMPSLanRes();
                    pSDEUIAction.setSMPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEUIAction.setSMPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        if (pSDEUIAction.isTipPSLanResIdDirty()) {
            if (pSDEUIAction.getTipPSLanResId() != null) {
                if (pSDEUIAction.getTipPSLanResId() == null || pSDEUIAction.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEUIAction.getTipPSLanRes();
                    pSDEUIAction.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEUIAction.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPDTView(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysUIAction(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RepPSSysUIAction(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewLogic(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFLink(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFProcess(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWFVersion(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWF(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEUIAction, bl);
    }

    public ArrayList<PSDEUIAction> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSDEACMode(PSDEACModeBase pSDEACModeBase) throws Exception {
        return this.selectByPSDEACMode(pSDEACModeBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEACMode(PSDEACModeBase pSDEACModeBase, String string) throws Exception {
        return this.selectByPSDEACMode(pSDEACModeBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEACMode(PSDEACModeBase pSDEACModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACMODEID", (Object)pSDEACModeBase.getPSDEACModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEACModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEACModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByNo2PSDEDataExp(PSDEDataExpBase pSDEDataExpBase) throws Exception {
        return this.selectByNo2PSDEDataExp(pSDEDataExpBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByNo2PSDEDataExp(PSDEDataExpBase pSDEDataExpBase, String string) throws Exception {
        return this.selectByNo2PSDEDataExp(pSDEDataExpBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByNo2PSDEDataExp(PSDEDataExpBase pSDEDataExpBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDEDATAEXPID", (Object)pSDEDataExpBase.getPSDEDataExpId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSDEDataExpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSDEDataExpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSDEDataImp(PSDEDataImpBase pSDEDataImpBase) throws Exception {
        return this.selectByPSDEDataImp(pSDEDataImpBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEDataImp(PSDEDataImpBase pSDEDataImpBase, String string) throws Exception {
        return this.selectByPSDEDataImp(pSDEDataImpBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEDataImp(PSDEDataImpBase pSDEDataImpBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATAIMPID", (Object)pSDEDataImpBase.getPSDEDataImpId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataImpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataImpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFGROUPID", (Object)pSDEFGroupBase.getPSDEFGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSDEViewLogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDEViewLogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEViewLogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDEViewLogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEViewLogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWLOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSDEOpPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOpPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEOpPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOpPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEOpPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEOpPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEOpPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSDEPrint(PSDEPrintBase pSDEPrintBase) throws Exception {
        return this.selectByPSDEPrint(pSDEPrintBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEPrint(PSDEPrintBase pSDEPrintBase, String string) throws Exception {
        return this.selectByPSDEPrint(pSDEPrintBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEPrint(PSDEPrintBase pSDEPrintBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPRINTID", (Object)pSDEPrintBase.getPSDEPrintId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEPrintCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEPrintCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByNextPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByNextPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByNextPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByNextPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByNextPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NEXTPSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNextPSDEUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNextPSDEUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByMobPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByMobPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByMobPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOBPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMobPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMobPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CAPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCapPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCapPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByCMPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCMPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByCMPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCMPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByCMPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CMPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCMPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCMPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectBySMPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectBySMPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectBySMPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectBySMPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectBySMPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SMPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySMPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySMPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TIPPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTipPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTipPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSMODULEID", (Object)pSModuleBase.getPSModuleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSModuleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSModuleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCOUNTERID", (Object)pSSysCounterBase.getPSSysCounterId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCounterCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCounterCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDYNAMODELID", (Object)pSSysDynaModelBase.getPSSysDynaModelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDynaModelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDynaModelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSIMAGEID", (Object)pSSysImageBase.getPSSysImageId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysImageCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysImageCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase) throws Exception {
        return this.selectByPSSysPDTView(pSSysPDTViewBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string) throws Exception {
        return this.selectByPSSysPDTView(pSSysPDTViewBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPDTVIEWID", (Object)pSSysPDTViewBase.getPSSysPDTViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPDTViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPDTViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSREQITEMID", (Object)pSSysReqItemBase.getPSSysReqItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysReqItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysReqItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTEMID", (Object)pSSystemBase.getPSSystemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSystemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSystemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSSysUIAction(PSSysUIActionBase pSSysUIActionBase) throws Exception {
        return this.selectByPSSysUIAction(pSSysUIActionBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysUIAction(PSSysUIActionBase pSSysUIActionBase, String string) throws Exception {
        return this.selectByPSSysUIAction(pSSysUIActionBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysUIAction(PSSysUIActionBase pSSysUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSUIACTIONID", (Object)pSSysUIActionBase.getPSSysUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByRepPSSysUIAction(PSSysUIActionBase pSSysUIActionBase) throws Exception {
        return this.selectByRepPSSysUIAction(pSSysUIActionBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByRepPSSysUIAction(PSSysUIActionBase pSSysUIActionBase, String string) throws Exception {
        return this.selectByRepPSSysUIAction(pSSysUIActionBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByRepPSSysUIAction(PSSysUIActionBase pSSysUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REPPSSYSUIACTIONID", (Object)pSSysUIActionBase.getPSSysUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRepPSSysUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRepPSSysUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string) throws Exception {
        return this.selectByPSSysViewLogic(pSSysViewLogicBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSSysViewLogic(PSSysViewLogicBase pSSysViewLogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWLOGICID", (Object)pSSysViewLogicBase.getPSSysViewLogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewLogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewLogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSWFLink(PSWFLinkBase pSWFLinkBase) throws Exception {
        return this.selectByPSWFLink(pSWFLinkBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSWFLink(PSWFLinkBase pSWFLinkBase, String string) throws Exception {
        return this.selectByPSWFLink(pSWFLinkBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSWFLink(PSWFLinkBase pSWFLinkBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFPLINKID", (Object)pSWFLinkBase.getPSWFLinkId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFLinkCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFLinkCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase) throws Exception {
        return this.selectByPSWFProcess(pSWFProcessBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string) throws Exception {
        return this.selectByPSWFProcess(pSWFProcessBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSWFProcess(PSWFProcessBase pSWFProcessBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFPROCESSID", (Object)pSWFProcessBase.getPSWFProcessId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFProcessCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFProcessCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string) throws Exception {
        return this.selectByPSWFVersion(pSWFVersionBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSWFVersion(PSWFVersionBase pSWFVersionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFVERSIONID", (Object)pSWFVersionBase.getPSWFVersionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFVersionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFVersionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEUIAction> selectByPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSDEUIAction> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSDEUIAction> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSWFID", (Object)pSWorkflowBase.getPSWorkflowId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSWFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSWFCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEACMode(pSDEACMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEACMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEACMODE_PSDEACMODEID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEACMode), arrayList.get(0)));
        }
    }

    public void resetPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEACMode(pSDEACMode);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEACModeId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        final PSDEACMode pSDEACMode2 = pSDEACMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDEACMode(pSDEACMode2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDEACMode(pSDEACMode2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDEACMode(pSDEACMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void internalRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEACMode(pSDEACMode);
        this.onBeforeRemoveByPSDEACMode(pSDEACMode, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDEACMode(pSDEACMode, arrayList);
    }

    protected void onAfterRemoveByPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void onBeforeRemoveByPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEActionId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByNo2PSDEDataExp(pSDEDataExp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAEXP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataExp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEDATAEXP_NO2PSDEDATAEXPID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEDataExp), arrayList.get(0)));
        }
    }

    public void resetNo2PSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByNo2PSDEDataExp(pSDEDataExp);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setNo2PSDEDataExpId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByNo2PSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        final PSDEDataExp pSDEDataExp2 = pSDEDataExp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByNo2PSDEDataExp(pSDEDataExp2);
                PSDEUIActionServiceBase.this.internalRemoveByNo2PSDEDataExp(pSDEDataExp2);
                PSDEUIActionServiceBase.this.onAfterRemoveByNo2PSDEDataExp(pSDEDataExp2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
    }

    protected void internalRemoveByNo2PSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByNo2PSDEDataExp(pSDEDataExp);
        this.onBeforeRemoveByNo2PSDEDataExp(pSDEDataExp, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByNo2PSDEDataExp(pSDEDataExp, arrayList);
    }

    protected void onAfterRemoveByNo2PSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDEDataExp(PSDEDataExp pSDEDataExp, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDEDataExp(PSDEDataExp pSDEDataExp, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEDataImp(pSDEDataImp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAIMP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataImp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEDATAIMP_PSDEDATAIMPID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEDataImp), arrayList.get(0)));
        }
    }

    public void resetPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEDataImp(pSDEDataImp);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEDataImpId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        final PSDEDataImp pSDEDataImp2 = pSDEDataImp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDEDataImp(pSDEDataImp2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDEDataImp(pSDEDataImp2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDEDataImp(pSDEDataImp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
    }

    protected void internalRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEDataImp(pSDEDataImp);
        this.onBeforeRemoveByPSDEDataImp(pSDEDataImp, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDEDataImp(pSDEDataImp, arrayList);
    }

    protected void onAfterRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEFGROUP_PSDEFGROUPID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEFGroupId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEFormId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewLogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEViewLogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDELOGIC_PSDEVIEWLOGICID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDEViewLogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEViewLogic(pSDELogic);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEViewLogicId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDEViewLogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDEViewLogic(pSDELogic2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDEViewLogic(pSDELogic2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDEViewLogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewLogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDEViewLogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEViewLogic(pSDELogic);
        this.onBeforeRemoveByPSDEViewLogic(pSDELogic, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDEViewLogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDEViewLogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewLogic(PSDELogic pSDELogic, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewLogic(PSDELogic pSDELogic, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOpPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEOpPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOpPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEOpPriv(pSDEOPPriv);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEOPPrivId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDEOpPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDEOpPriv(pSDEOPPriv2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDEOpPriv(pSDEOPPriv2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDEOpPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOpPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOpPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEOpPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOpPriv(pSDEOPPriv, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDEOpPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOpPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOpPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOpPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEPrint(pSDEPrint, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEPRINT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEPrint);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEPRINT_PSDEPRINTID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEPrint), arrayList.get(0)));
        }
    }

    public void resetPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEPrint(pSDEPrint);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEPrintId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        final PSDEPrint pSDEPrint2 = pSDEPrint;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDEPrint(pSDEPrint2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDEPrint(pSDEPrint2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDEPrint(pSDEPrint2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
    }

    protected void internalRemoveByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEPrint(pSDEPrint);
        this.onBeforeRemoveByPSDEPrint(pSDEPrint, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDEPrint(pSDEPrint, arrayList);
    }

    protected void onAfterRemoveByPSDEPrint(PSDEPrint pSDEPrint) throws Exception {
    }

    protected void onBeforeRemoveByPSDEPrint(PSDEPrint pSDEPrint, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEPrint(PSDEPrint pSDEPrint, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByNextPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByNextPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEUIACTION_NEXTPSDEUIACTIONID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetNextPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByNextPSDEUIAction(pSDEUIAction);
        for (PSDEUIAction pSDEUIAction2 : arrayList) {
            PSDEUIAction pSDEUIAction3 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction3.setPSDEUIActionId(pSDEUIAction2.getPSDEUIActionId());
            pSDEUIAction3.setNextPSDEUIActionId(null);
            this.update(pSDEUIAction3);
        }
    }

    public void removeByNextPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByNextPSDEUIAction(pSDEUIAction2);
                PSDEUIActionServiceBase.this.internalRemoveByNextPSDEUIAction(pSDEUIAction2);
                PSDEUIActionServiceBase.this.onAfterRemoveByNextPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByNextPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByNextPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByNextPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByNextPSDEUIAction(pSDEUIAction, arrayList);
        for (PSDEUIAction pSDEUIAction2 : arrayList) {
            this.remove((IEntity)pSDEUIAction2);
        }
        this.onAfterRemoveByNextPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByNextPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByNextPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNextPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByMobPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEVIEWBASE_MOBPSDEVIEWID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByMobPSDEView(pSDEViewBase);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setMobPSDEViewId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByMobPSDEView(pSDEViewBase2);
                PSDEUIActionServiceBase.this.internalRemoveByMobPSDEView(pSDEViewBase2);
                PSDEUIActionServiceBase.this.onAfterRemoveByMobPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByMobPSDEView(pSDEViewBase);
        this.onBeforeRemoveByMobPSDEView(pSDEViewBase, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByMobPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByMobPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMobPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSDEViewBaseId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEUIActionServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setCapPSLanResId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEUIActionServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEUIActionServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByCMPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSLANGUAGERES_CMPSLANRESID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByCMPSLanRes(pSLanguageRes);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setCMPSLanResId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByCMPSLanRes(pSLanguageRes2);
                PSDEUIActionServiceBase.this.internalRemoveByCMPSLanRes(pSLanguageRes2);
                PSDEUIActionServiceBase.this.onAfterRemoveByCMPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByCMPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCMPSLanRes(pSLanguageRes, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByCMPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveBySMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectBySMPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSLANGUAGERES_SMPSLANRESID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetSMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectBySMPSLanRes(pSLanguageRes);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setSMPSLanResId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeBySMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveBySMPSLanRes(pSLanguageRes2);
                PSDEUIActionServiceBase.this.internalRemoveBySMPSLanRes(pSLanguageRes2);
                PSDEUIActionServiceBase.this.onAfterRemoveBySMPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveBySMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveBySMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectBySMPSLanRes(pSLanguageRes);
        this.onBeforeRemoveBySMPSLanRes(pSLanguageRes, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveBySMPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveBySMPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveBySMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySMPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setTipPSLanResId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEUIActionServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSDEUIActionServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSModule(pSModule);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSModuleId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSDEUIActionServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSSysCounterId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSDEUIActionServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSSysDynaModelId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEUIActionServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSSysImageId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEUIActionServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysPDTView(pSSysPDTView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPDTVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPDTView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSSYSPDTVIEW_PSSYSPDTVIEWID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSSysPDTView), arrayList.get(0)));
        }
    }

    public void resetPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysPDTView(pSSysPDTView);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSSysPDTViewId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        final PSSysPDTView pSSysPDTView2 = pSSysPDTView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSSysPDTView(pSSysPDTView2);
                PSDEUIActionServiceBase.this.internalRemoveByPSSysPDTView(pSSysPDTView2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSSysPDTView(pSSysPDTView2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void internalRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysPDTView(pSSysPDTView);
        this.onBeforeRemoveByPSSysPDTView(pSSysPDTView, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSSysPDTView(pSSysPDTView, arrayList);
    }

    protected void onAfterRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSSysPFPluginId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEUIActionServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSSysReqItemId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEUIActionServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSSystemId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDEUIActionServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysUIAction(pSSysUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSSYSUIACTION_PSSYSUIACTIONID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSSysUIAction), arrayList.get(0)));
        }
    }

    public void resetPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysUIAction(pSSysUIAction);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSSysUIActionId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        final PSSysUIAction pSSysUIAction2 = pSSysUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSSysUIAction(pSSysUIAction2);
                PSDEUIActionServiceBase.this.internalRemoveByPSSysUIAction(pSSysUIAction2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSSysUIAction(pSSysUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
    }

    protected void internalRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysUIAction(pSSysUIAction);
        this.onBeforeRemoveByPSSysUIAction(pSSysUIAction, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSSysUIAction(pSSysUIAction, arrayList);
    }

    protected void onAfterRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysUIAction(PSSysUIAction pSSysUIAction, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByRepPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByRepPSSysUIAction(pSSysUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSSYSUIACTION_REPPSSYSUIACTIONID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSSysUIAction), arrayList.get(0)));
        }
    }

    public void resetRepPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByRepPSSysUIAction(pSSysUIAction);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setRepPSSysUIActionId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByRepPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        final PSSysUIAction pSSysUIAction2 = pSSysUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByRepPSSysUIAction(pSSysUIAction2);
                PSDEUIActionServiceBase.this.internalRemoveByRepPSSysUIAction(pSSysUIAction2);
                PSDEUIActionServiceBase.this.onAfterRemoveByRepPSSysUIAction(pSSysUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByRepPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
    }

    protected void internalRemoveByRepPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByRepPSSysUIAction(pSSysUIAction);
        this.onBeforeRemoveByRepPSSysUIAction(pSSysUIAction, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByRepPSSysUIAction(pSSysUIAction, arrayList);
    }

    protected void onAfterRemoveByRepPSSysUIAction(PSSysUIAction pSSysUIAction) throws Exception {
    }

    protected void onBeforeRemoveByRepPSSysUIAction(PSSysUIAction pSSysUIAction, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRepPSSysUIAction(PSSysUIAction pSSysUIAction, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWLOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewLogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEUIACTION_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", "", iDataEntityModel.getName(), "PSDEUIACTION", iDataEntityModel.getDataInfo((IEntity)pSSysViewLogic), arrayList.get(0)));
        }
    }

    public void resetPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSSysViewLogicId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEUIActionServiceBase.this.internalRemoveByPSSysViewLogic(pSSysViewLogic2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void internalRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSSysViewLogic(pSSysViewLogic);
        this.onBeforeRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSSysViewLogic(pSSysViewLogic, arrayList);
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewLogic(PSSysViewLogic pSSysViewLogic, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    public void resetPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSWFLink(pSWFLink);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSWFLinkId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSWFLink(PSWFLink pSWFLink) throws Exception {
        final PSWFLink pSWFLink2 = pSWFLink;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSWFLink(pSWFLink2);
                PSDEUIActionServiceBase.this.internalRemoveByPSWFLink(pSWFLink2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSWFLink(pSWFLink2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void internalRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSWFLink(pSWFLink);
        this.onBeforeRemoveByPSWFLink(pSWFLink, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSWFLink(pSWFLink, arrayList);
    }

    protected void onAfterRemoveByPSWFLink(PSWFLink pSWFLink) throws Exception {
    }

    protected void onBeforeRemoveByPSWFLink(PSWFLink pSWFLink, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFLink(PSWFLink pSWFLink, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    public void resetPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSWFProcess(pSWFProcess);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSWFProcessId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        final PSWFProcess pSWFProcess2 = pSWFProcess;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSWFProcess(pSWFProcess2);
                PSDEUIActionServiceBase.this.internalRemoveByPSWFProcess(pSWFProcess2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSWFProcess(pSWFProcess2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void internalRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSWFProcess(pSWFProcess);
        this.onBeforeRemoveByPSWFProcess(pSWFProcess, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSWFProcess(pSWFProcess, arrayList);
    }

    protected void onAfterRemoveByPSWFProcess(PSWFProcess pSWFProcess) throws Exception {
    }

    protected void onBeforeRemoveByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFProcess(PSWFProcess pSWFProcess, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    public void resetPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSWFVersion(pSWFVersion);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSWFVersionId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSWFVersion(pSWFVersion2);
                PSDEUIActionServiceBase.this.internalRemoveByPSWFVersion(pSWFVersion2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSWFVersion(pSWFVersion2);
            }
        });
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void internalRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSWFVersion(pSWFVersion);
        this.onBeforeRemoveByPSWFVersion(pSWFVersion, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSWFVersion(pSWFVersion, arrayList);
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion) throws Exception {
    }

    protected void onBeforeRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWFVersion(PSWFVersion pSWFVersion, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    public void testRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    public void resetPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSWF(pSWorkflow);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            PSDEUIAction pSDEUIAction2 = (PSDEUIAction)this.getDEModel().createEntity();
            pSDEUIAction2.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
            pSDEUIAction2.setPSWFId(null);
            this.update(pSDEUIAction2);
        }
    }

    public void removeByPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEUIActionServiceBase.this.onBeforeRemoveByPSWF(pSWorkflow2);
                PSDEUIActionServiceBase.this.internalRemoveByPSWF(pSWorkflow2);
                PSDEUIActionServiceBase.this.onAfterRemoveByPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSDEUIAction> arrayList = this.selectByPSWF(pSWorkflow);
        this.onBeforeRemoveByPSWF(pSWorkflow, arrayList);
        for (PSDEUIAction pSDEUIAction : arrayList) {
            this.remove((IEntity)pSDEUIAction);
        }
        this.onAfterRemoveByPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSDEUIAction> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEUIAction pSDEUIAction) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppFuncService)ServiceGlobal.getService(PSAppFuncService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppFuncServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSAppViewLogicService)ServiceGlobal.getService(PSAppViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlLogicGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUAAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByNextPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSHelpSectionService)ServiceGlobal.getService(PSHelpSectionService.class, (SessionFactory)this.getSessionFactory());
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        ((PSHelpSectionServiceBase)pSCoreSysServiceBase).removeByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeDimensionServiceBase)pSCoreSysServiceBase).testRemoveByParamPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBICubeMeasureServiceBase)pSCoreSysServiceBase).testRemoveByParamPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSSysDashboardLogicService)ServiceGlobal.getService(PSSysDashboardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSSysMapLogicService)ServiceGlobal.getService(PSSysMapLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFUtilUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEUIAction(pSDEUIAction);
        super.onBeforeRemove(pSDEUIAction);
    }

    protected void replaceParentInfo(PSDEUIAction pSDEUIAction, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEUIAction, cloneSession);
        if (pSDEUIAction.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEUIAction.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEUIAction, (PSDataEntity)iEntity);
        }
        if (pSDEUIAction.getPSDEACModeId() != null && (iEntity = cloneSession.getEntity("PSDEACMODE", (Object)pSDEUIAction.getPSDEACModeId())) != null) {
            this.onFillParentInfo_PSDEACMode(pSDEUIAction, (PSDEACMode)iEntity);
        }
        if (pSDEUIAction.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEUIAction.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDEUIAction, (PSDEAction)iEntity);
        }
        if (pSDEUIAction.getNo2PSDEDataExpId() != null && (iEntity = cloneSession.getEntity("PSDEDATAEXP", (Object)pSDEUIAction.getNo2PSDEDataExpId())) != null) {
            this.onFillParentInfo_No2PSDEDataExp(pSDEUIAction, (PSDEDataExp)iEntity);
        }
        if (pSDEUIAction.getPSDEDataImpId() != null && (iEntity = cloneSession.getEntity("PSDEDATAIMP", (Object)pSDEUIAction.getPSDEDataImpId())) != null) {
            this.onFillParentInfo_PSDEDataImp(pSDEUIAction, (PSDEDataImp)iEntity);
        }
        if (pSDEUIAction.getPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEUIAction.getPSDEFGroupId())) != null) {
            this.onFillParentInfo_PSDEFGroup(pSDEUIAction, (PSDEFGroup)iEntity);
        }
        if (pSDEUIAction.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEUIAction.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEUIAction, (PSDEForm)iEntity);
        }
        if (pSDEUIAction.getPSDEViewLogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEUIAction.getPSDEViewLogicId())) != null) {
            this.onFillParentInfo_PSDEViewLogic(pSDEUIAction, (PSDELogic)iEntity);
        }
        if (pSDEUIAction.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEUIAction.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOpPriv(pSDEUIAction, (PSDEOPPriv)iEntity);
        }
        if (pSDEUIAction.getPSDEPrintId() != null && (iEntity = cloneSession.getEntity("PSDEPRINT", (Object)pSDEUIAction.getPSDEPrintId())) != null) {
            this.onFillParentInfo_PSDEPrint(pSDEUIAction, (PSDEPrint)iEntity);
        }
        if (pSDEUIAction.getNextPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSDEUIAction.getNextPSDEUIActionId())) != null) {
            this.onFillParentInfo_NextPSDEUIAction(pSDEUIAction, (PSDEUIAction)iEntity);
        }
        if (pSDEUIAction.getMobPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEUIAction.getMobPSDEViewId())) != null) {
            this.onFillParentInfo_MobPSDEView(pSDEUIAction, (PSDEViewBase)iEntity);
        }
        if (pSDEUIAction.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEUIAction.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDEUIAction, (PSDEViewBase)iEntity);
        }
        if (pSDEUIAction.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEUIAction.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEUIAction, (PSLanguageRes)iEntity);
        }
        if (pSDEUIAction.getCMPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEUIAction.getCMPSLanResId())) != null) {
            this.onFillParentInfo_CMPSLanRes(pSDEUIAction, (PSLanguageRes)iEntity);
        }
        if (pSDEUIAction.getSMPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEUIAction.getSMPSLanResId())) != null) {
            this.onFillParentInfo_SMPSLanRes(pSDEUIAction, (PSLanguageRes)iEntity);
        }
        if (pSDEUIAction.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEUIAction.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSDEUIAction, (PSLanguageRes)iEntity);
        }
        if (pSDEUIAction.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSDEUIAction.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSDEUIAction, (PSModule)iEntity);
        }
        if (pSDEUIAction.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSDEUIAction.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSDEUIAction, (PSSysCounter)iEntity);
        }
        if (pSDEUIAction.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEUIAction.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEUIAction, (PSSysDynaModel)iEntity);
        }
        if (pSDEUIAction.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEUIAction.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEUIAction, (PSSysImage)iEntity);
        }
        if (pSDEUIAction.getPSSysPDTViewId() != null && (iEntity = cloneSession.getEntity("PSSYSPDTVIEW", (Object)pSDEUIAction.getPSSysPDTViewId())) != null) {
            this.onFillParentInfo_PSSysPDTView(pSDEUIAction, (PSSysPDTView)iEntity);
        }
        if (pSDEUIAction.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEUIAction.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEUIAction, (PSSysPFPlugin)iEntity);
        }
        if (pSDEUIAction.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEUIAction.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEUIAction, (PSSysReqItem)iEntity);
        }
        if (pSDEUIAction.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDEUIAction.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDEUIAction, (PSSystem)iEntity);
        }
        if (pSDEUIAction.getPSSysUIActionId() != null && (iEntity = cloneSession.getEntity("PSSYSUIACTION", (Object)pSDEUIAction.getPSSysUIActionId())) != null) {
            this.onFillParentInfo_PSSysUIAction(pSDEUIAction, (PSSysUIAction)iEntity);
        }
        if (pSDEUIAction.getRepPSSysUIActionId() != null && (iEntity = cloneSession.getEntity("PSSYSUIACTION", (Object)pSDEUIAction.getRepPSSysUIActionId())) != null) {
            this.onFillParentInfo_RepPSSysUIAction(pSDEUIAction, (PSSysUIAction)iEntity);
        }
        if (pSDEUIAction.getPSSysViewLogicId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWLOGIC", (Object)pSDEUIAction.getPSSysViewLogicId())) != null) {
            this.onFillParentInfo_PSSysViewLogic(pSDEUIAction, (PSSysViewLogic)iEntity);
        }
        if (pSDEUIAction.getPSWFLinkId() != null && (iEntity = cloneSession.getEntity("PSWFLINK", (Object)pSDEUIAction.getPSWFLinkId())) != null) {
            this.onFillParentInfo_PSWFLink(pSDEUIAction, (PSWFLink)iEntity);
        }
        if (pSDEUIAction.getPSWFProcessId() != null && (iEntity = cloneSession.getEntity("PSWFPROCESS", (Object)pSDEUIAction.getPSWFProcessId())) != null) {
            this.onFillParentInfo_PSWFProcess(pSDEUIAction, (PSWFProcess)iEntity);
        }
        if (pSDEUIAction.getPSWFVersionId() != null && (iEntity = cloneSession.getEntity("PSWFVERSION", (Object)pSDEUIAction.getPSWFVersionId())) != null) {
            this.onFillParentInfo_PSWFVersion(pSDEUIAction, (PSWFVersion)iEntity);
        }
        if (pSDEUIAction.getPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSDEUIAction.getPSWFId())) != null) {
            this.onFillParentInfo_PSWF(pSDEUIAction, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEUIAction, bl);
        pSDEUIAction.resetUATag();
        pSDEUIAction.resetUATag2();
        pSDEUIAction.resetUATag3();
        pSDEUIAction.resetUATag4();
    }

    protected void onCheckEntity(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActionLevel(bl, pSDEUIAction, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ActionTarget(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ButtonStyle(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CloseEditView(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CMPSLanResId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CMPSLanResName(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConfirmInfo(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataItem(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLogic(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableRTModel(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewActions(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FrontProType(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GlobalFlag(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlPageUrl(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemObj(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobPSDEViewId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NextPSDEUIActionId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEDataExpId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoPrivDM(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ParamItem(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PDTViewFlag(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEACModeId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataExpId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataImpId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEPrintId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionName(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewLogicId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPDTViewId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysUIActionId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFLinkName(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcessId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFProcessName(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReloadData(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RepPSSysUIActionId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SMPSLanResId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SMPSLanResName(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SuccessInfo(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplMode(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TextItem(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Timeout(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UATag(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UATag2(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UATag3(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UATag4(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionCode(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam10(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam11(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam12(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam2(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam3(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam4(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam5(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam6(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam7(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam8(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParam9(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionParams(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UIActionType(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserConfirm(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewActions(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewLogicType(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VisibleLogic(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VLExecMode(bl, pSDEUIAction, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEUIAction, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActionLevel(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isActionLevelDirty() : !pSDEUIAction.isActionLevelDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getActionLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActionLevel_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ActionTarget(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isActionTargetDirty() : !pSDEUIAction.isActionTargetDirty()) {
            return null;
        }
        String string = pSDEUIAction.getActionTarget();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActionTarget_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIONTARGET");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isBusyIndicatorDirty() : !pSDEUIAction.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUSYINDICATOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ButtonStyle(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isButtonStyleDirty() : !pSDEUIAction.isButtonStyleDirty()) {
            return null;
        }
        String string = pSDEUIAction.getButtonStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ButtonStyle_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUTTONSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isCapPSLanResIdDirty() : !pSDEUIAction.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isCapPSLanResNameDirty() : !pSDEUIAction.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEUIAction.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isCaptionDirty() && !bl2 : !pSDEUIAction.isCaptionDirty()) {
            return null;
        }
        String string = pSDEUIAction.getCaption();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CloseEditView(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isCloseEditViewDirty() : !pSDEUIAction.isCloseEditViewDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getCloseEditView();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CloseEditView_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CLOSEEDITVIEW");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CMPSLanResId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isCMPSLanResIdDirty() : !pSDEUIAction.isCMPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getCMPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CMPSLanResId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CMPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CMPSLanResName(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isCMPSLanResNameDirty() : !pSDEUIAction.isCMPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEUIAction.getCMPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CMPSLanResName_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CMPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isCodeNameDirty() : !pSDEUIAction.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEUIAction.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default2((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_ConfirmInfo(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isConfirmInfoDirty() : !pSDEUIAction.isConfirmInfoDirty()) {
            return null;
        }
        String string = pSDEUIAction.getConfirmInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConfirmInfo_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONFIRMINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isCounterIdDirty() : !pSDEUIAction.isCounterIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CounterId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isCustomCodeDirty() : !pSDEUIAction.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEUIAction.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataItem(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isDataItemDirty() : !pSDEUIAction.isDataItemDirty()) {
            return null;
        }
        String string = pSDEUIAction.getDataItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataItem_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isDynaModelFlagDirty() : !pSDEUIAction.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAMODELFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableLogic(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isEnableLogicDirty() : !pSDEUIAction.isEnableLogicDirty()) {
            return null;
        }
        String string = pSDEUIAction.getEnableLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableLogic_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableRTModel(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isEnableRTModelDirty() : !pSDEUIAction.isEnableRTModelDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getEnableRTModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableRTModel_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLERTMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableViewActions(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isEnableViewActionsDirty() : !pSDEUIAction.isEnableViewActionsDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getEnableViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewActions_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEVIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isExtendModeDirty() : !pSDEUIAction.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EXTENDMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FrontProType(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isFrontProTypeDirty() : !pSDEUIAction.isFrontProTypeDirty()) {
            return null;
        }
        String string = pSDEUIAction.getFrontProType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FrontProType_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FRONTPROTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GlobalFlag(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isGlobalFlagDirty() : !pSDEUIAction.isGlobalFlagDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getGlobalFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GlobalFlag_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GLOBALFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HtmlPageUrl(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isHtmlPageUrlDirty() : !pSDEUIAction.isHtmlPageUrlDirty()) {
            return null;
        }
        String string = pSDEUIAction.getHtmlPageUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlPageUrl_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTMLPAGEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemObj(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isItemObjDirty() : !pSDEUIAction.isItemObjDirty()) {
            return null;
        }
        String string = pSDEUIAction.getItemObj();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemObj_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMOBJ");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isLockFlagDirty() : !pSDEUIAction.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCKFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isMemoDirty() : !pSDEUIAction.isMemoDirty()) {
            return null;
        }
        String string = pSDEUIAction.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobPSDEViewId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isMobPSDEViewIdDirty() : !pSDEUIAction.isMobPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getMobPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MobPSDEViewId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NextPSDEUIActionId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isNextPSDEUIActionIdDirty() : !pSDEUIAction.isNextPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getNextPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NextPSDEUIActionId_NextPSDEUIAction((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTPSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_NextPSDEUIActionId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NEXTPSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEDataExpId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isNo2PSDEDataExpIdDirty() : !pSDEUIAction.isNo2PSDEDataExpIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getNo2PSDEDataExpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEDataExpId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEDATAEXPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NoPrivDM(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isNoPrivDMDirty() : !pSDEUIAction.isNoPrivDMDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getNoPrivDM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoPrivDM_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOPRIVDM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ParamItem(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isParamItemDirty() : !pSDEUIAction.isParamItemDirty()) {
            return null;
        }
        String string = pSDEUIAction.getParamItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ParamItem_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PARAMITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PDTViewFlag(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPDTViewFlagDirty() : !pSDEUIAction.isPDTViewFlagDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getPDTViewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PDTViewFlag_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PDTVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEACModeId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEACModeIdDirty() : !pSDEUIAction.isPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEACModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEACModeId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEActionIdDirty() : !pSDEUIAction.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_PSDEAction((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEActionId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataExpId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEDataExpIdDirty() : !pSDEUIAction.isPSDEDataExpIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEDataExpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataExpId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAEXPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataImpId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEDataImpIdDirty() : !pSDEUIAction.isPSDEDataImpIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEDataImpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataImpId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAIMPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEFGroupIdDirty() : !pSDEUIAction.isPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEFormIdDirty() : !pSDEUIAction.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEIdDirty() : !pSDEUIAction.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDENameDirty() : !pSDEUIAction.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEOPPrivIdDirty() : !pSDEUIAction.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEOPPRIVID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEPrintId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEPrintIdDirty() : !pSDEUIAction.isPSDEPrintIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEPrintId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEPrintId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPRINTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEUIActionIdDirty() && !bl2 : !pSDEUIAction.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEUIActionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionName(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEUIActionNameDirty() && !bl2 : !pSDEUIAction.isPSDEUIActionNameDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEUIActionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionName_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEViewBaseIdDirty() : !pSDEUIAction.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewLogicId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDEViewLogicIdDirty() : !pSDEUIAction.isPSDEViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDEViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewLogicId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSDynaInstIdDirty() : !pSDEUIAction.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSModuleIdDirty() : !pSDEUIAction.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSMODULEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSSysCounterIdDirty() : !pSDEUIAction.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCOUNTERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSSysDynaModelIdDirty() : !pSDEUIAction.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSSysImageIdDirty() : !pSDEUIAction.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSIMAGEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPDTViewId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSSysPDTViewIdDirty() : !pSDEUIAction.isPSSysPDTViewIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSSysPDTViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPDTViewId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPDTVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSSysPFPluginIdDirty() : !pSDEUIAction.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSSysReqItemIdDirty() : !pSDEUIAction.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSREQITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSSystemIdDirty() && !bl2 : !pSDEUIAction.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSDEUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysUIActionId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSSysUIActionIdDirty() : !pSDEUIAction.isPSSysUIActionIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSSysUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysUIActionId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewLogicId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSSysViewLogicIdDirty() : !pSDEUIAction.isPSSysViewLogicIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSSysViewLogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWLOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSWFIdDirty() : !pSDEUIAction.isPSWFIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSWFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFLinkId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSWFLinkIdDirty() : !pSDEUIAction.isPSWFLinkIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSWFLinkId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPLINKID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFLinkName(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSWFLinkNameDirty() : !pSDEUIAction.isPSWFLinkNameDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSWFLinkName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFLinkName_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPLINKNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcessId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSWFProcessIdDirty() : !pSDEUIAction.isPSWFProcessIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSWFProcessId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcessId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFProcessName(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSWFProcessNameDirty() : !pSDEUIAction.isPSWFProcessNameDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSWFProcessName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFProcessName_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFPROCESSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isPSWFVersionIdDirty() : !pSDEUIAction.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getPSWFVersionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReloadData(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isReloadDataDirty() : !pSDEUIAction.isReloadDataDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getReloadData();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReloadData_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RELOADDATA");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RepPSSysUIActionId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isRepPSSysUIActionIdDirty() : !pSDEUIAction.isRepPSSysUIActionIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getRepPSSysUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RepPSSysUIActionId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REPPSSYSUIACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (string == null) {
                bl4 = false;
            }
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEUIActionDEModel(), "REPPSSYSUIACTIONID", string3, pSDEUIAction, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("REPPSSYSUIACTIONID");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SMPSLanResId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isSMPSLanResIdDirty() : !pSDEUIAction.isSMPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getSMPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SMPSLanResId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SMPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SMPSLanResName(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isSMPSLanResNameDirty() : !pSDEUIAction.isSMPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEUIAction.getSMPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SMPSLanResName_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SMPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SuccessInfo(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isSuccessInfoDirty() : !pSDEUIAction.isSuccessInfoDirty()) {
            return null;
        }
        String string = pSDEUIAction.getSuccessInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SuccessInfo_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUCCESSINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplMode(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isTemplModeDirty() : !pSDEUIAction.isTemplModeDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getTemplMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplMode_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TextItem(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isTextItemDirty() : !pSDEUIAction.isTextItemDirty()) {
            return null;
        }
        String string = pSDEUIAction.getTextItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TextItem_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEXTITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Timeout(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isTimeoutDirty() : !pSDEUIAction.isTimeoutDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getTimeout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Timeout_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIMEOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isTipPSLanResIdDirty() : !pSDEUIAction.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEUIAction.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isTipPSLanResNameDirty() : !pSDEUIAction.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEUIAction.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TIPPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isToDoTaskDirty() : !pSDEUIAction.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEUIAction.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TODOTASK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isTooltipInfoDirty() : !pSDEUIAction.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSDEUIAction.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLTIPINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UATag(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUATagDirty() : !pSDEUIAction.isUATagDirty()) {
            return null;
        }
        String string = pSDEUIAction.getUATag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UATag_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UATAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UATag2(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUATag2Dirty() : !pSDEUIAction.isUATag2Dirty()) {
            return null;
        }
        String string = pSDEUIAction.getUATag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UATag2_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UATAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UATag3(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUATag3Dirty() : !pSDEUIAction.isUATag3Dirty()) {
            return null;
        }
        String string = pSDEUIAction.getUATag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UATag3_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UATAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UATag4(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUATag4Dirty() : !pSDEUIAction.isUATag4Dirty()) {
            return null;
        }
        String string = pSDEUIAction.getUATag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UATag4_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UATAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionCode(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionCodeDirty() : !pSDEUIAction.isUIActionCodeDirty()) {
            return null;
        }
        String string = pSDEUIAction.getUIActionCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionCode_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONCODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParamDirty() : !pSDEUIAction.isUIActionParamDirty()) {
            return null;
        }
        String string = pSDEUIAction.getUIActionParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionParam_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam10(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam10Dirty() : !pSDEUIAction.isUIActionParam10Dirty()) {
            return null;
        }
        Double d = pSDEUIAction.getUIActionParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UIActionParam10_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam11(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam11Dirty() : !pSDEUIAction.isUIActionParam11Dirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getUIActionParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UIActionParam11_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam12(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam12Dirty() : !pSDEUIAction.isUIActionParam12Dirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getUIActionParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UIActionParam12_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam2(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam2Dirty() : !pSDEUIAction.isUIActionParam2Dirty()) {
            return null;
        }
        String string = pSDEUIAction.getUIActionParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionParam2_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam3(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam3Dirty() : !pSDEUIAction.isUIActionParam3Dirty()) {
            return null;
        }
        String string = pSDEUIAction.getUIActionParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionParam3_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam4(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam4Dirty() : !pSDEUIAction.isUIActionParam4Dirty()) {
            return null;
        }
        String string = pSDEUIAction.getUIActionParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionParam4_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam5(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam5Dirty() : !pSDEUIAction.isUIActionParam5Dirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getUIActionParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UIActionParam5_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam6(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam6Dirty() : !pSDEUIAction.isUIActionParam6Dirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getUIActionParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UIActionParam6_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam7(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam7Dirty() : !pSDEUIAction.isUIActionParam7Dirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getUIActionParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UIActionParam7_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam8(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam8Dirty() : !pSDEUIAction.isUIActionParam8Dirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getUIActionParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UIActionParam8_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParam9(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParam9Dirty() : !pSDEUIAction.isUIActionParam9Dirty()) {
            return null;
        }
        Double d = pSDEUIAction.getUIActionParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UIActionParam9_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionParams(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionParamsDirty() : !pSDEUIAction.isUIActionParamsDirty()) {
            return null;
        }
        String string = pSDEUIAction.getUIActionParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionParams_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UIActionType(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUIActionTypeDirty() && !bl2 : !pSDEUIAction.isUIActionTypeDirty()) {
            return null;
        }
        String string = pSDEUIAction.getUIActionType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_UIActionType_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UIACTIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUserCatDirty() : !pSDEUIAction.isUserCatDirty()) {
            return null;
        }
        String string = pSDEUIAction.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSDEUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserConfirm(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUserConfirmDirty() : !pSDEUIAction.isUserConfirmDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getUserConfirm();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_UserConfirm_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERCONFIRM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUserParamsDirty() : !pSDEUIAction.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEUIAction.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUserTagDirty() : !pSDEUIAction.isUserTagDirty()) {
            return null;
        }
        String string = pSDEUIAction.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUserTag2Dirty() : !pSDEUIAction.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEUIAction.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUserTag3Dirty() : !pSDEUIAction.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEUIAction.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSDEUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isUserTag4Dirty() : !pSDEUIAction.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEUIAction.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSDEUIAction, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewActions(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isViewActionsDirty() : !pSDEUIAction.isViewActionsDirty()) {
            return null;
        }
        Integer n = pSDEUIAction.getViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewActions_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWACTIONS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ViewLogicType(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isViewLogicTypeDirty() : !pSDEUIAction.isViewLogicTypeDirty()) {
            return null;
        }
        String string = pSDEUIAction.getViewLogicType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewLogicType_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWLOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VisibleLogic(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isVisibleLogicDirty() : !pSDEUIAction.isVisibleLogicDirty()) {
            return null;
        }
        String string = pSDEUIAction.getVisibleLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VisibleLogic_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VISIBLELOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VLExecMode(boolean bl, PSDEUIAction pSDEUIAction, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEUIAction.isVLExecModeDirty() : !pSDEUIAction.isVLExecModeDirty()) {
            return null;
        }
        String string = pSDEUIAction.getVLExecMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VLExecMode_Default((IEntity)pSDEUIAction, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VLEXECMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEUIAction, bl);
    }

    protected void onSyncIndexEntities(PSDEUIAction pSDEUIAction, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEUIAction, bl);
    }

    public Object getDataContextValue(PSDEUIAction pSDEUIAction, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEUIAction, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEUIAction.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSystem pSSystem = pSDEUIAction.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEUIAction pSDEUIAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEUIAction, arrayList, n);
        this.onExportMajorModel_CMPSLanRes(pSDEUIAction, arrayList, n);
        this.onExportMajorModel_SMPSLanRes(pSDEUIAction, arrayList, n);
        this.onExportMajorModel_TipPSLanRes(pSDEUIAction, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEUIAction, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEUIAction pSDEUIAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEUIAction.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEUIAction.getCapPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_CMPSLanRes(PSDEUIAction pSDEUIAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEUIAction.getCMPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEUIAction.getCMPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_SMPSLanRes(PSDEUIAction pSDEUIAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEUIAction.getSMPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEUIAction.getSMPSLanRes(), arrayList, n);
        }
    }

    protected void onExportMajorModel_TipPSLanRes(PSDEUIAction pSDEUIAction, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEUIAction.getTipPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEUIAction.getTipPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIONLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionLevel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ACTIONTARGET", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActionTarget_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUTTONSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ButtonStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CapPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Caption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CLOSEEDITVIEW", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CloseEditView_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CMPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CMPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CMPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CMPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT2", (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default2(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONFIRMINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConfirmInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLERTMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableRTModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FRONTPROTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FrontProType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GLOBALFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GlobalFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLPAGEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlPageUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTPSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"NEXTPSDEUIACTION", (boolean)true) == 0) {
            return this.onTestValueRule_NextPSDEUIActionId_NextPSDEUIAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTPSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextPSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NEXTPSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NextPSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEDATAEXPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEDataExpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEDATAEXPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEDataExpName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOPRIVDM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoPrivDM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PARAMITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ParamItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PDTVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PDTViewFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEACModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEACModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEACTION", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_PSDEAction(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAEXPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataExpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAIMPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataImpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAIMPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataImpName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPRINTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEPrintId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPRINTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEPrintName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPDTVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPDTViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPDTVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPDTViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSREQITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysReqItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPLINKID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPLINKNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFLinkName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFPROCESSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFProcessName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RELOADDATA", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReloadData_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPPSSYSUIACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RepPSSysUIActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REPPSSYSUIACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RepPSSysUIActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SMPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SMPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SMPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SMPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUCCESSINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SuccessInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSITEMOBJ", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysItemObj_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEXTITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TextItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIMEOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Timeout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UATAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UATag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UATAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UATag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UATAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UATag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UATAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UATag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UIACTIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UIActionType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERCONFIRM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserConfirm_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWLOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewLogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VISIBLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VisibleLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VLEXECMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VLExecMode_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActionLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ActionTarget_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIONTARGET", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ButtonStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BUTTONSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CapPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Caption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CloseEditView_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CMPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CMPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CMPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CMPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CodeName_Default2(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldSimpleRule("PSDEID", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldQueryCountRule2("CODENAME", "DECodeNameCnt", iEntity, bl2, 0, true, 0, true, "\u5f53\u524d\u5b9e\u4f53\u4e2d\u5df2\u5305\u542b\u5f53\u524d\u4ee3\u7801\u540d\u79f0\u7684\u754c\u9762\u884c\u4e3a", true, true)) {
                return null;
            }
            return "\u5f53\u524d\u5b9e\u4f53\u4e2d\u5df2\u5305\u542b\u5f53\u524d\u4ee3\u7801\u540d\u79f0\u7684\u754c\u9762\u884c\u4e3a";
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

    protected String onTestValueRule_ConfirmInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONFIRMINFO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COUNTERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_CustomCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCODE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAITEM", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("DATAITEM", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ENABLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableRTModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FrontProType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FRONTPROTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GlobalFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HtmlPageUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTMLPAGEURL", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOBPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NextPSDEUIActionId_NextPSDEUIAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldSimpleRule("NEXTPSDEUIACTIONID", iEntity, bl2, "NOTEQ", "ENTITYFIELD", "PSDEUIACTIONID", "\u540e\u7eed\u754c\u9762\u884c\u4e3a\u4e0d\u80fd\u6307\u5411\u81ea\u5df1", false) && this.checkFieldDataSetRule("NEXTPSDEUIACTIONID", "PSDEUIACTION", DATASET_SYSANDDERANGE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u540e\u7eed\u754c\u9762\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NextPSDEUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTPSDEUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NextPSDEUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NEXTPSDEUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEDataExpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEDATAEXPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEDataExpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEDATAEXPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NoPrivDM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ParamItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PARAMITEM", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false) && this.checkFieldRegExRule("PARAMITEM", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PDTViewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEACModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEACModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACMODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionId_PSDEAction(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEACTIONID", "PSDEACTION", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u884c\u4e3a\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataExpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAEXPID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataImpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAIMPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataImpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAIMPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEOPPrivName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEOPPRIVNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEPrintId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPRINTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEPrintName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPRINTNAME", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSModuleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSMODULENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCounterName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCOUNTERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDynaModelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDYNAMODELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysImageName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSIMAGENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPDTViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPDTVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPDTViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPDTVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysReqItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSREQITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSystemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewLogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWLOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewLogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWLOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPLINKID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFLinkName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPLINKNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFProcessName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFPROCESSNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSWFVersionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSWFVERSIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReloadData_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RepPSSysUIActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REPPSSYSUIACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RepPSSysUIActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REPPSSYSUIACTIONNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SMPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SMPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SMPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SMPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SuccessInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUCCESSINFO", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysItemObj_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SYSITEMOBJ", iEntity, bl2, null, false, 250, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[250]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TextItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TEXTITEM", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("TEXTITEM", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Timeout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TipPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TipPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TIPPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToDoTask_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TODOTASK", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TooltipInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLTIPINFO", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UATag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UATAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UATag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UATAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UATag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UATAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UATag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UATAG4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionCode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONCODE", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UIActionParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UIActionParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UIActionParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UIActionParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UIActionParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UIActionParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UIActionParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UIActionParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UIActionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UIACTIONTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_UserConfirm_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_UserParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPARAMS", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
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

    protected String onTestValueRule_ViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ViewLogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWLOGICTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VisibleLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VISIBLELOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VLExecMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VLEXECMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEUIAction pSDEUIAction) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEUIAction)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEUIAction pSDEUIAction) throws Exception {
        IService iService;
        Object object = pSDEUIAction.get("PSDEID");
        if (object != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEUIACTION_PSDATAENTITY_PSDEID", object);
        }
        if ((object = pSDEUIAction.get("PSWFVERSIONID")) != null) {
            iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEUIACTION_PSWFVERSION_PSWFVERSIONID", object);
        }
        super.onUpdateParent((IEntity)pSDEUIAction);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEUIAction pSDEUIAction, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEUIACTION");
        if (!bl) {
            pSDEUIAction.setCreateDate(null);
            pSDEUIAction.setCreateMan(null);
            pSDEUIAction.setPSDEUIActionId(null);
            pSDEUIAction.setPSWFId(null);
            pSDEUIAction.setPSWFName(null);
            pSDEUIAction.setPSWFLinkName(null);
            pSDEUIAction.setPSWFProcessName(null);
            pSDEUIAction.setPSWFVersionId(null);
            pSDEUIAction.setPSWFVersionName(null);
            pSDEUIAction.setUpdateDate(null);
            pSDEUIAction.setUpdateMan(null);
            super.exportCurXmlModel(pSDEUIAction, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEUIAction pSDEUIAction, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEUIAction, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWFVERSION#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSMODULE#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSTEM#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUIACTION_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUIACTION_PSWFVERSION_PSWFVERSIONID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUIACTION_PSWORKFLOW_PSWFID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUIACTION_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEUIACTION_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFVERSIONNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULENAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSION", (boolean)true) == 0) {
            iEntity.set("PSWFVERSIONID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSWORKFLOW", (boolean)true) == 0) {
            iEntity.set("PSWFID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSMODULE", (boolean)true) == 0) {
            iEntity.set("PSMODULEID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID", "PSWFVERSIONID", "PSWFID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSDEUIAction pSDEUIAction) {
        if (!StringHelper.isNullOrEmpty((String)pSDEUIAction.getRepPSSysUIActionId())) {
            return pSDEUIAction.getRepPSSysUIActionId();
        }
        return super.getModelV2Tag(pSDEUIAction);
    }

    @Override
    public boolean setModelV2Tag(PSDEUIAction pSDEUIAction, String string) {
        return super.setModelV2Tag(pSDEUIAction, string);
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("REPPSSYSUIACTIONID", "");
        map.put("PSDEID", "");
        map.put("PSWFVERSIONID", "");
        map.put("PSWFID", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEUIAction pSDEUIAction, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEUIAction.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEUIAction, true);
        pSDEUIAction.set("REPPSSYSUIACTIONID", string);
        if (this.select(pSDEUIAction, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEUIAction, true);
        return super.getModelV2Entity(pSDEUIAction, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEUIAction pSDEUIAction, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEUIAction, objectNode, string, string2, n);
    }
}

