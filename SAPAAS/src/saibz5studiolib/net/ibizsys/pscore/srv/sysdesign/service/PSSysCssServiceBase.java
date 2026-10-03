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
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdesign.service;

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
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.PSCoreSysServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuItemServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppMenuServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPVPartServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPanelViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppPanelViewServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppTitleBarServiceBase;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppViewServiceBase;
import net.ibizsys.pscore.srv.config.entity.PSCssTempl;
import net.ibizsys.pscore.srv.config.entity.PSCssTemplBase;
import net.ibizsys.pscore.srv.core.IPSDataEntityModel;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEChartServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDRItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEGridServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMainStateServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETBItemServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEToolbarServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeColServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewCtrlServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardServiceBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEWizardStepServiceBase;
import net.ibizsys.pscore.srv.sysdesign.dao.PSSysCssDAO;
import net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCssDEModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModuleBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssCatBase;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCalendarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysEditorStyleServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMapViewServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPFPITemplServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletCatServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSearchBarServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdService;
import net.ibizsys.pscore.srv.sysdesign.service.PSThresholdServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupServiceBase;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgServiceBase;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSMOSFile;
import net.ibizsys.pscore.srv.util.IPSMOSFileFilter;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCssServiceBase
extends PSCoreSysServiceBase<PSSysCss> {
    private static final Log log = LogFactory.getLog(PSSysCssServiceBase.class);
    public static final String DATASET_CURSYS = "CurSys";
    public static final String DATASET_DEFAULT = "DEFAULT";
    public static final String DATASET_WEBCOLOR = "WebColor";
    public static final String ACTION_CALCSAMPLECONTENT = "CalcSampleContent";
    public static final String ACTION_GETFD = "GetFD";
    public static final String ACTION_GETFDL = "GetFDL";
    public static final String ACTION_GETPI = "GetPI";
    public static final String ACTION_GETPIL = "GetPIL";
    public static final String ACTION_UPDATEFD = "UpdateFD";
    public static final String ACTION_UPDATEFDL = "UpdateFDL";
    public static final String ACTION_UPDATEPI = "UpdatePI";
    public static final String ACTION_UPDATEPIL = "UpdatePIL";
    private static Map<String, String> defaultValueMap = new HashMap<String, String>();
    private PSSysCssDEModel pSSysCssDEModel;
    private PSSysCssDAO pSSysCssDAO;

    @PostConstruct
    public void postConstruct() throws Exception {
        ServiceGlobal.registerService((String)this.getServiceId(), (IService)this);
    }

    protected String getServiceId() {
        return "net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService";
    }

    public PSSysCssDEModel getPSSysCssDEModel() {
        if (this.pSSysCssDEModel == null) {
            try {
                this.pSSysCssDEModel = (PSSysCssDEModel)DEModelGlobal.getDEModel((String)"net.ibizsys.pscore.srv.sysdesign.demodel.PSSysCssDEModel");
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCssDEModel;
    }

    @Override
    public IPSDataEntityModel getDEModel() {
        return this.getPSSysCssDEModel();
    }

    public PSSysCssDAO getPSSysCssDAO() {
        if (this.pSSysCssDAO == null) {
            try {
                this.pSSysCssDAO = (PSSysCssDAO)DAOGlobal.getDAO((String)"net.ibizsys.pscore.srv.sysdesign.dao.PSSysCssDAO", (SessionFactory)this.getSessionFactory());
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return this.pSSysCssDAO;
    }

    @Override
    public IDAO getDAO() {
        return this.getPSSysCssDAO();
    }

    protected DBFetchResult onfetchDataSet(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_WEBCOLOR, (boolean)true) == 0) {
            return this.fetchWebColor(iDEDataSetFetchContext);
        }
        return super.onfetchDataSet(string, iDEDataSetFetchContext);
    }

    protected DBFetchResult onfetchDataSetTemp(String string, IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        if (StringHelper.compare((String)string, (String)DATASET_CURSYS, (boolean)true) == 0) {
            return this.fetchTempCurSys(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.fetchTempDefault(iDEDataSetFetchContext);
        }
        if (StringHelper.compare((String)string, (String)DATASET_WEBCOLOR, (boolean)true) == 0) {
            return this.fetchTempWebColor(iDEDataSetFetchContext);
        }
        return super.onfetchDataSetTemp(string, iDEDataSetFetchContext);
    }

    @Override
    protected void onExecuteAction(String string, IEntity iEntity) throws Exception {
        if (StringHelper.compare((String)string, (String)ACTION_CALCSAMPLECONTENT, (boolean)true) == 0) {
            this.calcSampleContent((PSSysCss)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETFD, (boolean)true) == 0) {
            this.getFD((PSSysCss)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETFDL, (boolean)true) == 0) {
            this.getFDL((PSSysCss)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETPI, (boolean)true) == 0) {
            this.getPI((PSSysCss)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_GETPIL, (boolean)true) == 0) {
            this.getPIL((PSSysCss)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEFD, (boolean)true) == 0) {
            this.updateFD((PSSysCss)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEFDL, (boolean)true) == 0) {
            this.updateFDL((PSSysCss)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEPI, (boolean)true) == 0) {
            this.updatePI((PSSysCss)iEntity);
            return;
        }
        if (StringHelper.compare((String)string, (String)ACTION_UPDATEPIL, (boolean)true) == 0) {
            this.updatePIL((PSSysCss)iEntity);
            return;
        }
        super.onExecuteAction(string, iEntity);
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

    public DBFetchResult fetchWebColor(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_WEBCOLOR, false);
        return dBFetchResult;
    }

    public DBFetchResult fetchTempWebColor(IDEDataSetFetchContext iDEDataSetFetchContext) throws Exception {
        DBFetchResult dBFetchResult = this.doServiceFetchWork(iDEDataSetFetchContext, DATASET_WEBCOLOR, true);
        return dBFetchResult;
    }

    public void calcSampleContent(PSSysCss pSSysCss) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_CALCSAMPLECONTENT, 0, pSSysCss, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysCss, ACTION_CALCSAMPLECONTENT);
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysCssServiceBase.this.getService(), PSSysCssServiceBase.ACTION_CALCSAMPLECONTENT, 40, pSSysCss2, null).getResult() != 1) {
                    PSSysCssServiceBase.this.onCalcSampleContent(pSSysCss2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_CALCSAMPLECONTENT, 99, pSSysCss, null);
        }
    }

    protected void onCalcSampleContent(PSSysCss pSSysCss) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[CalcSampleContent]");
    }

    public void getFD(PSSysCss pSSysCss) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETFD, 0, pSSysCss, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysCss, ACTION_GETFD);
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysCssServiceBase.this.getService(), PSSysCssServiceBase.ACTION_GETFD, 40, pSSysCss2, null).getResult() != 1) {
                    PSSysCssServiceBase.this.onGetFD(pSSysCss2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETFD, 99, pSSysCss, null);
        }
    }

    protected void onGetFD(PSSysCss pSSysCss) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetFD]");
    }

    public void getFDL(PSSysCss pSSysCss) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETFDL, 0, pSSysCss, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysCss, ACTION_GETFDL);
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysCssServiceBase.this.getService(), PSSysCssServiceBase.ACTION_GETFDL, 40, pSSysCss2, null).getResult() != 1) {
                    PSSysCssServiceBase.this.onGetFDL(pSSysCss2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETFDL, 99, pSSysCss, null);
        }
    }

    protected void onGetFDL(PSSysCss pSSysCss) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetFDL]");
    }

    public void getPI(PSSysCss pSSysCss) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETPI, 0, pSSysCss, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysCss, ACTION_GETPI);
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysCssServiceBase.this.getService(), PSSysCssServiceBase.ACTION_GETPI, 40, pSSysCss2, null).getResult() != 1) {
                    PSSysCssServiceBase.this.onGetPI(pSSysCss2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETPI, 99, pSSysCss, null);
        }
    }

    protected void onGetPI(PSSysCss pSSysCss) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetPI]");
    }

    public void getPIL(PSSysCss pSSysCss) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_GETPIL, 0, pSSysCss, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysCss, ACTION_GETPIL);
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysCssServiceBase.this.getService(), PSSysCssServiceBase.ACTION_GETPIL, 40, pSSysCss2, null).getResult() != 1) {
                    PSSysCssServiceBase.this.onGetPIL(pSSysCss2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_GETPIL, 99, pSSysCss, null);
        }
    }

    protected void onGetPIL(PSSysCss pSSysCss) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[GetPIL]");
    }

    public void updateFD(PSSysCss pSSysCss) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEFD, 0, pSSysCss, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysCss, ACTION_UPDATEFD);
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysCssServiceBase.this.getService(), PSSysCssServiceBase.ACTION_UPDATEFD, 40, pSSysCss2, null).getResult() != 1) {
                    PSSysCssServiceBase.this.onUpdateFD(pSSysCss2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEFD, 99, pSSysCss, null);
        }
    }

    protected void onUpdateFD(PSSysCss pSSysCss) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateFD]");
    }

    public void updateFDL(PSSysCss pSSysCss) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEFDL, 0, pSSysCss, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysCss, ACTION_UPDATEFDL);
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysCssServiceBase.this.getService(), PSSysCssServiceBase.ACTION_UPDATEFDL, 40, pSSysCss2, null).getResult() != 1) {
                    PSSysCssServiceBase.this.onUpdateFDL(pSSysCss2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEFDL, 99, pSSysCss, null);
        }
    }

    protected void onUpdateFDL(PSSysCss pSSysCss) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdateFDL]");
    }

    public void updatePI(PSSysCss pSSysCss) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEPI, 0, pSSysCss, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysCss, ACTION_UPDATEPI);
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysCssServiceBase.this.getService(), PSSysCssServiceBase.ACTION_UPDATEPI, 40, pSSysCss2, null).getResult() != 1) {
                    PSSysCssServiceBase.this.onUpdatePI(pSSysCss2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEPI, 99, pSSysCss, null);
        }
    }

    protected void onUpdatePI(PSSysCss pSSysCss) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdatePI]");
    }

    public void updatePIL(PSSysCss pSSysCss) throws Exception {
        final IServicePlugin iServicePlugin = this.getPlugin();
        if (iServicePlugin != null && iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEPIL, 0, pSSysCss, null).getResult() == 1) {
            return;
        }
        this.testDEMainStateAction(pSSysCss, ACTION_UPDATEPIL);
        final PSSysCss pSSysCss2 = pSSysCss;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                if (iServicePlugin == null || iServicePlugin.doCustomAction(PSSysCssServiceBase.this.getService(), PSSysCssServiceBase.ACTION_UPDATEPIL, 40, pSSysCss2, null).getResult() != 1) {
                    PSSysCssServiceBase.this.onUpdatePIL(pSSysCss2);
                }
            }
        });
        if (iServicePlugin != null) {
            iServicePlugin.doCustomAction((IService)this, ACTION_UPDATEPIL, 99, pSSysCss, null);
        }
    }

    protected void onUpdatePIL(PSSysCss pSSysCss) throws Exception {
        throw new Exception("\u6ca1\u6709\u5b9e\u73b0\u81ea\u5b9a\u4e49\u884c\u4e3a[UpdatePIL]");
    }

    protected void onFillParentInfo(PSSysCss pSSysCss, String string, String string2, String string3) throws Exception {
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCSS_PSCSSTEMPL_PSCSSTEMPLID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCssTemplService", (SessionFactory)this.getSessionFactory());
            PSCssTempl pSCssTempl = (PSCssTempl)iService.getDEModel().createEntity();
            pSCssTempl.set("PSCSSTEMPLID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSCssTempl);
            } else {
                iService.get(pSCssTempl);
            }
            this.onFillParentInfo_PSCssTempl(pSSysCss, pSCssTempl);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCSS_PSMODULE_PSMODULEID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModuleService", (SessionFactory)this.getSessionFactory());
            PSModule pSModule = (PSModule)iService.getDEModel().createEntity();
            pSModule.set("PSMODULEID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSModule);
            } else {
                iService.get(pSModule);
            }
            this.onFillParentInfo_PSModule(pSSysCss, pSModule);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCSS_PSSYSCSSCAT_PSSYSCSSCATID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssCatService", (SessionFactory)this.getSessionFactory());
            PSSysCssCat pSSysCssCat = (PSSysCssCat)iService.getDEModel().createEntity();
            pSSysCssCat.set("PSSYSCSSCATID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSysCssCat);
            } else {
                iService.get(pSSysCssCat);
            }
            this.onFillParentInfo_PSSysCssCat(pSSysCss, pSSysCssCat);
            return;
        }
        if ((StringHelper.compare((String)string, (String)"DER1N", (boolean)true) == 0 || StringHelper.compare((String)string, (String)"SYSDER1N", (boolean)true) == 0) && StringHelper.compare((String)string2, (String)"DER1N_PSSYSCSS_PSSYSTEM_PSSYSTEMID", (boolean)true) == 0) {
            IService iService = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSystemService", (SessionFactory)this.getSessionFactory());
            PSSystem pSSystem = (PSSystem)iService.getDEModel().createEntity();
            pSSystem.set("PSSYSTEMID", DataTypeHelper.parse((int)25, (String)string3));
            if (string3.indexOf("SRFTEMPKEY:") == 0) {
                iService.getTemp(pSSystem);
            } else {
                iService.get(pSSystem);
            }
            this.onFillParentInfo_PSSystem(pSSysCss, pSSystem);
            return;
        }
        super.onFillParentInfo(pSSysCss, string, string2, string3);
    }

    protected String onSyncDER1NData(String string, String string2, String string3) throws Exception {
        return super.onSyncDER1NData(string, string2, string3);
    }

    protected void onFillParentInfo_PSCssTempl(PSSysCss pSSysCss, PSCssTempl pSCssTempl) throws Exception {
        pSSysCss.setPSCssTemplId(pSCssTempl.getPSCssTemplId());
        pSSysCss.setPSCssTemplName(pSCssTempl.getPSCssTemplName());
    }

    protected void onFillParentInfo_PSModule(PSSysCss pSSysCss, PSModule pSModule) throws Exception {
        pSSysCss.setPSModuleId(pSModule.getPSModuleId());
        pSSysCss.setPSModuleName(pSModule.getPSModuleName());
    }

    protected void onFillParentInfo_PSSysCssCat(PSSysCss pSSysCss, PSSysCssCat pSSysCssCat) throws Exception {
        pSSysCss.setCssCatName(pSSysCssCat.getCssCatName());
        pSSysCss.setPSSysCssCatId(pSSysCssCat.getPSSysCssCatId());
        pSSysCss.setPSSysCssCatName(pSSysCssCat.getPSSysCssCatName());
    }

    protected void onFillParentInfo_PSSystem(PSSysCss pSSysCss, PSSystem pSSystem) throws Exception {
        pSSysCss.setPSSystemId(pSSystem.getPSSystemId());
        pSSysCss.setPSSystemName(pSSystem.getPSSystemName());
    }

    protected void onFillEntityFullInfo(PSSysCss pSSysCss, boolean bl) throws Exception {
        if (bl) {
            if (pSSysCss.getCodeName() == null) {
                pSSysCss.setCodeName((String)this.getDefaultValue(this.getWebContext(), "USER", "Css", 25));
            }
            if (pSSysCss.getPSSysCssName() == null) {
                pSSysCss.setPSSysCssName((String)this.getDefaultValue(this.getWebContext(), "USER", "\u6837\u5f0f\u8868", 25));
            }
            if (pSSysCss.getPublicFlag() == null) {
                pSSysCss.setPublicFlag((Integer)this.getDefaultValue(this.getWebContext(), "", "1", 9));
            }
        }
        super.onFillEntityFullInfo(pSSysCss, bl);
        this.onFillEntityFullInfo_PSCssTempl(pSSysCss, bl);
        this.onFillEntityFullInfo_PSModule(pSSysCss, bl);
        this.onFillEntityFullInfo_PSSysCssCat(pSSysCss, bl);
        this.onFillEntityFullInfo_PSSystem(pSSysCss, bl);
    }

    protected void onFillEntityFullInfo_PSCssTempl(PSSysCss pSSysCss, boolean bl) throws Exception {
        if (pSSysCss.isPSCssTemplIdDirty()) {
            if (pSSysCss.getPSCssTemplId() != null) {
                if (pSSysCss.getPSCssTemplId() == null || pSSysCss.getPSCssTemplName() == null) {
                    PSCssTempl pSCssTempl = pSSysCss.getPSCssTempl();
                    pSSysCss.setPSCssTemplName(pSCssTempl.getPSCssTemplName());
                }
            } else {
                pSSysCss.setPSCssTemplName(null);
            }
        }
    }

    protected void onFillEntityFullInfo_PSModule(PSSysCss pSSysCss, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSysCssCat(PSSysCss pSSysCss, boolean bl) throws Exception {
    }

    protected void onFillEntityFullInfo_PSSystem(PSSysCss pSSysCss, boolean bl) throws Exception {
        if (pSSysCss.isPSSystemIdDirty()) {
            if (pSSysCss.getPSSystemId() != null) {
                if (pSSysCss.getPSSystemId() == null || pSSysCss.getPSSystemName() == null) {
                    PSSystem pSSystem = pSSysCss.getPSSystem();
                    pSSysCss.setPSSystemName(pSSystem.getPSSystemName());
                }
            } else {
                pSSysCss.setPSSystemName(null);
            }
        }
    }

    protected void onWriteBackParent(PSSysCss pSSysCss, boolean bl) throws Exception {
        super.onWriteBackParent(pSSysCss, bl);
    }

    public ArrayList<PSSysCss> selectByPSCssTempl(PSCssTemplBase pSCssTemplBase) throws Exception {
        return this.selectByPSCssTempl(pSCssTemplBase, "", -1);
    }

    public ArrayList<PSSysCss> selectByPSCssTempl(PSCssTemplBase pSCssTemplBase, String string) throws Exception {
        return this.selectByPSCssTempl(pSCssTemplBase, string, -1);
    }

    public ArrayList<PSSysCss> selectByPSCssTempl(PSCssTemplBase pSCssTemplBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSCSSTEMPLID", (Object)pSCssTemplBase.getPSCssTemplId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSCssTemplCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSCssTemplCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCss> selectByPSModule(PSModuleBase pSModuleBase) throws Exception {
        return this.selectByPSModule(pSModuleBase, "", -1);
    }

    public ArrayList<PSSysCss> selectByPSModule(PSModuleBase pSModuleBase, String string) throws Exception {
        return this.selectByPSModule(pSModuleBase, string, -1);
    }

    public ArrayList<PSSysCss> selectByPSModule(PSModuleBase pSModuleBase, String string, int n) throws Exception {
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

    public ArrayList<PSSysCss> selectByPSSysCssCat(PSSysCssCatBase pSSysCssCatBase) throws Exception {
        return this.selectByPSSysCssCat(pSSysCssCatBase, "", -1);
    }

    public ArrayList<PSSysCss> selectByPSSysCssCat(PSSysCssCatBase pSSysCssCatBase, String string) throws Exception {
        return this.selectByPSSysCssCat(pSSysCssCatBase, string, -1);
    }

    public ArrayList<PSSysCss> selectByPSSysCssCat(PSSysCssCatBase pSSysCssCatBase, String string, int n) throws Exception {
        SelectCond selectCond = new SelectCond();
        selectCond.setConditon("PSSYSCSSCATID", (Object)pSSysCssCatBase.getPSSysCssCatId());
        if (!StringHelper.isNullOrEmpty((String)string)) {
            selectCond.setOrderInfo(string);
        }
        if (n > 0) {
            selectCond.setMaxRowCount(n);
        }
        this.onFillSelectByPSSysCssCatCond(selectCond);
        return this.select((ISelectCond)selectCond);
    }

    protected void onFillSelectByPSSysCssCatCond(SelectCond selectCond) throws Exception {
    }

    public ArrayList<PSSysCss> selectByPSSystem(PSSystemBase pSSystemBase) throws Exception {
        return this.selectByPSSystem(pSSystemBase, "", -1);
    }

    public ArrayList<PSSysCss> selectByPSSystem(PSSystemBase pSSystemBase, String string) throws Exception {
        return this.selectByPSSystem(pSSystemBase, string, -1);
    }

    public ArrayList<PSSysCss> selectByPSSystem(PSSystemBase pSSystemBase, String string, int n) throws Exception {
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

    public void testRemoveByPSCssTempl(PSCssTempl pSCssTempl) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSCssTempl(pSCssTempl, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSCSSTEMPL");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSCssTempl);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCSS_PSCSSTEMPL_PSCSSTEMPLID", "", iDataEntityModel.getName(), "PSSYSCSS", iDataEntityModel.getDataInfo(pSCssTempl), arrayList.get(0)));
        }
    }

    public void resetPSCssTempl(PSCssTempl pSCssTempl) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSCssTempl(pSCssTempl);
        for (PSSysCss pSSysCss : arrayList) {
            PSSysCss pSSysCss2 = (PSSysCss)this.getDEModel().createEntity();
            pSSysCss2.setPSSysCssId(pSSysCss.getPSSysCssId());
            pSSysCss2.setPSCssTemplId(null);
            this.update(pSSysCss2);
        }
    }

    public void removeByPSCssTempl(PSCssTempl pSCssTempl) throws Exception {
        final PSCssTempl pSCssTempl2 = pSCssTempl;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCssServiceBase.this.onBeforeRemoveByPSCssTempl(pSCssTempl2);
                PSSysCssServiceBase.this.internalRemoveByPSCssTempl(pSCssTempl2);
                PSSysCssServiceBase.this.onAfterRemoveByPSCssTempl(pSCssTempl2);
            }
        });
    }

    protected void onBeforeRemoveByPSCssTempl(PSCssTempl pSCssTempl) throws Exception {
    }

    protected void internalRemoveByPSCssTempl(PSCssTempl pSCssTempl) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSCssTempl(pSCssTempl);
        this.onBeforeRemoveByPSCssTempl(pSCssTempl, arrayList);
        for (PSSysCss pSSysCss : arrayList) {
            this.remove(pSSysCss);
        }
        this.onAfterRemoveByPSCssTempl(pSCssTempl, arrayList);
    }

    protected void onAfterRemoveByPSCssTempl(PSCssTempl pSCssTempl) throws Exception {
    }

    protected void onBeforeRemoveByPSCssTempl(PSCssTempl pSCssTempl, ArrayList<PSSysCss> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSCssTempl(PSCssTempl pSCssTempl, ArrayList<PSSysCss> arrayList) throws Exception {
    }

    public void testRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSModule(pSModule, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSMODULE");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSModule);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCSS_PSMODULE_PSMODULEID", "", iDataEntityModel.getName(), "PSSYSCSS", iDataEntityModel.getDataInfo(pSModule), arrayList.get(0)));
        }
    }

    public void resetPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSModule(pSModule);
        for (PSSysCss pSSysCss : arrayList) {
            PSSysCss pSSysCss2 = (PSSysCss)this.getDEModel().createEntity();
            pSSysCss2.setPSSysCssId(pSSysCss.getPSSysCssId());
            pSSysCss2.setPSModuleId(null);
            this.update(pSSysCss2);
        }
    }

    public void removeByPSModule(PSModule pSModule) throws Exception {
        final PSModule pSModule2 = pSModule;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCssServiceBase.this.onBeforeRemoveByPSModule(pSModule2);
                PSSysCssServiceBase.this.internalRemoveByPSModule(pSModule2);
                PSSysCssServiceBase.this.onAfterRemoveByPSModule(pSModule2);
            }
        });
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void internalRemoveByPSModule(PSModule pSModule) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSModule(pSModule);
        this.onBeforeRemoveByPSModule(pSModule, arrayList);
        for (PSSysCss pSSysCss : arrayList) {
            this.remove(pSSysCss);
        }
        this.onAfterRemoveByPSModule(pSModule, arrayList);
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule) throws Exception {
    }

    protected void onBeforeRemoveByPSModule(PSModule pSModule, ArrayList<PSSysCss> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSModule(PSModule pSModule, ArrayList<PSSysCss> arrayList) throws Exception {
    }

    public void testRemoveByPSSysCssCat(PSSysCssCat pSSysCssCat) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSSysCssCat(pSSysCssCat, null, -1);
        if (arrayList.size() > 0) {
            IDataEntityModel iDataEntityModel = this.getDEModel().getSystemRuntime().getDataEntityModel("PSSYSCSSCAT");
            iDataEntityModel.getService(this.getSessionFactory()).getCache(pSSysCssCat);
            throw new Exception(this.getRemoveRejectMsg("DER1N_PSSYSCSS_PSSYSCSSCAT_PSSYSCSSCATID", "", iDataEntityModel.getName(), "PSSYSCSS", iDataEntityModel.getDataInfo(pSSysCssCat), arrayList.get(0)));
        }
    }

    public void resetPSSysCssCat(PSSysCssCat pSSysCssCat) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSSysCssCat(pSSysCssCat);
        for (PSSysCss pSSysCss : arrayList) {
            PSSysCss pSSysCss2 = (PSSysCss)this.getDEModel().createEntity();
            pSSysCss2.setPSSysCssId(pSSysCss.getPSSysCssId());
            pSSysCss2.setPSSysCssCatId(null);
            this.update(pSSysCss2);
        }
    }

    public void removeByPSSysCssCat(PSSysCssCat pSSysCssCat) throws Exception {
        final PSSysCssCat pSSysCssCat2 = pSSysCssCat;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCssServiceBase.this.onBeforeRemoveByPSSysCssCat(pSSysCssCat2);
                PSSysCssServiceBase.this.internalRemoveByPSSysCssCat(pSSysCssCat2);
                PSSysCssServiceBase.this.onAfterRemoveByPSSysCssCat(pSSysCssCat2);
            }
        });
    }

    protected void onBeforeRemoveByPSSysCssCat(PSSysCssCat pSSysCssCat) throws Exception {
    }

    protected void internalRemoveByPSSysCssCat(PSSysCssCat pSSysCssCat) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSSysCssCat(pSSysCssCat);
        this.onBeforeRemoveByPSSysCssCat(pSSysCssCat, arrayList);
        for (PSSysCss pSSysCss : arrayList) {
            this.remove(pSSysCss);
        }
        this.onAfterRemoveByPSSysCssCat(pSSysCssCat, arrayList);
    }

    protected void onAfterRemoveByPSSysCssCat(PSSysCssCat pSSysCssCat) throws Exception {
    }

    protected void onBeforeRemoveByPSSysCssCat(PSSysCssCat pSSysCssCat, ArrayList<PSSysCss> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSysCssCat(PSSysCssCat pSSysCssCat, ArrayList<PSSysCss> arrayList) throws Exception {
    }

    public void testRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    public void resetPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSSystem(pSSystem);
        for (PSSysCss pSSysCss : arrayList) {
            PSSysCss pSSysCss2 = (PSSysCss)this.getDEModel().createEntity();
            pSSysCss2.setPSSysCssId(pSSysCss.getPSSysCssId());
            pSSysCss2.setPSSystemId(null);
            this.update(pSSysCss2);
        }
    }

    public void removeByPSSystem(PSSystem pSSystem) throws Exception {
        final PSSystem pSSystem2 = pSSystem;
        this.doServiceWork(new IServiceWork(){

            public void execute(ITransaction iTransaction) throws Exception {
                PSSysCssServiceBase.this.onBeforeRemoveByPSSystem(pSSystem2);
                PSSysCssServiceBase.this.internalRemoveByPSSystem(pSSystem2);
                PSSysCssServiceBase.this.onAfterRemoveByPSSystem(pSSystem2);
            }
        });
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void internalRemoveByPSSystem(PSSystem pSSystem) throws Exception {
        ArrayList<PSSysCss> arrayList = this.selectByPSSystem(pSSystem);
        this.onBeforeRemoveByPSSystem(pSSystem, arrayList);
        for (PSSysCss pSSysCss : arrayList) {
            this.remove(pSSysCss);
        }
        this.onAfterRemoveByPSSystem(pSSystem, arrayList);
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem) throws Exception {
    }

    protected void onBeforeRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysCss> arrayList) throws Exception {
    }

    protected void onAfterRemoveByPSSystem(PSSystem pSSystem, ArrayList<PSSysCss> arrayList) throws Exception {
    }

    @Override
    protected void onBeforeRemove(PSSysCss pSSysCss) throws Exception {
        PSCoreSysServiceBase pSCoreSysServiceBase = (PSAppMenuItemService)ServiceGlobal.getService(PSAppMenuItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSAppMenuService)ServiceGlobal.getService(PSAppMenuService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppMenuServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSAppPanelViewService)ServiceGlobal.getService(PSAppPanelViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPanelViewServiceBase)pSCoreSysServiceBase).testRemoveByNavBarPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSAppPVPartService)ServiceGlobal.getService(PSAppPVPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppPVPartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSAppTitleBarService)ServiceGlobal.getService(PSAppTitleBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppTitleBarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSAppViewService)ServiceGlobal.getService(PSAppViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSAppViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSCodeItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEChartService)ServiceGlobal.getService(PSDEChartService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEChartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByItemPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDataViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEDRDetailService)ServiceGlobal.getService(PSDEDRDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEDRItemService)ServiceGlobal.getService(PSDEDRItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEDRItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByCtrlPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByLabelPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByNavBarPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEFormServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByCellPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEGridColService)ServiceGlobal.getService(PSDEGridColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridColServiceBase)pSCoreSysServiceBase).testRemoveByHeaderPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByItemPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEGridService)ServiceGlobal.getService(PSDEGridService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEGridServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByItemPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEListServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEMainStateService)ServiceGlobal.getService(PSDEMainStateService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEMainStateServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDETBItemService)ServiceGlobal.getService(PSDETBItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETBItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEToolbarService)ServiceGlobal.getService(PSDEToolbarService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEToolbarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).testRemoveByCellPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDETreeColService)ServiceGlobal.getService(PSDETreeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeColServiceBase)pSCoreSysServiceBase).testRemoveByHeaderPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDETreeNodeColService)ServiceGlobal.getService(PSDETreeNodeColService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeColServiceBase)pSCoreSysServiceBase).testRemoveByCellPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeNodeServiceBase)pSCoreSysServiceBase).testRemoveByShapePSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSDETreeViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByAfterPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByBeforePSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEUAGroupDetailService)ServiceGlobal.getService(PSDEUAGroupDetailService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEUAGroupDetailServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewBaseServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEViewCtrlService)ServiceGlobal.getService(PSDEViewCtrlService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEViewCtrlServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEWizardStepService)ServiceGlobal.getService(PSDEWizardStepService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardStepServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSDEWizardService)ServiceGlobal.getService(PSDEWizardService.class, (SessionFactory)this.getSessionFactory());
        ((PSDEWizardServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysAppServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysCalendarItemService)ServiceGlobal.getService(PSSysCalendarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByGroupPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysCalendarService)ServiceGlobal.getService(PSSysCalendarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysCalendarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardServiceBase)pSCoreSysServiceBase).testRemoveByNavBarPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDashboardServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysDBPartServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysEditorStyleService)ServiceGlobal.getService(PSSysEditorStyleService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysEditorStyleServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysMapItemService)ServiceGlobal.getService(PSSysMapItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapItemServiceBase)pSCoreSysServiceBase).testRemoveByShapePSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysMapViewService)ServiceGlobal.getService(PSSysMapViewService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysMapViewServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysPFPITemplService)ServiceGlobal.getService(PSSysPFPITemplService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPFPITemplServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysPortletCatService)ServiceGlobal.getService(PSSysPortletCatService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletCatServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysPortletServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).testRemoveByCtrlPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).testRemoveByLabelPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysSearchBarItemService)ServiceGlobal.getService(PSSysSearchBarItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysSearchBarService)ServiceGlobal.getService(PSSysSearchBarService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysSearchBarServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByCtrlPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByLabelPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelItemServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelServiceBase)pSCoreSysServiceBase).testRemoveByNavBarPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
        ((PSSysViewPanelServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSThresholdService)ServiceGlobal.getService(PSThresholdService.class, (SessionFactory)this.getSessionFactory());
        ((PSThresholdServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgGroupServiceBase)pSCoreSysServiceBase).testRemoveByBodyMsgPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgGroupServiceBase)pSCoreSysServiceBase).testRemoveByBottomMsgPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgGroupServiceBase)pSCoreSysServiceBase).testRemoveByTopMsgPSSysCss(pSSysCss);
        pSCoreSysServiceBase = (PSViewMsgService)ServiceGlobal.getService(PSViewMsgService.class, (SessionFactory)this.getSessionFactory());
        ((PSViewMsgServiceBase)pSCoreSysServiceBase).testRemoveByPSSysCss(pSSysCss);
        super.onBeforeRemove(pSSysCss);
    }

    protected void replaceParentInfo(PSSysCss pSSysCss, CloneSession cloneSession) throws Exception {
        IEntity iEntity;
        super.replaceParentInfo(pSSysCss, cloneSession);
        if (pSSysCss.getPSCssTemplId() != null && (iEntity = cloneSession.getEntity("PSCSSTEMPL", (Object)pSSysCss.getPSCssTemplId())) != null) {
            this.onFillParentInfo_PSCssTempl(pSSysCss, (PSCssTempl)iEntity);
        }
        if (pSSysCss.getPSModuleId() != null && (iEntity = cloneSession.getEntity("PSMODULE", (Object)pSSysCss.getPSModuleId())) != null) {
            this.onFillParentInfo_PSModule(pSSysCss, (PSModule)iEntity);
        }
        if (pSSysCss.getPSSysCssCatId() != null && (iEntity = cloneSession.getEntity("PSSYSCSSCAT", (Object)pSSysCss.getPSSysCssCatId())) != null) {
            this.onFillParentInfo_PSSysCssCat(pSSysCss, (PSSysCssCat)iEntity);
        }
        if (pSSysCss.getPSSystemId() != null && (iEntity = cloneSession.getEntity("PSSYSTEM", (Object)pSSysCss.getPSSystemId())) != null) {
            this.onFillParentInfo_PSSystem(pSSysCss, (PSSystem)iEntity);
        }
    }

    protected void onRemoveEntityUncopyValues(PSSysCss pSSysCss, boolean bl) throws Exception {
        super.onRemoveEntityUncopyValues(pSSysCss, bl);
    }

    protected void onCheckEntity(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3, EntityError entityError) throws Exception {
        EntityFieldError entityFieldError = null;
        entityFieldError = this.onCheckField_BKColor(bl, pSSysCss, bl2, bl3);
        if (entityFieldError != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Border(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BorderColor(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_BorderStyle(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CodeName(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSSName(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CSSStyle(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_CssStyle2(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FontColor(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FontFamily(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FontSize(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FontStyle(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_FullCssName(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_HAlign(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_LockFlag(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Margin(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Memo(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerId(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerTag(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_OwnerType(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_Padding(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCssTemplId(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSCssTemplName(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSModuleId(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssCatId(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssId(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSysCssName(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemId(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PSSystemName(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_PublicFlag(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_SampleContent(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserCat(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag2(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag3(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_UserTag4(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        if ((entityFieldError = this.onCheckField_VAlign(bl, pSSysCss, bl2, bl3)) != null) {
            entityError.register(entityFieldError);
        }
        super.onCheckEntity(bl, pSSysCss, bl2, bl3, entityError);
    }

    protected EntityFieldError onCheckField_BKColor(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isBKColorDirty() : !pSSysCss.isBKColorDirty()) {
            return null;
        }
        String string = pSSysCss.getBKColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BKColor_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BKCOLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_Border(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isBorderDirty() : !pSSysCss.isBorderDirty()) {
            return null;
        }
        String string = pSSysCss.getBorder();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Border_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BORDER");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BorderColor(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isBorderColorDirty() : !pSSysCss.isBorderColorDirty()) {
            return null;
        }
        String string = pSSysCss.getBorderColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BorderColor_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("BORDERCOLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_BorderStyle(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isBorderStyleDirty() : !pSSysCss.isBorderStyleDirty()) {
            return null;
        }
        String string = pSSysCss.getBorderStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_BorderStyle_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_CodeName(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isCodeNameDirty() : !pSSysCss.isCodeNameDirty()) {
            return null;
        }
        String string = pSSysCss.getCodeName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CodeName_Default(pSSysCss, bl2, bl3);
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
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysCssDEModel(), "CODENAME", string3, pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_CSSName(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isCSSNameDirty() && !bl2 : !pSSysCss.isCSSNameDirty()) {
            return null;
        }
        String string = pSSysCss.getCSSName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSSName_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CSSStyle(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isCSSStyleDirty() : !pSSysCss.isCSSStyleDirty()) {
            return null;
        }
        String string = pSSysCss.getCSSStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CSSStyle_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_CssStyle2(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isCssStyle2Dirty() : !pSSysCss.isCssStyle2Dirty()) {
            return null;
        }
        String string = pSSysCss.getCssStyle2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_CssStyle2_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("CSSSTYLE2");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FontColor(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isFontColorDirty() : !pSSysCss.isFontColorDirty()) {
            return null;
        }
        String string = pSSysCss.getFontColor();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FontColor_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FONTCOLOR");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FontFamily(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isFontFamilyDirty() : !pSSysCss.isFontFamilyDirty()) {
            return null;
        }
        String string = pSSysCss.getFontFamily();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FontFamily_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FONTFAMILY");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FontSize(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isFontSizeDirty() : !pSSysCss.isFontSizeDirty()) {
            return null;
        }
        Integer n = pSSysCss.getFontSize();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FontSize_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FONTSIZE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FontStyle(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isFontStyleDirty() : !pSSysCss.isFontStyleDirty()) {
            return null;
        }
        Integer n = pSSysCss.getFontStyle();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_FontStyle_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FONTSTYLE");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_FullCssName(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isFullCssNameDirty() : !pSSysCss.isFullCssNameDirty()) {
            return null;
        }
        String string = pSSysCss.getFullCssName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_FullCssName_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("FULLCSSNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_HAlign(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isHAlignDirty() : !pSSysCss.isHAlignDirty()) {
            return null;
        }
        String string = pSSysCss.getHAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_HAlign_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_LockFlag(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isLockFlagDirty() : !pSSysCss.isLockFlagDirty()) {
            return null;
        }
        Integer n = pSSysCss.getLockFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_LockFlag_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_Margin(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isMarginDirty() : !pSSysCss.isMarginDirty()) {
            return null;
        }
        String string = pSSysCss.getMargin();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Margin_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_Memo(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isMemoDirty() : !pSSysCss.isMemoDirty()) {
            return null;
        }
        String string = pSSysCss.getMemo();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Memo_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_OwnerId(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isOwnerIdDirty() : !pSSysCss.isOwnerIdDirty()) {
            return null;
        }
        String string = pSSysCss.getOwnerId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerId_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_OwnerTag(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isOwnerTagDirty() : !pSSysCss.isOwnerTagDirty()) {
            return null;
        }
        String string = pSSysCss.getOwnerTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerTag_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_OwnerType(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isOwnerTypeDirty() : !pSSysCss.isOwnerTypeDirty()) {
            return null;
        }
        String string = pSSysCss.getOwnerType();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_OwnerType_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_Padding(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPaddingDirty() : !pSSysCss.isPaddingDirty()) {
            return null;
        }
        String string = pSSysCss.getPadding();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_Padding_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSCssTemplId(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPSCssTemplIdDirty() : !pSSysCss.isPSCssTemplIdDirty()) {
            return null;
        }
        String string = pSSysCss.getPSCssTemplId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCssTemplId_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCSSTEMPLID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSCssTemplName(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPSCssTemplNameDirty() : !pSSysCss.isPSCssTemplNameDirty()) {
            return null;
        }
        String string = pSSysCss.getPSCssTemplName();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSCssTemplName_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSCSSTEMPLNAME");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSModuleId(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPSModuleIdDirty() : !pSSysCss.isPSModuleIdDirty()) {
            return null;
        }
        String string = pSSysCss.getPSModuleId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSModuleId_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssCatId(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPSSysCssCatIdDirty() : !pSSysCss.isPSSysCssCatIdDirty()) {
            return null;
        }
        String string = pSSysCss.getPSSysCssCatId();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssCatId_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSCATID");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSysCssId(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPSSysCssIdDirty() && !bl2 : !pSSysCss.isPSSysCssIdDirty()) {
            return null;
        }
        String string = pSSysCss.getPSSysCssId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssId_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSysCssName(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPSSysCssNameDirty() && !bl2 : !pSSysCss.isPSSysCssNameDirty()) {
            return null;
        }
        String string = pSSysCss.getPSSysCssName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSysCssName_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSCSSNAME");
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
                string3 = string3 + ";";
                string3 = string3 + "PSSYSTEMID";
                String string4 = this.checkFieldDupRule(this.getPSSysCssDEModel(), "PSSYSCSSNAME", string3, pSSysCss, bl2, bl3);
                if (!StringHelper.isNullOrEmpty((String)string4)) {
                    EntityFieldError entityFieldError = new EntityFieldError();
                    entityFieldError.setFieldName("PSSYSCSSNAME");
                    entityFieldError.setErrorType(3);
                    entityFieldError.setErrorInfo(string4);
                    return entityFieldError;
                }
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_PSSystemId(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPSSystemIdDirty() && !bl2 : !pSSysCss.isPSSystemIdDirty()) {
            return null;
        }
        String string = pSSysCss.getPSSystemId();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMID");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemId_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_PSSystemName(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPSSystemNameDirty() && !bl2 : !pSSysCss.isPSSystemNameDirty()) {
            return null;
        }
        String string = pSSysCss.getPSSystemName();
        if (bl) {
            if (bl2 && StringHelper.isNullOrEmpty((String)string)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("PSSYSTEMNAME");
                entityFieldError.setErrorType(1);
                return entityFieldError;
            }
            String string2 = null;
            string2 = this.onTestValueRule_PSSystemName_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_PublicFlag(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isPublicFlagDirty() : !pSSysCss.isPublicFlagDirty()) {
            return null;
        }
        Integer n = pSSysCss.getPublicFlag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string = null;
            string = this.onTestValueRule_PublicFlag_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_SampleContent(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isSampleContentDirty() : !pSSysCss.isSampleContentDirty()) {
            return null;
        }
        String string = pSSysCss.getSampleContent();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_SampleContent_Default(pSSysCss, bl2, bl3);
            if (!StringHelper.isNullOrEmpty((String)string2)) {
                EntityFieldError entityFieldError = new EntityFieldError();
                entityFieldError.setFieldName("SAMPLECONTENT");
                entityFieldError.setErrorType(3);
                entityFieldError.setErrorInfo(string2);
                return entityFieldError;
            }
        }
        return null;
    }

    protected EntityFieldError onCheckField_UserCat(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isUserCatDirty() : !pSSysCss.isUserCatDirty()) {
            return null;
        }
        String string = pSSysCss.getUserCat();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserCat_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isUserTagDirty() : !pSSysCss.isUserTagDirty()) {
            return null;
        }
        String string = pSSysCss.getUserTag();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag2(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isUserTag2Dirty() : !pSSysCss.isUserTag2Dirty()) {
            return null;
        }
        String string = pSSysCss.getUserTag2();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag2_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag3(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isUserTag3Dirty() : !pSSysCss.isUserTag3Dirty()) {
            return null;
        }
        String string = pSSysCss.getUserTag3();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag3_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_UserTag4(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isUserTag4Dirty() : !pSSysCss.isUserTag4Dirty()) {
            return null;
        }
        String string = pSSysCss.getUserTag4();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_UserTag4_Default(pSSysCss, bl2, bl3);
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

    protected EntityFieldError onCheckField_VAlign(boolean bl, PSSysCss pSSysCss, boolean bl2, boolean bl3) throws Exception {
        if (bl ? !pSSysCss.isVAlignDirty() : !pSSysCss.isVAlignDirty()) {
            return null;
        }
        String string = pSSysCss.getVAlign();
        if (bl) {
            if (bl2) {
                // empty if block
            }
            String string2 = null;
            string2 = this.onTestValueRule_VAlign_Default(pSSysCss, bl2, bl3);
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

    protected void onSyncEntity(PSSysCss pSSysCss, boolean bl) throws Exception {
        super.onSyncEntity(pSSysCss, bl);
    }

    protected void onSyncIndexEntities(PSSysCss pSSysCss, boolean bl) throws Exception {
        super.onSyncIndexEntities(pSSysCss, bl);
    }

    public Object getDataContextValue(PSSysCss pSSysCss, String string, IDataContextParam iDataContextParam) throws Exception {
        Object object = null;
        if (iDataContextParam != null) {
            // empty if block
        }
        if ((object = super.getDataContextValue(pSSysCss, string, iDataContextParam)) != null) {
            return object;
        }
        PSSystem pSSystem = pSSysCss.getPSSystem();
        if (pSSystem != null && pSSystem.contains(string)) {
            return pSSystem.get(string);
        }
        return null;
    }

    protected void onExportMajorModel(PSSysCss pSSysCss, ArrayList<JSONObject> arrayList, int n) throws Exception {
        super.onExportMajorModel(pSSysCss, arrayList, n);
    }

    protected String onTestValueRule(String string, String string2, IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        if (StringHelper.compare((String)string, (String)"BKCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BKColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BORDER", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Border_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BORDERCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BorderColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"BORDERSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_BorderStyle_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"CSSCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CssCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSSName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CSSStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"CSSSTYLE2", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_CssStyle2_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FONTCOLOR", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FontColor_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FONTFAMILY", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FontFamily_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FONTSIZE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FontSize_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FONTSTYLE", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FontStyle_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"FULLCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_FullCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"HALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_HAlign_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"LOCKFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_LockFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MARGIN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Margin_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"MEMO", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Memo_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"PADDING", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_Padding_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCSSTEMPLID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCssTemplId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSCSSTEMPLNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSCssTemplName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULEID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSMODULENAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSModuleName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSCATID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssCatId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSCATNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssCatName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSCSSNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSysCssName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMID", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemId_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PSSYSTEMNAME", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PSSystemName_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"PUBLICFLAG", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_PublicFlag_Default(iEntity, bl, bl2);
        }
        if (StringHelper.compare((String)string, (String)"SAMPLECONTENT", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_SampleContent_Default(iEntity, bl, bl2);
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
        if (StringHelper.compare((String)string, (String)"VALIGN", (boolean)true) == 0 && StringHelper.compare((String)string2, (String)DATASET_DEFAULT, (boolean)true) == 0) {
            return this.onTestValueRule_VAlign_Default(iEntity, bl, bl2);
        }
        return super.onTestValueRule(string, string2, iEntity, bl, bl2);
    }

    protected String onTestValueRule_BKColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BKCOLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_Border_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BORDER", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BorderColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BORDERCOLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_BorderStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("BORDERSTYLE", iEntity, bl2, null, false, 20, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[20]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_CssCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSCATNAME", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSSName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSNAME", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CSSStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSSTYLE", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_CssStyle2_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("CSSSTYLE2", iEntity, bl2, null, false, 4000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[4000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FontColor_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FONTCOLOR", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FontFamily_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FONTFAMILY", iEntity, bl2, null, false, 1000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1000]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_FontSize_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FontStyle_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_FullCssName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("FULLCSSNAME", iEntity, bl2, null, false, 500, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[500]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
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

    protected String onTestValueRule_LockFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_Margin_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("MARGIN", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
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

    protected String onTestValueRule_Padding_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PADDING", iEntity, bl2, null, false, 30, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[30]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCssTemplId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCSSTEMPLID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSCssTemplName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSCSSTEMPLNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PSSysCssCatId_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSCATID", iEntity, bl2, null, false, 100, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[100]";
        }
        catch (Exception exception) {
            return exception.getMessage();
        }
    }

    protected String onTestValueRule_PSSysCssCatName_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("PSSYSCSSCATNAME", iEntity, bl2, null, false, 200, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[200]", false)) {
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

    protected String onTestValueRule_PublicFlag_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        return null;
    }

    protected String onTestValueRule_SampleContent_Default(IEntity iEntity, boolean bl, boolean bl2) throws Exception {
        try {
            if (this.checkFieldStringLengthRule("SAMPLECONTENT", iEntity, bl2, null, false, 0x100000, true, "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]", false)) {
                return null;
            }
            return "\u5185\u5bb9\u957f\u5ea6\u5fc5\u987b\u5c0f\u4e8e\u7b49\u4e8e[1048576]";
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

    @Override
    protected boolean isPrepareLastForUpdate() {
        return true;
    }

    protected boolean onMergeChild(String string, String string2, PSSysCss pSSysCss) throws Exception {
        boolean bl = false;
        if (super.onMergeChild(string, string2, pSSysCss)) {
            bl = true;
        }
        return bl;
    }

    protected void onUpdateParent(PSSysCss pSSysCss) throws Exception {
        super.onUpdateParent(pSSysCss);
    }

    @Override
    protected void exportCurXmlModel(PSSysCss pSSysCss, XmlNode xmlNode, boolean bl) throws Exception {
        xmlNode.setNodeName("PSSYSCSS");
        if (!bl) {
            pSSysCss.setPSCssTemplId(null);
            pSSysCss.setPSCssTemplName(null);
            super.exportCurXmlModel(pSSysCss, xmlNode, bl);
        }
    }

    @Override
    public ObjectNode fillModelV2(ObjectNode objectNode, PSSysCss pSSysCss, String string) throws Exception {
        objectNode = super.fillModelV2(objectNode, pSSysCss, string);
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
            return "DER1N_PSSYSCSS_PSMODULE_PSMODULEID";
        }
        string = DataObject.getStringValue((IDataObject)iEntity, (String)"PSSYSTEMID", null);
        if (!StringHelper.isNullOrEmpty((String)string)) {
            return "DER1N_PSSYSCSS_PSSYSTEM_PSSYSTEMID";
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
    public String getModelV2Tag(PSSysCss pSSysCss) {
        if (!StringHelper.isNullOrEmpty((String)pSSysCss.getCodeName())) {
            return pSSysCss.getCodeName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss.getPSSysCssName())) {
            return pSSysCss.getPSSysCssName();
        }
        if (!StringHelper.isNullOrEmpty((String)pSSysCss.getCodeName())) {
            return pSSysCss.getCodeName();
        }
        return super.getModelV2Tag(pSSysCss);
    }

    @Override
    public boolean setModelV2Tag(PSSysCss pSSysCss, String string) {
        pSSysCss.setCodeName(string);
        return true;
    }

    @Override
    public Map<String, String> getListDRDataFolderFields(Map<String, String> map, PSMOSFile pSMOSFile, IPSMOSFileFilter iPSMOSFileFilter) throws Exception {
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put("CODENAME", "");
        map.put("PSSYSCSSNAME", "");
        map.put("CODENAME", "");
        map.put("PSMODULEID", "");
        map.put("PSSYSTEMID", "");
        return super.getListDRDataFolderFields(map, pSMOSFile, iPSMOSFileFilter);
    }

    @Override
    public boolean getModelV2Entity(PSSysCss pSSysCss, String string) throws Exception {
        SimpleEntity simpleEntity = new SimpleEntity();
        pSSysCss.copyTo((IDataObject)simpleEntity, false);
        simpleEntity.copyTo((IDataObject)pSSysCss, true);
        pSSysCss.set("CODENAME", string);
        if (this.select(pSSysCss, true)) {
            return true;
        }
        simpleEntity.copyTo((IDataObject)pSSysCss, true);
        return super.getModelV2Entity(pSSysCss, string);
    }

    @Override
    protected boolean testCompileCurModelV2(PSSysCss pSSysCss, ObjectNode objectNode, String string, String string2, int n) throws Exception {
        if (n == 1) {
            return true;
        }
        return super.testCompileCurModelV2(pSSysCss, objectNode, string, string2, n);
    }

    @Override
    protected Map<String, String> getGetDraftDefaultValueMap(PSSysCss pSSysCss, boolean bl) {
        return defaultValueMap;
    }

    static {
        defaultValueMap.put("CODENAME", "Css");
        defaultValueMap.put("PSSYSCSSNAME", "\u6837\u5f0f\u8868");
    }
}

