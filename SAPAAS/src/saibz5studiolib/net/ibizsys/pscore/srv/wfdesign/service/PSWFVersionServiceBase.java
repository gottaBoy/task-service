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
 *  net.ibizsys.paas.db.ISelectField
 *  net.ibizsys.paas.db.SelectCond
 *  net.ibizsys.paas.db.SelectContext
 *  net.ibizsys.paas.db.SelectField
 *  net.ibizsys.paas.db.SqlParamList
 *  net.ibizsys.paas.demodel.DEModelGlobal
 *  net.ibizsys.paas.demodel.IDataEntityModel
 *  net.ibizsys.paas.entity.EntityBase
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
package net.ibizsys.pscore.srv.wfdesign.service;

import com.fasterxml.jackson.databind.JsonNode;
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
import net.ibizsys.paas.db.ISelectField;
import net.ibizsys.paas.db.SelectCond;
import net.ibizsys.paas.db.SelectContext;
import net.ibizsys.paas.db.SelectField;
import net.ibizsys.paas.db.SqlParamList;
import net.ibizsys.paas.demodel.DEModelGlobal;
import net.ibizsys.paas.demodel.IDataEntityModel;
import net.ibizsys.paas.entity.EntityBase;
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
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFVerService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppWFVerServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaInstBase;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVer;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaWFVerBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.ibizsys.pscore.srv.wfdesign.dao.PSWFVersionDAO;
import net.ibizsys.pscore.srv.wfdesign.demodel.PSWFVersionDEModel;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFMode;
import net.ibizsys.pscore.srv.wfdesign.entity.PSSysWFModeBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCond;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCondBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcRole;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcess;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFProcessBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIAction;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIActionBase;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflow;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWorkflowBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcRoleServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcSubWFServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFProcessServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFSubWFService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFSubWFServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionServiceBase;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVerLogService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVerLogServiceBase;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFVersionServiceBase
extends PSCoreSysServiceBase<PSWFVersion> {
    private static final Log log = LogFactory.getLog(PSWFVersionServiceBase.class);
    public static final String DATASET_CURINST = "CurInst";
    public static final String DATASET_CURWF = "CurWF";
    public static final String DATASET_CURWFPART = "CurWFPart";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CALCWFENGINETYPE = "CalcWFEngineType";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSWFVersionDEModel pSWFVersionDEModel;
    private PSWFVersionDAO pSWFVersionDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService";
    }

    public PSWFVersionDEModel getPSWFVersionDEModel() {
        if (this.pSWFVersionDEModel == null) {
            try {
                this.pSWFVersionDEModel = (PSWFVersionDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.wfdesign.demodel.PSWFVersionDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFVersionDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSWFVersionDEModel();
    }

    public PSWFVersionDAO getPSWFVersionDAO() {
        if (this.pSWFVersionDAO == null) {
            try {
                this.pSWFVersionDAO = (PSWFVersionDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.wfdesign.dao.PSWFVersionDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSWFVersionDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSWFVersionDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURINST, (boolean)true) == 0) {
            return this.fetchCurInst(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWF, (boolean)true) == 0) {
            return this.fetchCurWF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWFPART, (boolean)true) == 0) {
            return this.fetchCurWFPart(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURINST, (boolean)true) == 0) {
            return this.fetchTempCurInst(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWF, (boolean)true) == 0) {
            return this.fetchTempCurWF(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURWFPART, (boolean)true) == 0) {
            return this.fetchTempCurWFPart(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCWFENGINETYPE, (boolean)true) == 0) {
            this.calcWFEngineType((PSWFVersion)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSWFVersion)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSWFVersion)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSWFVersion)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSWFVersion)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSWFVersion)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurInst(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURINST, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurInst(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURINST, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurWF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWF, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurWF(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWF, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurWFPart(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWFPART, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurWFPart(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURWFPART, true);
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

    public void calcWFEngineType(PSWFVersion pSWFVersion) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCWFENGINETYPE, 0, (IEntity)pSWFVersion, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWFVersion, ACTION_CALCWFENGINETYPE);
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFVersionServiceBase.this.getService(), PSWFVersionServiceBase.ACTION_CALCWFENGINETYPE, 40, (IEntity)pSWFVersion2, null).getResult() != 1) {
                    PSWFVersionServiceBase.this.onCalcWFEngineType(pSWFVersion2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCWFENGINETYPE, 99, (IEntity)pSWFVersion, null);
        }
    }

    protected void onCalcWFEngineType(PSWFVersion pSWFVersion) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcWFEngineType]");
    }

    public void createWithModel(PSWFVersion pSWFVersion) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSWFVersion, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWFVersion, ACTION_CREATEWITHMODEL);
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFVersionServiceBase.this.getService(), PSWFVersionServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSWFVersion2, null).getResult() != 1) {
                    PSWFVersionServiceBase.this.onCreateWithModel(pSWFVersion2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSWFVersion, null);
        }
    }

    protected void onCreateWithModel(PSWFVersion pSWFVersion) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSWFVersion pSWFVersion) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSWFVersion, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWFVersion, ACTION_GETDRAFTFROMWITHMODEL);
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFVersionServiceBase.this.getService(), PSWFVersionServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSWFVersion2, null).getResult() != 1) {
                    PSWFVersionServiceBase.this.onGetDraftFromWithModel(pSWFVersion2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSWFVersion, null);
        }
    }

    protected void onGetDraftFromWithModel(PSWFVersion pSWFVersion) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSWFVersion pSWFVersion) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSWFVersion, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWFVersion, ACTION_GETDRAFTWITHMODEL);
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFVersionServiceBase.this.getService(), PSWFVersionServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSWFVersion2, null).getResult() != 1) {
                    PSWFVersionServiceBase.this.onGetDraftWithModel(pSWFVersion2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSWFVersion, null);
        }
    }

    protected void onGetDraftWithModel(PSWFVersion pSWFVersion) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSWFVersion pSWFVersion) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSWFVersion, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWFVersion, ACTION_GETWITHMODEL);
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFVersionServiceBase.this.getService(), PSWFVersionServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSWFVersion2, null).getResult() != 1) {
                    PSWFVersionServiceBase.this.onGetWithModel(pSWFVersion2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSWFVersion, null);
        }
    }

    protected void onGetWithModel(PSWFVersion pSWFVersion) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void updateWithModel(PSWFVersion pSWFVersion) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSWFVersion, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSWFVersion, ACTION_UPDATEWITHMODEL);
        final PSWFVersion pSWFVersion2 = pSWFVersion;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSWFVersionServiceBase.this.getService(), PSWFVersionServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSWFVersion2, null).getResult() != 1) {
                    PSWFVersionServiceBase.this.onUpdateWithModel(pSWFVersion2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSWFVersion, null);
        }
    }

    protected void onUpdateWithModel(PSWFVersion pSWFVersion) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSWFVersion pSWFVersion, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFVERSION_PSCODELIST_WFSTEPPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_WFStepPSCodeList(pSWFVersion, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFVERSION_PSDYNAINST_PSDYNAINSTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaInstService", (SessionFactory)this.getSessionFactory());
            PSDynaInst pSDynaInst = (PSDynaInst)iService.getDEModel().createEntity();
            pSDynaInst.set("PSDYNAINSTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaInst);
            } else {
                iService.get((IEntity)pSDynaInst);
            }
            this.onFillParentInfo_PSDynaInst(pSWFVersion, pSDynaInst);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFVERSION_PSDYNAWFVER_PSDYNAWFVERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaWFVerService", (SessionFactory)this.getSessionFactory());
            PSDynaWFVer pSDynaWFVer = (PSDynaWFVer)iService.getDEModel().createEntity();
            pSDynaWFVer.set("PSDYNAWFVERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDynaWFVer);
            } else {
                iService.get((IEntity)pSDynaWFVer);
            }
            this.onFillParentInfo_PSDynaWFVer(pSWFVersion, pSDynaWFVer);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFVERSION_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSWFVersion, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFVERSION_PSSYSWFMODE_PSSYSWFMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSSysWFModeService", (SessionFactory)this.getSessionFactory());
            PSSysWFMode pSSysWFMode = (PSSysWFMode)iService.getDEModel().createEntity();
            pSSysWFMode.set("PSSYSWFMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysWFMode);
            } else {
                iService.get((IEntity)pSSysWFMode);
            }
            this.onFillParentInfo_PSSysWFMode(pSWFVersion, pSSysWFMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            PSWorkflow pSWorkflow = (PSWorkflow)iService.getDEModel().createEntity();
            pSWorkflow.set("PSWORKFLOWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSWorkflow);
            } else {
                iService.get((IEntity)pSWorkflow);
            }
            this.onFillParentInfo_PSWF(pSWFVersion, pSWorkflow);
            return;
        }
        super.onFillParentInfo((IEntity)pSWFVersion, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_WFStepPSCodeList(PSWFVersion pSWFVersion, PSCodeList pSCodeList) throws Exception {
        pSWFVersion.setWFStepPSCodeListId(pSCodeList.getPSCodeListId());
        pSWFVersion.setWFStepPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSDynaInst(PSWFVersion pSWFVersion, PSDynaInst pSDynaInst) throws Exception {
        pSWFVersion.setPSDynaInstId(pSDynaInst.getPSDynaInstId());
        pSWFVersion.setPSDynaInstName(pSDynaInst.getPSDynaInstName());
    }

    protected void onFillParentInfo_PSDynaWFVer(PSWFVersion pSWFVersion, PSDynaWFVer pSDynaWFVer) throws Exception {
        pSWFVersion.setPSDynaWFVerId(pSDynaWFVer.getPSDynaWFVerId());
        pSWFVersion.setPSDynaWFVerName(pSDynaWFVer.getPSDynaWFVerName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSWFVersion pSWFVersion, PSSysReqItem pSSysReqItem) throws Exception {
        pSWFVersion.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSWFVersion.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_PSSysWFMode(PSWFVersion pSWFVersion, PSSysWFMode pSSysWFMode) throws Exception {
        pSWFVersion.setPSSysWFModeId(pSSysWFMode.getPSSysWFModeId());
        pSWFVersion.setPSSysWFModeName(pSSysWFMode.getPSSysWFModeName());
        pSWFVersion.setWFMode(pSSysWFMode.getWFMode());
    }

    protected void onFillParentInfo_PSWF(PSWFVersion pSWFVersion, PSWorkflow pSWorkflow) throws Exception {
        pSWFVersion.setPSSystemId(pSWorkflow.getPSSystemId());
        pSWFVersion.setPSWFId(pSWorkflow.getPSWorkflowId());
        pSWFVersion.setPSWFName(pSWorkflow.getPSWorkflowName());
        pSWFVersion.setWFEngineType(pSWorkflow.getWFEngineType());
    }

    protected void onFillEntityFullInfo(PSWFVersion pSWFVersion, boolean bl) throws Exception {
        if (bl) {
            if (pSWFVersion.getDynaSysRefMode() == null) {
                pSWFVersion.setDynaSysRefMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWFVersion.getEnable() == null) {
                pSWFVersion.setEnable((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSWFVersion.getPSDEUAGroupsCnt() == null) {
                pSWFVersion.setPSDEUAGroupsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWFVersion.getPSDEUIActionsCnt() == null) {
                pSWFVersion.setPSDEUIActionsCnt((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSWFVersion.getValidFlag() == null) {
                pSWFVersion.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSWFVersion, bl);
        this.onFillEntityFullInfo_WFStepPSCodeList(pSWFVersion, bl);
        this.onFillEntityFullInfo_PSDynaInst(pSWFVersion, bl);
        this.onFillEntityFullInfo_PSDynaWFVer(pSWFVersion, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSWFVersion, bl);
        this.onFillEntityFullInfo_PSSysWFMode(pSWFVersion, bl);
        this.onFillEntityFullInfo_PSWF(pSWFVersion, bl);
    }

    protected void onFillEntityFullInfo_WFStepPSCodeList(PSWFVersion pSWFVersion, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaInst(PSWFVersion pSWFVersion, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDynaWFVer(PSWFVersion pSWFVersion, boolean bl) throws Exception {
        if (pSWFVersion.isPSDynaWFVerIdDirty()) {
            if (pSWFVersion.getPSDynaWFVerId() != null) {
                if (pSWFVersion.getPSDynaWFVerId() == null || pSWFVersion.getPSDynaWFVerName() == null) {
                    PSDynaWFVer pSDynaWFVer = pSWFVersion.getPSDynaWFVer();
                    pSWFVersion.setPSDynaWFVerName(pSDynaWFVer.getPSDynaWFVerName());
                }
            } else {
                pSWFVersion.setPSDynaWFVerName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSWFVersion pSWFVersion, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysWFMode(PSWFVersion pSWFVersion, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSWF(PSWFVersion pSWFVersion, boolean bl) throws Exception {
        if (pSWFVersion.isPSWFIdDirty()) {
            if (pSWFVersion.getPSWFId() != null) {
                if (pSWFVersion.getPSWFId() == null || pSWFVersion.getPSWFName() == null) {
                    PSWorkflow pSWorkflow = pSWFVersion.getPSWF();
                    pSWFVersion.setPSSystemId(pSWorkflow.getPSSystemId());
                    pSWFVersion.setPSWFName(pSWorkflow.getPSWorkflowName());
                    pSWFVersion.setWFEngineType(pSWorkflow.getWFEngineType());
                }
            } else {
                pSWFVersion.setPSSystemId(null);
                pSWFVersion.setPSWFName(null);
                pSWFVersion.setWFEngineType(null);
            }
        }
    }

    protected void onWriteBackParent(PSWFVersion pSWFVersion, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSWFVersion, bl);
    }

    public ArrayList<PSWFVersion> selectByWFStepPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByWFStepPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSWFVersion> selectByWFStepPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByWFStepPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSWFVersion> selectByWFStepPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("WFSTEPPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByWFStepPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByWFStepPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFVersion> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, "", -1);
    }

    public ArrayList<PSWFVersion> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string) throws Exception {
        return this.selectByPSDynaInst(pSDynaInstBase, string, -1);
    }

    public ArrayList<PSWFVersion> selectByPSDynaInst(PSDynaInstBase pSDynaInstBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAINSTID", (Object)pSDynaInstBase.getPSDynaInstId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaInstCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaInstCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFVersion> selectByPSDynaWFVer(PSDynaWFVerBase pSDynaWFVerBase) throws Exception {
        return this.selectByPSDynaWFVer(pSDynaWFVerBase, "", -1);
    }

    public ArrayList<PSWFVersion> selectByPSDynaWFVer(PSDynaWFVerBase pSDynaWFVerBase, String string) throws Exception {
        return this.selectByPSDynaWFVer(pSDynaWFVerBase, string, -1);
    }

    public ArrayList<PSWFVersion> selectByPSDynaWFVer(PSDynaWFVerBase pSDynaWFVerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDYNAWFVERID", (Object)pSDynaWFVerBase.getPSDynaWFVerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDynaWFVerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDynaWFVerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFVersion> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSWFVersion> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSWFVersion> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSWFVersion> selectByPSSysWFMode(PSSysWFModeBase pSSysWFModeBase) throws Exception {
        return this.selectByPSSysWFMode(pSSysWFModeBase, "", -1);
    }

    public ArrayList<PSWFVersion> selectByPSSysWFMode(PSSysWFModeBase pSSysWFModeBase, String string) throws Exception {
        return this.selectByPSSysWFMode(pSSysWFModeBase, string, -1);
    }

    public ArrayList<PSWFVersion> selectByPSSysWFMode(PSSysWFModeBase pSSysWFModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSWFMODEID", (Object)pSSysWFModeBase.getPSSysWFModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysWFModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysWFModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSWFVersion> selectByPSWF(PSWorkflowBase pSWorkflowBase) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, "", -1);
    }

    public ArrayList<PSWFVersion> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string) throws Exception {
        return this.selectByPSWF(pSWorkflowBase, string, -1);
    }

    public ArrayList<PSWFVersion> selectByPSWF(PSWorkflowBase pSWorkflowBase, String string, int n) throws Exception {
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

    public void testRemoveByWFStepPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByWFStepPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFVERSION_PSCODELIST_WFSTEPPSCODELISTID", "", iDataEntityModel.getName(), "PSWFVERSION", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetWFStepPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByWFStepPSCodeList(pSCodeList);
        for (PSWFVersion pSWFVersion : arrayList) {
            PSWFVersion pSWFVersion2 = (PSWFVersion)this.getDEModel().createEntity();
            pSWFVersion2.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
            pSWFVersion2.setWFStepPSCodeListId(null);
            this.update(pSWFVersion2);
        }
    }

    public void removeByWFStepPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFVersionServiceBase.this.onBeforeRemoveByWFStepPSCodeList(pSCodeList2);
                PSWFVersionServiceBase.this.internalRemoveByWFStepPSCodeList(pSCodeList2);
                PSWFVersionServiceBase.this.onAfterRemoveByWFStepPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByWFStepPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByWFStepPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByWFStepPSCodeList(pSCodeList);
        this.onBeforeRemoveByWFStepPSCodeList(pSCodeList, arrayList);
        for (PSWFVersion pSWFVersion : arrayList) {
            this.remove((IEntity)pSWFVersion);
        }
        this.onAfterRemoveByWFStepPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByWFStepPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByWFStepPSCodeList(PSCodeList pSCodeList, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    protected void onAfterRemoveByWFStepPSCodeList(PSCodeList pSCodeList, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSDynaInst(pSDynaInst, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAINST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaInst);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFVERSION_PSDYNAINST_PSDYNAINSTID", "", iDataEntityModel.getName(), "PSWFVERSION", iDataEntityModel.getDataInfo((IEntity)pSDynaInst), arrayList.get(0)));
        }
    }

    public void resetPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSDynaInst(pSDynaInst);
        for (PSWFVersion pSWFVersion : arrayList) {
            PSWFVersion pSWFVersion2 = (PSWFVersion)this.getDEModel().createEntity();
            pSWFVersion2.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
            pSWFVersion2.setPSDynaInstId(null);
            this.update(pSWFVersion2);
        }
    }

    public void removeByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        final PSDynaInst pSDynaInst2 = pSDynaInst;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFVersionServiceBase.this.onBeforeRemoveByPSDynaInst(pSDynaInst2);
                PSWFVersionServiceBase.this.internalRemoveByPSDynaInst(pSDynaInst2);
                PSWFVersionServiceBase.this.onAfterRemoveByPSDynaInst(pSDynaInst2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void internalRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSDynaInst(pSDynaInst);
        this.onBeforeRemoveByPSDynaInst(pSDynaInst, arrayList);
        for (PSWFVersion pSWFVersion : arrayList) {
            this.remove((IEntity)pSWFVersion);
        }
        this.onAfterRemoveByPSDynaInst(pSDynaInst, arrayList);
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaInst(PSDynaInst pSDynaInst, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    public void testRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSDynaWFVer(pSDynaWFVer, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDYNAWFVER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDynaWFVer);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFVERSION_PSDYNAWFVER_PSDYNAWFVERID", "", iDataEntityModel.getName(), "PSWFVERSION", iDataEntityModel.getDataInfo((IEntity)pSDynaWFVer), arrayList.get(0)));
        }
    }

    public void resetPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSDynaWFVer(pSDynaWFVer);
        for (PSWFVersion pSWFVersion : arrayList) {
            PSWFVersion pSWFVersion2 = (PSWFVersion)this.getDEModel().createEntity();
            pSWFVersion2.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
            pSWFVersion2.setPSDynaWFVerId(null);
            this.update(pSWFVersion2);
        }
    }

    public void removeByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
        final PSDynaWFVer pSDynaWFVer2 = pSDynaWFVer;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFVersionServiceBase.this.onBeforeRemoveByPSDynaWFVer(pSDynaWFVer2);
                PSWFVersionServiceBase.this.internalRemoveByPSDynaWFVer(pSDynaWFVer2);
                PSWFVersionServiceBase.this.onAfterRemoveByPSDynaWFVer(pSDynaWFVer2);
            }
        });
    }

    protected void onBeforeRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
    }

    protected void internalRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSDynaWFVer(pSDynaWFVer);
        this.onBeforeRemoveByPSDynaWFVer(pSDynaWFVer, arrayList);
        for (PSWFVersion pSWFVersion : arrayList) {
            this.remove((IEntity)pSWFVersion);
        }
        this.onAfterRemoveByPSDynaWFVer(pSDynaWFVer, arrayList);
    }

    protected void onAfterRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer) throws Exception {
    }

    protected void onBeforeRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDynaWFVer(PSDynaWFVer pSDynaWFVer, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFVERSION_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSWFVERSION", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSWFVersion pSWFVersion : arrayList) {
            PSWFVersion pSWFVersion2 = (PSWFVersion)this.getDEModel().createEntity();
            pSWFVersion2.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
            pSWFVersion2.setPSSysReqItemId(null);
            this.update(pSWFVersion2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFVersionServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSWFVersionServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSWFVersionServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSWFVersion pSWFVersion : arrayList) {
            this.remove((IEntity)pSWFVersion);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    public void testRemoveByPSSysWFMode(PSSysWFMode pSSysWFMode) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSSysWFMode(pSSysWFMode, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSWFMODE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysWFMode);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFVERSION_PSSYSWFMODE_PSSYSWFMODEID", "", iDataEntityModel.getName(), "PSWFVERSION", iDataEntityModel.getDataInfo((IEntity)pSSysWFMode), arrayList.get(0)));
        }
    }

    public void resetPSSysWFMode(PSSysWFMode pSSysWFMode) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSSysWFMode(pSSysWFMode);
        for (PSWFVersion pSWFVersion : arrayList) {
            PSWFVersion pSWFVersion2 = (PSWFVersion)this.getDEModel().createEntity();
            pSWFVersion2.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
            pSWFVersion2.setPSSysWFModeId(null);
            this.update(pSWFVersion2);
        }
    }

    public void removeByPSSysWFMode(PSSysWFMode pSSysWFMode) throws Exception {
        final PSSysWFMode pSSysWFMode2 = pSSysWFMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFVersionServiceBase.this.onBeforeRemoveByPSSysWFMode(pSSysWFMode2);
                PSWFVersionServiceBase.this.internalRemoveByPSSysWFMode(pSSysWFMode2);
                PSWFVersionServiceBase.this.onAfterRemoveByPSSysWFMode(pSSysWFMode2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysWFMode(PSSysWFMode pSSysWFMode) throws Exception {
    }

    protected void internalRemoveByPSSysWFMode(PSSysWFMode pSSysWFMode) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSSysWFMode(pSSysWFMode);
        this.onBeforeRemoveByPSSysWFMode(pSSysWFMode, arrayList);
        for (PSWFVersion pSWFVersion : arrayList) {
            this.remove((IEntity)pSWFVersion);
        }
        this.onAfterRemoveByPSSysWFMode(pSSysWFMode, arrayList);
    }

    protected void onAfterRemoveByPSSysWFMode(PSSysWFMode pSSysWFMode) throws Exception {
    }

    protected void onBeforeRemoveByPSSysWFMode(PSSysWFMode pSSysWFMode, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysWFMode(PSSysWFMode pSSysWFMode, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    public void testRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSWF(pSWorkflow, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSWORKFLOW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSWorkflow);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", "", iDataEntityModel.getName(), "PSWFVERSION", iDataEntityModel.getDataInfo((IEntity)pSWorkflow), arrayList.get(0)));
        }
    }

    public void resetPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSWF(pSWorkflow);
        for (PSWFVersion pSWFVersion : arrayList) {
            PSWFVersion pSWFVersion2 = (PSWFVersion)this.getDEModel().createEntity();
            pSWFVersion2.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
            pSWFVersion2.setPSWFId(null);
            this.update(pSWFVersion2);
        }
    }

    public void removeByPSWF(PSWorkflow pSWorkflow) throws Exception {
        final PSWorkflow pSWorkflow2 = pSWorkflow;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSWFVersionServiceBase.this.onBeforeRemoveByPSWF(pSWorkflow2);
                PSWFVersionServiceBase.this.internalRemoveByPSWF(pSWorkflow2);
                PSWFVersionServiceBase.this.onAfterRemoveByPSWF(pSWorkflow2);
            }
        });
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void internalRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
        ArrayList<PSWFVersion> arrayList = this.selectByPSWF(pSWorkflow);
        this.onBeforeRemoveByPSWF(pSWorkflow, arrayList);
        for (PSWFVersion pSWFVersion : arrayList) {
            this.remove((IEntity)pSWFVersion);
        }
        this.onAfterRemoveByPSWF(pSWorkflow, arrayList);
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow) throws Exception {
    }

    protected void onBeforeRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSWF(PSWorkflow pSWorkflow, ArrayList<PSWFVersion> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSWFVersion pSWFVersion) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppWFVerService)ServiceGlobal.getService(PSAppWFVerService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppWFVerServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        ((PSDEUAGroupServiceBase)pSCoreSysServiceBase).removeByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        ((PSDEUIActionServiceBase)pSCoreSysServiceBase).removeByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).removeByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).removeByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).removeByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).removeByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).testRemoveByRefPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFProcSubWFService)ServiceGlobal.getService(PSWFProcSubWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcSubWFServiceBase)pSCoreSysServiceBase).testRemoveByEmbedPSWFVer(pSWFVersion);
        pSCoreSysServiceBase = (PSWFSubWFService)ServiceGlobal.getService(PSWFSubWFService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFSubWFServiceBase)pSCoreSysServiceBase).testRemoveBySubPSWFVer(pSWFVersion);
        pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFUtilUIActionServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFVerLogService)ServiceGlobal.getService(PSWFVerLogService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFVerLogServiceBase)pSCoreSysServiceBase).testRemoveByPSWFVersion(pSWFVersion);
        ((PSWFVerLogServiceBase)pSCoreSysServiceBase).removeByPSWFVersion(pSWFVersion);
        super.onBeforeRemove(pSWFVersion);
    }

    protected void onBeforeRemoveTemp(PSWFVersion pSWFVersion) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).removeTempByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).removeTempByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcRoleServiceBase)pSCoreSysServiceBase).removeTempByPSWFVersion(pSWFVersion);
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).removeTempByPSWFVersion(pSWFVersion);
        super.onBeforeRemoveTemp((IEntity)pSWFVersion);
    }

    protected void getRelatedDataTempMajor(PSWFVersion pSWFVersion) throws Exception {
        this.getRelatedDataTempMajor_PSWFProcess(pSWFVersion);
        this.getRelatedDataTempMajor_PSWFProcRole(pSWFVersion);
        this.getRelatedDataTempMajor_PSWFLink(pSWFVersion);
        this.getRelatedDataTempMajor_PSWFLinkCond(pSWFVersion);
        super.getRelatedDataTempMajor((IEntity)pSWFVersion);
    }

    protected void getRelatedDataTempMajor_PSWFProcess(PSWFVersion pSWFVersion) throws Exception {
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcess> arrayList = null;
        String string = pSWFVersion.getPSWFVersionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFProcessService.selectByPSWFVersion(pSWFVersion) : pSWFProcessService.selectTempByPSWFVersion(pSWFVersion);
        for (PSWFProcess pSWFProcess : arrayList) {
            pSWFProcessService.getTempMajor(pSWFProcess);
        }
    }

    protected void getRelatedDataTempMajor_PSWFProcRole(PSWFVersion pSWFVersion) throws Exception {
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcRole> arrayList = null;
        String string = pSWFVersion.getPSWFVersionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFProcRoleService.selectByPSWFVersion(pSWFVersion) : pSWFProcRoleService.selectTempByPSWFVersion(pSWFVersion);
        for (PSWFProcRole pSWFProcRole : arrayList) {
            pSWFProcRoleService.getTempMajor(pSWFProcRole);
        }
    }

    protected void getRelatedDataTempMajor_PSWFLink(PSWFVersion pSWFVersion) throws Exception {
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLink> arrayList = null;
        String string = pSWFVersion.getPSWFVersionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFLinkService.selectByPSWFVersion(pSWFVersion) : pSWFLinkService.selectTempByPSWFVersion(pSWFVersion);
        for (PSWFLink pSWFLink : arrayList) {
            pSWFLinkService.getTempMajor(pSWFLink);
        }
    }

    protected void getRelatedDataTempMajor_PSWFLinkCond(PSWFVersion pSWFVersion) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList = null;
        String string = pSWFVersion.getPSWFVersionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFLinkCondService.selectByPSWFVersion(pSWFVersion) : pSWFLinkCondService.selectTempByPSWFVersion(pSWFVersion);
        PSWFVersionServiceBase.sortHierarchyEntities(arrayList, (String)"PSWFLINKCONDID", (String)"PPSWFLINKCONDID");
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            pSWFLinkCondService.getTempMajor(pSWFLinkCond);
        }
    }

    protected void updateRelatedDataTempMajor(PSWFVersion pSWFVersion, PSWFVersion pSWFVersion2) throws Exception {
        ArrayList<PSWFLinkCond> arrayList = this.updateRelatedDataTempMajor_removePSWFLinkCond(pSWFVersion, pSWFVersion2);
        ArrayList<PSWFLink> arrayList2 = this.updateRelatedDataTempMajor_removePSWFLink(pSWFVersion, pSWFVersion2);
        ArrayList<PSWFProcRole> arrayList3 = this.updateRelatedDataTempMajor_removePSWFProcRole(pSWFVersion, pSWFVersion2);
        ArrayList<PSWFProcess> arrayList4 = this.updateRelatedDataTempMajor_removePSWFProcess(pSWFVersion, pSWFVersion2);
        this.updateRelatedDataTempMajor_updatePSWFProcess(pSWFVersion, pSWFVersion2, arrayList4);
        this.updateRelatedDataTempMajor_updatePSWFProcRole(pSWFVersion, pSWFVersion2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSWFLink(pSWFVersion, pSWFVersion2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSWFLinkCond(pSWFVersion, pSWFVersion2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSWFVersion, (IEntity)pSWFVersion2);
    }

    protected ArrayList<PSWFProcess> updateRelatedDataTempMajor_removePSWFProcess(PSWFVersion pSWFVersion, PSWFVersion pSWFVersion2) throws Exception {
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcess> arrayList = pSWFProcessService.selectTempByPSWFVersion(pSWFVersion);
        ArrayList<PSWFProcess> arrayList2 = pSWFProcessService.selectByPSWFVersion(pSWFVersion2);
        HashMap<String, PSWFProcess> hashMap = new HashMap<String, PSWFProcess>();
        for (PSWFProcess pSWFProcess : arrayList2) {
            hashMap.put(pSWFProcess.getPSWFProcessId(), pSWFProcess);
        }
        for (PSWFProcess pSWFProcess : arrayList) {
            Object object = pSWFProcess.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWFProcess pSWFProcess : hashMap.values()) {
            pSWFProcessService.remove((IEntity)pSWFProcess);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWFProcess(PSWFVersion pSWFVersion, PSWFVersion pSWFVersion2, ArrayList<PSWFProcess> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        for (PSWFProcess pSWFProcess : arrayList) {
            pSWFProcessService.updateTempMajor(pSWFProcess);
        }
    }

    protected ArrayList<PSWFProcRole> updateRelatedDataTempMajor_removePSWFProcRole(PSWFVersion pSWFVersion, PSWFVersion pSWFVersion2) throws Exception {
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcRole> arrayList = pSWFProcRoleService.selectTempByPSWFVersion(pSWFVersion);
        ArrayList<PSWFProcRole> arrayList2 = pSWFProcRoleService.selectByPSWFVersion(pSWFVersion2);
        HashMap<String, PSWFProcRole> hashMap = new HashMap<String, PSWFProcRole>();
        for (PSWFProcRole pSWFProcRole : arrayList2) {
            hashMap.put(pSWFProcRole.getPSWFProcRoleId(), pSWFProcRole);
        }
        for (PSWFProcRole pSWFProcRole : arrayList) {
            Object object = pSWFProcRole.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWFProcRole pSWFProcRole : hashMap.values()) {
            pSWFProcRoleService.remove((IEntity)pSWFProcRole);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWFProcRole(PSWFVersion pSWFVersion, PSWFVersion pSWFVersion2, ArrayList<PSWFProcRole> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWFProcRoleService pSWFProcRoleService = (PSWFProcRoleService)ServiceGlobal.getService(PSWFProcRoleService.class, (SessionFactory)this.getSessionFactory());
        for (PSWFProcRole pSWFProcRole : arrayList) {
            pSWFProcRoleService.updateTempMajor(pSWFProcRole);
        }
    }

    protected ArrayList<PSWFLink> updateRelatedDataTempMajor_removePSWFLink(PSWFVersion pSWFVersion, PSWFVersion pSWFVersion2) throws Exception {
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLink> arrayList = pSWFLinkService.selectTempByPSWFVersion(pSWFVersion);
        ArrayList<PSWFLink> arrayList2 = pSWFLinkService.selectByPSWFVersion(pSWFVersion2);
        HashMap<String, PSWFLink> hashMap = new HashMap<String, PSWFLink>();
        for (PSWFLink pSWFLink : arrayList2) {
            hashMap.put(pSWFLink.getPSWFLinkId(), pSWFLink);
        }
        for (PSWFLink pSWFLink : arrayList) {
            Object object = pSWFLink.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWFLink pSWFLink : hashMap.values()) {
            pSWFLinkService.remove((IEntity)pSWFLink);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWFLink(PSWFVersion pSWFVersion, PSWFVersion pSWFVersion2, ArrayList<PSWFLink> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        for (PSWFLink pSWFLink : arrayList) {
            pSWFLinkService.updateTempMajor(pSWFLink);
        }
    }

    protected ArrayList<PSWFLinkCond> updateRelatedDataTempMajor_removePSWFLinkCond(PSWFVersion pSWFVersion, PSWFVersion pSWFVersion2) throws Exception {
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLinkCond> arrayList = pSWFLinkCondService.selectTempByPSWFVersion(pSWFVersion);
        ArrayList<PSWFLinkCond> arrayList2 = pSWFLinkCondService.selectByPSWFVersion(pSWFVersion2);
        HashMap<String, PSWFLinkCond> hashMap = new HashMap<String, PSWFLinkCond>();
        for (PSWFLinkCond pSWFLinkCond : arrayList2) {
            hashMap.put(pSWFLinkCond.getPSWFLinkCondId(), pSWFLinkCond);
        }
        PSWFVersionServiceBase.sortHierarchyEntities(arrayList, (String)"PSWFLINKCONDID", (String)"PPSWFLINKCONDID");
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            Object object = pSWFLinkCond.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSWFLinkCond pSWFLinkCond : hashMap.values()) {
            pSWFLinkCondService.remove((IEntity)pSWFLinkCond);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSWFLinkCond(PSWFVersion pSWFVersion, PSWFVersion pSWFVersion2, ArrayList<PSWFLinkCond> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            pSWFLinkCondService.updateTempMajor(pSWFLinkCond);
        }
    }

    protected void replaceParentInfo(PSWFVersion pSWFVersion, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSWFVersion, cloneSession);
        if (pSWFVersion.getWFStepPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSWFVersion.getWFStepPSCodeListId())) != null) {
            this.onFillParentInfo_WFStepPSCodeList(pSWFVersion, (PSCodeList)iEntity);
        }
        if (pSWFVersion.getPSDynaInstId() != null && (iEntity = cloneSession.getEntity("PSDYNAINST", (Object)pSWFVersion.getPSDynaInstId())) != null) {
            this.onFillParentInfo_PSDynaInst(pSWFVersion, (PSDynaInst)iEntity);
        }
        if (pSWFVersion.getPSDynaWFVerId() != null && (iEntity = cloneSession.getEntity("PSDYNAWFVER", (Object)pSWFVersion.getPSDynaWFVerId())) != null) {
            this.onFillParentInfo_PSDynaWFVer(pSWFVersion, (PSDynaWFVer)iEntity);
        }
        if (pSWFVersion.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSWFVersion.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSWFVersion, (PSSysReqItem)iEntity);
        }
        if (pSWFVersion.getPSSysWFModeId() != null && (iEntity = cloneSession.getEntity("PSSYSWFMODE", (Object)pSWFVersion.getPSSysWFModeId())) != null) {
            this.onFillParentInfo_PSSysWFMode(pSWFVersion, (PSSysWFMode)iEntity);
        }
        if (pSWFVersion.getPSWFId() != null && (iEntity = cloneSession.getEntity("PSWORKFLOW", (Object)pSWFVersion.getPSWFId())) != null) {
            this.onFillParentInfo_PSWF(pSWFVersion, (PSWorkflow)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSWFVersion pSWFVersion, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSWFVersion, bl);
        pSWFVersion.resetVerTag();
        pSWFVersion.resetVerTag2();
    }

    protected void onCheckEntity(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActivitiModel(bl, pSWFVersion, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BPMNModel(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaSysRefMode(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaWFVer(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Enable(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaSys(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLog(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LastBackDataTag(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupsCnt(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionsCnt(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerId(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerInstId(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerInstName(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaWFVerName(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysWFModeId(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFId(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFName(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionId(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSWFVersionName(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemoveFlag(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VerTag2(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFModel(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFStepPSCodeListId(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFVerMode(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WFVersion(bl, pSWFVersion, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSWFVersion, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActivitiModel(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isActivitiModelDirty() : !pSWFVersion.isActivitiModelDirty()) {
            return null;
        }
        String string = pSWFVersion.getActivitiModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ActivitiModel_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIVITIMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BPMNModel(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isBPMNModelDirty() : !pSWFVersion.isBPMNModelDirty()) {
            return null;
        }
        String string = pSWFVersion.getBPMNModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BPMNModel_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BPMNMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isDynaModelFlagDirty() : !pSWFVersion.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_DynaSysRefMode(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isDynaSysRefModeDirty() : !pSWFVersion.isDynaSysRefModeDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getDynaSysRefMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaSysRefMode_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNASYSREFMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaWFVer(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isDynaWFVerDirty() : !pSWFVersion.isDynaWFVerDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getDynaWFVer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaWFVer_Default2((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAWFVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
            string = this.onTestValueRule_DynaWFVer_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNAWFVER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Enable(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isEnableDirty() && !bl2 : !pSWFVersion.isEnableDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getEnable();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_Enable_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaSys(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isEnableDynaSysDirty() : !pSWFVersion.isEnableDynaSysDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getEnableDynaSys();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaSys_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNASYS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSWFID";
                String string2 = this.checkFieldDupRule(this.getPSWFVersionDEModel(), "ENABLEDYNASYS", string, pSWFVersion, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("ENABLEDYNASYS");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableLog(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isEnableLogDirty() : !pSWFVersion.isEnableLogDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getEnableLog();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableLog_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLELOG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LastBackDataTag(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isLastBackDataTagDirty() : !pSWFVersion.isLastBackDataTagDirty()) {
            return null;
        }
        String string = pSWFVersion.getLastBackDataTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LastBackDataTag_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LASTBACKDATATAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isMemoDirty() : !pSWFVersion.isMemoDirty()) {
            return null;
        }
        String string = pSWFVersion.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupsCnt(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSDEUAGroupsCntDirty() : !pSWFVersion.isPSDEUAGroupsCntDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getPSDEUAGroupsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEUAGroupsCnt_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUIActionsCnt(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSDEUIActionsCntDirty() : !pSWFVersion.isPSDEUIActionsCntDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getPSDEUIActionsCnt();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PSDEUIActionsCnt_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUIACTIONSCNT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSDynaInstIdDirty() : !pSWFVersion.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaWFVerId(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSDynaWFVerIdDirty() : !pSWFVersion.isPSDynaWFVerIdDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSDynaWFVerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerId_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaWFVerInstId(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSDynaWFVerInstIdDirty() : !pSWFVersion.isPSDynaWFVerInstIdDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSDynaWFVerInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerInstId_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERINSTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaWFVerInstName(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSDynaWFVerInstNameDirty() : !pSWFVersion.isPSDynaWFVerInstNameDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSDynaWFVerInstName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerInstName_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERINSTNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaWFVerName(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSDynaWFVerNameDirty() : !pSWFVersion.isPSDynaWFVerNameDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSDynaWFVerName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaWFVerName_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDYNAWFVERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSSysReqItemIdDirty() : !pSWFVersion.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysWFModeId(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSSysWFModeIdDirty() : !pSWFVersion.isPSSysWFModeIdDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSSysWFModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysWFModeId_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSWFMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFId(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSWFIdDirty() && !bl2 : !pSWFVersion.isPSWFIdDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSWFId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFId_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFName(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSWFNameDirty() && !bl2 : !pSWFVersion.isPSWFNameDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSWFName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFName_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSWFVersionId(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSWFVersionIdDirty() && !bl2 : !pSWFVersion.isPSWFVersionIdDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSWFVersionId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionId_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSWFVersionName(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isPSWFVersionNameDirty() && !bl2 : !pSWFVersion.isPSWFVersionNameDirty()) {
            return null;
        }
        String string = pSWFVersion.getPSWFVersionName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSWFVersionName_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSWFVERSIONNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemoveFlag(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isRemoveFlagDirty() : !pSWFVersion.isRemoveFlagDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getRemoveFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RemoveFlag_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isToDoTaskDirty() : !pSWFVersion.isToDoTaskDirty()) {
            return null;
        }
        String string = pSWFVersion.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isUserCatDirty() : !pSWFVersion.isUserCatDirty()) {
            return null;
        }
        String string = pSWFVersion.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isUserTagDirty() : !pSWFVersion.isUserTagDirty()) {
            return null;
        }
        String string = pSWFVersion.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isUserTag2Dirty() : !pSWFVersion.isUserTag2Dirty()) {
            return null;
        }
        String string = pSWFVersion.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isUserTag3Dirty() : !pSWFVersion.isUserTag3Dirty()) {
            return null;
        }
        String string = pSWFVersion.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isUserTag4Dirty() : !pSWFVersion.isUserTag4Dirty()) {
            return null;
        }
        String string = pSWFVersion.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isValidFlagDirty() : !pSWFVersion.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSWFVersion, bl2, bl3);
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

    protected EntityFieldError onCheckField_VerTag(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isVerTagDirty() : !pSWFVersion.isVerTagDirty()) {
            return null;
        }
        String string = pSWFVersion.getVerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VerTag2(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isVerTag2Dirty() : !pSWFVersion.isVerTag2Dirty()) {
            return null;
        }
        String string = pSWFVersion.getVerTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VerTag2_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VERTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFModel(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isWFModelDirty() : !pSWFVersion.isWFModelDirty()) {
            return null;
        }
        String string = pSWFVersion.getWFModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFModel_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFStepPSCodeListId(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isWFStepPSCodeListIdDirty() : !pSWFVersion.isWFStepPSCodeListIdDirty()) {
            return null;
        }
        String string = pSWFVersion.getWFStepPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFStepPSCodeListId_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFSTEPPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFVerMode(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isWFVerModeDirty() : !pSWFVersion.isWFVerModeDirty()) {
            return null;
        }
        String string = pSWFVersion.getWFVerMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WFVerMode_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WFVersion(boolean bl, PSWFVersion pSWFVersion, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSWFVersion.isWFVersionDirty() : !pSWFVersion.isWFVersionDirty()) {
            return null;
        }
        Integer n = pSWFVersion.getWFVersion();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_WFVersion_Default((IEntity)pSWFVersion, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WFVERSION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (n == null) {
                bl4 = false;
            }
            if (bl4) {
                String string = "";
                string = "PSWFID";
                String string2 = this.checkFieldDupRule(this.getPSWFVersionDEModel(), "WFVERSION", string, pSWFVersion, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("WFVERSION");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected void onSyncEntity(PSWFVersion pSWFVersion, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSWFVersion, bl);
    }

    protected void onSyncIndexEntities(PSWFVersion pSWFVersion, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSWFVersion, bl);
    }

    public Object getDataContextValue(PSWFVersion pSWFVersion, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSWFVersion, string, iDataContextParam)) != null) {
            return object;
        }
        PSWorkflow pSWorkflow = pSWFVersion.getPSWF();
        if (pSWorkflow != null && pSWorkflow.contains(string)) {
            return pSWorkflow.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSWFVersion pSWFVersion, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSWFProcess_PSWFVersion(pSWFVersion, arrayList, n);
        this.onExportRelatedModel_PSWFLink_PSWFVersion(pSWFVersion, arrayList, n);
        super.onExportRelatedModel((IEntity)pSWFVersion, arrayList, n);
    }

    /*
     * WARNING - void declaration
     */
    protected void onExportRelatedModel_PSWFProcess_PSWFVersion(PSWFVersion pSWFVersion, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcess> arrayList2 = pSWFProcessService.selectByPSWFVersion(pSWFVersion);
        if ((n & 2) != 0) {
            void var7_8;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"8187422fc9b94fc127d18d949dd0a57e");
            jSONObject.put("srfdename", (Object)"PSWFPROCESS");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSWFPROCESS_PSWFVERSION_PSWFVERSIONID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSWFVersion, (String)"PSWFVERSIONID", (String)""));
            String object = "";
            for (PSWFProcess pSWFProcess : arrayList2) {
                void var7_10;
                if (!StringHelper.isNullOrEmpty((String)var7_8)) {
                    String string = (String)var7_8 + ";";
                }
                String string = (String)var7_10 + DataObject.getStringValue((IDataObject)pSWFProcess, (String)"PSWFPROCESSID", (String)"");
            }
            jSONObject.put("srfarg2", (Object)var7_8);
            arrayList.add(jSONObject);
        }
        for (PSWFProcess pSWFProcess : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSWFProcess, (String)"srfsyspub", (int)1) == 0) continue;
            pSWFProcessService.exportModel(pSWFProcess, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSWFLink_PSWFVersion(PSWFVersion pSWFVersion, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLink> arrayList2 = pSWFLinkService.selectByPSWFVersion(pSWFVersion);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"a93c35398cae7e2ecde2cd8e2a0f731c");
            jSONObject.put("srfdename", (Object)"PSWFLINK");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSWFLINK_PSWFVERSION_PSWFVERSIONID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSWFVersion, (String)"PSWFVERSIONID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSWFLink pSWFLink : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSWFLink, (String)"srfsyspub", (int)1) == 0) continue;
            pSWFLinkService.exportModel(pSWFLink, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSWFVersion pSWFVersion, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSWFVersion, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIVITIMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActivitiModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BPMNMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BPMNModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNASYSREFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaSysRefMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAWFVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"DEFAULT2", (boolean)true) == 0) {
            return this.onTestValueRule_DynaWFVer_Default2(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAWFVER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaWFVer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Enable_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNASYS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaSys_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELOG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLog_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LASTBACKDATATAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LastBackDataTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUIACTIONSCNT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUIActionsCnt_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERINSTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerInstName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAWFVERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaWFVerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSWFMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSWFMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysWFModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSWFVERSIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSWFVersionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemoveFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VerTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFENGINETYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFEngineType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTEPPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStepPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFSTEPPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFStepPSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFVerMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WFVERSION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WFVersion_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActivitiModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ACTIVITIMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BPMNModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BPMNMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaSysRefMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaWFVer_Default2(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldSimpleRule("DYNAWFVER", iEntity, bl2, "ISNULL", null, null, "", true) || this.checkFieldQueryCountRule2("DYNAWFVER", "DynaWFVerCnt", iEntity, bl2, 0, true, 0, true, "\u5b58\u5728\u91cd\u590d\u7684\u6d41\u7a0b\u7248\u672c", false, false) && this.checkFieldValueRangeRule("DYNAWFVER", iEntity, bl2, new Double(0.0), false, null, false, "\u7248\u672c\u53f7\u5fc5\u987b\u5927\u4e8e0", false)) {
                return null;
            }
            return "(\u5b58\u5728\u91cd\u590d\u7684\u6d41\u7a0b\u7248\u672c \u5e76\u4e14 \u7248\u672c\u53f7\u5fc5\u987b\u5927\u4e8e0)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaWFVer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Enable_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaSys_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableLog_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LastBackDataTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LASTBACKDATATAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEUAGroupsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEUIActionsCnt_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDynaInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAINSTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerInstId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERINSTID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerInstName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERINSTNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDynaWFVerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDYNAWFVERNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSSysWFModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysWFModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSWFMODENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RemoveFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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
            if (this.checkFieldStringLengthRule("USERTAG", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERTAG2", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_VerTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VerTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VERTAG2", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFEngineType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFENGINETYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStepPSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFStepPSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFSTEPPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFVerMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WFVERMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_WFVersion_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldValueRangeRule("WFVERSION", iEntity, bl2, new Double(0.0), false, null, false, "\u7248\u672c\u53f7\u5fc5\u987b\u5927\u4e8e0", true)) {
                return null;
            }
            return "\u7248\u672c\u53f7\u5fc5\u987b\u5927\u4e8e0";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSWFVersion pSWFVersion) throws Exception {
        boolean bl = false;
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUAGROUP_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) && this.onMergeChild_PSDEUAGroups(pSWFVersion)) {
            bl = true;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || (StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEUIACTION_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) && this.onMergeChild_PSDEUIActions(pSWFVersion)) {
            bl = true;
        }
        if (super.onMergeChild(string, string2, (IEntity)pSWFVersion)) {
            bl = true;
        }
        return bl;
    }

    protected boolean onMergeChild_PSDEUAGroups(PSWFVersion pSWFVersion) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEUAGROUPSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWFVersion.getPSWFVersionId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWFVERSIONID", (Object)pSWFVersion.getPSWFVersionId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWFVersion, false);
        return true;
    }

    protected boolean onMergeChild_PSDEUIActions(PSWFVersion pSWFVersion) throws Exception {
        SelectContext selectContext = new SelectContext();
        SelectField selectField = new SelectField();
        selectField.setAlias("PSDEUIACTIONSCNT");
        selectField.setFunc("COUNT");
        selectContext.addSelectField((ISelectField)selectField);
        String string = DataObject.getStringValue((Object)pSWFVersion.getPSWFVersionId());
        IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
        selectContext.set("PSWFVERSIONID", (Object)pSWFVersion.getPSWFVersionId());
        ArrayList arrayList = null;
        arrayList = string.indexOf("SRFTEMPKEY:") == 0 ? iService.selectTemp((ISelectCond)selectContext) : iService.select((ISelectCond)selectContext);
        if (arrayList.size() == 0) {
            throw new Exception("\u65e0\u6cd5\u83b7\u53d6\u6307\u5b9a\u6570\u636e");
        }
        IEntity iEntity = (IEntity)arrayList.get(0);
        iEntity.copyTo((IDataObject)pSWFVersion, false);
        return true;
    }

    protected void onUpdateParent(PSWFVersion pSWFVersion) throws Exception {
        Object object = pSWFVersion.get("PSWFID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWorkflowService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSWFVERSION_PSWORKFLOW_PSWFID", object);
        }
        super.onUpdateParent((IEntity)pSWFVersion);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSWFVersion pSWFVersion, Object object) throws Exception {
        PSWFVersion pSWFVersion2 = new PSWFVersion();
        pSWFVersion2.set("PSWFVERSIONID", object);
        String string = DataObject.getStringValue((Object)pSWFVersion.get("PSWFVERSIONID"));
        super.onCopyDetails((IEntity)pSWFVersion, object);
    }

    @Override
    protected void exportCurXmlModel(PSWFVersion pSWFVersion, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSWFVERSION");
        if (!bl) {
            pSWFVersion.setBPMNModel(null);
            pSWFVersion.setDynaSysRefMode(null);
            pSWFVersion.setPSDEUAGroupsCnt(null);
            pSWFVersion.setPSDEUIActionsCnt(null);
            pSWFVersion.setPSDynaInstId(null);
            pSWFVersion.setPSDynaInstName(null);
            pSWFVersion.setPSDynaWFVerInstName(null);
            pSWFVersion.setPSDynaWFVerName(null);
            super.exportCurXmlModel(pSWFVersion, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSWFVersion pSWFVersion, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSWFProcess(pSWFVersion, xmlNode);
        this.exportRelatedXmlModel_PSWFLink(pSWFVersion, xmlNode);
        super.onExportRelatedXmlModel(pSWFVersion, xmlNode);
    }

    protected void exportRelatedXmlModel_PSWFProcess(PSWFVersion pSWFVersion, XmlNode xmlNode) throws Exception {
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFProcess> arrayList = null;
        String string = pSWFVersion.getPSWFVersionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFProcessService.selectByPSWFVersion(pSWFVersion) : pSWFProcessService.selectTempByPSWFVersion(pSWFVersion);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSWFPROCESSES");
            xmlNode.addNode(xmlNode2);
            for (PSWFProcess pSWFProcess : arrayList) {
                pSWFProcessService.exportXmlModel(pSWFProcess, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSWFLink(PSWFVersion pSWFVersion, XmlNode xmlNode) throws Exception {
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSWFLink> arrayList = null;
        String string = pSWFVersion.getPSWFVersionId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSWFLinkService.selectByPSWFVersion(pSWFVersion, "ORDER BY ORDERVALUE ASC") : pSWFLinkService.selectTempByPSWFVersion(pSWFVersion, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSWFLINKS");
            xmlNode.addNode(xmlNode2);
            for (PSWFLink pSWFLink : arrayList) {
                pSWFLink.set("ORDERVALUE", null);
                pSWFLinkService.exportXmlModel(pSWFLink, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSWFVersion pSWFVersion, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSWFPROCESSES");
        this.importRelatedXmlModel_PSWFProcess(pSWFVersion, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSWFLINKS");
        this.importRelatedXmlModel_PSWFLink(pSWFVersion, xmlNode3);
        super.onImportRelatedXmlModel(pSWFVersion, xmlNode);
    }

    protected void importRelatedXmlModel_PSWFProcess(PSWFVersion pSWFVersion, XmlNode xmlNode) throws Exception {
        PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        String string = pSWFVersion.getPSWFVersionId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSWFProcessService.removeByPSWFVersion(pSWFVersion);
        } else {
            pSWFProcessService.removeTempByPSWFVersion(pSWFVersion);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSWFProcess pSWFProcess = new PSWFProcess();
                pSWFProcessService.fillParentInfo((IEntity)pSWFProcess, "DER1N", "DER1N_PSWFPROCESS_PSWFVERSION_PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
                pSWFProcessService.importXmlModel(pSWFProcess, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSWFLink(PSWFVersion pSWFVersion, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        String string = pSWFVersion.getPSWFVersionId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSWFLinkService.removeByPSWFVersion(pSWFVersion);
        } else {
            pSWFLinkService.removeTempByPSWFVersion(pSWFVersion);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSWFLink pSWFLink = new PSWFLink();
                pSWFLink.setOrderValue(n);
                n += 100;
                pSWFLinkService.fillParentInfo((IEntity)pSWFLink, "DER1N", "DER1N_PSWFLINK_PSWFVERSION_PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
                pSWFLinkService.importXmlModel(pSWFLink, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSWFVersion pSWFVersion, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSWFVersion, string);
        objectNode.remove("psdeuagroupscnt");
        objectNode.remove("psdeuiactionscnt");
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSWORKFLOW#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSWFVERSION_PSWORKFLOW_PSWFID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSWFNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSWORKFLOW", (boolean)true) == 0) {
            iEntity.set("PSWFID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSWFID"};
    }

    @Override
    public String getModelV2Tag(PSWFVersion pSWFVersion) {
        if (pSWFVersion.getWFVersion() != null) {
            return pSWFVersion.getWFVersion().toString();
        }
        return super.getModelV2Tag(pSWFVersion);
    }

    @Override
    public boolean setModelV2Tag(PSWFVersion pSWFVersion, String string) {
        pSWFVersion.setWFVersion(Integer.valueOf(string));
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("WFVERSION", "");
        map.put("PSWFID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSWFVersion pSWFVersion, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSWFVersion.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSWFVersion, true);
        pSWFVersion.set("WFVERSION", string);
        if (this.select(pSWFVersion, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSWFVersion, true);
        return super.getModelV2Entity(pSWFVersion, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSWFVersion pSWFVersion, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSWFVersion, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEUAGROUP_PSWFVERSION_PSWFVERSIONID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSDEUIACTION_PSWFVERSION_PSWFVERSIONID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        if (StringHelper.compare((String)"DER1N_PSWFPROCESS_PSWFVERSION_PSWFVERSIONID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSWFUTILUIACTION_PSWFVERSION_PSWFVERSIONID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 60;
        }
        if (StringHelper.compare((String)"DER1N_PSWFLINK_PSWFVERSION_PSWFVERSIONID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSWFLINKCOND_PSWFVERSION_PSWFVERSIONID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSWFVersion pSWFVersion, String string, String string2) throws Exception {
        String string3;
        EntityBase entityBase;
        ObjectNode objectNode;
        ArrayList<String> arrayList;
        File file;
        String string4;
        String string5;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file2 = null;
        if (this.isExportRelatedModelV2("DER1N_PSDEUAGROUP_PSWFVERSION_PSWFVERSIONID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFVERSION#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEUAGROUP", (Object)pSWFVersion.getPSWFVersionId()))).exists()) {
            pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSDEUAGroup();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEUAGroupService)pSCoreSysServiceBase).getModelV2Tag((PSDEUAGroup)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEUAGROUP", (Object)entityBase.getPSDEUAGroupId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSDEUIACTION_PSWFVERSION_PSWFVERSIONID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFVERSION#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEUIACTION", (Object)pSWFVersion.getPSWFVersionId()))).exists()) {
            pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSDEUIAction();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSDEUIActionService)pSCoreSysServiceBase).getModelV2Tag((PSDEUIAction)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEUIACTION", (Object)entityBase.getPSDEUIActionId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        if (this.isExportRelatedModelV2("DER1N_PSWFUTILUIACTION_PSWFVERSION_PSWFVERSIONID") && (file2 = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFVERSION#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSWFUTILUIACTION", (Object)pSWFVersion.getPSWFVersionId()))).exists()) {
            pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            string5 = pSCoreSysServiceBase.getModelV2Name(false);
            string4 = string + File.separator + string5;
            file = new File(string4);
            if (!file.exists()) {
                file.mkdirs();
            }
            arrayList = PSModelV2Helper.readFile2(file2);
            for (String string6 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string6)) continue;
                objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string6);
                entityBase = new PSWFUtilUIAction();
                PSModelV2Helper.fromJSONObject((IDataObject)entityBase, objectNode, false);
                string3 = ((PSWFUtilUIActionService)pSCoreSysServiceBase).getModelV2Tag((PSWFUtilUIAction)entityBase);
                if (StringHelper.isNullOrEmpty((String)string3)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSWFUTILUIACTION", (Object)entityBase.getPSWFUtilUIActionId()));
                }
                string3 = PSModelV2Helper.getModelV2TagFolderName(string3);
                file = new File(string4 + File.separator + string3);
                if (!file.exists()) {
                    file.mkdirs();
                }
                pSCoreSysServiceBase.exportModelV2(entityBase, string4 + File.separator + string3, string2);
            }
        }
        super.onExportRelatedModelV2(pSWFVersion, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSWFVersion pSWFVersion, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSDEUAGroup> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEUAGROUP_PSWFVERSION_PSWFVERSIONID")) {
            pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFVERSION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEUAGROUP", (Object)pSWFVersion.getPSWFVersionId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEUAGroup>();
                object4 = ((PSDEUAGroupServiceBase)pSCoreSysServiceBase).selectByPSWFVersion(pSWFVersion);
                object3 = StringHelper.format((String)"PSWFVERSION#%1$s", (Object)pSWFVersion.getPSWFVersionId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEUAGroup)object2.next();
                    object = ((PSDEUAGroupServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("psdeuagroupname")) {
                            string = objectNode.get("psdeuagroupname").asText();
                        }
                        if (objectNode2.has("psdeuagroupname")) {
                            string2 = objectNode2.get("psdeuagroupname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEUAGroup();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEUIACTION_PSWFVERSION_PSWFVERSIONID")) {
            pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFVERSION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEUIACTION", (Object)pSWFVersion.getPSWFVersionId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEUIActionServiceBase)pSCoreSysServiceBase).selectByPSWFVersion(pSWFVersion);
                object3 = StringHelper.format((String)"PSWFVERSION#%1$s", (Object)pSWFVersion.getPSWFVersionId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEUIAction)object2.next();
                    object = ((PSDEUIActionServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("psdeuiactionname")) {
                            string = objectNode.get("psdeuiactionname").asText();
                        }
                        if (objectNode2.has("psdeuiactionname")) {
                            string2 = objectNode2.get("psdeuiactionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEUIAction();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFPROCESS_PSWFVERSION_PSWFVERSIONID")) {
            pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFVERSION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFPROCESS", (Object)pSWFVersion.getPSWFVersionId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWFProcessServiceBase)pSCoreSysServiceBase).selectByPSWFVersion(pSWFVersion);
                object3 = StringHelper.format((String)"PSWFVERSION#%1$s", (Object)pSWFVersion.getPSWFVersionId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFProcess)object2.next();
                    object = ((PSWFProcessServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pswfprocessname")) {
                            string = objectNode.get("pswfprocessname").asText();
                        }
                        if (objectNode2.has("pswfprocessname")) {
                            string2 = objectNode2.get("pswfprocessname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFProcess();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFUTILUIACTION_PSWFVERSION_PSWFVERSIONID")) {
            pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFVERSION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFUTILUIACTION", (Object)pSWFVersion.getPSWFVersionId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWFUtilUIActionServiceBase)pSCoreSysServiceBase).selectByPSWFVersion(pSWFVersion);
                object3 = StringHelper.format((String)"PSWFVERSION#%1$s", (Object)pSWFVersion.getPSWFVersionId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFUtilUIAction)object2.next();
                    object = ((PSWFUtilUIActionServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pswfutiluiactionname")) {
                            string = objectNode.get("pswfutiluiactionname").asText();
                        }
                        if (objectNode2.has("pswfutiluiactionname")) {
                            string2 = objectNode2.get("pswfutiluiactionname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFUtilUIAction();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFLINK_PSWFVERSION_PSWFVERSIONID")) {
            pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFVERSION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFLINK", (Object)pSWFVersion.getPSWFVersionId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWFLinkServiceBase)pSCoreSysServiceBase).selectByPSWFVersion(pSWFVersion);
                object3 = StringHelper.format((String)"PSWFVERSION#%1$s", (Object)pSWFVersion.getPSWFVersionId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFLink)object2.next();
                    object = ((PSWFLinkServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("label")) {
                            string = objectNode.get("label").asText();
                        }
                        if (objectNode2.has("label")) {
                            string2 = objectNode2.get("label").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFLink();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSWFLINKCOND_PSWFVERSION_PSWFVERSIONID")) {
            pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSWFVERSION#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSWFLINKCOND", (Object)pSWFVersion.getPSWFVersionId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEUAGroup)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).selectByPSWFVersion(pSWFVersion);
                object3 = StringHelper.format((String)"PSWFVERSION#%1$s", (Object)pSWFVersion.getPSWFVersionId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSWFLinkCond)object2.next();
                    object = ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEUAGroup)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object4 = pSCoreSysServiceBase.getModelV2Name(false);
                object3 = objectNode.putArray(((String)object4).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

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
                        if (objectNode.has("pswflinkcondname")) {
                            string = objectNode.get("pswflinkcondname").asText();
                        }
                        if (objectNode2.has("pswflinkcondname")) {
                            string2 = objectNode2.get("pswflinkcondname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSWFLinkCond();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    ((PSWFLinkCondBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSWFVersion, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSWFVersion pSWFVersion) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSWFProcessServiceBase)pSCoreSysServiceBase).selectByPSWFVersion(pSWFVersion);
        String string2 = StringHelper.format((String)"PSWFVERSION#%1$s", (Object)pSWFVersion.getPSWFVersionId());
        for (PSWFProcess entityBase : arrayList) {
            string = ((PSWFProcessServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSWFVersion.getPSWFVersionId());
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSWFProcessServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWFPROCESS WHERE PSWFVERSIONID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSWFLinkServiceBase)pSCoreSysServiceBase).selectByPSWFVersion(pSWFVersion);
        string2 = StringHelper.format((String)"PSWFVERSION#%1$s", (Object)pSWFVersion.getPSWFVersionId());
        for (PSWFLink pSWFLink : arrayList) {
            string = ((PSWFLinkServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSWFLink);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSWFLink);
        }
        object = new SqlParamList();
        object.addString(pSWFVersion.getPSWFVersionId());
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSWFLinkServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWFLINK WHERE PSWFVERSIONID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).selectByPSWFVersion(pSWFVersion);
        string2 = StringHelper.format((String)"PSWFVERSION#%1$s", (Object)pSWFVersion.getPSWFVersionId());
        for (PSWFLinkCond pSWFLinkCond : arrayList) {
            string = ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSWFLinkCond);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSWFLinkCond);
        }
        object = new SqlParamList();
        object.addString(pSWFVersion.getPSWFVersionId());
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSWFLinkCondServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSWFLINKCOND WHERE PSWFVERSIONID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSWFVersion);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSWFVersion pSWFVersion, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEUAGroup();
        entityBase.set("PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEUIAction();
        entityBase.set("PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
        pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFProcess();
        entityBase.set("PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFUtilUIAction();
        entityBase.set("PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
        pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFLink();
        entityBase.set("PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSWFLinkCond();
        entityBase.set("PSWFVERSIONID", pSWFVersion.getPSWFVersionId());
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSWFVersion, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSWFVersion pSWFVersion, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        Object object5;
        File file;
        int n2;
        int n3;
        Object object2;
        Object object3;
        Object object4;
        int n4;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSWFVersionServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n4 = 0; n4 < arrayNode.size(); ++n4) {
                    object4 = (ObjectNode)arrayNode.get(n4);
                    object3 = new PSDEUAGroup();
                    ((PSDEUAGroupBase)object3).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    ((PSDEUAGroupBase)object3).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    pSCoreSysServiceBase.compileModelV2(object3, (ObjectNode)object4, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object4 = new File(string4);
                if (((File)object4).exists()) {
                    object2 = object3 = ((File)object4).listFiles();
                    n3 = ((File[])object2).length;
                    for (n2 = 0; n2 < n3; ++n2) {
                        file = object2[n2];
                        if (!file.isDirectory()) continue;
                        object5 = new PSDEUAGroup();
                        ((PSDEUAGroupBase)object5).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                        ((PSDEUAGroupBase)object5).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                        pSCoreSysServiceBase.compileModelV2(object5, null, string, file.getCanonicalPath(), n);
                    }
                }
            }
        }
        if (!PSWFVersionServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n4 = 0; n4 < arrayNode.size(); ++n4) {
                    object4 = (ObjectNode)arrayNode.get(n4);
                    object3 = new PSDEUIAction();
                    ((PSDEUIActionBase)object3).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    ((PSDEUIActionBase)object3).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    pSCoreSysServiceBase.compileModelV2(object3, (ObjectNode)object4, string, null, n);
                }
            } else {
                String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object4 = new File(string5);
                if (((File)object4).exists()) {
                    object2 = object3 = ((File)object4).listFiles();
                    n3 = ((File[])object2).length;
                    for (n2 = 0; n2 < n3; ++n2) {
                        file = object2[n2];
                        if (!file.isDirectory()) continue;
                        object5 = new PSDEUIAction();
                        ((PSDEUIActionBase)object5).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                        ((PSDEUIActionBase)object5).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                        pSCoreSysServiceBase.compileModelV2(object5, null, string, file.getCanonicalPath(), n);
                    }
                }
            }
        }
        pSCoreSysServiceBase = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object4 = (ObjectNode)arrayNode.get(i);
                object3 = new PSWFProcess();
                ((PSWFProcessBase)object3).setPSSystemId(pSWFVersion.getPSSystemId());
                ((PSWFProcessBase)object3).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                ((PSWFProcessBase)object3).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                ((PSWFProcessBase)object3).setWFEngineType(pSWFVersion.getWFEngineType());
                pSCoreSysServiceBase.compileModelV2(object3, (ObjectNode)object4, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object4 = new File(string6);
            if (((File)object4).exists()) {
                object2 = object3 = ((File)object4).listFiles();
                n3 = ((File[])object2).length;
                for (n2 = 0; n2 < n3; ++n2) {
                    file = object2[n2];
                    if (!file.isDirectory()) continue;
                    object5 = new PSWFProcess();
                    ((PSWFProcessBase)object5).setPSSystemId(pSWFVersion.getPSSystemId());
                    ((PSWFProcessBase)object5).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    ((PSWFProcessBase)object5).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    ((PSWFProcessBase)object5).setWFEngineType(pSWFVersion.getWFEngineType());
                    pSCoreSysServiceBase.compileModelV2(object5, null, string, file.getCanonicalPath(), n);
                }
            }
        }
        if (!PSWFVersionServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (int i = 0; i < arrayNode.size(); ++i) {
                    object4 = (ObjectNode)arrayNode.get(i);
                    object3 = new PSWFUtilUIAction();
                    ((PSWFUtilUIActionBase)object3).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    ((PSWFUtilUIActionBase)object3).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    pSCoreSysServiceBase.compileModelV2(object3, (ObjectNode)object4, string, null, n);
                }
            } else {
                String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                object4 = new File(string7);
                if (((File)object4).exists()) {
                    object2 = object3 = ((File)object4).listFiles();
                    n3 = ((File[])object2).length;
                    for (n2 = 0; n2 < n3; ++n2) {
                        file = object2[n2];
                        if (!file.isDirectory()) continue;
                        object5 = new PSWFUtilUIAction();
                        ((PSWFUtilUIActionBase)object5).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                        ((PSWFUtilUIActionBase)object5).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                        pSCoreSysServiceBase.compileModelV2(object5, null, string, file.getCanonicalPath(), n);
                    }
                }
            }
        }
        pSCoreSysServiceBase = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object4 = (ObjectNode)arrayNode.get(i);
                object3 = new PSWFLink();
                ((PSWFLinkBase)object3).setPSSystemId(pSWFVersion.getPSSystemId());
                ((PSWFLinkBase)object3).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                ((PSWFLinkBase)object3).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                ((PSWFLinkBase)object3).setWFEngineType(pSWFVersion.getWFEngineType());
                pSCoreSysServiceBase.compileModelV2(object3, (ObjectNode)object4, string, null, n);
            }
        } else {
            String string8 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object4 = new File(string8);
            if (((File)object4).exists()) {
                object2 = object3 = ((File)object4).listFiles();
                n3 = ((File[])object2).length;
                for (n2 = 0; n2 < n3; ++n2) {
                    file = object2[n2];
                    if (!file.isDirectory()) continue;
                    object5 = new PSWFLink();
                    ((PSWFLinkBase)object5).setPSSystemId(pSWFVersion.getPSSystemId());
                    ((PSWFLinkBase)object5).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    ((PSWFLinkBase)object5).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    ((PSWFLinkBase)object5).setWFEngineType(pSWFVersion.getWFEngineType());
                    pSCoreSysServiceBase.compileModelV2(object5, null, string, file.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n5 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object3 = (ObjectNode)arrayNode.get(i);
                object2 = new PSWFLinkCond();
                ((PSWFLinkCondBase)object2).setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                ((PSWFLinkCondBase)object2).setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                ((PSWFLinkCondBase)object2).setOrderValue(n5 += 10);
                pSCoreSysServiceBase.compileModelV2(object2, (ObjectNode)object3, string, null, n);
            }
        } else {
            object4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object3 = new File((String)object4);
            if (((File)object3).exists()) {
                for (Object object5 : object2 = ((File)object3).listFiles()) {
                    if (!((File)object5).isDirectory()) continue;
                    PSWFLinkCond pSWFLinkCond = new PSWFLinkCond();
                    pSWFLinkCond.setPSWFVersionId(pSWFVersion.getPSWFVersionId());
                    pSWFLinkCond.setPSWFVersionName(pSWFVersion.getPSWFVersionName());
                    pSCoreSysServiceBase.compileModelV2(pSWFLinkCond, null, string, ((File)object5).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSWFVersion, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSWFVersion pSWFVersion, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEUAGROUP_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEUAGroups(pSWFVersion, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEUIACTION_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEUIActions(pSWFVersion, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFPROCESS_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFProcesses(pSWFVersion, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSWFLINK_PSWFVERSION_PSWFVERSIONID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSWFLinks(pSWFVersion, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSWFVersion, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEUAGroups(PSWFVersion pSWFVersion, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEUAGROUP", true), (boolean)false) == 0) {
            PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
            pSDEUAGroup.setPSDEUAGroupId(pSMOSFile.getPSModelId());
            if (!pSDEUAGroupService.get((IEntity)pSDEUAGroup, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEUAGroup.getPSWFVersionId(), (String)pSWFVersion.getPSWFVersionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEUAGroupService.exportModelV2(pSDEUAGroup);
            pSDEUAGroup.reset();
            if (!pSDEUAGroupService.setModelV2ResScope((IEntity)pSDEUAGroup, "PSWFVERSION", pSWFVersion.getPSWFVersionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEUAGroupService.importModelV2(pSDEUAGroup, objectNode);
            SessionFactoryManager.commit();
            return pSDEUAGroupService.getFile((IEntity)pSDEUAGroup);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEUIActions(PSWFVersion pSWFVersion, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEUIACTION", true), (boolean)false) == 0) {
            PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = new PSDEUIAction();
            pSDEUIAction.setPSDEUIActionId(pSMOSFile.getPSModelId());
            if (!pSDEUIActionService.get((IEntity)pSDEUIAction, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEUIAction.getPSWFVersionId(), (String)pSWFVersion.getPSWFVersionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEUIActionService.exportModelV2(pSDEUIAction);
            pSDEUIAction.reset();
            if (!pSDEUIActionService.setModelV2ResScope((IEntity)pSDEUIAction, "PSWFVERSION", pSWFVersion.getPSWFVersionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEUIActionService.importModelV2(pSDEUIAction, objectNode);
            SessionFactoryManager.commit();
            return pSDEUIActionService.getFile((IEntity)pSDEUIAction);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWFProcesses(PSWFVersion pSWFVersion, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFPROCESS", true), (boolean)false) == 0) {
            PSWFProcessService pSWFProcessService = (PSWFProcessService)ServiceGlobal.getService(PSWFProcessService.class, (SessionFactory)this.getSessionFactory());
            PSWFProcess pSWFProcess = new PSWFProcess();
            pSWFProcess.setPSWFProcessId(pSMOSFile.getPSModelId());
            if (!pSWFProcessService.get((IEntity)pSWFProcess, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFProcess.getPSWFVersionId(), (String)pSWFVersion.getPSWFVersionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFProcessService.exportModelV2(pSWFProcess);
            pSWFProcess.reset();
            if (!pSWFProcessService.setModelV2ResScope((IEntity)pSWFProcess, "PSWFVERSION", pSWFVersion.getPSWFVersionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFProcessService.importModelV2(pSWFProcess, objectNode);
            SessionFactoryManager.commit();
            return pSWFProcessService.getFile((IEntity)pSWFProcess);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSWFLinks(PSWFVersion pSWFVersion, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSWFLINK", true), (boolean)false) == 0) {
            PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
            PSWFLink pSWFLink = new PSWFLink();
            pSWFLink.setPSWFLinkId(pSMOSFile.getPSModelId());
            if (!pSWFLinkService.get((IEntity)pSWFLink, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSWFLink.getPSWFVersionId(), (String)pSWFVersion.getPSWFVersionId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSWFLinkService.exportModelV2(pSWFLink);
            pSWFLink.reset();
            if (!pSWFLinkService.setModelV2ResScope((IEntity)pSWFLink, "PSWFVERSION", pSWFVersion.getPSWFVersionId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSWFLinkService.importModelV2(pSWFLink, objectNode);
            SessionFactoryManager.commit();
            return pSWFLinkService.getFile((IEntity)pSWFLink);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSWFVersion pSWFVersion, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEUAGroups(pSWFVersion, list);
        this.onFillPasteHelps_PSDEUIActions(pSWFVersion, list);
        this.onFillPasteHelps_PSWFProcesses(pSWFVersion, list);
        this.onFillPasteHelps_PSWFLinks(pSWFVersion, list);
        super.onFillPasteHelps(pSWFVersion, list);
    }

    protected void onFillPasteHelps_PSDEUAGroups(PSWFVersion pSWFVersion, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEUAGROUP");
        pSHelpSection.setSectionParam2("DER1N_PSDEUAGROUP_PSWFVERSION_PSWFVERSIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5b9a\u4e49\u7248\u672c]\u7684[\u5b9e\u4f53\u754c\u9762\u884c\u4e3a\u7ec4]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEUIActions(PSWFVersion pSWFVersion, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEUIACTION");
        pSHelpSection.setSectionParam2("DER1N_PSDEUIACTION_PSWFVERSION_PSWFVERSIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5b9a\u4e49\u7248\u672c]\u7684[\u5b9e\u4f53\u754c\u9762\u884c\u4e3a]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWFProcesses(PSWFVersion pSWFVersion, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFPROCESS");
        pSHelpSection.setSectionParam2("DER1N_PSWFPROCESS_PSWFVERSION_PSWFVERSIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5b9a\u4e49\u7248\u672c]\u7684[\u6d41\u7a0b\u5904\u7406\u8282\u70b9]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSWFLinks(PSWFVersion pSWFVersion, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSWFLINK");
        pSHelpSection.setSectionParam2("DER1N_PSWFLINK_PSWFVERSION_PSWFVERSIONID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u6d41\u7a0b\u5b9a\u4e49\u7248\u672c]\u7684[\u6d41\u7a0b\u5904\u7406\u8fde\u63a5]");
        list.add(pSHelpSection);
    }
}

