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
import net.ibizsys.pscore.srv.dedesign.dao.PSDEDataViewDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataViewDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataViewLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataViewLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFieldBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListItemBase;
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
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListItemServiceBase;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
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

public abstract class PSDEDataViewServiceBase
extends PSCoreSysServiceBase<PSDEDataView> {
    private static final Log log = LogFactory.getLog(PSDEDataViewServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURAPPKANBAN = "CurAppKanban";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURDEKANBAN = "CurDEKanban";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSKANBAN = "CurSysKanban";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_JITPREVIEW = "JITPREVIEW";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSDEDataViewDEModel pSDEDataViewDEModel;
    private PSDEDataViewDAO pSDEDataViewDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService";
    }

    public PSDEDataViewDEModel getPSDEDataViewDEModel() {
        if (this.pSDEDataViewDEModel == null) {
            try {
                this.pSDEDataViewDEModel = (PSDEDataViewDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEDataViewDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataViewDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEDataViewDEModel();
    }

    public PSDEDataViewDAO getPSDEDataViewDAO() {
        if (this.pSDEDataViewDAO == null) {
            try {
                this.pSDEDataViewDAO = (PSDEDataViewDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEDataViewDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEDataViewDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEDataViewDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPKANBAN, (boolean)true) == 0) {
            return this.fetchCurAppKanban(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEKANBAN, (boolean)true) == 0) {
            return this.fetchCurDEKanban(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSKANBAN, (boolean)true) == 0) {
            return this.fetchCurSysKanban(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURAPPKANBAN, (boolean)true) == 0) {
            return this.fetchTempCurAppKanban(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDE, (boolean)true) == 0) {
            return this.fetchTempCurDE(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURDEKANBAN, (boolean)true) == 0) {
            return this.fetchTempCurDEKanban(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSKANBAN, (boolean)true) == 0) {
            return this.fetchTempCurSysKanban(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSDEDataView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDEDataView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDEDataView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEDataView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW, (boolean)true) == 0) {
            this.jITPreview((PSDEDataView)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEDataView)iEntity);
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

    public DBFetchResult fetchCurAppKanban(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPKANBAN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurAppKanban(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURAPPKANBAN, true);
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

    public DBFetchResult fetchCurDEKanban(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEKANBAN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurDEKanban(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURDEKANBAN, true);
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

    public DBFetchResult fetchCurSysKanban(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSKANBAN, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysKanban(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSKANBAN, true);
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

    public void createWithModel(PSDEDataView pSDEDataView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSDEDataView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDataView, ACTION_CREATEWITHMODEL);
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataViewServiceBase.this.getService(), PSDEDataViewServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSDEDataView2, null).getResult() != 1) {
                    PSDEDataViewServiceBase.this.onCreateWithModel(pSDEDataView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSDEDataView, null);
        }
    }

    protected void onCreateWithModel(PSDEDataView pSDEDataView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSDEDataView pSDEDataView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSDEDataView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDataView, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataViewServiceBase.this.getService(), PSDEDataViewServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSDEDataView2, null).getResult() != 1) {
                    PSDEDataViewServiceBase.this.onGetDraftFromWithModel(pSDEDataView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSDEDataView, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDEDataView pSDEDataView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDEDataView pSDEDataView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSDEDataView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDataView, ACTION_GETDRAFTWITHMODEL);
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataViewServiceBase.this.getService(), PSDEDataViewServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSDEDataView2, null).getResult() != 1) {
                    PSDEDataViewServiceBase.this.onGetDraftWithModel(pSDEDataView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSDEDataView, null);
        }
    }

    protected void onGetDraftWithModel(PSDEDataView pSDEDataView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDEDataView pSDEDataView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSDEDataView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDataView, ACTION_GETWITHMODEL);
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataViewServiceBase.this.getService(), PSDEDataViewServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSDEDataView2, null).getResult() != 1) {
                    PSDEDataViewServiceBase.this.onGetWithModel(pSDEDataView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSDEDataView, null);
        }
    }

    protected void onGetWithModel(PSDEDataView pSDEDataView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void jITPreview(PSDEDataView pSDEDataView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 0, (IEntity)pSDEDataView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDataView, ACTION_JITPREVIEW);
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataViewServiceBase.this.getService(), PSDEDataViewServiceBase.ACTION_JITPREVIEW, 40, (IEntity)pSDEDataView2, null).getResult() != 1) {
                    PSDEDataViewServiceBase.this.onJITPreview(pSDEDataView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 99, (IEntity)pSDEDataView, null);
        }
    }

    protected void onJITPreview(PSDEDataView pSDEDataView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW]");
    }

    public void updateWithModel(PSDEDataView pSDEDataView) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSDEDataView, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEDataView, ACTION_UPDATEWITHMODEL);
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEDataViewServiceBase.this.getService(), PSDEDataViewServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSDEDataView2, null).getResult() != 1) {
                    PSDEDataViewServiceBase.this.onUpdateWithModel(pSDEDataView2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSDEDataView, null);
        }
    }

    protected void onUpdateWithModel(PSDEDataView pSDEDataView) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEDataView pSDEDataView, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSACHandler);
            } else {
                iService.get((IEntity)pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDEDataView, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSCODELIST_GROUPPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_GroupPSCodeList(pSDEDataView, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSCODELIST_SWIMLANEPSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_SwimlanePSCodeList(pSDEDataView, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlLogicGroup);
            } else {
                iService.get((IEntity)pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEDataView, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlMsg);
            } else {
                iService.get((IEntity)pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSDEDataView, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDATAENTITY_GROUPPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_GroupPSDE(pSDEDataView, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEDataView, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_COPYPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_CopyPSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_CREATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_CreatePSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_GETDRAFTPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_GetDraftPSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_GETPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_GetPSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_GROUPMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_GroupMovePSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_MOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_MovePSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_REMOVEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_RemovePSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_UPDATEPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_UpdatePSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_USER2PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_User2PSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEACTION_USERPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_UserPSDEAction(pSDEDataView, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEDATASET_ASYNCPSDEDSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_AsyncPSDEDS(pSDEDataView, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDEDataView, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEFIELD_GROUPPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_GroupPSDEF(pSDEDataView, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEFIELD_GROUPTEXTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_GroupTextPSDEF(pSDEDataView, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEFIELD_MINORSORTPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_MinorSortPSDEF(pSDEDataView, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEFIELD_ORDERVALUEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_OrderValuePSDEF(pSDEDataView, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEFIELD_SWIMLANEPSDEFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService", (SessionFactory)this.getSessionFactory());
            PSDEField pSDEField = (PSDEField)iService.getDEModel().createEntity();
            pSDEField.set("PSDEFIELDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEField);
            } else {
                iService.get((IEntity)pSDEField);
            }
            this.onFillParentInfo_SwimlanePSDEF(pSDEDataView, pSDEField);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEDataView, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDER_NAVPSDERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDERService", (SessionFactory)this.getSessionFactory());
            PSDER pSDER = (PSDER)iService.getDEModel().createEntity();
            pSDER.set("PSDERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDER);
            } else {
                iService.get((IEntity)pSDER);
            }
            this.onFillParentInfo_NavPSDER(pSDEDataView, pSDER);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDETOOLBAR_BATPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEToolbar);
            } else {
                iService.get((IEntity)pSDEToolbar);
            }
            this.onFillParentInfo_BatPSDEToolbar(pSDEDataView, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDETOOLBAR_GROUPQUICKPSDETBID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEToolbar);
            } else {
                iService.get((IEntity)pSDEToolbar);
            }
            this.onFillParentInfo_GroupQuickPSDEToolbar(pSDEDataView, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDETOOLBAR_QUICKPSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEToolbar);
            } else {
                iService.get((IEntity)pSDEToolbar);
            }
            this.onFillParentInfo_QuickPSDEToolbar(pSDEDataView, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEUAGROUP_GROUPPSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_GroupPSDEUAGroup(pSDEDataView, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEUAGROUP_NO2PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_No2PSDEUAGroup(pSDEDataView, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDEDataView, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSDEVIEWBASE_NAVPSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_NavPSDEViewBase(pSDEDataView, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSLANGUAGERES_EMPTYTEXTPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEDataView, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSSYSCSS_GROUPPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_GroupPSSysCss(pSDEDataView, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSSYSCSS_ITEMPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_ItemPSSysCss(pSDEDataView, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEDataView, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSSYSPFPLUGIN_GROUPPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_GroupPSSysPFPlugin(pSDEDataView, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSSYSPFPLUGIN_ITEMPSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_ItemPSSysPFPlugin(pSDEDataView, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEDataView, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDEDataView, pSSysViewPanel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEDATAVIEW_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewMsgGroup);
            } else {
                iService.get((IEntity)pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSDEDataView, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEDataView, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDEDataView pSDEDataView, PSACHandler pSACHandler) throws Exception {
        pSDEDataView.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEDataView.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_GroupPSCodeList(PSDEDataView pSDEDataView, PSCodeList pSCodeList) throws Exception {
        pSDEDataView.setGroupPSCodeListId(pSCodeList.getPSCodeListId());
        pSDEDataView.setGroupPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_SwimlanePSCodeList(PSDEDataView pSDEDataView, PSCodeList pSCodeList) throws Exception {
        pSDEDataView.setSwimlanePSCodeListId(pSCodeList.getPSCodeListId());
        pSDEDataView.setSwimlanePSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEDataView pSDEDataView, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEDataView.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEDataView.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSDEDataView pSDEDataView, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSDEDataView.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSDEDataView.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_GroupPSDE(PSDEDataView pSDEDataView, PSDataEntity pSDataEntity) throws Exception {
        pSDEDataView.setGroupPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDataView.setGroupPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDE(PSDEDataView pSDEDataView, PSDataEntity pSDataEntity) throws Exception {
        pSDEDataView.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEDataView.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_CopyPSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setCopyPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setCopyPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_CreatePSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setCreatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setCreatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetDraftPSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setGetDraftPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setGetDraftPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GetPSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setGetPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setGetPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_GroupMovePSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setGroupMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setGroupMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_MovePSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setMovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setMovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_RemovePSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setRemovePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setRemovePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UpdatePSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setUpdatePSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setUpdatePSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_User2PSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setUser2PSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setUser2PSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_UserPSDEAction(PSDEDataView pSDEDataView, PSDEAction pSDEAction) throws Exception {
        pSDEDataView.setUserPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEDataView.setUserPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_AsyncPSDEDS(PSDEDataView pSDEDataView, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEDataView.setAsyncPSDEDSId(pSDEDataSet.getPSDEDataSetId());
        pSDEDataView.setAsyncPSDEDSName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDEDataView pSDEDataView, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEDataView.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEDataView.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_GroupPSDEF(PSDEDataView pSDEDataView, PSDEField pSDEField) throws Exception {
        pSDEDataView.setGroupPSDEFId(pSDEField.getPSDEFieldId());
        pSDEDataView.setGroupPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_GroupTextPSDEF(PSDEDataView pSDEDataView, PSDEField pSDEField) throws Exception {
        pSDEDataView.setGroupTextPSDEFId(pSDEField.getPSDEFieldId());
        pSDEDataView.setGroupTextPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_MinorSortPSDEF(PSDEDataView pSDEDataView, PSDEField pSDEField) throws Exception {
        pSDEDataView.setMinorSortPSDEFId(pSDEField.getPSDEFieldId());
        pSDEDataView.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_OrderValuePSDEF(PSDEDataView pSDEDataView, PSDEField pSDEField) throws Exception {
        pSDEDataView.setOrderValuePSDEFId(pSDEField.getPSDEFieldId());
        pSDEDataView.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_SwimlanePSDEF(PSDEDataView pSDEDataView, PSDEField pSDEField) throws Exception {
        pSDEDataView.setSwimlanePSDEFId(pSDEField.getPSDEFieldId());
        pSDEDataView.setSwimlanePSDEFName(pSDEField.getPSDEFieldName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEDataView pSDEDataView, PSDEForm pSDEForm) throws Exception {
        pSDEDataView.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEDataView.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_NavPSDER(PSDEDataView pSDEDataView, PSDER pSDER) throws Exception {
        pSDEDataView.setNavPSDERId(pSDER.getPSDERId());
        pSDEDataView.setNavPSDERName(pSDER.getPSDERName());
    }

    protected void onFillParentInfo_BatPSDEToolbar(PSDEDataView pSDEDataView, PSDEToolbar pSDEToolbar) throws Exception {
        pSDEDataView.setBatPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDEDataView.setBatPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_GroupQuickPSDEToolbar(PSDEDataView pSDEDataView, PSDEToolbar pSDEToolbar) throws Exception {
        pSDEDataView.setGroupQuickPSDETBId(pSDEToolbar.getPSDEToolbarId());
        pSDEDataView.setGroupQuickPSDETBName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_QuickPSDEToolbar(PSDEDataView pSDEDataView, PSDEToolbar pSDEToolbar) throws Exception {
        pSDEDataView.setQuickPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDEDataView.setQuickPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_GroupPSDEUAGroup(PSDEDataView pSDEDataView, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEDataView.setGroupPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEDataView.setGroupPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No2PSDEUAGroup(PSDEDataView pSDEDataView, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEDataView.setNo2PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEDataView.setNo2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDEDataView pSDEDataView, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEDataView.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEDataView.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_NavPSDEViewBase(PSDEDataView pSDEDataView, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEDataView.setNavPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEDataView.setNavPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_EmptyTextPSLanRes(PSDEDataView pSDEDataView, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEDataView.setEmptyTextPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEDataView.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_GroupPSSysCss(PSDEDataView pSDEDataView, PSSysCss pSSysCss) throws Exception {
        pSDEDataView.setGroupPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEDataView.setGroupPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_ItemPSSysCss(PSDEDataView pSDEDataView, PSSysCss pSSysCss) throws Exception {
        pSDEDataView.setItemPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEDataView.setItemPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEDataView pSDEDataView, PSSysCss pSSysCss) throws Exception {
        pSDEDataView.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEDataView.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_GroupPSSysPFPlugin(PSDEDataView pSDEDataView, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEDataView.setGroupPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEDataView.setGroupPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_ItemPSSysPFPlugin(PSDEDataView pSDEDataView, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEDataView.setItemPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEDataView.setItemPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEDataView pSDEDataView, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEDataView.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEDataView.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDEDataView pSDEDataView, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEDataView.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEDataView.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSDEDataView pSDEDataView, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSDEDataView.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSDEDataView.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (bl && pSDEDataView.getEnablePagingBar() == null) {
            pSDEDataView.setEnablePagingBar((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSDEDataView, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDEDataView, bl);
        this.onFillEntityFullInfo_GroupPSCodeList(pSDEDataView, bl);
        this.onFillEntityFullInfo_SwimlanePSCodeList(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSDEDataView, bl);
        this.onFillEntityFullInfo_GroupPSDE(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSDE(pSDEDataView, bl);
        this.onFillEntityFullInfo_CopyPSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_CreatePSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_GetDraftPSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_GetPSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_GroupMovePSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_MovePSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_RemovePSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_UpdatePSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_User2PSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_UserPSDEAction(pSDEDataView, bl);
        this.onFillEntityFullInfo_AsyncPSDEDS(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDEDataView, bl);
        this.onFillEntityFullInfo_GroupPSDEF(pSDEDataView, bl);
        this.onFillEntityFullInfo_GroupTextPSDEF(pSDEDataView, bl);
        this.onFillEntityFullInfo_MinorSortPSDEF(pSDEDataView, bl);
        this.onFillEntityFullInfo_OrderValuePSDEF(pSDEDataView, bl);
        this.onFillEntityFullInfo_SwimlanePSDEF(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEDataView, bl);
        this.onFillEntityFullInfo_NavPSDER(pSDEDataView, bl);
        this.onFillEntityFullInfo_BatPSDEToolbar(pSDEDataView, bl);
        this.onFillEntityFullInfo_GroupQuickPSDEToolbar(pSDEDataView, bl);
        this.onFillEntityFullInfo_QuickPSDEToolbar(pSDEDataView, bl);
        this.onFillEntityFullInfo_GroupPSDEUAGroup(pSDEDataView, bl);
        this.onFillEntityFullInfo_No2PSDEUAGroup(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDEDataView, bl);
        this.onFillEntityFullInfo_NavPSDEViewBase(pSDEDataView, bl);
        this.onFillEntityFullInfo_EmptyTextPSLanRes(pSDEDataView, bl);
        this.onFillEntityFullInfo_GroupPSSysCss(pSDEDataView, bl);
        this.onFillEntityFullInfo_ItemPSSysCss(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEDataView, bl);
        this.onFillEntityFullInfo_GroupPSSysPFPlugin(pSDEDataView, bl);
        this.onFillEntityFullInfo_ItemPSSysPFPlugin(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDEDataView, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSDEDataView, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSCodeList(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SwimlanePSCodeList(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSDE(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isGroupPSDEIdDirty()) {
            if (pSDEDataView.getGroupPSDEId() != null) {
                if (pSDEDataView.getGroupPSDEId() == null || pSDEDataView.getGroupPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDataView.getGroupPSDE();
                    pSDEDataView.setGroupPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEDataView.setGroupPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDE(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isPSDEIdDirty()) {
            if (pSDEDataView.getPSDEId() != null) {
                if (pSDEDataView.getPSDEId() == null || pSDEDataView.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEDataView.getPSDE();
                    pSDEDataView.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEDataView.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_CopyPSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CreatePSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetDraftPSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GetPSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupMovePSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_MovePSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RemovePSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UpdatePSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_User2PSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_UserPSDEAction(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_AsyncPSDEDS(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSDEF(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isGroupPSDEFIdDirty()) {
            if (pSDEDataView.getGroupPSDEFId() != null) {
                if (pSDEDataView.getGroupPSDEFId() == null || pSDEDataView.getGroupPSDEFName() == null) {
                    PSDEField pSDEField = pSDEDataView.getGroupPSDEF();
                    pSDEDataView.setGroupPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDataView.setGroupPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupTextPSDEF(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isGroupTextPSDEFIdDirty()) {
            if (pSDEDataView.getGroupTextPSDEFId() != null) {
                if (pSDEDataView.getGroupTextPSDEFId() == null || pSDEDataView.getGroupTextPSDEFName() == null) {
                    PSDEField pSDEField = pSDEDataView.getGroupTextPSDEF();
                    pSDEDataView.setGroupTextPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDataView.setGroupTextPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_MinorSortPSDEF(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isMinorSortPSDEFIdDirty()) {
            if (pSDEDataView.getMinorSortPSDEFId() != null) {
                if (pSDEDataView.getMinorSortPSDEFId() == null || pSDEDataView.getMinorSortPSDEFName() == null) {
                    PSDEField pSDEField = pSDEDataView.getMinorSortPSDEF();
                    pSDEDataView.setMinorSortPSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDataView.setMinorSortPSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_OrderValuePSDEF(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isOrderValuePSDEFIdDirty()) {
            if (pSDEDataView.getOrderValuePSDEFId() != null) {
                if (pSDEDataView.getOrderValuePSDEFId() == null || pSDEDataView.getOrderValuePSDEFName() == null) {
                    PSDEField pSDEField = pSDEDataView.getOrderValuePSDEF();
                    pSDEDataView.setOrderValuePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDataView.setOrderValuePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_SwimlanePSDEF(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isSwimlanePSDEFIdDirty()) {
            if (pSDEDataView.getSwimlanePSDEFId() != null) {
                if (pSDEDataView.getSwimlanePSDEFId() == null || pSDEDataView.getSwimlanePSDEFName() == null) {
                    PSDEField pSDEField = pSDEDataView.getSwimlanePSDEF();
                    pSDEDataView.setSwimlanePSDEFName(pSDEField.getPSDEFieldName());
                }
            } else {
                pSDEDataView.setSwimlanePSDEFName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_NavPSDER(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isNavPSDERIdDirty()) {
            if (pSDEDataView.getNavPSDERId() != null) {
                if (pSDEDataView.getNavPSDERId() == null || pSDEDataView.getNavPSDERName() == null) {
                    PSDER pSDER = pSDEDataView.getNavPSDER();
                    pSDEDataView.setNavPSDERName(pSDER.getPSDERName());
                }
            } else {
                pSDEDataView.setNavPSDERName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_BatPSDEToolbar(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupQuickPSDEToolbar(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_QuickPSDEToolbar(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSDEUAGroup(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSDEUAGroup(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isNo2PSDEUAGroupIdDirty()) {
            if (pSDEDataView.getNo2PSDEUAGroupId() != null) {
                if (pSDEDataView.getNo2PSDEUAGroupId() == null || pSDEDataView.getNo2PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEDataView.getNo2PSDEUAGroup();
                    pSDEDataView.setNo2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEDataView.setNo2PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isPSDEUAGroupIdDirty()) {
            if (pSDEDataView.getPSDEUAGroupId() != null) {
                if (pSDEDataView.getPSDEUAGroupId() == null || pSDEDataView.getPSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEDataView.getPSDEUAGroup();
                    pSDEDataView.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEDataView.setPSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_NavPSDEViewBase(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_EmptyTextPSLanRes(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        if (pSDEDataView.isEmptyTextPSLanResIdDirty()) {
            if (pSDEDataView.getEmptyTextPSLanResId() != null) {
                if (pSDEDataView.getEmptyTextPSLanResId() == null || pSDEDataView.getEmptyTextPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEDataView.getEmptyTextPSLanRes();
                    pSDEDataView.setEmptyTextPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEDataView.setEmptyTextPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GroupPSSysCss(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ItemPSSysCss(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_GroupPSSysPFPlugin(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ItemPSSysPFPlugin(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSDEDataView pSDEDataView, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEDataView, bl);
    }

    public ArrayList<PSDEDataView> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByGroupPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectBySwimlanePSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectBySwimlanePSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectBySwimlanePSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectBySwimlanePSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectBySwimlanePSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SWIMLANEPSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySwimlanePSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySwimlanePSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataView> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGroupPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByGroupPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByGroupPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataView> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCopyPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByCopyPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByCreatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByCreatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetDraftPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGetDraftPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGetPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGroupMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGroupMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGroupMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGroupMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGroupMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPMOVEPSDEACTIONID", (Object)pSDEActionBase.getPSDEActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupMovePSDEActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupMovePSDEActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataView> selectByMovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByMovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByMovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByRemovePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByRemovePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUpdatePSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByUpdatePSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUser2PSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByUser2PSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByUserPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByUserPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByUserPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByAsyncPSDEDS(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByAsyncPSDEDS(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByGroupTextPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByGroupTextPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGroupTextPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByMinorSortPSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByMinorSortPSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectByOrderValuePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByOrderValuePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectBySwimlanePSDEF(PSDEFieldBase pSDEFieldBase) throws Exception {
        return this.selectBySwimlanePSDEF(pSDEFieldBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectBySwimlanePSDEF(PSDEFieldBase pSDEFieldBase, String string) throws Exception {
        return this.selectBySwimlanePSDEF(pSDEFieldBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectBySwimlanePSDEF(PSDEFieldBase pSDEFieldBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SWIMLANEPSDEFID", (Object)pSDEFieldBase.getPSDEFieldId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySwimlanePSDEFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySwimlanePSDEFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataView> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByNavPSDER(PSDERBase pSDERBase) throws Exception {
        return this.selectByNavPSDER(pSDERBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByNavPSDER(PSDERBase pSDERBase, String string) throws Exception {
        return this.selectByNavPSDER(pSDERBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByNavPSDER(PSDERBase pSDERBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByBatPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByBatPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByBatPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGroupQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByGroupQuickPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGroupQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByGroupQuickPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGroupQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("GROUPQUICKPSDETBID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByGroupQuickPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByGroupQuickPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataView> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByQuickPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByQuickPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByQuickPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByGroupPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByGroupPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO2PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo2PSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo2PSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataView> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataView> selectByNavPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByNavPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByNavPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByNavPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByNavPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByEmptyTextPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByEmptyTextPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByGroupPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByGroupPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByItemPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByItemPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByItemPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByItemPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByItemPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByGroupPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByGroupPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByGroupPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByItemPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByItemPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByItemPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByItemPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByItemPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ITEMPSSYSPFPLUGINID", (Object)pSSysPFPluginBase.getPSSysPFPluginId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByItemPSSysPFPluginCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByItemPSSysPFPluginCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataView> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEDataView> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysViewPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEDataView> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSDEDataView> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSDEDataView> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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
        ArrayList<PSDEDataView> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSACHandlerId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDEDataViewServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSCODELIST_GROUPPSCODELISTID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGroupPSCodeListId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGroupPSCodeList(pSCodeList2);
                PSDEDataViewServiceBase.this.internalRemoveByGroupPSCodeList(pSCodeList2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGroupPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSCodeList(pSCodeList);
        this.onBeforeRemoveByGroupPSCodeList(pSCodeList, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGroupPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSCodeList(PSCodeList pSCodeList, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectBySwimlanePSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSCODELIST_SWIMLANEPSCODELISTID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetSwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectBySwimlanePSCodeList(pSCodeList);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setSwimlanePSCodeListId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveBySwimlanePSCodeList(pSCodeList2);
                PSDEDataViewServiceBase.this.internalRemoveBySwimlanePSCodeList(pSCodeList2);
                PSDEDataViewServiceBase.this.onAfterRemoveBySwimlanePSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectBySwimlanePSCodeList(pSCodeList);
        this.onBeforeRemoveBySwimlanePSCodeList(pSCodeList, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveBySwimlanePSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveBySwimlanePSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveBySwimlanePSCodeList(PSCodeList pSCodeList, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySwimlanePSCodeList(PSCodeList pSCodeList, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSCtrlLogicGroupId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEDataViewServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSCtrlMsgId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEDataViewServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDATAENTITY_GROUPPSDEID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSDE(pSDataEntity);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGroupPSDEId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGroupPSDE(pSDataEntity2);
                PSDEDataViewServiceBase.this.internalRemoveByGroupPSDE(pSDataEntity2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGroupPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSDE(pSDataEntity);
        this.onBeforeRemoveByGroupPSDE(pSDataEntity, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGroupPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByGroupPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSDEId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEDataViewServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByCopyPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_COPYPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setCopyPSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByCopyPSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByCopyPSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByCopyPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByCopyPSDEAction(pSDEAction);
        this.onBeforeRemoveByCopyPSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByCopyPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCopyPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByCreatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_CREATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setCreatePSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByCreatePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByCreatePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByCreatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByCreatePSDEAction(pSDEAction);
        this.onBeforeRemoveByCreatePSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByCreatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCreatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGetDraftPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_GETDRAFTPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGetDraftPSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByGetDraftPSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGetDraftPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGetDraftPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGetDraftPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetDraftPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGetPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_GETPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGetPSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGetPSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGetPSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByGetPSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGetPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGetPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetPSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGetPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_GROUPMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupMovePSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGroupMovePSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGroupMovePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByGroupMovePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGroupMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByGroupMovePSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGroupMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGroupMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGroupMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByMovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_MOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByMovePSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setMovePSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByMovePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByMovePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByMovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByMovePSDEAction(pSDEAction);
        this.onBeforeRemoveByMovePSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByMovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByRemovePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_REMOVEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setRemovePSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByRemovePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByRemovePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByRemovePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByRemovePSDEAction(pSDEAction);
        this.onBeforeRemoveByRemovePSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByRemovePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRemovePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByUpdatePSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_UPDATEPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setUpdatePSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByUpdatePSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByUpdatePSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByUpdatePSDEAction(pSDEAction);
        this.onBeforeRemoveByUpdatePSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByUpdatePSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUpdatePSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByUser2PSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_USER2PSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setUser2PSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByUser2PSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByUser2PSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByUser2PSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByUser2PSDEAction(pSDEAction);
        this.onBeforeRemoveByUser2PSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByUser2PSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUser2PSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByUserPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEACTION_USERPSDEACTIONID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByUserPSDEAction(pSDEAction);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setUserPSDEActionId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByUserPSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.internalRemoveByUserPSDEAction(pSDEAction2);
                PSDEDataViewServiceBase.this.onAfterRemoveByUserPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByUserPSDEAction(pSDEAction);
        this.onBeforeRemoveByUserPSDEAction(pSDEAction, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByUserPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByUserPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEDATASET_ASYNCPSDEDSID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setAsyncPSDEDSId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSDEDataViewServiceBase.this.internalRemoveByAsyncPSDEDS(pSDEDataSet2);
                PSDEDataViewServiceBase.this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByAsyncPSDEDS(pSDEDataSet);
        this.onBeforeRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByAsyncPSDEDS(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByAsyncPSDEDS(PSDEDataSet pSDEDataSet, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSDEDataSetId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEDataViewServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEFIELD_GROUPPSDEFID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSDEF(pSDEField);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGroupPSDEFId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGroupPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGroupPSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.internalRemoveByGroupPSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGroupPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSDEF(pSDEField);
        this.onBeforeRemoveByGroupPSDEF(pSDEField, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGroupPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupTextPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEFIELD_GROUPTEXTPSDEFID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupTextPSDEF(pSDEField);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGroupTextPSDEFId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGroupTextPSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.internalRemoveByGroupTextPSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGroupTextPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupTextPSDEF(pSDEField);
        this.onBeforeRemoveByGroupTextPSDEF(pSDEField, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGroupTextPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByGroupTextPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByGroupTextPSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupTextPSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByMinorSortPSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEFIELD_MINORSORTPSDEFID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setMinorSortPSDEFId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByMinorSortPSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.internalRemoveByMinorSortPSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.onAfterRemoveByMinorSortPSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByMinorSortPSDEF(pSDEField);
        this.onBeforeRemoveByMinorSortPSDEF(pSDEField, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByMinorSortPSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByMinorSortPSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByOrderValuePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEFIELD_ORDERVALUEPSDEFID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setOrderValuePSDEFId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByOrderValuePSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.internalRemoveByOrderValuePSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.onAfterRemoveByOrderValuePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByOrderValuePSDEF(pSDEField);
        this.onBeforeRemoveByOrderValuePSDEF(pSDEField, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByOrderValuePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOrderValuePSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectBySwimlanePSDEF(pSDEField, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFIELD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEField);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEFIELD_SWIMLANEPSDEFID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEField), arrayList.get(0)));
        }
    }

    public void resetSwimlanePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectBySwimlanePSDEF(pSDEField);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setSwimlanePSDEFId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
        final PSDEField pSDEField2 = pSDEField;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveBySwimlanePSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.internalRemoveBySwimlanePSDEF(pSDEField2);
                PSDEDataViewServiceBase.this.onAfterRemoveBySwimlanePSDEF(pSDEField2);
            }
        });
    }

    protected void onBeforeRemoveBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void internalRemoveBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectBySwimlanePSDEF(pSDEField);
        this.onBeforeRemoveBySwimlanePSDEF(pSDEField, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveBySwimlanePSDEF(pSDEField, arrayList);
    }

    protected void onAfterRemoveBySwimlanePSDEF(PSDEField pSDEField) throws Exception {
    }

    protected void onBeforeRemoveBySwimlanePSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySwimlanePSDEF(PSDEField pSDEField, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSDEFormId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEDataViewServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByNavPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByNavPSDER(pSDER, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDER);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDER_NAVPSDERID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDER), arrayList.get(0)));
        }
    }

    public void resetNavPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByNavPSDER(pSDER);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setNavPSDERId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByNavPSDER(PSDER pSDER) throws Exception {
        final PSDER pSDER2 = pSDER;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByNavPSDER(pSDER2);
                PSDEDataViewServiceBase.this.internalRemoveByNavPSDER(pSDER2);
                PSDEDataViewServiceBase.this.onAfterRemoveByNavPSDER(pSDER2);
            }
        });
    }

    protected void onBeforeRemoveByNavPSDER(PSDER pSDER) throws Exception {
    }

    protected void internalRemoveByNavPSDER(PSDER pSDER) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByNavPSDER(pSDER);
        this.onBeforeRemoveByNavPSDER(pSDER, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByNavPSDER(pSDER, arrayList);
    }

    protected void onAfterRemoveByNavPSDER(PSDER pSDER) throws Exception {
    }

    protected void onBeforeRemoveByNavPSDER(PSDER pSDER, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNavPSDER(PSDER pSDER, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDETOOLBAR_BATPSDETOOLBARID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setBatPSDEToolbarId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByBatPSDEToolbar(pSDEToolbar2);
                PSDEDataViewServiceBase.this.internalRemoveByBatPSDEToolbar(pSDEToolbar2);
                PSDEDataViewServiceBase.this.onAfterRemoveByBatPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByBatPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByBatPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByBatPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByBatPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGroupQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupQuickPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDETOOLBAR_GROUPQUICKPSDETBID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetGroupQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupQuickPSDEToolbar(pSDEToolbar);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGroupQuickPSDETBId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGroupQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGroupQuickPSDEToolbar(pSDEToolbar2);
                PSDEDataViewServiceBase.this.internalRemoveByGroupQuickPSDEToolbar(pSDEToolbar2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGroupQuickPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByGroupQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByGroupQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupQuickPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByGroupQuickPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGroupQuickPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByGroupQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByGroupQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDETOOLBAR_QUICKPSDETOOLBARID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setQuickPSDEToolbarId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByQuickPSDEToolbar(pSDEToolbar2);
                PSDEDataViewServiceBase.this.internalRemoveByQuickPSDEToolbar(pSDEToolbar2);
                PSDEDataViewServiceBase.this.onAfterRemoveByQuickPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByQuickPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByQuickPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByQuickPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByQuickPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEUAGROUP_GROUPPSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGroupPSDEUAGroupId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
                PSDEDataViewServiceBase.this.internalRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGroupPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByGroupPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGroupPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEUAGROUP_NO2PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setNo2PSDEUAGroupId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDEDataViewServiceBase.this.internalRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDEDataViewServiceBase.this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSDEUAGroupId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEDataViewServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByNavPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSDEVIEWBASE_NAVPSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByNavPSDEViewBase(pSDEViewBase);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setNavPSDEViewBaseId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByNavPSDEViewBase(pSDEViewBase2);
                PSDEDataViewServiceBase.this.internalRemoveByNavPSDEViewBase(pSDEViewBase2);
                PSDEDataViewServiceBase.this.onAfterRemoveByNavPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByNavPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByNavPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByNavPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNavPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSLANGUAGERES_EMPTYTEXTPSLANRESID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setEmptyTextPSLanResId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEDataViewServiceBase.this.internalRemoveByEmptyTextPSLanRes(pSLanguageRes2);
                PSDEDataViewServiceBase.this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByEmptyTextPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByEmptyTextPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByEmptyTextPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSSYSCSS_GROUPPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSSysCss(pSSysCss);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGroupPSSysCssId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGroupPSSysCss(pSSysCss2);
                PSDEDataViewServiceBase.this.internalRemoveByGroupPSSysCss(pSSysCss2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGroupPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSSysCss(pSSysCss);
        this.onBeforeRemoveByGroupPSSysCss(pSSysCss, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGroupPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByGroupPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByItemPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSSYSCSS_ITEMPSSYSCSSID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByItemPSSysCss(pSSysCss);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setItemPSSysCssId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByItemPSSysCss(pSSysCss2);
                PSDEDataViewServiceBase.this.internalRemoveByItemPSSysCss(pSSysCss2);
                PSDEDataViewServiceBase.this.onAfterRemoveByItemPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByItemPSSysCss(pSSysCss);
        this.onBeforeRemoveByItemPSSysCss(pSSysCss, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByItemPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByItemPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByItemPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByItemPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSSysCssId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEDataViewServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSSYSPFPLUGIN_GROUPPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setGroupPSSysPFPluginId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataViewServiceBase.this.internalRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataViewServiceBase.this.onAfterRemoveByGroupPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByGroupPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByGroupPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByGroupPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGroupPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByItemPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSSYSPFPLUGIN_ITEMPSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByItemPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setItemPSSysPFPluginId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByItemPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataViewServiceBase.this.internalRemoveByItemPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataViewServiceBase.this.onAfterRemoveByItemPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByItemPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByItemPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByItemPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByItemPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSSysPFPluginId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataViewServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSSysViewPanelId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEDataViewServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEDATAVIEW_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSDEDATAVIEW", iDataEntityModel.getDataInfo((IEntity)pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSDEDataView pSDEDataView : arrayList) {
            PSDEDataView pSDEDataView2 = (PSDEDataView)this.getDEModel().createEntity();
            pSDEDataView2.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
            pSDEDataView2.setPSViewMsgGroupId(null);
            this.update(pSDEDataView2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEDataViewServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEDataViewServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEDataViewServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEDataView> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSDEDataView pSDEDataView : arrayList) {
            this.remove((IEntity)pSDEDataView);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEDataView> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEDataView pSDEDataView) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataView(pSDEDataView);
        ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).removeByPSDEDataView(pSDEDataView);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByMDPSDEDataView(pSDEDataView);
        pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataView(pSDEDataView);
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).removeByPSDEDataView(pSDEDataView);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataView(pSDEDataView);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataView(pSDEDataView);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEDataView(pSDEDataView);
        super.onBeforeRemove(pSDEDataView);
    }

    protected void onBeforeRemoveTemp(PSDEDataView pSDEDataView) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEDataView(pSDEDataView);
        pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).removeTempByPSDEDataView(pSDEDataView);
        super.onBeforeRemoveTemp((IEntity)pSDEDataView);
    }

    protected void getRelatedDataTempMajor(PSDEDataView pSDEDataView) throws Exception {
        this.getRelatedDataTempMajor_PSDEListItem(pSDEDataView);
        this.getRelatedDataTempMajor_PSDEDataViewLogic(pSDEDataView);
        super.getRelatedDataTempMajor((IEntity)pSDEDataView);
    }

    protected void getRelatedDataTempMajor_PSDEListItem(PSDEDataView pSDEDataView) throws Exception {
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList = null;
        String string = pSDEDataView.getPSDEDataViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEListItemService.selectByPSDEDataView(pSDEDataView) : pSDEListItemService.selectTempByPSDEDataView(pSDEDataView);
        for (PSDEListItem pSDEListItem : arrayList) {
            pSDEListItemService.getTempMajor(pSDEListItem);
        }
    }

    protected void getRelatedDataTempMajor_PSDEDataViewLogic(PSDEDataView pSDEDataView) throws Exception {
        PSDEDataViewLogicService pSDEDataViewLogicService = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDataViewLogic> arrayList = null;
        String string = pSDEDataView.getPSDEDataViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDataViewLogicService.selectByPSDEDataView(pSDEDataView) : pSDEDataViewLogicService.selectTempByPSDEDataView(pSDEDataView);
        for (PSDEDataViewLogic pSDEDataViewLogic : arrayList) {
            pSDEDataViewLogicService.getTempMajor(pSDEDataViewLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEDataView pSDEDataView, PSDEDataView pSDEDataView2) throws Exception {
        ArrayList<PSDEDataViewLogic> arrayList = this.updateRelatedDataTempMajor_removePSDEDataViewLogic(pSDEDataView, pSDEDataView2);
        ArrayList<PSDEListItem> arrayList2 = this.updateRelatedDataTempMajor_removePSDEListItem(pSDEDataView, pSDEDataView2);
        this.updateRelatedDataTempMajor_updatePSDEListItem(pSDEDataView, pSDEDataView2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEDataViewLogic(pSDEDataView, pSDEDataView2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSDEDataView, (IEntity)pSDEDataView2);
    }

    protected ArrayList<PSDEListItem> updateRelatedDataTempMajor_removePSDEListItem(PSDEDataView pSDEDataView, PSDEDataView pSDEDataView2) throws Exception {
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList = pSDEListItemService.selectTempByPSDEDataView(pSDEDataView);
        ArrayList<PSDEListItem> arrayList2 = pSDEListItemService.selectByPSDEDataView(pSDEDataView2);
        HashMap<String, PSDEListItem> hashMap = new HashMap<String, PSDEListItem>();
        for (PSDEListItem pSDEListItem : arrayList2) {
            hashMap.put(pSDEListItem.getPSDEListItemId(), pSDEListItem);
        }
        for (PSDEListItem pSDEListItem : arrayList) {
            Object object = pSDEListItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEListItem pSDEListItem : hashMap.values()) {
            pSDEListItemService.remove((IEntity)pSDEListItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEListItem(PSDEDataView pSDEDataView, PSDEDataView pSDEDataView2, ArrayList<PSDEListItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEListItem pSDEListItem : arrayList) {
            pSDEListItemService.updateTempMajor(pSDEListItem);
        }
    }

    protected ArrayList<PSDEDataViewLogic> updateRelatedDataTempMajor_removePSDEDataViewLogic(PSDEDataView pSDEDataView, PSDEDataView pSDEDataView2) throws Exception {
        PSDEDataViewLogicService pSDEDataViewLogicService = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDataViewLogic> arrayList = pSDEDataViewLogicService.selectTempByPSDEDataView(pSDEDataView);
        ArrayList<PSDEDataViewLogic> arrayList2 = pSDEDataViewLogicService.selectByPSDEDataView(pSDEDataView2);
        HashMap<String, PSDEDataViewLogic> hashMap = new HashMap<String, PSDEDataViewLogic>();
        for (PSDEDataViewLogic pSDEDataViewLogic : arrayList2) {
            hashMap.put(pSDEDataViewLogic.getPSDEDataViewLogicId(), pSDEDataViewLogic);
        }
        for (PSDEDataViewLogic pSDEDataViewLogic : arrayList) {
            Object object = pSDEDataViewLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEDataViewLogic pSDEDataViewLogic : hashMap.values()) {
            pSDEDataViewLogicService.remove((IEntity)pSDEDataViewLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEDataViewLogic(PSDEDataView pSDEDataView, PSDEDataView pSDEDataView2, ArrayList<PSDEDataViewLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEDataViewLogicService pSDEDataViewLogicService = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEDataViewLogic pSDEDataViewLogic : arrayList) {
            pSDEDataViewLogicService.updateTempMajor(pSDEDataViewLogic);
        }
    }

    protected void replaceParentInfo(PSDEDataView pSDEDataView, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEDataView, cloneSession);
        if (pSDEDataView.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEDataView.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDEDataView, (PSACHandler)iEntity);
        }
        if (pSDEDataView.getGroupPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEDataView.getGroupPSCodeListId())) != null) {
            this.onFillParentInfo_GroupPSCodeList(pSDEDataView, (PSCodeList)iEntity);
        }
        if (pSDEDataView.getSwimlanePSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSDEDataView.getSwimlanePSCodeListId())) != null) {
            this.onFillParentInfo_SwimlanePSCodeList(pSDEDataView, (PSCodeList)iEntity);
        }
        if (pSDEDataView.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEDataView.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEDataView, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEDataView.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSDEDataView.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSDEDataView, (PSCtrlMsg)iEntity);
        }
        if (pSDEDataView.getGroupPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDataView.getGroupPSDEId())) != null) {
            this.onFillParentInfo_GroupPSDE(pSDEDataView, (PSDataEntity)iEntity);
        }
        if (pSDEDataView.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEDataView.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEDataView, (PSDataEntity)iEntity);
        }
        if (pSDEDataView.getCopyPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getCopyPSDEActionId())) != null) {
            this.onFillParentInfo_CopyPSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getCreatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getCreatePSDEActionId())) != null) {
            this.onFillParentInfo_CreatePSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getGetDraftPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getGetDraftPSDEActionId())) != null) {
            this.onFillParentInfo_GetDraftPSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getGetPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getGetPSDEActionId())) != null) {
            this.onFillParentInfo_GetPSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getGroupMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getGroupMovePSDEActionId())) != null) {
            this.onFillParentInfo_GroupMovePSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getMovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getMovePSDEActionId())) != null) {
            this.onFillParentInfo_MovePSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getRemovePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getRemovePSDEActionId())) != null) {
            this.onFillParentInfo_RemovePSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getUpdatePSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getUpdatePSDEActionId())) != null) {
            this.onFillParentInfo_UpdatePSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getUser2PSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getUser2PSDEActionId())) != null) {
            this.onFillParentInfo_User2PSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getUserPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEDataView.getUserPSDEActionId())) != null) {
            this.onFillParentInfo_UserPSDEAction(pSDEDataView, (PSDEAction)iEntity);
        }
        if (pSDEDataView.getAsyncPSDEDSId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEDataView.getAsyncPSDEDSId())) != null) {
            this.onFillParentInfo_AsyncPSDEDS(pSDEDataView, (PSDEDataSet)iEntity);
        }
        if (pSDEDataView.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEDataView.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDEDataView, (PSDEDataSet)iEntity);
        }
        if (pSDEDataView.getGroupPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDataView.getGroupPSDEFId())) != null) {
            this.onFillParentInfo_GroupPSDEF(pSDEDataView, (PSDEField)iEntity);
        }
        if (pSDEDataView.getGroupTextPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDataView.getGroupTextPSDEFId())) != null) {
            this.onFillParentInfo_GroupTextPSDEF(pSDEDataView, (PSDEField)iEntity);
        }
        if (pSDEDataView.getMinorSortPSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDataView.getMinorSortPSDEFId())) != null) {
            this.onFillParentInfo_MinorSortPSDEF(pSDEDataView, (PSDEField)iEntity);
        }
        if (pSDEDataView.getOrderValuePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDataView.getOrderValuePSDEFId())) != null) {
            this.onFillParentInfo_OrderValuePSDEF(pSDEDataView, (PSDEField)iEntity);
        }
        if (pSDEDataView.getSwimlanePSDEFId() != null && (iEntity = cloneSession.getEntity("PSDEFIELD", (Object)pSDEDataView.getSwimlanePSDEFId())) != null) {
            this.onFillParentInfo_SwimlanePSDEF(pSDEDataView, (PSDEField)iEntity);
        }
        if (pSDEDataView.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEDataView.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEDataView, (PSDEForm)iEntity);
        }
        if (pSDEDataView.getNavPSDERId() != null && (iEntity = cloneSession.getEntity("PSDER", (Object)pSDEDataView.getNavPSDERId())) != null) {
            this.onFillParentInfo_NavPSDER(pSDEDataView, (PSDER)iEntity);
        }
        if (pSDEDataView.getBatPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDEDataView.getBatPSDEToolbarId())) != null) {
            this.onFillParentInfo_BatPSDEToolbar(pSDEDataView, (PSDEToolbar)iEntity);
        }
        if (pSDEDataView.getGroupQuickPSDETBId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDEDataView.getGroupQuickPSDETBId())) != null) {
            this.onFillParentInfo_GroupQuickPSDEToolbar(pSDEDataView, (PSDEToolbar)iEntity);
        }
        if (pSDEDataView.getQuickPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDEDataView.getQuickPSDEToolbarId())) != null) {
            this.onFillParentInfo_QuickPSDEToolbar(pSDEDataView, (PSDEToolbar)iEntity);
        }
        if (pSDEDataView.getGroupPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEDataView.getGroupPSDEUAGroupId())) != null) {
            this.onFillParentInfo_GroupPSDEUAGroup(pSDEDataView, (PSDEUAGroup)iEntity);
        }
        if (pSDEDataView.getNo2PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEDataView.getNo2PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No2PSDEUAGroup(pSDEDataView, (PSDEUAGroup)iEntity);
        }
        if (pSDEDataView.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEDataView.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDEDataView, (PSDEUAGroup)iEntity);
        }
        if (pSDEDataView.getNavPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEDataView.getNavPSDEViewBaseId())) != null) {
            this.onFillParentInfo_NavPSDEViewBase(pSDEDataView, (PSDEViewBase)iEntity);
        }
        if (pSDEDataView.getEmptyTextPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEDataView.getEmptyTextPSLanResId())) != null) {
            this.onFillParentInfo_EmptyTextPSLanRes(pSDEDataView, (PSLanguageRes)iEntity);
        }
        if (pSDEDataView.getGroupPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEDataView.getGroupPSSysCssId())) != null) {
            this.onFillParentInfo_GroupPSSysCss(pSDEDataView, (PSSysCss)iEntity);
        }
        if (pSDEDataView.getItemPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEDataView.getItemPSSysCssId())) != null) {
            this.onFillParentInfo_ItemPSSysCss(pSDEDataView, (PSSysCss)iEntity);
        }
        if (pSDEDataView.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEDataView.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEDataView, (PSSysCss)iEntity);
        }
        if (pSDEDataView.getGroupPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEDataView.getGroupPSSysPFPluginId())) != null) {
            this.onFillParentInfo_GroupPSSysPFPlugin(pSDEDataView, (PSSysPFPlugin)iEntity);
        }
        if (pSDEDataView.getItemPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEDataView.getItemPSSysPFPluginId())) != null) {
            this.onFillParentInfo_ItemPSSysPFPlugin(pSDEDataView, (PSSysPFPlugin)iEntity);
        }
        if (pSDEDataView.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEDataView.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEDataView, (PSSysPFPlugin)iEntity);
        }
        if (pSDEDataView.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEDataView.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDEDataView, (PSSysViewPanel)iEntity);
        }
        if (pSDEDataView.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSDEDataView.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSDEDataView, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEDataView, bl);
        pSDEDataView.resetDVTag();
        pSDEDataView.resetDVTag2();
        pSDEDataView.resetDVTag3();
        pSDEDataView.resetDVTag4();
    }

    protected void onCheckEntity(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_AppendDEItems(bl, pSDEDataView, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AsyncPSDEDSId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BatPSDEToolbarId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CardHeight(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CardWidth(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Card_Col_LG(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Card_Col_MD(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Card_Col_SM(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Card_Col_XS(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CopyPSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CreatePSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataViewSN(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataViewStyle(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DVTag(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DVTag2(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DVTag3(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DVTag4(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyText(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyTextPSLanResName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableEdit(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemPriv(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePagingBar(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetDraftPSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetPSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupBarCloseMode(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupHeight(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupLayout(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMode(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupMovePSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSCodeListId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEFName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSDEUAGroupId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSSysCssId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupPSSysPFPluginId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupQuickPSDETBId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupStyle(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTextPSDEFId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupTextPSDEFName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GroupWidth(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Group_Col_LG(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Group_Col_MD(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Group_Col_SM(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Group_Col_XS(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemPSSysCssId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemPSSysPFPluginId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_KanbanFlag(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutItemType(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortDir(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MinorSortPSDEFName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MovePSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MultiSelect(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavPSDERId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavPSDERName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavPSDEViewBaseId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewFilter(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewHeight(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxHeight(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMaxWidth(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinHeight(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewMinWidth(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewParam(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewPos(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewShowMode(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavViewWidth(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEUAGroupId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEUAGroupName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NoSort(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValuePSDEFName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PagingSize(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataViewId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataViewName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_QuickPSDEToolbarId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RemovePSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SRFSysPub(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwimlanePSCodeListId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwimlanePSDEFId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwimlanePSDEFName(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UpdatePSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_User2PSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserPSDEActionId(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewModel(bl, pSDEDataView, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEDataView, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_AppendDEItems(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isAppendDEItemsDirty() : !pSDEDataView.isAppendDEItemsDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getAppendDEItems();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_AppendDEItems_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("APPENDDEITEMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AsyncPSDEDSId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isAsyncPSDEDSIdDirty() : !pSDEDataView.isAsyncPSDEDSIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getAsyncPSDEDSId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AsyncPSDEDSId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_BatPSDEToolbarId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isBatPSDEToolbarIdDirty() : !pSDEDataView.isBatPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getBatPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BatPSDEToolbarId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isBusyIndicatorDirty() : !pSDEDataView.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_CardHeight(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCardHeightDirty() : !pSDEDataView.isCardHeightDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getCardHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CardHeight_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CARDHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CardWidth(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCardWidthDirty() : !pSDEDataView.isCardWidthDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getCardWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CardWidth_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CARDWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Card_Col_LG(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCard_Col_LGDirty() : !pSDEDataView.isCard_Col_LGDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getCard_Col_LG();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Card_Col_LG_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CARD_COL_LG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Card_Col_MD(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCard_Col_MDDirty() : !pSDEDataView.isCard_Col_MDDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getCard_Col_MD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Card_Col_MD_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CARD_COL_MD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Card_Col_SM(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCard_Col_SMDirty() : !pSDEDataView.isCard_Col_SMDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getCard_Col_SM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Card_Col_SM_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CARD_COL_SM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Card_Col_XS(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCard_Col_XSDirty() : !pSDEDataView.isCard_Col_XSDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getCard_Col_XS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Card_Col_XS_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CARD_COL_XS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCodeNameDirty() && !bl2 : !pSDEDataView.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getCodeName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CODENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSDEDataView, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSDEDataViewDEModel(), "CODENAME", string3, pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_CopyPSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCopyPSDEActionIdDirty() : !pSDEDataView.isCopyPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getCopyPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CopyPSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_CreatePSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCreatePSDEActionIdDirty() : !pSDEDataView.isCreatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getCreatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CreatePSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCustomCondDirty() : !pSDEDataView.isCustomCondDirty()) {
            return null;
        }
        String string = pSDEDataView.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isCustomTypeDirty() : !pSDEDataView.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDEDataView.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataViewSN(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isDataViewSNDirty() : !pSDEDataView.isDataViewSNDirty()) {
            return null;
        }
        String string = pSDEDataView.getDataViewSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataViewSN_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAVIEWSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataViewStyle(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isDataViewStyleDirty() : !pSDEDataView.isDataViewStyleDirty()) {
            return null;
        }
        String string = pSDEDataView.getDataViewStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataViewStyle_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAVIEWSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DVTag(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isDVTagDirty() : !pSDEDataView.isDVTagDirty()) {
            return null;
        }
        String string = pSDEDataView.getDVTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DVTag_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DVTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DVTag2(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isDVTag2Dirty() : !pSDEDataView.isDVTag2Dirty()) {
            return null;
        }
        String string = pSDEDataView.getDVTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DVTag2_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DVTAG2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DVTag3(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isDVTag3Dirty() : !pSDEDataView.isDVTag3Dirty()) {
            return null;
        }
        String string = pSDEDataView.getDVTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DVTag3_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DVTAG3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DVTag4(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isDVTag4Dirty() : !pSDEDataView.isDVTag4Dirty()) {
            return null;
        }
        String string = pSDEDataView.getDVTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DVTag4_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DVTAG4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isDynaModelFlagDirty() : !pSDEDataView.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyText(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isEmptyTextDirty() : !pSDEDataView.isEmptyTextDirty()) {
            return null;
        }
        String string = pSDEDataView.getEmptyText();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyText_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isEmptyTextPSLanResIdDirty() : !pSDEDataView.isEmptyTextPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getEmptyTextPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EmptyTextPSLanResName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isEmptyTextPSLanResNameDirty() : !pSDEDataView.isEmptyTextPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getEmptyTextPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EmptyTextPSLanResName_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableEdit(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isEnableEditDirty() : !pSDEDataView.isEnableEditDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getEnableEdit();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableEdit_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableItemPriv(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isEnableItemPrivDirty() : !pSDEDataView.isEnableItemPrivDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getEnableItemPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemPriv_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnablePagingBar(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isEnablePagingBarDirty() : !pSDEDataView.isEnablePagingBarDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getEnablePagingBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePagingBar_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GetDraftPSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGetDraftPSDEActionIdDirty() : !pSDEDataView.isGetDraftPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGetDraftPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetDraftPSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GetPSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGetPSDEActionIdDirty() : !pSDEDataView.isGetPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGetPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetPSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupBarCloseMode(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupBarCloseModeDirty() : !pSDEDataView.isGroupBarCloseModeDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getGroupBarCloseMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupBarCloseMode_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPBARCLOSEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupHeight(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupHeightDirty() : !pSDEDataView.isGroupHeightDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getGroupHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupHeight_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupLayout(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupLayoutDirty() : !pSDEDataView.isGroupLayoutDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupLayout();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupLayout_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPLAYOUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupMode(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupModeDirty() : !pSDEDataView.isGroupModeDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMode_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupMovePSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupMovePSDEActionIdDirty() : !pSDEDataView.isGroupMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupMovePSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPMOVEPSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSCodeListId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupPSCodeListIdDirty() : !pSDEDataView.isGroupPSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSCodeListId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupPSDEFId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupPSDEFIdDirty() : !pSDEDataView.isGroupPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupPSDEFName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupPSDEFNameDirty() : !pSDEDataView.isGroupPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEFName_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupPSDEId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupPSDEIdDirty() : !pSDEDataView.isGroupPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupPSDENameDirty() : !pSDEDataView.isGroupPSDENameDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEName_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupPSDEUAGroupId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupPSDEUAGroupIdDirty() : !pSDEDataView.isGroupPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSDEUAGroupId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupPSSysCssId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupPSSysCssIdDirty() : !pSDEDataView.isGroupPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSSysCssId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupPSSysPFPluginId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupPSSysPFPluginIdDirty() : !pSDEDataView.isGroupPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupPSSysPFPluginId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupQuickPSDETBId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupQuickPSDETBIdDirty() : !pSDEDataView.isGroupQuickPSDETBIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupQuickPSDETBId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupQuickPSDETBId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPQUICKPSDETBID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GroupStyle(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupStyleDirty() : !pSDEDataView.isGroupStyleDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupStyle_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupTextPSDEFId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupTextPSDEFIdDirty() : !pSDEDataView.isGroupTextPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupTextPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTextPSDEFId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupTextPSDEFName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupTextPSDEFNameDirty() : !pSDEDataView.isGroupTextPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getGroupTextPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GroupTextPSDEFName_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_GroupWidth(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroupWidthDirty() : !pSDEDataView.isGroupWidthDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getGroupWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GroupWidth_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUPWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Group_Col_LG(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroup_Col_LGDirty() : !pSDEDataView.isGroup_Col_LGDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getGroup_Col_LG();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Group_Col_LG_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUP_COL_LG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Group_Col_MD(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroup_Col_MDDirty() : !pSDEDataView.isGroup_Col_MDDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getGroup_Col_MD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Group_Col_MD_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUP_COL_MD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Group_Col_SM(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroup_Col_SMDirty() : !pSDEDataView.isGroup_Col_SMDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getGroup_Col_SM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Group_Col_SM_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUP_COL_SM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Group_Col_XS(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isGroup_Col_XSDirty() : !pSDEDataView.isGroup_Col_XSDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getGroup_Col_XS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Group_Col_XS_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GROUP_COL_XS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemPSSysCssId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isItemPSSysCssIdDirty() : !pSDEDataView.isItemPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getItemPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemPSSysCssId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ItemPSSysPFPluginId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isItemPSSysPFPluginIdDirty() : !pSDEDataView.isItemPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getItemPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemPSSysPFPluginId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPSSYSPFPLUGINID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_KanbanFlag(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isKanbanFlagDirty() : !pSDEDataView.isKanbanFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getKanbanFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_KanbanFlag_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("KANBANFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LayoutItemType(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isLayoutItemTypeDirty() : !pSDEDataView.isLayoutItemTypeDirty()) {
            return null;
        }
        String string = pSDEDataView.getLayoutItemType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutItemType_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isLockFlagDirty() : !pSDEDataView.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isMemoDirty() : !pSDEDataView.isMemoDirty()) {
            return null;
        }
        String string = pSDEDataView.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortDir(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isMinorSortDirDirty() : !pSDEDataView.isMinorSortDirDirty()) {
            return null;
        }
        String string = pSDEDataView.getMinorSortDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortDir_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortPSDEFId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isMinorSortPSDEFIdDirty() : !pSDEDataView.isMinorSortPSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getMinorSortPSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_MinorSortPSDEFName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isMinorSortPSDEFNameDirty() : !pSDEDataView.isMinorSortPSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getMinorSortPSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MinorSortPSDEFName_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_MovePSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isMovePSDEActionIdDirty() : !pSDEDataView.isMovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getMovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_MovePSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_MultiSelect(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isMultiSelectDirty() : !pSDEDataView.isMultiSelectDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getMultiSelect();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MultiSelect_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavPSDERId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavPSDERIdDirty() : !pSDEDataView.isNavPSDERIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getNavPSDERId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavPSDERId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavPSDERName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavPSDERNameDirty() : !pSDEDataView.isNavPSDERNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getNavPSDERName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavPSDERName_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavPSDEViewBaseId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavPSDEViewBaseIdDirty() : !pSDEDataView.isNavPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getNavPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavPSDEViewBaseId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewFilter(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewFilterDirty() : !pSDEDataView.isNavViewFilterDirty()) {
            return null;
        }
        String string = pSDEDataView.getNavViewFilter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewFilter_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewHeight(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewHeightDirty() : !pSDEDataView.isNavViewHeightDirty()) {
            return null;
        }
        Double d = pSDEDataView.getNavViewHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewHeight_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMaxHeight(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewMaxHeightDirty() : !pSDEDataView.isNavViewMaxHeightDirty()) {
            return null;
        }
        Double d = pSDEDataView.getNavViewMaxHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxHeight_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMaxWidth(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewMaxWidthDirty() : !pSDEDataView.isNavViewMaxWidthDirty()) {
            return null;
        }
        Double d = pSDEDataView.getNavViewMaxWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMaxWidth_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMinHeight(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewMinHeightDirty() : !pSDEDataView.isNavViewMinHeightDirty()) {
            return null;
        }
        Double d = pSDEDataView.getNavViewMinHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinHeight_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewMinWidth(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewMinWidthDirty() : !pSDEDataView.isNavViewMinWidthDirty()) {
            return null;
        }
        Double d = pSDEDataView.getNavViewMinWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewMinWidth_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewParam(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewParamDirty() : !pSDEDataView.isNavViewParamDirty()) {
            return null;
        }
        String string = pSDEDataView.getNavViewParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewParam_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewPos(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewPosDirty() : !pSDEDataView.isNavViewPosDirty()) {
            return null;
        }
        String string = pSDEDataView.getNavViewPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavViewPos_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewShowMode(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewShowModeDirty() : !pSDEDataView.isNavViewShowModeDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getNavViewShowMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewShowMode_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavViewWidth(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNavViewWidthDirty() : !pSDEDataView.isNavViewWidthDirty()) {
            return null;
        }
        Double d = pSDEDataView.getNavViewWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavViewWidth_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_No2PSDEUAGroupId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNo2PSDEUAGroupIdDirty() : !pSDEDataView.isNo2PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getNo2PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEUAGroupId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEUAGroupName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNo2PSDEUAGroupNameDirty() : !pSDEDataView.isNo2PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getNo2PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEUAGroupName_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO2PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NoSort(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isNoSortDirty() : !pSDEDataView.isNoSortDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getNoSort();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NoSort_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValuePSDEFId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isOrderValuePSDEFIdDirty() : !pSDEDataView.isOrderValuePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getOrderValuePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValuePSDEFName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isOrderValuePSDEFNameDirty() : !pSDEDataView.isOrderValuePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getOrderValuePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrderValuePSDEFName_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PagingSize(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPagingSizeDirty() : !pSDEDataView.isPagingSizeDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getPagingSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PagingSize_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSACHandlerIdDirty() : !pSDEDataView.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSCtrlLogicGroupIdDirty() : !pSDEDataView.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSCtrlMsgIdDirty() : !pSDEDataView.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSDEDataSetIdDirty() : !pSDEDataView.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_PSDEDataSet((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataViewId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSDEDataViewIdDirty() && !bl2 : !pSDEDataView.isPSDEDataViewIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSDEDataViewId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAVIEWID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataViewId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataViewName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSDEDataViewNameDirty() && !bl2 : !pSDEDataView.isPSDEDataViewNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSDEDataViewName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAVIEWNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataViewName_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAVIEWNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSDEFormIdDirty() : !pSDEDataView.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSDEIdDirty() && !bl2 : !pSDEDataView.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSDEId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSDENameDirty() && !bl2 : !pSDEDataView.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSDEName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDENAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSDEUAGroupIdDirty() : !pSDEDataView.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUAGroupName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSDEUAGroupNameDirty() : !pSDEDataView.isPSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupName_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSDynaInstIdDirty() : !pSDEDataView.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSSysCssIdDirty() : !pSDEDataView.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSSysPFPluginIdDirty() : !pSDEDataView.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSSysViewPanelIdDirty() : !pSDEDataView.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isPSViewMsgGroupIdDirty() : !pSDEDataView.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_QuickPSDEToolbarId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isQuickPSDEToolbarIdDirty() : !pSDEDataView.isQuickPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getQuickPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_QuickPSDEToolbarId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_RemovePSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isRemovePSDEActionIdDirty() : !pSDEDataView.isRemovePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getRemovePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RemovePSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_SRFSysPub(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isSRFSysPubDirty() : !pSDEDataView.isSRFSysPubDirty()) {
            return null;
        }
        Integer n = pSDEDataView.getSRFSysPub();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SRFSysPub_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_SwimlanePSCodeListId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isSwimlanePSCodeListIdDirty() : !pSDEDataView.isSwimlanePSCodeListIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getSwimlanePSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwimlanePSCodeListId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SWIMLANEPSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SwimlanePSDEFId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isSwimlanePSDEFIdDirty() : !pSDEDataView.isSwimlanePSDEFIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getSwimlanePSDEFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwimlanePSDEFId_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SWIMLANEPSDEFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SwimlanePSDEFName(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isSwimlanePSDEFNameDirty() : !pSDEDataView.isSwimlanePSDEFNameDirty()) {
            return null;
        }
        String string = pSDEDataView.getSwimlanePSDEFName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwimlanePSDEFName_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SWIMLANEPSDEFNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isToDoTaskDirty() : !pSDEDataView.isToDoTaskDirty()) {
            return null;
        }
        String string = pSDEDataView.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_UpdatePSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isUpdatePSDEActionIdDirty() : !pSDEDataView.isUpdatePSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getUpdatePSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UpdatePSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_User2PSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isUser2PSDEActionIdDirty() : !pSDEDataView.isUser2PSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getUser2PSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_User2PSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserPSDEActionId(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isUserPSDEActionIdDirty() : !pSDEDataView.isUserPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEDataView.getUserPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserPSDEActionId_Default((IEntity)pSDEDataView, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewModel(boolean bl, PSDEDataView pSDEDataView, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEDataView.isViewModelDirty() : !pSDEDataView.isViewModelDirty()) {
            return null;
        }
        String string = pSDEDataView.getViewModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ViewModel_Default((IEntity)pSDEDataView, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEDataView, bl);
    }

    protected void onSyncIndexEntities(PSDEDataView pSDEDataView, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEDataView, bl);
    }

    public Object getDataContextValue(PSDEDataView pSDEDataView, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null && StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACTION", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"GROUPMOVEPSDEACTIONID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"GROUPMOVEPSDEACTIONNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSDEDataView, "grouppsdeid", iDataContextParam)) != null) {
            return object;
        }
        object = super.getDataContextValue((IEntity)pSDEDataView, string, iDataContextParam);
        if (object != null) {
            return object;
        }
        PSDataEntity pSDataEntity = pSDEDataView.getPSDE();
        if (pSDataEntity != null && pSDataEntity.contains(string)) {
            return pSDataEntity.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEDataView pSDEDataView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDEListItem_PSDEDataView(pSDEDataView, arrayList, n);
        this.onExportRelatedModel_PSDEDataViewLogic_PSDEDataView(pSDEDataView, arrayList, n);
        super.onExportRelatedModel((IEntity)pSDEDataView, arrayList, n);
    }

    protected void onExportRelatedModel_PSDEListItem_PSDEDataView(PSDEDataView pSDEDataView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList2 = pSDEListItemService.selectByPSDEDataView(pSDEDataView);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"6bd0fb04c84d7b9a0cd3618c6101fd05");
            jSONObject.put("srfdename", (Object)"PSDELISTITEM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDELISTITEM_PSDEDATAVIEW_PSDEDATAVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDataView, (String)"PSDEDATAVIEWID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEListItem pSDEListItem : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEListItem, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEListItemService.exportModel(pSDEListItem, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEDataViewLogic_PSDEDataView(PSDEDataView pSDEDataView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEDataViewLogicService pSDEDataViewLogicService = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDataViewLogic> arrayList2 = pSDEDataViewLogicService.selectByPSDEDataView(pSDEDataView);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"6d2760838fda787d85cd14f0fe9ee245");
            jSONObject.put("srfdename", (Object)"PSDEDATAVIEWLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDEDATAVIEWLOGIC_PSDEDATAVIEW_PSDEDATAVIEWID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEDataView, (String)"PSDEDATAVIEWID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEDataViewLogic pSDEDataViewLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEDataViewLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEDataViewLogicService.exportModel(pSDEDataViewLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEDataView pSDEDataView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_EmptyTextPSLanRes(pSDEDataView, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEDataView, arrayList, n);
    }

    protected void onExportMajorModel_EmptyTextPSLanRes(PSDEDataView pSDEDataView, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEDataView.getEmptyTextPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEDataView.getEmptyTextPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"APPENDDEITEMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AppendDEItems_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CARDHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CardHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CARDWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CardWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CARD_COL_LG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Card_Col_LG_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CARD_COL_MD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Card_Col_MD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CARD_COL_SM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Card_Col_SM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CARD_COL_XS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Card_Col_XS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CodeName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DATAVIEWSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataViewSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAVIEWSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataViewStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DVTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DVTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DVTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DVTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DVTAG3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DVTag3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DVTAG4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DVTag4_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"ENABLEEDIT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableEdit_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEITEMPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableItemPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPAGINGBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePagingBar_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"GROUPBARCLOSEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupBarCloseMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPLAYOUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupLayout_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMOVEPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMovePSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPMOVEPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupMovePSDEActionName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"GROUPPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupPSDEName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"GROUPQUICKPSDETBID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupQuickPSDETBId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUPQUICKPSDETBNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupQuickPSDETBName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"GROUPWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GroupWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUP_COL_LG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Group_Col_LG_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUP_COL_MD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Group_Col_MD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUP_COL_SM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Group_Col_SM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GROUP_COL_XS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Group_Col_XS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemPSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"KANBANFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_KanbanFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutItemType_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEUAGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEDATASET", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_PSDEDataSet(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataViewName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"SRFSYSPUB", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SRFSysPub_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWIMLANEPSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwimlanePSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWIMLANEPSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwimlanePSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWIMLANEPSDEFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwimlanePSDEFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWIMLANEPSDEFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwimlanePSDEFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"USERPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VIEWMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewModel_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_AppendDEItems_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CardHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CardWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Card_Col_LG_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Card_Col_MD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Card_Col_SM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Card_Col_XS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_DataViewSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAVIEWSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataViewStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAVIEWSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DVTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DVTAG", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DVTag2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DVTAG2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DVTag3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DVTAG3", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DVTag4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DVTAG4", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
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

    protected String onTestValueRule_EnablePagingBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_GroupBarCloseMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GroupLayout_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPLAYOUT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_GroupMovePSDEActionId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMOVEPSDEACTIONID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupMovePSDEActionName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPMOVEPSDEACTIONNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_GroupPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_GroupQuickPSDETBId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPQUICKPSDETBID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GroupQuickPSDETBName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("GROUPQUICKPSDETBNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_GroupWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Group_Col_LG_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Group_Col_MD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Group_Col_SM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Group_Col_XS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ItemPSSysPFPluginId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSSYSPFPLUGINID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemPSSysPFPluginName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPSSYSPFPLUGINNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_KanbanFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LayoutItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTITEMTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_No2PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No2PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO2PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSDEDataSetId_PSDEDataSet(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEDATASETID", "PSDEDATASET", DATASET_CURDE, iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u9ed8\u8ba4\u6570\u636e\u96c6\u5408\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_PSDEDataViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysViewPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SRFSysPub_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SwimlanePSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWIMLANEPSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SwimlanePSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWIMLANEPSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SwimlanePSDEFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWIMLANEPSDEFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SwimlanePSDEFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWIMLANEPSDEFNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_ViewModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VIEWMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEDataView pSDEDataView) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEDataView)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEDataView pSDEDataView) throws Exception {
        Object object = pSDEDataView.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDEDATAVIEW_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent((IEntity)pSDEDataView);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEDataView pSDEDataView, Object object) throws Exception {
        PSDEDataView pSDEDataView2 = new PSDEDataView();
        pSDEDataView2.set("PSDEDATAVIEWID", object);
        String string = DataObject.getStringValue((Object)pSDEDataView.get("PSDEDATAVIEWID"));
        super.onCopyDetails((IEntity)pSDEDataView, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEDataView pSDEDataView, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEDATAVIEW");
        if (!bl) {
            pSDEDataView.setPSACHandlerName(null);
            super.exportCurXmlModel(pSDEDataView, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEDataView pSDEDataView, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDEListItem(pSDEDataView, xmlNode);
        this.exportRelatedXmlModel_PSDEDataViewLogic(pSDEDataView, xmlNode);
        super.onExportRelatedXmlModel(pSDEDataView, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDEListItem(PSDEDataView pSDEDataView, XmlNode xmlNode) throws Exception {
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEListItem> arrayList = null;
        String string = pSDEDataView.getPSDEDataViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEListItemService.selectByPSDEDataView(pSDEDataView, "ORDER BY ORDERVALUE ASC") : pSDEListItemService.selectTempByPSDEDataView(pSDEDataView, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDELISTITEM");
            xmlNode.addNode(xmlNode2);
            for (PSDEListItem pSDEListItem : arrayList) {
                pSDEListItem.set("ORDERVALUE", null);
                pSDEListItemService.exportXmlModel(pSDEListItem, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEDataViewLogic(PSDEDataView pSDEDataView, XmlNode xmlNode) throws Exception {
        PSDEDataViewLogicService pSDEDataViewLogicService = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEDataViewLogic> arrayList = null;
        String string = pSDEDataView.getPSDEDataViewId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEDataViewLogicService.selectByPSDEDataView(pSDEDataView, "ORDER BY ORDERVALUE ASC") : pSDEDataViewLogicService.selectTempByPSDEDataView(pSDEDataView, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDEDATAVIEWLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDEDataViewLogic pSDEDataViewLogic : arrayList) {
                pSDEDataViewLogic.set("ORDERVALUE", null);
                pSDEDataViewLogicService.exportXmlModel(pSDEDataViewLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEDataView pSDEDataView, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDELISTITEM");
        this.importRelatedXmlModel_PSDEListItem(pSDEDataView, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDEDATAVIEWLOGICS");
        this.importRelatedXmlModel_PSDEDataViewLogic(pSDEDataView, xmlNode3);
        super.onImportRelatedXmlModel(pSDEDataView, xmlNode);
    }

    protected void importRelatedXmlModel_PSDEListItem(PSDEDataView pSDEDataView, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEDataView.getPSDEDataViewId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEListItemService.removeByPSDEDataView(pSDEDataView);
        } else {
            pSDEListItemService.removeTempByPSDEDataView(pSDEDataView);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEListItem pSDEListItem = new PSDEListItem();
                pSDEListItem.setOrderValue(n);
                n += 100;
                pSDEListItemService.fillParentInfo((IEntity)pSDEListItem, "DER1N", "DER1N_PSDELISTITEM_PSDEDATAVIEW_PSDEDATAVIEWID", pSDEDataView.getPSDEDataViewId());
                pSDEListItemService.importXmlModel(pSDEListItem, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEDataViewLogic(PSDEDataView pSDEDataView, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEDataViewLogicService pSDEDataViewLogicService = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEDataView.getPSDEDataViewId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEDataViewLogicService.removeByPSDEDataView(pSDEDataView);
        } else {
            pSDEDataViewLogicService.removeTempByPSDEDataView(pSDEDataView);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEDataViewLogic pSDEDataViewLogic = new PSDEDataViewLogic();
                pSDEDataViewLogic.setOrderValue(n);
                n += 100;
                pSDEDataViewLogicService.fillParentInfo((IEntity)pSDEDataViewLogic, "DER1N", "DER1N_PSDEDATAVIEWLOGIC_PSDEDATAVIEW_PSDEDATAVIEWID", pSDEDataView.getPSDEDataViewId());
                pSDEDataViewLogicService.importXmlModel(pSDEDataViewLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEDataView pSDEDataView, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEDataView, string);
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
            return "DER1N_PSDEDATAVIEW_PSDATAENTITY_PSDEID";
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
    public String getModelV2Tag(PSDEDataView pSDEDataView) {
        if (!StringHelper.isNullOrEmpty((String)pSDEDataView.getCodeName())) {
            return pSDEDataView.getCodeName();
        }
        return super.getModelV2Tag(pSDEDataView);
    }

    @Override
    public boolean setModelV2Tag(PSDEDataView pSDEDataView, String string) {
        pSDEDataView.setCodeName(string);
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
    public boolean getModelV2Entity(PSDEDataView pSDEDataView, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEDataView.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEDataView, true);
        pSDEDataView.set("CODENAME", string);
        if (this.select(pSDEDataView, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEDataView, true);
        return super.getModelV2Entity(pSDEDataView, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEDataView pSDEDataView, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEDataView, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDELISTITEM_PSDEDATAVIEW_PSDEDATAVIEWID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDEDATAVIEWLOGIC_PSDEDATAVIEW_PSDEDATAVIEWID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEDataView pSDEDataView, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEDataView, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEDataView pSDEDataView, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSDEListItem> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDELISTITEM_PSDEDATAVIEW_PSDEDATAVIEWID")) {
            pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATAVIEW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDELISTITEM", (Object)pSDEDataView.getPSDEDataViewId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSDEListItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSDEListItem>();
                object3 = ((PSDEListItemServiceBase)pSCoreSysServiceBase).selectByPSDEDataView(pSDEDataView);
                arrayNode = StringHelper.format((String)"PSDEDATAVIEW#%1$s", (Object)pSDEDataView.getPSDEDataViewId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEListItem)object2.next();
                    object = ((PSDEListItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEListItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                        if (objectNode.has("psdelistitemname")) {
                            string = objectNode.get("psdelistitemname").asText();
                        }
                        if (objectNode2.has("psdelistitemname")) {
                            string2 = objectNode2.get("psdelistitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEListItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDEDATAVIEWLOGIC_PSDEDATAVIEW_PSDEDATAVIEWID")) {
            pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDEDATAVIEW#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDEDATAVIEWLOGIC", (Object)pSDEDataView.getPSDEDataViewId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSDEListItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).selectByPSDEDataView(pSDEDataView);
                arrayNode = StringHelper.format((String)"PSDEDATAVIEW#%1$s", (Object)pSDEDataView.getPSDEDataViewId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSDEDataViewLogic)object2.next();
                    object = ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSDEListItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
                }
            }
            if (arrayList != null && arrayList.size() > 0) {
                object3 = pSCoreSysServiceBase.getModelV2Name(false);
                arrayNode = objectNode.putArray(((String)object3).toLowerCase());
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
                        if (objectNode.has("psdedataviewlogicname")) {
                            string = objectNode.get("psdedataviewlogicname").asText();
                        }
                        if (objectNode2.has("psdedataviewlogicname")) {
                            string2 = objectNode2.get("psdedataviewlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSDEDataViewLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEDataView, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEDataView pSDEDataView) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSDEListItemServiceBase)pSCoreSysServiceBase).selectByPSDEDataView(pSDEDataView);
        String string2 = StringHelper.format((String)"PSDEDATAVIEW#%1$s", (Object)pSDEDataView.getPSDEDataViewId());
        for (PSDEListItem entityBase : arrayList) {
            string = ((PSDEListItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSDEDataView.getPSDEDataViewId());
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEListItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDELISTITEM WHERE PSDEDATAVIEWID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).selectByPSDEDataView(pSDEDataView);
        string2 = StringHelper.format((String)"PSDEDATAVIEW#%1$s", (Object)pSDEDataView.getPSDEDataViewId());
        for (PSDEDataViewLogic pSDEDataViewLogic : arrayList) {
            string = ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSDEDataViewLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEDataViewLogic);
        }
        object = new SqlParamList();
        object.addString(pSDEDataView.getPSDEDataViewId());
        ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDEDATAVIEWLOGIC WHERE PSDEDATAVIEWID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSDEDataView);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEDataView pSDEDataView, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDEListItem();
        entityBase.set("PSDEDATAVIEWID", pSDEDataView.getPSDEDataViewId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEDataViewLogic();
        entityBase.set("PSDEDATAVIEWID", pSDEDataView.getPSDEDataViewId());
        pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEDataView, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEDataView pSDEDataView, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSDEListItem();
                ((PSDEListItemBase)object).setDataViewPSDEId(pSDEDataView.getPSDEId());
                ((PSDEListItemBase)object).setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
                ((PSDEListItemBase)object).setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEListItem();
                    entityBase.setDataViewPSDEId(pSDEDataView.getPSDEId());
                    entityBase.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
                    entityBase.setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSDEDataViewLogic();
                ((PSDEDataViewLogicBase)object).setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
                ((PSDEDataViewLogicBase)object).setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string5);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSDEDataViewLogic();
                    entityBase.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
                    entityBase.setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEDataView, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEDataView pSDEDataView, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDELISTITEM_PSDEDATAVIEW_PSDEDATAVIEWID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEListItem(pSDEDataView, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDEDATAVIEWLOGIC_PSDEDATAVIEW_PSDEDATAVIEWID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEDataViewLogics(pSDEDataView, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEDataView, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDEListItem(PSDEDataView pSDEDataView, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDELISTITEM", true), (boolean)false) == 0) {
            PSDEListItemService pSDEListItemService = (PSDEListItemService)ServiceGlobal.getService(PSDEListItemService.class, (SessionFactory)this.getSessionFactory());
            PSDEListItem pSDEListItem = new PSDEListItem();
            pSDEListItem.setPSDEListItemId(pSMOSFile.getPSModelId());
            if (!pSDEListItemService.get((IEntity)pSDEListItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEListItem.getPSDEDataViewId(), (String)pSDEDataView.getPSDEDataViewId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEListItemService.exportModelV2(pSDEListItem);
            pSDEListItem.reset();
            if (!pSDEListItemService.setModelV2ResScope((IEntity)pSDEListItem, "PSDEDATAVIEW", pSDEDataView.getPSDEDataViewId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEListItemService.importModelV2(pSDEListItem, objectNode);
            SessionFactoryManager.commit();
            return pSDEListItemService.getFile((IEntity)pSDEListItem);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEDataViewLogics(PSDEDataView pSDEDataView, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDEDATAVIEWLOGIC", true), (boolean)false) == 0) {
            PSDEDataViewLogicService pSDEDataViewLogicService = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEDataViewLogic pSDEDataViewLogic = new PSDEDataViewLogic();
            pSDEDataViewLogic.setPSDEDataViewLogicId(pSMOSFile.getPSModelId());
            if (!pSDEDataViewLogicService.get((IEntity)pSDEDataViewLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEDataViewLogic.getPSDEDataViewId(), (String)pSDEDataView.getPSDEDataViewId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEDataViewLogicService.exportModelV2(pSDEDataViewLogic);
            pSDEDataViewLogic.reset();
            if (!pSDEDataViewLogicService.setModelV2ResScope((IEntity)pSDEDataViewLogic, "PSDEDATAVIEW", pSDEDataView.getPSDEDataViewId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEDataViewLogicService.importModelV2(pSDEDataViewLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDEDataViewLogicService.getFile((IEntity)pSDEDataViewLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEDataView pSDEDataView, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDEListItem(pSDEDataView, list);
        this.onFillPasteHelps_PSDEDataViewLogics(pSDEDataView, list);
        super.onFillPasteHelps(pSDEDataView, list);
    }

    protected void onFillPasteHelps_PSDEListItem(PSDEDataView pSDEDataView, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDELISTITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDELISTITEM_PSDEDATAVIEW_PSDEDATAVIEWID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5361\u7247\u89c6\u56fe\u90e8\u4ef6]\u7684[\u5b9e\u4f53\u591a\u6570\u636e\u90e8\u4ef6\u9879]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEDataViewLogics(PSDEDataView pSDEDataView, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDEDATAVIEWLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDEDATAVIEWLOGIC_PSDEDATAVIEW_PSDEDATAVIEWID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5361\u7247\u89c6\u56fe\u90e8\u4ef6]\u7684[\u5361\u7247\u89c6\u56fe\u90e8\u4ef6\u903b\u8f91]");
        list.add(pSHelpSection);
    }
}

