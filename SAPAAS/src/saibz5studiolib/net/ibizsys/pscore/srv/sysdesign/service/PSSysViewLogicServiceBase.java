/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.databind.JsonNode
 *  com.fasterxml.jackson.databind.node.ArrayNode
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
 *  net.ibizsys.paas.db.SqlParamList
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
 *  net.ibizsys.paas.service.SessionFactoryManager
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import net.ibizsys.paas.db.SqlParamList;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewLogicServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.entity.PSViewLogicTypeBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardLogicServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewLogicDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewLogicDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewLogicParam;
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
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewLogicServiceBase
extends PSCoreSysServiceBase<PSSysViewLogic> {
    private static final Log log = LogFactory.getLog(PSSysViewLogicServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_JITPREVIEW = "JITPREVIEW";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSSysViewLogicDEModel pSSysViewLogicDEModel;
    private PSSysViewLogicDAO pSSysViewLogicDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysViewLogicService";
    }

    public PSSysViewLogicDEModel getPSSysViewLogicDEModel() {
        if (this.pSSysViewLogicDEModel == null) {
            try {
                this.pSSysViewLogicDEModel = (PSSysViewLogicDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewLogicDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewLogicDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysViewLogicDEModel();
    }

    public PSSysViewLogicDAO getPSSysViewLogicDAO() {
        if (this.pSSysViewLogicDAO == null) {
            try {
                this.pSSysViewLogicDAO = (PSSysViewLogicDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewLogicDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewLogicDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysViewLogicDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchTempCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSSysViewLogic)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSSysViewLogic)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSSysViewLogic)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSSysViewLogic)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW, (boolean)true) == 0) {
            this.jITPreview((PSSysViewLogic)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSSysViewLogic)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurApp(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPP, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSys(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYS, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDefault(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DEFAULT, true);
        return dBFetchResult;
    }

    public void createWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSSysViewLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewLogic, ACTION_CREATEWITHMODEL);
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewLogicServiceBase.this.getService(), PSSysViewLogicServiceBase.ACTION_CREATEWITHMODEL, 40, pSSysViewLogic2, null).getResult() != 1) {
                    PSSysViewLogicServiceBase.this.onCreateWithModel(pSSysViewLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSSysViewLogic, null);
        }
    }

    protected void onCreateWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, pSSysViewLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewLogic, ACTION_GETDRAFTFROMWITHMODEL);
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewLogicServiceBase.this.getService(), PSSysViewLogicServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, pSSysViewLogic2, null).getResult() != 1) {
                    PSSysViewLogicServiceBase.this.onGetDraftFromWithModel(pSSysViewLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, pSSysViewLogic, null);
        }
    }

    protected void onGetDraftFromWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, pSSysViewLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewLogic, ACTION_GETDRAFTWITHMODEL);
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewLogicServiceBase.this.getService(), PSSysViewLogicServiceBase.ACTION_GETDRAFTWITHMODEL, 40, pSSysViewLogic2, null).getResult() != 1) {
                    PSSysViewLogicServiceBase.this.onGetDraftWithModel(pSSysViewLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, pSSysViewLogic, null);
        }
    }

    protected void onGetDraftWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSSysViewLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewLogic, ACTION_GETWITHMODEL);
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewLogicServiceBase.this.getService(), PSSysViewLogicServiceBase.ACTION_GETWITHMODEL, 40, pSSysViewLogic2, null).getResult() != 1) {
                    PSSysViewLogicServiceBase.this.onGetWithModel(pSSysViewLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSSysViewLogic, null);
        }
    }

    protected void onGetWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void jITPreview(PSSysViewLogic pSSysViewLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 0, pSSysViewLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewLogic, ACTION_JITPREVIEW);
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewLogicServiceBase.this.getService(), PSSysViewLogicServiceBase.ACTION_JITPREVIEW, 40, pSSysViewLogic2, null).getResult() != 1) {
                    PSSysViewLogicServiceBase.this.onJITPreview(pSSysViewLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 99, pSSysViewLogic, null);
        }
    }

    protected void onJITPreview(PSSysViewLogic pSSysViewLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW]");
    }

    public void updateWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSSysViewLogic, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysViewLogic, ACTION_UPDATEWITHMODEL);
        final PSSysViewLogic pSSysViewLogic2 = pSSysViewLogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewLogicServiceBase.this.getService(), PSSysViewLogicServiceBase.ACTION_UPDATEWITHMODEL, 40, pSSysViewLogic2, null).getResult() != 1) {
                    PSSysViewLogicServiceBase.this.onUpdateWithModel(pSSysViewLogic2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSSysViewLogic, null);
        }
    }

    protected void onUpdateWithModel(PSSysViewLogic pSSysViewLogic) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSSysViewLogic pSSysViewLogic, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWLOGIC_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysViewLogic, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWLOGIC_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDELogic);
            } else {
                iService.get(pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSSysViewLogic, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWLOGIC_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysViewLogic, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWLOGIC_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSysViewLogic, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWLOGIC_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysDynaModel);
            } else {
                iService.get(pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysViewLogic, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysViewLogic, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWLOGIC_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysReqItem);
            } else {
                iService.get(pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSSysViewLogic, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWLOGIC_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysViewLogic, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWLOGIC_PSVIEWLOGICTYPE_PSVIEWLOGICTYPEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService", (SessionFactory)this.getSessionFactory());
            PSViewLogicType pSViewLogicType = (PSViewLogicType)iService.getDEModel().createEntity();
            pSViewLogicType.set("PSVIEWLOGICTYPEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewLogicType);
            } else {
                iService.get(pSViewLogicType);
            }
            this.onFillParentInfo_PSViewLogicType(pSSysViewLogic, pSViewLogicType);
            return;
        }
        super.onFillParentInfo(pSSysViewLogic, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSSysViewLogic pSSysViewLogic, PSDataEntity pSDataEntity) throws Exception {
        pSSysViewLogic.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysViewLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDELogic(PSSysViewLogic pSSysViewLogic, PSDELogic pSDELogic) throws Exception {
        pSSysViewLogic.setLogicPSDEId(pSDELogic.getPSDEId());
        pSSysViewLogic.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysViewLogic.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSModule(PSSysViewLogic pSSysViewLogic, PSModule pSModule) throws Exception {
        pSSysViewLogic.setPSModuleId(pSModule.getPSModuleId());
        pSSysViewLogic.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysApp(PSSysViewLogic pSSysViewLogic, PSSysApp pSSysApp) throws Exception {
        pSSysViewLogic.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSysViewLogic.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysViewLogic pSSysViewLogic, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysViewLogic.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysViewLogic.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysViewLogic pSSysViewLogic, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysViewLogic.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysViewLogic.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSSysViewLogic pSSysViewLogic, PSSysReqItem pSSysReqItem) throws Exception {
        pSSysViewLogic.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSSysViewLogic.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSystem(PSSysViewLogic pSSysViewLogic, PSSystem pSSystem) throws Exception {
        pSSysViewLogic.setPSSystemId(pSSystem.getPSSystemId());
        pSSysViewLogic.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSViewLogicType(PSSysViewLogic pSSysViewLogic, PSViewLogicType pSViewLogicType) throws Exception {
        pSSysViewLogic.setPSViewLogicTypeId(pSViewLogicType.getPSViewLogicTypeId());
        pSSysViewLogic.setPSViewLogicTypeName(pSViewLogicType.getPSViewLogicTypeName());
    }

    protected void onFillEntityFullInfo(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
        if (bl) {
            // empty if block
        }
        super.onFillEntityFullInfo(pSSysViewLogic, bl);
        this.onFillEntityFullInfo_PSDE(pSSysViewLogic, bl);
        this.onFillEntityFullInfo_PSDELogic(pSSysViewLogic, bl);
        this.onFillEntityFullInfo_PSModule(pSSysViewLogic, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSysViewLogic, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysViewLogic, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysViewLogic, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSSysViewLogic, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysViewLogic, bl);
        this.onFillEntityFullInfo_PSViewLogicType(pSSysViewLogic, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
        if (pSSysViewLogic.isPSDEIdDirty()) {
            if (pSSysViewLogic.getPSDEId() != null) {
                if (pSSysViewLogic.getPSDEId() == null || pSSysViewLogic.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysViewLogic.getPSDE();
                    pSSysViewLogic.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysViewLogic.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDELogic(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
        if (pSSysViewLogic.isPSSystemIdDirty()) {
            if (pSSysViewLogic.getPSSystemId() != null) {
                if (pSSysViewLogic.getPSSystemId() == null || pSSysViewLogic.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysViewLogic.getPSSystem();
                    pSSysViewLogic.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysViewLogic.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSViewLogicType(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
        if (pSSysViewLogic.isPSViewLogicTypeIdDirty()) {
            if (pSSysViewLogic.getPSViewLogicTypeId() != null) {
                if (pSSysViewLogic.getPSViewLogicTypeId() == null || pSSysViewLogic.getPSViewLogicTypeName() == null) {
                    PSViewLogicType pSViewLogicType = pSSysViewLogic.getPSViewLogicType();
                    pSSysViewLogic.setPSViewLogicTypeName(pSViewLogicType.getPSViewLogicTypeName());
                }
            } else {
                pSSysViewLogic.setPSViewLogicTypeName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysViewLogic, bl);
    }

    public ArrayList<PSSysViewLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewLogic> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewLogic> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSAPPID", (Object)pSSysAppBase.getPSSysAppId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysAppCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysAppCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewLogic> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewLogic> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewLogic> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewLogic> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase) throws Exception {
        return this.selectByPSViewLogicType(pSViewLogicTypeBase, "", -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase, String string) throws Exception {
        return this.selectByPSViewLogicType(pSViewLogicTypeBase, string, -1);
    }

    public ArrayList<PSSysViewLogic> selectByPSViewLogicType(PSViewLogicTypeBase pSViewLogicTypeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWLOGICTYPEID", (Object)pSViewLogicTypeBase.getPSViewLogicTypeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewLogicTypeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewLogicTypeCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWLOGIC_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSVIEWLOGIC", iDataEntityModel.getDataInfo(pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            PSSysViewLogic pSSysViewLogic2 = (PSSysViewLogic)this.getDEModel().createEntity();
            pSSysViewLogic2.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
            pSSysViewLogic2.setPSDEId(null);
            this.update(pSSysViewLogic2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysViewLogicServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysViewLogicServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            this.remove(pSSysViewLogic);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWLOGIC_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSSYSVIEWLOGIC", iDataEntityModel.getDataInfo(pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            PSSysViewLogic pSSysViewLogic2 = (PSSysViewLogic)this.getDEModel().createEntity();
            pSSysViewLogic2.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
            pSSysViewLogic2.setPSDELogicId(null);
            this.update(pSSysViewLogic2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSSysViewLogicServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSSysViewLogicServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            this.remove(pSSysViewLogic);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWLOGIC_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSVIEWLOGIC", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSModule(pSModule);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            PSSysViewLogic pSSysViewLogic2 = (PSSysViewLogic)this.getDEModel().createEntity();
            pSSysViewLogic2.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
            pSSysViewLogic2.setPSModuleId(null);
            this.update(pSSysViewLogic2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysViewLogicServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysViewLogicServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            this.remove(pSSysViewLogic);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            PSSysViewLogic pSSysViewLogic2 = (PSSysViewLogic)this.getDEModel().createEntity();
            pSSysViewLogic2.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
            pSSysViewLogic2.setPSSysAppId(null);
            this.update(pSSysViewLogic2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSysViewLogicServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSysViewLogicServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            this.remove(pSSysViewLogic);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWLOGIC_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSVIEWLOGIC", iDataEntityModel.getDataInfo(pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            PSSysViewLogic pSSysViewLogic2 = (PSSysViewLogic)this.getDEModel().createEntity();
            pSSysViewLogic2.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
            pSSysViewLogic2.setPSSysDynaModelId(null);
            this.update(pSSysViewLogic2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysViewLogicServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysViewLogicServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            this.remove(pSSysViewLogic);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWLOGIC_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSVIEWLOGIC", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            PSSysViewLogic pSSysViewLogic2 = (PSSysViewLogic)this.getDEModel().createEntity();
            pSSysViewLogic2.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
            pSSysViewLogic2.setPSSysPFPluginId(null);
            this.update(pSSysViewLogic2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysViewLogicServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysViewLogicServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            this.remove(pSSysViewLogic);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWLOGIC_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSSYSVIEWLOGIC", iDataEntityModel.getDataInfo(pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            PSSysViewLogic pSSysViewLogic2 = (PSSysViewLogic)this.getDEModel().createEntity();
            pSSysViewLogic2.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
            pSSysViewLogic2.setPSSysReqItemId(null);
            this.update(pSSysViewLogic2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysViewLogicServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSSysViewLogicServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            this.remove(pSSysViewLogic);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            PSSysViewLogic pSSysViewLogic2 = (PSSysViewLogic)this.getDEModel().createEntity();
            pSSysViewLogic2.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
            pSSysViewLogic2.setPSSystemId(null);
            this.update(pSSysViewLogic2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysViewLogicServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysViewLogicServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            this.remove(pSSysViewLogic);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    public void testRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSViewLogicType(pSViewLogicType, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWLOGICTYPE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewLogicType);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWLOGIC_PSVIEWLOGICTYPE_PSVIEWLOGICTYPEID", "", iDataEntityModel.getName(), "PSSYSVIEWLOGIC", iDataEntityModel.getDataInfo(pSViewLogicType), arrayList.get(0)));
        }
    }

    public void resetPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSViewLogicType(pSViewLogicType);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            PSSysViewLogic pSSysViewLogic2 = (PSSysViewLogic)this.getDEModel().createEntity();
            pSSysViewLogic2.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
            pSSysViewLogic2.setPSViewLogicTypeId(null);
            this.update(pSSysViewLogic2);
        }
    }

    public void removeByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        final PSViewLogicType pSViewLogicType2 = pSViewLogicType;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewLogicServiceBase.this.onBeforeRemoveByPSViewLogicType(pSViewLogicType2);
                PSSysViewLogicServiceBase.this.internalRemoveByPSViewLogicType(pSViewLogicType2);
                PSSysViewLogicServiceBase.this.onAfterRemoveByPSViewLogicType(pSViewLogicType2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    protected void internalRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
        ArrayList<PSSysViewLogic> arrayList = this.selectByPSViewLogicType(pSViewLogicType);
        this.onBeforeRemoveByPSViewLogicType(pSViewLogicType, arrayList);
        for (PSSysViewLogic pSSysViewLogic : arrayList) {
            this.remove(pSSysViewLogic);
        }
        this.onAfterRemoveByPSViewLogicType(pSViewLogicType, arrayList);
    }

    protected void onAfterRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType) throws Exception {
    }

    protected void onBeforeRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewLogicType(PSViewLogicType pSViewLogicType, ArrayList<PSSysViewLogic> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysViewLogic pSSysViewLogic) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppLogicService)ServiceGlobal.getService(PSAppLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSAppViewLogicService)ServiceGlobal.getService(PSAppViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlLogicGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSDEWizardLogicService)ServiceGlobal.getService(PSDEWizardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSSysDashboardLogicService)ServiceGlobal.getService(PSSysDashboardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSSysMapLogicService)ServiceGlobal.getService(PSSysMapLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewLogicParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        ((PSSysViewLogicParamServiceBase)pSCoreSysServiceBase).removeByPSSysViewLogic(pSSysViewLogic);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewLogic(pSSysViewLogic);
        super.onBeforeRemove(pSSysViewLogic);
    }

    protected void onBeforeRemoveTemp(PSSysViewLogic pSSysViewLogic) throws Exception {
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        pSSysViewLogicParamService.removeTempByPSSysViewLogic(pSSysViewLogic);
        super.onBeforeRemoveTemp(pSSysViewLogic);
    }

    protected void getRelatedDataTempMajor(PSSysViewLogic pSSysViewLogic) throws Exception {
        this.getRelatedDataTempMajor_PSSysViewLogicParam(pSSysViewLogic);
        super.getRelatedDataTempMajor(pSSysViewLogic);
    }

    protected void getRelatedDataTempMajor_PSSysViewLogicParam(PSSysViewLogic pSSysViewLogic) throws Exception {
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewLogicParam> arrayList = null;
        String string = pSSysViewLogic.getPSSysViewLogicId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysViewLogicParamService.selectByPSSysViewLogic(pSSysViewLogic) : pSSysViewLogicParamService.selectTempByPSSysViewLogic(pSSysViewLogic);
        for (PSSysViewLogicParam pSSysViewLogicParam : arrayList) {
            pSSysViewLogicParamService.getTempMajor(pSSysViewLogicParam);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysViewLogic pSSysViewLogic, PSSysViewLogic pSSysViewLogic2) throws Exception {
        ArrayList<PSSysViewLogicParam> arrayList = this.updateRelatedDataTempMajor_removePSSysViewLogicParam(pSSysViewLogic, pSSysViewLogic2);
        this.updateRelatedDataTempMajor_updatePSSysViewLogicParam(pSSysViewLogic, pSSysViewLogic2, arrayList);
        super.updateRelatedDataTempMajor(pSSysViewLogic, pSSysViewLogic2);
    }

    protected ArrayList<PSSysViewLogicParam> updateRelatedDataTempMajor_removePSSysViewLogicParam(PSSysViewLogic pSSysViewLogic, PSSysViewLogic pSSysViewLogic2) throws Exception {
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewLogicParam> arrayList = pSSysViewLogicParamService.selectTempByPSSysViewLogic(pSSysViewLogic);
        ArrayList<PSSysViewLogicParam> arrayList2 = pSSysViewLogicParamService.selectByPSSysViewLogic(pSSysViewLogic2);
        HashMap<String, PSSysViewLogicParam> hashMap = new HashMap<String, PSSysViewLogicParam>();
        for (PSSysViewLogicParam pSSysViewLogicParam : arrayList2) {
            hashMap.put(pSSysViewLogicParam.getPSSysViewLogicParamId(), pSSysViewLogicParam);
        }
        for (PSSysViewLogicParam pSSysViewLogicParam : arrayList) {
            Object object = pSSysViewLogicParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysViewLogicParam pSSysViewLogicParam : hashMap.values()) {
            pSSysViewLogicParamService.remove(pSSysViewLogicParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysViewLogicParam(PSSysViewLogic pSSysViewLogic, PSSysViewLogic pSSysViewLogic2, ArrayList<PSSysViewLogicParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysViewLogicParam pSSysViewLogicParam : arrayList) {
            pSSysViewLogicParamService.updateTempMajor(pSSysViewLogicParam);
        }
    }

    protected void replaceParentInfo(PSSysViewLogic pSSysViewLogic, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysViewLogic, cloneSession);
        if (pSSysViewLogic.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysViewLogic.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysViewLogic, (PSDataEntity)iEntity);
        }
        if (pSSysViewLogic.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysViewLogic.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSSysViewLogic, (PSDELogic)iEntity);
        }
        if (pSSysViewLogic.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysViewLogic.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysViewLogic, (PSModule)iEntity);
        }
        if (pSSysViewLogic.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysViewLogic.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSysViewLogic, (PSSysApp)iEntity);
        }
        if (pSSysViewLogic.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysViewLogic.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysViewLogic, (PSSysDynaModel)iEntity);
        }
        if (pSSysViewLogic.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysViewLogic.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysViewLogic, (PSSysPFPlugin)iEntity);
        }
        if (pSSysViewLogic.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSSysViewLogic.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSSysViewLogic, (PSSysReqItem)iEntity);
        }
        if (pSSysViewLogic.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysViewLogic.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysViewLogic, (PSSystem)iEntity);
        }
        if (pSSysViewLogic.getPSViewLogicTypeId() != null && (iEntity = cloneSession.getEntity("PSVIEWLOGICTYPE", (Object)pSSysViewLogic.getPSViewLogicTypeId())) != null) {
            this.onFillParentInfo_PSViewLogicType(pSSysViewLogic, (PSViewLogicType)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysViewLogic, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSSysViewLogic, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomStyle(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicModel(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicType(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewLogicName(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeId(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewLogicTypeName(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysAppFlag(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysViewLogic, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysViewLogic, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isCodeNameDirty() : !pSSysViewLogic.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
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
                string3 = "PSMODULEID";
                String string4 = this.checkFieldDupRule(this.getPSSysViewLogicDEModel(), "CODENAME", string3, pSSysViewLogic, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("CODENAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomStyle(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isCustomStyleDirty() : !pSSysViewLogic.isCustomStyleDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getCustomStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomStyle_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicModel(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isLogicModelDirty() : !pSSysViewLogic.isLogicModelDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getLogicModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicModel_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicType(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isLogicTypeDirty() : !pSSysViewLogic.isLogicTypeDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getLogicType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicType_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOGICTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isMemoDirty() : !pSSysViewLogic.isMemoDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSDEIdDirty() : !pSSysViewLogic.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSDELogicIdDirty() : !pSSysViewLogic.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSDENameDirty() : !pSSysViewLogic.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSModuleIdDirty() : !pSSysViewLogic.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSSysAppIdDirty() : !pSSysViewLogic.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSSysDynaModelIdDirty() : !pSSysViewLogic.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSSysPFPluginIdDirty() : !pSSysViewLogic.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSSysReqItemIdDirty() : !pSSysViewLogic.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSSystemIdDirty() && !bl2 : !pSSysViewLogic.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSSystemNameDirty() && !bl2 : !pSSysViewLogic.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewLogicId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSSysViewLogicIdDirty() && !bl2 : !pSSysViewLogic.isPSSysViewLogicIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSSysViewLogicId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWLOGICID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicId_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewLogicName(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSSysViewLogicNameDirty() && !bl2 : !pSSysViewLogic.isPSSysViewLogicNameDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSSysViewLogicName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWLOGICNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewLogicName_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWLOGICNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewLogicTypeId(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSViewLogicTypeIdDirty() : !pSSysViewLogic.isPSViewLogicTypeIdDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSViewLogicTypeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeId_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewLogicTypeName(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isPSViewLogicTypeNameDirty() : !pSSysViewLogic.isPSViewLogicTypeNameDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getPSViewLogicTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewLogicTypeName_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWLOGICTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysAppFlag(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isSysAppFlagDirty() : !pSSysViewLogic.isSysAppFlagDirty()) {
            return null;
        }
        Integer n = pSSysViewLogic.getSysAppFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysAppFlag_Default(pSSysViewLogic, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SYSAPPFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isUserCatDirty() : !pSSysViewLogic.isUserCatDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isUserTagDirty() : !pSSysViewLogic.isUserTagDirty()) {
            return null;
        }
        String string = pSSysViewLogic.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isUserTag2Dirty() : !pSSysViewLogic.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysViewLogic.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isUserTag3Dirty() : !pSSysViewLogic.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysViewLogic.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysViewLogic, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysViewLogic pSSysViewLogic, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewLogic.isUserTag4Dirty() : !pSSysViewLogic.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysViewLogic.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysViewLogic, bl2, bl3);
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

    protected void onSyncEntity(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
        super.onSyncEntity(pSSysViewLogic, bl);
    }

    protected void onSyncIndexEntities(PSSysViewLogic pSSysViewLogic, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysViewLogic, bl);
    }

    public Object getDataContextValue(PSSysViewLogic pSSysViewLogic, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysViewLogic, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysViewLogic pSSysViewLogic, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysViewLogic, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSAPPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysAppName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWLOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewLogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWLOGICTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewLogicTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSAPPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysAppFlag_Default(iEntity, bl, bl2);
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
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_CustomStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMSTYLE", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LogicType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysAppId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysAppName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSAPPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSViewLogicTypeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWLOGICTYPEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewLogicTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWLOGICTYPENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SysAppFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysViewLogic pSSysViewLogic) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysViewLogic)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysViewLogic pSSysViewLogic) throws Exception {
        super.onUpdateParent(pSSysViewLogic);
    }

    protected void onCopyDetails(PSSysViewLogic pSSysViewLogic, Object object) throws Exception {
        PSSysViewLogic pSSysViewLogic2 = new PSSysViewLogic();
        pSSysViewLogic2.set("PSSYSVIEWLOGICID", object);
        String string = DataObject.getStringValue((Object)pSSysViewLogic.get("PSSYSVIEWLOGICID"));
        super.onCopyDetails(pSSysViewLogic, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysViewLogic pSSysViewLogic, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSVIEWLOGIC");
        if (!bl) {
            pSSysViewLogic.setCreateDate(null);
            pSSysViewLogic.setCreateMan(null);
            pSSysViewLogic.setPSSysAppName(null);
            pSSysViewLogic.setPSSysViewLogicId(null);
            pSSysViewLogic.setUpdateDate(null);
            pSSysViewLogic.setUpdateMan(null);
            super.exportCurXmlModel(pSSysViewLogic, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysViewLogic pSSysViewLogic, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysViewLogicParam(pSSysViewLogic, xmlNode);
        super.onExportRelatedXmlModel(pSSysViewLogic, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysViewLogicParam(PSSysViewLogic pSSysViewLogic, XmlNode xmlNode) throws Exception {
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewLogicParam> arrayList = null;
        String string = pSSysViewLogic.getPSSysViewLogicId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysViewLogicParamService.selectByPSSysViewLogic(pSSysViewLogic, "ORDER BY ORDERVALUE ASC") : pSSysViewLogicParamService.selectTempByPSSysViewLogic(pSSysViewLogic, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSVIEWLOGICPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSSysViewLogicParam pSSysViewLogicParam : arrayList) {
                pSSysViewLogicParam.set("ORDERVALUE", null);
                pSSysViewLogicParamService.exportXmlModel(pSSysViewLogicParam, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysViewLogic pSSysViewLogic, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSVIEWLOGICPARAMS");
        this.importRelatedXmlModel_PSSysViewLogicParam(pSSysViewLogic, xmlNode2);
        super.onImportRelatedXmlModel(pSSysViewLogic, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysViewLogicParam(PSSysViewLogic pSSysViewLogic, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewLogic.getPSSysViewLogicId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysViewLogicParamService.removeByPSSysViewLogic(pSSysViewLogic);
        } else {
            pSSysViewLogicParamService.removeTempByPSSysViewLogic(pSSysViewLogic);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysViewLogicParam pSSysViewLogicParam = new PSSysViewLogicParam();
                pSSysViewLogicParam.setOrderValue(n);
                n += 100;
                pSSysViewLogicParamService.fillParentInfo(pSSysViewLogicParam, "DER1N", "DER1N_PSSYSVIEWLOGICPARAM_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", pSSysViewLogic.getPSSysViewLogicId());
                pSSysViewLogicParamService.importXmlModel(pSSysViewLogicParam, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysViewLogic pSSysViewLogic, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysViewLogic, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
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
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSVIEWLOGIC_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSVIEWLOGIC_PSSYSTEM_PSSYSTEMID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
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
        return new String[]{"PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSSysViewLogic pSSysViewLogic) {
        if (!StringHelper.isNullOrEmpty((String)pSSysViewLogic.getCodeName())) {
            return pSSysViewLogic.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysViewLogic.getCodeName())) {
            return pSSysViewLogic.getCodeName();
        }
        return super.getModelV2Tag(pSSysViewLogic);
    }

    @Override
    public boolean setModelV2Tag(PSSysViewLogic pSSysViewLogic, String string) {
        pSSysViewLogic.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysViewLogic pSSysViewLogic, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysViewLogic.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysViewLogic, true);
        pSSysViewLogic.set("CODENAME", string);
        if (this.select(pSSysViewLogic, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysViewLogic, true);
        return super.getModelV2Entity(pSSysViewLogic, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysViewLogic pSSysViewLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysViewLogic, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        return StringHelper.compare((String)"DER1N_PSSYSVIEWLOGICPARAM_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysViewLogic pSSysViewLogic, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysViewLogic, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysViewLogic pSSysViewLogic, ObjectNode objectNode, String string, boolean bl) throws Exception {
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSVIEWLOGICPARAM_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID")) {
            PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
            ArrayList<ObjectNode> paramNodes = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWLOGIC#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSVIEWLOGICPARAM", (Object)pSSysViewLogic.getPSSysViewLogicId()));
                if (file.exists()) {
                    paramNodes = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        paramNodes.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                paramNodes = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSSYSVIEWLOGIC#%1$s", (Object)pSSysViewLogic.getPSSysViewLogicId());
                for (PSSysViewLogicParam param : pSSysViewLogicParamService.selectByPSSysViewLogic(pSSysViewLogic)) {
                    String paramScope = pSSysViewLogicParamService.getModelV2ResScope(param);
                    if (StringHelper.compare(scope, paramScope, false) != 0) continue;
                    paramNodes.add(PSModelV2Helper.toJSONObject(param, false));
                }
            }
            if (paramNodes != null && paramNodes.size() > 0) {
                ArrayNode childNodes = objectNode.putArray(pSSysViewLogicParamService.getModelV2Name(false).toLowerCase());
                Collections.sort(paramNodes, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2 = 1000;
                        int n3 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n2 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n3 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n2 - n3) != 0) {
                            return n;
                        }
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("pssysviewlogicparamname")) {
                            string = objectNode.get("pssysviewlogicparamname").asText();
                        }
                        if (objectNode2.has("pssysviewlogicparamname")) {
                            string2 = objectNode2.get("pssysviewlogicparamname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode paramNode : paramNodes) {
                    PSSysViewLogicParam param = new PSSysViewLogicParam();
                    PSModelV2Helper.fromJSONObject(param, paramNode, false);
                    childNodes.add(pSSysViewLogicParamService.exportModelV2(param, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysViewLogic, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysViewLogic pSSysViewLogic) throws Exception {
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewLogicParam> arrayList = pSSysViewLogicParamService.selectByPSSysViewLogic(pSSysViewLogic);
        String string = StringHelper.format((String)"PSSYSVIEWLOGIC#%1$s", (Object)pSSysViewLogic.getPSSysViewLogicId());
        for (PSSysViewLogicParam pSSysViewLogicParam : arrayList) {
            String string2 = pSSysViewLogicParamService.getModelV2ResScope(pSSysViewLogicParam);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSSysViewLogicParamService.emptyModelV2(pSSysViewLogicParam);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSSysViewLogic.getPSSysViewLogicId());
        pSSysViewLogicParamService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSSysViewLogicParamService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSVIEWLOGICPARAM WHERE PSSYSVIEWLOGICID = ?", sqlParamList);
        super.onEmptyModelV2(pSSysViewLogic);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        if (pSSysViewLogicParamService.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysViewLogic pSSysViewLogic, String string, String string2) throws Exception {
        IEntity iEntity = null;
        PSSysViewLogicParam pSSysViewLogicParam = new PSSysViewLogicParam();
        pSSysViewLogicParam.set("PSSYSVIEWLOGICID", pSSysViewLogic.getPSSysViewLogicId());
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSSysViewLogicParamService.getModelV2Entity(pSSysViewLogicParam, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysViewLogic, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysViewLogic pSSysViewLogic, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSSysViewLogicParamService.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(i);
                PSSysViewLogicParam pSSysViewLogicParam = new PSSysViewLogicParam();
                pSSysViewLogicParam.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
                pSSysViewLogicParam.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
                pSSysViewLogicParamService.compileModelV2(pSSysViewLogicParam, objectNode2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string4);
            if (file.exists()) {
                File[] fileArray;
                for (File file2 : fileArray = file.listFiles()) {
                    if (!file2.isDirectory()) continue;
                    PSSysViewLogicParam pSSysViewLogicParam = new PSSysViewLogicParam();
                    pSSysViewLogicParam.setPSSysViewLogicId(pSSysViewLogic.getPSSysViewLogicId());
                    pSSysViewLogicParam.setPSSysViewLogicName(pSSysViewLogic.getPSSysViewLogicName());
                    pSSysViewLogicParamService.compileModelV2(pSSysViewLogicParam, null, string, file2.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysViewLogic, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysViewLogic pSSysViewLogic, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSVIEWLOGICPARAM_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysViewLogicParams(pSSysViewLogic, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysViewLogic, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysViewLogicParams(PSSysViewLogic pSSysViewLogic, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSVIEWLOGICPARAM", true), (boolean)false) == 0) {
            PSSysViewLogicParamService pSSysViewLogicParamService = (PSSysViewLogicParamService)ServiceGlobal.getService(PSSysViewLogicParamService.class, (SessionFactory)this.getSessionFactory());
            PSSysViewLogicParam pSSysViewLogicParam = new PSSysViewLogicParam();
            pSSysViewLogicParam.setPSSysViewLogicParamId(pSMOSFile.getPSModelId());
            if (!pSSysViewLogicParamService.get(pSSysViewLogicParam, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysViewLogicParam.getPSSysViewLogicId(), (String)pSSysViewLogic.getPSSysViewLogicId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysViewLogicParamService.exportModelV2(pSSysViewLogicParam);
            pSSysViewLogicParam.reset();
            if (!pSSysViewLogicParamService.setModelV2ResScope(pSSysViewLogicParam, "PSSYSVIEWLOGIC", pSSysViewLogic.getPSSysViewLogicId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysViewLogicParamService.importModelV2(pSSysViewLogicParam, objectNode);
            SessionFactoryManager.commit();
            return pSSysViewLogicParamService.getFile(pSSysViewLogicParam);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysViewLogic pSSysViewLogic, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysViewLogicParams(pSSysViewLogic, list);
        super.onFillPasteHelps(pSSysViewLogic, list);
    }

    protected void onFillPasteHelps_PSSysViewLogicParams(PSSysViewLogic pSSysViewLogic, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSVIEWLOGICPARAM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSVIEWLOGICPARAM_PSSYSVIEWLOGIC_PSSYSVIEWLOGICID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u7cfb\u7edf\u9884\u7f6e\u754c\u9762\u903b\u8f91]\u7684[\u7cfb\u7edf\u754c\u9762\u903b\u8f91\u53c2\u6570]");
        list.add(pSHelpSection);
    }
}
