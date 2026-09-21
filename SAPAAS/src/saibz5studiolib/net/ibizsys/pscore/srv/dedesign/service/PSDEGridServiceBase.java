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
package net.ibizsys.pscore.srv.dedesign.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.Serializable;
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
import net.ibizsys.paas.service.SessionFactoryManager;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JsonNodeHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEGridDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEGridDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFInputTipSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIVR;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGEIVRBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDERBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFGroupServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIUpdateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGEIVRServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEGridServiceBase
extends PSCoreSysServiceBase<PSDEGrid> {
    private static final Log log = LogFactory.getLog(PSDEGridServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_PREVIEWSAVE = "PreviewSave";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSDEGridDEModel pSDEGridDEModel;
    private PSDEGridDAO pSDEGridDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEGridService";
    }

    public PSDEGridDEModel getPSDEGridDEModel() {
        if (this.pSDEGridDEModel == null) {
            try {
                this.pSDEGridDEModel = (PSDEGridDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEGridDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGridDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEGridDEModel();
    }

    public PSDEGridDAO getPSDEGridDAO() {
        if (this.pSDEGridDAO == null) {
            try {
                this.pSDEGridDAO = (PSDEGridDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEGridDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEGridDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEGridDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
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
            this.createWithModel((PSDEGrid)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDEGrid)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDEGrid)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEGrid)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PREVIEWSAVE, (boolean)true) == 0) {
            this.previewSave((PSDEGrid)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEGrid)iEntity);
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

    public DBFetchResult fetchCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDE(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDE, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, true);
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

    public void createWithModel(PSDEGrid pSDEGrid) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSDEGrid, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEGrid, ACTION_CREATEWITHMODEL);
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEGridServiceBase.this.getService(), PSDEGridServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSDEGrid2, null).getResult() != 1) {
                    PSDEGridServiceBase.this.onCreateWithModel(pSDEGrid2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSDEGrid, null);
        }
    }

    protected void onCreateWithModel(PSDEGrid pSDEGrid) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSDEGrid pSDEGrid) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSDEGrid, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEGrid, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEGridServiceBase.this.getService(), PSDEGridServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSDEGrid2, null).getResult() != 1) {
                    PSDEGridServiceBase.this.onGetDraftFromWithModel(pSDEGrid2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSDEGrid, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDEGrid pSDEGrid) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDEGrid pSDEGrid) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSDEGrid, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEGrid, ACTION_GETDRAFTWITHMODEL);
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEGridServiceBase.this.getService(), PSDEGridServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSDEGrid2, null).getResult() != 1) {
                    PSDEGridServiceBase.this.onGetDraftWithModel(pSDEGrid2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSDEGrid, null);
        }
    }

    protected void onGetDraftWithModel(PSDEGrid pSDEGrid) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDEGrid pSDEGrid) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSDEGrid, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEGrid, ACTION_GETWITHMODEL);
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEGridServiceBase.this.getService(), PSDEGridServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSDEGrid2, null).getResult() != 1) {
                    PSDEGridServiceBase.this.onGetWithModel(pSDEGrid2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSDEGrid, null);
        }
    }

    protected void onGetWithModel(PSDEGrid pSDEGrid) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void previewSave(PSDEGrid pSDEGrid) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 0, (IEntity)pSDEGrid, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEGrid, ACTION_PREVIEWSAVE);
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEGridServiceBase.this.getService(), PSDEGridServiceBase.ACTION_PREVIEWSAVE, 40, (IEntity)pSDEGrid2, null).getResult() != 1) {
                    PSDEGridServiceBase.this.onPreviewSave(pSDEGrid2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 99, (IEntity)pSDEGrid, null);
        }
    }

    protected void onPreviewSave(PSDEGrid pSDEGrid) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PreviewSave]");
    }

    public void updateWithModel(PSDEGrid pSDEGrid) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSDEGrid, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEGrid, ACTION_UPDATEWITHMODEL);
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEGridServiceBase.this.getService(), PSDEGridServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSDEGrid2, null).getResult() != 1) {
                    PSDEGridServiceBase.this.onUpdateWithModel(pSDEGrid2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSDEGrid, null);
        }
    }

    protected void onUpdateWithModel(PSDEGrid pSDEGrid) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEGrid pSDEGrid, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSACHandler);
            } else {
                iService.get((IEntity)pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDEGrid, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSCODELIST_GROUPPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_GroupPSCodeList(pSDEGrid, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlLogicGroup);
            } else {
                iService.get((IEntity)pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEGrid, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlMsg);
            } else {
                iService.get((IEntity)pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSDEGrid, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDATAENTITY_AGGPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_AggPSDE(pSDEGrid, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEGrid, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_AGGPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_AggPSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_COPYPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_CopyPSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_CREATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_CreatePSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_GETDRAFTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_GetDraftPSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_GETPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_GetPSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_MOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_MovePSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_REMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_RemovePSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_UPDATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_UpdatePSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_USER2PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_User2PSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEACTION_USERPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_UserPSDEAction(pSDEGrid, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEDATASET_AGGPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_AggPSDEDS(pSDEGrid, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEDATASET_ASYNCPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_AsyncPSDEDS(pSDEGrid, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDEGrid, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEFIELD_GROUPPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_GroupPSDEF(pSDEGrid, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEFIELD_GROUPTEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_GroupTextPSDEF(pSDEGrid, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEFIELD_MINORSORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MinorSortPSDEF(pSDEGrid, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEFIELD_ORDERVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_OrderValuePSDEF(pSDEGrid, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEFIELD_TREEPPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_TreePPSEF(pSDEGrid, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEFINPUTTIPSET_PSDEFINPUTTIPSETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFInputTipSetService", (SessionFactory)this.getSessionFactory());
            PSDEFInputTipSet pSDEFInputTipSet = (PSDEFInputTipSet)iService.getDEModel().createEntity();
            pSDEFInputTipSet.set("PSDEFINPUTTIPSETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEFInputTipSet);
            } else {
                iService.get((IEntity)pSDEFInputTipSet);
            }
            this.onFillParentInfo_PSDEFInputTipSet(pSDEGrid, pSDEFInputTipSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDER_NAVPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_NavPSDER(pSDEGrid, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDETOOLBAR_BATPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEToolbar);
            } else {
                iService.get((IEntity)pSDEToolbar);
            }
            this.onFillParentInfo_BatPSDEToolbar(pSDEGrid, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDETOOLBAR_QUICKPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEToolbar);
            } else {
                iService.get((IEntity)pSDEToolbar);
            }
            this.onFillParentInfo_QuickPSDEToolbar(pSDEGrid, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEUAGROUP_GROUPPSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_GroupPSDEUAGroup(pSDEGrid, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSDEVIEWBASE_NAVPSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_NavPSDEViewBase(pSDEGrid, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSLANGUAGERES_EMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEGrid, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSSYSCSS_GROUPPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_GroupPSSysCss(pSDEGrid, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSSYSCSS_ITEMPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_ItemPSSysCss(pSDEGrid, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEGrid, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEGrid, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSSYSPFPLUGIN_GROUPPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_GroupPSSysPFPlugin(pSDEGrid, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEGrid, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSSYSREQITEM_PSSYSREQITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService", (SessionFactory)this.getSessionFactory());
            PSSysReqItem pSSysReqItem = (PSSysReqItem)iService.getDEModel().createEntity();
            pSSysReqItem.set("PSSYSREQITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysReqItem);
            } else {
                iService.get((IEntity)pSSysReqItem);
            }
            this.onFillParentInfo_PSSysReqItem(pSDEGrid, pSSysReqItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSSYSVIEWPANEL_AGGPSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_AggPSSysViewPanel(pSDEGrid, pSSysViewPanel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEGRID_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewMsgGroup);
            } else {
                iService.get((IEntity)pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSDEGrid, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEGrid, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDEGrid pSDEGrid, PSACHandler pSACHandler) throws Exception {
        pSDEGrid.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEGrid.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_GroupPSCodeList(PSDEGrid pSDEGrid, PSCodeList pSCodeList) throws Exception {
        pSDEGrid.setGroupPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEGrid.setGroupPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEGrid pSDEGrid, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEGrid.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEGrid.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSDEGrid pSDEGrid, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSDEGrid.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSDEGrid.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_AggPSDE(PSDEGrid pSDEGrid, PSDataEntity pSDataEntity) throws Exception {
        pSDEGrid.setAggPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEGrid.setAggPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSDEGrid pSDEGrid, PSDataEntity pSDataEntity) throws Exception {
        pSDEGrid.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEGrid.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_AggPSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setAggPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setAggPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_CopyPSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setCopyPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setCopyPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_CreatePSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setCreatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setCreatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetDraftPSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setGetDraftPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setGetDraftPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetPSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setGetPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setGetPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_MovePSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_RemovePSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setRemovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setRemovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UpdatePSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setUpdatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setUpdatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_User2PSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setUser2PSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setUser2PSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UserPSDEAction(PSDEGrid pSDEGrid, PSDEAction pSDEAction) throws Exception {
        pSDEGrid.setUserPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEGrid.setUserPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_AggPSDEDS(PSDEGrid pSDEGrid, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEGrid.setAggPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEGrid.setAggPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_AsyncPSDEDS(PSDEGrid pSDEGrid, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEGrid.setAsyncPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEGrid.setAsyncPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDEGrid pSDEGrid, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEGrid.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEGrid.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_GroupPSDEF(PSDEGrid pSDEGrid, PSDEField pSDEField) throws Exception {
        pSDEGrid.setGroupPSDEFId(pSDEField.getPSDEFieldId());
        pSDEGrid.setGroupPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_GroupTextPSDEF(PSDEGrid pSDEGrid, PSDEField pSDEField) throws Exception {
        pSDEGrid.setGroupTextPSDEFId(pSDEField.getPSDEFieldId());
        pSDEGrid.setGroupTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MinorSortPSDEF(PSDEGrid pSDEGrid, PSDEField pSDEField) throws Exception {
        pSDEGrid.setMinorSortPSDEFId(pSDEField.getPSDEFieldId());
        pSDEGrid.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_OrderValuePSDEF(PSDEGrid pSDEGrid, PSDEField pSDEField) throws Exception {
        pSDEGrid.setOrderValuePSDEFId(pSDEField.getPSDEFieldId());
        pSDEGrid.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_TreePPSEF(PSDEGrid pSDEGrid, PSDEField pSDEField) throws Exception {
        pSDEGrid.setTreePPSDEFId(pSDEField.getPSDEFieldId());
        pSDEGrid.setTreePPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEFInputTipSet(PSDEGrid pSDEGrid, PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        pSDEGrid.setPSDEFInputTipSetId(pSDEFInputTipSet.getPSDEFInputTipSetId());
        pSDEGrid.setPSDEFInputTipSetName(pSDEFInputTipSet.getPSDEFInputTipSetName());
    }

    protected void onFillParentInfo_NavPSDER(PSDEGrid pSDEGrid, PSDER pSDER) throws Exception {
        pSDEGrid.setNavPSDERId(pSDER.getPSDERId());
        pSDEGrid.setNavPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_BatPSDEToolbar(PSDEGrid pSDEGrid, PSDEToolbar pSDEToolbar) throws Exception {
        pSDEGrid.setBatPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDEGrid.setBatPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_QuickPSDEToolbar(PSDEGrid pSDEGrid, PSDEToolbar pSDEToolbar) throws Exception {
        pSDEGrid.setQuickPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDEGrid.setQuickPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_GroupPSDEUAGroup(PSDEGrid pSDEGrid, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEGrid.setGroupPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEGrid.setGroupPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_NavPSDEViewBase(PSDEGrid pSDEGrid, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEGrid.setNavPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEGrid.setNavPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_EmptyTextPSLanRes(PSDEGrid pSDEGrid, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEGrid.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEGrid.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_GroupPSSysCss(PSDEGrid pSDEGrid, PSSysCss pSSysCss) throws Exception {
        pSDEGrid.setGroupPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEGrid.setGroupPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_ItemPSSysCss(PSDEGrid pSDEGrid, PSSysCss pSSysCss) throws Exception {
        pSDEGrid.setItemPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEGrid.setItemPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEGrid pSDEGrid, PSSysCss pSSysCss) throws Exception {
        pSDEGrid.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEGrid.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEGrid pSDEGrid, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEGrid.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEGrid.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_GroupPSSysPFPlugin(PSDEGrid pSDEGrid, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEGrid.setGroupPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEGrid.setGroupPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEGrid pSDEGrid, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEGrid.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEGrid.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysReqItem(PSDEGrid pSDEGrid, PSSysReqItem pSSysReqItem) throws Exception {
        pSDEGrid.setPSSysReqItemId(pSSysReqItem.getPSSysReqItemId());
        pSDEGrid.setPSSysReqItemName(pSSysReqItem.getPSSysReqItemName());
    }

    protected void onFillParentInfo_AggPSSysViewPanel(PSDEGrid pSDEGrid, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEGrid.setAggPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEGrid.setAggPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSDEGrid pSDEGrid, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSDEGrid.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSDEGrid.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (bl) {
            if (pSDEGrid.getEnablePagingBar() == null) {
                pSDEGrid.setEnablePagingBar((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
            if (pSDEGrid.getShowHeader() == null) {
                pSDEGrid.setShowHeader((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEGrid, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDEGrid, bl);
        this.onFillEntityFullInfo_GroupPSCodeList(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSDEGrid, bl);
        this.onFillEntityFullInfo_AggPSDE(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSDE(pSDEGrid, bl);
        this.onFillEntityFullInfo_AggPSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_CopyPSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_CreatePSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_GetDraftPSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_GetPSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_MovePSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_RemovePSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_UpdatePSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_User2PSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_UserPSDEAction(pSDEGrid, bl);
        this.onFillEntityFullInfo_AggPSDEDS(pSDEGrid, bl);
        this.onFillEntityFullInfo_AsyncPSDEDS(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDEGrid, bl);
        this.onFillEntityFullInfo_GroupPSDEF(pSDEGrid, bl);
        this.onFillEntityFullInfo_GroupTextPSDEF(pSDEGrid, bl);
        this.onFillEntityFullInfo_MinorSortPSDEF(pSDEGrid, bl);
        this.onFillEntityFullInfo_OrderValuePSDEF(pSDEGrid, bl);
        this.onFillEntityFullInfo_TreePPSEF(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSDEFInputTipSet(pSDEGrid, bl);
        this.onFillEntityFullInfo_NavPSDER(pSDEGrid, bl);
        this.onFillEntityFullInfo_BatPSDEToolbar(pSDEGrid, bl);
        this.onFillEntityFullInfo_QuickPSDEToolbar(pSDEGrid, bl);
        this.onFillEntityFullInfo_GroupPSDEUAGroup(pSDEGrid, bl);
        this.onFillEntityFullInfo_NavPSDEViewBase(pSDEGrid, bl);
        this.onFillEntityFullInfo_EmptyTextPSLanRes(pSDEGrid, bl);
        this.onFillEntityFullInfo_GroupPSSysCss(pSDEGrid, bl);
        this.onFillEntityFullInfo_ItemPSSysCss(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEGrid, bl);
        this.onFillEntityFullInfo_GroupPSSysPFPlugin(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSSysReqItem(pSDEGrid, bl);
        this.onFillEntityFullInfo_AggPSSysViewPanel(pSDEGrid, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSDEGrid, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSCodeList(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AggPSDE(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isAggPSDEIdDirty()) {
            if (pSDEGrid.getAggPSDEId() != null) {
                if (pSDEGrid.getAggPSDEId() == null || pSDEGrid.getAggPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEGrid.getAggPSDE();
                    pSDEGrid.setAggPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEGrid.setAggPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isPSDEIdDirty()) {
            if (pSDEGrid.getPSDEId() != null) {
                if (pSDEGrid.getPSDEId() == null || pSDEGrid.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEGrid.getPSDE();
                    pSDEGrid.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEGrid.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_AggPSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CopyPSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CreatePSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetDraftPSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetPSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MovePSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UpdatePSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_User2PSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UserPSDEAction(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AggPSDEDS(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AsyncPSDEDS(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSDEF(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isGroupPSDEFIdDirty()) {
            if (pSDEGrid.getGroupPSDEFId() != null) {
                if (pSDEGrid.getGroupPSDEFId() == null || pSDEGrid.getGroupPSDEFName() == null) {
                    PSDEField pSDEField = pSDEGrid.getGroupPSDEF();
                    pSDEGrid.setGroupPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEGrid.setGroupPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupTextPSDEF(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isGroupTextPSDEFIdDirty()) {
            if (pSDEGrid.getGroupTextPSDEFId() != null) {
                if (pSDEGrid.getGroupTextPSDEFId() == null || pSDEGrid.getGroupTextPSDEFName() == null) {
                    PSDEField pSDEField = pSDEGrid.getGroupTextPSDEF();
                    pSDEGrid.setGroupTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEGrid.setGroupTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorSortPSDEF(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isMinorSortPSDEFIdDirty()) {
            if (pSDEGrid.getMinorSortPSDEFId() != null) {
                if (pSDEGrid.getMinorSortPSDEFId() == null || pSDEGrid.getMinorSortPSDEFName() == null) {
                    PSDEField pSDEField = pSDEGrid.getMinorSortPSDEF();
                    pSDEGrid.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEGrid.setMinorSortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OrderValuePSDEF(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isOrderValuePSDEFIdDirty()) {
            if (pSDEGrid.getOrderValuePSDEFId() != null) {
                if (pSDEGrid.getOrderValuePSDEFId() == null || pSDEGrid.getOrderValuePSDEFName() == null) {
                    PSDEField pSDEField = pSDEGrid.getOrderValuePSDEF();
                    pSDEGrid.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEGrid.setOrderValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TreePPSEF(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isTreePPSDEFIdDirty()) {
            if (pSDEGrid.getTreePPSDEFId() != null) {
                if (pSDEGrid.getTreePPSDEFId() == null || pSDEGrid.getTreePPSDEFName() == null) {
                    PSDEField pSDEField = pSDEGrid.getTreePPSEF();
                    pSDEGrid.setTreePPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEGrid.setTreePPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEFInputTipSet(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NavPSDER(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isNavPSDERIdDirty()) {
            if (pSDEGrid.getNavPSDERId() != null) {
                if (pSDEGrid.getNavPSDERId() == null || pSDEGrid.getNavPSDERName() == null) {
                    PSDER pSDER = pSDEGrid.getNavPSDER();
                    pSDEGrid.setNavPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEGrid.setNavPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_BatPSDEToolbar(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_QuickPSDEToolbar(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSDEUAGroup(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NavPSDEViewBase(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmptyTextPSLanRes(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isEmptyTextPSLanResIdDirty()) {
            if (pSDEGrid.getEmptyTextPSLanResId() != null) {
                if (pSDEGrid.getEmptyTextPSLanResId() == null || pSDEGrid.getEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEGrid.getEmptyTextPSLanRes();
                    pSDEGrid.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEGrid.setEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupPSSysCss(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ItemPSSysCss(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        if (pSDEGrid.isPSSysDynaModelIdDirty()) {
            if (pSDEGrid.getPSSysDynaModelId() != null) {
                if (pSDEGrid.getPSSysDynaModelId() == null || pSDEGrid.getPSSysDynaModelName() == null) {
                    PSSysDynaModel pSSysDynaModel = pSDEGrid.getPSSysDynaModel();
                    pSDEGrid.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                }
            } else {
                pSDEGrid.setPSSysDynaModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupPSSysPFPlugin(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysReqItem(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AggPSSysViewPanel(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSDEGrid pSDEGrid, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEGrid, bl);
    }

    public ArrayList<PSDEGrid> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSACHANDLERID", (Object)pSACHandlerBase.getPSACHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSACHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSACHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLLOGICGROUPID", (Object)pSCtrlLogicGroupBase.getPSCtrlLogicGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlLogicGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlLogicGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCTRLMSGID", (Object)pSCtrlMsgBase.getPSCtrlMsgId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCtrlMsgCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCtrlMsgCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByAggPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByAggPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByAggPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByAggPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByAggPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AGGPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAggPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAggPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGrid> selectByAggPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByAggPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByAggPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByAggPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByAggPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AGGPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAggPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAggPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("COPYPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCopyPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCopyPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CREATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCreatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCreatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GETDRAFTPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGetDraftPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGetDraftPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByGetPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GETPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGetPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGetPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REMOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRemovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRemovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("UPDATEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUpdatePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUpdatePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USER2PSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUser2PSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUser2PSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByUserPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("USERPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByUserPSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByUserPSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByAggPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByAggPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByAggPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByAggPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByAggPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AGGPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAggPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAggPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ASYNCPSDEDSID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAsyncPSDEDSCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAsyncPSDEDSCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPTEXTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupTextPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupTextPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("MINORSORTPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByMinorSortPSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByMinorSortPSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ORDERVALUEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOrderValuePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOrderValuePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByTreePPSEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByTreePPSEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByTreePPSEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByTreePPSEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByTreePPSEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("TREEPPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByTreePPSEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByTreePPSEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByPSDEFInputTipSet(PSDEFInputTipSetBase pSDEFInputTipSetBase) throws Exception {
        return this.selectByPSDEFInputTipSet(pSDEFInputTipSetBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSDEFInputTipSet(PSDEFInputTipSetBase pSDEFInputTipSetBase, String string) throws Exception {
        return this.selectByPSDEFInputTipSet(pSDEFInputTipSetBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSDEFInputTipSet(PSDEFInputTipSetBase pSDEFInputTipSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEFINPUTTIPSETID", (Object)pSDEFInputTipSetBase.getPSDEFInputTipSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEFInputTipSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEFInputTipSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByNavPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByNavPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByNavPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByNavPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByNavPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAVPSDERID", (Object)pSDERBase.getPSDERId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNavPSDERCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNavPSDERCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByBatPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByBatPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("BATPSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByBatPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByBatPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByQuickPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByQuickPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("QUICKPSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByQuickPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByQuickPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByGroupPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByGroupPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByNavPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByNavPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByNavPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByNavPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByNavPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAVPSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNavPSDEViewBaseCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNavPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("EMPTYTEXTPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByEmptyTextPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByEmptyTextPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByGroupPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByGroupPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByItemPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByItemPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByItemPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByItemPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByItemPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ITEMPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByItemPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByItemPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGrid> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByGroupPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByGroupPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGrid> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string) throws Exception {
        return this.selectByPSSysReqItem(pSSysReqItemBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSSysReqItem(PSSysReqItemBase pSSysReqItemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEGrid> selectByAggPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByAggPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByAggPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByAggPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByAggPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("AGGPSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByAggPSSysViewPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByAggPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEGrid> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSDEGrid> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSDEGrid> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSVIEWMSGGROUPID", (Object)pSViewMsgGroupBase.getPSViewMsgGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSViewMsgGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSViewMsgGroupCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSACHandlerId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDEGridServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDEGridServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSCODELIST_GROUPPSCODELISTID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setGroupPSCodeListId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByGroupPSCodeList(pSCodeList2);
                PSDEGridServiceBase.this.internalRemoveByGroupPSCodeList(pSCodeList2);
                PSDEGridServiceBase.this.onAfterRemoveByGroupPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        this.onBeforeRemoveByGroupPSCodeList(pSCodeList, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByGroupPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSCtrlLogicGroupId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEGridServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEGridServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSCtrlMsgId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEGridServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEGridServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByAggPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDATAENTITY_AGGPSDEID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetAggPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSDE(pSDataEntity);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setAggPSDEId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByAggPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByAggPSDE(pSDataEntity2);
                PSDEGridServiceBase.this.internalRemoveByAggPSDE(pSDataEntity2);
                PSDEGridServiceBase.this.onAfterRemoveByAggPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByAggPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByAggPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSDE(pSDataEntity);
        this.onBeforeRemoveByAggPSDE(pSDataEntity, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByAggPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByAggPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByAggPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAggPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSDEId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEGridServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEGridServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByAggPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEACTION_AGGPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetAggPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setAggPSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByAggPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByAggPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByAggPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByAggPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByAggPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByAggPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSDEAction(pSDEAction);
        this.onBeforeRemoveByAggPSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByAggPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByAggPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByAggPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAggPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    public void resetCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setCopyPSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByCopyPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByCopyPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByCopyPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        this.onBeforeRemoveByCopyPSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByCopyPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByCreatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEACTION_CREATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setCreatePSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByCreatePSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByCreatePSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByCreatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        this.onBeforeRemoveByCreatePSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByCreatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGetDraftPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEACTION_GETDRAFTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setGetDraftPSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByGetDraftPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByGetDraftPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGetPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEACTION_GETPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGetPSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setGetPSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByGetPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByGetPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByGetPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGetPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetPSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByGetPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEACTION_MOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByMovePSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setMovePSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByMovePSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByMovePSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByMovePSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByRemovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEACTION_REMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setRemovePSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByRemovePSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByRemovePSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByRemovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        this.onBeforeRemoveByRemovePSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByRemovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByUpdatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEACTION_UPDATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setUpdatePSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByUpdatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        this.onBeforeRemoveByUpdatePSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByUpdatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    public void resetUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setUser2PSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByUser2PSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByUser2PSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByUser2PSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        this.onBeforeRemoveByUser2PSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByUser2PSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    public void resetUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByUserPSDEAction(pSDEAction);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setUserPSDEActionId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByUserPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.internalRemoveByUserPSDEAction(pSDEAction2);
                PSDEGridServiceBase.this.onAfterRemoveByUserPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByUserPSDEAction(pSDEAction);
        this.onBeforeRemoveByUserPSDEAction(pSDEAction, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByUserPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByAggPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEDATASET_AGGPSDEDSID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetAggPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSDEDS(pSDEDataSet);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setAggPSDEDSId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByAggPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByAggPSDEDS(pSDEDataSet2);
                PSDEGridServiceBase.this.internalRemoveByAggPSDEDS(pSDEDataSet2);
                PSDEGridServiceBase.this.onAfterRemoveByAggPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByAggPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByAggPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByAggPSDEDS(pSDEDataSet, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByAggPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByAggPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByAggPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAggPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEDATASET_ASYNCPSDEDSID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setAsyncPSDEDSId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSDEGridServiceBase.this.internalRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSDEGridServiceBase.this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSDEDataSetId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEGridServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEGridServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEFIELD_GROUPPSDEFID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSDEF(pSDEField);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setGroupPSDEFId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByGroupPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByGroupPSDEF(pSDEField2);
                PSDEGridServiceBase.this.internalRemoveByGroupPSDEF(pSDEField2);
                PSDEGridServiceBase.this.onAfterRemoveByGroupPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSDEF(pSDEField);
        this.onBeforeRemoveByGroupPSDEF(pSDEField, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByGroupPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEFIELD_GROUPTEXTPSDEFID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupTextPSDEF(pSDEField);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setGroupTextPSDEFId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByGroupTextPSDEF(pSDEField2);
                PSDEGridServiceBase.this.internalRemoveByGroupTextPSDEF(pSDEField2);
                PSDEGridServiceBase.this.onAfterRemoveByGroupTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupTextPSDEF(pSDEField);
        this.onBeforeRemoveByGroupTextPSDEF(pSDEField, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByGroupTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupTextPSDEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupTextPSDEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByMinorSortPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEFIELD_MINORSORTPSDEFID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setMinorSortPSDEFId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByMinorSortPSDEF(pSDEField2);
                PSDEGridServiceBase.this.internalRemoveByMinorSortPSDEF(pSDEField2);
                PSDEGridServiceBase.this.onAfterRemoveByMinorSortPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        this.onBeforeRemoveByMinorSortPSDEF(pSDEField, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByMinorSortPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByOrderValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEFIELD_ORDERVALUEPSDEFID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setOrderValuePSDEFId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByOrderValuePSDEF(pSDEField2);
                PSDEGridServiceBase.this.internalRemoveByOrderValuePSDEF(pSDEField2);
                PSDEGridServiceBase.this.onAfterRemoveByOrderValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        this.onBeforeRemoveByOrderValuePSDEF(pSDEField, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByOrderValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByTreePPSEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByTreePPSEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEFIELD_TREEPPSDEFID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetTreePPSEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByTreePPSEF(pSDEField);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setTreePPSDEFId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByTreePPSEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByTreePPSEF(pSDEField2);
                PSDEGridServiceBase.this.internalRemoveByTreePPSEF(pSDEField2);
                PSDEGridServiceBase.this.onAfterRemoveByTreePPSEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByTreePPSEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByTreePPSEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByTreePPSEF(pSDEField);
        this.onBeforeRemoveByTreePPSEF(pSDEField, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByTreePPSEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByTreePPSEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByTreePPSEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTreePPSEF(PSDEField pSDEField, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSDEFInputTipSet(pSDEFInputTipSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFINPUTTIPSET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEFInputTipSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEFINPUTTIPSET_PSDEFINPUTTIPSETID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEFInputTipSet), arrayList.get(0)));
        }
    }

    public void resetPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSDEFInputTipSet(pSDEFInputTipSet);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSDEFInputTipSetId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        final PSDEFInputTipSet pSDEFInputTipSet2 = pSDEFInputTipSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSDEFInputTipSet(pSDEFInputTipSet2);
                PSDEGridServiceBase.this.internalRemoveByPSDEFInputTipSet(pSDEFInputTipSet2);
                PSDEGridServiceBase.this.onAfterRemoveByPSDEFInputTipSet(pSDEFInputTipSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
    }

    protected void internalRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSDEFInputTipSet(pSDEFInputTipSet);
        this.onBeforeRemoveByPSDEFInputTipSet(pSDEFInputTipSet, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSDEFInputTipSet(pSDEFInputTipSet, arrayList);
    }

    protected void onAfterRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEFInputTipSet(PSDEFInputTipSet pSDEFInputTipSet, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByNavPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByNavPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDER_NAVPSDERID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetNavPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByNavPSDER(pSDER);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setNavPSDERId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByNavPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByNavPSDER(pSDER2);
                PSDEGridServiceBase.this.internalRemoveByNavPSDER(pSDER2);
                PSDEGridServiceBase.this.onAfterRemoveByNavPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByNavPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByNavPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByNavPSDER(pSDER);
        this.onBeforeRemoveByNavPSDER(pSDER, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByNavPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByNavPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByNavPSDER(PSDER pSDER, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNavPSDER(PSDER pSDER, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDETOOLBAR_BATPSDETOOLBARID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setBatPSDEToolbarId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByBatPSDEToolbar(pSDEToolbar2);
                PSDEGridServiceBase.this.internalRemoveByBatPSDEToolbar(pSDEToolbar2);
                PSDEGridServiceBase.this.onAfterRemoveByBatPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByBatPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByBatPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDETOOLBAR_QUICKPSDETOOLBARID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setQuickPSDEToolbarId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByQuickPSDEToolbar(pSDEToolbar2);
                PSDEGridServiceBase.this.internalRemoveByQuickPSDEToolbar(pSDEToolbar2);
                PSDEGridServiceBase.this.onAfterRemoveByQuickPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByQuickPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByQuickPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEUAGROUP_GROUPPSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setGroupPSDEUAGroupId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
                PSDEGridServiceBase.this.internalRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
                PSDEGridServiceBase.this.onAfterRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByGroupPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByGroupPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByNavPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSDEVIEWBASE_NAVPSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByNavPSDEViewBase(pSDEViewBase);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setNavPSDEViewBaseId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByNavPSDEViewBase(pSDEViewBase2);
                PSDEGridServiceBase.this.internalRemoveByNavPSDEViewBase(pSDEViewBase2);
                PSDEGridServiceBase.this.onAfterRemoveByNavPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByNavPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByNavPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByNavPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSLANGUAGERES_EMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setEmptyTextPSLanResId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEGridServiceBase.this.internalRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEGridServiceBase.this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSSYSCSS_GROUPPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSSysCss(pSSysCss);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setGroupPSSysCssId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByGroupPSSysCss(pSSysCss2);
                PSDEGridServiceBase.this.internalRemoveByGroupPSSysCss(pSSysCss2);
                PSDEGridServiceBase.this.onAfterRemoveByGroupPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSSysCss(pSSysCss);
        this.onBeforeRemoveByGroupPSSysCss(pSSysCss, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByGroupPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByItemPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSSYSCSS_ITEMPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByItemPSSysCss(pSSysCss);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setItemPSSysCssId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByItemPSSysCss(pSSysCss2);
                PSDEGridServiceBase.this.internalRemoveByItemPSSysCss(pSSysCss2);
                PSDEGridServiceBase.this.onAfterRemoveByItemPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByItemPSSysCss(pSSysCss);
        this.onBeforeRemoveByItemPSSysCss(pSSysCss, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByItemPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByItemPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByItemPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSSysCssId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEGridServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEGridServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSSysDynaModelId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEGridServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEGridServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSSYSPFPLUGIN_GROUPPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setGroupPSSysPFPluginId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
                PSDEGridServiceBase.this.internalRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
                PSDEGridServiceBase.this.onAfterRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByGroupPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByGroupPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSSysPFPluginId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEGridServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEGridServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysReqItem(pSSysReqItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSREQITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysReqItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSSYSREQITEM_PSSYSREQITEMID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSSysReqItem), arrayList.get(0)));
        }
    }

    public void resetPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSSysReqItemId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        final PSSysReqItem pSSysReqItem2 = pSSysReqItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEGridServiceBase.this.internalRemoveByPSSysReqItem(pSSysReqItem2);
                PSDEGridServiceBase.this.onAfterRemoveByPSSysReqItem(pSSysReqItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void internalRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSSysReqItem(pSSysReqItem);
        this.onBeforeRemoveByPSSysReqItem(pSSysReqItem, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSSysReqItem(pSSysReqItem, arrayList);
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem) throws Exception {
    }

    protected void onBeforeRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysReqItem(PSSysReqItem pSSysReqItem, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByAggPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSSYSVIEWPANEL_AGGPSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetAggPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSSysViewPanel(pSSysViewPanel);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setAggPSSysViewPanelId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByAggPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByAggPSSysViewPanel(pSSysViewPanel2);
                PSDEGridServiceBase.this.internalRemoveByAggPSSysViewPanel(pSSysViewPanel2);
                PSDEGridServiceBase.this.onAfterRemoveByAggPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByAggPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByAggPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByAggPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByAggPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByAggPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByAggPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByAggPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAggPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEGRID_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSDEGRID", iDataEntityModel.getDataInfo((IEntity)pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSDEGrid pSDEGrid : arrayList) {
            PSDEGrid pSDEGrid2 = (PSDEGrid)this.getDEModel().createEntity();
            pSDEGrid2.setPSDEGridId(pSDEGrid.getPSDEGridId());
            pSDEGrid2.setPSViewMsgGroupId(null);
            this.update(pSDEGrid2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEGridServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEGridServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEGridServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEGrid> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSDEGrid pSDEGrid : arrayList) {
            this.remove((IEntity)pSDEGrid);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEGrid> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEGrid pSDEGrid) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDataExpService)ServiceGlobal.getService(PSDEDataExpService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataExpServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEFGroupService)ServiceGlobal.getService(PSDEFGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFGroupServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByMDPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        ((PSDEGEIUDetailServiceBase)pSCoreSysServiceBase).removeByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).removeByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).removeByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).removeByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).removeByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeViewServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEGrid(pSDEGrid);
        super.onBeforeRemove(pSDEGrid);
    }

    protected void onBeforeRemoveTemp(PSDEGrid pSDEGrid) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).removeTempByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUDetailServiceBase)pSCoreSysServiceBase).removeTempByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).removeTempByPSDEGrid(pSDEGrid);
        pSCoreSysServiceBase = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).removeTempByPSDEGrid(pSDEGrid);
        super.onBeforeRemoveTemp((IEntity)pSDEGrid);
    }

    protected void getRelatedDataTempMajor(PSDEGrid pSDEGrid) throws Exception {
        this.getRelatedDataTempMajor_PSDEGEIUpdate(pSDEGrid);
        this.getRelatedDataTempMajor_PSDEGridCol(pSDEGrid);
        this.getRelatedDataTempMajor_PSDEGEIUDetail(pSDEGrid);
        this.getRelatedDataTempMajor_PSDEGEIVR(pSDEGrid);
        this.getRelatedDataTempMajor_PSDEGridLogic(pSDEGrid);
        super.getRelatedDataTempMajor((IEntity)pSDEGrid);
    }

    protected void getRelatedDataTempMajor_PSDEGEIUpdate(PSDEGrid pSDEGrid) throws Exception {
        PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUpdate> arrayList = null;
        String string = pSDEGrid.getPSDEGridId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGEIUpdateService.selectByPSDEGrid(pSDEGrid) : pSDEGEIUpdateService.selectTempByPSDEGrid(pSDEGrid);
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            pSDEGEIUpdateService.getTempMajor(pSDEGEIUpdate);
        }
    }

    protected void getRelatedDataTempMajor_PSDEGridCol(PSDEGrid pSDEGrid) throws Exception {
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridCol> arrayList = null;
        String string = pSDEGrid.getPSDEGridId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGridColService.selectByPSDEGrid(pSDEGrid) : pSDEGridColService.selectTempByPSDEGrid(pSDEGrid);
        PSDEGridServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEGRIDCOLID", (String)"PPSDEGRIDCOLID");
        for (PSDEGridCol pSDEGridCol : arrayList) {
            pSDEGridColService.getTempMajor(pSDEGridCol);
        }
    }

    protected void getRelatedDataTempMajor_PSDEGEIUDetail(PSDEGrid pSDEGrid) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUDetail> arrayList = null;
        String string = pSDEGrid.getPSDEGridId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGEIUDetailService.selectByPSDEGrid(pSDEGrid) : pSDEGEIUDetailService.selectTempByPSDEGrid(pSDEGrid);
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            pSDEGEIUDetailService.getTempMajor(pSDEGEIUDetail);
        }
    }

    protected void getRelatedDataTempMajor_PSDEGEIVR(PSDEGrid pSDEGrid) throws Exception {
        PSDEGEIVRService pSDEGEIVRService = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIVR> arrayList = null;
        String string = pSDEGrid.getPSDEGridId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGEIVRService.selectByPSDEGrid(pSDEGrid) : pSDEGEIVRService.selectTempByPSDEGrid(pSDEGrid);
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            pSDEGEIVRService.getTempMajor(pSDEGEIVR);
        }
    }

    protected void getRelatedDataTempMajor_PSDEGridLogic(PSDEGrid pSDEGrid) throws Exception {
        PSDEGridLogicService pSDEGridLogicService = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridLogic> arrayList = null;
        String string = pSDEGrid.getPSDEGridId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGridLogicService.selectByPSDEGrid(pSDEGrid) : pSDEGridLogicService.selectTempByPSDEGrid(pSDEGrid);
        for (PSDEGridLogic pSDEGridLogic : arrayList) {
            pSDEGridLogicService.getTempMajor(pSDEGridLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2) throws Exception {
        ArrayList<PSDEGridLogic> arrayList = this.updateRelatedDataTempMajor_removePSDEGridLogic(pSDEGrid, pSDEGrid2);
        ArrayList<PSDEGEIVR> arrayList2 = this.updateRelatedDataTempMajor_removePSDEGEIVR(pSDEGrid, pSDEGrid2);
        ArrayList<PSDEGEIUDetail> arrayList3 = this.updateRelatedDataTempMajor_removePSDEGEIUDetail(pSDEGrid, pSDEGrid2);
        ArrayList<PSDEGridCol> arrayList4 = this.updateRelatedDataTempMajor_removePSDEGridCol(pSDEGrid, pSDEGrid2);
        ArrayList<PSDEGEIUpdate> arrayList5 = this.updateRelatedDataTempMajor_removePSDEGEIUpdate(pSDEGrid, pSDEGrid2);
        this.updateRelatedDataTempMajor_updatePSDEGEIUpdate(pSDEGrid, pSDEGrid2, arrayList5);
        this.updateRelatedDataTempMajor_updatePSDEGridCol(pSDEGrid, pSDEGrid2, arrayList4);
        this.updateRelatedDataTempMajor_updatePSDEGEIUDetail(pSDEGrid, pSDEGrid2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSDEGEIVR(pSDEGrid, pSDEGrid2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEGridLogic(pSDEGrid, pSDEGrid2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEGrid, (IEntity)pSDEGrid2);
    }

    protected ArrayList<PSDEGEIUpdate> updateRelatedDataTempMajor_removePSDEGEIUpdate(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2) throws Exception {
        PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUpdate> arrayList = pSDEGEIUpdateService.selectTempByPSDEGrid(pSDEGrid);
        ArrayList<PSDEGEIUpdate> arrayList2 = pSDEGEIUpdateService.selectByPSDEGrid(pSDEGrid2);
        HashMap<String, PSDEGEIUpdate> hashMap = new HashMap<String, PSDEGEIUpdate>();
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList2) {
            hashMap.put(pSDEGEIUpdate.getPSDEGEIUpdateId(), pSDEGEIUpdate);
        }
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            Object object = pSDEGEIUpdate.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEGEIUpdate pSDEGEIUpdate : hashMap.values()) {
            pSDEGEIUpdateService.remove((IEntity)pSDEGEIUpdate);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEGEIUpdate(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2, ArrayList<PSDEGEIUpdate> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            pSDEGEIUpdateService.updateTempMajor(pSDEGEIUpdate);
        }
    }

    protected ArrayList<PSDEGridCol> updateRelatedDataTempMajor_removePSDEGridCol(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2) throws Exception {
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridCol> arrayList = pSDEGridColService.selectTempByPSDEGrid(pSDEGrid);
        ArrayList<PSDEGridCol> arrayList2 = pSDEGridColService.selectByPSDEGrid(pSDEGrid2);
        HashMap<String, PSDEGridCol> hashMap = new HashMap<String, PSDEGridCol>();
        for (PSDEGridCol pSDEGridCol : arrayList2) {
            hashMap.put(pSDEGridCol.getPSDEGridColId(), pSDEGridCol);
        }
        PSDEGridServiceBase.sortHierarchyEntities(arrayList, (String)"PSDEGRIDCOLID", (String)"PPSDEGRIDCOLID");
        for (PSDEGridCol pSDEGridCol : arrayList) {
            Object object = pSDEGridCol.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEGridCol pSDEGridCol : hashMap.values()) {
            pSDEGridColService.remove((IEntity)pSDEGridCol);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEGridCol(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2, ArrayList<PSDEGridCol> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEGridCol pSDEGridCol : arrayList) {
            pSDEGridColService.updateTempMajor(pSDEGridCol);
        }
    }

    protected ArrayList<PSDEGEIUDetail> updateRelatedDataTempMajor_removePSDEGEIUDetail(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUDetail> arrayList = pSDEGEIUDetailService.selectTempByPSDEGrid(pSDEGrid);
        ArrayList<PSDEGEIUDetail> arrayList2 = pSDEGEIUDetailService.selectByPSDEGrid(pSDEGrid2);
        HashMap<String, PSDEGEIUDetail> hashMap = new HashMap<String, PSDEGEIUDetail>();
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList2) {
            hashMap.put(pSDEGEIUDetail.getPSDEGEIUDetailId(), pSDEGEIUDetail);
        }
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            Object object = pSDEGEIUDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEGEIUDetail pSDEGEIUDetail : hashMap.values()) {
            pSDEGEIUDetailService.remove((IEntity)pSDEGEIUDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEGEIUDetail(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2, ArrayList<PSDEGEIUDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList) {
            pSDEGEIUDetailService.updateTempMajor(pSDEGEIUDetail);
        }
    }

    protected ArrayList<PSDEGEIVR> updateRelatedDataTempMajor_removePSDEGEIVR(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2) throws Exception {
        PSDEGEIVRService pSDEGEIVRService = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIVR> arrayList = pSDEGEIVRService.selectTempByPSDEGrid(pSDEGrid);
        ArrayList<PSDEGEIVR> arrayList2 = pSDEGEIVRService.selectByPSDEGrid(pSDEGrid2);
        HashMap<String, PSDEGEIVR> hashMap = new HashMap<String, PSDEGEIVR>();
        for (PSDEGEIVR pSDEGEIVR : arrayList2) {
            hashMap.put(pSDEGEIVR.getPSDEGEIVRId(), pSDEGEIVR);
        }
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            Object object = pSDEGEIVR.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEGEIVR pSDEGEIVR : hashMap.values()) {
            pSDEGEIVRService.remove((IEntity)pSDEGEIVR);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEGEIVR(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2, ArrayList<PSDEGEIVR> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEGEIVRService pSDEGEIVRService = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            pSDEGEIVRService.updateTempMajor(pSDEGEIVR);
        }
    }

    protected ArrayList<PSDEGridLogic> updateRelatedDataTempMajor_removePSDEGridLogic(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2) throws Exception {
        PSDEGridLogicService pSDEGridLogicService = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridLogic> arrayList = pSDEGridLogicService.selectTempByPSDEGrid(pSDEGrid);
        ArrayList<PSDEGridLogic> arrayList2 = pSDEGridLogicService.selectByPSDEGrid(pSDEGrid2);
        HashMap<String, PSDEGridLogic> hashMap = new HashMap<String, PSDEGridLogic>();
        for (PSDEGridLogic pSDEGridLogic : arrayList2) {
            hashMap.put(pSDEGridLogic.getPSDEGridColLogicId(), pSDEGridLogic);
        }
        for (PSDEGridLogic pSDEGridLogic : arrayList) {
            Object object = pSDEGridLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEGridLogic pSDEGridLogic : hashMap.values()) {
            pSDEGridLogicService.remove((IEntity)pSDEGridLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEGridLogic(PSDEGrid pSDEGrid, PSDEGrid pSDEGrid2, ArrayList<PSDEGridLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEGridLogicService pSDEGridLogicService = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEGridLogic pSDEGridLogic : arrayList) {
            pSDEGridLogicService.updateTempMajor(pSDEGridLogic);
        }
    }

    protected void replaceParentInfo(PSDEGrid pSDEGrid, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEGrid, cloneSession);
        if (pSDEGrid.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEGrid.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDEGrid, (PSACHandler)iEntity);
        }
        if (pSDEGrid.getGroupPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEGrid.getGroupPSCodeListId())) != null) {
            this.onFillParentInfo_GroupPSCodeList(pSDEGrid, (PSCodeList)iEntity);
        }
        if (pSDEGrid.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEGrid.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEGrid, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEGrid.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSDEGrid.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSDEGrid, (PSCtrlMsg)iEntity);
        }
        if (pSDEGrid.getAggPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEGrid.getAggPSDEId())) != null) {
            this.onFillParentInfo_AggPSDE(pSDEGrid, (PSDataEntity)iEntity);
        }
        if (pSDEGrid.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEGrid.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEGrid, (PSDataEntity)iEntity);
        }
        if (pSDEGrid.getAggPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getAggPSDEActionId())) != null) {
            this.onFillParentInfo_AggPSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getCopyPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getCopyPSDEActionId())) != null) {
            this.onFillParentInfo_CopyPSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getCreatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getCreatePSDEActionId())) != null) {
            this.onFillParentInfo_CreatePSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getGetDraftPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getGetDraftPSDEActionId())) != null) {
            this.onFillParentInfo_GetDraftPSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getGetPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getGetPSDEActionId())) != null) {
            this.onFillParentInfo_GetPSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getMovePSDEActionId())) != null) {
            this.onFillParentInfo_MovePSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getRemovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getRemovePSDEActionId())) != null) {
            this.onFillParentInfo_RemovePSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getUpdatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getUpdatePSDEActionId())) != null) {
            this.onFillParentInfo_UpdatePSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getUser2PSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getUser2PSDEActionId())) != null) {
            this.onFillParentInfo_User2PSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getUserPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEGrid.getUserPSDEActionId())) != null) {
            this.onFillParentInfo_UserPSDEAction(pSDEGrid, (PSDEAction)iEntity);
        }
        if (pSDEGrid.getAggPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEGrid.getAggPSDEDSId())) != null) {
            this.onFillParentInfo_AggPSDEDS(pSDEGrid, (PSDEDataSet)iEntity);
        }
        if (pSDEGrid.getAsyncPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEGrid.getAsyncPSDEDSId())) != null) {
            this.onFillParentInfo_AsyncPSDEDS(pSDEGrid, (PSDEDataSet)iEntity);
        }
        if (pSDEGrid.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEGrid.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDEGrid, (PSDEDataSet)iEntity);
        }
        if (pSDEGrid.getGroupPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEGrid.getGroupPSDEFId())) != null) {
            this.onFillParentInfo_GroupPSDEF(pSDEGrid, (PSDEField)iEntity);
        }
        if (pSDEGrid.getGroupTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEGrid.getGroupTextPSDEFId())) != null) {
            this.onFillParentInfo_GroupTextPSDEF(pSDEGrid, (PSDEField)iEntity);
        }
        if (pSDEGrid.getMinorSortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEGrid.getMinorSortPSDEFId())) != null) {
            this.onFillParentInfo_MinorSortPSDEF(pSDEGrid, (PSDEField)iEntity);
        }
        if (pSDEGrid.getOrderValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEGrid.getOrderValuePSDEFId())) != null) {
            this.onFillParentInfo_OrderValuePSDEF(pSDEGrid, (PSDEField)iEntity);
        }
        if (pSDEGrid.getTreePPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEGrid.getTreePPSDEFId())) != null) {
            this.onFillParentInfo_TreePPSEF(pSDEGrid, (PSDEField)iEntity);
        }
        if (pSDEGrid.getPSDEFInputTipSetId() != null && (iEntity = cloneSession.getEntity("PSDEFINPUTTIPSET", (Object)pSDEGrid.getPSDEFInputTipSetId())) != null) {
            this.onFillParentInfo_PSDEFInputTipSet(pSDEGrid, (PSDEFInputTipSet)iEntity);
        }
        if (pSDEGrid.getNavPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEGrid.getNavPSDERId())) != null) {
            this.onFillParentInfo_NavPSDER(pSDEGrid, (PSDER)iEntity);
        }
        if (pSDEGrid.getBatPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDEGrid.getBatPSDEToolbarId())) != null) {
            this.onFillParentInfo_BatPSDEToolbar(pSDEGrid, (PSDEToolbar)iEntity);
        }
        if (pSDEGrid.getQuickPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDEGrid.getQuickPSDEToolbarId())) != null) {
            this.onFillParentInfo_QuickPSDEToolbar(pSDEGrid, (PSDEToolbar)iEntity);
        }
        if (pSDEGrid.getGroupPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEGrid.getGroupPSDEUAGroupId())) != null) {
            this.onFillParentInfo_GroupPSDEUAGroup(pSDEGrid, (PSDEUAGroup)iEntity);
        }
        if (pSDEGrid.getNavPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEGrid.getNavPSDEViewBaseId())) != null) {
            this.onFillParentInfo_NavPSDEViewBase(pSDEGrid, (PSDEViewBase)iEntity);
        }
        if (pSDEGrid.getEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEGrid.getEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEGrid, (PSLanguageRes)iEntity);
        }
        if (pSDEGrid.getGroupPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEGrid.getGroupPSSysCssId())) != null) {
            this.onFillParentInfo_GroupPSSysCss(pSDEGrid, (PSSysCss)iEntity);
        }
        if (pSDEGrid.getItemPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEGrid.getItemPSSysCssId())) != null) {
            this.onFillParentInfo_ItemPSSysCss(pSDEGrid, (PSSysCss)iEntity);
        }
        if (pSDEGrid.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEGrid.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEGrid, (PSSysCss)iEntity);
        }
        if (pSDEGrid.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEGrid.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEGrid, (PSSysDynaModel)iEntity);
        }
        if (pSDEGrid.getGroupPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEGrid.getGroupPSSysPFPluginId())) != null) {
            this.onFillParentInfo_GroupPSSysPFPlugin(pSDEGrid, (PSSysPFPlugin)iEntity);
        }
        if (pSDEGrid.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEGrid.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEGrid, (PSSysPFPlugin)iEntity);
        }
        if (pSDEGrid.getPSSysReqItemId() != null && (iEntity = cloneSession.getEntity("PSSYSREQITEM", (Object)pSDEGrid.getPSSysReqItemId())) != null) {
            this.onFillParentInfo_PSSysReqItem(pSDEGrid, (PSSysReqItem)iEntity);
        }
        if (pSDEGrid.getAggPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEGrid.getAggPSSysViewPanelId())) != null) {
            this.onFillParentInfo_AggPSSysViewPanel(pSDEGrid, (PSSysViewPanel)iEntity);
        }
        if (pSDEGrid.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSDEGrid.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSDEGrid, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEGrid, bl);
    }

    protected void onCheckEntity(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AggMode(bl, pSDEGrid, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AggPSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AggPSDEDSId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AggPSDEId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AggPSDEName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AggPSSysViewPanelId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AsyncPSDEDSId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BatPSDEToolbarId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BufferRendererMode(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColEnableFilter(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColEnableLink(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CopyPSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableCustomized(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableEdit(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemPriv(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePagingBar(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ForceFit(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FrozenCol(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FrozenLastCol(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetDraftPSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetPSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridModel(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridSN(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridStyle(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMode(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSCodeListId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEUAGroupId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSSysCssId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSSysPFPluginId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupStyle(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTextPSDEFId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTextPSDEFName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreDSItem(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemPSSysCssId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortDir(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MultiSelect(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavPSDERId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavPSDERName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavPSDEViewBaseId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilter(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewHeight(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxHeight(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxWidth(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinHeight(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinWidth(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewParam(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewPos(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewShowMode(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewWidth(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoSort(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PagingSize(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFInputTipSetId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysReqItemId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QuickPSDEToolbarId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowHeader(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SortMode(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TreePPSDEFId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TreePPSDEFName(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEActionId(bl, pSDEGrid, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEGrid, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AggMode(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isAggModeDirty() : !pSDEGrid.isAggModeDirty()) {
            return null;
        }
        String string = pSDEGrid.getAggMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggMode_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AggPSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isAggPSDEActionIdDirty() : !pSDEGrid.isAggPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getAggPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggPSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AggPSDEDSId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isAggPSDEDSIdDirty() : !pSDEGrid.isAggPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getAggPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggPSDEDSId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AggPSDEId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isAggPSDEIdDirty() : !pSDEGrid.isAggPSDEIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getAggPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggPSDEId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AggPSDEName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isAggPSDENameDirty() : !pSDEGrid.isAggPSDENameDirty()) {
            return null;
        }
        String string = pSDEGrid.getAggPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggPSDEName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AggPSSysViewPanelId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isAggPSSysViewPanelIdDirty() : !pSDEGrid.isAggPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getAggPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AggPSSysViewPanelId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AGGPSSYSVIEWPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AsyncPSDEDSId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isAsyncPSDEDSIdDirty() : !pSDEGrid.isAsyncPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getAsyncPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AsyncPSDEDSId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ASYNCPSDEDSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BatPSDEToolbarId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isBatPSDEToolbarIdDirty() : !pSDEGrid.isBatPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getBatPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BatPSDEToolbarId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BATPSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BufferRendererMode(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isBufferRendererModeDirty() : !pSDEGrid.isBufferRendererModeDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getBufferRendererMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BufferRendererMode_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BUFFERRENDERERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isBusyIndicatorDirty() : !pSDEGrid.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isCodeNameDirty() && !bl2 : !pSDEGrid.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSDEID";
                String string4 = this.checkFieldDupRule(this.getPSDEGridDEModel(), "CODENAME", string3, pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColEnableFilter(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isColEnableFilterDirty() : !pSDEGrid.isColEnableFilterDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getColEnableFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColEnableFilter_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLENABLEFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColEnableLink(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isColEnableLinkDirty() : !pSDEGrid.isColEnableLinkDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getColEnableLink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColEnableLink_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLENABLELINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CopyPSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isCopyPSDEActionIdDirty() : !pSDEGrid.isCopyPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getCopyPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CopyPSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COPYPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CreatePSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isCreatePSDEActionIdDirty() : !pSDEGrid.isCreatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getCreatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CREATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isCustomCondDirty() : !pSDEGrid.isCustomCondDirty()) {
            return null;
        }
        String string = pSDEGrid.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMCOND");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isCustomTypeDirty() : !pSDEGrid.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDEGrid.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CUSTOMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isDynaModelFlagDirty() : !pSDEGrid.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isEmptyTextDirty() : !pSDEGrid.isEmptyTextDirty()) {
            return null;
        }
        String string = pSDEGrid.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSLanResId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isEmptyTextPSLanResIdDirty() : !pSDEGrid.isEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyTextPSLanResName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isEmptyTextPSLanResNameDirty() : !pSDEGrid.isEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYTEXTPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableCustomized(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isEnableCustomizedDirty() : !pSDEGrid.isEnableCustomizedDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getEnableCustomized();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableCustomized_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLECUSTOMIZED");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableEdit(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isEnableEditDirty() : !pSDEGrid.isEnableEditDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getEnableEdit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableEdit_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEEDIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableItemPriv(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isEnableItemPrivDirty() : !pSDEGrid.isEnableItemPrivDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getEnableItemPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemPriv_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEITEMPRIV");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnablePagingBar(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isEnablePagingBarDirty() && !bl2 : !pSDEGrid.isEnablePagingBarDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getEnablePagingBar();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPAGINGBAR");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_EnablePagingBar_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPAGINGBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ForceFit(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isForceFitDirty() : !pSDEGrid.isForceFitDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getForceFit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ForceFit_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FORCEFIT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FrozenCol(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isFrozenColDirty() : !pSDEGrid.isFrozenColDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getFrozenCol();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FrozenCol_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROZENCOL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FrozenLastCol(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isFrozenLastColDirty() : !pSDEGrid.isFrozenLastColDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getFrozenLastCol();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FrozenLastCol_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FROZENLASTCOL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetDraftPSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGetDraftPSDEActionIdDirty() : !pSDEGrid.isGetDraftPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getGetDraftPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetDraftPSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETDRAFTPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetPSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGetPSDEActionIdDirty() : !pSDEGrid.isGetPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getGetPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetPSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridModel(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGridModelDirty() : !pSDEGrid.isGridModelDirty()) {
            return null;
        }
        String string = pSDEGrid.getGridModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridModel_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridSN(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGridSNDirty() : !pSDEGrid.isGridSNDirty()) {
            return null;
        }
        String string = pSDEGrid.getGridSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridSN_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GridStyle(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGridStyleDirty() : !pSDEGrid.isGridStyleDirty()) {
            return null;
        }
        String string = pSDEGrid.getGridStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GridStyle_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMode(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupModeDirty() : !pSDEGrid.isGroupModeDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMode_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSCodeListId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupPSCodeListIdDirty() : !pSDEGrid.isGroupPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSCodeListId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEFId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupPSDEFIdDirty() : !pSDEGrid.isGroupPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEFName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupPSDEFNameDirty() : !pSDEGrid.isGroupPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEUAGroupId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupPSDEUAGroupIdDirty() : !pSDEGrid.isGroupPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEUAGroupId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSSysCssId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupPSSysCssIdDirty() : !pSDEGrid.isGroupPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSSysCssId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSSysPFPluginId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupPSSysPFPluginIdDirty() : !pSDEGrid.isGroupPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSSysPFPluginId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupStyle(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupStyleDirty() : !pSDEGrid.isGroupStyleDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupStyle_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTextPSDEFId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupTextPSDEFIdDirty() : !pSDEGrid.isGroupTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTextPSDEFId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTEXTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupTextPSDEFName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isGroupTextPSDEFNameDirty() : !pSDEGrid.isGroupTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getGroupTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTextPSDEFName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPTEXTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_IgnoreDSItem(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isIgnoreDSItemDirty() : !pSDEGrid.isIgnoreDSItemDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getIgnoreDSItem();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreDSItem_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREDSITEM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemPSSysCssId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isItemPSSysCssIdDirty() : !pSDEGrid.isItemPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getItemPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemPSSysCssId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isLockFlagDirty() : !pSDEGrid.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isMemoDirty() : !pSDEGrid.isMemoDirty()) {
            return null;
        }
        String string = pSDEGrid.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortDir(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isMinorSortDirDirty() : !pSDEGrid.isMinorSortDirDirty()) {
            return null;
        }
        String string = pSDEGrid.getMinorSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortDir_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortPSDEFId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isMinorSortPSDEFIdDirty() : !pSDEGrid.isMinorSortPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getMinorSortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MinorSortPSDEFName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isMinorSortPSDEFNameDirty() : !pSDEGrid.isMinorSortPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getMinorSortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MINORSORTPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MovePSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isMovePSDEActionIdDirty() : !pSDEGrid.isMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_MultiSelect(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isMultiSelectDirty() : !pSDEGrid.isMultiSelectDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getMultiSelect();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MultiSelect_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MULTISELECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavPSDERId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavPSDERIdDirty() : !pSDEGrid.isNavPSDERIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getNavPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavPSDERId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVPSDERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavPSDERName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavPSDERNameDirty() : !pSDEGrid.isNavPSDERNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getNavPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavPSDERName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVPSDERNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavPSDEViewBaseId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavPSDEViewBaseIdDirty() : !pSDEGrid.isNavPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getNavPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavPSDEViewBaseId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVPSDEVIEWBASEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewFilter(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewFilterDirty() : !pSDEGrid.isNavViewFilterDirty()) {
            return null;
        }
        String string = pSDEGrid.getNavViewFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilter_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWFILTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewHeight(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewHeightDirty() : !pSDEGrid.isNavViewHeightDirty()) {
            return null;
        }
        Double d = pSDEGrid.getNavViewHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewHeight_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMaxHeight(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewMaxHeightDirty() : !pSDEGrid.isNavViewMaxHeightDirty()) {
            return null;
        }
        Double d = pSDEGrid.getNavViewMaxHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxHeight_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMAXHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMaxWidth(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewMaxWidthDirty() : !pSDEGrid.isNavViewMaxWidthDirty()) {
            return null;
        }
        Double d = pSDEGrid.getNavViewMaxWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxWidth_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMAXWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMinHeight(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewMinHeightDirty() : !pSDEGrid.isNavViewMinHeightDirty()) {
            return null;
        }
        Double d = pSDEGrid.getNavViewMinHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinHeight_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMINHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewMinWidth(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewMinWidthDirty() : !pSDEGrid.isNavViewMinWidthDirty()) {
            return null;
        }
        Double d = pSDEGrid.getNavViewMinWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinWidth_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWMINWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewParam(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewParamDirty() : !pSDEGrid.isNavViewParamDirty()) {
            return null;
        }
        String string = pSDEGrid.getNavViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewParam_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewPos(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewPosDirty() : !pSDEGrid.isNavViewPosDirty()) {
            return null;
        }
        String string = pSDEGrid.getNavViewPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewPos_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewShowMode(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewShowModeDirty() : !pSDEGrid.isNavViewShowModeDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getNavViewShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewShowMode_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWSHOWMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavViewWidth(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNavViewWidthDirty() : !pSDEGrid.isNavViewWidthDirty()) {
            return null;
        }
        Double d = pSDEGrid.getNavViewWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewWidth_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVVIEWWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NoSort(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isNoSortDirty() : !pSDEGrid.isNoSortDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getNoSort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoSort_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOSORT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValuePSDEFId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isOrderValuePSDEFIdDirty() : !pSDEGrid.isOrderValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getOrderValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValuePSDEFName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isOrderValuePSDEFNameDirty() : !pSDEGrid.isOrderValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getOrderValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORDERVALUEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PagingSize(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPagingSizeDirty() : !pSDEGrid.isPagingSizeDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getPagingSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PagingSize_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGINGSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSACHandlerIdDirty() : !pSDEGrid.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSACHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSCtrlLogicGroupIdDirty() : !pSDEGrid.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLLOGICGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSCtrlMsgIdDirty() : !pSDEGrid.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLMSGID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSDEDataSetIdDirty() : !pSDEGrid.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFInputTipSetId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSDEFInputTipSetIdDirty() : !pSDEGrid.isPSDEFInputTipSetIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSDEFInputTipSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFInputTipSetId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFINPUTTIPSETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSDEGridIdDirty() && !bl2 : !pSDEGrid.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSDEGridId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSDEGridNameDirty() && !bl2 : !pSDEGrid.isPSDEGridNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSDEGridName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEGRIDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSDEIdDirty() && !bl2 : !pSDEGrid.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSDENameDirty() && !bl2 : !pSDEGrid.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSDynaInstIdDirty() : !pSDEGrid.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSSysCssIdDirty() : !pSDEGrid.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSSysDynaModelIdDirty() : !pSDEGrid.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSSysDynaModelNameDirty() : !pSDEGrid.isPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSSysDynaModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDYNAMODELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSSysPFPluginIdDirty() : !pSDEGrid.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysReqItemId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSSysReqItemIdDirty() : !pSDEGrid.isPSSysReqItemIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSSysReqItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysReqItemId_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isPSViewMsgGroupIdDirty() : !pSDEGrid.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSVIEWMSGGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_QuickPSDEToolbarId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isQuickPSDEToolbarIdDirty() : !pSDEGrid.isQuickPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getQuickPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QuickPSDEToolbarId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("QUICKPSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RemovePSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isRemovePSDEActionIdDirty() : !pSDEGrid.isRemovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getRemovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REMOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowHeader(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isShowHeaderDirty() : !pSDEGrid.isShowHeaderDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getShowHeader();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowHeader_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWHEADER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SortMode(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isSortModeDirty() : !pSDEGrid.isSortModeDirty()) {
            return null;
        }
        String string = pSDEGrid.getSortMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SortMode_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SORTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isSRFSysPubDirty() : !pSDEGrid.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDEGrid.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SRFSYSPUB");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isToDoTaskDirty() : !pSDEGrid.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEGrid.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_TreePPSDEFId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isTreePPSDEFIdDirty() : !pSDEGrid.isTreePPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getTreePPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TreePPSDEFId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TREEPPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TreePPSDEFName(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isTreePPSDEFNameDirty() : !pSDEGrid.isTreePPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEGrid.getTreePPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TreePPSDEFName_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TREEPPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UpdatePSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isUpdatePSDEActionIdDirty() : !pSDEGrid.isUpdatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getUpdatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("UPDATEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_User2PSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isUser2PSDEActionIdDirty() : !pSDEGrid.isUser2PSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getUser2PSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USER2PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isUserParamsDirty() : !pSDEGrid.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEGrid.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default((IEntity)pSDEGrid, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEActionId(boolean bl, PSDEGrid pSDEGrid, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEGrid.isUserPSDEActionIdDirty() : !pSDEGrid.isUserPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEGrid.getUserPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEActionId_Default((IEntity)pSDEGrid, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("USERPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEGrid, bl);
    }

    protected void onSyncIndexEntities(PSDEGrid pSDEGrid, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEGrid, bl);
    }

    public Object getDataContextValue(PSDEGrid pSDEGrid, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACTION", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AGGPSDEACTIONID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AGGPSDEACTIONNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEGrid, "aggpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AGGPSDEDSID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"AGGPSDEDSNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEGrid, "aggpsdeid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue((IEntity)pSDEGrid, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEGrid.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEGrid pSDEGrid, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEGEIUpdate_PSDEGrid(pSDEGrid, arrayList, n);
        this.onExportRelatedModel_PSDEGEIUDetail_PSDEGrid(pSDEGrid, arrayList, n);
        this.onExportRelatedModel_PSDEGridCol_PSDEGrid(pSDEGrid, arrayList, n);
        this.onExportRelatedModel_PSDEGEIVR_PSDEGrid(pSDEGrid, arrayList, n);
        this.onExportRelatedModel_PSDEGridLogic_PSDEGrid(pSDEGrid, arrayList, n);
        super.onExportRelatedModel((IEntity)pSDEGrid, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEGEIUpdate_PSDEGrid(PSDEGrid pSDEGrid, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUpdate> arrayList2 = pSDEGEIUpdateService.selectByPSDEGrid(pSDEGrid);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"72df034ccc3b5457fb30d5922f710b57");
            jSONObject.put("srfdename", (Object)"PSDEGEIUPDATE");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEGEIUPDATE_PSDEGRID_PSDEGRIDID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEGrid, (String)"PSDEGRIDID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEGEIUpdate, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEGEIUpdateService.exportModel(pSDEGEIUpdate, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEGEIUDetail_PSDEGrid(PSDEGrid pSDEGrid, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEGEIUDetailService pSDEGEIUDetailService = (PSDEGEIUDetailService)ServiceGlobal.getService(PSDEGEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUDetail> arrayList2 = pSDEGEIUDetailService.selectByPSDEGrid(pSDEGrid);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"c1774fb5e27bdd628a2be653a5fd42d7");
            jSONObject.put("srfdename", (Object)"PSDEGEIUDETAIL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEGEIUDETAIL_PSDEGRID_PSDEGRIDID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEGrid, (String)"PSDEGRIDID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEGEIUDetail pSDEGEIUDetail : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEGEIUDetail, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEGEIUDetailService.exportModel(pSDEGEIUDetail, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEGridCol_PSDEGrid(PSDEGrid pSDEGrid, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridCol> arrayList2 = pSDEGridColService.selectByPSDEGrid(pSDEGrid);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"ba42e103a81a9e0af8cadc4ae58d1c44");
            jSONObject.put("srfdename", (Object)"PSDEGRIDCOL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEGrid, (String)"PSDEGRIDID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEGridCol pSDEGridCol : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEGridCol, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEGridColService.exportModel(pSDEGridCol, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEGEIVR_PSDEGrid(PSDEGrid pSDEGrid, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEGEIVRService pSDEGEIVRService = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIVR> arrayList2 = pSDEGEIVRService.selectByPSDEGrid(pSDEGrid);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"272af8794de9bbea12f9cb21e3ebafda");
            jSONObject.put("srfdename", (Object)"PSDEGEIVR");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEGEIVR_PSDEGRID_PSDEGRIDID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEGrid, (String)"PSDEGRIDID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEGEIVR pSDEGEIVR : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEGEIVR, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEGEIVRService.exportModel(pSDEGEIVR, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEGridLogic_PSDEGrid(PSDEGrid pSDEGrid, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEGridLogicService pSDEGridLogicService = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridLogic> arrayList2 = pSDEGridLogicService.selectByPSDEGrid(pSDEGrid);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"0dd2d2074de418f8b7dceab68b28b7b5");
            jSONObject.put("srfdename", (Object)"PSDEGRIDLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEGRIDLOGIC_PSDEGRID_PSDEGRIDID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEGrid, (String)"PSDEGRIDID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEGridLogic pSDEGridLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEGridLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEGridLogicService.exportModel(pSDEGridLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEGrid pSDEGrid, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_EmptyTextPSLanRes(pSDEGrid, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEGrid, arrayList, n);
    }

    protected void onExportMajorModel_EmptyTextPSLanRes(PSDEGrid pSDEGrid, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEGrid.getEmptyTextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEGrid.getEmptyTextPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"AGGMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGPSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggPSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AGGPSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AggPSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASYNCPSDEDSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AsyncPSDEDSId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ASYNCPSDEDSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AsyncPSDEDSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BATPSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BatPSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BATPSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BatPSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUFFERRENDERERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BufferRendererMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLENABLEFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColEnableFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLENABLELINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColEnableLink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COPYPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CopyPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COPYPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CopyPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYTEXTPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyTextPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLECUSTOMIZED", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableCustomized_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEEDIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableEdit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEITEMPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableItemPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPAGINGBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePagingBar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FORCEFIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ForceFit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROZENCOL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FrozenCol_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROZENLASTCOL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FrozenLastCol_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETDRAFTPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetDraftPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETDRAFTPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetDraftPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTEXTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTextPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPTEXTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupTextPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREDSITEM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreDSItem_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MINORSORTPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MinorSortPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MULTISELECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MultiSelect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVPSDERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavPSDERId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVPSDERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavPSDERName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVPSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavPSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVPSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavPSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWFILTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewFilter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMAXHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMaxHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMAXWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMaxWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMINHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMinHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWMINWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewMinWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWSHOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewShowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOSORT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoSort_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValuePSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGINGSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PagingSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFINPUTTIPSETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFInputTipSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFINPUTTIPSETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFInputTipSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEGRIDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEGridName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKPSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickPSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"QUICKPSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_QuickPSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REMOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RemovePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWHEADER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowHeader_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SORTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SortMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TREEPPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TreePPSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TREEPPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TreePPSDEFName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdatePSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USER2PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_User2PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEActionName_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AggMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggPSSysViewPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGPSSYSVIEWPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AggPSSysViewPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AGGPSSYSVIEWPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AsyncPSDEDSId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASYNCPSDEDSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AsyncPSDEDSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ASYNCPSDEDSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BatPSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BATPSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BatPSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BATPSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BufferRendererMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_ColEnableFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ColEnableLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CopyPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COPYPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CopyPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COPYPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_CreatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CreatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CREATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomCond_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMCOND", iEntity, bl2, null, false, 2000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[2000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CustomType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CUSTOMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EmptyText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXT", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyTextPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EMPTYTEXTPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnableCustomized_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableEdit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableItemPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnablePagingBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ForceFit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FrozenCol_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FrozenLastCol_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GetDraftPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETDRAFTPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetDraftPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETDRAFTPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GETPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GridStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GRIDSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMODE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTextPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTEXTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupTextPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPTEXTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_IgnoreDSItem_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_MinorSortDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTDIR", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MinorSortPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MINORSORTPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MultiSelect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavPSDERId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVPSDERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavPSDERName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVPSDERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavPSDEViewBaseId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVPSDEVIEWBASEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavPSDEViewBaseName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVPSDEVIEWBASENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWFILTER", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMaxHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMaxWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMinHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewMinWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWPARAM", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVVIEWPOS", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavViewShowMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavViewWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NoSort_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrderValuePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORDERVALUEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValuePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORDERVALUEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PagingSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PSACHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSACHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSACHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSACHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlLogicGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLLOGICGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlMsgName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLMSGNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFInputTipSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFINPUTTIPSETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEFInputTipSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEFINPUTTIPSETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEGridName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEGRIDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSViewMsgGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSViewMsgGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSVIEWMSGGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QuickPSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUICKPSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_QuickPSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("QUICKPSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RemovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REMOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ShowHeader_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SortMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SORTMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_TreePPSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TREEPPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TreePPSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TREEPPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_UpdatePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UpdatePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("UPDATEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_User2PSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_User2PSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USER2PSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_UserPSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_UserPSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("USERPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
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

    protected boolean onMergeChild(String string, String string2, PSDEGrid pSDEGrid) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEGrid)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEGrid pSDEGrid) throws Exception {
        Object object = pSDEGrid.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEGRID_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEGrid);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEGrid pSDEGrid, Object object) throws Exception {
        PSDEGrid pSDEGrid2 = new PSDEGrid();
        pSDEGrid2.set("PSDEGRIDID", object);
        String string = DataObject.getStringValue((Object)pSDEGrid.get("PSDEGRIDID"));
        super.onCopyDetails((IEntity)pSDEGrid, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEGrid pSDEGrid, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEGRID");
        if (!bl) {
            pSDEGrid.setCreateDate(null);
            pSDEGrid.setCreateMan(null);
            pSDEGrid.setPSDEGridId(null);
            pSDEGrid.setUpdateDate(null);
            pSDEGrid.setUpdateMan(null);
            super.exportCurXmlModel(pSDEGrid, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEGrid pSDEGrid, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEGEIUpdate(pSDEGrid, xmlNode);
        this.exportRelatedXmlModel_PSDEGridCol(pSDEGrid, xmlNode);
        this.exportRelatedXmlModel_PSDEGridLogic(pSDEGrid, xmlNode);
        super.onExportRelatedXmlModel(pSDEGrid, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEGEIUpdate(PSDEGrid pSDEGrid, XmlNode xmlNode) throws Exception {
        PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGEIUpdate> arrayList = null;
        String string = pSDEGrid.getPSDEGridId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGEIUpdateService.selectByPSDEGrid(pSDEGrid) : pSDEGEIUpdateService.selectTempByPSDEGrid(pSDEGrid);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEGEIUPDATES");
            xmlNode.addNode(xmlNode2);
            for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
                pSDEGEIUpdateService.exportXmlModel(pSDEGEIUpdate, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEGridCol(PSDEGrid pSDEGrid, XmlNode xmlNode) throws Exception {
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridCol> arrayList = null;
        String string = pSDEGrid.getPSDEGridId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGridColService.selectByPSDEGrid(pSDEGrid, "ORDER BY ORDERVALUE ASC") : pSDEGridColService.selectTempByPSDEGrid(pSDEGrid, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEGRIDCOLS");
            xmlNode.addNode(xmlNode2);
            for (PSDEGridCol pSDEGridCol : arrayList) {
                if (pSDEGridCol.getPPSDEGridColId() != null) continue;
                pSDEGridCol.set("ORDERVALUE", null);
                pSDEGridColService.exportXmlModel(pSDEGridCol, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEGridLogic(PSDEGrid pSDEGrid, XmlNode xmlNode) throws Exception {
        PSDEGridLogicService pSDEGridLogicService = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEGridLogic> arrayList = null;
        String string = pSDEGrid.getPSDEGridId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEGridLogicService.selectByPSDEGrid(pSDEGrid, "ORDER BY ORDERVALUE ASC") : pSDEGridLogicService.selectTempByPSDEGrid(pSDEGrid, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEGRIDLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDEGridLogic pSDEGridLogic : arrayList) {
                pSDEGridLogic.set("ORDERVALUE", null);
                pSDEGridLogicService.exportXmlModel(pSDEGridLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEGrid pSDEGrid, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDEGEIUPDATES");
        this.importRelatedXmlModel_PSDEGEIUpdate(pSDEGrid, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEGRIDCOLS");
        this.importRelatedXmlModel_PSDEGridCol(pSDEGrid, xmlNode3);
        XmlNode xmlNode4 = xmlNode.getChildNodeByNodeName("PSDEGRIDLOGICS");
        this.importRelatedXmlModel_PSDEGridLogic(pSDEGrid, xmlNode4);
        super.onImportRelatedXmlModel(pSDEGrid, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEGEIUpdate(PSDEGrid pSDEGrid, XmlNode xmlNode) throws Exception {
        PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEGrid.getPSDEGridId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEGEIUpdateService.removeByPSDEGrid(pSDEGrid);
        } else {
            pSDEGEIUpdateService.removeTempByPSDEGrid(pSDEGrid);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEGEIUpdate pSDEGEIUpdate = new PSDEGEIUpdate();
                pSDEGEIUpdateService.fillParentInfo((IEntity)pSDEGEIUpdate, "DER1N", "DER1N_PSDEGEIUPDATE_PSDEGRID_PSDEGRIDID", pSDEGrid.getPSDEGridId());
                pSDEGEIUpdateService.importXmlModel(pSDEGEIUpdate, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEGridCol(PSDEGrid pSDEGrid, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEGrid.getPSDEGridId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEGridColService.removeByPSDEGrid(pSDEGrid);
        } else {
            pSDEGridColService.removeTempByPSDEGrid(pSDEGrid);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEGridCol pSDEGridCol = new PSDEGridCol();
                pSDEGridCol.setOrderValue(n);
                n += 100;
                pSDEGridColService.fillParentInfo((IEntity)pSDEGridCol, "DER1N", "DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID", pSDEGrid.getPSDEGridId());
                pSDEGridColService.importXmlModel(pSDEGridCol, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEGridLogic(PSDEGrid pSDEGrid, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEGridLogicService pSDEGridLogicService = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEGrid.getPSDEGridId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEGridLogicService.removeByPSDEGrid(pSDEGrid);
        } else {
            pSDEGridLogicService.removeTempByPSDEGrid(pSDEGrid);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEGridLogic pSDEGridLogic = new PSDEGridLogic();
                pSDEGridLogic.setOrderValue(n);
                n += 100;
                pSDEGridLogicService.fillParentInfo((IEntity)pSDEGridLogic, "DER1N", "DER1N_PSDEGRIDLOGIC_PSDEGRID_PSDEGRIDID", pSDEGrid.getPSDEGridId());
                pSDEGridLogicService.importXmlModel(pSDEGridLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEGrid pSDEGrid, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEGrid, string);
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
            return "DER1N_PSDEGRID_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEGrid pSDEGrid) {
        if (!StringHelper.isNullOrEmpty((String)pSDEGrid.getCodeName())) {
            return pSDEGrid.getCodeName();
        }
        return super.getModelV2Tag(pSDEGrid);
    }

    @Override
    public boolean setModelV2Tag(PSDEGrid pSDEGrid, String string) {
        pSDEGrid.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("CODENAME", "");
        map.put("PSDEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEGrid pSDEGrid, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEGrid.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEGrid, true);
        pSDEGrid.set("CODENAME", string);
        if (this.select(pSDEGrid, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEGrid, true);
        return super.getModelV2Entity(pSDEGrid, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEGrid pSDEGrid, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEGrid, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEGEIUPDATE_PSDEGRID_PSDEGRIDID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDEGEIVR_PSDEGRID_PSDEGRIDID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEGRIDLOGIC_PSDEGRID_PSDEGRIDID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEGrid pSDEGrid, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEGrid, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEGrid pSDEGrid, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSDEGridCol> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID")) {
            pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEGRID#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEGRIDCOL", (Object)pSDEGrid.getPSDEGridId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEGridCol)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEGridCol>();
                object4 = ((PSDEGridColServiceBase)pSCoreSysServiceBase).selectByPSDEGrid(pSDEGrid);
                object3 = StringHelper.format((String)"PSDEGRID#%1$s", (Object)pSDEGrid.getPSDEGridId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEGridCol)object2.next();
                    object = ((PSDEGridColServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEGridCol)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdegridcolname")) {
                            string = objectNode.get("psdegridcolname").asText();
                        }
                        if (objectNode2.has("psdegridcolname")) {
                            string2 = objectNode2.get("psdegridcolname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEGridCol();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    ((PSDEGridColBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEGEIUPDATE_PSDEGRID_PSDEGRIDID")) {
            pSCoreSysServiceBase = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEGRID#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEGEIUPDATE", (Object)pSDEGrid.getPSDEGridId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEGridCol)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).selectByPSDEGrid(pSDEGrid);
                object3 = StringHelper.format((String)"PSDEGRID#%1$s", (Object)pSDEGrid.getPSDEGridId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEGEIUpdate)object2.next();
                    object = ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEGridCol)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdegeiupdatename")) {
                            string = objectNode.get("psdegeiupdatename").asText();
                        }
                        if (objectNode2.has("psdegeiupdatename")) {
                            string2 = objectNode2.get("psdegeiupdatename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEGEIUpdate();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEGEIVR_PSDEGRID_PSDEGRIDID")) {
            pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEGRID#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEGEIVR", (Object)pSDEGrid.getPSDEGridId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEGridCol)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).selectByPSDEGrid(pSDEGrid);
                object3 = StringHelper.format((String)"PSDEGRID#%1$s", (Object)pSDEGrid.getPSDEGridId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEGEIVR)object2.next();
                    object = ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEGridCol)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdegeivrname")) {
                            string = objectNode.get("psdegeivrname").asText();
                        }
                        if (objectNode2.has("psdegeivrname")) {
                            string2 = objectNode2.get("psdegeivrname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEGEIVR();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEGRIDLOGIC_PSDEGRID_PSDEGRIDID")) {
            pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEGRID#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEGRIDLOGIC", (Object)pSDEGrid.getPSDEGridId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEGridCol)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).selectByPSDEGrid(pSDEGrid);
                object3 = StringHelper.format((String)"PSDEGRID#%1$s", (Object)pSDEGrid.getPSDEGridId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEGridLogic)object2.next();
                    object = ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEGridCol)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("psdegridlogicname")) {
                            string = objectNode.get("psdegridlogicname").asText();
                        }
                        if (objectNode2.has("psdegridlogicname")) {
                            string2 = objectNode2.get("psdegridlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEGridLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEGrid, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEGrid pSDEGrid) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSDEGridColServiceBase)pSCoreSysServiceBase).selectByPSDEGrid(pSDEGrid);
        String string2 = StringHelper.format((String)"PSDEGRID#%1$s", (Object)pSDEGrid.getPSDEGridId());
        for (PSDEGridCol entityBase : arrayList) {
            string = ((PSDEGridColServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSDEGrid.getPSDEGridId());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEGRIDCOL WHERE PSDEGRIDID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).selectByPSDEGrid(pSDEGrid);
        string2 = StringHelper.format((String)"PSDEGRID#%1$s", (Object)pSDEGrid.getPSDEGridId());
        for (PSDEGEIUpdate pSDEGEIUpdate : arrayList) {
            string = ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEGEIUpdate);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEGEIUpdate);
        }
        object = new SqlParamList();
        object.addString(pSDEGrid.getPSDEGridId());
        ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEGEIUpdateServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEGEIUPDATE WHERE PSDEGRIDID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).selectByPSDEGrid(pSDEGrid);
        string2 = StringHelper.format((String)"PSDEGRID#%1$s", (Object)pSDEGrid.getPSDEGridId());
        for (PSDEGEIVR pSDEGEIVR : arrayList) {
            string = ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEGEIVR);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEGEIVR);
        }
        object = new SqlParamList();
        object.addString(pSDEGrid.getPSDEGridId());
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEGEIVRServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEGEIVR WHERE PSDEGRIDID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).selectByPSDEGrid(pSDEGrid);
        string2 = StringHelper.format((String)"PSDEGRID#%1$s", (Object)pSDEGrid.getPSDEGridId());
        for (PSDEGridLogic pSDEGridLogic : arrayList) {
            string = ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEGridLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEGridLogic);
        }
        object = new SqlParamList();
        object.addString(pSDEGrid.getPSDEGridId());
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEGRIDLOGIC WHERE PSDEGRIDID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSDEGrid);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEGrid pSDEGrid, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEGridCol();
        entityBase.set("PSDEGRIDID", pSDEGrid.getPSDEGridId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEGEIUpdate();
        entityBase.set("PSDEGRIDID", pSDEGrid.getPSDEGridId());
        pSCoreSysServiceBase = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEGEIVR();
        entityBase.set("PSDEGRIDID", pSDEGrid.getPSDEGridId());
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEGridLogic();
        entityBase.set("PSDEGRIDID", pSDEGrid.getPSDEGridId());
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEGrid, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEGrid pSDEGrid, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        Serializable serializable;
        int n2;
        Object object2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n22 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                PSDEGridCol object = new PSDEGridCol();
                object.setPSDEGridId(pSDEGrid.getPSDEGridId());
                object.setPSDEGridName(pSDEGrid.getPSDEGridName());
                object.setPSDEId(pSDEGrid.getPSDEId());
                object.setOrderValue(n22 += 10);
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                File[] fileArray;
                File[] fileArray2 = fileArray = ((File)object2).listFiles();
                n2 = fileArray2.length;
                for (int i = 0; i < n2; ++i) {
                    serializable = fileArray2[i];
                    if (!((File)serializable).isDirectory()) continue;
                    PSDEGridCol pSDEGridCol = new PSDEGridCol();
                    pSDEGridCol.setPSDEGridId(pSDEGrid.getPSDEGridId());
                    pSDEGridCol.setPSDEGridName(pSDEGrid.getPSDEGridName());
                    pSDEGridCol.setPSDEId(pSDEGrid.getPSDEId());
                    pSCoreSysServiceBase.compileModelV2(pSDEGridCol, null, string, ((File)serializable).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n22 = 0; n22 < arrayNode.size(); ++n22) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(n22);
                object2 = new PSDEGEIUpdate();
                ((PSDEGEIUpdateBase)object2).setPSDEGridId(pSDEGrid.getPSDEGridId());
                ((PSDEGEIUpdateBase)object2).setPSDEGridName(pSDEGrid.getPSDEGridName());
                pSCoreSysServiceBase.compileModelV2(object2, objectNode2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string5);
            if (file.exists()) {
                Object object = object2 = file.listFiles();
                int n3 = ((Object)object).length;
                for (n2 = 0; n2 < n3; ++n2) {
                    Object object3 = object[n2];
                    if (!((File)object3).isDirectory()) continue;
                    serializable = new PSDEGEIUpdate();
                    ((PSDEGEIUpdateBase)serializable).setPSDEGridId(pSDEGrid.getPSDEGridId());
                    ((PSDEGEIUpdateBase)serializable).setPSDEGridName(pSDEGrid.getPSDEGridName());
                    pSCoreSysServiceBase.compileModelV2(serializable, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEGEIVRService)ServiceGlobal.getService(PSDEGEIVRService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode3 = (ObjectNode)arrayNode.get(i);
                object2 = new PSDEGEIVR();
                ((PSDEGEIVRBase)object2).setPSDEGridId(pSDEGrid.getPSDEGridId());
                ((PSDEGEIVRBase)object2).setPSDEGridName(pSDEGrid.getPSDEGridName());
                pSCoreSysServiceBase.compileModelV2(object2, objectNode3, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string6);
            if (file.exists()) {
                Object object = object2 = file.listFiles();
                int n4 = ((Object)object).length;
                for (n2 = 0; n2 < n4; ++n2) {
                    Object object4 = object[n2];
                    if (!((File)object4).isDirectory()) continue;
                    serializable = new PSDEGEIVR();
                    ((PSDEGEIVRBase)serializable).setPSDEGridId(pSDEGrid.getPSDEGridId());
                    ((PSDEGEIVRBase)serializable).setPSDEGridName(pSDEGrid.getPSDEGridName());
                    pSCoreSysServiceBase.compileModelV2(serializable, null, string, ((File)object4).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode objectNode4 = (ObjectNode)arrayNode.get(i);
                object2 = new PSDEGridLogic();
                ((PSDEGridLogicBase)object2).setPSDEGridId(pSDEGrid.getPSDEGridId());
                ((PSDEGridLogicBase)object2).setPSDEGridName(pSDEGrid.getPSDEGridName());
                pSCoreSysServiceBase.compileModelV2(object2, objectNode4, string, null, n);
            }
        } else {
            String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string7);
            if (file.exists()) {
                for (Object object : object2 = file.listFiles()) {
                    if (!((File)object).isDirectory()) continue;
                    serializable = new PSDEGridLogic();
                    ((PSDEGridLogicBase)serializable).setPSDEGridId(pSDEGrid.getPSDEGridId());
                    ((PSDEGridLogicBase)serializable).setPSDEGridName(pSDEGrid.getPSDEGridName());
                    pSCoreSysServiceBase.compileModelV2(serializable, null, string, ((File)object).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEGrid, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEGrid pSDEGrid, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEGridCols(pSDEGrid, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEGEIUPDATE_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEGEIUpdates(pSDEGrid, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEGRIDLOGIC_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEGridLogics(pSDEGrid, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEGrid, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEGridCols(PSDEGrid pSDEGrid, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEGRIDCOL", true), (boolean)false) == 0) {
            PSDEGridColService pSDEGridColService = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
            PSDEGridCol pSDEGridCol = new PSDEGridCol();
            pSDEGridCol.setPSDEGridColId(pSMOSFile.getPSModelId());
            if (!pSDEGridColService.get((IEntity)pSDEGridCol, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEGridCol.getPSDEGridId(), (String)pSDEGrid.getPSDEGridId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEGridColService.exportModelV2(pSDEGridCol);
            pSDEGridCol.reset();
            if (!pSDEGridColService.setModelV2ResScope((IEntity)pSDEGridCol, "PSDEGRID", pSDEGrid.getPSDEGridId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEGridColService.importModelV2(pSDEGridCol, objectNode);
            SessionFactoryManager.commit();
            return pSDEGridColService.getFile((IEntity)pSDEGridCol);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEGEIUpdates(PSDEGrid pSDEGrid, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEGEIUPDATE", true), (boolean)false) == 0) {
            PSDEGEIUpdateService pSDEGEIUpdateService = (PSDEGEIUpdateService)ServiceGlobal.getService(PSDEGEIUpdateService.class, (SessionFactory)this.getSessionFactory());
            PSDEGEIUpdate pSDEGEIUpdate = new PSDEGEIUpdate();
            pSDEGEIUpdate.setPSDEGEIUpdateId(pSMOSFile.getPSModelId());
            if (!pSDEGEIUpdateService.get((IEntity)pSDEGEIUpdate, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEGEIUpdate.getPSDEGridId(), (String)pSDEGrid.getPSDEGridId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEGEIUpdateService.exportModelV2(pSDEGEIUpdate);
            pSDEGEIUpdate.reset();
            if (!pSDEGEIUpdateService.setModelV2ResScope((IEntity)pSDEGEIUpdate, "PSDEGRID", pSDEGrid.getPSDEGridId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEGEIUpdateService.importModelV2(pSDEGEIUpdate, objectNode);
            SessionFactoryManager.commit();
            return pSDEGEIUpdateService.getFile((IEntity)pSDEGEIUpdate);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEGridLogics(PSDEGrid pSDEGrid, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEGRIDLOGIC", true), (boolean)false) == 0) {
            PSDEGridLogicService pSDEGridLogicService = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEGridLogic pSDEGridLogic = new PSDEGridLogic();
            pSDEGridLogic.setPSDEGridColLogicId(pSMOSFile.getPSModelId());
            if (!pSDEGridLogicService.get((IEntity)pSDEGridLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEGridLogic.getPSDEGridId(), (String)pSDEGrid.getPSDEGridId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEGridLogicService.exportModelV2(pSDEGridLogic);
            pSDEGridLogic.reset();
            if (!pSDEGridLogicService.setModelV2ResScope((IEntity)pSDEGridLogic, "PSDEGRID", pSDEGrid.getPSDEGridId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEGridLogicService.importModelV2(pSDEGridLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDEGridLogicService.getFile((IEntity)pSDEGridLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEGrid pSDEGrid, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEGridCols(pSDEGrid, list);
        this.onFillPasteHelps_PSDEGEIUpdates(pSDEGrid, list);
        this.onFillPasteHelps_PSDEGridLogics(pSDEGrid, list);
        super.onFillPasteHelps(pSDEGrid, list);
    }

    protected void onFillPasteHelps_PSDEGridCols(PSDEGrid pSDEGrid, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEGRIDCOL");
        pSHelpSection.setSectionParam2("DER1N_PSDEGRIDCOL_PSDEGRID_PSDEGRIDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u8868\u683c]\u7684[\u8868\u683c\u5217]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEGEIUpdates(PSDEGrid pSDEGrid, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEGEIUPDATE");
        pSHelpSection.setSectionParam2("DER1N_PSDEGEIUPDATE_PSDEGRID_PSDEGRIDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u8868\u683c]\u7684[\u8868\u683c\u7f16\u8f91\u9879\u66f4\u65b0\u6a21\u5f0f]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEGridLogics(PSDEGrid pSDEGrid, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEGRIDLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDEGRIDLOGIC_PSDEGRID_PSDEGRIDID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u8868\u683c]\u7684[\u8868\u683c\u903b\u8f91]");
        list.add(pSHelpSection);
    }
}

