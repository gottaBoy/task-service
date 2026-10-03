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
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JsonNodeHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.dedesign.service;

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
import net.ibizsys.paas.db.SelectCond;
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
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIAggTableServiceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDataQueryDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataQueryDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoin;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDQJoinBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainState;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMainStateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDQJoinServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDSDQServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFVRCondServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDQService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDQServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivRoleServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERDEFMapServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDESADetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewServiceServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDataQueryServiceBase
extends PSCoreSysServiceBase<PSDEDataQuery> {
    private static final Log log = LogFactory.getLog(PSDEDataQueryServiceBase.class);
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEDEDATASET = "CreateDEDataSet";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_X_GENERATECODE = "X_GENERATECODE";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_PREVIEWSAVE = "PreviewSave";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSDEDataQueryDEModel pSDEDataQueryDEModel;
    private PSDEDataQueryDAO pSDEDataQueryDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService";
    }

    public PSDEDataQueryDEModel getPSDEDataQueryDEModel() {
        if (this.pSDEDataQueryDEModel == null) {
            try {
                this.pSDEDataQueryDEModel = (PSDEDataQueryDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataQueryDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataQueryDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDataQueryDEModel();
    }

    public PSDEDataQueryDAO getPSDEDataQueryDAO() {
        if (this.pSDEDataQueryDAO == null) {
            try {
                this.pSDEDataQueryDAO = (PSDEDataQueryDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDataQueryDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataQueryDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDataQueryDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)ACTION_CREATEDEDATASET, (boolean)true) == 0) {
            this.createDEDataSet((PSDEDataQuery)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSDEDataQuery)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_X_GENERATECODE, (boolean)true) == 0) {
            this.generateCode((PSDEDataQuery)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDEDataQuery)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDEDataQuery)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEDataQuery)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PREVIEWSAVE, (boolean)true) == 0) {
            this.previewSave((PSDEDataQuery)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEDataQuery)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
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

    public void createDEDataSet(PSDEDataQuery pSDEDataQuery) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEDATASET, 0, pSDEDataQuery, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEDataQuery, ACTION_CREATEDEDATASET);
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataQueryServiceBase.this.getService(), PSDEDataQueryServiceBase.ACTION_CREATEDEDATASET, 40, pSDEDataQuery2, null).getResult() != 1) {
                    PSDEDataQueryServiceBase.this.onCreateDEDataSet(pSDEDataQuery2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEDEDATASET, 99, pSDEDataQuery, null);
        }
    }

    protected void onCreateDEDataSet(PSDEDataQuery pSDEDataQuery) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateDEDataSet]");
    }

    public void createWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSDEDataQuery, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEDataQuery, ACTION_CREATEWITHMODEL);
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataQueryServiceBase.this.getService(), PSDEDataQueryServiceBase.ACTION_CREATEWITHMODEL, 40, pSDEDataQuery2, null).getResult() != 1) {
                    PSDEDataQueryServiceBase.this.onCreateWithModel(pSDEDataQuery2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSDEDataQuery, null);
        }
    }

    protected void onCreateWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void generateCode(PSDEDataQuery pSDEDataQuery) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_X_GENERATECODE, 0, pSDEDataQuery, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEDataQuery, ACTION_X_GENERATECODE);
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataQueryServiceBase.this.getService(), PSDEDataQueryServiceBase.ACTION_X_GENERATECODE, 40, pSDEDataQuery2, null).getResult() != 1) {
                    PSDEDataQueryServiceBase.this.onGenerateCode(pSDEDataQuery2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_X_GENERATECODE, 99, pSDEDataQuery, null);
        }
    }

    protected void onGenerateCode(PSDEDataQuery pSDEDataQuery) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[X_GENERATECODE]");
    }

    public void getDraftFromWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, pSDEDataQuery, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEDataQuery, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataQueryServiceBase.this.getService(), PSDEDataQueryServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, pSDEDataQuery2, null).getResult() != 1) {
                    PSDEDataQueryServiceBase.this.onGetDraftFromWithModel(pSDEDataQuery2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, pSDEDataQuery, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, pSDEDataQuery, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEDataQuery, ACTION_GETDRAFTWITHMODEL);
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataQueryServiceBase.this.getService(), PSDEDataQueryServiceBase.ACTION_GETDRAFTWITHMODEL, 40, pSDEDataQuery2, null).getResult() != 1) {
                    PSDEDataQueryServiceBase.this.onGetDraftWithModel(pSDEDataQuery2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, pSDEDataQuery, null);
        }
    }

    protected void onGetDraftWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSDEDataQuery, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEDataQuery, ACTION_GETWITHMODEL);
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataQueryServiceBase.this.getService(), PSDEDataQueryServiceBase.ACTION_GETWITHMODEL, 40, pSDEDataQuery2, null).getResult() != 1) {
                    PSDEDataQueryServiceBase.this.onGetWithModel(pSDEDataQuery2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSDEDataQuery, null);
        }
    }

    protected void onGetWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void previewSave(PSDEDataQuery pSDEDataQuery) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 0, pSDEDataQuery, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEDataQuery, ACTION_PREVIEWSAVE);
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataQueryServiceBase.this.getService(), PSDEDataQueryServiceBase.ACTION_PREVIEWSAVE, 40, pSDEDataQuery2, null).getResult() != 1) {
                    PSDEDataQueryServiceBase.this.onPreviewSave(pSDEDataQuery2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 99, pSDEDataQuery, null);
        }
    }

    protected void onPreviewSave(PSDEDataQuery pSDEDataQuery) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PreviewSave]");
    }

    public void updateWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSDEDataQuery, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEDataQuery, ACTION_UPDATEWITHMODEL);
        final PSDEDataQuery pSDEDataQuery2 = pSDEDataQuery;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataQueryServiceBase.this.getService(), PSDEDataQueryServiceBase.ACTION_UPDATEWITHMODEL, 40, pSDEDataQuery2, null).getResult() != 1) {
                    PSDEDataQueryServiceBase.this.onUpdateWithModel(pSDEDataQuery2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSDEDataQuery, null);
        }
    }

    protected void onUpdateWithModel(PSDEDataQuery pSDEDataQuery) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEDataQuery pSDEDataQuery, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAQUERY_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDataQuery, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAQUERY_PSDEFGROUP_PSDEFGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService", (SessionFactory)this.getSessionFactory());
            PSDEFGroup pSDEFGroup = (PSDEFGroup)iService.getDEModel().createEntity();
            pSDEFGroup.set("PSDEFGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEFGroup);
            } else {
                iService.get(pSDEFGroup);
            }
            this.onFillParentInfo_PSDEFGroup(pSDEDataQuery, pSDEFGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAQUERY_PSDEMAINSTATE_PSDEMAINSTATEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService", (SessionFactory)this.getSessionFactory());
            PSDEMainState pSDEMainState = (PSDEMainState)iService.getDEModel().createEntity();
            pSDEMainState.set("PSDEMAINSTATEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEMainState);
            } else {
                iService.get(pSDEMainState);
            }
            this.onFillParentInfo_PSDEMainState(pSDEDataQuery, pSDEMainState);
            return;
        }
        super.onFillParentInfo(pSDEDataQuery, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSDE(PSDEDataQuery pSDEDataQuery, PSDataEntity pSDataEntity) throws Exception {
        pSDEDataQuery.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDataQuery.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEFGroup(PSDEDataQuery pSDEDataQuery, PSDEFGroup pSDEFGroup) throws Exception {
        pSDEDataQuery.setPSDEFGroupId(pSDEFGroup.getPSDEFGroupId());
        pSDEDataQuery.setPSDEFGroupName(pSDEFGroup.getPSDEFGroupName());
    }

    protected void onFillParentInfo_PSDEMainState(PSDEDataQuery pSDEDataQuery, PSDEMainState pSDEMainState) throws Exception {
        pSDEDataQuery.setPSDEMainStateId(pSDEMainState.getPSDEMainStateId());
        pSDEDataQuery.setPSDEMainStateName(pSDEMainState.getPSDEMainStateName());
    }

    protected void onFillEntityFullInfo(PSDEDataQuery pSDEDataQuery, boolean bl) throws Exception {
        if (bl) {
            if (pSDEDataQuery.getCodeName() == null) {
                pSDEDataQuery.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "DataQuery", 25));
            }
            if (pSDEDataQuery.getCustomMode() == null) {
                pSDEDataQuery.setCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEDataQuery.getDefaultMode() == null) {
                pSDEDataQuery.setDefaultMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEDataQuery.getLogicName() == null) {
                pSDEDataQuery.setLogicName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u6570\u636e\u67e5\u8be2", 25));
            }
            if (pSDEDataQuery.getPrivMode() == null) {
                pSDEDataQuery.setPrivMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEDataQuery.getPSDEDataQueryName() == null) {
                pSDEDataQuery.setPSDEDataQueryName((String)this.getDefaultValue(this.getWebContext(), "USER", "DATAQUERY", 25));
            }
        }
        super.onFillEntityFullInfo(pSDEDataQuery, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDataQuery, bl);
        this.onFillEntityFullInfo_PSDEFGroup(pSDEDataQuery, bl);
        this.onFillEntityFullInfo_PSDEMainState(pSDEDataQuery, bl);
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDataQuery pSDEDataQuery, boolean bl) throws Exception {
        if (pSDEDataQuery.isPSDEIdDirty()) {
            if (pSDEDataQuery.getPSDEId() != null) {
                if (pSDEDataQuery.getPSDEId() == null || pSDEDataQuery.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDataQuery.getPSDE();
                    pSDEDataQuery.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEDataQuery.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFGroup(PSDEDataQuery pSDEDataQuery, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEMainState(PSDEDataQuery pSDEDataQuery, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDataQuery pSDEDataQuery, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEDataQuery, bl);
    }

    public ArrayList<PSDEDataQuery> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDataQuery> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDataQuery> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataQuery> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, "", -1);
    }

    public ArrayList<PSDEDataQuery> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string) throws Exception {
        return this.selectByPSDEFGroup(pSDEFGroupBase, string, -1);
    }

    public ArrayList<PSDEDataQuery> selectByPSDEFGroup(PSDEFGroupBase pSDEFGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataQuery> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, "", -1);
    }

    public ArrayList<PSDEDataQuery> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string) throws Exception {
        return this.selectByPSDEMainState(pSDEMainStateBase, string, -1);
    }

    public ArrayList<PSDEDataQuery> selectByPSDEMainState(PSDEMainStateBase pSDEMainStateBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEMAINSTATEID", (Object)pSDEMainStateBase.getPSDEMainStateId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEMainStateCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEMainStateCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataQuery> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDataQuery pSDEDataQuery : arrayList) {
            PSDEDataQuery pSDEDataQuery2 = (PSDEDataQuery)this.getDEModel().createEntity();
            pSDEDataQuery2.setPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
            pSDEDataQuery2.setPSDEId(null);
            this.update(pSDEDataQuery2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataQueryServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDataQueryServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDataQueryServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataQuery> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDataQuery pSDEDataQuery : arrayList) {
            this.remove(pSDEDataQuery);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataQuery> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataQuery> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEDataQuery> arrayList = this.selectByPSDEFGroup(pSDEFGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEFGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAQUERY_PSDEFGROUP_PSDEFGROUPID", "", iDataEntityModel.getName(), "PSDEDATAQUERY", iDataEntityModel.getDataInfo(pSDEFGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEDataQuery> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        for (PSDEDataQuery pSDEDataQuery : arrayList) {
            PSDEDataQuery pSDEDataQuery2 = (PSDEDataQuery)this.getDEModel().createEntity();
            pSDEDataQuery2.setPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
            pSDEDataQuery2.setPSDEFGroupId(null);
            this.update(pSDEDataQuery2);
        }
    }

    public void removeByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        final PSDEFGroup pSDEFGroup2 = pSDEFGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataQueryServiceBase.this.onBeforeRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEDataQueryServiceBase.this.internalRemoveByPSDEFGroup(pSDEFGroup2);
                PSDEDataQueryServiceBase.this.onAfterRemoveByPSDEFGroup(pSDEFGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void internalRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
        ArrayList<PSDEDataQuery> arrayList = this.selectByPSDEFGroup(pSDEFGroup);
        this.onBeforeRemoveByPSDEFGroup(pSDEFGroup, arrayList);
        for (PSDEDataQuery pSDEDataQuery : arrayList) {
            this.remove(pSDEDataQuery);
        }
        this.onAfterRemoveByPSDEFGroup(pSDEFGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEDataQuery> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFGroup(PSDEFGroup pSDEFGroup, ArrayList<PSDEDataQuery> arrayList) throws Exception {
    }

    public void testRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEDataQuery> arrayList = this.selectByPSDEMainState(pSDEMainState, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEMAINSTATE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEMainState);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAQUERY_PSDEMAINSTATE_PSDEMAINSTATEID", "", iDataEntityModel.getName(), "PSDEDATAQUERY", iDataEntityModel.getDataInfo(pSDEMainState), arrayList.get(0)));
        }
    }

    public void resetPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEDataQuery> arrayList = this.selectByPSDEMainState(pSDEMainState);
        for (PSDEDataQuery pSDEDataQuery : arrayList) {
            PSDEDataQuery pSDEDataQuery2 = (PSDEDataQuery)this.getDEModel().createEntity();
            pSDEDataQuery2.setPSDEDataQueryId(pSDEDataQuery.getPSDEDataQueryId());
            pSDEDataQuery2.setPSDEMainStateId(null);
            this.update(pSDEDataQuery2);
        }
    }

    public void removeByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        final PSDEMainState pSDEMainState2 = pSDEMainState;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataQueryServiceBase.this.onBeforeRemoveByPSDEMainState(pSDEMainState2);
                PSDEDataQueryServiceBase.this.internalRemoveByPSDEMainState(pSDEMainState2);
                PSDEDataQueryServiceBase.this.onAfterRemoveByPSDEMainState(pSDEMainState2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void internalRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
        ArrayList<PSDEDataQuery> arrayList = this.selectByPSDEMainState(pSDEMainState);
        this.onBeforeRemoveByPSDEMainState(pSDEMainState, arrayList);
        for (PSDEDataQuery pSDEDataQuery : arrayList) {
            this.remove(pSDEDataQuery);
        }
        this.onAfterRemoveByPSDEMainState(pSDEMainState, arrayList);
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState) throws Exception {
    }

    protected void onBeforeRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEDataQuery> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEMainState(PSDEMainState pSDEMainState, ArrayList<PSDEDataQuery> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDataQuery pSDEDataQuery) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEActionLogicService)ServiceGlobal.getService(PSDEActionLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionLogicServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEDataQuery(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEActionServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataQuery(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQCodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQ(pSDEDataQuery);
        ((PSDEDQCodeServiceBase)pSCoreSysServiceBase).removeByPSDEDQ(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQ(pSDEDataQuery);
        ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).removeByPSDEDQ(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDELogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEDataQuery(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDQServiceBase)pSCoreSysServiceBase).testRemoveByDstPSDEDataQuery(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMapDQServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataQuery(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEOPPrivRoleService)ServiceGlobal.getService(PSDEOPPrivRoleService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEOPPrivRoleServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQ(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDESADetailService)ServiceGlobal.getService(PSDESADetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDESADetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQ(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEViewServiceService)ServiceGlobal.getService(PSDEViewServiceService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewServiceServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQ(pSDEDataQuery);
        pSCoreSysServiceBase = (PSSysBIAggTableService)ServiceGlobal.getService(PSSysBIAggTableService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIAggTableServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataQuery(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEDSDQService)ServiceGlobal.getService(PSDEDSDQService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDSDQServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQ(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEFVRCondService)ServiceGlobal.getService(PSDEFVRCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFVRCondServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQ(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQ(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDERDEFMapService)ServiceGlobal.getService(PSDERDEFMapService.class, (SessionFactory)this.getSessionFactory());
        ((PSDERDEFMapServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDQ(pSDEDataQuery);
        super.onBeforeRemove(pSDEDataQuery);
    }

    protected void onBeforeRemoveTemp(PSDEDataQuery pSDEDataQuery) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQCondServiceBase)pSCoreSysServiceBase).removeTempByPSDEDQ(pSDEDataQuery);
        pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).removeTempByPSDEDQ(pSDEDataQuery);
        super.onBeforeRemoveTemp(pSDEDataQuery);
    }

    protected void getRelatedDataTempMajor(PSDEDataQuery pSDEDataQuery) throws Exception {
        this.getRelatedDataTempMajor_PSDEDQJoin(pSDEDataQuery);
        this.getRelatedDataTempMajor_PSDEDQCond(pSDEDataQuery);
        super.getRelatedDataTempMajor(pSDEDataQuery);
    }

    protected void getRelatedDataTempMajor_PSDEDQJoin(PSDEDataQuery pSDEDataQuery) throws Exception {
        PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQJoin> arrayList = null;
        String string = pSDEDataQuery.getPSDEDataQueryId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDQJoinService.selectByPSDEDQ(pSDEDataQuery) : pSDEDQJoinService.selectTempByPSDEDQ(pSDEDataQuery);
        PSDEDataQueryServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEDQJOINID", (String)"PPSDEDQJOINID");
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            pSDEDQJoinService.getTempMajor(pSDEDQJoin);
        }
    }

    protected void getRelatedDataTempMajor_PSDEDQCond(PSDEDataQuery pSDEDataQuery) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCond> arrayList = null;
        String string = pSDEDataQuery.getPSDEDataQueryId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDQCondService.selectByPSDEDQ(pSDEDataQuery) : pSDEDQCondService.selectTempByPSDEDQ(pSDEDataQuery);
        PSDEDataQueryServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEDQCONDID", (String)"PPSDEDQCONDID");
        for (PSDEDQCond pSDEDQCond : arrayList) {
            pSDEDQCondService.getTempMajor(pSDEDQCond);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEDataQuery pSDEDataQuery, PSDEDataQuery pSDEDataQuery2) throws Exception {
        ArrayList<PSDEDQCond> arrayList = this.updateRelatedDataTempMajor_removePSDEDQCond(pSDEDataQuery, pSDEDataQuery2);
        ArrayList<PSDEDQJoin> arrayList2 = this.updateRelatedDataTempMajor_removePSDEDQJoin(pSDEDataQuery, pSDEDataQuery2);
        this.updateRelatedDataTempMajor_updatePSDEDQJoin(pSDEDataQuery, pSDEDataQuery2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEDQCond(pSDEDataQuery, pSDEDataQuery2, arrayList);
        super.updateRelatedDataTempMajor(pSDEDataQuery, pSDEDataQuery2);
    }

    protected ArrayList<PSDEDQJoin> updateRelatedDataTempMajor_removePSDEDQJoin(PSDEDataQuery pSDEDataQuery, PSDEDataQuery pSDEDataQuery2) throws Exception {
        PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQJoin> arrayList = pSDEDQJoinService.selectTempByPSDEDQ(pSDEDataQuery);
        ArrayList<PSDEDQJoin> arrayList2 = pSDEDQJoinService.selectByPSDEDQ(pSDEDataQuery2);
        HashMap<String, PSDEDQJoin> hashMap = new HashMap<String, PSDEDQJoin>();
        for (PSDEDQJoin pSDEDQJoin : arrayList2) {
            hashMap.put(pSDEDQJoin.getPSDEDQJoinId(), pSDEDQJoin);
        }
        PSDEDataQueryServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEDQJOINID", (String)"PPSDEDQJOINID");
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            Object object = pSDEDQJoin.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDQJoin pSDEDQJoin : hashMap.values()) {
            pSDEDQJoinService.remove(pSDEDQJoin);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDQJoin(PSDEDataQuery pSDEDataQuery, PSDEDataQuery pSDEDataQuery2, ArrayList<PSDEDQJoin> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            pSDEDQJoinService.updateTempMajor(pSDEDQJoin);
        }
    }

    protected ArrayList<PSDEDQCond> updateRelatedDataTempMajor_removePSDEDQCond(PSDEDataQuery pSDEDataQuery, PSDEDataQuery pSDEDataQuery2) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCond> arrayList = pSDEDQCondService.selectTempByPSDEDQ(pSDEDataQuery);
        ArrayList<PSDEDQCond> arrayList2 = pSDEDQCondService.selectByPSDEDQ(pSDEDataQuery2);
        HashMap<String, PSDEDQCond> hashMap = new HashMap<String, PSDEDQCond>();
        for (PSDEDQCond pSDEDQCond : arrayList2) {
            hashMap.put(pSDEDQCond.getPSDEDQCondId(), pSDEDQCond);
        }
        PSDEDataQueryServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEDQCONDID", (String)"PPSDEDQCONDID");
        for (PSDEDQCond pSDEDQCond : arrayList) {
            Object object = pSDEDQCond.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDQCond pSDEDQCond : hashMap.values()) {
            pSDEDQCondService.remove(pSDEDQCond);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDQCond(PSDEDataQuery pSDEDataQuery, PSDEDataQuery pSDEDataQuery2, ArrayList<PSDEDQCond> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDQCond pSDEDQCond : arrayList) {
            pSDEDQCondService.updateTempMajor(pSDEDQCond);
        }
    }

    protected void replaceParentInfo(PSDEDataQuery pSDEDataQuery, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEDataQuery, cloneSession);
        if (pSDEDataQuery.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDataQuery.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDataQuery, (PSDataEntity)iEntity);
        }
        if (pSDEDataQuery.getPSDEFGroupId() != null && (iEntity = cloneSession.getEntity("PSDEFGROUP", (Object)pSDEDataQuery.getPSDEFGroupId())) != null) {
            this.onFillParentInfo_PSDEFGroup(pSDEDataQuery, (PSDEFGroup)iEntity);
        }
        if (pSDEDataQuery.getPSDEMainStateId() != null && (iEntity = cloneSession.getEntity("PSDEMAINSTATE", (Object)pSDEDataQuery.getPSDEMainStateId())) != null) {
            this.onFillParentInfo_PSDEMainState(pSDEDataQuery, (PSDEMainState)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDataQuery pSDEDataQuery, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEDataQuery, bl);
        pSDEDataQuery.resetCodeName();
        pSDEDataQuery.resetDefaultMode();
        pSDEDataQuery.resetViewColLevel();
    }

    protected void onCheckEntity(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEDataQuery, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultMode(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DQJoinModel(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DQOption(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DQSN(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DQTag(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DQTag2(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DQTag3(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DQTag4(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePQL(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ExtendMode(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FilterModel(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PrivMode(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataQueryId(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataQueryName(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFGroupId(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEMainStateId(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PubMode(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QueryViewFlag(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestMethod(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RequestPath(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ServiceCodeName(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubSysSADetailMode(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewColLevel(bl, pSDEDataQuery, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEDataQuery, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isCodeNameDirty() : !pSDEDataQuery.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEDataQuery, bl2, bl3);
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
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEDataQueryDEModel(), "CODENAME", string3, pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isCustomCodeDirty() : !pSDEDataQuery.isCustomCodeDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isCustomModeDirty() : !pSDEDataQuery.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DefaultMode(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isDefaultModeDirty() : !pSDEDataQuery.isDefaultModeDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getDefaultMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultMode_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            bl4 = DataTypeHelper.compare((int)9, (Object)n, (Object)"1") == 0L;
            if (bl4) {
                String string = "";
                string = "PSDEID";
                String string2 = this.checkFieldDupRule(this.getPSDEDataQueryDEModel(), "DEFAULTMODE", string, pSDEDataQuery, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string2)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("DEFAULTMODE");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string2);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DQJoinModel(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isDQJoinModelDirty() : !pSDEDataQuery.isDQJoinModelDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getDQJoinModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DQJoinModel_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DQJOINMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DQOption(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isDQOptionDirty() : !pSDEDataQuery.isDQOptionDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getDQOption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DQOption_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DQOPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DQSN(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isDQSNDirty() : !pSDEDataQuery.isDQSNDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getDQSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DQSN_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DQSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DQTag(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isDQTagDirty() : !pSDEDataQuery.isDQTagDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getDQTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DQTag_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DQTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DQTag2(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isDQTag2Dirty() : !pSDEDataQuery.isDQTag2Dirty()) {
            return null;
        }
        String string = pSDEDataQuery.getDQTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DQTag2_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DQTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DQTag3(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isDQTag3Dirty() : !pSDEDataQuery.isDQTag3Dirty()) {
            return null;
        }
        String string = pSDEDataQuery.getDQTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DQTag3_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DQTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DQTag4(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isDQTag4Dirty() : !pSDEDataQuery.isDQTag4Dirty()) {
            return null;
        }
        String string = pSDEDataQuery.getDQTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DQTag4_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DQTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isDynaModelFlagDirty() : !pSDEDataQuery.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnablePQL(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isEnablePQLDirty() : !pSDEDataQuery.isEnablePQLDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getEnablePQL();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePQL_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPQL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ExtendMode(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isExtendModeDirty() : !pSDEDataQuery.isExtendModeDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getExtendMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ExtendMode_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_FilterModel(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isFilterModelDirty() : !pSDEDataQuery.isFilterModelDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getFilterModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FilterModel_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FILTERMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isLockFlagDirty() : !pSDEDataQuery.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isLogicNameDirty() : !pSDEDataQuery.isLogicNameDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isMemoDirty() : !pSDEDataQuery.isMemoDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isOrderValueDirty() : !pSDEDataQuery.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PrivMode(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isPrivModeDirty() : !pSDEDataQuery.isPrivModeDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getPrivMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PrivMode_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PRIVMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataQueryId(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isPSDEDataQueryIdDirty() && !bl2 : !pSDEDataQuery.isPSDEDataQueryIdDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getPSDEDataQueryId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAQUERYID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataQueryId_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAQUERYID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataQueryName(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isPSDEDataQueryNameDirty() && !bl2 : !pSDEDataQuery.isPSDEDataQueryNameDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getPSDEDataQueryName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAQUERYNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataQueryName_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAQUERYNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEDataQueryDEModel(), "PSDEDATAQUERYNAME", string3, pSDEDataQuery, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEDATAQUERYNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFGroupId(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isPSDEFGroupIdDirty() : !pSDEDataQuery.isPSDEFGroupIdDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getPSDEFGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFGroupId_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isPSDEIdDirty() && !bl2 : !pSDEDataQuery.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEMainStateId(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isPSDEMainStateIdDirty() : !pSDEDataQuery.isPSDEMainStateIdDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getPSDEMainStateId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEMainStateId_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEMAINSTATEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isPSDENameDirty() && !bl2 : !pSDEDataQuery.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isPSDynaInstIdDirty() : !pSDEDataQuery.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_PubMode(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isPubModeDirty() : !pSDEDataQuery.isPubModeDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getPubMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PubMode_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QueryViewFlag(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isQueryViewFlagDirty() : !pSDEDataQuery.isQueryViewFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getQueryViewFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_QueryViewFlag_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUERYVIEWFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RequestMethod(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isRequestMethodDirty() : !pSDEDataQuery.isRequestMethodDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getRequestMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestMethod_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQUESTMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RequestPath(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isRequestPathDirty() : !pSDEDataQuery.isRequestPathDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getRequestPath();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RequestPath_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REQUESTPATH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ServiceCodeName(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isServiceCodeNameDirty() : !pSDEDataQuery.isServiceCodeNameDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getServiceCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ServiceCodeName_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SERVICECODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SubSysSADetailMode(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isSubSysSADetailModeDirty() : !pSDEDataQuery.isSubSysSADetailModeDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getSubSysSADetailMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SubSysSADetailMode_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBSYSSADETAILMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isToDoTaskDirty() : !pSDEDataQuery.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isUserCatDirty() : !pSDEDataQuery.isUserCatDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isUserTagDirty() : !pSDEDataQuery.isUserTagDirty()) {
            return null;
        }
        String string = pSDEDataQuery.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isUserTag2Dirty() : !pSDEDataQuery.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEDataQuery.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isUserTag3Dirty() : !pSDEDataQuery.isUserTag3Dirty()) {
            return null;
        }
        String string = pSDEDataQuery.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isUserTag4Dirty() : !pSDEDataQuery.isUserTag4Dirty()) {
            return null;
        }
        String string = pSDEDataQuery.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isValidFlagDirty() : !pSDEDataQuery.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default(pSDEDataQuery, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewColLevel(boolean bl, PSDEDataQuery pSDEDataQuery, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataQuery.isViewColLevelDirty() : !pSDEDataQuery.isViewColLevelDirty()) {
            return null;
        }
        Integer n = pSDEDataQuery.getViewColLevel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ViewColLevel_Default(pSDEDataQuery, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWCOLLEVEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDataQuery pSDEDataQuery, boolean bl) throws Exception {
        super.onSyncEntity(pSDEDataQuery, bl);
    }

    protected void onSyncIndexEntities(PSDEDataQuery pSDEDataQuery, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEDataQuery, bl);
    }

    public Object getDataContextValue(PSDEDataQuery pSDEDataQuery, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEDataQuery, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEDataQuery.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEDataQuery pSDEDataQuery, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEDQJoin_PSDEDQ(pSDEDataQuery, arrayList, n);
        this.onExportRelatedModel_PSDEDQCond_PSDEDQ(pSDEDataQuery, arrayList, n);
        this.onExportRelatedModel_PSDEDQCode_PSDEDQ(pSDEDataQuery, arrayList, n);
        super.onExportRelatedModel(pSDEDataQuery, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEDQJoin_PSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQJoin> arrayList2 = pSDEDQJoinService.selectByPSDEDQ(pSDEDataQuery);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"86dca81427cd4060905a2dab73458b16");
            jSONObject.put("srfdename", (Object)"PSDEDQJOIN");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDQJOIN_PSDEDATAQUERY_PSDEDQID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDataQuery, (String)"PSDEDATAQUERYID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDQJoin pSDEDQJoin : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDQJoin, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDQJoinService.exportModel(pSDEDQJoin, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEDQCond_PSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCond> arrayList2 = pSDEDQCondService.selectByPSDEDQ(pSDEDataQuery);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"5ed92e75cf44d8f79867a20621018cf0");
            jSONObject.put("srfdename", (Object)"PSDEDQCOND");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDQCOND_PSDEDATAQUERY_PSDEDQID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDataQuery, (String)"PSDEDATAQUERYID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDQCond pSDEDQCond : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDQCond, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDQCondService.exportModel(pSDEDQCond, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEDQCode_PSDEDQ(PSDEDataQuery pSDEDataQuery, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDQCodeService pSDEDQCodeService = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCode> arrayList2 = pSDEDQCodeService.selectByPSDEDQ(pSDEDataQuery);
        for (PSDEDQCode pSDEDQCode : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDQCode, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDQCodeService.exportModel(pSDEDQCode, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEDataQuery pSDEDataQuery, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEDataQuery, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DQJOINMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DQJoinModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DQOPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DQOption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DQSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DQSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DQTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DQTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DQTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DQTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DQTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DQTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DQTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DQTag4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPQL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePQL_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EXTENDMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ExtendMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FILTERMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FilterModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PRIVMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PrivMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERYID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataQueryId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAQUERYNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataQueryName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEMAINSTATENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEMainStateName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PubMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUERYVIEWFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QueryViewFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REQUESTPATH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RequestPath_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SERVICECODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ServiceCodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBSYSSADETAILMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubSysSADetailMode_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWCOLLEVEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewColLevel_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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

    protected String onTestValueRule_CustomMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DefaultMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DQJoinModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DQJOINMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DQOption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DQSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DQSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DQTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DQTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DQTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DQTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DQTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DQTAG3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DQTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DQTAG4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnablePQL_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ExtendMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FilterModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FILTERMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PrivMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSDEDataQueryId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAQUERYID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataQueryName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAQUERYNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSDEDATAQUERYNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_PSDEMainStateId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEMainStateName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEMAINSTATENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PubMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_QueryViewFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RequestMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQUESTMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RequestPath_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REQUESTPATH", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ServiceCodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SERVICECODENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubSysSADetailMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ViewColLevel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEDataQuery pSDEDataQuery) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEDataQuery)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDataQuery pSDEDataQuery) throws Exception {
        Object object = pSDEDataQuery.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDATAQUERY_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEDataQuery);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    @Override
    protected void exportCurXmlModel(PSDEDataQuery pSDEDataQuery, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDATAQUERY");
        if (!bl) {
            pSDEDataQuery.setCreateDate(null);
            pSDEDataQuery.setCreateMan(null);
            pSDEDataQuery.setPSDEDataQueryId(null);
            pSDEDataQuery.setUpdateDate(null);
            pSDEDataQuery.setUpdateMan(null);
            super.exportCurXmlModel(pSDEDataQuery, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEDataQuery pSDEDataQuery, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEDQCond(pSDEDataQuery, xmlNode);
        super.onExportRelatedXmlModel(pSDEDataQuery, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEDQCond(PSDEDataQuery pSDEDataQuery, XmlNode xmlNode) throws Exception {
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQCond> arrayList = null;
        String string = pSDEDataQuery.getPSDEDataQueryId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDQCondService.selectByPSDEDQ(pSDEDataQuery, "ORDER BY ORDERVALUE ASC") : pSDEDQCondService.selectTempByPSDEDQ(pSDEDataQuery, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEDQCONDS");
            xmlNode.addNode(xmlNode2);
            for (PSDEDQCond pSDEDQCond : arrayList) {
                if (pSDEDQCond.getPPSDEDQCondId() != null) continue;
                pSDEDQCond.set("ORDERVALUE", null);
                pSDEDQCondService.exportXmlModel(pSDEDQCond, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEDataQuery pSDEDataQuery, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEDQCONDS");
        this.importRelatedXmlModel_PSDEDQCond(pSDEDataQuery, xmlNode2);
        super.onImportRelatedXmlModel(pSDEDataQuery, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEDQCond(PSDEDataQuery pSDEDataQuery, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEDQCondService pSDEDQCondService = (PSDEDQCondService)ServiceGlobal.getService(PSDEDQCondService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEDataQuery.getPSDEDataQueryId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEDQCondService.removeByPSDEDQ(pSDEDataQuery);
        } else {
            pSDEDQCondService.removeTempByPSDEDQ(pSDEDataQuery);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEDQCond pSDEDQCond = new PSDEDQCond();
                pSDEDQCond.setOrderValue(n);
                n += 100;
                pSDEDQCondService.fillParentInfo(pSDEDQCond, "DER1N", "DER1N_PSDEDQCOND_PSDEDATAQUERY_PSDEDQID", pSDEDataQuery.getPSDEDataQueryId());
                pSDEDQCondService.importXmlModel(pSDEDQCond, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDataQuery pSDEDataQuery, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDataQuery, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEDATAQUERY_PSDATAENTITY_PSDEID";
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
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDATAENTITY", (boolean)true) == 0) {
            iEntity.set("PSDEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID"};
    }

    @Override
    public String getModelV2Tag(PSDEDataQuery pSDEDataQuery) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDataQuery.getPSDEDataQueryName())) {
            return pSDEDataQuery.getPSDEDataQueryName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSDEDataQuery.getCodeName())) {
            return pSDEDataQuery.getCodeName();
        }
        return super.getModelV2Tag(pSDEDataQuery);
    }

    @Override
    public boolean setModelV2Tag(PSDEDataQuery pSDEDataQuery, String string) {
        pSDEDataQuery.setPSDEDataQueryName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEDATAQUERYNAME", "");
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEDATAQUERYNAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEDataQuery pSDEDataQuery, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDataQuery.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDataQuery, true);
        pSDEDataQuery.set("PSDEDATAQUERYNAME", string);
        if (this.select(pSDEDataQuery, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDataQuery, true);
        return super.getModelV2Entity(pSDEDataQuery, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDataQuery pSDEDataQuery, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDataQuery, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEDQCODE_PSDEDATAQUERY_PSDEDQID", (String)string, (boolean)true) == 0) {
            return this.getExportCurModelV2Level() >= 20;
        }
        return StringHelper.compare((String)"DER1N_PSDEDQJOIN_PSDEDATAQUERY_PSDEDQID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEDataQuery pSDEDataQuery, String string, String string2) throws Exception {
        File file = null;
        if (this.isExportRelatedModelV2("DER1N_PSDEDQCODE_PSDEDATAQUERY_PSDEDQID") && (file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATAQUERY#%4$s#ALL.txt", (Object)string2, (Object)File.separator, (Object)"PSDEDQCODE", (Object)pSDEDataQuery.getPSDEDataQueryId()))).exists()) {
            PSDEDQCodeService pSDEDQCodeService = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)this.getSessionFactory());
            String string3 = pSDEDQCodeService.getModelV2Name(false);
            String string4 = string + File.separator + string3;
            File file2 = new File(string4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            ArrayList<String> arrayList = PSModelV2Helper.readFile2(file);
            for (String string5 : arrayList) {
                if (StringHelper.isNullOrEmpty((String)string5)) continue;
                ObjectNode objectNode = (ObjectNode)JsonNodeHelper.fromString((String)string5);
                PSDEDQCode pSDEDQCode = new PSDEDQCode();
                PSModelV2Helper.fromJSONObject((IDataObject)pSDEDQCode, objectNode, false);
                String string6 = pSDEDQCodeService.getModelV2Tag(pSDEDQCode);
                if (StringHelper.isNullOrEmpty((String)string6)) {
                    throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u8ba1\u7b97\u6a21\u578b[%1$s][%2$s]\u6807\u8bb0", (Object)"PSDEDQCODE", (Object)pSDEDQCode.getPSDEDQCodeId()));
                }
                string6 = PSModelV2Helper.getModelV2TagFolderName(string6);
                file2 = new File(string4 + File.separator + string6);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                pSDEDQCodeService.exportModelV2(pSDEDQCode, string4 + File.separator + string6, string2);
            }
        }
        super.onExportRelatedModelV2(pSDEDataQuery, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEDataQuery pSDEDataQuery, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayNode arrayNode;
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDQCODE_PSDEDATAQUERY_PSDEDQID")) {
            pSCoreSysServiceBase = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATAQUERY#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDQCODE", (Object)pSDEDataQuery.getPSDEDataQueryId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEDATAQUERY#%1$s", (Object)pSDEDataQuery.getPSDEDataQueryId());
                for (PSDEDQCode model : ((PSDEDQCodeServiceBase)pSCoreSysServiceBase).selectByPSDEDQ(pSDEDataQuery)) {
                    if (StringHelper.compare(scope, ((PSDEDQCodeServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdedqcodename")) {
                            string = objectNode.get("psdedqcodename").asText();
                        }
                        if (objectNode2.has("psdedqcodename")) {
                            string2 = objectNode2.get("psdedqcodename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEDQCode model = new PSDEDQCode();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDQJOIN_PSDEDATAQUERY_PSDEDQID")) {
            pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATAQUERY#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDQJOIN", (Object)pSDEDataQuery.getPSDEDataQueryId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDEDATAQUERY#%1$s", (Object)pSDEDataQuery.getPSDEDataQueryId());
                for (PSDEDQJoin model : ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).selectByPSDEDQ(pSDEDataQuery)) {
                    if (StringHelper.compare(scope, ((PSDEDQJoinServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(model, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                arrayNode = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdedqjoinname")) {
                            string = objectNode.get("psdedqjoinname").asText();
                        }
                        if (objectNode2.has("psdedqjoinname")) {
                            string2 = objectNode2.get("psdedqjoinname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEDQJoin model = new PSDEDQJoin();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    model.remove("ordervalue");
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEDataQuery, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEDataQuery pSDEDataQuery) throws Exception {
        PSDEDQJoinService pSDEDQJoinService = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDQJoin> arrayList = pSDEDQJoinService.selectByPSDEDQ(pSDEDataQuery);
        String string = StringHelper.format((String)"PSDEDATAQUERY#%1$s", (Object)pSDEDataQuery.getPSDEDataQueryId());
        for (PSDEDQJoin pSDEDQJoin : arrayList) {
            String string2 = pSDEDQJoinService.getModelV2ResScope(pSDEDQJoin);
            if (StringHelper.compare((String)string, (String)string2, (boolean)false) != 0) continue;
            pSDEDQJoinService.emptyModelV2(pSDEDQJoin);
        }
        SqlParamList sqlParamList = new SqlParamList();
        sqlParamList.addString(pSDEDataQuery.getPSDEDataQueryId());
        pSDEDQJoinService.getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        pSDEDQJoinService.getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDQJOIN WHERE PSDEDQID = ?", sqlParamList);
        super.onEmptyModelV2(pSDEDataQuery);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEDataQuery pSDEDataQuery, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEDQCode();
        entityBase.set("PSDEDQID", pSDEDataQuery.getPSDEDataQueryId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEDQJoin();
        entityBase.set("PSDEDQID", pSDEDataQuery.getPSDEDataQueryId());
        pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEDataQuery, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEDataQuery pSDEDataQuery, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        String string3;
        ArrayNode arrayNode;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (!PSDEDataQueryServiceBase.isSimpleImportExportMode("")) {
            pSCoreSysServiceBase = (PSDEDQCodeService)ServiceGlobal.getService(PSDEDQCodeService.class, (SessionFactory)this.getSessionFactory());
            arrayNode = null;
            string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
            if (objectNode != null) {
                arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
            }
            if (arrayNode != null) {
                for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                    ObjectNode node = (ObjectNode)arrayNode.get(n2);
                    PSDEDQCode model = new PSDEDQCode();
                    model.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
                    model.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
                    pSCoreSysServiceBase.compileModelV2(model, node, string, null, n);
                }
            } else {
                String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
                File folder = new File(string4);
                if (folder.exists()) {
                    File[] files = folder.listFiles();
                    if (files != null) {
                        for (File file : files) {
                            if (!file.isDirectory()) continue;
                            PSDEDQCode model = new PSDEDQCode();
                            model.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
                            model.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
                            pSCoreSysServiceBase.compileModelV2(model, null, string, file.getCanonicalPath(), n);
                        }
                    }
                }
            }
        }
        pSCoreSysServiceBase = (PSDEDQJoinService)ServiceGlobal.getService(PSDEDQJoinService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode node = (ObjectNode)arrayNode.get(i);
                PSDEDQJoin model = new PSDEDQJoin();
                model.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
                model.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
                model.setOrderValue(n2 += 10);
                pSCoreSysServiceBase.compileModelV2(model, node, string, null, n);
            }
        } else {
            String path = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File folder = new File(path);
            if (folder.exists()) {
                File[] files = folder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (!file.isDirectory()) continue;
                        PSDEDQJoin model = new PSDEDQJoin();
                        model.setPSDEDQId(pSDEDataQuery.getPSDEDataQueryId());
                        model.setPSDEDQName(pSDEDataQuery.getPSDEDataQueryName());
                        pSCoreSysServiceBase.compileModelV2(model, null, string, file.getCanonicalPath(), n);
                    }
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEDataQuery, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEDataQuery pSDEDataQuery, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        Object var5_5 = null;
        return super.onPasteFile(pSDEDataQuery, pSMOSFile, string, iPSMOSFileAction);
    }

    @Override
    protected void onFillPasteHelps(PSDEDataQuery pSDEDataQuery, List<PSHelpSection> list) throws Exception {
        super.onFillPasteHelps(pSDEDataQuery, list);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSDEDataQuery pSDEDataQuery, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "DataQuery");
        defaultValueMap.put("LOGICNAME", "\u6570\u636e\u67e5\u8be2");
        defaultValueMap.put("PSDEDATAQUERYNAME", "DATAQUERY");
    }
}
