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
import net.ibizsys.pscore.srv.dedesign.dao.PSDETreeViewDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeViewDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdate;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETEIUpdateBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeCol;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeColBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeRS;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNodeRSBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETEIUpdateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
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

public abstract class PSDETreeViewServiceBase
extends PSCoreSysServiceBase<PSDETreeView> {
    private static final Log log = LogFactory.getLog(PSDETreeViewServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURAPPGANTT = "CurAppGantt";
    public static final String DATASET_CURAPPGRID = "CurAppGrid";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDEGANTT = "CurDEGantt";
    public static final String DATASET_CURDEGRID = "CurDEGrid";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSGANTT = "CurSysGantt";
    public static final String DATASET_CURSYSGRID = "CurSysGrid";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_JITPREVIEW = "JITPREVIEW";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSDETreeViewDEModel pSDETreeViewDEModel;
    private PSDETreeViewDAO pSDETreeViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService";
    }

    public PSDETreeViewDEModel getPSDETreeViewDEModel() {
        if (this.pSDETreeViewDEModel == null) {
            try {
                this.pSDETreeViewDEModel = (PSDETreeViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDETreeViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDETreeViewDEModel();
    }

    public PSDETreeViewDAO getPSDETreeViewDAO() {
        if (this.pSDETreeViewDAO == null) {
            try {
                this.pSDETreeViewDAO = (PSDETreeViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDETreeViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDETreeViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDETreeViewDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPGANTT, (boolean)true) == 0) {
            return this.fetchCurAppGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPGRID, (boolean)true) == 0) {
            return this.fetchCurAppGrid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEGANTT, (boolean)true) == 0) {
            return this.fetchCurDEGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEGRID, (boolean)true) == 0) {
            return this.fetchCurDEGrid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSGANTT, (boolean)true) == 0) {
            return this.fetchCurSysGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSGRID, (boolean)true) == 0) {
            return this.fetchCurSysGrid(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPGANTT, (boolean)true) == 0) {
            return this.fetchTempCurAppGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPGRID, (boolean)true) == 0) {
            return this.fetchTempCurAppGrid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEGANTT, (boolean)true) == 0) {
            return this.fetchTempCurDEGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEGRID, (boolean)true) == 0) {
            return this.fetchTempCurDEGrid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSGANTT, (boolean)true) == 0) {
            return this.fetchTempCurSysGantt(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSGRID, (boolean)true) == 0) {
            return this.fetchTempCurSysGrid(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSDETreeView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDETreeView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDETreeView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDETreeView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW, (boolean)true) == 0) {
            this.jITPreview((PSDETreeView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDETreeView)iEntity);
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

    public DBFetchResult fetchCurAppGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPGANTT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAppGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPGANTT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurAppGrid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPGRID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAppGrid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPGRID, true);
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

    public DBFetchResult fetchCurDEGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEGANTT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEGANTT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurDEGrid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEGRID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEGrid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEGRID, true);
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

    public DBFetchResult fetchCurSysGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSGANTT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysGantt(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSGANTT, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysGrid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSGRID, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysGrid(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSGRID, true);
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

    public void createWithModel(PSDETreeView pSDETreeView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSDETreeView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDETreeView, ACTION_CREATEWITHMODEL);
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDETreeViewServiceBase.this.getService(), PSDETreeViewServiceBase.ACTION_CREATEWITHMODEL, 40, pSDETreeView2, null).getResult() != 1) {
                    PSDETreeViewServiceBase.this.onCreateWithModel(pSDETreeView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSDETreeView, null);
        }
    }

    protected void onCreateWithModel(PSDETreeView pSDETreeView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSDETreeView pSDETreeView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, pSDETreeView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDETreeView, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDETreeViewServiceBase.this.getService(), PSDETreeViewServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, pSDETreeView2, null).getResult() != 1) {
                    PSDETreeViewServiceBase.this.onGetDraftFromWithModel(pSDETreeView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, pSDETreeView, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDETreeView pSDETreeView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDETreeView pSDETreeView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, pSDETreeView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDETreeView, ACTION_GETDRAFTWITHMODEL);
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDETreeViewServiceBase.this.getService(), PSDETreeViewServiceBase.ACTION_GETDRAFTWITHMODEL, 40, pSDETreeView2, null).getResult() != 1) {
                    PSDETreeViewServiceBase.this.onGetDraftWithModel(pSDETreeView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, pSDETreeView, null);
        }
    }

    protected void onGetDraftWithModel(PSDETreeView pSDETreeView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDETreeView pSDETreeView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSDETreeView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDETreeView, ACTION_GETWITHMODEL);
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDETreeViewServiceBase.this.getService(), PSDETreeViewServiceBase.ACTION_GETWITHMODEL, 40, pSDETreeView2, null).getResult() != 1) {
                    PSDETreeViewServiceBase.this.onGetWithModel(pSDETreeView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSDETreeView, null);
        }
    }

    protected void onGetWithModel(PSDETreeView pSDETreeView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void jITPreview(PSDETreeView pSDETreeView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 0, pSDETreeView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDETreeView, ACTION_JITPREVIEW);
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDETreeViewServiceBase.this.getService(), PSDETreeViewServiceBase.ACTION_JITPREVIEW, 40, pSDETreeView2, null).getResult() != 1) {
                    PSDETreeViewServiceBase.this.onJITPreview(pSDETreeView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 99, pSDETreeView, null);
        }
    }

    protected void onJITPreview(PSDETreeView pSDETreeView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW]");
    }

    public void updateWithModel(PSDETreeView pSDETreeView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSDETreeView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDETreeView, ACTION_UPDATEWITHMODEL);
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDETreeViewServiceBase.this.getService(), PSDETreeViewServiceBase.ACTION_UPDATEWITHMODEL, 40, pSDETreeView2, null).getResult() != 1) {
                    PSDETreeViewServiceBase.this.onUpdateWithModel(pSDETreeView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSDETreeView, null);
        }
    }

    protected void onUpdateWithModel(PSDETreeView pSDETreeView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDETreeView pSDETreeView, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSACHandler);
            } else {
                iService.get(pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDETreeView, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSCODELIST_CATPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCodeList);
            } else {
                iService.get(pSCodeList);
            }
            this.onFillParentInfo_CatPSCodeList(pSDETreeView, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup);
            } else {
                iService.get(pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDETreeView, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlMsg);
            } else {
                iService.get(pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSDETreeView, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDETreeView, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEGrid);
            } else {
                iService.get(pSDEGrid);
            }
            this.onFillParentInfo_PSDEGrid(pSDETreeView, pSDEGrid);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSLANGUAGERES_EMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSLanguageRes);
            } else {
                iService.get(pSLanguageRes);
            }
            this.onFillParentInfo_EmptyTextPSLanRes(pSDETreeView, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCounter);
            } else {
                iService.get(pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSDETreeView, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDETreeView, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDETreeView, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDETreeView, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETREEVIEW_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSDETreeView, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo(pSDETreeView, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDETreeView pSDETreeView, PSACHandler pSACHandler) throws Exception {
        pSDETreeView.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDETreeView.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_CatPSCodeList(PSDETreeView pSDETreeView, PSCodeList pSCodeList) throws Exception {
        pSDETreeView.setCatPSCodeListId(pSCodeList.getPSCodeListId());
        pSDETreeView.setCatPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDETreeView pSDETreeView, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDETreeView.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDETreeView.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSDETreeView pSDETreeView, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSDETreeView.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSDETreeView.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_PSDE(PSDETreeView pSDETreeView, PSDataEntity pSDataEntity) throws Exception {
        pSDETreeView.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDETreeView.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSSystem() != null) {
            this.onFillParentInfo_PSSystem(pSDETreeView, pSDataEntity.getPSSystem());
        }
    }

    protected void onFillParentInfo_PSDEGrid(PSDETreeView pSDETreeView, PSDEGrid pSDEGrid) throws Exception {
        pSDETreeView.setPSDEGridId(pSDEGrid.getPSDEGridId());
        pSDETreeView.setPSDEGridName(pSDEGrid.getPSDEGridName());
    }

    protected void onFillParentInfo_EmptyTextPSLanRes(PSDETreeView pSDETreeView, PSLanguageRes pSLanguageRes) throws Exception {
        pSDETreeView.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDETreeView.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCounter(PSDETreeView pSDETreeView, PSSysCounter pSSysCounter) throws Exception {
        pSDETreeView.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSDETreeView.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_PSSysCss(PSDETreeView pSDETreeView, PSSysCss pSSysCss) throws Exception {
        pSDETreeView.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDETreeView.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDETreeView pSDETreeView, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDETreeView.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDETreeView.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSDETreeView pSDETreeView, PSSystem pSSystem) throws Exception {
        pSDETreeView.setPSSystemId(pSSystem.getPSSystemId());
        pSDETreeView.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSDETreeView pSDETreeView, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSDETreeView.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSDETreeView.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSDETreeView pSDETreeView, boolean bl) throws Exception {
        if (bl) {
            if (pSDETreeView.getShowRoot() == null) {
                pSDETreeView.setShowRoot((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDETreeView.getTreeGridFlag() == null) {
                pSDETreeView.setTreeGridFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
        }
        super.onFillEntityFullInfo(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDETreeView, bl);
        this.onFillEntityFullInfo_CatPSCodeList(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSDE(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSDEGrid(pSDETreeView, bl);
        this.onFillEntityFullInfo_EmptyTextPSLanRes(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSSystem(pSDETreeView, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSDETreeView, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDETreeView pSDETreeView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CatPSCodeList(PSDETreeView pSDETreeView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDETreeView pSDETreeView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSDETreeView pSDETreeView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDETreeView pSDETreeView, boolean bl) throws Exception {
        if (pSDETreeView.isPSDEIdDirty()) {
            if (pSDETreeView.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSDETreeView.getPSDEId() == null || pSDETreeView.getPSDEName() == null) {
                    pSDataEntity = pSDETreeView.getPSDE();
                    pSDETreeView.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSDETreeView.getPSDE()).getPSSystemId(), (Object)pSDETreeView.getPSSystemId()) != 0L) {
                    pSDETreeView.setPSSystemId(pSDataEntity.getPSSystemId());
                    this.onFillEntityFullInfo_PSSystem(pSDETreeView, bl);
                }
            } else {
                pSDETreeView.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEGrid(PSDETreeView pSDETreeView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmptyTextPSLanRes(PSDETreeView pSDETreeView, boolean bl) throws Exception {
        if (pSDETreeView.isEmptyTextPSLanResIdDirty()) {
            if (pSDETreeView.getEmptyTextPSLanResId() != null) {
                if (pSDETreeView.getEmptyTextPSLanResId() == null || pSDETreeView.getEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDETreeView.getEmptyTextPSLanRes();
                    pSDETreeView.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDETreeView.setEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSDETreeView pSDETreeView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDETreeView pSDETreeView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDETreeView pSDETreeView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSDETreeView pSDETreeView, boolean bl) throws Exception {
        if (pSDETreeView.isPSSystemIdDirty()) {
            if (pSDETreeView.getPSSystemId() != null) {
                if (pSDETreeView.getPSSystemId() == null || pSDETreeView.getPSSystemName() == null) {
                    PSSystem pSSystem = pSDETreeView.getPSSystem();
                    pSDETreeView.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSDETreeView.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSDETreeView pSDETreeView, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDETreeView pSDETreeView, boolean bl) throws Exception {
        super.onWriteBackParent(pSDETreeView, bl);
    }

    public ArrayList<PSDETreeView> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeView> selectByCatPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByCatPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByCatPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByCatPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByCatPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CATPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCatPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCatPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeView> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeView> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeView> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeView> selectByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEGRIDID", (Object)pSDEGridBase.getPSDEGridId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEGridCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEGridCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDETreeView> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeView> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeView> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeView> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeView> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDETreeView> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSDETreeView> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSDETreeView> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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
        ArrayList<PSDETreeView> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSACHandlerId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDETreeViewServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByCatPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByCatPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSCODELIST_CATPSCODELISTID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSCodeList), arrayList.get(0)));
        }
    }

    public void resetCatPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByCatPSCodeList(pSCodeList);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setCatPSCodeListId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByCatPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByCatPSCodeList(pSCodeList2);
                PSDETreeViewServiceBase.this.internalRemoveByCatPSCodeList(pSCodeList2);
                PSDETreeViewServiceBase.this.onAfterRemoveByCatPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByCatPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByCatPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByCatPSCodeList(pSCodeList);
        this.onBeforeRemoveByCatPSCodeList(pSCodeList, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByCatPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByCatPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByCatPSCodeList(PSCodeList pSCodeList, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCatPSCodeList(PSCodeList pSCodeList, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSCtrlLogicGroupId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDETreeViewServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSCtrlMsgId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDETreeViewServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSDEId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDETreeViewServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSDEGrid(pSDEGrid, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEGRID");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEGrid);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSDEGRID_PSDEGRIDID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSDEGrid), arrayList.get(0)));
        }
    }

    public void resetPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSDEGrid(pSDEGrid);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSDEGridId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSDEGrid(pSDEGrid2);
                PSDETreeViewServiceBase.this.internalRemoveByPSDEGrid(pSDEGrid2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByPSDEGrid(pSDEGrid, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSLANGUAGERES_EMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setEmptyTextPSLanResId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDETreeViewServiceBase.this.internalRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDETreeViewServiceBase.this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSSysCounterId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSDETreeViewServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSSysCssId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDETreeViewServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSSysPFPluginId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDETreeViewServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSSystemId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDETreeViewServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETREEVIEW_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSDETREEVIEW", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSDETreeView pSDETreeView : arrayList) {
            PSDETreeView pSDETreeView2 = (PSDETreeView)this.getDEModel().createEntity();
            pSDETreeView2.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
            pSDETreeView2.setPSViewMsgGroupId(null);
            this.update(pSDETreeView2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDETreeViewServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDETreeViewServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDETreeViewServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDETreeView> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSDETreeView pSDETreeView : arrayList) {
            this.remove(pSDETreeView);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDETreeView> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDETreeView pSDETreeView) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETEIUDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        ((PSDETEIUDetailServiceBase)pSCoreSysServiceBase).removeByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).removeByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).removeByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).removeByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).removeByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).removeByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDETreeView(pSDETreeView);
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).removeByPSDETreeView(pSDETreeView);
        super.onBeforeRemove(pSDETreeView);
    }

    protected void onBeforeRemoveTemp(PSDETreeView pSDETreeView) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETEIUDetailServiceBase)pSCoreSysServiceBase).removeTempByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).removeTempByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).removeTempByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).removeTempByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).removeTempByPSDETreeView(pSDETreeView);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).removeTempByPSDETreeView(pSDETreeView);
        super.onBeforeRemoveTemp(pSDETreeView);
    }

    protected void getRelatedDataTempMajor(PSDETreeView pSDETreeView) throws Exception {
        this.getRelatedDataTempMajor_PSDETreeNode(pSDETreeView);
        this.getRelatedDataTempMajor_PSDETreeCol(pSDETreeView);
        this.getRelatedDataTempMajor_PSDETEIUpdate(pSDETreeView);
        this.getRelatedDataTempMajor_PSDETreeNodeRS(pSDETreeView);
        this.getRelatedDataTempMajor_PSDETreeNodeCol(pSDETreeView);
        this.getRelatedDataTempMajor_PSDETEIUDetail(pSDETreeView);
        this.getRelatedDataTempMajor_PSDETreeLogic(pSDETreeView);
        super.getRelatedDataTempMajor(pSDETreeView);
    }

    protected void getRelatedDataTempMajor_PSDETreeNode(PSDETreeView pSDETreeView) throws Exception {
        PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNode> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeNodeService.selectByPSDETreeView(pSDETreeView) : pSDETreeNodeService.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETreeNode pSDETreeNode : arrayList) {
            pSDETreeNodeService.getTempMajor(pSDETreeNode);
        }
    }

    protected void getRelatedDataTempMajor_PSDETreeCol(PSDETreeView pSDETreeView) throws Exception {
        PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeCol> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeColService.selectByPSDETreeView(pSDETreeView) : pSDETreeColService.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETreeCol pSDETreeCol : arrayList) {
            pSDETreeColService.getTempMajor(pSDETreeCol);
        }
    }

    protected void getRelatedDataTempMajor_PSDETEIUpdate(PSDETreeView pSDETreeView) throws Exception {
        PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUpdate> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETEIUpdateService.selectByPSDETreeView(pSDETreeView) : pSDETEIUpdateService.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            pSDETEIUpdateService.getTempMajor(pSDETEIUpdate);
        }
    }

    protected void getRelatedDataTempMajor_PSDETreeNodeRS(PSDETreeView pSDETreeView) throws Exception {
        PSDETreeNodeRSService pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeRS> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeNodeRSService.selectByPSDETreeView(pSDETreeView) : pSDETreeNodeRSService.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            pSDETreeNodeRSService.getTempMajor(pSDETreeNodeRS);
        }
    }

    protected void getRelatedDataTempMajor_PSDETreeNodeCol(PSDETreeView pSDETreeView) throws Exception {
        PSDETreeNodeColService pSDETreeNodeColService = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeCol> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeNodeColService.selectByPSDETreeView(pSDETreeView) : pSDETreeNodeColService.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            pSDETreeNodeColService.getTempMajor(pSDETreeNodeCol);
        }
    }

    protected void getRelatedDataTempMajor_PSDETEIUDetail(PSDETreeView pSDETreeView) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUDetail> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETEIUDetailService.selectByPSDETreeView(pSDETreeView) : pSDETEIUDetailService.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            pSDETEIUDetailService.getTempMajor(pSDETEIUDetail);
        }
    }

    protected void getRelatedDataTempMajor_PSDETreeLogic(PSDETreeView pSDETreeView) throws Exception {
        PSDETreeLogicService pSDETreeLogicService = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeLogic> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeLogicService.selectByPSDETreeView(pSDETreeView) : pSDETreeLogicService.selectTempByPSDETreeView(pSDETreeView);
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            pSDETreeLogicService.getTempMajor(pSDETreeLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2) throws Exception {
        ArrayList<PSDETreeLogic> arrayList = this.updateRelatedDataTempMajor_removePSDETreeLogic(pSDETreeView, pSDETreeView2);
        ArrayList<PSDETEIUDetail> arrayList2 = this.updateRelatedDataTempMajor_removePSDETEIUDetail(pSDETreeView, pSDETreeView2);
        ArrayList<PSDETreeNodeCol> arrayList3 = this.updateRelatedDataTempMajor_removePSDETreeNodeCol(pSDETreeView, pSDETreeView2);
        ArrayList<PSDETreeNodeRS> arrayList4 = this.updateRelatedDataTempMajor_removePSDETreeNodeRS(pSDETreeView, pSDETreeView2);
        ArrayList<PSDETEIUpdate> arrayList5 = this.updateRelatedDataTempMajor_removePSDETEIUpdate(pSDETreeView, pSDETreeView2);
        ArrayList<PSDETreeCol> arrayList6 = this.updateRelatedDataTempMajor_removePSDETreeCol(pSDETreeView, pSDETreeView2);
        ArrayList<PSDETreeNode> arrayList7 = this.updateRelatedDataTempMajor_removePSDETreeNode(pSDETreeView, pSDETreeView2);
        this.updateRelatedDataTempMajor_updatePSDETreeNode(pSDETreeView, pSDETreeView2, arrayList7);
        this.updateRelatedDataTempMajor_updatePSDETreeCol(pSDETreeView, pSDETreeView2, arrayList6);
        this.updateRelatedDataTempMajor_updatePSDETEIUpdate(pSDETreeView, pSDETreeView2, arrayList5);
        this.updateRelatedDataTempMajor_updatePSDETreeNodeRS(pSDETreeView, pSDETreeView2, arrayList4);
        this.updateRelatedDataTempMajor_updatePSDETreeNodeCol(pSDETreeView, pSDETreeView2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSDETEIUDetail(pSDETreeView, pSDETreeView2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDETreeLogic(pSDETreeView, pSDETreeView2, arrayList);
        super.updateRelatedDataTempMajor(pSDETreeView, pSDETreeView2);
    }

    protected ArrayList<PSDETreeNode> updateRelatedDataTempMajor_removePSDETreeNode(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2) throws Exception {
        PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNode> arrayList = pSDETreeNodeService.selectTempByPSDETreeView(pSDETreeView);
        ArrayList<PSDETreeNode> arrayList2 = pSDETreeNodeService.selectByPSDETreeView(pSDETreeView2);
        HashMap<String, PSDETreeNode> hashMap = new HashMap<String, PSDETreeNode>();
        for (PSDETreeNode pSDETreeNode : arrayList2) {
            hashMap.put(pSDETreeNode.getPSDETreeNodeId(), pSDETreeNode);
        }
        for (PSDETreeNode pSDETreeNode : arrayList) {
            Object object = pSDETreeNode.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETreeNode pSDETreeNode : hashMap.values()) {
            pSDETreeNodeService.remove(pSDETreeNode);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETreeNode(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2, ArrayList<PSDETreeNode> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETreeNode pSDETreeNode : arrayList) {
            pSDETreeNodeService.updateTempMajor(pSDETreeNode);
        }
    }

    protected ArrayList<PSDETreeCol> updateRelatedDataTempMajor_removePSDETreeCol(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2) throws Exception {
        PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeCol> arrayList = pSDETreeColService.selectTempByPSDETreeView(pSDETreeView);
        ArrayList<PSDETreeCol> arrayList2 = pSDETreeColService.selectByPSDETreeView(pSDETreeView2);
        HashMap<String, PSDETreeCol> hashMap = new HashMap<String, PSDETreeCol>();
        for (PSDETreeCol pSDETreeCol : arrayList2) {
            hashMap.put(pSDETreeCol.getPSDETreeColId(), pSDETreeCol);
        }
        for (PSDETreeCol pSDETreeCol : arrayList) {
            Object object = pSDETreeCol.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETreeCol pSDETreeCol : hashMap.values()) {
            pSDETreeColService.remove(pSDETreeCol);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETreeCol(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2, ArrayList<PSDETreeCol> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETreeCol pSDETreeCol : arrayList) {
            pSDETreeColService.updateTempMajor(pSDETreeCol);
        }
    }

    protected ArrayList<PSDETEIUpdate> updateRelatedDataTempMajor_removePSDETEIUpdate(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2) throws Exception {
        PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUpdate> arrayList = pSDETEIUpdateService.selectTempByPSDETreeView(pSDETreeView);
        ArrayList<PSDETEIUpdate> arrayList2 = pSDETEIUpdateService.selectByPSDETreeView(pSDETreeView2);
        HashMap<String, PSDETEIUpdate> hashMap = new HashMap<String, PSDETEIUpdate>();
        for (PSDETEIUpdate pSDETEIUpdate : arrayList2) {
            hashMap.put(pSDETEIUpdate.getPSDETEIUpdateId(), pSDETEIUpdate);
        }
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            Object object = pSDETEIUpdate.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETEIUpdate pSDETEIUpdate : hashMap.values()) {
            pSDETEIUpdateService.remove(pSDETEIUpdate);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETEIUpdate(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2, ArrayList<PSDETEIUpdate> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETEIUpdate pSDETEIUpdate : arrayList) {
            pSDETEIUpdateService.updateTempMajor(pSDETEIUpdate);
        }
    }

    protected ArrayList<PSDETreeNodeRS> updateRelatedDataTempMajor_removePSDETreeNodeRS(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2) throws Exception {
        PSDETreeNodeRSService pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeRS> arrayList = pSDETreeNodeRSService.selectTempByPSDETreeView(pSDETreeView);
        ArrayList<PSDETreeNodeRS> arrayList2 = pSDETreeNodeRSService.selectByPSDETreeView(pSDETreeView2);
        HashMap<String, PSDETreeNodeRS> hashMap = new HashMap<String, PSDETreeNodeRS>();
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList2) {
            hashMap.put(pSDETreeNodeRS.getPSDETreeNodeRSId(), pSDETreeNodeRS);
        }
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            Object object = pSDETreeNodeRS.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETreeNodeRS pSDETreeNodeRS : hashMap.values()) {
            pSDETreeNodeRSService.remove(pSDETreeNodeRS);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETreeNodeRS(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2, ArrayList<PSDETreeNodeRS> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETreeNodeRSService pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList) {
            pSDETreeNodeRSService.updateTempMajor(pSDETreeNodeRS);
        }
    }

    protected ArrayList<PSDETreeNodeCol> updateRelatedDataTempMajor_removePSDETreeNodeCol(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2) throws Exception {
        PSDETreeNodeColService pSDETreeNodeColService = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeCol> arrayList = pSDETreeNodeColService.selectTempByPSDETreeView(pSDETreeView);
        ArrayList<PSDETreeNodeCol> arrayList2 = pSDETreeNodeColService.selectByPSDETreeView(pSDETreeView2);
        HashMap<String, PSDETreeNodeCol> hashMap = new HashMap<String, PSDETreeNodeCol>();
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList2) {
            hashMap.put(pSDETreeNodeCol.getPSDETreeNodeColId(), pSDETreeNodeCol);
        }
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            Object object = pSDETreeNodeCol.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETreeNodeCol pSDETreeNodeCol : hashMap.values()) {
            pSDETreeNodeColService.remove(pSDETreeNodeCol);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETreeNodeCol(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2, ArrayList<PSDETreeNodeCol> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETreeNodeColService pSDETreeNodeColService = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList) {
            pSDETreeNodeColService.updateTempMajor(pSDETreeNodeCol);
        }
    }

    protected ArrayList<PSDETEIUDetail> updateRelatedDataTempMajor_removePSDETEIUDetail(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUDetail> arrayList = pSDETEIUDetailService.selectTempByPSDETreeView(pSDETreeView);
        ArrayList<PSDETEIUDetail> arrayList2 = pSDETEIUDetailService.selectByPSDETreeView(pSDETreeView2);
        HashMap<String, PSDETEIUDetail> hashMap = new HashMap<String, PSDETEIUDetail>();
        for (PSDETEIUDetail pSDETEIUDetail : arrayList2) {
            hashMap.put(pSDETEIUDetail.getPSDETEIUDetailId(), pSDETEIUDetail);
        }
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            Object object = pSDETEIUDetail.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETEIUDetail pSDETEIUDetail : hashMap.values()) {
            pSDETEIUDetailService.remove(pSDETEIUDetail);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETEIUDetail(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2, ArrayList<PSDETEIUDetail> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETEIUDetail pSDETEIUDetail : arrayList) {
            pSDETEIUDetailService.updateTempMajor(pSDETEIUDetail);
        }
    }

    protected ArrayList<PSDETreeLogic> updateRelatedDataTempMajor_removePSDETreeLogic(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2) throws Exception {
        PSDETreeLogicService pSDETreeLogicService = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeLogic> arrayList = pSDETreeLogicService.selectTempByPSDETreeView(pSDETreeView);
        ArrayList<PSDETreeLogic> arrayList2 = pSDETreeLogicService.selectByPSDETreeView(pSDETreeView2);
        HashMap<String, PSDETreeLogic> hashMap = new HashMap<String, PSDETreeLogic>();
        for (PSDETreeLogic pSDETreeLogic : arrayList2) {
            hashMap.put(pSDETreeLogic.getPSDETreeLogicId(), pSDETreeLogic);
        }
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            Object object = pSDETreeLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETreeLogic pSDETreeLogic : hashMap.values()) {
            pSDETreeLogicService.remove(pSDETreeLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETreeLogic(PSDETreeView pSDETreeView, PSDETreeView pSDETreeView2, ArrayList<PSDETreeLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETreeLogicService pSDETreeLogicService = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETreeLogic pSDETreeLogic : arrayList) {
            pSDETreeLogicService.updateTempMajor(pSDETreeLogic);
        }
    }

    protected void replaceParentInfo(PSDETreeView pSDETreeView, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDETreeView, cloneSession);
        if (pSDETreeView.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDETreeView.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDETreeView, (PSACHandler)iEntity);
        }
        if (pSDETreeView.getCatPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDETreeView.getCatPSCodeListId())) != null) {
            this.onFillParentInfo_CatPSCodeList(pSDETreeView, (PSCodeList)iEntity);
        }
        if (pSDETreeView.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDETreeView.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDETreeView, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDETreeView.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSDETreeView.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSDETreeView, (PSCtrlMsg)iEntity);
        }
        if (pSDETreeView.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDETreeView.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDETreeView, (PSDataEntity)iEntity);
        }
        if (pSDETreeView.getPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSDETreeView.getPSDEGridId())) != null) {
            this.onFillParentInfo_PSDEGrid(pSDETreeView, (PSDEGrid)iEntity);
        }
        if (pSDETreeView.getEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDETreeView.getEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_EmptyTextPSLanRes(pSDETreeView, (PSLanguageRes)iEntity);
        }
        if (pSDETreeView.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSDETreeView.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSDETreeView, (PSSysCounter)iEntity);
        }
        if (pSDETreeView.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDETreeView.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDETreeView, (PSSysCss)iEntity);
        }
        if (pSDETreeView.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDETreeView.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDETreeView, (PSSysPFPlugin)iEntity);
        }
        if (pSDETreeView.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDETreeView.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDETreeView, (PSSystem)iEntity);
        }
        if (pSDETreeView.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSDETreeView.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSDETreeView, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDETreeView pSDETreeView, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDETreeView, bl);
        pSDETreeView.resetCodeName();
    }

    protected void onCheckEntity(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BufferRendererMode(bl, pSDETreeView, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CatPSCodeListId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColEnableFilter(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColEnableLink(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResName(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableEdit(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemPriv(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableSearch(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FrozenCol(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FrozenLastCol(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewHeight(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxHeight(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxWidth(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinHeight(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinWidth(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewPos(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewShowMode(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewWidth(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoIconDefault(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewName(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RootSelect(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowRoot(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TreeGridFlag(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TreeModel(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TreeStyle(bl, pSDETreeView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDETreeView, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BufferRendererMode(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isBufferRendererModeDirty() : !pSDETreeView.isBufferRendererModeDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getBufferRendererMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BufferRendererMode_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isBusyIndicatorDirty() : !pSDETreeView.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_CatPSCodeListId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isCatPSCodeListIdDirty() : !pSDETreeView.isCatPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getCatPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CatPSCodeListId_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CATPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isCodeNameDirty() && !bl2 : !pSDETreeView.isCodeNameDirty()) {
            return null;
        }
        String string = pSDETreeView.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDETreeView, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDETreeViewDEModel(), "CODENAME", string3, pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColEnableFilter(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isColEnableFilterDirty() : !pSDETreeView.isColEnableFilterDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getColEnableFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColEnableFilter_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ColEnableLink(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isColEnableLinkDirty() : !pSDETreeView.isColEnableLinkDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getColEnableLink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColEnableLink_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isEmptyTextDirty() : !pSDETreeView.isEmptyTextDirty()) {
            return null;
        }
        String string = pSDETreeView.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isEmptyTextPSLanResIdDirty() : !pSDETreeView.isEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResName(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isEmptyTextPSLanResNameDirty() : !pSDETreeView.isEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSDETreeView.getEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResName_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableEdit(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isEnableEditDirty() : !pSDETreeView.isEnableEditDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getEnableEdit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableEdit_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableItemPriv(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isEnableItemPrivDirty() : !pSDETreeView.isEnableItemPrivDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getEnableItemPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemPriv_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableSearch(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isEnableSearchDirty() : !pSDETreeView.isEnableSearchDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getEnableSearch();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableSearch_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLESEARCH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FrozenCol(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isFrozenColDirty() : !pSDETreeView.isFrozenColDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getFrozenCol();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FrozenCol_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_FrozenLastCol(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isFrozenLastColDirty() : !pSDETreeView.isFrozenLastColDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getFrozenLastCol();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FrozenLastCol_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isLockFlagDirty() : !pSDETreeView.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isMemoDirty() : !pSDETreeView.isMemoDirty()) {
            return null;
        }
        String string = pSDETreeView.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewHeight(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isNavViewHeightDirty() : !pSDETreeView.isNavViewHeightDirty()) {
            return null;
        }
        Double d = pSDETreeView.getNavViewHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewHeight_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMaxHeight(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isNavViewMaxHeightDirty() : !pSDETreeView.isNavViewMaxHeightDirty()) {
            return null;
        }
        Double d = pSDETreeView.getNavViewMaxHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxHeight_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMaxWidth(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isNavViewMaxWidthDirty() : !pSDETreeView.isNavViewMaxWidthDirty()) {
            return null;
        }
        Double d = pSDETreeView.getNavViewMaxWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxWidth_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMinHeight(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isNavViewMinHeightDirty() : !pSDETreeView.isNavViewMinHeightDirty()) {
            return null;
        }
        Double d = pSDETreeView.getNavViewMinHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinHeight_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMinWidth(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isNavViewMinWidthDirty() : !pSDETreeView.isNavViewMinWidthDirty()) {
            return null;
        }
        Double d = pSDETreeView.getNavViewMinWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinWidth_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewPos(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isNavViewPosDirty() : !pSDETreeView.isNavViewPosDirty()) {
            return null;
        }
        String string = pSDETreeView.getNavViewPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewPos_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewShowMode(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isNavViewShowModeDirty() : !pSDETreeView.isNavViewShowModeDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getNavViewShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewShowMode_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewWidth(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isNavViewWidthDirty() : !pSDETreeView.isNavViewWidthDirty()) {
            return null;
        }
        Double d = pSDETreeView.getNavViewWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewWidth_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NoIconDefault(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isNoIconDefaultDirty() : !pSDETreeView.isNoIconDefaultDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getNoIconDefault();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoIconDefault_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NOICONDEFAULT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSACHandlerIdDirty() : !pSDETreeView.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSCtrlLogicGroupIdDirty() : !pSDETreeView.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSCtrlMsgIdDirty() : !pSDETreeView.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSDEGridIdDirty() : !pSDETreeView.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSDEGridId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSDEIdDirty() && !bl2 : !pSDETreeView.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSDENameDirty() && !bl2 : !pSDETreeView.isPSDENameDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSDETreeViewIdDirty() && !bl2 : !pSDETreeView.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSDETreeViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDETreeViewName(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSDETreeViewNameDirty() && !bl2 : !pSDETreeView.isPSDETreeViewNameDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSDETreeViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewName_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETREEVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSSysCounterIdDirty() : !pSDETreeView.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSSysCssIdDirty() : !pSDETreeView.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSSysPFPluginIdDirty() : !pSDETreeView.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSSystemIdDirty() && !bl2 : !pSDETreeView.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSSystemNameDirty() && !bl2 : !pSDETreeView.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isPSViewMsgGroupIdDirty() : !pSDETreeView.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSDETreeView.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_RootSelect(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isRootSelectDirty() : !pSDETreeView.isRootSelectDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getRootSelect();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RootSelect_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROOTSELECT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowRoot(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isShowRootDirty() : !pSDETreeView.isShowRootDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getShowRoot();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowRoot_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWROOT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isSRFSysPubDirty() : !pSDETreeView.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isToDoTaskDirty() : !pSDETreeView.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDETreeView.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default(pSDETreeView, bl2, bl3);
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

    protected EntityFieldError onCheckField_TreeGridFlag(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isTreeGridFlagDirty() : !pSDETreeView.isTreeGridFlagDirty()) {
            return null;
        }
        Integer n = pSDETreeView.getTreeGridFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TreeGridFlag_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TREEGRIDFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TreeModel(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isTreeModelDirty() : !pSDETreeView.isTreeModelDirty()) {
            return null;
        }
        String string = pSDETreeView.getTreeModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TreeModel_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TREEMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TreeStyle(boolean bl, PSDETreeView pSDETreeView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDETreeView.isTreeStyleDirty() : !pSDETreeView.isTreeStyleDirty()) {
            return null;
        }
        String string = pSDETreeView.getTreeStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TreeStyle_Default(pSDETreeView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TREESTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDETreeView pSDETreeView, boolean bl) throws Exception {
        super.onSyncEntity(pSDETreeView, bl);
    }

    protected void onSyncIndexEntities(PSDETreeView pSDETreeView, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDETreeView, bl);
    }

    public Object getDataContextValue(PSDETreeView pSDETreeView, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDETreeView, string, iDataContextParam)) != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDETreeView.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        PSSystem pSSystem = pSDETreeView.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDETreeNode_PSDETreeView(pSDETreeView, arrayList, n);
        this.onExportRelatedModel_PSDETreeCol_PSDETreeView(pSDETreeView, arrayList, n);
        this.onExportRelatedModel_PSDETreeNodeRS_PSDETreeView(pSDETreeView, arrayList, n);
        this.onExportRelatedModel_PSDETEIUpdate_PSDETreeView(pSDETreeView, arrayList, n);
        this.onExportRelatedModel_PSDETreeNodeCol_PSDETreeView(pSDETreeView, arrayList, n);
        this.onExportRelatedModel_PSDETEIUDetail_PSDETreeView(pSDETreeView, arrayList, n);
        this.onExportRelatedModel_PSDETreeLogic_PSDETreeView(pSDETreeView, arrayList, n);
        super.onExportRelatedModel(pSDETreeView, arrayList, n);
    }

    protected void onExportRelatedModel_PSDETreeNode_PSDETreeView(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNode> arrayList2 = pSDETreeNodeService.selectByPSDETreeView(pSDETreeView);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"dd2e58dcdf452ead721f5ba437039c39");
            jSONObject.put("srfdename", (Object)"PSDETREENODE");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDETREENODE_PSDETREEVIEW_PSDETREEVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDETreeView, (String)"PSDETREEVIEWID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDETreeNode pSDETreeNode : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDETreeNode, (String)"srfsyspub", (int)1) == 0) continue;
            pSDETreeNodeService.exportModel(pSDETreeNode, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDETreeCol_PSDETreeView(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeCol> arrayList2 = pSDETreeColService.selectByPSDETreeView(pSDETreeView);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"cc051052b723c599282be6c02f78c136");
            jSONObject.put("srfdename", (Object)"PSDETREECOL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDETREECOL_PSDETREEVIEW_PSDETREEVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDETreeView, (String)"PSDETREEVIEWID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDETreeCol pSDETreeCol : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDETreeCol, (String)"srfsyspub", (int)1) == 0) continue;
            pSDETreeColService.exportModel(pSDETreeCol, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDETreeNodeRS_PSDETreeView(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDETreeNodeRSService pSDETreeNodeRSService = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeRS> arrayList2 = pSDETreeNodeRSService.selectByPSDETreeView(pSDETreeView);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"c5a3691654a3a474785871c70891e2e4");
            jSONObject.put("srfdename", (Object)"PSDETREENODERS");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDETREENODERS_PSDETREEVIEW_PSDETREEVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDETreeView, (String)"PSDETREEVIEWID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDETreeNodeRS pSDETreeNodeRS : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDETreeNodeRS, (String)"srfsyspub", (int)1) == 0) continue;
            pSDETreeNodeRSService.exportModel(pSDETreeNodeRS, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDETEIUpdate_PSDETreeView(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDETEIUpdateService pSDETEIUpdateService = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUpdate> arrayList2 = pSDETEIUpdateService.selectByPSDETreeView(pSDETreeView);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"0ebc12cbac705963c07727c8f0b7082f");
            jSONObject.put("srfdename", (Object)"PSDETEIUPDATE");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDETEIUPDATE_PSDETREEVIEW_PSDETREEVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDETreeView, (String)"PSDETREEVIEWID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDETEIUpdate pSDETEIUpdate : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDETEIUpdate, (String)"srfsyspub", (int)1) == 0) continue;
            pSDETEIUpdateService.exportModel(pSDETEIUpdate, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDETreeNodeCol_PSDETreeView(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDETreeNodeColService pSDETreeNodeColService = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeCol> arrayList2 = pSDETreeNodeColService.selectByPSDETreeView(pSDETreeView);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"fab245b69a5a0348ed5c4a45af51fb6d");
            jSONObject.put("srfdename", (Object)"PSDETREENODECOL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDETREENODECOL_PSDETREEVIEW_PSDETREEVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDETreeView, (String)"PSDETREEVIEWID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDETreeNodeCol pSDETreeNodeCol : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDETreeNodeCol, (String)"srfsyspub", (int)1) == 0) continue;
            pSDETreeNodeColService.exportModel(pSDETreeNodeCol, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDETEIUDetail_PSDETreeView(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDETEIUDetailService pSDETEIUDetailService = (PSDETEIUDetailService)ServiceGlobal.getService(PSDETEIUDetailService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUDetail> arrayList2 = pSDETEIUDetailService.selectByPSDETreeView(pSDETreeView);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"d5388688453316fae1814881bc3cf2a9");
            jSONObject.put("srfdename", (Object)"PSDETEIUDETAIL");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDETEIUDETAIL_PSDETREEVIEW_PSDETREEVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDETreeView, (String)"PSDETREEVIEWID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDETEIUDetail pSDETEIUDetail : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDETEIUDetail, (String)"srfsyspub", (int)1) == 0) continue;
            pSDETEIUDetailService.exportModel(pSDETEIUDetail, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDETreeLogic_PSDETreeView(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDETreeLogicService pSDETreeLogicService = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeLogic> arrayList2 = pSDETreeLogicService.selectByPSDETreeView(pSDETreeView);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"7058e0f6691aabb635234eff9f346f12");
            jSONObject.put("srfdename", (Object)"PSDETREELOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDETREELOGIC_PSDETREEVIEW_PSDETREEVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDETreeView, (String)"PSDETREEVIEWID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDETreeLogic pSDETreeLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDETreeLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDETreeLogicService.exportModel(pSDETreeLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_EmptyTextPSLanRes(pSDETreeView, arrayList, n);
        super.onExportMajorModel(pSDETreeView, arrayList, n);
    }

    protected void onExportMajorModel_EmptyTextPSLanRes(PSDETreeView pSDETreeView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDETreeView.getEmptyTextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel(pSDETreeView.getEmptyTextPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BUFFERRENDERERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BufferRendererMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CATPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatPSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CATPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CatPSCodeListName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ENABLEEDIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableEdit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEITEMPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableItemPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLESEARCH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableSearch_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROZENCOL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FrozenCol_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FROZENLASTCOL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FrozenLastCol_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"NAVVIEWPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWSHOWMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewShowMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVVIEWWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavViewWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NOICONDEFAULT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NoIconDefault_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCOUNTERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCounterName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROOTSELECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RootSelect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWROOT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowRoot_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TODOTASK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToDoTask_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TREEGRIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TreeGridFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TREEMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TreeModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TREESTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TreeStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BufferRendererMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CatPSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CatPSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CATPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ColEnableFilter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ColEnableLink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_EnableEdit_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableItemPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableSearch_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FrozenCol_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FrozenLastCol_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NoIconDefault_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PSDETreeViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDETreeViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETREEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RootSelect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowRoot_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_TreeGridFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TreeModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TREEMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TreeStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TREESTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDETreeView pSDETreeView) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDETreeView)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDETreeView pSDETreeView) throws Exception {
        Object object = pSDETreeView.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDETREEVIEW_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDETreeView);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDETreeView pSDETreeView, Object object) throws Exception {
        PSDETreeView pSDETreeView2 = new PSDETreeView();
        pSDETreeView2.set("PSDETREEVIEWID", object);
        String string = DataObject.getStringValue((Object)pSDETreeView.get("PSDETREEVIEWID"));
        super.onCopyDetails(pSDETreeView, object);
    }

    @Override
    protected void exportCurXmlModel(PSDETreeView pSDETreeView, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETREEVIEW");
        if (!bl) {
            super.exportCurXmlModel(pSDETreeView, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDETreeView pSDETreeView, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDETreeNode(pSDETreeView, xmlNode);
        this.exportRelatedXmlModel_PSDETreeCol(pSDETreeView, xmlNode);
        this.exportRelatedXmlModel_PSDETreeLogic(pSDETreeView, xmlNode);
        super.onExportRelatedXmlModel(pSDETreeView, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDETreeNode(PSDETreeView pSDETreeView, XmlNode xmlNode) throws Exception {
        PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNode> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeNodeService.selectByPSDETreeView(pSDETreeView) : pSDETreeNodeService.selectTempByPSDETreeView(pSDETreeView);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDETREENODES");
            xmlNode.addNode(xmlNode2);
            for (PSDETreeNode pSDETreeNode : arrayList) {
                pSDETreeNodeService.exportXmlModel(pSDETreeNode, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDETreeCol(PSDETreeView pSDETreeView, XmlNode xmlNode) throws Exception {
        PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeCol> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeColService.selectByPSDETreeView(pSDETreeView, "ORDER BY ORDERVALUE ASC") : pSDETreeColService.selectTempByPSDETreeView(pSDETreeView, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDETREECOLS");
            xmlNode.addNode(xmlNode2);
            for (PSDETreeCol pSDETreeCol : arrayList) {
                pSDETreeCol.set("ORDERVALUE", null);
                pSDETreeColService.exportXmlModel(pSDETreeCol, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDETreeLogic(PSDETreeView pSDETreeView, XmlNode xmlNode) throws Exception {
        PSDETreeLogicService pSDETreeLogicService = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeLogic> arrayList = null;
        String string = pSDETreeView.getPSDETreeViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETreeLogicService.selectByPSDETreeView(pSDETreeView, "ORDER BY ORDERVALUE ASC") : pSDETreeLogicService.selectTempByPSDETreeView(pSDETreeView, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDETREELOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDETreeLogic pSDETreeLogic : arrayList) {
                pSDETreeLogic.set("ORDERVALUE", null);
                pSDETreeLogicService.exportXmlModel(pSDETreeLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDETreeView pSDETreeView, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDETREENODES");
        this.importRelatedXmlModel_PSDETreeNode(pSDETreeView, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDETREECOLS");
        this.importRelatedXmlModel_PSDETreeCol(pSDETreeView, xmlNode3);
        XmlNode xmlNode4 = xmlNode.getChildNodeByNodeName("PSDETREELOGICS");
        this.importRelatedXmlModel_PSDETreeLogic(pSDETreeView, xmlNode4);
        super.onImportRelatedXmlModel(pSDETreeView, xmlNode);
    }

    protected void importRelatedXmlModel_PSDETreeNode(PSDETreeView pSDETreeView, XmlNode xmlNode) throws Exception {
        PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDETreeView.getPSDETreeViewId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDETreeNodeService.removeByPSDETreeView(pSDETreeView);
        } else {
            pSDETreeNodeService.removeTempByPSDETreeView(pSDETreeView);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDETreeNode pSDETreeNode = new PSDETreeNode();
                pSDETreeNodeService.fillParentInfo(pSDETreeNode, "DER1N", "DER1N_PSDETREENODE_PSDETREEVIEW_PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
                pSDETreeNodeService.importXmlModel(pSDETreeNode, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDETreeCol(PSDETreeView pSDETreeView, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDETreeView.getPSDETreeViewId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDETreeColService.removeByPSDETreeView(pSDETreeView);
        } else {
            pSDETreeColService.removeTempByPSDETreeView(pSDETreeView);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDETreeCol pSDETreeCol = new PSDETreeCol();
                pSDETreeCol.setOrderValue(n);
                n += 100;
                pSDETreeColService.fillParentInfo(pSDETreeCol, "DER1N", "DER1N_PSDETREECOL_PSDETREEVIEW_PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
                pSDETreeColService.importXmlModel(pSDETreeCol, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDETreeLogic(PSDETreeView pSDETreeView, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDETreeLogicService pSDETreeLogicService = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDETreeView.getPSDETreeViewId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDETreeLogicService.removeByPSDETreeView(pSDETreeView);
        } else {
            pSDETreeLogicService.removeTempByPSDETreeView(pSDETreeView);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDETreeLogic pSDETreeLogic = new PSDETreeLogic();
                pSDETreeLogic.setOrderValue(n);
                n += 100;
                pSDETreeLogicService.fillParentInfo(pSDETreeLogic, "DER1N", "DER1N_PSDETREELOGIC_PSDETREEVIEW_PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
                pSDETreeLogicService.importXmlModel(pSDETreeLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDETreeView pSDETreeView, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDETreeView, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
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
            return "DER1N_PSDETREEVIEW_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETREEVIEW_PSSYSTEM_PSSYSTEMID";
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
        if (StringHelper.compare((String)string, (String)"PSSYSTEM", (boolean)true) == 0) {
            iEntity.set("PSSYSTEMID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSDETreeView pSDETreeView) {
        if (!StringHelper.isNullOrEmpty((String)pSDETreeView.getCodeName())) {
            return pSDETreeView.getCodeName();
        }
        return super.getModelV2Tag(pSDETreeView);
    }

    @Override
    public boolean setModelV2Tag(PSDETreeView pSDETreeView, String string) {
        pSDETreeView.setCodeName(string);
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
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDETreeView pSDETreeView, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDETreeView.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDETreeView, true);
        pSDETreeView.set("CODENAME", string);
        if (this.select(pSDETreeView, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDETreeView, true);
        return super.getModelV2Entity(pSDETreeView, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDETreeView pSDETreeView, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDETreeView, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDETREECOL_PSDETREEVIEW_PSDETREEVIEWID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDETREENODE_PSDETREEVIEW_PSDETREEVIEWID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDETEIUPDATE_PSDETREEVIEW_PSDETREEVIEWID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDETREENODERS_PSDETREEVIEW_PSDETREEVIEWID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSDETREELOGIC_PSDETREEVIEW_PSDETREEVIEWID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDETREENODECOL_PSDETREEVIEW_PSDETREEVIEWID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDETreeView pSDETreeView, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDETreeView, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDETreeView pSDETreeView, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETREECOL_PSDETREEVIEW_PSDETREEVIEWID")) {
            pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETREEVIEW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETREECOL", (Object)pSDETreeView.getPSDETreeViewId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
                for (PSDETreeCol entity : ((PSDETreeColServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView)) {
                    String entityScope = ((PSDETreeColServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdetreecolname")) {
                            string = objectNode.get("psdetreecolname").asText();
                        }
                        if (objectNode2.has("psdetreecolname")) {
                            string2 = objectNode2.get("psdetreecolname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDETreeCol entity = new PSDETreeCol();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETREENODE_PSDETREEVIEW_PSDETREEVIEWID")) {
            pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETREEVIEW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETREENODE", (Object)pSDETreeView.getPSDETreeViewId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
                for (PSDETreeNode entity : ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView)) {
                    String entityScope = ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdetreenodename")) {
                            string = objectNode.get("psdetreenodename").asText();
                        }
                        if (objectNode2.has("psdetreenodename")) {
                            string2 = objectNode2.get("psdetreenodename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDETreeNode entity = new PSDETreeNode();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETEIUPDATE_PSDETREEVIEW_PSDETREEVIEWID")) {
            pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETREEVIEW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETEIUPDATE", (Object)pSDETreeView.getPSDETreeViewId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
                for (PSDETEIUpdate entity : ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView)) {
                    String entityScope = ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdeteiupdatename")) {
                            string = objectNode.get("psdeteiupdatename").asText();
                        }
                        if (objectNode2.has("psdeteiupdatename")) {
                            string2 = objectNode2.get("psdeteiupdatename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDETEIUpdate entity = new PSDETEIUpdate();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETREENODERS_PSDETREEVIEW_PSDETREEVIEWID")) {
            pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETREEVIEW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETREENODERS", (Object)pSDETreeView.getPSDETreeViewId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
                for (PSDETreeNodeRS entity : ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView)) {
                    String entityScope = ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
                Collections.sort(arrayList, new Comparator<ObjectNode>(){

                    @Override
                    public int compare(ObjectNode objectNode, ObjectNode objectNode2) {
                        int n;
                        int n2;
                        String string = null;
                        String string2 = null;
                        if (objectNode.has("ppsdetreenodename")) {
                            string = objectNode.get("ppsdetreenodename").asText();
                        }
                        if (objectNode2.has("ppsdetreenodename")) {
                            string2 = objectNode2.get("ppsdetreenodename").asText();
                        }
                        if ((n2 = StringHelper.compare((String)string, string2, (boolean)false)) != 0) {
                            return n2;
                        }
                        string = null;
                        string2 = null;
                        if (objectNode.has("cpsdetreenodename")) {
                            string = objectNode.get("cpsdetreenodename").asText();
                        }
                        if (objectNode2.has("cpsdetreenodename")) {
                            string2 = objectNode2.get("cpsdetreenodename").asText();
                        }
                        if ((n2 = StringHelper.compare((String)string, (String)string2, (boolean)false)) != 0) {
                            return n2;
                        }
                        int n3 = 1000;
                        int n4 = 1000;
                        if (objectNode.has("ordervalue")) {
                            n3 = objectNode.get("ordervalue").asInt();
                        }
                        if (objectNode2.has("ordervalue")) {
                            n4 = objectNode2.get("ordervalue").asInt();
                        }
                        if ((n = n3 - n4) != 0) {
                            return n;
                        }
                        String string3 = null;
                        String string4 = null;
                        if (objectNode.has("psdetreenodersname")) {
                            string3 = objectNode.get("psdetreenodersname").asText();
                        }
                        if (objectNode2.has("psdetreenodersname")) {
                            string4 = objectNode2.get("psdetreenodersname").asText();
                        }
                        return StringHelper.compare((String)string3, string4, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDETreeNodeRS entity = new PSDETreeNodeRS();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETREELOGIC_PSDETREEVIEW_PSDETREEVIEWID")) {
            pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETREEVIEW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETREELOGIC", (Object)pSDETreeView.getPSDETreeViewId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
                for (PSDETreeLogic entity : ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView)) {
                    String entityScope = ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdetreelogicname")) {
                            string = objectNode.get("psdetreelogicname").asText();
                        }
                        if (objectNode2.has("psdetreelogicname")) {
                            string2 = objectNode2.get("psdetreelogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDETreeLogic entity = new PSDETreeLogic();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETREENODECOL_PSDETREEVIEW_PSDETREEVIEWID")) {
            pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETREEVIEW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETREENODECOL", (Object)pSDETreeView.getPSDETreeViewId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
                for (PSDETreeNodeCol entity : ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView)) {
                    String entityScope = ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entity);
                    if (StringHelper.compare(scope, entityScope, false) != 0) continue;
                    arrayList.add(PSModelV2Helper.toJSONObject(entity, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                ArrayNode related = objectNode.putArray(pSCoreSysServiceBase.getModelV2Name(false).toLowerCase());
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
                        if (objectNode.has("psdetreenodecolname")) {
                            string = objectNode.get("psdetreenodecolname").asText();
                        }
                        if (objectNode2.has("psdetreenodecolname")) {
                            string2 = objectNode2.get("psdetreenodecolname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode model : arrayList) {
                    PSDETreeNodeCol entity = new PSDETreeNodeCol();
                    PSModelV2Helper.fromJSONObject(entity, model, false);
                    related.add(pSCoreSysServiceBase.exportModelV2(entity, string));
                }
            }
        }
        super.onExportCurModelV2(pSDETreeView, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDETreeView pSDETreeView) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeCol> arrayList = ((PSDETreeColServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView);
        String string2 = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
        for (PSDETreeCol entityBase : arrayList) {
            string = ((PSDETreeColServiceBase)pSCoreSysServiceBase).getModelV2ResScope(entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        SqlParamList object = new SqlParamList();
        object.addString(pSDETreeView.getPSDETreeViewId());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETREECOL WHERE PSDETREEVIEWID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNode> nodes = ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView);
        string2 = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
        for (PSDETreeNode pSDETreeNode : nodes) {
            string = ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDETreeNode);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDETreeNode);
        }
        object = new SqlParamList();
        object.addString(pSDETreeView.getPSDETreeViewId());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETREENODE WHERE PSDETREEVIEWID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETEIUpdate> updates = ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView);
        string2 = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
        for (PSDETEIUpdate pSDETEIUpdate : updates) {
            string = ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDETEIUpdate);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDETEIUpdate);
        }
        object = new SqlParamList();
        object.addString(pSDETreeView.getPSDETreeViewId());
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETEIUpdateServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETEIUPDATE WHERE PSDETREEVIEWID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeRS> relations = ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView);
        string2 = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
        for (PSDETreeNodeRS pSDETreeNodeRS : relations) {
            string = ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDETreeNodeRS);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDETreeNodeRS);
        }
        object = new SqlParamList();
        object.addString(pSDETreeView.getPSDETreeViewId());
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETreeNodeRSServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETREENODERS WHERE PSDETREEVIEWID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeLogic> logics = ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView);
        string2 = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
        for (PSDETreeLogic pSDETreeLogic : logics) {
            string = ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDETreeLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDETreeLogic);
        }
        object = new SqlParamList();
        object.addString(pSDETreeView.getPSDETreeViewId());
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETREELOGIC WHERE PSDETREEVIEWID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETreeNodeCol> nodeCols = ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).selectByPSDETreeView(pSDETreeView);
        string2 = StringHelper.format((String)"PSDETREEVIEW#%1$s", (Object)pSDETreeView.getPSDETreeViewId());
        for (PSDETreeNodeCol pSDETreeNodeCol : nodeCols) {
            string = ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDETreeNodeCol);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDETreeNodeCol);
        }
        object = new SqlParamList();
        object.addString(pSDETreeView.getPSDETreeViewId());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETREENODECOL WHERE PSDETREEVIEWID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSDETreeView);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDETreeView pSDETreeView, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDETreeCol();
        entityBase.set("PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDETreeNode();
        entityBase.set("PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDETEIUpdate();
        entityBase.set("PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
        pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDETreeNodeRS();
        entityBase.set("PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDETreeLogic();
        entityBase.set("PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDETreeNodeCol();
        entityBase.set("PSDETREEVIEWID", pSDETreeView.getPSDETreeViewId());
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDETreeView, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDETreeView pSDETreeView, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode model = (ObjectNode)arrayNode.get(n2);
                PSDETreeCol entity = new PSDETreeCol();
                entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string4);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDETreeCol entity = new PSDETreeCol();
                    entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                    entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode model = (ObjectNode)arrayNode.get(n2);
                PSDETreeNode entity = new PSDETreeNode();
                entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                entity.setPSSystemId(pSDETreeView.getPSSystemId());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string5);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDETreeNode entity = new PSDETreeNode();
                    entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                    entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                    entity.setPSSystemId(pSDETreeView.getPSSystemId());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDETEIUpdateService)ServiceGlobal.getService(PSDETEIUpdateService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode model = (ObjectNode)arrayNode.get(i);
                PSDETEIUpdate entity = new PSDETEIUpdate();
                entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string6 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string6);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDETEIUpdate entity = new PSDETEIUpdate();
                    entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                    entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDETreeNodeRSService)ServiceGlobal.getService(PSDETreeNodeRSService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode model = (ObjectNode)arrayNode.get(i);
                PSDETreeNodeRS entity = new PSDETreeNodeRS();
                entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string7 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string7);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDETreeNodeRS entity = new PSDETreeNodeRS();
                    entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                    entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode model = (ObjectNode)arrayNode.get(i);
                PSDETreeLogic entity = new PSDETreeLogic();
                entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string8 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string8);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDETreeLogic entity = new PSDETreeLogic();
                    entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                    entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                ObjectNode model = (ObjectNode)arrayNode.get(i);
                PSDETreeNodeCol entity = new PSDETreeNodeCol();
                entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                pSCoreSysServiceBase.compileModelV2(entity, model, string, null, n);
            }
        } else {
            String string9 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File directory = new File(string9);
            if (directory.exists()) {
                for (File child : directory.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDETreeNodeCol entity = new PSDETreeNodeCol();
                    entity.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
                    entity.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
                    pSCoreSysServiceBase.compileModelV2(entity, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDETreeView, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDETreeView pSDETreeView, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDETREECOL_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDETreeCols(pSDETreeView, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDETREENODE_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDETreeNodes(pSDETreeView, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDETREELOGIC_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDETreeLogics(pSDETreeView, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDETreeView, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDETreeCols(PSDETreeView pSDETreeView, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDETREECOL", true), (boolean)false) == 0) {
            PSDETreeColService pSDETreeColService = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
            PSDETreeCol pSDETreeCol = new PSDETreeCol();
            pSDETreeCol.setPSDETreeColId(pSMOSFile.getPSModelId());
            if (!pSDETreeColService.get(pSDETreeCol, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDETreeCol.getPSDETreeViewId(), (String)pSDETreeView.getPSDETreeViewId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDETreeColService.exportModelV2(pSDETreeCol);
            pSDETreeCol.reset();
            if (!pSDETreeColService.setModelV2ResScope(pSDETreeCol, "PSDETREEVIEW", pSDETreeView.getPSDETreeViewId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDETreeColService.importModelV2(pSDETreeCol, objectNode);
            SessionFactoryManager.commit();
            return pSDETreeColService.getFile(pSDETreeCol);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDETreeNodes(PSDETreeView pSDETreeView, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDETREENODE", true), (boolean)false) == 0) {
            PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
            PSDETreeNode pSDETreeNode = new PSDETreeNode();
            pSDETreeNode.setPSDETreeNodeId(pSMOSFile.getPSModelId());
            if (!pSDETreeNodeService.get(pSDETreeNode, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDETreeNode.getPSDETreeViewId(), (String)pSDETreeView.getPSDETreeViewId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDETreeNodeService.exportModelV2(pSDETreeNode);
            pSDETreeNode.reset();
            if (!pSDETreeNodeService.setModelV2ResScope(pSDETreeNode, "PSDETREEVIEW", pSDETreeView.getPSDETreeViewId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDETreeNodeService.importModelV2(pSDETreeNode, objectNode);
            SessionFactoryManager.commit();
            return pSDETreeNodeService.getFile(pSDETreeNode);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDETreeLogics(PSDETreeView pSDETreeView, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDETREELOGIC", true), (boolean)false) == 0) {
            PSDETreeLogicService pSDETreeLogicService = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDETreeLogic pSDETreeLogic = new PSDETreeLogic();
            pSDETreeLogic.setPSDETreeLogicId(pSMOSFile.getPSModelId());
            if (!pSDETreeLogicService.get(pSDETreeLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDETreeLogic.getPSDETreeViewId(), (String)pSDETreeView.getPSDETreeViewId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDETreeLogicService.exportModelV2(pSDETreeLogic);
            pSDETreeLogic.reset();
            if (!pSDETreeLogicService.setModelV2ResScope(pSDETreeLogic, "PSDETREEVIEW", pSDETreeView.getPSDETreeViewId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDETreeLogicService.importModelV2(pSDETreeLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDETreeLogicService.getFile(pSDETreeLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDETreeView pSDETreeView, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDETreeCols(pSDETreeView, list);
        this.onFillPasteHelps_PSDETreeNodes(pSDETreeView, list);
        this.onFillPasteHelps_PSDETreeLogics(pSDETreeView, list);
        super.onFillPasteHelps(pSDETreeView, list);
    }

    protected void onFillPasteHelps_PSDETreeCols(PSDETreeView pSDETreeView, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDETREECOL");
        pSHelpSection.setSectionParam2("DER1N_PSDETREECOL_PSDETREEVIEW_PSDETREEVIEWID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u6811\u90e8\u4ef6]\u7684[\u6811\u8868\u683c\u5217]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDETreeNodes(PSDETreeView pSDETreeView, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDETREENODE");
        pSHelpSection.setSectionParam2("DER1N_PSDETREENODE_PSDETREEVIEW_PSDETREEVIEWID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u6811\u90e8\u4ef6]\u7684[\u6811\u8282\u70b9]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDETreeLogics(PSDETreeView pSDETreeView, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDETREELOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDETREELOGIC_PSDETREEVIEW_PSDETREEVIEWID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u6811\u90e8\u4ef6]\u7684[\u6811\u90e8\u4ef6\u903b\u8f91]");
        list.add(pSHelpSection);
    }
}
