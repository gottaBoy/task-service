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
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuLogicServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppUtilPageServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEPrintServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEReportServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeLogicServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicServiceBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelEngine;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelEngineBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCond;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLNParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysAppBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroupBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGrpDetailServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSubViewTypeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewPanelServiceBase
extends PSCoreSysServiceBase<PSSysViewPanel> {
    private static final Log log = LogFactory.getLog(PSSysViewPanelServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURDE = "CurDE";
    public static final String DATASET_CURMOD = "CurMod";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURSYSCTRL = "CurSysCtrl";
    public static final String DATASET_CURSYSVIEW = "CurSysView";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_VIEWLAYOUT = "ViewLayout";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETDRAFTFROMWITHMODEL = "GetDraftFromWithModel";
    public static final String ACTION_GETDRAFTWITHMODEL = "GetDraftWithModel";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_JITPREVIEW = "JITPREVIEW";
    public static final String ACTION_PREVIEWSAVE = "PreviewSave";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSSysViewPanelDEModel pSSysViewPanelDEModel;
    private PSSysViewPanelDAO pSSysViewPanelDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService";
    }

    public PSSysViewPanelDEModel getPSSysViewPanelDEModel() {
        if (this.pSSysViewPanelDEModel == null) {
            try {
                this.pSSysViewPanelDEModel = (PSSysViewPanelDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysViewPanelDEModel();
    }

    public PSSysViewPanelDAO getPSSysViewPanelDAO() {
        if (this.pSSysViewPanelDAO == null) {
            try {
                this.pSSysViewPanelDAO = (PSSysViewPanelDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysViewPanelDAO();
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
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSCTRL, (boolean)true) == 0) {
            return this.fetchCurSysCtrl(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSVIEW, (boolean)true) == 0) {
            return this.fetchCurSysView(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VIEWLAYOUT, (boolean)true) == 0) {
            return this.fetchViewLayout(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSCTRL, (boolean)true) == 0) {
            return this.fetchTempCurSysCtrl(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYSVIEW, (boolean)true) == 0) {
            return this.fetchTempCurSysView(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_VIEWLAYOUT, (boolean)true) == 0) {
            return this.fetchTempViewLayout(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSSysViewPanel)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTFROMWITHMODEL, (boolean)true) == 0) {
            this.getDraftFromWithModel((PSSysViewPanel)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETDRAFTWITHMODEL, (boolean)true) == 0) {
            this.getDraftWithModel((PSSysViewPanel)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSSysViewPanel)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_JITPREVIEW, (boolean)true) == 0) {
            this.jITPreview((PSSysViewPanel)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_PREVIEWSAVE, (boolean)true) == 0) {
            this.previewSave((PSSysViewPanel)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSSysViewPanel)iEntity);
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

    public DBFetchResult fetchCurSysCtrl(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSCTRL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysCtrl(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSCTRL, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurSysView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSVIEW, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurSysView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURSYSVIEW, true);
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

    public DBFetchResult fetchViewLayout(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VIEWLAYOUT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempViewLayout(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_VIEWLAYOUT, true);
        return dBFetchResult;
    }

    public void createWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSSysViewPanel, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanel, ACTION_CREATEWITHMODEL);
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelServiceBase.this.getService(), PSSysViewPanelServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSSysViewPanel2, null).getResult() != 1) {
                    PSSysViewPanelServiceBase.this.onCreateWithModel(pSSysViewPanel2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSSysViewPanel, null);
        }
    }

    protected void onCreateWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getDraftFromWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 0, (IEntity)pSSysViewPanel, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanel, ACTION_GETDRAFTFROMWITHMODEL);
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelServiceBase.this.getService(), PSSysViewPanelServiceBase.ACTION_GETDRAFTFROMWITHMODEL, 40, (IEntity)pSSysViewPanel2, null).getResult() != 1) {
                    PSSysViewPanelServiceBase.this.onGetDraftFromWithModel(pSSysViewPanel2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTFROMWITHMODEL, 99, (IEntity)pSSysViewPanel, null);
        }
    }

    protected void onGetDraftFromWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftFromWithModel]");
    }

    public void getDraftWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 0, (IEntity)pSSysViewPanel, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanel, ACTION_GETDRAFTWITHMODEL);
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelServiceBase.this.getService(), PSSysViewPanelServiceBase.ACTION_GETDRAFTWITHMODEL, 40, (IEntity)pSSysViewPanel2, null).getResult() != 1) {
                    PSSysViewPanelServiceBase.this.onGetDraftWithModel(pSSysViewPanel2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETDRAFTWITHMODEL, 99, (IEntity)pSSysViewPanel, null);
        }
    }

    protected void onGetDraftWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetDraftWithModel]");
    }

    public void getWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSSysViewPanel, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanel, ACTION_GETWITHMODEL);
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelServiceBase.this.getService(), PSSysViewPanelServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSSysViewPanel2, null).getResult() != 1) {
                    PSSysViewPanelServiceBase.this.onGetWithModel(pSSysViewPanel2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSSysViewPanel, null);
        }
    }

    protected void onGetWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void jITPreview(PSSysViewPanel pSSysViewPanel) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 0, (IEntity)pSSysViewPanel, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanel, ACTION_JITPREVIEW);
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelServiceBase.this.getService(), PSSysViewPanelServiceBase.ACTION_JITPREVIEW, 40, (IEntity)pSSysViewPanel2, null).getResult() != 1) {
                    PSSysViewPanelServiceBase.this.onJITPreview(pSSysViewPanel2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_JITPREVIEW, 99, (IEntity)pSSysViewPanel, null);
        }
    }

    protected void onJITPreview(PSSysViewPanel pSSysViewPanel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[JITPREVIEW]");
    }

    public void previewSave(PSSysViewPanel pSSysViewPanel) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 0, (IEntity)pSSysViewPanel, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanel, ACTION_PREVIEWSAVE);
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelServiceBase.this.getService(), PSSysViewPanelServiceBase.ACTION_PREVIEWSAVE, 40, (IEntity)pSSysViewPanel2, null).getResult() != 1) {
                    PSSysViewPanelServiceBase.this.onPreviewSave(pSSysViewPanel2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_PREVIEWSAVE, 99, (IEntity)pSSysViewPanel, null);
        }
    }

    protected void onPreviewSave(PSSysViewPanel pSSysViewPanel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[PreviewSave]");
    }

    public void updateWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSSysViewPanel, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanel, ACTION_UPDATEWITHMODEL);
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelServiceBase.this.getService(), PSSysViewPanelServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSSysViewPanel2, null).getResult() != 1) {
                    PSSysViewPanelServiceBase.this.onUpdateWithModel(pSSysViewPanel2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSSysViewPanel, null);
        }
    }

    protected void onUpdateWithModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSSysViewPanel pSSysViewPanel, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSACHandler);
            } else {
                iService.get((IEntity)pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSSysViewPanel, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlLogicGroup);
            } else {
                iService.get((IEntity)pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysViewPanel, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysViewPanel, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSDEACTION_GETPSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_GetPSDEAction(pSSysViewPanel, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSModule);
            } else {
                iService.get((IEntity)pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysViewPanel, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSSYSAPP_PSSYSAPPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService", (SessionFactory)this.getSessionFactory());
            PSSysApp pSSysApp = (PSSysApp)iService.getDEModel().createEntity();
            pSSysApp.set("PSSYSAPPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysApp);
            } else {
                iService.get((IEntity)pSSysApp);
            }
            this.onFillParentInfo_PSSysApp(pSSysViewPanel, pSSysApp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSSYSCSS_NAVBARPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_NavBarPSSysCss(pSSysViewPanel, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSSysViewPanel, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysViewPanel, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSystem);
            } else {
                iService.get((IEntity)pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysViewPanel, pSSystem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANEL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService", (SessionFactory)this.getSessionFactory());
            PSViewMsgGroup pSViewMsgGroup = (PSViewMsgGroup)iService.getDEModel().createEntity();
            pSViewMsgGroup.set("PSVIEWMSGGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSViewMsgGroup);
            } else {
                iService.get((IEntity)pSViewMsgGroup);
            }
            this.onFillParentInfo_PSViewMsgGroup(pSSysViewPanel, pSViewMsgGroup);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysViewPanel, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSSysViewPanel pSSysViewPanel, PSACHandler pSACHandler) throws Exception {
        pSSysViewPanel.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSSysViewPanel.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSSysViewPanel pSSysViewPanel, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSSysViewPanel.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSSysViewPanel.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSDE(PSSysViewPanel pSSysViewPanel, PSDataEntity pSDataEntity) throws Exception {
        pSSysViewPanel.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysViewPanel.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_GetPSDEAction(PSSysViewPanel pSSysViewPanel, PSDEAction pSDEAction) throws Exception {
        pSSysViewPanel.setGetPSDEActionId(pSDEAction.getPSDEActionId());
        pSSysViewPanel.setGetPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSModule(PSSysViewPanel pSSysViewPanel, PSModule pSModule) throws Exception {
        pSSysViewPanel.setPSModuleId(pSModule.getPSModuleId());
        pSSysViewPanel.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysApp(PSSysViewPanel pSSysViewPanel, PSSysApp pSSysApp) throws Exception {
        pSSysViewPanel.setPSSysAppId(pSSysApp.getPSSysAppId());
        pSSysViewPanel.setPSSysAppName(pSSysApp.getPSSysAppName());
    }

    protected void onFillParentInfo_NavBarPSSysCss(PSSysViewPanel pSSysViewPanel, PSSysCss pSSysCss) throws Exception {
        pSSysViewPanel.setNavBarPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysViewPanel.setNavBarPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysCss(PSSysViewPanel pSSysViewPanel, PSSysCss pSSysCss) throws Exception {
        pSSysViewPanel.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysViewPanel.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysViewPanel pSSysViewPanel, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysViewPanel.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysViewPanel.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSystem(PSSysViewPanel pSSysViewPanel, PSSystem pSSystem) throws Exception {
        pSSysViewPanel.setPSSystemId(pSSystem.getPSSystemId());
        pSSysViewPanel.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillParentInfo_PSViewMsgGroup(PSSysViewPanel pSSysViewPanel, PSViewMsgGroup pSViewMsgGroup) throws Exception {
        pSSysViewPanel.setPSViewMsgGroupId(pSViewMsgGroup.getPSViewMsgGroupId());
        pSSysViewPanel.setPSViewMsgGroupName(pSViewMsgGroup.getPSViewMsgGroupName());
    }

    protected void onFillEntityFullInfo(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
        if (bl) {
            if (pSSysViewPanel.getMobFlag() == null) {
                pSSysViewPanel.setMobFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSSysViewPanel.getPublicFlag() == null) {
                pSSysViewPanel.setPublicFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSSysViewPanel, bl);
        this.onFillEntityFullInfo_PSACHandler(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_PSDE(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_GetPSDEAction(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_PSModule(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_PSSysApp(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_NavBarPSSysCss(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_PSSysCss(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysViewPanel, bl);
        this.onFillEntityFullInfo_PSViewMsgGroup(pSSysViewPanel, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
        if (pSSysViewPanel.isPSDEIdDirty()) {
            if (pSSysViewPanel.getPSDEId() != null) {
                if (pSSysViewPanel.getPSDEId() == null || pSSysViewPanel.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysViewPanel.getPSDE();
                    pSSysViewPanel.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysViewPanel.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_GetPSDEAction(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSModule(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysApp(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
        if (pSSysViewPanel.isPSSysAppIdDirty()) {
            if (pSSysViewPanel.getPSSysAppId() != null) {
                if (pSSysViewPanel.getPSSysAppId() == null || pSSysViewPanel.getPSSysAppName() == null) {
                    PSSysApp pSSysApp = pSSysViewPanel.getPSSysApp();
                    pSSysViewPanel.setPSSysAppName(pSSysApp.getPSSysAppName());
                }
            } else {
                pSSysViewPanel.setPSSysAppName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_NavBarPSSysCss(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
        if (pSSysViewPanel.isPSSystemIdDirty()) {
            if (pSSysViewPanel.getPSSystemId() != null) {
                if (pSSysViewPanel.getPSSystemId() == null || pSSysViewPanel.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysViewPanel.getPSSystem();
                    pSSysViewPanel.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysViewPanel.setPSSystemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSViewMsgGroup(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysViewPanel, bl);
    }

    public ArrayList<PSSysViewPanel> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanel> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanel> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanel> selectByGetPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByGetPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByGetPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanel> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanel> selectByPSSysApp(PSSysAppBase pSSysAppBase) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string) throws Exception {
        return this.selectByPSSysApp(pSSysAppBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSSysApp(PSSysAppBase pSSysAppBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanel> selectByNavBarPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByNavBarPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByNavBarPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByNavBarPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByNavBarPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("NAVBARPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByNavBarPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByNavBarPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanel> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanel> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanel> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanel> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, "", -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string) throws Exception {
        return this.selectByPSViewMsgGroup(pSViewMsgGroupBase, string, -1);
    }

    public ArrayList<PSSysViewPanel> selectByPSViewMsgGroup(PSViewMsgGroupBase pSViewMsgGroupBase, String string, int n) throws Exception {
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
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setPSACHandlerId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSSysViewPanelServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setPSCtrlLogicGroupId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysViewPanelServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setPSDEId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysViewPanelServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByGetPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSDEACTION_GETPSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByGetPSDEAction(pSDEAction);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setGetPSDEActionId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByGetPSDEAction(pSDEAction2);
                PSSysViewPanelServiceBase.this.internalRemoveByGetPSDEAction(pSDEAction2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByGetPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByGetPSDEAction(pSDEAction);
        this.onBeforeRemoveByGetPSDEAction(pSDEAction, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByGetPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByGetPSDEAction(PSDEAction pSDEAction, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSModule(pSModule);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setPSModuleId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysViewPanelServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    public void resetPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSysApp(pSSysApp);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setPSSysAppId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByPSSysApp(PSSysApp pSSysApp) throws Exception {
        final PSSysApp pSSysApp2 = pSSysApp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByPSSysApp(pSSysApp2);
                PSSysViewPanelServiceBase.this.internalRemoveByPSSysApp(pSSysApp2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByPSSysApp(pSSysApp2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void internalRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSysApp(pSSysApp);
        this.onBeforeRemoveByPSSysApp(pSSysApp, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByPSSysApp(pSSysApp, arrayList);
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp) throws Exception {
    }

    protected void onBeforeRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysApp(PSSysApp pSSysApp, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByNavBarPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSSYSCSS_NAVBARPSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByNavBarPSSysCss(pSSysCss);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setNavBarPSSysCssId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByNavBarPSSysCss(pSSysCss2);
                PSSysViewPanelServiceBase.this.internalRemoveByNavBarPSSysCss(pSSysCss2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByNavBarPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByNavBarPSSysCss(pSSysCss);
        this.onBeforeRemoveByNavBarPSSysCss(pSSysCss, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByNavBarPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByNavBarPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByNavBarPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNavBarPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setPSSysCssId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSSysViewPanelServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setPSSysPFPluginId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysViewPanelServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSystem(pSSystem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSTEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSystem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSSYSTEM_PSSYSTEMID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSSystem), arrayList.get(0)));
        }
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setPSSystemId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysViewPanelServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    public void testRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSVIEWMSGGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSViewMsgGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANEL_PSVIEWMSGGROUP_PSVIEWMSGGROUPID", "", iDataEntityModel.getName(), "PSSYSVIEWPANEL", iDataEntityModel.getDataInfo((IEntity)pSViewMsgGroup), arrayList.get(0)));
        }
    }

    public void resetPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            PSSysViewPanel pSSysViewPanel2 = (PSSysViewPanel)this.getDEModel().createEntity();
            pSSysViewPanel2.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
            pSSysViewPanel2.setPSViewMsgGroupId(null);
            this.update(pSSysViewPanel2);
        }
    }

    public void removeByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        final PSViewMsgGroup pSViewMsgGroup2 = pSViewMsgGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelServiceBase.this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysViewPanelServiceBase.this.internalRemoveByPSViewMsgGroup(pSViewMsgGroup2);
                PSSysViewPanelServiceBase.this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void internalRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
        ArrayList<PSSysViewPanel> arrayList = this.selectByPSViewMsgGroup(pSViewMsgGroup);
        this.onBeforeRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
        for (PSSysViewPanel pSSysViewPanel : arrayList) {
            this.remove((IEntity)pSSysViewPanel);
        }
        this.onAfterRemoveByPSViewMsgGroup(pSViewMsgGroup, arrayList);
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSViewMsgGroup(PSViewMsgGroup pSViewMsgGroup, ArrayList<PSSysViewPanel> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuLogicService)ServiceGlobal.getService(PSAppMenuLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSAppUtilPageService)ServiceGlobal.getService(PSAppUtilPageService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppUtilPageServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSCtrlLogicGrpDetailService)ServiceGlobal.getService(PSCtrlLogicGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSCtrlLogicGrpDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEACModeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEChartLogicService)ServiceGlobal.getService(PSDEChartLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEDataViewLogicService)ServiceGlobal.getService(PSDEDataViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEDRLogicService)ServiceGlobal.getService(PSDEDRLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByMDPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEFormLogicService)ServiceGlobal.getService(PSDEFormLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEGridLogicService)ServiceGlobal.getService(PSDEGridLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByAggPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEListLogicService)ServiceGlobal.getService(PSDEListLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEPrintService)ServiceGlobal.getService(PSDEPrintService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEPrintServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEReportService)ServiceGlobal.getService(PSDEReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEToolbarLogicService)ServiceGlobal.getService(PSDEToolbarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDETreeLogicService)ServiceGlobal.getService(PSDETreeLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).resetPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLLCondServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSPanelLLCondServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicParamServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSPanelLogicParamServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSubViewTypeService)ServiceGlobal.getService(PSSubViewTypeService.class, (SessionFactory)this.getSessionFactory());
        ((PSSubViewTypeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysBIReportServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysCalendarLogicService)ServiceGlobal.getService(PSSysCalendarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysDashboardLogicService)ServiceGlobal.getService(PSSysDashboardLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysMapLogicService)ServiceGlobal.getService(PSSysMapLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysSearchBarLogicService)ServiceGlobal.getService(PSSysSearchBarLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSDEPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).testRemoveByLayoutPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanel(pSSysViewPanel);
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanel(pSSysViewPanel);
        super.onBeforeRemove(pSSysViewPanel);
    }

    protected void onBeforeRemoveTemp(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLLCondServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLNParamServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicLinkServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicParamServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanel(pSSysViewPanel);
        super.onBeforeRemoveTemp((IEntity)pSSysViewPanel);
    }

    protected void getRelatedDataTempMajor(PSSysViewPanel pSSysViewPanel) throws Exception {
        this.getRelatedDataTempMajor_PSSysViewPanelItem(pSSysViewPanel);
        this.getRelatedDataTempMajor_PSSysViewPanelModel(pSSysViewPanel);
        this.getRelatedDataTempMajor_PSPanelItemLogic(pSSysViewPanel);
        this.getRelatedDataTempMajor_PSSysViewPanelLogic(pSSysViewPanel);
        this.getRelatedDataTempMajor_PSPanelEngine(pSSysViewPanel);
        this.getRelatedDataTempMajor_PSPanelLogicParam(pSSysViewPanel);
        this.getRelatedDataTempMajor_PSPanelLogicNode(pSSysViewPanel);
        this.getRelatedDataTempMajor_PSPanelLogicLink(pSSysViewPanel);
        this.getRelatedDataTempMajor_PSPanelLNParam(pSSysViewPanel);
        this.getRelatedDataTempMajor_PSPanelLLCond(pSSysViewPanel);
        super.getRelatedDataTempMajor((IEntity)pSSysViewPanel);
    }

    protected void getRelatedDataTempMajor_PSSysViewPanelItem(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelItem> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysViewPanelItemService.selectByPSSysViewPanel(pSSysViewPanel) : pSSysViewPanelItemService.selectTempByPSSysViewPanel(pSSysViewPanel);
        PSSysViewPanelServiceBase.sortHierarchyEntities(arrayList, (String)"PSSYSVIEWPANELITEMID", (String)"PPSSYSVIEWPANELITEMID");
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            pSSysViewPanelItemService.getTempMajor(pSSysViewPanelItem);
        }
    }

    protected void getRelatedDataTempMajor_PSSysViewPanelModel(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelModel> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysViewPanelModelService.selectByPSSysViewPanel(pSSysViewPanel) : pSSysViewPanelModelService.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            pSSysViewPanelModelService.getTempMajor(pSSysViewPanelModel);
        }
    }

    protected void getRelatedDataTempMajor_PSPanelItemLogic(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelItemLogic> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelItemLogicService.selectByPSSysViewPanel(pSSysViewPanel) : pSPanelItemLogicService.selectTempByPSSysViewPanel(pSSysViewPanel);
        PSSysViewPanelServiceBase.sortHierarchyEntities(arrayList, (String)"PSPANELITEMLOGICID", (String)"PPSPANELITEMLOGICID");
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            pSPanelItemLogicService.getTempMajor(pSPanelItemLogic);
        }
    }

    protected void getRelatedDataTempMajor_PSSysViewPanelLogic(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelLogic> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysViewPanelLogicService.selectByPSSysViewPanel(pSSysViewPanel) : pSSysViewPanelLogicService.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            pSSysViewPanelLogicService.getTempMajor(pSSysViewPanelLogic);
        }
    }

    protected void getRelatedDataTempMajor_PSPanelEngine(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSPanelEngineService pSPanelEngineService = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelEngine> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelEngineService.selectByPSSysViewPanel(pSSysViewPanel) : pSPanelEngineService.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelEngine pSPanelEngine : arrayList) {
            pSPanelEngineService.getTempMajor(pSPanelEngine);
        }
    }

    protected void getRelatedDataTempMajor_PSPanelLogicParam(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicParam> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicParamService.selectByPSSysViewPanel(pSSysViewPanel) : pSPanelLogicParamService.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            pSPanelLogicParamService.getTempMajor(pSPanelLogicParam);
        }
    }

    protected void getRelatedDataTempMajor_PSPanelLogicNode(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicNode> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicNodeService.selectByPSSysViewPanel(pSSysViewPanel) : pSPanelLogicNodeService.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            pSPanelLogicNodeService.getTempMajor(pSPanelLogicNode);
        }
    }

    protected void getRelatedDataTempMajor_PSPanelLogicLink(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicLink> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicLinkService.selectByPSSysViewPanel(pSSysViewPanel) : pSPanelLogicLinkService.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            pSPanelLogicLinkService.getTempMajor(pSPanelLogicLink);
        }
    }

    protected void getRelatedDataTempMajor_PSPanelLNParam(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLNParam> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLNParamService.selectByPSSysViewPanel(pSSysViewPanel) : pSPanelLNParamService.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            pSPanelLNParamService.getTempMajor(pSPanelLNParam);
        }
    }

    protected void getRelatedDataTempMajor_PSPanelLLCond(PSSysViewPanel pSSysViewPanel) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLLCond> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLLCondService.selectByPSSysViewPanel(pSSysViewPanel) : pSPanelLLCondService.selectTempByPSSysViewPanel(pSSysViewPanel);
        PSSysViewPanelServiceBase.sortHierarchyEntities(arrayList, (String)"PSPANELLLCONDID", (String)"PPSPANELLLCONDID");
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            pSPanelLLCondService.getTempMajor(pSPanelLLCond);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        ArrayList<PSPanelLLCond> arrayList = this.updateRelatedDataTempMajor_removePSPanelLLCond(pSSysViewPanel, pSSysViewPanel2);
        ArrayList<PSPanelLNParam> arrayList2 = this.updateRelatedDataTempMajor_removePSPanelLNParam(pSSysViewPanel, pSSysViewPanel2);
        ArrayList<PSPanelLogicLink> arrayList3 = this.updateRelatedDataTempMajor_removePSPanelLogicLink(pSSysViewPanel, pSSysViewPanel2);
        ArrayList<PSPanelLogicNode> arrayList4 = this.updateRelatedDataTempMajor_removePSPanelLogicNode(pSSysViewPanel, pSSysViewPanel2);
        ArrayList<PSPanelLogicParam> arrayList5 = this.updateRelatedDataTempMajor_removePSPanelLogicParam(pSSysViewPanel, pSSysViewPanel2);
        ArrayList<PSPanelEngine> arrayList6 = this.updateRelatedDataTempMajor_removePSPanelEngine(pSSysViewPanel, pSSysViewPanel2);
        ArrayList<PSSysViewPanelLogic> arrayList7 = this.updateRelatedDataTempMajor_removePSSysViewPanelLogic(pSSysViewPanel, pSSysViewPanel2);
        ArrayList<PSPanelItemLogic> arrayList8 = this.updateRelatedDataTempMajor_removePSPanelItemLogic(pSSysViewPanel, pSSysViewPanel2);
        ArrayList<PSSysViewPanelModel> arrayList9 = this.updateRelatedDataTempMajor_removePSSysViewPanelModel(pSSysViewPanel, pSSysViewPanel2);
        ArrayList<PSSysViewPanelItem> arrayList10 = this.updateRelatedDataTempMajor_removePSSysViewPanelItem(pSSysViewPanel, pSSysViewPanel2);
        this.updateRelatedDataTempMajor_updatePSSysViewPanelItem(pSSysViewPanel, pSSysViewPanel2, arrayList10);
        this.updateRelatedDataTempMajor_updatePSSysViewPanelModel(pSSysViewPanel, pSSysViewPanel2, arrayList9);
        this.updateRelatedDataTempMajor_updatePSPanelItemLogic(pSSysViewPanel, pSSysViewPanel2, arrayList8);
        this.updateRelatedDataTempMajor_updatePSSysViewPanelLogic(pSSysViewPanel, pSSysViewPanel2, arrayList7);
        this.updateRelatedDataTempMajor_updatePSPanelEngine(pSSysViewPanel, pSSysViewPanel2, arrayList6);
        this.updateRelatedDataTempMajor_updatePSPanelLogicParam(pSSysViewPanel, pSSysViewPanel2, arrayList5);
        this.updateRelatedDataTempMajor_updatePSPanelLogicNode(pSSysViewPanel, pSSysViewPanel2, arrayList4);
        this.updateRelatedDataTempMajor_updatePSPanelLogicLink(pSSysViewPanel, pSSysViewPanel2, arrayList3);
        this.updateRelatedDataTempMajor_updatePSPanelLNParam(pSSysViewPanel, pSSysViewPanel2, arrayList2);
        this.updateRelatedDataTempMajor_updatePSPanelLLCond(pSSysViewPanel, pSSysViewPanel2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysViewPanel, (IEntity)pSSysViewPanel2);
    }

    protected ArrayList<PSSysViewPanelItem> updateRelatedDataTempMajor_removePSSysViewPanelItem(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelItem> arrayList = pSSysViewPanelItemService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSSysViewPanelItem> arrayList2 = pSSysViewPanelItemService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSSysViewPanelItem> hashMap = new HashMap<String, PSSysViewPanelItem>();
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList2) {
            hashMap.put(pSSysViewPanelItem.getPSSysViewPanelItemId(), pSSysViewPanelItem);
        }
        PSSysViewPanelServiceBase.sortHierarchyEntities(arrayList, (String)"PSSYSVIEWPANELITEMID", (String)"PPSSYSVIEWPANELITEMID");
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            Object object = pSSysViewPanelItem.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysViewPanelItem pSSysViewPanelItem : hashMap.values()) {
            pSSysViewPanelItemService.remove((IEntity)pSSysViewPanelItem);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysViewPanelItem(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            pSSysViewPanelItemService.updateTempMajor(pSSysViewPanelItem);
        }
    }

    protected ArrayList<PSSysViewPanelModel> updateRelatedDataTempMajor_removePSSysViewPanelModel(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelModel> arrayList = pSSysViewPanelModelService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSSysViewPanelModel> arrayList2 = pSSysViewPanelModelService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSSysViewPanelModel> hashMap = new HashMap<String, PSSysViewPanelModel>();
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList2) {
            hashMap.put(pSSysViewPanelModel.getPSSysViewPanelModelId(), pSSysViewPanelModel);
        }
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            Object object = pSSysViewPanelModel.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysViewPanelModel pSSysViewPanelModel : hashMap.values()) {
            pSSysViewPanelModelService.remove((IEntity)pSSysViewPanelModel);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysViewPanelModel(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSSysViewPanelModel> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            pSSysViewPanelModelService.updateTempMajor(pSSysViewPanelModel);
        }
    }

    protected ArrayList<PSPanelItemLogic> updateRelatedDataTempMajor_removePSPanelItemLogic(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelItemLogic> arrayList = pSPanelItemLogicService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSPanelItemLogic> arrayList2 = pSPanelItemLogicService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSPanelItemLogic> hashMap = new HashMap<String, PSPanelItemLogic>();
        for (PSPanelItemLogic pSPanelItemLogic : arrayList2) {
            hashMap.put(pSPanelItemLogic.getPSPanelItemLogicId(), pSPanelItemLogic);
        }
        PSSysViewPanelServiceBase.sortHierarchyEntities(arrayList, (String)"PSPANELITEMLOGICID", (String)"PPSPANELITEMLOGICID");
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            Object object = pSPanelItemLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelItemLogic pSPanelItemLogic : hashMap.values()) {
            pSPanelItemLogicService.remove((IEntity)pSPanelItemLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelItemLogic(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            pSPanelItemLogicService.updateTempMajor(pSPanelItemLogic);
        }
    }

    protected ArrayList<PSSysViewPanelLogic> updateRelatedDataTempMajor_removePSSysViewPanelLogic(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelLogic> arrayList = pSSysViewPanelLogicService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSSysViewPanelLogic> arrayList2 = pSSysViewPanelLogicService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSSysViewPanelLogic> hashMap = new HashMap<String, PSSysViewPanelLogic>();
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList2) {
            hashMap.put(pSSysViewPanelLogic.getPSSysViewPanelLogicId(), pSSysViewPanelLogic);
        }
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            Object object = pSSysViewPanelLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSSysViewPanelLogic pSSysViewPanelLogic : hashMap.values()) {
            pSSysViewPanelLogicService.remove((IEntity)pSSysViewPanelLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSSysViewPanelLogic(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSSysViewPanelLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
            pSSysViewPanelLogicService.updateTempMajor(pSSysViewPanelLogic);
        }
    }

    protected ArrayList<PSPanelEngine> updateRelatedDataTempMajor_removePSPanelEngine(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSPanelEngineService pSPanelEngineService = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelEngine> arrayList = pSPanelEngineService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSPanelEngine> arrayList2 = pSPanelEngineService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSPanelEngine> hashMap = new HashMap<String, PSPanelEngine>();
        for (PSPanelEngine pSPanelEngine : arrayList2) {
            hashMap.put(pSPanelEngine.getPSPanelEngineId(), pSPanelEngine);
        }
        for (PSPanelEngine pSPanelEngine : arrayList) {
            Object object = pSPanelEngine.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelEngine pSPanelEngine : hashMap.values()) {
            pSPanelEngineService.remove((IEntity)pSPanelEngine);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelEngine(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSPanelEngine> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelEngineService pSPanelEngineService = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelEngine pSPanelEngine : arrayList) {
            pSPanelEngineService.updateTempMajor(pSPanelEngine);
        }
    }

    protected ArrayList<PSPanelLogicParam> updateRelatedDataTempMajor_removePSPanelLogicParam(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicParam> arrayList = pSPanelLogicParamService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSPanelLogicParam> arrayList2 = pSPanelLogicParamService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSPanelLogicParam> hashMap = new HashMap<String, PSPanelLogicParam>();
        for (PSPanelLogicParam pSPanelLogicParam : arrayList2) {
            hashMap.put(pSPanelLogicParam.getPSPanelLogicParamId(), pSPanelLogicParam);
        }
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            Object object = pSPanelLogicParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLogicParam pSPanelLogicParam : hashMap.values()) {
            pSPanelLogicParamService.remove((IEntity)pSPanelLogicParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLogicParam(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSPanelLogicParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
            pSPanelLogicParamService.updateTempMajor(pSPanelLogicParam);
        }
    }

    protected ArrayList<PSPanelLogicNode> updateRelatedDataTempMajor_removePSPanelLogicNode(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicNode> arrayList = pSPanelLogicNodeService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSPanelLogicNode> arrayList2 = pSPanelLogicNodeService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSPanelLogicNode> hashMap = new HashMap<String, PSPanelLogicNode>();
        for (PSPanelLogicNode pSPanelLogicNode : arrayList2) {
            hashMap.put(pSPanelLogicNode.getPSPanelLogicNodeId(), pSPanelLogicNode);
        }
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            Object object = pSPanelLogicNode.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLogicNode pSPanelLogicNode : hashMap.values()) {
            pSPanelLogicNodeService.remove((IEntity)pSPanelLogicNode);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLogicNode(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSPanelLogicNode> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
            pSPanelLogicNodeService.updateTempMajor(pSPanelLogicNode);
        }
    }

    protected ArrayList<PSPanelLogicLink> updateRelatedDataTempMajor_removePSPanelLogicLink(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicLink> arrayList = pSPanelLogicLinkService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSPanelLogicLink> arrayList2 = pSPanelLogicLinkService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSPanelLogicLink> hashMap = new HashMap<String, PSPanelLogicLink>();
        for (PSPanelLogicLink pSPanelLogicLink : arrayList2) {
            hashMap.put(pSPanelLogicLink.getPSPanelLogicLinkId(), pSPanelLogicLink);
        }
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            Object object = pSPanelLogicLink.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLogicLink pSPanelLogicLink : hashMap.values()) {
            pSPanelLogicLinkService.remove((IEntity)pSPanelLogicLink);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLogicLink(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSPanelLogicLink> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
            pSPanelLogicLinkService.updateTempMajor(pSPanelLogicLink);
        }
    }

    protected ArrayList<PSPanelLNParam> updateRelatedDataTempMajor_removePSPanelLNParam(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLNParam> arrayList = pSPanelLNParamService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSPanelLNParam> arrayList2 = pSPanelLNParamService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSPanelLNParam> hashMap = new HashMap<String, PSPanelLNParam>();
        for (PSPanelLNParam pSPanelLNParam : arrayList2) {
            hashMap.put(pSPanelLNParam.getPSPanelLNParamId(), pSPanelLNParam);
        }
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            Object object = pSPanelLNParam.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLNParam pSPanelLNParam : hashMap.values()) {
            pSPanelLNParamService.remove((IEntity)pSPanelLNParam);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLNParam(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSPanelLNParam> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLNParam pSPanelLNParam : arrayList) {
            pSPanelLNParamService.updateTempMajor(pSPanelLNParam);
        }
    }

    protected ArrayList<PSPanelLLCond> updateRelatedDataTempMajor_removePSPanelLLCond(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLLCond> arrayList = pSPanelLLCondService.selectTempByPSSysViewPanel(pSSysViewPanel);
        ArrayList<PSPanelLLCond> arrayList2 = pSPanelLLCondService.selectByPSSysViewPanel(pSSysViewPanel2);
        HashMap<String, PSPanelLLCond> hashMap = new HashMap<String, PSPanelLLCond>();
        for (PSPanelLLCond pSPanelLLCond : arrayList2) {
            hashMap.put(pSPanelLLCond.getPSPanelLLCondId(), pSPanelLLCond);
        }
        PSSysViewPanelServiceBase.sortHierarchyEntities(arrayList, (String)"PSPANELLLCONDID", (String)"PPSPANELLLCONDID");
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            Object object = pSPanelLLCond.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelLLCond pSPanelLLCond : hashMap.values()) {
            pSPanelLLCondService.remove((IEntity)pSPanelLLCond);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelLLCond(PSSysViewPanel pSSysViewPanel, PSSysViewPanel pSSysViewPanel2, ArrayList<PSPanelLLCond> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelLLCond pSPanelLLCond : arrayList) {
            pSPanelLLCondService.updateTempMajor(pSPanelLLCond);
        }
    }

    protected void replaceParentInfo(PSSysViewPanel pSSysViewPanel, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysViewPanel, cloneSession);
        if (pSSysViewPanel.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSSysViewPanel.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSSysViewPanel, (PSACHandler)iEntity);
        }
        if (pSSysViewPanel.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSSysViewPanel.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysViewPanel, (PSCtrlLogicGroup)iEntity);
        }
        if (pSSysViewPanel.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysViewPanel.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysViewPanel, (PSDataEntity)iEntity);
        }
        if (pSSysViewPanel.getGetPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysViewPanel.getGetPSDEActionId())) != null) {
            this.onFillParentInfo_GetPSDEAction(pSSysViewPanel, (PSDEAction)iEntity);
        }
        if (pSSysViewPanel.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysViewPanel.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysViewPanel, (PSModule)iEntity);
        }
        if (pSSysViewPanel.getPSSysAppId() != null && (iEntity = cloneSession.getEntity("PSSYSAPP", (Object)pSSysViewPanel.getPSSysAppId())) != null) {
            this.onFillParentInfo_PSSysApp(pSSysViewPanel, (PSSysApp)iEntity);
        }
        if (pSSysViewPanel.getNavBarPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysViewPanel.getNavBarPSSysCssId())) != null) {
            this.onFillParentInfo_NavBarPSSysCss(pSSysViewPanel, (PSSysCss)iEntity);
        }
        if (pSSysViewPanel.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysViewPanel.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSSysViewPanel, (PSSysCss)iEntity);
        }
        if (pSSysViewPanel.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysViewPanel.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysViewPanel, (PSSysPFPlugin)iEntity);
        }
        if (pSSysViewPanel.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysViewPanel.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysViewPanel, (PSSystem)iEntity);
        }
        if (pSSysViewPanel.getPSViewMsgGroupId() != null && (iEntity = cloneSession.getEntity("PSVIEWMSGGROUP", (Object)pSSysViewPanel.getPSViewMsgGroupId())) != null) {
            this.onFillParentInfo_PSViewMsgGroup(pSSysViewPanel, (PSViewMsgGroup)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysViewPanel, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BodyOnlyFlag(bl, pSSysViewPanel, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataName(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePageFooter(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnablePageHeader(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetDataMode(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetDataTimer(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetPSDEActionId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutCat(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutMode(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MobFlag(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarHeight(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarPos(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarPSSysCssId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarStyle(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NavBarWidth(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerTag(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerType(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageFormat(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageHeight(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageMarginBottom(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageMarginLeft(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageMarginRight(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageMarginTop(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PageWidth(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelHeight(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelModel(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelNavBar(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelStyle(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PanelWidth(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPI(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysAppName(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelName(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSViewMsgGroupId(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PublicFlag(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowFooterFirstPage(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowHeaderFirstPage(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SysAppFlag(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToDoTask(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ViewLayoutFlag(bl, pSSysViewPanel, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysViewPanel, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BodyOnlyFlag(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isBodyOnlyFlagDirty() : !pSSysViewPanel.isBodyOnlyFlagDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getBodyOnlyFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BodyOnlyFlag_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BODYONLYFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isCodeNameDirty() : !pSSysViewPanel.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default((IEntity)pSSysViewPanel, bl2, bl3);
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
                String string4 = this.checkFieldDupRule(this.getPSSysViewPanelDEModel(), "CODENAME", string3, pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataName(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isDataNameDirty() : !pSSysViewPanel.isDataNameDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getDataName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataName_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATANAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnablePageFooter(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isEnablePageFooterDirty() : !pSSysViewPanel.isEnablePageFooterDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getEnablePageFooter();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePageFooter_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPAGEFOOTER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnablePageHeader(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isEnablePageHeaderDirty() : !pSSysViewPanel.isEnablePageHeaderDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getEnablePageHeader();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnablePageHeader_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEPAGEHEADER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetDataMode(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isGetDataModeDirty() : !pSSysViewPanel.isGetDataModeDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getGetDataMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GetDataMode_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETDATAMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetDataTimer(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isGetDataTimerDirty() : !pSSysViewPanel.isGetDataTimerDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getGetDataTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GetDataTimer_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GETDATATIMER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetPSDEActionId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isGetPSDEActionIdDirty() : !pSSysViewPanel.isGetPSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getGetPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_GetPSDEActionId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_LayoutCat(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isLayoutCatDirty() : !pSSysViewPanel.isLayoutCatDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getLayoutCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutCat_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTCAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LayoutMode(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isLayoutModeDirty() : !pSSysViewPanel.isLayoutModeDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getLayoutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutMode_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LAYOUTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isMemoDirty() : !pSSysViewPanel.isMemoDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_MobFlag(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isMobFlagDirty() && !bl2 : !pSSysViewPanel.isMobFlagDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getMobFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MOBFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_MobFlag_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_NavBarHeight(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isNavBarHeightDirty() : !pSSysViewPanel.isNavBarHeightDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getNavBarHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavBarHeight_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavBarPos(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isNavBarPosDirty() : !pSSysViewPanel.isNavBarPosDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getNavBarPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavBarPos_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavBarPSSysCssId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isNavBarPSSysCssIdDirty() : !pSSysViewPanel.isNavBarPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getNavBarPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavBarPSSysCssId_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavBarStyle(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isNavBarStyleDirty() : !pSSysViewPanel.isNavBarStyleDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getNavBarStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NavBarStyle_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_NavBarWidth(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isNavBarWidthDirty() : !pSSysViewPanel.isNavBarWidthDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getNavBarWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_NavBarWidth_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("NAVBARWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isOwnerIdDirty() : !pSSysViewPanel.isOwnerIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getOwnerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerId_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerTag(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isOwnerTagDirty() : !pSSysViewPanel.isOwnerTagDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getOwnerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerTag_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERTAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OwnerType(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isOwnerTypeDirty() : !pSSysViewPanel.isOwnerTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getOwnerType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerType_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OWNERTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageFormat(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPageFormatDirty() : !pSSysViewPanel.isPageFormatDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPageFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PageFormat_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageHeight(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPageHeightDirty() : !pSSysViewPanel.isPageHeightDirty()) {
            return null;
        }
        Double d = pSSysViewPanel.getPageHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PageHeight_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageMarginBottom(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPageMarginBottomDirty() : !pSSysViewPanel.isPageMarginBottomDirty()) {
            return null;
        }
        Double d = pSSysViewPanel.getPageMarginBottom();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PageMarginBottom_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEMARGINBOTTOM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageMarginLeft(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPageMarginLeftDirty() : !pSSysViewPanel.isPageMarginLeftDirty()) {
            return null;
        }
        Double d = pSSysViewPanel.getPageMarginLeft();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PageMarginLeft_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEMARGINLEFT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageMarginRight(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPageMarginRightDirty() : !pSSysViewPanel.isPageMarginRightDirty()) {
            return null;
        }
        Double d = pSSysViewPanel.getPageMarginRight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PageMarginRight_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEMARGINRIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageMarginTop(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPageMarginTopDirty() : !pSSysViewPanel.isPageMarginTopDirty()) {
            return null;
        }
        Double d = pSSysViewPanel.getPageMarginTop();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PageMarginTop_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEMARGINTOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PageWidth(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPageWidthDirty() : !pSSysViewPanel.isPageWidthDirty()) {
            return null;
        }
        Double d = pSSysViewPanel.getPageWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PageWidth_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PAGEWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelHeight(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPanelHeightDirty() : !pSSysViewPanel.isPanelHeightDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getPanelHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PanelHeight_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelModel(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPanelModelDirty() : !pSSysViewPanel.isPanelModelDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPanelModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PanelModel_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelNavBar(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPanelNavBarDirty() : !pSSysViewPanel.isPanelNavBarDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getPanelNavBar();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PanelNavBar_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELNAVBAR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelStyle(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPanelStyleDirty() : !pSSysViewPanel.isPanelStyleDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPanelStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PanelStyle_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PanelWidth(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPanelWidthDirty() : !pSSysViewPanel.isPanelWidthDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getPanelWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PanelWidth_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PANELWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPI(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPPIDirty() : !pSSysViewPanel.isPPIDirty()) {
            return null;
        }
        Double d = pSSysViewPanel.getPPI();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PPI_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPI");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSACHandlerIdDirty() : !pSSysViewPanel.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSCtrlLogicGroupIdDirty() : !pSSysViewPanel.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSDEIdDirty() : !pSSysViewPanel.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSDENameDirty() : !pSSysViewPanel.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSModuleIdDirty() : !pSSysViewPanel.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSSysAppIdDirty() : !pSSysViewPanel.isPSSysAppIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSSysAppId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysAppName(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSSysAppNameDirty() : !pSSysViewPanel.isPSSysAppNameDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSSysAppName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysAppName_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSAPPNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSSysCssIdDirty() : !pSSysViewPanel.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSSysPFPluginIdDirty() : !pSSysViewPanel.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSSystemIdDirty() && !bl2 : !pSSysViewPanel.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSSystemNameDirty() : !pSSysViewPanel.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSSystemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSSysViewPanelIdDirty() && !bl2 : !pSSysViewPanel.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelName(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSSysViewPanelNameDirty() && !bl2 : !pSSysViewPanel.isPSSysViewPanelNameDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSSysViewPanelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelName_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSViewMsgGroupId(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPSViewMsgGroupIdDirty() : !pSSysViewPanel.isPSViewMsgGroupIdDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getPSViewMsgGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSViewMsgGroupId_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_PublicFlag(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isPublicFlagDirty() : !pSSysViewPanel.isPublicFlagDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getPublicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PublicFlag_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PUBLICFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowFooterFirstPage(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isShowFooterFirstPageDirty() : !pSSysViewPanel.isShowFooterFirstPageDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getShowFooterFirstPage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowFooterFirstPage_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWFOOTERFIRSTPAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowHeaderFirstPage(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isShowHeaderFirstPageDirty() : !pSSysViewPanel.isShowHeaderFirstPageDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getShowHeaderFirstPage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowHeaderFirstPage_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWHEADERFIRSTPAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SysAppFlag(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isSysAppFlagDirty() : !pSSysViewPanel.isSysAppFlagDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getSysAppFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_SysAppFlag_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_ToDoTask(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isToDoTaskDirty() : !pSSysViewPanel.isToDoTaskDirty()) {
            return null;
        }
        String string = pSSysViewPanel.getToDoTask();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToDoTask_Default((IEntity)pSSysViewPanel, bl2, bl3);
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

    protected EntityFieldError onCheckField_ViewLayoutFlag(boolean bl, PSSysViewPanel pSSysViewPanel, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanel.isViewLayoutFlagDirty() && !bl2 : !pSSysViewPanel.isViewLayoutFlagDirty()) {
            return null;
        }
        Integer n = pSSysViewPanel.getViewLayoutFlag();
        if (bl) {
            if (bl2 && n == null) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWLAYOUTFLAG");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string = null;
            string = this.onTestValueRule_ViewLayoutFlag_Default((IEntity)pSSysViewPanel, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VIEWLAYOUTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysViewPanel, bl);
    }

    protected void onSyncIndexEntities(PSSysViewPanel pSSysViewPanel, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysViewPanel, bl);
    }

    public Object getDataContextValue(PSSysViewPanel pSSysViewPanel, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSSysViewPanel, string, iDataContextParam)) != null) {
            return object;
        }
        return null;
    }

    protected void onExportMajorModel(PSSysViewPanel pSSysViewPanel, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysViewPanel, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BODYONLYFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BodyOnlyFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"DATANAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPAGEFOOTER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePageFooter_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEPAGEHEADER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnablePageHeader_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETDATAMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetDataMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETDATATIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetDataTimer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETPSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetPSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETPSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetPSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTCAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutCat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NAVBARWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NavBarWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OWNERTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OwnerType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEMARGINBOTTOM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageMarginBottom_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEMARGINLEFT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageMarginLeft_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEMARGINRIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageMarginRight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEMARGINTOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageMarginTop_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PAGEWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PageWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELNAVBAR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelNavBar_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PANELWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PanelWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPI", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPI_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEId_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PUBLICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PublicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWFOOTERFIRSTPAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowFooterFirstPage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWHEADERFIRSTPAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowHeaderFirstPage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SYSAPPFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SysAppFlag_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VIEWLAYOUTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ViewLayoutFlag_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BodyOnlyFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CodeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CODENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("CODENAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_DataName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATANAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EnablePageFooter_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnablePageHeader_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GetDataMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GetDataTimer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_LayoutCat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTCAT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LayoutMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LAYOUTMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_NavBarHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NavBarPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVBARPOS", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavBarPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVBARPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavBarPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVBARPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavBarStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("NAVBARSTYLE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_NavBarWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OwnerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OwnerTag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERTAG", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OwnerType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OWNERTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PageFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PAGEFORMAT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PageHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PageMarginBottom_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PageMarginLeft_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PageMarginRight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PageMarginTop_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PageWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PanelHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PanelModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PANELMODEL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PanelNavBar_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PanelStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PANELSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PanelWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_PPI_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_PublicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowFooterFirstPage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowHeaderFirstPage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SysAppFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_ViewLayoutFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysViewPanel pSSysViewPanel) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysViewPanel)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysViewPanel pSSysViewPanel) throws Exception {
        super.onUpdateParent((IEntity)pSSysViewPanel);
    }

    protected void onCopyDetails(PSSysViewPanel pSSysViewPanel, Object object) throws Exception {
        PSSysViewPanel pSSysViewPanel2 = new PSSysViewPanel();
        pSSysViewPanel2.set("PSSYSVIEWPANELID", object);
        String string = DataObject.getStringValue((Object)pSSysViewPanel.get("PSSYSVIEWPANELID"));
        super.onCopyDetails((IEntity)pSSysViewPanel, object);
    }

    @Override
    protected void exportCurXmlModel(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSVIEWPANEL");
        if (!bl) {
            pSSysViewPanel.setCreateDate(null);
            pSSysViewPanel.setCreateMan(null);
            pSSysViewPanel.setPSSysViewPanelId(null);
            pSSysViewPanel.setUpdateDate(null);
            pSSysViewPanel.setUpdateMan(null);
            super.exportCurXmlModel(pSSysViewPanel, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysViewPanelItem(pSSysViewPanel, xmlNode);
        this.exportRelatedXmlModel_PSSysViewPanelModel(pSSysViewPanel, xmlNode);
        this.exportRelatedXmlModel_PSPanelItemLogic(pSSysViewPanel, xmlNode);
        this.exportRelatedXmlModel_PSSysViewPanelLogic(pSSysViewPanel, xmlNode);
        this.exportRelatedXmlModel_PSPanelEngine(pSSysViewPanel, xmlNode);
        this.exportRelatedXmlModel_PSPanelLogicParam(pSSysViewPanel, xmlNode);
        this.exportRelatedXmlModel_PSPanelLogicNode(pSSysViewPanel, xmlNode);
        this.exportRelatedXmlModel_PSPanelLogicLink(pSSysViewPanel, xmlNode);
        this.exportRelatedXmlModel_PSPanelLNParam(pSSysViewPanel, xmlNode);
        this.exportRelatedXmlModel_PSPanelLLCond(pSSysViewPanel, xmlNode);
        super.onExportRelatedXmlModel(pSSysViewPanel, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysViewPanelItem(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelItem> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysViewPanelItemService.selectByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC") : pSSysViewPanelItemService.selectTempByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSVIEWPANELITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
                if (pSSysViewPanelItem.getPPSSysViewPanelItemId() != null) continue;
                pSSysViewPanelItem.set("ORDERVALUE", null);
                pSSysViewPanelItemService.exportXmlModel(pSSysViewPanelItem, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSSysViewPanelModel(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelModel> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysViewPanelModelService.selectByPSSysViewPanel(pSSysViewPanel) : pSSysViewPanelModelService.selectTempByPSSysViewPanel(pSSysViewPanel);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSVIEWPANELMODELS");
            xmlNode.addNode(xmlNode2);
            for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
                pSSysViewPanelModelService.exportXmlModel(pSSysViewPanelModel, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelItemLogic(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelItemLogic> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelItemLogicService.selectByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC") : pSPanelItemLogicService.selectTempByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELITEMLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
                if (pSPanelItemLogic.getPPSPanelItemLogicId() != null) continue;
                pSPanelItemLogic.set("ORDERVALUE", null);
                pSPanelItemLogicService.exportXmlModel(pSPanelItemLogic, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSSysViewPanelLogic(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelLogic> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysViewPanelLogicService.selectByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC") : pSSysViewPanelLogicService.selectTempByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSVIEWPANELLOGICS");
            xmlNode.addNode(xmlNode2);
            for (PSSysViewPanelLogic pSSysViewPanelLogic : arrayList) {
                pSSysViewPanelLogic.set("ORDERVALUE", null);
                pSSysViewPanelLogicService.exportXmlModel(pSSysViewPanelLogic, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelEngine(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSPanelEngineService pSPanelEngineService = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelEngine> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelEngineService.selectByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC") : pSPanelEngineService.selectTempByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELENGINES");
            xmlNode.addNode(xmlNode2);
            for (PSPanelEngine pSPanelEngine : arrayList) {
                pSPanelEngine.set("ORDERVALUE", null);
                pSPanelEngineService.exportXmlModel(pSPanelEngine, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelLogicParam(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicParam> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicParamService.selectByPSSysViewPanel(pSSysViewPanel) : pSPanelLogicParamService.selectTempByPSSysViewPanel(pSSysViewPanel);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLOGICPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLogicParam pSPanelLogicParam : arrayList) {
                pSPanelLogicParamService.exportXmlModel(pSPanelLogicParam, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelLogicNode(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicNode> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicNodeService.selectByPSSysViewPanel(pSSysViewPanel) : pSPanelLogicNodeService.selectTempByPSSysViewPanel(pSSysViewPanel);
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLOGICNODES");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLogicNode pSPanelLogicNode : arrayList) {
                pSPanelLogicNodeService.exportXmlModel(pSPanelLogicNode, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelLogicLink(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLogicLink> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLogicLinkService.selectByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC") : pSPanelLogicLinkService.selectTempByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLOGICLINKS");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLogicLink pSPanelLogicLink : arrayList) {
                pSPanelLogicLink.set("ORDERVALUE", null);
                pSPanelLogicLinkService.exportXmlModel(pSPanelLogicLink, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelLNParam(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLNParam> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLNParamService.selectByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC") : pSPanelLNParamService.selectTempByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLNPARAMS");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLNParam pSPanelLNParam : arrayList) {
                pSPanelLNParam.set("ORDERVALUE", null);
                pSPanelLNParamService.exportXmlModel(pSPanelLNParam, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelLLCond(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelLLCond> arrayList = null;
        String string = pSSysViewPanel.getPSSysViewPanelId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelLLCondService.selectByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC") : pSPanelLLCondService.selectTempByPSSysViewPanel(pSSysViewPanel, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSPANELLLCONDS");
            xmlNode.addNode(xmlNode2);
            for (PSPanelLLCond pSPanelLLCond : arrayList) {
                if (pSPanelLLCond.getPPSPanelLLCondId() != null) continue;
                pSPanelLLCond.set("ORDERVALUE", null);
                pSPanelLLCondService.exportXmlModel(pSPanelLLCond, xmlNode2);
            }
        }
    }

    @Override
    protected void onImportRelatedXmlModel(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSVIEWPANELITEMS");
        this.importRelatedXmlModel_PSSysViewPanelItem(pSSysViewPanel, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSSYSVIEWPANELMODELS");
        this.importRelatedXmlModel_PSSysViewPanelModel(pSSysViewPanel, xmlNode3);
        XmlNode xmlNode4 = xmlNode.getChildNodeByNodeName("PSPANELITEMLOGICS");
        this.importRelatedXmlModel_PSPanelItemLogic(pSSysViewPanel, xmlNode4);
        XmlNode xmlNode5 = xmlNode.getChildNodeByNodeName("PSSYSVIEWPANELLOGICS");
        this.importRelatedXmlModel_PSSysViewPanelLogic(pSSysViewPanel, xmlNode5);
        XmlNode xmlNode6 = xmlNode.getChildNodeByNodeName("PSPANELENGINES");
        this.importRelatedXmlModel_PSPanelEngine(pSSysViewPanel, xmlNode6);
        XmlNode xmlNode7 = xmlNode.getChildNodeByNodeName("PSPANELLOGICPARAMS");
        this.importRelatedXmlModel_PSPanelLogicParam(pSSysViewPanel, xmlNode7);
        XmlNode xmlNode8 = xmlNode.getChildNodeByNodeName("PSPANELLOGICNODES");
        this.importRelatedXmlModel_PSPanelLogicNode(pSSysViewPanel, xmlNode8);
        XmlNode xmlNode9 = xmlNode.getChildNodeByNodeName("PSPANELLOGICLINKS");
        this.importRelatedXmlModel_PSPanelLogicLink(pSSysViewPanel, xmlNode9);
        XmlNode xmlNode10 = xmlNode.getChildNodeByNodeName("PSPANELLNPARAMS");
        this.importRelatedXmlModel_PSPanelLNParam(pSSysViewPanel, xmlNode10);
        XmlNode xmlNode11 = xmlNode.getChildNodeByNodeName("PSPANELLLCONDS");
        this.importRelatedXmlModel_PSPanelLLCond(pSSysViewPanel, xmlNode11);
        super.onImportRelatedXmlModel(pSSysViewPanel, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysViewPanelItem(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysViewPanelItemService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSSysViewPanelItemService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setOrderValue(n);
                n += 100;
                pSSysViewPanelItemService.fillParentInfo((IEntity)pSSysViewPanelItem, "DER1N", "DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSSysViewPanelItemService.importXmlModel(pSSysViewPanelItem, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSSysViewPanelModel(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysViewPanelModelService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSSysViewPanelModelService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysViewPanelModel pSSysViewPanelModel = new PSSysViewPanelModel();
                pSSysViewPanelModelService.fillParentInfo((IEntity)pSSysViewPanelModel, "DER1N", "DER1N_PSSYSVIEWPANELMODEL_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSSysViewPanelModelService.importXmlModel(pSSysViewPanelModel, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelItemLogic(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelItemLogicService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSPanelItemLogicService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelItemLogic pSPanelItemLogic = new PSPanelItemLogic();
                pSPanelItemLogic.setOrderValue(n);
                n += 100;
                pSPanelItemLogicService.fillParentInfo((IEntity)pSPanelItemLogic, "DER1N", "DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSPanelItemLogicService.importXmlModel(pSPanelItemLogic, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSSysViewPanelLogic(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysViewPanelLogicService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSSysViewPanelLogicService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
                pSSysViewPanelLogic.setOrderValue(n);
                n += 100;
                pSSysViewPanelLogicService.fillParentInfo((IEntity)pSSysViewPanelLogic, "DER1N", "DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSSysViewPanelLogicService.importXmlModel(pSSysViewPanelLogic, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelEngine(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSPanelEngineService pSPanelEngineService = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelEngineService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSPanelEngineService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelEngine pSPanelEngine = new PSPanelEngine();
                pSPanelEngine.setOrderValue(n);
                n += 100;
                pSPanelEngineService.fillParentInfo((IEntity)pSPanelEngine, "DER1N", "DER1N_PSPANELENGINE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSPanelEngineService.importXmlModel(pSPanelEngine, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelLogicParam(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLogicParamService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSPanelLogicParamService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLogicParam pSPanelLogicParam = new PSPanelLogicParam();
                pSPanelLogicParamService.fillParentInfo((IEntity)pSPanelLogicParam, "DER1N", "DER1N_PSPANELLOGICPARAM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSPanelLogicParamService.importXmlModel(pSPanelLogicParam, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelLogicNode(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLogicNodeService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSPanelLogicNodeService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLogicNode pSPanelLogicNode = new PSPanelLogicNode();
                pSPanelLogicNodeService.fillParentInfo((IEntity)pSPanelLogicNode, "DER1N", "DER1N_PSPANELLOGICNODE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSPanelLogicNodeService.importXmlModel(pSPanelLogicNode, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelLogicLink(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLogicLinkService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSPanelLogicLinkService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLogicLink pSPanelLogicLink = new PSPanelLogicLink();
                pSPanelLogicLink.setOrderValue(n);
                n += 100;
                pSPanelLogicLinkService.fillParentInfo((IEntity)pSPanelLogicLink, "DER1N", "DER1N_PSPANELLOGICLINK_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSPanelLogicLinkService.importXmlModel(pSPanelLogicLink, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelLNParam(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSPanelLNParamService pSPanelLNParamService = (PSPanelLNParamService)ServiceGlobal.getService(PSPanelLNParamService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLNParamService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSPanelLNParamService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLNParam pSPanelLNParam = new PSPanelLNParam();
                pSPanelLNParam.setOrderValue(n);
                n += 100;
                pSPanelLNParamService.fillParentInfo((IEntity)pSPanelLNParam, "DER1N", "DER1N_PSPANELLNPARAM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSPanelLNParamService.importXmlModel(pSPanelLNParam, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelLLCond(PSSysViewPanel pSSysViewPanel, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanel.getPSSysViewPanelId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelLLCondService.removeByPSSysViewPanel(pSSysViewPanel);
        } else {
            pSPanelLLCondService.removeTempByPSSysViewPanel(pSSysViewPanel);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSPanelLLCond pSPanelLLCond = new PSPanelLLCond();
                pSPanelLLCond.setOrderValue(n);
                n += 100;
                pSPanelLLCondService.fillParentInfo((IEntity)pSPanelLLCond, "DER1N", "DER1N_PSPANELLLCOND_PSSYSVIEWPANEL_PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
                pSPanelLLCondService.importXmlModel(pSPanelLLCond, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysViewPanel pSSysViewPanel, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysViewPanel, string);
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
            return "DER1N_PSSYSVIEWPANEL_PSDATAENTITY_PSDEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSMODULEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSVIEWPANEL_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSVIEWPANEL_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysViewPanel pSSysViewPanel) {
        if (!StringHelper.isNullOrEmpty((String)pSSysViewPanel.getCodeName())) {
            return pSSysViewPanel.getCodeName();
        }
        return super.getModelV2Tag(pSSysViewPanel);
    }

    @Override
    public boolean setModelV2Tag(PSSysViewPanel pSSysViewPanel, String string) {
        pSSysViewPanel.setCodeName(string);
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
    public boolean getModelV2Entity(PSSysViewPanel pSSysViewPanel, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysViewPanel.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysViewPanel, true);
        pSSysViewPanel.set("CODENAME", string);
        if (this.select(pSSysViewPanel, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysViewPanel, true);
        return super.getModelV2Entity(pSSysViewPanel, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysViewPanel pSSysViewPanel, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysViewPanel, objectNode, string, string2, n);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSSYSVIEWPANELMODEL_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (String)string, (boolean)true) == 0) {
            return false;
        }
        if (StringHelper.compare((String)"DER1N_PSPANELENGINE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysViewPanel pSSysViewPanel, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysViewPanel, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysViewPanel pSSysViewPanel, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        Object object3;
        Object object4;
        ArrayList<PSSysViewPanelLogic> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID")) {
            pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWPANEL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSVIEWPANELLOGIC", (Object)pSSysViewPanel.getPSSysViewPanelId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysViewPanelLogic)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysViewPanelLogic>();
                object4 = ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanel(pSSysViewPanel);
                object3 = StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)pSSysViewPanel.getPSSysViewPanelId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysViewPanelLogic)object2.next();
                    object = ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysViewPanelLogic)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssysviewpanellogicname")) {
                            string = objectNode.get("pssysviewpanellogicname").asText();
                        }
                        if (objectNode2.has("pssysviewpanellogicname")) {
                            string2 = objectNode2.get("pssysviewpanellogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysViewPanelLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSVIEWPANELMODEL_PSSYSVIEWPANEL_PSSYSVIEWPANELID")) {
            pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWPANEL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSVIEWPANELMODEL", (Object)pSSysViewPanel.getPSSysViewPanelId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysViewPanelLogic)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanel(pSSysViewPanel);
                object3 = StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)pSSysViewPanel.getPSSysViewPanelId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysViewPanelModel)object2.next();
                    object = ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysViewPanelLogic)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssysviewpanelmodelname")) {
                            string = objectNode.get("pssysviewpanelmodelname").asText();
                        }
                        if (objectNode2.has("pssysviewpanelmodelname")) {
                            string2 = objectNode2.get("pssysviewpanelmodelname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysViewPanelModel();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSPANELENGINE_PSSYSVIEWPANEL_PSSYSVIEWPANELID")) {
            pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWPANEL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSPANELENGINE", (Object)pSSysViewPanel.getPSSysViewPanelId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysViewPanelLogic)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSPanelEngineServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanel(pSSysViewPanel);
                object3 = StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)pSSysViewPanel.getPSSysViewPanelId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSPanelEngine)object2.next();
                    object = ((PSPanelEngineServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysViewPanelLogic)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pspanelenginename")) {
                            string = objectNode.get("pspanelenginename").asText();
                        }
                        if (objectNode2.has("pspanelenginename")) {
                            string2 = objectNode2.get("pspanelenginename").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSPanelEngine();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANEL_PSSYSVIEWPANELID")) {
            pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWPANEL#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSVIEWPANELITEM", (Object)pSSysViewPanel.getPSSysViewPanelId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object4 = PSModelV2Helper.readFile2(file);
                    object3 = ((ArrayList)object4).iterator();
                    while (object3.hasNext()) {
                        object2 = (String)object3.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysViewPanelLogic)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object4 = ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanel(pSSysViewPanel);
                object3 = StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)pSSysViewPanel.getPSSysViewPanelId());
                object2 = ((ArrayList)object4).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysViewPanelItem)object2.next();
                    object = ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)object3, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysViewPanelLogic)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pssysviewpanelitemname")) {
                            string = objectNode.get("pssysviewpanelitemname").asText();
                        }
                        if (objectNode2.has("pssysviewpanelitemname")) {
                            string2 = objectNode2.get("pssysviewpanelitemname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSSysViewPanelItem();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    ((PSSysViewPanelItemBase)object).remove("ordervalue");
                    object3.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysViewPanel, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysViewPanel pSSysViewPanel) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanel(pSSysViewPanel);
        String string2 = StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)pSSysViewPanel.getPSSysViewPanelId());
        for (PSSysViewPanelLogic entityBase : arrayList) {
            string = ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSSysViewPanel.getPSSysViewPanelId());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSVIEWPANELLOGIC WHERE PSSYSVIEWPANELID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanel(pSSysViewPanel);
        string2 = StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)pSSysViewPanel.getPSSysViewPanelId());
        for (PSSysViewPanelModel pSSysViewPanelModel : arrayList) {
            string = ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSSysViewPanelModel);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSSysViewPanelModel);
        }
        object = new SqlParamList();
        object.addString(pSSysViewPanel.getPSSysViewPanelId());
        ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSVIEWPANELMODEL WHERE PSSYSVIEWPANELID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSPanelEngineServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanel(pSSysViewPanel);
        string2 = StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)pSSysViewPanel.getPSSysViewPanelId());
        for (PSPanelEngine pSPanelEngine : arrayList) {
            string = ((PSPanelEngineServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSPanelEngine);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSPanelEngine);
        }
        object = new SqlParamList();
        object.addString(pSSysViewPanel.getPSSysViewPanelId());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSPANELENGINE WHERE PSSYSVIEWPANELID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanel(pSSysViewPanel);
        string2 = StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)pSSysViewPanel.getPSSysViewPanelId());
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            string = ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSSysViewPanelItem);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSSysViewPanelItem);
        }
        object = new SqlParamList();
        object.addString(pSSysViewPanel.getPSSysViewPanelId());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSVIEWPANELITEM WHERE PSSYSVIEWPANELID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSSysViewPanel);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysViewPanel pSSysViewPanel, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysViewPanelLogic();
        entityBase.set("PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysViewPanelModel();
        entityBase.set("PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
        pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSPanelEngine();
        entityBase.set("PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSSysViewPanelItem();
        entityBase.set("PSSYSVIEWPANELID", pSSysViewPanel.getPSSysViewPanelId());
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysViewPanel, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysViewPanel pSSysViewPanel, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        Object object5;
        File file;
        int n2;
        int n3;
        Object object2;
        Object object3;
        Object object4;
        int n4;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n4 = 0; n4 < arrayNode.size(); ++n4) {
                object4 = (ObjectNode)arrayNode.get(n4);
                object3 = new PSSysViewPanelLogic();
                ((PSSysViewPanelLogicBase)object3).setPSSystemId(pSSysViewPanel.getPSSystemId());
                ((PSSysViewPanelLogicBase)object3).setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                ((PSSysViewPanelLogicBase)object3).setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
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
                    object5 = new PSSysViewPanelLogic();
                    ((PSSysViewPanelLogicBase)object5).setPSSystemId(pSSysViewPanel.getPSSystemId());
                    ((PSSysViewPanelLogicBase)object5).setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                    ((PSSysViewPanelLogicBase)object5).setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
                    pSCoreSysServiceBase.compileModelV2(object5, null, string, file.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n4 = 0; n4 < arrayNode.size(); ++n4) {
                object4 = (ObjectNode)arrayNode.get(n4);
                object3 = new PSSysViewPanelModel();
                ((PSSysViewPanelModelBase)object3).setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                ((PSSysViewPanelModelBase)object3).setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
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
                    object5 = new PSSysViewPanelModel();
                    ((PSSysViewPanelModelBase)object5).setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                    ((PSSysViewPanelModelBase)object5).setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
                    pSCoreSysServiceBase.compileModelV2(object5, null, string, file.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object4 = (ObjectNode)arrayNode.get(i);
                object3 = new PSPanelEngine();
                ((PSPanelEngineBase)object3).setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                ((PSPanelEngineBase)object3).setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
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
                    object5 = new PSPanelEngine();
                    ((PSPanelEngineBase)object5).setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                    ((PSPanelEngineBase)object5).setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
                    pSCoreSysServiceBase.compileModelV2(object5, null, string, file.getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n5 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (int i = 0; i < arrayNode.size(); ++i) {
                object3 = (ObjectNode)arrayNode.get(i);
                object2 = new PSSysViewPanelItem();
                ((PSSysViewPanelItemBase)object2).setMobFlag(pSSysViewPanel.getMobFlag());
                ((PSSysViewPanelItemBase)object2).setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                ((PSSysViewPanelItemBase)object2).setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
                ((PSSysViewPanelItemBase)object2).setOrderValue(n5 += 10);
                pSCoreSysServiceBase.compileModelV2(object2, (ObjectNode)object3, string, null, n);
            }
        } else {
            object4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object3 = new File((String)object4);
            if (((File)object3).exists()) {
                for (Object object5 : object2 = ((File)object3).listFiles()) {
                    if (!((File)object5).isDirectory()) continue;
                    PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                    pSSysViewPanelItem.setMobFlag(pSSysViewPanel.getMobFlag());
                    pSSysViewPanelItem.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
                    pSSysViewPanelItem.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
                    pSCoreSysServiceBase.compileModelV2(pSSysViewPanelItem, null, string, ((File)object5).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysViewPanel, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysViewPanel pSSysViewPanel, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysViewPanelLogics(pSSysViewPanel, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSVIEWPANELMODEL_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysViewPanelModels(pSSysViewPanel, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSPANELENGINE_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSPanelEngines(pSSysViewPanel, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysViewPanelItems(pSSysViewPanel, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysViewPanel, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysViewPanelLogics(PSSysViewPanel pSSysViewPanel, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSVIEWPANELLOGIC", true), (boolean)false) == 0) {
            PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
            PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
            pSSysViewPanelLogic.setPSSysViewPanelLogicId(pSMOSFile.getPSModelId());
            if (!pSSysViewPanelLogicService.get((IEntity)pSSysViewPanelLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysViewPanelLogic.getPSSysViewPanelId(), (String)pSSysViewPanel.getPSSysViewPanelId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysViewPanelLogicService.exportModelV2(pSSysViewPanelLogic);
            pSSysViewPanelLogic.reset();
            if (!pSSysViewPanelLogicService.setModelV2ResScope((IEntity)pSSysViewPanelLogic, "PSSYSVIEWPANEL", pSSysViewPanel.getPSSysViewPanelId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysViewPanelLogicService.importModelV2(pSSysViewPanelLogic, objectNode);
            SessionFactoryManager.commit();
            return pSSysViewPanelLogicService.getFile((IEntity)pSSysViewPanelLogic);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysViewPanelModels(PSSysViewPanel pSSysViewPanel, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSVIEWPANELMODEL", true), (boolean)false) == 0) {
            PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
            PSSysViewPanelModel pSSysViewPanelModel = new PSSysViewPanelModel();
            pSSysViewPanelModel.setPSSysViewPanelModelId(pSMOSFile.getPSModelId());
            if (!pSSysViewPanelModelService.get((IEntity)pSSysViewPanelModel, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysViewPanelModel.getPSSysViewPanelId(), (String)pSSysViewPanel.getPSSysViewPanelId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysViewPanelModelService.exportModelV2(pSSysViewPanelModel);
            pSSysViewPanelModel.reset();
            if (!pSSysViewPanelModelService.setModelV2ResScope((IEntity)pSSysViewPanelModel, "PSSYSVIEWPANEL", pSSysViewPanel.getPSSysViewPanelId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysViewPanelModelService.importModelV2(pSSysViewPanelModel, objectNode);
            SessionFactoryManager.commit();
            return pSSysViewPanelModelService.getFile((IEntity)pSSysViewPanelModel);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSPanelEngines(PSSysViewPanel pSSysViewPanel, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSPANELENGINE", true), (boolean)false) == 0) {
            PSPanelEngineService pSPanelEngineService = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
            PSPanelEngine pSPanelEngine = new PSPanelEngine();
            pSPanelEngine.setPSPanelEngineId(pSMOSFile.getPSModelId());
            if (!pSPanelEngineService.get((IEntity)pSPanelEngine, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSPanelEngine.getPSSysViewPanelId(), (String)pSSysViewPanel.getPSSysViewPanelId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSPanelEngineService.exportModelV2(pSPanelEngine);
            pSPanelEngine.reset();
            if (!pSPanelEngineService.setModelV2ResScope((IEntity)pSPanelEngine, "PSSYSVIEWPANEL", pSSysViewPanel.getPSSysViewPanelId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSPanelEngineService.importModelV2(pSPanelEngine, objectNode);
            SessionFactoryManager.commit();
            return pSPanelEngineService.getFile((IEntity)pSPanelEngine);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSSysViewPanelItems(PSSysViewPanel pSSysViewPanel, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSVIEWPANELITEM", true), (boolean)false) == 0) {
            PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
            pSSysViewPanelItem.setPSSysViewPanelItemId(pSMOSFile.getPSModelId());
            if (!pSSysViewPanelItemService.get((IEntity)pSSysViewPanelItem, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysViewPanelItem.getPSSysViewPanelId(), (String)pSSysViewPanel.getPSSysViewPanelId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysViewPanelItemService.exportModelV2(pSSysViewPanelItem);
            pSSysViewPanelItem.reset();
            if (!pSSysViewPanelItemService.setModelV2ResScope((IEntity)pSSysViewPanelItem, "PSSYSVIEWPANEL", pSSysViewPanel.getPSSysViewPanelId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysViewPanelItemService.importModelV2(pSSysViewPanelItem, objectNode);
            SessionFactoryManager.commit();
            return pSSysViewPanelItemService.getFile((IEntity)pSSysViewPanelItem);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysViewPanel pSSysViewPanel, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysViewPanelLogics(pSSysViewPanel, list);
        this.onFillPasteHelps_PSSysViewPanelModels(pSSysViewPanel, list);
        this.onFillPasteHelps_PSPanelEngines(pSSysViewPanel, list);
        this.onFillPasteHelps_PSSysViewPanelItems(pSSysViewPanel, list);
        super.onFillPasteHelps(pSSysViewPanel, list);
    }

    protected void onFillPasteHelps_PSSysViewPanelLogics(PSSysViewPanel pSSysViewPanel, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSVIEWPANELLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSSYSVIEWPANELLOGIC_PSSYSVIEWPANEL_PSSYSVIEWPANELID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u90e8\u4ef6]\u7684[\u9762\u677f\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysViewPanelModels(PSSysViewPanel pSSysViewPanel, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSVIEWPANELMODEL");
        pSHelpSection.setSectionParam2("DER1N_PSSYSVIEWPANELMODEL_PSSYSVIEWPANEL_PSSYSVIEWPANELID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u90e8\u4ef6]\u7684[\u9762\u677f\u6570\u636e\u6a21\u578b]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSPanelEngines(PSSysViewPanel pSSysViewPanel, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSPANELENGINE");
        pSHelpSection.setSectionParam2("DER1N_PSPANELENGINE_PSSYSVIEWPANEL_PSSYSVIEWPANELID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u90e8\u4ef6]\u7684[\u9762\u677f\u754c\u9762\u5f15\u64ce]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSSysViewPanelItems(PSSysViewPanel pSSysViewPanel, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSVIEWPANELITEM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANEL_PSSYSVIEWPANELID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u90e8\u4ef6]\u7684[\u9762\u677f\u6210\u5458]");
        list.add(pSHelpSection);
    }
}

