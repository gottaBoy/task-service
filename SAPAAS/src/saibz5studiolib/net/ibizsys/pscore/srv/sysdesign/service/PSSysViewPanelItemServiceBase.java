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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenu;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppMenuBase;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppView;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppViewBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.entity.PSSysResourceBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACModeBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItem;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDRItemBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelation;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataRelationBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSetBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGrid;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEGridBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEListBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReportBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.helpdesign.entity.PSHelpSection;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelItemDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelItemDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeListBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogicBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCalendarBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounter;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCounterBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboardBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyle;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysEditorStyleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPDTViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelEngineServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileAction;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.ibizsys.pscore.srv.util.PSModelV2Helper;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysViewPanelItemServiceBase
extends PSCoreSysServiceBase<PSSysViewPanelItem> {
    private static final Log log = LogFactory.getLog(PSSysViewPanelItemServiceBase.class);
    public static final String DATASET_CURPANEL = "CurPanel";
    public static final String DATASET_CURPANELALLCONTROL = "CurPanelAllControl";
    public static final String DATASET_CURPANELCONTROL = "CurPanelControl";
    public static final String DATASET_CURPANELCTRLPOS = "CurPanelCtrlPos";
    public static final String DATASET_CURPANELFIELD = "CurPanelField";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String ACTION_CREATETEMPWITHPREVIEW = "CreateTempWithPreview";
    public static final String ACTION_CREATEWITHMODEL = "CreateWithModel";
    public static final String ACTION_GETTEMPWITHPREVIEW = "GetTempWithPreview";
    public static final String ACTION_GETWITHMODEL = "GetWithModel";
    public static final String ACTION_UPDATETEMPWITHPREVIEW = "UpdateTempWithPreview";
    public static final String ACTION_UPDATEWITHMODEL = "UpdateWithModel";
    private PSSysViewPanelItemDEModel pSSysViewPanelItemDEModel;
    private PSSysViewPanelItemDAO pSSysViewPanelItemDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService";
    }

    public PSSysViewPanelItemDEModel getPSSysViewPanelItemDEModel() {
        if (this.pSSysViewPanelItemDEModel == null) {
            try {
                this.pSSysViewPanelItemDEModel = (PSSysViewPanelItemDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysViewPanelItemDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelItemDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysViewPanelItemDEModel();
    }

    public PSSysViewPanelItemDAO getPSSysViewPanelItemDAO() {
        if (this.pSSysViewPanelItemDAO == null) {
            try {
                this.pSSysViewPanelItemDAO = (PSSysViewPanelItemDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysViewPanelItemDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysViewPanelItemDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysViewPanelItemDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPANEL, (boolean)true) == 0) {
            return this.fetchCurPanel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPANELALLCONTROL, (boolean)true) == 0) {
            return this.fetchCurPanelAllControl(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPANELCONTROL, (boolean)true) == 0) {
            return this.fetchCurPanelControl(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPANELCTRLPOS, (boolean)true) == 0) {
            return this.fetchCurPanelCtrlPos(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPANELFIELD, (boolean)true) == 0) {
            return this.fetchCurPanelField(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURPANEL, (boolean)true) == 0) {
            return this.fetchTempCurPanel(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPANELALLCONTROL, (boolean)true) == 0) {
            return this.fetchTempCurPanelAllControl(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPANELCONTROL, (boolean)true) == 0) {
            return this.fetchTempCurPanelControl(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPANELCTRLPOS, (boolean)true) == 0) {
            return this.fetchTempCurPanelCtrlPos(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURPANELFIELD, (boolean)true) == 0) {
            return this.fetchTempCurPanelField(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CREATETEMPWITHPREVIEW, (boolean)true) == 0) {
            this.createTempWithPreview((PSSysViewPanelItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CREATEWITHMODEL, (boolean)true) == 0) {
            this.createWithModel((PSSysViewPanelItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETTEMPWITHPREVIEW, (boolean)true) == 0) {
            this.getTempWithPreview((PSSysViewPanelItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETWITHMODEL, (boolean)true) == 0) {
            this.getWithModel((PSSysViewPanelItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATETEMPWITHPREVIEW, (boolean)true) == 0) {
            this.updateTempWithPreview((PSSysViewPanelItem)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEWITHMODEL, (boolean)true) == 0) {
            this.updateWithModel((PSSysViewPanelItem)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
    }

    public DBFetchResult fetchCurPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANEL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPanel(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANEL, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPanelAllControl(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANELALLCONTROL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPanelAllControl(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANELALLCONTROL, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPanelControl(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANELCONTROL, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPanelControl(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANELCONTROL, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPanelCtrlPos(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANELCTRLPOS, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPanelCtrlPos(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANELCTRLPOS, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurPanelField(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANELFIELD, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurPanelField(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURPANELFIELD, true);
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

    public void createTempWithPreview(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATETEMPWITHPREVIEW, 0, (IEntity)pSSysViewPanelItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanelItem, ACTION_CREATETEMPWITHPREVIEW);
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelItemServiceBase.this.getService(), PSSysViewPanelItemServiceBase.ACTION_CREATETEMPWITHPREVIEW, 40, (IEntity)pSSysViewPanelItem2, null).getResult() != 1) {
                    PSSysViewPanelItemServiceBase.this.onCreateTempWithPreview(pSSysViewPanelItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATETEMPWITHPREVIEW, 99, (IEntity)pSSysViewPanelItem, null);
        }
    }

    protected void onCreateTempWithPreview(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateTempWithPreview]");
    }

    public void createWithModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 0, (IEntity)pSSysViewPanelItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanelItem, ACTION_CREATEWITHMODEL);
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelItemServiceBase.this.getService(), PSSysViewPanelItemServiceBase.ACTION_CREATEWITHMODEL, 40, (IEntity)pSSysViewPanelItem2, null).getResult() != 1) {
                    PSSysViewPanelItemServiceBase.this.onCreateWithModel(pSSysViewPanelItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CREATEWITHMODEL, 99, (IEntity)pSSysViewPanelItem, null);
        }
    }

    protected void onCreateWithModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CreateWithModel]");
    }

    public void getTempWithPreview(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETTEMPWITHPREVIEW, 0, (IEntity)pSSysViewPanelItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanelItem, ACTION_GETTEMPWITHPREVIEW);
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelItemServiceBase.this.getService(), PSSysViewPanelItemServiceBase.ACTION_GETTEMPWITHPREVIEW, 40, (IEntity)pSSysViewPanelItem2, null).getResult() != 1) {
                    PSSysViewPanelItemServiceBase.this.onGetTempWithPreview(pSSysViewPanelItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETTEMPWITHPREVIEW, 99, (IEntity)pSSysViewPanelItem, null);
        }
    }

    protected void onGetTempWithPreview(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetTempWithPreview]");
    }

    public void getWithModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 0, (IEntity)pSSysViewPanelItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanelItem, ACTION_GETWITHMODEL);
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelItemServiceBase.this.getService(), PSSysViewPanelItemServiceBase.ACTION_GETWITHMODEL, 40, (IEntity)pSSysViewPanelItem2, null).getResult() != 1) {
                    PSSysViewPanelItemServiceBase.this.onGetWithModel(pSSysViewPanelItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETWITHMODEL, 99, (IEntity)pSSysViewPanelItem, null);
        }
    }

    protected void onGetWithModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetWithModel]");
    }

    public void updateTempWithPreview(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATETEMPWITHPREVIEW, 0, (IEntity)pSSysViewPanelItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanelItem, ACTION_UPDATETEMPWITHPREVIEW);
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelItemServiceBase.this.getService(), PSSysViewPanelItemServiceBase.ACTION_UPDATETEMPWITHPREVIEW, 40, (IEntity)pSSysViewPanelItem2, null).getResult() != 1) {
                    PSSysViewPanelItemServiceBase.this.onUpdateTempWithPreview(pSSysViewPanelItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATETEMPWITHPREVIEW, 99, (IEntity)pSSysViewPanelItem, null);
        }
    }

    protected void onUpdateTempWithPreview(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateTempWithPreview]");
    }

    public void updateWithModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 0, (IEntity)pSSysViewPanelItem, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSSysViewPanelItem, ACTION_UPDATEWITHMODEL);
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysViewPanelItemServiceBase.this.getService(), PSSysViewPanelItemServiceBase.ACTION_UPDATEWITHMODEL, 40, (IEntity)pSSysViewPanelItem2, null).getResult() != 1) {
                    PSSysViewPanelItemServiceBase.this.onUpdateWithModel(pSSysViewPanelItem2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEWITHMODEL, 99, (IEntity)pSSysViewPanelItem, null);
        }
    }

    protected void onUpdateWithModel(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateWithModel]");
    }

    protected void onFillParentInfo(PSSysViewPanelItem pSSysViewPanelItem, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSACHandler);
            } else {
                iService.get((IEntity)pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSSysViewPanelItem, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSAPPMENU_PSAPPMENUID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService", (SessionFactory)this.getSessionFactory());
            PSAppMenu pSAppMenu = (PSAppMenu)iService.getDEModel().createEntity();
            pSAppMenu.set("PSAPPMENUID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppMenu);
            } else {
                iService.get((IEntity)pSAppMenu);
            }
            this.onFillParentInfo_PSAppMenu(pSSysViewPanelItem, pSAppMenu);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSAPPVIEW_OPENPSAPPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppViewService", (SessionFactory)this.getSessionFactory());
            PSAppView pSAppView = (PSAppView)iService.getDEModel().createEntity();
            pSAppView.set("PSAPPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSAppView);
            } else {
                iService.get((IEntity)pSAppView);
            }
            this.onFillParentInfo_OpenPSAppView(pSSysViewPanelItem, pSAppView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSCODELIST_PSCODELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService", (SessionFactory)this.getSessionFactory());
            PSCodeList pSCodeList = (PSCodeList)iService.getDEModel().createEntity();
            pSCodeList.set("PSCODELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCodeList);
            } else {
                iService.get((IEntity)pSCodeList);
            }
            this.onFillParentInfo_PSCodeList(pSSysViewPanelItem, pSCodeList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlLogicGroup);
            } else {
                iService.get((IEntity)pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysViewPanelItem, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSSysViewPanelItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDATAENTITY_REFPSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_RefPSDE(pSSysViewPanelItem, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEACMODE_REFPSDEACMODEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService", (SessionFactory)this.getSessionFactory());
            PSDEACMode pSDEACMode = (PSDEACMode)iService.getDEModel().createEntity();
            pSDEACMode.set("PSDEACMODEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEACMode);
            } else {
                iService.get((IEntity)pSDEACMode);
            }
            this.onFillParentInfo_RefPSDEACMode(pSSysViewPanelItem, pSDEACMode);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSSysViewPanelItem, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDECHART_PSDECHARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartService", (SessionFactory)this.getSessionFactory());
            PSDEChart pSDEChart = (PSDEChart)iService.getDEModel().createEntity();
            pSDEChart.set("PSDECHARTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEChart);
            } else {
                iService.get((IEntity)pSDEChart);
            }
            this.onFillParentInfo_PSDEChart(pSSysViewPanelItem, pSDEChart);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEDATARELATION_PSDEDRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService", (SessionFactory)this.getSessionFactory());
            PSDEDataRelation pSDEDataRelation = (PSDEDataRelation)iService.getDEModel().createEntity();
            pSDEDataRelation.set("PSDEDATARELATIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataRelation);
            } else {
                iService.get((IEntity)pSDEDataRelation);
            }
            this.onFillParentInfo_PSDEDR(pSSysViewPanelItem, pSDEDataRelation);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSSysViewPanelItem, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEDATASET_REFPSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_RefPSDEDataSet(pSSysViewPanelItem, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEDATAVIEW_PSDEDATAVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService", (SessionFactory)this.getSessionFactory());
            PSDEDataView pSDEDataView = (PSDEDataView)iService.getDEModel().createEntity();
            pSDEDataView.set("PSDEDATAVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataView);
            } else {
                iService.get((IEntity)pSDEDataView);
            }
            this.onFillParentInfo_PSDEDataView(pSSysViewPanelItem, pSDEDataView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEDRITEM_PSDEDRITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService", (SessionFactory)this.getSessionFactory());
            PSDEDRItem pSDEDRItem = (PSDEDRItem)iService.getDEModel().createEntity();
            pSDEDRItem.set("PSDEDRITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDRItem);
            } else {
                iService.get((IEntity)pSDEDRItem);
            }
            this.onFillParentInfo_PSDEDRItem(pSSysViewPanelItem, pSDEDRItem);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSSysViewPanelItem, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEFORM_PSDESEARCHFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDESearchForm(pSSysViewPanelItem, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGrid);
            } else {
                iService.get((IEntity)pSDEGrid);
            }
            this.onFillParentInfo_PSDEGrid(pSSysViewPanelItem, pSDEGrid);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDELIST_PSDELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListService", (SessionFactory)this.getSessionFactory());
            PSDEList pSDEList = (PSDEList)iService.getDEModel().createEntity();
            pSDEList.set("PSDELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEList);
            } else {
                iService.get((IEntity)pSDEList);
            }
            this.onFillParentInfo_PSDEList(pSSysViewPanelItem, pSDEList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDELOGIC_ADPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_ADPSDELogic(pSSysViewPanelItem, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDELOGIC_PSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_PSDELogic(pSSysViewPanelItem, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEREPORT_PSDEREPORTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEReportService", (SessionFactory)this.getSessionFactory());
            PSDEReport pSDEReport = (PSDEReport)iService.getDEModel().createEntity();
            pSDEReport.set("PSDEREPORTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEReport);
            } else {
                iService.get((IEntity)pSDEReport);
            }
            this.onFillParentInfo_PSDEReport(pSSysViewPanelItem, pSDEReport);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEToolbar);
            } else {
                iService.get((IEntity)pSDEToolbar);
            }
            this.onFillParentInfo_PSDEToolbar(pSSysViewPanelItem, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDETreeView);
            } else {
                iService.get((IEntity)pSDETreeView);
            }
            this.onFillParentInfo_PSDETreeView(pSSysViewPanelItem, pSDETreeView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSSysViewPanelItem, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEUIACTION_PSDEUIACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService", (SessionFactory)this.getSessionFactory());
            PSDEUIAction pSDEUIAction = (PSDEUIAction)iService.getDEModel().createEntity();
            pSDEUIAction.set("PSDEUIACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUIAction);
            } else {
                iService.get((IEntity)pSDEUIAction);
            }
            this.onFillParentInfo_PSDEUIAction(pSSysViewPanelItem, pSDEUIAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEVIEWBASE_OPENPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_OpenPSDEView(pSSysViewPanelItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSSysViewPanelItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEVIEWBASE_REFLINKPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_RefLinkPSDEView(pSSysViewPanelItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEVIEWBASE_REFPICKUPPSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_RefPickupPSDEView(pSSysViewPanelItem, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory());
            PSDEWizard pSDEWizard = (PSDEWizard)iService.getDEModel().createEntity();
            pSDEWizard.set("PSDEWIZARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEWizard);
            } else {
                iService.get((IEntity)pSDEWizard);
            }
            this.onFillParentInfo_PSDEWizard(pSSysViewPanelItem, pSDEWizard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSSysViewPanelItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSLANGUAGERES_PHPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_PHPSLanRes(pSSysViewPanelItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSLANGUAGERES_TIPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_TipPSLanRes(pSSysViewPanelItem, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSCALENDAR_PSSYSCALENDARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService", (SessionFactory)this.getSessionFactory());
            PSSysCalendar pSSysCalendar = (PSSysCalendar)iService.getDEModel().createEntity();
            pSSysCalendar.set("PSSYSCALENDARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCalendar);
            } else {
                iService.get((IEntity)pSSysCalendar);
            }
            this.onFillParentInfo_PSSysCalendar(pSSysViewPanelItem, pSSysCalendar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCounter);
            } else {
                iService.get((IEntity)pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSSysViewPanelItem, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSCSS_CTRLPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_CtrlPSSysCss(pSSysViewPanelItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSCSS_LABELPSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_LabelPSSysCss(pSSysViewPanelItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSSysViewPanelItem, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSDASHBOARD_PSSYSDASHBOARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService", (SessionFactory)this.getSessionFactory());
            PSSysDashboard pSSysDashboard = (PSSysDashboard)iService.getDEModel().createEntity();
            pSSysDashboard.set("PSSYSDASHBOARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDashboard);
            } else {
                iService.get((IEntity)pSSysDashboard);
            }
            this.onFillParentInfo_PSSysDashboard(pSSysViewPanelItem, pSSysDashboard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSSysViewPanelItem, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService", (SessionFactory)this.getSessionFactory());
            PSSysEditorStyle pSSysEditorStyle = (PSSysEditorStyle)iService.getDEModel().createEntity();
            pSSysEditorStyle.set("PSSYSEDITORSTYLEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysEditorStyle);
            } else {
                iService.get((IEntity)pSSysEditorStyle);
            }
            this.onFillParentInfo_PSSysEditorStyle(pSSysViewPanelItem, pSSysEditorStyle);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSSysViewPanelItem, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSMAPVIEW_PSSYSMAPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService", (SessionFactory)this.getSessionFactory());
            PSSysMapView pSSysMapView = (PSSysMapView)iService.getDEModel().createEntity();
            pSSysMapView.set("PSSYSMAPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysMapView);
            } else {
                iService.get((IEntity)pSSysMapView);
            }
            this.onFillParentInfo_PSSysMapView(pSSysViewPanelItem, pSSysMapView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSPDTVIEW_OPENPSSYSPDTVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysPDTViewService", (SessionFactory)this.getSessionFactory());
            PSSysPDTView pSSysPDTView = (PSSysPDTView)iService.getDEModel().createEntity();
            pSSysPDTView.set("PSSYSPDTVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPDTView);
            } else {
                iService.get((IEntity)pSSysPDTView);
            }
            this.onFillParentInfo_OpenPSSysPDTView(pSSysViewPanelItem, pSSysPDTView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSSysViewPanelItem, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSRESOURCE_PSSYSRESOURCEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysResourceService", (SessionFactory)this.getSessionFactory());
            PSSysResource pSSysResource = (PSSysResource)iService.getDEModel().createEntity();
            pSSysResource.set("PSSYSRESOURCEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysResource);
            } else {
                iService.get((IEntity)pSSysResource);
            }
            this.onFillParentInfo_PSSysResource(pSSysViewPanelItem, pSSysResource);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSSEARCHBAR_PSSYSSEARCHBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService", (SessionFactory)this.getSessionFactory());
            PSSysSearchBar pSSysSearchBar = (PSSysSearchBar)iService.getDEModel().createEntity();
            pSSysSearchBar.set("PSSYSSEARCHBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSearchBar);
            } else {
                iService.get((IEntity)pSSysSearchBar);
            }
            this.onFillParentInfo_PSSysSearchBar(pSSysViewPanelItem, pSSysSearchBar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEM_PPSSYSVIEWPANELITEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)iService.getDEModel().createEntity();
            pSSysViewPanelItem2.set("PSSYSVIEWPANELITEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanelItem2);
            } else {
                iService.get((IEntity)pSSysViewPanelItem2);
            }
            this.onFillParentInfo_PPSSysViewPanelItem(pSSysViewPanelItem, pSSysViewPanelItem2);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANEL_PSDEPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_PSDEPanel(pSSysViewPanelItem, pSSysViewPanel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSSysViewPanelItem, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo((IEntity)pSSysViewPanelItem, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSSysViewPanelItem pSSysViewPanelItem, PSACHandler pSACHandler) throws Exception {
        pSSysViewPanelItem.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSSysViewPanelItem.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSAppMenu(PSSysViewPanelItem pSSysViewPanelItem, PSAppMenu pSAppMenu) throws Exception {
        pSSysViewPanelItem.setPSAppMenuId(pSAppMenu.getPSAppMenuId());
        pSSysViewPanelItem.setPSAppMenuName(pSAppMenu.getPSAppMenuName());
    }

    protected void onFillParentInfo_OpenPSAppView(PSSysViewPanelItem pSSysViewPanelItem, PSAppView pSAppView) throws Exception {
        pSSysViewPanelItem.setOpenPSAppViewId(pSAppView.getPSAppViewId());
        pSSysViewPanelItem.setOpenPSAppViewName(pSAppView.getPSAppViewName());
    }

    protected void onFillParentInfo_PSCodeList(PSSysViewPanelItem pSSysViewPanelItem, PSCodeList pSCodeList) throws Exception {
        pSSysViewPanelItem.setPSCodeListId(pSCodeList.getPSCodeListId());
        pSSysViewPanelItem.setPSCodeListName(pSCodeList.getPSCodeListName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSSysViewPanelItem pSSysViewPanelItem, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSSysViewPanelItem.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSSysViewPanelItem.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSDE(PSSysViewPanelItem pSSysViewPanelItem, PSDataEntity pSDataEntity) throws Exception {
        pSSysViewPanelItem.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysViewPanelItem.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_RefPSDE(PSSysViewPanelItem pSSysViewPanelItem, PSDataEntity pSDataEntity) throws Exception {
        pSSysViewPanelItem.setRefPSDEId(pSDataEntity.getPSDataEntityId());
        pSSysViewPanelItem.setRefPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_RefPSDEACMode(PSSysViewPanelItem pSSysViewPanelItem, PSDEACMode pSDEACMode) throws Exception {
        pSSysViewPanelItem.setRefPSDEACModeId(pSDEACMode.getPSDEACModeId());
        pSSysViewPanelItem.setRefPSDEACModeName(pSDEACMode.getPSDEACModeName());
    }

    protected void onFillParentInfo_PSDEAction(PSSysViewPanelItem pSSysViewPanelItem, PSDEAction pSDEAction) throws Exception {
        pSSysViewPanelItem.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSSysViewPanelItem.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEChart(PSSysViewPanelItem pSSysViewPanelItem, PSDEChart pSDEChart) throws Exception {
        pSSysViewPanelItem.setPSDEChartId(pSDEChart.getPSDEChartId());
        pSSysViewPanelItem.setPSDEChartName(pSDEChart.getPSDEChartName());
    }

    protected void onFillParentInfo_PSDEDR(PSSysViewPanelItem pSSysViewPanelItem, PSDEDataRelation pSDEDataRelation) throws Exception {
        pSSysViewPanelItem.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
        pSSysViewPanelItem.setPSDEDRName(pSDEDataRelation.getPSDEDataRelationName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSSysViewPanelItem pSSysViewPanelItem, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysViewPanelItem.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSSysViewPanelItem.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_RefPSDEDataSet(PSSysViewPanelItem pSSysViewPanelItem, PSDEDataSet pSDEDataSet) throws Exception {
        pSSysViewPanelItem.setRefPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSSysViewPanelItem.setRefPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDataView(PSSysViewPanelItem pSSysViewPanelItem, PSDEDataView pSDEDataView) throws Exception {
        pSSysViewPanelItem.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
        pSSysViewPanelItem.setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
    }

    protected void onFillParentInfo_PSDEDRItem(PSSysViewPanelItem pSSysViewPanelItem, PSDEDRItem pSDEDRItem) throws Exception {
        pSSysViewPanelItem.setPSDEDRItemId(pSDEDRItem.getPSDEDRItemId());
        pSSysViewPanelItem.setPSDEDRItemName(pSDEDRItem.getPSDEDRItemName());
    }

    protected void onFillParentInfo_PSDEForm(PSSysViewPanelItem pSSysViewPanelItem, PSDEForm pSDEForm) throws Exception {
        pSSysViewPanelItem.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSSysViewPanelItem.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDESearchForm(PSSysViewPanelItem pSSysViewPanelItem, PSDEForm pSDEForm) throws Exception {
        pSSysViewPanelItem.setPSDESearchFormId(pSDEForm.getPSDEFormId());
        pSSysViewPanelItem.setPSDESearchFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEGrid(PSSysViewPanelItem pSSysViewPanelItem, PSDEGrid pSDEGrid) throws Exception {
        pSSysViewPanelItem.setPSDEGridId(pSDEGrid.getPSDEGridId());
        pSSysViewPanelItem.setPSDEGridName(pSDEGrid.getPSDEGridName());
    }

    protected void onFillParentInfo_PSDEList(PSSysViewPanelItem pSSysViewPanelItem, PSDEList pSDEList) throws Exception {
        pSSysViewPanelItem.setPSDEListId(pSDEList.getPSDEListId());
        pSSysViewPanelItem.setPSDEListName(pSDEList.getPSDEListName());
    }

    protected void onFillParentInfo_ADPSDELogic(PSSysViewPanelItem pSSysViewPanelItem, PSDELogic pSDELogic) throws Exception {
        pSSysViewPanelItem.setADPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysViewPanelItem.setADPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDELogic(PSSysViewPanelItem pSSysViewPanelItem, PSDELogic pSDELogic) throws Exception {
        pSSysViewPanelItem.setPSDELogicId(pSDELogic.getPSDELogicId());
        pSSysViewPanelItem.setPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEReport(PSSysViewPanelItem pSSysViewPanelItem, PSDEReport pSDEReport) throws Exception {
        pSSysViewPanelItem.setPSDEReportId(pSDEReport.getPSDEReportId());
        pSSysViewPanelItem.setPSDEReportName(pSDEReport.getPSDEReportName());
    }

    protected void onFillParentInfo_PSDEToolbar(PSSysViewPanelItem pSSysViewPanelItem, PSDEToolbar pSDEToolbar) throws Exception {
        pSSysViewPanelItem.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSSysViewPanelItem.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_PSDETreeView(PSSysViewPanelItem pSSysViewPanelItem, PSDETreeView pSDETreeView) throws Exception {
        pSSysViewPanelItem.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        pSSysViewPanelItem.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSSysViewPanelItem pSSysViewPanelItem, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSSysViewPanelItem.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSSysViewPanelItem.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUIAction(PSSysViewPanelItem pSSysViewPanelItem, PSDEUIAction pSDEUIAction) throws Exception {
        pSSysViewPanelItem.setPSDEUIActionId(pSDEUIAction.getPSDEUIActionId());
        pSSysViewPanelItem.setPSDEUIActionName(pSDEUIAction.getPSDEUIActionName());
    }

    protected void onFillParentInfo_OpenPSDEView(PSSysViewPanelItem pSSysViewPanelItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysViewPanelItem.setOpenPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSSysViewPanelItem.setOpenPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSSysViewPanelItem pSSysViewPanelItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysViewPanelItem.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSSysViewPanelItem.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_RefLinkPSDEView(PSSysViewPanelItem pSSysViewPanelItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysViewPanelItem.setRefLinkPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSSysViewPanelItem.setRefLinkPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_RefPickupPSDEView(PSSysViewPanelItem pSSysViewPanelItem, PSDEViewBase pSDEViewBase) throws Exception {
        pSSysViewPanelItem.setRefPickupPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSSysViewPanelItem.setRefPickupPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSDEWizard(PSSysViewPanelItem pSSysViewPanelItem, PSDEWizard pSDEWizard) throws Exception {
        pSSysViewPanelItem.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
        pSSysViewPanelItem.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSSysViewPanelItem pSSysViewPanelItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysViewPanelItem.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysViewPanelItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PHPSLanRes(PSSysViewPanelItem pSSysViewPanelItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysViewPanelItem.setPHPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysViewPanelItem.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_TipPSLanRes(PSSysViewPanelItem pSSysViewPanelItem, PSLanguageRes pSLanguageRes) throws Exception {
        pSSysViewPanelItem.setTipPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSSysViewPanelItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSSysCalendar(PSSysViewPanelItem pSSysViewPanelItem, PSSysCalendar pSSysCalendar) throws Exception {
        pSSysViewPanelItem.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
        pSSysViewPanelItem.setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
    }

    protected void onFillParentInfo_PSSysCounter(PSSysViewPanelItem pSSysViewPanelItem, PSSysCounter pSSysCounter) throws Exception {
        pSSysViewPanelItem.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSSysViewPanelItem.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_CtrlPSSysCss(PSSysViewPanelItem pSSysViewPanelItem, PSSysCss pSSysCss) throws Exception {
        pSSysViewPanelItem.setCtrlPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysViewPanelItem.setCtrlPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_LabelPSSysCss(PSSysViewPanelItem pSSysViewPanelItem, PSSysCss pSSysCss) throws Exception {
        pSSysViewPanelItem.setLabelPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysViewPanelItem.setLabelPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysCss(PSSysViewPanelItem pSSysViewPanelItem, PSSysCss pSSysCss) throws Exception {
        pSSysViewPanelItem.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSSysViewPanelItem.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDashboard(PSSysViewPanelItem pSSysViewPanelItem, PSSysDashboard pSSysDashboard) throws Exception {
        pSSysViewPanelItem.setPSSysDashboardId(pSSysDashboard.getPSSysDashboardId());
        pSSysViewPanelItem.setPSSysDashboardName(pSSysDashboard.getPSSysDashboardName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSSysViewPanelItem pSSysViewPanelItem, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSSysViewPanelItem.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSSysViewPanelItem.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysEditorStyle(PSSysViewPanelItem pSSysViewPanelItem, PSSysEditorStyle pSSysEditorStyle) throws Exception {
        pSSysViewPanelItem.setPSSysEditorStyleId(pSSysEditorStyle.getPSSysEditorStyleId());
        pSSysViewPanelItem.setPSSysEditorStyleName(pSSysEditorStyle.getPSSysEditorStyleName());
    }

    protected void onFillParentInfo_PSSysImage(PSSysViewPanelItem pSSysViewPanelItem, PSSysImage pSSysImage) throws Exception {
        pSSysViewPanelItem.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSSysViewPanelItem.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysMapView(PSSysViewPanelItem pSSysViewPanelItem, PSSysMapView pSSysMapView) throws Exception {
        pSSysViewPanelItem.setPSSysMapViewId(pSSysMapView.getPSSysMapViewId());
        pSSysViewPanelItem.setPSSysMapViewName(pSSysMapView.getPSSysMapViewName());
    }

    protected void onFillParentInfo_OpenPSSysPDTView(PSSysViewPanelItem pSSysViewPanelItem, PSSysPDTView pSSysPDTView) throws Exception {
        pSSysViewPanelItem.setOpenPSSysPDTViewId(pSSysPDTView.getPSSysPDTViewId());
        pSSysViewPanelItem.setOpenPSSysPDTViewName(pSSysPDTView.getPSSysPDTViewName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSSysViewPanelItem pSSysViewPanelItem, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSSysViewPanelItem.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSSysViewPanelItem.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysResource(PSSysViewPanelItem pSSysViewPanelItem, PSSysResource pSSysResource) throws Exception {
        pSSysViewPanelItem.setPSSysResourceId(pSSysResource.getPSSysResourceId());
        pSSysViewPanelItem.setPSSysResourceName(pSSysResource.getPSSysResourceName());
    }

    protected void onFillParentInfo_PSSysSearchBar(PSSysViewPanelItem pSSysViewPanelItem, PSSysSearchBar pSSysSearchBar) throws Exception {
        pSSysViewPanelItem.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
        pSSysViewPanelItem.setPSSysSearchBarName(pSSysSearchBar.getPSSysSearchBarName());
    }

    protected void onFillParentInfo_PPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, PSSysViewPanelItem pSSysViewPanelItem2) throws Exception {
        pSSysViewPanelItem.setPLayoutMode(pSSysViewPanelItem2.getLayoutMode());
        pSSysViewPanelItem.setPPSSysViewPanelItemId(pSSysViewPanelItem2.getPSSysViewPanelItemId());
        pSSysViewPanelItem.setPPSSysViewPanelItemName(pSSysViewPanelItem2.getPSSysViewPanelItemName());
    }

    protected void onFillParentInfo_PSDEPanel(PSSysViewPanelItem pSSysViewPanelItem, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysViewPanelItem.setPSDEPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSSysViewPanelItem.setPSDEPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSSysViewPanelItem pSSysViewPanelItem, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSSysViewPanelItem.setMobFlag(pSSysViewPanel.getMobFlag());
        pSSysViewPanelItem.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSSysViewPanelItem.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected void onFillEntityFullInfo(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (bl && pSSysViewPanelItem.getCustomMode() == null) {
            pSSysViewPanelItem.setCustomMode((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
        }
        super.onFillEntityFullInfo((IEntity)pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSACHandler(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSAppMenu(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_OpenPSAppView(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSCodeList(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDE(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_RefPSDE(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_RefPSDEACMode(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEAction(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEChart(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEDR(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_RefPSDEDataSet(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEDataView(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEDRItem(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEForm(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDESearchForm(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEGrid(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEList(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_ADPSDELogic(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDELogic(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEReport(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEToolbar(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDETreeView(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEUIAction(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_OpenPSDEView(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_RefLinkPSDEView(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_RefPickupPSDEView(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEWizard(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PHPSLanRes(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_TipPSLanRes(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysCalendar(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_CtrlPSSysCss(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_LabelPSSysCss(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysCss(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysDashboard(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysEditorStyle(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysImage(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysMapView(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_OpenPSSysPDTView(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysResource(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysSearchBar(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PPSSysViewPanelItem(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSDEPanel(pSSysViewPanelItem, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSSysViewPanelItem, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSAppMenu(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OpenPSAppView(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCodeList(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (pSSysViewPanelItem.isPSDEIdDirty()) {
            if (pSSysViewPanelItem.getPSDEId() != null) {
                if (pSSysViewPanelItem.getPSDEId() == null || pSSysViewPanelItem.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysViewPanelItem.getPSDE();
                    pSSysViewPanelItem.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysViewPanelItem.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDE(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (pSSysViewPanelItem.isRefPSDEIdDirty()) {
            if (pSSysViewPanelItem.getRefPSDEId() != null) {
                if (pSSysViewPanelItem.getRefPSDEId() == null || pSSysViewPanelItem.getRefPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSSysViewPanelItem.getRefPSDE();
                    pSSysViewPanelItem.setRefPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSSysViewPanelItem.setRefPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_RefPSDEACMode(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEAction(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEChart(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDR(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPSDEDataSet(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataView(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (pSSysViewPanelItem.isPSDEDataViewIdDirty()) {
            if (pSSysViewPanelItem.getPSDEDataViewId() != null) {
                if (pSSysViewPanelItem.getPSDEDataViewId() == null || pSSysViewPanelItem.getPSDEDataViewName() == null) {
                    PSDEDataView pSDEDataView = pSSysViewPanelItem.getPSDEDataView();
                    pSSysViewPanelItem.setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
                }
            } else {
                pSSysViewPanelItem.setPSDEDataViewName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDRItem(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEForm(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDESearchForm(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEGrid(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEList(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ADPSDELogic(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDELogic(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEReport(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEToolbar(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDETreeView(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEUIAction(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OpenPSDEView(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefLinkPSDEView(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_RefPickupPSDEView(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEWizard(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (pSSysViewPanelItem.isCapPSLanResIdDirty()) {
            if (pSSysViewPanelItem.getCapPSLanResId() != null) {
                if (pSSysViewPanelItem.getCapPSLanResId() == null || pSSysViewPanelItem.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysViewPanelItem.getCapPSLanRes();
                    pSSysViewPanelItem.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysViewPanelItem.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PHPSLanRes(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (pSSysViewPanelItem.isPHPSLanResIdDirty()) {
            if (pSSysViewPanelItem.getPHPSLanResId() != null) {
                if (pSSysViewPanelItem.getPHPSLanResId() == null || pSSysViewPanelItem.getPHPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysViewPanelItem.getPHPSLanRes();
                    pSSysViewPanelItem.setPHPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysViewPanelItem.setPHPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_TipPSLanRes(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (pSSysViewPanelItem.isTipPSLanResIdDirty()) {
            if (pSSysViewPanelItem.getTipPSLanResId() != null) {
                if (pSSysViewPanelItem.getTipPSLanResId() == null || pSSysViewPanelItem.getTipPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSSysViewPanelItem.getTipPSLanRes();
                    pSSysViewPanelItem.setTipPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSSysViewPanelItem.setTipPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysCalendar(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CtrlPSSysCss(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_LabelPSSysCss(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDashboard(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (pSSysViewPanelItem.isPSSysDynaModelIdDirty()) {
            if (pSSysViewPanelItem.getPSSysDynaModelId() != null) {
                if (pSSysViewPanelItem.getPSSysDynaModelId() == null || pSSysViewPanelItem.getPSSysDynaModelName() == null) {
                    PSSysDynaModel pSSysDynaModel = pSSysViewPanelItem.getPSSysDynaModel();
                    pSSysViewPanelItem.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
                }
            } else {
                pSSysViewPanelItem.setPSSysDynaModelName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSSysEditorStyle(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMapView(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_OpenPSSysPDTView(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysResource(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSearchBar(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (pSSysViewPanelItem.isPPSSysViewPanelItemIdDirty()) {
            if (pSSysViewPanelItem.getPPSSysViewPanelItemId() != null) {
                if (pSSysViewPanelItem.getPPSSysViewPanelItemId() == null || pSSysViewPanelItem.getPPSSysViewPanelItemName() == null) {
                    PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem.getPPSSysViewPanelItem();
                    pSSysViewPanelItem.setPLayoutMode(pSSysViewPanelItem2.getLayoutMode());
                    pSSysViewPanelItem.setPPSSysViewPanelItemName(pSSysViewPanelItem2.getPSSysViewPanelItemName());
                }
            } else {
                pSSysViewPanelItem.setPLayoutMode(null);
                pSSysViewPanelItem.setPPSSysViewPanelItemName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEPanel(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        if (pSSysViewPanelItem.isPSSysViewPanelIdDirty()) {
            if (pSSysViewPanelItem.getPSSysViewPanelId() != null) {
                if (pSSysViewPanelItem.getPSSysViewPanelId() == null || pSSysViewPanelItem.getPSSysViewPanelName() == null) {
                    PSSysViewPanel pSSysViewPanel = pSSysViewPanelItem.getPSSysViewPanel();
                    pSSysViewPanelItem.setMobFlag(pSSysViewPanel.getMobFlag());
                    pSSysViewPanelItem.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
                }
            } else {
                pSSysViewPanelItem.setMobFlag(null);
                pSSysViewPanelItem.setPSSysViewPanelName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSSysViewPanelItem, bl);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string) throws Exception {
        return this.selectByPSAppMenu(pSAppMenuBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSAppMenu(PSAppMenuBase pSAppMenuBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSAPPMENUID", (Object)pSAppMenuBase.getPSAppMenuId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSAppMenuCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSAppMenuCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByOpenPSAppView(PSAppViewBase pSAppViewBase) throws Exception {
        return this.selectByOpenPSAppView(pSAppViewBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByOpenPSAppView(PSAppViewBase pSAppViewBase, String string) throws Exception {
        return this.selectByOpenPSAppView(pSAppViewBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByOpenPSAppView(PSAppViewBase pSAppViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPENPSAPPVIEWID", (Object)pSAppViewBase.getPSAppViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOpenPSAppViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOpenPSAppViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSCodeList(PSCodeListBase pSCodeListBase) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string) throws Exception {
        return this.selectByPSCodeList(pSCodeListBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSCodeList(PSCodeListBase pSCodeListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCODELISTID", (Object)pSCodeListBase.getPSCodeListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCodeListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCodeListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByRefPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByRefPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEID", (Object)pSDataEntityBase.getPSDataEntityId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDECond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDECond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string) throws Exception {
        return this.selectByRefPSDEACMode(pSDEACModeBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPSDEACMode(PSDEACModeBase pSDEACModeBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEACMODEID", (Object)pSDEACModeBase.getPSDEACModeId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEACModeCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEACModeCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSDEChart(PSDEChartBase pSDEChartBase) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDECHARTID", (Object)pSDEChartBase.getPSDEChartId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEChartCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEChartCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase) throws Exception {
        return this.selectByPSDEDR(pSDEDataRelationBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase, String string) throws Exception {
        return this.selectByPSDEDR(pSDEDataRelationBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDRID", (Object)pSDEDataRelationBase.getPSDEDataRelationId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDRCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDRCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByRefPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPSDEDATASETID", (Object)pSDEDataSetBase.getPSDEDataSetId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPSDEDataSetCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPSDEDataSetCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDataView(PSDEDataViewBase pSDEDataViewBase) throws Exception {
        return this.selectByPSDEDataView(pSDEDataViewBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDataView(PSDEDataViewBase pSDEDataViewBase, String string) throws Exception {
        return this.selectByPSDEDataView(pSDEDataViewBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDataView(PSDEDataViewBase pSDEDataViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATAVIEWID", (Object)pSDEDataViewBase.getPSDEDataViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDRItem(PSDEDRItemBase pSDEDRItemBase) throws Exception {
        return this.selectByPSDEDRItem(pSDEDRItemBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDRItem(PSDEDRItemBase pSDEDRItemBase, String string) throws Exception {
        return this.selectByPSDEDRItem(pSDEDRItemBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEDRItem(PSDEDRItemBase pSDEDRItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDRITEMID", (Object)pSDEDRItemBase.getPSDEDRItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDRItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDRItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSDESearchForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDESearchForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDESearchForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDESearchForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDESearchForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDESEARCHFORMID", (Object)pSDEFormBase.getPSDEFormId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDESearchFormCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDESearchFormCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSDEList(PSDEListBase pSDEListBase) throws Exception {
        return this.selectByPSDEList(pSDEListBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEList(PSDEListBase pSDEListBase, String string) throws Exception {
        return this.selectByPSDEList(pSDEListBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEList(PSDEListBase pSDEListBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDELISTID", (Object)pSDEListBase.getPSDEListId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEListCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEListCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByADPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("ADPSDELOGICID", (Object)pSDELogicBase.getPSDELogicId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByADPSDELogicCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByADPSDELogicCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSDEReport(PSDEReportBase pSDEReportBase) throws Exception {
        return this.selectByPSDEReport(pSDEReportBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEReport(PSDEReportBase pSDEReportBase, String string) throws Exception {
        return this.selectByPSDEReport(pSDEReportBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEReport(PSDEReportBase pSDEReportBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEREPORTID", (Object)pSDEReportBase.getPSDEReportId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEReportCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEReportCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETOOLBARID", (Object)pSDEToolbarBase.getPSDEToolbarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEToolbarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEToolbarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDETREEVIEWID", (Object)pSDETreeViewBase.getPSDETreeViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDETreeViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDETreeViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string) throws Exception {
        return this.selectByPSDEUIAction(pSDEUIActionBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEUIAction(PSDEUIActionBase pSDEUIActionBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEUIACTIONID", (Object)pSDEUIActionBase.getPSDEUIActionId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEUIActionCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEUIActionCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByOpenPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByOpenPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByOpenPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByOpenPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByOpenPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPENPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOpenPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOpenPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByRefLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRefLinkPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRefLinkPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefLinkPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFLINKPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefLinkPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefLinkPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByRefPickupPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByRefPickupPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByRefPickupPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("REFPICKUPPSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByRefPickupPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByRefPickupPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEWIZARDID", (Object)pSDEWizardBase.getPSDEWizardId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEWizardCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEWizardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByPHPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPHPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PHPSLANRESID", (Object)pSLanguageResBase.getPSLanguageResId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPHPSLanResCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPHPSLanResCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByTipPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByTipPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCALENDARID", (Object)pSSysCalendarBase.getPSSysCalendarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCalendarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCalendarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByCtrlPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByCtrlPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByCtrlPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByCtrlPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByCtrlPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("CTRLPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByCtrlPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByCtrlPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByLabelPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByLabelPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByLabelPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByLabelPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByLabelPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("LABELPSSYSCSSID", (Object)pSSysCssBase.getPSSysCssId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByLabelPSSysCssCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByLabelPSSysCssCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase) throws Exception {
        return this.selectByPSSysDashboard(pSSysDashboardBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase, String string) throws Exception {
        return this.selectByPSSysDashboard(pSSysDashboardBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSDASHBOARDID", (Object)pSSysDashboardBase.getPSSysDashboardId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysDashboardCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysDashboardCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string) throws Exception {
        return this.selectByPSSysEditorStyle(pSSysEditorStyleBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysEditorStyle(PSSysEditorStyleBase pSSysEditorStyleBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSEDITORSTYLEID", (Object)pSSysEditorStyleBase.getPSSysEditorStyleId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysEditorStyleCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysEditorStyleCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase) throws Exception {
        return this.selectByPSSysMapView(pSSysMapViewBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase, String string) throws Exception {
        return this.selectByPSSysMapView(pSSysMapViewBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMAPVIEWID", (Object)pSSysMapViewBase.getPSSysMapViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMapViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMapViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByOpenPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase) throws Exception {
        return this.selectByOpenPSSysPDTView(pSSysPDTViewBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByOpenPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string) throws Exception {
        return this.selectByOpenPSSysPDTView(pSSysPDTViewBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByOpenPSSysPDTView(PSSysPDTViewBase pSSysPDTViewBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("OPENPSSYSPDTVIEWID", (Object)pSSysPDTViewBase.getPSSysPDTViewId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByOpenPSSysPDTViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByOpenPSSysPDTViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectByPSSysResource(PSSysResourceBase pSSysResourceBase) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string) throws Exception {
        return this.selectByPSSysResource(pSSysResourceBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysResource(PSSysResourceBase pSSysResourceBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSRESOURCEID", (Object)pSSysResourceBase.getPSSysResourceId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysResourceCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysResourceCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysSearchBar(PSSysSearchBarBase pSSysSearchBarBase) throws Exception {
        return this.selectByPSSysSearchBar(pSSysSearchBarBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysSearchBar(PSSysSearchBarBase pSSysSearchBarBase, String string) throws Exception {
        return this.selectByPSSysSearchBar(pSSysSearchBarBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysSearchBar(PSSysSearchBarBase pSSysSearchBarBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSSEARCHBARID", (Object)pSSysSearchBarBase.getPSSysSearchBarId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysSearchBarCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysSearchBarCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectByPPSSysViewPanelItem(pSSysViewPanelItemBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        return this.selectByPPSSysViewPanelItem(pSSysViewPanelItemBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSVIEWPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPPSSysViewPanelItemCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPPSSysViewPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectTempByPPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase) throws Exception {
        return this.selectTempByPPSSysViewPanelItem(pSSysViewPanelItemBase, "");
    }

    public ArrayList<PSSysViewPanelItem> selectTempByPPSSysViewPanelItem(PSSysViewPanelItemBase pSSysViewPanelItemBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PPSSYSVIEWPANELITEMID", (Object)pSSysViewPanelItemBase.getPSSysViewPanelItemId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPPSSysViewPanelItemCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPPSSysViewPanelItemCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSDEPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSDEPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSDEPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEPanelCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEPanelCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSSysViewPanelItem> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysViewPanelItem> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectTempByPSSysViewPanel(pSSysViewPanelBase, "");
    }

    public ArrayList<PSSysViewPanelItem> selectTempByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSVIEWPANELID", (Object)pSSysViewPanelBase.getPSSysViewPanelId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSSysViewPanelCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSSysViewPanelCond(SelectCond selectCond) throws Exception {
    }

    public void testRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSACHandlerId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSAppMenu(pSAppMenu, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPMENU");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppMenu);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSAPPMENU_PSAPPMENUID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSAppMenu), arrayList.get(0)));
        }
    }

    public void resetPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSAppMenu(pSAppMenu);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSAppMenuId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        final PSAppMenu pSAppMenu2 = pSAppMenu;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSAppMenu(pSAppMenu2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSAppMenu(pSAppMenu2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSAppMenu(pSAppMenu2);
            }
        });
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void internalRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSAppMenu(pSAppMenu);
        this.onBeforeRemoveByPSAppMenu(pSAppMenu, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSAppMenu(pSAppMenu, arrayList);
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu) throws Exception {
    }

    protected void onBeforeRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSAppMenu(PSAppMenu pSAppMenu, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByOpenPSAppView(pSAppView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSAPPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSAppView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSAPPVIEW_OPENPSAPPVIEWID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSAppView), arrayList.get(0)));
        }
    }

    public void resetOpenPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByOpenPSAppView(pSAppView);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setOpenPSAppViewId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByOpenPSAppView(PSAppView pSAppView) throws Exception {
        final PSAppView pSAppView2 = pSAppView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByOpenPSAppView(pSAppView2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByOpenPSAppView(pSAppView2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByOpenPSAppView(pSAppView2);
            }
        });
    }

    protected void onBeforeRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void internalRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByOpenPSAppView(pSAppView);
        this.onBeforeRemoveByOpenPSAppView(pSAppView, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByOpenPSAppView(pSAppView, arrayList);
    }

    protected void onAfterRemoveByOpenPSAppView(PSAppView pSAppView) throws Exception {
    }

    protected void onBeforeRemoveByOpenPSAppView(PSAppView pSAppView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOpenPSAppView(PSAppView pSAppView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSCodeList(pSCodeList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCODELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCodeList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSCODELIST_PSCODELISTID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSCodeList), arrayList.get(0)));
        }
    }

    public void resetPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSCodeList(pSCodeList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSCodeListId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSCodeList(PSCodeList pSCodeList) throws Exception {
        final PSCodeList pSCodeList2 = pSCodeList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSCodeList(pSCodeList2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSCodeList(pSCodeList2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSCodeList(pSCodeList2);
            }
        });
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void internalRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSCodeList(pSCodeList);
        this.onBeforeRemoveByPSCodeList(pSCodeList, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSCodeList(pSCodeList, arrayList);
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList) throws Exception {
    }

    protected void onBeforeRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCodeList(PSCodeList pSCodeList, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSCtrlLogicGroupId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDATAENTITY_REFPSDEID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPSDE(pSDataEntity);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setRefPSDEId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByRefPSDE(pSDataEntity2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByRefPSDE(pSDataEntity2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByRefPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPSDE(pSDataEntity);
        this.onBeforeRemoveByRefPSDE(pSDataEntity, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByRefPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDE(PSDataEntity pSDataEntity, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    public void resetRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setRefPSDEACModeId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        final PSDEACMode pSDEACMode2 = pSDEACMode;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByRefPSDEACMode(pSDEACMode2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByRefPSDEACMode(pSDEACMode2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByRefPSDEACMode(pSDEACMode2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void internalRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPSDEACMode(pSDEACMode);
        this.onBeforeRemoveByRefPSDEACMode(pSDEACMode, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByRefPSDEACMode(pSDEACMode, arrayList);
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEACMode(PSDEACMode pSDEACMode, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEActionId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEChart(pSDEChart, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDECHART");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEChart);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDECHART_PSDECHARTID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEChart), arrayList.get(0)));
        }
    }

    public void resetPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEChart(pSDEChart);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEChartId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEChart(PSDEChart pSDEChart) throws Exception {
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEChart(pSDEChart2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEChart(pSDEChart2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEChart(pSDEChart2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void internalRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEChart(pSDEChart);
        this.onBeforeRemoveByPSDEChart(pSDEChart, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEChart(pSDEChart, arrayList);
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDR(pSDEDataRelation, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATARELATION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataRelation);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEDATARELATION_PSDEDRID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEDataRelation), arrayList.get(0)));
        }
    }

    public void resetPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDR(pSDEDataRelation);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEDRId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        final PSDEDataRelation pSDEDataRelation2 = pSDEDataRelation;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEDR(pSDEDataRelation2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEDR(pSDEDataRelation2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEDR(pSDEDataRelation2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void internalRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDR(pSDEDataRelation);
        this.onBeforeRemoveByPSDEDR(pSDEDataRelation, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEDR(pSDEDataRelation, arrayList);
    }

    protected void onAfterRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEDataSetId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEDATASET_REFPSDEDATASETID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setRefPSDEDataSetId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByRefPSDEDataSet(pSDEDataSet2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByRefPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDataView(pSDEDataView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEDATAVIEW_PSDEDATAVIEWID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEDataView), arrayList.get(0)));
        }
    }

    public void resetPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDataView(pSDEDataView);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEDataViewId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEDataView(pSDEDataView2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEDataView(pSDEDataView2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEDataView(pSDEDataView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
    }

    protected void internalRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDataView(pSDEDataView);
        this.onBeforeRemoveByPSDEDataView(pSDEDataView, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEDataView(pSDEDataView, arrayList);
    }

    protected void onAfterRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataView(PSDEDataView pSDEDataView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataView(PSDEDataView pSDEDataView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDRItem(pSDEDRItem, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDRITEM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDRItem);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEDRITEM_PSDEDRITEMID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEDRItem), arrayList.get(0)));
        }
    }

    public void resetPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDRItem(pSDEDRItem);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEDRItemId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        final PSDEDRItem pSDEDRItem2 = pSDEDRItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEDRItem(pSDEDRItem2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEDRItem(pSDEDRItem2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEDRItem(pSDEDRItem2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
    }

    protected void internalRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEDRItem(pSDEDRItem);
        this.onBeforeRemoveByPSDEDRItem(pSDEDRItem, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEDRItem(pSDEDRItem, arrayList);
    }

    protected void onAfterRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDRItem(PSDEDRItem pSDEDRItem, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEFormId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDESearchForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDESearchForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEFORM_PSDESEARCHFORMID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDESearchForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDESearchForm(pSDEForm);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDESearchFormId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDESearchForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDESearchForm(pSDEForm2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDESearchForm(pSDEForm2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDESearchForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDESearchForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDESearchForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDESearchForm(pSDEForm);
        this.onBeforeRemoveByPSDESearchForm(pSDEForm, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDESearchForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDESearchForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDESearchForm(PSDEForm pSDEForm, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDESearchForm(PSDEForm pSDEForm, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEGrid(pSDEGrid, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEGRID");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEGrid);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEGRID_PSDEGRIDID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEGrid), arrayList.get(0)));
        }
    }

    public void resetPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEGrid(pSDEGrid);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEGridId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEGrid(pSDEGrid2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEGrid(pSDEGrid2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByPSDEGrid(pSDEGrid, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEList(pSDEList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDELIST_PSDELISTID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEList), arrayList.get(0)));
        }
    }

    public void resetPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEList(pSDEList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEListId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEList(PSDEList pSDEList) throws Exception {
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEList(pSDEList2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEList(pSDEList2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEList(pSDEList2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void internalRemoveByPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEList(pSDEList);
        this.onBeforeRemoveByPSDEList(pSDEList, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEList(pSDEList, arrayList);
    }

    protected void onAfterRemoveByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void onBeforeRemoveByPSDEList(PSDEList pSDEList, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEList(PSDEList pSDEList, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByADPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDELOGIC_ADPSDELOGICID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByADPSDELogic(pSDELogic);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setADPSDELogicId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByADPSDELogic(pSDELogic2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByADPSDELogic(pSDELogic2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByADPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByADPSDELogic(pSDELogic);
        this.onBeforeRemoveByADPSDELogic(pSDELogic, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByADPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDELOGIC_PSDELOGICID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDELogic(pSDELogic);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDELogicId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDELogic(pSDELogic2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDELogic(pSDELogic2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDELogic(pSDELogic);
        this.onBeforeRemoveByPSDELogic(pSDELogic, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDELogic(PSDELogic pSDELogic, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEReport(pSDEReport, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEREPORT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEReport);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEREPORT_PSDEREPORTID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEReport), arrayList.get(0)));
        }
    }

    public void resetPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEReport(pSDEReport);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEReportId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEReport(PSDEReport pSDEReport) throws Exception {
        final PSDEReport pSDEReport2 = pSDEReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEReport(pSDEReport2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEReport(pSDEReport2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEReport(pSDEReport2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void internalRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEReport(pSDEReport);
        this.onBeforeRemoveByPSDEReport(pSDEReport, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEReport(pSDEReport, arrayList);
    }

    protected void onAfterRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void onBeforeRemoveByPSDEReport(PSDEReport pSDEReport, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEReport(PSDEReport pSDEReport, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDETOOLBAR_PSDETOOLBARID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEToolbarId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEToolbar(pSDEToolbar2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEToolbar(pSDEToolbar2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDETreeView(pSDETreeView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETREEVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDETreeView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDETREEVIEW_PSDETREEVIEWID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDETreeView), arrayList.get(0)));
        }
    }

    public void resetPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDETreeView(pSDETreeView);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDETreeViewId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDETreeView(pSDETreeView2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDETreeView(pSDETreeView2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveByPSDETreeView(pSDETreeView, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEUAGroupId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEUIAction(pSDEUIAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUIACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUIAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEUIACTION_PSDEUIACTIONID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEUIAction), arrayList.get(0)));
        }
    }

    public void resetPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEUIActionId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        final PSDEUIAction pSDEUIAction2 = pSDEUIAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEUIAction(pSDEUIAction2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEUIAction(pSDEUIAction2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEUIAction(pSDEUIAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void internalRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEUIAction(pSDEUIAction);
        this.onBeforeRemoveByPSDEUIAction(pSDEUIAction, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEUIAction(pSDEUIAction, arrayList);
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUIAction(PSDEUIAction pSDEUIAction, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByOpenPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEVIEWBASE_OPENPSDEVIEWID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByOpenPSDEView(pSDEViewBase);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setOpenPSDEViewId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByOpenPSDEView(pSDEViewBase2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByOpenPSDEView(pSDEViewBase2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByOpenPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByOpenPSDEView(pSDEViewBase);
        this.onBeforeRemoveByOpenPSDEView(pSDEViewBase, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByOpenPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOpenPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEVIEWBASE_PSDEVIEWBASEID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEViewBaseId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefLinkPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEVIEWBASE_REFLINKPSDEVIEWID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefLinkPSDEView(pSDEViewBase);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setRefLinkPSDEViewId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByRefLinkPSDEView(pSDEViewBase2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByRefLinkPSDEView(pSDEViewBase2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByRefLinkPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefLinkPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRefLinkPSDEView(pSDEViewBase, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByRefLinkPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefLinkPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPickupPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEVIEWBASE_REFPICKUPPSDEVIEWID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPickupPSDEView(pSDEViewBase);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setRefPickupPSDEViewId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByRefPickupPSDEView(pSDEViewBase2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByRefPickupPSDEView(pSDEViewBase2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByRefPickupPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByRefPickupPSDEView(pSDEViewBase);
        this.onBeforeRemoveByRefPickupPSDEView(pSDEViewBase, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByRefPickupPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByRefPickupPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEWizard(pSDEWizard, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEWIZARD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEWizard);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSDEWIZARD_PSDEWIZARDID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSDEWizard), arrayList.get(0)));
        }
    }

    public void resetPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEWizard(pSDEWizard);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEWizardId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEWizard(pSDEWizard2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEWizard(pSDEWizard2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEWizard(pSDEWizard2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void internalRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEWizard(pSDEWizard);
        this.onBeforeRemoveByPSDEWizard(pSDEWizard, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEWizard(pSDEWizard, arrayList);
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setCapPSLanResId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPHPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSLANGUAGERES_PHPSLANRESID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPHPSLanResId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPHPSLanRes(pSLanguageRes2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPHPSLanRes(pSLanguageRes2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPHPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPHPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByPHPSLanRes(pSLanguageRes, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPHPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPHPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSLANGUAGERES_TIPPSLANRESID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setTipPSLanResId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByTipPSLanRes(pSLanguageRes2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByTipPSLanRes(pSLanguageRes2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByTipPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByTipPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByTipPSLanRes(pSLanguageRes, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByTipPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByTipPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysCalendar(pSSysCalendar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCALENDAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCalendar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSCALENDAR_PSSYSCALENDARID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysCalendar), arrayList.get(0)));
        }
    }

    public void resetPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysCalendarId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        final PSSysCalendar pSSysCalendar2 = pSSysCalendar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysCalendar(pSSysCalendar2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysCalendar(pSSysCalendar2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysCalendar(pSSysCalendar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void internalRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        this.onBeforeRemoveByPSSysCalendar(pSSysCalendar, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysCalendar(pSSysCalendar, arrayList);
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysCounterId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByCtrlPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSCSS_CTRLPSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByCtrlPSSysCss(pSSysCss);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setCtrlPSSysCssId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByCtrlPSSysCss(pSSysCss2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByCtrlPSSysCss(pSSysCss2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByCtrlPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByCtrlPSSysCss(pSSysCss);
        this.onBeforeRemoveByCtrlPSSysCss(pSSysCss, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByCtrlPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByCtrlPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByCtrlPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCtrlPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByLabelPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSCSS_LABELPSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByLabelPSSysCss(pSSysCss);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setLabelPSSysCssId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByLabelPSSysCss(pSSysCss2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByLabelPSSysCss(pSSysCss2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByLabelPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByLabelPSSysCss(pSSysCss);
        this.onBeforeRemoveByLabelPSSysCss(pSSysCss, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByLabelPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByLabelPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByLabelPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByLabelPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysCssId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysDashboard(pSSysDashboard, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDASHBOARD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDashboard);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSDASHBOARD_PSSYSDASHBOARDID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysDashboard), arrayList.get(0)));
        }
    }

    public void resetPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysDashboard(pSSysDashboard);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysDashboardId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        final PSSysDashboard pSSysDashboard2 = pSSysDashboard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysDashboard(pSSysDashboard2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysDashboard(pSSysDashboard2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysDashboard(pSSysDashboard2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
    }

    protected void internalRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysDashboard(pSSysDashboard);
        this.onBeforeRemoveByPSSysDashboard(pSSysDashboard, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysDashboard(pSSysDashboard, arrayList);
    }

    protected void onAfterRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysDynaModelId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSEDITORSTYLE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysEditorStyle);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSEDITORSTYLE_PSSYSEDITORSTYLEID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysEditorStyle), arrayList.get(0)));
        }
    }

    public void resetPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysEditorStyleId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        final PSSysEditorStyle pSSysEditorStyle2 = pSSysEditorStyle;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysEditorStyle(pSSysEditorStyle2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void internalRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysEditorStyle(pSSysEditorStyle);
        this.onBeforeRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysEditorStyle(pSSysEditorStyle, arrayList);
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle) throws Exception {
    }

    protected void onBeforeRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysEditorStyle(PSSysEditorStyle pSSysEditorStyle, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysImageId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysMapView(pSSysMapView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMAPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysMapView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSMAPVIEW_PSSYSMAPVIEWID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysMapView), arrayList.get(0)));
        }
    }

    public void resetPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysMapView(pSSysMapView);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysMapViewId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        final PSSysMapView pSSysMapView2 = pSSysMapView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysMapView(pSSysMapView2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysMapView(pSSysMapView2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysMapView(pSSysMapView2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void internalRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysMapView(pSSysMapView);
        this.onBeforeRemoveByPSSysMapView(pSSysMapView, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysMapView(pSSysMapView, arrayList);
    }

    protected void onAfterRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByOpenPSSysPDTView(pSSysPDTView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPDTVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPDTView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSPDTVIEW_OPENPSSYSPDTVIEWID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysPDTView), arrayList.get(0)));
        }
    }

    public void resetOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByOpenPSSysPDTView(pSSysPDTView);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setOpenPSSysPDTViewId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        final PSSysPDTView pSSysPDTView2 = pSSysPDTView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByOpenPSSysPDTView(pSSysPDTView2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByOpenPSSysPDTView(pSSysPDTView2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByOpenPSSysPDTView(pSSysPDTView2);
            }
        });
    }

    protected void onBeforeRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void internalRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByOpenPSSysPDTView(pSSysPDTView);
        this.onBeforeRemoveByOpenPSSysPDTView(pSSysPDTView, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByOpenPSSysPDTView(pSSysPDTView, arrayList);
    }

    protected void onAfterRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView) throws Exception {
    }

    protected void onBeforeRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByOpenPSSysPDTView(PSSysPDTView pSSysPDTView, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysPFPluginId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysResource(pSSysResource, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSRESOURCE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysResource);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSRESOURCE_PSSYSRESOURCEID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysResource), arrayList.get(0)));
        }
    }

    public void resetPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysResource(pSSysResource);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysResourceId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysResource(PSSysResource pSSysResource) throws Exception {
        final PSSysResource pSSysResource2 = pSSysResource;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysResource(pSSysResource2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysResource(pSSysResource2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysResource(pSSysResource2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void internalRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysResource(pSSysResource);
        this.onBeforeRemoveByPSSysResource(pSSysResource, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysResource(pSSysResource, arrayList);
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource) throws Exception {
    }

    protected void onBeforeRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysResource(PSSysResource pSSysResource, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysSearchBar(pSSysSearchBar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSearchBar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSSEARCHBAR_PSSYSSEARCHBARID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysSearchBar), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysSearchBar(pSSysSearchBar);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysSearchBarId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
        final PSSysSearchBar pSSysSearchBar2 = pSSysSearchBar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysSearchBar(pSSysSearchBar2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysSearchBar(pSSysSearchBar2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysSearchBar(pSSysSearchBar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
    }

    protected void internalRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysSearchBar(pSSysSearchBar);
        this.onBeforeRemoveByPSSysSearchBar(pSSysSearchBar, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysSearchBar(pSSysSearchBar, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    public void resetPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSSysViewPanelItem pSSysViewPanelItem2 : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem3 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem3.setPSSysViewPanelItemId(pSSysViewPanelItem2.getPSSysViewPanelItemId());
            pSSysViewPanelItem3.setPPSSysViewPanelItemId(null);
            this.update(pSSysViewPanelItem3);
        }
    }

    public void resetTempPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectTempByPPSSysViewPanelItem(pSSysViewPanelItem);
        for (PSSysViewPanelItem pSSysViewPanelItem2 : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem3 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem3.setPSSysViewPanelItemId(pSSysViewPanelItem2.getPSSysViewPanelItemId());
            pSSysViewPanelItem3.setPPSSysViewPanelItemId(null);
            this.updateTemp((IEntity)pSSysViewPanelItem3);
        }
    }

    public void removeByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveByPPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem2 : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem2);
        }
        this.onAfterRemoveByPPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSDEPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANEL_PSDEPANELID", "", iDataEntityModel.getName(), "PSSYSVIEWPANELITEM", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSDEPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEPanel(pSSysViewPanel);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSDEPanelId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void removeByPSDEPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSDEPanel(pSSysViewPanel2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSDEPanel(pSSysViewPanel2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSDEPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSDEPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSDEPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSDEPanel(pSSysViewPanel, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSDEPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSDEPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSDEPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysViewPanelId(null);
            this.update(pSSysViewPanelItem2);
        }
    }

    public void resetTempPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            PSSysViewPanelItem pSSysViewPanelItem2 = (PSSysViewPanelItem)this.getDEModel().createEntity();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
            pSSysViewPanelItem2.setPSSysViewPanelId(null);
            this.updateTemp((IEntity)pSSysViewPanelItem2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelItemServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.remove((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo3PSPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo4PSPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanelItem(pSSysViewPanelItem);
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).removeByPSSysViewPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPPSSysViewPanelItem(pSSysViewPanelItem);
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).removeByPPSSysViewPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).testRemoveByParamPSPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).testRemoveByPSSysViewPanelItem(pSSysViewPanelItem);
        super.onBeforeRemove(pSSysViewPanelItem);
    }

    protected void onBeforeRemoveTemp(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).removeTempByPSSysViewPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelModelServiceBase)pSCoreSysServiceBase).resetTempPSSysViewPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).resetTempPSSysViewPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelLogicServiceBase)pSCoreSysServiceBase).resetTempParamPSPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).resetTempPPSSysViewPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelLogicNodeServiceBase)pSCoreSysServiceBase).resetTempPSSysViewPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).resetTempPSPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).resetTempNo4PSPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).resetTempNo3PSPanelItem(pSSysViewPanelItem);
        pSCoreSysServiceBase = (PSPanelEngineService)ServiceGlobal.getService(PSPanelEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSPanelEngineServiceBase)pSCoreSysServiceBase).resetTempNo2PSPanelItem(pSSysViewPanelItem);
        super.onBeforeRemoveTemp((IEntity)pSSysViewPanelItem);
    }

    public void removeTempByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        final PSSysViewPanelItem pSSysViewPanelItem2 = pSSysViewPanelItem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveTempByPPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelItemServiceBase.this.internalRemoveTempByPPSSysViewPanelItem(pSSysViewPanelItem2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveTempByPPSSysViewPanelItem(pSSysViewPanelItem2);
            }
        });
    }

    protected void onBeforeRemoveTempByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void internalRemoveTempByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectTempByPPSSysViewPanelItem(pSSysViewPanelItem);
        this.onBeforeRemoveTempByPPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem2 : arrayList) {
            this.removeTemp((IEntity)pSSysViewPanelItem2);
        }
        this.onAfterRemoveTempByPPSSysViewPanelItem(pSSysViewPanelItem, arrayList);
    }

    protected void onAfterRemoveTempByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
    }

    protected void onBeforeRemoveTempByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPPSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    public void removeTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysViewPanelItemServiceBase.this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelItemServiceBase.this.internalRemoveTempByPSSysViewPanel(pSSysViewPanel2);
                PSSysViewPanelItemServiceBase.this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSSysViewPanelItem> arrayList = this.selectTempByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSSysViewPanelItem pSSysViewPanelItem : arrayList) {
            this.removeTemp((IEntity)pSSysViewPanelItem);
        }
        this.onAfterRemoveTempByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSSysViewPanelItem> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        this.getRelatedDataTempMajor_PSPanelItemLogic(pSSysViewPanelItem);
        super.getRelatedDataTempMajor((IEntity)pSSysViewPanelItem);
    }

    protected void getRelatedDataTempMajor_PSPanelItemLogic(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelItemLogic> arrayList = null;
        String string = pSSysViewPanelItem.getPSSysViewPanelItemId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelItemLogicService.selectByPSSysViewPanelItem(pSSysViewPanelItem) : pSPanelItemLogicService.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        PSSysViewPanelItemServiceBase.sortHierarchyEntities(arrayList, (String)"PSPANELITEMLOGICID", (String)"PPSPANELITEMLOGICID");
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            pSPanelItemLogicService.getTempMajor(pSPanelItemLogic);
        }
    }

    protected void updateRelatedDataTempMajor(PSSysViewPanelItem pSSysViewPanelItem, PSSysViewPanelItem pSSysViewPanelItem2) throws Exception {
        ArrayList<PSPanelItemLogic> arrayList = this.updateRelatedDataTempMajor_removePSPanelItemLogic(pSSysViewPanelItem, pSSysViewPanelItem2);
        this.updateRelatedDataTempMajor_updatePSPanelItemLogic(pSSysViewPanelItem, pSSysViewPanelItem2, arrayList);
        super.updateRelatedDataTempMajor((IEntity)pSSysViewPanelItem, (IEntity)pSSysViewPanelItem2);
    }

    protected ArrayList<PSPanelItemLogic> updateRelatedDataTempMajor_removePSPanelItemLogic(PSSysViewPanelItem pSSysViewPanelItem, PSSysViewPanelItem pSSysViewPanelItem2) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelItemLogic> arrayList = pSPanelItemLogicService.selectTempByPSSysViewPanelItem(pSSysViewPanelItem);
        ArrayList<PSPanelItemLogic> arrayList2 = pSPanelItemLogicService.selectByPSSysViewPanelItem(pSSysViewPanelItem2);
        HashMap<String, PSPanelItemLogic> hashMap = new HashMap<String, PSPanelItemLogic>();
        for (PSPanelItemLogic pSPanelItemLogic : arrayList2) {
            hashMap.put(pSPanelItemLogic.getPSPanelItemLogicId(), pSPanelItemLogic);
        }
        PSSysViewPanelItemServiceBase.sortHierarchyEntities(arrayList, (String)"PSPANELITEMLOGICID", (String)"PPSPANELITEMLOGICID");
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            Object object = pSPanelItemLogic.get("SRFORIKEY");
            hashMap.remove(object);
        }
        for (PSPanelItemLogic pSPanelItemLogic : hashMap.values()) {
            pSPanelItemLogicService.remove((IEntity)pSPanelItemLogic);
        }
        return arrayList;
    }

    protected void updateRelatedDataTempMajor_updatePSPanelItemLogic(PSSysViewPanelItem pSSysViewPanelItem, PSSysViewPanelItem pSSysViewPanelItem2, ArrayList<PSPanelItemLogic> arrayList) throws Exception {
        if (arrayList == null) {
            return;
        }
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            pSPanelItemLogicService.updateTempMajor(pSPanelItemLogic);
        }
    }

    protected void replaceParentInfo(PSSysViewPanelItem pSSysViewPanelItem, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSSysViewPanelItem, cloneSession);
        if (pSSysViewPanelItem.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSSysViewPanelItem.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSSysViewPanelItem, (PSACHandler)iEntity);
        }
        if (pSSysViewPanelItem.getPSAppMenuId() != null && (iEntity = cloneSession.getEntity("PSAPPMENU", (Object)pSSysViewPanelItem.getPSAppMenuId())) != null) {
            this.onFillParentInfo_PSAppMenu(pSSysViewPanelItem, (PSAppMenu)iEntity);
        }
        if (pSSysViewPanelItem.getOpenPSAppViewId() != null && (iEntity = cloneSession.getEntity("PSAPPVIEW", (Object)pSSysViewPanelItem.getOpenPSAppViewId())) != null) {
            this.onFillParentInfo_OpenPSAppView(pSSysViewPanelItem, (PSAppView)iEntity);
        }
        if (pSSysViewPanelItem.getPSCodeListId() != null && (iEntity = cloneSession.getEntity("PSCODELIST", (Object)pSSysViewPanelItem.getPSCodeListId())) != null) {
            this.onFillParentInfo_PSCodeList(pSSysViewPanelItem, (PSCodeList)iEntity);
        }
        if (pSSysViewPanelItem.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSSysViewPanelItem.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSSysViewPanelItem, (PSCtrlLogicGroup)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysViewPanelItem.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSSysViewPanelItem, (PSDataEntity)iEntity);
        }
        if (pSSysViewPanelItem.getRefPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSSysViewPanelItem.getRefPSDEId())) != null) {
            this.onFillParentInfo_RefPSDE(pSSysViewPanelItem, (PSDataEntity)iEntity);
        }
        if (pSSysViewPanelItem.getRefPSDEACModeId() != null && (iEntity = cloneSession.getEntity("PSDEACMODE", (Object)pSSysViewPanelItem.getRefPSDEACModeId())) != null) {
            this.onFillParentInfo_RefPSDEACMode(pSSysViewPanelItem, (PSDEACMode)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSSysViewPanelItem.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSSysViewPanelItem, (PSDEAction)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEChartId() != null && (iEntity = cloneSession.getEntity("PSDECHART", (Object)pSSysViewPanelItem.getPSDEChartId())) != null) {
            this.onFillParentInfo_PSDEChart(pSSysViewPanelItem, (PSDEChart)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEDRId() != null && (iEntity = cloneSession.getEntity("PSDEDATARELATION", (Object)pSSysViewPanelItem.getPSDEDRId())) != null) {
            this.onFillParentInfo_PSDEDR(pSSysViewPanelItem, (PSDEDataRelation)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysViewPanelItem.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSSysViewPanelItem, (PSDEDataSet)iEntity);
        }
        if (pSSysViewPanelItem.getRefPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSSysViewPanelItem.getRefPSDEDataSetId())) != null) {
            this.onFillParentInfo_RefPSDEDataSet(pSSysViewPanelItem, (PSDEDataSet)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEDataViewId() != null && (iEntity = cloneSession.getEntity("PSDEDATAVIEW", (Object)pSSysViewPanelItem.getPSDEDataViewId())) != null) {
            this.onFillParentInfo_PSDEDataView(pSSysViewPanelItem, (PSDEDataView)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEDRItemId() != null && (iEntity = cloneSession.getEntity("PSDEDRITEM", (Object)pSSysViewPanelItem.getPSDEDRItemId())) != null) {
            this.onFillParentInfo_PSDEDRItem(pSSysViewPanelItem, (PSDEDRItem)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSSysViewPanelItem.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSSysViewPanelItem, (PSDEForm)iEntity);
        }
        if (pSSysViewPanelItem.getPSDESearchFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSSysViewPanelItem.getPSDESearchFormId())) != null) {
            this.onFillParentInfo_PSDESearchForm(pSSysViewPanelItem, (PSDEForm)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSSysViewPanelItem.getPSDEGridId())) != null) {
            this.onFillParentInfo_PSDEGrid(pSSysViewPanelItem, (PSDEGrid)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEListId() != null && (iEntity = cloneSession.getEntity("PSDELIST", (Object)pSSysViewPanelItem.getPSDEListId())) != null) {
            this.onFillParentInfo_PSDEList(pSSysViewPanelItem, (PSDEList)iEntity);
        }
        if (pSSysViewPanelItem.getADPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysViewPanelItem.getADPSDELogicId())) != null) {
            this.onFillParentInfo_ADPSDELogic(pSSysViewPanelItem, (PSDELogic)iEntity);
        }
        if (pSSysViewPanelItem.getPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSSysViewPanelItem.getPSDELogicId())) != null) {
            this.onFillParentInfo_PSDELogic(pSSysViewPanelItem, (PSDELogic)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEReportId() != null && (iEntity = cloneSession.getEntity("PSDEREPORT", (Object)pSSysViewPanelItem.getPSDEReportId())) != null) {
            this.onFillParentInfo_PSDEReport(pSSysViewPanelItem, (PSDEReport)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSSysViewPanelItem.getPSDEToolbarId())) != null) {
            this.onFillParentInfo_PSDEToolbar(pSSysViewPanelItem, (PSDEToolbar)iEntity);
        }
        if (pSSysViewPanelItem.getPSDETreeViewId() != null && (iEntity = cloneSession.getEntity("PSDETREEVIEW", (Object)pSSysViewPanelItem.getPSDETreeViewId())) != null) {
            this.onFillParentInfo_PSDETreeView(pSSysViewPanelItem, (PSDETreeView)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSSysViewPanelItem.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSSysViewPanelItem, (PSDEUAGroup)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEUIActionId() != null && (iEntity = cloneSession.getEntity("PSDEUIACTION", (Object)pSSysViewPanelItem.getPSDEUIActionId())) != null) {
            this.onFillParentInfo_PSDEUIAction(pSSysViewPanelItem, (PSDEUIAction)iEntity);
        }
        if (pSSysViewPanelItem.getOpenPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysViewPanelItem.getOpenPSDEViewId())) != null) {
            this.onFillParentInfo_OpenPSDEView(pSSysViewPanelItem, (PSDEViewBase)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysViewPanelItem.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSSysViewPanelItem, (PSDEViewBase)iEntity);
        }
        if (pSSysViewPanelItem.getRefLinkPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysViewPanelItem.getRefLinkPSDEViewId())) != null) {
            this.onFillParentInfo_RefLinkPSDEView(pSSysViewPanelItem, (PSDEViewBase)iEntity);
        }
        if (pSSysViewPanelItem.getRefPickupPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSSysViewPanelItem.getRefPickupPSDEViewId())) != null) {
            this.onFillParentInfo_RefPickupPSDEView(pSSysViewPanelItem, (PSDEViewBase)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEWizardId() != null && (iEntity = cloneSession.getEntity("PSDEWIZARD", (Object)pSSysViewPanelItem.getPSDEWizardId())) != null) {
            this.onFillParentInfo_PSDEWizard(pSSysViewPanelItem, (PSDEWizard)iEntity);
        }
        if (pSSysViewPanelItem.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysViewPanelItem.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSSysViewPanelItem, (PSLanguageRes)iEntity);
        }
        if (pSSysViewPanelItem.getPHPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysViewPanelItem.getPHPSLanResId())) != null) {
            this.onFillParentInfo_PHPSLanRes(pSSysViewPanelItem, (PSLanguageRes)iEntity);
        }
        if (pSSysViewPanelItem.getTipPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSSysViewPanelItem.getTipPSLanResId())) != null) {
            this.onFillParentInfo_TipPSLanRes(pSSysViewPanelItem, (PSLanguageRes)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysCalendarId() != null && (iEntity = cloneSession.getEntity("PSSYSCALENDAR", (Object)pSSysViewPanelItem.getPSSysCalendarId())) != null) {
            this.onFillParentInfo_PSSysCalendar(pSSysViewPanelItem, (PSSysCalendar)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSSysViewPanelItem.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSSysViewPanelItem, (PSSysCounter)iEntity);
        }
        if (pSSysViewPanelItem.getCtrlPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysViewPanelItem.getCtrlPSSysCssId())) != null) {
            this.onFillParentInfo_CtrlPSSysCss(pSSysViewPanelItem, (PSSysCss)iEntity);
        }
        if (pSSysViewPanelItem.getLabelPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysViewPanelItem.getLabelPSSysCssId())) != null) {
            this.onFillParentInfo_LabelPSSysCss(pSSysViewPanelItem, (PSSysCss)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSSysViewPanelItem.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSSysViewPanelItem, (PSSysCss)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysDashboardId() != null && (iEntity = cloneSession.getEntity("PSSYSDASHBOARD", (Object)pSSysViewPanelItem.getPSSysDashboardId())) != null) {
            this.onFillParentInfo_PSSysDashboard(pSSysViewPanelItem, (PSSysDashboard)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSSysViewPanelItem.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSSysViewPanelItem, (PSSysDynaModel)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysEditorStyleId() != null && (iEntity = cloneSession.getEntity("PSSYSEDITORSTYLE", (Object)pSSysViewPanelItem.getPSSysEditorStyleId())) != null) {
            this.onFillParentInfo_PSSysEditorStyle(pSSysViewPanelItem, (PSSysEditorStyle)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSSysViewPanelItem.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSSysViewPanelItem, (PSSysImage)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysMapViewId() != null && (iEntity = cloneSession.getEntity("PSSYSMAPVIEW", (Object)pSSysViewPanelItem.getPSSysMapViewId())) != null) {
            this.onFillParentInfo_PSSysMapView(pSSysViewPanelItem, (PSSysMapView)iEntity);
        }
        if (pSSysViewPanelItem.getOpenPSSysPDTViewId() != null && (iEntity = cloneSession.getEntity("PSSYSPDTVIEW", (Object)pSSysViewPanelItem.getOpenPSSysPDTViewId())) != null) {
            this.onFillParentInfo_OpenPSSysPDTView(pSSysViewPanelItem, (PSSysPDTView)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSSysViewPanelItem.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSSysViewPanelItem, (PSSysPFPlugin)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysResourceId() != null && (iEntity = cloneSession.getEntity("PSSYSRESOURCE", (Object)pSSysViewPanelItem.getPSSysResourceId())) != null) {
            this.onFillParentInfo_PSSysResource(pSSysViewPanelItem, (PSSysResource)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysSearchBarId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHBAR", (Object)pSSysViewPanelItem.getPSSysSearchBarId())) != null) {
            this.onFillParentInfo_PSSysSearchBar(pSSysViewPanelItem, (PSSysSearchBar)iEntity);
        }
        if (pSSysViewPanelItem.getPPSSysViewPanelItemId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANELITEM", (Object)pSSysViewPanelItem.getPPSSysViewPanelItemId())) != null) {
            this.onFillParentInfo_PPSSysViewPanelItem(pSSysViewPanelItem, (PSSysViewPanelItem)iEntity);
        }
        if (pSSysViewPanelItem.getPSDEPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSSysViewPanelItem.getPSDEPanelId())) != null) {
            this.onFillParentInfo_PSDEPanel(pSSysViewPanelItem, (PSSysViewPanel)iEntity);
        }
        if (pSSysViewPanelItem.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSSysViewPanelItem.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSSysViewPanelItem, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSSysViewPanelItem, bl);
        pSSysViewPanelItem.resetCssId();
        pSSysViewPanelItem.resetLableCssId();
    }

    protected void onCheckEntity(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ActiveDataMode(bl, pSSysViewPanelItem, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ADPSDELogicId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_AL_Pos(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BlankLogic(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BL_Pos(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BorderStyle(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BottomPos(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BtnActionType(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CaptionPos(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Child_Col_LG(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Child_Col_MD(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Child_Col_SM(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Child_Col_XS(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CollapsibleFlag(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColModel(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ColSpan(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_LG_OS(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_MD_OS(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_SM_OS(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_Width(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Col_XS_OS(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ContentType(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CounterMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CssId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlDynaClass(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlHeight(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlPSSysCssId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlRawCssStyle(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlType(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlWidth(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataPanelMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DataSource(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DetailStyle(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaClass(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorType(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EditorTypeName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EmptyCaption(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableAnchor(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableLogic(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FieldStates(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexAlign(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexBasis(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexDir(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexGrow(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexShrink(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FlexVAlign(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GetDataTimer(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_GridRowId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HAlign(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HAlignSelf(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HeightMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlContent(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HtmlPageUrl(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IconAlign(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_IgnoreInput(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam10(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam11(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam12(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam2(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam3(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam4(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam5(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam6(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam7(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam8(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParam9(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemParams(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ItemType(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelDynaClass(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelPSSysCssId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LabelRawCssStyle(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LableCssId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LayoutMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPos(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LogicName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenPSAppViewId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenPSDEViewId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OpenPSSysPDTViewId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrientationMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PHPSLanResName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PlaceHolder(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysViewPanelItemId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PPSSysViewPanelItemName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PreviewHtml(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSAppMenuId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCodeListId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataViewId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataViewName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRItemId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEListId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDELogicId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEPanelId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEReportId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDESearchFormId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUIActionId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDashboardId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysEditorStyleId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMapViewId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysResourceId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchBarId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelItemId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelItemName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawContent(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawCssStyle(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceMethod(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RawServiceUrl(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadOnlyMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCtrl2Name(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCtrl2Usage(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCtrlName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCtrlUsage(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefLinkPSDEViewId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPickupPSDEViewId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEACModeId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEDataSetId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefPSDEName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RenderMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ResetItemName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RightPos(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RowSpan(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ShowCaption(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpacingBottom(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpacingLeft(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpacingRight(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SpacingTop(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SwapMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TabIndex(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TargetType(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TemplateMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResId(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TipPSLanResName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TitleBarCloseMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ToggleMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TooltipInfo(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopPos(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VAlign(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VAlignSelf(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueFormat(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValueItemName(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VisibleLogic(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_WidthMode(bl, pSSysViewPanelItem, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSSysViewPanelItem, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ActiveDataMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isActiveDataModeDirty() : !pSSysViewPanelItem.isActiveDataModeDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getActiveDataMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ActiveDataMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ACTIVEDATAMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ADPSDELogicId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isADPSDELogicIdDirty() : !pSSysViewPanelItem.isADPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getADPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ADPSDELogicId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ADPSDELOGICID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_AL_Pos(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isAL_PosDirty() : !pSSysViewPanelItem.isAL_PosDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getAL_Pos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_AL_Pos_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("AL_POS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BlankLogic(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isBlankLogicDirty() : !pSSysViewPanelItem.isBlankLogicDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getBlankLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BlankLogic_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BLANKLOGIC");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BL_Pos(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isBL_PosDirty() : !pSSysViewPanelItem.isBL_PosDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getBL_Pos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BL_Pos_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BL_POS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BorderStyle(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isBorderStyleDirty() : !pSSysViewPanelItem.isBorderStyleDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getBorderStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BorderStyle_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BORDERSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BottomPos(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isBottomPosDirty() : !pSSysViewPanelItem.isBottomPosDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getBottomPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BottomPos_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BOTTOMPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BtnActionType(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isBtnActionTypeDirty() : !pSSysViewPanelItem.isBtnActionTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getBtnActionType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BtnActionType_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BTNACTIONTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isBusyIndicatorDirty() : !pSSysViewPanelItem.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCapPSLanResIdDirty() : !pSSysViewPanelItem.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCapPSLanResNameDirty() : !pSSysViewPanelItem.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Caption(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCaptionDirty() : !pSSysViewPanelItem.isCaptionDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CaptionPos(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCaptionPosDirty() : !pSSysViewPanelItem.isCaptionPosDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCaptionPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CaptionPos_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CAPTIONPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Child_Col_LG(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isChild_Col_LGDirty() : !pSSysViewPanelItem.isChild_Col_LGDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getChild_Col_LG();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Child_Col_LG_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILD_COL_LG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Child_Col_MD(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isChild_Col_MDDirty() : !pSSysViewPanelItem.isChild_Col_MDDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getChild_Col_MD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Child_Col_MD_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILD_COL_MD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Child_Col_SM(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isChild_Col_SMDirty() : !pSSysViewPanelItem.isChild_Col_SMDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getChild_Col_SM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Child_Col_SM_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILD_COL_SM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Child_Col_XS(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isChild_Col_XSDirty() : !pSSysViewPanelItem.isChild_Col_XSDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getChild_Col_XS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Child_Col_XS_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CHILD_COL_XS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isColIdDirty() : !pSSysViewPanelItem.isColIdDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getColId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CollapsibleFlag(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCollapsibleFlagDirty() : !pSSysViewPanelItem.isCollapsibleFlagDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCollapsibleFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CollapsibleFlag_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLLAPSIBLEFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColModel(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isColModelDirty() : !pSSysViewPanelItem.isColModelDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getColModel();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ColModel_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLMODEL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ColSpan(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isColSpanDirty() : !pSSysViewPanelItem.isColSpanDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getColSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ColSpan_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COLSPAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_LG(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCol_LGDirty() : !pSSysViewPanelItem.isCol_LGDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCol_LG();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_LG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_LG_OS(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCol_LG_OSDirty() : !pSSysViewPanelItem.isCol_LG_OSDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCol_LG_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_LG_OS_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_LG_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_MD(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCol_MDDirty() : !pSSysViewPanelItem.isCol_MDDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCol_MD();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_MD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_MD_OS(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCol_MD_OSDirty() : !pSSysViewPanelItem.isCol_MD_OSDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCol_MD_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_MD_OS_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_MD_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_SM(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCol_SMDirty() : !pSSysViewPanelItem.isCol_SMDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCol_SM();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_SM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_SM_OS(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCol_SM_OSDirty() : !pSSysViewPanelItem.isCol_SM_OSDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCol_SM_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_SM_OS_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_SM_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_Width(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCol_WidthDirty() : !pSSysViewPanelItem.isCol_WidthDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCol_Width();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_Width_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_XS(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCol_XSDirty() : !pSSysViewPanelItem.isCol_XSDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCol_XS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_XS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Col_XS_OS(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCol_XS_OSDirty() : !pSSysViewPanelItem.isCol_XS_OSDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCol_XS_OS();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Col_XS_OS_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COL_XS_OS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ContentType(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isContentTypeDirty() : !pSSysViewPanelItem.isContentTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getContentType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ContentType_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONTENTTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CounterId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCounterIdDirty() : !pSSysViewPanelItem.isCounterIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CounterId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CounterMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCounterModeDirty() : !pSSysViewPanelItem.isCounterModeDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCounterMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CounterMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("COUNTERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CssId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCssIdDirty() : !pSSysViewPanelItem.isCssIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CssId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlDynaClass(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCtrlDynaClassDirty() : !pSSysViewPanelItem.isCtrlDynaClassDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCtrlDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlDynaClass_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLDYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlHeight(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCtrlHeightDirty() : !pSSysViewPanelItem.isCtrlHeightDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCtrlHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlHeight_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLHEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlPSSysCssId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCtrlPSSysCssIdDirty() : !pSSysViewPanelItem.isCtrlPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCtrlPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlPSSysCssId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlRawCssStyle(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCtrlRawCssStyleDirty() : !pSSysViewPanelItem.isCtrlRawCssStyleDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCtrlRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlRawCssStyle_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLRAWCSSSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlType(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCtrlTypeDirty() : !pSSysViewPanelItem.isCtrlTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCtrlType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlType_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlWidth(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCtrlWidthDirty() : !pSSysViewPanelItem.isCtrlWidthDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCtrlWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlWidth_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLWIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCustomCodeDirty() : !pSSysViewPanelItem.isCustomCodeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getCustomCode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isCustomModeDirty() : !pSSysViewPanelItem.isCustomModeDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getCustomMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CustomMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_DataPanelMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isDataPanelModeDirty() : !pSSysViewPanelItem.isDataPanelModeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getDataPanelMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataPanelMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATAPANELMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DataSource(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isDataSourceDirty() : !pSSysViewPanelItem.isDataSourceDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getDataSource();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DataSource_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DATASOURCE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DetailStyle(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isDetailStyleDirty() : !pSSysViewPanelItem.isDetailStyleDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getDetailStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DetailStyle_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DETAILSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaClass(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isDynaClassDirty() : !pSSysViewPanelItem.isDynaClassDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_DynaClass_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorType(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isEditorTypeDirty() : !pSSysViewPanelItem.isEditorTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getEditorType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorType_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EditorTypeName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isEditorTypeNameDirty() : !pSSysViewPanelItem.isEditorTypeNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getEditorTypeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EditorTypeName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EDITORTYPENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EmptyCaption(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isEmptyCaptionDirty() : !pSSysViewPanelItem.isEmptyCaptionDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getEmptyCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EmptyCaption_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("EMPTYCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableAnchor(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isEnableAnchorDirty() : !pSSysViewPanelItem.isEnableAnchorDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getEnableAnchor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableAnchor_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEANCHOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableLogic(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isEnableLogicDirty() : !pSSysViewPanelItem.isEnableLogicDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getEnableLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_EnableLogic_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_FieldName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isFieldNameDirty() : !pSSysViewPanelItem.isFieldNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getFieldName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FieldName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FieldStates(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isFieldStatesDirty() : !pSSysViewPanelItem.isFieldStatesDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getFieldStates();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FieldStates_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FIELDSTATES");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexAlign(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isFlexAlignDirty() : !pSSysViewPanelItem.isFlexAlignDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getFlexAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexAlign_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexBasis(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isFlexBasisDirty() : !pSSysViewPanelItem.isFlexBasisDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getFlexBasis();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexBasis_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXBASIS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexDir(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isFlexDirDirty() : !pSSysViewPanelItem.isFlexDirDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getFlexDir();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexDir_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXDIR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexGrow(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isFlexGrowDirty() : !pSSysViewPanelItem.isFlexGrowDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getFlexGrow();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexGrow_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXGROW");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexShrink(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isFlexShrinkDirty() : !pSSysViewPanelItem.isFlexShrinkDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getFlexShrink();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FlexShrink_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXSHRINK");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FlexVAlign(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isFlexVAlignDirty() : !pSSysViewPanelItem.isFlexVAlignDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getFlexVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FlexVAlign_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FLEXVALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_GetDataTimer(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isGetDataTimerDirty() : !pSSysViewPanelItem.isGetDataTimerDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getGetDataTimer();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GetDataTimer_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_GridRowId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isGridRowIdDirty() : !pSSysViewPanelItem.isGridRowIdDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getGridRowId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_GridRowId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("GRIDROWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HAlign(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isHAlignDirty() : !pSSysViewPanelItem.isHAlignDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getHAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HAlign_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HAlignSelf(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isHAlignSelfDirty() : !pSSysViewPanelItem.isHAlignSelfDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getHAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HAlignSelf_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HALIGNSELF");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Height(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isHeightDirty() : !pSSysViewPanelItem.isHeightDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HeightMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isHeightModeDirty() : !pSSysViewPanelItem.isHeightModeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getHeightMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HeightMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HEIGHTMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HtmlContent(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isHtmlContentDirty() : !pSSysViewPanelItem.isHtmlContentDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getHtmlContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlContent_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("HTMLCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HtmlPageUrl(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isHtmlPageUrlDirty() : !pSSysViewPanelItem.isHtmlPageUrlDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getHtmlPageUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HtmlPageUrl_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_IconAlign(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isIconAlignDirty() : !pSSysViewPanelItem.isIconAlignDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getIconAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_IconAlign_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_IgnoreInput(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isIgnoreInputDirty() : !pSSysViewPanelItem.isIgnoreInputDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getIgnoreInput();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_IgnoreInput_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("IGNOREINPUT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParamDirty() : !pSSysViewPanelItem.isItemParamDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getItemParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParam_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam10(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam10Dirty() : !pSSysViewPanelItem.isItemParam10Dirty()) {
            return null;
        }
        Double d = pSSysViewPanelItem.getItemParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam10_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam11(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam11Dirty() : !pSSysViewPanelItem.isItemParam11Dirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getItemParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam11_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam12(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam12Dirty() : !pSSysViewPanelItem.isItemParam12Dirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getItemParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam12_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam2(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam2Dirty() : !pSSysViewPanelItem.isItemParam2Dirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getItemParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParam2_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam3(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam3Dirty() : !pSSysViewPanelItem.isItemParam3Dirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getItemParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParam3_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam4(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam4Dirty() : !pSSysViewPanelItem.isItemParam4Dirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getItemParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParam4_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam5(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam5Dirty() : !pSSysViewPanelItem.isItemParam5Dirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getItemParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam5_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam6(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam6Dirty() : !pSSysViewPanelItem.isItemParam6Dirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getItemParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam6_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam7(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam7Dirty() : !pSSysViewPanelItem.isItemParam7Dirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getItemParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam7_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam8(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam8Dirty() : !pSSysViewPanelItem.isItemParam8Dirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getItemParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam8_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParam9(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParam9Dirty() : !pSSysViewPanelItem.isItemParam9Dirty()) {
            return null;
        }
        Double d = pSSysViewPanelItem.getItemParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ItemParam9_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemParams(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemParamsDirty() : !pSSysViewPanelItem.isItemParamsDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getItemParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemParams_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ItemType(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isItemTypeDirty() && !bl2 : !pSSysViewPanelItem.isItemTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getItemType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_ItemType_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ITEMTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelDynaClass(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isLabelDynaClassDirty() : !pSSysViewPanelItem.isLabelDynaClassDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getLabelDynaClass();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LabelDynaClass_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELDYNACLASS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelPSSysCssId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isLabelPSSysCssIdDirty() : !pSSysViewPanelItem.isLabelPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getLabelPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LabelPSSysCssId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELPSSYSCSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LabelRawCssStyle(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isLabelRawCssStyleDirty() : !pSSysViewPanelItem.isLabelRawCssStyleDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getLabelRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LabelRawCssStyle_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABELRAWCSSSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LableCssId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isLableCssIdDirty() : !pSSysViewPanelItem.isLableCssIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getLableCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LableCssId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LABLECSSID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LayoutMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isLayoutModeDirty() : !pSSysViewPanelItem.isLayoutModeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getLayoutMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LayoutMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_LeftPos(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isLeftPosDirty() : !pSSysViewPanelItem.isLeftPosDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getLeftPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LeftPos_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LEFTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LogicName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isLogicNameDirty() : !pSSysViewPanelItem.isLogicNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getLogicName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_LogicName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isMemoDirty() : !pSSysViewPanelItem.isMemoDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OpenPSAppViewId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isOpenPSAppViewIdDirty() : !pSSysViewPanelItem.isOpenPSAppViewIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getOpenPSAppViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenPSAppViewId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENPSAPPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenPSDEViewId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isOpenPSDEViewIdDirty() : !pSSysViewPanelItem.isOpenPSDEViewIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getOpenPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenPSDEViewId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OpenPSSysPDTViewId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isOpenPSSysPDTViewIdDirty() : !pSSysViewPanelItem.isOpenPSSysPDTViewIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getOpenPSSysPDTViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OpenPSSysPDTViewId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("OPENPSSYSPDTVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isOrderValueDirty() : !pSSysViewPanelItem.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrientationMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isOrientationModeDirty() : !pSSysViewPanelItem.isOrientationModeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getOrientationMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OrientationMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ORIENTATIONMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PHPSLanResId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPHPSLanResIdDirty() : !pSSysViewPanelItem.isPHPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPHPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHPSLANRESID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PHPSLanResName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPHPSLanResNameDirty() : !pSSysViewPanelItem.isPHPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPHPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PHPSLanResName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PHPSLANRESNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PlaceHolder(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPlaceHolderDirty() : !pSSysViewPanelItem.isPlaceHolderDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPlaceHolder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PlaceHolder_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PLACEHOLDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysViewPanelItemId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPPSSysViewPanelItemIdDirty() : !pSSysViewPanelItem.isPPSSysViewPanelItemIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPPSSysViewPanelItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysViewPanelItemId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSVIEWPANELITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PPSSysViewPanelItemName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPPSSysViewPanelItemNameDirty() : !pSSysViewPanelItem.isPPSSysViewPanelItemNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPPSSysViewPanelItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PPSSysViewPanelItemName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PPSSYSVIEWPANELITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPredefinedTypeDirty() : !pSSysViewPanelItem.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREDEFINEDTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PreviewHtml(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPreviewHtmlDirty() : !pSSysViewPanelItem.isPreviewHtmlDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPreviewHtml();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PreviewHtml_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PREVIEWHTML");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSACHandlerIdDirty() : !pSSysViewPanelItem.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSAppMenuId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSAppMenuIdDirty() : !pSSysViewPanelItem.isPSAppMenuIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSAppMenuId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSAppMenuId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSAPPMENUID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCodeListId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSCodeListIdDirty() : !pSSysViewPanelItem.isPSCodeListIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSCodeListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCodeListId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCODELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSCtrlIdDirty() : !pSSysViewPanelItem.isPSCtrlIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSCtrlId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSCtrlLogicGroupIdDirty() : !pSSysViewPanelItem.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSCtrlNameDirty() : !pSSysViewPanelItem.isPSCtrlNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSCtrlName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEActionIdDirty() : !pSSysViewPanelItem.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEChartId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEChartIdDirty() : !pSSysViewPanelItem.isPSDEChartIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEChartId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEDataSetIdDirty() : !pSSysViewPanelItem.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataViewId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEDataViewIdDirty() : !pSSysViewPanelItem.isPSDEDataViewIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEDataViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataViewId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataViewName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEDataViewNameDirty() : !pSSysViewPanelItem.isPSDEDataViewNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEDataViewName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataViewName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDRId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEDRIdDirty() : !pSSysViewPanelItem.isPSDEDRIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEDRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEDRItemId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEDRItemIdDirty() : !pSSysViewPanelItem.isPSDEDRItemIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEDRItemId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRItemId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEFormIdDirty() : !pSSysViewPanelItem.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEGridIdDirty() : !pSSysViewPanelItem.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEGridId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEIdDirty() : !pSSysViewPanelItem.isPSDEIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEListId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEListIdDirty() : !pSSysViewPanelItem.isPSDEListIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEListId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDELISTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDELogicId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDELogicIdDirty() : !pSSysViewPanelItem.isPSDELogicIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDELogicId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDENameDirty() : !pSSysViewPanelItem.isPSDENameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEPanelId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEPanelIdDirty() : !pSSysViewPanelItem.isPSDEPanelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEPanelId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEPANELID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEReportId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEReportIdDirty() : !pSSysViewPanelItem.isPSDEReportIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEReportId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEReportId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEREPORTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDESearchFormId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDESearchFormIdDirty() : !pSSysViewPanelItem.isPSDESearchFormIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDESearchFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDESearchFormId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDESEARCHFORMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEToolbarId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEToolbarIdDirty() : !pSSysViewPanelItem.isPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDETreeViewIdDirty() : !pSSysViewPanelItem.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDETreeViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEUAGroupIdDirty() : !pSSysViewPanelItem.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUIActionId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEUIActionIdDirty() : !pSSysViewPanelItem.isPSDEUIActionIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEUIActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUIActionId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEViewBaseIdDirty() : !pSSysViewPanelItem.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEViewBaseId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEWizardId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSDEWizardIdDirty() : !pSSysViewPanelItem.isPSDEWizardIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSDEWizardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysCalendarIdDirty() : !pSSysViewPanelItem.isPSSysCalendarIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysCalendarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCALENDARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysCounterIdDirty() : !pSSysViewPanelItem.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysCssIdDirty() : !pSSysViewPanelItem.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDashboardId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysDashboardIdDirty() : !pSSysViewPanelItem.isPSSysDashboardIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysDashboardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDashboardId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSDASHBOARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysDynaModelIdDirty() : !pSSysViewPanelItem.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysDynaModelNameDirty() : !pSSysViewPanelItem.isPSSysDynaModelNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysDynaModelName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysEditorStyleId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysEditorStyleIdDirty() : !pSSysViewPanelItem.isPSSysEditorStyleIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysEditorStyleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysEditorStyleId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSEDITORSTYLEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysImageIdDirty() : !pSSysViewPanelItem.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMapViewId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysMapViewIdDirty() : !pSSysViewPanelItem.isPSSysMapViewIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysMapViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMapViewId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMAPVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysPFPluginIdDirty() : !pSSysViewPanelItem.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysResourceId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysResourceIdDirty() : !pSSysViewPanelItem.isPSSysResourceIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysResourceId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysResourceId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSRESOURCEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysSearchBarId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysSearchBarIdDirty() : !pSSysViewPanelItem.isPSSysSearchBarIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysSearchBarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchBarId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSSEARCHBARID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysViewPanelIdDirty() && !bl2 : !pSSysViewPanelItem.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysViewPanelId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelItemId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysViewPanelItemIdDirty() && !bl2 : !pSSysViewPanelItem.isPSSysViewPanelItemIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysViewPanelItemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELITEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelItemId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELITEMID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelItemName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysViewPanelItemNameDirty() && !bl2 : !pSSysViewPanelItem.isPSSysViewPanelItemNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysViewPanelItemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELITEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelItemName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        } else {
            boolean bl4 = true;
            if (bl4) {
                String string3 = "";
                string3 = "PSSYSVIEWPANELID";
                String string4 = this.checkFieldDupRule(this.getPSSysViewPanelItemDEModel(), "PSSYSVIEWPANELITEMNAME", string3, pSSysViewPanelItem, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSVIEWPANELITEMNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysViewPanelName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isPSSysViewPanelNameDirty() && !bl2 : !pSSysViewPanelItem.isPSSysViewPanelNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getPSSysViewPanelName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSVIEWPANELNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_RawContent(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRawContentDirty() : !pSSysViewPanelItem.isRawContentDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRawContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawContent_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWCONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawCssStyle(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRawCssStyleDirty() : !pSSysViewPanelItem.isRawCssStyleDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRawCssStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawCssStyle_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWCSSSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawServiceMethod(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRawServiceMethodDirty() : !pSSysViewPanelItem.isRawServiceMethodDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRawServiceMethod();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceMethod_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEMETHOD");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RawServiceUrl(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRawServiceUrlDirty() : !pSSysViewPanelItem.isRawServiceUrlDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRawServiceUrl();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RawServiceUrl_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RAWSERVICEURL");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ReadOnlyMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isReadOnlyModeDirty() : !pSSysViewPanelItem.isReadOnlyModeDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getReadOnlyMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReadOnlyMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("READONLYMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCtrl2Name(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefCtrl2NameDirty() : !pSSysViewPanelItem.isRefCtrl2NameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefCtrl2Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefCtrl2Name_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCTRL2NAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCtrl2Usage(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefCtrl2UsageDirty() : !pSSysViewPanelItem.isRefCtrl2UsageDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefCtrl2Usage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefCtrl2Usage_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCTRL2USAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCtrlName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefCtrlNameDirty() : !pSSysViewPanelItem.isRefCtrlNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefCtrlName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefCtrlName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCTRLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefCtrlUsage(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefCtrlUsageDirty() : !pSSysViewPanelItem.isRefCtrlUsageDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefCtrlUsage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefCtrlUsage_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFCTRLUSAGE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefLinkPSDEViewId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefLinkPSDEViewIdDirty() : !pSSysViewPanelItem.isRefLinkPSDEViewIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefLinkPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefLinkPSDEViewId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFLINKPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPickupPSDEViewId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefPickupPSDEViewIdDirty() : !pSSysViewPanelItem.isRefPickupPSDEViewIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefPickupPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPickupPSDEViewId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPICKUPPSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEACModeId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefPSDEACModeIdDirty() : !pSSysViewPanelItem.isRefPSDEACModeIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefPSDEACModeId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEACModeId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEACMODEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEDataSetId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefPSDEDataSetIdDirty() : !pSSysViewPanelItem.isRefPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEDataSetId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEDATASETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefPSDEIdDirty() : !pSSysViewPanelItem.isRefPSDEIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDEID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RefPSDEName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRefPSDENameDirty() : !pSSysViewPanelItem.isRefPSDENameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRefPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefPSDEName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("REFPSDENAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RenderMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRenderModeDirty() : !pSSysViewPanelItem.isRenderModeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getRenderMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RenderMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RENDERMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ResetItemName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isResetItemNameDirty() : !pSSysViewPanelItem.isResetItemNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getResetItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ResetItemName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RESETITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RightPos(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRightPosDirty() : !pSSysViewPanelItem.isRightPosDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getRightPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RightPos_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("RIGHTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_RowSpan(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isRowSpanDirty() : !pSSysViewPanelItem.isRowSpanDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getRowSpan();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RowSpan_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ROWSPAN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ShowCaption(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isShowCaptionDirty() : !pSSysViewPanelItem.isShowCaptionDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getShowCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ShowCaption_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SHOWCAPTION");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpacingBottom(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isSpacingBottomDirty() : !pSSysViewPanelItem.isSpacingBottomDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getSpacingBottom();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpacingBottom_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPACINGBOTTOM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpacingLeft(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isSpacingLeftDirty() : !pSSysViewPanelItem.isSpacingLeftDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getSpacingLeft();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpacingLeft_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPACINGLEFT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpacingRight(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isSpacingRightDirty() : !pSSysViewPanelItem.isSpacingRightDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getSpacingRight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpacingRight_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPACINGRIGHT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SpacingTop(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isSpacingTopDirty() : !pSSysViewPanelItem.isSpacingTopDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getSpacingTop();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SpacingTop_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SPACINGTOP");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_SwapMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isSwapModeDirty() : !pSSysViewPanelItem.isSwapModeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getSwapMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SwapMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SWAPMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TabIndex(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTabIndexDirty() : !pSSysViewPanelItem.isTabIndexDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getTabIndex();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TabIndex_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TABINDEX");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTargetIdDirty() : !pSSysViewPanelItem.isTargetIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getTargetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTargetNameDirty() : !pSSysViewPanelItem.isTargetNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getTargetName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TargetType(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTargetTypeDirty() : !pSSysViewPanelItem.isTargetTypeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getTargetType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TargetType_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TARGETTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TemplateMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTemplateModeDirty() : !pSSysViewPanelItem.isTemplateModeDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getTemplateMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TemplateMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TEMPLATEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TipPSLanResId(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTipPSLanResIdDirty() : !pSSysViewPanelItem.isTipPSLanResIdDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getTipPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResId_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TipPSLanResName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTipPSLanResNameDirty() : !pSSysViewPanelItem.isTipPSLanResNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getTipPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TipPSLanResName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TitleBarCloseMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTitleBarCloseModeDirty() : !pSSysViewPanelItem.isTitleBarCloseModeDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getTitleBarCloseMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TitleBarCloseMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TITLEBARCLOSEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ToggleMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isToggleModeDirty() : !pSSysViewPanelItem.isToggleModeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getToggleMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ToggleMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOGGLEMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TooltipInfo(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTooltipInfoDirty() : !pSSysViewPanelItem.isTooltipInfoDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getTooltipInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_TooltipInfo_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_TopPos(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isTopPosDirty() : !pSSysViewPanelItem.isTopPosDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getTopPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TopPos_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("TOPPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isUserTagDirty() : !pSSysViewPanelItem.isUserTagDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isUserTag2Dirty() : !pSSysViewPanelItem.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_VAlign(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isVAlignDirty() : !pSSysViewPanelItem.isVAlignDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VAlign_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIGN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VAlignSelf(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isVAlignSelfDirty() : !pSSysViewPanelItem.isVAlignSelfDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getVAlignSelf();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VAlignSelf_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALIGNSELF");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueFormat(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isValueFormatDirty() : !pSSysViewPanelItem.isValueFormatDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getValueFormat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueFormat_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEFORMAT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_ValueItemName(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isValueItemNameDirty() : !pSSysViewPanelItem.isValueItemNameDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getValueItemName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ValueItemName_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("VALUEITEMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_VisibleLogic(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isVisibleLogicDirty() : !pSSysViewPanelItem.isVisibleLogicDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getVisibleLogic();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VisibleLogic_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
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

    protected EntityFieldError onCheckField_Width(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isWidthDirty() : !pSSysViewPanelItem.isWidthDirty()) {
            return null;
        }
        Integer n = pSSysViewPanelItem.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTH");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_WidthMode(boolean bl, PSSysViewPanelItem pSSysViewPanelItem, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysViewPanelItem.isWidthModeDirty() : !pSSysViewPanelItem.isWidthModeDirty()) {
            return null;
        }
        String string = pSSysViewPanelItem.getWidthMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_WidthMode_Default((IEntity)pSSysViewPanelItem, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("WIDTHMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected void onSyncEntity(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSSysViewPanelItem, bl);
    }

    protected void onSyncIndexEntities(PSSysViewPanelItem pSSysViewPanelItem, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSSysViewPanelItem, bl);
    }

    public Object getDataContextValue(PSSysViewPanelItem pSSysViewPanelItem, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEACMODE", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODEID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEACMODENAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSSysViewPanelItem, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
            if (StringHelper.compare((String)iDataContextParam.getDEName(), (String)"PSDEDATASET", (boolean)true) == 0 && StringHelper.compare((String)iDataContextParam.getDEFName(), (String)"PSDEID", (boolean)true) == 0 && (StringHelper.isNullOrEmpty((String)iDataContextParam.getReferItem()) || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETID", (boolean)true) == 0 || StringHelper.compare((String)iDataContextParam.getReferItem(), (String)"REFPSDEDATASETNAME", (boolean)true) == 0) && (object = super.getDataContextValue((IEntity)pSSysViewPanelItem, "refpsdeid", iDataContextParam)) != null) {
                return object;
            }
        }
        if ((object = super.getDataContextValue((IEntity)pSSysViewPanelItem, string, iDataContextParam)) != null) {
            return object;
        }
        PSSysViewPanel pSSysViewPanel = pSSysViewPanelItem.getPSSysViewPanel();
        if (pSSysViewPanel != null && pSSysViewPanel.contains(string)) {
            return pSSysViewPanel.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysViewPanelItem pSSysViewPanelItem, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel((IEntity)pSSysViewPanelItem, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ACTIVEDATAMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ActiveDataMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"AL_POS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_AL_Pos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BLANKLOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BlankLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BL_POS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BL_Pos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BORDERSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BorderStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BOTTOMPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BottomPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BTNACTIONTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BtnActionType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BUSYINDICATOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BusyIndicator_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CAPTIONPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CaptionPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILD_COL_LG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Child_Col_LG_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILD_COL_MD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Child_Col_MD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILD_COL_SM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Child_Col_SM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CHILD_COL_XS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Child_Col_XS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLLAPSIBLEFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CollapsibleFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLMODEL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColModel_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COLSPAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ColSpan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_LG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_LG_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_LG_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_LG_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_MD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_MD_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_MD_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_MD_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_SM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_SM_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_SM_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_SM_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_Width_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_XS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_XS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COL_XS_OS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Col_XS_OS_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CONTENTTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ContentType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"COUNTERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CounterMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLDYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlDynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLHEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlHeight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLRAWCSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlRawCssStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLWIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlWidth_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATAPANELMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataPanelMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATASOURCE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataSource_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DATASOURCETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DataSourceText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DETAILSTYLETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DetailStyleText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EDITORTYPENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EditorTypeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"EMPTYCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EmptyCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEANCHOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableAnchor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FIELDSTATES", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FieldStates_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXBASIS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexBasis_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXDIR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexDir_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXGROW", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexGrow_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXSHRINK", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexShrink_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FLEXVALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FlexVAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GETDATATIMER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GetDataTimer_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"GRIDROWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_GridRowId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HALIGNSELF", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HAlignSelf_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HeightMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HTMLPAGEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HtmlPageUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ICONALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IconAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"IGNOREINPUT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_IgnoreInput_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ITEMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ItemType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELDYNACLASS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelDynaClass_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELPSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelPSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELPSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelPSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABELRAWCSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LabelRawCssStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LABLECSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LableCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LogicName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MOBFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MobFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSAPPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSAppViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSAPPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSAppViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSSYSPDTVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSSysPDTViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"OPENPSSYSPDTVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OpenPSSysPDTViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORIENTATIONMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrientationMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PHPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PHPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLACEHOLDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PlaceHolder_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PLAYOUTMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PLayoutMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSVIEWPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysViewPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PPSSYSVIEWPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PPSSysViewPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREVIEWHTML", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PreviewHtml_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSAPPMENUNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSAppMenuName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCODELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCodeListName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLLOGICGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlLogicGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEACTIONNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEActionName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEDRID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDRNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDRName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEFormName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDELISTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDELISTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEListName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEReportId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEREPORTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEReportName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESEARCHFORMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESearchFormId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDESEARCHFORMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDESearchFormName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETOOLBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEToolbarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDETREEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDETreeViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEUAGroupName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCALENDARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCalendarName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSDASHBOARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDashboardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDASHBOARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDashboardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSDYNAMODELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysDynaModelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSEDITORSTYLENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysEditorStyleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSIMAGENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysImageName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMAPVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMapViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMAPVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMapViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSRESOURCENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysResourceName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchBarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchBarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelItemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWCONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawContent_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWCSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawCssStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEMETHOD", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceMethod_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RAWSERVICEURL", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RawServiceUrl_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"READONLYMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ReadOnlyMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCTRL2NAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCtrl2Name_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCTRL2USAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCtrl2Usage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCTRL2USAGETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCtrl2UsageText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCTRLUSAGE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCtrlUsage_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFCTRLUSAGETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefCtrlUsageText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFLINKPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefLinkPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFLINKPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefLinkPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPICKUPPSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPickupPSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPICKUPPSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPickupPSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEACMODEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEACModeId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEACMODENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEACModeName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEDATASETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEDataSetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"REFPSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RefPSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RENDERMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RenderMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RENDERMODETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RenderModeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RESETITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ResetItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"RIGHTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RightPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ROWSPAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RowSpan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SHOWCAPTION", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ShowCaption_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPACINGBOTTOM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpacingBottom_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPACINGLEFT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpacingLeft_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPACINGRIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpacingRight_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SPACINGTOP", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SpacingTop_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SWAPMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SwapMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TABINDEX", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TabIndex_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TARGETTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TargetType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TEMPLATEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TemplateMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TIPPSLANRESNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TipPSLanResName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TITLEBARCLOSEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TitleBarCloseMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOGGLEMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ToggleMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOOLTIPINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TooltipInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"TOPPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_TopPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"UPDATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UpdateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"USERTAG2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_UserTag2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALIGNSELF", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VAlignSelf_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEFORMAT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueFormat_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VALUEITEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValueItemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"VISIBLELOGIC", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VisibleLogic_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTHMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_WidthMode_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_ActiveDataMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ADPSDELogicId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADPSDELOGICID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ADPSDELogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ADPSDELOGICNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_AL_Pos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("AL_POS", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BlankLogic_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BLANKLOGIC", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BL_Pos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BL_POS", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BorderStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BORDERSTYLE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BottomPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_BtnActionType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BTNACTIONTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BusyIndicator_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CaptionPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CAPTIONPOS", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Child_Col_LG_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Child_Col_MD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Child_Col_SM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Child_Col_XS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ColId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CollapsibleFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ColModel_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COLMODEL", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ColSpan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_LG_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_LG_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_MD_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_MD_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_SM_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_SM_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_XS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Col_XS_OS_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ContentType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONTENTTYPE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CounterId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("COUNTERID", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CounterMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_CssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSID", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlDynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLDYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlHeight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlRawCssStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLRAWCSSSTYLE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlWidth_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
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

    protected String onTestValueRule_DataPanelMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATAPANELMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataSource_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATASOURCE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DataSourceText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DATASOURCETEXT", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILSTYLE", iEntity, bl2, null, false, 16, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[16]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DetailStyleText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DETAILSTYLETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_DynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("DYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORTYPE", iEntity, bl2, null, false, 40, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[40]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EditorTypeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("EDITORTYPENAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_EmptyCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableAnchor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_FieldName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FIELDNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FieldStates_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexBasis_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexDir_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXDIR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FlexGrow_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexShrink_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FlexVAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FLEXVALIGN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_GetDataTimer_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_GridRowId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HALIGN", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HAlignSelf_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HALIGNSELF", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_HeightMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HEIGHTMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HtmlContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTMLCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_HtmlPageUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("HTMLPAGEURL", iEntity, bl2, null, false, 300, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[300]";
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

    protected String onTestValueRule_IgnoreInput_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ItemParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ItemType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ITEMTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelDynaClass_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELDYNACLASS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelPSSysCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELPSSYSCSSID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelPSSysCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELPSSYSCSSNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LabelRawCssStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABELRAWCSSSTYLE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_LableCssId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LABLECSSID", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
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

    protected String onTestValueRule_LeftPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LogicName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("LOGICNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Memo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MEMO", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_MobFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OpenPSAppViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSAPPVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSAppViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSAPPVIEWNAME", iEntity, bl2, null, false, 80, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[80]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSSysPDTViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSSYSPDTVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OpenPSSysPDTViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("OPENPSSYSPDTVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_OrientationMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("ORIENTATIONMODE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PHPSLanResId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PHPSLANRESID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PHPSLanResName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PHPSLANRESNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PlaceHolder_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLACEHOLDER", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PLayoutMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PLAYOUTMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysViewPanelItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSVIEWPANELITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PPSSysViewPanelItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PPSSYSVIEWPANELITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PredefinedTypeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREDEFINEDTYPETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PreviewHtml_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PREVIEWHTML", iEntity, bl2, null, false, 10, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[10]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_PSAppMenuId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSAppMenuName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSAPPMENUNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCodeListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCODELISTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_PSCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCTRLNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
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

    protected String onTestValueRule_PSDEChartId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEChartName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDECHARTNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEDRId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDRName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDRNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSDEListId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEListName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDELISTNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_PSDEPanelId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPANELID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEPanelName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEPANELNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEReportId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEREPORTID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEReportName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEREPORTNAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESearchFormId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESEARCHFORMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDESearchFormName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDESEARCHFORMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEWizardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEWIZARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCalendarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCALENDARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysDashboardId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDASHBOARDID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysDashboardName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSDASHBOARDNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysEditorStyleId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysEditorStyleName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSEDITORSTYLENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysMapViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMAPVIEWID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMapViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMAPVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysResourceId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysResourceName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSRESOURCENAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchBarId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHBARID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysSearchBarName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSSEARCHBARNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysViewPanelItemId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELITEMID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysViewPanelItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSVIEWPANELITEMNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false) && this.checkFieldRegExRule("PSSYSVIEWPANELITEMNAME", iEntity, bl2, "[a-zA-Z_$][a-zA-Z0-9_$]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd)";
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

    protected String onTestValueRule_RawContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWCONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawCssStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWCSSSTYLE", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawServiceMethod_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEMETHOD", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RawServiceUrl_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RAWSERVICEURL", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ReadOnlyMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RefCtrl2Name_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFCTRL2NAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCtrl2Usage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFCTRL2USAGE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCtrl2UsageText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFCTRL2USAGETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFCTRLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCtrlUsage_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFCTRLUSAGE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefCtrlUsageText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFCTRLUSAGETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefLinkPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFLINKPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefLinkPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFLINKPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPickupPSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPICKUPPSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPickupPSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPICKUPPSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEACModeId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEACMODEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEACModeName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEACMODENAME", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEDataSetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEDATASETNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDEID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RefPSDEName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("REFPSDENAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RenderMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RENDERMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RenderModeText_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RENDERMODETEXT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ResetItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("RESETITEMNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_RightPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_RowSpan_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ShowCaption_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SpacingBottom_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPACINGBOTTOM", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpacingLeft_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPACINGLEFT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpacingRight_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPACINGRIGHT", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SpacingTop_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SPACINGTOP", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SwapMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SWAPMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TabIndex_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_TargetId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETID", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TargetType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TARGETTYPE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_TemplateMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_TitleBarCloseMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_ToggleMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("TOGGLEMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
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

    protected String onTestValueRule_TopPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_VAlign_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALIGN", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_VAlignSelf_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALIGNSELF", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueFormat_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEFORMAT", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ValueItemName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("VALUEITEMNAME", iEntity, bl2, null, false, 60, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[60]";
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

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_WidthMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("WIDTHMODE", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSSysViewPanelItem)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        super.onUpdateParent((IEntity)pSSysViewPanelItem);
    }

    @Override
    protected void exportCurXmlModel(PSSysViewPanelItem pSSysViewPanelItem, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSVIEWPANELITEM");
        if (!bl) {
            pSSysViewPanelItem.setCreateDate(null);
            pSSysViewPanelItem.setCreateMan(null);
            pSSysViewPanelItem.setPSSysViewPanelItemId(null);
            pSSysViewPanelItem.setUpdateDate(null);
            pSSysViewPanelItem.setUpdateMan(null);
            pSSysViewPanelItem.setPLayoutMode(null);
            pSSysViewPanelItem.setPPSSysViewPanelItemId(null);
            pSSysViewPanelItem.setMobFlag(null);
            pSSysViewPanelItem.setPSSysViewPanelId(null);
            pSSysViewPanelItem.setPSSysViewPanelName(null);
            super.exportCurXmlModel(pSSysViewPanelItem, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSSysViewPanelItem pSSysViewPanelItem, XmlNode xmlNode) throws Exception {
        this.exportRelatedXmlModel_PSSysViewPanelItem(pSSysViewPanelItem, xmlNode);
        this.exportRelatedXmlModel_PSPanelItemLogic(pSSysViewPanelItem, xmlNode);
        super.onExportRelatedXmlModel(pSSysViewPanelItem, xmlNode);
    }

    protected void exportRelatedXmlModel_PSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, XmlNode xmlNode) throws Exception {
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSSysViewPanelItem> arrayList = null;
        String string = pSSysViewPanelItem.getPSSysViewPanelItemId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSSysViewPanelItemService.selectByPPSSysViewPanelItem(pSSysViewPanelItem, "ORDER BY ORDERVALUE ASC") : pSSysViewPanelItemService.selectTempByPPSSysViewPanelItem(pSSysViewPanelItem, "ORDER BY ORDERVALUE ASC");
        if (arrayList.size() > 0) {
            XmlNode xmlNode2 = new XmlNode();
            xmlNode2.setNodeName("PSSYSVIEWPANELITEMS");
            xmlNode.addNode(xmlNode2);
            for (PSSysViewPanelItem pSSysViewPanelItem2 : arrayList) {
                pSSysViewPanelItem2.set("ORDERVALUE", null);
                pSSysViewPanelItemService.exportXmlModel(pSSysViewPanelItem2, xmlNode2);
            }
        }
    }

    protected void exportRelatedXmlModel_PSPanelItemLogic(PSSysViewPanelItem pSSysViewPanelItem, XmlNode xmlNode) throws Exception {
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<PSPanelItemLogic> arrayList = null;
        String string = pSSysViewPanelItem.getPSSysViewPanelItemId();
        arrayList = string.indexOf("SRFTEMPKEY:") != 0 ? pSPanelItemLogicService.selectByPSSysViewPanelItem(pSSysViewPanelItem, "ORDER BY ORDERVALUE ASC") : pSPanelItemLogicService.selectTempByPSSysViewPanelItem(pSSysViewPanelItem, "ORDER BY ORDERVALUE ASC");
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

    @Override
    protected void onImportRelatedXmlModel(PSSysViewPanelItem pSSysViewPanelItem, XmlNode xmlNode) throws Exception {
        XmlNode xmlNode2 = xmlNode.getChildNodeByNodeName("PSSYSVIEWPANELITEMS");
        this.importRelatedXmlModel_PSSysViewPanelItem(pSSysViewPanelItem, xmlNode2);
        XmlNode xmlNode3 = xmlNode.getChildNodeByNodeName("PSPANELITEMLOGICS");
        this.importRelatedXmlModel_PSPanelItemLogic(pSSysViewPanelItem, xmlNode3);
        super.onImportRelatedXmlModel(pSSysViewPanelItem, xmlNode);
    }

    protected void importRelatedXmlModel_PSSysViewPanelItem(PSSysViewPanelItem pSSysViewPanelItem, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanelItem.getPSSysViewPanelItemId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSSysViewPanelItemService.removeByPPSSysViewPanelItem(pSSysViewPanelItem);
        } else {
            pSSysViewPanelItemService.removeTempByPPSSysViewPanelItem(pSSysViewPanelItem);
        }
        if (xmlNode == null) {
            return;
        }
        Iterator iterator = xmlNode.getChildNodes();
        if (iterator != null) {
            while (iterator.hasNext()) {
                XmlNode xmlNode2 = (XmlNode)iterator.next();
                PSSysViewPanelItem pSSysViewPanelItem2 = new PSSysViewPanelItem();
                pSSysViewPanelItem2.setOrderValue(n);
                n += 100;
                pSSysViewPanelItemService.fillParentInfo((IEntity)pSSysViewPanelItem2, "DER1N", "DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEM_PPSSYSVIEWPANELITEMID", pSSysViewPanelItem.getPSSysViewPanelItemId());
                pSSysViewPanelItemService.importXmlModel(pSSysViewPanelItem2, xmlNode2);
            }
        }
    }

    protected void importRelatedXmlModel_PSPanelItemLogic(PSSysViewPanelItem pSSysViewPanelItem, XmlNode xmlNode) throws Exception {
        int n = 100;
        PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        String string = pSSysViewPanelItem.getPSSysViewPanelItemId();
        if (string.indexOf("SRFTEMPKEY:") != 0) {
            pSPanelItemLogicService.removeByPSSysViewPanelItem(pSSysViewPanelItem);
        } else {
            pSPanelItemLogicService.removeTempByPSSysViewPanelItem(pSSysViewPanelItem);
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
                pSPanelItemLogicService.fillParentInfo((IEntity)pSPanelItemLogic, "DER1N", "DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", pSSysViewPanelItem.getPSSysViewPanelItemId());
                pSPanelItemLogicService.importXmlModel(pSPanelItemLogic, xmlNode2);
            }
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysViewPanelItem pSSysViewPanelItem, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysViewPanelItem, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSVIEWPANELITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSVIEWPANELITEM#%1$s", (Object)string);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSSYSVIEWPANEL#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSVIEWPANELITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEM_PPSSYSVIEWPANELITEMID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANEL_PSSYSVIEWPANELID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSVIEWPANELITEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PPSSYSVIEWPANELITEMNAME", null);
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSVIEWPANELNAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELITEM", (boolean)true) == 0) {
            iEntity.set("PPSSYSVIEWPANELITEMID", (Object)string2);
            return true;
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANEL", (boolean)true) == 0) {
            iEntity.set("PSSYSVIEWPANELID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PPSSYSVIEWPANELITEMID", "PSSYSVIEWPANELID"};
    }

    @Override
    public String getModelV2Tag(PSSysViewPanelItem pSSysViewPanelItem) {
        if (!StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getPSSysViewPanelItemName())) {
            return pSSysViewPanelItem.getPSSysViewPanelItemName();
        }
        return super.getModelV2Tag(pSSysViewPanelItem);
    }

    @Override
    public boolean setModelV2Tag(PSSysViewPanelItem pSSysViewPanelItem, String string) {
        pSSysViewPanelItem.setPSSysViewPanelItemName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSSYSVIEWPANELITEMNAME", "");
        map.put("PPSSYSVIEWPANELITEMID", "");
        map.put("PSSYSVIEWPANELID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysViewPanelItem pSSysViewPanelItem, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysViewPanelItem.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysViewPanelItem, true);
        pSSysViewPanelItem.set("PSSYSVIEWPANELITEMNAME", string);
        if (this.select(pSSysViewPanelItem, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysViewPanelItem, true);
        return super.getModelV2Entity(pSSysViewPanelItem, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysViewPanelItem pSSysViewPanelItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        boolean bl = false;
        if (!StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getPPSSysViewPanelItemId())) {
            bl = true;
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysViewPanelItem.getPSSysViewPanelId())) {
            bl = true;
        } else if (bl && !objectNode.has("pssysviewpanelid")) {
            objectNode.put("pssysviewpanelid", "<PSSYSVIEWPANEL>");
        }
        return super.testCompileCurModelV2(pSSysViewPanelItem, objectNode, string, string2, n);
    }

    @Override
    protected ObjectNode onFillModelV2(ObjectNode objectNode, PSSysViewPanelItem pSSysViewPanelItem, String string, Map<String, String> map) throws Exception {
        if (PSSysViewPanelItemServiceBase.isSimpleImportExportMode()) {
            map.put("PPSSYSVIEWPANELITEMID", "");
            map.put("PSSYSVIEWPANELID", "");
        }
        return super.onFillModelV2(objectNode, pSSysViewPanelItem, string, map);
    }

    protected boolean isExportRelatedModelV2(String string) {
        if (StringHelper.compare((String)"DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEM_PPSSYSVIEWPANELITEMID", (String)string, (boolean)true) == 0) {
            return false;
        }
        return StringHelper.compare((String)"DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", (String)string, (boolean)true) != 0;
    }

    @Override
    protected void onExportRelatedModelV2(PSSysViewPanelItem pSSysViewPanelItem, String string, String string2) throws Exception {
        Object var4_4 = null;
        super.onExportRelatedModelV2(pSSysViewPanelItem, string, string2);
    }

    @Override
    protected void onExportCurModelV2(PSSysViewPanelItem pSSysViewPanelItem, ObjectNode objectNode, String string, boolean bl) throws Exception {
        Object object;
        EntityBase entityBase2;
        Object object2;
        ArrayNode arrayNode;
        Object object3;
        ArrayList<PSSysViewPanelItem> arrayList;
        PSCoreSysServiceBase pSCoreSysServiceBase;
        File file = null;
        if (bl || !this.isExportRelatedModelV2("DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEM_PPSSYSVIEWPANELITEMID")) {
            pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWPANELITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSSYSVIEWPANELITEM", (Object)pSSysViewPanelItem.getPSSysViewPanelItemId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty((String)object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString((String)object2);
                        arrayList.add((PSSysViewPanelItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList<PSSysViewPanelItem>();
                object3 = ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).selectByPPSSysViewPanelItem(pSSysViewPanelItem);
                arrayNode = StringHelper.format((String)"PSSYSVIEWPANELITEM#%1$s", (Object)pSSysViewPanelItem.getPSSysViewPanelItemId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSSysViewPanelItem)object2.next();
                    object = ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare(arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysViewPanelItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        if (bl || !this.isExportRelatedModelV2("DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID")) {
            pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
            arrayList = null;
            if (!StringHelper.isNullOrEmpty((String)string)) {
                file = new File(StringHelper.format((String)"%1$s%2$s%3$s%2$sPSSYSVIEWPANELITEM#%4$s#ALL.txt", (Object)string, (Object)File.separator, (Object)"PSPANELITEMLOGIC", (Object)pSSysViewPanelItem.getPSSysViewPanelItemId()));
                if (file.exists()) {
                    arrayList = new ArrayList();
                    object3 = PSModelV2Helper.readFile2(file);
                    arrayNode = ((ArrayList)object3).iterator();
                    while (arrayNode.hasNext()) {
                        object2 = (String)arrayNode.next();
                        if (StringHelper.isNullOrEmpty(object2)) continue;
                        entityBase2 = (ObjectNode)JsonNodeHelper.fromString(object2);
                        arrayList.add((PSSysViewPanelItem)entityBase2);
                    }
                }
            } else {
                arrayList = new ArrayList();
                object3 = ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanelItem(pSSysViewPanelItem);
                arrayNode = StringHelper.format((String)"PSSYSVIEWPANELITEM#%1$s", (Object)pSSysViewPanelItem.getPSSysViewPanelItemId());
                object2 = ((ArrayList)object3).iterator();
                while (object2.hasNext()) {
                    entityBase2 = (PSPanelItemLogic)object2.next();
                    object = ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase2);
                    if (StringHelper.compare((String)arrayNode, (String)object, (boolean)false) != 0) continue;
                    arrayList.add((PSSysViewPanelItem)PSModelV2Helper.toJSONObject((IEntity)entityBase2, false));
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
                        if (objectNode.has("pspanelitemlogicname")) {
                            string = objectNode.get("pspanelitemlogicname").asText();
                        }
                        if (objectNode2.has("pspanelitemlogicname")) {
                            string2 = objectNode2.get("pspanelitemlogicname").asText();
                        }
                        return StringHelper.compare((String)string, string2, (boolean)false);
                    }
                });
                for (EntityBase entityBase2 : arrayList) {
                    object = new PSPanelItemLogic();
                    PSModelV2Helper.fromJSONObject((IDataObject)object, (ObjectNode)entityBase2, false);
                    ((PSPanelItemLogicBase)object).remove("ordervalue");
                    arrayNode.add((JsonNode)pSCoreSysServiceBase.exportModelV2(object, string));
                }
            }
        }
        super.onExportCurModelV2(pSSysViewPanelItem, objectNode, string, bl);
    }

    @Override
    protected void onEmptyModelV2(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        String string;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayList<EntityBase> arrayList = ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).selectByPPSSysViewPanelItem(pSSysViewPanelItem);
        String string2 = StringHelper.format((String)"PSSYSVIEWPANELITEM#%1$s", (Object)pSSysViewPanelItem.getPSSysViewPanelItemId());
        for (PSSysViewPanelItem entityBase : arrayList) {
            string = ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)entityBase);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(entityBase);
        }
        Object object = new SqlParamList();
        object.addString(pSSysViewPanelItem.getPSSysViewPanelItemId());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSSYSVIEWPANELITEM WHERE PPSSYSVIEWPANELITEMID = ?", (SqlParamList)object);
        pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayList = ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).selectByPSSysViewPanelItem(pSSysViewPanelItem);
        string2 = StringHelper.format((String)"PSSYSVIEWPANELITEM#%1$s", (Object)pSSysViewPanelItem.getPSSysViewPanelItemId());
        for (PSPanelItemLogic pSPanelItemLogic : arrayList) {
            string = ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).getModelV2ResScope((IEntity)pSPanelItemLogic);
            if (StringHelper.compare((String)string2, (String)string, (boolean)false) != 0) continue;
            pSCoreSysServiceBase.emptyModelV2(pSPanelItemLogic);
        }
        object = new SqlParamList();
        object.addString(pSSysViewPanelItem.getPSSysViewPanelItemId());
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "SET FOREIGN_KEY_CHECKS=0;", null);
        ((PSPanelItemLogicServiceBase)pSCoreSysServiceBase).getDAO().executeRawSql(null, "DELETE FROM T_SRFPSPANELITEMLOGIC WHERE PSSYSVIEWPANELITEMID = ?", (SqlParamList)object);
        super.onEmptyModelV2(pSSysViewPanelItem);
    }

    @Override
    protected boolean onContainsRelatedModelV2Entity(String string, int n) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        if (pSCoreSysServiceBase.containsModelV2Entity(string, n)) {
            return true;
        }
        return super.onContainsRelatedModelV2Entity(string, n);
    }

    @Override
    protected IEntity onGetRelatedModelV2Entity(PSSysViewPanelItem pSSysViewPanelItem, String string, String string2) throws Exception {
        IEntity iEntity = null;
        EntityBase entityBase = new PSSysViewPanelItem();
        entityBase.set("PPSSYSVIEWPANELITEMID", pSSysViewPanelItem.getPSSysViewPanelItemId());
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        entityBase = new PSPanelItemLogic();
        entityBase.set("PSSYSVIEWPANELITEMID", pSSysViewPanelItem.getPSSysViewPanelItemId());
        pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        iEntity = pSCoreSysServiceBase.getModelV2Entity(entityBase, string, string2);
        if (iEntity != null) {
            return iEntity;
        }
        return super.onGetRelatedModelV2Entity(pSSysViewPanelItem, string, string2);
    }

    @Override
    protected void onCompileRelatedModelV2(PSSysViewPanelItem pSSysViewPanelItem, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        EntityBase entityBase;
        Object object;
        Object object2;
        int n2;
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ArrayNode arrayNode = null;
        String string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        int n3 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSSysViewPanelItem();
                ((PSSysViewPanelItemBase)object).setPLayoutMode(pSSysViewPanelItem.getLayoutMode());
                ((PSSysViewPanelItemBase)object).setPPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
                ((PSSysViewPanelItemBase)object).setPPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                ((PSSysViewPanelItemBase)object).setOrderValue(n3 += 10);
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string4 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string4);
            if (((File)object2).exists()) {
                object = ((File)object2).listFiles();
                for (Object object3 : object) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSSysViewPanelItem();
                    entityBase.setPLayoutMode(pSSysViewPanelItem.getLayoutMode());
                    entityBase.setPPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
                    entityBase.setPPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        pSCoreSysServiceBase = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
        arrayNode = null;
        string3 = pSCoreSysServiceBase.getModelV2Name(null, false);
        n3 = 0;
        if (objectNode != null) {
            arrayNode = JsonNodeHelper.getArray((ObjectNode)objectNode, (String)string3.toLowerCase());
        }
        if (arrayNode != null) {
            for (n2 = 0; n2 < arrayNode.size(); ++n2) {
                object2 = (ObjectNode)arrayNode.get(n2);
                object = new PSPanelItemLogic();
                ((PSPanelItemLogicBase)object).setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
                ((PSPanelItemLogicBase)object).setPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                ((PSPanelItemLogicBase)object).setOrderValue(n3 += 10);
                pSCoreSysServiceBase.compileModelV2(object, (ObjectNode)object2, string, null, n);
            }
        } else {
            String string5 = StringHelper.format((String)"%1$s%2$s%3$s", (Object)string2, (Object)File.separator, (Object)string3);
            object2 = new File(string5);
            if (((File)object2).exists()) {
                for (Object object3 : object = ((File)object2).listFiles()) {
                    if (!((File)object3).isDirectory()) continue;
                    entityBase = new PSPanelItemLogic();
                    entityBase.setPSSysViewPanelItemId(pSSysViewPanelItem.getPSSysViewPanelItemId());
                    entityBase.setPSSysViewPanelItemName(pSSysViewPanelItem.getPSSysViewPanelItemName());
                    pSCoreSysServiceBase.compileModelV2(entityBase, null, string, ((File)object3).getCanonicalPath(), n);
                }
            }
        }
        super.onCompileRelatedModelV2(pSSysViewPanelItem, objectNode, string, string2, n);
    }

    @Override
    protected PSMOSFile onPasteFile(PSSysViewPanelItem pSSysViewPanelItem, PSMOSFile pSMOSFile, String string, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        PSMOSFile pSMOSFile2 = null;
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEM_PPSSYSVIEWPANELITEMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSSysViewPanelItems(pSSysViewPanelItem, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        if ((StringHelper.isNullOrEmpty((String)string) || StringHelper.compare((String)string, (String)"DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID", (boolean)true) == 0) && (pSMOSFile2 = this.onPasteFile_PSPanelItemLogics(pSSysViewPanelItem, pSMOSFile, iPSMOSFileAction)) != null) {
            return pSMOSFile2;
        }
        return super.onPasteFile(pSSysViewPanelItem, pSMOSFile, string, iPSMOSFileAction);
    }

    protected PSMOSFile onPasteFile_PSSysViewPanelItems(PSSysViewPanelItem pSSysViewPanelItem, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSSYSVIEWPANELITEM", true), (boolean)false) == 0) {
            PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
            PSSysViewPanelItem pSSysViewPanelItem2 = new PSSysViewPanelItem();
            pSSysViewPanelItem2.setPSSysViewPanelItemId(pSMOSFile.getPSModelId());
            if (!pSSysViewPanelItemService.get((IEntity)pSSysViewPanelItem2, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSSysViewPanelItem2.getPPSSysViewPanelItemId(), (String)pSSysViewPanelItem.getPSSysViewPanelItemId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSSysViewPanelItemService.exportModelV2(pSSysViewPanelItem2);
            pSSysViewPanelItem2.reset();
            if (!pSSysViewPanelItemService.setModelV2ResScope((IEntity)pSSysViewPanelItem2, "PSSYSVIEWPANELITEM", pSSysViewPanelItem.getPSSysViewPanelItemId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSSysViewPanelItemService.importModelV2(pSSysViewPanelItem2, objectNode);
            SessionFactoryManager.commit();
            return pSSysViewPanelItemService.getFile((IEntity)pSSysViewPanelItem2);
        }
        return null;
    }

    protected PSMOSFile onPasteFile_PSPanelItemLogics(PSSysViewPanelItem pSSysViewPanelItem, PSMOSFile pSMOSFile, IPSMOSFileAction iPSMOSFileAction) throws Exception {
        if (StringHelper.compare((String)pSMOSFile.getPSModelType(), (String)PSModelV2Helper.getModelV2Name("PSPANELITEMLOGIC", true), (boolean)false) == 0) {
            PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
            PSPanelItemLogic pSPanelItemLogic = new PSPanelItemLogic();
            pSPanelItemLogic.setPSPanelItemLogicId(pSMOSFile.getPSModelId());
            if (!pSPanelItemLogicService.get((IEntity)pSPanelItemLogic, true)) {
                throw new Exception(StringHelper.format((String)"\u65e0\u6cd5\u83b7\u53d6\u6a21\u578b[%1$s|%2$s]", (Object)pSMOSFile.getPSMOSFileId(), (Object)pSMOSFile.getPSModelId()));
            }
            if (StringHelper.compare((String)pSPanelItemLogic.getPSSysViewPanelItemId(), (String)pSSysViewPanelItem.getPSSysViewPanelItemId(), (boolean)false) == 0) {
                throw new Exception(StringHelper.format((String)"\u76ee\u6807\u8def\u5f84\u4e0e\u6e90\u8def\u5f84\u4e00\u81f4"));
            }
            ObjectNode objectNode = pSPanelItemLogicService.exportModelV2(pSPanelItemLogic);
            pSPanelItemLogic.reset();
            if (!pSPanelItemLogicService.setModelV2ResScope((IEntity)pSPanelItemLogic, "PSSYSVIEWPANELITEM", pSSysViewPanelItem.getPSSysViewPanelItemId())) {
                throw new Exception("\u65e0\u6cd5\u8bbe\u7f6e\u6a21\u578b\u57df");
            }
            pSPanelItemLogicService.importModelV2(pSPanelItemLogic, objectNode);
            SessionFactoryManager.commit();
            return pSPanelItemLogicService.getFile((IEntity)pSPanelItemLogic);
        }
        return null;
    }

    @Override
    protected void onFillPasteHelps(PSSysViewPanelItem pSSysViewPanelItem, List<PSHelpSection> list) throws Exception {
        this.onFillPasteHelps_PSSysViewPanelItems(pSSysViewPanelItem, list);
        this.onFillPasteHelps_PSPanelItemLogics(pSSysViewPanelItem, list);
        super.onFillPasteHelps(pSSysViewPanelItem, list);
    }

    protected void onFillPasteHelps_PSSysViewPanelItems(PSSysViewPanelItem pSSysViewPanelItem, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSSYSVIEWPANELITEM");
        pSHelpSection.setSectionParam2("DER1N_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEM_PPSSYSVIEWPANELITEMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u6210\u5458]\u7684[\u9762\u677f\u6210\u5458]");
        list.add(pSHelpSection);
    }

    protected void onFillPasteHelps_PSPanelItemLogics(PSSysViewPanelItem pSSysViewPanelItem, List<PSHelpSection> list) throws Exception {
        PSHelpSection pSHelpSection = new PSHelpSection();
        pSHelpSection.setSectionType("USER");
        pSHelpSection.setSectionParam("PSPANELITEMLOGIC");
        pSHelpSection.setSectionParam2("DER1N_PSPANELITEMLOGIC_PSSYSVIEWPANELITEM_PSSYSVIEWPANELITEMID");
        pSHelpSection.setContent("\u7c98\u8d34\u5176\u5b83[\u9762\u677f\u6210\u5458]\u7684[\u9762\u677f\u9879\u903b\u8f91]");
        list.add(pSHelpSection);
    }

    @Override
    public Object getDataType(PSSysViewPanelItem pSSysViewPanelItem) throws Exception {
        return pSSysViewPanelItem.getItemType();
    }
}

