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
 *  net.ibizsys.paas.util.KeyValueHelper
 *  net.ibizsys.paas.util.StringBuilderEx
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
import net.ibizsys.paas.util.KeyValueHelper;
import net.ibizsys.paas.util.StringBuilderEx;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSPFBase;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPluginBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.dao.PSDEViewCtrlDAO;
import net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewCtrlDEModel;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEActionBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChart;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEChartBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataExpBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImp;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataImpBase;
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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPriv;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEOPPrivBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReport;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEReportBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbar;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEToolbarBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroupBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBaseBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewCtrl;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizard;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEWizardBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntityBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlDSService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlDSServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewEngineServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewLogicServiceBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandler;
import net.ibizsys.pscore.srv.sysdesign.entity.PSACHandlerBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroup;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlLogicGroupBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsg;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCtrlMsgBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageResBase;
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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImageBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapView;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMapViewBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTemplBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBar;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSearchBarBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewCtrlServiceBase
extends PSCoreSysServiceBase<PSDEViewCtrl> {
    private static final Log log = LogFactory.getLog(PSDEViewCtrlServiceBase.class);
    public static final String DATASET_CURAPP = "CurApp";
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_CURVIEW = "CurView";
    public static final String DATASET_CURVIEWRT = "CurViewRT";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_FORMTYPE = "FormType";
    public static final String ACTION_CHANGECHART = "ChangeChart";
    public static final String ACTION_CHANGEDASHBOARD = "ChangeDashboard";
    public static final String ACTION_CHANGEDATARELATION = "ChangeDataRelation";
    public static final String ACTION_CHANGEDATAVIEW = "ChangeDataView";
    public static final String ACTION_CHANGEEDITFORM = "ChangeEditForm";
    public static final String ACTION_CHANGEGRID = "ChangeGrid";
    public static final String ACTION_CHANGELIST = "ChangeList";
    public static final String ACTION_CHANGETOOLBAR = "ChangeToolbar";
    public static final String ACTION_CHANGETREE = "ChangeTree";
    private PSDEViewCtrlDEModel pSDEViewCtrlDEModel;
    private PSDEViewCtrlDAO pSDEViewCtrlDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService";
    }

    public PSDEViewCtrlDEModel getPSDEViewCtrlDEModel() {
        if (this.pSDEViewCtrlDEModel == null) {
            try {
                this.pSDEViewCtrlDEModel = (PSDEViewCtrlDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.dedesign.demodel.PSDEViewCtrlDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewCtrlDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSDEViewCtrlDEModel();
    }

    public PSDEViewCtrlDAO getPSDEViewCtrlDAO() {
        if (this.pSDEViewCtrlDAO == null) {
            try {
                this.pSDEViewCtrlDAO = (PSDEViewCtrlDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.dedesign.dao.PSDEViewCtrlDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSDEViewCtrlDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSDEViewCtrlDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURAPP, (boolean)true) == 0) {
            return this.fetchCurApp(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURVIEW, (boolean)true) == 0) {
            return this.fetchCurView(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURVIEWRT, (boolean)true) == 0) {
            return this.fetchCurViewRT(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchFormType(iDEDataSetFetchContext);
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
        if (StringHelper.compare((String)string, (String)DATASET_CURVIEW, (boolean)true) == 0) {
            return this.fetchTempCurView(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_CURVIEWRT, (boolean)true) == 0) {
            return this.fetchTempCurViewRT(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_FORMTYPE, (boolean)true) == 0) {
            return this.fetchTempFormType(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CHANGECHART, (boolean)true) == 0) {
            this.changeChart((PSDEViewCtrl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGEDASHBOARD, (boolean)true) == 0) {
            this.changeDashboard((PSDEViewCtrl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGEDATARELATION, (boolean)true) == 0) {
            this.changeDataRelation((PSDEViewCtrl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGEDATAVIEW, (boolean)true) == 0) {
            this.changeDataView((PSDEViewCtrl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGEEDITFORM, (boolean)true) == 0) {
            this.changeEditForm((PSDEViewCtrl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGEGRID, (boolean)true) == 0) {
            this.changeGrid((PSDEViewCtrl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGELIST, (boolean)true) == 0) {
            this.changeList((PSDEViewCtrl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGETOOLBAR, (boolean)true) == 0) {
            this.changeToolbar((PSDEViewCtrl)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_CHANGETREE, (boolean)true) == 0) {
            this.changeTree((PSDEViewCtrl)iEntity);
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

    public DBFetchResult fetchCurView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVIEW, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurView(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVIEW, true);
        return dBFetchResult;
    }

    public DBFetchResult fetchCurViewRT(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVIEWRT, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempCurViewRT(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_CURVIEWRT, true);
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

    public DBFetchResult fetchFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempFormType(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_FORMTYPE, true);
        return dBFetchResult;
    }

    public void changeChart(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGECHART, 0, (IEntity)pSDEViewCtrl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEViewCtrl, ACTION_CHANGECHART);
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewCtrlServiceBase.this.getService(), PSDEViewCtrlServiceBase.ACTION_CHANGECHART, 40, (IEntity)pSDEViewCtrl2, null).getResult() != 1) {
                    PSDEViewCtrlServiceBase.this.onChangeChart(pSDEViewCtrl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGECHART, 99, (IEntity)pSDEViewCtrl, null);
        }
    }

    protected void onChangeChart(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeChart]");
    }

    public void changeDashboard(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDASHBOARD, 0, (IEntity)pSDEViewCtrl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEViewCtrl, ACTION_CHANGEDASHBOARD);
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewCtrlServiceBase.this.getService(), PSDEViewCtrlServiceBase.ACTION_CHANGEDASHBOARD, 40, (IEntity)pSDEViewCtrl2, null).getResult() != 1) {
                    PSDEViewCtrlServiceBase.this.onChangeDashboard(pSDEViewCtrl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDASHBOARD, 99, (IEntity)pSDEViewCtrl, null);
        }
    }

    protected void onChangeDashboard(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeDashboard]");
    }

    public void changeDataRelation(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDATARELATION, 0, (IEntity)pSDEViewCtrl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEViewCtrl, ACTION_CHANGEDATARELATION);
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewCtrlServiceBase.this.getService(), PSDEViewCtrlServiceBase.ACTION_CHANGEDATARELATION, 40, (IEntity)pSDEViewCtrl2, null).getResult() != 1) {
                    PSDEViewCtrlServiceBase.this.onChangeDataRelation(pSDEViewCtrl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDATARELATION, 99, (IEntity)pSDEViewCtrl, null);
        }
    }

    protected void onChangeDataRelation(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeDataRelation]");
    }

    public void changeDataView(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDATAVIEW, 0, (IEntity)pSDEViewCtrl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEViewCtrl, ACTION_CHANGEDATAVIEW);
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewCtrlServiceBase.this.getService(), PSDEViewCtrlServiceBase.ACTION_CHANGEDATAVIEW, 40, (IEntity)pSDEViewCtrl2, null).getResult() != 1) {
                    PSDEViewCtrlServiceBase.this.onChangeDataView(pSDEViewCtrl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEDATAVIEW, 99, (IEntity)pSDEViewCtrl, null);
        }
    }

    protected void onChangeDataView(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeDataView]");
    }

    public void changeEditForm(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEEDITFORM, 0, (IEntity)pSDEViewCtrl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEViewCtrl, ACTION_CHANGEEDITFORM);
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewCtrlServiceBase.this.getService(), PSDEViewCtrlServiceBase.ACTION_CHANGEEDITFORM, 40, (IEntity)pSDEViewCtrl2, null).getResult() != 1) {
                    PSDEViewCtrlServiceBase.this.onChangeEditForm(pSDEViewCtrl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEEDITFORM, 99, (IEntity)pSDEViewCtrl, null);
        }
    }

    protected void onChangeEditForm(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeEditForm]");
    }

    public void changeGrid(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEGRID, 0, (IEntity)pSDEViewCtrl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEViewCtrl, ACTION_CHANGEGRID);
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewCtrlServiceBase.this.getService(), PSDEViewCtrlServiceBase.ACTION_CHANGEGRID, 40, (IEntity)pSDEViewCtrl2, null).getResult() != 1) {
                    PSDEViewCtrlServiceBase.this.onChangeGrid(pSDEViewCtrl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGEGRID, 99, (IEntity)pSDEViewCtrl, null);
        }
    }

    protected void onChangeGrid(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeGrid]");
    }

    public void changeList(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGELIST, 0, (IEntity)pSDEViewCtrl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEViewCtrl, ACTION_CHANGELIST);
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewCtrlServiceBase.this.getService(), PSDEViewCtrlServiceBase.ACTION_CHANGELIST, 40, (IEntity)pSDEViewCtrl2, null).getResult() != 1) {
                    PSDEViewCtrlServiceBase.this.onChangeList(pSDEViewCtrl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGELIST, 99, (IEntity)pSDEViewCtrl, null);
        }
    }

    protected void onChangeList(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeList]");
    }

    public void changeToolbar(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGETOOLBAR, 0, (IEntity)pSDEViewCtrl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEViewCtrl, ACTION_CHANGETOOLBAR);
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewCtrlServiceBase.this.getService(), PSDEViewCtrlServiceBase.ACTION_CHANGETOOLBAR, 40, (IEntity)pSDEViewCtrl2, null).getResult() != 1) {
                    PSDEViewCtrlServiceBase.this.onChangeToolbar(pSDEViewCtrl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGETOOLBAR, 99, (IEntity)pSDEViewCtrl, null);
        }
    }

    protected void onChangeToolbar(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeToolbar]");
    }

    public void changeTree(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CHANGETREE, 0, (IEntity)pSDEViewCtrl, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction((IEntity)pSDEViewCtrl, ACTION_CHANGETREE);
        final PSDEViewCtrl pSDEViewCtrl2 = pSDEViewCtrl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSDEViewCtrlServiceBase.this.getService(), PSDEViewCtrlServiceBase.ACTION_CHANGETREE, 40, (IEntity)pSDEViewCtrl2, null).getResult() != 1) {
                    PSDEViewCtrlServiceBase.this.onChangeTree(pSDEViewCtrl2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CHANGETREE, 99, (IEntity)pSDEViewCtrl, null);
        }
    }

    protected void onChangeTree(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[ChangeTree]");
    }

    protected void onFillParentInfo(PSDEViewCtrl pSDEViewCtrl, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSACHANDLER_PSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSACHandler);
            } else {
                iService.get((IEntity)pSACHandler);
            }
            this.onFillParentInfo_PSACHandler(pSDEViewCtrl, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSACHANDLER_SUBPSACHANDLERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSACHandlerService", (SessionFactory)this.getSessionFactory());
            PSACHandler pSACHandler = (PSACHandler)iService.getDEModel().createEntity();
            pSACHandler.set("PSACHANDLERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSACHandler);
            } else {
                iService.get((IEntity)pSACHandler);
            }
            this.onFillParentInfo_SubPSACHandler(pSDEViewCtrl, pSACHandler);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlLogicGroupService", (SessionFactory)this.getSessionFactory());
            PSCtrlLogicGroup pSCtrlLogicGroup = (PSCtrlLogicGroup)iService.getDEModel().createEntity();
            pSCtrlLogicGroup.set("PSCTRLLOGICGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlLogicGroup);
            } else {
                iService.get((IEntity)pSCtrlLogicGroup);
            }
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEViewCtrl, pSCtrlLogicGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSCTRLMSG_PSCTRLMSGID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCtrlMsgService", (SessionFactory)this.getSessionFactory());
            PSCtrlMsg pSCtrlMsg = (PSCtrlMsg)iService.getDEModel().createEntity();
            pSCtrlMsg.set("PSCTRLMSGID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSCtrlMsg);
            } else {
                iService.get((IEntity)pSCtrlMsg);
            }
            this.onFillParentInfo_PSCtrlMsg(pSDEViewCtrl, pSCtrlMsg);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDATAENTITY_PSDEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService", (SessionFactory)this.getSessionFactory());
            PSDataEntity pSDataEntity = (PSDataEntity)iService.getDEModel().createEntity();
            pSDataEntity.set("PSDATAENTITYID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDataEntity);
            } else {
                iService.get((IEntity)pSDataEntity);
            }
            this.onFillParentInfo_PSDE(pSDEViewCtrl, pSDataEntity);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEACTION_PSDEACTIONID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEActionService", (SessionFactory)this.getSessionFactory());
            PSDEAction pSDEAction = (PSDEAction)iService.getDEModel().createEntity();
            pSDEAction.set("PSDEACTIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEAction);
            } else {
                iService.get((IEntity)pSDEAction);
            }
            this.onFillParentInfo_PSDEAction(pSDEViewCtrl, pSDEAction);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDECHART_PSDECHARTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEChartService", (SessionFactory)this.getSessionFactory());
            PSDEChart pSDEChart = (PSDEChart)iService.getDEModel().createEntity();
            pSDEChart.set("PSDECHARTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEChart);
            } else {
                iService.get((IEntity)pSDEChart);
            }
            this.onFillParentInfo_PSDEChart(pSDEViewCtrl, pSDEChart);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEDATAEXP_PSDEDATAEXPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataExpService", (SessionFactory)this.getSessionFactory());
            PSDEDataExp pSDEDataExp = (PSDEDataExp)iService.getDEModel().createEntity();
            pSDEDataExp.set("PSDEDATAEXPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataExp);
            } else {
                iService.get((IEntity)pSDEDataExp);
            }
            this.onFillParentInfo_PSDEDataExp(pSDEViewCtrl, pSDEDataExp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEDATAIMP_PSDEDATAIMPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataImpService", (SessionFactory)this.getSessionFactory());
            PSDEDataImp pSDEDataImp = (PSDEDataImp)iService.getDEModel().createEntity();
            pSDEDataImp.set("PSDEDATAIMPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataImp);
            } else {
                iService.get((IEntity)pSDEDataImp);
            }
            this.onFillParentInfo_PSDEDataImp(pSDEViewCtrl, pSDEDataImp);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEDATARELATION_PSDEDRID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataRelationService", (SessionFactory)this.getSessionFactory());
            PSDEDataRelation pSDEDataRelation = (PSDEDataRelation)iService.getDEModel().createEntity();
            pSDEDataRelation.set("PSDEDATARELATIONID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataRelation);
            } else {
                iService.get((IEntity)pSDEDataRelation);
            }
            this.onFillParentInfo_PSDEDR(pSDEViewCtrl, pSDEDataRelation);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEDATASET_PSDEDATASETID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService", (SessionFactory)this.getSessionFactory());
            PSDEDataSet pSDEDataSet = (PSDEDataSet)iService.getDEModel().createEntity();
            pSDEDataSet.set("PSDEDATASETID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataSet);
            } else {
                iService.get((IEntity)pSDEDataSet);
            }
            this.onFillParentInfo_PSDEDataSet(pSDEViewCtrl, pSDEDataSet);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEDATAVIEW_PSDEDATAVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService", (SessionFactory)this.getSessionFactory());
            PSDEDataView pSDEDataView = (PSDEDataView)iService.getDEModel().createEntity();
            pSDEDataView.set("PSDEDATAVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEDataView);
            } else {
                iService.get((IEntity)pSDEDataView);
            }
            this.onFillParentInfo_PSDEDataView(pSDEViewCtrl, pSDEDataView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEFORM_PSDEFORMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFormService", (SessionFactory)this.getSessionFactory());
            PSDEForm pSDEForm = (PSDEForm)iService.getDEModel().createEntity();
            pSDEForm.set("PSDEFORMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEForm);
            } else {
                iService.get((IEntity)pSDEForm);
            }
            this.onFillParentInfo_PSDEForm(pSDEViewCtrl, pSDEForm);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEGRID_PSDEGRIDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEGridService", (SessionFactory)this.getSessionFactory());
            PSDEGrid pSDEGrid = (PSDEGrid)iService.getDEModel().createEntity();
            pSDEGrid.set("PSDEGRIDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEGrid);
            } else {
                iService.get((IEntity)pSDEGrid);
            }
            this.onFillParentInfo_PSDEGrid(pSDEViewCtrl, pSDEGrid);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDELIST_PSDELISTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListService", (SessionFactory)this.getSessionFactory());
            PSDEList pSDEList = (PSDEList)iService.getDEModel().createEntity();
            pSDEList.set("PSDELISTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEList);
            } else {
                iService.get((IEntity)pSDEList);
            }
            this.onFillParentInfo_PSDEList(pSDEViewCtrl, pSDEList);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDELOGIC_ADPSDELOGICID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicService", (SessionFactory)this.getSessionFactory());
            PSDELogic pSDELogic = (PSDELogic)iService.getDEModel().createEntity();
            pSDELogic.set("PSDELOGICID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDELogic);
            } else {
                iService.get((IEntity)pSDELogic);
            }
            this.onFillParentInfo_ADPSDELogic(pSDEViewCtrl, pSDELogic);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEOPPRIV_PSDEOPPRIVID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEOPPrivService", (SessionFactory)this.getSessionFactory());
            PSDEOPPriv pSDEOPPriv = (PSDEOPPriv)iService.getDEModel().createEntity();
            pSDEOPPriv.set("PSDEOPPRIVID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEOPPriv);
            } else {
                iService.get((IEntity)pSDEOPPriv);
            }
            this.onFillParentInfo_PSDEOPPriv(pSDEViewCtrl, pSDEOPPriv);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEREPORT_PSDEREPORTID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEReportService", (SessionFactory)this.getSessionFactory());
            PSDEReport pSDEReport = (PSDEReport)iService.getDEModel().createEntity();
            pSDEReport.set("PSDEREPORTID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEReport);
            } else {
                iService.get((IEntity)pSDEReport);
            }
            this.onFillParentInfo_PSDEReport(pSDEViewCtrl, pSDEReport);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDETOOLBAR_PSDETOOLBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService", (SessionFactory)this.getSessionFactory());
            PSDEToolbar pSDEToolbar = (PSDEToolbar)iService.getDEModel().createEntity();
            pSDEToolbar.set("PSDETOOLBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEToolbar);
            } else {
                iService.get((IEntity)pSDEToolbar);
            }
            this.onFillParentInfo_PSDEToolbar(pSDEViewCtrl, pSDEToolbar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDETREEVIEW_PSDETREEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService", (SessionFactory)this.getSessionFactory());
            PSDETreeView pSDETreeView = (PSDETreeView)iService.getDEModel().createEntity();
            pSDETreeView.set("PSDETREEVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDETreeView);
            } else {
                iService.get((IEntity)pSDETreeView);
            }
            this.onFillParentInfo_PSDETreeView(pSDEViewCtrl, pSDETreeView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO2PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_No2PSDEUAGroup(pSDEViewCtrl, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO3PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_No3PSDEUAGroup(pSDEViewCtrl, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO4PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_No4PSDEUAGroup(pSDEViewCtrl, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO5PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_No5PSDEUAGroup(pSDEViewCtrl, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO6PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_No6PSDEUAGroup(pSDEViewCtrl, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEUAGROUP_PSDEUAGROUPID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService", (SessionFactory)this.getSessionFactory());
            PSDEUAGroup pSDEUAGroup = (PSDEUAGroup)iService.getDEModel().createEntity();
            pSDEUAGroup.set("PSDEUAGROUPID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEUAGroup);
            } else {
                iService.get((IEntity)pSDEUAGroup);
            }
            this.onFillParentInfo_PSDEUAGroup(pSDEViewCtrl, pSDEUAGroup);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PSDEViewBase(pSDEViewCtrl, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEViewBase);
            } else {
                iService.get((IEntity)pSDEViewBase);
            }
            this.onFillParentInfo_PSDEView(pSDEViewCtrl, pSDEViewBase);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSDEWIZARD_PSDEWIZARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService", (SessionFactory)this.getSessionFactory());
            PSDEWizard pSDEWizard = (PSDEWizard)iService.getDEModel().createEntity();
            pSDEWizard.set("PSDEWIZARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSDEWizard);
            } else {
                iService.get((IEntity)pSDEWizard);
            }
            this.onFillParentInfo_PSDEWizard(pSDEViewCtrl, pSDEWizard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSLANGUAGERES_CAPPSLANRESID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            PSLanguageRes pSLanguageRes = (PSLanguageRes)iService.getDEModel().createEntity();
            pSLanguageRes.set("PSLANGUAGERESID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSLanguageRes);
            } else {
                iService.get((IEntity)pSLanguageRes);
            }
            this.onFillParentInfo_CapPSLanRes(pSDEViewCtrl, pSLanguageRes);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSPF_PSPFID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory());
            PSPF pSPF = (PSPF)iService.getDEModel().createEntity();
            pSPF.set("PSPFID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSPF);
            } else {
                iService.get((IEntity)pSPF);
            }
            this.onFillParentInfo_PSPF(pSDEViewCtrl, pSPF);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSCALENDAR_PSSYSCALENDARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService", (SessionFactory)this.getSessionFactory());
            PSSysCalendar pSSysCalendar = (PSSysCalendar)iService.getDEModel().createEntity();
            pSSysCalendar.set("PSSYSCALENDARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCalendar);
            } else {
                iService.get((IEntity)pSSysCalendar);
            }
            this.onFillParentInfo_PSSysCalendar(pSDEViewCtrl, pSSysCalendar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSCOUNTER_PSSYSCOUNTERID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCounterService", (SessionFactory)this.getSessionFactory());
            PSSysCounter pSSysCounter = (PSSysCounter)iService.getDEModel().createEntity();
            pSSysCounter.set("PSSYSCOUNTERID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCounter);
            } else {
                iService.get((IEntity)pSSysCounter);
            }
            this.onFillParentInfo_PSSysCounter(pSDEViewCtrl, pSSysCounter);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSCSS_PSSYSCSSID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory());
            PSSysCss pSSysCss = (PSSysCss)iService.getDEModel().createEntity();
            pSSysCss.set("PSSYSCSSID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysCss);
            } else {
                iService.get((IEntity)pSSysCss);
            }
            this.onFillParentInfo_PSSysCss(pSDEViewCtrl, pSSysCss);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSDASHBOARD_PSSYSDASHBOARDID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService", (SessionFactory)this.getSessionFactory());
            PSSysDashboard pSSysDashboard = (PSSysDashboard)iService.getDEModel().createEntity();
            pSSysDashboard.set("PSSYSDASHBOARDID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDashboard);
            } else {
                iService.get((IEntity)pSSysDashboard);
            }
            this.onFillParentInfo_PSSysDashboard(pSDEViewCtrl, pSSysDashboard);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService", (SessionFactory)this.getSessionFactory());
            PSSysDynaModel pSSysDynaModel = (PSSysDynaModel)iService.getDEModel().createEntity();
            pSSysDynaModel.set("PSSYSDYNAMODELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysDynaModel);
            } else {
                iService.get((IEntity)pSSysDynaModel);
            }
            this.onFillParentInfo_PSSysDynaModel(pSDEViewCtrl, pSSysDynaModel);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSIMAGE_PSSYSIMAGEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService", (SessionFactory)this.getSessionFactory());
            PSSysImage pSSysImage = (PSSysImage)iService.getDEModel().createEntity();
            pSSysImage.set("PSSYSIMAGEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysImage);
            } else {
                iService.get((IEntity)pSSysImage);
            }
            this.onFillParentInfo_PSSysImage(pSDEViewCtrl, pSSysImage);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSMAPVIEW_PSSYSMAPVIEWID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService", (SessionFactory)this.getSessionFactory());
            PSSysMapView pSSysMapView = (PSSysMapView)iService.getDEModel().createEntity();
            pSSysMapView.set("PSSYSMAPVIEWID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysMapView);
            } else {
                iService.get((IEntity)pSSysMapView);
            }
            this.onFillParentInfo_PSSysMapView(pSDEViewCtrl, pSSysMapView);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService", (SessionFactory)this.getSessionFactory());
            PSSysMsgTempl pSSysMsgTempl = (PSSysMsgTempl)iService.getDEModel().createEntity();
            pSSysMsgTempl.set("PSSYSMSGTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysMsgTempl);
            } else {
                iService.get((IEntity)pSSysMsgTempl);
            }
            this.onFillParentInfo_PSSysMsgTempl(pSDEViewCtrl, pSSysMsgTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPFPluginService", (SessionFactory)this.getSessionFactory());
            PSSysPFPlugin pSSysPFPlugin = (PSSysPFPlugin)iService.getDEModel().createEntity();
            pSSysPFPlugin.set("PSSYSPFPLUGINID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysPFPlugin);
            } else {
                iService.get((IEntity)pSSysPFPlugin);
            }
            this.onFillParentInfo_PSSysPFPlugin(pSDEViewCtrl, pSSysPFPlugin);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSSEARCHBAR_PSSYSSEARCHBARID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService", (SessionFactory)this.getSessionFactory());
            PSSysSearchBar pSSysSearchBar = (PSSysSearchBar)iService.getDEModel().createEntity();
            pSSysSearchBar.set("PSSYSSEARCHBARID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysSearchBar);
            } else {
                iService.get((IEntity)pSSysSearchBar);
            }
            this.onFillParentInfo_PSSysSearchBar(pSDEViewCtrl, pSSysSearchBar);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSDEVIEWCTRL_PSSYSVIEWPANEL_PSSYSVIEWPANELID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService", (SessionFactory)this.getSessionFactory());
            PSSysViewPanel pSSysViewPanel = (PSSysViewPanel)iService.getDEModel().createEntity();
            pSSysViewPanel.set("PSSYSVIEWPANELID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp((IEntity)pSSysViewPanel);
            } else {
                iService.get((IEntity)pSSysViewPanel);
            }
            this.onFillParentInfo_PSSysViewPanel(pSDEViewCtrl, pSSysViewPanel);
            return;
        }
        super.onFillParentInfo((IEntity)pSDEViewCtrl, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        if (StringHelper.compare((String)string, (String)"DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWBASEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService", (SessionFactory)this.getSessionFactory());
            PSDEViewBase pSDEViewBase = (PSDEViewBase)iService.getDEModel().createEntity();
            pSDEViewBase.set("PSDEVIEWBASEID", string2);
            return this.onSyncDER1NData_PSDEViewBase(pSDEViewBase, string3);
        }
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSACHandler(PSDEViewCtrl pSDEViewCtrl, PSACHandler pSACHandler) throws Exception {
        pSDEViewCtrl.setPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEViewCtrl.setPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_SubPSACHandler(PSDEViewCtrl pSDEViewCtrl, PSACHandler pSACHandler) throws Exception {
        pSDEViewCtrl.setSubPSACHandlerId(pSACHandler.getPSACHandlerId());
        pSDEViewCtrl.setSubPSACHandlerName(pSACHandler.getPSACHandlerName());
    }

    protected void onFillParentInfo_PSCtrlLogicGroup(PSDEViewCtrl pSDEViewCtrl, PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        pSDEViewCtrl.setPSCtrlLogicGroupId(pSCtrlLogicGroup.getPSCtrlLogicGroupId());
        pSDEViewCtrl.setPSCtrlLogicGroupName(pSCtrlLogicGroup.getPSCtrlLogicGroupName());
    }

    protected void onFillParentInfo_PSCtrlMsg(PSDEViewCtrl pSDEViewCtrl, PSCtrlMsg pSCtrlMsg) throws Exception {
        pSDEViewCtrl.setPSCtrlMsgId(pSCtrlMsg.getPSCtrlMsgId());
        pSDEViewCtrl.setPSCtrlMsgName(pSCtrlMsg.getPSCtrlMsgName());
    }

    protected void onFillParentInfo_PSDE(PSDEViewCtrl pSDEViewCtrl, PSDataEntity pSDataEntity) throws Exception {
        pSDEViewCtrl.setPSDEId(pSDataEntity.getPSDataEntityId());
        pSDEViewCtrl.setPSDEName(pSDataEntity.getPSDataEntityName());
    }

    protected void onFillParentInfo_PSDEAction(PSDEViewCtrl pSDEViewCtrl, PSDEAction pSDEAction) throws Exception {
        pSDEViewCtrl.setPSDEActionId(pSDEAction.getPSDEActionId());
        pSDEViewCtrl.setPSDEActionName(pSDEAction.getPSDEActionName());
    }

    protected void onFillParentInfo_PSDEChart(PSDEViewCtrl pSDEViewCtrl, PSDEChart pSDEChart) throws Exception {
        pSDEViewCtrl.setPSDEChartId(pSDEChart.getPSDEChartId());
        pSDEViewCtrl.setPSDEChartName(pSDEChart.getPSDEChartName());
    }

    protected void onFillParentInfo_PSDEDataExp(PSDEViewCtrl pSDEViewCtrl, PSDEDataExp pSDEDataExp) throws Exception {
        pSDEViewCtrl.setPSDEDataExpId(pSDEDataExp.getPSDEDataExpId());
        pSDEViewCtrl.setPSDEDataExpName(pSDEDataExp.getPSDEDataExpName());
    }

    protected void onFillParentInfo_PSDEDataImp(PSDEViewCtrl pSDEViewCtrl, PSDEDataImp pSDEDataImp) throws Exception {
        pSDEViewCtrl.setPSDEDataImpId(pSDEDataImp.getPSDEDataImpId());
        pSDEViewCtrl.setPSDEDataImpName(pSDEDataImp.getPSDEDataImpName());
    }

    protected void onFillParentInfo_PSDEDR(PSDEViewCtrl pSDEViewCtrl, PSDEDataRelation pSDEDataRelation) throws Exception {
        pSDEViewCtrl.setPSDEDRId(pSDEDataRelation.getPSDEDataRelationId());
        pSDEViewCtrl.setPSDEDRName(pSDEDataRelation.getPSDEDataRelationName());
    }

    protected void onFillParentInfo_PSDEDataSet(PSDEViewCtrl pSDEViewCtrl, PSDEDataSet pSDEDataSet) throws Exception {
        pSDEViewCtrl.setPSDEDataSetId(pSDEDataSet.getPSDEDataSetId());
        pSDEViewCtrl.setPSDEDataSetName(pSDEDataSet.getPSDEDataSetName());
    }

    protected void onFillParentInfo_PSDEDataView(PSDEViewCtrl pSDEViewCtrl, PSDEDataView pSDEDataView) throws Exception {
        pSDEViewCtrl.setPSDEDataViewId(pSDEDataView.getPSDEDataViewId());
        pSDEViewCtrl.setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
    }

    protected void onFillParentInfo_PSDEForm(PSDEViewCtrl pSDEViewCtrl, PSDEForm pSDEForm) throws Exception {
        pSDEViewCtrl.setPSDEFormId(pSDEForm.getPSDEFormId());
        pSDEViewCtrl.setPSDEFormName(pSDEForm.getPSDEFormName());
    }

    protected void onFillParentInfo_PSDEGrid(PSDEViewCtrl pSDEViewCtrl, PSDEGrid pSDEGrid) throws Exception {
        pSDEViewCtrl.setPSDEGridId(pSDEGrid.getPSDEGridId());
        pSDEViewCtrl.setPSDEGridName(pSDEGrid.getPSDEGridName());
    }

    protected void onFillParentInfo_PSDEList(PSDEViewCtrl pSDEViewCtrl, PSDEList pSDEList) throws Exception {
        pSDEViewCtrl.setPSDEListId(pSDEList.getPSDEListId());
        pSDEViewCtrl.setPSDEListName(pSDEList.getPSDEListName());
    }

    protected void onFillParentInfo_ADPSDELogic(PSDEViewCtrl pSDEViewCtrl, PSDELogic pSDELogic) throws Exception {
        pSDEViewCtrl.setADPSDELogicId(pSDELogic.getPSDELogicId());
        pSDEViewCtrl.setADPSDELogicName(pSDELogic.getPSDELogicName());
    }

    protected void onFillParentInfo_PSDEOPPriv(PSDEViewCtrl pSDEViewCtrl, PSDEOPPriv pSDEOPPriv) throws Exception {
        pSDEViewCtrl.setPSDEOPPrivId(pSDEOPPriv.getPSDEOPPrivId());
        pSDEViewCtrl.setPSDEOPPrivName(pSDEOPPriv.getPSDEOPPrivName());
    }

    protected void onFillParentInfo_PSDEReport(PSDEViewCtrl pSDEViewCtrl, PSDEReport pSDEReport) throws Exception {
        pSDEViewCtrl.setPSDEReportId(pSDEReport.getPSDEReportId());
        pSDEViewCtrl.setPSDEReportName(pSDEReport.getPSDEReportName());
    }

    protected void onFillParentInfo_PSDEToolbar(PSDEViewCtrl pSDEViewCtrl, PSDEToolbar pSDEToolbar) throws Exception {
        pSDEViewCtrl.setPSDEToolbarId(pSDEToolbar.getPSDEToolbarId());
        pSDEViewCtrl.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
    }

    protected void onFillParentInfo_PSDETreeView(PSDEViewCtrl pSDEViewCtrl, PSDETreeView pSDETreeView) throws Exception {
        pSDEViewCtrl.setPSDETreeViewId(pSDETreeView.getPSDETreeViewId());
        pSDEViewCtrl.setPSDETreeViewName(pSDETreeView.getPSDETreeViewName());
    }

    protected void onFillParentInfo_No2PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEViewCtrl.setNO2PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEViewCtrl.setNO2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No3PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEViewCtrl.setNO3PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEViewCtrl.setNO3PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No4PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEViewCtrl.setNO4PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEViewCtrl.setNO4PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No5PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEViewCtrl.setNO5PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEViewCtrl.setNO5PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_No6PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEViewCtrl.setNO6PSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEViewCtrl.setNO6PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, PSDEUAGroup pSDEUAGroup) throws Exception {
        pSDEViewCtrl.setPSDEUAGroupId(pSDEUAGroup.getPSDEUAGroupId());
        pSDEViewCtrl.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
    }

    protected void onFillParentInfo_PSDEViewBase(PSDEViewCtrl pSDEViewCtrl, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEViewCtrl.setPSDEViewBaseId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewCtrl.setPSDEViewBaseName(pSDEViewBase.getPSDEViewBaseName());
        pSDEViewCtrl.setPSSystemId(pSDEViewBase.getPSSystemId());
    }

    protected String onSyncDER1NData_PSDEViewBase(PSDEViewBase pSDEViewBase, String string) throws Exception {
        if (StringHelper.isNullOrEmpty((String)string)) {
            this.removeByPSDEViewBase(pSDEViewBase);
        } else {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            String[] stringArray = StringHelper.splitEx((String)string);
            if (stringArray != null) {
                for (int i = 0; i < stringArray.length; ++i) {
                    if (StringHelper.isNullOrEmpty((String)stringArray[i])) continue;
                    hashMap.put(stringArray[i], "");
                }
            }
            ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
            for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
                if (hashMap.containsKey(DataObject.getStringValue((IDataObject)pSDEViewCtrl, (String)"PSDEVIEWCTRLID", (String)""))) continue;
                this.remove((IEntity)pSDEViewCtrl);
            }
        }
        return null;
    }

    protected void onFillParentInfo_PSDEView(PSDEViewCtrl pSDEViewCtrl, PSDEViewBase pSDEViewBase) throws Exception {
        pSDEViewCtrl.setPSDEViewId(pSDEViewBase.getPSDEViewBaseId());
        pSDEViewCtrl.setPSDEViewName(pSDEViewBase.getPSDEViewBaseName());
    }

    protected void onFillParentInfo_PSDEWizard(PSDEViewCtrl pSDEViewCtrl, PSDEWizard pSDEWizard) throws Exception {
        pSDEViewCtrl.setPSDEWizardId(pSDEWizard.getPSDEWizardId());
        pSDEViewCtrl.setPSDEWizardName(pSDEWizard.getPSDEWizardName());
    }

    protected void onFillParentInfo_CapPSLanRes(PSDEViewCtrl pSDEViewCtrl, PSLanguageRes pSLanguageRes) throws Exception {
        pSDEViewCtrl.setCapPSLanResId(pSLanguageRes.getPSLanguageResId());
        pSDEViewCtrl.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
    }

    protected void onFillParentInfo_PSPF(PSDEViewCtrl pSDEViewCtrl, PSPF pSPF) throws Exception {
        pSDEViewCtrl.setPSPFId(pSPF.getPSPFId());
        pSDEViewCtrl.setPSPFName(pSPF.getPSPFName());
    }

    protected void onFillParentInfo_PSSysCalendar(PSDEViewCtrl pSDEViewCtrl, PSSysCalendar pSSysCalendar) throws Exception {
        pSDEViewCtrl.setPSSysCalendarId(pSSysCalendar.getPSSysCalendarId());
        pSDEViewCtrl.setPSSysCalendarName(pSSysCalendar.getPSSysCalendarName());
    }

    protected void onFillParentInfo_PSSysCounter(PSDEViewCtrl pSDEViewCtrl, PSSysCounter pSSysCounter) throws Exception {
        pSDEViewCtrl.setPSSysCounterId(pSSysCounter.getPSSysCounterId());
        pSDEViewCtrl.setPSSysCounterName(pSSysCounter.getPSSysCounterName());
    }

    protected void onFillParentInfo_PSSysCss(PSDEViewCtrl pSDEViewCtrl, PSSysCss pSSysCss) throws Exception {
        pSDEViewCtrl.setPSSysCssId(pSSysCss.getPSSysCssId());
        pSDEViewCtrl.setPSSysCssName(pSSysCss.getPSSysCssName());
    }

    protected void onFillParentInfo_PSSysDashboard(PSDEViewCtrl pSDEViewCtrl, PSSysDashboard pSSysDashboard) throws Exception {
        pSDEViewCtrl.setPSSysDashboardId(pSSysDashboard.getPSSysDashboardId());
        pSDEViewCtrl.setPSSysDashboardName(pSSysDashboard.getPSSysDashboardName());
    }

    protected void onFillParentInfo_PSSysDynaModel(PSDEViewCtrl pSDEViewCtrl, PSSysDynaModel pSSysDynaModel) throws Exception {
        pSDEViewCtrl.setPSSysDynaModelId(pSSysDynaModel.getPSSysDynaModelId());
        pSDEViewCtrl.setPSSysDynaModelName(pSSysDynaModel.getPSSysDynaModelName());
    }

    protected void onFillParentInfo_PSSysImage(PSDEViewCtrl pSDEViewCtrl, PSSysImage pSSysImage) throws Exception {
        pSDEViewCtrl.setPSSysImageId(pSSysImage.getPSSysImageId());
        pSDEViewCtrl.setPSSysImageName(pSSysImage.getPSSysImageName());
    }

    protected void onFillParentInfo_PSSysMapView(PSDEViewCtrl pSDEViewCtrl, PSSysMapView pSSysMapView) throws Exception {
        pSDEViewCtrl.setPSSysMapViewId(pSSysMapView.getPSSysMapViewId());
        pSDEViewCtrl.setPSSysMapViewName(pSSysMapView.getPSSysMapViewName());
    }

    protected void onFillParentInfo_PSSysMsgTempl(PSDEViewCtrl pSDEViewCtrl, PSSysMsgTempl pSSysMsgTempl) throws Exception {
        pSDEViewCtrl.setPSSysMsgTemplId(pSSysMsgTempl.getPSSysMsgTemplId());
        pSDEViewCtrl.setPSSysMsgTemplName(pSSysMsgTempl.getPSSysMsgTemplName());
    }

    protected void onFillParentInfo_PSSysPFPlugin(PSDEViewCtrl pSDEViewCtrl, PSSysPFPlugin pSSysPFPlugin) throws Exception {
        pSDEViewCtrl.setPSSysPFPluginId(pSSysPFPlugin.getPSSysPFPluginId());
        pSDEViewCtrl.setPSSysPFPluginName(pSSysPFPlugin.getPSSysPFPluginName());
    }

    protected void onFillParentInfo_PSSysSearchBar(PSDEViewCtrl pSDEViewCtrl, PSSysSearchBar pSSysSearchBar) throws Exception {
        pSDEViewCtrl.setPSSysSearchBarId(pSSysSearchBar.getPSSysSearchBarId());
        pSDEViewCtrl.setPSSysSearchBarName(pSSysSearchBar.getPSSysSearchBarName());
    }

    protected void onFillParentInfo_PSSysViewPanel(PSDEViewCtrl pSDEViewCtrl, PSSysViewPanel pSSysViewPanel) throws Exception {
        pSDEViewCtrl.setPSSysViewPanelId(pSSysViewPanel.getPSSysViewPanelId());
        pSDEViewCtrl.setPSSysViewPanelName(pSSysViewPanel.getPSSysViewPanelName());
    }

    protected boolean onFillEntityKeyValue(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        StringBuilderEx stringBuilderEx = new StringBuilderEx();
        Object object = pSDEViewCtrl.get("PSDEVIEWBASEID");
        if (object == null) {
            object = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object);
        stringBuilderEx.append("||");
        Object object2 = pSDEViewCtrl.get("PSDEVIEWCTRLNAME");
        if (object2 == null) {
            object2 = "__EMTPY__";
        }
        stringBuilderEx.append("%1$s", object2);
        String string = stringBuilderEx.toString();
        pSDEViewCtrl.set(this.getPSDEViewCtrlDEModel().getKeyDEField().getName(), KeyValueHelper.genUniqueId((String)string));
        return true;
    }

    protected void onFillEntityFullInfo(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (bl) {
            if (pSDEViewCtrl.getDefaultFlag() == null) {
                pSDEViewCtrl.setDefaultFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "0", 9));
            }
            if (pSDEViewCtrl.getValidFlag() == null) {
                pSDEViewCtrl.setValidFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo((IEntity)pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSACHandler(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_SubPSACHandler(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSCtrlLogicGroup(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSCtrlMsg(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDE(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEAction(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEChart(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEDataExp(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEDataImp(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEDR(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEDataSet(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEDataView(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEForm(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEGrid(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEList(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_ADPSDELogic(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEOPPriv(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEReport(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEToolbar(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDETreeView(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_No2PSDEUAGroup(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_No3PSDEUAGroup(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_No4PSDEUAGroup(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_No5PSDEUAGroup(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_No6PSDEUAGroup(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEUAGroup(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEViewBase(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEView(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSDEWizard(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_CapPSLanRes(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSPF(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysCalendar(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysCounter(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysCss(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysDashboard(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysDynaModel(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysImage(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysMapView(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysMsgTempl(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysPFPlugin(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysSearchBar(pSDEViewCtrl, bl);
        this.onFillEntityFullInfo_PSSysViewPanel(pSDEViewCtrl, bl);
    }

    protected void onFillEntityFullInfo_PSACHandler(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_SubPSACHandler(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlLogicGroup(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSCtrlMsg(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDE(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isPSDEIdDirty()) {
            if (pSDEViewCtrl.getPSDEId() != null) {
                if (pSDEViewCtrl.getPSDEId() == null || pSDEViewCtrl.getPSDEName() == null) {
                    PSDataEntity pSDataEntity = pSDEViewCtrl.getPSDE();
                    pSDEViewCtrl.setPSDEName(pSDataEntity.getPSDataEntityName());
                }
            } else {
                pSDEViewCtrl.setPSDEName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEAction(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEChart(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataExp(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataImp(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDR(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isPSDEDRIdDirty()) {
            if (pSDEViewCtrl.getPSDEDRId() != null) {
                if (pSDEViewCtrl.getPSDEDRId() == null || pSDEViewCtrl.getPSDEDRName() == null) {
                    PSDEDataRelation pSDEDataRelation = pSDEViewCtrl.getPSDEDR();
                    pSDEViewCtrl.setPSDEDRName(pSDEDataRelation.getPSDEDataRelationName());
                }
            } else {
                pSDEViewCtrl.setPSDEDRName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEDataSet(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEDataView(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isPSDEDataViewIdDirty()) {
            if (pSDEViewCtrl.getPSDEDataViewId() != null) {
                if (pSDEViewCtrl.getPSDEDataViewId() == null || pSDEViewCtrl.getPSDEDataViewName() == null) {
                    PSDEDataView pSDEDataView = pSDEViewCtrl.getPSDEDataView();
                    pSDEViewCtrl.setPSDEDataViewName(pSDEDataView.getPSDEDataViewName());
                }
            } else {
                pSDEViewCtrl.setPSDEDataViewName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEForm(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isPSDEFormIdDirty()) {
            if (pSDEViewCtrl.getPSDEFormId() != null) {
                if (pSDEViewCtrl.getPSDEFormId() == null || pSDEViewCtrl.getPSDEFormName() == null) {
                    PSDEForm pSDEForm = pSDEViewCtrl.getPSDEForm();
                    pSDEViewCtrl.setPSDEFormName(pSDEForm.getPSDEFormName());
                }
            } else {
                pSDEViewCtrl.setPSDEFormName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEGrid(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isPSDEGridIdDirty()) {
            if (pSDEViewCtrl.getPSDEGridId() != null) {
                if (pSDEViewCtrl.getPSDEGridId() == null || pSDEViewCtrl.getPSDEGridName() == null) {
                    PSDEGrid pSDEGrid = pSDEViewCtrl.getPSDEGrid();
                    pSDEViewCtrl.setPSDEGridName(pSDEGrid.getPSDEGridName());
                }
            } else {
                pSDEViewCtrl.setPSDEGridName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEList(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_ADPSDELogic(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEOPPriv(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEReport(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEToolbar(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isPSDEToolbarIdDirty()) {
            if (pSDEViewCtrl.getPSDEToolbarId() != null) {
                if (pSDEViewCtrl.getPSDEToolbarId() == null || pSDEViewCtrl.getPSDEToolbarName() == null) {
                    PSDEToolbar pSDEToolbar = pSDEViewCtrl.getPSDEToolbar();
                    pSDEViewCtrl.setPSDEToolbarName(pSDEToolbar.getPSDEToolbarName());
                }
            } else {
                pSDEViewCtrl.setPSDEToolbarName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDETreeView(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_No2PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isNO2PSDEUAGroupIdDirty()) {
            if (pSDEViewCtrl.getNO2PSDEUAGroupId() != null) {
                if (pSDEViewCtrl.getNO2PSDEUAGroupId() == null || pSDEViewCtrl.getNO2PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEViewCtrl.getNo2PSDEUAGroup();
                    pSDEViewCtrl.setNO2PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEViewCtrl.setNO2PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No3PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isNO3PSDEUAGroupIdDirty()) {
            if (pSDEViewCtrl.getNO3PSDEUAGroupId() != null) {
                if (pSDEViewCtrl.getNO3PSDEUAGroupId() == null || pSDEViewCtrl.getNO3PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEViewCtrl.getNo3PSDEUAGroup();
                    pSDEViewCtrl.setNO3PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEViewCtrl.setNO3PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No4PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isNO4PSDEUAGroupIdDirty()) {
            if (pSDEViewCtrl.getNO4PSDEUAGroupId() != null) {
                if (pSDEViewCtrl.getNO4PSDEUAGroupId() == null || pSDEViewCtrl.getNO4PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEViewCtrl.getNo4PSDEUAGroup();
                    pSDEViewCtrl.setNO4PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEViewCtrl.setNO4PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No5PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isNO5PSDEUAGroupIdDirty()) {
            if (pSDEViewCtrl.getNO5PSDEUAGroupId() != null) {
                if (pSDEViewCtrl.getNO5PSDEUAGroupId() == null || pSDEViewCtrl.getNO5PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEViewCtrl.getNo5PSDEUAGroup();
                    pSDEViewCtrl.setNO5PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEViewCtrl.setNO5PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_No6PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isNO6PSDEUAGroupIdDirty()) {
            if (pSDEViewCtrl.getNO6PSDEUAGroupId() != null) {
                if (pSDEViewCtrl.getNO6PSDEUAGroupId() == null || pSDEViewCtrl.getNO6PSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEViewCtrl.getNo6PSDEUAGroup();
                    pSDEViewCtrl.setNO6PSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEViewCtrl.setNO6PSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEUAGroup(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isPSDEUAGroupIdDirty()) {
            if (pSDEViewCtrl.getPSDEUAGroupId() != null) {
                if (pSDEViewCtrl.getPSDEUAGroupId() == null || pSDEViewCtrl.getPSDEUAGroupName() == null) {
                    PSDEUAGroup pSDEUAGroup = pSDEViewCtrl.getPSDEUAGroup();
                    pSDEViewCtrl.setPSDEUAGroupName(pSDEUAGroup.getPSDEUAGroupName());
                }
            } else {
                pSDEViewCtrl.setPSDEUAGroupName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSDEViewBase(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEView(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSDEWizard(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_CapPSLanRes(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        if (pSDEViewCtrl.isCapPSLanResIdDirty()) {
            if (pSDEViewCtrl.getCapPSLanResId() != null) {
                if (pSDEViewCtrl.getCapPSLanResId() == null || pSDEViewCtrl.getCapPSLanResName() == null) {
                    PSLanguageRes pSLanguageRes = pSDEViewCtrl.getCapPSLanRes();
                    pSDEViewCtrl.setCapPSLanResName(pSLanguageRes.getPSLanguageResName());
                }
            } else {
                pSDEViewCtrl.setCapPSLanResName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSPF(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCalendar(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCounter(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCss(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDashboard(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysDynaModel(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysImage(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMapView(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysMsgTempl(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysPFPlugin(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysSearchBar(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysViewPanel(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
    }

    protected void onWriteBackParent(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        super.onWriteBackParent((IEntity)pSDEViewCtrl, bl);
    }

    public ArrayList<PSDEViewCtrl> selectByPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectByPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectBySubPSACHandler(PSACHandlerBase pSACHandlerBase) throws Exception {
        return this.selectBySubPSACHandler(pSACHandlerBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectBySubPSACHandler(PSACHandlerBase pSACHandlerBase, String string) throws Exception {
        return this.selectBySubPSACHandler(pSACHandlerBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectBySubPSACHandler(PSACHandlerBase pSACHandlerBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("SUBPSACHANDLERID", (Object)pSACHandlerBase.getPSACHandlerId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectBySubPSACHandlerCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectBySubPSACHandlerCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewCtrl> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string) throws Exception {
        return this.selectByPSCtrlLogicGroup(pSCtrlLogicGroupBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSCtrlLogicGroup(PSCtrlLogicGroupBase pSCtrlLogicGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string) throws Exception {
        return this.selectByPSCtrlMsg(pSCtrlMsgBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSCtrlMsg(PSCtrlMsgBase pSCtrlMsgBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDE(PSDataEntityBase pSDataEntityBase) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string) throws Exception {
        return this.selectByPSDE(pSDataEntityBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDE(PSDataEntityBase pSDataEntityBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEAction(PSDEActionBase pSDEActionBase) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string) throws Exception {
        return this.selectByPSDEAction(pSDEActionBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEAction(PSDEActionBase pSDEActionBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEChart(PSDEChartBase pSDEChartBase) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string) throws Exception {
        return this.selectByPSDEChart(pSDEChartBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEChart(PSDEChartBase pSDEChartBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEDataExp(PSDEDataExpBase pSDEDataExpBase) throws Exception {
        return this.selectByPSDEDataExp(pSDEDataExpBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDataExp(PSDEDataExpBase pSDEDataExpBase, String string) throws Exception {
        return this.selectByPSDEDataExp(pSDEDataExpBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDataExp(PSDEDataExpBase pSDEDataExpBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEDATAEXPID", (Object)pSDEDataExpBase.getPSDEDataExpId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEDataExpCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEDataExpCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDataImp(PSDEDataImpBase pSDEDataImpBase) throws Exception {
        return this.selectByPSDEDataImp(pSDEDataImpBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDataImp(PSDEDataImpBase pSDEDataImpBase, String string) throws Exception {
        return this.selectByPSDEDataImp(pSDEDataImpBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDataImp(PSDEDataImpBase pSDEDataImpBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase) throws Exception {
        return this.selectByPSDEDR(pSDEDataRelationBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase, String string) throws Exception {
        return this.selectByPSDEDR(pSDEDataRelationBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDR(PSDEDataRelationBase pSDEDataRelationBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string) throws Exception {
        return this.selectByPSDEDataSet(pSDEDataSetBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDataSet(PSDEDataSetBase pSDEDataSetBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEDataView(PSDEDataViewBase pSDEDataViewBase) throws Exception {
        return this.selectByPSDEDataView(pSDEDataViewBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDataView(PSDEDataViewBase pSDEDataViewBase, String string) throws Exception {
        return this.selectByPSDEDataView(pSDEDataViewBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEDataView(PSDEDataViewBase pSDEDataViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEForm(PSDEFormBase pSDEFormBase) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string) throws Exception {
        return this.selectByPSDEForm(pSDEFormBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEForm(PSDEFormBase pSDEFormBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEGrid(PSDEGridBase pSDEGridBase) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string) throws Exception {
        return this.selectByPSDEGrid(pSDEGridBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEGrid(PSDEGridBase pSDEGridBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEList(PSDEListBase pSDEListBase) throws Exception {
        return this.selectByPSDEList(pSDEListBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEList(PSDEListBase pSDEListBase, String string) throws Exception {
        return this.selectByPSDEList(pSDEListBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEList(PSDEListBase pSDEListBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByADPSDELogic(PSDELogicBase pSDELogicBase) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string) throws Exception {
        return this.selectByADPSDELogic(pSDELogicBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByADPSDELogic(PSDELogicBase pSDELogicBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string) throws Exception {
        return this.selectByPSDEOPPriv(pSDEOPPrivBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEOPPriv(PSDEOPPrivBase pSDEOPPrivBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEOPPRIVID", (Object)pSDEOPPrivBase.getPSDEOPPrivId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEOPPrivCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEOPPrivCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEReport(PSDEReportBase pSDEReportBase) throws Exception {
        return this.selectByPSDEReport(pSDEReportBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEReport(PSDEReportBase pSDEReportBase, String string) throws Exception {
        return this.selectByPSDEReport(pSDEReportBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEReport(PSDEReportBase pSDEReportBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string) throws Exception {
        return this.selectByPSDEToolbar(pSDEToolbarBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEToolbar(PSDEToolbarBase pSDEToolbarBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string) throws Exception {
        return this.selectByPSDETreeView(pSDETreeViewBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDETreeView(PSDETreeViewBase pSDETreeViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo2PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo2PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByNo3PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo3PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo3PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo3PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo3PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByNo4PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo4PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo4PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo4PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo4PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByNo5PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo5PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo5PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo5PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo5PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByNo6PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByNo6PSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo6PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByNo6PSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByNo6PSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string) throws Exception {
        return this.selectByPSDEUAGroup(pSDEUAGroupBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEUAGroup(PSDEUAGroupBase pSDEUAGroupBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEViewBase(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectTempByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectTempByPSDEViewBase(pSDEViewBaseBase, "");
    }

    public ArrayList<PSDEViewCtrl> selectTempByPSDEViewBase(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWBASEID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        selectCond.setOrderInfo(string);
        this.onFillSelectTempByPSDEViewBaseCond(selectCond);
        return this.selectTemp((ISelectCond)selectCond);
    }

    protected void onFillSelectTempByPSDEViewBaseCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEView(PSDEViewBaseBase pSDEViewBaseBase) throws Exception {
        return this.selectByPSDEView(pSDEViewBaseBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string) throws Exception {
        return this.selectByPSDEView(pSDEViewBaseBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEView(PSDEViewBaseBase pSDEViewBaseBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSDEVIEWID", (Object)pSDEViewBaseBase.getPSDEViewBaseId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSDEViewCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSDEViewCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string) throws Exception {
        return this.selectByPSDEWizard(pSDEWizardBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSDEWizard(PSDEWizardBase pSDEWizardBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string) throws Exception {
        return this.selectByCapPSLanRes(pSLanguageResBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByCapPSLanRes(PSLanguageResBase pSLanguageResBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSPF(PSPFBase pSPFBase) throws Exception {
        return this.selectByPSPF(pSPFBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSPF(PSPFBase pSPFBase, String string) throws Exception {
        return this.selectByPSPF(pSPFBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSPF(PSPFBase pSPFBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSPFID", (Object)pSPFBase.getPSPFId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSPFCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSPFCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string) throws Exception {
        return this.selectByPSSysCalendar(pSSysCalendarBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysCalendar(PSSysCalendarBase pSSysCalendarBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string) throws Exception {
        return this.selectByPSSysCounter(pSSysCounterBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysCounter(PSSysCounterBase pSSysCounterBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSSysCss(PSSysCssBase pSSysCssBase) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string) throws Exception {
        return this.selectByPSSysCss(pSSysCssBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysCss(PSSysCssBase pSSysCssBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase) throws Exception {
        return this.selectByPSSysDashboard(pSSysDashboardBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase, String string) throws Exception {
        return this.selectByPSSysDashboard(pSSysDashboardBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysDashboard(PSSysDashboardBase pSSysDashboardBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string) throws Exception {
        return this.selectByPSSysDynaModel(pSSysDynaModelBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysDynaModel(PSSysDynaModelBase pSSysDynaModelBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSSysImage(PSSysImageBase pSSysImageBase) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string) throws Exception {
        return this.selectByPSSysImage(pSSysImageBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysImage(PSSysImageBase pSSysImageBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase) throws Exception {
        return this.selectByPSSysMapView(pSSysMapViewBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase, String string) throws Exception {
        return this.selectByPSSysMapView(pSSysMapViewBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysMapView(PSSysMapViewBase pSSysMapViewBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string) throws Exception {
        return this.selectByPSSysMsgTempl(pSSysMsgTemplBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysMsgTempl(PSSysMsgTemplBase pSSysMsgTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSMSGTEMPLID", (Object)pSSysMsgTemplBase.getPSSysMsgTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysMsgTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysMsgTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string) throws Exception {
        return this.selectByPSSysPFPlugin(pSSysPFPluginBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysPFPlugin(PSSysPFPluginBase pSSysPFPluginBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSSysSearchBar(PSSysSearchBarBase pSSysSearchBarBase) throws Exception {
        return this.selectByPSSysSearchBar(pSSysSearchBarBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysSearchBar(PSSysSearchBarBase pSSysSearchBarBase, String string) throws Exception {
        return this.selectByPSSysSearchBar(pSSysSearchBarBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysSearchBar(PSSysSearchBarBase pSSysSearchBarBase, String string, int n) throws Exception {
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

    public ArrayList<PSDEViewCtrl> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, "", -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string) throws Exception {
        return this.selectByPSSysViewPanel(pSSysViewPanelBase, string, -1);
    }

    public ArrayList<PSDEViewCtrl> selectByPSSysViewPanel(PSSysViewPanelBase pSSysViewPanelBase, String string, int n) throws Exception {
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

    public void testRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSACHANDLER_PSACHANDLERID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSACHandler), arrayList.get(0)));
        }
    }

    public void resetPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSACHandler(pSACHandler);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSACHandlerId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSACHandler(pSACHandler2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSACHandler(pSACHandler2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSACHandler(pSACHandler);
        this.onBeforeRemoveByPSACHandler(pSACHandler, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveBySubPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectBySubPSACHandler(pSACHandler, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSACHANDLER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSACHandler);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSACHANDLER_SUBPSACHANDLERID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSACHandler), arrayList.get(0)));
        }
    }

    public void resetSubPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectBySubPSACHandler(pSACHandler);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setSubPSACHandlerId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeBySubPSACHandler(PSACHandler pSACHandler) throws Exception {
        final PSACHandler pSACHandler2 = pSACHandler;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveBySubPSACHandler(pSACHandler2);
                PSDEViewCtrlServiceBase.this.internalRemoveBySubPSACHandler(pSACHandler2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveBySubPSACHandler(pSACHandler2);
            }
        });
    }

    protected void onBeforeRemoveBySubPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void internalRemoveBySubPSACHandler(PSACHandler pSACHandler) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectBySubPSACHandler(pSACHandler);
        this.onBeforeRemoveBySubPSACHandler(pSACHandler, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveBySubPSACHandler(pSACHandler, arrayList);
    }

    protected void onAfterRemoveBySubPSACHandler(PSACHandler pSACHandler) throws Exception {
    }

    protected void onBeforeRemoveBySubPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveBySubPSACHandler(PSACHandler pSACHandler, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLLOGICGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlLogicGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSCTRLLOGICGROUP_PSCTRLLOGICGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSCtrlLogicGroup), arrayList.get(0)));
        }
    }

    public void resetPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSCtrlLogicGroupId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        final PSCtrlLogicGroup pSCtrlLogicGroup2 = pSCtrlLogicGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void internalRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSCtrlLogicGroup(pSCtrlLogicGroup);
        this.onBeforeRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSCtrlLogicGroup(pSCtrlLogicGroup, arrayList);
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlLogicGroup(PSCtrlLogicGroup pSCtrlLogicGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCTRLMSG");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSCtrlMsg);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSCTRLMSG_PSCTRLMSGID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSCtrlMsg), arrayList.get(0)));
        }
    }

    public void resetPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSCtrlMsgId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        final PSCtrlMsg pSCtrlMsg2 = pSCtrlMsg;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSCtrlMsg(pSCtrlMsg2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg2);
            }
        });
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void internalRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSCtrlMsg(pSCtrlMsg);
        this.onBeforeRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSCtrlMsg(pSCtrlMsg, arrayList);
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg) throws Exception {
    }

    protected void onBeforeRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCtrlMsg(PSCtrlMsg pSCtrlMsg, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDE(pSDataEntity, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDATAENTITY");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDataEntity);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDATAENTITY_PSDEID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDataEntity), arrayList.get(0)));
        }
    }

    public void resetPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDE(pSDataEntity);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDE(PSDataEntity pSDataEntity) throws Exception {
        final PSDataEntity pSDataEntity2 = pSDataEntity;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDE(pSDataEntity2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDE(pSDataEntity2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDE(pSDataEntity2);
            }
        });
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void internalRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDE(pSDataEntity);
        this.onBeforeRemoveByPSDE(pSDataEntity, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDE(pSDataEntity, arrayList);
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity) throws Exception {
    }

    protected void onBeforeRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDE(PSDataEntity pSDataEntity, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEAction(pSDEAction, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEACTION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEAction);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEACTION_PSDEACTIONID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEAction), arrayList.get(0)));
        }
    }

    public void resetPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEAction(pSDEAction);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEActionId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEAction(PSDEAction pSDEAction) throws Exception {
        final PSDEAction pSDEAction2 = pSDEAction;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEAction(pSDEAction2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEAction(pSDEAction2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEAction(pSDEAction2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void internalRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEAction(pSDEAction);
        this.onBeforeRemoveByPSDEAction(pSDEAction, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEAction(pSDEAction, arrayList);
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction) throws Exception {
    }

    protected void onBeforeRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEAction(PSDEAction pSDEAction, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEChart(pSDEChart, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDECHART");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEChart);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDECHART_PSDECHARTID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEChart), arrayList.get(0)));
        }
    }

    public void resetPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEChart(pSDEChart);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEChartId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEChart(PSDEChart pSDEChart) throws Exception {
        final PSDEChart pSDEChart2 = pSDEChart;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEChart(pSDEChart2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEChart(pSDEChart2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEChart(pSDEChart2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void internalRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEChart(pSDEChart);
        this.onBeforeRemoveByPSDEChart(pSDEChart, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEChart(pSDEChart, arrayList);
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart) throws Exception {
    }

    protected void onBeforeRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEChart(PSDEChart pSDEChart, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataExp(pSDEDataExp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAEXP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataExp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEDATAEXP_PSDEDATAEXPID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEDataExp), arrayList.get(0)));
        }
    }

    public void resetPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataExp(pSDEDataExp);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEDataExpId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        final PSDEDataExp pSDEDataExp2 = pSDEDataExp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEDataExp(pSDEDataExp2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEDataExp(pSDEDataExp2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEDataExp(pSDEDataExp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
    }

    protected void internalRemoveByPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataExp(pSDEDataExp);
        this.onBeforeRemoveByPSDEDataExp(pSDEDataExp, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEDataExp(pSDEDataExp, arrayList);
    }

    protected void onAfterRemoveByPSDEDataExp(PSDEDataExp pSDEDataExp) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataExp(PSDEDataExp pSDEDataExp, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataExp(PSDEDataExp pSDEDataExp, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataImp(pSDEDataImp, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAIMP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataImp);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEDATAIMP_PSDEDATAIMPID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEDataImp), arrayList.get(0)));
        }
    }

    public void resetPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataImp(pSDEDataImp);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEDataImpId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        final PSDEDataImp pSDEDataImp2 = pSDEDataImp;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEDataImp(pSDEDataImp2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEDataImp(pSDEDataImp2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEDataImp(pSDEDataImp2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
    }

    protected void internalRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataImp(pSDEDataImp);
        this.onBeforeRemoveByPSDEDataImp(pSDEDataImp, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEDataImp(pSDEDataImp, arrayList);
    }

    protected void onAfterRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataImp(PSDEDataImp pSDEDataImp, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDR(pSDEDataRelation, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATARELATION");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataRelation);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEDATARELATION_PSDEDRID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEDataRelation), arrayList.get(0)));
        }
    }

    public void resetPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDR(pSDEDataRelation);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEDRId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        final PSDEDataRelation pSDEDataRelation2 = pSDEDataRelation;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEDR(pSDEDataRelation2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEDR(pSDEDataRelation2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEDR(pSDEDataRelation2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void internalRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDR(pSDEDataRelation);
        this.onBeforeRemoveByPSDEDR(pSDEDataRelation, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEDR(pSDEDataRelation, arrayList);
    }

    protected void onAfterRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDR(PSDEDataRelation pSDEDataRelation, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataSet(pSDEDataSet, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATASET");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataSet);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEDATASET_PSDEDATASETID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEDataSet), arrayList.get(0)));
        }
    }

    public void resetPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEDataSetId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        final PSDEDataSet pSDEDataSet2 = pSDEDataSet;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEDataSet(pSDEDataSet2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEDataSet(pSDEDataSet2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void internalRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataSet(pSDEDataSet);
        this.onBeforeRemoveByPSDEDataSet(pSDEDataSet, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEDataSet(pSDEDataSet, arrayList);
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataSet(PSDEDataSet pSDEDataSet, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataView(pSDEDataView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEDATAVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEDataView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEDATAVIEW_PSDEDATAVIEWID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEDataView), arrayList.get(0)));
        }
    }

    public void resetPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataView(pSDEDataView);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEDataViewId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        final PSDEDataView pSDEDataView2 = pSDEDataView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEDataView(pSDEDataView2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEDataView(pSDEDataView2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEDataView(pSDEDataView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
    }

    protected void internalRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEDataView(pSDEDataView);
        this.onBeforeRemoveByPSDEDataView(pSDEDataView, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEDataView(pSDEDataView, arrayList);
    }

    protected void onAfterRemoveByPSDEDataView(PSDEDataView pSDEDataView) throws Exception {
    }

    protected void onBeforeRemoveByPSDEDataView(PSDEDataView pSDEDataView, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEDataView(PSDEDataView pSDEDataView, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEForm(pSDEForm, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEFORM");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEForm);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEFORM_PSDEFORMID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEForm), arrayList.get(0)));
        }
    }

    public void resetPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEForm(pSDEForm);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEFormId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEForm(PSDEForm pSDEForm) throws Exception {
        final PSDEForm pSDEForm2 = pSDEForm;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEForm(pSDEForm2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEForm(pSDEForm2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEForm(pSDEForm2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void internalRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEForm(pSDEForm);
        this.onBeforeRemoveByPSDEForm(pSDEForm, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEForm(pSDEForm, arrayList);
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm) throws Exception {
    }

    protected void onBeforeRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEForm(PSDEForm pSDEForm, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEGrid(pSDEGrid, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEGRID");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEGrid);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEGRID_PSDEGRIDID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEGrid), arrayList.get(0)));
        }
    }

    public void resetPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEGrid(pSDEGrid);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEGridId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        final PSDEGrid pSDEGrid2 = pSDEGrid;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEGrid(pSDEGrid2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEGrid(pSDEGrid2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEGrid(pSDEGrid2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void internalRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEGrid(pSDEGrid);
        this.onBeforeRemoveByPSDEGrid(pSDEGrid, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEGrid(pSDEGrid, arrayList);
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid) throws Exception {
    }

    protected void onBeforeRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEGrid(PSDEGrid pSDEGrid, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEList(pSDEList, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELIST");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEList);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDELIST_PSDELISTID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEList), arrayList.get(0)));
        }
    }

    public void resetPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEList(pSDEList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEListId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEList(PSDEList pSDEList) throws Exception {
        final PSDEList pSDEList2 = pSDEList;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEList(pSDEList2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEList(pSDEList2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEList(pSDEList2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void internalRemoveByPSDEList(PSDEList pSDEList) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEList(pSDEList);
        this.onBeforeRemoveByPSDEList(pSDEList, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEList(pSDEList, arrayList);
    }

    protected void onAfterRemoveByPSDEList(PSDEList pSDEList) throws Exception {
    }

    protected void onBeforeRemoveByPSDEList(PSDEList pSDEList, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEList(PSDEList pSDEList, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByADPSDELogic(pSDELogic, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDELOGIC");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDELogic);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDELOGIC_ADPSDELOGICID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDELogic), arrayList.get(0)));
        }
    }

    public void resetADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByADPSDELogic(pSDELogic);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setADPSDELogicId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        final PSDELogic pSDELogic2 = pSDELogic;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByADPSDELogic(pSDELogic2);
                PSDEViewCtrlServiceBase.this.internalRemoveByADPSDELogic(pSDELogic2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByADPSDELogic(pSDELogic2);
            }
        });
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void internalRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByADPSDELogic(pSDELogic);
        this.onBeforeRemoveByADPSDELogic(pSDELogic, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByADPSDELogic(pSDELogic, arrayList);
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic) throws Exception {
    }

    protected void onBeforeRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByADPSDELogic(PSDELogic pSDELogic, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEOPPRIV");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEOPPriv);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEOPPRIV_PSDEOPPRIVID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEOPPriv), arrayList.get(0)));
        }
    }

    public void resetPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEOPPrivId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        final PSDEOPPriv pSDEOPPriv2 = pSDEOPPriv;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEOPPriv(pSDEOPPriv2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void internalRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEOPPriv(pSDEOPPriv);
        this.onBeforeRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEOPPriv(pSDEOPPriv, arrayList);
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv) throws Exception {
    }

    protected void onBeforeRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEOPPriv(PSDEOPPriv pSDEOPPriv, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEReport(pSDEReport, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEREPORT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEReport);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEREPORT_PSDEREPORTID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEReport), arrayList.get(0)));
        }
    }

    public void resetPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEReport(pSDEReport);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEReportId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEReport(PSDEReport pSDEReport) throws Exception {
        final PSDEReport pSDEReport2 = pSDEReport;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEReport(pSDEReport2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEReport(pSDEReport2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEReport(pSDEReport2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void internalRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEReport(pSDEReport);
        this.onBeforeRemoveByPSDEReport(pSDEReport, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEReport(pSDEReport, arrayList);
    }

    protected void onAfterRemoveByPSDEReport(PSDEReport pSDEReport) throws Exception {
    }

    protected void onBeforeRemoveByPSDEReport(PSDEReport pSDEReport, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEReport(PSDEReport pSDEReport, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEToolbar(pSDEToolbar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETOOLBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEToolbar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDETOOLBAR_PSDETOOLBARID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEToolbar), arrayList.get(0)));
        }
    }

    public void resetPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEToolbarId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        final PSDEToolbar pSDEToolbar2 = pSDEToolbar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEToolbar(pSDEToolbar2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEToolbar(pSDEToolbar2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEToolbar(pSDEToolbar2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void internalRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEToolbar(pSDEToolbar);
        this.onBeforeRemoveByPSDEToolbar(pSDEToolbar, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEToolbar(pSDEToolbar, arrayList);
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar) throws Exception {
    }

    protected void onBeforeRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEToolbar(PSDEToolbar pSDEToolbar, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDETreeView(pSDETreeView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDETREEVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDETreeView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDETREEVIEW_PSDETREEVIEWID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDETreeView), arrayList.get(0)));
        }
    }

    public void resetPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDETreeView(pSDETreeView);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDETreeViewId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        final PSDETreeView pSDETreeView2 = pSDETreeView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDETreeView(pSDETreeView2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDETreeView(pSDETreeView2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDETreeView(pSDETreeView2);
            }
        });
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void internalRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDETreeView(pSDETreeView);
        this.onBeforeRemoveByPSDETreeView(pSDETreeView, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDETreeView(pSDETreeView, arrayList);
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView) throws Exception {
    }

    protected void onBeforeRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDETreeView(PSDETreeView pSDETreeView, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO2PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setNO2PSDEUAGroupId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.internalRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo2PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByNo2PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo2PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo3PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO3PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo3PSDEUAGroup(pSDEUAGroup);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setNO3PSDEUAGroupId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByNo3PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.internalRemoveByNo3PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByNo3PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo3PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo3PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByNo3PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo3PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo4PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO4PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo4PSDEUAGroup(pSDEUAGroup);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setNO4PSDEUAGroupId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByNo4PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.internalRemoveByNo4PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByNo4PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo4PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo4PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByNo4PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo4PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo5PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO5PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo5PSDEUAGroup(pSDEUAGroup);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setNO5PSDEUAGroupId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByNo5PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.internalRemoveByNo5PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByNo5PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo5PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo5PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByNo5PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo5PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo6PSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEUAGROUP_NO6PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo6PSDEUAGroup(pSDEUAGroup);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setNO6PSDEUAGroupId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByNo6PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.internalRemoveByNo6PSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByNo6PSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByNo6PSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByNo6PSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByNo6PSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByNo6PSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEUAGROUP");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEUAGroup);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEUAGROUP_PSDEUAGROUPID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEUAGroup), arrayList.get(0)));
        }
    }

    public void resetPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEUAGroupId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        final PSDEUAGroup pSDEUAGroup2 = pSDEUAGroup;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEUAGroup(pSDEUAGroup2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void internalRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEUAGroup(pSDEUAGroup);
        this.onBeforeRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEUAGroup(pSDEUAGroup, arrayList);
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup) throws Exception {
    }

    protected void onBeforeRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEUAGroup(PSDEUAGroup pSDEUAGroup, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    public void resetPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEViewBaseId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void resetTempPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectTempByPSDEViewBase(pSDEViewBase);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEViewBaseId(null);
            this.updateTemp((IEntity)pSDEViewCtrl2);
        }
    }

    public void removeByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEViewBase(pSDEViewBase2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEView(pSDEViewBase, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEVIEWBASE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEViewBase);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEViewBase), arrayList.get(0)));
        }
    }

    public void resetPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEView(pSDEViewBase);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEViewId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEView(pSDEViewBase2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEView(pSDEViewBase2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEView(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEView(pSDEViewBase);
        this.onBeforeRemoveByPSDEView(pSDEViewBase, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEView(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveByPSDEView(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveByPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEView(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEWizard(pSDEWizard, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSDEWIZARD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSDEWizard);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSDEWIZARD_PSDEWIZARDID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSDEWizard), arrayList.get(0)));
        }
    }

    public void resetPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEWizard(pSDEWizard);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSDEWizardId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        final PSDEWizard pSDEWizard2 = pSDEWizard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSDEWizard(pSDEWizard2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSDEWizard(pSDEWizard2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSDEWizard(pSDEWizard2);
            }
        });
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void internalRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSDEWizard(pSDEWizard);
        this.onBeforeRemoveByPSDEWizard(pSDEWizard, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSDEWizard(pSDEWizard, arrayList);
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard) throws Exception {
    }

    protected void onBeforeRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSDEWizard(PSDEWizard pSDEWizard, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByCapPSLanRes(pSLanguageRes, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSLANGUAGERES");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSLanguageRes);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSLANGUAGERES_CAPPSLANRESID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSLanguageRes), arrayList.get(0)));
        }
    }

    public void resetCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setCapPSLanResId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        final PSLanguageRes pSLanguageRes2 = pSLanguageRes;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEViewCtrlServiceBase.this.internalRemoveByCapPSLanRes(pSLanguageRes2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByCapPSLanRes(pSLanguageRes2);
            }
        });
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void internalRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByCapPSLanRes(pSLanguageRes);
        this.onBeforeRemoveByCapPSLanRes(pSLanguageRes, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByCapPSLanRes(pSLanguageRes, arrayList);
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes) throws Exception {
    }

    protected void onBeforeRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByCapPSLanRes(PSLanguageRes pSLanguageRes, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSPF(pSPF, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSPF");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSPF);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSPF_PSPFID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSPF), arrayList.get(0)));
        }
    }

    public void resetPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSPF(pSPF);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSPFId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSPF(PSPF pSPF) throws Exception {
        final PSPF pSPF2 = pSPF;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSPF(pSPF2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSPF(pSPF2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSPF(pSPF2);
            }
        });
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void internalRemoveByPSPF(PSPF pSPF) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSPF(pSPF);
        this.onBeforeRemoveByPSPF(pSPF, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSPF(pSPF, arrayList);
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF) throws Exception {
    }

    protected void onBeforeRemoveByPSPF(PSPF pSPF, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSPF(PSPF pSPF, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysCalendar(pSSysCalendar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCALENDAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCalendar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSCALENDAR_PSSYSCALENDARID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysCalendar), arrayList.get(0)));
        }
    }

    public void resetPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysCalendarId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        final PSSysCalendar pSSysCalendar2 = pSSysCalendar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysCalendar(pSSysCalendar2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysCalendar(pSSysCalendar2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysCalendar(pSSysCalendar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void internalRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysCalendar(pSSysCalendar);
        this.onBeforeRemoveByPSSysCalendar(pSSysCalendar, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysCalendar(pSSysCalendar, arrayList);
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCalendar(PSSysCalendar pSSysCalendar, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysCounter(pSSysCounter, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCOUNTER");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCounter);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSCOUNTER_PSSYSCOUNTERID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysCounter), arrayList.get(0)));
        }
    }

    public void resetPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysCounter(pSSysCounter);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysCounterId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        final PSSysCounter pSSysCounter2 = pSSysCounter;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysCounter(pSSysCounter2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysCounter(pSSysCounter2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysCounter(pSSysCounter2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void internalRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysCounter(pSSysCounter);
        this.onBeforeRemoveByPSSysCounter(pSSysCounter, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysCounter(pSSysCounter, arrayList);
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCounter(PSSysCounter pSSysCounter, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysCss(pSSysCss, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSS");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysCss);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSCSS_PSSYSCSSID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysCss), arrayList.get(0)));
        }
    }

    public void resetPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysCss(pSSysCss);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysCssId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysCss(PSSysCss pSSysCss) throws Exception {
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysCss(pSSysCss2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysCss(pSSysCss2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysCss(pSSysCss2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void internalRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysCss(pSSysCss);
        this.onBeforeRemoveByPSSysCss(pSSysCss, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysCss(pSSysCss, arrayList);
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCss(PSSysCss pSSysCss, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysDashboard(pSSysDashboard, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDASHBOARD");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDashboard);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSDASHBOARD_PSSYSDASHBOARDID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysDashboard), arrayList.get(0)));
        }
    }

    public void resetPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysDashboard(pSSysDashboard);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysDashboardId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        final PSSysDashboard pSSysDashboard2 = pSSysDashboard;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysDashboard(pSSysDashboard2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysDashboard(pSSysDashboard2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysDashboard(pSSysDashboard2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
    }

    protected void internalRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysDashboard(pSSysDashboard);
        this.onBeforeRemoveByPSSysDashboard(pSSysDashboard, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysDashboard(pSSysDashboard, arrayList);
    }

    protected void onAfterRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDashboard(PSSysDashboard pSSysDashboard, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSDYNAMODEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysDynaModel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSDYNAMODEL_PSSYSDYNAMODELID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysDynaModel), arrayList.get(0)));
        }
    }

    public void resetPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysDynaModelId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        final PSSysDynaModel pSSysDynaModel2 = pSSysDynaModel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysDynaModel(pSSysDynaModel2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void internalRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysDynaModel(pSSysDynaModel);
        this.onBeforeRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysDynaModel(pSSysDynaModel, arrayList);
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysDynaModel(PSSysDynaModel pSSysDynaModel, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysImage(pSSysImage, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSIMAGE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysImage);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSIMAGE_PSSYSIMAGEID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysImage), arrayList.get(0)));
        }
    }

    public void resetPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysImage(pSSysImage);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysImageId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysImage(PSSysImage pSSysImage) throws Exception {
        final PSSysImage pSSysImage2 = pSSysImage;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysImage(pSSysImage2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysImage(pSSysImage2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysImage(pSSysImage2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void internalRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysImage(pSSysImage);
        this.onBeforeRemoveByPSSysImage(pSSysImage, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysImage(pSSysImage, arrayList);
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage) throws Exception {
    }

    protected void onBeforeRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysImage(PSSysImage pSSysImage, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysMapView(pSSysMapView, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMAPVIEW");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysMapView);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSMAPVIEW_PSSYSMAPVIEWID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysMapView), arrayList.get(0)));
        }
    }

    public void resetPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysMapView(pSSysMapView);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysMapViewId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        final PSSysMapView pSSysMapView2 = pSSysMapView;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysMapView(pSSysMapView2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysMapView(pSSysMapView2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysMapView(pSSysMapView2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void internalRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysMapView(pSSysMapView);
        this.onBeforeRemoveByPSSysMapView(pSSysMapView, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysMapView(pSSysMapView, arrayList);
    }

    protected void onAfterRemoveByPSSysMapView(PSSysMapView pSSysMapView) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMapView(PSSysMapView pSSysMapView, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSMSGTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysMsgTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSMSGTEMPL_PSSYSMSGTEMPLID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysMsgTempl), arrayList.get(0)));
        }
    }

    public void resetPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysMsgTemplId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        final PSSysMsgTempl pSSysMsgTempl2 = pSSysMsgTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysMsgTempl(pSSysMsgTempl2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void internalRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysMsgTempl(pSSysMsgTempl);
        this.onBeforeRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysMsgTempl(pSSysMsgTempl, arrayList);
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysMsgTempl(PSSysMsgTempl pSSysMsgTempl, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSPFPLUGIN");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysPFPlugin);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSPFPLUGIN_PSSYSPFPLUGINID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysPFPlugin), arrayList.get(0)));
        }
    }

    public void resetPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysPFPluginId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        final PSSysPFPlugin pSSysPFPlugin2 = pSSysPFPlugin;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysPFPlugin(pSSysPFPlugin2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void internalRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysPFPlugin(pSSysPFPlugin);
        this.onBeforeRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysPFPlugin(pSSysPFPlugin, arrayList);
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin) throws Exception {
    }

    protected void onBeforeRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysPFPlugin(PSSysPFPlugin pSSysPFPlugin, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysSearchBar(pSSysSearchBar, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSSEARCHBAR");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysSearchBar);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSSEARCHBAR_PSSYSSEARCHBARID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysSearchBar), arrayList.get(0)));
        }
    }

    public void resetPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysSearchBar(pSSysSearchBar);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysSearchBarId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
        final PSSysSearchBar pSSysSearchBar2 = pSSysSearchBar;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysSearchBar(pSSysSearchBar2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysSearchBar(pSSysSearchBar2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysSearchBar(pSSysSearchBar2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
    }

    protected void internalRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysSearchBar(pSSysSearchBar);
        this.onBeforeRemoveByPSSysSearchBar(pSSysSearchBar, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysSearchBar(pSSysSearchBar, arrayList);
    }

    protected void onAfterRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar) throws Exception {
    }

    protected void onBeforeRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysSearchBar(PSSysSearchBar pSSysSearchBar, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    public void testRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSVIEWPANEL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache((IEntity)pSSysViewPanel);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSDEVIEWCTRL_PSSYSVIEWPANEL_PSSYSVIEWPANELID", "", iDataEntityModel.getName(), "PSDEVIEWCTRL", iDataEntityModel.getDataInfo((IEntity)pSSysViewPanel), arrayList.get(0)));
        }
    }

    public void resetPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            PSDEViewCtrl pSDEViewCtrl2 = (PSDEViewCtrl)this.getDEModel().createEntity();
            pSDEViewCtrl2.setPSDEViewCtrlId(pSDEViewCtrl.getPSDEViewCtrlId());
            pSDEViewCtrl2.setPSSysViewPanelId(null);
            this.update(pSDEViewCtrl2);
        }
    }

    public void removeByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        final PSSysViewPanel pSSysViewPanel2 = pSSysViewPanel;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEViewCtrlServiceBase.this.internalRemoveByPSSysViewPanel(pSSysViewPanel2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void internalRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectByPSSysViewPanel(pSSysViewPanel);
        this.onBeforeRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.remove((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveByPSSysViewPanel(pSSysViewPanel, arrayList);
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel) throws Exception {
    }

    protected void onBeforeRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysViewPanel(PSSysViewPanel pSSysViewPanel, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewCtrlDSService)ServiceGlobal.getService(PSDEViewCtrlDSService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlDSServiceBase)pSCoreSysServiceBase).testRemoveByPsdeviewctrl(pSDEViewCtrl);
        ((PSDEViewCtrlDSServiceBase)pSCoreSysServiceBase).removeByPsdeviewctrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo2PSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo3PSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByNo4PSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByParamPSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).testRemoveByPSDEViewCtrl(pSDEViewCtrl);
        super.onBeforeRemove(pSDEViewCtrl);
    }

    protected void onBeforeRemoveTemp(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).resetTempPSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewLogicService)ServiceGlobal.getService(PSDEViewLogicService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewLogicServiceBase)pSCoreSysServiceBase).resetTempParamPSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).resetTempPSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).resetTempNo4PSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).resetTempNo3PSDEViewCtrl(pSDEViewCtrl);
        pSCoreSysServiceBase = (PSDEViewEngineService)ServiceGlobal.getService(PSDEViewEngineService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewEngineServiceBase)pSCoreSysServiceBase).resetTempNo2PSDEViewCtrl(pSDEViewCtrl);
        super.onBeforeRemoveTemp((IEntity)pSDEViewCtrl);
    }

    public void removeTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        final PSDEViewBase pSDEViewBase2 = pSDEViewBase;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSDEViewCtrlServiceBase.this.onBeforeRemoveTempByPSDEViewBase(pSDEViewBase2);
                PSDEViewCtrlServiceBase.this.internalRemoveTempByPSDEViewBase(pSDEViewBase2);
                PSDEViewCtrlServiceBase.this.onAfterRemoveTempByPSDEViewBase(pSDEViewBase2);
            }
        });
    }

    protected void onBeforeRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void internalRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
        ArrayList<PSDEViewCtrl> arrayList = this.selectTempByPSDEViewBase(pSDEViewBase);
        this.onBeforeRemoveTempByPSDEViewBase(pSDEViewBase, arrayList);
        for (PSDEViewCtrl pSDEViewCtrl : arrayList) {
            this.removeTemp((IEntity)pSDEViewCtrl);
        }
        this.onAfterRemoveTempByPSDEViewBase(pSDEViewBase, arrayList);
    }

    protected void onAfterRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase) throws Exception {
    }

    protected void onBeforeRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void onAfterRemoveTempByPSDEViewBase(PSDEViewBase pSDEViewBase, ArrayList<PSDEViewCtrl> arrayList) throws Exception {
    }

    protected void getRelatedDataTempMajor(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        super.getRelatedDataTempMajor((IEntity)pSDEViewCtrl);
    }

    protected void updateRelatedDataTempMajor(PSDEViewCtrl pSDEViewCtrl, PSDEViewCtrl pSDEViewCtrl2) throws Exception {
        super.updateRelatedDataTempMajor((IEntity)pSDEViewCtrl, (IEntity)pSDEViewCtrl2);
    }

    protected void replaceParentInfo(PSDEViewCtrl pSDEViewCtrl, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo((IEntity)pSDEViewCtrl, cloneSession);
        if (pSDEViewCtrl.getPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEViewCtrl.getPSACHandlerId())) != null) {
            this.onFillParentInfo_PSACHandler(pSDEViewCtrl, (PSACHandler)iEntity);
        }
        if (pSDEViewCtrl.getSubPSACHandlerId() != null && (iEntity = cloneSession.getEntity("PSACHANDLER", (Object)pSDEViewCtrl.getSubPSACHandlerId())) != null) {
            this.onFillParentInfo_SubPSACHandler(pSDEViewCtrl, (PSACHandler)iEntity);
        }
        if (pSDEViewCtrl.getPSCtrlLogicGroupId() != null && (iEntity = cloneSession.getEntity("PSCTRLLOGICGROUP", (Object)pSDEViewCtrl.getPSCtrlLogicGroupId())) != null) {
            this.onFillParentInfo_PSCtrlLogicGroup(pSDEViewCtrl, (PSCtrlLogicGroup)iEntity);
        }
        if (pSDEViewCtrl.getPSCtrlMsgId() != null && (iEntity = cloneSession.getEntity("PSCTRLMSG", (Object)pSDEViewCtrl.getPSCtrlMsgId())) != null) {
            this.onFillParentInfo_PSCtrlMsg(pSDEViewCtrl, (PSCtrlMsg)iEntity);
        }
        if (pSDEViewCtrl.getPSDEId() != null && (iEntity = cloneSession.getEntity("PSDATAENTITY", (Object)pSDEViewCtrl.getPSDEId())) != null) {
            this.onFillParentInfo_PSDE(pSDEViewCtrl, (PSDataEntity)iEntity);
        }
        if (pSDEViewCtrl.getPSDEActionId() != null && (iEntity = cloneSession.getEntity("PSDEACTION", (Object)pSDEViewCtrl.getPSDEActionId())) != null) {
            this.onFillParentInfo_PSDEAction(pSDEViewCtrl, (PSDEAction)iEntity);
        }
        if (pSDEViewCtrl.getPSDEChartId() != null && (iEntity = cloneSession.getEntity("PSDECHART", (Object)pSDEViewCtrl.getPSDEChartId())) != null) {
            this.onFillParentInfo_PSDEChart(pSDEViewCtrl, (PSDEChart)iEntity);
        }
        if (pSDEViewCtrl.getPSDEDataExpId() != null && (iEntity = cloneSession.getEntity("PSDEDATAEXP", (Object)pSDEViewCtrl.getPSDEDataExpId())) != null) {
            this.onFillParentInfo_PSDEDataExp(pSDEViewCtrl, (PSDEDataExp)iEntity);
        }
        if (pSDEViewCtrl.getPSDEDataImpId() != null && (iEntity = cloneSession.getEntity("PSDEDATAIMP", (Object)pSDEViewCtrl.getPSDEDataImpId())) != null) {
            this.onFillParentInfo_PSDEDataImp(pSDEViewCtrl, (PSDEDataImp)iEntity);
        }
        if (pSDEViewCtrl.getPSDEDRId() != null && (iEntity = cloneSession.getEntity("PSDEDATARELATION", (Object)pSDEViewCtrl.getPSDEDRId())) != null) {
            this.onFillParentInfo_PSDEDR(pSDEViewCtrl, (PSDEDataRelation)iEntity);
        }
        if (pSDEViewCtrl.getPSDEDataSetId() != null && (iEntity = cloneSession.getEntity("PSDEDATASET", (Object)pSDEViewCtrl.getPSDEDataSetId())) != null) {
            this.onFillParentInfo_PSDEDataSet(pSDEViewCtrl, (PSDEDataSet)iEntity);
        }
        if (pSDEViewCtrl.getPSDEDataViewId() != null && (iEntity = cloneSession.getEntity("PSDEDATAVIEW", (Object)pSDEViewCtrl.getPSDEDataViewId())) != null) {
            this.onFillParentInfo_PSDEDataView(pSDEViewCtrl, (PSDEDataView)iEntity);
        }
        if (pSDEViewCtrl.getPSDEFormId() != null && (iEntity = cloneSession.getEntity("PSDEFORM", (Object)pSDEViewCtrl.getPSDEFormId())) != null) {
            this.onFillParentInfo_PSDEForm(pSDEViewCtrl, (PSDEForm)iEntity);
        }
        if (pSDEViewCtrl.getPSDEGridId() != null && (iEntity = cloneSession.getEntity("PSDEGRID", (Object)pSDEViewCtrl.getPSDEGridId())) != null) {
            this.onFillParentInfo_PSDEGrid(pSDEViewCtrl, (PSDEGrid)iEntity);
        }
        if (pSDEViewCtrl.getPSDEListId() != null && (iEntity = cloneSession.getEntity("PSDELIST", (Object)pSDEViewCtrl.getPSDEListId())) != null) {
            this.onFillParentInfo_PSDEList(pSDEViewCtrl, (PSDEList)iEntity);
        }
        if (pSDEViewCtrl.getADPSDELogicId() != null && (iEntity = cloneSession.getEntity("PSDELOGIC", (Object)pSDEViewCtrl.getADPSDELogicId())) != null) {
            this.onFillParentInfo_ADPSDELogic(pSDEViewCtrl, (PSDELogic)iEntity);
        }
        if (pSDEViewCtrl.getPSDEOPPrivId() != null && (iEntity = cloneSession.getEntity("PSDEOPPRIV", (Object)pSDEViewCtrl.getPSDEOPPrivId())) != null) {
            this.onFillParentInfo_PSDEOPPriv(pSDEViewCtrl, (PSDEOPPriv)iEntity);
        }
        if (pSDEViewCtrl.getPSDEReportId() != null && (iEntity = cloneSession.getEntity("PSDEREPORT", (Object)pSDEViewCtrl.getPSDEReportId())) != null) {
            this.onFillParentInfo_PSDEReport(pSDEViewCtrl, (PSDEReport)iEntity);
        }
        if (pSDEViewCtrl.getPSDEToolbarId() != null && (iEntity = cloneSession.getEntity("PSDETOOLBAR", (Object)pSDEViewCtrl.getPSDEToolbarId())) != null) {
            this.onFillParentInfo_PSDEToolbar(pSDEViewCtrl, (PSDEToolbar)iEntity);
        }
        if (pSDEViewCtrl.getPSDETreeViewId() != null && (iEntity = cloneSession.getEntity("PSDETREEVIEW", (Object)pSDEViewCtrl.getPSDETreeViewId())) != null) {
            this.onFillParentInfo_PSDETreeView(pSDEViewCtrl, (PSDETreeView)iEntity);
        }
        if (pSDEViewCtrl.getNO2PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEViewCtrl.getNO2PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No2PSDEUAGroup(pSDEViewCtrl, (PSDEUAGroup)iEntity);
        }
        if (pSDEViewCtrl.getNO3PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEViewCtrl.getNO3PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No3PSDEUAGroup(pSDEViewCtrl, (PSDEUAGroup)iEntity);
        }
        if (pSDEViewCtrl.getNO4PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEViewCtrl.getNO4PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No4PSDEUAGroup(pSDEViewCtrl, (PSDEUAGroup)iEntity);
        }
        if (pSDEViewCtrl.getNO5PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEViewCtrl.getNO5PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No5PSDEUAGroup(pSDEViewCtrl, (PSDEUAGroup)iEntity);
        }
        if (pSDEViewCtrl.getNO6PSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEViewCtrl.getNO6PSDEUAGroupId())) != null) {
            this.onFillParentInfo_No6PSDEUAGroup(pSDEViewCtrl, (PSDEUAGroup)iEntity);
        }
        if (pSDEViewCtrl.getPSDEUAGroupId() != null && (iEntity = cloneSession.getEntity("PSDEUAGROUP", (Object)pSDEViewCtrl.getPSDEUAGroupId())) != null) {
            this.onFillParentInfo_PSDEUAGroup(pSDEViewCtrl, (PSDEUAGroup)iEntity);
        }
        if (pSDEViewCtrl.getPSDEViewBaseId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEViewCtrl.getPSDEViewBaseId())) != null) {
            this.onFillParentInfo_PSDEViewBase(pSDEViewCtrl, (PSDEViewBase)iEntity);
        }
        if (pSDEViewCtrl.getPSDEViewId() != null && (iEntity = cloneSession.getEntity("PSDEVIEWBASE", (Object)pSDEViewCtrl.getPSDEViewId())) != null) {
            this.onFillParentInfo_PSDEView(pSDEViewCtrl, (PSDEViewBase)iEntity);
        }
        if (pSDEViewCtrl.getPSDEWizardId() != null && (iEntity = cloneSession.getEntity("PSDEWIZARD", (Object)pSDEViewCtrl.getPSDEWizardId())) != null) {
            this.onFillParentInfo_PSDEWizard(pSDEViewCtrl, (PSDEWizard)iEntity);
        }
        if (pSDEViewCtrl.getCapPSLanResId() != null && (iEntity = cloneSession.getEntity("PSLANGUAGERES", (Object)pSDEViewCtrl.getCapPSLanResId())) != null) {
            this.onFillParentInfo_CapPSLanRes(pSDEViewCtrl, (PSLanguageRes)iEntity);
        }
        if (pSDEViewCtrl.getPSPFId() != null && (iEntity = cloneSession.getEntity("PSPF", (Object)pSDEViewCtrl.getPSPFId())) != null) {
            this.onFillParentInfo_PSPF(pSDEViewCtrl, (PSPF)iEntity);
        }
        if (pSDEViewCtrl.getPSSysCalendarId() != null && (iEntity = cloneSession.getEntity("PSSYSCALENDAR", (Object)pSDEViewCtrl.getPSSysCalendarId())) != null) {
            this.onFillParentInfo_PSSysCalendar(pSDEViewCtrl, (PSSysCalendar)iEntity);
        }
        if (pSDEViewCtrl.getPSSysCounterId() != null && (iEntity = cloneSession.getEntity("PSSYSCOUNTER", (Object)pSDEViewCtrl.getPSSysCounterId())) != null) {
            this.onFillParentInfo_PSSysCounter(pSDEViewCtrl, (PSSysCounter)iEntity);
        }
        if (pSDEViewCtrl.getPSSysCssId() != null && (iEntity = cloneSession.getEntity("PSSYSCSS", (Object)pSDEViewCtrl.getPSSysCssId())) != null) {
            this.onFillParentInfo_PSSysCss(pSDEViewCtrl, (PSSysCss)iEntity);
        }
        if (pSDEViewCtrl.getPSSysDashboardId() != null && (iEntity = cloneSession.getEntity("PSSYSDASHBOARD", (Object)pSDEViewCtrl.getPSSysDashboardId())) != null) {
            this.onFillParentInfo_PSSysDashboard(pSDEViewCtrl, (PSSysDashboard)iEntity);
        }
        if (pSDEViewCtrl.getPSSysDynaModelId() != null && (iEntity = cloneSession.getEntity("PSSYSDYNAMODEL", (Object)pSDEViewCtrl.getPSSysDynaModelId())) != null) {
            this.onFillParentInfo_PSSysDynaModel(pSDEViewCtrl, (PSSysDynaModel)iEntity);
        }
        if (pSDEViewCtrl.getPSSysImageId() != null && (iEntity = cloneSession.getEntity("PSSYSIMAGE", (Object)pSDEViewCtrl.getPSSysImageId())) != null) {
            this.onFillParentInfo_PSSysImage(pSDEViewCtrl, (PSSysImage)iEntity);
        }
        if (pSDEViewCtrl.getPSSysMapViewId() != null && (iEntity = cloneSession.getEntity("PSSYSMAPVIEW", (Object)pSDEViewCtrl.getPSSysMapViewId())) != null) {
            this.onFillParentInfo_PSSysMapView(pSDEViewCtrl, (PSSysMapView)iEntity);
        }
        if (pSDEViewCtrl.getPSSysMsgTemplId() != null && (iEntity = cloneSession.getEntity("PSSYSMSGTEMPL", (Object)pSDEViewCtrl.getPSSysMsgTemplId())) != null) {
            this.onFillParentInfo_PSSysMsgTempl(pSDEViewCtrl, (PSSysMsgTempl)iEntity);
        }
        if (pSDEViewCtrl.getPSSysPFPluginId() != null && (iEntity = cloneSession.getEntity("PSSYSPFPLUGIN", (Object)pSDEViewCtrl.getPSSysPFPluginId())) != null) {
            this.onFillParentInfo_PSSysPFPlugin(pSDEViewCtrl, (PSSysPFPlugin)iEntity);
        }
        if (pSDEViewCtrl.getPSSysSearchBarId() != null && (iEntity = cloneSession.getEntity("PSSYSSEARCHBAR", (Object)pSDEViewCtrl.getPSSysSearchBarId())) != null) {
            this.onFillParentInfo_PSSysSearchBar(pSDEViewCtrl, (PSSysSearchBar)iEntity);
        }
        if (pSDEViewCtrl.getPSSysViewPanelId() != null && (iEntity = cloneSession.getEntity("PSSYSVIEWPANEL", (Object)pSDEViewCtrl.getPSSysViewPanelId())) != null) {
            this.onFillParentInfo_PSSysViewPanel(pSDEViewCtrl, (PSSysViewPanel)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues((IEntity)pSDEViewCtrl, bl);
        pSDEViewCtrl.resetDefaultFlag();
    }

    protected void onCheckEntity(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_ADPSDELogicId(bl, pSDEViewCtrl, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BottomPos(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BtnActionType(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BusyIndicator(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CapPSLanResName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Caption(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ConfigInfo(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam10(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam11(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam12(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam2(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam3(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam4(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam5(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam6(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam7(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam8(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParam9(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CtrlParams(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomCond(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CustomType(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DefaultFlag(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DynaModelFlag(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_DyncMode(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableDynaSys(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableItemPriv(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_EnableViewActions(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Height(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_InsertPos(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LeftPos(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LocalMode(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Margin(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_MultiSelect(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO2PSDEUAGroupId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO2PSDEUAGroupName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO3PSDEUAGroupId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO3PSDEUAGroupName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO4PSDEUAGroupId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO4PSDEUAGroupName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO5PSDEUAGroupId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO5PSDEUAGroupName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO6PSDEUAGroupId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_NO6PSDEUAGroupName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OrderValue(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Padding(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PredefinedType(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSACHandlerId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlLogicGroupId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlMsgId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCtrlName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEActionId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEChartId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataExpId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataImpId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataSetId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataViewId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDataViewName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEDRName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEFormName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEGridName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEListId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEOPPrivId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEReportId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEToolbarName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDETreeViewId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEUAGroupName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewBaseId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewCtrlType(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEViewId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDEWizardId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSDynaInstId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSPFId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCalendarId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCounterId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDashboardId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysDynaModelId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysImageId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMapViewId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysMsgTemplId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysPFPluginId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysSearchBarId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysViewPanelId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ReadOnlyMode(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCtrl2Name(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCtrl2Usage(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCtrlName(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RefCtrlUsage(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_RightPos(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SubPSACHandlerId(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_TopPos(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_ValidFlag(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Width(bl, pSDEViewCtrl, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, (IEntity)pSDEViewCtrl, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_ADPSDELogicId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isADPSDELogicIdDirty() : !pSDEViewCtrl.isADPSDELogicIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getADPSDELogicId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ADPSDELogicId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_BottomPos(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isBottomPosDirty() : !pSDEViewCtrl.isBottomPosDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getBottomPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BottomPos_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_BtnActionType(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isBtnActionTypeDirty() : !pSDEViewCtrl.isBtnActionTypeDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getBtnActionType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BtnActionType_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_BusyIndicator(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isBusyIndicatorDirty() : !pSDEViewCtrl.isBusyIndicatorDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getBusyIndicator();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_BusyIndicator_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCapPSLanResIdDirty() : !pSDEViewCtrl.isCapPSLanResIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCapPSLanResId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CapPSLanResName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCapPSLanResNameDirty() : !pSDEViewCtrl.isCapPSLanResNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCapPSLanResName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CapPSLanResName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_Caption(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCaptionDirty() : !pSDEViewCtrl.isCaptionDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCaption();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Caption_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ConfigInfo(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isConfigInfoDirty() : !pSDEViewCtrl.isConfigInfoDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getConfigInfo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_ConfigInfo_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CONFIGINFO");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParamDirty() : !pSDEViewCtrl.isCtrlParamDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCtrlParam();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam10(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam10Dirty() : !pSDEViewCtrl.isCtrlParam10Dirty()) {
            return null;
        }
        Double d = pSDEViewCtrl.getCtrlParam10();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam10_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM10");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam11(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam11Dirty() : !pSDEViewCtrl.isCtrlParam11Dirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getCtrlParam11();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam11_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM11");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam12(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam12Dirty() : !pSDEViewCtrl.isCtrlParam12Dirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getCtrlParam12();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam12_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM12");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam2(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam2Dirty() : !pSDEViewCtrl.isCtrlParam2Dirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCtrlParam2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam2_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam3(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam3Dirty() : !pSDEViewCtrl.isCtrlParam3Dirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCtrlParam3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam3_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM3");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam4(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam4Dirty() : !pSDEViewCtrl.isCtrlParam4Dirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCtrlParam4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParam4_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM4");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam5(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam5Dirty() : !pSDEViewCtrl.isCtrlParam5Dirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getCtrlParam5();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam5_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM5");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam6(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam6Dirty() : !pSDEViewCtrl.isCtrlParam6Dirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getCtrlParam6();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam6_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM6");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam7(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam7Dirty() : !pSDEViewCtrl.isCtrlParam7Dirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getCtrlParam7();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam7_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM7");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam8(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam8Dirty() : !pSDEViewCtrl.isCtrlParam8Dirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getCtrlParam8();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam8_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM8");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParam9(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParam9Dirty() : !pSDEViewCtrl.isCtrlParam9Dirty()) {
            return null;
        }
        Double d = pSDEViewCtrl.getCtrlParam9();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_CtrlParam9_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAM9");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CtrlParams(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCtrlParamsDirty() : !pSDEViewCtrl.isCtrlParamsDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCtrlParams();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CtrlParams_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CTRLPARAMS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CustomCond(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCustomCondDirty() : !pSDEViewCtrl.isCustomCondDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCustomCond();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomCond_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_CustomType(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isCustomTypeDirty() : !pSDEViewCtrl.isCustomTypeDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getCustomType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CustomType_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_DefaultFlag(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isDefaultFlagDirty() : !pSDEViewCtrl.isDefaultFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getDefaultFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DefaultFlag_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DEFAULTFLAG");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_DynaModelFlag(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isDynaModelFlagDirty() : !pSDEViewCtrl.isDynaModelFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getDynaModelFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DynaModelFlag_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_DyncMode(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isDyncModeDirty() : !pSDEViewCtrl.isDyncModeDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getDyncMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_DyncMode_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("DYNCMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableDynaSys(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isEnableDynaSysDirty() : !pSDEViewCtrl.isEnableDynaSysDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getEnableDynaSys();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableDynaSys_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("ENABLEDYNASYS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_EnableItemPriv(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isEnableItemPrivDirty() : !pSDEViewCtrl.isEnableItemPrivDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getEnableItemPriv();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableItemPriv_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_EnableViewActions(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isEnableViewActionsDirty() : !pSDEViewCtrl.isEnableViewActionsDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getEnableViewActions();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_EnableViewActions_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_Height(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isHeightDirty() : !pSDEViewCtrl.isHeightDirty()) {
            return null;
        }
        Double d = pSDEViewCtrl.getHeight();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Height_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_InsertPos(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isInsertPosDirty() : !pSDEViewCtrl.isInsertPosDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getInsertPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_InsertPos_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("INSERTPOS");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_LeftPos(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isLeftPosDirty() : !pSDEViewCtrl.isLeftPosDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getLeftPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LeftPos_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_LocalMode(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isLocalModeDirty() : !pSDEViewCtrl.isLocalModeDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getLocalMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LocalMode_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("LOCALMODE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Margin(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isMarginDirty() : !pSDEViewCtrl.isMarginDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getMargin();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Margin_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("MARGIN");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Memo(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isMemoDirty() : !pSDEViewCtrl.isMemoDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_MultiSelect(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isMultiSelectDirty() : !pSDEViewCtrl.isMultiSelectDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getMultiSelect();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_MultiSelect_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO2PSDEUAGroupId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO2PSDEUAGroupIdDirty() : !pSDEViewCtrl.isNO2PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO2PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO2PSDEUAGroupId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO2PSDEUAGroupName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO2PSDEUAGroupNameDirty() : !pSDEViewCtrl.isNO2PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO2PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO2PSDEUAGroupName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO3PSDEUAGroupId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO3PSDEUAGroupIdDirty() : !pSDEViewCtrl.isNO3PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO3PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO3PSDEUAGroupId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO3PSDEUAGroupName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO3PSDEUAGroupNameDirty() : !pSDEViewCtrl.isNO3PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO3PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO3PSDEUAGroupName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO4PSDEUAGroupId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO4PSDEUAGroupIdDirty() : !pSDEViewCtrl.isNO4PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO4PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO4PSDEUAGroupId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO4PSDEUAGroupName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO4PSDEUAGroupNameDirty() : !pSDEViewCtrl.isNO4PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO4PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO4PSDEUAGroupName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO5PSDEUAGroupId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO5PSDEUAGroupIdDirty() : !pSDEViewCtrl.isNO5PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO5PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO5PSDEUAGroupId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO5PSDEUAGroupName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO5PSDEUAGroupNameDirty() : !pSDEViewCtrl.isNO5PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO5PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO5PSDEUAGroupName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO6PSDEUAGroupId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO6PSDEUAGroupIdDirty() : !pSDEViewCtrl.isNO6PSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO6PSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO6PSDEUAGroupId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_NO6PSDEUAGroupName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isNO6PSDEUAGroupNameDirty() : !pSDEViewCtrl.isNO6PSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getNO6PSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_NO6PSDEUAGroupName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_OrderValue(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isOrderValueDirty() : !pSDEViewCtrl.isOrderValueDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getOrderValue();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_OrderValue_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_Padding(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPaddingDirty() : !pSDEViewCtrl.isPaddingDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPadding();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Padding_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PADDING");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PredefinedType(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPredefinedTypeDirty() : !pSDEViewCtrl.isPredefinedTypeDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPredefinedType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PredefinedType_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSACHandlerId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSACHandlerIdDirty() : !pSDEViewCtrl.isPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSACHandlerId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSCtrlIdDirty() : !pSDEViewCtrl.isPSCtrlIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSCtrlId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlLogicGroupId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSCtrlLogicGroupIdDirty() : !pSDEViewCtrl.isPSCtrlLogicGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSCtrlLogicGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlLogicGroupId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlMsgId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSCtrlMsgIdDirty() : !pSDEViewCtrl.isPSCtrlMsgIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSCtrlMsgId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlMsgId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCtrlName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSCtrlNameDirty() : !pSDEViewCtrl.isPSCtrlNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSCtrlName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCtrlName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEActionId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEActionIdDirty() : !pSDEViewCtrl.isPSDEActionIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEActionId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEActionId_PSDEAction((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEACTIONID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEActionId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEChartId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEChartIdDirty() : !pSDEViewCtrl.isPSDEChartIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEChartId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEChartId_PSDEChart((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDECHARTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEChartId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataExpId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEDataExpIdDirty() : !pSDEViewCtrl.isPSDEDataExpIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEDataExpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataExpId_PSDEDataExp((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDATAEXPID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEDataExpId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataImpId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEDataImpIdDirty() : !pSDEViewCtrl.isPSDEDataImpIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEDataImpId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataImpId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataSetId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEDataSetIdDirty() : !pSDEViewCtrl.isPSDEDataSetIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEDataSetId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataSetId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataViewId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEDataViewIdDirty() : !pSDEViewCtrl.isPSDEDataViewIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEDataViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataViewId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDataViewName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEDataViewNameDirty() : !pSDEViewCtrl.isPSDEDataViewNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEDataViewName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDataViewName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDRId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEDRIdDirty() : !pSDEViewCtrl.isPSDEDRIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEDRId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEDRName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEDRNameDirty() : !pSDEViewCtrl.isPSDEDRNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEDRName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEDRName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEDRNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEFormId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEFormIdDirty() : !pSDEViewCtrl.isPSDEFormIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEFormId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEFormName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEFormNameDirty() : !pSDEViewCtrl.isPSDEFormNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEFormName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEFormName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEFORMNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEGridId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEGridIdDirty() : !pSDEViewCtrl.isPSDEGridIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEGridId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEGridName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEGridNameDirty() : !pSDEViewCtrl.isPSDEGridNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEGridName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEGridName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEIdDirty() : !pSDEViewCtrl.isPSDEIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEListId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEListIdDirty() : !pSDEViewCtrl.isPSDEListIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEListId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEListId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDENameDirty() : !pSDEViewCtrl.isPSDENameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEOPPrivId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEOPPrivIdDirty() : !pSDEViewCtrl.isPSDEOPPrivIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEOPPrivId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEOPPrivId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEReportId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEReportIdDirty() : !pSDEViewCtrl.isPSDEReportIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEReportId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEReportId_PSDEReport((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEREPORTID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEReportId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEToolbarId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEToolbarIdDirty() : !pSDEViewCtrl.isPSDEToolbarIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEToolbarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEToolbarName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEToolbarNameDirty() : !pSDEViewCtrl.isPSDEToolbarNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEToolbarName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEToolbarName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDETreeViewId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDETreeViewIdDirty() : !pSDEViewCtrl.isPSDETreeViewIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDETreeViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDETreeViewId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEUAGroupIdDirty() : !pSDEViewCtrl.isPSDEUAGroupIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEUAGroupId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEUAGroupName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEUAGroupNameDirty() : !pSDEViewCtrl.isPSDEUAGroupNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEUAGroupName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEUAGroupName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewBaseId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEViewBaseIdDirty() && !bl2 : !pSDEViewCtrl.isPSDEViewBaseIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEViewBaseId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWBASEID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewBaseId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDEViewCtrlId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEViewCtrlIdDirty() && !bl2 : !pSDEViewCtrl.isPSDEViewCtrlIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEViewCtrlId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewCtrlName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEViewCtrlNameDirty() && !bl2 : !pSDEViewCtrl.isPSDEViewCtrlNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEViewCtrlName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLNAME");
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
                string3 = "PSDEVIEWBASEID";
                String string4 = this.checkFieldDupRule(this.getPSDEViewCtrlDEModel(), "PSDEVIEWCTRLNAME", string3, pSDEViewCtrl, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSDEVIEWCTRLNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewCtrlType(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEViewCtrlTypeDirty() && !bl2 : !pSDEViewCtrl.isPSDEViewCtrlTypeDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEViewCtrlType();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLTYPE");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewCtrlType_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWCTRLTYPE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEViewId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEViewIdDirty() : !pSDEViewCtrl.isPSDEViewIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEViewId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEVIEWID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSDEWizardId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDEWizardIdDirty() : !pSDEViewCtrl.isPSDEWizardIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDEWizardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDEWizardId_PSDEWizard((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSDEWIZARDID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
            string2 = this.onTestValueRule_PSDEWizardId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSDynaInstId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSDynaInstIdDirty() : !pSDEViewCtrl.isPSDynaInstIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSDynaInstId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSDynaInstId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSPFId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSPFIdDirty() : !pSDEViewCtrl.isPSPFIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSPFId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSPFId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSPFID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCalendarId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysCalendarIdDirty() : !pSDEViewCtrl.isPSSysCalendarIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysCalendarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCalendarId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCounterId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysCounterIdDirty() : !pSDEViewCtrl.isPSSysCounterIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysCounterId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCounterId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysCssIdDirty() : !pSDEViewCtrl.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysCssId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDashboardId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysDashboardIdDirty() : !pSDEViewCtrl.isPSSysDashboardIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysDashboardId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDashboardId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysDynaModelId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysDynaModelIdDirty() : !pSDEViewCtrl.isPSSysDynaModelIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysDynaModelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysDynaModelId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysImageId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysImageIdDirty() : !pSDEViewCtrl.isPSSysImageIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysImageId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysImageId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMapViewId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysMapViewIdDirty() : !pSDEViewCtrl.isPSSysMapViewIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysMapViewId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMapViewId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysMsgTemplId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysMsgTemplIdDirty() : !pSDEViewCtrl.isPSSysMsgTemplIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysMsgTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysMsgTemplId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSMSGTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysPFPluginId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysPFPluginIdDirty() : !pSDEViewCtrl.isPSSysPFPluginIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysPFPluginId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysPFPluginId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysSearchBarId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysSearchBarIdDirty() : !pSDEViewCtrl.isPSSysSearchBarIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysSearchBarId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysSearchBarId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysViewPanelId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isPSSysViewPanelIdDirty() : !pSDEViewCtrl.isPSSysViewPanelIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getPSSysViewPanelId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysViewPanelId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ReadOnlyMode(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isReadOnlyModeDirty() : !pSDEViewCtrl.isReadOnlyModeDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getReadOnlyMode();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ReadOnlyMode_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefCtrl2Name(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isRefCtrl2NameDirty() : !pSDEViewCtrl.isRefCtrl2NameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getRefCtrl2Name();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefCtrl2Name_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefCtrl2Usage(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isRefCtrl2UsageDirty() : !pSDEViewCtrl.isRefCtrl2UsageDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getRefCtrl2Usage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefCtrl2Usage_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefCtrlName(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isRefCtrlNameDirty() : !pSDEViewCtrl.isRefCtrlNameDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getRefCtrlName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefCtrlName_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_RefCtrlUsage(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isRefCtrlUsageDirty() : !pSDEViewCtrl.isRefCtrlUsageDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getRefCtrlUsage();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_RefCtrlUsage_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_RightPos(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isRightPosDirty() : !pSDEViewCtrl.isRightPosDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getRightPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_RightPos_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_SubPSACHandlerId(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isSubPSACHandlerIdDirty() : !pSDEViewCtrl.isSubPSACHandlerIdDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getSubPSACHandlerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SubPSACHandlerId_Default((IEntity)pSDEViewCtrl, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SUBPSACHANDLERID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_TopPos(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isTopPosDirty() : !pSDEViewCtrl.isTopPosDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getTopPos();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_TopPos_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isUserTagDirty() : !pSDEViewCtrl.isUserTagDirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isUserTag2Dirty() : !pSDEViewCtrl.isUserTag2Dirty()) {
            return null;
        }
        String string = pSDEViewCtrl.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_ValidFlag(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isValidFlagDirty() : !pSDEViewCtrl.isValidFlagDirty()) {
            return null;
        }
        Integer n = pSDEViewCtrl.getValidFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_ValidFlag_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected EntityFieldError onCheckField_Width(boolean bl, PSDEViewCtrl pSDEViewCtrl, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSDEViewCtrl.isWidthDirty() : !pSDEViewCtrl.isWidthDirty()) {
            return null;
        }
        Double d = pSDEViewCtrl.getWidth();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_Width_Default((IEntity)pSDEViewCtrl, bl2, bl3);
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

    protected void onSyncEntity(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        super.onSyncEntity((IEntity)pSDEViewCtrl, bl);
    }

    protected void onSyncIndexEntities(PSDEViewCtrl pSDEViewCtrl, boolean bl) throws Exception {
        super.onSyncIndexEntities((IEntity)pSDEViewCtrl, bl);
    }

    public Object getDataContextValue(PSDEViewCtrl pSDEViewCtrl, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue((IEntity)pSDEViewCtrl, string, iDataContextParam)) != null) {
            return object;
        }
        PSDEViewBase pSDEViewBase = pSDEViewCtrl.getPSDEViewBase();
        if (pSDEViewBase != null && pSDEViewBase.contains(string)) {
            return pSDEViewBase.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSDEViewCtrl pSDEViewCtrl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        this.onExportMajorModel_CapPSLanRes(pSDEViewCtrl, arrayList, n);
        super.onExportMajorModel((IEntity)pSDEViewCtrl, arrayList, n);
    }

    protected void onExportMajorModel_CapPSLanRes(PSDEViewCtrl pSDEViewCtrl, ArrayList<JSONObject> arrayList, int n) throws Exception {
        if (pSDEViewCtrl.getCapPSLanRes() != null) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService", (SessionFactory)this.getSessionFactory());
            iService.exportModel((IEntity)pSDEViewCtrl.getCapPSLanRes(), arrayList, n);
        }
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ADPSDELOGICNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ADPSDELogicName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CONFIGINFO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ConfigInfo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEDATE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateDate_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CREATEMAN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CreateMan_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM10", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam10_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM11", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam11_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM12", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam12_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM3", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam3_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM4", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam4_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM5", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam5_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM6", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam6_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM7", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam7_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM8", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam8_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAM9", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParam9_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CTRLPARAMS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CtrlParams_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMCOND", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomCond_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CUSTOMTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CustomType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DEFAULTFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DefaultFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNAMODELFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DynaModelFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"DYNCMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_DyncMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEDYNASYS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableDynaSys_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEITEMPRIV", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableItemPriv_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ENABLEVIEWACTIONS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_EnableViewActions_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HEIGHT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Height_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"INSERTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_InsertPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LEFTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LeftPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCALMODE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LocalMode_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MARGIN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Margin_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MULTISELECT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_MultiSelect_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO2PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO2PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO2PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO3PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO3PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO3PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO4PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO4PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO4PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO5PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO5PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO5PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO5PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO6PSDEUAGROUPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO6PSDEUAGroupId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"NO6PSDEUAGROUPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_NO6PSDEUAGroupName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"ORDERVALUE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_OrderValue_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PADDING", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Padding_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PREDEFINEDTYPETEXT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PredefinedTypeText_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSACHandlerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLMSGNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlMsgName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCtrlName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDECHARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDECHART", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartId_PSDEChart(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDECHARTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEChartName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAEXPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEDATAEXP", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataExpId_PSDEDataExp(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAEXPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataExpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAEXPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataExpName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAIMPID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataImpId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEDATAIMPNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEDataImpName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEOPPRIVNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEOPPrivName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEREPORT", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEReportId_PSDEReport(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEREPORTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEReportId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEREPORTNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEReportName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewBaseName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWCTRLTYPE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewCtrlType_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEVIEWNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEViewName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)"PSDEWIZARD", (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardId_PSDEWizard(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDEWIZARDNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDEWizardName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSDYNAINSTID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSDynaInstId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSPFNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSPFName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSMSGTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysMsgTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSPFPLUGINNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysPFPluginName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHBARID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchBarId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSSEARCHBARNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysSearchBarName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSVIEWPANELNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysViewPanelName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"RIGHTPOS", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_RightPos_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBPSACHANDLERID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubPSACHandlerId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SUBPSACHANDLERNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SubPSACHandlerName_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIDFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_ValidFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"WIDTH", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Width_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
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
            if (this.checkFieldStringLengthRule("CAPTION", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_ConfigInfo_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CONFIGINFO", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_CtrlParam_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARAM", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlParam10_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam11_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam12_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARAM2", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlParam3_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARAM3", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlParam4_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARAM4", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CtrlParam5_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam6_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam7_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam8_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParam9_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_CtrlParams_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CTRLPARAMS", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    protected String onTestValueRule_DefaultFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DynaModelFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_DyncMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableDynaSys_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableItemPriv_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_EnableViewActions_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Height_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldValueRangeRule("HEIGHT", iEntity, bl2, new Double(0.0), true, null, false, "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[0.0]", false)) {
                return null;
            }
            return "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[0.0]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_InsertPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LeftPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_LocalMode_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Margin_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MARGIN", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_MultiSelect_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_NO2PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NO2PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NO3PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NO3PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NO4PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NO4PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NO5PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NO5PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NO6PSDEUAGroupId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_NO6PSDEUAGroupName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
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

    protected String onTestValueRule_OrderValue_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Padding_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PADDING", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
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

    protected String onTestValueRule_PSDEChartId_PSDEChart(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDECHARTID", "PSDECHART", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u56fe\u8868\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_PSDEDataExpId_PSDEDataExp(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEDATAEXPID", "PSDEDATAEXP", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u6570\u636e\u5bfc\u51fa\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataExpId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAEXPID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEDataExpName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEDATAEXPNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_PSDEReportId_PSDEReport(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEREPORTID", "PSDEREPORT", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u62a5\u8868\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_PSDEViewCtrlId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewCtrlName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLNAME", iEntity, bl2, null, false, 50, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50]", false) && this.checkFieldRegExRule("PSDEVIEWCTRLNAME", iEntity, bl2, "[A-Za-z_$]+[\\w.]*", "\u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd\u6216\u4e0b\u5212\u7ebf", false)) {
                return null;
            }
            return "(\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[50] \u5e76\u4e14 \u5185\u5bb9\u53ea\u80fd\u7531\u5b57\u6bcd\u3001\u6570\u5b57\u53ca\u70b9\u53f7\u7ec4\u6210\uff0c\u4e14\u5f00\u59cb\u5fc5\u987b\u4e3a\u5b57\u6bcd\u6216\u4e0b\u5212\u7ebf)";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewCtrlType_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWCTRLTYPE", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEViewName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSDEVIEWNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSDEWizardId_PSDEWizard(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldDataSetRule("PSDEWIZARDID", "PSDEWIZARD", "CurDE", iEntity, bl2, null, null, "\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d", true)) {
                return null;
            }
            return "\u5b9e\u4f53\u5411\u5bfc\u503c\u5fc5\u987b\u5728\u6570\u636e\u96c6\u5408\u4e2d";
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

    protected String onTestValueRule_PSPFId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSPFName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSPFNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysMsgTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysMsgTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSMSGTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_RightPos_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SubPSACHandlerId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBPSACHANDLERID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_SubPSACHandlerName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SUBPSACHANDLERNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]";
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

    protected String onTestValueRule_ValidFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Width_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldValueRangeRule("WIDTH", iEntity, bl2, new Double(0.0), true, null, false, "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[0.0]", false)) {
                return null;
            }
            return "\u6570\u503c\u5fc5\u987b\u5927\u4e8e\u7b49\u4e8e[0.0]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSDEViewCtrl pSDEViewCtrl) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, (IEntity)pSDEViewCtrl)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        super.onUpdateParent((IEntity)pSDEViewCtrl);
    }

    protected void onCopyDetails(PSDEViewCtrl pSDEViewCtrl, Object object) throws Exception {
        PSDEViewCtrl pSDEViewCtrl2 = new PSDEViewCtrl();
        pSDEViewCtrl2.set("PSDEVIEWCTRLID", object);
        String string = DataObject.getStringValue((Object)pSDEViewCtrl.get("PSDEVIEWCTRLID"));
        super.onCopyDetails((IEntity)pSDEViewCtrl, object);
    }

    @Override
    protected void exportCurXmlModel(PSDEViewCtrl pSDEViewCtrl, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSDEVIEWCTRL");
        if (!bl) {
            pSDEViewCtrl.setConfigInfo(null);
            pSDEViewCtrl.setCreateDate(null);
            pSDEViewCtrl.setCreateMan(null);
            pSDEViewCtrl.setPSDEViewCtrlId(null);
            pSDEViewCtrl.setPSDEViewCtrlType(null);
            pSDEViewCtrl.setUpdateDate(null);
            pSDEViewCtrl.setUpdateMan(null);
            pSDEViewCtrl.setPSDEViewBaseId(null);
            pSDEViewCtrl.setPSDEViewBaseName(null);
            pSDEViewCtrl.setPSSystemId(null);
            super.exportCurXmlModel(pSDEViewCtrl, xmlNode, bl);
        }
    }

    @Override
    protected void onExportRelatedXmlModel(PSDEViewCtrl pSDEViewCtrl, XmlNode xmlNode) throws Exception {
        super.onExportRelatedXmlModel(pSDEViewCtrl, xmlNode);
    }

    @Override
    protected void onImportRelatedXmlModel(PSDEViewCtrl pSDEViewCtrl, XmlNode xmlNode) throws Exception {
        super.onImportRelatedXmlModel(pSDEViewCtrl, xmlNode);
    }

    @Override
    protected String getEntityFolderKeyValue(PSDEViewCtrl pSDEViewCtrl, PSSystem pSSystem) throws Exception {
        PSDEViewCtrl pSDEViewCtrl2 = new PSDEViewCtrl();
        pSDEViewCtrl2.setPSDEViewBaseId(pSDEViewCtrl.getPSDEViewBaseId());
        pSDEViewCtrl2.setPSDEViewCtrlName(pSDEViewCtrl.getPSDEViewCtrlName());
        if (this.selectOne((IEntity)pSDEViewCtrl2, true)) {
            return pSDEViewCtrl2.getPSDEViewCtrlId();
        }
        return super.getEntityFolderKeyValue(pSDEViewCtrl, pSSystem);
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSDEViewCtrl pSDEViewCtrl, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSDEViewCtrl, string);
        return objectNode;
    }

    @Override
    public String getModelV2ResScope(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return StringHelper.format((String)"PSDEVIEWBASE#%1$s", (Object)string);
        }
        return super.getModelV2ResScope(iEntity);
    }

    @Override
    public String getModelV2ResScopeDER(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSDEVIEWCTRL_PSDEVIEWBASE_PSDEVIEWBASEID";
        }
        return super.getModelV2ResScopeDER(iEntity);
    }

    @Override
    public String getModelV2ResScopeText(IEntity iEntity) throws Exception {
        String string = null;
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASEID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return DataObject.getStringValue((IDataObject)iEntity, (String)"PSDEVIEWBASENAME", null);
        }
        return super.getModelV2ResScopeText(iEntity);
    }

    @Override
    public boolean setModelV2ResScope(IEntity iEntity, String string, String string2) throws Exception {
        if (StringHelper.compare((String)string, (String)"PSDEVIEWBASE", (boolean)true) == 0) {
            iEntity.set("PSDEVIEWBASEID", (Object)string2);
            return true;
        }
        return super.setModelV2ResScope(iEntity, string, string2);
    }

    @Override
    public String[] getModelV2ResScopeFields() throws Exception {
        return new String[]{"PSDEVIEWBASEID"};
    }

    @Override
    public String getModelV2Tag(PSDEViewCtrl pSDEViewCtrl) {
        if (!StringHelper.isNullOrEmpty((String)pSDEViewCtrl.getPSDEViewCtrlName())) {
            return pSDEViewCtrl.getPSDEViewCtrlName();
        }
        return super.getModelV2Tag(pSDEViewCtrl);
    }

    @Override
    public boolean setModelV2Tag(PSDEViewCtrl pSDEViewCtrl, String string) {
        pSDEViewCtrl.setPSDEViewCtrlName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("PSDEVIEWCTRLNAME", "");
        map.put("PSDEVIEWBASEID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSDEViewCtrl pSDEViewCtrl, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSDEViewCtrl.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSDEViewCtrl, true);
        pSDEViewCtrl.set("PSDEVIEWCTRLNAME", string);
        if (this.select(pSDEViewCtrl, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSDEViewCtrl, true);
        return super.getModelV2Entity(pSDEViewCtrl, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSDEViewCtrl pSDEViewCtrl, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSDEViewCtrl, objectNode, string, string2, n);
    }

    @Override
    public Object getDataType(PSDEViewCtrl pSDEViewCtrl) throws Exception {
        return pSDEViewCtrl.getPSDEViewCtrlType();
    }
}

