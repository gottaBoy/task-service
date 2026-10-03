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
import net.ibizsys.pscore.srv.config.entity.PSSysToolbar;
import net.ibizsys.pscore.srv.config.entity.PSSysToolbarBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEToolbarDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEToolbarDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETBItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarLogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTitleBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTitleBarServiceBase;
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

public abstract class PSDEToolbarServiceBase
extends PSCoreSysServiceBase<PSDEToolbar> {
    private static final Log log = LogFactory.getLog(PSDEToolbarServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYSTEMPL = "CurSysTempl";
    public static final String DATASET_DERANGE = "DERange";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_SYSANDDERANGE = "SysAndDERange";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_PREVIEWSAVE = "PreviewSave";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSDEToolbarDEModel pSDEToolbarDEModel;
    private PSDEToolbarDAO pSDEToolbarDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService";
    }

    public PSDEToolbarDEModel getPSDEToolbarDEModel() {
        if (this.pSDEToolbarDEModel == null) {
            try {
                this.pSDEToolbarDEModel = (PSDEToolbarDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEToolbarDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEToolbarDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEToolbarDEModel();
    }

    public PSDEToolbarDAO getPSDEToolbarDAO() {
        if (this.pSDEToolbarDAO == null) {
            try {
                this.pSDEToolbarDAO = (PSDEToolbarDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEToolbarDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEToolbarDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEToolbarDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSTEMPL, (boolean)true) == 0) {
            return this.fetchCurSysTempl(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DERANGE, (boolean)true) == 0) {
            return this.fetchDERange(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_SYSANDDERANGE, (boolean)true) == 0) {
            return this.fetchSysAndDERange(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchTempCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURMOD, (boolean)true) == 0) {
            return this.fetchTempCurMod(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSTEMPL, (boolean)true) == 0) {
            return this.fetchTempCurSysTempl(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DERANGE, (boolean)true) == 0) {
            return this.fetchTempDERange(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_SYSANDDERANGE, (boolean)true) == 0) {
            return this.fetchTempSysAndDERange(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSDEToolbar)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSDEToolbar)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSDEToolbar)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSDEToolbar)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PREVIEWSAVE, (boolean)true) == 0) {
            this.previewSave((PSDEToolbar)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSDEToolbar)iEntity);
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

    public DBFetchResult fetchCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurMod(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURMOD, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysTempl(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSTEMPL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysTempl(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSTEMPL, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchDERange(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DERANGE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempDERange(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_DERANGE, true);
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

    public DBFetchResult fetchSysAndDERange(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_SYSANDDERANGE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempSysAndDERange(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_SYSANDDERANGE, true);
        return dBFetchResult;
    }

    public void createWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, pSDEToolbar, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEToolbar, ACTION_CREATEWITHMODEL);
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEToolbarServiceBase.this.getService(), PSDEToolbarServiceBase.ACTION_CREATEWITHMODEL, 40, pSDEToolbar2, null).getResult() != 1) {
                    PSDEToolbarServiceBase.this.onCreateWithModel(pSDEToolbar2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, pSDEToolbar, null);
        }
    }

    protected void onCreateWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, pSDEToolbar, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEToolbar, ACTION_GETDRAFTFROMWITHMODEL);
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEToolbarServiceBase.this.getService(), PSDEToolbarServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, pSDEToolbar2, null).getResult() != 1) {
                    PSDEToolbarServiceBase.this.onGetDraftFromWithModel(pSDEToolbar2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, pSDEToolbar, null);
        }
    }

    protected void onGetDraftFromWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, pSDEToolbar, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEToolbar, ACTION_GETDRAFTWITHMODEL);
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEToolbarServiceBase.this.getService(), PSDEToolbarServiceBase.ACTION_GETDRAFTWITHMODEL, 40, pSDEToolbar2, null).getResult() != 1) {
                    PSDEToolbarServiceBase.this.onGetDraftWithModel(pSDEToolbar2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, pSDEToolbar, null);
        }
    }

    protected void onGetDraftWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, pSDEToolbar, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEToolbar, ACTION_GETWITHMODEL);
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEToolbarServiceBase.this.getService(), PSDEToolbarServiceBase.ACTION_GETWITHMODEL, 40, pSDEToolbar2, null).getResult() != 1) {
                    PSDEToolbarServiceBase.this.onGetWithModel(pSDEToolbar2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, pSDEToolbar, null);
        }
    }

    protected void onGetWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void previewSave(PSDEToolbar pSDEToolbar) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 0, pSDEToolbar, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEToolbar, ACTION_PREVIEWSAVE);
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEToolbarServiceBase.this.getService(), PSDEToolbarServiceBase.ACTION_PREVIEWSAVE, 40, pSDEToolbar2, null).getResult() != 1) {
                    PSDEToolbarServiceBase.this.onPreviewSave(pSDEToolbar2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 99, pSDEToolbar, null);
        }
    }

    protected void onPreviewSave(PSDEToolbar pSDEToolbar) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PreviewSave]");
    }

    public void updateWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, pSDEToolbar, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSDEToolbar, ACTION_UPDATEWITHMODEL);
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEToolbarServiceBase.this.getService(), PSDEToolbarServiceBase.ACTION_UPDATEWITHMODEL, 40, pSDEToolbar2, null).getResult() != 1) {
                    PSDEToolbarServiceBase.this.onUpdateWithModel(pSDEToolbar2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, pSDEToolbar, null);
        }
    }

    protected void onUpdateWithModel(PSDEToolbar pSDEToolbar) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSDEToolbar pSDEToolbar, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCtrlLogicGroup);
            } else {
                iService.get(pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEToolbar, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDataEntity);
            } else {
                iService.get(pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEToolbar, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSDEUAGROUP_NO2PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_No2PSDEUAGroup(pSDEToolbar, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSDEUAGROUP_NO3PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_No3PSDEUAGroup(pSDEToolbar, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSDEUAGROUP_NO4PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_No4PSDEUAGroup(pSDEToolbar, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSDEUAGROUP_NO5PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_No5PSDEUAGroup(pSDEToolbar, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSDEUAGROUP_NO6PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_No6PSDEUAGroup(pSDEToolbar, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSDEUAGroup);
            } else {
                iService.get(pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDEToolbar, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSDEToolbar, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysApp);
            } else {
                iService.get(pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSDEToolbar, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCounter);
            } else {
                iService.get(pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSDEToolbar, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCss);
            } else {
                iService.get(pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEToolbar, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysPFPlugin);
            } else {
                iService.get(pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEToolbar, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSDEToolbar, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSSYSTOOLBAR_PSSYSTOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysToolbarService", (SessionFactory)this.getSessionFactory());
            PSSysToolbar pSSysToolbar = (PSSysToolbar)iService.getDEModel().createEntity();
            pSSysToolbar.set("PSSYSTOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysToolbar);
            } else {
                iService.get(pSSysToolbar);
            }
            this.onFillParentInfo_PSSysToolbar(pSDEToolbar, pSSysToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDETOOLBAR_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSViewMsgGroup);
            } else {
                iService.get(pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSDEToolbar, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo(pSDEToolbar, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEToolbar pSDEToolbar, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEToolbar.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEToolbar.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSDE(PSDEToolbar pSDEToolbar, PSDataEntity pSDataEntity) throws Exception {
        pSDEToolbar.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEToolbar.setPSDEName(pSDataEntity.getPSDataEntityName());
        if (pSDataEntity.getPSModule() != null) {
            this.onFillParentInfo_PSModule(pSDEToolbar, pSDataEntity.getPSModule());
        }
    }

    protected void onFillParentInfo_No2PSDEUAGroup(PSDEToolbar pSDEToolbar, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEToolbar.setNo2PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEToolbar.setNo2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No3PSDEUAGroup(PSDEToolbar pSDEToolbar, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEToolbar.setNo3PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEToolbar.setNo3PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No4PSDEUAGroup(PSDEToolbar pSDEToolbar, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEToolbar.setNo4PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEToolbar.setNo4PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No5PSDEUAGroup(PSDEToolbar pSDEToolbar, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEToolbar.setNo5PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEToolbar.setNo5PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No6PSDEUAGroup(PSDEToolbar pSDEToolbar, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEToolbar.setNo6PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEToolbar.setNo6PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDEToolbar pSDEToolbar, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEToolbar.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEToolbar.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSModule(PSDEToolbar pSDEToolbar, PSModule pSModule) throws Exception {
        pSDEToolbar.setPSModuleId(pSModule.getPSModuleId());
        pSDEToolbar.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysApp(PSDEToolbar pSDEToolbar, PSSysApp pSSysApp) throws Exception {
        pSDEToolbar.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSDEToolbar.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_PSSysCounter(PSDEToolbar pSDEToolbar, PSSysCounter pSSysCounter) throws Exception {
        pSDEToolbar.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSDEToolbar.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEToolbar pSDEToolbar, PSSysCss pSSysCss) throws Exception {
        pSDEToolbar.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEToolbar.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEToolbar pSDEToolbar, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEToolbar.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEToolbar.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSDEToolbar pSDEToolbar, PSSystem pSSystem) throws Exception {
        pSDEToolbar.setPSSystemId(pSSystem.getPSSystemId());
        pSDEToolbar.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSSysToolbar(PSDEToolbar pSDEToolbar, PSSysToolbar pSSysToolbar) throws Exception {
        pSDEToolbar.setPSSysToolbarId(pSSysToolbar.getPSSysToolbarId());
        pSDEToolbar.setPSSysToolbarName(pSSysToolbar.getPSSysToolbarName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSDEToolbar pSDEToolbar, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSDEToolbar.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSDEToolbar.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        if (bl && pSDEToolbar.getTemplToolbar() == null) {
            pSDEToolbar.setTemplToolbar((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSDE(pSDEToolbar, bl);
        this.onFillEntityFullInfo_No2PSDEUAGroup(pSDEToolbar, bl);
        this.onFillEntityFullInfo_No3PSDEUAGroup(pSDEToolbar, bl);
        this.onFillEntityFullInfo_No4PSDEUAGroup(pSDEToolbar, bl);
        this.onFillEntityFullInfo_No5PSDEUAGroup(pSDEToolbar, bl);
        this.onFillEntityFullInfo_No6PSDEUAGroup(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSModule(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSSysApp(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSSystem(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSSysToolbar(pSDEToolbar, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSDEToolbar, bl);
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        if (pSDEToolbar.isPSDEIdDirty()) {
            if (pSDEToolbar.getPSDEId() != null) {
                PSDataEntity pSDataEntity;
                if (pSDEToolbar.getPSDEId() == null || pSDEToolbar.getPSDEName() == null) {
                    pSDataEntity = pSDEToolbar.getPSDE();
                    pSDEToolbar.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
                if (DataTypeHelper.compare((int)25, (Object)(pSDataEntity = pSDEToolbar.getPSDE()).getPSModuleId(), (Object)pSDEToolbar.getPSModuleId()) != 0L) {
                    pSDEToolbar.setPSModuleId(pSDataEntity.getPSModuleId());
                    this.onFillEntityFullInfo_PSModule(pSDEToolbar, bl);
                }
            } else {
                pSDEToolbar.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No2PSDEUAGroup(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        if (pSDEToolbar.isNo2PSDEUAGroupIdDirty()) {
            if (pSDEToolbar.getNo2PSDEUAGroupId() != null) {
                if (pSDEToolbar.getNo2PSDEUAGroupId() == null || pSDEToolbar.getNo2PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEToolbar.getNo2PSDEUAGroup();
                    pSDEToolbar.setNo2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEToolbar.setNo2PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No3PSDEUAGroup(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        if (pSDEToolbar.isNo3PSDEUAGroupIdDirty()) {
            if (pSDEToolbar.getNo3PSDEUAGroupId() != null) {
                if (pSDEToolbar.getNo3PSDEUAGroupId() == null || pSDEToolbar.getNo3PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEToolbar.getNo3PSDEUAGroup();
                    pSDEToolbar.setNo3PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEToolbar.setNo3PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No4PSDEUAGroup(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        if (pSDEToolbar.isNo4PSDEUAGroupIdDirty()) {
            if (pSDEToolbar.getNo4PSDEUAGroupId() != null) {
                if (pSDEToolbar.getNo4PSDEUAGroupId() == null || pSDEToolbar.getNo4PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEToolbar.getNo4PSDEUAGroup();
                    pSDEToolbar.setNo4PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEToolbar.setNo4PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No5PSDEUAGroup(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        if (pSDEToolbar.isNo5PSDEUAGroupIdDirty()) {
            if (pSDEToolbar.getNo5PSDEUAGroupId() != null) {
                if (pSDEToolbar.getNo5PSDEUAGroupId() == null || pSDEToolbar.getNo5PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEToolbar.getNo5PSDEUAGroup();
                    pSDEToolbar.setNo5PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEToolbar.setNo5PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No6PSDEUAGroup(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        if (pSDEToolbar.isNo6PSDEUAGroupIdDirty()) {
            if (pSDEToolbar.getNo6PSDEUAGroupId() != null) {
                if (pSDEToolbar.getNo6PSDEUAGroupId() == null || pSDEToolbar.getNo6PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEToolbar.getNo6PSDEUAGroup();
                    pSDEToolbar.setNo6PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEToolbar.setNo6PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        if (pSDEToolbar.isPSDEUAGroupIdDirty()) {
            if (pSDEToolbar.getPSDEUAGroupId() != null) {
                if (pSDEToolbar.getPSDEUAGroupId() == null || pSDEToolbar.getPSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEToolbar.getPSDEUAGroup();
                    pSDEToolbar.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEToolbar.setPSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysToolbar(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        super.onWriteBackParent(pSDEToolbar, bl);
    }

    public ArrayList<PSDEToolbar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByNo3PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo3PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByNo3PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo3PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByNo3PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO3PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo3PSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo3PSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEToolbar> selectByNo4PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo4PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByNo4PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo4PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByNo4PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO4PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo4PSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo4PSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEToolbar> selectByNo5PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo5PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByNo5PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo5PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByNo5PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO5PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo5PSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo5PSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEToolbar> selectByNo6PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo6PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByNo6PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo6PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByNo6PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NO6PSDEUAGROUPID", (Object)pSDEUAGroupBase.getPSDEUAGroupId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNo6PSDEUAGroupCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNo6PSDEUAGroupCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEToolbar> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEToolbar> selectByPSSysToolbar(PSSysToolbarBase pSSysToolbarBase) throws Exception {
        return this.selectByPSSysToolbar(pSSysToolbarBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysToolbar(PSSysToolbarBase pSSysToolbarBase, String string) throws Exception {
        return this.selectByPSSysToolbar(pSSysToolbarBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSSysToolbar(PSSysToolbarBase pSSysToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSTOOLBARID", (Object)pSSysToolbarBase.getPSSysToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEToolbar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSDEToolbar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSDEToolbar> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSCtrlLogicGroupId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEToolbarServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSDEId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEToolbarServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSDEUAGROUP_NO2PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setNo2PSDEUAGroupId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.internalRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo3PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSDEUAGROUP_NO3PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo3PSDEUAGroup(pSDEUAGroup);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setNo3PSDEUAGroupId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByNo3PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.internalRemoveByNo3PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.onAfterRemoveByNo3PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo3PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo3PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByNo3PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo4PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSDEUAGROUP_NO4PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo4PSDEUAGroup(pSDEUAGroup);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setNo4PSDEUAGroupId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByNo4PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.internalRemoveByNo4PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.onAfterRemoveByNo4PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo4PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo4PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByNo4PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo5PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSDEUAGROUP_NO5PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo5PSDEUAGroup(pSDEUAGroup);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setNo5PSDEUAGroupId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByNo5PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.internalRemoveByNo5PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.onAfterRemoveByNo5PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo5PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo5PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByNo5PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo6PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSDEUAGROUP_NO6PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo6PSDEUAGroup(pSDEUAGroup);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setNo6PSDEUAGroupId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByNo6PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.internalRemoveByNo6PSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.onAfterRemoveByNo6PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByNo6PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo6PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByNo6PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSDEUAGroupId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSModule(pSModule);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSModuleId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSDEToolbarServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSSysAppId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSDEToolbarServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSSysCounterId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSDEToolbarServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSSysCssId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEToolbarServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSSysPFPluginId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEToolbarServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSystem(pSSystem);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSSystemId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSDEToolbarServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysToolbar(pSSysToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSSYSTOOLBAR_PSSYSTOOLBARID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSSysToolbar), arrayList.get(0)));
        }
    }

    public void resetPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysToolbar(pSSysToolbar);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSSysToolbarId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        final PSSysToolbar pSSysToolbar2 = pSSysToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSSysToolbar(pSSysToolbar2);
                PSDEToolbarServiceBase.this.internalRemoveByPSSysToolbar(pSSysToolbar2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSSysToolbar(pSSysToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
    }

    protected void internalRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSSysToolbar(pSSysToolbar);
        this.onBeforeRemoveByPSSysToolbar(pSSysToolbar, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSSysToolbar(pSSysToolbar, arrayList);
    }

    protected void onAfterRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysToolbar(PSSysToolbar pSSysToolbar, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDETOOLBAR_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSDETOOLBAR", iDataEntityModel.getDataInfo(pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            PSDEToolbar pSDEToolbar2 = (PSDEToolbar)this.getDEModel().createEntity();
            pSDEToolbar2.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
            pSDEToolbar2.setPSViewMsgGroupId(null);
            this.update(pSDEToolbar2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEToolbarServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEToolbarServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSDEToolbarServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSDEToolbar> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSDEToolbar pSDEToolbar : arrayList) {
            this.remove(pSDEToolbar);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSDEToolbar> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEToolbar pSDEToolbar) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByBatPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGroupQuickPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByQuickPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByBatPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByQuickPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByBatPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByQuickPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEToolbar(pSDEToolbar);
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).removeByPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEToolbar(pSDEToolbar);
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).removeByPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByBatPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByQuickPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSSysTitleBarService)ServiceGlobal.getService(PSSysTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByLeftPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSSysTitleBarService)ServiceGlobal.getService(PSSysTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByRightPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEToolbar(pSDEToolbar);
        super.onBeforeRemove(pSDEToolbar);
    }

    protected void onBeforeRemoveTemp(PSDEToolbar pSDEToolbar) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).removeTempByPSDEToolbar(pSDEToolbar);
        pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).removeTempByPSDEToolbar(pSDEToolbar);
        super.onBeforeRemoveTemp(pSDEToolbar);
    }

    protected void getRelatedDataTempMajor(PSDEToolbar pSDEToolbar) throws Exception {
        this.getRelatedDataTempMajor_PSDETBItem(pSDEToolbar);
        this.getRelatedDataTempMajor_PSDEToolbarLogic(pSDEToolbar);
        super.getRelatedDataTempMajor(pSDEToolbar);
    }

    protected void getRelatedDataTempMajor_PSDETBItem(PSDEToolbar pSDEToolbar) throws Exception {
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETBItem> arrayList = null;
        String string = pSDEToolbar.getPSDEToolbarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETBItemService.selectByPSDEToolbar(pSDEToolbar) : pSDETBItemService.selectTempByPSDEToolbar(pSDEToolbar);
        PSDEToolbarServiceBase.sortHierarchyEntities(arrayList, (String)"PSDETBITEMID", (String)"PPSDETBITEMID");
        for (PSDETBItem pSDETBItem : arrayList) {
            pSDETBItemService.getTempMajor(pSDETBItem);
        }
    }

    protected void getRelatedDataTempMajor_PSDEToolbarLogic(PSDEToolbar pSDEToolbar) throws Exception {
        PSDEToolbarLogicService pSDEToolbarLogicService = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEToolbarLogic> arrayList = null;
        String string = pSDEToolbar.getPSDEToolbarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEToolbarLogicService.selectByPSDEToolbar(pSDEToolbar) : pSDEToolbarLogicService.selectTempByPSDEToolbar(pSDEToolbar);
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            pSDEToolbarLogicService.getTempMajor(pSDEToolbarLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSDEToolbar pSDEToolbar, PSDEToolbar pSDEToolbar2) throws Exception {
        ArrayList<PSDEToolbarLogic> arrayList = this.updateRelatedDataTempMajor_removePSDEToolbarLogic(pSDEToolbar, pSDEToolbar2);
        ArrayList<PSDETBItem> arrayList2 = this.updateRelatedDataTempMajor_removePSDETBItem(pSDEToolbar, pSDEToolbar2);
        this.updateRelatedDataTempMajor_updatePSDETBItem(pSDEToolbar, pSDEToolbar2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSDEToolbarLogic(pSDEToolbar, pSDEToolbar2, arrayList);
        super.updateRelatedDataTempMajor(pSDEToolbar, pSDEToolbar2);
    }

    protected ArrayList<PSDETBItem> updateRelatedDataTempMajor_removePSDETBItem(PSDEToolbar pSDEToolbar, PSDEToolbar pSDEToolbar2) throws Exception {
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETBItem> arrayList = pSDETBItemService.selectTempByPSDEToolbar(pSDEToolbar);
        ArrayList<PSDETBItem> arrayList2 = pSDETBItemService.selectByPSDEToolbar(pSDEToolbar2);
        HashMap<String, PSDETBItem> hashMap = new HashMap<String, PSDETBItem>();
        for (PSDETBItem pSDETBItem : arrayList2) {
            hashMap.put(pSDETBItem.getPSDETBItemId(), pSDETBItem);
        }
        PSDEToolbarServiceBase.sortHierarchyEntities(arrayList, (String)"PSDETBITEMID", (String)"PPSDETBITEMID");
        for (PSDETBItem pSDETBItem : arrayList) {
            Object object = pSDETBItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDETBItem pSDETBItem : hashMap.values()) {
            pSDETBItemService.remove(pSDETBItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDETBItem(PSDEToolbar pSDEToolbar, PSDEToolbar pSDEToolbar2, ArrayList<PSDETBItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSDETBItem pSDETBItem : arrayList) {
            pSDETBItemService.updateTempMajor(pSDETBItem);
        }
    }

    protected ArrayList<PSDEToolbarLogic> updateRelatedDataTempMajor_removePSDEToolbarLogic(PSDEToolbar pSDEToolbar, PSDEToolbar pSDEToolbar2) throws Exception {
        PSDEToolbarLogicService pSDEToolbarLogicService = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEToolbarLogic> arrayList = pSDEToolbarLogicService.selectTempByPSDEToolbar(pSDEToolbar);
        ArrayList<PSDEToolbarLogic> arrayList2 = pSDEToolbarLogicService.selectByPSDEToolbar(pSDEToolbar2);
        HashMap<String, PSDEToolbarLogic> hashMap = new HashMap<String, PSDEToolbarLogic>();
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList2) {
            hashMap.put(pSDEToolbarLogic.getPSDEToolbarLogicId(), pSDEToolbarLogic);
        }
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            Object object = pSDEToolbarLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSDEToolbarLogic pSDEToolbarLogic : hashMap.values()) {
            pSDEToolbarLogicService.remove(pSDEToolbarLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSDEToolbarLogic(PSDEToolbar pSDEToolbar, PSDEToolbar pSDEToolbar2, ArrayList<PSDEToolbarLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSDEToolbarLogicService pSDEToolbarLogicService = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
            pSDEToolbarLogicService.updateTempMajor(pSDEToolbarLogic);
        }
    }

    protected void replaceParentInfo(PSDEToolbar pSDEToolbar, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSDEToolbar, cloneSession);
        if (pSDEToolbar.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEToolbar.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEToolbar, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEToolbar.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEToolbar.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEToolbar, (PSDataEntity)iEntity);
        }
        if (pSDEToolbar.getNo2PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEToolbar.getNo2PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No2PSDEUAGroup(pSDEToolbar, (PSDEUAGroup)iEntity);
        }
        if (pSDEToolbar.getNo3PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEToolbar.getNo3PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No3PSDEUAGroup(pSDEToolbar, (PSDEUAGroup)iEntity);
        }
        if (pSDEToolbar.getNo4PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEToolbar.getNo4PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No4PSDEUAGroup(pSDEToolbar, (PSDEUAGroup)iEntity);
        }
        if (pSDEToolbar.getNo5PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEToolbar.getNo5PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No5PSDEUAGroup(pSDEToolbar, (PSDEUAGroup)iEntity);
        }
        if (pSDEToolbar.getNo6PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEToolbar.getNo6PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No6PSDEUAGroup(pSDEToolbar, (PSDEUAGroup)iEntity);
        }
        if (pSDEToolbar.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEToolbar.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDEToolbar, (PSDEUAGroup)iEntity);
        }
        if (pSDEToolbar.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSDEToolbar.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSDEToolbar, (PSModule)iEntity);
        }
        if (pSDEToolbar.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSDEToolbar.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSDEToolbar, (PSSysApp)iEntity);
        }
        if (pSDEToolbar.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSDEToolbar.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSDEToolbar, (PSSysCounter)iEntity);
        }
        if (pSDEToolbar.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEToolbar.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEToolbar, (PSSysCss)iEntity);
        }
        if (pSDEToolbar.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEToolbar.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEToolbar, (PSSysPFPlugin)iEntity);
        }
        if (pSDEToolbar.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSDEToolbar.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSDEToolbar, (PSSystem)iEntity);
        }
        if (pSDEToolbar.getPSSysToolbarId() != null && (iEntity = cloneSession.getEntity("PSSYSTOOLBAR", (Object)pSDEToolbar.getPSSysToolbarId())) != null) {
            this.onFillParentInfo_PSSysToolbar(pSDEToolbar, (PSSysToolbar)iEntity);
        }
        if (pSDEToolbar.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSDEToolbar.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSDEToolbar, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSDEToolbar, bl);
        pSDEToolbar.resetCodeName();
    }

    protected void onCheckEntity(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_CodeName(bl, pSDEToolbar, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconAlign(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobFlag(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEUAGroupId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No2PSDEUAGroupName(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSDEUAGroupId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No3PSDEUAGroupName(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSDEUAGroupId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No4PSDEUAGroupName(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No5PSDEUAGroupId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No5PSDEUAGroupName(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No6PSDEUAGroupId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_No6PSDEUAGroupName(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarName(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupName(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysToolbarId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysAppFlag(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TBModel(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplToolbar(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToolbarSN(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToolbarStyle(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserParams(bl, pSDEToolbar, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSDEToolbar, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isCodeNameDirty() : !pSDEToolbar.isCodeNameDirty()) {
            return null;
        }
        String string = pSDEToolbar.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSDEToolbar, bl2, bl3);
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
                string3 = string3 + ";";
                string3 = string3 + "PSMODULEID";
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSDEToolbarDEModel(), "CODENAME", string3, pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_IconAlign(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isIconAlignDirty() : !pSDEToolbar.isIconAlignDirty()) {
            return null;
        }
        String string = pSDEToolbar.getIconAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconAlign_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ICONALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isLockFlagDirty() : !pSDEToolbar.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSDEToolbar.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isMemoDirty() : !pSDEToolbar.isMemoDirty()) {
            return null;
        }
        String string = pSDEToolbar.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobFlag(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isMobFlagDirty() : !pSDEToolbar.isMobFlagDirty()) {
            return null;
        }
        Integer n = pSDEToolbar.getMobFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MobFlag_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No2PSDEUAGroupId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo2PSDEUAGroupIdDirty() : !pSDEToolbar.isNo2PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo2PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEUAGroupId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_No2PSDEUAGroupName(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo2PSDEUAGroupNameDirty() : !pSDEToolbar.isNo2PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo2PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No2PSDEUAGroupName_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_No3PSDEUAGroupId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo3PSDEUAGroupIdDirty() : !pSDEToolbar.isNo3PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo3PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSDEUAGroupId_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No3PSDEUAGroupName(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo3PSDEUAGroupNameDirty() : !pSDEToolbar.isNo3PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo3PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No3PSDEUAGroupName_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO3PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSDEUAGroupId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo4PSDEUAGroupIdDirty() : !pSDEToolbar.isNo4PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo4PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSDEUAGroupId_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No4PSDEUAGroupName(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo4PSDEUAGroupNameDirty() : !pSDEToolbar.isNo4PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo4PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No4PSDEUAGroupName_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO4PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No5PSDEUAGroupId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo5PSDEUAGroupIdDirty() : !pSDEToolbar.isNo5PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo5PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No5PSDEUAGroupId_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO5PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No5PSDEUAGroupName(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo5PSDEUAGroupNameDirty() : !pSDEToolbar.isNo5PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo5PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No5PSDEUAGroupName_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO5PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No6PSDEUAGroupId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo6PSDEUAGroupIdDirty() : !pSDEToolbar.isNo6PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo6PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No6PSDEUAGroupId_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO6PSDEUAGROUPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_No6PSDEUAGroupName(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isNo6PSDEUAGroupNameDirty() : !pSDEToolbar.isNo6PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEToolbar.getNo6PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_No6PSDEUAGroupName_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NO6PSDEUAGROUPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSCtrlLogicGroupIdDirty() : !pSDEToolbar.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSDEIdDirty() : !pSDEToolbar.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSDENameDirty() : !pSDEToolbar.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEToolbarId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSDEToolbarIdDirty() && !bl2 : !pSDEToolbar.isPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSDEToolbarId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarId_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEToolbarName(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSDEToolbarNameDirty() && !bl2 : !pSDEToolbar.isPSDEToolbarNameDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSDEToolbarName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarName_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDETOOLBARNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSDEUAGroupIdDirty() : !pSDEToolbar.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupName(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSDEUAGroupNameDirty() : !pSDEToolbar.isPSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupName_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSModuleIdDirty() : !pSDEToolbar.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSSysAppIdDirty() : !pSDEToolbar.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSSysCounterIdDirty() : !pSDEToolbar.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSSysCssIdDirty() : !pSDEToolbar.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSSysPFPluginIdDirty() : !pSDEToolbar.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSSystemIdDirty() && !bl2 : !pSDEToolbar.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysToolbarId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSSysToolbarIdDirty() : !pSDEToolbar.isPSSysToolbarIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSSysToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysToolbarId_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTOOLBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isPSViewMsgGroupIdDirty() : !pSDEToolbar.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSDEToolbar.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_SysAppFlag(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isSysAppFlagDirty() : !pSDEToolbar.isSysAppFlagDirty()) {
            return null;
        }
        Integer n = pSDEToolbar.getSysAppFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysAppFlag_Default(pSDEToolbar, bl2, bl3);
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

    protected EntityFieldError onCheckField_TBModel(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isTBModelDirty() : !pSDEToolbar.isTBModelDirty()) {
            return null;
        }
        String string = pSDEToolbar.getTBModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TBModel_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TBMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplToolbar(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isTemplToolbarDirty() : !pSDEToolbar.isTemplToolbarDirty()) {
            return null;
        }
        Integer n = pSDEToolbar.getTemplToolbar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplToolbar_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLTOOLBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToolbarSN(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isToolbarSNDirty() : !pSDEToolbar.isToolbarSNDirty()) {
            return null;
        }
        String string = pSDEToolbar.getToolbarSN();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToolbarSN_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLBARSN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToolbarStyle(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isToolbarStyleDirty() : !pSDEToolbar.isToolbarStyleDirty()) {
            return null;
        }
        String string = pSDEToolbar.getToolbarStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToolbarStyle_Default(pSDEToolbar, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOOLBARSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserParams(boolean bl, PSDEToolbar pSDEToolbar, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEToolbar.isUserParamsDirty() : !pSDEToolbar.isUserParamsDirty()) {
            return null;
        }
        String string = pSDEToolbar.getUserParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserParams_Default(pSDEToolbar, bl2, bl3);
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

    protected void onSyncEntity(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        super.onSyncEntity(pSDEToolbar, bl);
    }

    protected void onSyncIndexEntities(PSDEToolbar pSDEToolbar, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSDEToolbar, bl);
    }

    public Object getDataContextValue(PSDEToolbar pSDEToolbar, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSDEToolbar, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSDEToolbar.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportRelatedModel(PSDEToolbar pSDEToolbar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportRelatedModel_PSDETBItem_PSDEToolbar(pSDEToolbar, arrayList, n);
        this.onExportRelatedModel_PSDEToolbarLogic_PSDEToolbar(pSDEToolbar, arrayList, n);
        super.onExportRelatedModel(pSDEToolbar, arrayList, n);
    }

    /*
     * WARNING - void declaration
     */
    protected void onExportRelatedModel_PSDETBItem_PSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETBItem> arrayList2 = pSDETBItemService.selectByPSDEToolbar(pSDEToolbar);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"35d6211dd58885b4b8908feceb4cbb31");
            jSONObject.put("srfdename", (Object)"PSDETBITEM");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDETBITEM_PSDETOOLBAR_PSDETOOLBARID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEToolbar, (String)"PSDETOOLBARID", (String)""));
            String object = "";
            for (PSDETBItem pSDETBItem : arrayList2) {
                if (!StringHelper.isNullOrEmpty((String)object)) {
                    object = object + ";";
                }
                object = object + DataObject.getStringValue((IDataObject)pSDETBItem, (String)"PSDETBITEMID", (String)"");
            }
            jSONObject.put("srfarg2", (Object)object);
            arrayList.add(jSONObject);
        }
        for (PSDETBItem pSDETBItem : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDETBItem, (String)"srfsyspub", (int)1) == 0) continue;
            pSDETBItemService.exportModel(pSDETBItem, arrayList, n);
        }
    }

    protected void onExportRelatedModel_PSDEToolbarLogic_PSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        PSDEToolbarLogicService pSDEToolbarLogicService = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEToolbarLogic> arrayList2 = pSDEToolbarLogicService.selectByPSDEToolbar(pSDEToolbar);
        if ((n & 2) != 0) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("srfdeid", (Object)"ade729016ecf22553a6979968a77203b");
            jSONObject.put("srfdename", (Object)"PSDETOOLBARLOGIC");
            jSONObject.put("srfder1nsync", (Object)"true");
            jSONObject.put("srfder1nid", (Object)"DER1N_PSDETOOLBARLOGIC_PSDETOOLBAR_PSDETOOLBARID");
            jSONObject.put("srfarg", (Object)DataObject.getStringValue((IDataObject)pSDEToolbar, (String)"PSDETOOLBARID", (String)""));
            jSONObject.put("srfarg2", (Object)"");
            arrayList.add(jSONObject);
        }
        for (PSDEToolbarLogic pSDEToolbarLogic : arrayList2) {
            if (DataObject.getIntegerValue((IDataObject)pSDEToolbarLogic, (String)"srfsyspub", (int)1) == 0) continue;
            pSDEToolbarLogicService.exportModel(pSDEToolbarLogic, arrayList, n);
        }
    }

    protected void onExportMajorModel(PSDEToolbar pSDEToolbar, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSDEToolbar, arrayList, n);
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
        if (StringHelper.compare((String)string, (String)"ICONALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No2PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No3PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No4PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO5PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No5PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO5PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No5PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO6PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No6PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO6PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_No6PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSTOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSVIEWMSGGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSViewMsgGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSAPPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysAppFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TBMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TBModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLTOOLBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplToolbar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLBARSN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToolbarSN_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLBARSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToolbarStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserParams_Default(iEntity, bl, bl2);
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

    protected String onTestValueRule_IconAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ICONALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
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

    protected String onTestValueRule_MobFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_No3PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No3PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO3PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No4PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO4PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No5PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO5PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No5PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO5PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No6PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO6PSDEUAGROUPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_No6PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NO6PSDEUAGROUPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDETOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSSysToolbarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTOOLBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysToolbarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSTOOLBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_SysAppFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TBModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TBMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplToolbar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ToolbarSN_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLBARSN", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ToolbarStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOOLBARSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEToolbar pSDEToolbar) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSDEToolbar)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEToolbar pSDEToolbar) throws Exception {
        Object object = pSDEToolbar.get("PSDEID");
        if (object != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            iService.mergeChild("DER1N", "DER1N_PSDETOOLBAR_PSDATAENTITY_PSDEID", object);
        }
        super.onUpdateParent(pSDEToolbar);
    }

    protected boolean isNeedUpdateParent() {
        return true;
    }

    protected void onCopyDetails(PSDEToolbar pSDEToolbar, Object object) throws Exception {
        PSDEToolbar pSDEToolbar2 = new PSDEToolbar();
        pSDEToolbar2.set("PSDETOOLBARID", object);
        String string = DataObject.getStringValue((Object)pSDEToolbar.get("PSDETOOLBARID"));
        super.onCopyDetails(pSDEToolbar, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEToolbar pSDEToolbar, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDETOOLBAR");
        if (!bl) {
            pSDEToolbar.setCreateDate(null);
            pSDEToolbar.setCreateMan(null);
            pSDEToolbar.setPSDEToolbarId(null);
            pSDEToolbar.setPSSysAppName(null);
            pSDEToolbar.setUpdateDate(null);
            pSDEToolbar.setUpdateMan(null);
            super.exportCurXmlModel(pSDEToolbar, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEToolbar pSDEToolbar, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSDETBItem(pSDEToolbar, xmlNode);
        this.exportRelatedXmlModel_PSDEToolbarLogic(pSDEToolbar, xmlNode);
        super.onExportRelatedXmlModel(pSDEToolbar, xmlNode);
    }

    protected void exportRelatedXmlModel_PSDETBItem(PSDEToolbar pSDEToolbar, XmlNode xmlNode) throws Exception {
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETBItem> arrayList = null;
        String string = pSDEToolbar.getPSDEToolbarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDETBItemService.selectByPSDEToolbar(pSDEToolbar, "ORDER BY ORDERVALUE ASC") : pSDETBItemService.selectTempByPSDEToolbar(pSDEToolbar, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDETBITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSDETBItem pSDETBItem : arrayList) {
                if (pSDETBItem.getPPSDETBItemId() != null) continue;
                pSDETBItem.set("ORDERVALUE", null);
                pSDETBItemService.exportXmlModel(pSDETBItem, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSDEToolbarLogic(PSDEToolbar pSDEToolbar, XmlNode xmlNode) throws Exception {
        PSDEToolbarLogicService pSDEToolbarLogicService = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEToolbarLogic> arrayList = null;
        String string = pSDEToolbar.getPSDEToolbarId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSDEToolbarLogicService.selectByPSDEToolbar(pSDEToolbar, "ORDER BY ORDERVALUE ASC") : pSDEToolbarLogicService.selectTempByPSDEToolbar(pSDEToolbar, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSDETOOLBARLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSDEToolbarLogic pSDEToolbarLogic : arrayList) {
                pSDEToolbarLogic.set("ORDERVALUE", null);
                pSDEToolbarLogicService.exportXmlModel(pSDEToolbarLogic, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEToolbar pSDEToolbar, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSDETBITEMS");
        this.importRelatedXmlModel_PSDETBItem(pSDEToolbar, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSDETOOLBARLOGICS");
        this.importRelatedXmlModel_PSDEToolbarLogic(pSDEToolbar, xmlNode3);
        super.onImportRelatedXmlModel(pSDEToolbar, xmlNode);
    }

    protected void importRelatedXmlModel_PSDETBItem(PSDEToolbar pSDEToolbar, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEToolbar.getPSDEToolbarId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDETBItemService.removeByPSDEToolbar(pSDEToolbar);
        } else {
            pSDETBItemService.removeTempByPSDEToolbar(pSDEToolbar);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDETBItem pSDETBItem = new PSDETBItem();
                pSDETBItem.setOrderValue(n);
                n += 100;
                pSDETBItemService.fillParentInfo(pSDETBItem, "DER1N", "DER1N_PSDETBITEM_PSDETOOLBAR_PSDETOOLBARID", pSDEToolbar.getPSDEToolbarId());
                pSDETBItemService.importXmlModel(pSDETBItem, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSDEToolbarLogic(PSDEToolbar pSDEToolbar, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSDEToolbarLogicService pSDEToolbarLogicService = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSDEToolbar.getPSDEToolbarId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSDEToolbarLogicService.removeByPSDEToolbar(pSDEToolbar);
        } else {
            pSDEToolbarLogicService.removeTempByPSDEToolbar(pSDEToolbar);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSDEToolbarLogic pSDEToolbarLogic = new PSDEToolbarLogic();
                pSDEToolbarLogic.setOrderValue(n);
                n += 100;
                pSDEToolbarLogicService.fillParentInfo(pSDEToolbarLogic, "DER1N", "DER1N_PSDETOOLBARLOGIC_PSDETOOLBAR_PSDETOOLBARID", pSDEToolbar.getPSDEToolbarId());
                pSDEToolbarLogicService.importXmlModel(pSDEToolbarLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEToolbar pSDEToolbar, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEToolbar, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDATAENTITY#%1$s", (Object)string);
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
            return "DER1N_PSDETOOLBAR_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETOOLBAR_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDETOOLBAR_PSSYSTEM_PSSYSTEMID";
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
        return new String[]{"PSDEID", "PSMODULEID", "PSSYSTEMID"};
    }

    @Override
    public String getModelV2Tag(PSDEToolbar pSDEToolbar) {
        if (!StringHelper.isNullOrEmpty((String)pSDEToolbar.getCodeName())) {
            return pSDEToolbar.getCodeName();
        }
        return super.getModelV2Tag(pSDEToolbar);
    }

    @Override
    public boolean setModelV2Tag(PSDEToolbar pSDEToolbar, String string) {
        pSDEToolbar.setCodeName(string);
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
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEToolbar pSDEToolbar, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEToolbar.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEToolbar, true);
        pSDEToolbar.set("CODENAME", string);
        if (this.select(pSDEToolbar, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEToolbar, true);
        return super.getModelV2Entity(pSDEToolbar, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEToolbar pSDEToolbar, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEToolbar, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSDETBITEM_PSDETOOLBAR_PSDETOOLBARID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSDETOOLBARLOGIC_PSDETOOLBAR_PSDETOOLBARID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSDEToolbar pSDEToolbar, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSDEToolbar, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSDEToolbar pSDEToolbar, ObjectNode objectNode, String string, boolean bl) throws Exception {
        ArrayNode arrayNode;
        ArrayList<ObjectNode> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETBITEM_PSDETOOLBAR_PSDETOOLBARID")) {
            pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETOOLBAR#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETBITEM", (Object)pSDEToolbar.getPSDEToolbarId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETOOLBAR#%1$s", (Object)pSDEToolbar.getPSDEToolbarId());
                for (PSDETBItem model : ((PSDETBItemServiceBase)pSCoreSysServiceBase).selectByPSDEToolbar(pSDEToolbar)) {
                    if (StringHelper.compare(scope, ((PSDETBItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
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
                        if (objectNode.has("psdetbitemname")) {
                            string = objectNode.get("psdetbitemname").asText();
                        }
                        if (objectNode2.has("psdetbitemname")) {
                            string2 = objectNode2.get("psdetbitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDETBItem model = new PSDETBItem();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    model.remove("ordervalue");
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSDETOOLBARLOGIC_PSDETOOLBAR_PSDETOOLBARID")) {
            pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                File file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSDETOOLBAR#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSDETOOLBARLOGIC", (Object)pSDEToolbar.getPSDEToolbarId()));
                if (file.exists()) {
                    arrayList = new ArrayList<ObjectNode>();
                    for (String line : PSModelV2Helper.readFile2(file)) {
                        if (StringHelper.isNullOrEmpty(line)) continue;
                        arrayList.add((ObjectNode)JsonNodeHelper.fromString(line));
                    }
                }
            } else {
                arrayList = new ArrayList<ObjectNode>();
                String scope = StringHelper.format((String)"PSDETOOLBAR#%1$s", (Object)pSDEToolbar.getPSDEToolbarId());
                for (PSDEToolbarLogic model : ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).selectByPSDEToolbar(pSDEToolbar)) {
                    if (StringHelper.compare(scope, ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(model), false) != 0) continue;
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
                        if (objectNode.has("psdetoolbarlogicname")) {
                            string = objectNode.get("psdetoolbarlogicname").asText();
                        }
                        if (objectNode2.has("psdetoolbarlogicname")) {
                            string2 = objectNode2.get("psdetoolbarlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (ObjectNode node : arrayList) {
                    PSDEToolbarLogic model = new PSDEToolbarLogic();
                    PSModelV2Helper.fromJSONObject(model, node, false);
                    arrayNode.add(pSCoreSysServiceBase.exportModelV2(model, string));
                }
            }
        }
        super.onExportCurModelV2(pSDEToolbar, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSDEToolbar pSDEToolbar) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDETBItem> items = ((PSDETBItemServiceBase)pSCoreSysServiceBase).selectByPSDEToolbar(pSDEToolbar);
        String string2 = StringHelper.format((String)"PSDETOOLBAR#%1$s", (Object)pSDEToolbar.getPSDEToolbarId());
        for (PSDETBItem item : items) {
            string = ((PSDETBItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope(item);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(item);
        }
        SqlParamList params = new SqlParamList();
        params.addString(pSDEToolbar.getPSDEToolbarId());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETBITEM WHERE PSDETOOLBARID = ?", params);
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSDEToolbarLogic> logics = ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).selectByPSDEToolbar(pSDEToolbar);
        string2 = StringHelper.format((String)"PSDETOOLBAR#%1$s", (Object)pSDEToolbar.getPSDEToolbarId());
        for (PSDEToolbarLogic pSDEToolbarLogic : logics) {
            string = ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope(pSDEToolbarLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSDEToolbarLogic);
        }
        params = new SqlParamList();
        params.addString(pSDEToolbar.getPSDEToolbarId());
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSDETOOLBARLOGIC WHERE PSDETOOLBARID = ?", params);
        super.onEmptyModelV2(pSDEToolbar);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSDEToolbar pSDEToolbar, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSDETBItem();
        entityBase.set("PSDETOOLBARID", pSDEToolbar.getPSDEToolbarId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSDEToolbarLogic();
        entityBase.set("PSDETOOLBARID", pSDEToolbar.getPSDEToolbarId());
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSDEToolbar, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSDEToolbar pSDEToolbar, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        Object object2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n2 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object2 = (ObjectNode)arrayNode.get(i);
                PSDETBItem object = new PSDETBItem();
                object.setPSDEId(pSDEToolbar.getPSDEId());
                object.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
                object.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
                object.setPSSystemId(pSDEToolbar.getPSSystemId());
                object.setOrderValue(n2 += 10);
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                for (File child : ((File)object2).listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDETBItem pSDETBItem = new PSDETBItem();
                    pSDETBItem.setPSDEId(pSDEToolbar.getPSDEId());
                    pSDETBItem.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
                    pSDETBItem.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
                    pSDETBItem.setPSSystemId(pSDEToolbar.getPSSystemId());
                    pSCoreSysServiceBase.compileModelV2(pSDETBItem, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                ObjectNode objectNode2 = (ObjectNode)arrayNode.get(n2);
                PSDEToolbarLogic logic = new PSDEToolbarLogic();
                logic.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
                logic.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
                pSCoreSysServiceBase.compileModelV2(logic, objectNode2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            File file = new File(string5);
            if (file.exists()) {
                for (File child : file.listFiles()) {
                    if (!child.isDirectory()) continue;
                    PSDEToolbarLogic logic = new PSDEToolbarLogic();
                    logic.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
                    logic.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
                    pSCoreSysServiceBase.compileModelV2(logic, null, string, child.getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSDEToolbar, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSDEToolbar pSDEToolbar, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDETBITEM_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDETBItems(pSDEToolbar, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSDETOOLBARLOGIC_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSDEToolbarLogics(pSDEToolbar, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSDEToolbar, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSDETBItems(PSDEToolbar pSDEToolbar, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDETBITEM", true), (boolean)false) == 0) {
            PSDETBItemService pSDETBItemService = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
            PSDETBItem pSDETBItem = new PSDETBItem();
            pSDETBItem.setPSDETBItemId(pSMOSFile.getPSModelId());
            if (!pSDETBItemService.get(pSDETBItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDETBItem.getPSDEToolbarId(), (String)pSDEToolbar.getPSDEToolbarId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDETBItemService.exportModelV2(pSDETBItem);
            pSDETBItem.reset();
            if (!pSDETBItemService.setModelV2ResScope(pSDETBItem, "PSDETOOLBAR", pSDEToolbar.getPSDEToolbarId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDETBItemService.importModelV2(pSDETBItem, objectNode);
            SessionFactoryManager.commit();
            return pSDETBItemService.getFile(pSDETBItem);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSDEToolbarLogics(PSDEToolbar pSDEToolbar, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSDETOOLBARLOGIC", true), (boolean)false) == 0) {
            PSDEToolbarLogicService pSDEToolbarLogicService = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
            PSDEToolbarLogic pSDEToolbarLogic = new PSDEToolbarLogic();
            pSDEToolbarLogic.setPSDEToolbarLogicId(pSMOSFile.getPSModelId());
            if (!pSDEToolbarLogicService.get(pSDEToolbarLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSDEToolbarLogic.getPSDEToolbarId(), (String)pSDEToolbar.getPSDEToolbarId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSDEToolbarLogicService.exportModelV2(pSDEToolbarLogic);
            pSDEToolbarLogic.reset();
            if (!pSDEToolbarLogicService.setModelV2ResScope(pSDEToolbarLogic, "PSDETOOLBAR", pSDEToolbar.getPSDEToolbarId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSDEToolbarLogicService.importModelV2(pSDEToolbarLogic, objectNode);
            SessionFactoryManager.commit();
            return pSDEToolbarLogicService.getFile(pSDEToolbarLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSDEToolbar pSDEToolbar, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSDETBItems(pSDEToolbar, list);
        this.onFillPasteHelps_PSDEToolbarLogics(pSDEToolbar, list);
        super.onFillPasteHelps(pSDEToolbar, list);
    }

    protected void onFillPasteHelps_PSDETBItems(PSDEToolbar pSDEToolbar, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDETBITEM");
        pSHelpSection.setSectionParam2("DER1N_PSDETBITEM_PSDETOOLBAR_PSDETOOLBARID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5de5\u5177\u680f]\u7684[\u5de5\u5177\u680f\u9879]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSDEToolbarLogics(PSDEToolbar pSDEToolbar, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSDETOOLBARLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSDETOOLBARLOGIC_PSDETOOLBAR_PSDETOOLBARID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u5b9e\u4f53\u5de5\u5177\u680f]\u7684[\u5de5\u5177\u680f\u903b\u8f91]");
        list.add(pSHelpSection);
    }
}
